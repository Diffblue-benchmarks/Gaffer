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

package uk.gov.gchq.gaffer.operation.impl.get;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;

class GetGraphCreatedTimeDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link GetGraphCreatedTime.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    GetGraphCreatedTime.Builder actualBuilder = new GetGraphCreatedTime.Builder();

    // Assert
    GetGraphCreatedTime _getOpResult = actualBuilder._getOp();
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.String>", outputType.getTypeName());
    assertNull(_getOpResult.getOptions());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, _getOpResult.getOutputTypeReference().getType());
  }

  /**
   * Method under test: {@link GetGraphCreatedTime#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    Operation actualShallowCloneResult = (new GetGraphCreatedTime()).shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof GetGraphCreatedTime);
    Type outputType = ((GetGraphCreatedTime) actualShallowCloneResult).getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.String>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, ((GetGraphCreatedTime) actualShallowCloneResult).getOutputClass());
    assertSame(outputType, ((GetGraphCreatedTime) actualShallowCloneResult).getOutputTypeReference().getType());
  }

  /**
   * Method under test: {@link GetGraphCreatedTime#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    GetGraphCreatedTime getGraphCreatedTime = new GetGraphCreatedTime();
    getGraphCreatedTime.setOptions(new HashMap<>());

    // Act
    Operation actualShallowCloneResult = getGraphCreatedTime.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof GetGraphCreatedTime);
    Type outputType = ((GetGraphCreatedTime) actualShallowCloneResult).getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.String>", outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, ((GetGraphCreatedTime) actualShallowCloneResult).getOutputClass());
    assertSame(outputType, ((GetGraphCreatedTime) actualShallowCloneResult).getOutputTypeReference().getType());
  }

  /**
   * Method under test: {@link GetGraphCreatedTime#shallowClone()}
   */
  @Test
  void testShallowClone3() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetGraphCreatedTime getGraphCreatedTime = new GetGraphCreatedTime();
    getGraphCreatedTime.setOptions(options);

    // Act
    Operation actualShallowCloneResult = getGraphCreatedTime.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof GetGraphCreatedTime);
    Type outputType = ((GetGraphCreatedTime) actualShallowCloneResult).getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.String>", outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, ((GetGraphCreatedTime) actualShallowCloneResult).getOutputClass());
    assertSame(outputType, ((GetGraphCreatedTime) actualShallowCloneResult).getOutputTypeReference().getType());
  }

  /**
   * Method under test: {@link GetGraphCreatedTime#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map<java.lang.String, java.lang.String>",
        (new GetGraphCreatedTime()).getOutputTypeReference().getType().getTypeName());
  }

  /**
   * Method under test: {@link GetGraphCreatedTime#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetGraphCreatedTime getGraphCreatedTime = new GetGraphCreatedTime();
    getGraphCreatedTime.setOptions(options);

    // Act and Assert
    assertEquals("java.util.Map<java.lang.String, java.lang.String>",
        getGraphCreatedTime.getOutputTypeReference().getType().getTypeName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetGraphCreatedTime}
   *   <li>{@link GetGraphCreatedTime#setOptions(Map)}
   *   <li>{@link GetGraphCreatedTime#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GetGraphCreatedTime actualGetGraphCreatedTime = new GetGraphCreatedTime();
    HashMap<String, String> options = new HashMap<>();
    actualGetGraphCreatedTime.setOptions(options);
    Map<String, String> actualOptions = actualGetGraphCreatedTime.getOptions();

    // Assert that nothing has changed
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
