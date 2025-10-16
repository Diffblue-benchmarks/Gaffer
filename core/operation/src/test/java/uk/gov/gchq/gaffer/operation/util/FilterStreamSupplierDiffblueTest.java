package uk.gov.gchq.gaffer.operation.util;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.function.Filter;

class FilterStreamSupplierDiffblueTest {
  /**
   * Test {@link FilterStreamSupplier#get()}.
   *
   * <ul>
   *   <li>Given {@link Filter} (default constructor) Input is {@link ArrayList#ArrayList()}.
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link FilterStreamSupplier#get()}
   */
  @Test
  @DisplayName(
      "Test get(); given Filter (default constructor) Input is ArrayList(); then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream FilterStreamSupplier.get()"})
  void testGet_givenFilterInputIsArrayList_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange
    Filter filter = new Filter();
    filter.setInput(new ArrayList<>());

    // Act
    Stream<Element> actualGetResult = new FilterStreamSupplier(filter).get();

    // Assert
    assertTrue(actualGetResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
