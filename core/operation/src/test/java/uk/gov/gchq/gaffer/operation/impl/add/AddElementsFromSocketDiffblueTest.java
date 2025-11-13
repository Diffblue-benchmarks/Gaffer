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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.add.AddElementsFromSocket.Builder;

class AddElementsFromSocketDiffblueTest {
  /**
   * Test Builder {@link Builder#delimiter(String)}.
   *
   * <p>Method under test: {@link Builder#delimiter(String)}
   */
  @Test
  @DisplayName("Test Builder delimiter(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.delimiter(String)"})
  void testBuilderDelimiter() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDelimiterResult = builder.delimiter("Delimiter");

    // Assert
    assertSame(builder, actualDelimiterResult);
  }

  /**
   * Test Builder {@link Builder#generator(Class)}.
   *
   * <p>Method under test: {@link Builder#generator(Class)}
   */
  @Test
  @DisplayName("Test Builder generator(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.generator(Class)"})
  void testBuilderGenerator() {
    // Arrange
    Builder builder = new Builder();
    Class<Function> forNameResult = Function.class;

    // Act
    Builder actualGeneratorResult =
        builder.generator(
            (Class<Function<Iterable<? extends String>, Iterable<? extends Element>>>)
                (Class) forNameResult);

    // Assert
    assertSame(builder, actualGeneratorResult);
  }

  /**
   * Test Builder {@link Builder#hostname(String)}.
   *
   * <p>Method under test: {@link Builder#hostname(String)}
   */
  @Test
  @DisplayName("Test Builder hostname(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.hostname(String)"})
  void testBuilderHostname() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualHostnameResult = builder.hostname("localhost");

    // Assert
    assertSame(builder, actualHostnameResult);
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
    AddElementsFromSocket _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getElementGenerator());
    assertNull(_getOpResult.getParallelism());
    assertNull(_getOpResult.getHostname());
    assertNull(_getOpResult.getOptions());
    assertEquals(0, _getOpResult.getPort());
    assertFalse(_getOpResult.isSkipInvalidElements());
    assertTrue(_getOpResult.isValidate());
    assertEquals(AddElementsFromSocket.DEFAULT_DELIMITER, _getOpResult.getDelimiter());
    AddElementsFromSocket actualAddElementsFromSocket = actualBuilder.build();
    assertSame(_getOpResult, actualAddElementsFromSocket);
  }

  /**
   * Test Builder {@link Builder#parallelism(Integer)}.
   *
   * <p>Method under test: {@link Builder#parallelism(Integer)}
   */
  @Test
  @DisplayName("Test Builder parallelism(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parallelism(Integer)"})
  void testBuilderParallelism() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualParallelismResult = builder.parallelism(2);

    // Assert
    assertSame(builder, actualParallelismResult);
  }

  /**
   * Test Builder {@link Builder#port(int)}.
   *
   * <p>Method under test: {@link Builder#port(int)}
   */
  @Test
  @DisplayName("Test Builder port(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.port(int)"})
  void testBuilderPort() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPortResult = builder.port(8080);

    // Assert
    assertSame(builder, actualPortResult);
  }

  /**
   * Test {@link AddElementsFromSocket#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddElementsFromSocket} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromSocket#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddElementsFromSocket (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddElementsFromSocket AddElementsFromSocket.shallowClone()"})
  void testShallowClone_givenAddElementsFromSocket_thenReturnOptionsIsNull() {
    // Arrange and Act
    AddElementsFromSocket actualShallowCloneResult = new AddElementsFromSocket().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getElementGenerator());
    assertNull(actualShallowCloneResult.getParallelism());
    assertNull(actualShallowCloneResult.getHostname());
    assertNull(actualShallowCloneResult.getOptions());
    assertEquals(0, actualShallowCloneResult.getPort());
    assertFalse(actualShallowCloneResult.isSkipInvalidElements());
    assertTrue(actualShallowCloneResult.isValidate());
    assertEquals(AddElementsFromSocket.DEFAULT_DELIMITER, actualShallowCloneResult.getDelimiter());
  }

  /**
   * Test {@link AddElementsFromSocket#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromSocket#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddElementsFromSocket AddElementsFromSocket.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    AddElementsFromSocket addElementsFromSocket = new AddElementsFromSocket();
    addElementsFromSocket.setOptions(new HashMap<>());

    // Act
    AddElementsFromSocket actualShallowCloneResult = addElementsFromSocket.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getElementGenerator());
    assertNull(actualShallowCloneResult.getParallelism());
    assertNull(actualShallowCloneResult.getHostname());
    assertEquals(0, actualShallowCloneResult.getPort());
    assertFalse(actualShallowCloneResult.isSkipInvalidElements());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.isValidate());
    assertEquals(AddElementsFromSocket.DEFAULT_DELIMITER, actualShallowCloneResult.getDelimiter());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AddElementsFromSocket}
   *   <li>{@link AddElementsFromSocket#setDelimiter(String)}
   *   <li>{@link AddElementsFromSocket#setElementGenerator(Class)}
   *   <li>{@link AddElementsFromSocket#setHostname(String)}
   *   <li>{@link AddElementsFromSocket#setOptions(Map)}
   *   <li>{@link AddElementsFromSocket#setParallelism(Integer)}
   *   <li>{@link AddElementsFromSocket#setPort(int)}
   *   <li>{@link AddElementsFromSocket#setSkipInvalidElements(boolean)}
   *   <li>{@link AddElementsFromSocket#setValidate(boolean)}
   *   <li>{@link AddElementsFromSocket#getDelimiter()}
   *   <li>{@link AddElementsFromSocket#getElementGenerator()}
   *   <li>{@link AddElementsFromSocket#getHostname()}
   *   <li>{@link AddElementsFromSocket#getOptions()}
   *   <li>{@link AddElementsFromSocket#getParallelism()}
   *   <li>{@link AddElementsFromSocket#getPort()}
   *   <li>{@link AddElementsFromSocket#isSkipInvalidElements()}
   *   <li>{@link AddElementsFromSocket#isValidate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddElementsFromSocket.<init>()",
    "String AddElementsFromSocket.getDelimiter()",
    "Class AddElementsFromSocket.getElementGenerator()",
    "String AddElementsFromSocket.getHostname()",
    "Map AddElementsFromSocket.getOptions()",
    "Integer AddElementsFromSocket.getParallelism()",
    "int AddElementsFromSocket.getPort()",
    "boolean AddElementsFromSocket.isSkipInvalidElements()",
    "boolean AddElementsFromSocket.isValidate()",
    "void AddElementsFromSocket.setDelimiter(String)",
    "void AddElementsFromSocket.setElementGenerator(Class)",
    "void AddElementsFromSocket.setHostname(String)",
    "void AddElementsFromSocket.setOptions(Map)",
    "void AddElementsFromSocket.setParallelism(Integer)",
    "void AddElementsFromSocket.setPort(int)",
    "void AddElementsFromSocket.setSkipInvalidElements(boolean)",
    "void AddElementsFromSocket.setValidate(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AddElementsFromSocket actualAddElementsFromSocket = new AddElementsFromSocket();
    actualAddElementsFromSocket.setDelimiter("Delimiter");
    Class<Function> forNameResult = Function.class;
    actualAddElementsFromSocket.setElementGenerator(
        (Class<Function<Iterable<? extends String>, Iterable<? extends Element>>>)
            (Class) forNameResult);
    actualAddElementsFromSocket.setHostname("localhost");
    HashMap<String, String> options = new HashMap<>();
    actualAddElementsFromSocket.setOptions(options);
    actualAddElementsFromSocket.setParallelism(2);
    actualAddElementsFromSocket.setPort(8080);
    actualAddElementsFromSocket.setSkipInvalidElements(true);
    actualAddElementsFromSocket.setValidate(true);
    String actualDelimiter = actualAddElementsFromSocket.getDelimiter();
    Class<? extends Function<Iterable<? extends String>, Iterable<? extends Element>>>
        actualElementGenerator = actualAddElementsFromSocket.getElementGenerator();
    String actualHostname = actualAddElementsFromSocket.getHostname();
    Map<String, String> actualOptions = actualAddElementsFromSocket.getOptions();
    Integer actualParallelism = actualAddElementsFromSocket.getParallelism();
    int actualPort = actualAddElementsFromSocket.getPort();
    boolean actualIsSkipInvalidElementsResult = actualAddElementsFromSocket.isSkipInvalidElements();
    boolean actualIsValidateResult = actualAddElementsFromSocket.isValidate();

    // Assert
    assertEquals("Delimiter", actualDelimiter);
    assertEquals("localhost", actualHostname);
    assertEquals(2, actualParallelism.intValue());
    assertEquals(8080, actualPort);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsSkipInvalidElementsResult);
    assertTrue(actualIsValidateResult);
    Class<Function> expectedElementGenerator = Function.class;
    assertEquals(expectedElementGenerator, actualElementGenerator);
    assertSame(options, actualOptions);
  }
}
