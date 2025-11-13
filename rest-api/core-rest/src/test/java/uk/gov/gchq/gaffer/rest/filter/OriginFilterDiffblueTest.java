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

package uk.gov.gchq.gaffer.rest.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class OriginFilterDiffblueTest {
  /**
   * Test {@link OriginFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link OriginFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilter(ServletRequest, ServletResponse, FilterChain); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OriginFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  void testDoFilter_givenIOException_thenThrowIOException() throws IOException, ServletException {
    // Arrange
    OriginFilter originFilter = new OriginFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doThrow(new IOException())
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(IOException.class, () -> originFilter.doFilter(request, response, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link OriginFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames size is three.
   * </ul>
   *
   * <p>Method under test: {@link OriginFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilter(ServletRequest, ServletResponse, FilterChain); then MockHttpServletResponse (default constructor) HeaderNames size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OriginFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  void testDoFilter_thenMockHttpServletResponseHeaderNamesSizeIsThree()
      throws IOException, ServletException {
    // Arrange
    OriginFilter originFilter = new OriginFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    originFilter.doFilter(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(3, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertTrue(headerNames.contains("Access-Control-Allow-Headers"));
    assertTrue(headerNames.contains("Access-Control-Allow-Methods"));
    assertTrue(headerNames.contains("Access-Control-Allow-Origin"));
  }
}
