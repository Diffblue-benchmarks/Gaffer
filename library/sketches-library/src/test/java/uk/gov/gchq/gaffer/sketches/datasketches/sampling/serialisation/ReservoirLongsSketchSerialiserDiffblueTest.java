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

package uk.gov.gchq.gaffer.sketches.datasketches.sampling.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.sampling.ReservoirLongsSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class ReservoirLongsSketchSerialiserDiffblueTest {
  /**
   * Test {@link ReservoirLongsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReservoirLongsSketchSerialiser.canHandle(Class)"})
  void testCanHandle_thenReturnTrue() {
    // Arrange
    ReservoirLongsSketchSerialiser reservoirLongsSketchSerialiser =
        new ReservoirLongsSketchSerialiser();
    Class<ReservoirLongsSketch> clazz = ReservoirLongsSketch.class;

    // Act and Assert
    assertTrue(reservoirLongsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReservoirLongsSketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    ReservoirLongsSketchSerialiser reservoirLongsSketchSerialiser =
        new ReservoirLongsSketchSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(reservoirLongsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReservoirLongsSketch ReservoirLongsSketchSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new ReservoirLongsSketchSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReservoirLongsSketchSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirLongsSketchSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#equals(Object)}, and {@link
   * ReservoirLongsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirLongsSketchSerialiser#equals(Object)}
   *   <li>{@link ReservoirLongsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirLongsSketchSerialiser.equals(Object)",
    "int ReservoirLongsSketchSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReservoirLongsSketchSerialiser reservoirLongsSketchSerialiser =
        new ReservoirLongsSketchSerialiser();
    ReservoirLongsSketchSerialiser reservoirLongsSketchSerialiser2 =
        new ReservoirLongsSketchSerialiser();

    // Act and Assert
    assertEquals(reservoirLongsSketchSerialiser, reservoirLongsSketchSerialiser2);
    assertEquals(
        reservoirLongsSketchSerialiser.hashCode(), reservoirLongsSketchSerialiser2.hashCode());
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#equals(Object)}, and {@link
   * ReservoirLongsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirLongsSketchSerialiser#equals(Object)}
   *   <li>{@link ReservoirLongsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirLongsSketchSerialiser.equals(Object)",
    "int ReservoirLongsSketchSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReservoirLongsSketchSerialiser reservoirLongsSketchSerialiser =
        new ReservoirLongsSketchSerialiser();

    // Act and Assert
    assertEquals(reservoirLongsSketchSerialiser, reservoirLongsSketchSerialiser);
    int expectedHashCodeResult = reservoirLongsSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, reservoirLongsSketchSerialiser.hashCode());
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirLongsSketchSerialiser.equals(Object)",
    "int ReservoirLongsSketchSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirLongsSketchSerialiser(), 1);
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirLongsSketchSerialiser.equals(Object)",
    "int ReservoirLongsSketchSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirLongsSketchSerialiser(), null);
  }

  /**
   * Test {@link ReservoirLongsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirLongsSketchSerialiser.equals(Object)",
    "int ReservoirLongsSketchSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ReservoirLongsSketchSerialiser(), "Different type to ReservoirLongsSketchSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ReservoirLongsSketchSerialiser}
   *   <li>{@link ReservoirLongsSketchSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReservoirLongsSketchSerialiser.<init>()",
    "boolean ReservoirLongsSketchSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirLongsSketchSerialiser().isConsistent());
  }
}
