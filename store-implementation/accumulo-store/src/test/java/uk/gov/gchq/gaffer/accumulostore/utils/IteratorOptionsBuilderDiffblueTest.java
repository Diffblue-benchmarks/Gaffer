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
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.junit.jupiter.api.Test;

class IteratorOptionsBuilderDiffblueTest {
  /**
   * Method under test:
   * {@link IteratorOptionsBuilder#addNamedOption(String, String)}
   */
  @Test
  void testAddNamedOption() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder = new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something");

    // Act and Assert
    assertSame(iteratorOptionsBuilder, iteratorOptionsBuilder.addNamedOption("Option Name", "Option Description"));
  }

  /**
   * Method under test: {@link IteratorOptionsBuilder#addViewNamedOption()}
   */
  @Test
  void testAddViewNamedOption() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder = new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something");

    // Act and Assert
    assertSame(iteratorOptionsBuilder, iteratorOptionsBuilder.addViewNamedOption());
  }

  /**
   * Method under test: {@link IteratorOptionsBuilder#addSchemaNamedOption()}
   */
  @Test
  void testAddSchemaNamedOption() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder = new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something");

    // Act and Assert
    assertSame(iteratorOptionsBuilder, iteratorOptionsBuilder.addSchemaNamedOption());
  }

  /**
   * Method under test:
   * {@link IteratorOptionsBuilder#addElementConverterClassNamedOption()}
   */
  @Test
  void testAddElementConverterClassNamedOption() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder = new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something");

    // Act and Assert
    assertSame(iteratorOptionsBuilder, iteratorOptionsBuilder.addElementConverterClassNamedOption());
  }

  /**
   * Method under test: {@link IteratorOptionsBuilder#setIteratorName(String)}
   */
  @Test
  void testSetIteratorName() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder = new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something");

    // Act and Assert
    assertSame(iteratorOptionsBuilder, iteratorOptionsBuilder.setIteratorName("Iterator Name"));
  }

  /**
   * Method under test:
   * {@link IteratorOptionsBuilder#setIteratorDescription(String)}
   */
  @Test
  void testSetIteratorDescription() {
    // Arrange
    IteratorOptionsBuilder iteratorOptionsBuilder = new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something");

    // Act and Assert
    assertSame(iteratorOptionsBuilder, iteratorOptionsBuilder.setIteratorDescription("Iterator Description"));
  }

  /**
   * Method under test: {@link IteratorOptionsBuilder#build()}
   */
  @Test
  void testBuild() {
    // Arrange and Act
    OptionDescriber.IteratorOptions actualBuildResult = (new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something")).setIteratorDescription("Iterator Description")
            .setIteratorName("Iterator Name")
            .build();

    // Assert
    assertEquals("Iterator Description", actualBuildResult.getDescription());
    assertEquals("Iterator Name", actualBuildResult.getName());
    assertNull(actualBuildResult.getUnnamedOptionDescriptions());
    assertNull(actualBuildResult.getNamedOptions());
  }

  /**
   * Method under test:
   * {@link IteratorOptionsBuilder#IteratorOptionsBuilder(String, String)}
   */
  @Test
  void testNewIteratorOptionsBuilder() {
    // Arrange, Act and Assert
    OptionDescriber.IteratorOptions buildResult = (new IteratorOptionsBuilder("Name",
        "The characteristics of someone or something")).build();
    assertEquals("Name", buildResult.getName());
    assertEquals("The characteristics of someone or something", buildResult.getDescription());
    assertNull(buildResult.getUnnamedOptionDescriptions());
    assertNull(buildResult.getNamedOptions());
  }

  /**
   * Method under test:
   * {@link IteratorOptionsBuilder#IteratorOptionsBuilder(OptionDescriber.IteratorOptions)}
   */
  @Test
  void testNewIteratorOptionsBuilder2() {
    // Arrange
    HashMap<String, String> namedOptions = new HashMap<>();
    OptionDescriber.IteratorOptions options = new OptionDescriber.IteratorOptions("Name",
        "The characteristics of someone or something", namedOptions, new ArrayList<>());

    // Act and Assert
    assertSame(options, (new IteratorOptionsBuilder(options)).build());
  }

  /**
   * Method under test:
   * {@link IteratorOptionsBuilder#IteratorOptionsBuilder(OptionDescriber.IteratorOptions)}
   */
  @Test
  void testNewIteratorOptionsBuilder3() {
    // Arrange
    HashMap<String, String> namedOptions = new HashMap<>();
    namedOptions.computeIfPresent("foo", mock(BiFunction.class));
    OptionDescriber.IteratorOptions options = new OptionDescriber.IteratorOptions("Name",
        "The characteristics of someone or something", namedOptions, new ArrayList<>());

    // Act and Assert
    assertSame(options, (new IteratorOptionsBuilder(options)).build());
  }
}
