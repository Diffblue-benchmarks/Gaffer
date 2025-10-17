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

package uk.gov.gchq.gaffer.rest.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;

class DefaultGraphFactoryDiffblueTest {
  /**
   * Test {@link DefaultGraphFactory#createGraphFactory()}.
   *
   * <p>Method under test: {@link DefaultGraphFactory#createGraphFactory()}
   */
  @Test
  @DisplayName("Test createGraphFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphFactory DefaultGraphFactory.createGraphFactory()"})
  void testCreateGraphFactory() {
    // Arrange and Act
    GraphFactory actualCreateGraphFactoryResult = DefaultGraphFactory.createGraphFactory();

    // Assert
    assertTrue(actualCreateGraphFactoryResult instanceof DefaultGraphFactory);
    assertTrue(((DefaultGraphFactory) actualCreateGraphFactoryResult).isSingletonGraph());
  }

  /**
   * Test {@link DefaultGraphFactory#getSchemaPaths()}.
   *
   * <p>Method under test: {@link DefaultGraphFactory#getSchemaPaths()}
   */
  @Test
  @DisplayName("Test getSchemaPaths()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.nio.file.Path[] DefaultGraphFactory.getSchemaPaths()"})
  void testGetSchemaPaths() {
    // Arrange, Act and Assert
    assertEquals(0, DefaultGraphFactory.getSchemaPaths().length);
  }

  /**
   * Test {@link DefaultGraphFactory#getGraph()}.
   *
   * <ul>
   *   <li>Given {@link DefaultGraphFactory} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DefaultGraphFactory#getGraph()}
   */
  @Test
  @DisplayName("Test getGraph(); given DefaultGraphFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"uk.gov.gchq.gaffer.graph.Graph DefaultGraphFactory.getGraph()"})
  void testGetGraph_givenDefaultGraphFactory() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class, () -> new DefaultGraphFactory().getGraph());
  }

  /**
   * Test {@link DefaultGraphFactory#getGraph()}.
   *
   * <ul>
   *   <li>Given {@link DefaultGraphFactory} (default constructor) SingletonGraph is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGraphFactory#getGraph()}
   */
  @Test
  @DisplayName(
      "Test getGraph(); given DefaultGraphFactory (default constructor) SingletonGraph is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"uk.gov.gchq.gaffer.graph.Graph DefaultGraphFactory.getGraph()"})
  void testGetGraph_givenDefaultGraphFactorySingletonGraphIsFalse() {
    // Arrange
    DefaultGraphFactory defaultGraphFactory = new DefaultGraphFactory();
    defaultGraphFactory.setSingletonGraph(false);

    // Act and Assert
    assertThrows(SchemaException.class, () -> defaultGraphFactory.getGraph());
  }

  /**
   * Test {@link DefaultGraphFactory#createGraphBuilder()}.
   *
   * <p>Method under test: {@link DefaultGraphFactory#createGraphBuilder()}
   */
  @Test
  @DisplayName("Test createGraphBuilder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.graph.Graph.Builder DefaultGraphFactory.createGraphBuilder()"
  })
  void testCreateGraphBuilder() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class, () -> new DefaultGraphFactory().createGraphBuilder());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultGraphFactory}
   *   <li>{@link DefaultGraphFactory#setSingletonGraph(boolean)}
   *   <li>{@link DefaultGraphFactory#isSingletonGraph()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultGraphFactory.<init>()",
    "boolean DefaultGraphFactory.isSingletonGraph()",
    "void DefaultGraphFactory.setGraph(uk.gov.gchq.gaffer.graph.Graph)",
    "void DefaultGraphFactory.setSingletonGraph(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultGraphFactory actualDefaultGraphFactory = new DefaultGraphFactory();
    actualDefaultGraphFactory.setSingletonGraph(true);

    // Assert
    assertTrue(actualDefaultGraphFactory.isSingletonGraph());
  }
}
