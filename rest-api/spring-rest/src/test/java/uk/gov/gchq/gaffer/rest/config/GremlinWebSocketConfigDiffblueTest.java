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
import org.mockito.Mockito;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.ServletWebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import uk.gov.gchq.gaffer.rest.factory.spring.AbstractUserFactory;

class GremlinWebSocketConfigDiffblueTest {
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
    GremlinWebSocketConfig gremlinWebSocketConfig =
        new GremlinWebSocketConfig(null, new AbstractUserFactory(), 1L);

    WebSocketHandlerRegistry registry = mock(WebSocketHandlerRegistry.class);
    when(registry.addHandler(Mockito.<WebSocketHandler>any(), (String[]) Mockito.any()))
        .thenReturn(new ServletWebSocketHandlerRegistration());

    // Act
    gremlinWebSocketConfig.registerWebSocketHandlers(registry);

    // Assert
    verify(registry).addHandler(isA(WebSocketHandler.class), (String[]) Mockito.any());
  }
}
