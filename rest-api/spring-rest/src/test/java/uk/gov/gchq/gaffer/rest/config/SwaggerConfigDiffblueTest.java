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

package uk.gov.gchq.gaffer.rest.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SwaggerConfig.class})
@ExtendWith(SpringExtension.class)
class SwaggerConfigDiffblueTest {
  @Autowired private SwaggerConfig swaggerConfig;

  /**
   * Test {@link SwaggerConfig#apiInfo()}.
   *
   * <p>Method under test: {@link SwaggerConfig#apiInfo()}
   */
  @Test
  @DisplayName("Test apiInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OpenAPI SwaggerConfig.apiInfo()"})
  void testApiInfo() {
    // Arrange and Act
    OpenAPI actualApiInfoResult = swaggerConfig.apiInfo();

    // Assert
    assertEquals("3.0.1", actualApiInfoResult.getOpenapi());
    assertNull(actualApiInfoResult.getComponents());
    assertNull(actualApiInfoResult.getPaths());
    assertNull(actualApiInfoResult.getJsonSchemaDialect());
    assertNull(actualApiInfoResult.getSecurity());
    assertNull(actualApiInfoResult.getServers());
    assertNull(actualApiInfoResult.getTags());
    assertNull(actualApiInfoResult.getWebhooks());
    assertNull(actualApiInfoResult.getExtensions());
    assertEquals(SpecVersion.V30, actualApiInfoResult.getSpecVersion());
  }
}
