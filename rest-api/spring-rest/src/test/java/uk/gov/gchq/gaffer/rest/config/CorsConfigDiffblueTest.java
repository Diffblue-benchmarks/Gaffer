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

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@ContextConfiguration(classes = {CorsConfig.class})
@ExtendWith(SpringExtension.class)
class CorsConfigDiffblueTest {
  @Autowired
  private CorsConfig corsConfig;

  /**
   * Method under test: {@link CorsConfig#addCorsMappings(CorsRegistry)}
   */
  @Test
  void testAddCorsMappings() {
    // Arrange
    CorsRegistry registry = mock(CorsRegistry.class);
    when(registry.addMapping(Mockito.<String>any())).thenReturn(new CorsRegistration("Path Pattern"));

    // Act
    corsConfig.addCorsMappings(registry);

    // Assert
    verify(registry).addMapping(eq("/**"));
  }
}
