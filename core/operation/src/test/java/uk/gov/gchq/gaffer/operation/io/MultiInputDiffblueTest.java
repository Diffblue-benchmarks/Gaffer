package uk.gov.gchq.gaffer.operation.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.named.operation.NamedOperation.Builder;

class MultiInputDiffblueTest {
  /**
   * Test Builder {@link MultiInput.Builder#input(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link MultiInput.Builder#input(Iterable)}
   */
  @Test
  @DisplayName("Test Builder input(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  void testBuilderInputWithIterable() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualInputResult = builder.input(new ArrayList<>());

    // Assert
    assertSame(builder, actualInputResult);
  }

  /**
   * Test Builder {@link MultiInput.Builder#input(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MultiInput.Builder#input(Object[])}
   */
  @Test
  @DisplayName(
      "Test Builder input(Object[]) with 'Object[]'; when 'Input'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderInputWithObject_whenInput_thenReturnBuilder() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualInputResult = builder.input("Input");

    // Assert
    assertSame(builder, actualInputResult);
  }

  /**
   * Test {@link MultiInput#createInputArray()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return first element is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MultiInput#createInputArray()}
   */
  @Test
  @DisplayName(
      "Test createInputArray(); given ArrayList() add '42'; then return first element is '42'")
  @Tag("MaintainedByDiffblue")
  void testCreateInputArray_givenArrayListAdd42_thenReturnFirstElementIs42() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    Iterable<Object> input = mock(Iterable.class);
    when(input.iterator()).thenReturn(objectList.iterator());

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setInput(input);

    // Act
    Object[] actualCreateInputArrayResult = namedOperation.createInputArray();

    // Assert
    verify(input).iterator();
    assertEquals("42", actualCreateInputArrayResult[0]);
    assertEquals(1, actualCreateInputArrayResult.length);
  }

  /**
   * Test {@link MultiInput#createInputArray()}.
   *
   * <ul>
   *   <li>Given {@link NamedOperation} (default constructor) Input is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MultiInput#createInputArray()}
   */
  @Test
  @DisplayName(
      "Test createInputArray(); given NamedOperation (default constructor) Input is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testCreateInputArray_givenNamedOperationInputIsArrayList() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setInput(new ArrayList<>());

    // Act and Assert
    assertEquals(0, namedOperation.createInputArray().length);
  }

  /**
   * Test {@link MultiInput#createInputArray()}.
   *
   * <ul>
   *   <li>Given {@link NamedOperation} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiInput#createInputArray()}
   */
  @Test
  @DisplayName(
      "Test createInputArray(); given NamedOperation (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testCreateInputArray_givenNamedOperation_thenReturnNull() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act and Assert
    assertNull(namedOperation.createInputArray());
  }

  /**
   * Test {@link MultiInput#createInputArray()}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiInput#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); then return array length is zero")
  @Tag("MaintainedByDiffblue")
  void testCreateInputArray_thenReturnArrayLengthIsZero() {
    // Arrange
    Iterable<Object> input = mock(Iterable.class);

    ArrayList<Object> objectList = new ArrayList<>();
    when(input.iterator()).thenReturn(objectList.iterator());

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setInput(input);

    // Act
    Object[] actualCreateInputArrayResult = namedOperation.createInputArray();

    // Assert
    verify(input).iterator();
    assertEquals(0, actualCreateInputArrayResult.length);
  }

  /**
   * Test {@link MultiInput#setInput(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then {@link NamedOperation} (default constructor) Input {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link MultiInput#setInput(Object[])}
   */
  @Test
  @DisplayName(
      "Test setInput(Object[]) with 'Object[]'; when 'Input'; then NamedOperation (default constructor) Input List")
  @Tag("MaintainedByDiffblue")
  void testSetInputWithObject_whenInput_thenNamedOperationInputList() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act
    namedOperation.setInput("Input");

    // Assert
    Iterable<?> input = namedOperation.getInput();
    assertTrue(input instanceof List);
    assertEquals(1, ((List<?>) input).size());
    assertEquals("Input", ((List<?>) input).get(0));
  }
}
