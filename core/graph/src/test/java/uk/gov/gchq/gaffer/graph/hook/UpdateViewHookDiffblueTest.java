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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewElementDefinition;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.graph.OperationView;
import uk.gov.gchq.gaffer.operation.graph.OperationViewImpl;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.user.User;

class UpdateViewHookDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateViewHook.Builder#build()}
   *   <li>default or parameterless constructor of {@link UpdateViewHook.Builder}
   *   <li>{@link UpdateViewHook.Builder#blackListElementGroups(Set)}
   *   <li>{@link UpdateViewHook.Builder#setViewToMerge(View)}
   *   <li>{@link UpdateViewHook.Builder#whiteListElementGroups(Set)}
   *   <li>{@link UpdateViewHook.Builder#withDataAuth(Set)}
   *   <li>{@link UpdateViewHook.Builder#withOpAuth(Set)}
   *   <li>{@link UpdateViewHook.Builder#withoutDataAuth(Set)}
   *   <li>{@link UpdateViewHook.Builder#withoutOpAuth(Set)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    UpdateViewHook.Builder builder = new UpdateViewHook.Builder();
    HashSet<String> blackListElementGroups = new HashSet<>();
    UpdateViewHook.Builder blackListElementGroupsResult = builder.blackListElementGroups(blackListElementGroups);
    View viewToMerge = new View();
    UpdateViewHook.Builder setViewToMergeResult = blackListElementGroupsResult.setViewToMerge(viewToMerge);
    HashSet<String> whiteListElementGroups = new HashSet<>();
    UpdateViewHook.Builder whiteListElementGroupsResult = setViewToMergeResult
        .whiteListElementGroups(whiteListElementGroups);
    HashSet<String> withDataAuths = new HashSet<>();
    UpdateViewHook.Builder withDataAuthResult = whiteListElementGroupsResult.withDataAuth(withDataAuths);
    HashSet<String> withOpAuth = new HashSet<>();
    UpdateViewHook.Builder withOpAuthResult = withDataAuthResult.withOpAuth(withOpAuth);
    HashSet<String> withoutDataAuth = new HashSet<>();
    UpdateViewHook.Builder withoutDataAuthResult = withOpAuthResult.withoutDataAuth(withoutDataAuth);
    HashSet<String> withoutOpAuth = new HashSet<>();

    // Act
    UpdateViewHook actualBuildResult = withoutDataAuthResult.withoutOpAuth(withoutOpAuth).build();

    // Assert
    assertFalse(actualBuildResult.isAddExtraGroups());
    Set<String> blackListElementGroups2 = actualBuildResult.getBlackListElementGroups();
    assertTrue(blackListElementGroups2.isEmpty());
    Set<String> whiteListElementGroups2 = actualBuildResult.getWhiteListElementGroups();
    assertTrue(whiteListElementGroups2.isEmpty());
    Set<String> withDataAuth = actualBuildResult.getWithDataAuth();
    assertTrue(withDataAuth.isEmpty());
    Set<String> withOpAuth2 = actualBuildResult.getWithOpAuth();
    assertTrue(withOpAuth2.isEmpty());
    Set<String> withoutDataAuth2 = actualBuildResult.getWithoutDataAuth();
    assertTrue(withoutDataAuth2.isEmpty());
    Set<String> withoutOpAuth2 = actualBuildResult.getWithoutOpAuth();
    assertTrue(withoutOpAuth2.isEmpty());
    assertEquals(viewToMerge, actualBuildResult.getViewToMerge());
    assertSame(blackListElementGroups, blackListElementGroups2);
    assertSame(whiteListElementGroups, whiteListElementGroups2);
    assertSame(withDataAuths, withDataAuth);
    assertSame(withOpAuth, withOpAuth2);
    assertSame(withoutDataAuth, withoutDataAuth2);
    assertSame(withoutOpAuth, withoutOpAuth2);
  }

  /**
   * Method under test: {@link UpdateViewHook#preExecute(OperationChain, Context)}
   */
  @Test
  void testPreExecute() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    OperationChain<?> opChain = mock(OperationChain.class);
    when(opChain.flatten()).thenReturn(new ArrayList<>());

    // Act
    updateViewHook.preExecute(opChain, new Context());

    // Assert
    verify(opChain).flatten();
  }

  /**
   * Method under test: {@link UpdateViewHook#removeElementGroups(Map.Entry)}
   */
  @Test
  void testRemoveElementGroups() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    // Act and Assert
    assertFalse(updateViewHook.removeElementGroups(new AbstractMap.SimpleEntry<>("foo", new ViewElementDefinition())));
  }

  /**
   * Method under test: {@link UpdateViewHook#removeElementGroups(Map.Entry)}
   */
  @Test
  void testRemoveElementGroups2() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    updateViewHook.setWhiteListElementGroups(null);
    updateViewHook.setBlackListElementGroups(new HashSet<>());

    // Act and Assert
    assertFalse(updateViewHook.removeElementGroups(new AbstractMap.SimpleEntry<>("foo", new ViewElementDefinition())));
  }

  /**
   * Method under test: {@link UpdateViewHook#removeElementGroups(Map.Entry)}
   */
  @Test
  void testRemoveElementGroups3() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    updateViewHook.setWhiteListElementGroups(new HashSet<>());
    updateViewHook.setBlackListElementGroups(null);

    // Act and Assert
    assertTrue(updateViewHook.removeElementGroups(new AbstractMap.SimpleEntry<>("foo", new ViewElementDefinition())));
  }

  /**
   * Method under test: {@link UpdateViewHook#removeElementGroups(Map.Entry)}
   */
  @Test
  void testRemoveElementGroups4() {
    // Arrange
    HashSet<String> whiteListElementGroups = new HashSet<>();
    whiteListElementGroups.add("foo");

    UpdateViewHook updateViewHook = new UpdateViewHook();
    updateViewHook.setWhiteListElementGroups(whiteListElementGroups);
    updateViewHook.setBlackListElementGroups(null);

    // Act and Assert
    assertFalse(updateViewHook.removeElementGroups(new AbstractMap.SimpleEntry<>("foo", new ViewElementDefinition())));
  }

  /**
   * Method under test: {@link UpdateViewHook#applyToUser(User)}
   */
  @Test
  void testApplyToUser() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    // Act and Assert
    assertTrue(updateViewHook.applyToUser(new User()));
  }

  /**
   * Method under test: {@link UpdateViewHook#applyToUser(User)}
   */
  @Test
  void testApplyToUser2() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    updateViewHook.setWithoutOpAuth(null);
    updateViewHook.setWithOpAuth(null);
    updateViewHook.setWithDataAuth(null);
    updateViewHook.setWithoutDataAuth(new HashSet<>());

    // Act and Assert
    assertTrue(updateViewHook.applyToUser(new User()));
  }

  /**
   * Method under test: {@link UpdateViewHook#applyToUser(User)}
   */
  @Test
  void testApplyToUser3() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    updateViewHook.setWithoutOpAuth(null);
    updateViewHook.setWithOpAuth(null);
    updateViewHook.setWithDataAuth(new HashSet<>());
    updateViewHook.setWithoutDataAuth(null);

    // Act and Assert
    assertFalse(updateViewHook.applyToUser(new User()));
  }

  /**
   * Method under test: {@link UpdateViewHook#applyToUser(User)}
   */
  @Test
  void testApplyToUser4() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    updateViewHook.setWithoutOpAuth(null);
    updateViewHook.setWithOpAuth(new HashSet<>());
    updateViewHook.setWithDataAuth(null);
    updateViewHook.setWithoutDataAuth(null);

    // Act and Assert
    assertFalse(updateViewHook.applyToUser(new User()));
  }

  /**
   * Method under test: {@link UpdateViewHook#applyToUser(User)}
   */
  @Test
  void testApplyToUser5() {
    // Arrange
    HashSet<String> withoutDataAuth = new HashSet<>();
    withoutDataAuth.add("foo");

    UpdateViewHook updateViewHook = new UpdateViewHook();
    updateViewHook.setWithoutOpAuth(null);
    updateViewHook.setWithOpAuth(null);
    updateViewHook.setWithDataAuth(null);
    updateViewHook.setWithoutDataAuth(withoutDataAuth);

    // Act and Assert
    assertTrue(updateViewHook.applyToUser(new User()));
  }

  /**
   * Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  void testValidateAuths() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    HashSet<String> userAuths = new HashSet<>();

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, new HashSet<>(), true));
  }

  /**
   * Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  void testValidateAuths2() {
    // Arrange, Act and Assert
    assertTrue((new UpdateViewHook()).validateAuths(null, null, true));
  }

  /**
   * Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  void testValidateAuths3() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    // Act and Assert
    assertTrue(updateViewHook.validateAuths(null, new HashSet<>(), true));
  }

  /**
   * Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  void testValidateAuths4() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    HashSet<String> userAuths = new HashSet<>();
    userAuths.add("foo");

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, new HashSet<>(), true));
  }

  /**
   * Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  void testValidateAuths5() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    HashSet<String> userAuths = new HashSet<>();
    userAuths.add("42");
    userAuths.add("foo");

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, new HashSet<>(), true));
  }

  /**
   * Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  void testValidateAuths6() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    HashSet<String> userAuths = new HashSet<>();

    HashSet<String> validAuth = new HashSet<>();
    validAuth.add("foo");

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, validAuth, true));
  }

  /**
   * Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  void testValidateAuths7() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    HashSet<String> userAuths = new HashSet<>();

    HashSet<String> validAuth = new HashSet<>();
    validAuth.add("42");
    validAuth.add("foo");

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, validAuth, true));
  }

  /**
   * Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  void testValidateAuths8() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    HashSet<String> userAuths = new HashSet<>();
    userAuths.add("foo");

    HashSet<String> validAuth = new HashSet<>();
    validAuth.add("foo");

    // Act and Assert
    assertTrue(updateViewHook.validateAuths(userAuths, validAuth, true));
  }

  /**
   * Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  void testValidateAuths9() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    HashSet<String> userAuths = new HashSet<>();
    userAuths.add("foo");

    HashSet<String> validAuth = new HashSet<>();
    validAuth.add("42");
    validAuth.add("foo");

    // Act and Assert
    assertTrue(updateViewHook.validateAuths(userAuths, validAuth, true));
  }

  /**
   * Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  void testValidateAuths10() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    HashSet<String> userAuths = new HashSet<>();
    userAuths.add("foo");

    HashSet<String> validAuth = new HashSet<>();
    validAuth.add("42");

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, validAuth, true));
  }

  /**
   * Method under test: {@link UpdateViewHook#validateAuths(Set, Set, boolean)}
   */
  @Test
  void testValidateAuths11() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    HashSet<String> userAuths = new HashSet<>();
    userAuths.add("");

    HashSet<String> validAuth = new HashSet<>();
    validAuth.add("42");
    validAuth.add("foo");

    // Act and Assert
    assertFalse(updateViewHook.validateAuths(userAuths, validAuth, true));
  }

  /**
   * Method under test:
   * {@link UpdateViewHook#postExecute(Object, OperationChain, Context)}
   */
  @Test
  void testPostExecute() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    OperationChain<?> opChain = new OperationChain<>();

    // Act and Assert
    assertEquals("Result", updateViewHook.postExecute("Result", opChain, new Context()));
  }

  /**
   * Method under test:
   * {@link UpdateViewHook#onFailure(Object, OperationChain, Context, Exception)}
   */
  @Test
  void testOnFailure() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    OperationChain<?> opChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertEquals("Result", updateViewHook.onFailure("Result", opChain, context, new Exception("foo")));
  }

  /**
   * Method under test: {@link UpdateViewHook#setViewToMerge(View)}
   */
  @Test
  void testSetViewToMerge() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    View viewToMerge = new View();

    // Act
    UpdateViewHook actualSetViewToMergeResult = updateViewHook.setViewToMerge(viewToMerge);

    // Assert
    assertEquals(viewToMerge, updateViewHook.getViewToMerge());
    assertSame(updateViewHook, actualSetViewToMergeResult);
  }

  /**
   * Method under test: {@link UpdateViewHook#setViewToMerge(View)}
   */
  @Test
  void testSetViewToMerge2() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    // Act
    UpdateViewHook actualSetViewToMergeResult = updateViewHook.setViewToMerge(null);

    // Assert
    assertNull(updateViewHook.getViewToMerge());
    assertSame(updateViewHook, actualSetViewToMergeResult);
  }

  /**
   * Method under test: {@link UpdateViewHook#setViewToMerge(View)}
   */
  @Test
  void testSetViewToMerge3() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    // Act and Assert
    assertSame(updateViewHook, updateViewHook.setViewToMerge(new NamedView()));
  }

  /**
   * Method under test: {@link UpdateViewHook#setViewToMerge(View)}
   */
  @Test
  void testSetViewToMerge4() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();

    View viewToMerge = new View();
    viewToMerge.setAllEntities(true);

    // Act
    UpdateViewHook actualSetViewToMergeResult = updateViewHook.setViewToMerge(viewToMerge);

    // Assert
    assertEquals(viewToMerge, updateViewHook.getViewToMerge());
    assertSame(updateViewHook, actualSetViewToMergeResult);
  }

  /**
   * Method under test: {@link UpdateViewHook#getViewToMerge()}
   */
  @Test
  void testGetViewToMerge() {
    // Arrange, Act and Assert
    assertNull((new UpdateViewHook()).getViewToMerge());
  }

  /**
   * Method under test: {@link UpdateViewHook#getViewToMerge()}
   */
  @Test
  void testGetViewToMerge2() {
    // Arrange
    UpdateViewHook updateViewHook = new UpdateViewHook();
    View viewToMerge = new View();
    updateViewHook.setViewToMerge(viewToMerge);

    // Act and Assert
    assertEquals(viewToMerge, updateViewHook.getViewToMerge());
  }

  /**
   * Method under test: {@link UpdateViewHook#getViewToMerge()}
   */
  @Test
  void testGetViewToMerge3() {
    // Arrange
    View viewToMerge = new View();
    viewToMerge.addConfig("Key", "42");

    UpdateViewHook updateViewHook = new UpdateViewHook();
    updateViewHook.setViewToMerge(viewToMerge);

    // Act and Assert
    assertEquals(viewToMerge, updateViewHook.getViewToMerge());
  }

  /**
   * Method under test: {@link UpdateViewHook#getViewToMerge()}
   */
  @Test
  void testGetViewToMerge4() {
    // Arrange
    View viewToMerge = new View();
    viewToMerge.setAllEntities(true);
    viewToMerge.addConfig("Key", "42");

    UpdateViewHook updateViewHook = new UpdateViewHook();
    updateViewHook.setViewToMerge(viewToMerge);

    // Act and Assert
    assertEquals(viewToMerge, updateViewHook.getViewToMerge());
  }

  /**
   * Method under test: {@link UpdateViewHook#getViewToMerge()}
   */
  @Test
  void testGetViewToMerge5() {
    // Arrange
    View viewToMerge = new View();
    viewToMerge.setAllEdges(true);
    viewToMerge.addConfig("Key", "42");

    UpdateViewHook updateViewHook = new UpdateViewHook();
    updateViewHook.setViewToMerge(viewToMerge);

    // Act and Assert
    assertEquals(viewToMerge, updateViewHook.getViewToMerge());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UpdateViewHook}
   *   <li>{@link UpdateViewHook#setAddExtraGroups(boolean)}
   *   <li>{@link UpdateViewHook#setBlackListElementGroups(Set)}
   *   <li>{@link UpdateViewHook#setWhiteListElementGroups(Set)}
   *   <li>{@link UpdateViewHook#setWithDataAuth(Set)}
   *   <li>{@link UpdateViewHook#setWithOpAuth(Set)}
   *   <li>{@link UpdateViewHook#setWithoutDataAuth(Set)}
   *   <li>{@link UpdateViewHook#setWithoutOpAuth(Set)}
   *   <li>{@link UpdateViewHook#mergeView(OperationView, View)}
   *   <li>{@link UpdateViewHook#getBlackListElementGroups()}
   *   <li>{@link UpdateViewHook#getWhiteListElementGroups()}
   *   <li>{@link UpdateViewHook#getWithDataAuth()}
   *   <li>{@link UpdateViewHook#getWithOpAuth()}
   *   <li>{@link UpdateViewHook#getWithoutDataAuth()}
   *   <li>{@link UpdateViewHook#getWithoutOpAuth()}
   *   <li>{@link UpdateViewHook#isAddExtraGroups()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    UpdateViewHook actualUpdateViewHook = new UpdateViewHook();
    UpdateViewHook actualSetAddExtraGroupsResult = actualUpdateViewHook.setAddExtraGroups(true);
    HashSet<String> blackListElementGroups = new HashSet<>();
    UpdateViewHook actualSetBlackListElementGroupsResult = actualUpdateViewHook
        .setBlackListElementGroups(blackListElementGroups);
    HashSet<String> whiteListElementGroups = new HashSet<>();
    UpdateViewHook actualSetWhiteListElementGroupsResult = actualUpdateViewHook
        .setWhiteListElementGroups(whiteListElementGroups);
    HashSet<String> withDataAuth = new HashSet<>();
    UpdateViewHook actualSetWithDataAuthResult = actualUpdateViewHook.setWithDataAuth(withDataAuth);
    HashSet<String> withOpAuth = new HashSet<>();
    UpdateViewHook actualSetWithOpAuthResult = actualUpdateViewHook.setWithOpAuth(withOpAuth);
    HashSet<String> withoutDataAuth = new HashSet<>();
    UpdateViewHook actualSetWithoutDataAuthResult = actualUpdateViewHook.setWithoutDataAuth(withoutDataAuth);
    HashSet<String> withoutOpAuth = new HashSet<>();
    UpdateViewHook actualSetWithoutOpAuthResult = actualUpdateViewHook.setWithoutOpAuth(withoutOpAuth);
    OperationViewImpl operationView = new OperationViewImpl();
    actualUpdateViewHook.mergeView(operationView, new View());
    Set<String> actualBlackListElementGroups = actualUpdateViewHook.getBlackListElementGroups();
    Set<String> actualWhiteListElementGroups = actualUpdateViewHook.getWhiteListElementGroups();
    Set<String> actualWithDataAuth = actualUpdateViewHook.getWithDataAuth();
    Set<String> actualWithOpAuth = actualUpdateViewHook.getWithOpAuth();
    Set<String> actualWithoutDataAuth = actualUpdateViewHook.getWithoutDataAuth();
    Set<String> actualWithoutOpAuth = actualUpdateViewHook.getWithoutOpAuth();
    boolean actualIsAddExtraGroupsResult = actualUpdateViewHook.isAddExtraGroups();

    // Assert
    assertTrue(actualBlackListElementGroups.isEmpty());
    assertTrue(actualWhiteListElementGroups.isEmpty());
    assertTrue(actualWithDataAuth.isEmpty());
    assertTrue(actualWithOpAuth.isEmpty());
    assertTrue(actualWithoutDataAuth.isEmpty());
    assertTrue(actualWithoutOpAuth.isEmpty());
    assertTrue(actualIsAddExtraGroupsResult);
    assertSame(blackListElementGroups, actualBlackListElementGroups);
    assertSame(whiteListElementGroups, actualWhiteListElementGroups);
    assertSame(withDataAuth, actualWithDataAuth);
    assertSame(withOpAuth, actualWithOpAuth);
    assertSame(withoutDataAuth, actualWithoutDataAuth);
    assertSame(withoutOpAuth, actualWithoutOpAuth);
    assertSame(actualUpdateViewHook, actualSetAddExtraGroupsResult);
    assertSame(actualUpdateViewHook, actualSetBlackListElementGroupsResult);
    assertSame(actualUpdateViewHook, actualSetWhiteListElementGroupsResult);
    assertSame(actualUpdateViewHook, actualSetWithDataAuthResult);
    assertSame(actualUpdateViewHook, actualSetWithOpAuthResult);
    assertSame(actualUpdateViewHook, actualSetWithoutDataAuthResult);
    assertSame(actualUpdateViewHook, actualSetWithoutOpAuthResult);
  }
}
