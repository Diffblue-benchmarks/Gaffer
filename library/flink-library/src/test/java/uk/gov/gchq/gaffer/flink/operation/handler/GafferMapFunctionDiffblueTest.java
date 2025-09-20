package uk.gov.gchq.gaffer.flink.operation.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.function.Function;
import org.apache.flink.util.Collector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;

class GafferMapFunctionDiffblueTest {
  /**
   * Test {@link GafferMapFunction#GafferMapFunction(Class, Class)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferMapFunction#GafferMapFunction(Class, Class)}
   */
  @Test
  @DisplayName("Test new GafferMapFunction(Class, Class); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewGafferMapFunction_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> consumeAs = Object.class;
    Class<Function> forNameResult = Function.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new GafferMapFunction<>(
                consumeAs,
                (Class<Function<Iterable<?>, Iterable<? extends Element>>>) (Class) forNameResult));
  }

  /**
   * Test {@link GafferMapFunction#setConsumeAs(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferMapFunction#setConsumeAs(Class)}
   */
  @Test
  @DisplayName(
      "Test setConsumeAs(Class); when 'java.lang.Object'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testSetConsumeAs_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    GafferMapFunction<Object> gafferMapFunction = new GafferMapFunction<>();
    Class<Object> consumeAs = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> gafferMapFunction.setConsumeAs(consumeAs));
  }

  /**
   * Test {@link GafferMapFunction#flatMap(Object, Collector)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferMapFunction#flatMap(Object, Collector)}
   */
  @Test
  @DisplayName("Test flatMap(Object, Collector); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testFlatMap_whenNull_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    GafferMapFunction<Object> gafferMapFunction = new GafferMapFunction<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> gafferMapFunction.flatMap("Item", null));
  }
}
