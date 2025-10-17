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

package uk.gov.gchq.gaffer.sketches.datasketches.quantiles.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.quantiles.DoublesSketch;
import org.apache.datasketches.quantiles.DoublesUnion;
import org.apache.datasketches.quantiles.UpdateDoublesSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DoublesUnionAggregatorDiffblueTest {
  /**
   * Test {@link DoublesUnionAggregator#_apply(DoublesUnion, DoublesUnion)} with {@code
   * DoublesUnion}, {@code DoublesUnion}.
   *
   * <p>Method under test: {@link DoublesUnionAggregator#_apply(DoublesUnion, DoublesUnion)}
   */
  @Test
  @DisplayName("Test _apply(DoublesUnion, DoublesUnion) with 'DoublesUnion', 'DoublesUnion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoublesUnion DoublesUnionAggregator._apply(DoublesUnion, DoublesUnion)"})
  void test_applyWithDoublesUnionDoublesUnion() {
    // Arrange
    DoublesUnionAggregator doublesUnionAggregator = new DoublesUnionAggregator();

    DoublesUnion a = mock(DoublesUnion.class);
    doNothing().when(a).union(Mockito.<DoublesSketch>any());

    DoublesUnion b = mock(DoublesUnion.class);
    when(b.getResult()).thenReturn(mock(UpdateDoublesSketch.class));

    // Act
    DoublesUnion actual_applyResult = doublesUnionAggregator._apply(a, b);

    // Assert
    verify(b).getResult();
    verify(a).union(isA(DoublesSketch.class));
    assertSame(a, actual_applyResult);
  }
}
