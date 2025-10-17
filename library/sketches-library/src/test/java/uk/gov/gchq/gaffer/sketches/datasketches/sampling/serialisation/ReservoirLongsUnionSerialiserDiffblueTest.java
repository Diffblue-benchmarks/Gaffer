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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.sampling.ReservoirLongsUnion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class ReservoirLongsUnionSerialiserDiffblueTest {
  /**
   * Test {@link ReservoirLongsUnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReservoirLongsUnionSerialiser.canHandle(Class)"})
  void testCanHandle_thenReturnTrue() {
    // Arrange
    ReservoirLongsUnionSerialiser reservoirLongsUnionSerialiser =
        new ReservoirLongsUnionSerialiser();
    Class<ReservoirLongsUnion> clazz = ReservoirLongsUnion.class;

    // Act and Assert
    assertTrue(reservoirLongsUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReservoirLongsUnionSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    ReservoirLongsUnionSerialiser reservoirLongsUnionSerialiser =
        new ReservoirLongsUnionSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(reservoirLongsUnionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReservoirLongsUnion ReservoirLongsUnionSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new ReservoirLongsUnionSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReservoirLongsUnionSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirLongsUnionSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#equals(Object)}, and {@link
   * ReservoirLongsUnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirLongsUnionSerialiser#equals(Object)}
   *   <li>{@link ReservoirLongsUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirLongsUnionSerialiser.equals(Object)",
    "int ReservoirLongsUnionSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReservoirLongsUnionSerialiser reservoirLongsUnionSerialiser =
        new ReservoirLongsUnionSerialiser();
    ReservoirLongsUnionSerialiser reservoirLongsUnionSerialiser2 =
        new ReservoirLongsUnionSerialiser();

    // Act and Assert
    assertEquals(reservoirLongsUnionSerialiser, reservoirLongsUnionSerialiser2);
    assertEquals(
        reservoirLongsUnionSerialiser.hashCode(), reservoirLongsUnionSerialiser2.hashCode());
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#equals(Object)}, and {@link
   * ReservoirLongsUnionSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReservoirLongsUnionSerialiser#equals(Object)}
   *   <li>{@link ReservoirLongsUnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirLongsUnionSerialiser.equals(Object)",
    "int ReservoirLongsUnionSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReservoirLongsUnionSerialiser reservoirLongsUnionSerialiser =
        new ReservoirLongsUnionSerialiser();

    // Act and Assert
    assertEquals(reservoirLongsUnionSerialiser, reservoirLongsUnionSerialiser);
    int expectedHashCodeResult = reservoirLongsUnionSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, reservoirLongsUnionSerialiser.hashCode());
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirLongsUnionSerialiser.equals(Object)",
    "int ReservoirLongsUnionSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirLongsUnionSerialiser(), 1);
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirLongsUnionSerialiser.equals(Object)",
    "int ReservoirLongsUnionSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReservoirLongsUnionSerialiser(), null);
  }

  /**
   * Test {@link ReservoirLongsUnionSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReservoirLongsUnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReservoirLongsUnionSerialiser.equals(Object)",
    "int ReservoirLongsUnionSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ReservoirLongsUnionSerialiser(), "Different type to ReservoirLongsUnionSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ReservoirLongsUnionSerialiser}
   *   <li>{@link ReservoirLongsUnionSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReservoirLongsUnionSerialiser.<init>()",
    "boolean ReservoirLongsUnionSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new ReservoirLongsUnionSerialiser().isConsistent());
  }
}
