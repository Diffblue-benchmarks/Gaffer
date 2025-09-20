package uk.gov.gchq.gaffer.rest.factory;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GraphFactoryDiffblueTest {
  /**
   * Test {@link GraphFactory#createGraphFactory()}.
   *
   * <p>Method under test: {@link GraphFactory#createGraphFactory()}
   */
  @Test
  @DisplayName("Test createGraphFactory()")
  @Tag("MaintainedByDiffblue")
  void testCreateGraphFactory() {
    // Arrange and Act
    GraphFactory actualCreateGraphFactoryResult = GraphFactory.createGraphFactory();

    // Assert
    assertTrue(actualCreateGraphFactoryResult instanceof DefaultGraphFactory);
    assertTrue(((DefaultGraphFactory) actualCreateGraphFactoryResult).isSingletonGraph());
  }
}
