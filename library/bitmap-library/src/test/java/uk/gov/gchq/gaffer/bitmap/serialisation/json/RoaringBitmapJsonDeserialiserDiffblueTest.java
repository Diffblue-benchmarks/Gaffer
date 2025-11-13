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

package uk.gov.gchq.gaffer.bitmap.serialisation.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RoaringBitmapJsonDeserialiserDiffblueTest {
  /**
   * Test {@link RoaringBitmapJsonDeserialiser#deserialize(JsonParser, DeserializationContext)} with {@code jsonParser}, {@code deserializationContext}.
   * <ul>
   *   <li>Given {@code END_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoaringBitmapJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  @DisplayName("Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'; given 'END_OBJECT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.roaringbitmap.RoaringBitmap RoaringBitmapJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"})
  void testDeserializeWithJsonParserDeserializationContext_givenEndObject() throws IOException {
    // Arrange
    RoaringBitmapJsonDeserialiser roaringBitmapJsonDeserialiser = new RoaringBitmapJsonDeserialiser();
    JsonParserSequence d = mock(JsonParserSequence.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentToken()).thenReturn(JsonToken.END_OBJECT);
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> roaringBitmapJsonDeserialiser.deserialize(jsonParser,
        new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
  }

  /**
   * Test {@link RoaringBitmapJsonDeserialiser#deserialize(JsonParser, DeserializationContext)} with {@code jsonParser}, {@code deserializationContext}.
   * <ul>
   *   <li>Then calls {@link JsonParserDelegate#currentTokenId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoaringBitmapJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  @DisplayName("Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'; then calls currentTokenId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.roaringbitmap.RoaringBitmap RoaringBitmapJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"})
  void testDeserializeWithJsonParserDeserializationContext_thenCallsCurrentTokenId() throws IOException {
    // Arrange
    RoaringBitmapJsonDeserialiser roaringBitmapJsonDeserialiser = new RoaringBitmapJsonDeserialiser();
    JsonParserSequence d = mock(JsonParserSequence.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> roaringBitmapJsonDeserialiser.deserialize(jsonParser,
        new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d).nextToken();
  }

  /**
   * Test new {@link RoaringBitmapJsonDeserialiser} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link RoaringBitmapJsonDeserialiser}
   */
  @Test
  @DisplayName("Test new RoaringBitmapJsonDeserialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RoaringBitmapJsonDeserialiser.<init>()"})
  void testNewRoaringBitmapJsonDeserialiser() {
    // Arrange and Act
    RoaringBitmapJsonDeserialiser actualRoaringBitmapJsonDeserialiser = new RoaringBitmapJsonDeserialiser();

    // Assert
    assertNull(actualRoaringBitmapJsonDeserialiser.getDelegatee());
    assertNull(actualRoaringBitmapJsonDeserialiser.getObjectIdReader());
    assertNull(actualRoaringBitmapJsonDeserialiser.getEmptyValue());
    assertNull(actualRoaringBitmapJsonDeserialiser.getKnownPropertyNames());
    assertNull(actualRoaringBitmapJsonDeserialiser.getNullValue());
    assertEquals(AccessPattern.CONSTANT, actualRoaringBitmapJsonDeserialiser.getNullAccessPattern());
    assertEquals(AccessPattern.DYNAMIC, actualRoaringBitmapJsonDeserialiser.getEmptyAccessPattern());
    assertFalse(actualRoaringBitmapJsonDeserialiser.isCachable());
  }
}
