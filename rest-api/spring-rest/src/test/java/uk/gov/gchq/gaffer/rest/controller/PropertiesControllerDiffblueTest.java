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

package uk.gov.gchq.gaffer.rest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map PropertiesController.getProperties()"})
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
                        + "\"images/logo.png\",\"gaffer.version\":\"2.3.3-SNAPSHOT\",\"koryphe.version\":\"2.6.0\"}"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map PropertiesController.getProperties()"})
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
                        + "\"images/logo.png\",\"gaffer.version\":\"2.3.3-SNAPSHOT\",\"koryphe.version\":\"2.6.0\"}"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PropertiesController.getProperty(String)"})
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
