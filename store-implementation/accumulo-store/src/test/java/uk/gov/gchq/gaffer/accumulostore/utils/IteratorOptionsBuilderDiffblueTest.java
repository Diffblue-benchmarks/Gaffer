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
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Method under test: {@link IteratorOptionsBuilder#IteratorOptionsBuilder(String, String)}
   */
  @Test
  @DisplayName("Test new IteratorOptionsBuilder(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IteratorOptionsBuilder.<init>(String, String)"})
  void testNewIteratorOptionsBuilder() {
    // Arrange, Act and Assert
    IteratorOptions iteratorOptions =
        new IteratorOptionsBuilder("Name", "The characteristics of someone or something").build();
    assertEquals("Name", iteratorOptions.getName());
    assertEquals("The characteristics of someone or something", iteratorOptions.getDescription());
    assertNull(iteratorOptions.getUnnamedOptionDescriptions());
    assertNull(iteratorOptions.getNamedOptions());
  }

  /**
   * Test {@link IteratorOptionsBuilder#IteratorOptionsBuilder(IteratorOptions)}.
   *
   * <p>Method under test: {@link
   * IteratorOptionsBuilder#IteratorOptionsBuilder(OptionDescriber.IteratorOptions)}
   */
  @Test
  @DisplayName("Test new IteratorOptionsBuilder(IteratorOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IteratorOptionsBuilder.<init>(OptionDescriber.IteratorOptions)"})
  void testNewIteratorOptionsBuilder2() {
    // Arrange
    HashMap<String, String> namedOptions = new HashMap<>();
    IteratorOptions options =
        new IteratorOptions(
            "Name", "The characteristics of someone or something", namedOptions, new ArrayList<>());

    // Act and Assert
    IteratorOptions actualIteratorOptions = new IteratorOptionsBuilder(options).build();
    assertSame(options, actualIteratorOptions);
  }

  /**
   * Test {@link IteratorOptionsBuilder#addNamedOption(String, String)}.
   *
   * <p>Method under test: {@link IteratorOptionsBuilder#addNamedOption(String, String)}
   */
  @Test
  @DisplayName("Test addNamedOption(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorOptionsBuilder IteratorOptionsBuilder.addNamedOption(String, String)"
  })
  void testAddNamedOption() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder =
        new IteratorOptionsBuilder("Name", "The characteristics of someone or something");

    // Act
    IteratorOptionsBuilder actualAddNamedOptionResult =
        iteratorOptionsBuilder.addNamedOption("Option Name", "Option Description");

    // Assert
    assertSame(iteratorOptionsBuilder, actualAddNamedOptionResult);
  }

  /**
   * Test {@link IteratorOptionsBuilder#addViewNamedOption()}.
   *
   * <p>Method under test: {@link IteratorOptionsBuilder#addViewNamedOption()}
   */
  @Test
  @DisplayName("Test addViewNamedOption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorOptionsBuilder IteratorOptionsBuilder.addViewNamedOption()"})
  void testAddViewNamedOption() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder =
        new IteratorOptionsBuilder("Name", "The characteristics of someone or something");

    // Act
    IteratorOptionsBuilder actualAddViewNamedOptionResult =
        iteratorOptionsBuilder.addViewNamedOption();

    // Assert
    assertSame(iteratorOptionsBuilder, actualAddViewNamedOptionResult);
  }

  /**
   * Test {@link IteratorOptionsBuilder#addSchemaNamedOption()}.
   *
   * <p>Method under test: {@link IteratorOptionsBuilder#addSchemaNamedOption()}
   */
  @Test
  @DisplayName("Test addSchemaNamedOption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorOptionsBuilder IteratorOptionsBuilder.addSchemaNamedOption()"})
  void testAddSchemaNamedOption() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder =
        new IteratorOptionsBuilder("Name", "The characteristics of someone or something");

    // Act
    IteratorOptionsBuilder actualAddSchemaNamedOptionResult =
        iteratorOptionsBuilder.addSchemaNamedOption();

    // Assert
    assertSame(iteratorOptionsBuilder, actualAddSchemaNamedOptionResult);
  }

  /**
   * Test {@link IteratorOptionsBuilder#addElementConverterClassNamedOption()}.
   *
   * <p>Method under test: {@link IteratorOptionsBuilder#addElementConverterClassNamedOption()}
   */
  @Test
  @DisplayName("Test addElementConverterClassNamedOption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorOptionsBuilder IteratorOptionsBuilder.addElementConverterClassNamedOption()"
  })
  void testAddElementConverterClassNamedOption() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder =
        new IteratorOptionsBuilder("Name", "The characteristics of someone or something");

    // Act
    IteratorOptionsBuilder actualAddElementConverterClassNamedOptionResult =
        iteratorOptionsBuilder.addElementConverterClassNamedOption();

    // Assert
    assertSame(iteratorOptionsBuilder, actualAddElementConverterClassNamedOptionResult);
  }

  /**
   * Test {@link IteratorOptionsBuilder#setIteratorName(String)}.
   *
   * <p>Method under test: {@link IteratorOptionsBuilder#setIteratorName(String)}
   */
  @Test
  @DisplayName("Test setIteratorName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorOptionsBuilder IteratorOptionsBuilder.setIteratorName(String)"})
  void testSetIteratorName() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder =
        new IteratorOptionsBuilder("Name", "The characteristics of someone or something");

    // Act
    IteratorOptionsBuilder actualSetIteratorNameResult =
        iteratorOptionsBuilder.setIteratorName("Iterator Name");

    // Assert
    assertSame(iteratorOptionsBuilder, actualSetIteratorNameResult);
  }

  /**
   * Test {@link IteratorOptionsBuilder#setIteratorDescription(String)}.
   *
   * <p>Method under test: {@link IteratorOptionsBuilder#setIteratorDescription(String)}
   */
  @Test
  @DisplayName("Test setIteratorDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorOptionsBuilder IteratorOptionsBuilder.setIteratorDescription(String)"
  })
  void testSetIteratorDescription() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder =
        new IteratorOptionsBuilder("Name", "The characteristics of someone or something");

    // Act
    IteratorOptionsBuilder actualSetIteratorDescriptionResult =
        iteratorOptionsBuilder.setIteratorDescription("Iterator Description");

    // Assert
    assertSame(iteratorOptionsBuilder, actualSetIteratorDescriptionResult);
  }

  /**
   * Test {@link IteratorOptionsBuilder#build()}.
   *
   * <p>Method under test: {@link IteratorOptionsBuilder#build()}
   */
  @Test
  @DisplayName("Test build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionDescriber.IteratorOptions IteratorOptionsBuilder.build()"})
  void testBuild() {
    // Arrange and Act
    IteratorOptions actualIteratorOptions =
        new IteratorOptionsBuilder("Name", "The characteristics of someone or something")
            .setIteratorDescription("Iterator Description")
            .setIteratorName("Iterator Name")
            .build();

    // Assert
    assertEquals("Iterator Description", actualIteratorOptions.getDescription());
    assertEquals("Iterator Name", actualIteratorOptions.getName());
    assertNull(actualIteratorOptions.getUnnamedOptionDescriptions());
    assertNull(actualIteratorOptions.getNamedOptions());
  }
}
