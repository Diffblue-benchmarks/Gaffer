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

package uk.gov.gchq.gaffer.sketches.datasketches.theta.serialisation;

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
import org.apache.datasketches.theta.CompactSketch;
import org.apache.datasketches.theta.Union;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class UnionSerialiserDiffblueTest {
  /**
   * Test {@link UnionSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UnionSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    UnionSerialiser unionSerialiser = new UnionSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(unionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link UnionSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Union}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnionSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'org.apache.datasketches.theta.Union'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UnionSerialiser.canHandle(Class)"})
  void testCanHandle_whenOrgApacheDatasketchesThetaUnion_thenReturnTrue() {
    // Arrange
    UnionSerialiser unionSerialiser = new UnionSerialiser();
    Class<Union> clazz = Union.class;

    // Act and Assert
    assertTrue(unionSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link UnionSerialiser#serialise(Union)} with {@code Union}.
   * <p>
   * Method under test: {@link UnionSerialiser#serialise(Union)}
   */
  @Test
  @DisplayName("Test serialise(Union) with 'Union'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] UnionSerialiser.serialise(Union)"})
  void testSerialiseWithUnion() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    UnionSerialiser unionSerialiser = new UnionSerialiser();
    CompactSketch compactSketch = mock(CompactSketch.class);
    when(compactSketch.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Union union = mock(Union.class);
    when(union.getResult()).thenReturn(compactSketch);

    // Act
    byte[] actualSerialiseResult = unionSerialiser.serialise(union);

    // Assert
    verify(compactSketch).toByteArray();
    verify(union).getResult();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link UnionSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link UnionSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Union UnionSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new UnionSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link UnionSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link UnionSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UnionSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new UnionSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link UnionSerialiser#equals(Object)}, and {@link UnionSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UnionSerialiser#equals(Object)}
   *   <li>{@link UnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UnionSerialiser.equals(Object)", "int UnionSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnionSerialiser unionSerialiser = new UnionSerialiser();
    UnionSerialiser unionSerialiser2 = new UnionSerialiser();

    // Act and Assert
    assertEquals(unionSerialiser, unionSerialiser2);
    int expectedHashCodeResult = unionSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, unionSerialiser2.hashCode());
  }

  /**
   * Test {@link UnionSerialiser#equals(Object)}, and {@link UnionSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UnionSerialiser#equals(Object)}
   *   <li>{@link UnionSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UnionSerialiser.equals(Object)", "int UnionSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnionSerialiser unionSerialiser = new UnionSerialiser();

    // Act and Assert
    assertEquals(unionSerialiser, unionSerialiser);
    int expectedHashCodeResult = unionSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, unionSerialiser.hashCode());
  }

  /**
   * Test {@link UnionSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UnionSerialiser.equals(Object)", "int UnionSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnionSerialiser(), 1);
  }

  /**
   * Test {@link UnionSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UnionSerialiser.equals(Object)", "int UnionSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnionSerialiser(), null);
  }

  /**
   * Test {@link UnionSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnionSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UnionSerialiser.equals(Object)", "int UnionSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnionSerialiser(), "Different type to UnionSerialiser");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UnionSerialiser}
   *   <li>{@link UnionSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UnionSerialiser.<init>()", "boolean UnionSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new UnionSerialiser()).isConsistent());
  }
}
