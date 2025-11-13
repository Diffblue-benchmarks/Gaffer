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

package uk.gov.gchq.gaffer.flink.operation.handler;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferMapFunction.<init>(Class, Class)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferMapFunction.setConsumeAs(Class)"})
  void testSetConsumeAs_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    GafferMapFunction<Object> gafferMapFunction = new GafferMapFunction<>();
    Class<Object> consumeAs = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> gafferMapFunction.setConsumeAs(consumeAs));
  }

  /**
   * Test {@link GafferMapFunction#setConsumeAs(Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link GafferMapFunction#setConsumeAs(Class)}
   */
  @Test
  @DisplayName("Test setConsumeAs(Class); when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferMapFunction.setConsumeAs(Class)"})
  void testSetConsumeAs_whenNull_thenDoesNotThrow() {
    // Arrange
    GafferMapFunction<Object> gafferMapFunction = new GafferMapFunction<>();

    // Act and Assert
    assertDoesNotThrow(() -> gafferMapFunction.setConsumeAs(null));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferMapFunction.flatMap(Object, Collector)"})
  void testFlatMap_whenNull_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    GafferMapFunction<Object> gafferMapFunction = new GafferMapFunction<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> gafferMapFunction.flatMap("Item", null));
  }
}
