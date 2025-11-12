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

package uk.gov.gchq.gaffer.operation.impl.export.localfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class ImportFromLocalFileDiffblueTest {
  /**
   * Method under test: {@link ImportFromLocalFile.Builder#filePath(String)}
   */
  @Test
  void testBuilderFilePath() {
    // Arrange
    ImportFromLocalFile.Builder builder = new ImportFromLocalFile.Builder();

    // Act and Assert
    assertSame(builder, builder.filePath("/directory/foo.txt"));
  }

  /**
   * Method under test: {@link ImportFromLocalFile#getFilePath()}
   */
  @Test
  void testGetFilePath() {
    // Arrange, Act and Assert
    assertNull((new ImportFromLocalFile()).getFilePath());
  }

  /**
   * Method under test: {@link ImportFromLocalFile#getFilePath()}
   */
  @Test
  void testGetFilePath2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ImportFromLocalFile importFromLocalFile = new ImportFromLocalFile();
    importFromLocalFile.setOptions(options);

    // Act and Assert
    assertNull(importFromLocalFile.getFilePath());
  }

  /**
   * Method under test: {@link ImportFromLocalFile#setFilePath(String)}
   */
  @Test
  void testSetFilePath() {
    // Arrange
    ImportFromLocalFile importFromLocalFile = new ImportFromLocalFile();

    // Act
    importFromLocalFile.setFilePath("/directory/foo.txt");

    // Assert
    assertEquals("/directory/foo.txt", importFromLocalFile.getKeyOrDefault());
    assertEquals("/directory/foo.txt", importFromLocalFile.getFilePath());
    assertEquals("/directory/foo.txt", importFromLocalFile.getKey());
  }

  /**
   * Method under test: {@link ImportFromLocalFile#setFilePath(String)}
   */
  @Test
  void testSetFilePath2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ImportFromLocalFile importFromLocalFile = new ImportFromLocalFile();
    importFromLocalFile.setOptions(options);

    // Act
    importFromLocalFile.setFilePath("/directory/foo.txt");

    // Assert
    assertEquals("/directory/foo.txt", importFromLocalFile.getKeyOrDefault());
    assertEquals("/directory/foo.txt", importFromLocalFile.getFilePath());
    assertEquals("/directory/foo.txt", importFromLocalFile.getKey());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImportFromLocalFile}
   *   <li>{@link ImportFromLocalFile#setKey(String)}
   *   <li>{@link ImportFromLocalFile#setOptions(Map)}
   *   <li>{@link ImportFromLocalFile#setJobId(String)}
   *   <li>{@link ImportFromLocalFile#getJobId()}
   *   <li>{@link ImportFromLocalFile#getKey()}
   *   <li>{@link ImportFromLocalFile#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ImportFromLocalFile actualImportFromLocalFile = new ImportFromLocalFile();
    actualImportFromLocalFile.setKey("/directory/foo.txt");
    HashMap<String, String> options = new HashMap<>();
    actualImportFromLocalFile.setOptions(options);
    actualImportFromLocalFile.setJobId("42");
    actualImportFromLocalFile.getJobId();
    String actualKey = actualImportFromLocalFile.getKey();
    Map<String, String> actualOptions = actualImportFromLocalFile.getOptions();

    // Assert that nothing has changed
    assertEquals("/directory/foo.txt", actualKey);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
