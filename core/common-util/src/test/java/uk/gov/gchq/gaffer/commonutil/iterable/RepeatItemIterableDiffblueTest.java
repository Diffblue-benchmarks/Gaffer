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

package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RepeatItemIterableDiffblueTest {
  /**
   * Test {@link RepeatItemIterable#RepeatItemIterable(Object, long)}.
   *
   * <p>Method under test: {@link RepeatItemIterable#RepeatItemIterable(Object, long)}
   */
  @Test
  @DisplayName("Test new RepeatItemIterable(Object, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RepeatItemIterable.<init>(Object, long)"})
  void testNewRepeatItemIterable() {
    // Arrange and Act
    RepeatItemIterable<Object> actualRepeatItemIterable = new RepeatItemIterable<>("Item", 1L);

    // Assert
    Iterator<Object> iteratorResult = actualRepeatItemIterable.iterator();
    assertTrue(iteratorResult instanceof RepeatItemIterator);
    assertEquals("Item", iteratorResult.next());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link RepeatItemIterable#iterator()}.
   *
   * <p>Method under test: {@link RepeatItemIterable#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator RepeatItemIterable.iterator()"})
  void testIterator() {
    // Arrange
    RepeatItemIterable<Object> repeatItemIterable = new RepeatItemIterable<>("Item", 1L);

    // Act
    Iterator<Object> actualIteratorResult = repeatItemIterable.iterator();

    // Assert
    assertTrue(actualIteratorResult instanceof RepeatItemIterator);
    assertEquals("Item", actualIteratorResult.next());
    assertFalse(actualIteratorResult.hasNext());
  }
}
