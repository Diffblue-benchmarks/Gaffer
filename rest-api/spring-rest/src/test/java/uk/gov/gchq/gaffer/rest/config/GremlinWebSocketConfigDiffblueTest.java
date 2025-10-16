package uk.gov.gchq.gaffer.rest.config;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.ServletWebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@ExtendWith(MockitoExtension.class)
class GremlinWebSocketConfigDiffblueTest {
  @InjectMocks private GremlinWebSocketConfig gremlinWebSocketConfig;

  /**
   * Test {@link GremlinWebSocketConfig#registerWebSocketHandlers(WebSocketHandlerRegistry)}.
   *
   * <p>Method under test: {@link
   * GremlinWebSocketConfig#registerWebSocketHandlers(WebSocketHandlerRegistry)}
   */
  @Test
  @DisplayName("Test registerWebSocketHandlers(WebSocketHandlerRegistry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GremlinWebSocketConfig.registerWebSocketHandlers(WebSocketHandlerRegistry)"
  })
  void testRegisterWebSocketHandlers() {
    // Arrange
    WebSocketHandlerRegistry registry = mock(WebSocketHandlerRegistry.class);
    when(registry.addHandler(Mockito.<WebSocketHandler>any(), (String[]) Mockito.any()))
        .thenReturn(new ServletWebSocketHandlerRegistration());

    // Act
    gremlinWebSocketConfig.registerWebSocketHandlers(registry);

    // Assert
    verify(registry).addHandler(isA(WebSocketHandler.class), (String[]) Mockito.any());
  }
}
