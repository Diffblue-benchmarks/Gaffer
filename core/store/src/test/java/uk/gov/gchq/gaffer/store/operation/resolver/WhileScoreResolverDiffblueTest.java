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

package uk.gov.gchq.gaffer.store.operation.resolver;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.While;

class WhileScoreResolverDiffblueTest {
  /**
   * Method under test: {@link WhileScoreResolver#getScore(While)}
   */
  @Test
  void testGetScore() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new WhileScoreResolver()).getScore(null));
  }
}
