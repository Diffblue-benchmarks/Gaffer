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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.MinimalClassNameIdResolver;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.roaringbitmap.RoaringBitmap;

class RoaringBitmapJsonSerialiserDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link RoaringBitmapJsonSerialiser}
   */
  @Test
  void testNewRoaringBitmapJsonSerialiser() {
    // Arrange and Act
    RoaringBitmapJsonSerialiser actualRoaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();

    // Assert
    assertNull(actualRoaringBitmapJsonSerialiser.getDelegatee());
    assertFalse(actualRoaringBitmapJsonSerialiser.isUnwrappingSerializer());
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serialize(RoaringBitmap, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap roaringBitmap = new RoaringBitmap();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeFieldName(Mockito.<String>any());
    doNothing().when(d).writeObject(Mockito.<Object>any());
    doNothing().when(d).writeStartObject();
    JsonGeneratorDelegate jsonGenerator = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    // Act
    roaringBitmapJsonSerialiser.serialize(roaringBitmap, jsonGenerator, new DefaultSerializerProvider.Impl());

    // Assert
    verify(d, atLeast(1)).writeEndObject();
    verify(d, atLeast(1)).writeFieldName(Mockito.<String>any());
    verify(d).writeObject(isA(Object.class));
    verify(d, atLeast(1)).writeStartObject();
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serialize(RoaringBitmap, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize2() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();

    RoaringBitmap roaringBitmap = new RoaringBitmap();
    roaringBitmap.add(2);
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeFieldName(Mockito.<String>any());
    doNothing().when(d).writeObject(Mockito.<Object>any());
    doNothing().when(d).writeStartObject();
    JsonGeneratorDelegate jsonGenerator = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    // Act
    roaringBitmapJsonSerialiser.serialize(roaringBitmap, jsonGenerator, new DefaultSerializerProvider.Impl());

    // Assert
    verify(d, atLeast(1)).writeEndObject();
    verify(d, atLeast(1)).writeFieldName(Mockito.<String>any());
    verify(d).writeObject(isA(Object.class));
    verify(d, atLeast(1)).writeStartObject();
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serialize(RoaringBitmap, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize3() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap roaringBitmap = new RoaringBitmap();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeBinary(Mockito.<Base64Variant>any(), Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(d).flush();
    when(d.getCodec()).thenReturn(new ObjectMapper());
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter5);
    doNothing().when(f).filterFinishObject();
    FilteringGeneratorDelegate d3 = new FilteringGeneratorDelegate(d2, f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);

    JsonGeneratorDelegate jsonGenerator = new JsonGeneratorDelegate(d3, true);

    // Act
    roaringBitmapJsonSerialiser.serialize(roaringBitmap, jsonGenerator, new DefaultSerializerProvider.Impl());

    // Assert
    verify(d).flush();
    verify(d).getCodec();
    verify(d).writeBinary(isA(Base64Variant.class), isA(byte[].class), eq(0), eq(8));
    verify(tokenFilter4).filterFinishObject();
    verify(tokenFilter2).filterFinishObject();
    verify(tokenFilter5).filterStartObject();
    verify(tokenFilter3).filterStartObject();
    verify(tokenFilter).includeBinary();
    verify(tokenFilter4).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter2).includeProperty(eq("value"));
    verify(f).includeRootValue(eq(0));
    JsonGenerator delegateResult = jsonGenerator.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = jsonGenerator.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(1, ((FilteringGeneratorDelegate) delegateResult).getMatchCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d3, delegateResult);
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serialize(RoaringBitmap, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize4() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap roaringBitmap = new RoaringBitmap();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeBinary(Mockito.<Base64Variant>any(), Mockito.<byte[]>any(), anyInt(), anyInt());
    when(d.getCodec()).thenReturn(null);
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter5);
    doNothing().when(f).filterFinishObject();
    FilteringGeneratorDelegate d3 = new FilteringGeneratorDelegate(d2, f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);

    JsonGeneratorDelegate jsonGenerator = new JsonGeneratorDelegate(d3, true);

    // Act
    roaringBitmapJsonSerialiser.serialize(roaringBitmap, jsonGenerator, new DefaultSerializerProvider.Impl());

    // Assert
    verify(d).getCodec();
    verify(d).writeBinary(isA(Base64Variant.class), isA(byte[].class), eq(0), eq(8));
    verify(tokenFilter4).filterFinishObject();
    verify(tokenFilter2).filterFinishObject();
    verify(tokenFilter5).filterStartObject();
    verify(tokenFilter3).filterStartObject();
    verify(tokenFilter).includeBinary();
    verify(tokenFilter4).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter2).includeProperty(eq("value"));
    verify(f).includeRootValue(eq(0));
    JsonGenerator delegateResult = jsonGenerator.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = jsonGenerator.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(1, ((FilteringGeneratorDelegate) delegateResult).getMatchCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d3, delegateResult);
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serialize(RoaringBitmap, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize5() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap roaringBitmap = new RoaringBitmap();
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeBinary(Mockito.<Base64Variant>any(), Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(d).flush();
    when(d.getCodec()).thenReturn(new ObjectMapper());
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter5);
    doNothing().when(f).filterFinishObject();
    JsonGeneratorDelegate d3 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d2, f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter6 = mock(TokenFilter.class);
    when(tokenFilter6.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter7 = mock(TokenFilter.class);
    when(tokenFilter7.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter6);
    doNothing().when(tokenFilter7).filterFinishObject();
    TokenFilter tokenFilter8 = mock(TokenFilter.class);
    when(tokenFilter8.filterStartObject()).thenReturn(tokenFilter7);
    TokenFilter tokenFilter9 = mock(TokenFilter.class);
    when(tokenFilter9.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter8);
    doNothing().when(tokenFilter9).filterFinishObject();
    TokenFilter tokenFilter10 = mock(TokenFilter.class);
    when(tokenFilter10.filterStartObject()).thenReturn(tokenFilter9);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter10);
    doNothing().when(f2).filterFinishObject();
    FilteringGeneratorDelegate d4 = new FilteringGeneratorDelegate(d3, f2, TokenFilter.Inclusion.INCLUDE_NON_NULL,
        true);

    JsonGeneratorDelegate jsonGenerator = new JsonGeneratorDelegate(d4, true);

    // Act
    roaringBitmapJsonSerialiser.serialize(roaringBitmap, jsonGenerator, new DefaultSerializerProvider.Impl());

    // Assert
    verify(d).flush();
    verify(d).getCodec();
    verify(d).writeBinary(isA(Base64Variant.class), isA(byte[].class), eq(0), eq(8));
    verify(tokenFilter4).filterFinishObject();
    verify(tokenFilter2).filterFinishObject();
    verify(tokenFilter9).filterFinishObject();
    verify(tokenFilter7).filterFinishObject();
    verify(tokenFilter5).filterStartObject();
    verify(tokenFilter3).filterStartObject();
    verify(tokenFilter10).filterStartObject();
    verify(tokenFilter8).filterStartObject();
    verify(tokenFilter).includeBinary();
    verify(tokenFilter6).includeBinary();
    verify(tokenFilter4).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter9).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter2).includeProperty(eq("value"));
    verify(tokenFilter7).includeProperty(eq("value"));
    verify(f).includeRootValue(eq(0));
    verify(f2).includeRootValue(eq(0));
    JsonStreamContext outputContext = jsonGenerator.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d4, jsonGenerator.delegate());
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serialize(RoaringBitmap, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize6() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap roaringBitmap = new RoaringBitmap();
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter5);
    doNothing().when(f).filterFinishObject();
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.unknown(), true);

    ObjectMapper codec = new ObjectMapper();
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);
    FilteringGeneratorDelegate d = new FilteringGeneratorDelegate(
        new JsonGeneratorDelegate(new UTF8JsonGenerator(ctxt, 1, codec, out), true), f,
        TokenFilter.Inclusion.INCLUDE_NON_NULL, true);

    JsonGeneratorDelegate jsonGenerator = new JsonGeneratorDelegate(d, true);

    // Act
    roaringBitmapJsonSerialiser.serialize(roaringBitmap, jsonGenerator, new DefaultSerializerProvider.Impl());

    // Assert
    verify(tokenFilter4).filterFinishObject();
    verify(tokenFilter2).filterFinishObject();
    verify(tokenFilter5).filterStartObject();
    verify(tokenFilter3).filterStartObject();
    verify(tokenFilter).includeBinary();
    verify(tokenFilter4).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter2).includeProperty(eq("value"));
    verify(f).includeRootValue(eq(0));
    JsonStreamContext outputContext = jsonGenerator.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(2, jsonGenerator.getOutputBuffered());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d, jsonGenerator.delegate());
    assertSame(out, jsonGenerator.getOutputTarget());
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap value = new RoaringBitmap();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeTypeId(Mockito.<Object>any());
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeFieldName(Mockito.<String>any());
    doNothing().when(d).writeObject(Mockito.<Object>any());
    doNothing().when(d).writeStartObject();
    when(d.canWriteTypeId()).thenReturn(true);
    doNothing().when(d).writeStartObject(Mockito.<Object>any());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers,
        new AsArrayTypeSerializer(idRes, new BeanProperty.Bogus()));

    // Assert
    verify(d, atLeast(1)).canWriteTypeId();
    verify(d, atLeast(1)).writeEndObject();
    verify(d, atLeast(1)).writeFieldName(Mockito.<String>any());
    verify(d).writeObject(isA(Object.class));
    verify(d).writeStartObject();
    verify(d).writeStartObject(isA(Object.class));
    verify(d).writeTypeId(isA(Object.class));
    verify(idRes).idFromValue(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType2() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();

    RoaringBitmap value = new RoaringBitmap();
    value.add(1);
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeTypeId(Mockito.<Object>any());
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeFieldName(Mockito.<String>any());
    doNothing().when(d).writeObject(Mockito.<Object>any());
    doNothing().when(d).writeStartObject();
    when(d.canWriteTypeId()).thenReturn(true);
    doNothing().when(d).writeStartObject(Mockito.<Object>any());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers,
        new AsArrayTypeSerializer(idRes, new BeanProperty.Bogus()));

    // Assert
    verify(d, atLeast(1)).canWriteTypeId();
    verify(d, atLeast(1)).writeEndObject();
    verify(d, atLeast(1)).writeFieldName(Mockito.<String>any());
    verify(d).writeObject(isA(Object.class));
    verify(d).writeStartObject();
    verify(d).writeStartObject(isA(Object.class));
    verify(d).writeTypeId(isA(Object.class));
    verify(idRes).idFromValue(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType3() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap value = new RoaringBitmap();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndArray();
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeFieldName(Mockito.<String>any());
    doNothing().when(d).writeObject(Mockito.<Object>any());
    doNothing().when(d).writeStartArray();
    doNothing().when(d).writeStartObject();
    doNothing().when(d).writeString(Mockito.<String>any());
    when(d.canWriteTypeId()).thenReturn(false);
    doNothing().when(d).writeStartObject(Mockito.<Object>any());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers,
        new AsArrayTypeSerializer(idRes, new BeanProperty.Bogus()));

    // Assert
    verify(d, atLeast(1)).canWriteTypeId();
    verify(d).writeEndArray();
    verify(d, atLeast(1)).writeEndObject();
    verify(d, atLeast(1)).writeFieldName(Mockito.<String>any());
    verify(d).writeObject(isA(Object.class));
    verify(d).writeStartArray();
    verify(d).writeStartObject();
    verify(d).writeStartObject(isA(Object.class));
    verify(d).writeString(eq("42"));
    verify(idRes).idFromValue(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType4() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap value = new RoaringBitmap();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeBinary(Mockito.<Base64Variant>any(), Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(d).flush();
    doNothing().when(d).writeTypeId(Mockito.<Object>any());
    when(d.getCodec()).thenReturn(new ObjectMapper());
    when(d.canWriteTypeId()).thenReturn(true);
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter5);
    doNothing().when(f).filterFinishObject();
    FilteringGeneratorDelegate d3 = new FilteringGeneratorDelegate(d2, f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d3, true);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers,
        new AsArrayTypeSerializer(idRes, new BeanProperty.Bogus()));

    // Assert
    verify(d, atLeast(1)).canWriteTypeId();
    verify(d).flush();
    verify(d).getCodec();
    verify(d).writeBinary(isA(Base64Variant.class), isA(byte[].class), eq(0), eq(8));
    verify(d).writeTypeId(isA(Object.class));
    verify(tokenFilter4).filterFinishObject();
    verify(tokenFilter2).filterFinishObject();
    verify(tokenFilter5).filterStartObject();
    verify(tokenFilter3).filterStartObject();
    verify(tokenFilter).includeBinary();
    verify(tokenFilter4).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter2).includeProperty(eq("value"));
    verify(f).includeRootValue(eq(0));
    verify(idRes).idFromValue(isA(Object.class));
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(1, ((FilteringGeneratorDelegate) delegateResult).getMatchCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d3, delegateResult);
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType5() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap value = new RoaringBitmap();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeBinary(Mockito.<Base64Variant>any(), Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(d).writeTypeId(Mockito.<Object>any());
    when(d.getCodec()).thenReturn(null);
    when(d.canWriteTypeId()).thenReturn(true);
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter5);
    doNothing().when(f).filterFinishObject();
    FilteringGeneratorDelegate d3 = new FilteringGeneratorDelegate(d2, f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d3, true);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers,
        new AsArrayTypeSerializer(idRes, new BeanProperty.Bogus()));

    // Assert
    verify(d, atLeast(1)).canWriteTypeId();
    verify(d).getCodec();
    verify(d).writeBinary(isA(Base64Variant.class), isA(byte[].class), eq(0), eq(8));
    verify(d).writeTypeId(isA(Object.class));
    verify(tokenFilter4).filterFinishObject();
    verify(tokenFilter2).filterFinishObject();
    verify(tokenFilter5).filterStartObject();
    verify(tokenFilter3).filterStartObject();
    verify(tokenFilter).includeBinary();
    verify(tokenFilter4).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter2).includeProperty(eq("value"));
    verify(f).includeRootValue(eq(0));
    verify(idRes).idFromValue(isA(Object.class));
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(1, ((FilteringGeneratorDelegate) delegateResult).getMatchCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d3, delegateResult);
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType6() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap value = new RoaringBitmap();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeString(Mockito.<String>any());
    doNothing().when(d).writeBinary(Mockito.<Base64Variant>any(), Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(d).flush();
    when(d.getCodec()).thenReturn(new ObjectMapper());
    when(d.canWriteTypeId()).thenReturn(false);
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter6 = mock(TokenFilter.class);
    when(tokenFilter6.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter5);
    doNothing().when(tokenFilter6).filterFinishObject();
    TokenFilter tokenFilter7 = mock(TokenFilter.class);
    when(tokenFilter7.filterStartObject()).thenReturn(tokenFilter6);
    TokenFilter tokenFilter8 = mock(TokenFilter.class);
    when(tokenFilter8.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter7);
    doNothing().when(tokenFilter8).filterFinishObject();
    TokenFilter tokenFilter9 = mock(TokenFilter.class);
    when(tokenFilter9.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter9.filterStartObject()).thenReturn(tokenFilter8);
    TokenFilter tokenFilter10 = mock(TokenFilter.class);
    doNothing().when(tokenFilter10).filterFinishArray();
    when(tokenFilter10.includeElement(anyInt())).thenReturn(tokenFilter9);
    when(tokenFilter10.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    doNothing().when(tokenFilter10).filterFinishObject();
    TokenFilter tokenFilter11 = mock(TokenFilter.class);
    when(tokenFilter11.filterStartArray()).thenReturn(tokenFilter10);
    when(tokenFilter11.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f = mock(TokenFilter.class);
    doNothing().when(f).filterFinishArray();
    when(f.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter11);
    doNothing().when(f).filterFinishObject();
    FilteringGeneratorDelegate d3 = new FilteringGeneratorDelegate(d2, f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d3, true);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers,
        new AsArrayTypeSerializer(idRes, new BeanProperty.Bogus()));

    // Assert
    verify(d, atLeast(1)).canWriteTypeId();
    verify(d).flush();
    verify(d).getCodec();
    verify(d).writeBinary(isA(Base64Variant.class), isA(byte[].class), eq(0), eq(8));
    verify(d).writeString(eq("42"));
    verify(tokenFilter10).filterFinishArray();
    verify(tokenFilter8).filterFinishObject();
    verify(tokenFilter6).filterFinishObject();
    verify(tokenFilter11).filterStartArray();
    verify(tokenFilter9).filterStartObject();
    verify(tokenFilter7).filterStartObject();
    verify(tokenFilter5).includeBinary();
    verify(tokenFilter10, atLeast(1)).includeElement(anyInt());
    verify(tokenFilter8).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter6).includeProperty(eq("value"));
    verify(f).includeRootValue(eq(0));
    verify(tokenFilter9).includeString(eq("42"));
    verify(idRes).idFromValue(isA(Object.class));
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(2, ((FilteringGeneratorDelegate) delegateResult).getMatchCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d3, delegateResult);
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType7() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap value = new RoaringBitmap();
    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter6 = mock(TokenFilter.class);
    when(tokenFilter6.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter5);
    doNothing().when(tokenFilter6).filterFinishObject();
    TokenFilter tokenFilter7 = mock(TokenFilter.class);
    when(tokenFilter7.filterStartObject()).thenReturn(tokenFilter6);
    TokenFilter tokenFilter8 = mock(TokenFilter.class);
    when(tokenFilter8.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter7);
    doNothing().when(tokenFilter8).filterFinishObject();
    TokenFilter tokenFilter9 = mock(TokenFilter.class);
    when(tokenFilter9.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter9.filterStartObject()).thenReturn(tokenFilter8);
    TokenFilter tokenFilter10 = mock(TokenFilter.class);
    doNothing().when(tokenFilter10).filterFinishArray();
    when(tokenFilter10.includeElement(anyInt())).thenReturn(tokenFilter9);
    when(tokenFilter10.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    doNothing().when(tokenFilter10).filterFinishObject();
    TokenFilter tokenFilter11 = mock(TokenFilter.class);
    when(tokenFilter11.filterStartArray()).thenReturn(tokenFilter10);
    when(tokenFilter11.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f = mock(TokenFilter.class);
    doNothing().when(f).filterFinishArray();
    when(f.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter11);
    doNothing().when(f).filterFinishObject();
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.unknown(), true);

    ObjectMapper codec = new ObjectMapper();
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);
    FilteringGeneratorDelegate d = new FilteringGeneratorDelegate(
        new JsonGeneratorDelegate(new UTF8JsonGenerator(ctxt, 1, codec, out), true), f,
        TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d, true);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers,
        new AsArrayTypeSerializer(idRes, new BeanProperty.Bogus()));

    // Assert
    verify(tokenFilter10).filterFinishArray();
    verify(tokenFilter8).filterFinishObject();
    verify(tokenFilter6).filterFinishObject();
    verify(tokenFilter11).filterStartArray();
    verify(tokenFilter9).filterStartObject();
    verify(tokenFilter7).filterStartObject();
    verify(tokenFilter5).includeBinary();
    verify(tokenFilter10, atLeast(1)).includeElement(anyInt());
    verify(tokenFilter8).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter6).includeProperty(eq("value"));
    verify(f).includeRootValue(eq(0));
    verify(tokenFilter9).includeString(eq("42"));
    verify(idRes).idFromValue(isA(Object.class));
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d, gen.delegate());
    assertSame(out, gen.getOutputTarget());
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType8() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap value = new RoaringBitmap();
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeBinary(Mockito.<Base64Variant>any(), Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(d).flush();
    doNothing().when(d).writeTypeId(Mockito.<Object>any());
    when(d.getCodec()).thenReturn(new ObjectMapper());
    when(d.canWriteTypeId()).thenReturn(true);
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter5);
    doNothing().when(f).filterFinishObject();
    JsonGeneratorDelegate d3 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d2, f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter6 = mock(TokenFilter.class);
    when(tokenFilter6.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter7 = mock(TokenFilter.class);
    when(tokenFilter7.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter6);
    doNothing().when(tokenFilter7).filterFinishObject();
    TokenFilter tokenFilter8 = mock(TokenFilter.class);
    when(tokenFilter8.filterStartObject()).thenReturn(tokenFilter7);
    TokenFilter tokenFilter9 = mock(TokenFilter.class);
    when(tokenFilter9.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter8);
    doNothing().when(tokenFilter9).filterFinishObject();
    TokenFilter tokenFilter10 = mock(TokenFilter.class);
    when(tokenFilter10.filterStartObject()).thenReturn(tokenFilter9);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter10);
    doNothing().when(f2).filterFinishObject();
    FilteringGeneratorDelegate d4 = new FilteringGeneratorDelegate(d3, f2, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH,
        true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d4, true);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers,
        new AsArrayTypeSerializer(idRes, new BeanProperty.Bogus()));

    // Assert
    verify(d, atLeast(1)).canWriteTypeId();
    verify(d).flush();
    verify(d).getCodec();
    verify(d).writeBinary(isA(Base64Variant.class), isA(byte[].class), eq(0), eq(8));
    verify(d).writeTypeId(isA(Object.class));
    verify(tokenFilter4).filterFinishObject();
    verify(tokenFilter2).filterFinishObject();
    verify(tokenFilter9).filterFinishObject();
    verify(tokenFilter7).filterFinishObject();
    verify(tokenFilter5).filterStartObject();
    verify(tokenFilter3).filterStartObject();
    verify(tokenFilter10).filterStartObject();
    verify(tokenFilter8).filterStartObject();
    verify(tokenFilter).includeBinary();
    verify(tokenFilter6).includeBinary();
    verify(tokenFilter4).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter9).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter2).includeProperty(eq("value"));
    verify(tokenFilter7).includeProperty(eq("value"));
    verify(f).includeRootValue(eq(0));
    verify(f2).includeRootValue(eq(0));
    verify(idRes).idFromValue(isA(Object.class));
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d4, gen.delegate());
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType9() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap value = new RoaringBitmap();
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeBinary(Mockito.<Base64Variant>any(), Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(d).writeTypeId(Mockito.<Object>any());
    when(d.getCodec()).thenReturn(null);
    when(d.canWriteTypeId()).thenReturn(true);
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter5);
    doNothing().when(f).filterFinishObject();
    JsonGeneratorDelegate d3 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d2, f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter6 = mock(TokenFilter.class);
    when(tokenFilter6.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter7 = mock(TokenFilter.class);
    when(tokenFilter7.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter6);
    doNothing().when(tokenFilter7).filterFinishObject();
    TokenFilter tokenFilter8 = mock(TokenFilter.class);
    when(tokenFilter8.filterStartObject()).thenReturn(tokenFilter7);
    TokenFilter tokenFilter9 = mock(TokenFilter.class);
    when(tokenFilter9.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter8);
    doNothing().when(tokenFilter9).filterFinishObject();
    TokenFilter tokenFilter10 = mock(TokenFilter.class);
    when(tokenFilter10.filterStartObject()).thenReturn(tokenFilter9);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter10);
    doNothing().when(f2).filterFinishObject();
    FilteringGeneratorDelegate d4 = new FilteringGeneratorDelegate(d3, f2, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH,
        true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d4, true);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers,
        new AsArrayTypeSerializer(idRes, new BeanProperty.Bogus()));

    // Assert
    verify(d, atLeast(1)).canWriteTypeId();
    verify(d).getCodec();
    verify(d).writeBinary(isA(Base64Variant.class), isA(byte[].class), eq(0), eq(8));
    verify(d).writeTypeId(isA(Object.class));
    verify(tokenFilter4).filterFinishObject();
    verify(tokenFilter2).filterFinishObject();
    verify(tokenFilter9).filterFinishObject();
    verify(tokenFilter7).filterFinishObject();
    verify(tokenFilter5).filterStartObject();
    verify(tokenFilter3).filterStartObject();
    verify(tokenFilter10).filterStartObject();
    verify(tokenFilter8).filterStartObject();
    verify(tokenFilter).includeBinary();
    verify(tokenFilter6).includeBinary();
    verify(tokenFilter4).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter9).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter2).includeProperty(eq("value"));
    verify(tokenFilter7).includeProperty(eq("value"));
    verify(f).includeRootValue(eq(0));
    verify(f2).includeRootValue(eq(0));
    verify(idRes).idFromValue(isA(Object.class));
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d4, gen.delegate());
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType10() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap value = new RoaringBitmap();
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeString(Mockito.<String>any());
    doNothing().when(d).writeBinary(Mockito.<Base64Variant>any(), Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(d).flush();
    when(d.getCodec()).thenReturn(new ObjectMapper());
    when(d.canWriteTypeId()).thenReturn(false);
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter6 = mock(TokenFilter.class);
    when(tokenFilter6.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter5);
    doNothing().when(tokenFilter6).filterFinishObject();
    TokenFilter tokenFilter7 = mock(TokenFilter.class);
    when(tokenFilter7.filterStartObject()).thenReturn(tokenFilter6);
    TokenFilter tokenFilter8 = mock(TokenFilter.class);
    when(tokenFilter8.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter7);
    doNothing().when(tokenFilter8).filterFinishObject();
    TokenFilter tokenFilter9 = mock(TokenFilter.class);
    when(tokenFilter9.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter9.filterStartObject()).thenReturn(tokenFilter8);
    TokenFilter tokenFilter10 = mock(TokenFilter.class);
    doNothing().when(tokenFilter10).filterFinishArray();
    when(tokenFilter10.includeElement(anyInt())).thenReturn(tokenFilter9);
    when(tokenFilter10.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    doNothing().when(tokenFilter10).filterFinishObject();
    TokenFilter tokenFilter11 = mock(TokenFilter.class);
    when(tokenFilter11.filterStartArray()).thenReturn(tokenFilter10);
    when(tokenFilter11.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f = mock(TokenFilter.class);
    doNothing().when(f).filterFinishArray();
    when(f.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter11);
    doNothing().when(f).filterFinishObject();
    JsonGeneratorDelegate d3 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d2, f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter12 = mock(TokenFilter.class);
    when(tokenFilter12.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter13 = mock(TokenFilter.class);
    when(tokenFilter13.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter12);
    doNothing().when(tokenFilter13).filterFinishObject();
    TokenFilter tokenFilter14 = mock(TokenFilter.class);
    when(tokenFilter14.filterStartObject()).thenReturn(tokenFilter13);
    TokenFilter tokenFilter15 = mock(TokenFilter.class);
    when(tokenFilter15.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter14);
    doNothing().when(tokenFilter15).filterFinishObject();
    TokenFilter tokenFilter16 = mock(TokenFilter.class);
    when(tokenFilter16.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter17 = mock(TokenFilter.class);
    when(tokenFilter17.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter16);
    doNothing().when(tokenFilter17).filterFinishObject();
    TokenFilter tokenFilter18 = mock(TokenFilter.class);
    when(tokenFilter18.filterStartObject()).thenReturn(tokenFilter17);
    TokenFilter tokenFilter19 = mock(TokenFilter.class);
    when(tokenFilter19.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter18);
    doNothing().when(tokenFilter19).filterFinishObject();
    TokenFilter tokenFilter20 = mock(TokenFilter.class);
    when(tokenFilter20.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter20.filterStartObject()).thenReturn(tokenFilter19);
    TokenFilter tokenFilter21 = mock(TokenFilter.class);
    doNothing().when(tokenFilter21).filterFinishArray();
    when(tokenFilter21.includeElement(anyInt())).thenReturn(tokenFilter20);
    when(tokenFilter21.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    doNothing().when(tokenFilter21).filterFinishObject();
    TokenFilter tokenFilter22 = mock(TokenFilter.class);
    when(tokenFilter22.filterStartArray()).thenReturn(tokenFilter21);
    when(tokenFilter22.filterStartObject()).thenReturn(tokenFilter15);
    TokenFilter f2 = mock(TokenFilter.class);
    doNothing().when(f2).filterFinishArray();
    when(f2.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter22);
    doNothing().when(f2).filterFinishObject();
    FilteringGeneratorDelegate d4 = new FilteringGeneratorDelegate(d3, f2, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH,
        true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d4, true);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers,
        new AsArrayTypeSerializer(idRes, new BeanProperty.Bogus()));

    // Assert
    verify(d, atLeast(1)).canWriteTypeId();
    verify(d).flush();
    verify(d).getCodec();
    verify(d).writeBinary(isA(Base64Variant.class), isA(byte[].class), eq(0), eq(8));
    verify(d).writeString(eq("42"));
    verify(tokenFilter10).filterFinishArray();
    verify(tokenFilter21).filterFinishArray();
    verify(tokenFilter8).filterFinishObject();
    verify(tokenFilter6).filterFinishObject();
    verify(tokenFilter19).filterFinishObject();
    verify(tokenFilter17).filterFinishObject();
    verify(tokenFilter11).filterStartArray();
    verify(tokenFilter22).filterStartArray();
    verify(tokenFilter9).filterStartObject();
    verify(tokenFilter7).filterStartObject();
    verify(tokenFilter20).filterStartObject();
    verify(tokenFilter18).filterStartObject();
    verify(tokenFilter5).includeBinary();
    verify(tokenFilter16).includeBinary();
    verify(tokenFilter10, atLeast(1)).includeElement(anyInt());
    verify(tokenFilter21, atLeast(1)).includeElement(anyInt());
    verify(tokenFilter8).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter19).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter6).includeProperty(eq("value"));
    verify(tokenFilter17).includeProperty(eq("value"));
    verify(f).includeRootValue(eq(0));
    verify(f2).includeRootValue(eq(0));
    verify(tokenFilter9).includeString(eq("42"));
    verify(tokenFilter20).includeString(eq("42"));
    verify(idRes).idFromValue(isA(Object.class));
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d4, gen.delegate());
  }

  /**
   * Method under test:
   * {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType11() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap value = new RoaringBitmap();
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    new IOException(RoaringBitmapConstants.BITMAP_WRAPPER_OBJECT_NAME);
    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.includeBinary()).thenReturn(true);
    TokenFilter tokenFilter6 = mock(TokenFilter.class);
    when(tokenFilter6.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter5);
    doNothing().when(tokenFilter6).filterFinishObject();
    TokenFilter tokenFilter7 = mock(TokenFilter.class);
    when(tokenFilter7.filterStartObject()).thenReturn(tokenFilter6);
    TokenFilter tokenFilter8 = mock(TokenFilter.class);
    when(tokenFilter8.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter7);
    doNothing().when(tokenFilter8).filterFinishObject();
    TokenFilter tokenFilter9 = mock(TokenFilter.class);
    when(tokenFilter9.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter9.filterStartObject()).thenReturn(tokenFilter8);
    TokenFilter tokenFilter10 = mock(TokenFilter.class);
    doNothing().when(tokenFilter10).filterFinishArray();
    when(tokenFilter10.includeElement(anyInt())).thenReturn(tokenFilter9);
    when(tokenFilter10.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    doNothing().when(tokenFilter10).filterFinishObject();
    TokenFilter tokenFilter11 = mock(TokenFilter.class);
    when(tokenFilter11.filterStartArray()).thenReturn(tokenFilter10);
    when(tokenFilter11.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f = mock(TokenFilter.class);
    doNothing().when(f).filterFinishArray();
    when(f.includeProperty(Mockito.<String>any())).thenReturn(mock(TokenFilter.class));
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter11);
    doNothing().when(f).filterFinishObject();
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.unknown(), true);

    ObjectMapper codec = new ObjectMapper();
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);
    FilteringGeneratorDelegate d = new FilteringGeneratorDelegate(
        new JsonGeneratorDelegate(new UTF8JsonGenerator(ctxt, 1, codec, out), true), f,
        TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH, true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d, true);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers,
        new AsArrayTypeSerializer(idRes, new BeanProperty.Bogus()));

    // Assert
    verify(tokenFilter10).filterFinishArray();
    verify(tokenFilter8).filterFinishObject();
    verify(tokenFilter6).filterFinishObject();
    verify(tokenFilter11).filterStartArray();
    verify(tokenFilter9).filterStartObject();
    verify(tokenFilter7).filterStartObject();
    verify(tokenFilter5).includeBinary();
    verify(tokenFilter10, atLeast(1)).includeElement(anyInt());
    verify(tokenFilter8).includeProperty(eq("roaringBitmap"));
    verify(tokenFilter6).includeProperty(eq("value"));
    verify(f).includeRootValue(eq(0));
    verify(tokenFilter9).includeString(eq("42"));
    verify(idRes).idFromValue(isA(Object.class));
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(3, gen.getOutputBuffered());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d, gen.delegate());
    assertSame(out, gen.getOutputTarget());
  }
}
