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

package uk.gov.gchq.gaffer.store.operation.handler.join;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.join.Join;

class JoinHandlerDiffblueTest {
  /**
   * Test {@link JoinHandler#getOperationFromJoin(Join)}.
   * <ul>
   *   <li>When {@link Join} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JoinHandler#getOperationFromJoin(Join)}
   */
  @Test
  @DisplayName("Test getOperationFromJoin(Join); when Join (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"uk.gov.gchq.gaffer.operation.Operation JoinHandler.getOperationFromJoin(Join)"})
  void testGetOperationFromJoin_whenJoin_thenReturnNull() {
    // Arrange
    JoinHandler<Object> joinHandler = new JoinHandler<>();

    // Act and Assert
    assertNull(joinHandler.getOperationFromJoin(new Join<>()));
  }
}
