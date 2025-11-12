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

package uk.gov.gchq.gaffer.tinkerpop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.apache.tinkerpop.gremlin.structure.Element;
import org.apache.tinkerpop.gremlin.structure.util.detached.DetachedEdge;
import org.junit.Test;

public class GafferPopPropertyDiffblueTest {
  /**
   * Method under test: {@link GafferPopProperty#isPresent()}
   */
  @Test
  public void testIsPresent() {
    // Arrange
    GafferPopProperty<Object> gafferPopProperty = new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null),
        "Key", "Value");

    // Act and Assert
    assertTrue(gafferPopProperty.isPresent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GafferPopProperty#equals(Object)}
   *   <li>{@link GafferPopProperty#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GafferPopProperty<Object> gafferPopProperty = new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null),
        "Key", "Value");
    GafferPopProperty<Object> gafferPopProperty2 = new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null),
        "Key", "Value");

    // Act and Assert
    assertEquals(gafferPopProperty, gafferPopProperty2);
    int expectedHashCodeResult = gafferPopProperty.hashCode();
    assertEquals(expectedHashCodeResult, gafferPopProperty2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GafferPopProperty#equals(Object)}
   *   <li>{@link GafferPopProperty#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    GafferPopProperty<Object> gafferPopProperty = new GafferPopProperty<>(mock(DetachedEdge.class), "Key", "Value");
    GafferPopProperty<Object> gafferPopProperty2 = new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null),
        "Key", "Value");

    // Act and Assert
    assertEquals(gafferPopProperty, gafferPopProperty2);
    int expectedHashCodeResult = gafferPopProperty.hashCode();
    assertEquals(expectedHashCodeResult, gafferPopProperty2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GafferPopProperty#equals(Object)}
   *   <li>{@link GafferPopProperty#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GafferPopProperty<Object> gafferPopProperty = new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null),
        "Key", "Value");

    // Act and Assert
    assertEquals(gafferPopProperty, gafferPopProperty);
    int expectedHashCodeResult = gafferPopProperty.hashCode();
    assertEquals(expectedHashCodeResult, gafferPopProperty.hashCode());
  }

  /**
   * Method under test: {@link GafferPopProperty#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GafferPopProperty<Object> gafferPopProperty = new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null),
        "42", "Value");

    // Act and Assert
    assertNotEquals(gafferPopProperty,
        new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null), "Key", "Value"));
  }

  /**
   * Method under test: {@link GafferPopProperty#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    GafferPopProperty<Object> gafferPopProperty = new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null),
        "Key", "Value");

    // Act and Assert
    assertNotEquals(gafferPopProperty, null);
  }

  /**
   * Method under test: {@link GafferPopProperty#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    GafferPopProperty<Object> gafferPopProperty = new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null),
        "Key", "Value");

    // Act and Assert
    assertNotEquals(gafferPopProperty, "Different type to GafferPopProperty");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GafferPopProperty#GafferPopProperty(Element, String, Object)}
   *   <li>{@link GafferPopProperty#toString()}
   *   <li>{@link GafferPopProperty#element()}
   *   <li>{@link GafferPopProperty#key()}
   *   <li>{@link GafferPopProperty#value()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    GafferPopVertex element = new GafferPopVertex("Label", "Id", null);

    // Act
    GafferPopProperty<Object> actualGafferPopProperty = new GafferPopProperty<>(element, "Key", "Value");
    String actualToStringResult = actualGafferPopProperty.toString();
    Element actualElementResult = actualGafferPopProperty.element();
    String actualKeyResult = actualGafferPopProperty.key();

    // Assert
    assertEquals("Key", actualKeyResult);
    assertEquals("Value", actualGafferPopProperty.value());
    assertEquals("p[Key->Value]", actualToStringResult);
    assertSame(element, actualElementResult);
  }
}
