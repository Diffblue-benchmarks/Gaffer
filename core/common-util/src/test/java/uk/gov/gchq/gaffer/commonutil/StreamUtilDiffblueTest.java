package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StreamUtilDiffblueTest {
  /**
   * Test {@link StreamUtil#graphConfig(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#graphConfig(Class)}
   */
  @Test
  @DisplayName(
      "Test graphConfig(Class); when 'java.lang.Object'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testGraphConfig_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.graphConfig(clazz));
  }

  /**
   * Test {@link StreamUtil#view(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#view(Class)}
   */
  @Test
  @DisplayName("Test view(Class); when 'java.lang.Object'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testView_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.view(clazz));
  }

  /**
   * Test {@link StreamUtil#schemas(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#schemas(Class)}
   */
  @Test
  @DisplayName("Test schemas(Class); when 'java.lang.Object'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testSchemas_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.schemas(clazz));
  }

  /**
   * Test {@link StreamUtil#schema(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#schema(Class)}
   */
  @Test
  @DisplayName("Test schema(Class); when 'java.lang.Object'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testSchema_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.schema(clazz));
  }

  /**
   * Test {@link StreamUtil#elementsSchema(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#elementsSchema(Class)}
   */
  @Test
  @DisplayName(
      "Test elementsSchema(Class); when 'java.lang.Object'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testElementsSchema_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.elementsSchema(clazz));
  }

  /**
   * Test {@link StreamUtil#typesSchema(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#typesSchema(Class)}
   */
  @Test
  @DisplayName(
      "Test typesSchema(Class); when 'java.lang.Object'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testTypesSchema_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.typesSchema(clazz));
  }

  /**
   * Test {@link StreamUtil#storeProps(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#storeProps(Class)}
   */
  @Test
  @DisplayName(
      "Test storeProps(Class); when 'java.lang.Object'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testStoreProps_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.storeProps(clazz));
  }

  /**
   * Test {@link StreamUtil#openStreams(Class, String)} with {@code clazz}, {@code folderPath}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#openStreams(Class, String)}
   */
  @Test
  @DisplayName(
      "Test openStreams(Class, String) with 'clazz', 'folderPath'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testOpenStreamsWithClazzFolderPath_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> StreamUtil.openStreams(clazz, "Folder Path"));
  }

  /**
   * Test {@link StreamUtil#openStreams(Class, String)} with {@code clazz}, {@code folderPath}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#openStreams(Class, String)}
   */
  @Test
  @DisplayName(
      "Test openStreams(Class, String) with 'clazz', 'folderPath'; when 'null'; then return array length is zero")
  @Tag("MaintainedByDiffblue")
  void testOpenStreamsWithClazzFolderPath_whenNull_thenReturnArrayLengthIsZero() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(0, StreamUtil.openStreams(clazz, null).length);
  }

  /**
   * Test {@link StreamUtil#openStreams(Class, String)} with {@code clazz}, {@code folderPath}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#openStreams(Class, String)}
   */
  @Test
  @DisplayName(
      "Test openStreams(Class, String) with 'clazz', 'folderPath'; when '/'; then return array length is one")
  @Tag("MaintainedByDiffblue")
  void testOpenStreamsWithClazzFolderPath_whenSlash_thenReturnArrayLengthIsOne()
      throws IOException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    InputStream[] actualOpenStreamsResult = StreamUtil.openStreams(clazz, "/");

    // Assert
    assertEquals(1, actualOpenStreamsResult.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, actualOpenStreamsResult[0].read(byteArray));
    assertArrayEquals(
        "Manifest-Version: 1.0\r\nAnt-Version: Apache Ant 1.9.".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StreamUtil#openStreams(URI[])} with {@code uris}.
   *
   * <ul>
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#openStreams(URI[])}
   */
  @Test
  @DisplayName("Test openStreams(URI[]) with 'uris'; then return array length is one")
  @Tag("MaintainedByDiffblue")
  void testOpenStreamsWithUris_thenReturnArrayLengthIsOne() throws IOException {
    // Arrange and Act
    InputStream[] actualOpenStreamsResult =
        StreamUtil.openStreams(Paths.get(System.getProperty("java.io.tmpdir")).toUri());

    // Assert
    assertEquals(1, actualOpenStreamsResult.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, actualOpenStreamsResult[0].read(byteArray));
    assertArrayEquals(
        "1758277170342-0\n1758277208448-0\n1758277955223-0\n175".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StreamUtil#openStreams(URI[])} with {@code uris}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#openStreams(URI[])}
   */
  @Test
  @DisplayName("Test openStreams(URI[]) with 'uris'; then return array length is zero")
  @Tag("MaintainedByDiffblue")
  void testOpenStreamsWithUris_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act and Assert
    assertEquals(0, StreamUtil.openStreams().length);
  }

  /**
   * Test {@link StreamUtil#openStream(Class, String)} with {@code clazz}, {@code path}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#openStream(Class, String)}
   */
  @Test
  @DisplayName(
      "Test openStream(Class, String) with 'clazz', 'path'; when empty string; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testOpenStreamWithClazzPath_whenEmptyString_thenThrowIllegalArgumentException()
      throws IllegalArgumentException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.openStream(clazz, ""));
  }

  /**
   * Test {@link StreamUtil#openStream(Class, String)} with {@code clazz}, {@code path}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#openStream(Class, String)}
   */
  @Test
  @DisplayName(
      "Test openStream(Class, String) with 'clazz', 'path'; when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testOpenStreamWithClazzPath_whenNull_thenThrowIllegalArgumentException()
      throws IllegalArgumentException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.openStream(clazz, null));
  }

  /**
   * Test {@link StreamUtil#openStream(Class, String)} with {@code clazz}, {@code path}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#openStream(Class, String)}
   */
  @Test
  @DisplayName(
      "Test openStream(Class, String) with 'clazz', 'path'; when 'Path'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testOpenStreamWithClazzPath_whenPath_thenThrowIllegalArgumentException()
      throws IllegalArgumentException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.openStream(clazz, "Path"));
  }

  /**
   * Test {@link StreamUtil#openStream(Class, String)} with {@code clazz}, {@code path}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#openStream(Class, String)}
   */
  @Test
  @DisplayName(
      "Test openStream(Class, String) with 'clazz', 'path'; when '/'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testOpenStreamWithClazzPath_whenSlash_thenThrowIllegalArgumentException()
      throws IllegalArgumentException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.openStream(clazz, "/"));
  }

  /**
   * Test {@link StreamUtil#openStream(URI)} with {@code uri}.
   *
   * <ul>
   *   <li>Then return read is fifty-one.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#openStream(URI)}
   */
  @Test
  @DisplayName("Test openStream(URI) with 'uri'; then return read is fifty-one")
  @Tag("MaintainedByDiffblue")
  void testOpenStreamWithUri_thenReturnReadIsFiftyOne() throws IOException {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[51];
    assertEquals(
        51,
        StreamUtil.openStream(Paths.get(System.getProperty("java.io.tmpdir"), "").toUri())
            .read(byteArray));
    assertArrayEquals(
        "1758277170342-0\n1758277208448-0\n1758277955223-0\n175".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link StreamUtil#closeStreams(InputStream[])}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link DataInputStream#close()}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#closeStreams(InputStream[])}
   */
  @Test
  @DisplayName(
      "Test closeStreams(InputStream[]); given IllegalArgumentException(); then calls close()")
  @Tag("MaintainedByDiffblue")
  void testCloseStreams_givenIllegalArgumentException_thenCallsClose() throws IOException {
    // Arrange
    DataInputStream dataInputStream = mock(DataInputStream.class);
    doThrow(new IllegalArgumentException()).when(dataInputStream).close();

    // Act
    int actualCloseStreamsResult = StreamUtil.closeStreams(dataInputStream);

    // Assert
    verify(dataInputStream).close();
    assertEquals(1, actualCloseStreamsResult);
  }

  /**
   * Test {@link StreamUtil#closeStreams(InputStream[])}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#closeStreams(InputStream[])}
   */
  @Test
  @DisplayName(
      "Test closeStreams(InputStream[]); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  void testCloseStreams_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        1, StreamUtil.closeStreams(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link StreamUtil#formatPathForOpenStream(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#formatPathForOpenStream(String)}
   */
  @Test
  @DisplayName(
      "Test formatPathForOpenStream(String); when empty string; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testFormatPathForOpenStream_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.formatPathForOpenStream(""));
  }

  /**
   * Test {@link StreamUtil#formatPathForOpenStream(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#formatPathForOpenStream(String)}
   */
  @Test
  @DisplayName(
      "Test formatPathForOpenStream(String); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testFormatPathForOpenStream_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.formatPathForOpenStream(null));
  }

  /**
   * Test {@link StreamUtil#formatPathForOpenStream(String)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then return {@code /Path}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#formatPathForOpenStream(String)}
   */
  @Test
  @DisplayName("Test formatPathForOpenStream(String); when 'Path'; then return '/Path'")
  @Tag("MaintainedByDiffblue")
  void testFormatPathForOpenStream_whenPath_thenReturnPath() {
    // Arrange, Act and Assert
    assertEquals("/Path", StreamUtil.formatPathForOpenStream("Path"));
  }

  /**
   * Test {@link StreamUtil#formatPathForOpenStream(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link StreamUtil#formatPathForOpenStream(String)}
   */
  @Test
  @DisplayName("Test formatPathForOpenStream(String); when '/'; then return '/'")
  @Tag("MaintainedByDiffblue")
  void testFormatPathForOpenStream_whenSlash_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", StreamUtil.formatPathForOpenStream("/"));
  }
}
