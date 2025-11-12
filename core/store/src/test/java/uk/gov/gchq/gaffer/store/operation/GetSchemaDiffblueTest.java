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

package uk.gov.gchq.gaffer.store.operation;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class GetSchemaDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetSchema}
   *   <li>{@link GetSchema#setCompact(boolean)}
   *   <li>{@link GetSchema#setOptions(Map)}
   *   <li>{@link GetSchema#getOptions()}
   *   <li>{@link GetSchema#isCompact()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GetSchema actualGetSchema = new GetSchema();
    actualGetSchema.setCompact(true);
    HashMap<String, String> options = new HashMap<>();
    actualGetSchema.setOptions(options);
    Map<String, String> actualOptions = actualGetSchema.getOptions();
    boolean actualIsCompactResult = actualGetSchema.isCompact();

    // Assert that nothing has changed
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsCompactResult);
    assertSame(options, actualOptions);
  }
}
