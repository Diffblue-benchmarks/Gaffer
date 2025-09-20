package uk.gov.gchq.gaffer.rest.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
  @Tag("MaintainedByDiffblue")
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
