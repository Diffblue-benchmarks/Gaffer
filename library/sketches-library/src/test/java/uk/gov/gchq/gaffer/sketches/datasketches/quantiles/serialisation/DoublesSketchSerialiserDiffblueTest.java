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

package uk.gov.gchq.gaffer.sketches.datasketches.quantiles.serialisation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.apache.datasketches.quantiles.DoublesSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class DoublesSketchSerialiserDiffblueTest {
  /**
   * Test {@link DoublesSketchSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DoublesSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DoublesSketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    DoublesSketchSerialiser doublesSketchSerialiser = new DoublesSketchSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(doublesSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link DoublesSketchSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code DoublesSketch}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DoublesSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'org.apache.datasketches.quantiles.DoublesSketch'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DoublesSketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenOrgApacheDatasketchesQuantilesDoublesSketch_thenReturnTrue() {
    // Arrange
    DoublesSketchSerialiser doublesSketchSerialiser = new DoublesSketchSerialiser();
    Class<DoublesSketch> clazz = DoublesSketch.class;

    // Act and Assert
    assertTrue(doublesSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link DoublesSketchSerialiser#serialise(DoublesSketch)} with {@code DoublesSketch}.
   * <p>
   * Method under test: {@link DoublesSketchSerialiser#serialise(DoublesSketch)}
   */
  @Test
  @DisplayName("Test serialise(DoublesSketch) with 'DoublesSketch'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] DoublesSketchSerialiser.serialise(DoublesSketch)"})
  void testSerialiseWithDoublesSketch() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    DoublesSketchSerialiser doublesSketchSerialiser = new DoublesSketchSerialiser();
    DoublesSketch sketch = mock(DoublesSketch.class);
    when(sketch.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSerialiseResult = doublesSketchSerialiser.serialise(sketch);

    // Assert
    verify(sketch).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link DoublesSketchSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link DoublesSketchSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DoublesSketch DoublesSketchSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new DoublesSketchSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link DoublesSketchSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link DoublesSketchSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DoublesSketchSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new DoublesSketchSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link DoublesSketchSerialiser#equals(Object)}, and {@link DoublesSketchSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DoublesSketchSerialiser#equals(Object)}
   *   <li>{@link DoublesSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DoublesSketchSerialiser.equals(Object)", "int DoublesSketchSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DoublesSketchSerialiser doublesSketchSerialiser = new DoublesSketchSerialiser();
    DoublesSketchSerialiser doublesSketchSerialiser2 = new DoublesSketchSerialiser();

    // Act and Assert
    assertEquals(doublesSketchSerialiser, doublesSketchSerialiser2);
    int expectedHashCodeResult = doublesSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, doublesSketchSerialiser2.hashCode());
  }

  /**
   * Test {@link DoublesSketchSerialiser#equals(Object)}, and {@link DoublesSketchSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DoublesSketchSerialiser#equals(Object)}
   *   <li>{@link DoublesSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DoublesSketchSerialiser.equals(Object)", "int DoublesSketchSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DoublesSketchSerialiser doublesSketchSerialiser = new DoublesSketchSerialiser();

    // Act and Assert
    assertEquals(doublesSketchSerialiser, doublesSketchSerialiser);
    int expectedHashCodeResult = doublesSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, doublesSketchSerialiser.hashCode());
  }

  /**
   * Test {@link DoublesSketchSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DoublesSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DoublesSketchSerialiser.equals(Object)", "int DoublesSketchSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoublesSketchSerialiser(), 1);
  }

  /**
   * Test {@link DoublesSketchSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DoublesSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DoublesSketchSerialiser.equals(Object)", "int DoublesSketchSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoublesSketchSerialiser(), null);
  }

  /**
   * Test {@link DoublesSketchSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DoublesSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DoublesSketchSerialiser.equals(Object)", "int DoublesSketchSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoublesSketchSerialiser(), "Different type to DoublesSketchSerialiser");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DoublesSketchSerialiser}
   *   <li>{@link DoublesSketchSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DoublesSketchSerialiser.<init>()", "boolean DoublesSketchSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new DoublesSketchSerialiser()).isConsistent());
  }
}
