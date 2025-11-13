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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.get.GetFromEndpoint.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GetFromEndpointDiffblueTest {
  /**
   * Test Builder {@link Builder#endpoint(String)}.
   * <p>
   * Method under test: {@link Builder#endpoint(String)}
   */
  @Test
  @DisplayName("Test Builder endpoint(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.endpoint(String)"})
  void testBuilderEndpoint() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.endpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

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
   * Test {@link GetFromEndpoint#shallowClone()}.
   * <ul>
   *   <li>Given {@link GetFromEndpoint} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetFromEndpoint#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetFromEndpoint (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetFromEndpoint GetFromEndpoint.shallowClone()"})
  void testShallowClone_givenGetFromEndpointOptionsIsHashMap_thenReturnOptionsEmpty() throws CloneFailedException {
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
   * Test {@link GetFromEndpoint#shallowClone()}.
   * <ul>
   *   <li>Given {@link GetFromEndpoint} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetFromEndpoint#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetFromEndpoint (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetFromEndpoint GetFromEndpoint.shallowClone()"})
  void testShallowClone_givenGetFromEndpoint_thenReturnOptionsIsNull() throws CloneFailedException {
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
   * Test {@link GetFromEndpoint#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link GetFromEndpoint#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference GetFromEndpoint.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue((new GetFromEndpoint()).getOutputTypeReference() instanceof TypeReferenceImpl.String);
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetFromEndpoint.<init>()", "String GetFromEndpoint.getEndpoint()",
      "Map GetFromEndpoint.getOptions()", "void GetFromEndpoint.setEndpoint(String)",
      "void GetFromEndpoint.setOptions(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    GetFromEndpoint actualGetFromEndpoint = new GetFromEndpoint();
    actualGetFromEndpoint.setEndpoint("https://config.us-east-2.amazonaws.com");
    HashMap<String, String> options = new HashMap<>();
    actualGetFromEndpoint.setOptions(options);
    String actualEndpoint = actualGetFromEndpoint.getEndpoint();
    Map<String, String> actualOptions = actualGetFromEndpoint.getOptions();

    // Assert
    assertEquals("https://config.us-east-2.amazonaws.com", actualEndpoint);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
