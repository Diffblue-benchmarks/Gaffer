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

package uk.gov.gchq.gaffer.sketches.clearspring.cardinality.serialisation.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HyperLogLogPlusJsonSerialiserDiffblueTest {
  /**
   * Method under test:
   * {@link HyperLogLogPlusJsonSerialiser#serialize(HyperLogLogPlus, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize() throws IOException {
    // Arrange
    HyperLogLogPlusJsonSerialiser hyperLogLogPlusJsonSerialiser = new HyperLogLogPlusJsonSerialiser();
    HyperLogLogPlus hyperLogLogPlus = mock(HyperLogLogPlus.class);
    when(hyperLogLogPlus.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(hyperLogLogPlus.cardinality()).thenReturn(4L);
    FilteringGeneratorDelegate jsonGenerator = mock(FilteringGeneratorDelegate.class);
    doNothing().when(jsonGenerator).writeNumberField(Mockito.<String>any(), anyLong());
    doNothing().when(jsonGenerator).writeObjectField(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(jsonGenerator).writeEndObject();
    doNothing().when(jsonGenerator).writeObjectFieldStart(Mockito.<String>any());
    doNothing().when(jsonGenerator).writeStartObject();

    // Act
    hyperLogLogPlusJsonSerialiser.serialize(hyperLogLogPlus, jsonGenerator, new DefaultSerializerProvider.Impl());

    // Assert
    verify(hyperLogLogPlus).cardinality();
    verify(hyperLogLogPlus).getBytes();
    verify(jsonGenerator).writeNumberField(eq("cardinality"), eq(4L));
    verify(jsonGenerator).writeObjectField(eq("hyperLogLogPlusSketchBytes"), isA(Object.class));
    verify(jsonGenerator).writeObjectFieldStart(eq("hyperLogLogPlus"));
    verify(jsonGenerator, atLeast(1)).writeEndObject();
    verify(jsonGenerator).writeStartObject();
  }

  /**
   * Method under test:
   * {@link HyperLogLogPlusJsonSerialiser#serialize(HyperLogLogPlus, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize2() throws IOException {
    // Arrange
    HyperLogLogPlusJsonSerialiser hyperLogLogPlusJsonSerialiser = new HyperLogLogPlusJsonSerialiser();
    HyperLogLogPlus hyperLogLogPlus = mock(HyperLogLogPlus.class);
    when(hyperLogLogPlus.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    FilteringGeneratorDelegate jsonGenerator = mock(FilteringGeneratorDelegate.class);
    doThrow(new IOException("hyperLogLogPlus")).when(jsonGenerator)
        .writeObjectField(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(jsonGenerator).writeObjectFieldStart(Mockito.<String>any());
    doNothing().when(jsonGenerator).writeStartObject();

    // Act and Assert
    assertThrows(IOException.class, () -> hyperLogLogPlusJsonSerialiser.serialize(hyperLogLogPlus, jsonGenerator,
        new DefaultSerializerProvider.Impl()));
    verify(hyperLogLogPlus).getBytes();
    verify(jsonGenerator).writeObjectField(eq("hyperLogLogPlusSketchBytes"), isA(Object.class));
    verify(jsonGenerator).writeObjectFieldStart(eq("hyperLogLogPlus"));
    verify(jsonGenerator).writeStartObject();
  }

  /**
   * Method under test:
   * {@link HyperLogLogPlusJsonSerialiser#serializeWithType(HyperLogLogPlus, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType() throws IOException {
    // Arrange
    HyperLogLogPlusJsonSerialiser hyperLogLogPlusJsonSerialiser = new HyperLogLogPlusJsonSerialiser();
    HyperLogLogPlus value = mock(HyperLogLogPlus.class);
    when(value.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(value.cardinality()).thenReturn(4L);
    FilteringGeneratorDelegate gen = mock(FilteringGeneratorDelegate.class);
    doNothing().when(gen).writeNumberField(Mockito.<String>any(), anyLong());
    doNothing().when(gen).writeObjectField(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(gen).writeEndObject();
    doNothing().when(gen).writeObjectFieldStart(Mockito.<String>any());
    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    AsArrayTypeSerializer typeSer = mock(AsArrayTypeSerializer.class);
    doNothing().when(typeSer).writeTypeSuffixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());
    doNothing().when(typeSer).writeTypePrefixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());

    // Act
    hyperLogLogPlusJsonSerialiser.serializeWithType(value, gen, serializers, typeSer);

    // Assert
    verify(value).cardinality();
    verify(value).getBytes();
    verify(gen).writeNumberField(eq("cardinality"), eq(4L));
    verify(gen).writeObjectField(eq("hyperLogLogPlusSketchBytes"), isA(Object.class));
    verify(gen).writeObjectFieldStart(eq("hyperLogLogPlus"));
    verify(gen).writeEndObject();
    verify(typeSer).writeTypePrefixForObject(isA(Object.class), isA(JsonGenerator.class));
    verify(typeSer).writeTypeSuffixForObject(isA(Object.class), isA(JsonGenerator.class));
  }

  /**
   * Method under test:
   * {@link HyperLogLogPlusJsonSerialiser#serializeWithType(HyperLogLogPlus, JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  void testSerializeWithType2() throws IOException {
    // Arrange
    HyperLogLogPlusJsonSerialiser hyperLogLogPlusJsonSerialiser = new HyperLogLogPlusJsonSerialiser();
    HyperLogLogPlus value = mock(HyperLogLogPlus.class);
    when(value.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(value.cardinality()).thenReturn(4L);
    FilteringGeneratorDelegate gen = mock(FilteringGeneratorDelegate.class);
    doNothing().when(gen).writeNumberField(Mockito.<String>any(), anyLong());
    doNothing().when(gen).writeObjectField(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(gen).writeEndObject();
    doNothing().when(gen).writeObjectFieldStart(Mockito.<String>any());
    DefaultSerializerProvider.Impl serializers = new DefaultSerializerProvider.Impl();
    AsArrayTypeSerializer typeSer = mock(AsArrayTypeSerializer.class);
    doThrow(new IOException("hyperLogLogPlus")).when(typeSer)
        .writeTypeSuffixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());
    doNothing().when(typeSer).writeTypePrefixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());

    // Act and Assert
    assertThrows(IOException.class,
        () -> hyperLogLogPlusJsonSerialiser.serializeWithType(value, gen, serializers, typeSer));
    verify(value).cardinality();
    verify(value).getBytes();
    verify(gen).writeNumberField(eq("cardinality"), eq(4L));
    verify(gen).writeObjectField(eq("hyperLogLogPlusSketchBytes"), isA(Object.class));
    verify(gen).writeObjectFieldStart(eq("hyperLogLogPlus"));
    verify(gen).writeEndObject();
    verify(typeSer).writeTypePrefixForObject(isA(Object.class), isA(JsonGenerator.class));
    verify(typeSer).writeTypeSuffixForObject(isA(Object.class), isA(JsonGenerator.class));
  }

  /**
   * Method under test: {@link HyperLogLogPlusJsonSerialiser#handledType()}
   */
  @Test
  void testHandledType() {
    // Arrange and Act
    Class<HyperLogLogPlus> actualHandledTypeResult = (new HyperLogLogPlusJsonSerialiser()).handledType();

    // Assert
    Class<HyperLogLogPlus> expectedHandledTypeResult = HyperLogLogPlus.class;
    assertEquals(expectedHandledTypeResult, actualHandledTypeResult);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link HyperLogLogPlusJsonSerialiser}
   */
  @Test
  void testNewHyperLogLogPlusJsonSerialiser() {
    // Arrange and Act
    HyperLogLogPlusJsonSerialiser actualHyperLogLogPlusJsonSerialiser = new HyperLogLogPlusJsonSerialiser();

    // Assert
    assertNull(actualHyperLogLogPlusJsonSerialiser.getDelegatee());
    assertFalse(actualHyperLogLogPlusJsonSerialiser.isUnwrappingSerializer());
  }
}
