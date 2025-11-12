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
import uk.gov.gchq.gaffer.types.TypeValue;

class ToTypeValueDiffblueTest {
  /**
   * Method under test: {@link ToTypeValue#apply(Object)}
   */
  @Test
  void testApply() {
    // Arrange and Act
    TypeValue actualApplyResult = (new ToTypeValue()).apply("Value");

    // Assert
    assertEquals("Value", actualApplyResult.getValue());
    assertNull(actualApplyResult.getType());
  }

  /**
   * Method under test: {@link ToTypeValue#apply(Object)}
   */
  @Test
  void testApply2() {
    // Arrange and Act
    TypeValue actualApplyResult = (new ToTypeValue()).apply(null);

    // Assert
    assertNull(actualApplyResult.getType());
    assertNull(actualApplyResult.getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToTypeValue#setType(String)}
   *   <li>{@link ToTypeValue#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ToTypeValue toTypeValue = new ToTypeValue();

    // Act
    toTypeValue.setType("Type");

    // Assert that nothing has changed
    assertEquals("Type", toTypeValue.getType());
  }

  /**
   * Method under test: {@link ToTypeValue#ToTypeValue()}
   */
  @Test
  void testNewToTypeValue() {
    // Arrange, Act and Assert
    assertNull((new ToTypeValue()).getType());
    assertEquals("Type", (new ToTypeValue("Type")).getType());
  }
}
