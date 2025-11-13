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

package uk.gov.gchq.gaffer.accumulostore.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FilterFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class IngestUtilsDiffblueTest {
  /**
   * Test {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}.
   * <ul>
   *   <li>Given array of {@link FileStatus} with {@link FileStatus#FileStatus()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  @DisplayName("Test setDirectoryPermsForAccumulo(FileSystem, Path); given array of FileStatus with FileStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IngestUtils.setDirectoryPermsForAccumulo(FileSystem, Path)"})
  void testSetDirectoryPermsForAccumulo_givenArrayOfFileStatusWithFileStatus()
      throws IOException, IllegalArgumentException {
    // Arrange
    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.listStatus(Mockito.<Path>any())).thenReturn(new FileStatus[]{new FileStatus()});
    doNothing().when(fs).setPermission(Mockito.<Path>any(), Mockito.<FsPermission>any());
    when(fs.getFileStatus(Mockito.<Path>any()))
        .thenReturn(new FileStatus(3L, true, 1, 3L, 10L, new Path(" is not a directory")));

    // Act
    IngestUtils.setDirectoryPermsForAccumulo(fs, new Path("Path String"));

    // Assert
    verify(fs).getFileStatus(isA(Path.class));
    verify(fs).listStatus(isA(Path.class));
    verify(fs, atLeast(1)).setPermission(Mockito.<Path>any(), isA(FsPermission.class));
  }

  /**
   * Test {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}.
   * <ul>
   *   <li>Given {@link FileStatus#FileStatus()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  @DisplayName("Test setDirectoryPermsForAccumulo(FileSystem, Path); given FileStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IngestUtils.setDirectoryPermsForAccumulo(FileSystem, Path)"})
  void testSetDirectoryPermsForAccumulo_givenFileStatus() throws IOException, IllegalArgumentException {
    // Arrange
    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.getFileStatus(Mockito.<Path>any())).thenReturn(new FileStatus());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> IngestUtils.setDirectoryPermsForAccumulo(fs, new Path("Path String")));
    verify(fs).getFileStatus(isA(Path.class));
  }

  /**
   * Test {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}.
   * <ul>
   *   <li>Given {@link FileStatus} {@link FileStatus#isDirectory()} return {@code false}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  @DisplayName("Test setDirectoryPermsForAccumulo(FileSystem, Path); given FileStatus isDirectory() return 'false'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IngestUtils.setDirectoryPermsForAccumulo(FileSystem, Path)"})
  void testSetDirectoryPermsForAccumulo_givenFileStatusIsDirectoryReturnFalse_whenNull() throws IOException {
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

  /**
   * Test {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}.
   * <ul>
   *   <li>Given {@link FileStatus} {@link FileStatus#isDirectory()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  @DisplayName("Test setDirectoryPermsForAccumulo(FileSystem, Path); given FileStatus isDirectory() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IngestUtils.setDirectoryPermsForAccumulo(FileSystem, Path)"})
  void testSetDirectoryPermsForAccumulo_givenFileStatusIsDirectoryReturnTrue()
      throws IOException, IllegalArgumentException {
    // Arrange
    FileStatus fileStatus = mock(FileStatus.class);
    when(fileStatus.isDirectory()).thenReturn(true);
    FileStatus fileStatus2 = mock(FileStatus.class);
    when(fileStatus2.getPath()).thenReturn(new Path("Path String"));
    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.listStatus(Mockito.<Path>any())).thenReturn(new FileStatus[]{fileStatus2});
    doNothing().when(fs).setPermission(Mockito.<Path>any(), Mockito.<FsPermission>any());
    when(fs.getFileStatus(Mockito.<Path>any())).thenReturn(fileStatus);

    // Act
    IngestUtils.setDirectoryPermsForAccumulo(fs, new Path("Path String"));

    // Assert
    verify(fileStatus2).getPath();
    verify(fileStatus).isDirectory();
    verify(fs).getFileStatus(isA(Path.class));
    verify(fs).listStatus(isA(Path.class));
    verify(fs, atLeast(1)).setPermission(isA(Path.class), isA(FsPermission.class));
  }

  /**
   * Test {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}.
   * <ul>
   *   <li>Then calls {@link FileStatus#getPath()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  @DisplayName("Test setDirectoryPermsForAccumulo(FileSystem, Path); then calls getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IngestUtils.setDirectoryPermsForAccumulo(FileSystem, Path)"})
  void testSetDirectoryPermsForAccumulo_thenCallsGetPath() throws IOException, IllegalArgumentException {
    // Arrange
    FileStatus fileStatus = mock(FileStatus.class);
    when(fileStatus.getPath()).thenReturn(new Path("Path String"));
    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.listStatus(Mockito.<Path>any())).thenReturn(new FileStatus[]{fileStatus});
    doNothing().when(fs).setPermission(Mockito.<Path>any(), Mockito.<FsPermission>any());
    when(fs.getFileStatus(Mockito.<Path>any()))
        .thenReturn(new FileStatus(3L, true, 1, 3L, 10L, new Path(" is not a directory")));

    // Act
    IngestUtils.setDirectoryPermsForAccumulo(fs, new Path("Path String"));

    // Assert
    verify(fileStatus).getPath();
    verify(fs).getFileStatus(isA(Path.class));
    verify(fs).listStatus(isA(Path.class));
    verify(fs, atLeast(1)).setPermission(isA(Path.class), isA(FsPermission.class));
  }
}
