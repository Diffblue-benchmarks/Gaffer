package uk.gov.gchq.gaffer.operation.impl.export;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.export.GetExport;
import uk.gov.gchq.gaffer.operation.impl.export.GetExports.Builder;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ImportFromLocalFile;

class GetExportsDiffblueTest {
  /**
   * Test Builder {@link Builder#exports(GetExport[])} with {@code GetExport[]}.
   *
   * <p>Method under test: {@link Builder#exports(GetExport[])}
   */
  @Test
  @DisplayName("Test Builder exports(GetExport[]) with 'GetExport[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.exports(GetExport[])"})
  void testBuilderExportsWithGetExport() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualExportsResult = builder.exports(new ImportFromLocalFile());

    // Assert
    assertSame(builder, actualExportsResult);
  }

  /**
   * Test Builder {@link Builder#exports(List)} with {@code List}.
   *
   * <ul>
   *   <li>Then return _getOp GetExports is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#exports(List)}
   */
  @Test
  @DisplayName(
      "Test Builder exports(List) with 'List'; then return _getOp GetExports is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.exports(List)"})
  void testBuilderExportsWithList_thenReturn_getOpGetExportsIsArrayList() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<GetExport> resultExports = new ArrayList<>();
    resultExports.add(new ImportFromLocalFile());

    // Act and Assert
    assertSame(resultExports, builder.exports(resultExports)._getOp().getGetExports());
  }

  /**
   * Test Builder {@link Builder#exports(List)} with {@code List}.
   *
   * <ul>
   *   <li>Then return _getOp GetExports size is two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#exports(List)}
   */
  @Test
  @DisplayName("Test Builder exports(List) with 'List'; then return _getOp GetExports size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.exports(List)"})
  void testBuilderExportsWithList_thenReturn_getOpGetExportsSizeIsTwo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<GetExport> resultExports = new ArrayList<>();
    resultExports.add(new ImportFromLocalFile());
    ImportFromLocalFile importFromLocalFile = new ImportFromLocalFile();
    resultExports.add(importFromLocalFile);

    // Act and Assert
    List<GetExport> getExports = builder.exports(resultExports)._getOp().getGetExports();
    assertEquals(2, getExports.size());
    assertSame(importFromLocalFile, getExports.get(1));
  }

  /**
   * Test Builder {@link Builder#exports(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#exports(List)}
   */
  @Test
  @DisplayName(
      "Test Builder exports(List) with 'List'; when ArrayList(); then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.exports(List)"})
  void testBuilderExportsWithList_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualExportsResult = builder.exports(new ArrayList<>());

    // Assert
    assertSame(builder, actualExportsResult);
  }

  /**
   * Test {@link GetExports#setGetExports(List)}.
   *
   * <ul>
   *   <li>Given {@link ImportFromLocalFile} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link ImportFromLocalFile} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetExports#setGetExports(List)}
   */
  @Test
  @DisplayName(
      "Test setGetExports(List); given ImportFromLocalFile (default constructor); when ArrayList() add ImportFromLocalFile (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetExports.setGetExports(List)"})
  void testSetGetExports_givenImportFromLocalFile_whenArrayListAddImportFromLocalFile() {
    // Arrange
    GetExports getExports = new GetExports();

    ArrayList<GetExport> getExports2 = new ArrayList<>();
    getExports2.add(new ImportFromLocalFile());

    // Act
    getExports.setGetExports(getExports2);

    // Assert
    assertSame(getExports2, getExports.getGetExports());
  }

  /**
   * Test {@link GetExports#setGetExports(List)}.
   *
   * <ul>
   *   <li>Given {@link ImportFromLocalFile} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link ImportFromLocalFile} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetExports#setGetExports(List)}
   */
  @Test
  @DisplayName(
      "Test setGetExports(List); given ImportFromLocalFile (default constructor); when ArrayList() add ImportFromLocalFile (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetExports.setGetExports(List)"})
  void testSetGetExports_givenImportFromLocalFile_whenArrayListAddImportFromLocalFile2() {
    // Arrange
    GetExports getExports = new GetExports();

    ArrayList<GetExport> getExports2 = new ArrayList<>();
    getExports2.add(new ImportFromLocalFile());
    getExports2.add(new ImportFromLocalFile());

    // Act
    getExports.setGetExports(getExports2);

    // Assert
    assertSame(getExports2, getExports.getGetExports());
  }

  /**
   * Test {@link GetExports#setGetExports(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GetExports#setGetExports(List)}
   */
  @Test
  @DisplayName("Test setGetExports(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetExports.setGetExports(List)"})
  void testSetGetExports_whenArrayList() {
    // Arrange
    GetExports getExports = new GetExports();
    ArrayList<GetExport> getExports2 = new ArrayList<>();

    // Act
    getExports.setGetExports(getExports2);

    // Assert
    assertSame(getExports2, getExports.getGetExports());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetExports}
   *   <li>{@link GetExports#setOptions(Map)}
   *   <li>{@link GetExports#getGetExports()}
   *   <li>{@link GetExports#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetExports.<init>()",
    "List GetExports.getGetExports()",
    "Map GetExports.getOptions()",
    "void GetExports.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetExports actualGetExports = new GetExports();
    HashMap<String, String> options = new HashMap<>();
    actualGetExports.setOptions(options);
    List<GetExport> actualGetExports2 = actualGetExports.getGetExports();
    Map<String, String> actualOptions = actualGetExports.getOptions();

    // Assert
    assertTrue(actualGetExports2.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
