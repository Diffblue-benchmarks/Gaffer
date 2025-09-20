package uk.gov.gchq.gaffer.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.user.User;

class GraphResultDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  void testGettersAndSetters() {
    // Arrange
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();

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
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GraphResult#equals(Object)}
   *   <li>{@link GraphResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    GraphResult<Object> graphResult = new GraphResult<>("Result", context);

    // Act and Assert
    assertEquals(graphResult, graphResult);
    int expectedHashCodeResult = graphResult.hashCode();
    assertEquals(expectedHashCodeResult, graphResult.hashCode());
  }

  /**
   * Test {@link GraphResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GraphResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    GraphResult<Object> graphResult = new GraphResult<>("Result", context);

    Builder builder2 = new Builder();
    Context context2 = builder2.user(new User.Builder().userId("42").build()).build();

    // Act and Assert
    assertNotEquals(graphResult, new GraphResult<>("Result", context2));
  }

  /**
   * Test {@link GraphResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GraphResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    GraphResult<Object> graphResult = new GraphResult<>("Result", context);

    Builder builder2 = new Builder();
    Context context2 = builder2.user(new User.Builder().userId("42").build()).build();

    GraphResult<Object> graphResult2 = new GraphResult<>(graphResult, context2);

    Builder builder3 = new Builder();
    Context context3 = builder3.user(new User.Builder().userId("42").build()).build();

    // Act and Assert
    assertNotEquals(graphResult2, new GraphResult<>("Result", context3));
  }

  /**
   * Test {@link GraphResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GraphResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    GraphResult<Object> graphResult = new GraphResult<>("Result", context);

    // Act and Assert
    assertNotEquals(graphResult, null);
  }

  /**
   * Test {@link GraphResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GraphResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    GraphResult<Object> graphResult = new GraphResult<>("Result", context);

    // Act and Assert
    assertNotEquals(graphResult, "Different type to GraphResult");
  }
}
