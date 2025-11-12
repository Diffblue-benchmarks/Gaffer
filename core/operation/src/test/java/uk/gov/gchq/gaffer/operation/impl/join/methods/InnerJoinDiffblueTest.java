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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class InnerJoinDiffblueTest {
  /**
   * Method under test:
   * {@link InnerJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  void testJoinFlattened() {
    // Arrange
    InnerJoin innerJoin = new InnerJoin();

    // Act and Assert
    assertTrue(innerJoin.joinFlattened("Key", new ArrayList<>(), "Key Name", "42").isEmpty());
  }

  /**
   * Method under test:
   * {@link InnerJoin#joinAggregated(Object, List, String, String)}
   */
  @Test
  void testJoinAggregated() {
    // Arrange
    InnerJoin innerJoin = new InnerJoin();

    // Act and Assert
    assertNull(innerJoin.joinAggregated("Key", new ArrayList<>(), "Key Name", "42"));
  }
}
