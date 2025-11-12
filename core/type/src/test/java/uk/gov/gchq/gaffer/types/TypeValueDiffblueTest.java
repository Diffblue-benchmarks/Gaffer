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

package uk.gov.gchq.gaffer.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class TypeValueDiffblueTest {
  /**
   * Method under test: {@link TypeValue#compareTo(TypeValue)}
   */
  @Test
  void testCompareTo() {
    // Arrange
    TypeValue typeValue = new TypeValue("Type", "42");

    // Act and Assert
    assertEquals(0, typeValue.compareTo(new TypeValue("Type", "42")));
  }

  /**
   * Method under test: {@link TypeValue#compareTo(TypeValue)}
   */
  @Test
  void testCompareTo2() {
    // Arrange, Act and Assert
    assertEquals(1, (new TypeValue("Type", "42")).compareTo(null));
  }

  /**
   * Method under test: {@link TypeValue#compareTo(TypeValue)}
   */
  @Test
  void testCompareTo3() {
    // Arrange
    TypeValue typeValue = new TypeValue("uk.gov.gchq.gaffer.types.TypeValue", "42");

    // Act and Assert
    assertEquals(33, typeValue.compareTo(new TypeValue("Type", "42")));
  }

  /**
   * Method under test: {@link TypeValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeValue("Type", "42"), null);
  }

  /**
   * Method under test: {@link TypeValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeValue("Type", "42"), "Different type to TypeValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypeValue#TypeValue()}
   *   <li>{@link TypeValue#setType(String)}
   *   <li>{@link TypeValue#setValue(String)}
   *   <li>{@link TypeValue#getType()}
   *   <li>{@link TypeValue#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TypeValue actualTypeValue = new TypeValue();
    actualTypeValue.setType("Type");
    actualTypeValue.setValue("42");
    String actualType = actualTypeValue.getType();

    // Assert that nothing has changed
    assertEquals("42", actualTypeValue.getValue());
    assertEquals("Type", actualType);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypeValue#TypeValue(String, String)}
   *   <li>{@link TypeValue#setType(String)}
   *   <li>{@link TypeValue#setValue(String)}
   *   <li>{@link TypeValue#getType()}
   *   <li>{@link TypeValue#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    TypeValue actualTypeValue = new TypeValue("Type", "42");
    actualTypeValue.setType("Type");
    actualTypeValue.setValue("42");
    String actualType = actualTypeValue.getType();

    // Assert that nothing has changed
    assertEquals("42", actualTypeValue.getValue());
    assertEquals("Type", actualType);
  }
}
