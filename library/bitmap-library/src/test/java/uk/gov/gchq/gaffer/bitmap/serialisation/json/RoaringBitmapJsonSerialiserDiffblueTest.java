package uk.gov.gchq.gaffer.bitmap.serialisation.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.BeanProperty.Bogus;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.MinimalClassNameIdResolver;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.roaringbitmap.RoaringBitmap;

class RoaringBitmapJsonSerialiserDiffblueTest {
  /**
   * Test {@link RoaringBitmapJsonSerialiser#serialize(RoaringBitmap, JsonGenerator,
   * SerializerProvider)} with {@code RoaringBitmap}, {@code JsonGenerator}, {@code
   * SerializerProvider}.
   *
   * <p>Method under test: {@link RoaringBitmapJsonSerialiser#serialize(RoaringBitmap,
   * JsonGenerator, SerializerProvider)}
   */
  @Test
  @DisplayName(
      "Test serialize(RoaringBitmap, JsonGenerator, SerializerProvider) with 'RoaringBitmap', 'JsonGenerator', 'SerializerProvider'")
  @Tag("MaintainedByDiffblue")
  void testSerializeWithRoaringBitmapJsonGeneratorSerializerProvider() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap roaringBitmap = new RoaringBitmap();

    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeFieldName(Mockito.<String>any());
    doNothing().when(d).writeObject(Mockito.<Object>any());
    doNothing().when(d).writeStartObject();
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(d);
    JsonGeneratorDelegate jsonGenerator = new JsonGeneratorDelegate(d2, true);

    // Act
    roaringBitmapJsonSerialiser.serialize(roaringBitmap, jsonGenerator, new Impl());

