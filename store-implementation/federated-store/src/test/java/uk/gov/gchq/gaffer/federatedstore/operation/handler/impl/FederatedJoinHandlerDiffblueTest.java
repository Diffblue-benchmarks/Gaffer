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

package uk.gov.gchq.gaffer.federatedstore.operation.handler.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.operation.AddGraph;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.impl.join.Join;

class FederatedJoinHandlerDiffblueTest {
  /**
   * Test {@link FederatedJoinHandler#getOperationFromJoin(Join)}.
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor).</li>
   *   <li>Then return {@link AddGraph}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedJoinHandler#getOperationFromJoin(Join)}
   */
  @Test
  @DisplayName("Test getOperationFromJoin(Join); given AddGraph (default constructor); then return AddGraph")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation FederatedJoinHandler.getOperationFromJoin(Join)"})
  void testGetOperationFromJoin_givenAddGraph_thenReturnAddGraph() {
    // Arrange
    FederatedJoinHandler<Object> federatedJoinHandler = new FederatedJoinHandler<>();

    Join<Object> join = new Join<>();
    join.setOperation(new AddGraph());

    // Act
    Operation actualOperationFromJoin = federatedJoinHandler.getOperationFromJoin(join);

    // Assert
    assertTrue(actualOperationFromJoin instanceof AddGraph);
    assertNull(((AddGraph) actualOperationFromJoin).getGraphId());
    assertNull(((AddGraph) actualOperationFromJoin).getParentPropertiesId());
    assertNull(((AddGraph) actualOperationFromJoin).getParentSchemaIds());
    assertNull(actualOperationFromJoin.getOptions());
    assertNull(((AddGraph) actualOperationFromJoin).getProperties());
    assertNull(((AddGraph) actualOperationFromJoin).getGraphAuths());
    assertNull(((AddGraph) actualOperationFromJoin).getReadAccessPredicate());
    assertNull(((AddGraph) actualOperationFromJoin).getWriteAccessPredicate());
    assertNull(((AddGraph) actualOperationFromJoin).getStoreProperties());
    assertNull(((AddGraph) actualOperationFromJoin).getSchema());
    assertFalse(((AddGraph) actualOperationFromJoin).getIsPublic());
    assertFalse(((AddGraph) actualOperationFromJoin).isUserRequestingAdminUsage());
  }
}
