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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import java.io.IOException;
import org.apache.datasketches.hll.HllSketch;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HllSketchJsonSerialiserDiffblueTest {
  /**
   * Method under test:
   * {@link HllSketchJsonSerialiser#serializeWithType(HllSketch, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType() throws IOException {
    // Arrange
    HllSketchJsonSerialiser hllSketchJsonSerialiser = new HllSketchJsonSerialiser();
    HllSketch value = mock(HllSketch.class);
    when(value.getEstimate()).thenReturn(10.0d);
    when(value.toCompactByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    FilteringGeneratorDelegate d = mock(FilteringGeneratorDelegate.class);
    doNothing().when(d).writeFieldName(Mockito.<String>any());
    doNothing().when(d).writeNumber(anyDouble());
    doNothing().when(d).writeObject(Mockito.<Object>any());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d, true);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    AsArrayTypeSerializer typeSer = mock(AsArrayTypeSerializer.class);
    doNothing().when(typeSer).writeTypeSuffixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());
    doNothing().when(typeSer).writeTypePrefixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());

    // Act
    hllSketchJsonSerialiser.serializeWithType(value, gen, serializers, typeSer);

    // Assert
    verify(d, atLeast(1)).writeFieldName(Mockito.<String>any());
    verify(d).writeNumber(eq(10.0d));
    verify(d).writeObject(isA(Object.class));
    verify(typeSer).writeTypePrefixForObject(isA(Object.class), isA(JsonGenerator.class));
    verify(typeSer).writeTypeSuffixForObject(isA(Object.class), isA(JsonGenerator.class));
    verify(value).getEstimate();
    verify(value).toCompactByteArray();
  }

  /**
   * Method under test:
   * {@link HllSketchJsonSerialiser#serializeWithType(HllSketch, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType2() throws IOException {
    // Arrange
    HllSketchJsonSerialiser hllSketchJsonSerialiser = new HllSketchJsonSerialiser();
    HllSketch value = mock(HllSketch.class);
    when(value.getEstimate()).thenReturn(10.0d);
    when(value.toCompactByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    FilteringGeneratorDelegate d = mock(FilteringGeneratorDelegate.class);
    doNothing().when(d).writeFieldName(Mockito.<String>any());
    doNothing().when(d).writeNumber(anyDouble());
    doNothing().when(d).writeObject(Mockito.<Object>any());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d, true);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    AsArrayTypeSerializer typeSer = mock(AsArrayTypeSerializer.class);
    doThrow(new IOException(HllSketchJsonConstants.BYTES)).when(typeSer)
        .writeTypeSuffixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());
    doNothing().when(typeSer).writeTypePrefixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());

    // Act and Assert
    assertThrows(IOException.class, () -> hllSketchJsonSerialiser.serializeWithType(value, gen, serializers, typeSer));
    verify(d, atLeast(1)).writeFieldName(Mockito.<String>any());
    verify(d).writeNumber(eq(10.0d));
    verify(d).writeObject(isA(Object.class));
    verify(typeSer).writeTypePrefixForObject(isA(Object.class), isA(JsonGenerator.class));
    verify(typeSer).writeTypeSuffixForObject(isA(Object.class), isA(JsonGenerator.class));
    verify(value).getEstimate();
    verify(value).toCompactByteArray();
  }

  /**
   * Method under test:
   * {@link HllSketchJsonSerialiser#serializeWithType(HllSketch, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType3() throws IOException {
    // Arrange
    HllSketchJsonSerialiser hllSketchJsonSerialiser = new HllSketchJsonSerialiser();
    HllSketch value = mock(HllSketch.class);
    when(value.getEstimate()).thenReturn(10.0d);
    when(value.toCompactByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    FilteringGeneratorDelegate d = mock(FilteringGeneratorDelegate.class);
    when(d.getCodec()).thenReturn(null);
    doNothing().when(d).writeBinary(Mockito.<Base64Variant>any(), Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(d).writeFieldName(Mockito.<String>any());
    doNothing().when(d).writeNumber(anyDouble());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d, false);

    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    AsArrayTypeSerializer typeSer = mock(AsArrayTypeSerializer.class);
    doNothing().when(typeSer).writeTypeSuffixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());
    doNothing().when(typeSer).writeTypePrefixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());

    // Act
    hllSketchJsonSerialiser.serializeWithType(value, gen, serializers, typeSer);

    // Assert
    verify(d).writeBinary(isA(Base64Variant.class), isA(byte[].class), eq(0), eq(8));
    verify(d, atLeast(1)).writeFieldName(Mockito.<String>any());
    verify(d).writeNumber(eq(10.0d));
    verify(d).getCodec();
    verify(typeSer).writeTypePrefixForObject(isA(Object.class), isA(JsonGenerator.class));
    verify(typeSer).writeTypeSuffixForObject(isA(Object.class), isA(JsonGenerator.class));
    verify(value).getEstimate();
    verify(value).toCompactByteArray();
  }

  /**
   * Method under test:
   * {@link HllSketchJsonSerialiser#serializeWithType(HllSketch, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType4() throws IOException {
    // Arrange
    HllSketchJsonSerialiser hllSketchJsonSerialiser = new HllSketchJsonSerialiser();
    HllSketch value = mock(HllSketch.class);
    when(value.getEstimate()).thenReturn(10.0d);
    when(value.toCompactByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    FilteringGeneratorDelegate gen = mock(FilteringGeneratorDelegate.class);
    doNothing().when(gen).writeNumberField(Mockito.<String>any(), anyDouble());
    doNothing().when(gen).writeObjectField(Mockito.<String>any(), Mockito.<Object>any());
    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    AsArrayTypeSerializer typeSer = mock(AsArrayTypeSerializer.class);
    doNothing().when(typeSer).writeTypeSuffixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());
    doNothing().when(typeSer).writeTypePrefixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());

    // Act
    hllSketchJsonSerialiser.serializeWithType(value, gen, serializers, typeSer);

    // Assert
    verify(gen).writeNumberField(eq("cardinality"), eq(10.0d));
    verify(gen).writeObjectField(eq("bytes"), isA(Object.class));
    verify(typeSer).writeTypePrefixForObject(isA(Object.class), isA(JsonGenerator.class));
    verify(typeSer).writeTypeSuffixForObject(isA(Object.class), isA(JsonGenerator.class));
    verify(value).getEstimate();
    verify(value).toCompactByteArray();
  }

  /**
   * Method under test: {@link HllSketchJsonSerialiser#handledType()}
   */
  @Test
  void testHandledType() {
    // Arrange and Act
    Class<HllSketch> actualHandledTypeResult = (new HllSketchJsonSerialiser()).handledType();

    // Assert
    Class<HllSketch> expectedHandledTypeResult = HllSketch.class;
    assertEquals(expectedHandledTypeResult, actualHandledTypeResult);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link HllSketchJsonSerialiser}
   */
  @Test
  void testNewHllSketchJsonSerialiser() {
    // Arrange and Act
    HllSketchJsonSerialiser actualHllSketchJsonSerialiser = new HllSketchJsonSerialiser();

    // Assert
    assertNull(actualHllSketchJsonSerialiser.getDelegatee());
    assertFalse(actualHllSketchJsonSerialiser.isUnwrappingSerializer());
  }
}
