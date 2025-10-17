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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SuppliedIterableDiffblueTest {
  /**
   * Test {@link SuppliedIterable#SuppliedIterable(Supplier)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SuppliedIterable#SuppliedIterable(Supplier)}
   */
  @Test
  @DisplayName(
      "Test new SuppliedIterable(Supplier); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SuppliedIterable.<init>(Supplier)"})
  void testNewSuppliedIterable_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SuppliedIterable<>(null));
  }

  /**
   * Test {@link SuppliedIterable#iterator()}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} return {@link ArrayList#ArrayList()}.
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link SuppliedIterable#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given Supplier get() return ArrayList(); then return not hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator SuppliedIterable.iterator()"})
  void testIterator_givenSupplierGetReturnArrayList_thenReturnNotHasNext() {
    // Arrange
    Supplier<Iterable<Object>> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn(new ArrayList<>());
    SuppliedIterable<Object> suppliedIterable = new SuppliedIterable<>(supplier);

    // Act
    Iterator<Object> actualIteratorResult = suppliedIterable.iterator();

    // Assert
    verify(supplier).get();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link SuppliedIterable#iterator()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SuppliedIterable#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator SuppliedIterable.iterator()"})
  void testIterator_thenThrowIllegalArgumentException() {
    // Arrange
    Supplier<Iterable<Object>> supplier = mock(Supplier.class);
    when(supplier.get()).thenThrow(new IllegalArgumentException());
    SuppliedIterable<Object> suppliedIterable = new SuppliedIterable<>(supplier);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> suppliedIterable.iterator());
    verify(supplier).get();
  }
}
