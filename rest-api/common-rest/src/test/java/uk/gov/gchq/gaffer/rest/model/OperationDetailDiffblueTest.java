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

package uk.gov.gchq.gaffer.rest.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherGraph;
import uk.gov.gchq.gaffer.operation.impl.output.ToMap;

class OperationDetailDiffblueTest {
  /**
   * Test {@link OperationDetail#OperationDetail(Class, Set, Operation)}.
   *
   * <p>Method under test: {@link OperationDetail#OperationDetail(Class, Set, Operation)}
   */
  @Test
  @DisplayName("Test new OperationDetail(Class, Set, Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationDetail.<init>(Class, Set, Operation)"})
  void testNewOperationDetail() {
    // Arrange
    Class<Operation> opClass = Operation.class;
    HashSet<Class<? extends Operation>> nextOperations = new HashSet<>();
    ExportToOtherGraph exampleJson = new ExportToOtherGraph();

    // Act
    OperationDetail actualOperationDetail =
        new OperationDetail(opClass, nextOperations, exampleJson);

    // Assert
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.data.element.Element>",
        actualOperationDetail.getOutputClassName());
    assertSame(exampleJson, actualOperationDetail.getExampleJson());
  }

  /**
   * Test {@link OperationDetail#OperationDetail(Class, Set, Operation)}.
   *
   * <p>Method under test: {@link OperationDetail#OperationDetail(Class, Set, Operation)}
   */
  @Test
  @DisplayName("Test new OperationDetail(Class, Set, Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationDetail.<init>(Class, Set, Operation)"})
  void testNewOperationDetail2() {
    // Arrange
    Class<Operation> opClass = Operation.class;
    HashSet<Class<? extends Operation>> nextOperations = new HashSet<>();
    ToMap exampleJson = new ToMap();

    // Act
    OperationDetail actualOperationDetail =
        new OperationDetail(opClass, nextOperations, exampleJson);

    // Assert
    assertEquals(
        "java.lang.Iterable<java.util.Map<java.lang.String,java.lang.Object>>",
        actualOperationDetail.getOutputClassName());
    assertSame(exampleJson, actualOperationDetail.getExampleJson());
  }

  /**
   * Test {@link OperationDetail#OperationDetail(Class, Set, Operation)}.
   *
   * <ul>
   *   <li>Then return Next is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationDetail#OperationDetail(Class, Set, Operation)}
   */
  @Test
  @DisplayName("Test new OperationDetail(Class, Set, Operation); then return Next is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationDetail.<init>(Class, Set, Operation)"})
  void testNewOperationDetail_thenReturnNextIsHashSet() {
    // Arrange
    Class<Operation> opClass = Operation.class;

    HashSet<Class<? extends Operation>> nextOperations = new HashSet<>();
    Class<Operation> forNameResult = Operation.class;
    nextOperations.add(forNameResult);
    AddNamedOperation exampleJson = new AddNamedOperation();

    // Act
    OperationDetail actualOperationDetail =
        new OperationDetail(opClass, nextOperations, exampleJson);

    // Assert
    assertNull(actualOperationDetail.getOutputClassName());
    assertSame(nextOperations, actualOperationDetail.getNext());
    assertSame(exampleJson, actualOperationDetail.getExampleJson());
  }

  /**
   * Test {@link OperationDetail#OperationDetail(Class, Set, Operation)}.
   *
   * <ul>
   *   <li>Then return OutputClassName is {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link OperationDetail#OperationDetail(Class, Set, Operation)}
   */
  @Test
  @DisplayName(
      "Test new OperationDetail(Class, Set, Operation); then return OutputClassName is 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationDetail.<init>(Class, Set, Operation)"})
  void testNewOperationDetail_thenReturnOutputClassNameIsJavaLangObject() {
    // Arrange
    Class<Operation> opClass = Operation.class;
    HashSet<Class<? extends Operation>> nextOperations = new HashSet<>();
    OperationChain<Object> exampleJson = OperationChain.wrap(new NamedOperation<>());

    // Act
    OperationDetail actualOperationDetail =
        new OperationDetail(opClass, nextOperations, exampleJson);

    // Assert
    assertEquals("java.lang.Object", actualOperationDetail.getOutputClassName());
    assertSame(exampleJson, actualOperationDetail.getExampleJson());
  }

  /**
   * Test {@link OperationDetail#OperationDetail(Class, Set, Operation)}.
   *
   * <ul>
   *   <li>When {@link AddNamedOperation} (default constructor).
   *   <li>Then return OutputClassName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationDetail#OperationDetail(Class, Set, Operation)}
   */
  @Test
  @DisplayName(
      "Test new OperationDetail(Class, Set, Operation); when AddNamedOperation (default constructor); then return OutputClassName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationDetail.<init>(Class, Set, Operation)"})
  void testNewOperationDetail_whenAddNamedOperation_thenReturnOutputClassNameIsNull() {
    // Arrange
    Class<Operation> opClass = Operation.class;
    HashSet<Class<? extends Operation>> nextOperations = new HashSet<>();
    AddNamedOperation exampleJson = new AddNamedOperation();

    // Act
    OperationDetail actualOperationDetail =
        new OperationDetail(opClass, nextOperations, exampleJson);

    // Assert
    assertNull(actualOperationDetail.getOutputClassName());
    assertSame(exampleJson, actualOperationDetail.getExampleJson());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationDetail#toString()}
   *   <li>{@link OperationDetail#getExampleJson()}
   *   <li>{@link OperationDetail#getFields()}
   *   <li>{@link OperationDetail#getName()}
   *   <li>{@link OperationDetail#getNext()}
   *   <li>{@link OperationDetail#getOutputClassName()}
   *   <li>{@link OperationDetail#getSummary()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation OperationDetail.getExampleJson()",
    "List OperationDetail.getFields()",
    "String OperationDetail.getName()",
    "Set OperationDetail.getNext()",
    "String OperationDetail.getOutputClassName()",
    "String OperationDetail.getSummary()",
    "String OperationDetail.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Class<Operation> opClass = Operation.class;
    HashSet<Class<? extends Operation>> nextOperations = new HashSet<>();
    AddNamedOperation exampleJson = new AddNamedOperation();

    OperationDetail operationDetail = new OperationDetail(opClass, nextOperations, exampleJson);

    // Act
    operationDetail.toString();
    Operation actualExampleJson = operationDetail.getExampleJson();
    List<OperationField> actualFields = operationDetail.getFields();
    String actualName = operationDetail.getName();
    Set<Class<? extends Operation>> actualNext = operationDetail.getNext();
    String actualOutputClassName = operationDetail.getOutputClassName();

    // Assert
    assertEquals(1, actualFields.size());
    OperationField getResult = actualFields.get(0);
    assertEquals("java.util.Map<java.lang.String,java.lang.String>", getResult.getClassName());
    assertEquals("options", getResult.getName());
    assertEquals("uk.gov.gchq.gaffer.operation.Operation", actualName);
    assertNull(actualOutputClassName);
    assertNull(operationDetail.getSummary());
    assertNull(getResult.getSummary());
    assertNull(getResult.getOptions());
    assertFalse(getResult.isRequired());
    assertTrue(actualNext.isEmpty());
    assertSame(nextOperations, actualNext);
    assertSame(exampleJson, actualExampleJson);
  }

  /**
   * Test {@link OperationDetail#equals(Object)}, and {@link OperationDetail#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationDetail#equals(Object)}
   *   <li>{@link OperationDetail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationDetail.equals(Object)", "int OperationDetail.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Class<Operation> opClass = Operation.class;
    OperationDetail operationDetail = new OperationDetail(opClass, new HashSet<>(), null);
    Class<Operation> opClass2 = Operation.class;
    OperationDetail operationDetail2 = new OperationDetail(opClass2, new HashSet<>(), null);

    // Act and Assert
    assertEquals(operationDetail, operationDetail2);
    assertEquals(operationDetail.hashCode(), operationDetail2.hashCode());
  }

  /**
   * Test {@link OperationDetail#equals(Object)}, and {@link OperationDetail#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationDetail#equals(Object)}
   *   <li>{@link OperationDetail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationDetail.equals(Object)", "int OperationDetail.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Class<Operation> opClass = Operation.class;
    HashSet<Class<? extends Operation>> nextOperations = new HashSet<>();

    OperationDetail operationDetail =
        new OperationDetail(opClass, nextOperations, new AddNamedOperation());

    // Act and Assert
    assertEquals(operationDetail, operationDetail);
    int expectedHashCodeResult = operationDetail.hashCode();
    assertEquals(expectedHashCodeResult, operationDetail.hashCode());
  }

  /**
   * Test {@link OperationDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationDetail.equals(Object)", "int OperationDetail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Class<Operation> opClass = Operation.class;
    HashSet<Class<? extends Operation>> nextOperations = new HashSet<>();

    OperationDetail operationDetail =
        new OperationDetail(opClass, nextOperations, new AddNamedOperation());
    Class<Operation> opClass2 = Operation.class;
    HashSet<Class<? extends Operation>> nextOperations2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        operationDetail, new OperationDetail(opClass2, nextOperations2, new AddNamedOperation()));
  }

  /**
   * Test {@link OperationDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationDetail.equals(Object)", "int OperationDetail.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Class<Operation> opClass = Operation.class;
    HashSet<Class<? extends Operation>> nextOperations = new HashSet<>();

    // Act and Assert
    assertNotEquals(new OperationDetail(opClass, nextOperations, new AddNamedOperation()), null);
  }

  /**
   * Test {@link OperationDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OperationDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationDetail.equals(Object)", "int OperationDetail.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Class<Operation> opClass = Operation.class;
    HashSet<Class<? extends Operation>> nextOperations = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        new OperationDetail(opClass, nextOperations, new AddNamedOperation()),
        "Different type to OperationDetail");
  }
}
