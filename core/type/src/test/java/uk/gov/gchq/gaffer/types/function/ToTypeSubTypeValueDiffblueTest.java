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
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class ToTypeSubTypeValueDiffblueTest {
  /**
   * Method under test: {@link ToTypeSubTypeValue#apply(Object)}
   */
  @Test
  void testApply() {
    // Arrange and Act
    TypeSubTypeValue actualApplyResult = (new ToTypeSubTypeValue()).apply("Value");

    // Assert
    assertEquals("Value", actualApplyResult.getValue());
    assertNull(actualApplyResult.getSubType());
    assertNull(actualApplyResult.getType());
  }

  /**
   * Method under test: {@link ToTypeSubTypeValue#apply(Object)}
   */
  @Test
  void testApply2() {
    // Arrange and Act
    TypeSubTypeValue actualApplyResult = (new ToTypeSubTypeValue()).apply(null);

    // Assert
    assertNull(actualApplyResult.getSubType());
    assertNull(actualApplyResult.getType());
    assertNull(actualApplyResult.getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToTypeSubTypeValue#setSubType(String)}
   *   <li>{@link ToTypeSubTypeValue#setType(String)}
   *   <li>{@link ToTypeSubTypeValue#getSubType()}
   *   <li>{@link ToTypeSubTypeValue#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ToTypeSubTypeValue toTypeSubTypeValue = new ToTypeSubTypeValue();

    // Act
    toTypeSubTypeValue.setSubType("Sub Type");
    toTypeSubTypeValue.setType("Type");
    String actualSubType = toTypeSubTypeValue.getSubType();

    // Assert that nothing has changed
    assertEquals("Sub Type", actualSubType);
    assertEquals("Type", toTypeSubTypeValue.getType());
  }

  /**
   * Method under test: {@link ToTypeSubTypeValue#ToTypeSubTypeValue()}
   */
  @Test
  void testNewToTypeSubTypeValue() {
    // Arrange and Act
    ToTypeSubTypeValue actualToTypeSubTypeValue = new ToTypeSubTypeValue();

    // Assert
    assertNull(actualToTypeSubTypeValue.getSubType());
    assertNull(actualToTypeSubTypeValue.getType());
  }

  /**
   * Method under test:
   * {@link ToTypeSubTypeValue#ToTypeSubTypeValue(String, String)}
   */
  @Test
  void testNewToTypeSubTypeValue2() {
    // Arrange and Act
    ToTypeSubTypeValue actualToTypeSubTypeValue = new ToTypeSubTypeValue("Type", "Sub Type");

    // Assert
    assertEquals("Sub Type", actualToTypeSubTypeValue.getSubType());
    assertEquals("Type", actualToTypeSubTypeValue.getType());
  }
}
