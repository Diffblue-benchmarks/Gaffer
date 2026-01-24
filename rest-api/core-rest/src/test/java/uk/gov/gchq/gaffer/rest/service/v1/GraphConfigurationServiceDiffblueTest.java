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

package uk.gov.gchq.gaffer.rest.service.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.predicate.user.DefaultUserPredicate;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.data.element.function.PropertiesFilter;
import uk.gov.gchq.gaffer.data.generator.CsvGenerator;
import uk.gov.gchq.gaffer.data.generator.JsonToElementGenerator;
import uk.gov.gchq.gaffer.data.generator.MapGenerator;
import uk.gov.gchq.gaffer.data.generator.Neo4jCsvElementGenerator;
import uk.gov.gchq.gaffer.data.generator.Neo4jCsvGenerator;
import uk.gov.gchq.gaffer.data.generator.NeptuneCsvElementGenerator;
import uk.gov.gchq.gaffer.data.generator.NeptuneCsvGenerator;
import uk.gov.gchq.gaffer.operation.data.generator.EdgeIdExtractor;
import uk.gov.gchq.gaffer.operation.data.generator.EntityIdExtractor;
import uk.gov.gchq.gaffer.operation.function.ToElementId;
import uk.gov.gchq.gaffer.rest.example.ExampleDomainObjectGenerator;
import uk.gov.gchq.gaffer.rest.example.ExampleElementGenerator;
import uk.gov.gchq.gaffer.rest.example.ExampleFilterFunction;
import uk.gov.gchq.gaffer.rest.example.ExampleTransformFunction;
import uk.gov.gchq.gaffer.sketches.clearspring.cardinality.HyperLogLogPlusEntityGenerator;
import uk.gov.gchq.gaffer.sketches.datasketches.cardinality.HllSketchEntityGenerator;
import uk.gov.gchq.koryphe.impl.function.CreateObject;
import uk.gov.gchq.koryphe.impl.function.DefaultIfEmpty;
import uk.gov.gchq.koryphe.impl.function.ExtractValue;
import uk.gov.gchq.koryphe.impl.function.Identity;
import uk.gov.gchq.koryphe.impl.function.Size;
import uk.gov.gchq.koryphe.impl.function.ToArray;
import uk.gov.gchq.koryphe.impl.function.ToNull;
import uk.gov.gchq.koryphe.impl.predicate.AgeOff;
import uk.gov.gchq.koryphe.impl.predicate.And;
import uk.gov.gchq.koryphe.impl.predicate.If;
import uk.gov.gchq.koryphe.impl.predicate.IsFalse;
import uk.gov.gchq.koryphe.impl.predicate.IsShorterThan;
import uk.gov.gchq.koryphe.impl.predicate.IsXMoreThanY;
import uk.gov.gchq.koryphe.impl.predicate.MapContains;
import uk.gov.gchq.koryphe.impl.predicate.MapContainsPredicate;
import uk.gov.gchq.koryphe.impl.predicate.MultiRegex;
import uk.gov.gchq.koryphe.impl.predicate.Not;
import uk.gov.gchq.koryphe.impl.predicate.range.InRange;
import uk.gov.gchq.koryphe.impl.predicate.range.InRangeDual;
import uk.gov.gchq.koryphe.predicate.AdaptedPredicate;
import uk.gov.gchq.koryphe.predicate.PredicateComposite;
import uk.gov.gchq.koryphe.tuple.TupleInputAdapter;
import uk.gov.gchq.koryphe.tuple.predicate.TupleAdaptedPredicateComposite;

