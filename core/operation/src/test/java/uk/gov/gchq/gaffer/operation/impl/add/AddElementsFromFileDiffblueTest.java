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

package uk.gov.gchq.gaffer.operation.impl.add;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.add.AddElementsFromFile.Builder;

class AddElementsFromFileDiffblueTest {
  /**
   * Test Builder {@link Builder#filename(String)}.
   * <p>
   * Method under test: {@link Builder#filename(String)}
   */
  @Test
  @DisplayName("Test Builder filename(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.filename(String)"})
  void testBuilderFilename() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.filename("foo.txt"));
  }

  /**
   * Test Builder {@link Builder#generator(Class)}.
   * <p>
   * Method under test: {@link Builder#generator(Class)}
   */
  @Test
  @DisplayName("Test Builder generator(Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.generator(Class)"})
  void testBuilderGenerator() {
    // Arrange
    Builder builder = new Builder();
    Class<Function> forNameResult = Function.class;

    // Act and Assert
    assertSame(builder, builder
        .generator((Class<Function<Iterable<? extends String>, Iterable<? extends Element>>>) (Class) forNameResult));
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
    AddElementsFromFile _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getElementGenerator());
    assertNull(_getOpResult.getParallelism());
    assertNull(_getOpResult.getFilename());
    assertNull(_getOpResult.getOptions());
    assertFalse(_getOpResult.isSkipInvalidElements());
    assertTrue(_getOpResult.isValidate());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Test Builder {@link Builder#parallelism(Integer)}.
   * <p>
   * Method under test: {@link Builder#parallelism(Integer)}
   */
  @Test
  @DisplayName("Test Builder parallelism(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parallelism(Integer)"})
  void testBuilderParallelism() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.parallelism(2));
  }

  /**
   * Test {@link AddElementsFromFile#shallowClone()}.
   * <ul>
   *   <li>Given {@link AddElementsFromFile} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsFromFile#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given AddElementsFromFile (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AddElementsFromFile AddElementsFromFile.shallowClone()"})
  void testShallowClone_givenAddElementsFromFileOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    AddElementsFromFile addElementsFromFile = new AddElementsFromFile();
    addElementsFromFile.setOptions(new HashMap<>());

    // Act
    AddElementsFromFile actualShallowCloneResult = addElementsFromFile.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getElementGenerator());
    assertNull(actualShallowCloneResult.getParallelism());
    assertNull(actualShallowCloneResult.getFilename());
    assertFalse(actualShallowCloneResult.isSkipInvalidElements());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.isValidate());
  }

  /**
   * Test {@link AddElementsFromFile#shallowClone()}.
   * <ul>
   *   <li>Given {@link AddElementsFromFile} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddElementsFromFile#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given AddElementsFromFile (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AddElementsFromFile AddElementsFromFile.shallowClone()"})
  void testShallowClone_givenAddElementsFromFile_thenReturnOptionsIsNull() {
    // Arrange and Act
    AddElementsFromFile actualShallowCloneResult = (new AddElementsFromFile()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getElementGenerator());
    assertNull(actualShallowCloneResult.getParallelism());
    assertNull(actualShallowCloneResult.getFilename());
    assertNull(actualShallowCloneResult.getOptions());
    assertFalse(actualShallowCloneResult.isSkipInvalidElements());
    assertTrue(actualShallowCloneResult.isValidate());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AddElementsFromFile}
   *   <li>{@link AddElementsFromFile#setElementGenerator(Class)}
   *   <li>{@link AddElementsFromFile#setFilename(String)}
   *   <li>{@link AddElementsFromFile#setOptions(Map)}
   *   <li>{@link AddElementsFromFile#setParallelism(Integer)}
   *   <li>{@link AddElementsFromFile#setSkipInvalidElements(boolean)}
   *   <li>{@link AddElementsFromFile#setValidate(boolean)}
   *   <li>{@link AddElementsFromFile#getElementGenerator()}
   *   <li>{@link AddElementsFromFile#getFilename()}
   *   <li>{@link AddElementsFromFile#getOptions()}
   *   <li>{@link AddElementsFromFile#getParallelism()}
   *   <li>{@link AddElementsFromFile#isSkipInvalidElements()}
   *   <li>{@link AddElementsFromFile#isValidate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AddElementsFromFile.<init>()", "Class AddElementsFromFile.getElementGenerator()",
      "String AddElementsFromFile.getFilename()", "Map AddElementsFromFile.getOptions()",
      "Integer AddElementsFromFile.getParallelism()", "boolean AddElementsFromFile.isSkipInvalidElements()",
      "boolean AddElementsFromFile.isValidate()", "void AddElementsFromFile.setElementGenerator(Class)",
      "void AddElementsFromFile.setFilename(String)", "void AddElementsFromFile.setOptions(Map)",
      "void AddElementsFromFile.setParallelism(Integer)", "void AddElementsFromFile.setSkipInvalidElements(boolean)",
      "void AddElementsFromFile.setValidate(boolean)"})
  void testGettersAndSetters() {
    // Arrange and Act
    AddElementsFromFile actualAddElementsFromFile = new AddElementsFromFile();
    Class<Function> forNameResult = Function.class;
    actualAddElementsFromFile.setElementGenerator(
        (Class<Function<Iterable<? extends String>, Iterable<? extends Element>>>) (Class) forNameResult);
    actualAddElementsFromFile.setFilename("foo.txt");
    HashMap<String, String> options = new HashMap<>();
    actualAddElementsFromFile.setOptions(options);
    actualAddElementsFromFile.setParallelism(2);
    actualAddElementsFromFile.setSkipInvalidElements(true);
    actualAddElementsFromFile.setValidate(true);
    Class<? extends Function<Iterable<? extends String>, Iterable<? extends Element>>> actualElementGenerator = actualAddElementsFromFile
        .getElementGenerator();
    String actualFilename = actualAddElementsFromFile.getFilename();
    Map<String, String> actualOptions = actualAddElementsFromFile.getOptions();
    Integer actualParallelism = actualAddElementsFromFile.getParallelism();
    boolean actualIsSkipInvalidElementsResult = actualAddElementsFromFile.isSkipInvalidElements();
    boolean actualIsValidateResult = actualAddElementsFromFile.isValidate();

    // Assert
    assertEquals("foo.txt", actualFilename);
    assertEquals(2, actualParallelism.intValue());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsSkipInvalidElementsResult);
    assertTrue(actualIsValidateResult);
    Class<Function> expectedElementGenerator = Function.class;
    assertEquals(expectedElementGenerator, actualElementGenerator);
    assertSame(options, actualOptions);
    assertSame((Class) forNameResult, actualElementGenerator);
  }
}
