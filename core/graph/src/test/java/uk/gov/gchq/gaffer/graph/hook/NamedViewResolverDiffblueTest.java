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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedViewCache;

class NamedViewResolverDiffblueTest {
  /**
   * Method under test: {@link NamedViewResolver#getSuffixCacheName()}
   */
  @Test
  void testGetSuffixCacheName() {
    // Arrange, Act and Assert
    assertEquals("suffix named view cache name",
        (new NamedViewResolver("Suffix Named View Cache Name")).getSuffixCacheName());
  }

  /**
   * Method under test:
   * {@link NamedViewResolver#preExecute(OperationChain, Context)}
   */
  @Test
  void testPreExecute() {
    // Arrange
    NamedViewResolver namedViewResolver = new NamedViewResolver("Suffix Named View Cache Name");
    OperationChain<?> opChain = mock(OperationChain.class);
    when(opChain.getOperations()).thenReturn(new ArrayList<>());

    // Act
    namedViewResolver.preExecute(opChain, new Context());

    // Assert
    verify(opChain).getOperations();
  }

  /**
   * Method under test:
   * {@link NamedViewResolver#postExecute(Object, OperationChain, Context)}
   */
  @Test
  void testPostExecute() {
    // Arrange
    NamedViewResolver namedViewResolver = new NamedViewResolver("Suffix Named View Cache Name");
    OperationChain<?> opChain = new OperationChain<>();

    // Act and Assert
    assertEquals("Result", namedViewResolver.postExecute("Result", opChain, new Context()));
  }

  /**
   * Method under test:
   * {@link NamedViewResolver#onFailure(Object, OperationChain, Context, Exception)}
   */
  @Test
  void testOnFailure() {
    // Arrange
    NamedViewResolver namedViewResolver = new NamedViewResolver("Suffix Named View Cache Name");
    OperationChain<?> opChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertEquals("Result", namedViewResolver.onFailure("Result", opChain, context, new Exception("foo")));
  }

  /**
   * Method under test:
   * {@link NamedViewResolver#NamedViewResolver(NamedViewCache)}
   */
  @Test
  void testNewNamedViewResolver() {
    // Arrange, Act and Assert
    assertEquals("suffix named view cache name",
        (new NamedViewResolver(new NamedViewCache("Suffix Named View Cache Name"))).getSuffixCacheName());
    assertEquals("suffix named view cache name",
        (new NamedViewResolver("Suffix Named View Cache Name")).getSuffixCacheName());
  }
}
