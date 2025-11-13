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

package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.GetVariables.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.MapStringObject;

class GetVariablesDiffblueTest {
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
    GetVariables _getOpResult = actualBuilder._getOp();
    TypeReference<Map<String, Object>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof MapStringObject);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>", outputType.getTypeName());
    assertNull(_getOpResult.getVariableNames());
    assertNull(_getOpResult.getOptions());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test Builder {@link Builder#variableNames(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#variableNames(List)}
   */
  @Test
  @DisplayName("Test Builder variableNames(List); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.variableNames(List)"})
  void testBuilderVariableNames_given42_whenArrayListAdd42() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> variableNames = new ArrayList<>();
    variableNames.add("42");
    variableNames.add("foo");

    // Act and Assert
    assertSame(builder, builder.variableNames(variableNames));
  }

  /**
   * Test Builder {@link Builder#variableNames(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#variableNames(List)}
   */
  @Test
  @DisplayName("Test Builder variableNames(List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.variableNames(List)"})
  void testBuilderVariableNames_givenFoo_whenArrayListAddFoo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> variableNames = new ArrayList<>();
    variableNames.add("foo");

    // Act and Assert
    assertSame(builder, builder.variableNames(variableNames));
  }

  /**
   * Test Builder {@link Builder#variableNames(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#variableNames(List)}
   */
  @Test
  @DisplayName("Test Builder variableNames(List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.variableNames(List)"})
  void testBuilderVariableNames_whenArrayList() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.variableNames(new ArrayList<>()));
  }

  /**
   * Test {@link GetVariables#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link GetVariables#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference GetVariables.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Map<String, Object>> actualOutputTypeReference = (new GetVariables()).getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof MapStringObject);
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetVariables#shallowClone()}.
   * <ul>
   *   <li>Given {@link GetVariables} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetVariables#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetVariables (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetVariables GetVariables.shallowClone()"})
  void testShallowClone_givenGetVariablesOptionsIsHashMap_thenReturnOptionsEmpty() throws CloneFailedException {
    // Arrange
    GetVariables getVariables = new GetVariables();
    getVariables.setOptions(new HashMap<>());

    // Act
    GetVariables actualShallowCloneResult = getVariables.shallowClone();

    // Assert
    TypeReference<Map<String, Object>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof MapStringObject);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getVariableNames());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetVariables#shallowClone()}.
   * <ul>
   *   <li>Given {@link GetVariables} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetVariables#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetVariables (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetVariables GetVariables.shallowClone()"})
  void testShallowClone_givenGetVariables_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    GetVariables actualShallowCloneResult = (new GetVariables()).shallowClone();

    // Assert
    TypeReference<Map<String, Object>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof MapStringObject);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getVariableNames());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetVariables}
   *   <li>{@link GetVariables#setOptions(Map)}
   *   <li>{@link GetVariables#setVariableNames(List)}
   *   <li>{@link GetVariables#getOptions()}
   *   <li>{@link GetVariables#getVariableNames()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetVariables.<init>()", "Map GetVariables.getOptions()",
      "List GetVariables.getVariableNames()", "void GetVariables.setOptions(Map)",
      "void GetVariables.setVariableNames(List)"})
  void testGettersAndSetters() {
    // Arrange and Act
    GetVariables actualGetVariables = new GetVariables();
    HashMap<String, String> options = new HashMap<>();
    actualGetVariables.setOptions(options);
    ArrayList<String> variableNames = new ArrayList<>();
    actualGetVariables.setVariableNames(variableNames);
    Map<String, String> actualOptions = actualGetVariables.getOptions();
    List<String> actualVariableNames = actualGetVariables.getVariableNames();

    // Assert
    assertTrue(actualVariableNames.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(variableNames, actualVariableNames);
    assertSame(options, actualOptions);
  }
}
