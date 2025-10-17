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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterable;

class MapStreamSupplierDiffblueTest {
  /**
   * Test {@link MapStreamSupplier#MapStreamSupplier(Iterable, Function)}.
   *
   * <p>Method under test: {@link MapStreamSupplier#MapStreamSupplier(Iterable, Function)}
   */
  @Test
  @DisplayName("Test new MapStreamSupplier(Iterable, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapStreamSupplier.<init>(Iterable, Function)"})
  void testNewMapStreamSupplier() {
    // Arrange and Act
    MapStreamSupplier<Object, Object> actualMapStreamSupplier =
        new MapStreamSupplier<>(new ArrayList<>(), mock(Function.class));

    // Assert
    Stream<Object> getResult = actualMapStreamSupplier.get();
    assertTrue(getResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link MapStreamSupplier#get()}.
   *
   * <ul>
   *   <li>Given {@link MapStreamSupplier#MapStreamSupplier(Iterable, Function)} with input is
   *       {@link ArrayList#ArrayList()} and {@link Function}.
   * </ul>
   *
   * <p>Method under test: {@link MapStreamSupplier#get()}
   */
  @Test
  @DisplayName(
      "Test get(); given MapStreamSupplier(Iterable, Function) with input is ArrayList() and Function")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream MapStreamSupplier.get()"})
  void testGet_givenMapStreamSupplierWithInputIsArrayListAndFunction() {
    // Arrange
    MapStreamSupplier<Object, Object> mapStreamSupplier =
        new MapStreamSupplier<>(new ArrayList<>(), mock(Function.class));

    // Act
    Stream<Object> actualGetResult = mapStreamSupplier.get();

    // Assert
    assertTrue(actualGetResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link MapStreamSupplier#get()}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} return {@link ArrayList#ArrayList()}
   *       stream.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link MapStreamSupplier#get()}
   */
  @Test
  @DisplayName("Test get(); given Supplier get() return ArrayList() stream; then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream MapStreamSupplier.get()"})
  void testGet_givenSupplierGetReturnArrayListStream_thenCallsGet() {
    // Arrange
    Supplier<Stream<Object>> streamSupplier = mock(Supplier.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    when(streamSupplier.get()).thenReturn(streamResult);
    StreamIterable<Object> input = new StreamIterable<>(streamSupplier);
    MapStreamSupplier<Object, Object> mapStreamSupplier =
        new MapStreamSupplier<>(input, mock(Function.class));

    // Act
    Stream<Object> actualGetResult = mapStreamSupplier.get();

    // Assert
    verify(streamSupplier).get();
    assertTrue(actualGetResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
