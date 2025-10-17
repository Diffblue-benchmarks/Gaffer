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

package uk.gov.gchq.gaffer.traffic.generator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RoadTrafficStringElementGeneratorDiffblueTest {
  /**
   * Test {@link RoadTrafficStringElementGenerator#isHeader(String)}.
   *
   * <ul>
   *   <li>When {@code Line}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficStringElementGenerator#isHeader(String)}
   */
  @Test
  @DisplayName("Test isHeader(String); when 'Line'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RoadTrafficStringElementGenerator.isHeader(String)"})
  void testIsHeader_whenLine_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RoadTrafficStringElementGenerator.isHeader("Line"));
  }

  /**
   * Test {@link RoadTrafficStringElementGenerator#isHeader(String)}.
   *
   * <ul>
   *   <li>When {@code "Region Name (GO)",}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficStringElementGenerator#isHeader(String)}
   */
  @Test
  @DisplayName("Test isHeader(String); when '\"Region Name (GO)\",'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RoadTrafficStringElementGenerator.isHeader(String)"})
  void testIsHeader_whenRegionNameGo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RoadTrafficStringElementGenerator.isHeader("\"Region Name (GO)\","));
  }

  /**
   * Test {@link RoadTrafficStringElementGenerator#extractFields(String)}.
   *
   * <ul>
   *   <li>When {@code "Region Name (GO)",}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RoadTrafficStringElementGenerator#extractFields(String)}
   */
  @Test
  @DisplayName("Test extractFields(String); when '\"Region Name (GO)\",'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] RoadTrafficStringElementGenerator.extractFields(String)"})
  void testExtractFields_whenRegionNameGo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RoadTrafficStringElementGenerator.extractFields("\"Region Name (GO)\","));
  }
}
