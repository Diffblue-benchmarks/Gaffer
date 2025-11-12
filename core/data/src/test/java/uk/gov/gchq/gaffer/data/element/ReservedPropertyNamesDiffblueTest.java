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

package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class ReservedPropertyNamesDiffblueTest {
  /**
   * Method under test: {@link ReservedPropertyNames#contains(String)}
   */
  @Test
  void testContains() {
    // Arrange, Act and Assert
    assertFalse(ReservedPropertyNames.contains("Property"));
    assertTrue(ReservedPropertyNames.contains("DIRECTED"));
  }

  /**
   * Method under test: {@link ReservedPropertyNames#getNames()}
   */
  @Test
  void testGetNames() {
    // Arrange and Act
    Stream<String> actualNames = ReservedPropertyNames.GROUP.getNames();

    // Assert
    List<String> collectResult = actualNames.limit(5).collect(Collectors.toList());
    assertEquals(2, collectResult.size());
    assertEquals("GROUP", collectResult.get(1));
    assertEquals("group", collectResult.get(0));
  }
}
