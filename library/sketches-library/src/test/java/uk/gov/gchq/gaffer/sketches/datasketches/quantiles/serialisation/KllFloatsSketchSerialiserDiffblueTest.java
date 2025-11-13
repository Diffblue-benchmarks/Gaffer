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
import org.apache.datasketches.kll.KllFloatsSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class KllFloatsSketchSerialiserDiffblueTest {
  /**
   * Test {@link KllFloatsSketchSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KllFloatsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean KllFloatsSketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    KllFloatsSketchSerialiser kllFloatsSketchSerialiser = new KllFloatsSketchSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(kllFloatsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code KllFloatsSketch}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KllFloatsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'org.apache.datasketches.kll.KllFloatsSketch'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean KllFloatsSketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenOrgApacheDatasketchesKllKllFloatsSketch_thenReturnTrue() {
    // Arrange
    KllFloatsSketchSerialiser kllFloatsSketchSerialiser = new KllFloatsSketchSerialiser();
    Class<KllFloatsSketch> clazz = KllFloatsSketch.class;

    // Act and Assert
    assertTrue(kllFloatsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#serialise(KllFloatsSketch)} with {@code KllFloatsSketch}.
   * <p>
   * Method under test: {@link KllFloatsSketchSerialiser#serialise(KllFloatsSketch)}
   */
  @Test
  @DisplayName("Test serialise(KllFloatsSketch) with 'KllFloatsSketch'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] KllFloatsSketchSerialiser.serialise(KllFloatsSketch)"})
  void testSerialiseWithKllFloatsSketch() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    KllFloatsSketchSerialiser kllFloatsSketchSerialiser = new KllFloatsSketchSerialiser();
    KllFloatsSketch sketch = mock(KllFloatsSketch.class);
    when(sketch.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSerialiseResult = kllFloatsSketchSerialiser.serialise(sketch);

    // Assert
    verify(sketch).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link KllFloatsSketchSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KllFloatsSketch KllFloatsSketchSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new KllFloatsSketchSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link KllFloatsSketchSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean KllFloatsSketchSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new KllFloatsSketchSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#equals(Object)}, and {@link KllFloatsSketchSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KllFloatsSketchSerialiser#equals(Object)}
   *   <li>{@link KllFloatsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean KllFloatsSketchSerialiser.equals(Object)", "int KllFloatsSketchSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KllFloatsSketchSerialiser kllFloatsSketchSerialiser = new KllFloatsSketchSerialiser();
    KllFloatsSketchSerialiser kllFloatsSketchSerialiser2 = new KllFloatsSketchSerialiser();

    // Act and Assert
    assertEquals(kllFloatsSketchSerialiser, kllFloatsSketchSerialiser2);
    int expectedHashCodeResult = kllFloatsSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, kllFloatsSketchSerialiser2.hashCode());
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#equals(Object)}, and {@link KllFloatsSketchSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KllFloatsSketchSerialiser#equals(Object)}
   *   <li>{@link KllFloatsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean KllFloatsSketchSerialiser.equals(Object)", "int KllFloatsSketchSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KllFloatsSketchSerialiser kllFloatsSketchSerialiser = new KllFloatsSketchSerialiser();

    // Act and Assert
    assertEquals(kllFloatsSketchSerialiser, kllFloatsSketchSerialiser);
    int expectedHashCodeResult = kllFloatsSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, kllFloatsSketchSerialiser.hashCode());
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KllFloatsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean KllFloatsSketchSerialiser.equals(Object)", "int KllFloatsSketchSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KllFloatsSketchSerialiser(), 1);
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KllFloatsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean KllFloatsSketchSerialiser.equals(Object)", "int KllFloatsSketchSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KllFloatsSketchSerialiser(), null);
  }

  /**
   * Test {@link KllFloatsSketchSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KllFloatsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean KllFloatsSketchSerialiser.equals(Object)", "int KllFloatsSketchSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KllFloatsSketchSerialiser(), "Different type to KllFloatsSketchSerialiser");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link KllFloatsSketchSerialiser}
   *   <li>{@link KllFloatsSketchSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void KllFloatsSketchSerialiser.<init>()", "boolean KllFloatsSketchSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new KllFloatsSketchSerialiser()).isConsistent());
  }
}
