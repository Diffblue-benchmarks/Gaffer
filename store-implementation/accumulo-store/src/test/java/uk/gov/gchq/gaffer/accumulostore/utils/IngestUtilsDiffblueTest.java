/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.accumulostore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.accumulo.core.client.AccumuloSecurityException;
import org.apache.accumulo.core.client.Connector;
import org.apache.accumulo.core.client.TableNotFoundException;
import org.apache.accumulo.core.clientImpl.ConnectorImpl;
import org.apache.accumulo.core.clientImpl.TableOperationsImpl;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FilterFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.io.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class IngestUtilsDiffblueTest {
  /**
   * Test {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path, int)} with {@code
   * conn}, {@code table}, {@code fs}, {@code splitsFile}, {@code maxSplits}.
   *
   * <p>Method under test: {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createSplitsFile(Connector, String, FileSystem, Path, int) with 'conn', 'table', 'fs', 'splitsFile', 'maxSplits'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IngestUtils.createSplitsFile(Connector, String, FileSystem, Path, int)"})
  void testCreateSplitsFileWithConnTableFsSplitsFileMaxSplits()
      throws IOException, IllegalArgumentException, AccumuloSecurityException,
          TableNotFoundException {
    // Arrange
    ArrayList<Text> textList = new ArrayList<>();
    textList.add(new Text());

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.listSplits(Mockito.<String>any(), anyInt())).thenReturn(textList);

    ConnectorImpl conn = mock(ConnectorImpl.class);
    when(conn.tableOperations()).thenReturn(tableOperationsImpl);

    FilterFileSystem fs = mock(FilterFileSystem.class);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Class<FileSystem> cls = FileSystem.class;
    FSDataOutputStream fsDataOutputStream =
        new FSDataOutputStream(out, FileSystem.getStatistics("Scheme", cls));
    when(fs.create(Mockito.<Path>any(), anyBoolean())).thenReturn(fsDataOutputStream);

    // Act
    int actualCreateSplitsFileResult =
        IngestUtils.createSplitsFile(conn, "Table", fs, new Path("Path String"), 3);

    // Assert
    verify(conn).tableOperations();
    verify(tableOperationsImpl).listSplits("Table", 3);
    verify(fs).create(isA(Path.class), eq(true));
    assertEquals(1, actualCreateSplitsFileResult);
  }

  /**
   * Test {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path, int)} with {@code
   * conn}, {@code table}, {@code fs}, {@code splitsFile}, {@code maxSplits}.
   *
   * <p>Method under test: {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createSplitsFile(Connector, String, FileSystem, Path, int) with 'conn', 'table', 'fs', 'splitsFile', 'maxSplits'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IngestUtils.createSplitsFile(Connector, String, FileSystem, Path, int)"})
  void testCreateSplitsFileWithConnTableFsSplitsFileMaxSplits2()
      throws IOException, IllegalArgumentException, AccumuloSecurityException,
          TableNotFoundException {
    // Arrange
    ArrayList<Text> textList = new ArrayList<>();
    textList.add(
        new Text("Creating splits file in location {} from table {} with maximum splits {}"));

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.listSplits(Mockito.<String>any(), anyInt())).thenReturn(textList);

    ConnectorImpl conn = mock(ConnectorImpl.class);
    when(conn.tableOperations()).thenReturn(tableOperationsImpl);

    FSDataOutputStream fsDataOutputStream = mock(FSDataOutputStream.class);
    doNothing().when(fsDataOutputStream).write(Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(fsDataOutputStream).flush();
    doNothing().when(fsDataOutputStream).close();

    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.create(Mockito.<Path>any(), anyBoolean())).thenReturn(fsDataOutputStream);

    // Act
    int actualCreateSplitsFileResult =
        IngestUtils.createSplitsFile(conn, "Table", fs, new Path("Path String"), 3);

    // Assert
    verify(fsDataOutputStream).flush();
    verify(fsDataOutputStream).write(isA(byte[].class), eq(0), eq(109));
    verify(conn).tableOperations();
    verify(tableOperationsImpl).listSplits("Table", 3);
    verify(fsDataOutputStream).close();
    verify(fs).create(isA(Path.class), eq(true));
    assertEquals(1, actualCreateSplitsFileResult);
  }

  /**
   * Test {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path, int)} with {@code
   * conn}, {@code table}, {@code fs}, {@code splitsFile}, {@code maxSplits}.
   *
   * <p>Method under test: {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createSplitsFile(Connector, String, FileSystem, Path, int) with 'conn', 'table', 'fs', 'splitsFile', 'maxSplits'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IngestUtils.createSplitsFile(Connector, String, FileSystem, Path, int)"})
  void testCreateSplitsFileWithConnTableFsSplitsFileMaxSplits3()
      throws IOException, IllegalArgumentException, AccumuloSecurityException,
          TableNotFoundException {
    // Arrange
    ArrayList<Text> textList = new ArrayList<>();
    Text text = new Text(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    textList.add(text);

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.listSplits(Mockito.<String>any(), anyInt())).thenReturn(textList);

    ConnectorImpl conn = mock(ConnectorImpl.class);
    when(conn.tableOperations()).thenReturn(tableOperationsImpl);

    FSDataOutputStream fsDataOutputStream = mock(FSDataOutputStream.class);
    doNothing().when(fsDataOutputStream).write(Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(fsDataOutputStream).flush();
    doNothing().when(fsDataOutputStream).close();

    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.create(Mockito.<Path>any(), anyBoolean())).thenReturn(fsDataOutputStream);

    // Act
    int actualCreateSplitsFileResult =
        IngestUtils.createSplitsFile(conn, "Table", fs, new Path("Path String"), 3);

    // Assert
    verify(fsDataOutputStream).flush();
    verify(fsDataOutputStream).write(isA(byte[].class), eq(0), eq(13));
    verify(conn).tableOperations();
    verify(tableOperationsImpl).listSplits("Table", 3);
    verify(fsDataOutputStream).close();
    verify(fs).create(isA(Path.class), eq(true));
    assertEquals(1, actualCreateSplitsFileResult);
  }

  /**
   * Test {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path, int)} with {@code
   * conn}, {@code table}, {@code fs}, {@code splitsFile}, {@code maxSplits}.
   *
   * <p>Method under test: {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createSplitsFile(Connector, String, FileSystem, Path, int) with 'conn', 'table', 'fs', 'splitsFile', 'maxSplits'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IngestUtils.createSplitsFile(Connector, String, FileSystem, Path, int)"})
  void testCreateSplitsFileWithConnTableFsSplitsFileMaxSplits4()
      throws IOException, IllegalArgumentException, AccumuloSecurityException,
          TableNotFoundException {
    // Arrange
    Text text = mock(Text.class);
    when(text.getBytes()).thenReturn("AXAXAXAXAXAXAXAXAXAXAXAX".getBytes("UTF-8"));

    ArrayList<Text> textList = new ArrayList<>();
    textList.add(text);

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.listSplits(Mockito.<String>any(), anyInt())).thenReturn(textList);

    ConnectorImpl conn = mock(ConnectorImpl.class);
    when(conn.tableOperations()).thenReturn(tableOperationsImpl);

    FSDataOutputStream fsDataOutputStream = mock(FSDataOutputStream.class);
    doNothing().when(fsDataOutputStream).write(Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(fsDataOutputStream).flush();
    doNothing().when(fsDataOutputStream).close();

    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.create(Mockito.<Path>any(), anyBoolean())).thenReturn(fsDataOutputStream);

    // Act
    int actualCreateSplitsFileResult =
        IngestUtils.createSplitsFile(conn, "Table", fs, new Path("Path String"), 3);

    // Assert
    verify(fsDataOutputStream).flush();
    verify(fsDataOutputStream).write(isA(byte[].class), eq(0), eq(33));
    verify(conn).tableOperations();
    verify(tableOperationsImpl).listSplits("Table", 3);
    verify(fsDataOutputStream).close();
    verify(fs).create(isA(Path.class), eq(true));
    verify(text).getBytes();
    assertEquals(1, actualCreateSplitsFileResult);
  }

  /**
   * Test {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path, int)} with {@code
   * conn}, {@code table}, {@code fs}, {@code splitsFile}, {@code maxSplits}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Text#Text()}.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createSplitsFile(Connector, String, FileSystem, Path, int) with 'conn', 'table', 'fs', 'splitsFile', 'maxSplits'; given ArrayList() add Text()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IngestUtils.createSplitsFile(Connector, String, FileSystem, Path, int)"})
  void testCreateSplitsFileWithConnTableFsSplitsFileMaxSplits_givenArrayListAddText()
      throws IOException, IllegalArgumentException, AccumuloSecurityException,
          TableNotFoundException {
    // Arrange
    ArrayList<Text> textList = new ArrayList<>();
    textList.add(new Text());

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.listSplits(Mockito.<String>any(), anyInt())).thenReturn(textList);

    ConnectorImpl conn = mock(ConnectorImpl.class);
    when(conn.tableOperations()).thenReturn(tableOperationsImpl);

    FSDataOutputStream fsDataOutputStream = mock(FSDataOutputStream.class);
    doNothing().when(fsDataOutputStream).write(Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(fsDataOutputStream).flush();
    doNothing().when(fsDataOutputStream).close();

    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.create(Mockito.<Path>any(), anyBoolean())).thenReturn(fsDataOutputStream);

    // Act
    int actualCreateSplitsFileResult =
        IngestUtils.createSplitsFile(conn, "Table", fs, new Path("Path String"), 3);

    // Assert
    verify(fsDataOutputStream).flush();
    verify(fsDataOutputStream).write(isA(byte[].class), eq(0), eq(1));
    verify(conn).tableOperations();
    verify(tableOperationsImpl).listSplits("Table", 3);
    verify(fsDataOutputStream).close();
    verify(fs).create(isA(Path.class), eq(true));
    assertEquals(1, actualCreateSplitsFileResult);
  }

  /**
   * Test {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path, int)} with {@code
   * conn}, {@code table}, {@code fs}, {@code splitsFile}, {@code maxSplits}.
   *
   * <ul>
   *   <li>Given {@code X}.
   *   <li>Then calls {@link Text#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createSplitsFile(Connector, String, FileSystem, Path, int) with 'conn', 'table', 'fs', 'splitsFile', 'maxSplits'; given 'X'; then calls getBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IngestUtils.createSplitsFile(Connector, String, FileSystem, Path, int)"})
  void testCreateSplitsFileWithConnTableFsSplitsFileMaxSplits_givenX_thenCallsGetBytes()
      throws IOException, IllegalArgumentException, AccumuloSecurityException,
          TableNotFoundException {
    // Arrange
    Text text = mock(Text.class);
    when(text.getBytes()).thenReturn(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    ArrayList<Text> textList = new ArrayList<>();
    textList.add(text);

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.listSplits(Mockito.<String>any(), anyInt())).thenReturn(textList);

    ConnectorImpl conn = mock(ConnectorImpl.class);
    when(conn.tableOperations()).thenReturn(tableOperationsImpl);

    FSDataOutputStream fsDataOutputStream = mock(FSDataOutputStream.class);
    doNothing().when(fsDataOutputStream).write(Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(fsDataOutputStream).flush();
    doNothing().when(fsDataOutputStream).close();

    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.create(Mockito.<Path>any(), anyBoolean())).thenReturn(fsDataOutputStream);

    // Act
    int actualCreateSplitsFileResult =
        IngestUtils.createSplitsFile(conn, "Table", fs, new Path("Path String"), 3);

    // Assert
    verify(fsDataOutputStream).flush();
    verify(fsDataOutputStream).write(isA(byte[].class), eq(0), eq(13));
    verify(conn).tableOperations();
    verify(tableOperationsImpl).listSplits("Table", 3);
    verify(fsDataOutputStream).close();
    verify(fs).create(isA(Path.class), eq(true));
    verify(text).getBytes();
    assertEquals(1, actualCreateSplitsFileResult);
  }

  /**
   * Test {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path, int)} with {@code
   * conn}, {@code table}, {@code fs}, {@code splitsFile}, {@code maxSplits}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createSplitsFile(Connector, String, FileSystem, Path, int) with 'conn', 'table', 'fs', 'splitsFile', 'maxSplits'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IngestUtils.createSplitsFile(Connector, String, FileSystem, Path, int)"})
  void testCreateSplitsFileWithConnTableFsSplitsFileMaxSplits_thenReturnZero()
      throws IOException, IllegalArgumentException, AccumuloSecurityException,
          TableNotFoundException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.listSplits(Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    ConnectorImpl conn = mock(ConnectorImpl.class);
    when(conn.tableOperations()).thenReturn(tableOperationsImpl);

    FilterFileSystem fs = mock(FilterFileSystem.class);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Class<FileSystem> cls = FileSystem.class;
    FSDataOutputStream fsDataOutputStream =
        new FSDataOutputStream(out, FileSystem.getStatistics("Scheme", cls));
    when(fs.create(Mockito.<Path>any(), anyBoolean())).thenReturn(fsDataOutputStream);

    // Act
    int actualCreateSplitsFileResult =
        IngestUtils.createSplitsFile(conn, "Table", fs, new Path("Path String"), 3);

    // Assert
    verify(conn).tableOperations();
    verify(tableOperationsImpl).listSplits("Table", 3);
    verify(fs).create(isA(Path.class), eq(true));
    assertEquals(0, actualCreateSplitsFileResult);
  }

  /**
   * Test {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path, int)} with {@code
   * conn}, {@code table}, {@code fs}, {@code splitsFile}, {@code maxSplits}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createSplitsFile(Connector, String, FileSystem, Path, int) with 'conn', 'table', 'fs', 'splitsFile', 'maxSplits'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IngestUtils.createSplitsFile(Connector, String, FileSystem, Path, int)"})
  void testCreateSplitsFileWithConnTableFsSplitsFileMaxSplits_thenReturnZero2()
      throws IOException, IllegalArgumentException, AccumuloSecurityException,
          TableNotFoundException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.listSplits(Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    ConnectorImpl conn = mock(ConnectorImpl.class);
    when(conn.tableOperations()).thenReturn(tableOperationsImpl);

    FSDataOutputStream fsDataOutputStream = mock(FSDataOutputStream.class);
    doNothing().when(fsDataOutputStream).flush();
    doNothing().when(fsDataOutputStream).close();

    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.create(Mockito.<Path>any(), anyBoolean())).thenReturn(fsDataOutputStream);

    // Act
    int actualCreateSplitsFileResult =
        IngestUtils.createSplitsFile(conn, "Table", fs, new Path("Path String"), 3);

    // Assert
    verify(fsDataOutputStream).flush();
    verify(conn).tableOperations();
    verify(tableOperationsImpl).listSplits("Table", 3);
    verify(fsDataOutputStream).close();
    verify(fs).create(isA(Path.class), eq(true));
    assertEquals(0, actualCreateSplitsFileResult);
  }

  /**
   * Test {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path, int)} with {@code
   * conn}, {@code table}, {@code fs}, {@code splitsFile}, {@code maxSplits}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createSplitsFile(Connector, String, FileSystem, Path, int) with 'conn', 'table', 'fs', 'splitsFile', 'maxSplits'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IngestUtils.createSplitsFile(Connector, String, FileSystem, Path, int)"})
  void testCreateSplitsFileWithConnTableFsSplitsFileMaxSplits_thenThrowIOException()
      throws IOException, IllegalArgumentException, AccumuloSecurityException,
          TableNotFoundException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    TableNotFoundException tableNotFoundException =
        new TableNotFoundException(
            "42",
            "Creating splits file in location {} from table {} with maximum splits {}",
            "The characteristics of someone or something");
    when(tableOperationsImpl.listSplits(Mockito.<String>any(), anyInt()))
        .thenThrow(tableNotFoundException);

    ConnectorImpl conn = mock(ConnectorImpl.class);
    when(conn.tableOperations()).thenReturn(tableOperationsImpl);
    FilterFileSystem fs = new FilterFileSystem();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> IngestUtils.createSplitsFile(conn, "Table", fs, new Path("Path String"), 3));
    verify(conn).tableOperations();
    verify(tableOperationsImpl).listSplits("Table", 3);
  }

  /**
   * Test {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path, int)} with {@code
   * conn}, {@code table}, {@code fs}, {@code splitsFile}, {@code maxSplits}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createSplitsFile(Connector, String, FileSystem, Path, int) with 'conn', 'table', 'fs', 'splitsFile', 'maxSplits'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IngestUtils.createSplitsFile(Connector, String, FileSystem, Path, int)"})
  void testCreateSplitsFileWithConnTableFsSplitsFileMaxSplits_thenThrowRuntimeException()
      throws IOException, IllegalArgumentException, AccumuloSecurityException,
          TableNotFoundException {
    // Arrange
    ArrayList<Text> textList = new ArrayList<>();
    textList.add(new Text());

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.listSplits(Mockito.<String>any(), anyInt())).thenReturn(textList);

    ConnectorImpl conn = mock(ConnectorImpl.class);
    when(conn.tableOperations()).thenReturn(tableOperationsImpl);

    FSDataOutputStream fsDataOutputStream = mock(FSDataOutputStream.class);
    doThrow(new RuntimeException())
        .when(fsDataOutputStream)
        .write(Mockito.<byte[]>any(), anyInt(), anyInt());
    doNothing().when(fsDataOutputStream).close();

    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.create(Mockito.<Path>any(), anyBoolean())).thenReturn(fsDataOutputStream);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> IngestUtils.createSplitsFile(conn, "Table", fs, new Path("Path String"), 3));
    verify(fsDataOutputStream).write(isA(byte[].class), eq(0), eq(1));
    verify(conn).tableOperations();
    verify(tableOperationsImpl).listSplits("Table", 3);
    verify(fsDataOutputStream).close();
    verify(fs).create(isA(Path.class), eq(true));
  }

  /**
   * Test {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path)} with {@code
   * conn}, {@code table}, {@code fs}, {@code splitsFile}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path)}
   */
  @Test
  @DisplayName(
      "Test createSplitsFile(Connector, String, FileSystem, Path) with 'conn', 'table', 'fs', 'splitsFile'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IngestUtils.createSplitsFile(Connector, String, FileSystem, Path)"})
  void testCreateSplitsFileWithConnTableFsSplitsFile_thenReturnOne()
      throws IOException, IllegalArgumentException, AccumuloSecurityException,
          TableNotFoundException {
    // Arrange
    ArrayList<Text> textList = new ArrayList<>();
    textList.add(new Text());

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.listSplits(Mockito.<String>any(), anyInt())).thenReturn(textList);

    ConnectorImpl conn = mock(ConnectorImpl.class);
    when(conn.tableOperations()).thenReturn(tableOperationsImpl);

    FilterFileSystem fs = mock(FilterFileSystem.class);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Class<FileSystem> cls = FileSystem.class;
    FSDataOutputStream fsDataOutputStream =
        new FSDataOutputStream(out, FileSystem.getStatistics("Scheme", cls));
    when(fs.create(Mockito.<Path>any(), anyBoolean())).thenReturn(fsDataOutputStream);

    // Act
    int actualCreateSplitsFileResult =
        IngestUtils.createSplitsFile(conn, "Table", fs, new Path("Path String"));

    // Assert
    verify(conn).tableOperations();
    verify(tableOperationsImpl).listSplits("Table", 2147483647);
    verify(fs).create(isA(Path.class), eq(true));
    assertEquals(1, actualCreateSplitsFileResult);
  }

  /**
   * Test {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path)} with {@code
   * conn}, {@code table}, {@code fs}, {@code splitsFile}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path)}
   */
  @Test
  @DisplayName(
      "Test createSplitsFile(Connector, String, FileSystem, Path) with 'conn', 'table', 'fs', 'splitsFile'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IngestUtils.createSplitsFile(Connector, String, FileSystem, Path)"})
  void testCreateSplitsFileWithConnTableFsSplitsFile_thenReturnZero()
      throws IOException, IllegalArgumentException, AccumuloSecurityException,
          TableNotFoundException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.listSplits(Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    ConnectorImpl conn = mock(ConnectorImpl.class);
    when(conn.tableOperations()).thenReturn(tableOperationsImpl);

    FilterFileSystem fs = mock(FilterFileSystem.class);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Class<FileSystem> cls = FileSystem.class;
    FSDataOutputStream fsDataOutputStream =
        new FSDataOutputStream(out, FileSystem.getStatistics("Scheme", cls));
    when(fs.create(Mockito.<Path>any(), anyBoolean())).thenReturn(fsDataOutputStream);

    // Act
    int actualCreateSplitsFileResult =
        IngestUtils.createSplitsFile(conn, "Table", fs, new Path("Path String"));

    // Assert
    verify(conn).tableOperations();
    verify(tableOperationsImpl).listSplits("Table", 2147483647);
    verify(fs).create(isA(Path.class), eq(true));
    assertEquals(0, actualCreateSplitsFileResult);
  }

  /**
   * Test {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path)} with {@code
   * conn}, {@code table}, {@code fs}, {@code splitsFile}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#createSplitsFile(Connector, String, FileSystem, Path)}
   */
  @Test
  @DisplayName(
      "Test createSplitsFile(Connector, String, FileSystem, Path) with 'conn', 'table', 'fs', 'splitsFile'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IngestUtils.createSplitsFile(Connector, String, FileSystem, Path)"})
  void testCreateSplitsFileWithConnTableFsSplitsFile_thenThrowIOException()
      throws IOException, IllegalArgumentException, AccumuloSecurityException,
          TableNotFoundException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    TableNotFoundException tableNotFoundException =
        new TableNotFoundException(
            "42",
            "Creating splits file in location {} from table {} with maximum splits {}",
            "The characteristics of someone or something");
    when(tableOperationsImpl.listSplits(Mockito.<String>any(), anyInt()))
        .thenThrow(tableNotFoundException);

    ConnectorImpl conn = mock(ConnectorImpl.class);
    when(conn.tableOperations()).thenReturn(tableOperationsImpl);
    FilterFileSystem fs = new FilterFileSystem();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> IngestUtils.createSplitsFile(conn, "Table", fs, new Path("Path String")));
    verify(conn).tableOperations();
    verify(tableOperationsImpl).listSplits("Table", 2147483647);
  }

  /**
   * Test {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}.
   *
   * <ul>
   *   <li>Given array of {@link FileStatus} with {@link FileStatus#FileStatus()}.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  @DisplayName(
      "Test setDirectoryPermsForAccumulo(FileSystem, Path); given array of FileStatus with FileStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IngestUtils.setDirectoryPermsForAccumulo(FileSystem, Path)"})
  void testSetDirectoryPermsForAccumulo_givenArrayOfFileStatusWithFileStatus()
      throws IOException, IllegalArgumentException {
    // Arrange
    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.listStatus(Mockito.<Path>any())).thenReturn(new FileStatus[] {new FileStatus()});
    doNothing().when(fs).setPermission(Mockito.<Path>any(), Mockito.<FsPermission>any());
    FileStatus fileStatus = new FileStatus(3L, true, 1, 3L, 10L, new Path(" is not a directory"));
    when(fs.getFileStatus(Mockito.<Path>any())).thenReturn(fileStatus);

    // Act
    IngestUtils.setDirectoryPermsForAccumulo(fs, new Path("Path String"));

    // Assert
    verify(fs).getFileStatus(isA(Path.class));
    verify(fs).listStatus(isA(Path.class));
    verify(fs, atLeast(1)).setPermission(Mockito.<Path>any(), isA(FsPermission.class));
  }

  /**
   * Test {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}.
   *
   * <ul>
   *   <li>Given {@link FileStatus#FileStatus()}.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  @DisplayName("Test setDirectoryPermsForAccumulo(FileSystem, Path); given FileStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IngestUtils.setDirectoryPermsForAccumulo(FileSystem, Path)"})
  void testSetDirectoryPermsForAccumulo_givenFileStatus()
      throws IOException, IllegalArgumentException {
    // Arrange
    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.getFileStatus(Mockito.<Path>any())).thenReturn(new FileStatus());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> IngestUtils.setDirectoryPermsForAccumulo(fs, new Path("Path String")));
    verify(fs).getFileStatus(isA(Path.class));
  }

  /**
   * Test {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  @DisplayName(
      "Test setDirectoryPermsForAccumulo(FileSystem, Path); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IngestUtils.setDirectoryPermsForAccumulo(FileSystem, Path)"})
  void testSetDirectoryPermsForAccumulo_givenIOException_thenThrowIOException()
      throws IOException, IllegalArgumentException {
    // Arrange
    FilterFileSystem fs = mock(FilterFileSystem.class);
    doThrow(new IOException())
        .when(fs)
        .setPermission(Mockito.<Path>any(), Mockito.<FsPermission>any());
    FileStatus fileStatus = new FileStatus(3L, true, 1, 3L, 10L, new Path(" is not a directory"));
    when(fs.getFileStatus(Mockito.<Path>any())).thenReturn(fileStatus);

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> IngestUtils.setDirectoryPermsForAccumulo(fs, new Path("Path String")));
    verify(fs).getFileStatus(isA(Path.class));
    verify(fs).setPermission(isA(Path.class), isA(FsPermission.class));
  }

  /**
   * Test {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}.
   *
   * <ul>
   *   <li>Then calls {@link FileStatus#getPath()}.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  @DisplayName("Test setDirectoryPermsForAccumulo(FileSystem, Path); then calls getPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IngestUtils.setDirectoryPermsForAccumulo(FileSystem, Path)"})
  void testSetDirectoryPermsForAccumulo_thenCallsGetPath()
      throws IOException, IllegalArgumentException {
    // Arrange
    FileStatus fileStatus = mock(FileStatus.class);
    when(fileStatus.getPath()).thenReturn(new Path("Path String"));

    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.listStatus(Mockito.<Path>any())).thenReturn(new FileStatus[] {fileStatus});
    doNothing().when(fs).setPermission(Mockito.<Path>any(), Mockito.<FsPermission>any());
    FileStatus fileStatus2 = new FileStatus(3L, true, 1, 3L, 10L, new Path(" is not a directory"));
    when(fs.getFileStatus(Mockito.<Path>any())).thenReturn(fileStatus2);

    // Act
    IngestUtils.setDirectoryPermsForAccumulo(fs, new Path("Path String"));

    // Assert
    verify(fileStatus).getPath();
    verify(fs).getFileStatus(isA(Path.class));
    verify(fs).listStatus(isA(Path.class));
    verify(fs, atLeast(1)).setPermission(isA(Path.class), isA(FsPermission.class));
  }

  /**
   * Test {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}.
   *
   * <ul>
   *   <li>Then calls {@link FileStatus#isDirectory()}.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  @DisplayName("Test setDirectoryPermsForAccumulo(FileSystem, Path); then calls isDirectory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IngestUtils.setDirectoryPermsForAccumulo(FileSystem, Path)"})
  void testSetDirectoryPermsForAccumulo_thenCallsIsDirectory()
      throws IOException, IllegalArgumentException {
    // Arrange
    FileStatus fileStatus = mock(FileStatus.class);
    when(fileStatus.isDirectory()).thenReturn(false);

    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.getFileStatus(Mockito.<Path>any())).thenReturn(fileStatus);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> IngestUtils.setDirectoryPermsForAccumulo(fs, new Path("Path String")));
    verify(fileStatus).isDirectory();
    verify(fs).getFileStatus(isA(Path.class));
  }

  /**
   * Test {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link FileStatus#isDirectory()}.
   * </ul>
   *
   * <p>Method under test: {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  @DisplayName(
      "Test setDirectoryPermsForAccumulo(FileSystem, Path); when 'null'; then calls isDirectory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IngestUtils.setDirectoryPermsForAccumulo(FileSystem, Path)"})
  void testSetDirectoryPermsForAccumulo_whenNull_thenCallsIsDirectory() throws IOException {
    // Arrange
    FileStatus fileStatus = mock(FileStatus.class);
    when(fileStatus.isDirectory()).thenReturn(false);

    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.getFileStatus(Mockito.<Path>any())).thenReturn(fileStatus);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> IngestUtils.setDirectoryPermsForAccumulo(fs, null));
    verify(fileStatus).isDirectory();
    verify(fs).getFileStatus((Path) isNull());
  }
}
