package uk.gov.gchq.gaffer.operation.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.If;
import uk.gov.gchq.gaffer.operation.io.GenericInput.InputWrapper;
import uk.gov.gchq.gaffer.operation.io.GenericInput.InputWrapperNoTypeInfo;
import uk.gov.gchq.gaffer.operation.io.GenericInput.MultiInputWrapper;

class GenericInputDiffblueTest {
  /**
   * Test {@link GenericInput#getInput()}.
   *
   * <p>Method under test: {@link GenericInput#getInput()}
   */
  @Test
  @DisplayName("Test getInput()")
  @Tag("MaintainedByDiffblue")
  void testGetInput() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act and Assert
    assertNull(resultIf.getInput());
  }

  /**
   * Test InputWrapper getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link InputWrapper}
   *   <li>{@link InputWrapper#setInput(Object)}
   *   <li>{@link InputWrapper#getInput()}
   * </ul>
   */
  @Test
  @DisplayName("Test InputWrapper getters and setters")
  @Tag("MaintainedByDiffblue")
  void testInputWrapperGettersAndSetters() {
    // Arrange and Act
    InputWrapper actualInputWrapper = new InputWrapper();
    actualInputWrapper.setInput("Input");

    // Assert
    assertEquals("Input", actualInputWrapper.getInput());
  }

  /**
   * Test InputWrapperNoTypeInfo getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InputWrapperNoTypeInfo#InputWrapperNoTypeInfo()}
   *   <li>{@link InputWrapperNoTypeInfo#setInput(Object)}
   *   <li>{@link InputWrapperNoTypeInfo#getInput()}
   * </ul>
   */
  @Test
  @DisplayName("Test InputWrapperNoTypeInfo getters and setters")
  @Tag("MaintainedByDiffblue")
  void testInputWrapperNoTypeInfoGettersAndSetters() {
    // Arrange and Act
    InputWrapperNoTypeInfo actualInputWrapperNoTypeInfo = new InputWrapperNoTypeInfo();
    actualInputWrapperNoTypeInfo.setInput("Input");

    // Assert
    assertEquals("Input", actualInputWrapperNoTypeInfo.getInput());
  }

  /**
   * Test InputWrapperNoTypeInfo getters and setters.
   *
   * <ul>
   *   <li>When {@code Input}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InputWrapperNoTypeInfo#InputWrapperNoTypeInfo(Object)}
   *   <li>{@link InputWrapperNoTypeInfo#setInput(Object)}
   *   <li>{@link InputWrapperNoTypeInfo#getInput()}
   * </ul>
   */
  @Test
  @DisplayName("Test InputWrapperNoTypeInfo getters and setters; when 'Input'")
  @Tag("MaintainedByDiffblue")
  void testInputWrapperNoTypeInfoGettersAndSetters_whenInput() {
    // Arrange and Act
    InputWrapperNoTypeInfo actualInputWrapperNoTypeInfo = new InputWrapperNoTypeInfo("Input");
    actualInputWrapperNoTypeInfo.setInput("Input");

    // Assert
    assertEquals("Input", actualInputWrapperNoTypeInfo.getInput());
  }

  /**
   * Test MultiInputWrapper {@link MultiInputWrapper#getInputAsArray()}.
   *
   * <p>Method under test: {@link MultiInputWrapper#getInputAsArray()}
   */
  @Test
  @DisplayName("Test MultiInputWrapper getInputAsArray()")
  @Tag("MaintainedByDiffblue")
  void testMultiInputWrapperGetInputAsArray() {
    // Arrange, Act and Assert
    assertNull(new MultiInputWrapper().getInputAsArray());
  }

  /**
   * Test MultiInputWrapper {@link MultiInputWrapper#getInputAsIterable()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiInputWrapper#getInputAsIterable()}
   */
  @Test
  @DisplayName("Test MultiInputWrapper getInputAsIterable(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testMultiInputWrapperGetInputAsIterable_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new MultiInputWrapper().getInputAsIterable());
  }

  /**
   * Test MultiInputWrapper {@link MultiInputWrapper#hasMultiInput()}.
   *
   * <p>Method under test: {@link MultiInputWrapper#hasMultiInput()}
   */
  @Test
  @DisplayName("Test MultiInputWrapper hasMultiInput()")
  @Tag("MaintainedByDiffblue")
  void testMultiInputWrapperHasMultiInput() {
    // Arrange, Act and Assert
    assertFalse(new MultiInputWrapper().hasMultiInput());
  }

  /**
   * Test MultiInputWrapper new {@link MultiInputWrapper} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MultiInputWrapper}
   */
  @Test
  @DisplayName("Test MultiInputWrapper new MultiInputWrapper (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testMultiInputWrapperNewMultiInputWrapper() {
    // Arrange and Act
    MultiInputWrapper actualMultiInputWrapper = new MultiInputWrapper();

    // Assert
    assertNull(actualMultiInputWrapper.getInputAsIterable());
    assertNull(actualMultiInputWrapper.getInputAsArray());
    assertFalse(actualMultiInputWrapper.hasMultiInput());
  }

  /**
   * Test MultiInputWrapper {@link MultiInputWrapper#setInputFromArray(Object[])}.
   *
   * <p>Method under test: {@link MultiInputWrapper#setInputFromArray(Object[])}
   */
  @Test
  @DisplayName("Test MultiInputWrapper setInputFromArray(Object[])")
  @Tag("MaintainedByDiffblue")
  void testMultiInputWrapperSetInputFromArray() {
    // Arrange
    MultiInputWrapper multiInputWrapper = new MultiInputWrapper();
    Object[] input = new Object[] {"Input"};

    // Act
    multiInputWrapper.setInputFromArray(input);

    // Assert
    Iterable<?> inputAsIterable = multiInputWrapper.getInputAsIterable();
    assertTrue(inputAsIterable instanceof List);
    assertEquals(1, ((List<?>) inputAsIterable).size());
    assertEquals("Input", ((List<?>) inputAsIterable).get(0));
    assertTrue(multiInputWrapper.hasMultiInput());
    assertSame(input, multiInputWrapper.getInputAsArray());
  }

  /**
   * Test MultiInputWrapper {@link MultiInputWrapper#setInputFromIterable(Iterable)}.
   *
   * <p>Method under test: {@link MultiInputWrapper#setInputFromIterable(Iterable)}
   */
  @Test
  @DisplayName("Test MultiInputWrapper setInputFromIterable(Iterable)")
  @Tag("MaintainedByDiffblue")
  void testMultiInputWrapperSetInputFromIterable() {
    // Arrange
    MultiInputWrapper multiInputWrapper = new MultiInputWrapper();
    ArrayList<Object> input = new ArrayList<>();

    // Act
    multiInputWrapper.setInputFromIterable(input);

    // Assert
    assertEquals(0, multiInputWrapper.getInputAsArray().length);
    assertTrue(multiInputWrapper.hasMultiInput());
    assertSame(input, multiInputWrapper.getInputAsIterable());
  }

  /**
   * Test MultiInputWrapper {@link MultiInputWrapper#setInput(Object)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiInputWrapper#setInput(Object)}
   */
  @Test
  @DisplayName(
      "Test MultiInputWrapper setInput(Object); when ArrayList(); then array length is zero")
  @Tag("MaintainedByDiffblue")
  void testMultiInputWrapperSetInput_whenArrayList_thenArrayLengthIsZero() {
    // Arrange
    MultiInputWrapper multiInputWrapper = new MultiInputWrapper();
    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    multiInputWrapper.setInput(objectList);

    // Assert
    assertEquals(0, multiInputWrapper.getInputAsArray().length);
    assertTrue(multiInputWrapper.hasMultiInput());
    assertSame(objectList, multiInputWrapper.getInputAsIterable());
  }

  /**
   * Test MultiInputWrapper {@link MultiInputWrapper#setInput(Object)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then not {@link MultiInputWrapper} (default constructor) hasMultiInput.
   * </ul>
   *
   * <p>Method under test: {@link MultiInputWrapper#setInput(Object)}
   */
  @Test
  @DisplayName(
      "Test MultiInputWrapper setInput(Object); when 'Input'; then not MultiInputWrapper (default constructor) hasMultiInput")
  @Tag("MaintainedByDiffblue")
  void testMultiInputWrapperSetInput_whenInput_thenNotMultiInputWrapperHasMultiInput() {
    // Arrange
    MultiInputWrapper multiInputWrapper = new MultiInputWrapper();

    // Act
    multiInputWrapper.setInput("Input");

    // Assert that nothing has changed
    assertFalse(multiInputWrapper.hasMultiInput());
  }

  /**
   * Test MultiInputWrapper {@link MultiInputWrapper#setInput(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then not {@link MultiInputWrapper} (default constructor) hasMultiInput.
   * </ul>
   *
   * <p>Method under test: {@link MultiInputWrapper#setInput(Object)}
   */
  @Test
  @DisplayName(
      "Test MultiInputWrapper setInput(Object); when 'null'; then not MultiInputWrapper (default constructor) hasMultiInput")
  @Tag("MaintainedByDiffblue")
  void testMultiInputWrapperSetInput_whenNull_thenNotMultiInputWrapperHasMultiInput() {
    // Arrange
    MultiInputWrapper multiInputWrapper = new MultiInputWrapper();

    // Act
    multiInputWrapper.setInput(null);

    // Assert that nothing has changed
    assertFalse(multiInputWrapper.hasMultiInput());
  }

  /**
   * Test {@link GenericInput#setInput(Object)}.
   *
   * <ul>
   *   <li>Given {@link If} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link If} (default constructor) Input is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GenericInput#setInput(Object)}
   */
  @Test
  @DisplayName(
      "Test setInput(Object); given If (default constructor); when ArrayList(); then If (default constructor) Input is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testSetInput_givenIf_whenArrayList_thenIfInputIsArrayList() {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    resultIf.setInput(objectList);

    // Assert
    assertSame(objectList, resultIf.getInput());
  }

  /**
   * Test {@link GenericInput#setInput(Object)}.
   *
   * <ul>
   *   <li>Given {@link If} (default constructor).
   *   <li>When {@code Input}.
   *   <li>Then {@link If} (default constructor) Input is {@code Input}.
   * </ul>
   *
   * <p>Method under test: {@link GenericInput#setInput(Object)}
   */
  @Test
  @DisplayName(
      "Test setInput(Object); given If (default constructor); when 'Input'; then If (default constructor) Input is 'Input'")
  @Tag("MaintainedByDiffblue")
  void testSetInput_givenIf_whenInput_thenIfInputIsInput() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act
    resultIf.setInput("Input");

    // Assert
    assertEquals("Input", resultIf.getInput());
  }
}
