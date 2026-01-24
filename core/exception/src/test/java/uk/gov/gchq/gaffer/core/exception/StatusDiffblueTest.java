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

package uk.gov.gchq.gaffer.core.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StatusDiffblueTest {
  /**
   * Test {@link Status#fromStatusCode(int)}.
   *
   * <ul>
   *   <li>When one hundred.
   *   <li>Then return {@code CONTINUE}.
   * </ul>
   *
   * <p>Method under test: {@link Status#fromStatusCode(int)}
   */
  @Test
  @DisplayName("Test fromStatusCode(int); when one hundred; then return 'CONTINUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Status Status.fromStatusCode(int)"})
  void testFromStatusCode_whenOneHundred_thenReturnContinue() {
    // Arrange, Act and Assert
    assertEquals(Status.CONTINUE, Status.fromStatusCode(100));
  }

  /**
   * Test {@link Status#fromStatusCode(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link GafferRuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link Status#fromStatusCode(int)}
   */
  @Test
  @DisplayName("Test fromStatusCode(int); when one; then throw GafferRuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Status Status.fromStatusCode(int)"})
  void testFromStatusCode_whenOne_thenThrowGafferRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(GafferRuntimeException.class, () -> Status.fromStatusCode(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Status#toString()}
   *   <li>{@link Status#getReason()}
   *   <li>{@link Status#getStatusCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String Status.getReason()",
    "int Status.getStatusCode()",
    "String Status.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Status valueOfResult = Status.valueOf("CONTINUE");

    // Act
    String actualToStringResult = valueOfResult.toString();
    String actualReason = valueOfResult.getReason();

    // Assert
    assertEquals("Continue", actualReason);
    assertEquals("Status[Continue]", actualToStringResult);
    assertEquals(100, valueOfResult.getStatusCode());
  }
}
