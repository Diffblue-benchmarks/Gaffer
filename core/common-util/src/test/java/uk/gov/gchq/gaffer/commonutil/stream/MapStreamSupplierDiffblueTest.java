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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MapStreamSupplierDiffblueTest {
  /**
   * Test {@link MapStreamSupplier#MapStreamSupplier(Iterable, Function)}.
   * <p>
   * Method under test: {@link MapStreamSupplier#MapStreamSupplier(Iterable, Function)}
   */
  @Test
  @DisplayName("Test new MapStreamSupplier(Iterable, Function)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapStreamSupplier.<init>(Iterable, Function)"})
  void testNewMapStreamSupplier() {
    // Arrange and Act
    MapStreamSupplier<Object, Object> actualMapStreamSupplier = new MapStreamSupplier<>(new ArrayList<>(),
        mock(Function.class));

    // Assert
    Stream<Object> getResult = actualMapStreamSupplier.get();
    assertTrue(getResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link MapStreamSupplier#get()}.
   * <ul>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStreamSupplier#get()}
   */
  @Test
  @DisplayName("Test get(); then return limit five collect toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream MapStreamSupplier.get()"})
  void testGet_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange
    MapStreamSupplier<Object, Object> mapStreamSupplier = new MapStreamSupplier<>(new ArrayList<>(),
        mock(Function.class));

    // Act
    Stream<Object> actualGetResult = mapStreamSupplier.get();

    // Assert
    assertTrue(actualGetResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
