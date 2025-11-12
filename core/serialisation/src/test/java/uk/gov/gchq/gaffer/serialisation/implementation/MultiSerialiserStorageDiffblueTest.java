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
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.core.exception.GafferCheckedException;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;

class MultiSerialiserStorageDiffblueTest {
  /**
   * Method under test:
   * {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}
   */
  @Test
  void testPut() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    BooleanSerialiser serialiser = new BooleanSerialiser();
    Class<Object> supportedClass = Object.class;

    // Act and Assert
    assertThrows(GafferCheckedException.class,
        () -> multiSerialiserStorage.put((byte) 'A', serialiser, supportedClass));
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}
   */
  @Test
  void testPut2() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    Class<Object> supportedClass = Object.class;

    // Act and Assert
    assertThrows(GafferCheckedException.class, () -> multiSerialiserStorage.put((byte) 'A', null, supportedClass));
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}
   */
  @Test
  void testPut3() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    MultiSerialiser serialiser = new MultiSerialiser();
    Class<Object> supportedClass = Object.class;

    // Act and Assert
    assertThrows(GafferCheckedException.class,
        () -> multiSerialiserStorage.put((byte) 'A', serialiser, supportedClass));
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}
   */
  @Test
  void testPut4() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> supportedClass = Object.class;

    // Act
    multiSerialiserStorage.put((byte) 'A', serialiser, supportedClass);

    // Assert
    List<MultiSerialiserStorage.SerialiserDetail> serialiserDetails = multiSerialiserStorage.getSerialiserDetails();
    assertEquals(1, serialiserDetails.size());
    Class<Object> expectedValueClass = Object.class;
    MultiSerialiserStorage.SerialiserDetail getResult = serialiserDetails.get(0);
    Class valueClass = getResult.getValueClass();
    assertEquals(expectedValueClass, valueClass);
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, getResult.getSerialiser());
    assertSame(supportedClass, valueClass);
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}
   */
  @Test
  void testPut5() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    // Act and Assert
    assertThrows(GafferCheckedException.class,
        () -> multiSerialiserStorage.put((byte) 'A', new BooleanSerialiser(), null));
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#getSerialiserFromKey(Byte)}
   */
  @Test
  void testGetSerialiserFromKey() {
    // Arrange, Act and Assert
    assertNull((new MultiSerialiserStorage()).getSerialiserFromKey((byte) 'A'));
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#getKeyFromValue(Object)}
   */
  @Test
  void testGetKeyFromValue() {
    // Arrange, Act and Assert
    assertNull((new MultiSerialiserStorage()).getKeyFromValue("Object"));
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#getSerialiserFromValue(Object)}
   */
  @Test
  void testGetSerialiserFromValue() {
    // Arrange, Act and Assert
    assertNull((new MultiSerialiserStorage()).getSerialiserFromValue("Object"));
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    Class<Object> handleClass = Object.class;

    // Act and Assert
    assertFalse(multiSerialiserStorage.canHandle(handleClass));
    assertTrue(multiSerialiserStorage.getSerialiserDetails().isEmpty());
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#canHandle(Class)}
   */
  @Test
  void testCanHandle2() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> supportedClass = Object.class;
    multiSerialiserStorage.put((byte) 'A', serialiser, supportedClass);
    Class<Object> handleClass = Object.class;

    // Act
    boolean actualCanHandleResult = multiSerialiserStorage.canHandle(handleClass);

    // Assert
    List<MultiSerialiserStorage.SerialiserDetail> serialiserDetails = multiSerialiserStorage.getSerialiserDetails();
    assertEquals(1, serialiserDetails.size());
    assertTrue(actualCanHandleResult);
    Class<Object> expectedValueClass = Object.class;
    Class valueClass = serialiserDetails.get(0).getValueClass();
    assertEquals(expectedValueClass, valueClass);
    assertSame(handleClass, valueClass);
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#addSerialiserDetails(byte, ToBytesSerialiser, Class)}
   */
  @Test
  void testAddSerialiserDetails() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    BooleanSerialiser serialiser = new BooleanSerialiser();
    Class<Object> aClass = Object.class;

    // Act and Assert
    assertThrows(GafferCheckedException.class,
        () -> multiSerialiserStorage.addSerialiserDetails((byte) 'A', serialiser, aClass));
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#addSerialiserDetails(byte, ToBytesSerialiser, Class)}
   */
  @Test
  void testAddSerialiserDetails2() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    MultiSerialiser serialiser = new MultiSerialiser();
    Class<Object> aClass = Object.class;

    // Act and Assert
    assertThrows(GafferCheckedException.class,
        () -> multiSerialiserStorage.addSerialiserDetails((byte) 'A', serialiser, aClass));
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#addSerialiserDetails(byte, ToBytesSerialiser, Class)}
   */
  @Test
  void testAddSerialiserDetails3() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    Class<Object> aClass = Object.class;

    // Act and Assert
    assertThrows(GafferCheckedException.class,
        () -> multiSerialiserStorage.addSerialiserDetails((byte) 'A', null, aClass));
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#addSerialiserDetails(byte, ToBytesSerialiser, Class)}
   */
  @Test
  void testAddSerialiserDetails4() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    // Act and Assert
    assertThrows(GafferCheckedException.class,
        () -> multiSerialiserStorage.addSerialiserDetails((byte) 'A', new BooleanSerialiser(), null));
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#addSerialiserDetails(byte, ToBytesSerialiser, Class)}
   */
  @Test
  void testAddSerialiserDetails5() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> aClass = Object.class;

    // Act
    multiSerialiserStorage.addSerialiserDetails((byte) 'A', serialiser, aClass);

    // Assert
    List<MultiSerialiserStorage.SerialiserDetail> serialiserDetails = multiSerialiserStorage.getSerialiserDetails();
    assertEquals(1, serialiserDetails.size());
    Class<Object> expectedValueClass = Object.class;
    MultiSerialiserStorage.SerialiserDetail getResult = serialiserDetails.get(0);
    Class valueClass = getResult.getValueClass();
    assertEquals(expectedValueClass, valueClass);
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, getResult.getSerialiser());
    assertSame(aClass, valueClass);
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#addSerialiserDetails(MultiSerialiserStorage.SerialiserDetail)}
   */
  @Test
  void testAddSerialiserDetails6() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    // Act and Assert
    assertThrows(GafferCheckedException.class,
        () -> multiSerialiserStorage.addSerialiserDetails(new MultiSerialiserStorage.SerialiserDetail()));
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#addSerialiserDetails(MultiSerialiserStorage.SerialiserDetail)}
   */
  @Test
  void testAddSerialiserDetails7() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    MultiSerialiserStorage.SerialiserDetail serialiserDetail = new MultiSerialiserStorage.SerialiserDetail();
    Class<Object> valueClass = Object.class;
    serialiserDetail.valueClass(valueClass);

    // Act and Assert
    assertThrows(GafferCheckedException.class, () -> multiSerialiserStorage.addSerialiserDetails(serialiserDetail));
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#addSerialiserDetails(MultiSerialiserStorage.SerialiserDetail)}
   */
  @Test
  void testAddSerialiserDetails8() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    BooleanSerialiser serialiser = new BooleanSerialiser();
    Class<Object> valueClass = Object.class;

    // Act and Assert
    assertThrows(GafferCheckedException.class, () -> multiSerialiserStorage
        .addSerialiserDetails(new MultiSerialiserStorage.SerialiserDetail((byte) 'A', serialiser, valueClass)));
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#addSerialiserDetails(MultiSerialiserStorage.SerialiserDetail)}
   */
  @Test
  void testAddSerialiserDetails9() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    // Act
    multiSerialiserStorage.addSerialiserDetails(null);

    // Assert that nothing has changed
    assertTrue(multiSerialiserStorage.getSerialiserDetails().isEmpty());
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#addSerialiserDetails(MultiSerialiserStorage.SerialiserDetail)}
   */
  @Test
  void testAddSerialiserDetails10() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    MultiSerialiser serialiser = new MultiSerialiser();
    Class<Object> valueClass = Object.class;

    // Act and Assert
    assertThrows(GafferCheckedException.class, () -> multiSerialiserStorage
        .addSerialiserDetails(new MultiSerialiserStorage.SerialiserDetail((byte) 'A', serialiser, valueClass)));
  }

  /**
   * Method under test:
   * {@link MultiSerialiserStorage#addSerialiserDetails(MultiSerialiserStorage.SerialiserDetail)}
   */
  @Test
  void testAddSerialiserDetails11() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> valueClass = Object.class;

    // Act
    multiSerialiserStorage
        .addSerialiserDetails(new MultiSerialiserStorage.SerialiserDetail((byte) 'A', serialiser, valueClass));

    // Assert
    List<MultiSerialiserStorage.SerialiserDetail> serialiserDetails = multiSerialiserStorage.getSerialiserDetails();
    assertEquals(1, serialiserDetails.size());
    MultiSerialiserStorage.SerialiserDetail getResult = serialiserDetails.get(0);
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, getResult.getSerialiser());
    assertSame(valueClass, getResult.getValueClass());
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#getSerialiserDetails()}
   */
  @Test
  void testGetSerialiserDetails() {
    // Arrange, Act and Assert
    assertTrue((new MultiSerialiserStorage()).getSerialiserDetails().isEmpty());
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#getSerialiserDetails()}
   */
  @Test
  void testGetSerialiserDetails2() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> supportedClass = Object.class;
    multiSerialiserStorage.put((byte) 'A', serialiser, supportedClass);

    // Act
    List<MultiSerialiserStorage.SerialiserDetail> actualSerialiserDetails = multiSerialiserStorage
        .getSerialiserDetails();

    // Assert
    assertEquals(1, actualSerialiserDetails.size());
    MultiSerialiserStorage.SerialiserDetail getResult = actualSerialiserDetails.get(0);
    ToBytesSerialiser serialiser2 = getResult.getSerialiser();
    assertTrue(serialiser2 instanceof NullSerialiser);
    assertTrue(serialiser2.isConsistent());
    Class<Object> expectedValueClass = Object.class;
    Class valueClass = getResult.getValueClass();
    assertEquals(expectedValueClass, valueClass);
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, serialiser2);
    assertSame(supportedClass, valueClass);
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#getSerialiserDetails()}
   */
  @Test
  void testGetSerialiserDetails3() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> supportedClass = Object.class;
    multiSerialiserStorage.put((byte) 'X', serialiser, supportedClass);
    NullSerialiser serialiser2 = new NullSerialiser();
    Class<Object> supportedClass2 = Object.class;
    multiSerialiserStorage.put((byte) 'A', serialiser2, supportedClass2);

    // Act
    List<MultiSerialiserStorage.SerialiserDetail> actualSerialiserDetails = multiSerialiserStorage
        .getSerialiserDetails();

    // Assert
    assertEquals(2, actualSerialiserDetails.size());
    MultiSerialiserStorage.SerialiserDetail getResult = actualSerialiserDetails.get(1);
    ToBytesSerialiser serialiser3 = getResult.getSerialiser();
    assertTrue(serialiser3 instanceof NullSerialiser);
    assertTrue(serialiser3.isConsistent());
    Class<Object> expectedValueClass = Object.class;
    MultiSerialiserStorage.SerialiserDetail getResult2 = actualSerialiserDetails.get(0);
    Class valueClass = getResult2.getValueClass();
    assertEquals(expectedValueClass, valueClass);
    assertEquals('A', getResult2.getKey());
    assertEquals('X', getResult.getKey());
    assertSame(serialiser2, getResult2.getSerialiser());
    assertSame(serialiser, serialiser3);
    assertSame(supportedClass2, valueClass);
    assertSame(supportedClass2, getResult.getValueClass());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MultiSerialiserStorage.SerialiserDetail#SerialiserDetail()}
   *   <li>{@link MultiSerialiserStorage.SerialiserDetail#key(byte)}
   *   <li>
   * {@link MultiSerialiserStorage.SerialiserDetail#serialiser(ToBytesSerialiser)}
   *   <li>{@link MultiSerialiserStorage.SerialiserDetail#valueClass(Class)}
   *   <li>{@link MultiSerialiserStorage.SerialiserDetail#getKey()}
   *   <li>{@link MultiSerialiserStorage.SerialiserDetail#getSerialiser()}
   *   <li>{@link MultiSerialiserStorage.SerialiserDetail#getValueClass()}
   * </ul>
   */
  @Test
  void testSerialiserDetailGettersAndSetters() {
    // Arrange and Act
    MultiSerialiserStorage.SerialiserDetail actualSerialiserDetail = new MultiSerialiserStorage.SerialiserDetail();
    MultiSerialiserStorage.SerialiserDetail actualKeyResult = actualSerialiserDetail.key((byte) 'A');
    BooleanSerialiser serialiser = new BooleanSerialiser();
    MultiSerialiserStorage.SerialiserDetail actualSerialiserResult = actualSerialiserDetail.serialiser(serialiser);
    Class<Object> valueClass = Object.class;
    MultiSerialiserStorage.SerialiserDetail actualValueClassResult = actualSerialiserDetail.valueClass(valueClass);
    byte actualKey = actualSerialiserDetail.getKey();
    ToBytesSerialiser actualSerialiser = actualSerialiserDetail.getSerialiser();
    Class actualValueClass = actualSerialiserDetail.getValueClass();

    // Assert
    assertTrue(actualSerialiser instanceof BooleanSerialiser);
    Class<Object> expectedValueClass = Object.class;
    assertEquals(expectedValueClass, actualValueClass);
    assertEquals('A', actualKey);
    assertSame(serialiser, actualSerialiser);
    assertSame(actualSerialiserDetail, actualKeyResult);
    assertSame(actualSerialiserDetail, actualSerialiserResult);
    assertSame(actualSerialiserDetail, actualValueClassResult);
    assertSame(valueClass, actualValueClass);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MultiSerialiserStorage.SerialiserDetail#SerialiserDetail(byte, ToBytesSerialiser, Class)}
   *   <li>{@link MultiSerialiserStorage.SerialiserDetail#key(byte)}
   *   <li>
   * {@link MultiSerialiserStorage.SerialiserDetail#serialiser(ToBytesSerialiser)}
   *   <li>{@link MultiSerialiserStorage.SerialiserDetail#valueClass(Class)}
   *   <li>{@link MultiSerialiserStorage.SerialiserDetail#getKey()}
   *   <li>{@link MultiSerialiserStorage.SerialiserDetail#getSerialiser()}
   *   <li>{@link MultiSerialiserStorage.SerialiserDetail#getValueClass()}
   * </ul>
   */
  @Test
  void testSerialiserDetailGettersAndSetters2() {
    // Arrange
    BooleanSerialiser serialiser = new BooleanSerialiser();
    Class<Object> valueClass = Object.class;

    // Act
    MultiSerialiserStorage.SerialiserDetail actualSerialiserDetail = new MultiSerialiserStorage.SerialiserDetail(
        (byte) 'A', serialiser, valueClass);
    MultiSerialiserStorage.SerialiserDetail actualKeyResult = actualSerialiserDetail.key((byte) 'A');
    BooleanSerialiser serialiser2 = new BooleanSerialiser();
    MultiSerialiserStorage.SerialiserDetail actualSerialiserResult = actualSerialiserDetail.serialiser(serialiser2);
    Class<Object> valueClass2 = Object.class;
    MultiSerialiserStorage.SerialiserDetail actualValueClassResult = actualSerialiserDetail.valueClass(valueClass2);
    byte actualKey = actualSerialiserDetail.getKey();
    ToBytesSerialiser actualSerialiser = actualSerialiserDetail.getSerialiser();
    Class actualValueClass = actualSerialiserDetail.getValueClass();

    // Assert
    Class<Object> expectedValueClass = Object.class;
    assertEquals(expectedValueClass, actualValueClass);
    assertEquals('A', actualKey);
    assertSame(serialiser2, actualSerialiser);
    assertSame(actualSerialiserDetail, actualKeyResult);
    assertSame(actualSerialiserDetail, actualSerialiserResult);
    assertSame(actualSerialiserDetail, actualValueClassResult);
    assertSame(valueClass2, actualValueClass);
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  void testSetSerialiserDetails() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    // Act
    multiSerialiserStorage.setSerialiserDetails(new ArrayList<>());

    // Assert
    assertTrue(multiSerialiserStorage.getSerialiserDetails().isEmpty());
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  void testSetSerialiserDetails2() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    ArrayList<MultiSerialiserStorage.SerialiserDetail> serialisersDetails = new ArrayList<>();
    serialisersDetails.add(new MultiSerialiserStorage.SerialiserDetail());

    // Act and Assert
    assertThrows(GafferCheckedException.class, () -> multiSerialiserStorage.setSerialiserDetails(serialisersDetails));
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  void testSetSerialiserDetails3() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    ArrayList<MultiSerialiserStorage.SerialiserDetail> serialisersDetails = new ArrayList<>();
    serialisersDetails.add(new MultiSerialiserStorage.SerialiserDetail());
    serialisersDetails.add(new MultiSerialiserStorage.SerialiserDetail());

    // Act and Assert
    assertThrows(GafferCheckedException.class, () -> multiSerialiserStorage.setSerialiserDetails(serialisersDetails));
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  void testSetSerialiserDetails4() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    MultiSerialiserStorage.SerialiserDetail serialiserDetail = new MultiSerialiserStorage.SerialiserDetail();
    Class<Object> valueClass = Object.class;
    serialiserDetail.valueClass(valueClass);

    ArrayList<MultiSerialiserStorage.SerialiserDetail> serialisersDetails = new ArrayList<>();
    serialisersDetails.add(serialiserDetail);

    // Act and Assert
    assertThrows(GafferCheckedException.class, () -> multiSerialiserStorage.setSerialiserDetails(serialisersDetails));
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  void testSetSerialiserDetails5() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    ArrayList<MultiSerialiserStorage.SerialiserDetail> serialisersDetails = new ArrayList<>();
    BooleanSerialiser serialiser = new BooleanSerialiser();
    Class<Object> valueClass = Object.class;
    serialisersDetails.add(new MultiSerialiserStorage.SerialiserDetail((byte) 'A', serialiser, valueClass));

    // Act and Assert
    assertThrows(GafferCheckedException.class, () -> multiSerialiserStorage.setSerialiserDetails(serialisersDetails));
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  void testSetSerialiserDetails6() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    ArrayList<MultiSerialiserStorage.SerialiserDetail> serialisersDetails = new ArrayList<>();
    serialisersDetails.add(null);

    // Act
    multiSerialiserStorage.setSerialiserDetails(serialisersDetails);

    // Assert
    assertTrue(multiSerialiserStorage.getSerialiserDetails().isEmpty());
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  void testSetSerialiserDetails7() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    ArrayList<MultiSerialiserStorage.SerialiserDetail> serialisersDetails = new ArrayList<>();
    MultiSerialiser serialiser = new MultiSerialiser();
    Class<Object> valueClass = Object.class;
    serialisersDetails.add(new MultiSerialiserStorage.SerialiserDetail((byte) 'A', serialiser, valueClass));

    // Act and Assert
    assertThrows(GafferCheckedException.class, () -> multiSerialiserStorage.setSerialiserDetails(serialisersDetails));
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  void testSetSerialiserDetails8() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    ArrayList<MultiSerialiserStorage.SerialiserDetail> serialisersDetails = new ArrayList<>();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> valueClass = Object.class;
    serialisersDetails.add(new MultiSerialiserStorage.SerialiserDetail((byte) 'A', serialiser, valueClass));

    // Act
    multiSerialiserStorage.setSerialiserDetails(serialisersDetails);

    // Assert
    List<MultiSerialiserStorage.SerialiserDetail> serialiserDetails = multiSerialiserStorage.getSerialiserDetails();
    assertEquals(1, serialiserDetails.size());
    MultiSerialiserStorage.SerialiserDetail getResult = serialiserDetails.get(0);
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, getResult.getSerialiser());
    assertSame(valueClass, getResult.getValueClass());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MultiSerialiserStorage#equals(Object)}
   *   <li>{@link MultiSerialiserStorage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    MultiSerialiserStorage multiSerialiserStorage2 = new MultiSerialiserStorage();

    // Act and Assert
    assertEquals(multiSerialiserStorage, multiSerialiserStorage2);
    int expectedHashCodeResult = multiSerialiserStorage.hashCode();
    assertEquals(expectedHashCodeResult, multiSerialiserStorage2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MultiSerialiserStorage#equals(Object)}
   *   <li>{@link MultiSerialiserStorage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    // Act and Assert
    assertEquals(multiSerialiserStorage, multiSerialiserStorage);
    int expectedHashCodeResult = multiSerialiserStorage.hashCode();
    assertEquals(expectedHashCodeResult, multiSerialiserStorage.hashCode());
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MultiSerialiserStorage(), null);
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws GafferCheckedException {
    // Arrange
    BooleanSerialiser serialiser = mock(BooleanSerialiser.class);
    when(serialiser.isConsistent()).thenReturn(true);
    when(serialiser.preservesObjectOrdering()).thenReturn(true);
    when(serialiser.canHandle(Mockito.<Class<Object>>any())).thenReturn(true);

    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    Class<Object> supportedClass = Object.class;
    multiSerialiserStorage.put((byte) 'A', serialiser, supportedClass);

    // Act and Assert
    assertNotEquals(multiSerialiserStorage, new MultiSerialiserStorage());
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MultiSerialiserStorage(), null);
  }

  /**
   * Method under test: {@link MultiSerialiserStorage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MultiSerialiserStorage(), "Different type to MultiSerialiserStorage");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MultiSerialiserStorage}
   *   <li>{@link MultiSerialiserStorage#isConsistent()}
   *   <li>{@link MultiSerialiserStorage#preservesObjectOrdering()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MultiSerialiserStorage actualMultiSerialiserStorage = new MultiSerialiserStorage();
    boolean actualIsConsistentResult = actualMultiSerialiserStorage.isConsistent();

    // Assert
    assertTrue(actualIsConsistentResult);
    assertTrue(actualMultiSerialiserStorage.preservesObjectOrdering());
  }
}
