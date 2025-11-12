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

package uk.gov.gchq.gaffer.operation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class OperationChainDiffblueTest {
  /**
   * Method under test: {@link OperationChain#getOptions()}
   */
  @Test
  void testGetOptions() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act and Assert
    assertTrue(operationChain.getOptions().isEmpty());
  }
}
