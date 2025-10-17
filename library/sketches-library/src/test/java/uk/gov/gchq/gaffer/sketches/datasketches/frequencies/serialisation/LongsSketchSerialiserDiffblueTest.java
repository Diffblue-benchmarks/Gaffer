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

package uk.gov.gchq.gaffer.sketches.datasketches.frequencies.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.apache.datasketches.frequencies.LongsSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class LongsSketchSerialiserDiffblueTest {
  /**
   * Test {@link LongsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LongsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LongsSketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    LongsSketchSerialiser longsSketchSerialiser = new LongsSketchSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(longsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link LongsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code LongsSketch}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LongsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'org.apache.datasketches.frequencies.LongsSketch'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LongsSketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenOrgApacheDatasketchesFrequenciesLongsSketch_thenReturnTrue() {
    // Arrange
    LongsSketchSerialiser longsSketchSerialiser = new LongsSketchSerialiser();
    Class<LongsSketch> clazz = LongsSketch.class;

    // Act and Assert
    assertTrue(longsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link LongsSketchSerialiser#serialise(LongsSketch)} with {@code LongsSketch}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link LongsSketchSerialiser#serialise(LongsSketch)}
   */
  @Test
  @DisplayName(
      "Test serialise(LongsSketch) with 'LongsSketch'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LongsSketchSerialiser.serialise(LongsSketch)"})
  void testSerialiseWithLongsSketch_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    LongsSketchSerialiser longsSketchSerialiser = new LongsSketchSerialiser();

    LongsSketch sketch = mock(LongsSketch.class);
    when(sketch.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSerialiseResult = longsSketchSerialiser.serialise(sketch);

    // Assert
    verify(sketch).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link LongsSketchSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link LongsSketchSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongsSketch LongsSketchSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new LongsSketchSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link LongsSketchSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link LongsSketchSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LongsSketchSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new LongsSketchSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link LongsSketchSerialiser#equals(Object)}, and {@link
   * LongsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LongsSketchSerialiser#equals(Object)}
   *   <li>{@link LongsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LongsSketchSerialiser.equals(Object)",
    "int LongsSketchSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LongsSketchSerialiser longsSketchSerialiser = new LongsSketchSerialiser();
    LongsSketchSerialiser longsSketchSerialiser2 = new LongsSketchSerialiser();

    // Act and Assert
    assertEquals(longsSketchSerialiser, longsSketchSerialiser2);
    assertEquals(longsSketchSerialiser.hashCode(), longsSketchSerialiser2.hashCode());
  }

  /**
   * Test {@link LongsSketchSerialiser#equals(Object)}, and {@link
   * LongsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LongsSketchSerialiser#equals(Object)}
   *   <li>{@link LongsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LongsSketchSerialiser.equals(Object)",
    "int LongsSketchSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LongsSketchSerialiser longsSketchSerialiser = new LongsSketchSerialiser();

    // Act and Assert
    assertEquals(longsSketchSerialiser, longsSketchSerialiser);
    int expectedHashCodeResult = longsSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, longsSketchSerialiser.hashCode());
  }

  /**
   * Test {@link LongsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LongsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LongsSketchSerialiser.equals(Object)",
    "int LongsSketchSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongsSketchSerialiser(), 1);
  }

  /**
   * Test {@link LongsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LongsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LongsSketchSerialiser.equals(Object)",
    "int LongsSketchSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongsSketchSerialiser(), null);
  }

  /**
   * Test {@link LongsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LongsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LongsSketchSerialiser.equals(Object)",
    "int LongsSketchSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongsSketchSerialiser(), "Different type to LongsSketchSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LongsSketchSerialiser}
   *   <li>{@link LongsSketchSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LongsSketchSerialiser.<init>()",
    "boolean LongsSketchSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new LongsSketchSerialiser().isConsistent());
  }
}
