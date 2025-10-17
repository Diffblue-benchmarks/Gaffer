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

package uk.gov.gchq.gaffer.spark.operation.javardd;

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
import uk.gov.gchq.gaffer.spark.operation.javardd.ImportJavaRDDOfElements.Builder;

class ImportJavaRDDOfElementsDiffblueTest {
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
    ImportJavaRDDOfElements _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getInput());
    ImportJavaRDDOfElements actualImportJavaRDDOfElements = actualBuilder.build();
    assertSame(_getOpResult, actualImportJavaRDDOfElements);
  }

  /**
   * Test {@link ImportJavaRDDOfElements#getInput()}.
   *
   * <p>Method under test: {@link ImportJavaRDDOfElements#getInput()}
   */
  @Test
  @DisplayName("Test getInput()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.spark.api.java.JavaRDD ImportJavaRDDOfElements.getInput()"})
  void testGetInput() {
    // Arrange, Act and Assert
    assertNull(new ImportJavaRDDOfElements().getInput());
  }

  /**
   * Test {@link ImportJavaRDDOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ImportJavaRDDOfElements} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImportJavaRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ImportJavaRDDOfElements (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImportJavaRDDOfElements ImportJavaRDDOfElements.shallowClone()"})
  void testShallowClone_givenImportJavaRDDOfElements_thenReturnOptionsIsNull() {
    // Arrange and Act
    ImportJavaRDDOfElements actualShallowCloneResult = new ImportJavaRDDOfElements().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getInput());
  }

  /**
   * Test {@link ImportJavaRDDOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImportJavaRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImportJavaRDDOfElements ImportJavaRDDOfElements.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    ImportJavaRDDOfElements importJavaRDDOfElements = new ImportJavaRDDOfElements();
    importJavaRDDOfElements.setOptions(new HashMap<>());

    // Act
    ImportJavaRDDOfElements actualShallowCloneResult = importJavaRDDOfElements.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ImportJavaRDDOfElements}
   *   <li>{@link ImportJavaRDDOfElements#setOptions(Map)}
   *   <li>{@link ImportJavaRDDOfElements#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImportJavaRDDOfElements.<init>()",
    "Map ImportJavaRDDOfElements.getOptions()",
    "void ImportJavaRDDOfElements.setInput(org.apache.spark.api.java.JavaRDD)",
    "void ImportJavaRDDOfElements.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ImportJavaRDDOfElements actualImportJavaRDDOfElements = new ImportJavaRDDOfElements();
    HashMap<String, String> options = new HashMap<>();
    actualImportJavaRDDOfElements.setOptions(options);
    Map<String, String> actualOptions = actualImportJavaRDDOfElements.getOptions();

    // Assert
    assertNull(actualImportJavaRDDOfElements.getInput());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