class GraphConfigurationServiceDiffblueTest {
  /**
   * Test new {@link GraphConfigurationService} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link GraphConfigurationService}
   */
  @Test
  @DisplayName("Test new GraphConfigurationService (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfigurationService.<init>()"})
  void testNewGraphConfigurationService() {
    // Arrange and Act
    GraphConfigurationService actualGraphConfigurationService = new GraphConfigurationService();

    // Assert
    assertEquals(128, actualGraphConfigurationService.getTransformFunctions().size());
    assertEquals(50, actualGraphConfigurationService.getFilterFunctions().size());
    assertEquals(6, actualGraphConfigurationService.getElementGenerators().size());
    assertEquals(7, actualGraphConfigurationService.getObjectGenerators().size());
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getFilterFunctions()}
   */
  @Test
  @DisplayName("Test getFilterFunctions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions()"})
  void testGetFilterFunctions() {
    // Arrange and Act
    Set<Class> actualFilterFunctions = new GraphConfigurationService().getFilterFunctions();

    // Assert
    assertEquals(50, actualFilterFunctions.size());
    assertTrue(actualFilterFunctions.contains(PropertiesFilter.class));
    assertTrue(actualFilterFunctions.contains(AgeOff.class));
    assertTrue(actualFilterFunctions.contains(If.class));
    assertTrue(actualFilterFunctions.contains(IsFalse.class));
    assertTrue(actualFilterFunctions.contains(IsXMoreThanY.class));
    assertTrue(actualFilterFunctions.contains(MapContains.class));
    assertTrue(actualFilterFunctions.contains(MapContainsPredicate.class));
    assertTrue(actualFilterFunctions.contains(MultiRegex.class));
    assertTrue(actualFilterFunctions.contains(InRange.class));
    assertTrue(actualFilterFunctions.contains(InRangeDual.class));
    assertTrue(actualFilterFunctions.contains(PredicateComposite.class));
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return size is twenty-one.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'; then return size is twenty-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_thenReturnSizeIsTwentyOne() {
    // Arrange and Act
    Set<Class> actualFilterFunctions =
        new GraphConfigurationService()
            .getFilterFunctions("com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition");

    // Assert
    assertEquals(21, actualFilterFunctions.size());
    assertTrue(actualFilterFunctions.contains(DefaultUserPredicate.class));
    assertTrue(actualFilterFunctions.contains(ElementFilter.class));
    assertTrue(actualFilterFunctions.contains(PropertiesFilter.class));
    assertTrue(actualFilterFunctions.contains(ExampleFilterFunction.class));
    assertTrue(actualFilterFunctions.contains(And.class));
    assertTrue(actualFilterFunctions.contains(If.class));
    assertTrue(actualFilterFunctions.contains(IsShorterThan.class));
    assertTrue(actualFilterFunctions.contains(Not.class));
    assertTrue(actualFilterFunctions.contains(AdaptedPredicate.class));
    assertTrue(actualFilterFunctions.contains(PredicateComposite.class));
    assertTrue(actualFilterFunctions.contains(TupleAdaptedPredicateComposite.class));
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName(
      "Test getFilterFunctions(String) with 'String'; when '.'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getFilterFunctions("."));
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return size is fifty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName(
      "Test getFilterFunctions(String) with 'String'; when empty string; then return size is fifty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_whenEmptyString_thenReturnSizeIsFifty() {
    // Arrange and Act
    Set<Class> actualFilterFunctions = new GraphConfigurationService().getFilterFunctions("");

    // Assert
    assertEquals(50, actualFilterFunctions.size());
    assertTrue(actualFilterFunctions.contains(PropertiesFilter.class));
    assertTrue(actualFilterFunctions.contains(AgeOff.class));
    assertTrue(actualFilterFunctions.contains(If.class));
    assertTrue(actualFilterFunctions.contains(IsFalse.class));
    assertTrue(actualFilterFunctions.contains(IsXMoreThanY.class));
    assertTrue(actualFilterFunctions.contains(MapContains.class));
    assertTrue(actualFilterFunctions.contains(MapContainsPredicate.class));
    assertTrue(actualFilterFunctions.contains(MultiRegex.class));
    assertTrue(actualFilterFunctions.contains(InRange.class));
    assertTrue(actualFilterFunctions.contains(InRangeDual.class));
    assertTrue(actualFilterFunctions.contains(PredicateComposite.class));
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Input Class}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'; when 'Input Class'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_whenInputClass() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getFilterFunctions("Input Class"));
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'; when '[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getFilterFunctions("[]"));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>Then return size is twenty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); then return size is twenty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_thenReturnSizeIsTwenty() {
    // Arrange and Act
    Set<String> actualSerialisedFields =
        new GraphConfigurationService()
            .getSerialisedFields(
                "com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition");

    // Assert
    assertEquals(20, actualSerialisedFields.size());
    assertTrue(actualSerialisedFields.contains("accessor"));
    assertTrue(actualSerialisedFields.contains("field"));
    assertTrue(actualSerialisedFields.contains("fullName"));
    assertTrue(actualSerialisedFields.contains("getter"));
    assertTrue(actualSerialisedFields.contains("internalName"));
    assertTrue(actualSerialisedFields.contains("metadata"));
    assertTrue(actualSerialisedFields.contains("nonConstructorMutator"));
    assertTrue(actualSerialisedFields.contains("primaryMember"));
    assertTrue(actualSerialisedFields.contains("rawPrimaryType"));
    assertTrue(actualSerialisedFields.contains("required"));
    assertTrue(actualSerialisedFields.contains("wrapperName"));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFields(String); when 'Class Name'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenClassName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getSerialisedFields("Class Name"));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when '.'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getSerialisedFields("."));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code java.util.function.Predicate}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFields(String); when 'java.util.function.Predicate'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenJavaUtilFunctionPredicate_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new GraphConfigurationService()
            .getSerialisedFields("java.util.function.Predicate")
            .isEmpty());
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code Set}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when 'java.util.Set'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenJavaUtilSet_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new GraphConfigurationService().getSerialisedFields("java.util.Set").isEmpty());
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when '[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getSerialisedFields("[]"));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code uk.gov.gchq.koryphe.signature.Signature$UnknownGenericType}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFields(String); when 'uk.gov.gchq.koryphe.signature.Signature$UnknownGenericType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenUkGovGchqKorypheSignatureSignatureUnknownGenericType() {
    // Arrange, Act and Assert
    assertTrue(
        new GraphConfigurationService()
            .getSerialisedFields("uk.gov.gchq.koryphe.signature.Signature$UnknownGenericType")
            .isEmpty());
  }

  /**
   * Test {@link GraphConfigurationService#getTransformFunctions()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getTransformFunctions()}
   */
  @Test
  @DisplayName("Test getTransformFunctions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getTransformFunctions()"})
  void testGetTransformFunctions() {
    // Arrange and Act
    Set<Class> actualTransformFunctions = new GraphConfigurationService().getTransformFunctions();

    // Assert
    assertEquals(128, actualTransformFunctions.size());
    assertTrue(actualTransformFunctions.contains(ToElementId.class));
    assertTrue(actualTransformFunctions.contains(ExampleElementGenerator.class));
    assertTrue(actualTransformFunctions.contains(ExampleTransformFunction.class));
    assertTrue(actualTransformFunctions.contains(CreateObject.class));
    assertTrue(actualTransformFunctions.contains(DefaultIfEmpty.class));
    assertTrue(actualTransformFunctions.contains(ExtractValue.class));
    assertTrue(actualTransformFunctions.contains(Identity.class));
    assertTrue(actualTransformFunctions.contains(Size.class));
    assertTrue(actualTransformFunctions.contains(ToArray.class));
    assertTrue(actualTransformFunctions.contains(ToNull.class));
    assertTrue(actualTransformFunctions.contains(TupleInputAdapter.class));
  }

  /**
   * Test {@link GraphConfigurationService#getNextOperations(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getNextOperations(String)}
   */
  @Test
  @DisplayName("Test getNextOperations(String); when '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getNextOperations(String)"})
  void testGetNextOperations_whenDot() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getNextOperations("."));
  }

  /**
   * Test {@link GraphConfigurationService#getNextOperations(String)}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getNextOperations(String)}
   */
  @Test
  @DisplayName("Test getNextOperations(String); when '[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getNextOperations(String)"})
  void testGetNextOperations_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getNextOperations("[]"));
  }

  /**
   * Test {@link GraphConfigurationService#getNextOperations(String)}.
   *
   * <ul>
   *   <li>When {@code Operation Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getNextOperations(String)}
   */
  @Test
  @DisplayName("Test getNextOperations(String); when 'Operation Class Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getNextOperations(String)"})
  void testGetNextOperations_whenOperationClassName() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getNextOperations("Operation Class Name"));
  }

  /**
   * Test {@link GraphConfigurationService#getElementGenerators()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getElementGenerators()}
   */
  @Test
  @DisplayName("Test getElementGenerators()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getElementGenerators()"})
  void testGetElementGenerators() {
    // Arrange and Act
    Set<Class> actualElementGenerators = new GraphConfigurationService().getElementGenerators();

    // Assert
    assertEquals(6, actualElementGenerators.size());
    assertTrue(actualElementGenerators.contains(JsonToElementGenerator.class));
    assertTrue(actualElementGenerators.contains(Neo4jCsvElementGenerator.class));
    assertTrue(actualElementGenerators.contains(NeptuneCsvElementGenerator.class));
    assertTrue(actualElementGenerators.contains(ExampleElementGenerator.class));
    assertTrue(actualElementGenerators.contains(HyperLogLogPlusEntityGenerator.class));
    assertTrue(actualElementGenerators.contains(HllSketchEntityGenerator.class));
  }

  /**
   * Test {@link GraphConfigurationService#getObjectGenerators()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getObjectGenerators()}
   */
  @Test
  @DisplayName("Test getObjectGenerators()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getObjectGenerators()"})
  void testGetObjectGenerators() {
    // Arrange and Act
    Set<Class> actualObjectGenerators = new GraphConfigurationService().getObjectGenerators();

    // Assert
    assertEquals(7, actualObjectGenerators.size());
    assertTrue(actualObjectGenerators.contains(CsvGenerator.class));
    assertTrue(actualObjectGenerators.contains(MapGenerator.class));
    assertTrue(actualObjectGenerators.contains(Neo4jCsvGenerator.class));
    assertTrue(actualObjectGenerators.contains(NeptuneCsvGenerator.class));
    assertTrue(actualObjectGenerators.contains(EdgeIdExtractor.class));
    assertTrue(actualObjectGenerators.contains(EntityIdExtractor.class));
    assertTrue(actualObjectGenerators.contains(ExampleDomainObjectGenerator.class));
  }
}
