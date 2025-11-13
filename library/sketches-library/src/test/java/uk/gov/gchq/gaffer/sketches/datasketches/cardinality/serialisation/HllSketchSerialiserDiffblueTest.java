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

package uk.gov.gchq.gaffer.sketches.datasketches.cardinality.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.hll.HllSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class HllSketchSerialiserDiffblueTest {
  /**
   * Test {@link HllSketchSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HllSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HllSketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    HllSketchSerialiser hllSketchSerialiser = new HllSketchSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(hllSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link HllSketchSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code HllSketch}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HllSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'org.apache.datasketches.hll.HllSketch'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HllSketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenOrgApacheDatasketchesHllHllSketch_thenReturnTrue() {
    // Arrange
    HllSketchSerialiser hllSketchSerialiser = new HllSketchSerialiser();
    Class<HllSketch> clazz = HllSketch.class;

    // Act and Assert
    assertTrue(hllSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link HllSketchSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link HllSketchSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HllSketch HllSketchSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new HllSketchSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link HllSketchSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link HllSketchSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HllSketchSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new HllSketchSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link HllSketchSerialiser#equals(Object)}, and {@link HllSketchSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HllSketchSerialiser#equals(Object)}
   *   <li>{@link HllSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HllSketchSerialiser.equals(Object)", "int HllSketchSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HllSketchSerialiser hllSketchSerialiser = new HllSketchSerialiser();
    HllSketchSerialiser hllSketchSerialiser2 = new HllSketchSerialiser();

    // Act and Assert
    assertEquals(hllSketchSerialiser, hllSketchSerialiser2);
    int expectedHashCodeResult = hllSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, hllSketchSerialiser2.hashCode());
  }

  /**
   * Test {@link HllSketchSerialiser#equals(Object)}, and {@link HllSketchSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HllSketchSerialiser#equals(Object)}
   *   <li>{@link HllSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HllSketchSerialiser.equals(Object)", "int HllSketchSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HllSketchSerialiser hllSketchSerialiser = new HllSketchSerialiser();

    // Act and Assert
    assertEquals(hllSketchSerialiser, hllSketchSerialiser);
    int expectedHashCodeResult = hllSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, hllSketchSerialiser.hashCode());
  }

  /**
   * Test {@link HllSketchSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HllSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HllSketchSerialiser.equals(Object)", "int HllSketchSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HllSketchSerialiser(), 3);
  }

  /**
   * Test {@link HllSketchSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HllSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HllSketchSerialiser.equals(Object)", "int HllSketchSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HllSketchSerialiser(), null);
  }

  /**
   * Test {@link HllSketchSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HllSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HllSketchSerialiser.equals(Object)", "int HllSketchSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HllSketchSerialiser(), "Different type to HllSketchSerialiser");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link HllSketchSerialiser}
   *   <li>{@link HllSketchSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HllSketchSerialiser.<init>()", "boolean HllSketchSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new HllSketchSerialiser()).isConsistent());
  }
}
