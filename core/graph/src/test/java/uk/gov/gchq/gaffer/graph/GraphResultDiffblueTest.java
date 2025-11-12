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

package uk.gov.gchq.gaffer.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.Context;

class GraphResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GraphResult#equals(Object)}
   *   <li>{@link GraphResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GraphResult<Object> graphResult = new GraphResult<>("Result", new Context());

    // Act and Assert
    assertEquals(graphResult, graphResult);
    int expectedHashCodeResult = graphResult.hashCode();
    assertEquals(expectedHashCodeResult, graphResult.hashCode());
  }

  /**
   * Method under test: {@link GraphResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GraphResult<Object> graphResult = new GraphResult<>("Result", new Context());

    // Act and Assert
    assertNotEquals(graphResult, new GraphResult<>("Result", new Context()));
  }

  /**
   * Method under test: {@link GraphResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    GraphResult<Object> graphResult = new GraphResult<>("Result", new Context());

    GraphResult<Object> graphResult2 = new GraphResult<>(graphResult, new Context());

    // Act and Assert
    assertNotEquals(graphResult2, new GraphResult<>("Result", new Context()));
  }

  /**
   * Method under test: {@link GraphResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Context context = mock(Context.class);
    GraphResult<Object> graphResult = new GraphResult<>(context, new Context());

    // Act and Assert
    assertNotEquals(graphResult, new GraphResult<>("Result", new Context()));
  }

  /**
   * Method under test: {@link GraphResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    GraphResult<Object> graphResult = new GraphResult<>("Result", new Context());

    // Act and Assert
    assertNotEquals(graphResult, null);
  }

  /**
   * Method under test: {@link GraphResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    GraphResult<Object> graphResult = new GraphResult<>("Result", new Context());

    // Act and Assert
    assertNotEquals(graphResult, "Different type to GraphResult");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GraphResult#GraphResult(Object, Context)}
   *   <li>{@link GraphResult#getContext()}
   *   <li>{@link GraphResult#getResult()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Context context = new Context();

    // Act
    GraphResult<Object> actualGraphResult = new GraphResult<>("Result", context);
    Context actualContext = actualGraphResult.getContext();

    // Assert
    assertEquals("Result", actualGraphResult.getResult());
    assertSame(context, actualContext);
  }
}
