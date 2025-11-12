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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FilterFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class IngestUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  void testSetDirectoryPermsForAccumulo() throws IOException, IllegalArgumentException {
    // Arrange
    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.getFileStatus(Mockito.<Path>any())).thenReturn(new FileStatus());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> IngestUtils.setDirectoryPermsForAccumulo(fs, new Path("Path String")));
    verify(fs).getFileStatus(isA(Path.class));
  }

  /**
   * Method under test:
   * {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  void testSetDirectoryPermsForAccumulo2() throws IOException, IllegalArgumentException {
    // Arrange
    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.listStatus(Mockito.<Path>any())).thenReturn(new FileStatus[]{new FileStatus()});
    doNothing().when(fs).setPermission(Mockito.<Path>any(), Mockito.<FsPermission>any());
    when(fs.getFileStatus(Mockito.<Path>any()))
        .thenReturn(new FileStatus(3L, true, 1, 3L, 10L, new Path("Path String")));

    // Act
    IngestUtils.setDirectoryPermsForAccumulo(fs, new Path("Path String"));

    // Assert that nothing has changed
    verify(fs).getFileStatus(isA(Path.class));
    verify(fs).listStatus(isA(Path.class));
    verify(fs, atLeast(1)).setPermission(Mockito.<Path>any(), isA(FsPermission.class));
  }

  /**
   * Method under test:
   * {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  void testSetDirectoryPermsForAccumulo3() throws IOException, IllegalArgumentException {
    // Arrange
    FileStatus fileStatus = mock(FileStatus.class);
    when(fileStatus.getPath()).thenReturn(new Path("Path String"));
    FilterFileSystem fs = mock(FilterFileSystem.class);
    when(fs.listStatus(Mockito.<Path>any())).thenReturn(new FileStatus[]{fileStatus});
    doNothing().when(fs).setPermission(Mockito.<Path>any(), Mockito.<FsPermission>any());
    when(fs.getFileStatus(Mockito.<Path>any()))
        .thenReturn(new FileStatus(3L, true, 1, 3L, 10L, new Path("Path String")));

    // Act
    IngestUtils.setDirectoryPermsForAccumulo(fs, new Path("Path String"));

    // Assert that nothing has changed
    verify(fileStatus).getPath();
    verify(fs).getFileStatus(isA(Path.class));
    verify(fs).listStatus(isA(Path.class));
    verify(fs, atLeast(1)).setPermission(isA(Path.class), isA(FsPermission.class));
  }

  /**
   * Method under test:
   * {@link IngestUtils#setDirectoryPermsForAccumulo(FileSystem, Path)}
   */
  @Test
  void testSetDirectoryPermsForAccumulo4() throws IOException, IllegalArgumentException {
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

    // Assert that nothing has changed
    verify(fileStatus2).getPath();
    verify(fileStatus).isDirectory();
    verify(fs).getFileStatus(isA(Path.class));
    verify(fs).listStatus(isA(Path.class));
    verify(fs, atLeast(1)).setPermission(isA(Path.class), isA(FsPermission.class));
  }
}
