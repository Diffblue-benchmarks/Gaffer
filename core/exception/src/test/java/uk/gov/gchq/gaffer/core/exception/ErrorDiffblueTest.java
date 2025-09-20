package uk.gov.gchq.gaffer.core.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Error.ErrorBuilder;

class ErrorDiffblueTest {
  /**
   * Test ErrorBuilder {@link ErrorBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorBuilder#build()}
   *   <li>default or parameterless constructor of {@link ErrorBuilder}
   *   <li>{@link ErrorBuilder#detailMessage(String)}
   *   <li>{@link ErrorBuilder#simpleMessage(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test ErrorBuilder build()")
  @Tag("MaintainedByDiffblue")
  void testErrorBuilderBuild() {
    // Arrange and Act
    Error actualError =
        new ErrorBuilder().detailMessage("Detail Message").simpleMessage("Simple Message").build();

    // Assert
    assertEquals("Simple Message", actualError.getSimpleMessage());
    assertNull(actualError.getDetailMessage());
    assertNull(actualError.getStatus());
    assertEquals(0, actualError.getStatusCode());
  }

  /**
   * Test ErrorBuilder {@link ErrorBuilder#status(Status)}.
   *
   * <p>Method under test: {@link ErrorBuilder#status(Status)}
   */
  @Test
  @DisplayName("Test ErrorBuilder status(Status)")
  @Tag("MaintainedByDiffblue")
  void testErrorBuilderStatus() {
    // Arrange
    ErrorBuilder errorBuilder = new ErrorBuilder();

    // Act
    ErrorBuilder actualStatusResult = errorBuilder.status(Status.CONTINUE);

    // Assert
    assertSame(errorBuilder, actualStatusResult);
  }

  /**
   * Test ErrorBuilder {@link ErrorBuilder#statusCode(int)}.
   *
   * <ul>
   *   <li>When one hundred one.
   *   <li>Then return {@link ErrorBuilder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ErrorBuilder#statusCode(int)}
   */
  @Test
  @DisplayName(
      "Test ErrorBuilder statusCode(int); when one hundred one; then return ErrorBuilder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testErrorBuilderStatusCode_whenOneHundredOne_thenReturnErrorBuilder() {
    // Arrange
    ErrorBuilder errorBuilder = new ErrorBuilder();

    // Act
    ErrorBuilder actualStatusCodeResult = errorBuilder.statusCode(101);

    // Assert
    assertSame(errorBuilder, actualStatusCodeResult);
  }

  /**
   * Test ErrorBuilder {@link ErrorBuilder#statusCode(int)}.
   *
   * <ul>
   *   <li>When one hundred.
   *   <li>Then return {@link ErrorBuilder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ErrorBuilder#statusCode(int)}
   */
  @Test
  @DisplayName(
      "Test ErrorBuilder statusCode(int); when one hundred; then return ErrorBuilder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testErrorBuilderStatusCode_whenOneHundred_thenReturnErrorBuilder() {
    // Arrange
    ErrorBuilder errorBuilder = new ErrorBuilder();

    // Act
    ErrorBuilder actualStatusCodeResult = errorBuilder.statusCode(100);

    // Assert
    assertSame(errorBuilder, actualStatusCodeResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Error#toString()}
   *   <li>{@link Error#getDetailMessage()}
   *   <li>{@link Error#getSimpleMessage()}
   *   <li>{@link Error#getStatus()}
   *   <li>{@link Error#getStatusCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange
    Error error =
        new ErrorBuilder().detailMessage("Detail Message").simpleMessage("Simple Message").build();

    // Act
    String actualToStringResult = error.toString();
    String actualDetailMessage = error.getDetailMessage();
    String actualSimpleMessage = error.getSimpleMessage();
    Status actualStatus = error.getStatus();

    // Assert
    assertEquals("Error[statusCode=0,simpleMessage=Simple Message]", actualToStringResult);
    assertEquals("Simple Message", actualSimpleMessage);
    assertNull(actualDetailMessage);
    assertNull(actualStatus);
    assertEquals(0, error.getStatusCode());
  }

  /**
   * Test {@link Error#equals(Object)}, and {@link Error#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Error#equals(Object)}
   *   <li>{@link Error#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Error error =
        new ErrorBuilder().detailMessage("Detail Message").simpleMessage("Simple Message").build();
    Error error2 =
        new ErrorBuilder().detailMessage("Detail Message").simpleMessage("Simple Message").build();

    // Act and Assert
    assertEquals(error, error2);
    assertEquals(error.hashCode(), error2.hashCode());
  }

  /**
   * Test {@link Error#equals(Object)}, and {@link Error#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Error#equals(Object)}
   *   <li>{@link Error#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Error error =
        new ErrorBuilder().detailMessage("Detail Message").simpleMessage("Simple Message").build();

    // Act and Assert
    assertEquals(error, error);
    int expectedHashCodeResult = error.hashCode();
    assertEquals(expectedHashCodeResult, error.hashCode());
  }

  /**
   * Test {@link Error#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Error#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Error error = new ErrorBuilder().detailMessage("Detail Message").simpleMessage("42").build();

    // Act and Assert
    assertNotEquals(
        error,
        new ErrorBuilder().detailMessage("Detail Message").simpleMessage("Simple Message").build());
  }

  /**
   * Test {@link Error#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Error#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ErrorBuilder().detailMessage("Detail Message").simpleMessage("Simple Message").build(),
        null);
  }

  /**
   * Test {@link Error#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Error#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ErrorBuilder().detailMessage("Detail Message").simpleMessage("Simple Message").build(),
        "Different type to Error");
  }
}
