package uk.gov.gchq.gaffer.operation.impl.export.localfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ImportFromLocalFile.Builder;

class ImportFromLocalFileDiffblueTest {
  /**
   * Test Builder {@link Builder#filePath(String)}.
   *
   * <p>Method under test: {@link Builder#filePath(String)}
   */
  @Test
  @DisplayName("Test Builder filePath(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderFilePath() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualFilePathResult = builder.filePath("/directory/foo.txt");

    // Assert
    assertSame(builder, actualFilePathResult);
  }

  /**
   * Test {@link ImportFromLocalFile#getFilePath()}.
   *
   * <p>Method under test: {@link ImportFromLocalFile#getFilePath()}
   */
  @Test
  @DisplayName("Test getFilePath()")
  @Tag("MaintainedByDiffblue")
  void testGetFilePath() {
    // Arrange, Act and Assert
    assertNull(new ImportFromLocalFile().getFilePath());
  }

  /**
   * Test {@link ImportFromLocalFile#setFilePath(String)}.
   *
   * <p>Method under test: {@link ImportFromLocalFile#setFilePath(String)}
   */
  @Test
  @DisplayName("Test setFilePath(String)")
  @Tag("MaintainedByDiffblue")
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ImportFromLocalFile actualImportFromLocalFile = new ImportFromLocalFile();
    actualImportFromLocalFile.setKey("/directory/foo.txt");
    HashMap<String, String> options = new HashMap<>();
    actualImportFromLocalFile.setOptions(options);
    actualImportFromLocalFile.setJobId("42");
    String actualJobId = actualImportFromLocalFile.getJobId();
    String actualKey = actualImportFromLocalFile.getKey();
    Map<String, String> actualOptions = actualImportFromLocalFile.getOptions();

    // Assert
    assertEquals("/directory/foo.txt", actualKey);
    assertNull(actualJobId);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
