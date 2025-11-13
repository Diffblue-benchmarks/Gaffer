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

package uk.gov.gchq.gaffer.rest.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OperationFieldDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationField#OperationField(String, String, String, Set, boolean)}
   *   <li>{@link OperationField#toString()}
   *   <li>{@link OperationField#getClassName()}
   *   <li>{@link OperationField#getName()}
   *   <li>{@link OperationField#getOptions()}
   *   <li>{@link OperationField#getSummary()}
   *   <li>{@link OperationField#isRequired()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OperationField.<init>(String, String, String, Set, boolean)",
    "String OperationField.getClassName()",
    "String OperationField.getName()",
    "Set OperationField.getOptions()",
    "String OperationField.getSummary()",
    "boolean OperationField.isRequired()",
    "String OperationField.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    HashSet<String> options = new HashSet<>();

    // Act
    OperationField actualOperationField =
        new OperationField("Name", "Summary", "Class Name", options, true);
    String actualToStringResult = actualOperationField.toString();
    String actualClassName = actualOperationField.getClassName();
    String actualName = actualOperationField.getName();
    Set<String> actualOptions = actualOperationField.getOptions();
    String actualSummary = actualOperationField.getSummary();
    boolean actualIsRequiredResult = actualOperationField.isRequired();

    // Assert
    assertEquals("Class Name", actualClassName);
    assertEquals("Name", actualName);
    assertEquals(
        "OperationField[name=Name,summary=Summary,className=Class Name,options=[],required=true]",
        actualToStringResult);
    assertEquals("Summary", actualSummary);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsRequiredResult);
    assertSame(options, actualOptions);
  }

  /**
   * Test {@link OperationField#equals(Object)}, and {@link OperationField#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationField#equals(Object)}
   *   <li>{@link OperationField#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationField.equals(Object)", "int OperationField.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OperationField operationField =
        new OperationField("Name", "Summary", "Class Name", new HashSet<>(), true);
    OperationField operationField2 =
        new OperationField("Name", "Summary", "Class Name", new HashSet<>(), true);

    // Act and Assert
    assertEquals(operationField, operationField2);
    assertEquals(operationField.hashCode(), operationField2.hashCode());
  }

  /**
   * Test {@link OperationField#equals(Object)}, and {@link OperationField#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationField#equals(Object)}
   *   <li>{@link OperationField#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationField.equals(Object)", "int OperationField.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OperationField operationField =
        new OperationField("Name", "Summary", "Class Name", new HashSet<>(), true);

    // Act and Assert
    assertEquals(operationField, operationField);
    int expectedHashCodeResult = operationField.hashCode();
    assertEquals(expectedHashCodeResult, operationField.hashCode());
  }

  /**
   * Test {@link OperationField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationField.equals(Object)", "int OperationField.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OperationField operationField =
        new OperationField(null, "Summary", "Class Name", new HashSet<>(), true);

    // Act and Assert
    assertNotEquals(
        operationField, new OperationField("Name", "Summary", "Class Name", new HashSet<>(), true));
  }

  /**
   * Test {@link OperationField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationField.equals(Object)", "int OperationField.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new OperationField("Name", "Summary", "Class Name", new HashSet<>(), true), null);
  }

  /**
   * Test {@link OperationField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationField.equals(Object)", "int OperationField.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new OperationField("Name", "Summary", "Class Name", new HashSet<>(), true),
        "Different type to OperationField");
  }
}
