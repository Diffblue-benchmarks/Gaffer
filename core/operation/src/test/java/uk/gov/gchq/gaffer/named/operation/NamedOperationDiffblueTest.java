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

package uk.gov.gchq.gaffer.named.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation.Builder;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.impl.OperationImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class NamedOperationDiffblueTest {
  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualNameResult = builder.name("Name");

    // Assert
    assertSame(builder, actualNameResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder<Object, Object> actualBuilder = new Builder<>();

    // Assert
    NamedOperation<Object, Object> _getOpResult = actualBuilder._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOperationName());
    assertNull(_getOpResult.getParameters());
    assertNull(_getOpResult.getOptions());
    assertTrue(_getOpResult.getOperations().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, _getOpResult.getOperationsClass());
    NamedOperation<Object, Object> actualNamedOperation = actualBuilder.build();
    assertSame(_getOpResult, actualNamedOperation);
  }

  /**
   * Test Builder {@link Builder#parameters(Map)}.
   *
   * <p>Method under test: {@link Builder#parameters(Map)}
   */
  @Test
  @DisplayName("Test Builder parameters(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parameters(Map)"})
  void testBuilderParameters() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualParametersResult = builder.parameters(new HashMap<>());

    // Assert
    assertSame(builder, actualParametersResult);
  }

  /**
   * Test {@link NamedOperation#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperation#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable NamedOperation.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act and Assert
    assertNull(namedOperation.getInput());
  }

  /**
   * Test {@link NamedOperation#setParameters(Map)} with {@code Map}.
   *
   * <ul>
   *   <li>Then {@link NamedOperation} (default constructor) Parameters is {@link
   *       LinkedHashMap#LinkedHashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperation#setParameters(Map)}
   */
  @Test
  @DisplayName(
      "Test setParameters(Map) with 'Map'; then NamedOperation (default constructor) Parameters is LinkedHashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedOperation.setParameters(Map)"})
  void testSetParametersWithMap_thenNamedOperationParametersIsLinkedHashMap() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

    // Act
    namedOperation.setParameters((Map<String, Object>) parameters);

    // Assert
    assertSame(parameters, namedOperation.getParameters());
  }

  /**
   * Test {@link NamedOperation#setParameters(Map)} with {@code Map}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link NamedOperation} (default constructor) Parameters Empty.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperation#setParameters(Map)}
   */
  @Test
  @DisplayName(
      "Test setParameters(Map) with 'Map'; when HashMap(); then NamedOperation (default constructor) Parameters Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedOperation.setParameters(Map)"})
  void testSetParametersWithMap_whenHashMap_thenNamedOperationParametersEmpty() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act
    namedOperation.setParameters(new HashMap<>());

    // Assert
    assertTrue(namedOperation.getParameters().isEmpty());
  }

  /**
   * Test {@link NamedOperation#setParameters(Map)} with {@code Map}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link NamedOperation} (default constructor) Parameters is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperation#setParameters(Map)}
   */
  @Test
  @DisplayName(
      "Test setParameters(Map) with 'Map'; when 'null'; then NamedOperation (default constructor) Parameters is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedOperation.setParameters(Map)"})
  void testSetParametersWithMap_whenNull_thenNamedOperationParametersIsNull() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act
    namedOperation.setParameters((Map<String, Object>) null);

    // Assert that nothing has changed
    assertNull(namedOperation.getParameters());
  }

  /**
   * Test {@link NamedOperation#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link NamedOperation#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.core.type.TypeReference NamedOperation.getOutputTypeReference()"
  })
  void testGetOutputTypeReference() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act and Assert
    assertTrue(namedOperation.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test {@link NamedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link NamedOperation} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperation#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given NamedOperation (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamedOperation NamedOperation.shallowClone()"})
  void testShallowClone_givenNamedOperationOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setOptions(new HashMap<>());

    // Act
    NamedOperation actualShallowCloneResult = namedOperation.shallowClone();

    // Assert
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOperationName());
    assertNull(actualShallowCloneResult.getParameters());
    assertTrue(actualShallowCloneResult.getOperations().isEmpty());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
  }

  /**
   * Test {@link NamedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link NamedOperation} (default constructor).
   *   <li>Then return Parameters is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperation#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given NamedOperation (default constructor); then return Parameters is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamedOperation NamedOperation.shallowClone()"})
  void testShallowClone_givenNamedOperation_thenReturnParametersIsNull() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act
    NamedOperation actualShallowCloneResult = namedOperation.shallowClone();

    // Assert
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOperationName());
    assertNull(actualShallowCloneResult.getParameters());
    assertNull(actualShallowCloneResult.getOptions());
    assertTrue(actualShallowCloneResult.getOperations().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
  }

  /**
   * Test {@link NamedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Parameters Empty.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperation#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Parameters Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamedOperation NamedOperation.shallowClone()"})
  void testShallowClone_thenReturnParametersEmpty() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setParameters(new LinkedHashMap<>());

    // Act
    NamedOperation actualShallowCloneResult = namedOperation.shallowClone();

    // Assert
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOperationName());
    assertNull(actualShallowCloneResult.getOptions());
    assertTrue(actualShallowCloneResult.getOperations().isEmpty());
    assertTrue(actualShallowCloneResult.getParameters().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
  }

  /**
   * Test {@link NamedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashMap#LinkedHashMap()} {@code foo} is {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperation#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); given LinkedHashMap() 'foo' is '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List NamedOperation.getOperations()"})
  void testGetOperations_givenLinkedHashMapFooIs42_thenReturnEmpty() {
    // Arrange
    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
    parameters.put("foo", "42");

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setParameters(parameters);

    // Act and Assert
    assertTrue(namedOperation.getOperations().isEmpty());
  }

  /**
   * Test {@link NamedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashMap#LinkedHashMap()} {@code foo} is {@link OperationImpl} (default
   *       constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperation#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given LinkedHashMap() 'foo' is OperationImpl (default constructor); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List NamedOperation.getOperations()"})
  void testGetOperations_givenLinkedHashMapFooIsOperationImpl_thenReturnSizeIsOne() {
    // Arrange
    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
    OperationImpl operationImpl = new OperationImpl();
    parameters.put("foo", operationImpl);

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setParameters(parameters);

    // Act
    List<Operation> actualOperations = namedOperation.getOperations();

    // Assert
    assertEquals(1, actualOperations.size());
    assertSame(operationImpl, actualOperations.get(0));
  }

  /**
   * Test {@link NamedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link NamedOperation} (default constructor) Parameters is {@link
   *       LinkedHashMap#LinkedHashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperation#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given NamedOperation (default constructor) Parameters is LinkedHashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List NamedOperation.getOperations()"})
  void testGetOperations_givenNamedOperationParametersIsLinkedHashMap_thenReturnEmpty() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.setParameters(new LinkedHashMap<>());

    // Act and Assert
    assertTrue(namedOperation.getOperations().isEmpty());
  }

  /**
   * Test {@link NamedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link NamedOperation} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperation#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given NamedOperation (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List NamedOperation.getOperations()"})
  void testGetOperations_givenNamedOperation_thenReturnEmpty() {
    // Arrange
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();

    // Act and Assert
    assertTrue(namedOperation.getOperations().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NamedOperation}
   *   <li>{@link NamedOperation#setInput(Iterable)}
   *   <li>{@link NamedOperation#setOperationName(String)}
   *   <li>{@link NamedOperation#setOptions(Map)}
   *   <li>{@link NamedOperation#setParameters(LinkedHashMap)}
   *   <li>{@link NamedOperation#getOperationName()}
   *   <li>{@link NamedOperation#getOptions()}
   *   <li>{@link NamedOperation#getParameters()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NamedOperation.<init>()",
    "String NamedOperation.getOperationName()",
    "Map NamedOperation.getOptions()",
    "Map NamedOperation.getParameters()",
    "void NamedOperation.setInput(Iterable)",
    "void NamedOperation.setOperationName(String)",
    "void NamedOperation.setOptions(Map)",
    "void NamedOperation.setParameters(LinkedHashMap)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NamedOperation<Object, Object> actualNamedOperation = new NamedOperation<>();
    ArrayList<Object> input = new ArrayList<>();
    actualNamedOperation.setInput(input);
    actualNamedOperation.setOperationName("Operation Name");
    HashMap<String, String> options = new HashMap<>();
    actualNamedOperation.setOptions(options);
    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
    actualNamedOperation.setParameters(parameters);
    String actualOperationName = actualNamedOperation.getOperationName();
    Map<String, String> actualOptions = actualNamedOperation.getOptions();
    Map<String, Object> actualParameters = actualNamedOperation.getParameters();

    // Assert
    Iterable<?> input2 = actualNamedOperation.getInput();
    assertTrue(input2 instanceof List);
    assertEquals("Operation Name", actualOperationName);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualParameters.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(parameters, actualParameters);
  }
}
