package uk.gov.gchq.gaffer.rest.handler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.rest.factory.spring.AbstractUserFactory;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraph;

class GremlinWebSocketHandlerDiffblueTest {
  /**
   * Test {@link GremlinWebSocketHandler#GremlinWebSocketHandler(GafferPopGraph,
   * AbstractUserFactory, Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not supportsPartialMessages.
   * </ul>
   *
   * <p>Method under test: {@link GremlinWebSocketHandler#GremlinWebSocketHandler(GafferPopGraph,
   * AbstractUserFactory, Long)}
   */
  @Test
  @DisplayName(
      "Test new GremlinWebSocketHandler(GafferPopGraph, AbstractUserFactory, Long); when 'null'; then return not supportsPartialMessages")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GremlinWebSocketHandler.<init>(GafferPopGraph, AbstractUserFactory, Long)"
  })
  void testNewGremlinWebSocketHandler_whenNull_thenReturnNotSupportsPartialMessages() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    GremlinWebSocketHandler actualGremlinWebSocketHandler =
        new GremlinWebSocketHandler(null, new AbstractUserFactory(), 1L);

    // Assert
    assertFalse(actualGremlinWebSocketHandler.supportsPartialMessages());
  }
}
