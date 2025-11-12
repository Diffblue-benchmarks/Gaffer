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
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ExportToLocalFileDiffblueTest {
  /**
   * Method under test: {@link ExportToLocalFile.Builder#filePath(String)}
   */
  @Test
  void testBuilderFilePath() {
    // Arrange
    ExportToLocalFile.Builder builder = new ExportToLocalFile.Builder();

    // Act and Assert
    assertSame(builder, builder.filePath("/directory/foo.txt"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ExportToLocalFile.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ExportToLocalFile.Builder actualBuilder = new ExportToLocalFile.Builder();

    // Assert
    ExportToLocalFile _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends String>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableString);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends java.lang.String>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getFilePath());
    assertNull(_getOpResult.getKey());
    assertNull(_getOpResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link ExportToLocalFile#setFilePath(String)}
   */
  @Test
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
   * Method under test: {@link ExportToLocalFile#setFilePath(String)}
   */
  @Test
  void testSetFilePath2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ExportToLocalFile exportToLocalFile = new ExportToLocalFile();
    exportToLocalFile.setOptions(options);

    // Act
    exportToLocalFile.setFilePath("/directory/foo.txt");

    // Assert
    assertEquals("/directory/foo.txt", exportToLocalFile.getKeyOrDefault());
    assertEquals("/directory/foo.txt", exportToLocalFile.getFilePath());
    assertEquals("/directory/foo.txt", exportToLocalFile.getKey());
  }

  /**
   * Method under test: {@link ExportToLocalFile#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    ExportToLocalFile actualShallowCloneResult = (new ExportToLocalFile()).shallowClone();

    // Assert
    TypeReference<Iterable<? extends String>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableString);
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
   * Method under test: {@link ExportToLocalFile#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ExportToLocalFile exportToLocalFile = new ExportToLocalFile();
    exportToLocalFile.setOptions(options);

    // Act
    ExportToLocalFile actualShallowCloneResult = exportToLocalFile.shallowClone();

    // Assert
    TypeReference<Iterable<? extends String>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableString);
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
   * Method under test: {@link ExportToLocalFile#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends String>> actualOutputTypeReference = (new ExportToLocalFile())
        .getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.IterableString);
    assertEquals("java.lang.Iterable<? extends java.lang.String>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link ExportToLocalFile#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    ExportToLocalFile exportToLocalFile = new ExportToLocalFile();
    exportToLocalFile.setOptions(options);

    // Act
    TypeReference<Iterable<? extends String>> actualOutputTypeReference = exportToLocalFile.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.IterableString);
    assertEquals("java.lang.Iterable<? extends java.lang.String>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    ExportToLocalFile actualExportToLocalFile = new ExportToLocalFile();
    ArrayList<String> input = new ArrayList<>();
    actualExportToLocalFile.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualExportToLocalFile.setOptions(options);
    actualExportToLocalFile.setKey("Key");
    actualExportToLocalFile.getFilePath();
    actualExportToLocalFile.getKey();
    Map<String, String> actualOptions = actualExportToLocalFile.getOptions();

    // Assert that nothing has changed
    Iterable<? extends String> input2 = actualExportToLocalFile.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
