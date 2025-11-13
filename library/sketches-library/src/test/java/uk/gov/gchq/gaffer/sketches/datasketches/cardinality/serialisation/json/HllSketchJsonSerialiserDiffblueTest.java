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

package uk.gov.gchq.gaffer.sketches.datasketches.cardinality.serialisation.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.hll.HllSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HllSketchJsonSerialiserDiffblueTest {
  /**
   * Test {@link HllSketchJsonSerialiser#handledType()}.
   * <p>
   * Method under test: {@link HllSketchJsonSerialiser#handledType()}
   */
  @Test
  @DisplayName("Test handledType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Class HllSketchJsonSerialiser.handledType()"})
  void testHandledType() {
    // Arrange and Act
    Class<HllSketch> actualHandledTypeResult = (new HllSketchJsonSerialiser()).handledType();

    // Assert
    Class<HllSketch> expectedHandledTypeResult = HllSketch.class;
    assertEquals(expectedHandledTypeResult, actualHandledTypeResult);
  }

  /**
   * Test new {@link HllSketchJsonSerialiser} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link HllSketchJsonSerialiser}
   */
  @Test
  @DisplayName("Test new HllSketchJsonSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HllSketchJsonSerialiser.<init>()"})
  void testNewHllSketchJsonSerialiser() {
    // Arrange and Act
    HllSketchJsonSerialiser actualHllSketchJsonSerialiser = new HllSketchJsonSerialiser();

    // Assert
    assertNull(actualHllSketchJsonSerialiser.getDelegatee());
    assertFalse(actualHllSketchJsonSerialiser.isUnwrappingSerializer());
  }
}
