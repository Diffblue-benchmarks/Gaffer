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
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ExportToLocalFile;

class ExportDiffblueTest {
  /**
   * Method under test: {@link Export.Builder#key(String)}
   */
  @Test
  void testBuilderKey() {
    // Arrange
    ExportToLocalFile.Builder builder = new ExportToLocalFile.Builder();

    // Act and Assert
    assertSame(builder, builder.key("Key"));
  }

  /**
   * Method under test: {@link Export#getKeyOrDefault()}
   */
  @Test
  void testGetKeyOrDefault() {
    // Arrange, Act and Assert
    assertEquals(Export.DEFAULT_KEY, (new ExportToLocalFile()).getKeyOrDefault());
  }

  /**
   * Method under test: {@link Export#getKeyOrDefault()}
   */
  @Test
  void testGetKeyOrDefault2() {
    // Arrange
    ExportToLocalFile exportToLocalFile = new ExportToLocalFile();
    exportToLocalFile.setFilePath("foo");

    // Act and Assert
    assertEquals("foo", exportToLocalFile.getKeyOrDefault());
  }

  /**
   * Method under test: {@link Export#getKeyOrDefault()}
   */
  @Test
  void testGetKeyOrDefault3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ExportToLocalFile exportToLocalFile = new ExportToLocalFile();
    exportToLocalFile.setOptions(options);

    // Act and Assert
    assertEquals(Export.DEFAULT_KEY, exportToLocalFile.getKeyOrDefault());
  }
}
