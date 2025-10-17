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
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.BeanProperty.Bogus;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IterableDeserializerDiffblueTest {
  /**
   * Test {@link IterableDeserializer#getModule()}.
   *
   * <p>Method under test: {@link IterableDeserializer#getModule()}
   */
  @Test
  @DisplayName("Test getModule()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleModule IterableDeserializer.getModule()"})
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
   * Test {@link IterableDeserializer#createContextual(DeserializationContext, BeanProperty)}.
   *
   * <ul>
   *   <li>Given {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   * </ul>
   *
   * <p>Method under test: {@link IterableDeserializer#createContextual(DeserializationContext,
   * BeanProperty)}
   */
  @Test
  @DisplayName(
      "Test createContextual(DeserializationContext, BeanProperty); given PlaceholderForType(int) with ordinal is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonDeserializer IterableDeserializer.createContextual(DeserializationContext, BeanProperty)"
  })
  void testCreateContextual_givenPlaceholderForTypeWithOrdinalIsOne() throws JsonMappingException {
    // Arrange
    IterableDeserializer iterableDeserializer = new IterableDeserializer();

    DeserializationContext deserializationContext = mock(DeserializationContext.class);
    when(deserializationContext.getContextualType()).thenReturn(new PlaceholderForType(1));

    // Act
    JsonDeserializer<?> actualCreateContextualResult =
        iterableDeserializer.createContextual(deserializationContext, new Bogus());

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
   * Test {@link IterableDeserializer#createContextual(DeserializationContext, BeanProperty)}.
   *
   * <ul>
   *   <li>Then calls {@link CollectionLikeType#containedType(int)}.
   * </ul>
   *
   * <p>Method under test: {@link IterableDeserializer#createContextual(DeserializationContext,
   * BeanProperty)}
   */
  @Test
  @DisplayName(
      "Test createContextual(DeserializationContext, BeanProperty); then calls containedType(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonDeserializer IterableDeserializer.createContextual(DeserializationContext, BeanProperty)"
  })
  void testCreateContextual_thenCallsContainedType() throws JsonMappingException {
    // Arrange
    IterableDeserializer iterableDeserializer = new IterableDeserializer();

    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.containedType(anyInt())).thenReturn(new PlaceholderForType(1));

    DeserializationContext deserializationContext = mock(DeserializationContext.class);
    when(deserializationContext.getContextualType()).thenReturn(collectionLikeType);

    // Act
    JsonDeserializer<?> actualCreateContextualResult =
        iterableDeserializer.createContextual(deserializationContext, new Bogus());

    // Assert
    verify(deserializationContext).getContextualType();
    verify(collectionLikeType).containedType(0);
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
   * Test new {@link IterableDeserializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link IterableDeserializer}
   */
  @Test
  @DisplayName("Test new IterableDeserializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IterableDeserializer.<init>()"})
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