    // Assert
    verify(d, atLeast(1)).writeEndObject();
    verify(d, atLeast(1)).writeFieldName(Mockito.<String>any());
    verify(d).writeObject(isA(Object.class));
    verify(d, atLeast(1)).writeStartObject();
  }

  /**
   * Test {@link RoaringBitmapJsonSerialiser#serialize(RoaringBitmap, JsonGenerator,
   * SerializerProvider)} with {@code RoaringBitmap}, {@code JsonGenerator}, {@code
   * SerializerProvider}.
   *
   * <p>Method under test: {@link RoaringBitmapJsonSerialiser#serialize(RoaringBitmap,
   * JsonGenerator, SerializerProvider)}
   */
  @Test
  @DisplayName(
      "Test serialize(RoaringBitmap, JsonGenerator, SerializerProvider) with 'RoaringBitmap', 'JsonGenerator', 'SerializerProvider'")
  @Tag("MaintainedByDiffblue")
  void testSerializeWithRoaringBitmapJsonGeneratorSerializerProvider2() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap roaringBitmap = new RoaringBitmap();

    JsonGenerator d = mock(JsonGenerator.class);
    doNothing()
        .when(d)
        .writeBinary(Mockito.<Base64Variant>any(), Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(d).flush();
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(d);
    JsonGeneratorDelegate d3 = new JsonGeneratorDelegate(d2, true);

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
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter5);

    FilteringGeneratorDelegate d4 =
        new FilteringGeneratorDelegate(d3, f, Inclusion.ONLY_INCLUDE_ALL, true);
    JsonGeneratorDelegate jsonGenerator = new JsonGeneratorDelegate(d4, true);

    // Act
    roaringBitmapJsonSerialiser.serialize(roaringBitmap, jsonGenerator, new Impl());

    // Assert
    verify(d).flush();
    verify(d).getCodec();
    verify(d).writeBinary(isA(Base64Variant.class), isA(byte[].class), eq(0), eq(8));
    verify(tokenFilter4).filterFinishObject();
    verify(tokenFilter2).filterFinishObject();
    verify(tokenFilter5).filterStartObject();
    verify(tokenFilter3).filterStartObject();
    verify(tokenFilter).includeBinary();
    verify(tokenFilter4).includeProperty("roaringBitmap");
    verify(tokenFilter2).includeProperty("value");
    verify(f).includeRootValue(0);
    JsonGenerator delegateResult = jsonGenerator.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = jsonGenerator.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(1, ((FilteringGeneratorDelegate) delegateResult).getMatchCount());
    assertTrue(outputContext.hasCurrentIndex());
  }

  /**
   * Test {@link RoaringBitmapJsonSerialiser#serialize(RoaringBitmap, JsonGenerator,
   * SerializerProvider)} with {@code RoaringBitmap}, {@code JsonGenerator}, {@code
   * SerializerProvider}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapJsonSerialiser#serialize(RoaringBitmap,
   * JsonGenerator, SerializerProvider)}
   */
  @Test
  @DisplayName(
      "Test serialize(RoaringBitmap, JsonGenerator, SerializerProvider) with 'RoaringBitmap', 'JsonGenerator', 'SerializerProvider'; given two")
  @Tag("MaintainedByDiffblue")
  void testSerializeWithRoaringBitmapJsonGeneratorSerializerProvider_givenTwo() throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();

    RoaringBitmap roaringBitmap = new RoaringBitmap();
    roaringBitmap.add(2);

    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeFieldName(Mockito.<String>any());
    doNothing().when(d).writeObject(Mockito.<Object>any());
    doNothing().when(d).writeStartObject();
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(d);
    JsonGeneratorDelegate jsonGenerator = new JsonGeneratorDelegate(d2, true);

    // Act
    roaringBitmapJsonSerialiser.serialize(roaringBitmap, jsonGenerator, new Impl());

    // Assert
    verify(d, atLeast(1)).writeEndObject();
    verify(d, atLeast(1)).writeFieldName(Mockito.<String>any());
    verify(d).writeObject(isA(Object.class));
    verify(d, atLeast(1)).writeStartObject();
  }

  /**
   * Test {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator,
   * SerializerProvider, TypeSerializer)} with {@code RoaringBitmap}, {@code JsonGenerator}, {@code
   * SerializerProvider}, {@code TypeSerializer}.
   *
   * <p>Method under test: {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap,
   * JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  @DisplayName(
      "Test serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer) with 'RoaringBitmap', 'JsonGenerator', 'SerializerProvider', 'TypeSerializer'")
  @Tag("MaintainedByDiffblue")
  void testSerializeWithTypeWithRoaringBitmapJsonGeneratorSerializerProviderTypeSerializer()
      throws IOException {
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
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(d);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d2, true);
    Impl serializers = new Impl();

    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");
    AsArrayTypeSerializer typeSer = new AsArrayTypeSerializer(idRes, new Bogus());

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers, typeSer);

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
   * Test {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator,
   * SerializerProvider, TypeSerializer)} with {@code RoaringBitmap}, {@code JsonGenerator}, {@code
   * SerializerProvider}, {@code TypeSerializer}.
   *
   * <p>Method under test: {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap,
   * JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  @DisplayName(
      "Test serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer) with 'RoaringBitmap', 'JsonGenerator', 'SerializerProvider', 'TypeSerializer'")
  @Tag("MaintainedByDiffblue")
  void testSerializeWithTypeWithRoaringBitmapJsonGeneratorSerializerProviderTypeSerializer2()
      throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();

    RoaringBitmap value = new RoaringBitmap();
    value.add(2);

    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeTypeId(Mockito.<Object>any());
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeFieldName(Mockito.<String>any());
    doNothing().when(d).writeObject(Mockito.<Object>any());
    doNothing().when(d).writeStartObject();
    when(d.canWriteTypeId()).thenReturn(true);
    doNothing().when(d).writeStartObject(Mockito.<Object>any());
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(d);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d2, true);
    Impl serializers = new Impl();

    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");
    AsArrayTypeSerializer typeSer = new AsArrayTypeSerializer(idRes, new Bogus());

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers, typeSer);

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
   * Test {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap, JsonGenerator,
   * SerializerProvider, TypeSerializer)} with {@code RoaringBitmap}, {@code JsonGenerator}, {@code
   * SerializerProvider}, {@code TypeSerializer}.
   *
   * <p>Method under test: {@link RoaringBitmapJsonSerialiser#serializeWithType(RoaringBitmap,
   * JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  @DisplayName(
      "Test serializeWithType(RoaringBitmap, JsonGenerator, SerializerProvider, TypeSerializer) with 'RoaringBitmap', 'JsonGenerator', 'SerializerProvider', 'TypeSerializer'")
  @Tag("MaintainedByDiffblue")
  void testSerializeWithTypeWithRoaringBitmapJsonGeneratorSerializerProviderTypeSerializer3()
      throws IOException {
    // Arrange
    RoaringBitmapJsonSerialiser roaringBitmapJsonSerialiser = new RoaringBitmapJsonSerialiser();
    RoaringBitmap value = new RoaringBitmap();

    JsonGenerator d = mock(JsonGenerator.class);
    doNothing()
        .when(d)
        .writeBinary(Mockito.<Base64Variant>any(), Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(d).flush();
    doNothing().when(d).writeTypeId(Mockito.<Object>any());
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    when(d.canWriteTypeId()).thenReturn(true);
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(d);
    JsonGeneratorDelegate d3 = new JsonGeneratorDelegate(d2, true);

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
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter5);

    FilteringGeneratorDelegate d4 =
        new FilteringGeneratorDelegate(d3, f, Inclusion.ONLY_INCLUDE_ALL, true);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d4, true);
    Impl serializers = new Impl();

    MinimalClassNameIdResolver idRes = mock(MinimalClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");
    AsArrayTypeSerializer typeSer = new AsArrayTypeSerializer(idRes, new Bogus());

    // Act
    roaringBitmapJsonSerialiser.serializeWithType(value, gen, serializers, typeSer);

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
    verify(tokenFilter4).includeProperty("roaringBitmap");
    verify(tokenFilter2).includeProperty("value");
    verify(f).includeRootValue(0);
    verify(idRes).idFromValue(isA(Object.class));
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(1, ((FilteringGeneratorDelegate) delegateResult).getMatchCount());
    assertTrue(outputContext.hasCurrentIndex());
  }

  /**
   * Test new {@link RoaringBitmapJsonSerialiser} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * RoaringBitmapJsonSerialiser}
   */
  @Test
  @DisplayName("Test new RoaringBitmapJsonSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewRoaringBitmapJsonSerialiser() {
    // Arrange and Act
    RoaringBitmapJsonSerialiser actualRoaringBitmapJsonSerialiser =
        new RoaringBitmapJsonSerialiser();

    // Assert
    assertNull(actualRoaringBitmapJsonSerialiser.getDelegatee());
    assertFalse(actualRoaringBitmapJsonSerialiser.isUnwrappingSerializer());
  }
}
