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

package uk.gov.gchq.gaffer.accumulostore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.key.AccumuloKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.operation.handler.AddElementsHandler;
import uk.gov.gchq.gaffer.accumulostore.operation.handler.DeleteAllDataHandler;
import uk.gov.gchq.gaffer.accumulostore.operation.handler.DeleteElementsHandler;
import uk.gov.gchq.gaffer.accumulostore.operation.handler.GetAdjacentIdsHandler;
import uk.gov.gchq.gaffer.accumulostore.operation.handler.GetAllElementsHandler;
import uk.gov.gchq.gaffer.accumulostore.operation.handler.GetElementsHandler;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;
import uk.gov.gchq.gaffer.serialisation.TypeSubTypeValueSerialiser;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.operation.handler.GetTraitsHandler;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition;
import uk.gov.gchq.gaffer.store.schema.TypeDefinition;
import uk.gov.gchq.gaffer.store.schema.TypeDefinition.Builder;
import uk.gov.gchq.koryphe.ValidationResult;

class AccumuloStoreDiffblueTest {
  /**
   * Test {@link AccumuloStore#initialise(String, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>Then throw {@link GafferRuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStore#initialise(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test initialise(String, Schema, StoreProperties); then throw GafferRuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.initialise(String, Schema, StoreProperties)"})
  void testInitialise_thenThrowGafferRuntimeException() throws StoreException {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();
    Schema schema = new Schema();

    StoreProperties properties = mock(StoreProperties.class);
    when(properties.getReflectionPackages())
        .thenThrow(new GafferRuntimeException("An error occurred"));
    when(properties.getProperties()).thenReturn(new Properties());
    doNothing().when(properties).updateStorePropertiesClass(Mockito.<Class<StoreProperties>>any());

    // Act and Assert
    assertThrows(
        GafferRuntimeException.class, () -> accumuloStore.initialise("42", schema, properties));
    verify(properties).getProperties();
    verify(properties).getReflectionPackages();
    verify(properties).updateStorePropertiesClass(isA(Class.class));
  }

  /**
   * Test {@link AccumuloStore#preInitialise(String, Schema, StoreProperties)}.
   *
   * <ul>
   *   <li>Then throw {@link GafferRuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStore#preInitialise(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test preInitialise(String, Schema, StoreProperties); then throw GafferRuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.preInitialise(String, Schema, StoreProperties)"})
  void testPreInitialise_thenThrowGafferRuntimeException() throws StoreException {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();
    Schema schema = new Schema();

    StoreProperties properties = mock(StoreProperties.class);
    when(properties.getReflectionPackages())
        .thenThrow(new GafferRuntimeException("An error occurred"));
    when(properties.getProperties()).thenReturn(new Properties());
    doNothing().when(properties).updateStorePropertiesClass(Mockito.<Class<StoreProperties>>any());

    // Act and Assert
    assertThrows(
        GafferRuntimeException.class, () -> accumuloStore.preInitialise("42", schema, properties));
    verify(properties).getProperties();
    verify(properties).getReflectionPackages();
    verify(properties).updateStorePropertiesClass(isA(Class.class));
  }

  /**
   * Test {@link AccumuloStore#createSchemaOptimiser()}.
   *
   * <p>Method under test: {@link AccumuloStore#createSchemaOptimiser()}
   */
  @Test
  @DisplayName("Test createSchemaOptimiser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaOptimiser AccumuloStore.createSchemaOptimiser()"})
  void testCreateSchemaOptimiser() {
    // Arrange, Act and Assert
    assertNull(new AccumuloStore().createSchemaOptimiser().optimise(null, true));
  }

  /**
   * Test {@link AccumuloStore#validateSchemas()}.
   *
   * <p>Method under test: {@link AccumuloStore#validateSchemas()}
   */
  @Test
  @DisplayName("Test validateSchemas()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.validateSchemas()"})
  void testValidateSchemas() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class, () -> new AccumuloStore().validateSchemas());
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <p>Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", new SchemaEdgeDefinition());
    ValidationResult validationResult = new ValidationResult();

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert that nothing has changed
    assertEquals("Validation errors: \n", validationResult.getErrorString());
    assertTrue(validationResult.getErrors().isEmpty());
    assertTrue(validationResult.isValid());
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <p>Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition2() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getProperties()).thenReturn(new HashSet<>());
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    ValidationResult validationResult = new ValidationResult();

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert that nothing has changed
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    assertEquals("Validation errors: \n", validationResult.getErrorString());
    assertTrue(validationResult.getErrors().isEmpty());
    assertTrue(validationResult.isValid());
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <p>Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition3() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any()))
        .thenReturn(new Builder().aggregateFunction(mock(BinaryOperator.class)).build());
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaEdgeDefinition.getProperties()).thenReturn(new HashSet<>());
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    ValidationResult validationResult = new ValidationResult();

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert that nothing has changed
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyTypeDef("foo");
    assertEquals("Validation errors: \n", validationResult.getErrorString());
    assertTrue(validationResult.getErrors().isEmpty());
    assertTrue(validationResult.isValid());
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <p>Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition4() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any()))
        .thenThrow(new GafferRuntimeException("An error occurred"));
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaEdgeDefinition.getProperties()).thenReturn(new HashSet<>());
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);

    // Act and Assert
    assertThrows(
        GafferRuntimeException.class,
        () ->
            accumuloStore.validateSchemaElementDefinition(
                schemaElementDefinitionEntry, new ValidationResult()));
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyTypeDef("foo");
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <p>Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition5() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any()))
        .thenReturn(new Builder().aggregateFunction(mock(BinaryOperator.class)).build());
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet2);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    ValidationResult validationResult = new ValidationResult();

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyClass("foo");
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyTypeDef("foo");
    assertEquals(
        "Validation errors: \nCould not find a serialiser for property 'foo' in the group 'foo'.",
        validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(validationResult.isValid());
    assertTrue(
        errors.contains("Could not find a serialiser for property 'foo' in the group 'foo'."));
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <p>Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition6() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any()))
        .thenThrow(new GafferRuntimeException("An error occurred"));
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);

    // Act and Assert
    assertThrows(
        GafferRuntimeException.class,
        () ->
            accumuloStore.validateSchemaElementDefinition(
                schemaElementDefinitionEntry, new ValidationResult()));
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyClass("foo");
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <p>Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition7() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    Builder builder = new Builder();
    builder.serialiser(new TypeSubTypeValueSerialiser());
    TypeDefinition typeDefinition = builder.aggregateFunction(mock(BinaryOperator.class)).build();

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(typeDefinition);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet2);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    ValidationResult validationResult = new ValidationResult();

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyClass("foo");
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyTypeDef("foo");
    assertEquals(
        "Validation errors: \n"
            + "Schema serialiser (uk.gov.gchq.gaffer.serialisation.TypeSubTypeValueSerialiser) for property 'foo' in"
            + " the group 'foo' cannot handle property found in the schema",
        validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(validationResult.isValid());
    assertTrue(
        errors.contains(
            "Schema serialiser (uk.gov.gchq.gaffer.serialisation.TypeSubTypeValueSerialiser) for property 'foo' in"
                + " the group 'foo' cannot handle property found in the schema"));
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code Serialiser for groupBy property:}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateSchemaElementDefinition(Entry, ValidationResult); given HashSet() add 'Serialiser for groupBy property:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition_givenHashSetAddSerialiserForGroupByProperty() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("Serialiser for groupBy property: ");
    stringSet2.add("foo");

    Builder builder = new Builder();
    builder.serialiser(new AvroSerialiser());
    TypeDefinition typeDefinition = builder.aggregateFunction(mock(BinaryOperator.class)).build();

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(typeDefinition);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet2);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    ValidationResult validationResult = new ValidationResult();

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyClass(Mockito.<String>any());
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyTypeDef(Mockito.<String>any());
    assertEquals(
        "Validation errors: \n"
            + "Serialiser for groupBy property: foo is inconsistent. This store requires all groupBy property"
            + " serialisers to be consistent. Serialiser uk.gov.gchq.gaffer.serialisation.AvroSerialiser is not"
            + " consistent.",
        validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(validationResult.isValid());
    assertTrue(
        errors.contains(
            "Serialiser for groupBy property: foo is inconsistent. This store requires all groupBy property"
                + " serialisers to be consistent. Serialiser uk.gov.gchq.gaffer.serialisation.AvroSerialiser is not"
                + " consistent."));
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <ul>
   *   <li>Then {@link ValidationResult#ValidationResult()} ErrorString is a string.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateSchemaElementDefinition(Entry, ValidationResult); then ValidationResult() ErrorString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition_thenValidationResultErrorStringIsAString() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    Builder builder = new Builder();
    builder.serialiser(new AvroSerialiser());
    TypeDefinition typeDefinition = builder.aggregateFunction(mock(BinaryOperator.class)).build();

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(typeDefinition);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet2);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    ValidationResult validationResult = new ValidationResult();

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyClass("foo");
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyTypeDef("foo");
    assertEquals(
        "Validation errors: \n"
            + "Serialiser for groupBy property: foo is inconsistent. This store requires all groupBy property"
            + " serialisers to be consistent. Serialiser uk.gov.gchq.gaffer.serialisation.AvroSerialiser is not"
            + " consistent.",
        validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(validationResult.isValid());
    assertTrue(
        errors.contains(
            "Serialiser for groupBy property: foo is inconsistent. This store requires all groupBy property"
                + " serialisers to be consistent. Serialiser uk.gov.gchq.gaffer.serialisation.AvroSerialiser is not"
                + " consistent."));
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <ul>
   *   <li>Then {@link ValidationResult#ValidationResult()} Errors size is two.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateSchemaElementDefinition(Entry, ValidationResult); then ValidationResult() Errors size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition_thenValidationResultErrorsSizeIsTwo() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    Builder builder = new Builder();
    builder.serialiser(new AvroSerialiser());
    TypeDefinition typeDefinition = builder.aggregateFunction(mock(BinaryOperator.class)).build();

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Class<Class> forNameResult = Class.class;
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(typeDefinition);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet2);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    ValidationResult validationResult = new ValidationResult();

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyClass("foo");
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyTypeDef("foo");
    assertEquals(
        "Validation errors: \n"
            + "Schema serialiser (uk.gov.gchq.gaffer.serialisation.AvroSerialiser) for property 'foo' in the group"
            + " 'foo' cannot handle property found in the schema\n"
            + "Serialiser for groupBy property: foo is inconsistent. This store requires all groupBy property"
            + " serialisers to be consistent. Serialiser uk.gov.gchq.gaffer.serialisation.AvroSerialiser is not"
            + " consistent.",
        validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(2, errors.size());
    assertTrue(
        errors.contains(
            "Schema serialiser (uk.gov.gchq.gaffer.serialisation.AvroSerialiser) for property 'foo' in the group"
                + " 'foo' cannot handle property found in the schema"));
    assertTrue(
        errors.contains(
            "Serialiser for groupBy property: foo is inconsistent. This store requires all groupBy property"
                + " serialisers to be consistent. Serialiser uk.gov.gchq.gaffer.serialisation.AvroSerialiser is not"
                + " consistent."));
  }

  /**
   * Test {@link AccumuloStore#getProperties()}.
   *
   * <p>Method under test: {@link AccumuloStore#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AccumuloProperties AccumuloStore.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertNull(new AccumuloStore().getProperties());
  }

  /**
   * Test {@link AccumuloStore#getGetElementsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link GetElementsHandler}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStore#getGetElementsHandler()}
   */
  @Test
  @DisplayName("Test getGetElementsHandler(); then return GetElementsHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler AccumuloStore.getGetElementsHandler()"
  })
  void testGetGetElementsHandler_thenReturnGetElementsHandler() {
    // Arrange, Act and Assert
    assertTrue(new AccumuloStore().getGetElementsHandler() instanceof GetElementsHandler);
  }

  /**
   * Test {@link AccumuloStore#getGetAllElementsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link GetAllElementsHandler}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStore#getGetAllElementsHandler()}
   */
  @Test
  @DisplayName("Test getGetAllElementsHandler(); then return GetAllElementsHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler AccumuloStore.getGetAllElementsHandler()"
  })
  void testGetGetAllElementsHandler_thenReturnGetAllElementsHandler() {
    // Arrange, Act and Assert
    assertTrue(new AccumuloStore().getGetAllElementsHandler() instanceof GetAllElementsHandler);
  }

  /**
   * Test {@link AccumuloStore#getAdjacentIdsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link GetAdjacentIdsHandler}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStore#getAdjacentIdsHandler()}
   */
  @Test
  @DisplayName("Test getAdjacentIdsHandler(); then return GetAdjacentIdsHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler AccumuloStore.getAdjacentIdsHandler()"
  })
  void testGetAdjacentIdsHandler_thenReturnGetAdjacentIdsHandler() {
    // Arrange, Act and Assert
    assertTrue(new AccumuloStore().getAdjacentIdsHandler() instanceof GetAdjacentIdsHandler);
  }

  /**
   * Test {@link AccumuloStore#getAddElementsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link AddElementsHandler}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStore#getAddElementsHandler()}
   */
  @Test
  @DisplayName("Test getAddElementsHandler(); then return AddElementsHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OperationHandler AccumuloStore.getAddElementsHandler()"
  })
  void testGetAddElementsHandler_thenReturnAddElementsHandler() {
    // Arrange, Act and Assert
    assertTrue(new AccumuloStore().getAddElementsHandler() instanceof AddElementsHandler);
  }

  /**
   * Test {@link AccumuloStore#getGetTraitsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link GetTraitsHandler}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStore#getGetTraitsHandler()}
   */
  @Test
  @DisplayName("Test getGetTraitsHandler(); then return GetTraitsHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler AccumuloStore.getGetTraitsHandler()"
  })
  void testGetGetTraitsHandler_thenReturnGetTraitsHandler() {
    // Arrange, Act and Assert
    assertTrue(new AccumuloStore().getGetTraitsHandler() instanceof GetTraitsHandler);
  }

  /**
   * Test {@link AccumuloStore#getDeleteElementsHandler()}.
   *
   * <ul>
   *   <li>Then return {@link DeleteElementsHandler}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStore#getDeleteElementsHandler()}
   */
  @Test
  @DisplayName("Test getDeleteElementsHandler(); then return DeleteElementsHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler AccumuloStore.getDeleteElementsHandler()"
  })
  void testGetDeleteElementsHandler_thenReturnDeleteElementsHandler() {
    // Arrange, Act and Assert
    assertTrue(new AccumuloStore().getDeleteElementsHandler() instanceof DeleteElementsHandler);
  }

  /**
   * Test {@link AccumuloStore#getDeleteAllDataHandler()}.
   *
   * <ul>
   *   <li>Then return {@link DeleteAllDataHandler}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStore#getDeleteAllDataHandler()}
   */
  @Test
  @DisplayName("Test getDeleteAllDataHandler(); then return DeleteAllDataHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.operation.handler.OperationHandler AccumuloStore.getDeleteAllDataHandler()"
  })
  void testGetDeleteAllDataHandler_thenReturnDeleteAllDataHandler() {
    // Arrange, Act and Assert
    assertTrue(new AccumuloStore().getDeleteAllDataHandler() instanceof DeleteAllDataHandler);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AccumuloStore#getKeyPackage()}
   *   <li>{@link AccumuloStore#getPropertiesClass()}
   *   <li>{@link AccumuloStore#getRequiredParentSerialiserClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AccumuloKeyPackage AccumuloStore.getKeyPackage()",
    "Class AccumuloStore.getPropertiesClass()",
    "Class AccumuloStore.getRequiredParentSerialiserClass()"
  })
  void testGettersAndSetters() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    // Act
    AccumuloKeyPackage actualKeyPackage = accumuloStore.getKeyPackage();
    Class<AccumuloProperties> actualPropertiesClass = accumuloStore.getPropertiesClass();
    Class<? extends ToBytesSerialiser> actualRequiredParentSerialiserClass =
        accumuloStore.getRequiredParentSerialiserClass();

    // Assert
    assertNull(actualKeyPackage);
    Class<AccumuloProperties> expectedPropertiesClass = AccumuloProperties.class;
    assertEquals(expectedPropertiesClass, actualPropertiesClass);
    Class<ToBytesSerialiser> expectedRequiredParentSerialiserClass = ToBytesSerialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualRequiredParentSerialiserClass);
  }

  /**
   * Test new {@link AccumuloStore} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AccumuloStore}
   */
  @Test
  @DisplayName("Test new AccumuloStore (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloStore.<init>()"})
  void testNewAccumuloStore() {
    // Arrange and Act
    AccumuloStore actualAccumuloStore = new AccumuloStore();

    // Assert
    assertTrue(actualAccumuloStore.getAddElementsHandler() instanceof AddElementsHandler);
    assertTrue(actualAccumuloStore.getDeleteAllDataHandler() instanceof DeleteAllDataHandler);
    assertTrue(actualAccumuloStore.getDeleteElementsHandler() instanceof DeleteElementsHandler);
    assertTrue(actualAccumuloStore.getAdjacentIdsHandler() instanceof GetAdjacentIdsHandler);
    assertTrue(actualAccumuloStore.getGetAllElementsHandler() instanceof GetAllElementsHandler);
    assertTrue(actualAccumuloStore.getGetElementsHandler() instanceof GetElementsHandler);
    assertTrue(actualAccumuloStore.getGetTraitsHandler() instanceof GetTraitsHandler);
    assertNull(actualAccumuloStore.getGraphId());
    assertNull(actualAccumuloStore.getProperties());
    assertNull(actualAccumuloStore.getKeyPackage());
    assertNull(actualAccumuloStore.getJobTracker());
    assertNull(actualAccumuloStore.getGraphLibrary());
    assertNull(actualAccumuloStore.getOriginalSchema());
    assertNull(actualAccumuloStore.getSchema());
    assertTrue(actualAccumuloStore.getOperationChainOptimisers().isEmpty());
    assertTrue(actualAccumuloStore.getSupportedOperations().isEmpty());
    Class<AccumuloProperties> expectedPropertiesClass = AccumuloProperties.class;
    assertEquals(expectedPropertiesClass, actualAccumuloStore.getPropertiesClass());
    Class<ToBytesSerialiser> expectedRequiredParentSerialiserClass = ToBytesSerialiser.class;
    assertEquals(
        expectedRequiredParentSerialiserClass,
        actualAccumuloStore.getRequiredParentSerialiserClass());
  }
}
