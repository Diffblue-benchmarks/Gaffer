package uk.gov.gchq.gaffer.operation.impl.add;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    AddElements _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertFalse(_getOpResult.isSkipInvalidElements());
    assertTrue(_getOpResult.isValidate());
    AddElements actualAddElements = actualBuilder.build();
    assertSame(_getOpResult, actualAddElements);
  }

  /**
   * Test {@link AddElements#createInputArray()}.
   *
   * <ul>
   *   <li>Given {@link AddElements} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddElements#createInputArray()}
   */
  @Test
  @DisplayName(
      "Test createInputArray(); given AddElements (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testCreateInputArray_givenAddElements_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AddElements().createInputArray());
  }

  /**
   * Test {@link AddElements#createInputArray()}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link AddElements#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); then return array length is zero")
  @Tag("MaintainedByDiffblue")
  void testCreateInputArray_thenReturnArrayLengthIsZero() {
    // Arrange
    AddElements addElements = new AddElements();
    addElements.setInput(new ArrayList<>());

    // Act and Assert
    assertEquals(0, addElements.createInputArray().length);
  }

  /**
   * Test {@link AddElements#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddElements#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AddElements().getInput());
  }

  /**
   * Test {@link AddElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddElements} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Input is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddElements (default constructor) Options is HashMap(); then return Input is 'null'")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>Given {@link AddElements} (default constructor).
   *   <li>Then return {@link AddElements} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AddElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddElements (default constructor); then return AddElements (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenAddElements_thenReturnAddElements() {
    // Arrange
    AddElements addElements = new AddElements();

    // Act
    AddElements actualShallowCloneResult = addElements.shallowClone();

    // Assert
    assertEquals(addElements, actualShallowCloneResult);
  }

  /**
   * Test {@link AddElements#equals(Object)}, and {@link AddElements#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AddElements#equals(Object)}
   *   <li>{@link AddElements#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AddElements addElements = new AddElements();
    AddElements addElements2 = new AddElements();

    // Act and Assert
    assertEquals(addElements, addElements2);
    assertEquals(addElements.hashCode(), addElements2.hashCode());
  }

  /**
   * Test {@link AddElements#equals(Object)}, and {@link AddElements#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AddElements#equals(Object)}
   *   <li>{@link AddElements#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AddElements#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AddElements addElements = new AddElements();
    addElements.setInput(new ArrayList<>());

    // Act and Assert
    assertNotEquals(addElements, new AddElements());
  }

  /**
   * Test {@link AddElements#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AddElements#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AddElements(), null);
  }

  /**
   * Test {@link AddElements#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AddElements#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AddElements(), "Different type to AddElements");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
    assertEquals(
        "AddElements[options={},validate=true,skipInvalidElements=true,elements=[]]",
        actualToStringResult);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsSkipInvalidElementsResult);
    assertTrue(actualIsValidateResult);
    assertSame(elements, input);
    assertSame(options, actualOptions);
  }
}
