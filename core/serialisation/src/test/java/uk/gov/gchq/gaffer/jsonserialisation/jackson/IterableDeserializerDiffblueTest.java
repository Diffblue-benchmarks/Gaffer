/*
 * Copyright 2025 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.jsonserialisation.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.util.List;
import org.junit.jupiter.api.Test;

class IterableDeserializerDiffblueTest {
  /**
   * Method under test: {@link IterableDeserializer#getModule()}
   */
  @Test
  void testGetModule() {
    // Arrange and Act
    SimpleModule actualModule = IterableDeserializer.getModule();

    // Assert
    Iterable<? extends Module> dependencies = actualModule.getDependencies();
    assertTrue(dependencies instanceof List);
    Version versionResult = actualModule.version();
    assertEquals("", versionResult.getArtifactId());
    assertEquals("", versionResult.getGroupId());
    assertEquals("//0.0.0", versionResult.toFullString());
    assertEquals(0, versionResult.getMajorVersion());
    assertEquals(0, versionResult.getMinorVersion());
    assertEquals(0, versionResult.getPatchLevel());
    assertFalse(versionResult.isSnapshot());
    assertTrue(versionResult.isUknownVersion());
    assertTrue(versionResult.isUnknownVersion());
    assertTrue(((List<? extends Module>) dependencies).isEmpty());
  }

  /**
   * Method under test:
   * {@link IterableDeserializer#createContextual(DeserializationContext, BeanProperty)}
   */
  @Test
  void testCreateContextual() throws JsonMappingException {
    // Arrange
    IterableDeserializer iterableDeserializer = new IterableDeserializer();
    DeserializationContext deserializationContext = mock(DeserializationContext.class);
    when(deserializationContext.getContextualType()).thenReturn(new PlaceholderForType(1));

    // Act
    JsonDeserializer<?> actualCreateContextualResult = iterableDeserializer.createContextual(deserializationContext,
        new BeanProperty.Bogus());

    // Assert
    verify(deserializationContext).getContextualType();
    assertTrue(actualCreateContextualResult instanceof IterableDeserializer);
    assertNull(actualCreateContextualResult.getDelegatee());
    assertNull(actualCreateContextualResult.getObjectIdReader());
    assertNull(actualCreateContextualResult.getNullValue());
    assertNull(actualCreateContextualResult.getEmptyValue());
    assertNull(actualCreateContextualResult.getKnownPropertyNames());
    assertEquals(AccessPattern.CONSTANT, actualCreateContextualResult.getNullAccessPattern());
    assertEquals(AccessPattern.DYNAMIC, actualCreateContextualResult.getEmptyAccessPattern());
    assertFalse(actualCreateContextualResult.isCachable());
  }

  /**
   * Method under test:
   * {@link IterableDeserializer#createContextual(DeserializationContext, BeanProperty)}
   */
  @Test
  void testCreateContextual2() throws JsonMappingException {
    // Arrange
    IterableDeserializer iterableDeserializer = new IterableDeserializer();
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.containedType(anyInt())).thenReturn(new PlaceholderForType(1));
    DeserializationContext deserializationContext = mock(DeserializationContext.class);
    when(deserializationContext.getContextualType()).thenReturn(collectionLikeType);

    // Act
    JsonDeserializer<?> actualCreateContextualResult = iterableDeserializer.createContextual(deserializationContext,
        new BeanProperty.Bogus());

    // Assert
    verify(deserializationContext).getContextualType();
    verify(collectionLikeType).containedType(eq(0));
    assertTrue(actualCreateContextualResult instanceof IterableDeserializer);
    assertNull(actualCreateContextualResult.getDelegatee());
    assertNull(actualCreateContextualResult.getObjectIdReader());
    assertNull(actualCreateContextualResult.getNullValue());
    assertNull(actualCreateContextualResult.getEmptyValue());
    assertNull(actualCreateContextualResult.getKnownPropertyNames());
    assertEquals(AccessPattern.CONSTANT, actualCreateContextualResult.getNullAccessPattern());
    assertEquals(AccessPattern.DYNAMIC, actualCreateContextualResult.getEmptyAccessPattern());
    assertFalse(actualCreateContextualResult.isCachable());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link IterableDeserializer}
   */
  @Test
  void testNewIterableDeserializer() {
    // Arrange and Act
    IterableDeserializer actualIterableDeserializer = new IterableDeserializer();

    // Assert
    assertNull(actualIterableDeserializer.getDelegatee());
    assertNull(actualIterableDeserializer.getObjectIdReader());
    assertNull(actualIterableDeserializer.getNullValue());
    assertNull(actualIterableDeserializer.getEmptyValue());
    assertNull(actualIterableDeserializer.getKnownPropertyNames());
    assertEquals(AccessPattern.CONSTANT, actualIterableDeserializer.getNullAccessPattern());
    assertEquals(AccessPattern.DYNAMIC, actualIterableDeserializer.getEmptyAccessPattern());
    assertFalse(actualIterableDeserializer.isCachable());
  }
}
