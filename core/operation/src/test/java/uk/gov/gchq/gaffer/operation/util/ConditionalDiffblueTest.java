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

package uk.gov.gchq.gaffer.operation.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;

class ConditionalDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Conditional#Conditional()}
   *   <li>{@link Conditional#setPredicate(Predicate)}
   *   <li>{@link Conditional#setTransform(Operation)}
   *   <li>{@link Conditional#toString()}
   *   <li>{@link Conditional#getPredicate()}
   *   <li>{@link Conditional#getTransform()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Conditional.<init>()", "void Conditional.<init>(Predicate)",
      "void Conditional.<init>(Predicate, Operation)", "Predicate Conditional.getPredicate()",
      "Operation Conditional.getTransform()", "void Conditional.setPredicate(Predicate)",
      "void Conditional.setTransform(Operation)", "java.lang.String Conditional.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    Conditional actualConditional = new Conditional();
    Predicate predicate = mock(Predicate.class);
    actualConditional.setPredicate(predicate);
    AddNamedOperation transform = new AddNamedOperation();
    actualConditional.setTransform(transform);
    actualConditional.toString();
    Predicate actualPredicate = actualConditional.getPredicate();

    // Assert
    assertSame(transform, actualConditional.getTransform());
    assertSame(predicate, actualPredicate);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link AddNamedOperation} (default constructor).</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Conditional#Conditional(Predicate, Operation)}
   *   <li>{@link Conditional#setPredicate(Predicate)}
   *   <li>{@link Conditional#setTransform(Operation)}
   *   <li>{@link Conditional#toString()}
   *   <li>{@link Conditional#getPredicate()}
   *   <li>{@link Conditional#getTransform()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when AddNamedOperation (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Conditional.<init>()", "void Conditional.<init>(Predicate)",
      "void Conditional.<init>(Predicate, Operation)", "Predicate Conditional.getPredicate()",
      "Operation Conditional.getTransform()", "void Conditional.setPredicate(Predicate)",
      "void Conditional.setTransform(Operation)", "java.lang.String Conditional.toString()"})
  void testGettersAndSetters_whenAddNamedOperation() {
    // Arrange
    Predicate predicate = mock(Predicate.class);

    // Act
    Conditional actualConditional = new Conditional(predicate, new AddNamedOperation());
    Predicate predicate2 = mock(Predicate.class);
    actualConditional.setPredicate(predicate2);
    AddNamedOperation transform = new AddNamedOperation();
    actualConditional.setTransform(transform);
    actualConditional.toString();
    Predicate actualPredicate = actualConditional.getPredicate();

    // Assert
    assertSame(transform, actualConditional.getTransform());
    assertSame(predicate2, actualPredicate);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Predicate}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Conditional#Conditional(Predicate)}
   *   <li>{@link Conditional#setPredicate(Predicate)}
   *   <li>{@link Conditional#setTransform(Operation)}
   *   <li>{@link Conditional#toString()}
   *   <li>{@link Conditional#getPredicate()}
   *   <li>{@link Conditional#getTransform()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Predicate")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Conditional.<init>()", "void Conditional.<init>(Predicate)",
      "void Conditional.<init>(Predicate, Operation)", "Predicate Conditional.getPredicate()",
      "Operation Conditional.getTransform()", "void Conditional.setPredicate(Predicate)",
      "void Conditional.setTransform(Operation)", "java.lang.String Conditional.toString()"})
  void testGettersAndSetters_whenPredicate() {
    // Arrange and Act
    Conditional actualConditional = new Conditional(mock(Predicate.class));
    Predicate predicate = mock(Predicate.class);
    actualConditional.setPredicate(predicate);
    AddNamedOperation transform = new AddNamedOperation();
    actualConditional.setTransform(transform);
    actualConditional.toString();
    Predicate actualPredicate = actualConditional.getPredicate();

    // Assert
    assertSame(transform, actualConditional.getTransform());
    assertSame(predicate, actualPredicate);
  }

  /**
   * Test {@link Conditional#shallowClone()}.
   * <ul>
   *   <li>Given {@link Conditional#Conditional()}.</li>
   *   <li>Then return {@link Conditional#Conditional()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Conditional#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given Conditional(); then return Conditional()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Conditional Conditional.shallowClone()"})
  void testShallowClone_givenConditional_thenReturnConditional() {
    // Arrange
    Conditional conditional = new Conditional();

    // Act and Assert
    assertEquals(conditional, conditional.shallowClone());
  }

  /**
   * Test {@link Conditional#shallowClone()}.
   * <ul>
   *   <li>Then Transform Operations return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Conditional#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then Transform Operations return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Conditional Conditional.shallowClone()"})
  void testShallowClone_thenTransformOperationsReturnList() {
    // Arrange
    Conditional conditional = new Conditional();
    conditional.setTransform(new AddNamedOperation());

    // Act
    Conditional actualShallowCloneResult = conditional.shallowClone();

    // Assert
    Operation transform = actualShallowCloneResult.getTransform();
    Collection<Operation> operations = ((AddNamedOperation) transform).getOperations();
    assertTrue(operations instanceof List);
    assertTrue(transform instanceof AddNamedOperation);
    assertNull(((AddNamedOperation) transform).getScore());
    assertNull(((AddNamedOperation) transform).getDescription());
    assertNull(((AddNamedOperation) transform).getOperationChainAsString());
    assertNull(((AddNamedOperation) transform).getOperationName());
    assertNull(((AddNamedOperation) transform).getLabels());
    assertNull(((AddNamedOperation) transform).getReadAccessRoles());
    assertNull(((AddNamedOperation) transform).getWriteAccessRoles());
    assertNull(transform.getOptions());
    assertNull(((AddNamedOperation) transform).getParameters());
    assertNull(actualShallowCloneResult.getPredicate());
    assertNull(((AddNamedOperation) transform).getReadAccessPredicate());
    assertNull(((AddNamedOperation) transform).getWriteAccessPredicate());
    assertFalse(((AddNamedOperation) transform).isOverwriteFlag());
    assertTrue(operations.isEmpty());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, ((AddNamedOperation) transform).getOperationsClass());
  }

  /**
   * Test {@link Conditional#equals(Object)}, and {@link Conditional#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Conditional#equals(Object)}
   *   <li>{@link Conditional#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Conditional.equals(Object)", "int Conditional.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Conditional conditional = new Conditional();
    Conditional conditional2 = new Conditional();

    // Act and Assert
    assertEquals(conditional, conditional2);
    int expectedHashCodeResult = conditional.hashCode();
    assertEquals(expectedHashCodeResult, conditional2.hashCode());
  }

  /**
   * Test {@link Conditional#equals(Object)}, and {@link Conditional#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Conditional#equals(Object)}
   *   <li>{@link Conditional#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Conditional.equals(Object)", "int Conditional.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Conditional conditional = new Conditional();

    // Act and Assert
    assertEquals(conditional, conditional);
    int expectedHashCodeResult = conditional.hashCode();
    assertEquals(expectedHashCodeResult, conditional.hashCode());
  }

  /**
   * Test {@link Conditional#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Conditional#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Conditional.equals(Object)", "int Conditional.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Conditional conditional = new Conditional();
    conditional.setTransform(new AddNamedOperation());

    // Act and Assert
    assertNotEquals(conditional, new Conditional());
  }

  /**
   * Test {@link Conditional#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Conditional#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Conditional.equals(Object)", "int Conditional.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Conditional(), null);
  }

  /**
   * Test {@link Conditional#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Conditional#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Conditional.equals(Object)", "int Conditional.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Conditional(), "Different type to Conditional");
  }
}
