/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.sketches.datasketches.theta.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.theta.CompactSketch;
import org.apache.datasketches.theta.Sketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SketchAggregatorDiffblueTest {
  /**
   * Test {@link SketchAggregator#_apply(Sketch, Sketch)} with {@code Sketch}, {@code Sketch}.
   *
   * <ul>
   *   <li>Then return RetainedEntries is zero.
   * </ul>
   *
   * <p>Method under test: {@link SketchAggregator#_apply(Sketch, Sketch)}
   */
  @Test
  @DisplayName(
      "Test _apply(Sketch, Sketch) with 'Sketch', 'Sketch'; then return RetainedEntries is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sketch SketchAggregator._apply(Sketch, Sketch)"})
  void test_applyWithSketchSketch_thenReturnRetainedEntriesIsZero() {
    // Arrange
    SketchAggregator sketchAggregator = new SketchAggregator();

    Sketch a = mock(Sketch.class);
    when(a.isEmpty()).thenReturn(true);

    Sketch b = mock(Sketch.class);
    when(b.isEmpty()).thenReturn(true);

    // Act
    Sketch actual_applyResult = sketchAggregator._apply(a, b);

    // Assert
    verify(a).isEmpty();
    verify(b).isEmpty();
    assertEquals(0, actual_applyResult.getRetainedEntries());
    assertEquals(1.0d, actual_applyResult.getTheta());
    CompactSketch actualCompactResult = actual_applyResult.compact();
    assertSame(actual_applyResult, actualCompactResult);
  }

  /**
   * Test {@link SketchAggregator#_apply(Sketch, Sketch)} with {@code Sketch}, {@code Sketch}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return RetainedEntries is zero.
   * </ul>
   *
   * <p>Method under test: {@link SketchAggregator#_apply(Sketch, Sketch)}
   */
  @Test
  @DisplayName(
      "Test _apply(Sketch, Sketch) with 'Sketch', 'Sketch'; when 'null'; then return RetainedEntries is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sketch SketchAggregator._apply(Sketch, Sketch)"})
  void test_applyWithSketchSketch_whenNull_thenReturnRetainedEntriesIsZero() {
    // Arrange
    SketchAggregator sketchAggregator = new SketchAggregator();

    Sketch a = mock(Sketch.class);
    when(a.isEmpty()).thenReturn(true);

    // Act
    Sketch actual_applyResult = sketchAggregator._apply(a, null);

    // Assert
    verify(a).isEmpty();
    assertEquals(0, actual_applyResult.getRetainedEntries());
    assertEquals(1.0d, actual_applyResult.getTheta());
    CompactSketch actualCompactResult = actual_applyResult.compact();
    assertSame(actual_applyResult, actualCompactResult);
  }
}
