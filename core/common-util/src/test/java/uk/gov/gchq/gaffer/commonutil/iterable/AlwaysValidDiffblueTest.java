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

package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlwaysValidDiffblueTest {
  /**
   * Test {@link AlwaysValid#validate(Object)}.
   * <p>
   * Method under test: {@link AlwaysValid#validate(Object)}
   */
  @Test
  @DisplayName("Test validate(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlwaysValid.validate(Object)"})
  void testValidate() {
    // Arrange
    AlwaysValid<Object> alwaysValid = new AlwaysValid<>();

    // Act and Assert
    assertTrue(alwaysValid.validate("Obj"));
  }
}
