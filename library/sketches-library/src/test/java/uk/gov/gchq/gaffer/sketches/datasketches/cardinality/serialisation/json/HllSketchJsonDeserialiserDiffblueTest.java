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

package uk.gov.gchq.gaffer.sketches.datasketches.cardinality.serialisation.json;

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
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class HllSketchJsonDeserialiserDiffblueTest {
  /**
   * Test {@link HllSketchJsonDeserialiser#deserialize(JsonParser, DeserializationContext)} with {@code jsonParser}, {@code deserializationContext}.
   * <p>
   * Method under test: {@link HllSketchJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  @DisplayName("Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.datasketches.hll.HllSketch HllSketchJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"})
  void testDeserializeWithJsonParserDeserializationContext()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    HllSketchJsonDeserialiser hllSketchJsonDeserialiser = new HllSketchJsonDeserialiser();
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.unknown(), true);

    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();
    JsonParserDelegate jsonParser = new JsonParserDelegate(
        new UTF8StreamJsonParser(ctxt, 1, in, codec, null, "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> hllSketchJsonDeserialiser.deserialize(jsonParser,
        new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
  }

  /**
   * Test {@link HllSketchJsonDeserialiser#deserialize(JsonParser, DeserializationContext)} with {@code jsonParser}, {@code deserializationContext}.
   * <p>
   * Method under test: {@link HllSketchJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  @DisplayName("Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.datasketches.hll.HllSketch HllSketchJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"})
  void testDeserializeWithJsonParserDeserializationContext2() throws SerialisationException {
    // Arrange
    HllSketchJsonDeserialiser hllSketchJsonDeserialiser = new HllSketchJsonDeserialiser();
    MissingNode n = MissingNode.getInstance();
    TreeTraversingParser jsonParser = new TreeTraversingParser(n, JsonMapper.builder().findAndAddModules().build());

    // Act and Assert
    assertThrows(SerialisationException.class, () -> hllSketchJsonDeserialiser.deserialize(jsonParser,
        new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
  }

  /**
   * Test {@link HllSketchJsonDeserialiser#deserialize(JsonParser, DeserializationContext)} with {@code jsonParser}, {@code deserializationContext}.
   * <ul>
   *   <li>Given {@link HllSketchJsonConstants#DEFAULT_LOG_K}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HllSketchJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  @DisplayName("Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'; given DEFAULT_LOG_K")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.datasketches.hll.HllSketch HllSketchJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"})
  void testDeserializeWithJsonParserDeserializationContext_givenDefault_log_k() throws SerialisationException {
    // Arrange
    HllSketchJsonDeserialiser hllSketchJsonDeserialiser = new HllSketchJsonDeserialiser();
    JsonParserSequence d = mock(JsonParserSequence.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(HllSketchJsonConstants.DEFAULT_LOG_K);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> hllSketchJsonDeserialiser.deserialize(jsonParser,
        new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d, atLeast(1)).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
  }

  /**
   * Test {@link HllSketchJsonDeserialiser#deserialize(JsonParser, DeserializationContext)} with {@code jsonParser}, {@code deserializationContext}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link HllSketchJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  @DisplayName("Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.datasketches.hll.HllSketch HllSketchJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"})
  void testDeserializeWithJsonParserDeserializationContext_givenZero() throws SerialisationException {
    // Arrange
    HllSketchJsonDeserialiser hllSketchJsonDeserialiser = new HllSketchJsonDeserialiser();
    JsonParserSequence d = mock(JsonParserSequence.class);
    when(d.getTokenLocation()).thenReturn(new JsonLocation(ContentReference.unknown(), 1L, 2, 1));
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(0);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> hllSketchJsonDeserialiser.deserialize(jsonParser,
        new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d, atLeast(1)).currentToken();
    verify(d, atLeast(1)).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d).getTokenLocation();
  }

  /**
   * Test {@link HllSketchJsonDeserialiser#deserialize(JsonParser, DeserializationContext)} with {@code jsonParser}, {@code deserializationContext}.
   * <ul>
   *   <li>Then calls {@link JsonParserDelegate#getCurrentName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HllSketchJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  @DisplayName("Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'; then calls getCurrentName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.datasketches.hll.HllSketch HllSketchJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"})
  void testDeserializeWithJsonParserDeserializationContext_thenCallsGetCurrentName() throws IOException {
    // Arrange
    HllSketchJsonDeserialiser hllSketchJsonDeserialiser = new HllSketchJsonDeserialiser();
    JsonParserSequence d = mock(JsonParserSequence.class);
    when(d.getCurrentName()).thenReturn("Current Name");
    when(d.getTokenLocation()).thenReturn(new JsonLocation(ContentReference.unknown(), 1L, 2, 1));
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.nextToken()).thenReturn(JsonToken.FIELD_NAME);
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> hllSketchJsonDeserialiser.deserialize(jsonParser,
        new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d, atLeast(1)).currentToken();
    verify(d, atLeast(1)).currentTokenId();
    verify(d).getCodec();
    verify(d).getCurrentName();
    verify(d).getReadCapabilities();
    verify(d).getTokenLocation();
    verify(d, atLeast(1)).nextToken();
  }

  /**
   * Test new {@link HllSketchJsonDeserialiser} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link HllSketchJsonDeserialiser}
   */
  @Test
  @DisplayName("Test new HllSketchJsonDeserialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HllSketchJsonDeserialiser.<init>()"})
  void testNewHllSketchJsonDeserialiser() {
    // Arrange and Act
    HllSketchJsonDeserialiser actualHllSketchJsonDeserialiser = new HllSketchJsonDeserialiser();

    // Assert
    assertNull(actualHllSketchJsonDeserialiser.getDelegatee());
    assertNull(actualHllSketchJsonDeserialiser.getObjectIdReader());
    assertNull(actualHllSketchJsonDeserialiser.getEmptyValue());
    assertNull(actualHllSketchJsonDeserialiser.getKnownPropertyNames());
    assertNull(actualHllSketchJsonDeserialiser.getNullValue());
    assertEquals(AccessPattern.CONSTANT, actualHllSketchJsonDeserialiser.getNullAccessPattern());
    assertEquals(AccessPattern.DYNAMIC, actualHllSketchJsonDeserialiser.getEmptyAccessPattern());
    assertFalse(actualHllSketchJsonDeserialiser.isCachable());
  }
}
