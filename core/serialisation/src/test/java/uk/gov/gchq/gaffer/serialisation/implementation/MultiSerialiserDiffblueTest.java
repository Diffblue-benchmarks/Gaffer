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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferCheckedException;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.MultiSerialiserStorage.SerialiserDetail;

class MultiSerialiserDiffblueTest {
  /**
   * Test {@link MultiSerialiser#setSerialisers(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#setSerialisers(List)}
   */
  @Test
  @DisplayName("Test setSerialisers(List); given 'null'; when ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MultiSerialiser.setSerialisers(List)"})
  void testSetSerialisers_givenNull_whenArrayListAddNull() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();

    ArrayList<SerialiserDetail> serialisers = new ArrayList<>();
    serialisers.add(null);

    // Act
    multiSerialiser.setSerialisers(serialisers);

    // Assert that nothing has changed
    assertTrue(multiSerialiser.getSerialisers().isEmpty());
  }

  /**
   * Test {@link MultiSerialiser#setSerialisers(List)}.
   * <ul>
   *   <li>Then {@link MultiSerialiser} (default constructor) Serialisers size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#setSerialisers(List)}
   */
  @Test
  @DisplayName("Test setSerialisers(List); then MultiSerialiser (default constructor) Serialisers size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MultiSerialiser.setSerialisers(List)"})
  void testSetSerialisers_thenMultiSerialiserSerialisersSizeIsOne() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();

    ArrayList<SerialiserDetail> serialisers = new ArrayList<>();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> valueClass = Object.class;
    serialisers.add(new SerialiserDetail((byte) 'A', serialiser, valueClass));

    // Act
    multiSerialiser.setSerialisers(serialisers);

    // Assert
    List<SerialiserDetail> serialisers2 = multiSerialiser.getSerialisers();
    assertEquals(1, serialisers2.size());
    SerialiserDetail getResult = serialisers2.get(0);
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, getResult.getSerialiser());
    assertSame(valueClass, getResult.getValueClass());
  }

  /**
   * Test {@link MultiSerialiser#setSerialisers(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link MultiSerialiser} (default constructor) Serialisers Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#setSerialisers(List)}
   */
  @Test
  @DisplayName("Test setSerialisers(List); when ArrayList(); then MultiSerialiser (default constructor) Serialisers Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MultiSerialiser.setSerialisers(List)"})
  void testSetSerialisers_whenArrayList_thenMultiSerialiserSerialisersEmpty() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();

    // Act
    multiSerialiser.setSerialisers(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(multiSerialiser.getSerialisers().isEmpty());
  }

  /**
   * Test {@link MultiSerialiser#addSerialiser(byte, ToBytesSerialiser, Class)}.
   * <ul>
   *   <li>When {@link NullSerialiser} (default constructor).</li>
   *   <li>Then {@link MultiSerialiser} (default constructor) Serialisers size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#addSerialiser(byte, ToBytesSerialiser, Class)}
   */
  @Test
  @DisplayName("Test addSerialiser(byte, ToBytesSerialiser, Class); when NullSerialiser (default constructor); then MultiSerialiser (default constructor) Serialisers size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MultiSerialiser MultiSerialiser.addSerialiser(byte, ToBytesSerialiser, Class)"})
  void testAddSerialiser_whenNullSerialiser_thenMultiSerialiserSerialisersSizeIsOne() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> aClass = Object.class;

    // Act
    MultiSerialiser actualAddSerialiserResult = multiSerialiser.addSerialiser((byte) 'A', serialiser, aClass);

    // Assert
    List<SerialiserDetail> serialisers = multiSerialiser.getSerialisers();
    assertEquals(1, serialisers.size());
    SerialiserDetail getResult = serialisers.get(0);
    assertEquals('A', getResult.getKey());
    assertSame(multiSerialiser, actualAddSerialiserResult);
    assertSame(serialiser, getResult.getSerialiser());
    assertSame(aClass, getResult.getValueClass());
  }

  /**
   * Test {@link MultiSerialiser#getSerialisers()}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#getSerialisers()}
   */
  @Test
  @DisplayName("Test getSerialisers(); given 'java.lang.Object'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List MultiSerialiser.getSerialisers()"})
  void testGetSerialisers_givenJavaLangObject_thenReturnSizeIsOne() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> aClass = Object.class;
    multiSerialiser.addSerialiser((byte) 'A', serialiser, aClass);

    // Act
    List<SerialiserDetail> actualSerialisers = multiSerialiser.getSerialisers();

    // Assert
    assertEquals(1, actualSerialisers.size());
    SerialiserDetail getResult = actualSerialisers.get(0);
    ToBytesSerialiser serialiser2 = getResult.getSerialiser();
    assertTrue(serialiser2 instanceof NullSerialiser);
    assertTrue(serialiser2.isConsistent());
    Class<Object> expectedValueClass = Object.class;
    assertEquals(expectedValueClass, getResult.getValueClass());
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, serialiser2);
  }

  /**
   * Test {@link MultiSerialiser#getSerialisers()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#getSerialisers()}
   */
  @Test
  @DisplayName("Test getSerialisers(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List MultiSerialiser.getSerialisers()"})
  void testGetSerialisers_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new MultiSerialiser()).getSerialisers().isEmpty());
  }

  /**
   * Test {@link MultiSerialiser#getSerialisers()}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#getSerialisers()}
   */
  @Test
  @DisplayName("Test getSerialisers(); then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List MultiSerialiser.getSerialisers()"})
  void testGetSerialisers_thenReturnSizeIsTwo() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> aClass = Object.class;
    multiSerialiser.addSerialiser((byte) 0, serialiser, aClass);
    NullSerialiser serialiser2 = new NullSerialiser();
    Class<Object> aClass2 = Object.class;
    multiSerialiser.addSerialiser((byte) 'A', serialiser2, aClass2);

    // Act
    List<SerialiserDetail> actualSerialisers = multiSerialiser.getSerialisers();

    // Assert
    assertEquals(2, actualSerialisers.size());
    assertEquals((byte) 0, actualSerialisers.get(0).getKey());
    SerialiserDetail getResult = actualSerialisers.get(1);
    assertEquals('A', getResult.getKey());
    assertSame(serialiser2, getResult.getSerialiser());
    assertSame(aClass2, getResult.getValueClass());
  }

  /**
   * Test {@link MultiSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; given 'java.lang.Object'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object MultiSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_givenJavaLangObject_thenReturnNull()
      throws UnsupportedEncodingException, GafferCheckedException, SerialisationException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> aClass = Object.class;
    multiSerialiser.addSerialiser((byte) 'A', serialiser, aClass);

    // Act and Assert
    assertNull(multiSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MultiSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object MultiSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenAxaxaxaxBytesIsUtf8_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();

    // Act and Assert
    assertThrows(SerialisationException.class, () -> multiSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MultiSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link MultiSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object MultiSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new MultiSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link MultiSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link MultiSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MultiSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new MultiSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link MultiSerialiser#isConsistent()}.
   * <p>
   * Method under test: {@link MultiSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MultiSerialiser.isConsistent()"})
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertTrue((new MultiSerialiser()).isConsistent());
  }

  /**
   * Test {@link MultiSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then {@link MultiSerialiser} (default constructor) Serialisers size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); given 'java.lang.Object'; then MultiSerialiser (default constructor) Serialisers size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MultiSerialiser.canHandle(Class)"})
  void testCanHandle_givenJavaLangObject_thenMultiSerialiserSerialisersSizeIsOne() throws GafferCheckedException {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> aClass = Object.class;
    multiSerialiser.addSerialiser((byte) 'A', serialiser, aClass);
    Class<Object> clazz = Object.class;

    // Act
    boolean actualCanHandleResult = multiSerialiser.canHandle(clazz);

    // Assert
    List<SerialiserDetail> serialisers = multiSerialiser.getSerialisers();
    assertEquals(1, serialisers.size());
    assertTrue(actualCanHandleResult);
    Class<Object> expectedValueClass = Object.class;
    assertEquals(expectedValueClass, serialisers.get(0).getValueClass());
  }

  /**
   * Test {@link MultiSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MultiSerialiser.canHandle(Class)"})
  void testCanHandle_thenReturnFalse() {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(multiSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link MultiSerialiser#equals(Object)}, and {@link MultiSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MultiSerialiser#equals(Object)}
   *   <li>{@link MultiSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MultiSerialiser.equals(Object)", "int MultiSerialiser.hashCode()"})
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
   * Test {@link MultiSerialiser#equals(Object)}, and {@link MultiSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MultiSerialiser#equals(Object)}
   *   <li>{@link MultiSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MultiSerialiser.equals(Object)", "int MultiSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();

    // Act and Assert
    assertEquals(multiSerialiser, multiSerialiser);
    int expectedHashCodeResult = multiSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, multiSerialiser.hashCode());
  }

  /**
   * Test {@link MultiSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MultiSerialiser.equals(Object)", "int MultiSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MultiSerialiser multiSerialiser = new MultiSerialiser();

    // Act and Assert
    assertNotEquals(multiSerialiser, new MultiSerialiserStorage());
  }

  /**
   * Test {@link MultiSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MultiSerialiser.equals(Object)", "int MultiSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MultiSerialiser(), null);
  }

  /**
   * Test {@link MultiSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MultiSerialiser.equals(Object)", "int MultiSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MultiSerialiser(), "Different type to MultiSerialiser");
  }

  /**
   * Test new {@link MultiSerialiser} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link MultiSerialiser}
   */
  @Test
  @DisplayName("Test new MultiSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MultiSerialiser.<init>()"})
  void testNewMultiSerialiser() {
    // Arrange and Act
    MultiSerialiser actualMultiSerialiser = new MultiSerialiser();

    // Assert
    assertTrue(actualMultiSerialiser.getSerialisers().isEmpty());
    assertTrue(actualMultiSerialiser.isConsistent());
  }
}
