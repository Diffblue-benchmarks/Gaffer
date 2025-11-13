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

package uk.gov.gchq.gaffer.federated.simple.merge.operator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;

class ElementAggregateOperatorDiffblueTest {
  /**
   * Test {@link ElementAggregateOperator#apply(Iterable, Iterable)} with {@code Iterable}, {@code Iterable}.
   * <p>
   * Method under test: {@link ElementAggregateOperator#apply(Iterable, Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable, Iterable) with 'Iterable', 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable ElementAggregateOperator.apply(Iterable, Iterable)"})
  void testApplyWithIterableIterable() {
    // Arrange
    ElementAggregateOperator elementAggregateOperator = new ElementAggregateOperator();
    ArrayList<Element> update = new ArrayList<>();

    // Act
    Iterable<Element> actualApplyResult = elementAggregateOperator.apply(update, new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof Set);
    assertFalse(actualApplyResult.iterator().hasNext());
    assertTrue(((Set<Element>) actualApplyResult).isEmpty());
  }
}
