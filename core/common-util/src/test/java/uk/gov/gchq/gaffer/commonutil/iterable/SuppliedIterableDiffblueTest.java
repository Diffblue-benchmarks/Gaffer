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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class SuppliedIterableDiffblueTest {
  /**
   * Method under test: {@link SuppliedIterable#iterator()}
   */
  @Test
  void testIterator() {
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
   * Method under test: {@link SuppliedIterable#iterator()}
   */
  @Test
  void testIterator2() {
    // Arrange
    Supplier<Iterable<Object>> supplier = mock(Supplier.class);
    when(supplier.get()).thenThrow(new IllegalArgumentException("foo"));
    SuppliedIterable<Object> suppliedIterable = new SuppliedIterable<>(supplier);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> suppliedIterable.iterator());
    verify(supplier).get();
  }

  /**
   * Method under test: {@link SuppliedIterable#SuppliedIterable(Supplier)}
   */
  @Test
  void testNewSuppliedIterable() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SuppliedIterable<>(null));
  }
}
