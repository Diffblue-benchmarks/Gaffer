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

package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class TypeSubTypeValueToTupleDiffblueTest {
  /**
   * Test {@link TypeSubTypeValueToTuple#apply(TypeSubTypeValue)} with {@code TypeSubTypeValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueToTuple#apply(TypeSubTypeValue)}
   */
  @Test
  @DisplayName(
      "Test apply(TypeSubTypeValue) with 'TypeSubTypeValue'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeSubTypeValueTuple TypeSubTypeValueToTuple.apply(TypeSubTypeValue)"})
  void testApplyWithTypeSubTypeValue_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TypeSubTypeValueToTuple().apply(null));
  }

  /**
   * Test {@link TypeSubTypeValueToTuple#apply(TypeSubTypeValue)} with {@code TypeSubTypeValue}.
   *
   * <ul>
   *   <li>When {@link TypeSubTypeValue#TypeSubTypeValue()}.
   *   <li>Then values return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueToTuple#apply(TypeSubTypeValue)}
   */
  @Test
  @DisplayName(
      "Test apply(TypeSubTypeValue) with 'TypeSubTypeValue'; when TypeSubTypeValue(); then values return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeSubTypeValueTuple TypeSubTypeValueToTuple.apply(TypeSubTypeValue)"})
  void testApplyWithTypeSubTypeValue_whenTypeSubTypeValue_thenValuesReturnList() {
    // Arrange
    TypeSubTypeValueToTuple typeSubTypeValueToTuple = new TypeSubTypeValueToTuple();

    // Act
    TypeSubTypeValueTuple actualApplyResult = typeSubTypeValueToTuple.apply(new TypeSubTypeValue());

    // Assert
    Iterable<Object> valuesResult = actualApplyResult.values();
    assertTrue(valuesResult instanceof List);
    Iterator<Object> iteratorResult = actualApplyResult.iterator();
    assertNull(iteratorResult.next());
    assertNull(iteratorResult.next());
    assertNull(iteratorResult.next());
    assertEquals(3, ((List<Object>) valuesResult).size());
    assertNull(((List<Object>) valuesResult).get(0));
    assertNull(((List<Object>) valuesResult).get(1));
    assertNull(((List<Object>) valuesResult).get(2));
    assertEquals(-1L, actualApplyResult.spliterator().getExactSizeIfKnown());
    assertFalse(iteratorResult.hasNext());
  }
}
