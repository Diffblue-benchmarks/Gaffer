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

package uk.gov.gchq.gaffer.types.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.TypeValue;

class ToTypeValueDiffblueTest {
  /**
   * Test {@link ToTypeValue#ToTypeValue()}.
   *
   * <p>Method under test: {@link ToTypeValue#ToTypeValue()}
   */
  @Test
  @DisplayName("Test new ToTypeValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToTypeValue.<init>()"})
  void testNewToTypeValue() {
    // Arrange, Act and Assert
    assertNull(new ToTypeValue().getType());
  }

  /**
   * Test {@link ToTypeValue#ToTypeValue(String)}.
   *
   * <p>Method under test: {@link ToTypeValue#ToTypeValue(String)}
   */
  @Test
  @DisplayName("Test new ToTypeValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToTypeValue.<init>(String)"})
  void testNewToTypeValue2() {
    // Arrange, Act and Assert
    assertEquals("Type", new ToTypeValue("Type").getType());
  }

  /**
   * Test {@link ToTypeValue#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToTypeValue#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'null'; then return Value is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeValue ToTypeValue.apply(Object)"})
  void testApply_whenNull_thenReturnValueIsNull() {
    // Arrange and Act
    TypeValue actualApplyResult = new ToTypeValue().apply(null);

    // Assert
    assertNull(actualApplyResult.getType());
    assertNull(actualApplyResult.getValue());
  }

  /**
   * Test {@link ToTypeValue#apply(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ToTypeValue#apply(Object)}
   */
  @Test
  @DisplayName("Test apply(Object); when 'Value'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeValue ToTypeValue.apply(Object)"})
  void testApply_whenValue_thenReturnValue() {
    // Arrange and Act
    TypeValue actualApplyResult = new ToTypeValue().apply("Value");

    // Assert
    assertEquals("Value", actualApplyResult.getValue());
    assertNull(actualApplyResult.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToTypeValue#setType(String)}
   *   <li>{@link ToTypeValue#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ToTypeValue.getType()", "void ToTypeValue.setType(String)"})
  void testGettersAndSetters() {
    // Arrange
    ToTypeValue toTypeValue = new ToTypeValue();

    // Act
    toTypeValue.setType("Type");

    // Assert
    assertEquals("Type", toTypeValue.getType());
  }
}
