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

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.impl.job.GetJobDetails;
import uk.gov.gchq.gaffer.rest.factory.DefaultGraphFactory;
import uk.gov.gchq.gaffer.rest.factory.ExamplesFactory;
import uk.gov.gchq.gaffer.rest.factory.GraphFactory;
import uk.gov.gchq.gaffer.rest.factory.UserFactory;
import uk.gov.gchq.gaffer.rest.factory.spring.AbstractUserFactory;
import uk.gov.gchq.gaffer.rest.mapper.GafferExceptionMapper;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.user.User;

@ContextConfiguration(classes = {OperationController.class, GafferExceptionMapper.class})
@ExtendWith(SpringExtension.class)
class OperationControllerDiffblueTest {
  @MockBean private AbstractUserFactory abstractUserFactory;

  @MockBean private ExamplesFactory examplesFactory;

  @Autowired private GafferExceptionMapper gafferExceptionMapper;

  @MockBean private GraphFactory graphFactory;

  @Autowired private OperationController operationController;

  /**
   * Test {@link OperationController#getAllOperationDetails()}.
   *
   * <p>Method under test: {@link OperationController#getAllOperationDetails()}
   */
  @Test
  @DisplayName("Test getAllOperationDetails()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set OperationController.getAllOperationDetails()"})
  void testGetAllOperationDetails() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new ClassCastException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/operations/details");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
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
   * Test {@link OperationController#getAllOperationDetails()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link OperationController#getAllOperationDetails()}
   */
  @Test
  @DisplayName("Test getAllOperationDetails(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set OperationController.getAllOperationDetails()"})
  void testGetAllOperationDetails_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/operations/details");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
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
   * Test {@link OperationController#getAllOperationDetailsIncludingUnsupported()}.
   *
   * <p>Method under test: {@link OperationController#getAllOperationDetailsIncludingUnsupported()}
   */
  @Test
  @DisplayName("Test getAllOperationDetailsIncludingUnsupported()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Set OperationController.getAllOperationDetailsIncludingUnsupported()"
  })
  void testGetAllOperationDetailsIncludingUnsupported() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new ClassCastException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/operations/details/all");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
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
   * Test {@link OperationController#getAllOperationDetailsIncludingUnsupported()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link OperationController#getAllOperationDetailsIncludingUnsupported()}
   */
  @Test
  @DisplayName("Test getAllOperationDetailsIncludingUnsupported(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Set OperationController.getAllOperationDetailsIncludingUnsupported()"
  })
  void testGetAllOperationDetailsIncludingUnsupported_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/operations/details/all");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
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
   * Test {@link OperationController#getOperationDetails(String)}.
   *
   * <p>Method under test: {@link OperationController#getOperationDetails(String)}
   */
  @Test
  @DisplayName("Test getOperationDetails(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.rest.model.OperationDetail OperationController.getOperationDetails(String)"
  })
  void testGetOperationDetails() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/operations/{className}", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
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
   * Test {@link OperationController#getOperationDetails(String)}.
   *
   * <p>Method under test: {@link OperationController#getOperationDetails(String)}
   */
  @Test
  @DisplayName("Test getOperationDetails(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.rest.model.OperationDetail OperationController.getOperationDetails(String)"
  })
  void testGetOperationDetails2() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new ClassCastException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/operations/{className}", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
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
   * Test {@link OperationController#getNextOperations(String)} with {@code className}.
   *
   * <ul>
   *   <li>Given array of {@link Object} with {@code Class Name}.
   *   <li>When {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link OperationController#getNextOperations(String)}
   */
  @Test
  @DisplayName(
      "Test getNextOperations(String) with 'className'; given array of Object with 'Class Name'; when '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set OperationController.getNextOperations(String)"})
  void testGetNextOperationsWithClassName_givenArrayOfObjectWithClassName_whenDot()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/operations/{className}/next", ".");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":404,\"status\":\"Not Found\",\"simpleMessage\":\"Operation class was not found: .\",\"detailMessage"
                        + "\":null}"));
  }

  /**
   * Test {@link OperationController#getNextOperations(String)} with {@code className}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link OperationController#getNextOperations(String)}
   */
  @Test
  @DisplayName("Test getNextOperations(String) with 'className'; when 'Class Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set OperationController.getNextOperations(String)"})
  void testGetNextOperationsWithClassName_whenClassName() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/operations/{className}/next", "Class Name");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":404,\"status\":\"Not Found\",\"simpleMessage\":\"Operation class was not found: Class"
                        + " Name\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link OperationController#getNextOperations(String)} with {@code className}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link OperationController#getNextOperations(String)}
   */
  @Test
  @DisplayName("Test getNextOperations(String) with 'className'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set OperationController.getNextOperations(String)"})
  void testGetNextOperationsWithClassName_whenEmptyString() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/operations/{className}/next", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":404,\"status\":\"Not Found\",\"simpleMessage\":\"Class: next was not found on the classpath.\""
                        + ",\"detailMessage\":null}"));
  }

  /**
   * Test {@link OperationController#getNextOperations(String)} with {@code className}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link OperationController#getNextOperations(String)}
   */
  @Test
  @DisplayName("Test getNextOperations(String) with 'className'; when '[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set OperationController.getNextOperations(String)"})
  void testGetNextOperationsWithClassName_whenLeftSquareBracketRightSquareBracket()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/operations/{className}/next", "[]");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":404,\"status\":\"Not Found\",\"simpleMessage\":\"Operation class was not found: []\",\"detailMessage"
                        + "\":null}"));
  }

  /**
   * Test {@link OperationController#getOperationExample(String)}.
   *
   * <ul>
   *   <li>Given array of {@link Object} with {@code Class Name}.
   *   <li>When {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link OperationController#getOperationExample(String)}
   */
  @Test
  @DisplayName(
      "Test getOperationExample(String); given array of Object with 'Class Name'; when '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation OperationController.getOperationExample(String)"})
  void testGetOperationExample_givenArrayOfObjectWithClassName_whenDot() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/operations/{className}/example", ".");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":404,\"status\":\"Not Found\",\"simpleMessage\":\"Class: . was not found on the classpath.\","
                        + "\"detailMessage\":null}"));
  }

  /**
   * Test {@link OperationController#getOperationExample(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link OperationController#getOperationExample(String)}
   */
  @Test
  @DisplayName("Test getOperationExample(String); when 'Class Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation OperationController.getOperationExample(String)"})
  void testGetOperationExample_whenClassName() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/operations/{className}/example", "Class Name");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":404,\"status\":\"Not Found\",\"simpleMessage\":\"Class: Class Name was not found on the"
                        + " classpath.\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link OperationController#getOperationExample(String)}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link OperationController#getOperationExample(String)}
   */
  @Test
  @DisplayName("Test getOperationExample(String); when '[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation OperationController.getOperationExample(String)"})
  void testGetOperationExample_whenLeftSquareBracketRightSquareBracket() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/operations/{className}/example", "[]");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":404,\"status\":\"Not Found\",\"simpleMessage\":\"Class: [] was not found on the classpath.\","
                        + "\"detailMessage\":null}"));
  }

  /**
   * Test {@link OperationController#execute(HttpHeaders, Operation)}.
   *
   * <p>Method under test: {@link OperationController#execute(HttpHeaders, Operation)}
   */
  @Test
  @DisplayName("Test execute(HttpHeaders, Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity OperationController.execute(HttpHeaders, Operation)"
  })
  void testExecute() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    Builder builder = new Builder();
    when(abstractUserFactory.createContext())
        .thenReturn(builder.user(new User.Builder().userId("42").build()).build());
    doNothing().when(abstractUserFactory).setHttpHeaders(Mockito.<HttpHeaders>any());

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/rest/graph/operations/execute")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(jsonMapper.writeValueAsString(new GetJobDetails()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
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
   * Test {@link OperationController#execute(HttpHeaders, Operation)}.
   *
   * <p>Method under test: {@link OperationController#execute(HttpHeaders, Operation)}
   */
  @Test
  @DisplayName("Test execute(HttpHeaders, Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity OperationController.execute(HttpHeaders, Operation)"
  })
  void testExecute2() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new ClassCastException());

    Builder builder = new Builder();
    when(abstractUserFactory.createContext())
        .thenReturn(builder.user(new User.Builder().userId("42").build()).build());
    doNothing().when(abstractUserFactory).setHttpHeaders(Mockito.<HttpHeaders>any());

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/rest/graph/operations/execute")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(jsonMapper.writeValueAsString(new GetJobDetails()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
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
   * Test {@link OperationController#execute(HttpHeaders, Operation)}.
   *
   * <ul>
   *   <li>Given {@link GraphFactory}.
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link OperationController#execute(HttpHeaders, Operation)}
   */
  @Test
  @DisplayName(
      "Test execute(HttpHeaders, Operation); given GraphFactory; then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity OperationController.execute(HttpHeaders, Operation)"
  })
  void testExecute_givenGraphFactory_thenContentStringAString() throws Exception {
    // Arrange
    when(abstractUserFactory.createContext())
        .thenThrow(new GafferRuntimeException("An error occurred"));
    doThrow(new GafferRuntimeException("An error occurred"))
        .when(abstractUserFactory)
        .setHttpHeaders(Mockito.<HttpHeaders>any());

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/rest/graph/operations/execute")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(jsonMapper.writeValueAsString(new GetJobDetails()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
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
   * Test {@link OperationController#executeChunked(HttpHeaders, Operation)}.
   *
   * <p>Method under test: {@link OperationController#executeChunked(HttpHeaders, Operation)}
   */
  @Test
  @DisplayName("Test executeChunked(HttpHeaders, Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity OperationController.executeChunked(HttpHeaders, Operation)"
  })
  void testExecuteChunked() throws Exception {
    // Arrange
    doThrow(new ClassCastException())
        .when(abstractUserFactory)
        .setHttpHeaders(Mockito.<HttpHeaders>any());

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/rest/graph/operations/execute/chunked")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(jsonMapper.writeValueAsString(new GetJobDetails()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
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
   * Test {@link OperationController#executeChunked(HttpHeaders, Operation)}.
   *
   * <ul>
   *   <li>Given {@link AbstractUserFactory} (default constructor) HttpHeaders is {@link
   *       HttpHeaders#HttpHeaders()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationController#executeChunked(HttpHeaders, Operation)}
   */
  @Test
  @DisplayName(
      "Test executeChunked(HttpHeaders, Operation); given AbstractUserFactory (default constructor) HttpHeaders is HttpHeaders()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity OperationController.executeChunked(HttpHeaders, Operation)"
  })
  void testExecuteChunked_givenAbstractUserFactoryHttpHeadersIsHttpHeaders() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/rest/graph/operations/execute/chunked")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(jsonMapper.writeValueAsString(new GetJobDetails()));

    AbstractUserFactory userFactory = new AbstractUserFactory();
    userFactory.setHttpHeaders(new HttpHeaders());
    OperationController operationController =
        new OperationController(
            new DefaultGraphFactory(), userFactory, mock(ExamplesFactory.class));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string(""));
  }

  /**
   * Test {@link OperationController#executeChunked(HttpHeaders, Operation)}.
   *
   * <ul>
   *   <li>Given {@link AbstractUserFactory} {@link AbstractUserFactory#setHttpHeaders(HttpHeaders)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link OperationController#executeChunked(HttpHeaders, Operation)}
   */
  @Test
  @DisplayName(
      "Test executeChunked(HttpHeaders, Operation); given AbstractUserFactory setHttpHeaders(HttpHeaders) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity OperationController.executeChunked(HttpHeaders, Operation)"
  })
  void testExecuteChunked_givenAbstractUserFactorySetHttpHeadersDoesNothing() throws Exception {
    // Arrange
    doNothing().when(abstractUserFactory).setHttpHeaders(Mockito.<HttpHeaders>any());

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/rest/graph/operations/execute/chunked")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(jsonMapper.writeValueAsString(new GetJobDetails()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string(""));
  }

  /**
   * Test {@link OperationController#executeChunked(HttpHeaders, Operation)}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link OperationController#executeChunked(HttpHeaders, Operation)}
   */
  @Test
  @DisplayName("Test executeChunked(HttpHeaders, Operation); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity OperationController.executeChunked(HttpHeaders, Operation)"
  })
  void testExecuteChunked_thenContentStringAString() throws Exception {
    // Arrange
    Builder builder = new Builder();
    when(abstractUserFactory.createContext())
        .thenReturn(builder.user(new User.Builder().userId("42").build()).build());
    doThrow(new GafferRuntimeException("An error occurred"))
        .when(abstractUserFactory)
        .setHttpHeaders(Mockito.<HttpHeaders>any());

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/rest/graph/operations/execute/chunked")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(jsonMapper.writeValueAsString(new GetJobDetails()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationController#getExamplesFactory()}
   *   <li>{@link OperationController#getGraphFactory()}
   *   <li>{@link OperationController#getUserFactory()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExamplesFactory OperationController.getExamplesFactory()",
    "GraphFactory OperationController.getGraphFactory()",
    "UserFactory OperationController.getUserFactory()"
  })
  void testGettersAndSetters() {
    // Arrange
    DefaultGraphFactory graphFactory = new DefaultGraphFactory();
    AbstractUserFactory userFactory = new AbstractUserFactory();

    OperationController operationController =
        new OperationController(graphFactory, userFactory, mock(ExamplesFactory.class));

    // Act
    operationController.getExamplesFactory();
    GraphFactory actualGraphFactory = operationController.getGraphFactory();
    UserFactory actualUserFactory = operationController.getUserFactory();

    // Assert
    assertTrue(actualGraphFactory instanceof DefaultGraphFactory);
    assertTrue(actualUserFactory instanceof AbstractUserFactory);
    assertSame(graphFactory, actualGraphFactory);
    assertSame(userFactory, actualUserFactory);
  }
}
