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
