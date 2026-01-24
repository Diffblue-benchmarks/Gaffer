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

package uk.gov.gchq.gaffer.store.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.IdentifierType;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition.Builder;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition.BaseBuilder;
import uk.gov.gchq.koryphe.ValidationResult;
import uk.gov.gchq.koryphe.tuple.binaryoperator.TupleAdaptedBinaryOperator;

class SchemaElementDefinitionDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#aggregate(boolean)}.
   *
   * <p>Method under test: {@link BaseBuilder#aggregate(boolean)}
   */
  @Test
  @DisplayName("Test BaseBuilder aggregate(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.aggregate(boolean)"})
  void testBaseBuilderAggregate() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAggregateResult = builder.aggregate(true);

    // Assert
    assertSame(builder, actualAggregateResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#aggregator(ElementAggregator)}.
   *
   * <p>Method under test: {@link BaseBuilder#aggregator(ElementAggregator)}
   */
  @Test
  @DisplayName("Test BaseBuilder aggregator(ElementAggregator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.aggregator(ElementAggregator)"})
  void testBaseBuilderAggregator() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAggregatorResult = builder.aggregator(new ElementAggregator());

    // Assert
    assertSame(builder, actualAggregatorResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#description(String)}.
   *
   * <p>Method under test: {@link BaseBuilder#description(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder description(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.description(String)"})
  void testBaseBuilderDescription() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDescriptionResult =
        builder.description("The characteristics of someone or something");

    // Assert
    assertSame(builder, actualDescriptionResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#getElementDef()}.
   *
   * <p>Method under test: {@link BaseBuilder#getElementDef()}
   */
  @Test
  @DisplayName("Test BaseBuilder getElementDef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaElementDefinition BaseBuilder.getElementDef()"})
  void testBaseBuilderGetElementDef() {
    // Arrange
    Builder builder = new Builder();

    // Act
    SchemaEdgeDefinition actualElementDef = builder.getElementDef();

    // Assert
    assertSame(builder.elDef, actualElementDef);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#identifier(IdentifierType, String)}.
   *
   * <p>Method under test: {@link BaseBuilder#identifier(IdentifierType, String)}
   */
  @Test
  @DisplayName("Test BaseBuilder identifier(IdentifierType, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.identifier(IdentifierType, String)"})
  void testBaseBuilderIdentifier() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIdentifierResult = builder.identifier(IdentifierType.VERTEX, "Type Name");

    // Assert
    assertSame(builder, actualIdentifierResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#identifiers(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then ElementDef Identifiers return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#identifiers(Map)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder identifiers(Map); when HashMap(); then ElementDef Identifiers return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.identifiers(Map)"})
  void testBaseBuilderIdentifiers_whenHashMap_thenElementDefIdentifiersReturnSet() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    SchemaEdgeDefinition elementDef = builder.identifiers(new HashMap<>()).getElementDef();
    Collection<IdentifierType> identifiers = elementDef.getIdentifiers();
    assertTrue(identifiers instanceof Set);
    assertNull(elementDef.getDestination());
    assertNull(elementDef.getDirected());
    assertNull(elementDef.getSource());
    assertTrue(elementDef.getIdentifierTypeNames().isEmpty());
    assertTrue(identifiers.isEmpty());
    assertTrue(elementDef.getIdentifierMap().isEmpty());
    SchemaEdgeDefinition actualExpandedDefinition = elementDef.getExpandedDefinition();
    assertSame(elementDef, actualExpandedDefinition);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#parents(String[])}.
   *
   * <ul>
   *   <li>When {@code Parents}.
   *   <li>Then return ElementDef Parents size is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#parents(String[])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder parents(String[]); when 'Parents'; then return ElementDef Parents size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.parents(String[])"})
  void testBaseBuilderParents_whenParents_thenReturnElementDefParentsSizeIsOne() {
    // Arrange, Act and Assert
    SchemaEdgeDefinition elementDef = new Builder().parents("Parents").getElementDef();
    Set<String> parents = elementDef.getParents();
    assertEquals(1, parents.size());
    assertSame(parents, elementDef.getParentsOrNull());
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#properties(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return ElementDef PropertyTypeNames Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#properties(Map)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder properties(Map); when HashMap(); then return ElementDef PropertyTypeNames Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.properties(Map)"})
  void testBaseBuilderProperties_whenHashMap_thenReturnElementDefPropertyTypeNamesEmpty() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    SchemaEdgeDefinition elementDef = builder.properties(new HashMap<>()).getElementDef();
    assertTrue(elementDef.getPropertyTypeNames().isEmpty());
    assertTrue(elementDef.getPropertyMap().isEmpty());
    assertTrue(elementDef.properties.isEmpty());
    assertTrue(elementDef.getProperties().isEmpty());
    SchemaEdgeDefinition actualExpandedDefinition = elementDef.getExpandedDefinition();
    assertSame(elementDef, actualExpandedDefinition);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#property(String, String)}.
   *
   * <p>Method under test: {@link BaseBuilder#property(String, String)}
   */
  @Test
  @DisplayName("Test BaseBuilder property(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.property(String, String)"})
  void testBaseBuilderProperty() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertyResult = builder.property("Property Name", "Type Name");

    // Assert
    assertSame(builder, actualPropertyResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#validator(ElementFilter)}.
   *
   * <p>Method under test: {@link BaseBuilder#validator(ElementFilter)}
   */
  @Test
  @DisplayName("Test BaseBuilder validator(ElementFilter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.validator(ElementFilter)"})
  void testBaseBuilderValidator() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualValidatorResult = builder.validator(new ElementFilter());

    // Assert
    assertSame(builder, actualValidatorResult);
  }

  /**
   * Test {@link SchemaElementDefinition#validate()}.
   *
   * <ul>
   *   <li>Given {@link SchemaEdgeDefinition} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SchemaEdgeDefinition (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SchemaElementDefinition.validate()"})
  void testValidate_givenSchemaEdgeDefinition() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();

    // Act
    ValidationResult actualValidateResult = schemaEdgeDefinition.validate();

    // Assert
    Collection<IdentifierType> identifiers = schemaEdgeDefinition.getIdentifiers();
    assertTrue(identifiers instanceof Set);
    assertEquals(
        "Validation errors: \nEdge source type is not defined.\nEdge destination type is not defined.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(2, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(identifiers.isEmpty());
    assertTrue(schemaEdgeDefinition.fullAggregatorCache.getComponents().isEmpty());
    assertTrue(schemaEdgeDefinition.fullValidatorWithIsACache.getComponents().isEmpty());
    assertTrue(errors.contains("Edge destination type is not defined."));
    assertTrue(errors.contains("Edge source type is not defined."));
    ElementAggregator expectedFullAggregator = schemaEdgeDefinition.fullAggregatorCache;
    assertSame(expectedFullAggregator, schemaEdgeDefinition.getFullAggregator());
    ElementFilter expectedValidator = schemaEdgeDefinition.fullValidatorWithIsACache;
    assertSame(expectedValidator, schemaEdgeDefinition.getValidator());
  }

  /**
   * Test {@link SchemaElementDefinition#validate()}.
   *
   * <ul>
   *   <li>Given {@link SchemaEdgeDefinition} (default constructor) Aggregate is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SchemaEdgeDefinition (default constructor) Aggregate is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult SchemaElementDefinition.validate()"})
  void testValidate_givenSchemaEdgeDefinitionAggregateIsFalse() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();
    schemaEdgeDefinition.setAggregate(false);

    // Act
    ValidationResult actualValidateResult = schemaEdgeDefinition.validate();

    // Assert
    Collection<IdentifierType> identifiers = schemaEdgeDefinition.getIdentifiers();
    assertTrue(identifiers instanceof Set);
    assertEquals(
        "Validation errors: \nEdge source type is not defined.\nEdge destination type is not defined.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(2, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(identifiers.isEmpty());
    assertTrue(schemaEdgeDefinition.fullAggregatorCache.getComponents().isEmpty());
    assertTrue(schemaEdgeDefinition.fullValidatorWithIsACache.getComponents().isEmpty());
    assertTrue(errors.contains("Edge destination type is not defined."));
    assertTrue(errors.contains("Edge source type is not defined."));
    ElementAggregator expectedFullAggregator = schemaEdgeDefinition.fullAggregatorCache;
    assertSame(expectedFullAggregator, schemaEdgeDefinition.getFullAggregator());
    ElementFilter expectedValidator = schemaEdgeDefinition.fullValidatorWithIsACache;
    assertSame(expectedValidator, schemaEdgeDefinition.getValidator());
  }

  /**
   * Test {@link SchemaElementDefinition#getProperties()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SchemaElementDefinition.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue(new SchemaEdgeDefinition().getProperties().isEmpty());
  }

  /**
   * Test {@link SchemaElementDefinition#containsProperty(String)}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#containsProperty(String)}
   */
  @Test
  @DisplayName("Test containsProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SchemaElementDefinition.containsProperty(String)"})
  void testContainsProperty() {
    // Arrange, Act and Assert
    assertFalse(new SchemaEdgeDefinition().containsProperty("Property Name"));
  }

  /**
   * Test {@link SchemaElementDefinition#getPropertyMap()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getPropertyMap()}
   */
  @Test
  @DisplayName("Test getPropertyMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SchemaElementDefinition.getPropertyMap()"})
  void testGetPropertyMap() {
    // Arrange, Act and Assert
    assertTrue(new SchemaEdgeDefinition().getPropertyMap().isEmpty());
  }

  /**
   * Test {@link SchemaElementDefinition#getIdentifiers()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getIdentifiers()}
   */
  @Test
  @DisplayName("Test getIdentifiers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SchemaElementDefinition.getIdentifiers()"})
  void testGetIdentifiers() {
    // Arrange and Act
    Collection<IdentifierType> actualIdentifiers = new SchemaEdgeDefinition().getIdentifiers();

    // Assert
    assertTrue(actualIdentifiers instanceof Set);
    assertTrue(actualIdentifiers.isEmpty());
  }

  /**
   * Test {@link SchemaElementDefinition#getIdentifierMap()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getIdentifierMap()}
   */
  @Test
  @DisplayName("Test getIdentifierMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SchemaElementDefinition.getIdentifierMap()"})
  void testGetIdentifierMap() {
    // Arrange, Act and Assert
    assertTrue(new SchemaEdgeDefinition().getIdentifierMap().isEmpty());
  }

  /**
   * Test {@link SchemaElementDefinition#containsIdentifier(IdentifierType)}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#containsIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test containsIdentifier(IdentifierType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SchemaElementDefinition.containsIdentifier(IdentifierType)"})
  void testContainsIdentifier() {
    // Arrange, Act and Assert
    assertFalse(new SchemaEdgeDefinition().containsIdentifier(IdentifierType.VERTEX));
  }

  /**
   * Test {@link SchemaElementDefinition#getPropertyTypeName(String)}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getPropertyTypeName(String)}
   */
  @Test
  @DisplayName("Test getPropertyTypeName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaElementDefinition.getPropertyTypeName(String)"})
  void testGetPropertyTypeName() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getPropertyTypeName("Property Name"));
  }

  /**
   * Test {@link SchemaElementDefinition#getIdentifierTypeName(IdentifierType)}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getIdentifierTypeName(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifierTypeName(IdentifierType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaElementDefinition.getIdentifierTypeName(IdentifierType)"})
  void testGetIdentifierTypeName() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getIdentifierTypeName(IdentifierType.VERTEX));
  }

  /**
   * Test {@link SchemaElementDefinition#getPropertyTypeNames()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getPropertyTypeNames()}
   */
  @Test
  @DisplayName("Test getPropertyTypeNames()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SchemaElementDefinition.getPropertyTypeNames()"})
  void testGetPropertyTypeNames() {
    // Arrange, Act and Assert
    assertTrue(new SchemaEdgeDefinition().getPropertyTypeNames().isEmpty());
  }

  /**
   * Test {@link SchemaElementDefinition#getIdentifierTypeNames()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getIdentifierTypeNames()}
   */
  @Test
  @DisplayName("Test getIdentifierTypeNames()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SchemaElementDefinition.getIdentifierTypeNames()"})
  void testGetIdentifierTypeNames() {
    // Arrange, Act and Assert
    assertTrue(new SchemaEdgeDefinition().getIdentifierTypeNames().isEmpty());
  }

  /**
   * Test {@link SchemaElementDefinition#getClass(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#getClass(String)}
   */
  @Test
  @DisplayName("Test getClass(String) with 'String'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Class SchemaElementDefinition.getClass(String)"})
  void testGetClassWithString_whenKey() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getClass("Key"));
  }

  /**
   * Test {@link SchemaElementDefinition#getClass(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#getClass(String)}
   */
  @Test
  @DisplayName("Test getClass(String) with 'String'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Class SchemaElementDefinition.getClass(String)"})
  void testGetClassWithString_whenNull() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getClass(null));
  }

  /**
   * Test {@link SchemaElementDefinition#getOriginalAggregator()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getOriginalAggregator()}
   */
  @Test
  @DisplayName("Test getOriginalAggregator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementAggregator SchemaElementDefinition.getOriginalAggregator()"})
  void testGetOriginalAggregator() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getOriginalAggregator());
  }

  /**
   * Test {@link SchemaElementDefinition#getOriginalAggregateFunctions()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getOriginalAggregateFunctions()}
   */
  @Test
  @DisplayName("Test getOriginalAggregateFunctions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List SchemaElementDefinition.getOriginalAggregateFunctions()"})
  void testGetOriginalAggregateFunctions() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getOriginalAggregateFunctions());
  }

  /**
   * Test {@link SchemaElementDefinition#getFullAggregator()}.
   *
   * <ul>
   *   <li>Given {@link SchemaEdgeDefinition} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#getFullAggregator()}
   */
  @Test
  @DisplayName("Test getFullAggregator(); given SchemaEdgeDefinition (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementAggregator SchemaElementDefinition.getFullAggregator()"})
  void testGetFullAggregator_givenSchemaEdgeDefinition() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();

    // Act
    ElementAggregator actualFullAggregator = schemaEdgeDefinition.getFullAggregator();

    // Assert
    Collection<IdentifierType> identifiers = schemaEdgeDefinition.getIdentifiers();
    assertTrue(identifiers instanceof Set);
    assertTrue(identifiers.isEmpty());
    assertTrue(actualFullAggregator.getComponents().isEmpty());
    ElementAggregator elementAggregator = schemaEdgeDefinition.fullAggregatorCache;
    assertEquals(elementAggregator, schemaEdgeDefinition.getIngestAggregator());
    assertSame(elementAggregator, actualFullAggregator);
  }

  /**
   * Test {@link SchemaElementDefinition#getFullAggregator()}.
   *
   * <ul>
   *   <li>Given {@link SchemaEdgeDefinition} (default constructor) Aggregate is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#getFullAggregator()}
   */
  @Test
  @DisplayName(
      "Test getFullAggregator(); given SchemaEdgeDefinition (default constructor) Aggregate is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementAggregator SchemaElementDefinition.getFullAggregator()"})
  void testGetFullAggregator_givenSchemaEdgeDefinitionAggregateIsFalse() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();
    schemaEdgeDefinition.setAggregate(false);

    // Act
    ElementAggregator actualFullAggregator = schemaEdgeDefinition.getFullAggregator();

    // Assert
    Collection<IdentifierType> identifiers = schemaEdgeDefinition.getIdentifiers();
    assertTrue(identifiers instanceof Set);
    assertTrue(identifiers.isEmpty());
    assertTrue(actualFullAggregator.getComponents().isEmpty());
    ElementAggregator elementAggregator = schemaEdgeDefinition.fullAggregatorCache;
    assertEquals(elementAggregator, schemaEdgeDefinition.getIngestAggregator());
    assertSame(elementAggregator, actualFullAggregator);
  }

  /**
   * Test {@link SchemaElementDefinition#getIngestAggregator()}.
   *
   * <ul>
   *   <li>Given {@link SchemaEdgeDefinition} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#getIngestAggregator()}
   */
  @Test
  @DisplayName("Test getIngestAggregator(); given SchemaEdgeDefinition (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementAggregator SchemaElementDefinition.getIngestAggregator()"})
  void testGetIngestAggregator_givenSchemaEdgeDefinition() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();

    // Act
    ElementAggregator actualIngestAggregator = schemaEdgeDefinition.getIngestAggregator();

    // Assert
    Collection<IdentifierType> identifiers = schemaEdgeDefinition.getIdentifiers();
    assertTrue(identifiers instanceof Set);
    assertTrue(identifiers.isEmpty());
    assertTrue(actualIngestAggregator.getComponents().isEmpty());
    ElementAggregator elementAggregator = schemaEdgeDefinition.ingestAggregatorCache;
    assertEquals(elementAggregator, schemaEdgeDefinition.getFullAggregator());
    assertSame(elementAggregator, actualIngestAggregator);
  }

  /**
   * Test {@link SchemaElementDefinition#getIngestAggregator()}.
   *
   * <ul>
   *   <li>Given {@link SchemaEdgeDefinition} (default constructor) Aggregate is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#getIngestAggregator()}
   */
  @Test
  @DisplayName(
      "Test getIngestAggregator(); given SchemaEdgeDefinition (default constructor) Aggregate is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementAggregator SchemaElementDefinition.getIngestAggregator()"})
  void testGetIngestAggregator_givenSchemaEdgeDefinitionAggregateIsFalse() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();
    schemaEdgeDefinition.setAggregate(false);

    // Act
    ElementAggregator actualIngestAggregator = schemaEdgeDefinition.getIngestAggregator();

    // Assert
    Collection<IdentifierType> identifiers = schemaEdgeDefinition.getIdentifiers();
    assertTrue(identifiers instanceof Set);
    assertTrue(identifiers.isEmpty());
    assertTrue(actualIngestAggregator.getComponents().isEmpty());
    ElementAggregator elementAggregator = schemaEdgeDefinition.ingestAggregatorCache;
    assertEquals(elementAggregator, schemaEdgeDefinition.getFullAggregator());
    assertSame(elementAggregator, actualIngestAggregator);
  }

  /**
   * Test {@link SchemaElementDefinition#getQueryAggregator(Set, ElementAggregator)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#getQueryAggregator(Set,
   * ElementAggregator)}
   */
  @Test
  @DisplayName(
      "Test getQueryAggregator(Set, ElementAggregator); given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ElementAggregator SchemaElementDefinition.getQueryAggregator(Set, ElementAggregator)"
  })
  void testGetQueryAggregator_given42_whenHashSetAdd42() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();

    HashSet<String> viewGroupBy = new HashSet<>();
    viewGroupBy.add("42");
    viewGroupBy.add("foo");
    ElementAggregator viewAggregator = new ElementAggregator();

    // Act
    ElementAggregator actualQueryAggregator =
        schemaEdgeDefinition.getQueryAggregator(viewGroupBy, viewAggregator);

    // Assert
    assertTrue(schemaEdgeDefinition.queryAggregatorCacheMap.isEmpty());
    assertEquals(viewAggregator, actualQueryAggregator);
  }

  /**
   * Test {@link SchemaElementDefinition#getQueryAggregator(Set, ElementAggregator)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#getQueryAggregator(Set,
   * ElementAggregator)}
   */
  @Test
  @DisplayName(
      "Test getQueryAggregator(Set, ElementAggregator); given 'foo'; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ElementAggregator SchemaElementDefinition.getQueryAggregator(Set, ElementAggregator)"
  })
  void testGetQueryAggregator_givenFoo_whenHashSetAddFoo() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();

    HashSet<String> viewGroupBy = new HashSet<>();
    viewGroupBy.add("foo");
    ElementAggregator viewAggregator = new ElementAggregator();

    // Act
    ElementAggregator actualQueryAggregator =
        schemaEdgeDefinition.getQueryAggregator(viewGroupBy, viewAggregator);

    // Assert
    assertTrue(schemaEdgeDefinition.queryAggregatorCacheMap.isEmpty());
    assertEquals(viewAggregator, actualQueryAggregator);
  }

  /**
   * Test {@link SchemaElementDefinition#getQueryAggregator(Set, ElementAggregator)}.
   *
   * <ul>
   *   <li>Given {@link SchemaEdgeDefinition} (default constructor) Aggregate is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#getQueryAggregator(Set,
   * ElementAggregator)}
   */
  @Test
  @DisplayName(
      "Test getQueryAggregator(Set, ElementAggregator); given SchemaEdgeDefinition (default constructor) Aggregate is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ElementAggregator SchemaElementDefinition.getQueryAggregator(Set, ElementAggregator)"
  })
  void testGetQueryAggregator_givenSchemaEdgeDefinitionAggregateIsFalse() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();
    schemaEdgeDefinition.setAggregate(false);
    HashSet<String> viewGroupBy = new HashSet<>();
    ElementAggregator viewAggregator = new ElementAggregator();

    // Act
    ElementAggregator actualQueryAggregator =
        schemaEdgeDefinition.getQueryAggregator(viewGroupBy, viewAggregator);

    // Assert
    assertTrue(schemaEdgeDefinition.queryAggregatorCacheMap.isEmpty());
    assertEquals(viewAggregator, actualQueryAggregator);
  }

  /**
   * Test {@link SchemaElementDefinition#getQueryAggregator(Set, ElementAggregator)}.
   *
   * <ul>
   *   <li>Then return Components is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#getQueryAggregator(Set,
   * ElementAggregator)}
   */
  @Test
  @DisplayName(
      "Test getQueryAggregator(Set, ElementAggregator); then return Components is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ElementAggregator SchemaElementDefinition.getQueryAggregator(Set, ElementAggregator)"
  })
  void testGetQueryAggregator_thenReturnComponentsIsArrayList() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();
    HashSet<String> viewGroupBy = new HashSet<>();

    ArrayList<TupleAdaptedBinaryOperator<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedBinaryOperator<>());

    ElementAggregator viewAggregator = new ElementAggregator();
    viewAggregator.setComponents(components);

    // Act and Assert
    assertEquals(
        components,
        schemaEdgeDefinition.getQueryAggregator(viewGroupBy, viewAggregator).getComponents());
  }

  /**
   * Test {@link SchemaElementDefinition#getQueryAggregator(Set, ElementAggregator)}.
   *
   * <ul>
   *   <li>Then {@link SchemaEdgeDefinition} (default constructor) {@link
   *       SchemaElementDefinition#queryAggregatorCacheMap} Empty.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#getQueryAggregator(Set,
   * ElementAggregator)}
   */
  @Test
  @DisplayName(
      "Test getQueryAggregator(Set, ElementAggregator); then SchemaEdgeDefinition (default constructor) queryAggregatorCacheMap Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ElementAggregator SchemaElementDefinition.getQueryAggregator(Set, ElementAggregator)"
  })
  void testGetQueryAggregator_thenSchemaEdgeDefinitionQueryAggregatorCacheMapEmpty() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();
    HashSet<String> viewGroupBy = new HashSet<>();
    ElementAggregator viewAggregator = new ElementAggregator();

    // Act
    ElementAggregator actualQueryAggregator =
        schemaEdgeDefinition.getQueryAggregator(viewGroupBy, viewAggregator);

    // Assert
    assertTrue(schemaEdgeDefinition.queryAggregatorCacheMap.isEmpty());
    assertEquals(viewAggregator, actualQueryAggregator);
  }

  /**
   * Test {@link SchemaElementDefinition#getQueryAggregator(Set, ElementAggregator)}.
   *
   * <ul>
   *   <li>Then {@link SchemaEdgeDefinition} (default constructor) {@link
   *       SchemaElementDefinition#queryAggregatorCacheMap} size is one.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#getQueryAggregator(Set,
   * ElementAggregator)}
   */
  @Test
  @DisplayName(
      "Test getQueryAggregator(Set, ElementAggregator); then SchemaEdgeDefinition (default constructor) queryAggregatorCacheMap size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ElementAggregator SchemaElementDefinition.getQueryAggregator(Set, ElementAggregator)"
  })
  void testGetQueryAggregator_thenSchemaEdgeDefinitionQueryAggregatorCacheMapSizeIsOne() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();

    // Act
    ElementAggregator actualQueryAggregator =
        schemaEdgeDefinition.getQueryAggregator(new HashSet<>(), null);

    // Assert
    assertEquals(1, schemaEdgeDefinition.queryAggregatorCacheMap.size());
    assertTrue(actualQueryAggregator.getComponents().isEmpty());
  }

  /**
   * Test {@link SchemaElementDefinition#getValidator()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getValidator()}
   */
  @Test
  @DisplayName("Test getValidator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementFilter SchemaElementDefinition.getValidator()"})
  void testGetValidator() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();

    // Act
    ElementFilter actualValidator = schemaEdgeDefinition.getValidator();

    // Assert
    assertTrue(actualValidator.getComponents().isEmpty());
    assertSame(schemaEdgeDefinition.fullValidatorWithIsACache, actualValidator);
  }

  /**
   * Test {@link SchemaElementDefinition#getValidator(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getValidator(boolean)}
   */
  @Test
  @DisplayName("Test getValidator(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementFilter SchemaElementDefinition.getValidator(boolean)"})
  void testGetValidatorWithBoolean() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();

    // Act
    ElementFilter actualValidator = schemaEdgeDefinition.getValidator(true);

    // Assert
    assertTrue(actualValidator.getComponents().isEmpty());
    assertTrue(schemaEdgeDefinition.fullValidatorWithIsACache.getComponents().isEmpty());
    ElementFilter elementFilter = schemaEdgeDefinition.fullValidatorWithIsACache;
    assertSame(elementFilter, schemaEdgeDefinition.getValidator());
    assertSame(elementFilter, actualValidator);
  }

  /**
   * Test {@link SchemaElementDefinition#getValidator(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getValidator(boolean)}
   */
  @Test
  @DisplayName("Test getValidator(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementFilter SchemaElementDefinition.getValidator(boolean)"})
  void testGetValidatorWithBoolean2() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();

    // Act
    ElementFilter actualValidator = schemaEdgeDefinition.getValidator(false);

    // Assert
    assertTrue(actualValidator.getComponents().isEmpty());
    assertTrue(schemaEdgeDefinition.fullValidatorCache.getComponents().isEmpty());
    ElementFilter elementFilter = schemaEdgeDefinition.fullValidatorCache;
    assertEquals(elementFilter, schemaEdgeDefinition.getValidator());
    assertSame(elementFilter, actualValidator);
  }

  /**
   * Test {@link SchemaElementDefinition#getOriginalValidator()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getOriginalValidator()}
   */
  @Test
  @DisplayName("Test getOriginalValidator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementFilter SchemaElementDefinition.getOriginalValidator()"})
  void testGetOriginalValidator() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getOriginalValidator());
  }

  /**
   * Test {@link SchemaElementDefinition#hasValidation()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#hasValidation()}
   */
  @Test
  @DisplayName("Test hasValidation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SchemaElementDefinition.hasValidation()"})
  void testHasValidation() {
    // Arrange, Act and Assert
    assertFalse(new SchemaEdgeDefinition().hasValidation());
  }

  /**
   * Test {@link SchemaElementDefinition#getOriginalValidateFunctions()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getOriginalValidateFunctions()}
   */
  @Test
  @DisplayName("Test getOriginalValidateFunctions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.koryphe.tuple.predicate.TupleAdaptedPredicate[] SchemaElementDefinition.getOriginalValidateFunctions()"
  })
  void testGetOriginalValidateFunctions() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getOriginalValidateFunctions());
  }

  /**
   * Test {@link SchemaElementDefinition#getPropertyTypeDefs()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getPropertyTypeDefs()}
   */
  @Test
  @DisplayName("Test getPropertyTypeDefs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SchemaElementDefinition.getPropertyTypeDefs()"})
  void testGetPropertyTypeDefs() {
    // Arrange and Act
    Iterable<TypeDefinition> actualPropertyTypeDefs =
        new SchemaEdgeDefinition().getPropertyTypeDefs();
    Iterator<TypeDefinition> actualIteratorResult = actualPropertyTypeDefs.iterator();

    // Assert
    assertEquals(-1L, actualPropertyTypeDefs.spliterator().getExactSizeIfKnown());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link SchemaElementDefinition#getPropertyTypeDef(String)}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getPropertyTypeDef(String)}
   */
  @Test
  @DisplayName("Test getPropertyTypeDef(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeDefinition SchemaElementDefinition.getPropertyTypeDef(String)"})
  void testGetPropertyTypeDef() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getPropertyTypeDef("Property"));
  }

  /**
   * Test {@link SchemaElementDefinition#getPropertyClass(String)}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getPropertyClass(String)}
   */
  @Test
  @DisplayName("Test getPropertyClass(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Class SchemaElementDefinition.getPropertyClass(String)"})
  void testGetPropertyClass() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getPropertyClass("Property Name"));
  }

  /**
   * Test {@link SchemaElementDefinition#getIdentifierClass(IdentifierType)}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getIdentifierClass(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifierClass(IdentifierType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Class SchemaElementDefinition.getIdentifierClass(IdentifierType)"})
  void testGetIdentifierClass() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getIdentifierClass(IdentifierType.VERTEX));
  }

  /**
   * Test {@link SchemaElementDefinition#getGroupBy()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getGroupBy()}
   */
  @Test
  @DisplayName("Test getGroupBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SchemaElementDefinition.getGroupBy()"})
  void testGetGroupBy() {
    // Arrange, Act and Assert
    assertTrue(new SchemaEdgeDefinition().getGroupBy().isEmpty());
  }

  /**
   * Test {@link SchemaElementDefinition#getParents()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getParents()}
   */
  @Test
  @DisplayName("Test getParents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SchemaElementDefinition.getParents()"})
  void testGetParents() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getParents());
  }

  /**
   * Test {@link SchemaElementDefinition#getParentsOrNull()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getParentsOrNull()}
   */
  @Test
  @DisplayName("Test getParentsOrNull()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SchemaElementDefinition.getParentsOrNull()"})
  void testGetParentsOrNull() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getParentsOrNull());
  }

  /**
   * Test {@link SchemaElementDefinition#getDescription()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaElementDefinition.getDescription()"})
  void testGetDescription() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getDescription());
  }

  /**
   * Test {@link SchemaElementDefinition#getSchemaReference()}.
   *
   * <p>Method under test: {@link SchemaElementDefinition#getSchemaReference()}
   */
  @Test
  @DisplayName("Test getSchemaReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema SchemaElementDefinition.getSchemaReference()"})
  void testGetSchemaReference() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();

    // Act
    Schema actualSchemaReference = schemaEdgeDefinition.getSchemaReference();

    // Assert
    assertSame(schemaEdgeDefinition.schemaReference, actualSchemaReference);
  }

  /**
   * Test {@link SchemaElementDefinition#equals(Object)}, and {@link
   * SchemaElementDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SchemaElementDefinition#equals(Object)}
   *   <li>{@link SchemaElementDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SchemaElementDefinition.equals(Object)",
    "int SchemaElementDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();
    SchemaEdgeDefinition schemaEdgeDefinition2 = new SchemaEdgeDefinition();

    // Act and Assert
    assertEquals(schemaEdgeDefinition, schemaEdgeDefinition2);
    assertNotEquals(schemaEdgeDefinition.hashCode(), schemaEdgeDefinition2.hashCode());
  }

  /**
   * Test {@link SchemaElementDefinition#equals(Object)}, and {@link
   * SchemaElementDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SchemaElementDefinition#equals(Object)}
   *   <li>{@link SchemaElementDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SchemaElementDefinition.equals(Object)",
    "int SchemaElementDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();

    // Act and Assert
    assertEquals(schemaEdgeDefinition, schemaEdgeDefinition);
    int expectedHashCodeResult = schemaEdgeDefinition.hashCode();
    assertEquals(expectedHashCodeResult, schemaEdgeDefinition.hashCode());
  }

  /**
   * Test {@link SchemaElementDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SchemaElementDefinition.equals(Object)",
    "int SchemaElementDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SchemaEdgeDefinition(), 1);
  }

  /**
   * Test {@link SchemaElementDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SchemaElementDefinition.equals(Object)",
    "int SchemaElementDefinition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SchemaEdgeDefinition(), null);
  }

  /**
   * Test {@link SchemaElementDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SchemaElementDefinition.equals(Object)",
    "int SchemaElementDefinition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SchemaEdgeDefinition(), "Different type to SchemaElementDefinition");
  }

  /**
   * Test {@link SchemaElementDefinition#isAggregate()}.
   *
   * <ul>
   *   <li>Given {@link SchemaEdgeDefinition} (default constructor) Aggregate is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#isAggregate()}
   */
  @Test
  @DisplayName(
      "Test isAggregate(); given SchemaEdgeDefinition (default constructor) Aggregate is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SchemaElementDefinition.isAggregate()"})
  void testIsAggregate_givenSchemaEdgeDefinitionAggregateIsFalse_thenReturnFalse() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = new SchemaEdgeDefinition();
    schemaEdgeDefinition.setAggregate(false);

    // Act and Assert
    assertFalse(schemaEdgeDefinition.isAggregate());
  }

  /**
   * Test {@link SchemaElementDefinition#isAggregate()}.
   *
   * <ul>
   *   <li>Given {@link SchemaEdgeDefinition} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaElementDefinition#isAggregate()}
   */
  @Test
  @DisplayName(
      "Test isAggregate(); given SchemaEdgeDefinition (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SchemaElementDefinition.isAggregate()"})
  void testIsAggregate_givenSchemaEdgeDefinition_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new SchemaEdgeDefinition().isAggregate());
  }
}
