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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GafferPopElementDiffblueTest {
  /**
   * Method under test: {@link GafferPopElement#id()}
   */
  @Test
  public void testId() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    // Act
    Object actualIdResult = gafferPopVertex.id();

    // Assert
    assertEquals("Id", actualIdResult);
    assertSame(gafferPopVertex.id, actualIdResult);
  }

  /**
   * Method under test: {@link GafferPopElement#label()}
   */
  @Test
  public void testLabel() {
    // Arrange, Act and Assert
    assertEquals("Label", (new GafferPopVertex("Label", "Id", null)).label());
  }

  /**
   * Method under test: {@link GafferPopElement#setReadOnly()}
   */
  @Test
  public void testSetReadOnly() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    // Act
    gafferPopVertex.setReadOnly();

    // Assert
    assertTrue(gafferPopVertex.isReadOnly());
  }

  /**
   * Method under test: {@link GafferPopElement#isReadOnly()}
   */
  @Test
  public void testIsReadOnly() {
    // Arrange, Act and Assert
    assertFalse((new GafferPopVertex("Label", "Id", null)).isReadOnly());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GafferPopElement#equals(Object)}
   *   <li>{@link GafferPopElement#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);
    GafferPopVertex gafferPopVertex2 = new GafferPopVertex("Label", "Id", null);

    // Act and Assert
    assertEquals(gafferPopVertex, gafferPopVertex2);
    int expectedHashCodeResult = gafferPopVertex.hashCode();
    assertEquals(expectedHashCodeResult, gafferPopVertex2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GafferPopElement#equals(Object)}
   *   <li>{@link GafferPopElement#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    // Act and Assert
    assertEquals(gafferPopVertex, gafferPopVertex);
    int expectedHashCodeResult = gafferPopVertex.hashCode();
    assertEquals(expectedHashCodeResult, gafferPopVertex.hashCode());
  }

  /**
   * Method under test: {@link GafferPopElement#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", 1, null);

    // Act and Assert
    assertNotEquals(gafferPopVertex, new GafferPopVertex("Label", "Id", null));
  }

  /**
   * Method under test: {@link GafferPopElement#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GafferPopVertex("Label", "Id", null), null);
  }

  /**
   * Method under test: {@link GafferPopElement#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GafferPopVertex("Label", "Id", null), "Different type to GafferPopElement");
  }
}
