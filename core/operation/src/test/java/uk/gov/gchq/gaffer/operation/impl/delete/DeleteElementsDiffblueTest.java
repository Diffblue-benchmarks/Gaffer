/*
 * Copyright 2025 Crown Copyright
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

package uk.gov.gchq.gaffer.operation.impl.delete;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.delete.DeleteElements.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class DeleteElementsDiffblueTest {
  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    DeleteElements _getOpResult = actualBuilder._getOp();
    TypeReference<Long> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Long);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertFalse(_getOpResult.isSkipInvalidElements());
    assertTrue(_getOpResult.isValidate());
    Class<Long> expectedOutputClass = Long.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test {@link DeleteElements#createInputArray()}.
   * <ul>
   *   <li>Given {@link DeleteElements} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElements#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); given DeleteElements (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] DeleteElements.createInputArray()"})
  void testCreateInputArray_givenDeleteElements_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DeleteElements()).createInputArray());
  }

  /**
   * Test {@link DeleteElements#createInputArray()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElements#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] DeleteElements.createInputArray()"})
  void testCreateInputArray_thenReturnArrayLengthIsZero() {
    // Arrange
    DeleteElements deleteElements = new DeleteElements();
    deleteElements.setInput(new ArrayList<>());

    // Act and Assert
    assertEquals(0, deleteElements.createInputArray().length);
  }

  /**
   * Test {@link DeleteElements#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link DeleteElements#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference DeleteElements.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue((new DeleteElements()).getOutputTypeReference() instanceof TypeReferenceImpl.Long);
  }

  /**
   * Test {@link DeleteElements#shallowClone()}.
   * <ul>
   *   <li>Given {@link DeleteElements} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given DeleteElements (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeleteElements DeleteElements.shallowClone()"})
  void testShallowClone_givenDeleteElements() {
    // Arrange
    DeleteElements deleteElements = new DeleteElements();

    // Act and Assert
    assertEquals(deleteElements, deleteElements.shallowClone());
  }

  /**
   * Test {@link DeleteElements#shallowClone()}.
   * <ul>
   *   <li>Given {@link DeleteElements} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given DeleteElements (default constructor) Options is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeleteElements DeleteElements.shallowClone()"})
  void testShallowClone_givenDeleteElementsOptionsIsHashMap() {
    // Arrange
    DeleteElements deleteElements = new DeleteElements();
    deleteElements.setOptions(new HashMap<>());

    // Act and Assert
    assertEquals(deleteElements, deleteElements.shallowClone());
  }

  /**
   * Test {@link DeleteElements#equals(Object)}, and {@link DeleteElements#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeleteElements#equals(Object)}
   *   <li>{@link DeleteElements#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeleteElements.equals(Object)", "int DeleteElements.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeleteElements deleteElements = new DeleteElements();
    DeleteElements deleteElements2 = new DeleteElements();

    // Act and Assert
    assertEquals(deleteElements, deleteElements2);
    int expectedHashCodeResult = deleteElements.hashCode();
    assertEquals(expectedHashCodeResult, deleteElements2.hashCode());
  }

  /**
   * Test {@link DeleteElements#equals(Object)}, and {@link DeleteElements#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeleteElements#equals(Object)}
   *   <li>{@link DeleteElements#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeleteElements.equals(Object)", "int DeleteElements.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeleteElements deleteElements = new DeleteElements();

    // Act and Assert
    assertEquals(deleteElements, deleteElements);
    int expectedHashCodeResult = deleteElements.hashCode();
    assertEquals(expectedHashCodeResult, deleteElements.hashCode());
  }

  /**
   * Test {@link DeleteElements#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElements#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeleteElements.equals(Object)", "int DeleteElements.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeleteElements deleteElements = new DeleteElements();
    deleteElements.setInput(new ArrayList<>());

    // Act and Assert
    assertNotEquals(deleteElements, new DeleteElements());
  }

  /**
   * Test {@link DeleteElements#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElements#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeleteElements.equals(Object)", "int DeleteElements.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeleteElements(), null);
  }

  /**
   * Test {@link DeleteElements#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteElements#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeleteElements.equals(Object)", "int DeleteElements.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeleteElements(), "Different type to DeleteElements");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeleteElements}
   *   <li>{@link DeleteElements#setInput(Iterable)}
   *   <li>{@link DeleteElements#setOptions(Map)}
   *   <li>{@link DeleteElements#setSkipInvalidElements(boolean)}
   *   <li>{@link DeleteElements#setValidate(boolean)}
   *   <li>{@link DeleteElements#toString()}
   *   <li>{@link DeleteElements#getOptions()}
   *   <li>{@link DeleteElements#isSkipInvalidElements()}
   *   <li>{@link DeleteElements#isValidate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeleteElements.<init>()", "Map DeleteElements.getOptions()",
      "boolean DeleteElements.isSkipInvalidElements()", "boolean DeleteElements.isValidate()",
      "void DeleteElements.setInput(Iterable)", "void DeleteElements.setOptions(Map)",
      "void DeleteElements.setSkipInvalidElements(boolean)", "void DeleteElements.setValidate(boolean)",
      "String DeleteElements.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    DeleteElements actualDeleteElements = new DeleteElements();
    ArrayList<Element> elements = new ArrayList<>();
    actualDeleteElements.setInput(elements);
    HashMap<String, String> options = new HashMap<>();
    actualDeleteElements.setOptions(options);
    actualDeleteElements.setSkipInvalidElements(true);
    actualDeleteElements.setValidate(true);
    String actualToStringResult = actualDeleteElements.toString();
    Map<String, String> actualOptions = actualDeleteElements.getOptions();
    boolean actualIsSkipInvalidElementsResult = actualDeleteElements.isSkipInvalidElements();
    boolean actualIsValidateResult = actualDeleteElements.isValidate();

    // Assert
    Iterable<? extends Element> input = actualDeleteElements.getInput();
    assertTrue(input instanceof List);
    assertEquals("DeleteElements[options={},validate=true,skipInvalidElements=true,elements=[]]", actualToStringResult);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsSkipInvalidElementsResult);
    assertTrue(actualIsValidateResult);
    assertSame(elements, input);
    assertSame(options, actualOptions);
  }
}
