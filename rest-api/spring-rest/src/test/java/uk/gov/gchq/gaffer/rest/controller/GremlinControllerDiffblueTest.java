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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class GremlinControllerDiffblueTest {
  @InjectMocks private GremlinController gremlinController;

  /**
   * Test {@link GremlinController#explain(HttpHeaders, String)}.
   *
   * <p>Method under test: {@link GremlinController#explain(HttpHeaders, String)}
   */
  @Test
  @DisplayName("Test explain(HttpHeaders, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GremlinController.explain(HttpHeaders, String)"})
  void testExplain() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/rest/gremlin/explain")
            .contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(gremlinController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }

  /**
   * Test {@link GremlinController#execute(HttpHeaders, String)}.
   *
   * <p>Method under test: {@link GremlinController#execute(HttpHeaders, String)}
   */
  @Test
  @DisplayName("Test execute(HttpHeaders, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity GremlinController.execute(HttpHeaders, String)"
  })
  void testExecute() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/rest/gremlin/execute")
            .contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(gremlinController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }

  /**
   * Test {@link GremlinController#cypherExplain(HttpHeaders, String)}.
   *
   * <p>Method under test: {@link GremlinController#cypherExplain(HttpHeaders, String)}
   */
  @Test
  @DisplayName("Test cypherExplain(HttpHeaders, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GremlinController.cypherExplain(HttpHeaders, String)"})
  void testCypherExplain() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/rest/gremlin/cypher/explain")
            .contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(gremlinController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }

  /**
   * Test {@link GremlinController#cypherExecute(HttpHeaders, String)}.
   *
   * <p>Method under test: {@link GremlinController#cypherExecute(HttpHeaders, String)}
   */
  @Test
  @DisplayName("Test cypherExecute(HttpHeaders, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity GremlinController.cypherExecute(HttpHeaders, String)"
  })
  void testCypherExecute() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/rest/gremlin/cypher/execute")
            .contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString("foo"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(gremlinController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }
}
