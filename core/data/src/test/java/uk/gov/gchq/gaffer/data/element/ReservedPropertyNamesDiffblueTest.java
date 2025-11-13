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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReservedPropertyNamesDiffblueTest {
  /**
   * Test {@link ReservedPropertyNames#contains(String)}.
   * <ul>
   *   <li>When {@code DIRECTED}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReservedPropertyNames#contains(String)}
   */
  @Test
  @DisplayName("Test contains(String); when 'DIRECTED'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservedPropertyNames.contains(String)"})
  void testContains_whenDirected_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ReservedPropertyNames.contains("DIRECTED"));
  }

  /**
   * Test {@link ReservedPropertyNames#contains(String)}.
   * <ul>
   *   <li>When {@code Property}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReservedPropertyNames#contains(String)}
   */
  @Test
  @DisplayName("Test contains(String); when 'Property'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservedPropertyNames.contains(String)"})
  void testContains_whenProperty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ReservedPropertyNames.contains("Property"));
  }

  /**
   * Test {@link ReservedPropertyNames#getNames()}.
   * <p>
   * Method under test: {@link ReservedPropertyNames#getNames()}
   */
  @Test
  @DisplayName("Test getNames()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream ReservedPropertyNames.getNames()"})
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
