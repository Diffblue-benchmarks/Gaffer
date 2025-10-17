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

package uk.gov.gchq.gaffer.graph.hook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.exception.UnauthorisedException;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.user.User;

class OperationAuthoriserDiffblueTest {
  /**
   * Test {@link OperationAuthoriser#preExecute(OperationChain, Context)}.
   *
   * <ul>
   *   <li>Then throw {@link UnauthorisedException}.
   * </ul>
   *
   * <p>Method under test: {@link OperationAuthoriser#preExecute(OperationChain, Context)}
   */
  @Test
  @DisplayName("Test preExecute(OperationChain, Context); then throw UnauthorisedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationAuthoriser.preExecute(OperationChain, Context)"})
  void testPreExecute_thenThrowUnauthorisedException() {
    // Arrange
    OperationAuthoriser operationAuthoriser = new OperationAuthoriser();
    Class<Operation> opClass = Operation.class;
    operationAuthoriser.addAuths(opClass, "Auths");
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());

    // Act and Assert
    assertThrows(
        UnauthorisedException.class, () -> operationAuthoriser.preExecute(opChain, new Context()));
  }

  /**
   * Test {@link OperationAuthoriser#postExecute(Object, OperationChain, Context)}.
   *
   * <p>Method under test: {@link OperationAuthoriser#postExecute(Object, OperationChain, Context)}
   */
  @Test
  @DisplayName("Test postExecute(Object, OperationChain, Context)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OperationAuthoriser.postExecute(Object, OperationChain, Context)"})
  void testPostExecute() {
    // Arrange
    OperationAuthoriser operationAuthoriser = new OperationAuthoriser();
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());

    // Act and Assert
    assertEquals("Result", operationAuthoriser.postExecute("Result", opChain, new Context()));
  }

  /**
   * Test {@link OperationAuthoriser#onFailure(Object, OperationChain, Context, Exception)}.
   *
   * <p>Method under test: {@link OperationAuthoriser#onFailure(Object, OperationChain, Context,
   * Exception)}
   */
  @Test
  @DisplayName("Test onFailure(Object, OperationChain, Context, Exception)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object OperationAuthoriser.onFailure(Object, OperationChain, Context, Exception)"
  })
  void testOnFailure() {
    // Arrange
    OperationAuthoriser operationAuthoriser = new OperationAuthoriser();
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());
    Context context = new Context();

    // Act and Assert
    assertEquals(
        "Result", operationAuthoriser.onFailure("Result", opChain, context, new Exception()));
  }

  /**
   * Test {@link OperationAuthoriser#getAuths()}.
   *
   * <p>Method under test: {@link OperationAuthoriser#getAuths()}
   */
  @Test
  @DisplayName("Test getAuths()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OperationAuthoriser.getAuths()"})
  void testGetAuths() {
    // Arrange, Act and Assert
    assertTrue(new OperationAuthoriser().getAuths().isEmpty());
  }

  /**
   * Test {@link OperationAuthoriser#getAuthsAsStrings()}.
   *
   * <ul>
   *   <li>Given {@link OperationAuthoriser} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OperationAuthoriser#getAuthsAsStrings()}
   */
  @Test
  @DisplayName(
      "Test getAuthsAsStrings(); given OperationAuthoriser (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OperationAuthoriser.getAuthsAsStrings()"})
  void testGetAuthsAsStrings_givenOperationAuthoriser_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new OperationAuthoriser().getAuthsAsStrings().isEmpty());
  }

  /**
   * Test {@link OperationAuthoriser#getAuthsAsStrings()}.
   *
   * <ul>
   *   <li>Given {@code Operation}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link OperationAuthoriser#getAuthsAsStrings()}
   */
  @Test
  @DisplayName(
      "Test getAuthsAsStrings(); given 'uk.gov.gchq.gaffer.operation.Operation'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map OperationAuthoriser.getAuthsAsStrings()"})
  void testGetAuthsAsStrings_givenUkGovGchqGafferOperationOperation_thenReturnSizeIsOne() {
    // Arrange
    OperationAuthoriser operationAuthoriser = new OperationAuthoriser();
    Class<Operation> opClass = Operation.class;
    operationAuthoriser.addAuths(opClass, "Auths");

    // Act
    Map<String, Set<String>> actualAuthsAsStrings = operationAuthoriser.getAuthsAsStrings();

    // Assert
    assertEquals(1, actualAuthsAsStrings.size());
    Set<String> getResult = actualAuthsAsStrings.get("uk.gov.gchq.gaffer.operation.Operation");
    assertEquals(1, getResult.size());
    assertTrue(getResult.contains("Auths"));
  }

  /**
   * Test {@link OperationAuthoriser#getAllAuths()}.
   *
   * <p>Method under test: {@link OperationAuthoriser#getAllAuths()}
   */
  @Test
  @DisplayName("Test getAllAuths()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set OperationAuthoriser.getAllAuths()"})
  void testGetAllAuths() {
    // Arrange, Act and Assert
    assertTrue(new OperationAuthoriser().getAllAuths().isEmpty());
  }

  /**
   * Test {@link OperationAuthoriser#authorise(Operation, User)}.
   *
   * <ul>
   *   <li>Then throw {@link UnauthorisedException}.
   * </ul>
   *
   * <p>Method under test: {@link OperationAuthoriser#authorise(Operation, User)}
   */
  @Test
  @DisplayName("Test authorise(Operation, User); then throw UnauthorisedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationAuthoriser.authorise(Operation, User)"})
  void testAuthorise_thenThrowUnauthorisedException() {
    // Arrange
    OperationAuthoriser operationAuthoriser = new OperationAuthoriser();
    Class<Operation> opClass = Operation.class;
    operationAuthoriser.addAuths(opClass, "Auths");
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    // Act and Assert
    assertThrows(
        UnauthorisedException.class, () -> operationAuthoriser.authorise(operation, new User()));
  }

  /**
   * Test new {@link OperationAuthoriser} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OperationAuthoriser}
   */
  @Test
  @DisplayName("Test new OperationAuthoriser (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationAuthoriser.<init>()"})
  void testNewOperationAuthoriser() {
    // Arrange and Act
    OperationAuthoriser actualOperationAuthoriser = new OperationAuthoriser();

    // Assert
    assertTrue(actualOperationAuthoriser.getAuths().isEmpty());
    assertTrue(actualOperationAuthoriser.getAuthsAsStrings().isEmpty());
    assertTrue(actualOperationAuthoriser.getAllAuths().isEmpty());
  }
}
