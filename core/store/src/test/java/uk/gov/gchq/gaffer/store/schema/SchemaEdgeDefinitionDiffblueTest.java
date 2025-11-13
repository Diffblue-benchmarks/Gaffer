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

package uk.gov.gchq.gaffer.store.schema;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition.BaseBuilder;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition.Builder;

class SchemaEdgeDefinitionDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#destination(String)}.
   * <p>
   * Method under test: {@link BaseBuilder#destination(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder destination(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.destination(String)"})
  void testBaseBuilderDestination() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.destination("Type Name"));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#directed(String)}.
   * <p>
   * Method under test: {@link BaseBuilder#directed(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder directed(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.directed(String)"})
  void testBaseBuilderDirected() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.directed("Type Name"));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#source(String)}.
   * <p>
   * Method under test: {@link BaseBuilder#source(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder source(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.source(String)"})
  void testBaseBuilderSource() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.source("Type Name"));
  }

  /**
   * Test Builder {@link Builder#self()}.
   * <p>
   * Method under test: {@link Builder#self()}
   */
  @Test
  @DisplayName("Test Builder self()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.self()"})
  void testBuilderSelf() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.self());
  }

  /**
   * Test {@link SchemaEdgeDefinition#getSource()}.
   * <p>
   * Method under test: {@link SchemaEdgeDefinition#getSource()}
   */
  @Test
  @DisplayName("Test getSource()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SchemaEdgeDefinition.getSource()"})
  void testGetSource() {
    // Arrange, Act and Assert
    assertNull((new SchemaEdgeDefinition()).getSource());
  }

  /**
   * Test {@link SchemaEdgeDefinition#getDestination()}.
   * <p>
   * Method under test: {@link SchemaEdgeDefinition#getDestination()}
   */
  @Test
  @DisplayName("Test getDestination()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SchemaEdgeDefinition.getDestination()"})
  void testGetDestination() {
    // Arrange, Act and Assert
    assertNull((new SchemaEdgeDefinition()).getDestination());
  }

  /**
   * Test {@link SchemaEdgeDefinition#getDirected()}.
   * <p>
   * Method under test: {@link SchemaEdgeDefinition#getDirected()}
   */
  @Test
  @DisplayName("Test getDirected()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SchemaEdgeDefinition.getDirected()"})
  void testGetDirected() {
    // Arrange, Act and Assert
    assertNull((new SchemaEdgeDefinition()).getDirected());
  }
}
