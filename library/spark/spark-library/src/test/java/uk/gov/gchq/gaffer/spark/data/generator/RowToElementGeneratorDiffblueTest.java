package uk.gov.gchq.gaffer.spark.data.generator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RowToElementGeneratorDiffblueTest {
  /**
   * Test {@link RowToElementGenerator#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link RowToElementGenerator#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; when ArrayList(); then return not iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable RowToElementGenerator.apply(Iterable)"})
  void testApplyWithIterable_whenArrayList_thenReturnNotIteratorHasNext() {
    // Arrange
    RowToElementGenerator rowToElementGenerator = new RowToElementGenerator();

    // Act and Assert
    assertFalse(rowToElementGenerator.apply(new ArrayList<>()).iterator().hasNext());
  }
}
