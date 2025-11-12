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
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GetFromEndpointDiffblueTest {
  /**
   * Method under test: {@link GetFromEndpoint.Builder#endpoint(String)}
   */
  @Test
  void testBuilderEndpoint() {
    // Arrange
    GetFromEndpoint.Builder builder = new GetFromEndpoint.Builder();

    // Act and Assert
    assertSame(builder, builder.endpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link GetFromEndpoint.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    GetFromEndpoint.Builder actualBuilder = new GetFromEndpoint.Builder();

    // Assert
    GetFromEndpoint _getOpResult = actualBuilder._getOp();
    TypeReference<String> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.String);
    assertNull(_getOpResult.getEndpoint());
    assertNull(_getOpResult.getOptions());
    Class<String> expectedOutputClass = String.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Method under test: {@link GetFromEndpoint#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    GetFromEndpoint actualShallowCloneResult = (new GetFromEndpoint()).shallowClone();

    // Assert
    TypeReference<String> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.String);
    assertNull(actualShallowCloneResult.getEndpoint());
    assertNull(actualShallowCloneResult.getOptions());
    Class<String> expectedOutputClass = String.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link GetFromEndpoint#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    GetFromEndpoint getFromEndpoint = new GetFromEndpoint();
    getFromEndpoint.setOptions(new HashMap<>());

    // Act
    GetFromEndpoint actualShallowCloneResult = getFromEndpoint.shallowClone();

    // Assert
    TypeReference<String> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.String);
    assertNull(actualShallowCloneResult.getEndpoint());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<String> expectedOutputClass = String.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link GetFromEndpoint#shallowClone()}
   */
  @Test
  void testShallowClone3() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetFromEndpoint getFromEndpoint = new GetFromEndpoint();
    getFromEndpoint.setOptions(options);

    // Act
    GetFromEndpoint actualShallowCloneResult = getFromEndpoint.shallowClone();

    // Assert
    TypeReference<String> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.String);
    assertNull(actualShallowCloneResult.getEndpoint());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<String> expectedOutputClass = String.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link GetFromEndpoint#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue((new GetFromEndpoint()).getOutputTypeReference() instanceof TypeReferenceImpl.String);
  }

  /**
   * Method under test: {@link GetFromEndpoint#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetFromEndpoint getFromEndpoint = new GetFromEndpoint();
    getFromEndpoint.setOptions(options);

    // Act and Assert
    assertTrue(getFromEndpoint.getOutputTypeReference() instanceof TypeReferenceImpl.String);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetFromEndpoint}
   *   <li>{@link GetFromEndpoint#setEndpoint(String)}
   *   <li>{@link GetFromEndpoint#setOptions(Map)}
   *   <li>{@link GetFromEndpoint#getEndpoint()}
   *   <li>{@link GetFromEndpoint#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GetFromEndpoint actualGetFromEndpoint = new GetFromEndpoint();
    actualGetFromEndpoint.setEndpoint("https://config.us-east-2.amazonaws.com");
    HashMap<String, String> options = new HashMap<>();
    actualGetFromEndpoint.setOptions(options);
    String actualEndpoint = actualGetFromEndpoint.getEndpoint();
    Map<String, String> actualOptions = actualGetFromEndpoint.getOptions();

    // Assert that nothing has changed
    assertEquals("https://config.us-east-2.amazonaws.com", actualEndpoint);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
