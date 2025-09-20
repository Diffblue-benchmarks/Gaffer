package uk.gov.gchq.gaffer.store.schema;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition.BaseBuilder;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition.Builder;

class SchemaEdgeDefinitionDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#destination(String)}.
   *
   * <p>Method under test: {@link BaseBuilder#destination(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder destination(String)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderDestination() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDestinationResult = builder.destination("Type Name");

    // Assert
    assertSame(builder, actualDestinationResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#directed(String)}.
   *
   * <p>Method under test: {@link BaseBuilder#directed(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder directed(String)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderDirected() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDirectedResult = builder.directed("Type Name");

    // Assert
    assertSame(builder, actualDirectedResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#source(String)}.
   *
   * <p>Method under test: {@link BaseBuilder#source(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder source(String)")
  @Tag("MaintainedByDiffblue")
  void testBaseBuilderSource() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSourceResult = builder.source("Type Name");

    // Assert
    assertSame(builder, actualSourceResult);
  }

  /**
   * Test Builder {@link Builder#self()}.
   *
   * <p>Method under test: {@link Builder#self()}
   */
  @Test
  @DisplayName("Test Builder self()")
  @Tag("MaintainedByDiffblue")
  void testBuilderSelf() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSelfResult = builder.self();

    // Assert
    assertSame(builder, actualSelfResult);
  }

  /**
   * Test {@link SchemaEdgeDefinition#getSource()}.
   *
   * <p>Method under test: {@link SchemaEdgeDefinition#getSource()}
   */
  @Test
  @DisplayName("Test getSource()")
  @Tag("MaintainedByDiffblue")
  void testGetSource() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getSource());
  }

  /**
   * Test {@link SchemaEdgeDefinition#getDestination()}.
   *
   * <p>Method under test: {@link SchemaEdgeDefinition#getDestination()}
   */
  @Test
  @DisplayName("Test getDestination()")
  @Tag("MaintainedByDiffblue")
  void testGetDestination() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getDestination());
  }

  /**
   * Test {@link SchemaEdgeDefinition#getDirected()}.
   *
   * <p>Method under test: {@link SchemaEdgeDefinition#getDirected()}
   */
  @Test
  @DisplayName("Test getDirected()")
  @Tag("MaintainedByDiffblue")
  void testGetDirected() {
    // Arrange, Act and Assert
    assertNull(new SchemaEdgeDefinition().getDirected());
  }
}
