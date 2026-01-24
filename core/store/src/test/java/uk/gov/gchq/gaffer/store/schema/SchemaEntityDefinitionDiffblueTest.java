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

package uk.gov.gchq.gaffer.store.schema;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.schema.SchemaEntityDefinition.BaseBuilder;
import uk.gov.gchq.gaffer.store.schema.SchemaEntityDefinition.Builder;

class SchemaEntityDefinitionDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#vertex(String)}.
   *
   * <p>Method under test: {@link BaseBuilder#vertex(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder vertex(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.vertex(String)"})
  void testBaseBuilderVertex() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualVertexResult = builder.vertex("Type Name");

    // Assert
    assertSame(builder, actualVertexResult);
  }

  /**
   * Test Builder {@link Builder#self()}.
   *
   * <p>Method under test: {@link Builder#self()}
   */
  @Test
  @DisplayName("Test Builder self()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.self()"})
  void testBuilderSelf() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSelfResult = builder.self();

    // Assert
    assertSame(builder, actualSelfResult);
  }

  /**
   * Test {@link SchemaEntityDefinition#getVertex()}.
   *
   * <p>Method under test: {@link SchemaEntityDefinition#getVertex()}
   */
  @Test
  @DisplayName("Test getVertex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SchemaEntityDefinition.getVertex()"})
  void testGetVertex() {
    // Arrange, Act and Assert
    assertNull(new SchemaEntityDefinition().getVertex());
  }
}
