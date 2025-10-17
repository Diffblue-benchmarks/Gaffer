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

package uk.gov.gchq.gaffer.operation.impl.export.localfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ExportToLocalFile.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableString;

class ExportToLocalFileDiffblueTest {
  /**
   * Test Builder {@link Builder#filePath(String)}.
   *
   * <p>Method under test: {@link Builder#filePath(String)}
   */
  @Test
  @DisplayName("Test Builder filePath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.filePath(String)"})
  void testBuilderFilePath() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualFilePathResult = builder.filePath("/directory/foo.txt");

    // Assert
    assertSame(builder, actualFilePathResult);
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
    ExportToLocalFile _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends String>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableString);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends java.lang.String>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getFilePath());
    assertNull(_getOpResult.getKey());
    assertNull(_getOpResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    ExportToLocalFile actualExportToLocalFile = actualBuilder.build();
    assertSame(_getOpResult, actualExportToLocalFile);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ExportToLocalFile#setFilePath(String)}.
   *
   * <p>Method under test: {@link ExportToLocalFile#setFilePath(String)}
   */
  @Test
  @DisplayName("Test setFilePath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExportToLocalFile.setFilePath(String)"})
  void testSetFilePath() {
    // Arrange
    ExportToLocalFile exportToLocalFile = new ExportToLocalFile();

    // Act
    exportToLocalFile.setFilePath("/directory/foo.txt");

    // Assert
    assertEquals("/directory/foo.txt", exportToLocalFile.getKeyOrDefault());
    assertEquals("/directory/foo.txt", exportToLocalFile.getFilePath());
    assertEquals("/directory/foo.txt", exportToLocalFile.getKey());
  }

  /**
   * Test {@link ExportToLocalFile#shallowClone()}.
   *
   * <p>Method under test: {@link ExportToLocalFile#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExportToLocalFile ExportToLocalFile.shallowClone()"})
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    ExportToLocalFile actualShallowCloneResult = new ExportToLocalFile().shallowClone();

    // Assert
    TypeReference<Iterable<? extends String>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableString);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends java.lang.String>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getFilePath());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ExportToLocalFile#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExportToLocalFile#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ExportToLocalFile.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ExportToLocalFile().getInput());
  }

  /**
   * Test {@link ExportToLocalFile#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ExportToLocalFile#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference ExportToLocalFile.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends String>> actualOutputTypeReference =
        new ExportToLocalFile().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableString);
    assertEquals(
        "java.lang.Iterable<? extends java.lang.String>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToLocalFile}
   *   <li>{@link ExportToLocalFile#setInput(Iterable)}
   *   <li>{@link ExportToLocalFile#setOptions(Map)}
   *   <li>{@link ExportToLocalFile#setKey(String)}
   *   <li>{@link ExportToLocalFile#getFilePath()}
   *   <li>{@link ExportToLocalFile#getKey()}
   *   <li>{@link ExportToLocalFile#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExportToLocalFile.<init>()",
    "String ExportToLocalFile.getFilePath()",
    "String ExportToLocalFile.getKey()",
    "Map ExportToLocalFile.getOptions()",
    "void ExportToLocalFile.setInput(Iterable)",
    "void ExportToLocalFile.setKey(String)",
    "void ExportToLocalFile.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ExportToLocalFile actualExportToLocalFile = new ExportToLocalFile();
    ArrayList<String> input = new ArrayList<>();
    actualExportToLocalFile.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualExportToLocalFile.setOptions(options);
    actualExportToLocalFile.setKey("Key");
    String actualFilePath = actualExportToLocalFile.getFilePath();
    String actualKey = actualExportToLocalFile.getKey();
    Map<String, String> actualOptions = actualExportToLocalFile.getOptions();

    // Assert
    Iterable<? extends String> input2 = actualExportToLocalFile.getInput();
    assertTrue(input2 instanceof List);
    assertNull(actualFilePath);
    assertNull(actualKey);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
