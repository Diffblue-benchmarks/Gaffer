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

package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
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
import org.junit.jupiter.api.Test;

class StreamUtilDiffblueTest {
  /**
   * Method under test: {@link StreamUtil#graphConfig(Class)}
   */
  @Test
  void testGraphConfig() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.graphConfig(clazz));
  }

  /**
   * Method under test: {@link StreamUtil#view(Class)}
   */
  @Test
  void testView() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.view(clazz));
  }

  /**
   * Method under test: {@link StreamUtil#schemas(Class)}
   */
  @Test
  void testSchemas() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.schemas(clazz));
  }

  /**
   * Method under test: {@link StreamUtil#schema(Class)}
   */
  @Test
  void testSchema() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.schema(clazz));
  }

  /**
   * Method under test: {@link StreamUtil#elementsSchema(Class)}
   */
  @Test
  void testElementsSchema() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.elementsSchema(clazz));
  }

  /**
   * Method under test: {@link StreamUtil#typesSchema(Class)}
   */
  @Test
  void testTypesSchema() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.typesSchema(clazz));
  }

  /**
   * Method under test: {@link StreamUtil#storeProps(Class)}
   */
  @Test
  void testStoreProps() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.storeProps(clazz));
  }

  /**
   * Method under test: {@link StreamUtil#openStreams(Class, String)}
   */
  @Test
  void testOpenStreams() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.openStreams(clazz, "Folder Path"));
  }

  /**
   * Method under test: {@link StreamUtil#openStreams(Class, String)}
   */
  @Test
  void testOpenStreams2() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(0, StreamUtil.openStreams(clazz, null).length);
  }

  /**
   * Method under test: {@link StreamUtil#openStreams(Class, String)}
   */
  @Test
  void testOpenStreams3() throws IOException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    InputStream[] actualOpenStreamsResult = StreamUtil.openStreams(clazz, "/");

    // Assert
    assertEquals(1, actualOpenStreamsResult.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, (actualOpenStreamsResult[0]).read(byteArray));
    assertArrayEquals("Manifest-Version: 1.0\r\nAnt-Version: Apache Ant 1.9.".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link StreamUtil#openStreams(URI[])}
   */
  @Test
  void testOpenStreams4() throws IOException {
    // Arrange and Act
    InputStream[] actualOpenStreamsResult = StreamUtil
        .openStreams(Paths.get(System.getProperty("java.io.tmpdir")).toUri());

    // Assert
    assertEquals(1, actualOpenStreamsResult.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, (actualOpenStreamsResult[0]).read(byteArray));
    assertArrayEquals("1762944841241-0\n1762944874644-0\n1762945580536-0\n176".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link StreamUtil#openStream(Class, String)}
   */
  @Test
  void testOpenStream() throws IllegalArgumentException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.openStream(clazz, "Path"));
  }

  /**
   * Method under test: {@link StreamUtil#openStream(Class, String)}
   */
  @Test
  void testOpenStream2() throws IllegalArgumentException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.openStream(clazz, null));
  }

  /**
   * Method under test: {@link StreamUtil#openStream(Class, String)}
   */
  @Test
  void testOpenStream3() throws IllegalArgumentException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.openStream(clazz, "/"));
  }

  /**
   * Method under test: {@link StreamUtil#openStream(Class, String)}
   */
  @Test
  void testOpenStream4() throws IllegalArgumentException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.openStream(clazz, ""));
  }

  /**
   * Method under test: {@link StreamUtil#openStream(URI)}
   */
  @Test
  void testOpenStream5() throws IOException {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[51];
    assertEquals(51,
        StreamUtil.openStream(Paths.get(System.getProperty("java.io.tmpdir"), "").toUri()).read(byteArray));
    assertArrayEquals("1762944841241-0\n1762944874644-0\n1762945580536-0\n176".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link StreamUtil#closeStreams(InputStream[])}
   */
  @Test
  void testCloseStreams() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1, StreamUtil.closeStreams(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test: {@link StreamUtil#closeStreams(InputStream[])}
   */
  @Test
  void testCloseStreams2() throws IOException {
    // Arrange
    DataInputStream dataInputStream = mock(DataInputStream.class);
    doNothing().when(dataInputStream).close();

    // Act
    int actualCloseStreamsResult = StreamUtil.closeStreams(dataInputStream);

    // Assert
    verify(dataInputStream).close();
    assertEquals(1, actualCloseStreamsResult);
  }

  /**
   * Method under test: {@link StreamUtil#closeStreams(InputStream[])}
   */
  @Test
  void testCloseStreams3() throws IOException {
    // Arrange
    DataInputStream dataInputStream = mock(DataInputStream.class);
    doThrow(new IllegalArgumentException("foo")).when(dataInputStream).close();

    // Act
    int actualCloseStreamsResult = StreamUtil.closeStreams(dataInputStream);

    // Assert
    verify(dataInputStream).close();
    assertEquals(1, actualCloseStreamsResult);
  }

  /**
   * Method under test: {@link StreamUtil#formatPathForOpenStream(String)}
   */
  @Test
  void testFormatPathForOpenStream() {
    // Arrange, Act and Assert
    assertEquals("/Path", StreamUtil.formatPathForOpenStream("Path"));
    assertEquals("/", StreamUtil.formatPathForOpenStream("/"));
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.formatPathForOpenStream(null));
    assertThrows(IllegalArgumentException.class, () -> StreamUtil.formatPathForOpenStream(""));
  }
}
