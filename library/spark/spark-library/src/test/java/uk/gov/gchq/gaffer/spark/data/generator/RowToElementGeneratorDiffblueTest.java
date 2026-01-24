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

package uk.gov.gchq.gaffer.spark.data.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;

class RowToElementGeneratorDiffblueTest {
  /**
   * Test {@link RowToElementGenerator#apply(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then return spliterator ExactSizeIfKnown is minus one.
   * </ul>
   *
   * <p>Method under test: {@link RowToElementGenerator#apply(Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Iterable) with 'Iterable'; then return spliterator ExactSizeIfKnown is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable RowToElementGenerator.apply(Iterable)"})
  void testApplyWithIterable_thenReturnSpliteratorExactSizeIfKnownIsMinusOne() {
    // Arrange
    RowToElementGenerator rowToElementGenerator = new RowToElementGenerator();

    // Act
    Iterable<? extends Element> actualApplyResult = rowToElementGenerator.apply(new ArrayList<>());
    Iterator<? extends Element> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertEquals(-1L, actualApplyResult.spliterator().getExactSizeIfKnown());
    assertFalse(actualIteratorResult.hasNext());
  }
}
