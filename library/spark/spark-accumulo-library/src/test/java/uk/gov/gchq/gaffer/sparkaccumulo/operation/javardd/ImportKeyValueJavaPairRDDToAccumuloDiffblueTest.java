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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.javardd;

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
import uk.gov.gchq.gaffer.sparkaccumulo.operation.javardd.ImportKeyValueJavaPairRDDToAccumulo.Builder;

class ImportKeyValueJavaPairRDDToAccumuloDiffblueTest {
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
    ImportKeyValueJavaPairRDDToAccumulo _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getFailurePath());
    assertNull(_getOpResult.getOutputPath());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getInput());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Test Builder {@link Builder#outputPath(String)}.
   * <p>
   * Method under test: {@link Builder#outputPath(String)}
   */
  @Test
  @DisplayName("Test Builder outputPath(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.outputPath(String)"})
  void testBuilderOutputPath() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.outputPath("Output Path"));
  }

  /**
   * Test {@link ImportKeyValueJavaPairRDDToAccumulo#getInput()}.
   * <p>
   * Method under test: {@link ImportKeyValueJavaPairRDDToAccumulo#getInput()}
   */
  @Test
  @DisplayName("Test getInput()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.spark.api.java.JavaPairRDD ImportKeyValueJavaPairRDDToAccumulo.getInput()"})
  void testGetInput() {
    // Arrange, Act and Assert
    assertNull((new ImportKeyValueJavaPairRDDToAccumulo()).getInput());
  }

  /**
   * Test {@link ImportKeyValueJavaPairRDDToAccumulo#shallowClone()}.
   * <ul>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportKeyValueJavaPairRDDToAccumulo#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportKeyValueJavaPairRDDToAccumulo ImportKeyValueJavaPairRDDToAccumulo.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    ImportKeyValueJavaPairRDDToAccumulo importKeyValueJavaPairRDDToAccumulo = new ImportKeyValueJavaPairRDDToAccumulo();
    importKeyValueJavaPairRDDToAccumulo.setOptions(new HashMap<>());

    // Act
    ImportKeyValueJavaPairRDDToAccumulo actualShallowCloneResult = importKeyValueJavaPairRDDToAccumulo.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getFailurePath());
    assertNull(actualShallowCloneResult.getOutputPath());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link ImportKeyValueJavaPairRDDToAccumulo#shallowClone()}.
   * <ul>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportKeyValueJavaPairRDDToAccumulo#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImportKeyValueJavaPairRDDToAccumulo ImportKeyValueJavaPairRDDToAccumulo.shallowClone()"})
  void testShallowClone_thenReturnOptionsIsNull() {
    // Arrange and Act
    ImportKeyValueJavaPairRDDToAccumulo actualShallowCloneResult = (new ImportKeyValueJavaPairRDDToAccumulo())
        .shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getFailurePath());
    assertNull(actualShallowCloneResult.getOutputPath());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getInput());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImportKeyValueJavaPairRDDToAccumulo}
   *   <li>{@link ImportKeyValueJavaPairRDDToAccumulo#setFailurePath(String)}
   *   <li>{@link ImportKeyValueJavaPairRDDToAccumulo#setOptions(Map)}
   *   <li>{@link ImportKeyValueJavaPairRDDToAccumulo#setOutputPath(String)}
   *   <li>{@link ImportKeyValueJavaPairRDDToAccumulo#getFailurePath()}
   *   <li>{@link ImportKeyValueJavaPairRDDToAccumulo#getOptions()}
   *   <li>{@link ImportKeyValueJavaPairRDDToAccumulo#getOutputPath()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImportKeyValueJavaPairRDDToAccumulo.<init>()",
      "String ImportKeyValueJavaPairRDDToAccumulo.getFailurePath()",
      "Map ImportKeyValueJavaPairRDDToAccumulo.getOptions()",
      "String ImportKeyValueJavaPairRDDToAccumulo.getOutputPath()",
      "void ImportKeyValueJavaPairRDDToAccumulo.setFailurePath(String)",
      "void ImportKeyValueJavaPairRDDToAccumulo.setInput(org.apache.spark.api.java.JavaPairRDD)",
      "void ImportKeyValueJavaPairRDDToAccumulo.setOptions(Map)",
      "void ImportKeyValueJavaPairRDDToAccumulo.setOutputPath(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ImportKeyValueJavaPairRDDToAccumulo actualImportKeyValueJavaPairRDDToAccumulo = new ImportKeyValueJavaPairRDDToAccumulo();
    actualImportKeyValueJavaPairRDDToAccumulo.setFailurePath("Failure Path");
    HashMap<String, String> options = new HashMap<>();
    actualImportKeyValueJavaPairRDDToAccumulo.setOptions(options);
    actualImportKeyValueJavaPairRDDToAccumulo.setOutputPath("Output Path");
    String actualFailurePath = actualImportKeyValueJavaPairRDDToAccumulo.getFailurePath();
    Map<String, String> actualOptions = actualImportKeyValueJavaPairRDDToAccumulo.getOptions();

    // Assert
    assertEquals("Failure Path", actualFailurePath);
    assertEquals("Output Path", actualImportKeyValueJavaPairRDDToAccumulo.getOutputPath());
    assertNull(actualImportKeyValueJavaPairRDDToAccumulo.getInput());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
