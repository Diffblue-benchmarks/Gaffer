/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.operation.impl;

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
import uk.gov.gchq.gaffer.operation.impl.SplitStoreFromFile.Builder;

class SplitStoreFromFileDiffblueTest {
  /**
   * Test Builder {@link Builder#inputPath(String)}.
   *
   * <p>Method under test: {@link Builder#inputPath(String)}
   */
  @Test
  @DisplayName("Test Builder inputPath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inputPath(String)"})
  void testBuilderInputPath() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputPathResult = builder.inputPath("Input Path");

    // Assert
    assertSame(builder, actualInputPathResult);
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
    SplitStoreFromFile _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getInputPath());
    assertNull(_getOpResult.getOptions());
    SplitStoreFromFile actualSplitStoreFromFile = actualBuilder.build();
    assertSame(_getOpResult, actualSplitStoreFromFile);
  }

  /**
   * Test {@link SplitStoreFromFile#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromFile} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromFile#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given SplitStoreFromFile (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SplitStoreFromFile SplitStoreFromFile.shallowClone()"})
  void testShallowClone_givenSplitStoreFromFileOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    SplitStoreFromFile splitStoreFromFile = new SplitStoreFromFile();
    splitStoreFromFile.setOptions(new HashMap<>());

    // Act
    SplitStoreFromFile actualShallowCloneResult = splitStoreFromFile.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInputPath());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link SplitStoreFromFile#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromFile} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromFile#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given SplitStoreFromFile (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SplitStoreFromFile SplitStoreFromFile.shallowClone()"})
  void testShallowClone_givenSplitStoreFromFile_thenReturnOptionsIsNull() {
    // Arrange and Act
    SplitStoreFromFile actualShallowCloneResult = new SplitStoreFromFile().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInputPath());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SplitStoreFromFile}
   *   <li>{@link SplitStoreFromFile#setInputPath(String)}
   *   <li>{@link SplitStoreFromFile#setOptions(Map)}
   *   <li>{@link SplitStoreFromFile#getInputPath()}
   *   <li>{@link SplitStoreFromFile#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SplitStoreFromFile.<init>()",
    "String SplitStoreFromFile.getInputPath()",
    "Map SplitStoreFromFile.getOptions()",
    "void SplitStoreFromFile.setInputPath(String)",
    "void SplitStoreFromFile.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SplitStoreFromFile actualSplitStoreFromFile = new SplitStoreFromFile();
    actualSplitStoreFromFile.setInputPath("Input Path");
    HashMap<String, String> options = new HashMap<>();
    actualSplitStoreFromFile.setOptions(options);
    String actualInputPath = actualSplitStoreFromFile.getInputPath();
    Map<String, String> actualOptions = actualSplitStoreFromFile.getOptions();

    // Assert
    assertEquals("Input Path", actualInputPath);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
