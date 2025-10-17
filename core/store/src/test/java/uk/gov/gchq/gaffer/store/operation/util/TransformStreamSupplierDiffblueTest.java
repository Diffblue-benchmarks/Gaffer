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

package uk.gov.gchq.gaffer.store.operation.util;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.function.Transform;

class TransformStreamSupplierDiffblueTest {
  /**
   * Test {@link TransformStreamSupplier#get()}.
   *
   * <ul>
   *   <li>Given {@link Transform} (default constructor) Input is {@link ArrayList#ArrayList()}.
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link TransformStreamSupplier#get()}
   */
  @Test
  @DisplayName(
      "Test get(); given Transform (default constructor) Input is ArrayList(); then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream TransformStreamSupplier.get()"})
  void testGet_givenTransformInputIsArrayList_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange
    Transform operation = new Transform();
    operation.setInput(new ArrayList<>());

    // Act
    Stream<Element> actualGetResult = new TransformStreamSupplier(operation).get();

    // Assert
    assertTrue(actualGetResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
