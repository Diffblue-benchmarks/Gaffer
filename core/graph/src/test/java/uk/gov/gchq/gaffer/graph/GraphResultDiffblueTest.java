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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.user.User;

class GraphResultDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GraphResult#GraphResult(Object, Context)}
   *   <li>{@link GraphResult#toString()}
   *   <li>{@link GraphResult#getContext()}
   *   <li>{@link GraphResult#getResult()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphResult.<init>(Object, Context)", "Context GraphResult.getContext()",
      "Object GraphResult.getResult()", "java.lang.String GraphResult.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();

    // Act
    GraphResult<Object> actualGraphResult = new GraphResult<>("Result", context);
    actualGraphResult.toString();
    Context actualContext = actualGraphResult.getContext();

    // Assert
    assertEquals("Result", actualGraphResult.getResult());
    assertSame(context, actualContext);
  }

  /**
   * Test {@link GraphResult#equals(Object)}, and {@link GraphResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GraphResult#equals(Object)}
   *   <li>{@link GraphResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphResult.equals(Object)", "int GraphResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    GraphResult<Object> graphResult = new GraphResult<>("Result", context);

    // Act and Assert
    assertEquals(graphResult, graphResult);
    int expectedHashCodeResult = graphResult.hashCode();
    assertEquals(expectedHashCodeResult, graphResult.hashCode());
  }

  /**
   * Test {@link GraphResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphResult.equals(Object)", "int GraphResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    GraphResult<Object> graphResult = new GraphResult<>("Result", context);

    Builder builder2 = new Builder();
    User user2 = (new User.Builder()).userId("42").build();
    Context context2 = builder2.user(user2).build();

    // Act and Assert
    assertNotEquals(graphResult, new GraphResult<>("Result", context2));
  }

  /**
   * Test {@link GraphResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphResult.equals(Object)", "int GraphResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    GraphResult<Object> graphResult = new GraphResult<>("Result", context);

    Builder builder2 = new Builder();
    User user2 = (new User.Builder()).userId("42").build();
    Context context2 = builder2.user(user2).build();
    GraphResult<Object> graphResult2 = new GraphResult<>(graphResult, context2);

    Builder builder3 = new Builder();
    User user3 = (new User.Builder()).userId("42").build();
    Context context3 = builder3.user(user3).build();

    // Act and Assert
    assertNotEquals(graphResult2, new GraphResult<>("Result", context3));
  }

  /**
   * Test {@link GraphResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphResult.equals(Object)", "int GraphResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    GraphResult<Object> graphResult = new GraphResult<>("Result", context);

    // Act and Assert
    assertNotEquals(graphResult, null);
  }

  /**
   * Test {@link GraphResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphResult.equals(Object)", "int GraphResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    GraphResult<Object> graphResult = new GraphResult<>("Result", context);

    // Act and Assert
    assertNotEquals(graphResult, "Different type to GraphResult");
  }
}
