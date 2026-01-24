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

package uk.gov.gchq.gaffer.store.operation.handler.join.match;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ElementMatchDiffblueTest {
  /**
   * Test {@link ElementMatch#init(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ElementMatch#ElementMatch()} matching {@code Test Object} is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementMatch#init(Iterable)}
   */
  @Test
  @DisplayName(
      "Test init(Iterable); when ArrayList(); then ElementMatch() matching 'Test Object' is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementMatch.init(Iterable)"})
  void testInit_whenArrayList_thenElementMatchMatchingTestObjectIsArrayList() {
    // Arrange
    ElementMatch elementMatch = new ElementMatch();
    ArrayList<Object> matchCandidates = new ArrayList<>();

    // Act
    elementMatch.init(matchCandidates);

    // Assert
    assertEquals(matchCandidates, elementMatch.matching("Test Object"));
  }

  /**
   * Test {@link ElementMatch#init(Iterable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ElementMatch#init(Iterable)}
   */
  @Test
  @DisplayName("Test init(Iterable); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementMatch.init(Iterable)"})
  void testInit_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ElementMatch().init(null));
  }

  /**
   * Test {@link ElementMatch#matching(Object)}.
   *
   * <ul>
   *   <li>Given {@link ElementMatch#ElementMatch()} init {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ElementMatch#matching(Object)}
   */
  @Test
  @DisplayName("Test matching(Object); given ElementMatch() init ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ElementMatch.matching(Object)"})
  void testMatching_givenElementMatchInitArrayList_thenReturnEmpty() {
    // Arrange
    ElementMatch elementMatch = new ElementMatch();
    elementMatch.init(new ArrayList<>());

    // Act and Assert
    assertTrue(elementMatch.matching("Test Object").isEmpty());
  }

  /**
   * Test {@link ElementMatch#matching(Object)}.
   *
   * <ul>
   *   <li>Given {@link ElementMatch#ElementMatch()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ElementMatch#matching(Object)}
   */
  @Test
  @DisplayName("Test matching(Object); given ElementMatch(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ElementMatch.matching(Object)"})
  void testMatching_givenElementMatch_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ElementMatch().matching("Test Object"));
  }
}
