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

package uk.gov.gchq.gaffer.tinkerpop.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.apache.tinkerpop.gremlin.structure.service.Service;
import org.apache.tinkerpop.gremlin.structure.service.Service.Type;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GafferPopNamedOperationServiceFactoryDiffblueTest {
  /**
   * Test {@link GafferPopNamedOperationServiceFactory#getSupportedTypes()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopNamedOperationServiceFactory#getSupportedTypes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set GafferPopNamedOperationServiceFactory.getSupportedTypes()"})
  public void testGetSupportedTypes_thenReturnSizeIsOne() {
    // Arrange
    GafferPopNamedOperationServiceFactory<Object, Object> gafferPopNamedOperationServiceFactory = new GafferPopNamedOperationServiceFactory<>(
        null);

    // Act
    Set<Type> actualSupportedTypes = gafferPopNamedOperationServiceFactory.getSupportedTypes();

    // Assert
    assertEquals(1, actualSupportedTypes.size());
    assertTrue(actualSupportedTypes.contains(Type.Start));
  }
}
