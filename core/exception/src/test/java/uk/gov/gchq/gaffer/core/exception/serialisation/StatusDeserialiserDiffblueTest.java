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

package uk.gov.gchq.gaffer.core.exception.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.util.AccessPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StatusDeserialiserDiffblueTest {
  /**
   * Test new {@link StatusDeserialiser} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link StatusDeserialiser}
   */
  @Test
  @DisplayName("Test new StatusDeserialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StatusDeserialiser.<init>()"})
  void testNewStatusDeserialiser() {
    // Arrange and Act
    StatusDeserialiser actualStatusDeserialiser = new StatusDeserialiser();

    // Assert
    assertNull(actualStatusDeserialiser.getDelegatee());
    assertNull(actualStatusDeserialiser.getObjectIdReader());
    assertNull(actualStatusDeserialiser.getEmptyValue());
    assertNull(actualStatusDeserialiser.getKnownPropertyNames());
    assertNull(actualStatusDeserialiser.getNullValue());
    assertEquals(AccessPattern.CONSTANT, actualStatusDeserialiser.getNullAccessPattern());
    assertEquals(AccessPattern.DYNAMIC, actualStatusDeserialiser.getEmptyAccessPattern());
    assertFalse(actualStatusDeserialiser.isCachable());
  }
}
