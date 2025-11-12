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

class TypeSubTypeValueDiffblueTest {
  /**
   * Method under test: {@link TypeSubTypeValue#compareTo(TypeSubTypeValue)}
   */
  @Test
  void testCompareTo() {
    // Arrange
    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("Type", "Sub Type", "42");

    // Act and Assert
    assertEquals(0, typeSubTypeValue.compareTo(new TypeSubTypeValue("Type", "Sub Type", "42")));
  }

  /**
   * Method under test: {@link TypeSubTypeValue#compareTo(TypeSubTypeValue)}
   */
  @Test
  void testCompareTo2() {
    // Arrange, Act and Assert
    assertEquals(1, (new TypeSubTypeValue("Type", "Sub Type", "42")).compareTo(null));
  }

  /**
   * Method under test: {@link TypeSubTypeValue#compareTo(TypeSubTypeValue)}
   */
  @Test
  void testCompareTo3() {
    // Arrange
    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("uk.gov.gchq.gaffer.types.TypeSubTypeValue", "Sub Type",
        "42");

    // Act and Assert
    assertEquals(33, typeSubTypeValue.compareTo(new TypeSubTypeValue("Type", "Sub Type", "42")));
  }

  /**
   * Method under test: {@link TypeSubTypeValue#compareTo(TypeSubTypeValue)}
   */
  @Test
  void testCompareTo4() {
    // Arrange
    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("Type", "uk.gov.gchq.gaffer.types.TypeSubTypeValue", "42");

    // Act and Assert
    assertEquals(34, typeSubTypeValue.compareTo(new TypeSubTypeValue("Type", "Sub Type", "42")));
  }

  /**
   * Method under test: {@link TypeSubTypeValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeSubTypeValue("Type", "Sub Type", "42"), null);
  }

  /**
   * Method under test: {@link TypeSubTypeValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeSubTypeValue("Type", "Sub Type", "42"), "Different type to TypeSubTypeValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypeSubTypeValue#TypeSubTypeValue()}
   *   <li>{@link TypeSubTypeValue#setSubType(String)}
   *   <li>{@link TypeSubTypeValue#setType(String)}
   *   <li>{@link TypeSubTypeValue#setValue(String)}
   *   <li>{@link TypeSubTypeValue#getSubType()}
   *   <li>{@link TypeSubTypeValue#getType()}
   *   <li>{@link TypeSubTypeValue#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TypeSubTypeValue actualTypeSubTypeValue = new TypeSubTypeValue();
    actualTypeSubTypeValue.setSubType("Sub Type");
    actualTypeSubTypeValue.setType("Type");
    actualTypeSubTypeValue.setValue("42");
    String actualSubType = actualTypeSubTypeValue.getSubType();
    String actualType = actualTypeSubTypeValue.getType();

    // Assert that nothing has changed
    assertEquals("42", actualTypeSubTypeValue.getValue());
    assertEquals("Sub Type", actualSubType);
    assertEquals("Type", actualType);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypeSubTypeValue#TypeSubTypeValue(String, String, String)}
   *   <li>{@link TypeSubTypeValue#setSubType(String)}
   *   <li>{@link TypeSubTypeValue#setType(String)}
   *   <li>{@link TypeSubTypeValue#setValue(String)}
   *   <li>{@link TypeSubTypeValue#getSubType()}
   *   <li>{@link TypeSubTypeValue#getType()}
   *   <li>{@link TypeSubTypeValue#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    TypeSubTypeValue actualTypeSubTypeValue = new TypeSubTypeValue("Type", "Sub Type", "42");
    actualTypeSubTypeValue.setSubType("Sub Type");
    actualTypeSubTypeValue.setType("Type");
    actualTypeSubTypeValue.setValue("42");
    String actualSubType = actualTypeSubTypeValue.getSubType();
    String actualType = actualTypeSubTypeValue.getType();

    // Assert that nothing has changed
    assertEquals("42", actualTypeSubTypeValue.getValue());
    assertEquals("Sub Type", actualSubType);
    assertEquals("Type", actualType);
  }
}
