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

package uk.gov.gchq.gaffer.store.operation.handler.named;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedViewCache;

class GetAllNamedViewsHandlerDiffblueTest {
  /**
   * Test {@link GetAllNamedViewsHandler#GetAllNamedViewsHandler(NamedViewCache)}.
   * <p>
   * Method under test: {@link GetAllNamedViewsHandler#GetAllNamedViewsHandler(NamedViewCache)}
   */
  @Test
  @DisplayName("Test new GetAllNamedViewsHandler(NamedViewCache)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetAllNamedViewsHandler.<init>(NamedViewCache)"})
  void testNewGetAllNamedViewsHandler() {
    // Arrange, Act and Assert
    assertEquals("suffix named view cache name",
        (new GetAllNamedViewsHandler(new NamedViewCache("Suffix Named View Cache Name"))).getSuffixCacheName());
  }

  /**
   * Test {@link GetAllNamedViewsHandler#GetAllNamedViewsHandler(String)}.
   * <p>
   * Method under test: {@link GetAllNamedViewsHandler#GetAllNamedViewsHandler(String)}
   */
  @Test
  @DisplayName("Test new GetAllNamedViewsHandler(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetAllNamedViewsHandler.<init>(String)"})
  void testNewGetAllNamedViewsHandler2() {
    // Arrange, Act and Assert
    assertEquals("suffix named view cache name",
        (new GetAllNamedViewsHandler("Suffix Named View Cache Name")).getSuffixCacheName());
  }

  /**
   * Test {@link GetAllNamedViewsHandler#getSuffixCacheName()}.
   * <ul>
   *   <li>Then return {@code suffix named view cache name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetAllNamedViewsHandler#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName(); then return 'suffix named view cache name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GetAllNamedViewsHandler.getSuffixCacheName()"})
  void testGetSuffixCacheName_thenReturnSuffixNamedViewCacheName() {
    // Arrange, Act and Assert
    assertEquals("suffix named view cache name",
        (new GetAllNamedViewsHandler("Suffix Named View Cache Name")).getSuffixCacheName());
  }
}
