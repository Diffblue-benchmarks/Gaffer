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

package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CachingIterableDiffblueTest {
  /**
   * Test {@link CachingIterable#CachingIterable(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link CachingIterable#CachingIterable(Iterable)}
   */
  @Test
  @DisplayName(
      "Test new CachingIterable(Iterable); when ArrayList(); then return not iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CachingIterable.<init>(Iterable)"})
  void testNewCachingIterable_whenArrayList_thenReturnNotIteratorHasNext() {
    // Arrange and Act
    CachingIterable<Object> actualCachingIterable = new CachingIterable<>(new ArrayList<>());

    // Assert
    assertFalse(actualCachingIterable.iterator().hasNext());
  }

  /**
   * Test {@link CachingIterable#CachingIterable(Iterable, int)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link CachingIterable#CachingIterable(Iterable, int)}
   */
  @Test
  @DisplayName(
      "Test new CachingIterable(Iterable, int); when ArrayList(); then return not iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CachingIterable.<init>(Iterable, int)"})
  void testNewCachingIterable_whenArrayList_thenReturnNotIteratorHasNext2() {
    // Arrange and Act
    CachingIterable<Object> actualCachingIterable = new CachingIterable<>(new ArrayList<>(), 3);

    // Assert
    assertFalse(actualCachingIterable.iterator().hasNext());
  }

  /**
   * Test {@link CachingIterable#CachingIterable(Iterable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link CachingIterable#CachingIterable(Iterable)}
   */
  @Test
  @DisplayName("Test new CachingIterable(Iterable); when 'null'; then return not iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CachingIterable.<init>(Iterable)"})
  void testNewCachingIterable_whenNull_thenReturnNotIteratorHasNext() {
    // Arrange and Act
    CachingIterable<Object> actualCachingIterable = new CachingIterable<>(null);

    // Assert
    assertFalse(actualCachingIterable.iterator().hasNext());
  }

  /**
   * Test {@link CachingIterable#CachingIterable(Iterable, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link CachingIterable#CachingIterable(Iterable, int)}
   */
  @Test
  @DisplayName(
      "Test new CachingIterable(Iterable, int); when 'null'; then return not iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CachingIterable.<init>(Iterable, int)"})
  void testNewCachingIterable_whenNull_thenReturnNotIteratorHasNext2() {
    // Arrange and Act
    CachingIterable<Object> actualCachingIterable = new CachingIterable<>(null, 3);

    // Assert
    assertFalse(actualCachingIterable.iterator().hasNext());
  }

  /**
   * Test {@link CachingIterable#iterator()}.
   *
   * <p>Method under test: {@link CachingIterable#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator CachingIterable.iterator()"})
  void testIterator() {
    // Arrange
    CachingIterable<Object> cachingIterable = new CachingIterable<>(new ArrayList<>(), 3);

    // Act and Assert
    assertFalse(cachingIterable.iterator().hasNext());
  }
}
