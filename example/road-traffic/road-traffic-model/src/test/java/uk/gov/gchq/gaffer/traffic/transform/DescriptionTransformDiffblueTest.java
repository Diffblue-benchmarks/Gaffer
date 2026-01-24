/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.traffic.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DescriptionTransformDiffblueTest {
  /**
   * Test {@link DescriptionTransform#apply(String, String, Long)} with {@code junctionA}, {@code
   * junctionB}, {@code count}.
   *
   * <p>Method under test: {@link DescriptionTransform#apply(String, String, Long)}
   */
  @Test
  @DisplayName("Test apply(String, String, Long) with 'junctionA', 'junctionB', 'count'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DescriptionTransform.apply(String, String, Long)"})
  void testApplyWithJunctionAJunctionBCount() {
    // Arrange, Act and Assert
    assertEquals(
        "3 vehicles have travelled between junction Junction A and junction Junction B",
        new DescriptionTransform().apply("Junction A", "Junction B", 3L));
  }
}
