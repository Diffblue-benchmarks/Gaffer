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

package uk.gov.gchq.gaffer.store.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.exception.OverwritingException;
import uk.gov.gchq.gaffer.store.StoreProperties;

class FileGraphLibraryDiffblueTest {
  /**
   * Test {@link FileGraphLibrary#FileGraphLibrary()}.
   * <p>
   * Method under test: {@link FileGraphLibrary#FileGraphLibrary()}
   */
  @Test
  @DisplayName("Test new FileGraphLibrary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FileGraphLibrary.<init>()"})
  void testNewFileGraphLibrary() {
    // Arrange, Act and Assert
    assertEquals("graphLibrary", (new FileGraphLibrary()).getPath());
  }

  /**
   * Test {@link FileGraphLibrary#FileGraphLibrary(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Path is {@code graphLibrary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileGraphLibrary#FileGraphLibrary(String)}
   */
  @Test
  @DisplayName("Test new FileGraphLibrary(String); when 'null'; then return Path is 'graphLibrary'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FileGraphLibrary.<init>(String)"})
  void testNewFileGraphLibrary_whenNull_thenReturnPathIsGraphLibrary() {
    // Arrange, Act and Assert
    assertEquals("graphLibrary", (new FileGraphLibrary(null)).getPath());
  }

  /**
   * Test {@link FileGraphLibrary#FileGraphLibrary(String)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then return {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileGraphLibrary#FileGraphLibrary(String)}
   */
  @Test
  @DisplayName("Test new FileGraphLibrary(String); when 'Path'; then return 'Path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FileGraphLibrary.<init>(String)"})
  void testNewFileGraphLibrary_whenPath_thenReturnPath() {
    // Arrange, Act and Assert
    assertEquals("Path", (new FileGraphLibrary("Path")).getPath());
  }

  /**
   * Test {@link FileGraphLibrary#initialise(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FileGraphLibrary#FileGraphLibrary()} Path is {@code graphLibrary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileGraphLibrary#initialise(String)}
   */
  @Test
  @DisplayName("Test initialise(String); when 'null'; then FileGraphLibrary() Path is 'graphLibrary'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FileGraphLibrary.initialise(String)"})
  void testInitialise_whenNull_thenFileGraphLibraryPathIsGraphLibrary() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act
    fileGraphLibrary.initialise(null);

    // Assert that nothing has changed
    assertEquals("graphLibrary", fileGraphLibrary.getPath());
  }

  /**
   * Test {@link FileGraphLibrary#initialise(String)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then {@link FileGraphLibrary#FileGraphLibrary()} Path is {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileGraphLibrary#initialise(String)}
   */
  @Test
  @DisplayName("Test initialise(String); when 'Path'; then FileGraphLibrary() Path is 'Path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FileGraphLibrary.initialise(String)"})
  void testInitialise_whenPath_thenFileGraphLibraryPathIsPath() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act
    fileGraphLibrary.initialise("Path");

    // Assert
    assertEquals("Path", fileGraphLibrary.getPath());
  }

  /**
   * Test {@link FileGraphLibrary#getPath()}.
   * <p>
   * Method under test: {@link FileGraphLibrary#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FileGraphLibrary.getPath()"})
  void testGetPath() {
    // Arrange, Act and Assert
    assertEquals("graphLibrary", (new FileGraphLibrary()).getPath());
  }

  /**
   * Test {@link FileGraphLibrary#setPath(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FileGraphLibrary#FileGraphLibrary()} Path is {@code graphLibrary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileGraphLibrary#setPath(String)}
   */
  @Test
  @DisplayName("Test setPath(String); when 'null'; then FileGraphLibrary() Path is 'graphLibrary'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FileGraphLibrary.setPath(String)"})
  void testSetPath_whenNull_thenFileGraphLibraryPathIsGraphLibrary() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act
    fileGraphLibrary.setPath(null);

    // Assert that nothing has changed
    assertEquals("graphLibrary", fileGraphLibrary.getPath());
  }

  /**
   * Test {@link FileGraphLibrary#setPath(String)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then {@link FileGraphLibrary#FileGraphLibrary()} Path is {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileGraphLibrary#setPath(String)}
   */
  @Test
  @DisplayName("Test setPath(String); when 'Path'; then FileGraphLibrary() Path is 'Path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FileGraphLibrary.setPath(String)"})
  void testSetPath_whenPath_thenFileGraphLibraryPathIsPath() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act
    fileGraphLibrary.setPath("Path");

    // Assert
    assertEquals("Path", fileGraphLibrary.getPath());
  }

  /**
   * Test {@link FileGraphLibrary#getIds(String)}.
   * <p>
   * Method under test: {@link FileGraphLibrary#getIds(String)}
   */
  @Test
  @DisplayName("Test getIds(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"uk.gov.gchq.gaffer.commonutil.pair.Pair FileGraphLibrary.getIds(String)"})
  void testGetIds() {
    // Arrange, Act and Assert
    assertNull((new FileGraphLibrary()).getIds("42"));
  }

  /**
   * Test {@link FileGraphLibrary#_addSchema(String, byte[])}.
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileGraphLibrary#_addSchema(String, byte[])}
   */
  @Test
  @DisplayName("Test _addSchema(String, byte[]); given FileGraphLibrary(); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FileGraphLibrary._addSchema(String, byte[])"})
  void test_addSchema_givenFileGraphLibrary_whenNull_thenThrowIllegalArgumentException() throws OverwritingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new FileGraphLibrary())._addSchema("42", null));
  }

  /**
   * Test {@link FileGraphLibrary#_addProperties(String, StoreProperties)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileGraphLibrary#_addProperties(String, StoreProperties)}
   */
  @Test
  @DisplayName("Test _addProperties(String, StoreProperties); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FileGraphLibrary._addProperties(String, StoreProperties)"})
  void test_addProperties_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new FileGraphLibrary())._addProperties("42", null));
  }

  /**
   * Test {@link FileGraphLibrary#_getSchema(String)}.
   * <p>
   * Method under test: {@link FileGraphLibrary#_getSchema(String)}
   */
  @Test
  @DisplayName("Test _getSchema(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] FileGraphLibrary._getSchema(String)"})
  void test_getSchema() {
    // Arrange, Act and Assert
    assertNull((new FileGraphLibrary())._getSchema("42"));
  }

  /**
   * Test {@link FileGraphLibrary#_getProperties(String)}.
   * <p>
   * Method under test: {@link FileGraphLibrary#_getProperties(String)}
   */
  @Test
  @DisplayName("Test _getProperties(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StoreProperties FileGraphLibrary._getProperties(String)"})
  void test_getProperties() {
    // Arrange, Act and Assert
    assertNull((new FileGraphLibrary())._getProperties("42"));
  }
}
