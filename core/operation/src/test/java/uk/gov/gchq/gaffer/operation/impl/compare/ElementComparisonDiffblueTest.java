package uk.gov.gchq.gaffer.operation.impl.compare;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Comparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.comparison.ElementPropertyComparator;

class ElementComparisonDiffblueTest {
  /**
   * Test {@link ElementComparison#getCombinedComparator()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getCombinedComparator()}
   */
  @Test
  @DisplayName("Test getCombinedComparator(); given ArrayList() add 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetCombinedComparator_givenArrayListAddNull_thenReturnNull() {
    // Arrange
    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(null);

    Max max = new Max();
    max.setComparators(comparators);

    // Act and Assert
    assertNull(max.getCombinedComparator());
  }

  /**
   * Test {@link ElementComparison#getCombinedComparator()}.
   *
   * <ul>
   *   <li>Given {@link Max} (default constructor) Comparators is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getCombinedComparator()}
   */
  @Test
  @DisplayName(
      "Test getCombinedComparator(); given Max (default constructor) Comparators is ArrayList(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetCombinedComparator_givenMaxComparatorsIsArrayList_thenReturnNull() {
    // Arrange
    Max max = new Max();
    max.setComparators(new ArrayList<>());

    // Act and Assert
    assertNull(max.getCombinedComparator());
  }

  /**
   * Test {@link ElementComparison#getCombinedComparator()}.
   *
   * <ul>
   *   <li>Given {@link Max} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getCombinedComparator()}
   */
  @Test
  @DisplayName("Test getCombinedComparator(); given Max (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetCombinedComparator_givenMax_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Max().getCombinedComparator());
  }

  /**
   * Test {@link ElementComparison#getCombinedComparator()}.
   *
   * <ul>
   *   <li>Then calls {@link Comparator#thenComparing(Comparator)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getCombinedComparator()}
   */
  @Test
  @DisplayName("Test getCombinedComparator(); then calls thenComparing(Comparator)")
  @Tag("MaintainedByDiffblue")
  void testGetCombinedComparator_thenCallsThenComparing() {
    // Arrange
    Comparator<Element> comparator = mock(Comparator.class);
    when(comparator.thenComparing(Mockito.<Comparator<Element>>any()))
        .thenReturn(mock(Comparator.class));

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(comparator);
    comparators.add(mock(Comparator.class));
    comparators.add(null);

    Max max = new Max();
    max.setComparators(comparators);

    // Act
    max.getCombinedComparator();

    // Assert
    verify(comparator).thenComparing(isA(Comparator.class));
  }

  /**
   * Test {@link ElementComparison#getComparableGroupPropertyPairs()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Comparator}.
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName("Test getComparableGroupPropertyPairs(); given ArrayList() add Comparator")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ElementPropertyComparator} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName(
      "Test getComparableGroupPropertyPairs(); given ArrayList() add ElementPropertyComparator (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>Given {@link Max} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName("Test getComparableGroupPropertyPairs(); given Max (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testGetComparableGroupPropertyPairs_givenMax() {
    // Arrange, Act and Assert
    assertTrue(new Max().getComparableGroupPropertyPairs().isEmpty());
  }

  /**
   * Test {@link ElementComparison#getComparableGroupPropertyPairs()}.
   *
   * <ul>
   *   <li>Given {@link Max} (default constructor) Comparators is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementComparison#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName(
      "Test getComparableGroupPropertyPairs(); given Max (default constructor) Comparators is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testGetComparableGroupPropertyPairs_givenMaxComparatorsIsArrayList() {
    // Arrange
    Max max = new Max();
    max.setComparators(new ArrayList<>());

    // Act and Assert
    assertTrue(max.getComparableGroupPropertyPairs().isEmpty());
  }
}
