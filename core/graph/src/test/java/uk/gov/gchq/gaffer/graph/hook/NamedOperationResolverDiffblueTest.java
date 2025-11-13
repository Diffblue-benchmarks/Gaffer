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

package uk.gov.gchq.gaffer.graph.hook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedOperationCache;

class NamedOperationResolverDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return DepthLimit is three.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NamedOperationResolver#NamedOperationResolver(NamedOperationCache)}
   *   <li>{@link NamedOperationResolver#getDepthLimit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return DepthLimit is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedOperationResolver.<init>(NamedOperationCache)",
      "void NamedOperationResolver.<init>(NamedOperationCache, int)", "int NamedOperationResolver.getDepthLimit()"})
  void testGettersAndSetters_thenReturnDepthLimitIsThree() {
    // Arrange, Act and Assert
    assertEquals(3,
        (new NamedOperationResolver(new NamedOperationCache("Suffix Named Operation Cache Name"))).getDepthLimit());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return DepthLimit is two.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NamedOperationResolver#NamedOperationResolver(NamedOperationCache, int)}
   *   <li>{@link NamedOperationResolver#getDepthLimit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when two; then return DepthLimit is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedOperationResolver.<init>(NamedOperationCache)",
      "void NamedOperationResolver.<init>(NamedOperationCache, int)", "int NamedOperationResolver.getDepthLimit()"})
  void testGettersAndSetters_whenTwo_thenReturnDepthLimitIsTwo() {
    // Arrange, Act and Assert
    assertEquals(2,
        (new NamedOperationResolver(new NamedOperationCache("Suffix Named Operation Cache Name"), 2)).getDepthLimit());
  }

  /**
   * Test {@link NamedOperationResolver#NamedOperationResolver(String)}.
   * <p>
   * Method under test: {@link NamedOperationResolver#NamedOperationResolver(String)}
   */
  @Test
  @DisplayName("Test new NamedOperationResolver(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedOperationResolver.<init>(String)"})
  void testNewNamedOperationResolver() {
    // Arrange and Act
    NamedOperationResolver actualNamedOperationResolver = new NamedOperationResolver(
        "Suffix Named Operation Cache Name");

    // Assert
    assertEquals("suffix named operation cache name", actualNamedOperationResolver.getSuffixCacheName());
    assertEquals(3, actualNamedOperationResolver.getDepthLimit());
  }

  /**
   * Test {@link NamedOperationResolver#NamedOperationResolver(String, int)}.
   * <p>
   * Method under test: {@link NamedOperationResolver#NamedOperationResolver(String, int)}
   */
  @Test
  @DisplayName("Test new NamedOperationResolver(String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedOperationResolver.<init>(String, int)"})
  void testNewNamedOperationResolver2() {
    // Arrange and Act
    NamedOperationResolver actualNamedOperationResolver = new NamedOperationResolver(
        "Suffix Named Operation Cache Name", 2);

    // Assert
    assertEquals("suffix named operation cache name", actualNamedOperationResolver.getSuffixCacheName());
    assertEquals(2, actualNamedOperationResolver.getDepthLimit());
  }

  /**
   * Test {@link NamedOperationResolver#NamedOperationResolver(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return SuffixCacheName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedOperationResolver#NamedOperationResolver(String)}
   */
  @Test
  @DisplayName("Test new NamedOperationResolver(String); when 'null'; then return SuffixCacheName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedOperationResolver.<init>(String)"})
  void testNewNamedOperationResolver_whenNull_thenReturnSuffixCacheNameIsNull() {
    // Arrange and Act
    NamedOperationResolver actualNamedOperationResolver = new NamedOperationResolver((String) null);

    // Assert
    assertNull(actualNamedOperationResolver.getSuffixCacheName());
    assertEquals(3, actualNamedOperationResolver.getDepthLimit());
  }

  /**
   * Test {@link NamedOperationResolver#NamedOperationResolver(String, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return SuffixCacheName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedOperationResolver#NamedOperationResolver(String, int)}
   */
  @Test
  @DisplayName("Test new NamedOperationResolver(String, int); when 'null'; then return SuffixCacheName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedOperationResolver.<init>(String, int)"})
  void testNewNamedOperationResolver_whenNull_thenReturnSuffixCacheNameIsNull2() {
    // Arrange and Act
    NamedOperationResolver actualNamedOperationResolver = new NamedOperationResolver((String) null, 2);

    // Assert
    assertNull(actualNamedOperationResolver.getSuffixCacheName());
    assertEquals(2, actualNamedOperationResolver.getDepthLimit());
  }

  /**
   * Test {@link NamedOperationResolver#getSuffixCacheName()}.
   * <ul>
   *   <li>Then return {@code suffix named operation cache name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedOperationResolver#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName(); then return 'suffix named operation cache name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String NamedOperationResolver.getSuffixCacheName()"})
  void testGetSuffixCacheName_thenReturnSuffixNamedOperationCacheName() {
    // Arrange, Act and Assert
    assertEquals("suffix named operation cache name",
        (new NamedOperationResolver("Suffix Named Operation Cache Name")).getSuffixCacheName());
  }

  /**
   * Test {@link NamedOperationResolver#postExecute(Object, OperationChain, Context)}.
   * <p>
   * Method under test: {@link NamedOperationResolver#postExecute(Object, OperationChain, Context)}
   */
  @Test
  @DisplayName("Test postExecute(Object, OperationChain, Context)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object NamedOperationResolver.postExecute(Object, OperationChain, Context)"})
  void testPostExecute() {
    // Arrange
    NamedOperationResolver namedOperationResolver = new NamedOperationResolver("Suffix Named Operation Cache Name");
    OperationChain<?> opChain = new OperationChain<>();

    // Act and Assert
    assertEquals("Result", namedOperationResolver.postExecute("Result", opChain, new Context()));
  }

  /**
   * Test {@link NamedOperationResolver#onFailure(Object, OperationChain, Context, Exception)}.
   * <p>
   * Method under test: {@link NamedOperationResolver#onFailure(Object, OperationChain, Context, Exception)}
   */
  @Test
  @DisplayName("Test onFailure(Object, OperationChain, Context, Exception)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object NamedOperationResolver.onFailure(Object, OperationChain, Context, Exception)"})
  void testOnFailure() {
    // Arrange
    NamedOperationResolver namedOperationResolver = new NamedOperationResolver("Suffix Named Operation Cache Name");
    OperationChain<?> opChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertEquals("Result", namedOperationResolver.onFailure("Result", opChain, context, new Exception("foo")));
  }
}
