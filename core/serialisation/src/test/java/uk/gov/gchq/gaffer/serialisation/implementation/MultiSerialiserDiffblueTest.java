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

package uk.gov.gchq.gaffer.serialisation.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferCheckedException;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;

class MultiSerialiserDiffblueTest {
  /**
   * Method under test: {@link MultiSerialiser#setSerialisers(List)}
   */
  @Test
  void testSetSerialisers() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();

    // Act
    multiSerialiser.setSerialisers(new ArrayList<>());

    // Assert
    assertTrue(multiSerialiser.getSerialisers().isEmpty());
  }

  /**
   * Method under test: {@link MultiSerialiser#setSerialisers(List)}
   */
  @Test
  void testSetSerialisers2() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();

    ArrayList<MultiSerialiserStorage.SerialiserDetail> serialisers = new ArrayList<>();
    serialisers.add(null);

    // Act
    multiSerialiser.setSerialisers(serialisers);

    // Assert
    assertTrue(multiSerialiser.getSerialisers().isEmpty());
  }

  /**
   * Method under test: {@link MultiSerialiser#setSerialisers(List)}
   */
  @Test
  void testSetSerialisers3() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();

    ArrayList<MultiSerialiserStorage.SerialiserDetail> serialisers = new ArrayList<>();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> valueClass = Object.class;
    serialisers.add(new MultiSerialiserStorage.SerialiserDetail((byte) 'A', serialiser, valueClass));

    // Act
    multiSerialiser.setSerialisers(serialisers);

    // Assert
    List<MultiSerialiserStorage.SerialiserDetail> serialisers2 = multiSerialiser.getSerialisers();
    assertEquals(1, serialisers2.size());
    MultiSerialiserStorage.SerialiserDetail getResult = serialisers2.get(0);
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, getResult.getSerialiser());
    assertSame(valueClass, getResult.getValueClass());
  }

  /**
   * Method under test:
   * {@link MultiSerialiser#addSerialiser(byte, ToBytesSerialiser, Class)}
   */
  @Test
  void testAddSerialiser() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> aClass = Object.class;

    // Act
    MultiSerialiser actualAddSerialiserResult = multiSerialiser.addSerialiser((byte) 'A', serialiser, aClass);

    // Assert
    List<MultiSerialiserStorage.SerialiserDetail> serialisers = multiSerialiser.getSerialisers();
    assertEquals(1, serialisers.size());
    MultiSerialiserStorage.SerialiserDetail getResult = serialisers.get(0);
    assertEquals('A', getResult.getKey());
    assertSame(multiSerialiser, actualAddSerialiserResult);
    assertSame(serialiser, getResult.getSerialiser());
    assertSame(aClass, getResult.getValueClass());
  }

  /**
   * Method under test: {@link MultiSerialiser#getSerialisers()}
   */
  @Test
  void testGetSerialisers() {
    // Arrange, Act and Assert
    assertTrue((new MultiSerialiser()).getSerialisers().isEmpty());
  }

  /**
   * Method under test: {@link MultiSerialiser#getSerialisers()}
   */
  @Test
  void testGetSerialisers2() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> aClass = Object.class;
    multiSerialiser.addSerialiser((byte) 'A', serialiser, aClass);

    // Act
    List<MultiSerialiserStorage.SerialiserDetail> actualSerialisers = multiSerialiser.getSerialisers();

    // Assert
    assertEquals(1, actualSerialisers.size());
    MultiSerialiserStorage.SerialiserDetail getResult = actualSerialisers.get(0);
    ToBytesSerialiser serialiser2 = getResult.getSerialiser();
    assertTrue(serialiser2 instanceof NullSerialiser);
    assertTrue(serialiser2.isConsistent());
    Class<Object> expectedValueClass = Object.class;
    Class valueClass = getResult.getValueClass();
    assertEquals(expectedValueClass, valueClass);
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, serialiser2);
    assertSame(aClass, valueClass);
  }

  /**
   * Method under test: {@link MultiSerialiser#getSerialisers()}
   */
  @Test
  void testGetSerialisers3() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> aClass = Object.class;
    multiSerialiser.addSerialiser((byte) 0, serialiser, aClass);
    NullSerialiser serialiser2 = new NullSerialiser();
    Class<Object> aClass2 = Object.class;
    multiSerialiser.addSerialiser((byte) 'A', serialiser2, aClass2);

    // Act
    List<MultiSerialiserStorage.SerialiserDetail> actualSerialisers = multiSerialiser.getSerialisers();

    // Assert
    assertEquals(2, actualSerialisers.size());
    MultiSerialiserStorage.SerialiserDetail getResult = actualSerialisers.get(0);
    ToBytesSerialiser serialiser3 = getResult.getSerialiser();
    assertTrue(serialiser3 instanceof NullSerialiser);
    assertEquals((byte) 0, getResult.getKey());
    assertTrue(serialiser3.isConsistent());
    Class<Object> expectedValueClass = Object.class;
    Class valueClass = getResult.getValueClass();
    assertEquals(expectedValueClass, valueClass);
    MultiSerialiserStorage.SerialiserDetail getResult2 = actualSerialisers.get(1);
    assertEquals('A', getResult2.getKey());
    assertSame(serialiser, serialiser3);
    assertSame(serialiser2, getResult2.getSerialiser());
    assertSame(aClass2, valueClass);
    assertSame(aClass2, getResult2.getValueClass());
  }

  /**
   * Method under test: {@link MultiSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();

    // Act and Assert
    assertThrows(SerialisationException.class, () -> multiSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link MultiSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise2() throws UnsupportedEncodingException, GafferCheckedException, SerialisationException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> aClass = Object.class;
    multiSerialiser.addSerialiser((byte) 'A', serialiser, aClass);

    // Act and Assert
    assertNull(multiSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link MultiSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new MultiSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link MultiSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new MultiSerialiser()).preservesObjectOrdering());
  }

  /**
   * Method under test: {@link MultiSerialiser#isConsistent()}
   */
  @Test
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertTrue((new MultiSerialiser()).isConsistent());
  }

  /**
   * Method under test: {@link MultiSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(multiSerialiser.canHandle(clazz));
    assertTrue(multiSerialiser.getSerialisers().isEmpty());
  }

  /**
   * Method under test: {@link MultiSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> aClass = Object.class;
    multiSerialiser.addSerialiser((byte) 'A', serialiser, aClass);
    Class<Object> clazz = Object.class;

    // Act
    boolean actualCanHandleResult = multiSerialiser.canHandle(clazz);

    // Assert
    List<MultiSerialiserStorage.SerialiserDetail> serialisers = multiSerialiser.getSerialisers();
    assertEquals(1, serialisers.size());
    assertTrue(actualCanHandleResult);
    Class<Object> expectedValueClass = Object.class;
    Class valueClass = serialisers.get(0).getValueClass();
    assertEquals(expectedValueClass, valueClass);
    assertSame(clazz, valueClass);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MultiSerialiser#equals(Object)}
   *   <li>{@link MultiSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();
    MultiSerialiser multiSerialiser2 = new MultiSerialiser();

    // Act and Assert
    assertEquals(multiSerialiser, multiSerialiser2);
    int expectedHashCodeResult = multiSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, multiSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MultiSerialiser#equals(Object)}
   *   <li>{@link MultiSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();

    // Act and Assert
    assertEquals(multiSerialiser, multiSerialiser);
    int expectedHashCodeResult = multiSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, multiSerialiser.hashCode());
  }

  /**
   * Method under test: {@link MultiSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();

    // Act and Assert
    assertNotEquals(multiSerialiser, new MultiSerialiserStorage());
  }

  /**
   * Method under test: {@link MultiSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new MultiSerialiser(), mock(MultiSerialiserStorage.class));
  }

  /**
   * Method under test: {@link MultiSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MultiSerialiser(), null);
  }

  /**
   * Method under test: {@link MultiSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MultiSerialiser(), "Different type to MultiSerialiser");
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link MultiSerialiser}
   */
  @Test
  void testNewMultiSerialiser() {
    // Arrange and Act
    MultiSerialiser actualMultiSerialiser = new MultiSerialiser();

    // Assert
    assertTrue(actualMultiSerialiser.getSerialisers().isEmpty());
    assertTrue(actualMultiSerialiser.isConsistent());
  }
}
