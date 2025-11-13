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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.util.RawValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.predicate.AccessPredicate;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation.Builder;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationChainDAO;

class AddNamedOperationDiffblueTest {
  /**
   * Test Builder {@link Builder#description(String)}.
   *
   * <p>Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDescriptionResult =
        builder.description("The characteristics of someone or something");

    // Assert
    assertSame(builder, actualDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#labels(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#labels(List)}
   */
  @Test
  @DisplayName("Test Builder labels(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.labels(List)"})
  void testBuilderLabels_given42_whenArrayListAdd42() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> labels = new ArrayList<>();
    labels.add("42");
    labels.add("foo");

    // Act
    Builder actualLabelsResult = builder.labels(labels);

    // Assert
    assertSame(builder, actualLabelsResult);
  }

  /**
   * Test Builder {@link Builder#labels(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#labels(List)}
   */
  @Test
  @DisplayName("Test Builder labels(List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.labels(List)"})
  void testBuilderLabels_givenFoo_whenArrayListAddFoo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> labels = new ArrayList<>();
    labels.add("foo");

    // Act
    Builder actualLabelsResult = builder.labels(labels);

    // Assert
    assertSame(builder, actualLabelsResult);
  }

  /**
   * Test Builder {@link Builder#labels(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#labels(List)}
   */
  @Test
  @DisplayName("Test Builder labels(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.labels(List)"})
  void testBuilderLabels_whenArrayList() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualLabelsResult = builder.labels(new ArrayList<>());

    // Assert
    assertSame(builder, actualLabelsResult);
  }

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
    Builder builder = new Builder();

    // Act
    Builder actualNameResult = builder.name("Name");

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
    Builder actualBuilder = new Builder();

    // Assert
    Builder actualOverwriteResult = actualBuilder.overwrite();
    assertSame(actualBuilder, actualOverwriteResult);
  }

  /**
   * Test Builder {@link Builder#operationChain(String)} with {@code opChainString}.
   *
   * <p>Method under test: {@link Builder#operationChain(String)}
   */
  @Test
  @DisplayName("Test Builder operationChain(String) with 'opChainString'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operationChain(String)"})
  void testBuilderOperationChainWithOpChainString() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOperationChainResult = builder.operationChain("Op Chain String");

    // Assert
    assertSame(builder, actualOperationChainResult);
  }

  /**
   * Test Builder {@link Builder#overwrite()}.
   *
   * <p>Method under test: {@link Builder#overwrite()}
   */
  @Test
  @DisplayName("Test Builder overwrite()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.overwrite()"})
  void testBuilderOverwrite() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOverwriteResult = builder.overwrite();

    // Assert
    assertSame(builder, actualOverwriteResult);
  }

  /**
   * Test Builder {@link Builder#overwrite(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link Builder#overwrite(boolean)}
   */
  @Test
  @DisplayName("Test Builder overwrite(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.overwrite(boolean)"})
  void testBuilderOverwriteWithBoolean() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOverwriteResult = builder.overwrite(true);

    // Assert
    assertSame(builder, actualOverwriteResult);
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
    Builder builder = new Builder();

    // Act
    Builder actualParametersResult = builder.parameters(new HashMap<>());

    // Assert
    assertSame(builder, actualParametersResult);
  }

  /**
   * Test Builder {@link Builder#readAccessPredicate(AccessPredicate)}.
   *
   * <p>Method under test: {@link Builder#readAccessPredicate(AccessPredicate)}
   */
  @Test
  @DisplayName("Test Builder readAccessPredicate(AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.readAccessPredicate(AccessPredicate)"})
  void testBuilderReadAccessPredicate() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualReadAccessPredicateResult =
        builder.readAccessPredicate(new AccessPredicate(mock(Predicate.class)));

    // Assert
    assertSame(builder, actualReadAccessPredicateResult);
  }

  /**
   * Test Builder {@link Builder#readAccessRoles(String[])}.
   *
   * <p>Method under test: {@link Builder#readAccessRoles(String[])}
   */
  @Test
  @DisplayName("Test Builder readAccessRoles(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.readAccessRoles(String[])"})
  void testBuilderReadAccessRoles() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualReadAccessRolesResult = builder.readAccessRoles("Roles");

    // Assert
    assertSame(builder, actualReadAccessRolesResult);
  }

  /**
   * Test Builder {@link Builder#score(Integer)}.
   *
   * <p>Method under test: {@link Builder#score(Integer)}
   */
  @Test
  @DisplayName("Test Builder score(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.score(Integer)"})
  void testBuilderScore() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualScoreResult = builder.score(3);

    // Assert
    assertSame(builder, actualScoreResult);
  }

  /**
   * Test Builder {@link Builder#writeAccessPredicate(AccessPredicate)}.
   *
   * <p>Method under test: {@link Builder#writeAccessPredicate(AccessPredicate)}
   */
  @Test
  @DisplayName("Test Builder writeAccessPredicate(AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.writeAccessPredicate(AccessPredicate)"})
  void testBuilderWriteAccessPredicate() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualWriteAccessPredicateResult =
        builder.writeAccessPredicate(new AccessPredicate(mock(Predicate.class)));

    // Assert
    assertSame(builder, actualWriteAccessPredicateResult);
  }

  /**
   * Test Builder {@link Builder#writeAccessRoles(String[])}.
   *
   * <p>Method under test: {@link Builder#writeAccessRoles(String[])}
   */
  @Test
  @DisplayName("Test Builder writeAccessRoles(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.writeAccessRoles(String[])"})
  void testBuilderWriteAccessRoles() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualWriteAccessRolesResult = builder.writeAccessRoles("Roles");

    // Assert
    assertSame(builder, actualWriteAccessRolesResult);
  }

  /**
   * Test {@link AddNamedOperation#setOperationChain(OperationChain)} with {@code OperationChain}.
   *
   * <p>Method under test: {@link AddNamedOperation#setOperationChain(OperationChain)}
   */
  @Test
  @DisplayName("Test setOperationChain(OperationChain) with 'OperationChain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddNamedOperation.setOperationChain(OperationChain)"})
  void testSetOperationChainWithOperationChain() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    OperationChain<?> operationChain =
        OperationChain.wrap(new OperationChainDAO<>(new AddNamedOperation()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> addNamedOperation.setOperationChain(operationChain));
  }

  /**
   * Test {@link AddNamedOperation#setOperationChain(OperationChain)} with {@code OperationChain}.
   *
   * <ul>
   *   <li>Given {@code filterFieldsByName}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperation#setOperationChain(OperationChain)}
   */
  @Test
  @DisplayName(
      "Test setOperationChain(OperationChain) with 'OperationChain'; given 'filterFieldsByName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddNamedOperation.setOperationChain(OperationChain)"})
  void testSetOperationChainWithOperationChain_givenFilterFieldsByName() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();

    AddNamedOperation operation = new AddNamedOperation();
    operation.setOperationChain("filterFieldsByName");
    OperationChain<?> operationChain = OperationChain.wrap(operation);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> addNamedOperation.setOperationChain(operationChain));
  }

  /**
   * Test {@link AddNamedOperation#setOperationChain(OperationChain)} with {@code OperationChain}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperation#setOperationChain(OperationChain)}
   */
  @Test
  @DisplayName(
      "Test setOperationChain(OperationChain) with 'OperationChain'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddNamedOperation.setOperationChain(OperationChain)"})
  void testSetOperationChainWithOperationChain_thenThrowIllegalArgumentException() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    OperationChain<?> operationChain = OperationChain.wrap(new AddNamedOperation());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> addNamedOperation.setOperationChain(operationChain));
  }

  /**
   * Test {@link AddNamedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperation#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddNamedOperation (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddNamedOperation AddNamedOperation.shallowClone()"})
  void testShallowClone_givenAddNamedOperationOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.setOptions(new HashMap<>());

    // Act
    AddNamedOperation actualShallowCloneResult = addNamedOperation.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertTrue(operations instanceof List);
    assertNull(actualShallowCloneResult.getScore());
    assertNull(actualShallowCloneResult.getDescription());
    assertNull(actualShallowCloneResult.getOperationChainAsString());
    assertNull(actualShallowCloneResult.getOperationName());
    assertNull(actualShallowCloneResult.getLabels());
    assertNull(actualShallowCloneResult.getParameters());
    assertNull(actualShallowCloneResult.getReadAccessPredicate());
    assertNull(actualShallowCloneResult.getWriteAccessPredicate());
    assertFalse(actualShallowCloneResult.isOverwriteFlag());
    assertTrue(operations.isEmpty());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
  }

  /**
   * Test {@link AddNamedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).
   *   <li>Then Operations return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperation#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddNamedOperation (default constructor); then Operations return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddNamedOperation AddNamedOperation.shallowClone()"})
  void testShallowClone_givenAddNamedOperation_thenOperationsReturnList() {
    // Arrange and Act
    AddNamedOperation actualShallowCloneResult = new AddNamedOperation().shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertTrue(operations instanceof List);
    assertNull(actualShallowCloneResult.getScore());
    assertNull(actualShallowCloneResult.getDescription());
    assertNull(actualShallowCloneResult.getOperationChainAsString());
    assertNull(actualShallowCloneResult.getOperationName());
    assertNull(actualShallowCloneResult.getLabels());
    assertNull(actualShallowCloneResult.getParameters());
    assertNull(actualShallowCloneResult.getReadAccessPredicate());
    assertNull(actualShallowCloneResult.getWriteAccessPredicate());
    assertFalse(actualShallowCloneResult.isOverwriteFlag());
    assertTrue(operations.isEmpty());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
  }

  /**
   * Test {@link AddNamedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Then return ReadAccessRoles is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperation#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return ReadAccessRoles is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddNamedOperation AddNamedOperation.shallowClone()"})
  void testShallowClone_thenReturnReadAccessRolesIsNull() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    ArrayList<String> writeAccessRoles = new ArrayList<>();
    addNamedOperation.setWriteAccessRoles(writeAccessRoles);

    // Act
    AddNamedOperation actualShallowCloneResult = addNamedOperation.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getReadAccessRoles());
    assertNull(actualShallowCloneResult.getOptions());
    assertTrue(actualShallowCloneResult.getWriteAccessRoles().isEmpty());
    assertEquals(writeAccessRoles, actualShallowCloneResult.getOperations());
  }

  /**
   * Test {@link AddNamedOperation#shallowClone()}.
   *
   * <ul>
   *   <li>Then return WriteAccessRoles is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperation#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return WriteAccessRoles is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddNamedOperation AddNamedOperation.shallowClone()"})
  void testShallowClone_thenReturnWriteAccessRolesIsNull() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    ArrayList<String> readAccessRoles = new ArrayList<>();
    addNamedOperation.setReadAccessRoles(readAccessRoles);

    // Act
    AddNamedOperation actualShallowCloneResult = addNamedOperation.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getWriteAccessRoles());
    assertNull(actualShallowCloneResult.getOptions());
    assertTrue(actualShallowCloneResult.getReadAccessRoles().isEmpty());
    assertEquals(readAccessRoles, actualShallowCloneResult.getOperations());
  }

  /**
   * Test {@link AddNamedOperation#getOperationChainAsJsonNode()}.
   *
   * <p>Method under test: {@link AddNamedOperation#getOperationChainAsJsonNode()}
   */
  @Test
  @DisplayName("Test getOperationChainAsJsonNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.databind.JsonNode AddNamedOperation.getOperationChainAsJsonNode()"
  })
  void testGetOperationChainAsJsonNode() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode opChainNode = new ArrayNode(nf);
    opChainNode.addRawValue(new RawValue("foo"));
    opChainNode.add(DoubleNode.valueOf(10.0d));

    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.setOperationChain(opChainNode);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> addNamedOperation.getOperationChainAsJsonNode());
  }

  /**
   * Test {@link AddNamedOperation#getOperationChainAsJsonNode()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) OperationChain is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperation#getOperationChainAsJsonNode()}
   */
  @Test
  @DisplayName(
      "Test getOperationChainAsJsonNode(); given AddNamedOperation (default constructor) OperationChain is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.databind.JsonNode AddNamedOperation.getOperationChainAsJsonNode()"
  })
  void testGetOperationChainAsJsonNode_givenAddNamedOperationOperationChainIsFoo() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.setOperationChain("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> addNamedOperation.getOperationChainAsJsonNode());
  }

  /**
   * Test {@link AddNamedOperation#getOperations()}.
   *
   * <p>Method under test: {@link AddNamedOperation#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AddNamedOperation.getOperations()"})
  void testGetOperations() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    addNamedOperation.setOperationChain(new ArrayNode(nf));

    // Act
    Collection<Operation> actualOperations = addNamedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertTrue(actualOperations.isEmpty());
  }

  /**
   * Test {@link AddNamedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) OperationChain is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperation#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given AddNamedOperation (default constructor) OperationChain is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AddNamedOperation.getOperations()"})
  void testGetOperations_givenAddNamedOperationOperationChainIsEmptyString() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.setOperationChain("");

    // Act
    Collection<Operation> actualOperations = addNamedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertTrue(actualOperations.isEmpty());
  }

  /**
   * Test {@link AddNamedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) OperationChain is Instance.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperation#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given AddNamedOperation (default constructor) OperationChain is Instance; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AddNamedOperation.getOperations()"})
  void testGetOperations_givenAddNamedOperationOperationChainIsInstance_thenReturnList() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.setOperationChain(NullNode.getInstance());

    // Act
    Collection<Operation> actualOperations = addNamedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertTrue(actualOperations.isEmpty());
  }

  /**
   * Test {@link AddNamedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) OperationChain is {@code Operation
   *       Chain}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperation#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given AddNamedOperation (default constructor) OperationChain is 'Operation Chain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AddNamedOperation.getOperations()"})
  void testGetOperations_givenAddNamedOperationOperationChainIsOperationChain() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.setOperationChain("Operation Chain");

    // Act
    Collection<Operation> actualOperations = addNamedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertTrue(actualOperations.isEmpty());
  }

  /**
   * Test {@link AddNamedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) OperationChain is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperation#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given AddNamedOperation (default constructor) OperationChain is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AddNamedOperation.getOperations()"})
  void testGetOperations_givenAddNamedOperationOperationChainIsValueOfTen() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.setOperationChain(DoubleNode.valueOf(10.0d));

    // Act
    Collection<Operation> actualOperations = addNamedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertTrue(actualOperations.isEmpty());
  }

  /**
   * Test {@link AddNamedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) Parameters is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperation#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given AddNamedOperation (default constructor) Parameters is HashMap(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AddNamedOperation.getOperations()"})
  void testGetOperations_givenAddNamedOperationParametersIsHashMap_thenReturnList() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.setParameters(new HashMap<>());

    // Act
    Collection<Operation> actualOperations = addNamedOperation.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertTrue(actualOperations.isEmpty());
  }

  /**
   * Test {@link AddNamedOperation#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperation#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given AddNamedOperation (default constructor); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AddNamedOperation.getOperations()"})
  void testGetOperations_givenAddNamedOperation_thenReturnList() {
    // Arrange and Act
    Collection<Operation> actualOperations = new AddNamedOperation().getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertTrue(actualOperations.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AddNamedOperation}
   *   <li>{@link AddNamedOperation#setDescription(String)}
   *   <li>{@link AddNamedOperation#setLabels(List)}
   *   <li>{@link AddNamedOperation#setOperationChain(String)}
   *   <li>{@link AddNamedOperation#setOperationName(String)}
   *   <li>{@link AddNamedOperation#setOptions(Map)}
   *   <li>{@link AddNamedOperation#setOverwriteFlag(boolean)}
   *   <li>{@link AddNamedOperation#setParameters(Map)}
   *   <li>{@link AddNamedOperation#setReadAccessPredicate(AccessPredicate)}
   *   <li>{@link AddNamedOperation#setReadAccessRoles(List)}
   *   <li>{@link AddNamedOperation#setScore(Integer)}
   *   <li>{@link AddNamedOperation#setWriteAccessPredicate(AccessPredicate)}
   *   <li>{@link AddNamedOperation#setWriteAccessRoles(List)}
   *   <li>{@link AddNamedOperation#updateOperations(Collection)}
   *   <li>{@link AddNamedOperation#getDescription()}
   *   <li>{@link AddNamedOperation#getLabels()}
   *   <li>{@link AddNamedOperation#getOperationChainAsString()}
   *   <li>{@link AddNamedOperation#getOperationName()}
   *   <li>{@link AddNamedOperation#getOptions()}
   *   <li>{@link AddNamedOperation#getParameters()}
   *   <li>{@link AddNamedOperation#getReadAccessPredicate()}
   *   <li>{@link AddNamedOperation#getReadAccessRoles()}
   *   <li>{@link AddNamedOperation#getScore()}
   *   <li>{@link AddNamedOperation#getWriteAccessPredicate()}
   *   <li>{@link AddNamedOperation#getWriteAccessRoles()}
   *   <li>{@link AddNamedOperation#isOverwriteFlag()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddNamedOperation.<init>()",
    "String AddNamedOperation.getDescription()",
    "List AddNamedOperation.getLabels()",
    "String AddNamedOperation.getOperationChainAsString()",
    "String AddNamedOperation.getOperationName()",
    "Map AddNamedOperation.getOptions()",
    "Map AddNamedOperation.getParameters()",
    "AccessPredicate AddNamedOperation.getReadAccessPredicate()",
    "List AddNamedOperation.getReadAccessRoles()",
    "Integer AddNamedOperation.getScore()",
    "AccessPredicate AddNamedOperation.getWriteAccessPredicate()",
    "List AddNamedOperation.getWriteAccessRoles()",
    "boolean AddNamedOperation.isOverwriteFlag()",
    "void AddNamedOperation.setDescription(String)",
    "void AddNamedOperation.setLabels(List)",
    "void AddNamedOperation.setOperationChain(String)",
    "void AddNamedOperation.setOperationName(String)",
    "void AddNamedOperation.setOptions(Map)",
    "void AddNamedOperation.setOverwriteFlag(boolean)",
    "void AddNamedOperation.setParameters(Map)",
    "void AddNamedOperation.setReadAccessPredicate(AccessPredicate)",
    "void AddNamedOperation.setReadAccessRoles(List)",
    "void AddNamedOperation.setScore(Integer)",
    "void AddNamedOperation.setWriteAccessPredicate(AccessPredicate)",
    "void AddNamedOperation.setWriteAccessRoles(List)",
    "void AddNamedOperation.updateOperations(Collection)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AddNamedOperation actualAddNamedOperation = new AddNamedOperation();
    actualAddNamedOperation.setDescription("The characteristics of someone or something");
    ArrayList<String> labels = new ArrayList<>();
    actualAddNamedOperation.setLabels(labels);
    actualAddNamedOperation.setOperationChain("Operation Chain");
    actualAddNamedOperation.setOperationName("Operation Name");
    HashMap<String, String> options = new HashMap<>();
    actualAddNamedOperation.setOptions(options);
    actualAddNamedOperation.setOverwriteFlag(true);
    HashMap<String, ParameterDetail> parameters = new HashMap<>();
    actualAddNamedOperation.setParameters(parameters);
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    actualAddNamedOperation.setReadAccessPredicate(readAccessPredicate);
    ArrayList<String> readAccessRoles = new ArrayList<>();
    actualAddNamedOperation.setReadAccessRoles(readAccessRoles);
    actualAddNamedOperation.setScore(3);
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));
    actualAddNamedOperation.setWriteAccessPredicate(writeAccessPredicate);
    ArrayList<String> writeAccessRoles = new ArrayList<>();
    actualAddNamedOperation.setWriteAccessRoles(writeAccessRoles);
    actualAddNamedOperation.updateOperations(new ArrayList<>());
    String actualDescription = actualAddNamedOperation.getDescription();
    List<String> actualLabels = actualAddNamedOperation.getLabels();
    String actualOperationChainAsString = actualAddNamedOperation.getOperationChainAsString();
    String actualOperationName = actualAddNamedOperation.getOperationName();
    Map<String, String> actualOptions = actualAddNamedOperation.getOptions();
    Map<String, ParameterDetail> actualParameters = actualAddNamedOperation.getParameters();
    AccessPredicate actualReadAccessPredicate = actualAddNamedOperation.getReadAccessPredicate();
    List<String> actualReadAccessRoles = actualAddNamedOperation.getReadAccessRoles();
    Integer actualScore = actualAddNamedOperation.getScore();
    AccessPredicate actualWriteAccessPredicate = actualAddNamedOperation.getWriteAccessPredicate();
    List<String> actualWriteAccessRoles = actualAddNamedOperation.getWriteAccessRoles();
    boolean actualIsOverwriteFlagResult = actualAddNamedOperation.isOverwriteFlag();

    // Assert
    assertEquals("Operation Chain", actualOperationChainAsString);
    assertEquals("Operation Name", actualOperationName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(3, actualScore.intValue());
    assertTrue(actualLabels.isEmpty());
    assertTrue(actualReadAccessRoles.isEmpty());
    assertTrue(actualWriteAccessRoles.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualParameters.isEmpty());
    assertTrue(actualIsOverwriteFlagResult);
    assertSame(labels, actualLabels);
    assertSame(readAccessRoles, actualReadAccessRoles);
    assertSame(writeAccessRoles, actualWriteAccessRoles);
    assertSame(options, actualOptions);
    assertSame(parameters, actualParameters);
    assertSame(readAccessPredicate, actualReadAccessPredicate);
    assertSame(writeAccessPredicate, actualWriteAccessPredicate);
  }
}
