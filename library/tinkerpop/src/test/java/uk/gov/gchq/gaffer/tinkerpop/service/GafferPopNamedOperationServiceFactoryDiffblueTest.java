/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.tinkerpop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.tinkerpop.gremlin.structure.service.Service;
import org.apache.tinkerpop.gremlin.structure.service.Service.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GafferPopNamedOperationServiceFactoryDiffblueTest {
  /**
   * Test {@link GafferPopNamedOperationServiceFactory#getSupportedTypes()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopNamedOperationServiceFactory#getSupportedTypes()}
   */
  @Test
  @DisplayName("Test getSupportedTypes(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GafferPopNamedOperationServiceFactory.getSupportedTypes()"})
  void testGetSupportedTypes_thenReturnSizeIsOne() {
    // Arrange
    GafferPopNamedOperationServiceFactory<Object, Object> gafferPopNamedOperationServiceFactory =
        new GafferPopNamedOperationServiceFactory<>(null);

    // Act
    Set<Type> actualSupportedTypes = gafferPopNamedOperationServiceFactory.getSupportedTypes();

    // Assert
    assertEquals(1, actualSupportedTypes.size());
    assertTrue(actualSupportedTypes.contains(Type.Start));
  }

  /**
   * Test {@link GafferPopNamedOperationServiceFactory#createService(boolean, Map)}.
   *
   * <ul>
   *   <li>Then return {@link GafferPopNamedOperationService}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopNamedOperationServiceFactory#createService(boolean, Map)}
   */
  @Test
  @DisplayName("Test createService(boolean, Map); then return GafferPopNamedOperationService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Service GafferPopNamedOperationServiceFactory.createService(boolean, Map)"})
  void testCreateService_thenReturnGafferPopNamedOperationService() {
    // Arrange
    GafferPopNamedOperationServiceFactory<Object, Object> gafferPopNamedOperationServiceFactory =
        new GafferPopNamedOperationServiceFactory<>(null);

    // Act
    Service<Object, Object> actualCreateServiceResult =
        gafferPopNamedOperationServiceFactory.createService(true, new HashMap<>());
    Type actualType = actualCreateServiceResult.getType();

    // Assert
    assertTrue(actualCreateServiceResult instanceof GafferPopNamedOperationService);
    assertEquals(Type.Start, actualCreateServiceResult.getType());
    assertEquals(Type.Start, actualType);
    assertFalse(actualCreateServiceResult.isBarrier());
    assertFalse(actualCreateServiceResult.isStreaming());
    assertTrue(actualCreateServiceResult.getRequirements().isEmpty());
    assertTrue(actualCreateServiceResult.isStart());
    assertEquals(Integer.MAX_VALUE, actualCreateServiceResult.getMaxBarrierSize());
  }
}
