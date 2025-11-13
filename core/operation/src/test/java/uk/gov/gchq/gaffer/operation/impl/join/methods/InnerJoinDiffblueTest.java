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

package uk.gov.gchq.gaffer.operation.impl.join.methods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.koryphe.tuple.MapTuple;

class InnerJoinDiffblueTest {
  /**
   * Test {@link InnerJoin#joinFlattened(Object, List, String, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link InnerJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  @DisplayName("Test joinFlattened(Object, List, String, String); given '42'; when ArrayList() add '42'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List InnerJoin.joinFlattened(Object, List, String, String)"})
  void testJoinFlattened_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    InnerJoin innerJoin = new InnerJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");
    matches.add("42");

    // Act
    List<MapTuple> actualJoinFlattenedResult = innerJoin.joinFlattened("Key", matches, "Key Name", "42");

    // Assert
    assertEquals(2, actualJoinFlattenedResult.size());
    assertEquals(actualJoinFlattenedResult.get(0), actualJoinFlattenedResult.get(1));
  }

  /**
   * Test {@link InnerJoin#joinFlattened(Object, List, String, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link InnerJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  @DisplayName("Test joinFlattened(Object, List, String, String); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List InnerJoin.joinFlattened(Object, List, String, String)"})
  void testJoinFlattened_whenArrayList_thenReturnEmpty() {
    // Arrange
    InnerJoin innerJoin = new InnerJoin();

    // Act and Assert
    assertTrue(innerJoin.joinFlattened("Key", new ArrayList<>(), "Key Name", "42").isEmpty());
  }

  /**
   * Test {@link InnerJoin#joinAggregated(Object, List, String, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InnerJoin#joinAggregated(Object, List, String, String)}
   */
  @Test
  @DisplayName("Test joinAggregated(Object, List, String, String); when ArrayList(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapTuple InnerJoin.joinAggregated(Object, List, String, String)"})
  void testJoinAggregated_whenArrayList_thenReturnNull() {
    // Arrange
    InnerJoin innerJoin = new InnerJoin();

    // Act and Assert
    assertNull(innerJoin.joinAggregated("Key", new ArrayList<>(), "Key Name", "42"));
  }
}
