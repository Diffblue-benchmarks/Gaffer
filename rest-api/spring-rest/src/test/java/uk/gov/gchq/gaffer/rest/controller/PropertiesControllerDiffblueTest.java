package uk.gov.gchq.gaffer.rest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.gov.gchq.gaffer.rest.mapper.GafferExceptionMapper;

@ContextConfiguration(classes = {PropertiesController.class, GafferExceptionMapper.class})
@ExtendWith(SpringExtension.class)
class PropertiesControllerDiffblueTest {
  @Autowired private GafferExceptionMapper gafferExceptionMapper;

  @Autowired private PropertiesController propertiesController;

  /**
   * Test {@link PropertiesController#getProperties()}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code /rest/properties} secure
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesController#getProperties()}
   */
  @Test
  @DisplayName(
      "Test getProperties(); given 'true'; when get(String, Object[]) '/rest/properties' secure 'true'")
  @Tag("MaintainedByDiffblue")
  void testGetProperties_givenTrue_whenGetRestPropertiesSecureTrue() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rest/properties");
    requestBuilder.secure(true);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(propertiesController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"gaffer.properties.app.title\":\"Gaffer REST\",\"gaffer.properties.app.description\":\"The Gaffer REST"
                        + " service.\",\"gaffer.properties.app.banner.description\":\"\",\"gaffer.properties.app.banner.colour\":\"\","
                        + "\"gaffer.properties.app.doc.url\":\"https://gchq.github.io/gaffer-doc/latest/\",\"gaffer.properties.app"
                        + ".logo.link\":\"https://github.com/gchq/Gaffer\",\"gaffer.properties.app.logo.src\":\"images/logo.png\",\"gaffer"
                        + ".properties.app.logo.favicon.small\":\"images/logo.png\",\"gaffer.properties.app.logo.favicon.large\":"
                        + "\"images/logo.png\",\"gaffer.version\":\"2.3.2\",\"koryphe.version\":\"2.6.0\"}"));
  }

  /**
   * Test {@link PropertiesController#getProperties()}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code /rest/properties}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesController#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties(); when get(String, Object[]) '/rest/properties'")
  @Tag("MaintainedByDiffblue")
  void testGetProperties_whenGetRestProperties() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rest/properties");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(propertiesController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"gaffer.properties.app.title\":\"Gaffer REST\",\"gaffer.properties.app.description\":\"The Gaffer REST"
                        + " service.\",\"gaffer.properties.app.banner.description\":\"\",\"gaffer.properties.app.banner.colour\":\"\","
                        + "\"gaffer.properties.app.doc.url\":\"https://gchq.github.io/gaffer-doc/latest/\",\"gaffer.properties.app"
                        + ".logo.link\":\"https://github.com/gchq/Gaffer\",\"gaffer.properties.app.logo.src\":\"images/logo.png\",\"gaffer"
                        + ".properties.app.logo.favicon.small\":\"images/logo.png\",\"gaffer.properties.app.logo.favicon.large\":"
                        + "\"images/logo.png\",\"gaffer.version\":\"2.3.2\",\"koryphe.version\":\"2.6.0\"}"));
  }

  /**
   * Test {@link PropertiesController#getProperty(String)}.
   *
   * <ul>
   *   <li>Given array of {@link Object} with {@code Property}.
   *   <li>When empty string.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesController#getProperty(String)}
   */
  @Test
  @DisplayName(
      "Test getProperty(String); given array of Object with 'Property'; when empty string; then status isOk()")
  @Tag("MaintainedByDiffblue")
  void testGetProperty_givenArrayOfObjectWithProperty_whenEmptyString_thenStatusIsOk()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/properties/{property}", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(propertiesController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"gaffer.properties.app.title\":\"Gaffer REST\",\"gaffer.properties.app.description\":\"The Gaffer REST"
                        + " service.\",\"gaffer.properties.app.banner.description\":\"\",\"gaffer.properties.app.banner.colour\":\"\","
                        + "\"gaffer.properties.app.doc.url\":\"https://gchq.github.io/gaffer-doc/latest/\",\"gaffer.properties.app"
                        + ".logo.link\":\"https://github.com/gchq/Gaffer\",\"gaffer.properties.app.logo.src\":\"images/logo.png\",\"gaffer"
                        + ".properties.app.logo.favicon.small\":\"images/logo.png\",\"gaffer.properties.app.logo.favicon.large\":"
                        + "\"images/logo.png\",\"gaffer.version\":\"2.3.2\",\"koryphe.version\":\"2.6.0\"}"));
  }

  /**
   * Test {@link PropertiesController#getProperty(String)}.
   *
   * <ul>
   *   <li>When {@code Property}.
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesController#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String); when 'Property'; then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  void testGetProperty_whenProperty_thenStatusIsNotFound() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/properties/{property}", "Property");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(propertiesController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":404,\"status\":\"Not Found\",\"simpleMessage\":\"Property: Property could not be found.\","
                        + "\"detailMessage\":null}"));
  }
}
