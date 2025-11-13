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

package uk.gov.gchq.gaffer.accumulostore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.OptionDescriber.IteratorOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IteratorOptionsBuilderDiffblueTest {
  /**
   * Test {@link IteratorOptionsBuilder#IteratorOptionsBuilder(String, String)}.
   * <p>
   * Method under test: {@link IteratorOptionsBuilder#IteratorOptionsBuilder(String, String)}
   */
  @Test
  @DisplayName("Test new IteratorOptionsBuilder(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IteratorOptionsBuilder.<init>(String, String)"})
  void testNewIteratorOptionsBuilder() {
    // Arrange, Act and Assert
    IteratorOptions buildResult = (new IteratorOptionsBuilder("Name", "The characteristics of someone or something"))
        .build();
    assertEquals("Name", buildResult.getName());
    assertEquals("The characteristics of someone or something", buildResult.getDescription());
    assertNull(buildResult.getUnnamedOptionDescriptions());
    assertNull(buildResult.getNamedOptions());
  }

  /**
   * Test {@link IteratorOptionsBuilder#IteratorOptionsBuilder(IteratorOptions)}.
   * <p>
   * Method under test: {@link IteratorOptionsBuilder#IteratorOptionsBuilder(OptionDescriber.IteratorOptions)}
   */
  @Test
  @DisplayName("Test new IteratorOptionsBuilder(IteratorOptions)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IteratorOptionsBuilder.<init>(OptionDescriber.IteratorOptions)"})
  void testNewIteratorOptionsBuilder2() {
    // Arrange
    HashMap<String, String> namedOptions = new HashMap<>();
    IteratorOptions options = new IteratorOptions("Name", "The characteristics of someone or something", namedOptions,
        new ArrayList<>());

    // Act and Assert
    assertSame(options, (new IteratorOptionsBuilder(options)).build());
  }

  /**
   * Test {@link IteratorOptionsBuilder#addNamedOption(String, String)}.
   * <p>
   * Method under test: {@link IteratorOptionsBuilder#addNamedOption(String, String)}
   */
  @Test
  @DisplayName("Test addNamedOption(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorOptionsBuilder IteratorOptionsBuilder.addNamedOption(String, String)"})
  void testAddNamedOption() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder = new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something");

    // Act and Assert
    assertSame(iteratorOptionsBuilder, iteratorOptionsBuilder.addNamedOption("Option Name", "Option Description"));
  }

  /**
   * Test {@link IteratorOptionsBuilder#addViewNamedOption()}.
   * <p>
   * Method under test: {@link IteratorOptionsBuilder#addViewNamedOption()}
   */
  @Test
  @DisplayName("Test addViewNamedOption()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorOptionsBuilder IteratorOptionsBuilder.addViewNamedOption()"})
  void testAddViewNamedOption() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder = new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something");

    // Act and Assert
    assertSame(iteratorOptionsBuilder, iteratorOptionsBuilder.addViewNamedOption());
  }

  /**
   * Test {@link IteratorOptionsBuilder#addSchemaNamedOption()}.
   * <p>
   * Method under test: {@link IteratorOptionsBuilder#addSchemaNamedOption()}
   */
  @Test
  @DisplayName("Test addSchemaNamedOption()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorOptionsBuilder IteratorOptionsBuilder.addSchemaNamedOption()"})
  void testAddSchemaNamedOption() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder = new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something");

    // Act and Assert
    assertSame(iteratorOptionsBuilder, iteratorOptionsBuilder.addSchemaNamedOption());
  }

  /**
   * Test {@link IteratorOptionsBuilder#addElementConverterClassNamedOption()}.
   * <p>
   * Method under test: {@link IteratorOptionsBuilder#addElementConverterClassNamedOption()}
   */
  @Test
  @DisplayName("Test addElementConverterClassNamedOption()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorOptionsBuilder IteratorOptionsBuilder.addElementConverterClassNamedOption()"})
  void testAddElementConverterClassNamedOption() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder = new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something");

    // Act and Assert
    assertSame(iteratorOptionsBuilder, iteratorOptionsBuilder.addElementConverterClassNamedOption());
  }

  /**
   * Test {@link IteratorOptionsBuilder#setIteratorName(String)}.
   * <p>
   * Method under test: {@link IteratorOptionsBuilder#setIteratorName(String)}
   */
  @Test
  @DisplayName("Test setIteratorName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorOptionsBuilder IteratorOptionsBuilder.setIteratorName(String)"})
  void testSetIteratorName() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder = new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something");

    // Act and Assert
    assertSame(iteratorOptionsBuilder, iteratorOptionsBuilder.setIteratorName("Iterator Name"));
  }

  /**
   * Test {@link IteratorOptionsBuilder#setIteratorDescription(String)}.
   * <p>
   * Method under test: {@link IteratorOptionsBuilder#setIteratorDescription(String)}
   */
  @Test
  @DisplayName("Test setIteratorDescription(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorOptionsBuilder IteratorOptionsBuilder.setIteratorDescription(String)"})
  void testSetIteratorDescription() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder = new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something");

    // Act and Assert
    assertSame(iteratorOptionsBuilder, iteratorOptionsBuilder.setIteratorDescription("Iterator Description"));
  }

  /**
   * Test {@link IteratorOptionsBuilder#build()}.
   * <p>
   * Method under test: {@link IteratorOptionsBuilder#build()}
   */
  @Test
  @DisplayName("Test build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OptionDescriber.IteratorOptions IteratorOptionsBuilder.build()"})
  void testBuild() {
    // Arrange and Act
    IteratorOptions actualBuildResult = (new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something")).setIteratorDescription("Iterator Description")
            .setIteratorName("Iterator Name")
            .build();

    // Assert
    assertEquals("Iterator Description", actualBuildResult.getDescription());
    assertEquals("Iterator Name", actualBuildResult.getName());
    assertNull(actualBuildResult.getUnnamedOptionDescriptions());
    assertNull(actualBuildResult.getNamedOptions());
  }
}
