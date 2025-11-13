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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Comparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.comparison.ElementPropertyComparator;

class ElementComparisonDiffblueTest {
  /**
   * Test {@link ElementComparison#getComparableGroupPropertyPairs()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Comparator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementComparison#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName("Test getComparableGroupPropertyPairs(); given ArrayList() add Comparator")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set ElementComparison.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenArrayListAddComparator() {
    // Arrange
    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(mock(Comparator.class));

    Max max = new Max();
    max.setComparators(comparators);

    // Act and Assert
    assertTrue(max.getComparableGroupPropertyPairs().isEmpty());
  }

  /**
   * Test {@link ElementComparison#getComparableGroupPropertyPairs()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ElementPropertyComparator} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementComparison#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName("Test getComparableGroupPropertyPairs(); given ArrayList() add ElementPropertyComparator (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set ElementComparison.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenArrayListAddElementPropertyComparator() {
    // Arrange
    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(new ElementPropertyComparator());

    Max max = new Max();
    max.setComparators(comparators);

    // Act and Assert
    assertTrue(max.getComparableGroupPropertyPairs().isEmpty());
  }

  /**
   * Test {@link ElementComparison#getComparableGroupPropertyPairs()}.
   * <ul>
   *   <li>Given {@link Max} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementComparison#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName("Test getComparableGroupPropertyPairs(); given Max (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set ElementComparison.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenMax() {
    // Arrange, Act and Assert
    assertTrue((new Max()).getComparableGroupPropertyPairs().isEmpty());
  }

  /**
   * Test {@link ElementComparison#getComparableGroupPropertyPairs()}.
   * <ul>
   *   <li>Given {@link Max} (default constructor) Comparators is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementComparison#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName("Test getComparableGroupPropertyPairs(); given Max (default constructor) Comparators is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set ElementComparison.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenMaxComparatorsIsArrayList() {
    // Arrange
    Max max = new Max();
    max.setComparators(new ArrayList<>());

    // Act and Assert
    assertTrue(max.getComparableGroupPropertyPairs().isEmpty());
  }
}
