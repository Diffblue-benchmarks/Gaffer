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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.scalardd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.scalardd.ImportKeyValuePairRDDToAccumulo.Builder;

class ImportKeyValuePairRDDToAccumuloDiffblueTest {
  /**
   * Test Builder {@link Builder#failurePath(String)}.
   *
   * <p>Method under test: {@link Builder#failurePath(String)}
   */
  @Test
  @DisplayName("Test Builder failurePath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.failurePath(String)"})
  void testBuilderFailurePath() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualFailurePathResult = builder.failurePath("Failure Path");

    // Assert
    assertSame(builder, actualFailurePathResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    ImportKeyValuePairRDDToAccumulo _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getFailurePath());
    assertNull(_getOpResult.getOutputPath());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getInput());
    ImportKeyValuePairRDDToAccumulo actualImportKeyValuePairRDDToAccumulo = actualBuilder.build();
    assertSame(_getOpResult, actualImportKeyValuePairRDDToAccumulo);
  }

  /**
   * Test Builder {@link Builder#outputPath(String)}.
   *
   * <p>Method under test: {@link Builder#outputPath(String)}
   */
  @Test
  @DisplayName("Test Builder outputPath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.outputPath(String)"})
  void testBuilderOutputPath() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOutputPathResult = builder.outputPath("Output Path");

    // Assert
    assertSame(builder, actualOutputPathResult);
  }

  /**
   * Test {@link ImportKeyValuePairRDDToAccumulo#getInput()}.
   *
   * <p>Method under test: {@link ImportKeyValuePairRDDToAccumulo#getInput()}
   */
  @Test
  @DisplayName("Test getInput()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.spark.rdd.RDD ImportKeyValuePairRDDToAccumulo.getInput()"})
  void testGetInput() {
    // Arrange, Act and Assert
    assertNull(new ImportKeyValuePairRDDToAccumulo().getInput());
  }

  /**
   * Test {@link ImportKeyValuePairRDDToAccumulo#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ImportKeyValuePairRDDToAccumulo} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImportKeyValuePairRDDToAccumulo#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ImportKeyValuePairRDDToAccumulo (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImportKeyValuePairRDDToAccumulo ImportKeyValuePairRDDToAccumulo.shallowClone()"
  })
  void testShallowClone_givenImportKeyValuePairRDDToAccumulo_thenReturnOptionsIsNull() {
    // Arrange and Act
    ImportKeyValuePairRDDToAccumulo actualShallowCloneResult =
        new ImportKeyValuePairRDDToAccumulo().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getFailurePath());
    assertNull(actualShallowCloneResult.getOutputPath());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getInput());
  }

  /**
   * Test {@link ImportKeyValuePairRDDToAccumulo#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImportKeyValuePairRDDToAccumulo#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImportKeyValuePairRDDToAccumulo ImportKeyValuePairRDDToAccumulo.shallowClone()"
  })
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    ImportKeyValuePairRDDToAccumulo importKeyValuePairRDDToAccumulo =
        new ImportKeyValuePairRDDToAccumulo();
    importKeyValuePairRDDToAccumulo.setOptions(new HashMap<>());

    // Act
    ImportKeyValuePairRDDToAccumulo actualShallowCloneResult =
        importKeyValuePairRDDToAccumulo.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getFailurePath());
    assertNull(actualShallowCloneResult.getOutputPath());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ImportKeyValuePairRDDToAccumulo}
   *   <li>{@link ImportKeyValuePairRDDToAccumulo#setFailurePath(String)}
   *   <li>{@link ImportKeyValuePairRDDToAccumulo#setOptions(Map)}
   *   <li>{@link ImportKeyValuePairRDDToAccumulo#setOutputPath(String)}
   *   <li>{@link ImportKeyValuePairRDDToAccumulo#getFailurePath()}
   *   <li>{@link ImportKeyValuePairRDDToAccumulo#getOptions()}
   *   <li>{@link ImportKeyValuePairRDDToAccumulo#getOutputPath()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImportKeyValuePairRDDToAccumulo.<init>()",
    "String ImportKeyValuePairRDDToAccumulo.getFailurePath()",
    "Map ImportKeyValuePairRDDToAccumulo.getOptions()",
    "String ImportKeyValuePairRDDToAccumulo.getOutputPath()",
    "void ImportKeyValuePairRDDToAccumulo.setFailurePath(String)",
    "void ImportKeyValuePairRDDToAccumulo.setInput(org.apache.spark.rdd.RDD)",
    "void ImportKeyValuePairRDDToAccumulo.setOptions(Map)",
    "void ImportKeyValuePairRDDToAccumulo.setOutputPath(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ImportKeyValuePairRDDToAccumulo actualImportKeyValuePairRDDToAccumulo =
        new ImportKeyValuePairRDDToAccumulo();
    actualImportKeyValuePairRDDToAccumulo.setFailurePath("Failure Path");
    HashMap<String, String> options = new HashMap<>();
    actualImportKeyValuePairRDDToAccumulo.setOptions(options);
    actualImportKeyValuePairRDDToAccumulo.setOutputPath("Output Path");
    String actualFailurePath = actualImportKeyValuePairRDDToAccumulo.getFailurePath();
    Map<String, String> actualOptions = actualImportKeyValuePairRDDToAccumulo.getOptions();

    // Assert
    assertEquals("Failure Path", actualFailurePath);
    assertEquals("Output Path", actualImportKeyValuePairRDDToAccumulo.getOutputPath());
    assertNull(actualImportKeyValuePairRDDToAccumulo.getInput());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
