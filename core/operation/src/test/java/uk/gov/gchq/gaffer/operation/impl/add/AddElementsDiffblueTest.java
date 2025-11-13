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

package uk.gov.gchq.gaffer.operation.impl.add;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.add.AddElements.Builder;

class AddElementsDiffblueTest {
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
    AddElements _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertFalse(_getOpResult.isSkipInvalidElements());
    assertTrue(_getOpResult.isValidate());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Test {@link AddElements#createInputArray()}.
   * <ul>
   *   <li>Given {@link AddElements} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElements#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); given AddElements (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] AddElements.createInputArray()"})
  void testCreateInputArray_givenAddElements_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AddElements()).createInputArray());
  }

  /**
   * Test {@link AddElements#createInputArray()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElements#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] AddElements.createInputArray()"})
  void testCreateInputArray_thenReturnArrayLengthIsZero() {
    // Arrange
    AddElements addElements = new AddElements();
    addElements.setInput(new ArrayList<>());

    // Act and Assert
    assertEquals(0, addElements.createInputArray().length);
  }

  /**
   * Test {@link AddElements#shallowClone()}.
   * <ul>
   *   <li>Given {@link AddElements} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Input is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given AddElements (default constructor) Options is HashMap(); then return Input is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AddElements AddElements.shallowClone()"})
  void testShallowClone_givenAddElementsOptionsIsHashMap_thenReturnInputIsNull() {
    // Arrange
    AddElements addElements = new AddElements();
    addElements.setOptions(new HashMap<>());

    // Act
    AddElements actualShallowCloneResult = addElements.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertFalse(actualShallowCloneResult.isSkipInvalidElements());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.isValidate());
  }

  /**
   * Test {@link AddElements#shallowClone()}.
   * <ul>
   *   <li>Given {@link AddElements} (default constructor).</li>
   *   <li>Then return {@link AddElements} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given AddElements (default constructor); then return AddElements (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AddElements AddElements.shallowClone()"})
  void testShallowClone_givenAddElements_thenReturnAddElements() {
    // Arrange
    AddElements addElements = new AddElements();

    // Act and Assert
    assertEquals(addElements, addElements.shallowClone());
  }

  /**
   * Test {@link AddElements#equals(Object)}, and {@link AddElements#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AddElements#equals(Object)}
   *   <li>{@link AddElements#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AddElements.equals(Object)", "int AddElements.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AddElements addElements = new AddElements();
    AddElements addElements2 = new AddElements();

    // Act and Assert
    assertEquals(addElements, addElements2);
    int expectedHashCodeResult = addElements.hashCode();
    assertEquals(expectedHashCodeResult, addElements2.hashCode());
  }

  /**
   * Test {@link AddElements#equals(Object)}, and {@link AddElements#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AddElements#equals(Object)}
   *   <li>{@link AddElements#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AddElements.equals(Object)", "int AddElements.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AddElements addElements = new AddElements();

    // Act and Assert
    assertEquals(addElements, addElements);
    int expectedHashCodeResult = addElements.hashCode();
    assertEquals(expectedHashCodeResult, addElements.hashCode());
  }

  /**
   * Test {@link AddElements#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElements#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AddElements.equals(Object)", "int AddElements.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AddElements addElements = new AddElements();
    addElements.setInput(new ArrayList<>());

    // Act and Assert
    assertNotEquals(addElements, new AddElements());
  }

  /**
   * Test {@link AddElements#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElements#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AddElements.equals(Object)", "int AddElements.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AddElements(), null);
  }

  /**
   * Test {@link AddElements#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElements#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AddElements.equals(Object)", "int AddElements.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AddElements(), "Different type to AddElements");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AddElements}
   *   <li>{@link AddElements#setInput(Iterable)}
   *   <li>{@link AddElements#setOptions(Map)}
   *   <li>{@link AddElements#setSkipInvalidElements(boolean)}
   *   <li>{@link AddElements#setValidate(boolean)}
   *   <li>{@link AddElements#toString()}
   *   <li>{@link AddElements#getOptions()}
   *   <li>{@link AddElements#isSkipInvalidElements()}
   *   <li>{@link AddElements#isValidate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AddElements.<init>()", "Map AddElements.getOptions()",
      "boolean AddElements.isSkipInvalidElements()", "boolean AddElements.isValidate()",
      "void AddElements.setInput(Iterable)", "void AddElements.setOptions(Map)",
      "void AddElements.setSkipInvalidElements(boolean)", "void AddElements.setValidate(boolean)",
      "String AddElements.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    AddElements actualAddElements = new AddElements();
    ArrayList<Element> elements = new ArrayList<>();
    actualAddElements.setInput(elements);
    HashMap<String, String> options = new HashMap<>();
    actualAddElements.setOptions(options);
    actualAddElements.setSkipInvalidElements(true);
    actualAddElements.setValidate(true);
    String actualToStringResult = actualAddElements.toString();
    Map<String, String> actualOptions = actualAddElements.getOptions();
    boolean actualIsSkipInvalidElementsResult = actualAddElements.isSkipInvalidElements();
    boolean actualIsValidateResult = actualAddElements.isValidate();

    // Assert
    Iterable<? extends Element> input = actualAddElements.getInput();
    assertTrue(input instanceof List);
    assertEquals("AddElements[options={},validate=true,skipInvalidElements=true,elements=[]]", actualToStringResult);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsSkipInvalidElementsResult);
    assertTrue(actualIsValidateResult);
    assertSame(elements, input);
    assertSame(options, actualOptions);
  }
}
