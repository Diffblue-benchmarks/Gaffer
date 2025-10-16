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
