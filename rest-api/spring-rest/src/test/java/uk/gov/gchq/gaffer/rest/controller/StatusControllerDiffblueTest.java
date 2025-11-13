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

package uk.gov.gchq.gaffer.rest.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.rest.factory.DefaultGraphFactory;

class StatusControllerDiffblueTest {
  /**
   * Test {@link StatusController#getStatus()}.
   * <ul>
   *   <li>Then throw {@link GafferRuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusController#getStatus()}
   */
  @Test
  @DisplayName("Test getStatus(); then throw GafferRuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"uk.gov.gchq.gaffer.rest.SystemStatus StatusController.getStatus()"})
  void testGetStatus_thenThrowGafferRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(GafferRuntimeException.class, () -> (new StatusController(new DefaultGraphFactory())).getStatus());
  }
}
