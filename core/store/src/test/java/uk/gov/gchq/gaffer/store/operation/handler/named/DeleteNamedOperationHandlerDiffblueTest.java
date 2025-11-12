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
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedOperationCache;

class DeleteNamedOperationHandlerDiffblueTest {
  /**
   * Method under test: {@link DeleteNamedOperationHandler#getSuffixCacheName()}
   */
  @Test
  void testGetSuffixCacheName() {
    // Arrange, Act and Assert
    assertEquals("suffix named operation cache name",
        (new DeleteNamedOperationHandler("Suffix Named Operation Cache Name")).getSuffixCacheName());
  }

  /**
   * Method under test:
   * {@link DeleteNamedOperationHandler#DeleteNamedOperationHandler(NamedOperationCache)}
   */
  @Test
  void testNewDeleteNamedOperationHandler() {
    // Arrange, Act and Assert
    assertEquals("suffix named operation cache name",
        (new DeleteNamedOperationHandler(new NamedOperationCache("Suffix Named Operation Cache Name")))
            .getSuffixCacheName());
    assertEquals("suffix named operation cache name",
        (new DeleteNamedOperationHandler("Suffix Named Operation Cache Name")).getSuffixCacheName());
    assertNull((new DeleteNamedOperationHandler((String) null)).getSuffixCacheName());
  }
}
