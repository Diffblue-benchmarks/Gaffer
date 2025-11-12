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

package uk.gov.gchq.gaffer.operation.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.GetAllNamedOperations;

class OutputDiffblueTest {
  /**
   * Method under test: {@link Output#getOutputClass()}
   */
  @Test
  void testGetOutputClass() {
    // Arrange and Act
    Class<?> actualOutputClass = (new GetAllNamedOperations()).getOutputClass();

    // Assert
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualOutputClass);
  }

  /**
   * Method under test: {@link Output#getOutputClass()}
   */
  @Test
  void testGetOutputClass2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetAllNamedOperations getAllNamedOperations = new GetAllNamedOperations();
    getAllNamedOperations.setOptions(options);

    // Act
    Class<?> actualOutputClass = getAllNamedOperations.getOutputClass();

    // Assert
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualOutputClass);
  }

  /**
   * Method under test: {@link Output#getOutputType()}
   */
  @Test
  void testGetOutputType() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        (new GetAllNamedOperations()).getOutputType().getTypeName());
  }

  /**
   * Method under test: {@link Output#getOutputType()}
   */
  @Test
  void testGetOutputType2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetAllNamedOperations getAllNamedOperations = new GetAllNamedOperations();
    getAllNamedOperations.setOptions(options);

    // Act and Assert
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        getAllNamedOperations.getOutputType().getTypeName());
  }
}
