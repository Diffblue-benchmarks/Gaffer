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

package uk.gov.gchq.gaffer.commonutil.stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class FlatMapStreamSupplierDiffblueTest {
  /**
   * Method under test: {@link FlatMapStreamSupplier#get()}
   */
  @Test
  void testGet() {
    // Arrange
    FlatMapStreamSupplier<Object, Object> flatMapStreamSupplier = new FlatMapStreamSupplier<>(new ArrayList<>(),
        mock(Function.class));

    // Act
    Stream<Object> actualGetResult = flatMapStreamSupplier.get();

    // Assert
    assertTrue(actualGetResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test:
   * {@link FlatMapStreamSupplier#FlatMapStreamSupplier(Iterable, Function)}
   */
  @Test
  void testNewFlatMapStreamSupplier() {
    // Arrange and Act
    FlatMapStreamSupplier<Object, Object> actualFlatMapStreamSupplier = new FlatMapStreamSupplier<>(new ArrayList<>(),
        mock(Function.class));

    // Assert
    Stream<Object> getResult = actualFlatMapStreamSupplier.get();
    assertTrue(getResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
