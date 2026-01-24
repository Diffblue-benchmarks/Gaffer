/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.sketches.clearspring.cardinality.serialisation.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class HyperLogLogPlusJsonDeserialiserDiffblueTest {
  /**
   * Test {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   * with {@code jsonParser}, {@code deserializationContext}.
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName(
      "Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.clearspring.analytics.stream.cardinality.HyperLogLogPlus HyperLogLogPlusJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserDeserializationContext() throws IOException {
    // Arrange
    HyperLogLogPlusJsonDeserialiser hyperLogLogPlusJsonDeserialiser =
        new HyperLogLogPlusJsonDeserialiser();
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.unknown(), true);
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();
    JsonParserDelegate jsonParser =
        new JsonParserDelegate(
            new UTF8StreamJsonParser(
                ctxt, 1, in, codec, null, "AXAXAXAX".getBytes("UTF-8"), 1, 3, true));

    // Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            hyperLogLogPlusJsonDeserialiser.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
  }

  /**
   * Test {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   * with {@code jsonParser}, {@code deserializationContext}.
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName(
      "Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.clearspring.analytics.stream.cardinality.HyperLogLogPlus HyperLogLogPlusJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserDeserializationContext2() throws IOException {
    // Arrange
    HyperLogLogPlusJsonDeserialiser hyperLogLogPlusJsonDeserialiser =
        new HyperLogLogPlusJsonDeserialiser();

    JsonParserSequence d = mock(JsonParserSequence.class);
    when(d.currentToken()).thenThrow(new RuntimeException());
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            hyperLogLogPlusJsonDeserialiser.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d).currentToken();
    verify(d).getCodec();
  }

  /**
   * Test {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   * with {@code jsonParser}, {@code deserializationContext}.
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName(
      "Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.clearspring.analytics.stream.cardinality.HyperLogLogPlus HyperLogLogPlusJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserDeserializationContext3() throws IOException {
    // Arrange
    HyperLogLogPlusJsonDeserialiser hyperLogLogPlusJsonDeserialiser =
        new HyperLogLogPlusJsonDeserialiser();

    JsonParserSequence d = mock(JsonParserSequence.class);
    when(d.getReadCapabilities()).thenThrow(new RuntimeException());
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            hyperLogLogPlusJsonDeserialiser.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d, atLeast(1)).currentToken();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
  }

  /**
   * Test {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   * with {@code jsonParser}, {@code deserializationContext}.
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName(
      "Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.clearspring.analytics.stream.cardinality.HyperLogLogPlus HyperLogLogPlusJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserDeserializationContext4() throws IOException {
    // Arrange
    HyperLogLogPlusJsonDeserialiser hyperLogLogPlusJsonDeserialiser =
        new HyperLogLogPlusJsonDeserialiser();
    DoubleNode n = DoubleNode.valueOf(10.0d);
    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();

    TreeTraversingParser jsonParser = new TreeTraversingParser(n, codec);

    // Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            hyperLogLogPlusJsonDeserialiser.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
  }

  /**
   * Test {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   * with {@code jsonParser}, {@code deserializationContext}.
   *
   * <ul>
   *   <li>Given {@code END_ARRAY}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName(
      "Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'; given 'END_ARRAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.clearspring.analytics.stream.cardinality.HyperLogLogPlus HyperLogLogPlusJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserDeserializationContext_givenEndArray() throws IOException {
    // Arrange
    HyperLogLogPlusJsonDeserialiser hyperLogLogPlusJsonDeserialiser =
        new HyperLogLogPlusJsonDeserialiser();

    JsonParserSequence jsonParser = mock(JsonParserSequence.class);
    doThrow(new RuntimeException()).when(jsonParser).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(jsonParser.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(jsonParser.currentToken()).thenReturn(JsonToken.END_ARRAY);
    when(jsonParser.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());

    // Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            hyperLogLogPlusJsonDeserialiser.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(jsonParser).clearCurrentToken();
    verify(jsonParser, atLeast(1)).currentToken();
    verify(jsonParser).getCodec();
    verify(jsonParser).getReadCapabilities();
  }

  /**
   * Test {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   * with {@code jsonParser}, {@code deserializationContext}.
   *
   * <ul>
   *   <li>Given {@code END_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName(
      "Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'; given 'END_OBJECT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.clearspring.analytics.stream.cardinality.HyperLogLogPlus HyperLogLogPlusJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserDeserializationContext_givenEndObject() throws IOException {
    // Arrange
    HyperLogLogPlusJsonDeserialiser hyperLogLogPlusJsonDeserialiser =
        new HyperLogLogPlusJsonDeserialiser();

    JsonParserSequence jsonParser = mock(JsonParserSequence.class);
    doThrow(new RuntimeException()).when(jsonParser).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(jsonParser.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(jsonParser.currentToken()).thenReturn(JsonToken.END_OBJECT);
    when(jsonParser.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());

    // Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            hyperLogLogPlusJsonDeserialiser.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(jsonParser).clearCurrentToken();
    verify(jsonParser, atLeast(1)).currentToken();
    verify(jsonParser).getCodec();
    verify(jsonParser).getReadCapabilities();
  }

  /**
   * Test {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   * with {@code jsonParser}, {@code deserializationContext}.
   *
   * <ul>
   *   <li>Then calls {@link JsonParserSequence#nextFieldName()}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName(
      "Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'; then calls nextFieldName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.clearspring.analytics.stream.cardinality.HyperLogLogPlus HyperLogLogPlusJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserDeserializationContext_thenCallsNextFieldName()
      throws IOException {
    // Arrange
    HyperLogLogPlusJsonDeserialiser hyperLogLogPlusJsonDeserialiser =
        new HyperLogLogPlusJsonDeserialiser();

    JsonParserSequence jsonParser = mock(JsonParserSequence.class);
    when(jsonParser.nextFieldName()).thenThrow(new SerialisationException("An error occurred"));
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(jsonParser.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(jsonParser.currentTokenId()).thenReturn(1);
    when(jsonParser.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(jsonParser.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());

    // Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            hyperLogLogPlusJsonDeserialiser.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(jsonParser).nextFieldName();
    verify(jsonParser, atLeast(1)).currentToken();
    verify(jsonParser).currentTokenId();
    verify(jsonParser).getCodec();
    verify(jsonParser).getReadCapabilities();
  }

  /**
   * Test {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser, DeserializationContext)}
   * with {@code jsonParser}, {@code deserializationContext}.
   *
   * <ul>
   *   <li>Then calls {@link JsonParserSequence#nextToken()}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonDeserialiser#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName(
      "Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'; then calls nextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.clearspring.analytics.stream.cardinality.HyperLogLogPlus HyperLogLogPlusJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserDeserializationContext_thenCallsNextToken() throws IOException {
    // Arrange
    HyperLogLogPlusJsonDeserialiser hyperLogLogPlusJsonDeserialiser =
        new HyperLogLogPlusJsonDeserialiser();

    JsonParserSequence d = mock(JsonParserSequence.class);
    doThrow(new RuntimeException()).when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(
        SerialisationException.class,
        () ->
            hyperLogLogPlusJsonDeserialiser.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d).nextToken();
  }

  /**
   * Test new {@link HyperLogLogPlusJsonDeserialiser} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * HyperLogLogPlusJsonDeserialiser}
   */
  @Test
  @DisplayName("Test new HyperLogLogPlusJsonDeserialiser (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HyperLogLogPlusJsonDeserialiser.<init>()"})
  void testNewHyperLogLogPlusJsonDeserialiser() {
    // Arrange and Act
    HyperLogLogPlusJsonDeserialiser actualHyperLogLogPlusJsonDeserialiser =
        new HyperLogLogPlusJsonDeserialiser();

    // Assert
    assertNull(actualHyperLogLogPlusJsonDeserialiser.getNullValue());
    assertNull(actualHyperLogLogPlusJsonDeserialiser.getDelegatee());
    assertNull(actualHyperLogLogPlusJsonDeserialiser.getObjectIdReader());
    assertNull(actualHyperLogLogPlusJsonDeserialiser.getEmptyValue());
    assertNull(actualHyperLogLogPlusJsonDeserialiser.getKnownPropertyNames());
    assertEquals(
        AccessPattern.CONSTANT, actualHyperLogLogPlusJsonDeserialiser.getNullAccessPattern());
    assertEquals(
        AccessPattern.DYNAMIC, actualHyperLogLogPlusJsonDeserialiser.getEmptyAccessPattern());
    assertFalse(actualHyperLogLogPlusJsonDeserialiser.isCachable());
  }
}
