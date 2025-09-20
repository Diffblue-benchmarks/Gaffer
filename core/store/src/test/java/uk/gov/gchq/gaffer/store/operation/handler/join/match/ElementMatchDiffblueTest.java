package uk.gov.gchq.gaffer.store.operation.handler.join.match;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  void testMatching_givenElementMatch_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ElementMatch().matching("Test Object"));
  }
}
