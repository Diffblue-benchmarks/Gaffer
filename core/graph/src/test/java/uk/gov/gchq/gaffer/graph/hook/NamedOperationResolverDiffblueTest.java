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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedOperationCache;

class NamedOperationResolverDiffblueTest {
  /**
   * Method under test: {@link NamedOperationResolver#getSuffixCacheName()}
   */
  @Test
  void testGetSuffixCacheName() {
    // Arrange, Act and Assert
    assertEquals("suffix named operation cache name",
        (new NamedOperationResolver("Suffix Named Operation Cache Name")).getSuffixCacheName());
  }

  /**
   * Method under test:
   * {@link NamedOperationResolver#preExecute(OperationChain, Context)}
   */
  @Test
  void testPreExecute() {
    // Arrange
    NamedOperationResolver namedOperationResolver = new NamedOperationResolver("Suffix Named Operation Cache Name");
    OperationChain<?> opChain = mock(OperationChain.class);
    doNothing().when(opChain).updateOperations(Mockito.<Collection<Operation>>any());
    when(opChain.getOperations()).thenReturn(new ArrayList<>());

    // Act
    namedOperationResolver.preExecute(opChain, new Context());

    // Assert
    verify(opChain, atLeast(1)).getOperations();
    verify(opChain).updateOperations(isA(Collection.class));
  }

  /**
   * Method under test:
   * {@link NamedOperationResolver#postExecute(Object, OperationChain, Context)}
   */
  @Test
  void testPostExecute() {
    // Arrange
    NamedOperationResolver namedOperationResolver = new NamedOperationResolver("Suffix Named Operation Cache Name");
    OperationChain<?> opChain = new OperationChain<>();

    // Act and Assert
    assertEquals("Result", namedOperationResolver.postExecute("Result", opChain, new Context()));
  }

  /**
   * Method under test:
   * {@link NamedOperationResolver#onFailure(Object, OperationChain, Context, Exception)}
   */
  @Test
  void testOnFailure() {
    // Arrange
    NamedOperationResolver namedOperationResolver = new NamedOperationResolver("Suffix Named Operation Cache Name");
    OperationChain<?> opChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertEquals("Result", namedOperationResolver.onFailure("Result", opChain, context, new Exception("foo")));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link NamedOperationResolver#NamedOperationResolver(NamedOperationCache)}
   *   <li>{@link NamedOperationResolver#getDepthLimit()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(3,
        (new NamedOperationResolver(new NamedOperationCache("Suffix Named Operation Cache Name"))).getDepthLimit());
    assertEquals(2,
        (new NamedOperationResolver(new NamedOperationCache("Suffix Named Operation Cache Name"), 2)).getDepthLimit());
  }

  /**
   * Method under test:
   * {@link NamedOperationResolver#NamedOperationResolver(String)}
   */
  @Test
  void testNewNamedOperationResolver() {
    // Arrange and Act
    NamedOperationResolver actualNamedOperationResolver = new NamedOperationResolver(
        "Suffix Named Operation Cache Name");

    // Assert
    assertEquals("suffix named operation cache name", actualNamedOperationResolver.getSuffixCacheName());
    assertEquals(3, actualNamedOperationResolver.getDepthLimit());
  }

  /**
   * Method under test:
   * {@link NamedOperationResolver#NamedOperationResolver(String)}
   */
  @Test
  void testNewNamedOperationResolver2() {
    // Arrange and Act
    NamedOperationResolver actualNamedOperationResolver = new NamedOperationResolver((String) null);

    // Assert
    assertNull(actualNamedOperationResolver.getSuffixCacheName());
    assertEquals(3, actualNamedOperationResolver.getDepthLimit());
  }

  /**
   * Method under test:
   * {@link NamedOperationResolver#NamedOperationResolver(String, int)}
   */
  @Test
  void testNewNamedOperationResolver3() {
    // Arrange and Act
    NamedOperationResolver actualNamedOperationResolver = new NamedOperationResolver(
        "Suffix Named Operation Cache Name", 2);

    // Assert
    assertEquals("suffix named operation cache name", actualNamedOperationResolver.getSuffixCacheName());
    assertEquals(2, actualNamedOperationResolver.getDepthLimit());
  }

  /**
   * Method under test:
   * {@link NamedOperationResolver#NamedOperationResolver(String, int)}
   */
  @Test
  void testNewNamedOperationResolver4() {
    // Arrange and Act
    NamedOperationResolver actualNamedOperationResolver = new NamedOperationResolver((String) null, 2);

    // Assert
    assertNull(actualNamedOperationResolver.getSuffixCacheName());
    assertEquals(2, actualNamedOperationResolver.getDepthLimit());
  }
}
