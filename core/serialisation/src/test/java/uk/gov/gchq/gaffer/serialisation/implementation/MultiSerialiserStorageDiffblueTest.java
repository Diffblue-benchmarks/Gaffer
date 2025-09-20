package uk.gov.gchq.gaffer.serialisation.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferCheckedException;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.MultiSerialiserStorage.SerialiserDetail;

class MultiSerialiserStorageDiffblueTest {
  /**
   * Test {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}.
   *
   * <ul>
   *   <li>When {@link BooleanSerialiser} (default constructor).
   *   <li>Then throw {@link GafferCheckedException}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}
   */
  @Test
  @DisplayName(
      "Test put(byte, ToBytesSerialiser, Class); when BooleanSerialiser (default constructor); then throw GafferCheckedException")
  @Tag("MaintainedByDiffblue")
  void testPut_whenBooleanSerialiser_thenThrowGafferCheckedException()
      throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    BooleanSerialiser serialiser = new BooleanSerialiser();
    Class<Object> supportedClass = Object.class;

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.put((byte) 'A', serialiser, supportedClass));
  }

  /**
   * Test {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}.
   *
   * <ul>
   *   <li>When {@link MultiSerialiser} (default constructor).
   *   <li>Then throw {@link GafferCheckedException}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}
   */
  @Test
  @DisplayName(
      "Test put(byte, ToBytesSerialiser, Class); when MultiSerialiser (default constructor); then throw GafferCheckedException")
  @Tag("MaintainedByDiffblue")
  void testPut_whenMultiSerialiser_thenThrowGafferCheckedException() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    MultiSerialiser serialiser = new MultiSerialiser();
    Class<Object> supportedClass = Object.class;

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.put((byte) 'A', serialiser, supportedClass));
  }

  /**
   * Test {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}.
   *
   * <ul>
   *   <li>When {@link NullSerialiser} (default constructor).
   *   <li>Then {@link MultiSerialiserStorage} (default constructor) SerialiserDetails size is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}
   */
  @Test
  @DisplayName(
      "Test put(byte, ToBytesSerialiser, Class); when NullSerialiser (default constructor); then MultiSerialiserStorage (default constructor) SerialiserDetails size is one")
  @Tag("MaintainedByDiffblue")
  void testPut_whenNullSerialiser_thenMultiSerialiserStorageSerialiserDetailsSizeIsOne()
      throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> supportedClass = Object.class;

    // Act
    multiSerialiserStorage.put((byte) 'A', serialiser, supportedClass);

    // Assert
    List<SerialiserDetail> serialiserDetails = multiSerialiserStorage.getSerialiserDetails();
    assertEquals(1, serialiserDetails.size());
    Class<Object> expectedValueClass = Object.class;
    SerialiserDetail getResult = serialiserDetails.get(0);
    assertEquals(expectedValueClass, getResult.getValueClass());
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, getResult.getSerialiser());
  }

  /**
   * Test {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link GafferCheckedException}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}
   */
  @Test
  @DisplayName(
      "Test put(byte, ToBytesSerialiser, Class); when 'null'; then throw GafferCheckedException")
  @Tag("MaintainedByDiffblue")
  void testPut_whenNull_thenThrowGafferCheckedException() throws GafferCheckedException {
    // Arrange, Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> new MultiSerialiserStorage().put((byte) 'A', null, null));
  }

  /**
   * Test {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link GafferCheckedException}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#put(byte, ToBytesSerialiser, Class)}
   */
  @Test
  @DisplayName(
      "Test put(byte, ToBytesSerialiser, Class); when 'null'; then throw GafferCheckedException")
  @Tag("MaintainedByDiffblue")
  void testPut_whenNull_thenThrowGafferCheckedException2() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    Class<Object> supportedClass = Object.class;

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.put((byte) 'A', null, supportedClass));
  }

  /**
   * Test {@link MultiSerialiserStorage#getSerialiserFromKey(Byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#getSerialiserFromKey(Byte)}
   */
  @Test
  @DisplayName("Test getSerialiserFromKey(Byte); when 'A'")
  @Tag("MaintainedByDiffblue")
  void testGetSerialiserFromKey_whenA() {
    // Arrange, Act and Assert
    assertNull(new MultiSerialiserStorage().getSerialiserFromKey((byte) 'A'));
  }

  /**
   * Test {@link MultiSerialiserStorage#getSerialiserFromKey(Byte)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#getSerialiserFromKey(Byte)}
   */
  @Test
  @DisplayName("Test getSerialiserFromKey(Byte); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetSerialiserFromKey_whenNull() {
    // Arrange, Act and Assert
    assertNull(new MultiSerialiserStorage().getSerialiserFromKey(null));
  }

  /**
   * Test {@link MultiSerialiserStorage#getKeyFromValue(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#getKeyFromValue(Object)}
   */
  @Test
  @DisplayName("Test getKeyFromValue(Object); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetKeyFromValue_whenNull() {
    // Arrange, Act and Assert
    assertNull(new MultiSerialiserStorage().getKeyFromValue(null));
  }

  /**
   * Test {@link MultiSerialiserStorage#getKeyFromValue(Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#getKeyFromValue(Object)}
   */
  @Test
  @DisplayName("Test getKeyFromValue(Object); when 'Object'")
  @Tag("MaintainedByDiffblue")
  void testGetKeyFromValue_whenObject() {
    // Arrange, Act and Assert
    assertNull(new MultiSerialiserStorage().getKeyFromValue("Object"));
  }

  /**
   * Test {@link MultiSerialiserStorage#getSerialiserFromValue(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#getSerialiserFromValue(Object)}
   */
  @Test
  @DisplayName("Test getSerialiserFromValue(Object); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetSerialiserFromValue_whenNull() {
    // Arrange, Act and Assert
    assertNull(new MultiSerialiserStorage().getSerialiserFromValue(null));
  }

  /**
   * Test {@link MultiSerialiserStorage#getSerialiserFromValue(Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#getSerialiserFromValue(Object)}
   */
  @Test
  @DisplayName("Test getSerialiserFromValue(Object); when 'Object'")
  @Tag("MaintainedByDiffblue")
  void testGetSerialiserFromValue_whenObject() {
    // Arrange, Act and Assert
    assertNull(new MultiSerialiserStorage().getSerialiserFromValue("Object"));
  }

  /**
   * Test {@link MultiSerialiserStorage#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then {@link MultiSerialiserStorage} (default constructor) SerialiserDetails size is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); then MultiSerialiserStorage (default constructor) SerialiserDetails size is one")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_thenMultiSerialiserStorageSerialiserDetailsSizeIsOne()
      throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> supportedClass = Object.class;

    multiSerialiserStorage.put((byte) 'A', serialiser, supportedClass);
    Class<Object> handleClass = Object.class;

    // Act
    boolean actualCanHandleResult = multiSerialiserStorage.canHandle(handleClass);

    // Assert
    List<SerialiserDetail> serialiserDetails = multiSerialiserStorage.getSerialiserDetails();
    assertEquals(1, serialiserDetails.size());
    assertTrue(actualCanHandleResult);
    Class<Object> expectedValueClass = Object.class;
    assertEquals(expectedValueClass, serialiserDetails.get(0).getValueClass());
  }

  /**
   * Test {@link MultiSerialiserStorage#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testCanHandle_thenReturnFalse() {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    Class<Object> handleClass = Object.class;

    // Act and Assert
    assertFalse(multiSerialiserStorage.canHandle(handleClass));
  }

  /**
   * Test {@link MultiSerialiserStorage#addSerialiserDetails(byte, ToBytesSerialiser, Class)} with
   * {@code key}, {@code serialiser}, {@code aClass}.
   *
   * <p>Method under test: {@link MultiSerialiserStorage#addSerialiserDetails(byte,
   * ToBytesSerialiser, Class)}
   */
  @Test
  @DisplayName(
      "Test addSerialiserDetails(byte, ToBytesSerialiser, Class) with 'key', 'serialiser', 'aClass'")
  @Tag("MaintainedByDiffblue")
  void testAddSerialiserDetailsWithKeySerialiserAClass() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> aClass = Object.class;

    // Act
    multiSerialiserStorage.addSerialiserDetails((byte) 'A', serialiser, aClass);

    // Assert
    List<SerialiserDetail> serialiserDetails = multiSerialiserStorage.getSerialiserDetails();
    assertEquals(1, serialiserDetails.size());
    Class<Object> expectedValueClass = Object.class;
    SerialiserDetail getResult = serialiserDetails.get(0);
    assertEquals(expectedValueClass, getResult.getValueClass());
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, getResult.getSerialiser());
  }

  /**
   * Test {@link MultiSerialiserStorage#addSerialiserDetails(byte, ToBytesSerialiser, Class)} with
   * {@code key}, {@code serialiser}, {@code aClass}.
   *
   * <ul>
   *   <li>When {@link BooleanSerialiser} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#addSerialiserDetails(byte,
   * ToBytesSerialiser, Class)}
   */
  @Test
  @DisplayName(
      "Test addSerialiserDetails(byte, ToBytesSerialiser, Class) with 'key', 'serialiser', 'aClass'; when BooleanSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testAddSerialiserDetailsWithKeySerialiserAClass_whenBooleanSerialiser()
      throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    BooleanSerialiser serialiser = new BooleanSerialiser();
    Class<Object> aClass = Object.class;

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.addSerialiserDetails((byte) 'A', serialiser, aClass));
  }

  /**
   * Test {@link MultiSerialiserStorage#addSerialiserDetails(byte, ToBytesSerialiser, Class)} with
   * {@code key}, {@code serialiser}, {@code aClass}.
   *
   * <ul>
   *   <li>When {@link BooleanSerialiser} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#addSerialiserDetails(byte,
   * ToBytesSerialiser, Class)}
   */
  @Test
  @DisplayName(
      "Test addSerialiserDetails(byte, ToBytesSerialiser, Class) with 'key', 'serialiser', 'aClass'; when BooleanSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testAddSerialiserDetailsWithKeySerialiserAClass_whenBooleanSerialiser2()
      throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () ->
            multiSerialiserStorage.addSerialiserDetails((byte) 'A', new BooleanSerialiser(), null));
  }

  /**
   * Test {@link MultiSerialiserStorage#addSerialiserDetails(byte, ToBytesSerialiser, Class)} with
   * {@code key}, {@code serialiser}, {@code aClass}.
   *
   * <ul>
   *   <li>When {@link MultiSerialiser} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#addSerialiserDetails(byte,
   * ToBytesSerialiser, Class)}
   */
  @Test
  @DisplayName(
      "Test addSerialiserDetails(byte, ToBytesSerialiser, Class) with 'key', 'serialiser', 'aClass'; when MultiSerialiser (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testAddSerialiserDetailsWithKeySerialiserAClass_whenMultiSerialiser()
      throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    MultiSerialiser serialiser = new MultiSerialiser();
    Class<Object> aClass = Object.class;

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.addSerialiserDetails((byte) 'A', serialiser, aClass));
  }

  /**
   * Test {@link MultiSerialiserStorage#addSerialiserDetails(byte, ToBytesSerialiser, Class)} with
   * {@code key}, {@code serialiser}, {@code aClass}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#addSerialiserDetails(byte,
   * ToBytesSerialiser, Class)}
   */
  @Test
  @DisplayName(
      "Test addSerialiserDetails(byte, ToBytesSerialiser, Class) with 'key', 'serialiser', 'aClass'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testAddSerialiserDetailsWithKeySerialiserAClass_whenNull() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    Class<Object> aClass = Object.class;

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.addSerialiserDetails((byte) 'A', null, aClass));
  }

  /**
   * Test {@link MultiSerialiserStorage#addSerialiserDetails(SerialiserDetail)} with {@code
   * serialiserDetail}.
   *
   * <p>Method under test: {@link MultiSerialiserStorage#addSerialiserDetails(SerialiserDetail)}
   */
  @Test
  @DisplayName("Test addSerialiserDetails(SerialiserDetail) with 'serialiserDetail'")
  @Tag("MaintainedByDiffblue")
  void testAddSerialiserDetailsWithSerialiserDetail() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    // Act
    multiSerialiserStorage.addSerialiserDetails(null);

    // Assert that nothing has changed
    assertTrue(multiSerialiserStorage.getSerialiserDetails().isEmpty());
  }

  /**
   * Test {@link MultiSerialiserStorage#addSerialiserDetails(SerialiserDetail)} with {@code
   * serialiserDetail}.
   *
   * <p>Method under test: {@link MultiSerialiserStorage#addSerialiserDetails(SerialiserDetail)}
   */
  @Test
  @DisplayName("Test addSerialiserDetails(SerialiserDetail) with 'serialiserDetail'")
  @Tag("MaintainedByDiffblue")
  void testAddSerialiserDetailsWithSerialiserDetail2() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    Class<Object> valueClass = Object.class;
    SerialiserDetail serialiserDetail = new SerialiserDetail((byte) 'A', null, valueClass);

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.addSerialiserDetails(serialiserDetail));
  }

  /**
   * Test {@link MultiSerialiserStorage#addSerialiserDetails(SerialiserDetail)} with {@code
   * serialiserDetail}.
   *
   * <p>Method under test: {@link MultiSerialiserStorage#addSerialiserDetails(SerialiserDetail)}
   */
  @Test
  @DisplayName("Test addSerialiserDetails(SerialiserDetail) with 'serialiserDetail'")
  @Tag("MaintainedByDiffblue")
  void testAddSerialiserDetailsWithSerialiserDetail3() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    BooleanSerialiser serialiser = new BooleanSerialiser();
    Class<Object> valueClass = Object.class;

    SerialiserDetail serialiserDetail = new SerialiserDetail((byte) 'A', serialiser, valueClass);

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.addSerialiserDetails(serialiserDetail));
  }

  /**
   * Test {@link MultiSerialiserStorage#addSerialiserDetails(SerialiserDetail)} with {@code
   * serialiserDetail}.
   *
   * <p>Method under test: {@link MultiSerialiserStorage#addSerialiserDetails(SerialiserDetail)}
   */
  @Test
  @DisplayName("Test addSerialiserDetails(SerialiserDetail) with 'serialiserDetail'")
  @Tag("MaintainedByDiffblue")
  void testAddSerialiserDetailsWithSerialiserDetail4() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    MultiSerialiser serialiser = new MultiSerialiser();
    Class<Object> valueClass = Object.class;

    SerialiserDetail serialiserDetail = new SerialiserDetail((byte) 'A', serialiser, valueClass);

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.addSerialiserDetails(serialiserDetail));
  }

  /**
   * Test {@link MultiSerialiserStorage#addSerialiserDetails(SerialiserDetail)} with {@code
   * serialiserDetail}.
   *
   * <p>Method under test: {@link MultiSerialiserStorage#addSerialiserDetails(SerialiserDetail)}
   */
  @Test
  @DisplayName("Test addSerialiserDetails(SerialiserDetail) with 'serialiserDetail'")
  @Tag("MaintainedByDiffblue")
  void testAddSerialiserDetailsWithSerialiserDetail5() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> valueClass = Object.class;

    SerialiserDetail serialiserDetail = new SerialiserDetail((byte) 'A', serialiser, valueClass);

    // Act
    multiSerialiserStorage.addSerialiserDetails(serialiserDetail);

    // Assert
    List<SerialiserDetail> serialiserDetails = multiSerialiserStorage.getSerialiserDetails();
    assertEquals(1, serialiserDetails.size());
    SerialiserDetail getResult = serialiserDetails.get(0);
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, getResult.getSerialiser());
    assertSame(valueClass, getResult.getValueClass());
  }

  /**
   * Test {@link MultiSerialiserStorage#addSerialiserDetails(SerialiserDetail)} with {@code
   * serialiserDetail}.
   *
   * <ul>
   *   <li>When {@link SerialiserDetail#SerialiserDetail()}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#addSerialiserDetails(SerialiserDetail)}
   */
  @Test
  @DisplayName(
      "Test addSerialiserDetails(SerialiserDetail) with 'serialiserDetail'; when SerialiserDetail()")
  @Tag("MaintainedByDiffblue")
  void testAddSerialiserDetailsWithSerialiserDetail_whenSerialiserDetail()
      throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.addSerialiserDetails(new SerialiserDetail()));
  }

  /**
   * Test {@link MultiSerialiserStorage#getSerialiserDetails()}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#getSerialiserDetails()}
   */
  @Test
  @DisplayName("Test getSerialiserDetails(); given 'java.lang.Object'; then return size is one")
  @Tag("MaintainedByDiffblue")
  void testGetSerialiserDetails_givenJavaLangObject_thenReturnSizeIsOne()
      throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> supportedClass = Object.class;

    multiSerialiserStorage.put((byte) 'A', serialiser, supportedClass);

    // Act
    List<SerialiserDetail> actualSerialiserDetails = multiSerialiserStorage.getSerialiserDetails();

    // Assert
    assertEquals(1, actualSerialiserDetails.size());
    SerialiserDetail getResult = actualSerialiserDetails.get(0);
    ToBytesSerialiser serialiser2 = getResult.getSerialiser();
    assertTrue(serialiser2 instanceof NullSerialiser);
    assertTrue(serialiser2.isConsistent());
    Class<Object> expectedValueClass = Object.class;
    assertEquals(expectedValueClass, getResult.getValueClass());
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, serialiser2);
  }

  /**
   * Test {@link MultiSerialiserStorage#getSerialiserDetails()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#getSerialiserDetails()}
   */
  @Test
  @DisplayName("Test getSerialiserDetails(); then return Empty")
  @Tag("MaintainedByDiffblue")
  void testGetSerialiserDetails_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new MultiSerialiserStorage().getSerialiserDetails().isEmpty());
  }

  /**
   * Test {@link MultiSerialiserStorage#getSerialiserDetails()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#getSerialiserDetails()}
   */
  @Test
  @DisplayName("Test getSerialiserDetails(); then return size is two")
  @Tag("MaintainedByDiffblue")
  void testGetSerialiserDetails_thenReturnSizeIsTwo() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> supportedClass = Object.class;

    multiSerialiserStorage.put((byte) 'X', serialiser, supportedClass);
    NullSerialiser serialiser2 = new NullSerialiser();
    Class<Object> supportedClass2 = Object.class;

    multiSerialiserStorage.put((byte) 'A', serialiser2, supportedClass2);

    // Act
    List<SerialiserDetail> actualSerialiserDetails = multiSerialiserStorage.getSerialiserDetails();

    // Assert
    assertEquals(2, actualSerialiserDetails.size());
    assertTrue(actualSerialiserDetails.get(0).getSerialiser() instanceof NullSerialiser);
    SerialiserDetail getResult = actualSerialiserDetails.get(1);
    ToBytesSerialiser serialiser3 = getResult.getSerialiser();
    assertTrue(serialiser3 instanceof NullSerialiser);
    assertTrue(serialiser3.isConsistent());
    assertEquals('X', getResult.getKey());
    assertSame(serialiser, serialiser3);
    assertSame(supportedClass2, getResult.getValueClass());
  }

  /**
   * Test SerialiserDetail getters and setters.
   *
   * <ul>
   *   <li>Then Serialiser return {@link BooleanSerialiser}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SerialiserDetail#SerialiserDetail()}
   *   <li>{@link SerialiserDetail#key(byte)}
   *   <li>{@link SerialiserDetail#serialiser(ToBytesSerialiser)}
   *   <li>{@link SerialiserDetail#valueClass(Class)}
   *   <li>{@link SerialiserDetail#getKey()}
   *   <li>{@link SerialiserDetail#getSerialiser()}
   *   <li>{@link SerialiserDetail#getValueClass()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test SerialiserDetail getters and setters; then Serialiser return BooleanSerialiser")
  @Tag("MaintainedByDiffblue")
  void testSerialiserDetailGettersAndSetters_thenSerialiserReturnBooleanSerialiser() {
    // Arrange and Act
    SerialiserDetail actualSerialiserDetail = new SerialiserDetail();
    SerialiserDetail actualKeyResult = actualSerialiserDetail.key((byte) 'A');
    BooleanSerialiser serialiser = new BooleanSerialiser();
    SerialiserDetail actualSerialiserResult = actualSerialiserDetail.serialiser(serialiser);
    Class<Object> valueClass = Object.class;
    SerialiserDetail actualValueClassResult = actualSerialiserDetail.valueClass(valueClass);
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
   * Test SerialiserDetail getters and setters.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SerialiserDetail#SerialiserDetail(byte, ToBytesSerialiser, Class)}
   *   <li>{@link SerialiserDetail#key(byte)}
   *   <li>{@link SerialiserDetail#serialiser(ToBytesSerialiser)}
   *   <li>{@link SerialiserDetail#valueClass(Class)}
   *   <li>{@link SerialiserDetail#getKey()}
   *   <li>{@link SerialiserDetail#getSerialiser()}
   *   <li>{@link SerialiserDetail#getValueClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test SerialiserDetail getters and setters; when 'A'")
  @Tag("MaintainedByDiffblue")
  void testSerialiserDetailGettersAndSetters_whenA() {
    // Arrange
    BooleanSerialiser serialiser = new BooleanSerialiser();
    Class<Object> valueClass = Object.class;

    // Act
    SerialiserDetail actualSerialiserDetail =
        new SerialiserDetail((byte) 'A', serialiser, valueClass);
    SerialiserDetail actualKeyResult = actualSerialiserDetail.key((byte) 'A');
    BooleanSerialiser serialiser2 = new BooleanSerialiser();
    SerialiserDetail actualSerialiserResult = actualSerialiserDetail.serialiser(serialiser2);
    Class<Object> valueClass2 = Object.class;
    SerialiserDetail actualValueClassResult = actualSerialiserDetail.valueClass(valueClass2);
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
   * Test {@link MultiSerialiserStorage#setSerialiserDetails(List)}.
   *
   * <p>Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  @DisplayName("Test setSerialiserDetails(List)")
  @Tag("MaintainedByDiffblue")
  void testSetSerialiserDetails() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    ArrayList<SerialiserDetail> serialisersDetails = new ArrayList<>();
    Class<Object> valueClass = Object.class;
    SerialiserDetail serialiserDetail = new SerialiserDetail((byte) 'A', null, valueClass);
    serialisersDetails.add(serialiserDetail);

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.setSerialiserDetails(serialisersDetails));
  }

  /**
   * Test {@link MultiSerialiserStorage#setSerialiserDetails(List)}.
   *
   * <p>Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  @DisplayName("Test setSerialiserDetails(List)")
  @Tag("MaintainedByDiffblue")
  void testSetSerialiserDetails2() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    ArrayList<SerialiserDetail> serialisersDetails = new ArrayList<>();
    BooleanSerialiser serialiser = new BooleanSerialiser();
    Class<Object> valueClass = Object.class;

    SerialiserDetail serialiserDetail = new SerialiserDetail((byte) 'A', serialiser, valueClass);
    serialisersDetails.add(serialiserDetail);

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.setSerialiserDetails(serialisersDetails));
  }

  /**
   * Test {@link MultiSerialiserStorage#setSerialiserDetails(List)}.
   *
   * <p>Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  @DisplayName("Test setSerialiserDetails(List)")
  @Tag("MaintainedByDiffblue")
  void testSetSerialiserDetails3() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    ArrayList<SerialiserDetail> serialisersDetails = new ArrayList<>();
    MultiSerialiser serialiser = new MultiSerialiser();
    Class<Object> valueClass = Object.class;

    SerialiserDetail serialiserDetail = new SerialiserDetail((byte) 'A', serialiser, valueClass);
    serialisersDetails.add(serialiserDetail);

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.setSerialiserDetails(serialisersDetails));
  }

  /**
   * Test {@link MultiSerialiserStorage#setSerialiserDetails(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  @DisplayName("Test setSerialiserDetails(List); given 'null'; when ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  void testSetSerialiserDetails_givenNull_whenArrayListAddNull() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    ArrayList<SerialiserDetail> serialisersDetails = new ArrayList<>();
    serialisersDetails.add(null);

    // Act
    multiSerialiserStorage.setSerialiserDetails(serialisersDetails);

    // Assert that nothing has changed
    assertTrue(multiSerialiserStorage.getSerialiserDetails().isEmpty());
  }

  /**
   * Test {@link MultiSerialiserStorage#setSerialiserDetails(List)}.
   *
   * <ul>
   *   <li>Given {@link SerialiserDetail#SerialiserDetail()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link SerialiserDetail#SerialiserDetail()}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  @DisplayName(
      "Test setSerialiserDetails(List); given SerialiserDetail(); when ArrayList() add SerialiserDetail()")
  @Tag("MaintainedByDiffblue")
  void testSetSerialiserDetails_givenSerialiserDetail_whenArrayListAddSerialiserDetail()
      throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    ArrayList<SerialiserDetail> serialisersDetails = new ArrayList<>();
    serialisersDetails.add(new SerialiserDetail());

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> multiSerialiserStorage.setSerialiserDetails(serialisersDetails));
  }

  /**
   * Test {@link MultiSerialiserStorage#setSerialiserDetails(List)}.
   *
   * <ul>
   *   <li>Then {@link MultiSerialiserStorage} (default constructor) SerialiserDetails size is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  @DisplayName(
      "Test setSerialiserDetails(List); then MultiSerialiserStorage (default constructor) SerialiserDetails size is one")
  @Tag("MaintainedByDiffblue")
  void testSetSerialiserDetails_thenMultiSerialiserStorageSerialiserDetailsSizeIsOne()
      throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    ArrayList<SerialiserDetail> serialisersDetails = new ArrayList<>();
    NullSerialiser serialiser = new NullSerialiser();
    Class<Object> valueClass = Object.class;

    SerialiserDetail serialiserDetail = new SerialiserDetail((byte) 'A', serialiser, valueClass);
    serialisersDetails.add(serialiserDetail);

    // Act
    multiSerialiserStorage.setSerialiserDetails(serialisersDetails);

    // Assert
    List<SerialiserDetail> serialiserDetails = multiSerialiserStorage.getSerialiserDetails();
    assertEquals(1, serialiserDetails.size());
    SerialiserDetail getResult = serialiserDetails.get(0);
    assertEquals('A', getResult.getKey());
    assertSame(serialiser, getResult.getSerialiser());
    assertSame(valueClass, getResult.getValueClass());
  }

  /**
   * Test {@link MultiSerialiserStorage#setSerialiserDetails(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  @DisplayName("Test setSerialiserDetails(List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testSetSerialiserDetails_whenArrayList() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    // Act
    multiSerialiserStorage.setSerialiserDetails(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(multiSerialiserStorage.getSerialiserDetails().isEmpty());
  }

  /**
   * Test {@link MultiSerialiserStorage#setSerialiserDetails(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#setSerialiserDetails(List)}
   */
  @Test
  @DisplayName("Test setSerialiserDetails(List); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testSetSerialiserDetails_whenNull() throws GafferCheckedException {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    // Act
    multiSerialiserStorage.setSerialiserDetails(null);

    // Assert that nothing has changed
    assertTrue(multiSerialiserStorage.getSerialiserDetails().isEmpty());
  }

  /**
   * Test {@link MultiSerialiserStorage#equals(Object)}, and {@link
   * MultiSerialiserStorage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MultiSerialiserStorage#equals(Object)}
   *   <li>{@link MultiSerialiserStorage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();
    MultiSerialiserStorage multiSerialiserStorage2 = new MultiSerialiserStorage();

    // Act and Assert
    assertEquals(multiSerialiserStorage, multiSerialiserStorage2);
    assertEquals(multiSerialiserStorage.hashCode(), multiSerialiserStorage2.hashCode());
  }

  /**
   * Test {@link MultiSerialiserStorage#equals(Object)}, and {@link
   * MultiSerialiserStorage#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MultiSerialiserStorage#equals(Object)}
   *   <li>{@link MultiSerialiserStorage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MultiSerialiserStorage multiSerialiserStorage = new MultiSerialiserStorage();

    // Act and Assert
    assertEquals(multiSerialiserStorage, multiSerialiserStorage);
    int expectedHashCodeResult = multiSerialiserStorage.hashCode();
    assertEquals(expectedHashCodeResult, multiSerialiserStorage.hashCode());
  }

  /**
   * Test {@link MultiSerialiserStorage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MultiSerialiserStorage(), null);
  }

  /**
   * Test {@link MultiSerialiserStorage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MultiSerialiserStorage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MultiSerialiserStorage(), "Different type to MultiSerialiserStorage");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MultiSerialiserStorage}
   *   <li>{@link MultiSerialiserStorage#isConsistent()}
   *   <li>{@link MultiSerialiserStorage#preservesObjectOrdering()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    MultiSerialiserStorage actualMultiSerialiserStorage = new MultiSerialiserStorage();
    boolean actualIsConsistentResult = actualMultiSerialiserStorage.isConsistent();

    // Assert
    assertTrue(actualIsConsistentResult);
    assertTrue(actualMultiSerialiserStorage.preservesObjectOrdering());
  }
}
