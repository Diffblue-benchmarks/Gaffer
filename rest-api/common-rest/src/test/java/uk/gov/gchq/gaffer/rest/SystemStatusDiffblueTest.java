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

package uk.gov.gchq.gaffer.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SystemStatusDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SystemStatus#SystemStatus(SystemStatus.Status)}
   *   <li>{@link SystemStatus#toString()}
   *   <li>{@link SystemStatus#getStatus()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SystemStatus actualSystemStatus = new SystemStatus(SystemStatus.Status.UP);
    actualSystemStatus.toString();

    // Assert
    assertEquals(SystemStatus.Status.UP, actualSystemStatus.getStatus());
  }
}
