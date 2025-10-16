package uk.gov.gchq.gaffer.commonutil.elementvisibilityutil;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AuthorisationsDiffblueTest {
  /**
   * Test {@link Authorisations#Authorisations()}.
   *
   * <p>Method under test: {@link Authorisations#Authorisations()}
   */
  @Test
  @DisplayName("Test new Authorisations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Authorisations.<init>()"})
  void testNewAuthorisations() throws UnsupportedEncodingException {
    // Arrange and Act
    Authorisations actualAuthorisations = new Authorisations();

    // Assert
    assertEquals(0, actualAuthorisations.size());
    assertFalse(actualAuthorisations.iterator().hasNext());
    assertTrue(actualAuthorisations.getAuthorisations().isEmpty());
    assertTrue(actualAuthorisations.getAuthorisationsBB().isEmpty());
    assertTrue(actualAuthorisations.isEmpty());
    assertArrayEquals("!AUTH1:".getBytes("UTF-8"), actualAuthorisations.getAuthorisationsArray());
  }

  /**
   * Test {@link Authorisations#Authorisations(String[])}.
   *
   * <ul>
   *   <li>Then return Authorisations size is two.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#Authorisations(String[])}
   */
  @Test
  @DisplayName("Test new Authorisations(String[]); then return Authorisations size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Authorisations.<init>(String[])"})
  void testNewAuthorisations_thenReturnAuthorisationsSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Authorisations actualAuthorisations = new Authorisations("JaneDoe", "authorisations is null");

    // Assert
    List<byte[]> authorisations = actualAuthorisations.getAuthorisations();
    assertEquals(2, authorisations.size());
    byte[] actualGetResult = authorisations.get(0);
    assertArrayEquals("JaneDoe".getBytes("UTF-8"), actualGetResult);
    assertArrayEquals("authorisations is null".getBytes("UTF-8"), authorisations.get(1));
    assertArrayEquals(
        "!AUTH1:SmFuZURvZQ==,YXV0aG9yaXNhdGlvbnMgaXMgbnVsbA==".getBytes("UTF-8"),
        actualAuthorisations.getAuthorisationsArray());
    List<ByteBuffer> authorisationsBB = actualAuthorisations.getAuthorisationsBB();
    assertEquals(2, authorisationsBB.size());
    ByteBuffer getResult = authorisationsBB.get(0);
    ByteBuffer getResult2 = authorisationsBB.get(1);
    assertArrayEquals("JaneDoe".getBytes("UTF-8"), getResult.array());
    assertArrayEquals("authorisations is null".getBytes("UTF-8"), getResult2.array());
    Iterator<byte[]> iteratorResult = actualAuthorisations.iterator();
    byte[] actualNextResult = iteratorResult.next();
    byte[] actualNextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals("JaneDoe".getBytes("UTF-8"), actualNextResult);
    assertArrayEquals("authorisations is null".getBytes("UTF-8"), actualNextResult2);
  }

  /**
   * Test {@link Authorisations#Authorisations(String[])}.
   *
   * <ul>
   *   <li>Then return Authorisations size is two.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#Authorisations(String[])}
   */
  @Test
  @DisplayName("Test new Authorisations(String[]); then return Authorisations size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Authorisations.<init>(String[])"})
  void testNewAuthorisations_thenReturnAuthorisationsSizeIsTwo2()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Authorisations actualAuthorisations =
        new Authorisations("JaneDoe", "authorisations is null", "JaneDoe");

    // Assert
    List<byte[]> authorisations = actualAuthorisations.getAuthorisations();
    assertEquals(2, authorisations.size());
    byte[] actualGetResult = authorisations.get(0);
    assertArrayEquals("JaneDoe".getBytes("UTF-8"), actualGetResult);
    assertArrayEquals("authorisations is null".getBytes("UTF-8"), authorisations.get(1));
    assertArrayEquals(
        "!AUTH1:SmFuZURvZQ==,YXV0aG9yaXNhdGlvbnMgaXMgbnVsbA==".getBytes("UTF-8"),
        actualAuthorisations.getAuthorisationsArray());
    List<ByteBuffer> authorisationsBB = actualAuthorisations.getAuthorisationsBB();
    assertEquals(2, authorisationsBB.size());
    ByteBuffer getResult = authorisationsBB.get(0);
    ByteBuffer getResult2 = authorisationsBB.get(1);
    assertArrayEquals("JaneDoe".getBytes("UTF-8"), getResult.array());
    assertArrayEquals("authorisations is null".getBytes("UTF-8"), getResult2.array());
    Iterator<byte[]> iteratorResult = actualAuthorisations.iterator();
    byte[] actualNextResult = iteratorResult.next();
    byte[] actualNextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals("JaneDoe".getBytes("UTF-8"), actualNextResult);
    assertArrayEquals("authorisations is null".getBytes("UTF-8"), actualNextResult2);
  }

  /**
   * Test {@link Authorisations#Authorisations(String[])}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#Authorisations(String[])}
   */
  @Test
  @DisplayName("Test new Authorisations(String[]); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Authorisations.<init>(String[])"})
  void testNewAuthorisations_thenReturnSizeIsZero() throws UnsupportedEncodingException {
    // Arrange and Act
    Authorisations actualAuthorisations = new Authorisations(new String[] {});

    // Assert
    assertEquals(0, actualAuthorisations.size());
    assertFalse(actualAuthorisations.iterator().hasNext());
    assertTrue(actualAuthorisations.getAuthorisations().isEmpty());
    assertTrue(actualAuthorisations.getAuthorisationsBB().isEmpty());
    assertTrue(actualAuthorisations.isEmpty());
    assertArrayEquals("!AUTH1:".getBytes("UTF-8"), actualAuthorisations.getAuthorisationsArray());
  }

  /**
   * Test {@link Authorisations#Authorisations(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Authorisations size is one.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#Authorisations(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Authorisations(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return Authorisations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Authorisations.<init>(byte[])"})
  void testNewAuthorisations_whenAxaxaxaxBytesIsUtf8_thenReturnAuthorisationsSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Authorisations actualAuthorisations = new Authorisations("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    List<byte[]> authorisations = actualAuthorisations.getAuthorisations();
    assertEquals(1, authorisations.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), authorisations.get(0));
    assertArrayEquals(
        "!AUTH1:QVhBWEFYQVg=".getBytes("UTF-8"), actualAuthorisations.getAuthorisationsArray());
    List<ByteBuffer> authorisationsBB = actualAuthorisations.getAuthorisationsBB();
    assertEquals(1, authorisationsBB.size());
    ByteBuffer getResult = authorisationsBB.get(0);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), getResult.array());
    assertEquals(8, getResult.capacity());
    assertTrue(getResult.hasArray());
    assertTrue(getResult.hasRemaining());
    assertEquals(8, getResult.limit());
    assertEquals(0, getResult.position());
    assertFalse(actualAuthorisations.isEmpty());
    Iterator<byte[]> iteratorResult = actualAuthorisations.iterator();
    byte[] actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNextResult);
    assertEquals(1, actualAuthorisations.size());
  }

  /**
   * Test {@link Authorisations#Authorisations(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#Authorisations(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Authorisations(byte[]); when empty array of byte; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Authorisations.<init>(byte[])"})
  void testNewAuthorisations_whenEmptyArrayOfByte_thenReturnSizeIsZero()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Authorisations actualAuthorisations = new Authorisations(new byte[] {});

    // Assert
    assertEquals(0, actualAuthorisations.size());
    assertFalse(actualAuthorisations.iterator().hasNext());
    assertTrue(actualAuthorisations.getAuthorisations().isEmpty());
    assertTrue(actualAuthorisations.getAuthorisationsBB().isEmpty());
    assertTrue(actualAuthorisations.isEmpty());
    assertArrayEquals("!AUTH1:".getBytes("UTF-8"), actualAuthorisations.getAuthorisationsArray());
  }

  /**
   * Test {@link Authorisations#Authorisations(String[])}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#Authorisations(String[])}
   */
  @Test
  @DisplayName(
      "Test new Authorisations(String[]); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Authorisations.<init>(String[])"})
  void testNewAuthorisations_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Authorisations(""));
  }

  /**
   * Test {@link Authorisations#Authorisations(String[])}.
   *
   * <ul>
   *   <li>When {@code JaneDoe}.
   *   <li>Then return Authorisations size is one.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#Authorisations(String[])}
   */
  @Test
  @DisplayName(
      "Test new Authorisations(String[]); when 'JaneDoe'; then return Authorisations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Authorisations.<init>(String[])"})
  void testNewAuthorisations_whenJaneDoe_thenReturnAuthorisationsSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Authorisations actualAuthorisations = new Authorisations("JaneDoe");

    // Assert
    List<byte[]> authorisations = actualAuthorisations.getAuthorisations();
    assertEquals(1, authorisations.size());
    assertArrayEquals("JaneDoe".getBytes("UTF-8"), authorisations.get(0));
    assertArrayEquals(
        "!AUTH1:SmFuZURvZQ==".getBytes("UTF-8"), actualAuthorisations.getAuthorisationsArray());
    List<ByteBuffer> authorisationsBB = actualAuthorisations.getAuthorisationsBB();
    assertEquals(1, authorisationsBB.size());
    assertArrayEquals("JaneDoe".getBytes("UTF-8"), authorisationsBB.get(0).array());
    Iterator<byte[]> iteratorResult = actualAuthorisations.iterator();
    byte[] actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertArrayEquals("JaneDoe".getBytes("UTF-8"), actualNextResult);
    assertEquals(1, actualAuthorisations.size());
  }

  /**
   * Test {@link Authorisations#getAuthorisations()}.
   *
   * <ul>
   *   <li>Given {@link Authorisations#Authorisations()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#getAuthorisations()}
   */
  @Test
  @DisplayName("Test getAuthorisations(); given Authorisations(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Authorisations.getAuthorisations()"})
  void testGetAuthorisations_givenAuthorisations_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new Authorisations().getAuthorisations().isEmpty());
  }

  /**
   * Test {@link Authorisations#getAuthorisations()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#getAuthorisations()}
   */
  @Test
  @DisplayName("Test getAuthorisations(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Authorisations.getAuthorisations()"})
  void testGetAuthorisations_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange and Act
    List<byte[]> actualAuthorisations =
        new Authorisations("AXAXAXAX".getBytes("UTF-8")).getAuthorisations();

    // Assert
    assertEquals(1, actualAuthorisations.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualAuthorisations.get(0));
  }

  /**
   * Test {@link Authorisations#getAuthorisationsArray()}.
   *
   * <ul>
   *   <li>Given {@link Authorisations#Authorisations()}.
   *   <li>Then return {@code !AUTH1:} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#getAuthorisationsArray()}
   */
  @Test
  @DisplayName(
      "Test getAuthorisationsArray(); given Authorisations(); then return '!AUTH1:' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Authorisations.getAuthorisationsArray()"})
  void testGetAuthorisationsArray_givenAuthorisations_thenReturnAuth1BytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals("!AUTH1:".getBytes("UTF-8"), new Authorisations().getAuthorisationsArray());
  }

  /**
   * Test {@link Authorisations#getAuthorisationsArray()}.
   *
   * <ul>
   *   <li>Then return {@code !AUTH1:QVhBWEFYQVg=} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#getAuthorisationsArray()}
   */
  @Test
  @DisplayName("Test getAuthorisationsArray(); then return '!AUTH1:QVhBWEFYQVg=' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Authorisations.getAuthorisationsArray()"})
  void testGetAuthorisationsArray_thenReturnAuth1QVhBWEFYQVgBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "!AUTH1:QVhBWEFYQVg=".getBytes("UTF-8"),
        new Authorisations("AXAXAXAX".getBytes("UTF-8")).getAuthorisationsArray());
  }

  /**
   * Test {@link Authorisations#getAuthorisationsBB()}.
   *
   * <ul>
   *   <li>Given {@link Authorisations#Authorisations()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#getAuthorisationsBB()}
   */
  @Test
  @DisplayName("Test getAuthorisationsBB(); given Authorisations(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Authorisations.getAuthorisationsBB()"})
  void testGetAuthorisationsBB_givenAuthorisations_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new Authorisations().getAuthorisationsBB().isEmpty());
  }

  /**
   * Test {@link Authorisations#getAuthorisationsBB()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#getAuthorisationsBB()}
   */
  @Test
  @DisplayName("Test getAuthorisationsBB(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Authorisations.getAuthorisationsBB()"})
  void testGetAuthorisationsBB_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange and Act
    List<ByteBuffer> actualAuthorisationsBB =
        new Authorisations("AXAXAXAX".getBytes("UTF-8")).getAuthorisationsBB();

    // Assert
    assertEquals(1, actualAuthorisationsBB.size());
    ByteBuffer getResult = actualAuthorisationsBB.get(0);
    assertEquals(0, getResult.position());
    assertEquals(8, getResult.capacity());
    assertEquals(8, getResult.limit());
    assertTrue(getResult.hasRemaining());
    assertTrue(getResult.hasArray());
    byte[] expectedArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedArrayResult, getResult.array());
  }

  /**
   * Test {@link Authorisations#serialise()}.
   *
   * <ul>
   *   <li>Given {@link Authorisations#Authorisations()}.
   *   <li>Then return {@link Authorisations#HEADER}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#serialise()}
   */
  @Test
  @DisplayName("Test serialise(); given Authorisations(); then return HEADER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Authorisations.serialise()"})
  void testSerialise_givenAuthorisations_thenReturnHeader() {
    // Arrange, Act and Assert
    assertEquals(Authorisations.HEADER, new Authorisations().serialise());
  }

  /**
   * Test {@link Authorisations#serialise()}.
   *
   * <ul>
   *   <li>Then return {@code !AUTH1:QVhBWEFYQVg=}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#serialise()}
   */
  @Test
  @DisplayName("Test serialise(); then return '!AUTH1:QVhBWEFYQVg='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Authorisations.serialise()"})
  void testSerialise_thenReturnAuth1QVhBWEFYQVg() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "!AUTH1:QVhBWEFYQVg=", new Authorisations("AXAXAXAX".getBytes("UTF-8")).serialise());
  }

  /**
   * Test {@link Authorisations#toString()}.
   *
   * <ul>
   *   <li>Given {@link Authorisations#Authorisations()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#toString()}
   */
  @Test
  @DisplayName("Test toString(); given Authorisations(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Authorisations.toString()"})
  void testToString_givenAuthorisations_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new Authorisations().toString());
  }

  /**
   * Test {@link Authorisations#toString()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'AXAXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Authorisations.toString()"})
  void testToString_thenReturnAxaxaxax() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX", new Authorisations("AXAXAXAX".getBytes("UTF-8")).toString());
  }

  /**
   * Test {@link Authorisations#contains(ArrayByteSequence)} with {@code ArrayByteSequence}.
   *
   * <ul>
   *   <li>When {@link ArrayByteSequence#ArrayByteSequence(String)} with s is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#contains(ArrayByteSequence)}
   */
  @Test
  @DisplayName(
      "Test contains(ArrayByteSequence) with 'ArrayByteSequence'; when ArrayByteSequence(String) with s is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Authorisations.contains(ArrayByteSequence)"})
  void testContainsWithArrayByteSequence_whenArrayByteSequenceWithSIsFoo() {
    // Arrange
    Authorisations authorisations = new Authorisations();

    // Act
    boolean actualContainsResult = authorisations.contains(new ArrayByteSequence("foo"));

    // Assert
    assertFalse(actualContainsResult);
  }

  /**
   * Test {@link Authorisations#contains(ArrayByteSequence)} with {@code ArrayByteSequence}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#contains(ArrayByteSequence)}
   */
  @Test
  @DisplayName("Test contains(ArrayByteSequence) with 'ArrayByteSequence'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Authorisations.contains(ArrayByteSequence)"})
  void testContainsWithArrayByteSequence_whenNull() {
    // Arrange, Act and Assert
    assertFalse(new Authorisations().contains((ArrayByteSequence) null));
  }

  /**
   * Test {@link Authorisations#contains(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link Authorisations#contains(byte[])}
   */
  @Test
  @DisplayName("Test contains(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Authorisations.contains(byte[])"})
  void testContainsWithByte() throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualContainsResult = new Authorisations().contains("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualContainsResult);
  }

  /**
   * Test {@link Authorisations#contains(String)} with {@code String}.
   *
   * <p>Method under test: {@link Authorisations#contains(String)}
   */
  @Test
  @DisplayName("Test contains(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Authorisations.contains(String)"})
  void testContainsWithString() {
    // Arrange, Act and Assert
    assertFalse(new Authorisations().contains("Auth"));
  }

  /**
   * Test {@link Authorisations#equals(Object)}, and {@link Authorisations#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Authorisations#equals(Object)}
   *   <li>{@link Authorisations#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Authorisations.equals(Object)", "int Authorisations.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Authorisations authorisations = new Authorisations();
    Authorisations authorisations2 = new Authorisations();

    // Act and Assert
    assertEquals(authorisations, authorisations2);
    assertEquals(authorisations.hashCode(), authorisations2.hashCode());
  }

  /**
   * Test {@link Authorisations#equals(Object)}, and {@link Authorisations#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Authorisations#equals(Object)}
   *   <li>{@link Authorisations#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Authorisations.equals(Object)", "int Authorisations.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Authorisations authorisations = new Authorisations();

    // Act and Assert
    assertEquals(authorisations, authorisations);
    int expectedHashCodeResult = authorisations.hashCode();
    assertEquals(expectedHashCodeResult, authorisations.hashCode());
  }

  /**
   * Test {@link Authorisations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Authorisations.equals(Object)", "int Authorisations.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Authorisations authorisations = new Authorisations(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(authorisations, new Authorisations());
  }

  /**
   * Test {@link Authorisations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Authorisations.equals(Object)", "int Authorisations.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Authorisations(), null);
  }

  /**
   * Test {@link Authorisations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Authorisations.equals(Object)", "int Authorisations.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Authorisations(), "Different type to Authorisations");
  }

  /**
   * Test {@link Authorisations#size()}.
   *
   * <p>Method under test: {@link Authorisations#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Authorisations.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new Authorisations().size());
  }

  /**
   * Test {@link Authorisations#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given 'A'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Authorisations.isEmpty()"})
  void testIsEmpty_givenA_thenReturnFalse() {
    // Arrange
    Authorisations authorisations = new Authorisations(new byte[] {'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act and Assert
    assertFalse(authorisations.isEmpty());
  }

  /**
   * Test {@link Authorisations#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link Authorisations#Authorisations()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given Authorisations(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Authorisations.isEmpty()"})
  void testIsEmpty_givenAuthorisations_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Authorisations().isEmpty());
  }

  /**
   * Test {@link Authorisations#iterator()}.
   *
   * <ul>
   *   <li>Given {@link Authorisations#Authorisations()}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given Authorisations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator Authorisations.iterator()"})
  void testIterator_givenAuthorisations() {
    // Arrange, Act and Assert
    assertFalse(new Authorisations().iterator().hasNext());
  }

  /**
   * Test {@link Authorisations#iterator()}.
   *
   * <ul>
   *   <li>Then return next is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); then return next is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator Authorisations.iterator()"})
  void testIterator_thenReturnNextIsAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    Iterator<byte[]> actualIteratorResult =
        new Authorisations("AXAXAXAX".getBytes("UTF-8")).iterator();

    // Assert
    byte[] actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNextResult);
  }

  /**
   * Test {@link Authorisations#isValidAuthChar(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#isValidAuthChar(byte)}
   */
  @Test
  @DisplayName("Test isValidAuthChar(byte); when 'A'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Authorisations.isValidAuthChar(byte)"})
  void testIsValidAuthChar_whenA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Authorisations.isValidAuthChar((byte) 'A'));
  }

  /**
   * Test {@link Authorisations#isValidAuthChar(byte)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Authorisations#isValidAuthChar(byte)}
   */
  @Test
  @DisplayName("Test isValidAuthChar(byte); when minus one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Authorisations.isValidAuthChar(byte)"})
  void testIsValidAuthChar_whenMinusOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Authorisations.isValidAuthChar((byte) -1));
  }
}
