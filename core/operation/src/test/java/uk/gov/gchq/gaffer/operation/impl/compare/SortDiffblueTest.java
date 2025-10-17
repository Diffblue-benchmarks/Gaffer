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

package uk.gov.gchq.gaffer.operation.impl.compare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.compare.Sort.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;

class SortDiffblueTest {
  /**
   * Test Builder {@link Builder#comparators(Comparator[])} with {@code Comparator[]}.
   *
   * <ul>
   *   <li>When {@link Comparator}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#comparators(Comparator[])}
   */
  @Test
  @DisplayName(
      "Test Builder comparators(Comparator[]) with 'Comparator[]'; when Comparator; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.comparators(Comparator[])"})
  void testBuilderComparatorsWithComparator_whenComparator_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualComparatorsResult = builder.comparators(mock(Comparator.class));

    // Assert
    assertSame(builder, actualComparatorsResult);
  }

  /**
   * Test Builder {@link Builder#comparators(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link Comparator}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Comparator}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#comparators(List)}
   */
  @Test
  @DisplayName(
      "Test Builder comparators(List) with 'List'; given Comparator; when ArrayList() add Comparator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.comparators(List)"})
  void testBuilderComparatorsWithList_givenComparator_whenArrayListAddComparator() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(mock(Comparator.class));

    // Act
    Builder actualComparatorsResult = builder.comparators(comparators);

    // Assert
    assertSame(builder, actualComparatorsResult);
  }

  /**
   * Test Builder {@link Builder#comparators(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link Comparator}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Comparator}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#comparators(List)}
   */
  @Test
  @DisplayName(
      "Test Builder comparators(List) with 'List'; given Comparator; when ArrayList() add Comparator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.comparators(List)"})
  void testBuilderComparatorsWithList_givenComparator_whenArrayListAddComparator2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(mock(Comparator.class));
    comparators.add(mock(Comparator.class));

    // Act
    Builder actualComparatorsResult = builder.comparators(comparators);

    // Assert
    assertSame(builder, actualComparatorsResult);
  }

  /**
   * Test Builder {@link Builder#comparators(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#comparators(List)}
   */
  @Test
  @DisplayName("Test Builder comparators(List) with 'List'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.comparators(List)"})
  void testBuilderComparatorsWithList_whenArrayList() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualComparatorsResult = builder.comparators(new ArrayList<>());

    // Assert
    assertSame(builder, actualComparatorsResult);
  }

  /**
   * Test Builder {@link Builder#deduplicate(boolean)}.
   *
   * <p>Method under test: {@link Builder#deduplicate(boolean)}
   */
  @Test
  @DisplayName("Test Builder deduplicate(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.deduplicate(boolean)"})
  void testBuilderDeduplicate() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDeduplicateResult = builder.deduplicate(true);

    // Assert
    assertSame(builder, actualDeduplicateResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    Sort _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(_getOpResult.getResultLimit());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getCombinedComparator());
    assertNull(_getOpResult.getComparators());
    assertNull(_getOpResult.getOptions());
    assertTrue(_getOpResult.getComparableGroupPropertyPairs().isEmpty());
    assertTrue(_getOpResult.isDeduplicate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    Sort actualSort = actualBuilder.build();
    assertSame(_getOpResult, actualSort);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test Builder {@link Builder#resultLimit(Integer)}.
   *
   * <p>Method under test: {@link Builder#resultLimit(Integer)}
   */
  @Test
  @DisplayName("Test Builder resultLimit(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.resultLimit(Integer)"})
  void testBuilderResultLimit() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualResultLimitResult = builder.resultLimit(1);

    // Assert
    assertSame(builder, actualResultLimitResult);
  }

  /**
   * Test {@link Sort#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Sort#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable Sort.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Sort().getInput());
  }

  /**
   * Test {@link Sort#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link Sort#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference Sort.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends Element>> actualOutputTypeReference =
        new Sort().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableElement);
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link Sort#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Sort} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link Sort#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given Sort (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sort Sort.shallowClone()"})
  void testShallowClone_givenSortOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    Sort sort = new Sort();
    sort.setOptions(new HashMap<>());

    // Act
    Sort actualShallowCloneResult = sort.shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getResultLimit());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getCombinedComparator());
    assertNull(actualShallowCloneResult.getComparators());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.getComparableGroupPropertyPairs().isEmpty());
    assertTrue(actualShallowCloneResult.isDeduplicate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link Sort#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Sort} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Sort#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given Sort (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sort Sort.shallowClone()"})
  void testShallowClone_givenSort_thenReturnOptionsIsNull() {
    // Arrange and Act
    Sort actualShallowCloneResult = new Sort().shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getResultLimit());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getCombinedComparator());
    assertNull(actualShallowCloneResult.getComparators());
    assertNull(actualShallowCloneResult.getOptions());
    assertTrue(actualShallowCloneResult.getComparableGroupPropertyPairs().isEmpty());
    assertTrue(actualShallowCloneResult.isDeduplicate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Sort}
   *   <li>{@link Sort#setComparators(List)}
   *   <li>{@link Sort#setDeduplicate(boolean)}
   *   <li>{@link Sort#setInput(Iterable)}
   *   <li>{@link Sort#setOptions(Map)}
   *   <li>{@link Sort#setResultLimit(Integer)}
   *   <li>{@link Sort#getComparators()}
   *   <li>{@link Sort#getOptions()}
   *   <li>{@link Sort#getResultLimit()}
   *   <li>{@link Sort#isDeduplicate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Sort.<init>()",
    "List Sort.getComparators()",
    "Map Sort.getOptions()",
    "Integer Sort.getResultLimit()",
    "boolean Sort.isDeduplicate()",
    "void Sort.setComparators(List)",
    "void Sort.setDeduplicate(boolean)",
    "void Sort.setInput(Iterable)",
    "void Sort.setOptions(Map)",
    "void Sort.setResultLimit(Integer)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Sort actualSort = new Sort();
    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    actualSort.setComparators(comparators);
    actualSort.setDeduplicate(true);
    ArrayList<Element> input = new ArrayList<>();
    actualSort.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualSort.setOptions(options);
    actualSort.setResultLimit(1);
    List<Comparator<Element>> actualComparators = actualSort.getComparators();
    Map<String, String> actualOptions = actualSort.getOptions();
    Integer actualResultLimit = actualSort.getResultLimit();
    boolean actualIsDeduplicateResult = actualSort.isDeduplicate();

    // Assert
    Iterable<? extends Element> input2 = actualSort.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(1, actualResultLimit.intValue());
    assertTrue(actualComparators.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsDeduplicateResult);
    assertSame(comparators, actualComparators);
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
