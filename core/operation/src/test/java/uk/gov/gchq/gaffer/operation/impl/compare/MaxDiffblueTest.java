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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.compare.Max.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class MaxDiffblueTest {
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
    Max _getOpResult = actualBuilder._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Element);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getCombinedComparator());
    assertNull(_getOpResult.getComparators());
    assertNull(_getOpResult.getOptions());
    assertTrue(_getOpResult.getComparableGroupPropertyPairs().isEmpty());
    Class<Element> expectedOutputClass = Element.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    Max actualMax = actualBuilder.build();
    assertSame(_getOpResult, actualMax);
  }

  /**
   * Test {@link Max#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Max#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable Max.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Max().getInput());
  }

  /**
   * Test {@link Max#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link Max#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"com.fasterxml.jackson.core.type.TypeReference Max.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue(new Max().getOutputTypeReference() instanceof TypeReferenceImpl.Element);
  }

  /**
   * Test {@link Max#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Max} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link Max#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given Max (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Max Max.shallowClone()"})
  void testShallowClone_givenMaxOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    Max max = new Max();
    max.setOptions(new HashMap<>());

    // Act
    Max actualShallowCloneResult = max.shallowClone();

    // Assert
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Element);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getCombinedComparator());
    assertNull(actualShallowCloneResult.getComparators());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.getComparableGroupPropertyPairs().isEmpty());
    Class<Element> expectedOutputClass = Element.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test {@link Max#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Max} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Max#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given Max (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Max Max.shallowClone()"})
  void testShallowClone_givenMax_thenReturnOptionsIsNull() {
    // Arrange and Act
    Max actualShallowCloneResult = new Max().shallowClone();

    // Assert
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Element);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getCombinedComparator());
    assertNull(actualShallowCloneResult.getComparators());
    assertNull(actualShallowCloneResult.getOptions());
    assertTrue(actualShallowCloneResult.getComparableGroupPropertyPairs().isEmpty());
    Class<Element> expectedOutputClass = Element.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Max}
   *   <li>{@link Max#setComparators(List)}
   *   <li>{@link Max#setInput(Iterable)}
   *   <li>{@link Max#setOptions(Map)}
   *   <li>{@link Max#getComparators()}
   *   <li>{@link Max#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Max.<init>()",
    "List Max.getComparators()",
    "Map Max.getOptions()",
    "void Max.setComparators(List)",
    "void Max.setInput(Iterable)",
    "void Max.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Max actualMax = new Max();
    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    actualMax.setComparators(comparators);
    ArrayList<Element> input = new ArrayList<>();
    actualMax.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualMax.setOptions(options);
    List<Comparator<Element>> actualComparators = actualMax.getComparators();
    Map<String, String> actualOptions = actualMax.getOptions();

    // Assert
    Iterable<? extends Element> input2 = actualMax.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualComparators.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(comparators, actualComparators);
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
