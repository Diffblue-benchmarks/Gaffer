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

package uk.gov.gchq.gaffer.rest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.rest.factory.GraphFactory;
import uk.gov.gchq.gaffer.rest.mapper.GafferExceptionMapper;

@ContextConfiguration(classes = {GraphConfigurationController.class, GafferExceptionMapper.class})
@ExtendWith(SpringExtension.class)
class GraphConfigurationControllerDiffblueTest {
  @Autowired private GafferExceptionMapper gafferExceptionMapper;

  @Autowired private GraphConfigurationController graphConfigurationController;

  @MockBean private GraphFactory graphFactory;

  /**
   * Test {@link GraphConfigurationController#getSchema()}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.schema.Schema GraphConfigurationController.getSchema()"
  })
  void testGetSchema() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/schema");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":null,\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getSchema()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.schema.Schema GraphConfigurationController.getSchema()"
  })
  void testGetSchema_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/schema");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"An error occurred\",\"detailMessage"
                        + "\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getDescription()}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getDescription()"})
  void testGetDescription() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/description");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":null,\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getDescription()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getDescription()"})
  void testGetDescription_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/description");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"An error occurred\",\"detailMessage"
                        + "\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getGraphId()}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getGraphId()"})
  void testGetGraphId() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/graphId");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":null,\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getGraphId()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getGraphId()"})
  void testGetGraphId_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/graphId");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"An error occurred\",\"detailMessage"
                        + "\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getGraphCreatedTime()}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getGraphCreatedTime()}
   */
  @Test
  @DisplayName("Test getGraphCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getGraphCreatedTime()"})
  void testGetGraphCreatedTime() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/graphCreatedTime");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":null,\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getGraphCreatedTime()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getGraphCreatedTime()}
   */
  @Test
  @DisplayName("Test getGraphCreatedTime(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getGraphCreatedTime()"})
  void testGetGraphCreatedTime_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/graphCreatedTime");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"An error occurred\",\"detailMessage"
                        + "\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getFilterFunctions(String)} with {@code String}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set GraphConfigurationController.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/rest/graph/config/filterFunctions/{inputClass}", "Input Class");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"Could not find input class: Input"
                        + " Class\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getFilterFunctions(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'; given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set GraphConfigurationController.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_givenTrue() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/rest/graph/config/filterFunctions/{inputClass}", "Input Class");
    requestBuilder.secure(true);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"Could not find input class: Input"
                        + " Class\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then status {@link StatusResultMatchers#isInternalServerError()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getSerialisedFields(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFields(String); when 'Class Name'; then status isInternalServerError()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set GraphConfigurationController.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenClassName_thenStatusIsInternalServerError() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/serialisedFields/{className}", "Class Name");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"Class name was not recognised:"
                        + " Class Name\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code Class Namejava.util.Set}.
   *   <li>Then status {@link StatusResultMatchers#isInternalServerError()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getSerialisedFields(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFields(String); when 'Class Namejava.util.Set'; then status isInternalServerError()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set GraphConfigurationController.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenClassNamejavaUtilSet_thenStatusIsInternalServerError()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/rest/graph/config/serialisedFields/{className}", "Class Namejava.util.Set");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"Class name was not recognised:"
                        + " Class Namejava.util.Set\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code java.util.Set}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when 'java.util.Set'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set GraphConfigurationController.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenJavaUtilSet_thenStatusIsOk() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/rest/graph/config/serialisedFields/{className}", "java.util.Set");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFieldClasses(String)}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map GraphConfigurationController.getSerialisedFieldClasses(String)"
  })
  void testGetSerialisedFieldClasses() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/rest/graph/config/serialisedFields/{className}/classes",
            "uk.gov.gchq.gaffer.operation.io.Output");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content().string("{\"options\":\"java.util.Map<java.lang.String,java.lang.String>\"}"));
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then status {@link StatusResultMatchers#isInternalServerError()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFieldClasses(String); when 'Class Name'; then status isInternalServerError()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map GraphConfigurationController.getSerialisedFieldClasses(String)"
  })
  void testGetSerialisedFieldClasses_whenClassName_thenStatusIsInternalServerError()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/rest/graph/config/serialisedFields/{className}/classes", "Class Name");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"Class name was not recognised:"
                        + " Class Name\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then status {@link StatusResultMatchers#isInternalServerError()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFieldClasses(String); when empty string; then status isInternalServerError()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map GraphConfigurationController.getSerialisedFieldClasses(String)"
  })
  void testGetSerialisedFieldClasses_whenEmptyString_thenStatusIsInternalServerError()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/serialisedFields/{className}/classes", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"Class name was not recognised:"
                        + " classes\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code java.util.function.Predicate}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'java.util.function.Predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map GraphConfigurationController.getSerialisedFieldClasses(String)"
  })
  void testGetSerialisedFieldClasses_whenJavaUtilFunctionPredicate() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/rest/graph/config/serialisedFields/{className}/classes",
            "java.util.function.Predicate");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{}"));
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code java.util.Set}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'java.util.Set'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map GraphConfigurationController.getSerialisedFieldClasses(String)"
  })
  void testGetSerialisedFieldClasses_whenJavaUtilSet() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/rest/graph/config/serialisedFields/{className}/classes", "java.util.Set");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{}"));
  }

  /**
   * Test {@link GraphConfigurationController#getStoreType()}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getStoreType()}
   */
  @Test
  @DisplayName("Test getStoreType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getStoreType()"})
  void testGetStoreType() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/storeType");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":null,\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getStoreType()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getStoreType()}
   */
  @Test
  @DisplayName("Test getStoreType(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getStoreType()"})
  void testGetStoreType_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/storeType");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"An error occurred\",\"detailMessage"
                        + "\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getStoreTraits()}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getStoreTraits()}
   */
  @Test
  @DisplayName("Test getStoreTraits()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set GraphConfigurationController.getStoreTraits()"})
  void testGetStoreTraits() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/storeTraits");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":null,\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getStoreTraits()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getStoreTraits()}
   */
  @Test
  @DisplayName("Test getStoreTraits(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set GraphConfigurationController.getStoreTraits()"})
  void testGetStoreTraits_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/storeTraits");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"An error occurred\",\"detailMessage"
                        + "\":null}"));
  }
}
