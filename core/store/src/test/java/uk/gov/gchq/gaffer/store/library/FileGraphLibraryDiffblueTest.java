package uk.gov.gchq.gaffer.store.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.exception.OverwritingException;
import uk.gov.gchq.gaffer.store.StoreProperties;

class FileGraphLibraryDiffblueTest {
  /**
   * Test {@link FileGraphLibrary#FileGraphLibrary()}.
   *
   * <p>Method under test: {@link FileGraphLibrary#FileGraphLibrary()}
   */
  @Test
  @DisplayName("Test new FileGraphLibrary()")
  @Tag("MaintainedByDiffblue")
  void testNewFileGraphLibrary() {
    // Arrange, Act and Assert
    assertEquals("graphLibrary", new FileGraphLibrary().getPath());
  }

  /**
   * Test {@link FileGraphLibrary#FileGraphLibrary(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Path is {@code graphLibrary}.
   * </ul>
   *
   * <p>Method under test: {@link FileGraphLibrary#FileGraphLibrary(String)}
   */
  @Test
  @DisplayName("Test new FileGraphLibrary(String); when 'null'; then return Path is 'graphLibrary'")
  @Tag("MaintainedByDiffblue")
  void testNewFileGraphLibrary_whenNull_thenReturnPathIsGraphLibrary() {
    // Arrange, Act and Assert
    assertEquals("graphLibrary", new FileGraphLibrary(null).getPath());
  }

  /**
   * Test {@link FileGraphLibrary#FileGraphLibrary(String)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then return {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link FileGraphLibrary#FileGraphLibrary(String)}
   */
  @Test
  @DisplayName("Test new FileGraphLibrary(String); when 'Path'; then return 'Path'")
  @Tag("MaintainedByDiffblue")
  void testNewFileGraphLibrary_whenPath_thenReturnPath() {
    // Arrange, Act and Assert
    assertEquals("Path", new FileGraphLibrary("Path").getPath());
  }

  /**
   * Test {@link FileGraphLibrary#initialise(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FileGraphLibrary#FileGraphLibrary()} Path is {@code graphLibrary}.
   * </ul>
   *
   * <p>Method under test: {@link FileGraphLibrary#initialise(String)}
   */
  @Test
  @DisplayName(
      "Test initialise(String); when 'null'; then FileGraphLibrary() Path is 'graphLibrary'")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then {@link FileGraphLibrary#FileGraphLibrary()} Path is {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link FileGraphLibrary#initialise(String)}
   */
  @Test
  @DisplayName("Test initialise(String); when 'Path'; then FileGraphLibrary() Path is 'Path'")
  @Tag("MaintainedByDiffblue")
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
   *
   * <p>Method under test: {@link FileGraphLibrary#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  void testGetPath() {
    // Arrange, Act and Assert
    assertEquals("graphLibrary", new FileGraphLibrary().getPath());
  }

  /**
   * Test {@link FileGraphLibrary#setPath(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FileGraphLibrary#FileGraphLibrary()} Path is {@code graphLibrary}.
   * </ul>
   *
   * <p>Method under test: {@link FileGraphLibrary#setPath(String)}
   */
  @Test
  @DisplayName("Test setPath(String); when 'null'; then FileGraphLibrary() Path is 'graphLibrary'")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then {@link FileGraphLibrary#FileGraphLibrary()} Path is {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link FileGraphLibrary#setPath(String)}
   */
  @Test
  @DisplayName("Test setPath(String); when 'Path'; then FileGraphLibrary() Path is 'Path'")
  @Tag("MaintainedByDiffblue")
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
   *
   * <p>Method under test: {@link FileGraphLibrary#getIds(String)}
   */
  @Test
  @DisplayName("Test getIds(String)")
  @Tag("MaintainedByDiffblue")
  void testGetIds() {
    // Arrange, Act and Assert
    assertNull(new FileGraphLibrary().getIds("42"));
  }

  /**
   * Test {@link FileGraphLibrary#_addSchema(String, byte[])}.
   *
   * <ul>
   *   <li>Given {@link FileGraphLibrary#FileGraphLibrary()}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FileGraphLibrary#_addSchema(String, byte[])}
   */
  @Test
  @DisplayName(
      "Test _addSchema(String, byte[]); given FileGraphLibrary(); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void test_addSchema_givenFileGraphLibrary_whenNull_thenThrowIllegalArgumentException()
      throws OverwritingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new FileGraphLibrary()._addSchema("42", null));
  }

  /**
   * Test {@link FileGraphLibrary#_addProperties(String, StoreProperties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FileGraphLibrary#_addProperties(String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test _addProperties(String, StoreProperties); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void test_addProperties_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new FileGraphLibrary()._addProperties("42", null));
  }

  /**
   * Test {@link FileGraphLibrary#_getSchema(String)}.
   *
   * <p>Method under test: {@link FileGraphLibrary#_getSchema(String)}
   */
  @Test
  @DisplayName("Test _getSchema(String)")
  @Tag("MaintainedByDiffblue")
  void test_getSchema() {
    // Arrange, Act and Assert
    assertNull(new FileGraphLibrary()._getSchema("42"));
  }

  /**
   * Test {@link FileGraphLibrary#_getProperties(String)}.
   *
   * <p>Method under test: {@link FileGraphLibrary#_getProperties(String)}
   */
  @Test
  @DisplayName("Test _getProperties(String)")
  @Tag("MaintainedByDiffblue")
  void test_getProperties() {
    // Arrange, Act and Assert
    assertNull(new FileGraphLibrary()._getProperties("42"));
  }
}
