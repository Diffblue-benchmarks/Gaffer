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

package uk.gov.gchq.gaffer.sketches.datasketches.sampling.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.sampling.ReservoirItemsUnion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class ReservoirNumbersUnionSerialiserDiffblueTest {
  /**
   * Test {@link ReservoirNumbersUnionSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReservoirNumbersUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirNumbersUnionSerialiser.canHandle(Class)"})
  void testCanHandle_thenReturnTrue() {
    // Arrange
    ReservoirNumbersUnionSerialiser reservoirNumbersUnionSerialiser = new ReservoirNumbersUnionSerialiser();
    Class<ReservoirItemsUnion> clazz = ReservoirItemsUnion.class;

    // Act and Assert
    assertTrue(reservoirNumbersUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReservoirNumbersUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirNumbersUnionSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    ReservoirNumbersUnionSerialiser reservoirNumbersUnionSerialiser = new ReservoirNumbersUnionSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(reservoirNumbersUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link ReservoirNumbersUnionSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReservoirItemsUnion ReservoirNumbersUnionSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new ReservoirNumbersUnionSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link ReservoirNumbersUnionSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirNumbersUnionSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new ReservoirNumbersUnionSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#equals(Object)}, and {@link ReservoirNumbersUnionSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReservoirNumbersUnionSerialiser#equals(Object)}
   *   <li>{@link ReservoirNumbersUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirNumbersUnionSerialiser.equals(Object)",
      "int ReservoirNumbersUnionSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReservoirNumbersUnionSerialiser reservoirNumbersUnionSerialiser = new ReservoirNumbersUnionSerialiser();
    ReservoirNumbersUnionSerialiser reservoirNumbersUnionSerialiser2 = new ReservoirNumbersUnionSerialiser();

    // Act and Assert
    assertEquals(reservoirNumbersUnionSerialiser, reservoirNumbersUnionSerialiser2);
    int expectedHashCodeResult = reservoirNumbersUnionSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, reservoirNumbersUnionSerialiser2.hashCode());
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#equals(Object)}, and {@link ReservoirNumbersUnionSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReservoirNumbersUnionSerialiser#equals(Object)}
   *   <li>{@link ReservoirNumbersUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirNumbersUnionSerialiser.equals(Object)",
      "int ReservoirNumbersUnionSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReservoirNumbersUnionSerialiser reservoirNumbersUnionSerialiser = new ReservoirNumbersUnionSerialiser();

    // Act and Assert
    assertEquals(reservoirNumbersUnionSerialiser, reservoirNumbersUnionSerialiser);
    int expectedHashCodeResult = reservoirNumbersUnionSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, reservoirNumbersUnionSerialiser.hashCode());
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReservoirNumbersUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirNumbersUnionSerialiser.equals(Object)",
      "int ReservoirNumbersUnionSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirNumbersUnionSerialiser(), 1);
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReservoirNumbersUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirNumbersUnionSerialiser.equals(Object)",
      "int ReservoirNumbersUnionSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirNumbersUnionSerialiser(), null);
  }

  /**
   * Test {@link ReservoirNumbersUnionSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReservoirNumbersUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirNumbersUnionSerialiser.equals(Object)",
      "int ReservoirNumbersUnionSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirNumbersUnionSerialiser(), "Different type to ReservoirNumbersUnionSerialiser");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ReservoirNumbersUnionSerialiser}
   *   <li>{@link ReservoirNumbersUnionSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ReservoirNumbersUnionSerialiser.<init>()",
      "boolean ReservoirNumbersUnionSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new ReservoirNumbersUnionSerialiser()).isConsistent());
  }
}
