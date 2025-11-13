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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import uk.gov.gchq.gaffer.rest.factory.spring.AbstractUserFactory;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraph;

class GremlinControllerDiffblueTest {
  /**
   * Test {@link GremlinController#execute(HttpHeaders, String)}.
   * <p>
   * Method under test: {@link GremlinController#execute(HttpHeaders, String)}
   */
  @Test
  @DisplayName("Test execute(HttpHeaders, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity GremlinController.execute(HttpHeaders, String)"})
  void testExecute() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    GremlinController gremlinController = new GremlinController(null, new AbstractUserFactory(), 1L);

    // Act
    ResponseEntity<StreamingResponseBody> actualExecuteResult = gremlinController.execute(new HttpHeaders(),
        "Gremlin Query");

    // Assert
    HttpHeaders headers = actualExecuteResult.getHeaders();
    assertEquals(1, headers.size());
    List<String> getResult = headers.get(HttpHeaders.CONTENT_TYPE);
    assertEquals(1, getResult.size());
    assertEquals("application/x-ndjson", getResult.get(0));
    assertEquals(500, actualExecuteResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualExecuteResult.getStatusCode());
    assertTrue(actualExecuteResult.hasBody());
  }

  /**
   * Test {@link GremlinController#execute(HttpHeaders, String)}.
   * <ul>
   *   <li>Given {@link GafferPopGraph} {@link GafferPopGraph#newInstance()} return {@code null}.</li>
   *   <li>Then calls {@link GafferPopGraph#newInstance()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GremlinController#execute(HttpHeaders, String)}
   */
  @Test
  @DisplayName("Test execute(HttpHeaders, String); given GafferPopGraph newInstance() return 'null'; then calls newInstance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity GremlinController.execute(HttpHeaders, String)"})
  void testExecute_givenGafferPopGraphNewInstanceReturnNull_thenCallsNewInstance() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.newInstance()).thenReturn(null);
    GremlinController gremlinController = new GremlinController(graph, new AbstractUserFactory(), 1L);

    // Act
    ResponseEntity<StreamingResponseBody> actualExecuteResult = gremlinController.execute(new HttpHeaders(),
        "Gremlin Query");

    // Assert
    verify(graph).newInstance();
    HttpHeaders headers = actualExecuteResult.getHeaders();
    assertEquals(1, headers.size());
    List<String> getResult = headers.get(HttpHeaders.CONTENT_TYPE);
    assertEquals(1, getResult.size());
    assertEquals("application/x-ndjson", getResult.get(0));
    assertEquals(500, actualExecuteResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualExecuteResult.getStatusCode());
    assertTrue(actualExecuteResult.hasBody());
  }

  /**
   * Test {@link GremlinController#cypherExecute(HttpHeaders, String)}.
   * <p>
   * Method under test: {@link GremlinController#cypherExecute(HttpHeaders, String)}
   */
  @Test
  @DisplayName("Test cypherExecute(HttpHeaders, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity GremlinController.cypherExecute(HttpHeaders, String)"})
  void testCypherExecute() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    GremlinController gremlinController = new GremlinController(null, new AbstractUserFactory(), 1L);

    // Act
    ResponseEntity<StreamingResponseBody> actualCypherExecuteResult = gremlinController.cypherExecute(new HttpHeaders(),
        "Cypher Query");

    // Assert
    HttpHeaders headers = actualCypherExecuteResult.getHeaders();
    assertEquals(1, headers.size());
    List<String> getResult = headers.get(HttpHeaders.CONTENT_TYPE);
    assertEquals(1, getResult.size());
    assertEquals("application/x-ndjson", getResult.get(0));
    assertEquals(500, actualCypherExecuteResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualCypherExecuteResult.getStatusCode());
    assertTrue(actualCypherExecuteResult.hasBody());
  }

  /**
   * Test {@link GremlinController#cypherExecute(HttpHeaders, String)}.
   * <p>
   * Method under test: {@link GremlinController#cypherExecute(HttpHeaders, String)}
   */
  @Test
  @DisplayName("Test cypherExecute(HttpHeaders, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity GremlinController.cypherExecute(HttpHeaders, String)"})
  void testCypherExecute2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    GremlinController gremlinController = new GremlinController(graph, new AbstractUserFactory(), 1L);

    // Act
    ResponseEntity<StreamingResponseBody> actualCypherExecuteResult = gremlinController.cypherExecute(new HttpHeaders(),
        "Cypher Query");

    // Assert
    HttpHeaders headers = actualCypherExecuteResult.getHeaders();
    assertEquals(1, headers.size());
    List<String> getResult = headers.get(HttpHeaders.CONTENT_TYPE);
    assertEquals(1, getResult.size());
    assertEquals("application/x-ndjson", getResult.get(0));
    assertEquals(500, actualCypherExecuteResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualCypherExecuteResult.getStatusCode());
    assertTrue(actualCypherExecuteResult.hasBody());
  }
}
