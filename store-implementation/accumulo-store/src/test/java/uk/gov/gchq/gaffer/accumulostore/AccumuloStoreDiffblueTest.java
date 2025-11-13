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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
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
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.delete.DeleteElements;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.operation.handler.GetTraitsHandler;
import uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition;
import uk.gov.gchq.gaffer.store.schema.TypeDefinition;
import uk.gov.gchq.gaffer.store.schema.TypeDefinition.Builder;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.koryphe.ValidationResult;

class AccumuloStoreDiffblueTest {
  /**
   * Test {@link AccumuloStore#initialise(String, Schema, StoreProperties)}.
   * <ul>
   *   <li>Then throw {@link GafferRuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloStore#initialise(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test initialise(String, Schema, StoreProperties); then throw GafferRuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloStore.initialise(String, Schema, StoreProperties)"})
  void testInitialise_thenThrowGafferRuntimeException() throws StoreException {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();
    Schema schema = new Schema();
    StoreProperties properties = mock(StoreProperties.class);
    when(properties.getReflectionPackages()).thenThrow(new GafferRuntimeException("An error occurred"));
    when(properties.getProperties()).thenReturn(new Properties());
    doNothing().when(properties).updateStorePropertiesClass(Mockito.<Class<StoreProperties>>any());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> accumuloStore.initialise("42", schema, properties));
    verify(properties).getProperties();
    verify(properties).getReflectionPackages();
    verify(properties).updateStorePropertiesClass(isA(Class.class));
  }

  /**
   * Test {@link AccumuloStore#preInitialise(String, Schema, StoreProperties)}.
   * <ul>
   *   <li>Then throw {@link GafferRuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloStore#preInitialise(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test preInitialise(String, Schema, StoreProperties); then throw GafferRuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloStore.preInitialise(String, Schema, StoreProperties)"})
  void testPreInitialise_thenThrowGafferRuntimeException() throws StoreException {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();
    Schema schema = new Schema();
    StoreProperties properties = mock(StoreProperties.class);
    when(properties.getReflectionPackages()).thenThrow(new GafferRuntimeException("An error occurred"));
    when(properties.getProperties()).thenReturn(new Properties());
    doNothing().when(properties).updateStorePropertiesClass(Mockito.<Class<StoreProperties>>any());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> accumuloStore.preInitialise("42", schema, properties));
    verify(properties).getProperties();
    verify(properties).getReflectionPackages();
    verify(properties).updateStorePropertiesClass(isA(Class.class));
  }

  /**
   * Test {@link AccumuloStore#createSchemaOptimiser()}.
   * <p>
   * Method under test: {@link AccumuloStore#createSchemaOptimiser()}
   */
  @Test
  @DisplayName("Test createSchemaOptimiser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaOptimiser AccumuloStore.createSchemaOptimiser()"})
  void testCreateSchemaOptimiser() {
    // Arrange, Act and Assert
    assertNull((new AccumuloStore()).createSchemaOptimiser().optimise(null, true));
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   * <p>
   * Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry = new SimpleEntry<>("foo",
        new SchemaEdgeDefinition());

    ValidationResult validationResult = new ValidationResult("An error occurred");

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert that nothing has changed
    assertEquals("Validation errors: \nAn error occurred", validationResult.getErrorString());
    assertEquals(1, validationResult.getErrors().size());
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   * <p>
   * Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition2() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    TypeDefinition buildResult = (new Builder())
        .<BinaryOperator<Object>, Object>aggregateFunction(mock(BinaryOperator.class))
        .build();
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(buildResult);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet2);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry = new SimpleEntry<>("foo",
        schemaEdgeDefinition);

    ValidationResult validationResult = new ValidationResult("An error occurred");

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyClass(eq("foo"));
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyTypeDef(eq("foo"));
    assertEquals("Validation errors: \n" + "An error occurred\n"
        + "Could not find a serialiser for property 'foo' in the group 'foo'.", validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(2, errors.size());
    assertTrue(errors.contains("Could not find a serialiser for property 'foo' in the group 'foo'."));
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   * <p>
   * Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition3() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    Builder builder = new Builder();
    builder.serialiser(new AvroSerialiser());
    TypeDefinition buildResult = builder.<BinaryOperator<Object>, Object>aggregateFunction(mock(BinaryOperator.class))
        .build();
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(buildResult);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet2);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry = new SimpleEntry<>("foo",
        schemaEdgeDefinition);

    ValidationResult validationResult = new ValidationResult("An error occurred");

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyClass(eq("foo"));
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyTypeDef(eq("foo"));
    assertEquals("Validation errors: \n" + "An error occurred\n"
        + "Serialiser for groupBy property: foo is inconsistent. This store requires all groupBy property"
        + " serialisers to be consistent. Serialiser uk.gov.gchq.gaffer.serialisation.AvroSerialiser is not"
        + " consistent.", validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(2, errors.size());
    assertTrue(
        errors.contains("Serialiser for groupBy property: foo is inconsistent. This store requires all groupBy property"
            + " serialisers to be consistent. Serialiser uk.gov.gchq.gaffer.serialisation.AvroSerialiser is not"
            + " consistent."));
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   * <p>
   * Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition4() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");

    Builder builder = new Builder();
    builder.serialiser(new AvroSerialiser());
    TypeDefinition buildResult = builder.<BinaryOperator<Object>, Object>aggregateFunction(mock(BinaryOperator.class))
        .build();
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Class<Class> forNameResult = Class.class;
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(buildResult);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet2);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry = new SimpleEntry<>("foo",
        schemaEdgeDefinition);

    ValidationResult validationResult = new ValidationResult("An error occurred");

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyClass(eq("foo"));
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyTypeDef(eq("foo"));
    assertEquals("Validation errors: \n" + "An error occurred\n"
        + "Schema serialiser (uk.gov.gchq.gaffer.serialisation.AvroSerialiser) for property 'foo' in the group"
        + " 'foo' cannot handle property found in the schema\n"
        + "Serialiser for groupBy property: foo is inconsistent. This store requires all groupBy property"
        + " serialisers to be consistent. Serialiser uk.gov.gchq.gaffer.serialisation.AvroSerialiser is not"
        + " consistent.", validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(3, errors.size());
    assertTrue(errors
        .contains("Schema serialiser (uk.gov.gchq.gaffer.serialisation.AvroSerialiser) for property 'foo' in the group"
            + " 'foo' cannot handle property found in the schema"));
    assertTrue(
        errors.contains("Serialiser for groupBy property: foo is inconsistent. This store requires all groupBy property"
            + " serialisers to be consistent. Serialiser uk.gov.gchq.gaffer.serialisation.AvroSerialiser is not"
            + " consistent."));
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult); given HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition_givenHashSet() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    when(schemaEdgeDefinition.getProperties()).thenReturn(new HashSet<>());
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry = new SimpleEntry<>("foo",
        schemaEdgeDefinition);

    ValidationResult validationResult = new ValidationResult("An error occurred");

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert that nothing has changed
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    assertEquals("Validation errors: \nAn error occurred", validationResult.getErrorString());
    assertEquals(1, validationResult.getErrors().size());
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult); given HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition_givenHashSet2() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    TypeDefinition buildResult = (new Builder())
        .<BinaryOperator<Object>, Object>aggregateFunction(mock(BinaryOperator.class))
        .build();
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(buildResult);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaEdgeDefinition.getProperties()).thenReturn(new HashSet<>());
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry = new SimpleEntry<>("foo",
        schemaEdgeDefinition);

    ValidationResult validationResult = new ValidationResult("An error occurred");

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert that nothing has changed
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyTypeDef(eq("foo"));
    assertEquals("Validation errors: \nAn error occurred", validationResult.getErrorString());
    assertEquals(1, validationResult.getErrors().size());
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult); given HashSet() add empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition_givenHashSetAddEmptyString() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("");
    stringSet2.add("foo");
    Serialiser serialiser = mock(Serialiser.class);
    when(serialiser.canHandle(Mockito.<Class<Object>>any())).thenReturn(true);
    when(serialiser.isConsistent()).thenReturn(true);

    Builder builder = new Builder();
    builder.serialiser(serialiser);
    TypeDefinition buildResult = builder.<BinaryOperator<Object>, Object>aggregateFunction(mock(BinaryOperator.class))
        .build();
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(buildResult);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet2);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry = new SimpleEntry<>("foo",
        schemaEdgeDefinition);

    ValidationResult validationResult = new ValidationResult("An error occurred");

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert that nothing has changed
    verify(serialiser, atLeast(1)).canHandle(isA(Class.class));
    verify(serialiser).isConsistent();
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyClass(Mockito.<String>any());
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyTypeDef(Mockito.<String>any());
    assertEquals("Validation errors: \nAn error occurred", validationResult.getErrorString());
    assertEquals(1, validationResult.getErrors().size());
  }

  /**
   * Test {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}.
   * <ul>
   *   <li>Then calls {@link Serialiser#canHandle(Class)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloStore#validateSchemaElementDefinition(Entry, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult); then calls canHandle(Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloStore.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition_thenCallsCanHandle() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    HashSet<String> stringSet2 = new HashSet<>();
    stringSet2.add("foo");
    Serialiser serialiser = mock(Serialiser.class);
    when(serialiser.canHandle(Mockito.<Class<Object>>any())).thenReturn(true);
    when(serialiser.isConsistent()).thenReturn(true);

    Builder builder = new Builder();
    builder.serialiser(serialiser);
    TypeDefinition buildResult = builder.<BinaryOperator<Object>, Object>aggregateFunction(mock(BinaryOperator.class))
        .build();
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any())).thenReturn(buildResult);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet2);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry = new SimpleEntry<>("foo",
        schemaEdgeDefinition);

    ValidationResult validationResult = new ValidationResult("An error occurred");

    // Act
    accumuloStore.validateSchemaElementDefinition(schemaElementDefinitionEntry, validationResult);

    // Assert that nothing has changed
    verify(serialiser).canHandle(isA(Class.class));
    verify(serialiser).isConsistent();
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyClass(eq("foo"));
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyTypeDef(eq("foo"));
    assertEquals("Validation errors: \nAn error occurred", validationResult.getErrorString());
    assertEquals(1, validationResult.getErrors().size());
  }

  /**
   * Test {@link AccumuloStore#getProperties()}.
   * <p>
   * Method under test: {@link AccumuloStore#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AccumuloProperties AccumuloStore.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertNull((new AccumuloStore()).getProperties());
  }

  /**
   * Test {@link AccumuloStore#getDeleteElementsHandler()}.
   * <ul>
   *   <li>Then return {@link DeleteElementsHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloStore#getDeleteElementsHandler()}
   */
  @Test
  @DisplayName("Test getDeleteElementsHandler(); then return DeleteElementsHandler")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler AccumuloStore.getDeleteElementsHandler()"})
  void testGetDeleteElementsHandler_thenReturnDeleteElementsHandler() throws OperationException, StoreException {
    // Arrange and Act
    OutputOperationHandler<DeleteElements, Long> actualDeleteElementsHandler = (new AccumuloStore())
        .getDeleteElementsHandler();
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(new ArrayList<>());
    Context.Builder builder = mock(Context.Builder.class);
    when(builder.user(Mockito.<User>any())).thenReturn(new Context.Builder());
    User.Builder builder2 = mock(User.Builder.class);
    when(builder2.userId(Mockito.<String>any())).thenReturn(new User.Builder());
    User user = builder2.userId("42").build();
    Context buildResult = builder.user(user).build();
    MiniAccumuloStore miniAccumuloStore = mock(MiniAccumuloStore.class);
    when(miniAccumuloStore.getSchema()).thenReturn(new Schema());
    doNothing().when(miniAccumuloStore).deleteElements(Mockito.<Iterable<Element>>any());
    Long actualDoOperationResult = actualDeleteElementsHandler.doOperation(deleteElements, buildResult,
        miniAccumuloStore);

    // Assert
    verify(miniAccumuloStore).deleteElements(isA(Iterable.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(builder).user(isA(User.class));
    verify(miniAccumuloStore).getSchema();
    verify(builder2).userId(eq("42"));
    assertTrue(actualDeleteElementsHandler instanceof DeleteElementsHandler);
    assertEquals(0L, actualDoOperationResult.longValue());
  }

  /**
   * Test {@link AccumuloStore#getDeleteElementsHandler()}.
   * <ul>
   *   <li>Then return {@link DeleteElementsHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloStore#getDeleteElementsHandler()}
   */
  @Test
  @DisplayName("Test getDeleteElementsHandler(); then return DeleteElementsHandler")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler AccumuloStore.getDeleteElementsHandler()"})
  void testGetDeleteElementsHandler_thenReturnDeleteElementsHandler2() throws OperationException, StoreException {
    // Arrange and Act
    OutputOperationHandler<DeleteElements, Long> actualDeleteElementsHandler = (new AccumuloStore())
        .getDeleteElementsHandler();
    ArrayList<Element> elementList = new ArrayList<>();
    elementList.add(new Edge("Deleting elements: {}"));
    DeleteElements deleteElements = mock(DeleteElements.class);
    when(deleteElements.isSkipInvalidElements()).thenReturn(true);
    when(deleteElements.isValidate()).thenReturn(true);
    Mockito.<Iterable<? extends Element>>when(deleteElements.getInput()).thenReturn(elementList);
    Context.Builder builder = mock(Context.Builder.class);
    when(builder.user(Mockito.<User>any())).thenReturn(new Context.Builder());
    User.Builder builder2 = mock(User.Builder.class);
    when(builder2.userId(Mockito.<String>any())).thenReturn(new User.Builder());
    User user = builder2.userId("42").build();
    Context buildResult = builder.user(user).build();
    MiniAccumuloStore miniAccumuloStore = mock(MiniAccumuloStore.class);
    when(miniAccumuloStore.getSchema()).thenReturn(new Schema());
    doNothing().when(miniAccumuloStore).deleteElements(Mockito.<Iterable<Element>>any());
    Long actualDoOperationResult = actualDeleteElementsHandler.doOperation(deleteElements, buildResult,
        miniAccumuloStore);

    // Assert
    verify(miniAccumuloStore).deleteElements(isA(Iterable.class));
    verify(deleteElements).getInput();
    verify(deleteElements).isSkipInvalidElements();
    verify(deleteElements).isValidate();
    verify(builder).user(isA(User.class));
    verify(miniAccumuloStore).getSchema();
    verify(builder2).userId(eq("42"));
    assertTrue(actualDeleteElementsHandler instanceof DeleteElementsHandler);
    assertEquals(0L, actualDoOperationResult.longValue());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccumuloStore#getKeyPackage()}
   *   <li>{@link AccumuloStore#getPropertiesClass()}
   *   <li>{@link AccumuloStore#getRequiredParentSerialiserClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AccumuloKeyPackage AccumuloStore.getKeyPackage()", "Class AccumuloStore.getPropertiesClass()",
      "Class AccumuloStore.getRequiredParentSerialiserClass()"})
  void testGettersAndSetters() {
    // Arrange
    AccumuloStore accumuloStore = new AccumuloStore();

    // Act
    AccumuloKeyPackage actualKeyPackage = accumuloStore.getKeyPackage();
    Class<AccumuloProperties> actualPropertiesClass = accumuloStore.getPropertiesClass();
    Class<? extends ToBytesSerialiser> actualRequiredParentSerialiserClass = accumuloStore
        .getRequiredParentSerialiserClass();

    // Assert
    assertNull(actualKeyPackage);
    Class<AccumuloProperties> expectedPropertiesClass = AccumuloProperties.class;
    assertEquals(expectedPropertiesClass, actualPropertiesClass);
    Class<ToBytesSerialiser> expectedRequiredParentSerialiserClass = ToBytesSerialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualRequiredParentSerialiserClass);
  }

  /**
   * Test new {@link AccumuloStore} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AccumuloStore}
   */
  @Test
  @DisplayName("Test new AccumuloStore (default constructor)")
  @Tag("MaintainedByDiffblue")
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
    assertEquals(expectedRequiredParentSerialiserClass, actualAccumuloStore.getRequiredParentSerialiserClass());
  }
}
