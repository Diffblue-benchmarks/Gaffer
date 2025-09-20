package uk.gov.gchq.gaffer.store.operation.util;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.function.Transform;

class TransformStreamSupplierDiffblueTest {
  /**
   * Test {@link TransformStreamSupplier#get()}.
   *
   * <ul>
   *   <li>Given {@link Transform} (default constructor) Input is {@link ArrayList#ArrayList()}.
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link TransformStreamSupplier#get()}
   */
  @Test
  @DisplayName(
      "Test get(); given Transform (default constructor) Input is ArrayList(); then return limit five collect toList Empty")
  @Tag("MaintainedByDiffblue")
  void testGet_givenTransformInputIsArrayList_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange
    Transform operation = new Transform();
    operation.setInput(new ArrayList<>());

    // Act
    Stream<Element> actualGetResult = new TransformStreamSupplier(operation).get();

    // Assert
    assertTrue(actualGetResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
