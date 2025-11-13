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

package uk.gov.gchq.gaffer.sketches.datasketches.theta.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.theta.CompactSketch;
import org.apache.datasketches.theta.Sketch;
import org.apache.datasketches.theta.Union;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UnionAggregatorDiffblueTest {
  /**
   * Test {@link UnionAggregator#_apply(Union, Union)} with {@code Union}, {@code Union}.
   *
   * <p>Method under test: {@link UnionAggregator#_apply(Union, Union)}
   */
  @Test
  @DisplayName("Test _apply(Union, Union) with 'Union', 'Union'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Union UnionAggregator._apply(Union, Union)"})
  void test_applyWithUnionUnion() {
    // Arrange
    UnionAggregator unionAggregator = new UnionAggregator();

    Union a = mock(Union.class);
    doNothing().when(a).union(Mockito.<Sketch>any());

    Union b = mock(Union.class);
    when(b.getResult()).thenReturn(mock(CompactSketch.class));

    // Act
    Union actual_applyResult = unionAggregator._apply(a, b);

    // Assert
    verify(b).getResult();
    verify(a).union(isA(Sketch.class));
    assertSame(a, actual_applyResult);
  }
}
