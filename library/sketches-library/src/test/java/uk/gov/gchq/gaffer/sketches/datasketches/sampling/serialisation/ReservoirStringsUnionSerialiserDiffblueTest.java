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

class ReservoirStringsUnionSerialiserDiffblueTest {
  /**
   * Test {@link ReservoirStringsUnionSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReservoirStringsUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirStringsUnionSerialiser.canHandle(Class)"})
  void testCanHandle_thenReturnTrue() {
    // Arrange
    ReservoirStringsUnionSerialiser reservoirStringsUnionSerialiser = new ReservoirStringsUnionSerialiser();
    Class<ReservoirItemsUnion> clazz = ReservoirItemsUnion.class;

    // Act and Assert
    assertTrue(reservoirStringsUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReservoirStringsUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirStringsUnionSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    ReservoirStringsUnionSerialiser reservoirStringsUnionSerialiser = new ReservoirStringsUnionSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(reservoirStringsUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link ReservoirStringsUnionSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReservoirItemsUnion ReservoirStringsUnionSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new ReservoirStringsUnionSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link ReservoirStringsUnionSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirStringsUnionSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new ReservoirStringsUnionSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#equals(Object)}, and {@link ReservoirStringsUnionSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReservoirStringsUnionSerialiser#equals(Object)}
   *   <li>{@link ReservoirStringsUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirStringsUnionSerialiser.equals(Object)",
      "int ReservoirStringsUnionSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReservoirStringsUnionSerialiser reservoirStringsUnionSerialiser = new ReservoirStringsUnionSerialiser();
    ReservoirStringsUnionSerialiser reservoirStringsUnionSerialiser2 = new ReservoirStringsUnionSerialiser();

    // Act and Assert
    assertEquals(reservoirStringsUnionSerialiser, reservoirStringsUnionSerialiser2);
    int expectedHashCodeResult = reservoirStringsUnionSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, reservoirStringsUnionSerialiser2.hashCode());
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#equals(Object)}, and {@link ReservoirStringsUnionSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReservoirStringsUnionSerialiser#equals(Object)}
   *   <li>{@link ReservoirStringsUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirStringsUnionSerialiser.equals(Object)",
      "int ReservoirStringsUnionSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReservoirStringsUnionSerialiser reservoirStringsUnionSerialiser = new ReservoirStringsUnionSerialiser();

    // Act and Assert
    assertEquals(reservoirStringsUnionSerialiser, reservoirStringsUnionSerialiser);
    int expectedHashCodeResult = reservoirStringsUnionSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, reservoirStringsUnionSerialiser.hashCode());
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReservoirStringsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirStringsUnionSerialiser.equals(Object)",
      "int ReservoirStringsUnionSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirStringsUnionSerialiser(), 1);
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReservoirStringsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirStringsUnionSerialiser.equals(Object)",
      "int ReservoirStringsUnionSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirStringsUnionSerialiser(), null);
  }

  /**
   * Test {@link ReservoirStringsUnionSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReservoirStringsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReservoirStringsUnionSerialiser.equals(Object)",
      "int ReservoirStringsUnionSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirStringsUnionSerialiser(), "Different type to ReservoirStringsUnionSerialiser");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ReservoirStringsUnionSerialiser}
   *   <li>{@link ReservoirStringsUnionSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ReservoirStringsUnionSerialiser.<init>()",
      "boolean ReservoirStringsUnionSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new ReservoirStringsUnionSerialiser()).isConsistent());
  }
}
