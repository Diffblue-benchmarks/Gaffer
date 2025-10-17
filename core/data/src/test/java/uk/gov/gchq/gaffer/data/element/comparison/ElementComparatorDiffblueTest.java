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

package uk.gov.gchq.gaffer.data.element.comparison;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Comparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.comparison.ElementPropertyComparator.Builder;

class ElementComparatorDiffblueTest {
  /**
   * Test {@link ElementComparator#getComparableGroupPropertyPairs()}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor) comparator {@link Comparator} build.
   * </ul>
   *
   * <p>Method under test: {@link ElementComparator#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName(
      "Test getComparableGroupPropertyPairs(); given Builder (default constructor) comparator Comparator build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ElementComparator.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenBuilderComparatorComparatorBuild() {
    // Arrange, Act and Assert
    assertTrue(
        new Builder()
            .comparator(mock(Comparator.class))
            .build()
            .getComparableGroupPropertyPairs()
            .isEmpty());
  }

  /**
   * Test {@link ElementComparator#getComparableGroupPropertyPairs()}.
   *
   * <ul>
   *   <li>Given {@link ElementPropertyComparator} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ElementComparator#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName(
      "Test getComparableGroupPropertyPairs(); given ElementPropertyComparator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ElementComparator.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenElementPropertyComparator() {
    // Arrange, Act and Assert
    assertTrue(new ElementPropertyComparator().getComparableGroupPropertyPairs().isEmpty());
  }
}
