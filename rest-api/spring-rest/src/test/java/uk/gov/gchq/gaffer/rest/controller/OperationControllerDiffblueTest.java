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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import uk.gov.gchq.gaffer.accumulostore.operation.hdfs.operation.ImportAccumuloKeyValueFiles;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.rest.factory.DefaultGraphFactory;
import uk.gov.gchq.gaffer.rest.factory.ExamplesFactory;
import uk.gov.gchq.gaffer.rest.factory.GraphFactory;
import uk.gov.gchq.gaffer.rest.factory.UserFactory;
import uk.gov.gchq.gaffer.rest.factory.spring.AbstractUserFactory;
import uk.gov.gchq.gaffer.rest.mapper.GafferExceptionMapper;

@ContextConfiguration(classes = {OperationController.class, GafferExceptionMapper.class})
@ExtendWith(SpringExtension.class)
class OperationControllerDiffblueTest {
  @MockBean
  private AbstractUserFactory abstractUserFactory;

  @MockBean
  private ExamplesFactory examplesFactory;

  @Autowired
  private GafferExceptionMapper gafferExceptionMapper;

  @MockBean
  private GraphFactory graphFactory;

  @Autowired
  private OperationController operationController;

  /**
   * Test {@link OperationController#getOperationDetails(String)}.
   * <p>
   * Method under test: {@link OperationController#getOperationDetails(String)}
   */
  @Test
  @DisplayName("Test getOperationDetails(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"uk.gov.gchq.gaffer.rest.model.OperationDetail OperationController.getOperationDetails(String)"})
  void testGetOperationDetails() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rest/graph/operations/{className}",
        "Class Name");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"statusCode\":404,\"status\":\"Not Found\",\"simpleMessage\":\"Class: Class Name was not found on the"
                    + " classpath.\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link OperationController#getNextOperations(String)} with {@code className}.
   * <p>
   * Method under test: {@link OperationController#getNextOperations(String)}
   */
  @Test
  @DisplayName("Test getNextOperations(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set OperationController.getNextOperations(String)"})
  void testGetNextOperationsWithClassName() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rest/graph/operations/{className}/next",
        "Class Name");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"statusCode\":404,\"status\":\"Not Found\",\"simpleMessage\":\"Operation class was not found: Class"
                    + " Name\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link OperationController#getOperationExample(String)}.
   * <p>
   * Method under test: {@link OperationController#getOperationExample(String)}
   */
  @Test
  @DisplayName("Test getOperationExample(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation OperationController.getOperationExample(String)"})
  void testGetOperationExample() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/rest/graph/operations/{className}/example", "Class Name");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(operationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"statusCode\":404,\"status\":\"Not Found\",\"simpleMessage\":\"Class: Class Name was not found on the"
                    + " classpath.\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link OperationController#executeChunked(HttpHeaders, Operation)}.
   * <ul>
   *   <li>Then return Headers size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationController#executeChunked(HttpHeaders, Operation)}
   */
  @Test
  @DisplayName("Test executeChunked(HttpHeaders, Operation); then return Headers size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity OperationController.executeChunked(HttpHeaders, Operation)"})
  void testExecuteChunked_thenReturnHeadersSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultGraphFactory graphFactory = new DefaultGraphFactory();
    OperationController operationController = new OperationController(graphFactory, new AbstractUserFactory(),
        mock(ExamplesFactory.class));
    HttpHeaders httpHeaders = new HttpHeaders();

    // Act
    ResponseEntity<StreamingResponseBody> actualExecuteChunkedResult = operationController.executeChunked(httpHeaders,
        new ImportAccumuloKeyValueFiles());

    // Assert
    HttpHeaders headers = actualExecuteChunkedResult.getHeaders();
    assertEquals(2, headers.size());
    List<String> getResult = headers.get(HttpHeaders.CONTENT_TYPE);
    assertEquals(1, getResult.size());
    assertEquals("application/json", getResult.get(0));
    List<String> getResult2 = headers.get("X-Gaffer-Media-Type");
    assertEquals(1, getResult2.size());
    assertEquals("gaffer.v2; format=json", getResult2.get(0));
    assertEquals(200, actualExecuteChunkedResult.getStatusCodeValue());
    assertEquals(HttpStatus.OK, actualExecuteChunkedResult.getStatusCode());
    assertTrue(actualExecuteChunkedResult.hasBody());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OperationController#getExamplesFactory()}
   *   <li>{@link OperationController#getGraphFactory()}
   *   <li>{@link OperationController#getUserFactory()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExamplesFactory OperationController.getExamplesFactory()",
      "GraphFactory OperationController.getGraphFactory()", "UserFactory OperationController.getUserFactory()"})
  void testGettersAndSetters() {
    // Arrange
    DefaultGraphFactory graphFactory = new DefaultGraphFactory();
    AbstractUserFactory userFactory = new AbstractUserFactory();
    OperationController operationController = new OperationController(graphFactory, userFactory,
        mock(ExamplesFactory.class));

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
