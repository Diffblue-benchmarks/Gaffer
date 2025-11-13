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

package uk.gov.gchq.gaffer.federated.simple.merge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.federated.simple.merge.operator.ElementAggregateOperator;
import uk.gov.gchq.koryphe.binaryoperator.BinaryOperatorMap;
import uk.gov.gchq.koryphe.impl.binaryoperator.And;
import uk.gov.gchq.koryphe.impl.binaryoperator.CollectionConcat;
import uk.gov.gchq.koryphe.impl.binaryoperator.Last;
import uk.gov.gchq.koryphe.impl.binaryoperator.StringConcat;
import uk.gov.gchq.koryphe.impl.binaryoperator.Sum;

class DefaultResultAccumulatorDiffblueTest {
  /**
   * Test {@link DefaultResultAccumulator#DefaultResultAccumulator()}.
   *
   * <p>Method under test: {@link DefaultResultAccumulator#DefaultResultAccumulator()}
   */
  @Test
  @DisplayName("Test new DefaultResultAccumulator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultResultAccumulator.<init>()"})
  void testNewDefaultResultAccumulator() {
    // Arrange and Act
    DefaultResultAccumulator<Object> actualDefaultResultAccumulator =
        new DefaultResultAccumulator<>();

    // Assert
    assertTrue(
        actualDefaultResultAccumulator.elementAggregateOperator
            instanceof ElementAggregateOperator);
    BinaryOperator<Map<Object, Object>> binaryOperator =
        actualDefaultResultAccumulator.mapMergeOperator;
    assertTrue(binaryOperator instanceof BinaryOperatorMap);
    assertTrue(actualDefaultResultAccumulator.booleanMergeOperator instanceof And);
    assertTrue(actualDefaultResultAccumulator.collectionMergeOperator instanceof CollectionConcat);
    assertTrue(actualDefaultResultAccumulator.mapValueMergeOperator instanceof Last);
    BinaryOperator<String> binaryOperator2 = actualDefaultResultAccumulator.stringMergeOperator;
    assertTrue(binaryOperator2 instanceof StringConcat);
    assertTrue(actualDefaultResultAccumulator.numberMergeOperator instanceof Sum);
    assertEquals(",", ((StringConcat) binaryOperator2).getSeparator());
    assertFalse(actualDefaultResultAccumulator.aggregateElements());
    assertFalse(actualDefaultResultAccumulator.aggregateElements);
    assertSame(
        actualDefaultResultAccumulator.mapValueMergeOperator,
        ((BinaryOperatorMap<Object, Object>) binaryOperator).getBinaryOperator());
  }

  /**
   * Test {@link DefaultResultAccumulator#DefaultResultAccumulator(Properties)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultResultAccumulator#DefaultResultAccumulator(Properties)}
   */
  @Test
  @DisplayName("Test new DefaultResultAccumulator(Properties); given one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultResultAccumulator.<init>(Properties)"})
  void testNewDefaultResultAccumulator_givenOne() {
    // Arrange
    Properties properties = new Properties();
    properties.put("gaffer.store.federated.merge.number.class", 1);
    properties.put(",", "Properties");
    properties.put("gaffer.store.federated.merge.string.class", "Properties");
    properties.put("gaffer.store.federated.merge.boolean.class", "Properties");
    properties.put("gaffer.store.federated.merge.collection.class", "Properties");
    properties.put("gaffer.store.federated.merge.elements.class", "Properties");
    properties.put("gaffer.store.federated.merge.map.class", "Properties");

    // Act
    DefaultResultAccumulator<Object> actualDefaultResultAccumulator =
        new DefaultResultAccumulator<>(properties);

    // Assert
    assertTrue(
        actualDefaultResultAccumulator.elementAggregateOperator
            instanceof ElementAggregateOperator);
    BinaryOperator<Map<Object, Object>> binaryOperator =
        actualDefaultResultAccumulator.mapMergeOperator;
    assertTrue(binaryOperator instanceof BinaryOperatorMap);
    assertTrue(actualDefaultResultAccumulator.booleanMergeOperator instanceof And);
    assertTrue(actualDefaultResultAccumulator.collectionMergeOperator instanceof CollectionConcat);
    assertTrue(actualDefaultResultAccumulator.mapValueMergeOperator instanceof Last);
    BinaryOperator<String> binaryOperator2 = actualDefaultResultAccumulator.stringMergeOperator;
    assertTrue(binaryOperator2 instanceof StringConcat);
    assertTrue(actualDefaultResultAccumulator.numberMergeOperator instanceof Sum);
    assertEquals(",", ((StringConcat) binaryOperator2).getSeparator());
    assertFalse(actualDefaultResultAccumulator.aggregateElements());
    assertFalse(actualDefaultResultAccumulator.aggregateElements);
    assertSame(
        actualDefaultResultAccumulator.mapValueMergeOperator,
        ((BinaryOperatorMap<Object, Object>) binaryOperator).getBinaryOperator());
  }

  /**
   * Test {@link DefaultResultAccumulator#DefaultResultAccumulator(Properties)}.
   *
   * <ul>
   *   <li>Then return aggregateElements.
   * </ul>
   *
   * <p>Method under test: {@link DefaultResultAccumulator#DefaultResultAccumulator(Properties)}
   */
  @Test
  @DisplayName("Test new DefaultResultAccumulator(Properties); then return aggregateElements")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultResultAccumulator.<init>(Properties)"})
  void testNewDefaultResultAccumulator_thenReturnAggregateElements() {
    // Arrange
    Properties properties = new Properties();
    properties.put("gaffer.store.federated.default.aggregateElements", Boolean.TRUE.toString());
    properties.put("gaffer.store.federated.merge.number.class", "Properties");
    properties.put("gaffer.store.federated.merge.string.class", "Properties");
    properties.put("gaffer.store.federated.merge.boolean.class", "Properties");
    properties.put("gaffer.store.federated.merge.collection.class", "Properties");
    properties.put("gaffer.store.federated.merge.elements.class", "Properties");
    properties.put("gaffer.store.federated.merge.map.class", "Properties");

    // Act
    DefaultResultAccumulator<Object> actualDefaultResultAccumulator =
        new DefaultResultAccumulator<>(properties);

    // Assert
    assertTrue(
        actualDefaultResultAccumulator.elementAggregateOperator
            instanceof ElementAggregateOperator);
    BinaryOperator<Map<Object, Object>> binaryOperator =
        actualDefaultResultAccumulator.mapMergeOperator;
    assertTrue(binaryOperator instanceof BinaryOperatorMap);
    assertTrue(actualDefaultResultAccumulator.booleanMergeOperator instanceof And);
    assertTrue(actualDefaultResultAccumulator.collectionMergeOperator instanceof CollectionConcat);
    assertTrue(actualDefaultResultAccumulator.mapValueMergeOperator instanceof Last);
    BinaryOperator<String> binaryOperator2 = actualDefaultResultAccumulator.stringMergeOperator;
    assertTrue(binaryOperator2 instanceof StringConcat);
    assertTrue(actualDefaultResultAccumulator.numberMergeOperator instanceof Sum);
    assertEquals(",", ((StringConcat) binaryOperator2).getSeparator());
    assertTrue(actualDefaultResultAccumulator.aggregateElements());
    assertTrue(actualDefaultResultAccumulator.aggregateElements);
    assertSame(
        actualDefaultResultAccumulator.mapValueMergeOperator,
        ((BinaryOperatorMap<Object, Object>) binaryOperator).getBinaryOperator());
  }

  /**
   * Test {@link DefaultResultAccumulator#DefaultResultAccumulator(Properties)}.
   *
   * <ul>
   *   <li>When {@link Properties#Properties()}.
   *   <li>Then return not aggregateElements.
   * </ul>
   *
   * <p>Method under test: {@link DefaultResultAccumulator#DefaultResultAccumulator(Properties)}
   */
  @Test
  @DisplayName(
      "Test new DefaultResultAccumulator(Properties); when Properties(); then return not aggregateElements")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultResultAccumulator.<init>(Properties)"})
  void testNewDefaultResultAccumulator_whenProperties_thenReturnNotAggregateElements() {
    // Arrange and Act
    DefaultResultAccumulator<Object> actualDefaultResultAccumulator =
        new DefaultResultAccumulator<>(new Properties());

    // Assert
    assertTrue(
        actualDefaultResultAccumulator.elementAggregateOperator
            instanceof ElementAggregateOperator);
    BinaryOperator<Map<Object, Object>> binaryOperator =
        actualDefaultResultAccumulator.mapMergeOperator;
    assertTrue(binaryOperator instanceof BinaryOperatorMap);
    assertTrue(actualDefaultResultAccumulator.booleanMergeOperator instanceof And);
    assertTrue(actualDefaultResultAccumulator.collectionMergeOperator instanceof CollectionConcat);
    assertTrue(actualDefaultResultAccumulator.mapValueMergeOperator instanceof Last);
    BinaryOperator<String> binaryOperator2 = actualDefaultResultAccumulator.stringMergeOperator;
    assertTrue(binaryOperator2 instanceof StringConcat);
    assertTrue(actualDefaultResultAccumulator.numberMergeOperator instanceof Sum);
    assertEquals(",", ((StringConcat) binaryOperator2).getSeparator());
    assertFalse(actualDefaultResultAccumulator.aggregateElements());
    assertFalse(actualDefaultResultAccumulator.aggregateElements);
    assertSame(
        actualDefaultResultAccumulator.mapValueMergeOperator,
        ((BinaryOperatorMap<Object, Object>) binaryOperator).getBinaryOperator());
  }

  /**
   * Test {@link DefaultResultAccumulator#apply(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link DefaultResultAccumulator#DefaultResultAccumulator()}.
   *   <li>When {@code Update}.
   *   <li>Then return {@code Update,State}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultResultAccumulator#apply(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Object, Object); given DefaultResultAccumulator(); when 'Update'; then return 'Update,State'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultResultAccumulator.apply(Object, Object)"})
  void testApply_givenDefaultResultAccumulator_whenUpdate_thenReturnUpdateState() {
    // Arrange
    DefaultResultAccumulator<Object> defaultResultAccumulator = new DefaultResultAccumulator<>();

    // Act and Assert
    assertEquals("Update,State", defaultResultAccumulator.apply("Update", "State"));
  }

  /**
   * Test {@link DefaultResultAccumulator#apply(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with {@code Group}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultResultAccumulator#apply(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Object, Object); given Edge(String) with 'Group'; when ArrayList(); then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultResultAccumulator.apply(Object, Object)"})
  void testApply_givenEdgeWithGroup_whenArrayList_thenReturnSet() {
    // Arrange
    DefaultResultAccumulator<Object> defaultResultAccumulator =
        new DefaultResultAccumulator<>(new Properties());
    defaultResultAccumulator.setAggregateElements(false);

    LinkedHashSet<Object> objectSet = new LinkedHashSet<>();
    objectSet.add(new Edge("Group"));

    // Act
    Object actualApplyResult = defaultResultAccumulator.apply(objectSet, new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof Set);
    assertEquals(1, ((Set<Edge>) actualApplyResult).size());
    assertSame(objectSet, actualApplyResult);
  }

  /**
   * Test {@link DefaultResultAccumulator#apply(Object, Object)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultResultAccumulator#apply(Object, Object)}
   */
  @Test
  @DisplayName("Test apply(Object, Object); when HashMap(); then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultResultAccumulator.apply(Object, Object)"})
  void testApply_whenHashMap_thenReturnIntValueIsOne() {
    // Arrange
    DefaultResultAccumulator<Object> defaultResultAccumulator =
        new DefaultResultAccumulator<>(new Properties());
    defaultResultAccumulator.setAggregateElements(false);
    Integer valueOfResult = Integer.valueOf(1);

    // Act
    Object actualApplyResult = defaultResultAccumulator.apply(valueOfResult, new HashMap<>());

    // Assert
    assertEquals(1, ((Integer) actualApplyResult).intValue());
    assertSame(valueOfResult, actualApplyResult);
  }

  /**
   * Test {@link DefaultResultAccumulator#apply(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultResultAccumulator#apply(Object, Object)}
   */
  @Test
  @DisplayName("Test apply(Object, Object); when 'null'; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultResultAccumulator.apply(Object, Object)"})
  void testApply_whenNull_thenReturnIntValueIsOne() {
    // Arrange
    DefaultResultAccumulator<Object> defaultResultAccumulator =
        new DefaultResultAccumulator<>(new Properties());
    defaultResultAccumulator.setAggregateElements(false);
    Integer valueOfResult = Integer.valueOf(1);

    // Act
    Object actualApplyResult = defaultResultAccumulator.apply(null, valueOfResult);

    // Assert
    assertEquals(1, ((Integer) actualApplyResult).intValue());
    assertSame(valueOfResult, actualApplyResult);
  }

  /**
   * Test {@link DefaultResultAccumulator#apply(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultResultAccumulator#apply(Object, Object)}
   */
  @Test
  @DisplayName("Test apply(Object, Object); when 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultResultAccumulator.apply(Object, Object)"})
  void testApply_whenTrue_thenReturnTrue() {
    // Arrange
    DefaultResultAccumulator<Object> defaultResultAccumulator =
        new DefaultResultAccumulator<>(new Properties());
    defaultResultAccumulator.setAggregateElements(false);

    // Act and Assert
    assertTrue((Boolean) defaultResultAccumulator.apply(null, true));
  }

  /**
   * Test {@link DefaultResultAccumulator#apply(Object, Object)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return intValue is two.
   * </ul>
   *
   * <p>Method under test: {@link DefaultResultAccumulator#apply(Object, Object)}
   */
  @Test
  @DisplayName("Test apply(Object, Object); when valueOf one; then return intValue is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultResultAccumulator.apply(Object, Object)"})
  void testApply_whenValueOfOne_thenReturnIntValueIsTwo() {
    // Arrange
    DefaultResultAccumulator<Object> defaultResultAccumulator =
        new DefaultResultAccumulator<>(new Properties());
    defaultResultAccumulator.setAggregateElements(false);

    // Act and Assert
    assertEquals(
        2,
        ((Integer) defaultResultAccumulator.apply(Integer.valueOf(1), Integer.valueOf(1)))
            .intValue());
  }
}
