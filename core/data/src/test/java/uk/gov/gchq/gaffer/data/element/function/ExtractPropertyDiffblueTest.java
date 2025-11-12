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

package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;

class ExtractPropertyDiffblueTest {
  /**
   * Method under test: {@link ExtractProperty#apply(Element)}
   */
  @Test
  void testApply() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("Name");

    // Act and Assert
    assertNull(extractProperty.apply(new Edge("Group")));
  }

  /**
   * Method under test: {@link ExtractProperty#apply(Element)}
   */
  @Test
  void testApply2() {
    // Arrange, Act and Assert
    assertNull((new ExtractProperty("Name")).apply(null));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractProperty#equals(Object)}
   *   <li>{@link ExtractProperty#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("Name");
    ExtractProperty extractProperty2 = new ExtractProperty("Name");

    // Act and Assert
    assertEquals(extractProperty, extractProperty2);
    int expectedHashCodeResult = extractProperty.hashCode();
    assertEquals(expectedHashCodeResult, extractProperty2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractProperty#equals(Object)}
   *   <li>{@link ExtractProperty#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("Name");

    // Act and Assert
    assertEquals(extractProperty, extractProperty);
    int expectedHashCodeResult = extractProperty.hashCode();
    assertEquals(expectedHashCodeResult, extractProperty.hashCode());
  }

  /**
   * Method under test: {@link ExtractProperty#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("uk.gov.gchq.gaffer.data.element.function.ExtractProperty");

    // Act and Assert
    assertNotEquals(extractProperty, new ExtractProperty("Name"));
  }

  /**
   * Method under test: {@link ExtractProperty#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExtractProperty("Name"), null);
  }

  /**
   * Method under test: {@link ExtractProperty#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExtractProperty("Name"), "Different type to ExtractProperty");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractProperty#ExtractProperty()}
   *   <li>{@link ExtractProperty#setName(String)}
   *   <li>{@link ExtractProperty#toString()}
   *   <li>{@link ExtractProperty#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ExtractProperty actualExtractProperty = new ExtractProperty();
    actualExtractProperty.setName("Name");
    actualExtractProperty.toString();

    // Assert that nothing has changed
    assertEquals("Name", actualExtractProperty.getName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractProperty#ExtractProperty(String)}
   *   <li>{@link ExtractProperty#setName(String)}
   *   <li>{@link ExtractProperty#toString()}
   *   <li>{@link ExtractProperty#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ExtractProperty actualExtractProperty = new ExtractProperty("Name");
    actualExtractProperty.setName("Name");
    actualExtractProperty.toString();

    // Assert that nothing has changed
    assertEquals("Name", actualExtractProperty.getName());
  }
}
