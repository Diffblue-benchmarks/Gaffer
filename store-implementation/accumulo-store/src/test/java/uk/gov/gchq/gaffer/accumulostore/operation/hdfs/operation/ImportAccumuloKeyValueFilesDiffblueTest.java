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

package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.operation.hdfs.operation.ImportAccumuloKeyValueFiles.Builder;

class ImportAccumuloKeyValueFilesDiffblueTest {
  /**
   * Test Builder {@link Builder#failurePath(String)}.
   * <p>
   * Method under test: {@link Builder#failurePath(String)}
   */
  @Test
  @DisplayName("Test Builder failurePath(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.failurePath(String)"})
  void testBuilderFailurePath() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.failurePath("Failure Path"));
  }

  /**
   * Test Builder {@link Builder#inputPath(String)}.
   * <p>
   * Method under test: {@link Builder#inputPath(String)}
   */
  @Test
  @DisplayName("Test Builder inputPath(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.inputPath(String)"})
  void testBuilderInputPath() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.inputPath("Input Path"));
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    ImportAccumuloKeyValueFiles _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getFailurePath());
    assertNull(_getOpResult.getInputPath());
    assertNull(_getOpResult.getOptions());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Test {@link ImportAccumuloKeyValueFiles#shallowClone()}.
   * <ul>
   *   <li>Given {@link ImportAccumuloKeyValueFiles} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportAccumuloKeyValueFiles#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given ImportAccumuloKeyValueFiles (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportAccumuloKeyValueFiles ImportAccumuloKeyValueFiles.shallowClone()"})
  void testShallowClone_givenImportAccumuloKeyValueFiles_thenReturnOptionsIsNull() {
    // Arrange and Act
    ImportAccumuloKeyValueFiles actualShallowCloneResult = (new ImportAccumuloKeyValueFiles()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getFailurePath());
    assertNull(actualShallowCloneResult.getInputPath());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test {@link ImportAccumuloKeyValueFiles#shallowClone()}.
   * <ul>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportAccumuloKeyValueFiles#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportAccumuloKeyValueFiles ImportAccumuloKeyValueFiles.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    ImportAccumuloKeyValueFiles importAccumuloKeyValueFiles = new ImportAccumuloKeyValueFiles();
    importAccumuloKeyValueFiles.setOptions(new HashMap<>());

    // Act
    ImportAccumuloKeyValueFiles actualShallowCloneResult = importAccumuloKeyValueFiles.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getFailurePath());
    assertNull(actualShallowCloneResult.getInputPath());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImportAccumuloKeyValueFiles}
   *   <li>{@link ImportAccumuloKeyValueFiles#setFailurePath(String)}
   *   <li>{@link ImportAccumuloKeyValueFiles#setInputPath(String)}
   *   <li>{@link ImportAccumuloKeyValueFiles#setOptions(Map)}
   *   <li>{@link ImportAccumuloKeyValueFiles#getFailurePath()}
   *   <li>{@link ImportAccumuloKeyValueFiles#getInputPath()}
   *   <li>{@link ImportAccumuloKeyValueFiles#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImportAccumuloKeyValueFiles.<init>()", "String ImportAccumuloKeyValueFiles.getFailurePath()",
      "String ImportAccumuloKeyValueFiles.getInputPath()", "Map ImportAccumuloKeyValueFiles.getOptions()",
      "void ImportAccumuloKeyValueFiles.setFailurePath(String)",
      "void ImportAccumuloKeyValueFiles.setInputPath(String)", "void ImportAccumuloKeyValueFiles.setOptions(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ImportAccumuloKeyValueFiles actualImportAccumuloKeyValueFiles = new ImportAccumuloKeyValueFiles();
    actualImportAccumuloKeyValueFiles.setFailurePath("Failure Path");
    actualImportAccumuloKeyValueFiles.setInputPath("Input Path");
    HashMap<String, String> options = new HashMap<>();
    actualImportAccumuloKeyValueFiles.setOptions(options);
    String actualFailurePath = actualImportAccumuloKeyValueFiles.getFailurePath();
    String actualInputPath = actualImportAccumuloKeyValueFiles.getInputPath();
    Map<String, String> actualOptions = actualImportAccumuloKeyValueFiles.getOptions();

    // Assert
    assertEquals("Failure Path", actualFailurePath);
    assertEquals("Input Path", actualInputPath);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
