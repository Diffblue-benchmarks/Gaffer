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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.apache.datasketches.common.ArrayOfItemsSerDe;
import org.apache.datasketches.frequencies.ItemsSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class StringsSketchSerialiserDiffblueTest {
  /**
   * Test {@link StringsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringsSketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    StringsSketchSerialiser stringsSketchSerialiser = new StringsSketchSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(stringsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link StringsSketchSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code ItemsSketch}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringsSketchSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'org.apache.datasketches.frequencies.ItemsSketch'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringsSketchSerialiser.canHandle(Class)"})
  void testCanHandle_whenOrgApacheDatasketchesFrequenciesItemsSketch_thenReturnTrue() {
    // Arrange
    StringsSketchSerialiser stringsSketchSerialiser = new StringsSketchSerialiser();
    Class<ItemsSketch> clazz = ItemsSketch.class;

    // Act and Assert
    assertTrue(stringsSketchSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link StringsSketchSerialiser#serialise(ItemsSketch)} with {@code ItemsSketch}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link StringsSketchSerialiser#serialise(ItemsSketch)}
   */
  @Test
  @DisplayName(
      "Test serialise(ItemsSketch) with 'ItemsSketch'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] StringsSketchSerialiser.serialise(ItemsSketch)"})
  void testSerialiseWithItemsSketch_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    StringsSketchSerialiser stringsSketchSerialiser = new StringsSketchSerialiser();

    ItemsSketch<String> sketch = mock(ItemsSketch.class);
    when(sketch.toByteArray(Mockito.<ArrayOfItemsSerDe<String>>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSerialiseResult = stringsSketchSerialiser.serialise(sketch);

    // Assert
    verify(sketch).toByteArray(isA(ArrayOfItemsSerDe.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link StringsSketchSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link StringsSketchSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemsSketch StringsSketchSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new StringsSketchSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link StringsSketchSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link StringsSketchSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringsSketchSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new StringsSketchSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link StringsSketchSerialiser#equals(Object)}, and {@link
   * StringsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringsSketchSerialiser#equals(Object)}
   *   <li>{@link StringsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StringsSketchSerialiser.equals(Object)",
    "int StringsSketchSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StringsSketchSerialiser stringsSketchSerialiser = new StringsSketchSerialiser();
    StringsSketchSerialiser stringsSketchSerialiser2 = new StringsSketchSerialiser();

    // Act and Assert
    assertEquals(stringsSketchSerialiser, stringsSketchSerialiser2);
    assertEquals(stringsSketchSerialiser.hashCode(), stringsSketchSerialiser2.hashCode());
  }

  /**
   * Test {@link StringsSketchSerialiser#equals(Object)}, and {@link
   * StringsSketchSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringsSketchSerialiser#equals(Object)}
   *   <li>{@link StringsSketchSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StringsSketchSerialiser.equals(Object)",
    "int StringsSketchSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StringsSketchSerialiser stringsSketchSerialiser = new StringsSketchSerialiser();

    // Act and Assert
    assertEquals(stringsSketchSerialiser, stringsSketchSerialiser);
    int expectedHashCodeResult = stringsSketchSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, stringsSketchSerialiser.hashCode());
  }

  /**
   * Test {@link StringsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StringsSketchSerialiser.equals(Object)",
    "int StringsSketchSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringsSketchSerialiser(), 1);
  }

  /**
   * Test {@link StringsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StringsSketchSerialiser.equals(Object)",
    "int StringsSketchSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringsSketchSerialiser(), null);
  }

  /**
   * Test {@link StringsSketchSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StringsSketchSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StringsSketchSerialiser.equals(Object)",
    "int StringsSketchSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringsSketchSerialiser(), "Different type to StringsSketchSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StringsSketchSerialiser}
   *   <li>{@link StringsSketchSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StringsSketchSerialiser.<init>()",
    "boolean StringsSketchSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new StringsSketchSerialiser().isConsistent());
  }
}
