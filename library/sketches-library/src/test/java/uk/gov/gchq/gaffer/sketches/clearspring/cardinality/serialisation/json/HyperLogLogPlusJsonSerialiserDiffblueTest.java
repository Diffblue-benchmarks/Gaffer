package uk.gov.gchq.gaffer.sketches.clearspring.cardinality.serialisation.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.BeanProperty.Bogus;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HyperLogLogPlusJsonSerialiserDiffblueTest {
  /**
   * Test {@link HyperLogLogPlusJsonSerialiser#serialize(HyperLogLogPlus, JsonGenerator,
   * SerializerProvider)} with {@code HyperLogLogPlus}, {@code JsonGenerator}, {@code
   * SerializerProvider}.
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonSerialiser#serialize(HyperLogLogPlus,
   * JsonGenerator, SerializerProvider)}
   */
  @Test
  @DisplayName(
      "Test serialize(HyperLogLogPlus, JsonGenerator, SerializerProvider) with 'HyperLogLogPlus', 'JsonGenerator', 'SerializerProvider'")
  @Tag("MaintainedByDiffblue")
  void testSerializeWithHyperLogLogPlusJsonGeneratorSerializerProvider() throws IOException {
    // Arrange
    HyperLogLogPlusJsonSerialiser hyperLogLogPlusJsonSerialiser =
        new HyperLogLogPlusJsonSerialiser();

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
    hyperLogLogPlusJsonSerialiser.serialize(hyperLogLogPlus, jsonGenerator, new Impl());

    // Assert
    verify(hyperLogLogPlus).cardinality();
    verify(hyperLogLogPlus).getBytes();
    verify(jsonGenerator).writeNumberField("cardinality", 4L);
    verify(jsonGenerator).writeObjectField(eq("hyperLogLogPlusSketchBytes"), isA(Object.class));
    verify(jsonGenerator).writeObjectFieldStart("hyperLogLogPlus");
    verify(jsonGenerator, atLeast(1)).writeEndObject();
    verify(jsonGenerator).writeStartObject();
  }

  /**
   * Test {@link HyperLogLogPlusJsonSerialiser#serialize(HyperLogLogPlus, JsonGenerator,
   * SerializerProvider)} with {@code HyperLogLogPlus}, {@code JsonGenerator}, {@code
   * SerializerProvider}.
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonSerialiser#serialize(HyperLogLogPlus,
   * JsonGenerator, SerializerProvider)}
   */
  @Test
  @DisplayName(
      "Test serialize(HyperLogLogPlus, JsonGenerator, SerializerProvider) with 'HyperLogLogPlus', 'JsonGenerator', 'SerializerProvider'")
  @Tag("MaintainedByDiffblue")
  void testSerializeWithHyperLogLogPlusJsonGeneratorSerializerProvider2() throws IOException {
    // Arrange
    HyperLogLogPlusJsonSerialiser hyperLogLogPlusJsonSerialiser =
        new HyperLogLogPlusJsonSerialiser();

    HyperLogLogPlus hyperLogLogPlus = mock(HyperLogLogPlus.class);
    when(hyperLogLogPlus.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    FilteringGeneratorDelegate jsonGenerator = mock(FilteringGeneratorDelegate.class);
    doThrow(new IOException())
        .when(jsonGenerator)
        .writeObjectField(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(jsonGenerator).writeObjectFieldStart(Mockito.<String>any());
    doNothing().when(jsonGenerator).writeStartObject();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> hyperLogLogPlusJsonSerialiser.serialize(hyperLogLogPlus, jsonGenerator, new Impl()));
    verify(hyperLogLogPlus).getBytes();
    verify(jsonGenerator).writeObjectField(eq("hyperLogLogPlusSketchBytes"), isA(Object.class));
    verify(jsonGenerator).writeObjectFieldStart("hyperLogLogPlus");
    verify(jsonGenerator).writeStartObject();
  }

  /**
   * Test {@link HyperLogLogPlusJsonSerialiser#serializeWithType(HyperLogLogPlus, JsonGenerator,
   * SerializerProvider, TypeSerializer)} with {@code HyperLogLogPlus}, {@code JsonGenerator},
   * {@code SerializerProvider}, {@code TypeSerializer}.
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonSerialiser#serializeWithType(HyperLogLogPlus,
   * JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  @DisplayName(
      "Test serializeWithType(HyperLogLogPlus, JsonGenerator, SerializerProvider, TypeSerializer) with 'HyperLogLogPlus', 'JsonGenerator', 'SerializerProvider', 'TypeSerializer'")
  @Tag("MaintainedByDiffblue")
  void testSerializeWithTypeWithHyperLogLogPlusJsonGeneratorSerializerProviderTypeSerializer()
      throws IOException {
    // Arrange
    HyperLogLogPlusJsonSerialiser hyperLogLogPlusJsonSerialiser =
        new HyperLogLogPlusJsonSerialiser();

    FilteringGeneratorDelegate d = mock(FilteringGeneratorDelegate.class);
    doThrow(new IOException()).when(d).writeTypeId(Mockito.<Object>any());
    when(d.canWriteTypeId()).thenReturn(true);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d, true);
    Impl serializers = new Impl();

    ClassNameIdResolver idRes = mock(ClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");
    AsArrayTypeSerializer typeSer = new AsArrayTypeSerializer(idRes, new Bogus());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> hyperLogLogPlusJsonSerialiser.serializeWithType(null, gen, serializers, typeSer));
    verify(d).writeTypeId(isA(Object.class));
    verify(d).canWriteTypeId();
    verify(idRes).idFromValue((Object) isNull());
  }

  /**
   * Test {@link HyperLogLogPlusJsonSerialiser#serializeWithType(HyperLogLogPlus, JsonGenerator,
   * SerializerProvider, TypeSerializer)} with {@code HyperLogLogPlus}, {@code JsonGenerator},
   * {@code SerializerProvider}, {@code TypeSerializer}.
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonSerialiser#serializeWithType(HyperLogLogPlus,
   * JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  @DisplayName(
      "Test serializeWithType(HyperLogLogPlus, JsonGenerator, SerializerProvider, TypeSerializer) with 'HyperLogLogPlus', 'JsonGenerator', 'SerializerProvider', 'TypeSerializer'")
  @Tag("MaintainedByDiffblue")
  void testSerializeWithTypeWithHyperLogLogPlusJsonGeneratorSerializerProviderTypeSerializer2()
      throws IOException {
    // Arrange
    HyperLogLogPlusJsonSerialiser hyperLogLogPlusJsonSerialiser =
        new HyperLogLogPlusJsonSerialiser();

    FilteringGeneratorDelegate d = mock(FilteringGeneratorDelegate.class);
    doNothing().when(d).writeTypeId(Mockito.<Object>any());
    when(d.canWriteTypeId()).thenReturn(true);
    doThrow(new IOException()).when(d).writeStartObject(Mockito.<Object>any());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d, true);
    Impl serializers = new Impl();

    ClassNameIdResolver idRes = mock(ClassNameIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");
    AsArrayTypeSerializer typeSer = new AsArrayTypeSerializer(idRes, new Bogus());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> hyperLogLogPlusJsonSerialiser.serializeWithType(null, gen, serializers, typeSer));
    verify(d).writeStartObject((Object) isNull());
    verify(d).writeTypeId(isA(Object.class));
    verify(d).canWriteTypeId();
    verify(idRes).idFromValue((Object) isNull());
  }

  /**
   * Test {@link HyperLogLogPlusJsonSerialiser#serializeWithType(HyperLogLogPlus, JsonGenerator,
   * SerializerProvider, TypeSerializer)} with {@code HyperLogLogPlus}, {@code JsonGenerator},
   * {@code SerializerProvider}, {@code TypeSerializer}.
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonSerialiser#serializeWithType(HyperLogLogPlus,
   * JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  @DisplayName(
      "Test serializeWithType(HyperLogLogPlus, JsonGenerator, SerializerProvider, TypeSerializer) with 'HyperLogLogPlus', 'JsonGenerator', 'SerializerProvider', 'TypeSerializer'")
  @Tag("MaintainedByDiffblue")
  void testSerializeWithTypeWithHyperLogLogPlusJsonGeneratorSerializerProviderTypeSerializer3()
      throws IOException {
    // Arrange
    HyperLogLogPlusJsonSerialiser hyperLogLogPlusJsonSerialiser =
        new HyperLogLogPlusJsonSerialiser();

    HyperLogLogPlus value = mock(HyperLogLogPlus.class);
    when(value.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    FilteringGeneratorDelegate gen = mock(FilteringGeneratorDelegate.class);
    doThrow(new IOException())
        .when(gen)
        .writeObjectField(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(gen).writeObjectFieldStart(Mockito.<String>any());
    Impl serializers = new Impl();

    AsArrayTypeSerializer typeSer = mock(AsArrayTypeSerializer.class);
    doNothing()
        .when(typeSer)
        .writeTypePrefixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> hyperLogLogPlusJsonSerialiser.serializeWithType(value, gen, serializers, typeSer));
    verify(value).getBytes();
    verify(gen).writeObjectField(eq("hyperLogLogPlusSketchBytes"), isA(Object.class));
    verify(gen).writeObjectFieldStart("hyperLogLogPlus");
    verify(typeSer).writeTypePrefixForObject(isA(Object.class), isA(JsonGenerator.class));
  }

  /**
   * Test {@link HyperLogLogPlusJsonSerialiser#serializeWithType(HyperLogLogPlus, JsonGenerator,
   * SerializerProvider, TypeSerializer)} with {@code HyperLogLogPlus}, {@code JsonGenerator},
   * {@code SerializerProvider}, {@code TypeSerializer}.
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonSerialiser#serializeWithType(HyperLogLogPlus,
   * JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  @DisplayName(
      "Test serializeWithType(HyperLogLogPlus, JsonGenerator, SerializerProvider, TypeSerializer) with 'HyperLogLogPlus', 'JsonGenerator', 'SerializerProvider', 'TypeSerializer'")
  @Tag("MaintainedByDiffblue")
  void testSerializeWithTypeWithHyperLogLogPlusJsonGeneratorSerializerProviderTypeSerializer4()
      throws IOException {
    // Arrange
    HyperLogLogPlusJsonSerialiser hyperLogLogPlusJsonSerialiser =
        new HyperLogLogPlusJsonSerialiser();

    HyperLogLogPlus value = mock(HyperLogLogPlus.class);
    when(value.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(value.cardinality()).thenReturn(4L);

    FilteringGeneratorDelegate gen = mock(FilteringGeneratorDelegate.class);
    doNothing().when(gen).writeNumberField(Mockito.<String>any(), anyLong());
    doNothing().when(gen).writeObjectField(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(gen).writeEndObject();
    doNothing().when(gen).writeObjectFieldStart(Mockito.<String>any());
    Impl serializers = new Impl();

    AsArrayTypeSerializer typeSer = mock(AsArrayTypeSerializer.class);
    doNothing()
        .when(typeSer)
        .writeTypeSuffixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());
    doNothing()
        .when(typeSer)
        .writeTypePrefixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());

    // Act
    hyperLogLogPlusJsonSerialiser.serializeWithType(value, gen, serializers, typeSer);

    // Assert
    verify(value).cardinality();
    verify(value).getBytes();
    verify(gen).writeNumberField("cardinality", 4L);
    verify(gen).writeObjectField(eq("hyperLogLogPlusSketchBytes"), isA(Object.class));
    verify(gen).writeObjectFieldStart("hyperLogLogPlus");
    verify(gen).writeEndObject();
    verify(typeSer).writeTypePrefixForObject(isA(Object.class), isA(JsonGenerator.class));
    verify(typeSer).writeTypeSuffixForObject(isA(Object.class), isA(JsonGenerator.class));
  }

  /**
   * Test {@link HyperLogLogPlusJsonSerialiser#serializeWithType(HyperLogLogPlus, JsonGenerator,
   * SerializerProvider, TypeSerializer)} with {@code HyperLogLogPlus}, {@code JsonGenerator},
   * {@code SerializerProvider}, {@code TypeSerializer}.
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonSerialiser#serializeWithType(HyperLogLogPlus,
   * JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  @DisplayName(
      "Test serializeWithType(HyperLogLogPlus, JsonGenerator, SerializerProvider, TypeSerializer) with 'HyperLogLogPlus', 'JsonGenerator', 'SerializerProvider', 'TypeSerializer'")
  @Tag("MaintainedByDiffblue")
  void testSerializeWithTypeWithHyperLogLogPlusJsonGeneratorSerializerProviderTypeSerializer5()
      throws IOException {
    // Arrange
    HyperLogLogPlusJsonSerialiser hyperLogLogPlusJsonSerialiser =
        new HyperLogLogPlusJsonSerialiser();

    HyperLogLogPlus value = mock(HyperLogLogPlus.class);
    when(value.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(value.cardinality()).thenReturn(4L);

    FilteringGeneratorDelegate gen = mock(FilteringGeneratorDelegate.class);
    doNothing().when(gen).writeNumberField(Mockito.<String>any(), anyLong());
    doNothing().when(gen).writeObjectField(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(gen).writeEndObject();
    doNothing().when(gen).writeObjectFieldStart(Mockito.<String>any());
    Impl serializers = new Impl();

    AsArrayTypeSerializer typeSer = mock(AsArrayTypeSerializer.class);
    doThrow(new IOException())
        .when(typeSer)
        .writeTypeSuffixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());
    doNothing()
        .when(typeSer)
        .writeTypePrefixForObject(Mockito.<Object>any(), Mockito.<JsonGenerator>any());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> hyperLogLogPlusJsonSerialiser.serializeWithType(value, gen, serializers, typeSer));
    verify(value).cardinality();
    verify(value).getBytes();
    verify(gen).writeNumberField("cardinality", 4L);
    verify(gen).writeObjectField(eq("hyperLogLogPlusSketchBytes"), isA(Object.class));
    verify(gen).writeObjectFieldStart("hyperLogLogPlus");
    verify(gen).writeEndObject();
    verify(typeSer).writeTypePrefixForObject(isA(Object.class), isA(JsonGenerator.class));
    verify(typeSer).writeTypeSuffixForObject(isA(Object.class), isA(JsonGenerator.class));
  }

  /**
   * Test {@link HyperLogLogPlusJsonSerialiser#handledType()}.
   *
   * <p>Method under test: {@link HyperLogLogPlusJsonSerialiser#handledType()}
   */
  @Test
  @DisplayName("Test handledType()")
  @Tag("MaintainedByDiffblue")
  void testHandledType() {
    // Arrange and Act
    Class<HyperLogLogPlus> actualHandledTypeResult =
        new HyperLogLogPlusJsonSerialiser().handledType();

    // Assert
    Class<HyperLogLogPlus> expectedHandledTypeResult = HyperLogLogPlus.class;
    assertEquals(expectedHandledTypeResult, actualHandledTypeResult);
  }

  /**
   * Test new {@link HyperLogLogPlusJsonSerialiser} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * HyperLogLogPlusJsonSerialiser}
   */
  @Test
  @DisplayName("Test new HyperLogLogPlusJsonSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewHyperLogLogPlusJsonSerialiser() {
    // Arrange and Act
    HyperLogLogPlusJsonSerialiser actualHyperLogLogPlusJsonSerialiser =
        new HyperLogLogPlusJsonSerialiser();

    // Assert
    assertNull(actualHyperLogLogPlusJsonSerialiser.getDelegatee());
    assertFalse(actualHyperLogLogPlusJsonSerialiser.isUnwrappingSerializer());
  }
}
