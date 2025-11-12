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

package uk.gov.gchq.gaffer.store.operation.resolver.named;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedOperationCache;
import uk.gov.gchq.gaffer.store.operation.resolver.ScoreResolver;

class NamedOperationScoreResolverDiffblueTest {
  /**
   * Method under test: {@link NamedOperationScoreResolver#getSuffixCacheName()}
   */
  @Test
  void testGetSuffixCacheName() {
    // Arrange, Act and Assert
    assertEquals("suffix named operation cache name",
        (new NamedOperationScoreResolver("Suffix Named Operation Cache Name")).getSuffixCacheName());
  }

  /**
   * Method under test:
   * {@link NamedOperationScoreResolver#getScore(NamedOperation)}
   */
  @Test
  void testGetScore() {
    // Arrange
    NamedOperationScoreResolver namedOperationScoreResolver = new NamedOperationScoreResolver(
        "Suffix Named Operation Cache Name");

    // Act and Assert
    assertNull(namedOperationScoreResolver.getScore(new NamedOperation()));
  }

  /**
   * Method under test:
   * {@link NamedOperationScoreResolver#getScore(NamedOperation)}
   */
  @Test
  void testGetScore2() {
    // Arrange, Act and Assert
    assertEquals(0, (new NamedOperationScoreResolver("Suffix Named Operation Cache Name")).getScore(null).intValue());
  }

  /**
   * Method under test:
   * {@link NamedOperationScoreResolver#getScore(NamedOperation, ScoreResolver)}
   */
  @Test
  void testGetScore3() {
    // Arrange
    NamedOperationScoreResolver namedOperationScoreResolver = new NamedOperationScoreResolver(
        "Suffix Named Operation Cache Name");

    // Act and Assert
    assertEquals(0, namedOperationScoreResolver.getScore(new NamedOperation(), mock(ScoreResolver.class)).intValue());
  }

  /**
   * Method under test:
   * {@link NamedOperationScoreResolver#NamedOperationScoreResolver(NamedOperationCache)}
   */
  @Test
  void testNewNamedOperationScoreResolver() {
    // Arrange, Act and Assert
    assertEquals("suffix named operation cache name",
        (new NamedOperationScoreResolver(new NamedOperationCache("Suffix Named Operation Cache Name")))
            .getSuffixCacheName());
    assertEquals("suffix named operation cache name",
        (new NamedOperationScoreResolver("Suffix Named Operation Cache Name")).getSuffixCacheName());
    assertNull((new NamedOperationScoreResolver((String) null)).getSuffixCacheName());
  }
}
