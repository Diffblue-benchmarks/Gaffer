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

package uk.gov.gchq.gaffer.operation.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.gchq.gaffer.operation.impl.If;
import uk.gov.gchq.gaffer.operation.io.GenericInput.InputWrapper;
import uk.gov.gchq.gaffer.operation.io.GenericInput.InputWrapperNoTypeInfo;
import uk.gov.gchq.gaffer.operation.io.GenericInput.MultiInputWrapper;

@ExtendWith(MockitoExtension.class)
class GenericInputDiffblueTest {
  @Mock private Iterable iterable;

  @InjectMocks private MultiInputWrapper multiInputWrapper;

  /**
   * Test {@link GenericInput#getInput()}.
   *
   * <p>Method under test: {@link GenericInput#getInput()}
   */
  @Test
  @DisplayName("Test getInput()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GenericInput.getInput()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InputWrapper.<init>()",
    "Object InputWrapper.getInput()",
    "void InputWrapper.setInput(Object)"
  })
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InputWrapperNoTypeInfo.<init>()",
    "void InputWrapperNoTypeInfo.<init>(Object)",
    "Object InputWrapperNoTypeInfo.getInput()",
    "void InputWrapperNoTypeInfo.setInput(Object)"
  })
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InputWrapperNoTypeInfo.<init>()",
    "void InputWrapperNoTypeInfo.<init>(Object)",
    "Object InputWrapperNoTypeInfo.getInput()",
    "void InputWrapperNoTypeInfo.setInput(Object)"
  })
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
   * <ul>
   *   <li>Given {@link MultiInputWrapper} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiInputWrapper#getInputAsArray()}
   */
  @Test
  @DisplayName(
      "Test MultiInputWrapper getInputAsArray(); given MultiInputWrapper (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] MultiInputWrapper.getInputAsArray()"})
  void testMultiInputWrapperGetInputAsArray_givenMultiInputWrapper_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new MultiInputWrapper().getInputAsArray());
  }

  /**
   * Test MultiInputWrapper {@link MultiInputWrapper#getInputAsArray()}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiInputWrapper#getInputAsArray()}
   */
  @Test
  @DisplayName("Test MultiInputWrapper getInputAsArray(); then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] MultiInputWrapper.getInputAsArray()"})
  void testMultiInputWrapperGetInputAsArray_thenReturnArrayLengthIsZero() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    when(iterable.iterator()).thenReturn(objectList.iterator());

    // Act
    Object[] actualInputAsArray = multiInputWrapper.getInputAsArray();

    // Assert
    verify(iterable).iterator();
    assertEquals(0, actualInputAsArray.length);
  }

  /**
   * Test MultiInputWrapper {@link MultiInputWrapper#getInputAsArray()}.
   *
   * <ul>
   *   <li>Then return first element is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MultiInputWrapper#getInputAsArray()}
   */
  @Test
  @DisplayName("Test MultiInputWrapper getInputAsArray(); then return first element is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] MultiInputWrapper.getInputAsArray()"})
  void testMultiInputWrapperGetInputAsArray_thenReturnFirstElementIs42() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    when(iterable.iterator()).thenReturn(objectList.iterator());

    // Act
    Object[] actualInputAsArray = multiInputWrapper.getInputAsArray();

    // Assert
    verify(iterable).iterator();
    assertEquals("42", actualInputAsArray[0]);
    assertEquals(1, actualInputAsArray.length);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable MultiInputWrapper.getInputAsIterable()"})
  void testMultiInputWrapperGetInputAsIterable_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new MultiInputWrapper().getInputAsIterable());
  }

  /**
   * Test MultiInputWrapper {@link MultiInputWrapper#hasMultiInput()}.
   *
   * <ul>
   *   <li>Given {@link Iterable}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MultiInputWrapper#hasMultiInput()}
   */
  @Test
  @DisplayName("Test MultiInputWrapper hasMultiInput(); given Iterable; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultiInputWrapper.hasMultiInput()"})
  void testMultiInputWrapperHasMultiInput_givenIterable_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(multiInputWrapper.hasMultiInput());
  }

  /**
   * Test MultiInputWrapper {@link MultiInputWrapper#hasMultiInput()}.
   *
   * <ul>
   *   <li>Given {@link MultiInputWrapper} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultiInputWrapper#hasMultiInput()}
   */
  @Test
  @DisplayName(
      "Test MultiInputWrapper hasMultiInput(); given MultiInputWrapper (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultiInputWrapper.hasMultiInput()"})
  void testMultiInputWrapperHasMultiInput_givenMultiInputWrapper_thenReturnFalse() {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiInputWrapper.<init>()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiInputWrapper.setInputFromArray(Object[])"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiInputWrapper.setInputFromIterable(Iterable)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiInputWrapper.setInput(Object)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiInputWrapper.setInput(Object)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiInputWrapper.setInput(Object)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericInput.setInput(Object)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericInput.setInput(Object)"})
  void testSetInput_givenIf_whenInput_thenIfInputIsInput() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act
    resultIf.setInput("Input");

    // Assert
    assertEquals("Input", resultIf.getInput());
  }
}
