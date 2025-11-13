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

package uk.gov.gchq.gaffer.operation.export;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ExportToLocalFile;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ExportToLocalFile.Builder;

class ExportDiffblueTest {
  /**
   * Test Builder {@link Export.Builder#key(String)}.
   *
   * <p>Method under test: {@link Export.Builder#key(String)}
   */
  @Test
  @DisplayName("Test Builder key(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Export.Builder Export.Builder.key(String)"})
  void testBuilderKey() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualKeyResult = builder.key("Key");

    // Assert
    assertSame(builder, actualKeyResult);
  }

  /**
   * Test {@link Export#getKeyOrDefault()}.
   *
   * <ul>
   *   <li>Given {@link ExportToLocalFile} (default constructor) FilePath is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Export#getKeyOrDefault()}
   */
  @Test
  @DisplayName(
      "Test getKeyOrDefault(); given ExportToLocalFile (default constructor) FilePath is 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Export.getKeyOrDefault()"})
  void testGetKeyOrDefault_givenExportToLocalFileFilePathIsFoo_thenReturnFoo() {
    // Arrange
    ExportToLocalFile exportToLocalFile = new ExportToLocalFile();
    exportToLocalFile.setFilePath("foo");

    // Act and Assert
    assertEquals("foo", exportToLocalFile.getKeyOrDefault());
  }

  /**
   * Test {@link Export#getKeyOrDefault()}.
   *
   * <ul>
   *   <li>Given {@link ExportToLocalFile} (default constructor).
   *   <li>Then return {@link Export#DEFAULT_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link Export#getKeyOrDefault()}
   */
  @Test
  @DisplayName(
      "Test getKeyOrDefault(); given ExportToLocalFile (default constructor); then return DEFAULT_KEY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Export.getKeyOrDefault()"})
  void testGetKeyOrDefault_givenExportToLocalFile_thenReturnDefault_key() {
    // Arrange, Act and Assert
    assertEquals(Export.DEFAULT_KEY, new ExportToLocalFile().getKeyOrDefault());
  }
}
