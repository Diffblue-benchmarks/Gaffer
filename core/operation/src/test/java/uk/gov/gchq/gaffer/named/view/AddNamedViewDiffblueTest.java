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

package uk.gov.gchq.gaffer.named.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.util.RawValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.predicate.AccessPredicate;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewParameterDetail;
import uk.gov.gchq.gaffer.named.view.AddNamedView.Builder;

class AddNamedViewDiffblueTest {
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
    AddNamedView _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getViewAsJsonNode());
    assertNull(_getOpResult.getDescription());
    assertNull(_getOpResult.getName());
    assertNull(_getOpResult.getViewAsString());
    assertNull(_getOpResult.getWriteAccessRoles());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getParameters());
    assertNull(_getOpResult.getReadAccessPredicate());
    assertNull(_getOpResult.getWriteAccessPredicate());
    assertNull(_getOpResult.getView());
    assertFalse(_getOpResult.isOverwriteFlag());
    AddNamedView actualAddNamedView = actualBuilder.build();
    assertSame(_getOpResult, actualAddNamedView);
  }

  /**
   * Test Builder {@link Builder#overwrite(boolean)}.
   *
   * <p>Method under test: {@link Builder#overwrite(boolean)}
   */
  @Test
  @DisplayName("Test Builder overwrite(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.overwrite(boolean)"})
  void testBuilderOverwrite() {
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
   * Test Builder {@link Builder#view(String)} with {@code String}.
   *
   * <p>Method under test: {@link Builder#view(String)}
   */
  @Test
  @DisplayName("Test Builder view(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.view(String)"})
  void testBuilderViewWithString() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualViewResult = builder.view("View");

    // Assert
    assertSame(builder, actualViewResult);
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
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#writeAccessRoles(String[])}
   */
  @Test
  @DisplayName("Test Builder writeAccessRoles(String[]); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.writeAccessRoles(String[])"})
  void testBuilderWriteAccessRoles_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualWriteAccessRolesResult = builder.writeAccessRoles(null);

    // Assert
    assertSame(builder, actualWriteAccessRolesResult);
  }

  /**
   * Test Builder {@link Builder#writeAccessRoles(String[])}.
   *
   * <ul>
   *   <li>When {@code Roles}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#writeAccessRoles(String[])}
   */
  @Test
  @DisplayName("Test Builder writeAccessRoles(String[]); when 'Roles'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.writeAccessRoles(String[])"})
  void testBuilderWriteAccessRoles_whenRoles() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualWriteAccessRolesResult = builder.writeAccessRoles("Roles");

    // Assert
    assertSame(builder, actualWriteAccessRolesResult);
  }

  /**
   * Test {@link AddNamedView#setView(JsonNode)} with {@code JsonNode}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link AddNamedView} (default constructor) ViewAsJsonNode is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedView#setView(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test setView(JsonNode) with 'JsonNode'; when 'null'; then AddNamedView (default constructor) ViewAsJsonNode is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddNamedView.setView(JsonNode)"})
  void testSetViewWithJsonNode_whenNull_thenAddNamedViewViewAsJsonNodeIsNull() {
    // Arrange
    AddNamedView addNamedView = new AddNamedView();

    // Act
    addNamedView.setView((JsonNode) null);

    // Assert that nothing has changed
    assertNull(addNamedView.getViewAsJsonNode());
    assertNull(addNamedView.getViewAsString());
  }

  /**
   * Test {@link AddNamedView#setView(View)} with {@code View}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link AddNamedView} (default constructor) ViewAsJsonNode is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedView#setView(View)}
   */
  @Test
  @DisplayName(
      "Test setView(View) with 'View'; when 'null'; then AddNamedView (default constructor) ViewAsJsonNode is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddNamedView.setView(View)"})
  void testSetViewWithView_whenNull_thenAddNamedViewViewAsJsonNodeIsNull() {
    // Arrange
    AddNamedView addNamedView = new AddNamedView();

    // Act
    addNamedView.setView((View) null);

    // Assert that nothing has changed
    assertNull(addNamedView.getViewAsJsonNode());
    assertNull(addNamedView.getViewAsString());
    assertNull(addNamedView.getView());
  }

  /**
   * Test {@link AddNamedView#getViewAsJsonNode()}.
   *
   * <p>Method under test: {@link AddNamedView#getViewAsJsonNode()}
   */
  @Test
  @DisplayName("Test getViewAsJsonNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AddNamedView.getViewAsJsonNode()"})
  void testGetViewAsJsonNode() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode viewNode = new ArrayNode(nf);
    viewNode.addRawValue(new RawValue("foo"));

    AddNamedView addNamedView = new AddNamedView();
    addNamedView.setView(viewNode);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> addNamedView.getViewAsJsonNode());
  }

  /**
   * Test {@link AddNamedView#getViewAsJsonNode()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedView} (default constructor) View is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedView#getViewAsJsonNode()}
   */
  @Test
  @DisplayName("Test getViewAsJsonNode(); given AddNamedView (default constructor) View is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AddNamedView.getViewAsJsonNode()"})
  void testGetViewAsJsonNode_givenAddNamedViewViewIsFoo() {
    // Arrange
    AddNamedView addNamedView = new AddNamedView();
    addNamedView.setView("foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> addNamedView.getViewAsJsonNode());
  }

  /**
   * Test {@link AddNamedView#getViewAsJsonNode()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedView} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedView#getViewAsJsonNode()}
   */
  @Test
  @DisplayName(
      "Test getViewAsJsonNode(); given AddNamedView (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AddNamedView.getViewAsJsonNode()"})
  void testGetViewAsJsonNode_givenAddNamedView_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AddNamedView().getViewAsJsonNode());
  }

  /**
   * Test {@link AddNamedView#getView()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedView} (default constructor) addOption {@code 42} and {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedView#getView()}
   */
  @Test
  @DisplayName(
      "Test getView(); given AddNamedView (default constructor) addOption '42' and 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View AddNamedView.getView()"})
  void testGetView_givenAddNamedViewAddOption42AndValue() {
    // Arrange
    AddNamedView addNamedView = new AddNamedView();
    addNamedView.addOption("42", "Value");
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    addNamedView.setView(new ArrayNode(nf));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> addNamedView.getView());
  }

  /**
   * Test {@link AddNamedView#getView()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedView} (default constructor) View is {@code foo}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedView#getView()}
   */
  @Test
  @DisplayName(
      "Test getView(); given AddNamedView (default constructor) View is 'foo'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View AddNamedView.getView()"})
  void testGetView_givenAddNamedViewViewIsFoo_thenThrowIllegalArgumentException() {
    // Arrange
    AddNamedView addNamedView = new AddNamedView();
    addNamedView.setView("foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> addNamedView.getView());
  }

  /**
   * Test {@link AddNamedView#getView()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedView} (default constructor) View is Instance.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedView#getView()}
   */
  @Test
  @DisplayName(
      "Test getView(); given AddNamedView (default constructor) View is Instance; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View AddNamedView.getView()"})
  void testGetView_givenAddNamedViewViewIsInstance_thenThrowIllegalArgumentException() {
    // Arrange
    AddNamedView addNamedView = new AddNamedView();
    addNamedView.setView(MissingNode.getInstance());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> addNamedView.getView());
  }

  /**
   * Test {@link AddNamedView#getView()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedView} (default constructor) View is valueOf ten.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedView#getView()}
   */
  @Test
  @DisplayName(
      "Test getView(); given AddNamedView (default constructor) View is valueOf ten; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View AddNamedView.getView()"})
  void testGetView_givenAddNamedViewViewIsValueOfTen_thenThrowIllegalArgumentException() {
    // Arrange
    AddNamedView addNamedView = new AddNamedView();
    addNamedView.setView(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> addNamedView.getView());
  }

  /**
   * Test {@link AddNamedView#getView()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedView} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedView#getView()}
   */
  @Test
  @DisplayName("Test getView(); given AddNamedView (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View AddNamedView.getView()"})
  void testGetView_givenAddNamedView_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AddNamedView().getView());
  }

  /**
   * Test {@link AddNamedView#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedView} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedView#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddNamedView (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddNamedView AddNamedView.shallowClone()"})
  void testShallowClone_givenAddNamedViewOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    AddNamedView addNamedView = new AddNamedView();
    addNamedView.setOptions(new HashMap<>());

    // Act
    AddNamedView actualShallowCloneResult = addNamedView.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getViewAsJsonNode());
    assertNull(actualShallowCloneResult.getDescription());
    assertNull(actualShallowCloneResult.getName());
    assertNull(actualShallowCloneResult.getViewAsString());
    assertNull(actualShallowCloneResult.getWriteAccessRoles());
    assertNull(actualShallowCloneResult.getParameters());
    assertNull(actualShallowCloneResult.getReadAccessPredicate());
    assertNull(actualShallowCloneResult.getWriteAccessPredicate());
    assertNull(actualShallowCloneResult.getView());
    assertFalse(actualShallowCloneResult.isOverwriteFlag());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link AddNamedView#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedView} (default constructor).
   *   <li>Then return WriteAccessRoles is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedView#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddNamedView (default constructor); then return WriteAccessRoles is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddNamedView AddNamedView.shallowClone()"})
  void testShallowClone_givenAddNamedView_thenReturnWriteAccessRolesIsNull()
      throws CloneFailedException {
    // Arrange and Act
    AddNamedView actualShallowCloneResult = new AddNamedView().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getViewAsJsonNode());
    assertNull(actualShallowCloneResult.getDescription());
    assertNull(actualShallowCloneResult.getName());
    assertNull(actualShallowCloneResult.getViewAsString());
    assertNull(actualShallowCloneResult.getWriteAccessRoles());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getParameters());
    assertNull(actualShallowCloneResult.getReadAccessPredicate());
    assertNull(actualShallowCloneResult.getWriteAccessPredicate());
    assertNull(actualShallowCloneResult.getView());
    assertFalse(actualShallowCloneResult.isOverwriteFlag());
  }

  /**
   * Test {@link AddNamedView#shallowClone()}.
   *
   * <ul>
   *   <li>Then return WriteAccessRoles Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedView#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return WriteAccessRoles Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddNamedView AddNamedView.shallowClone()"})
  void testShallowClone_thenReturnWriteAccessRolesEmpty() throws CloneFailedException {
    // Arrange
    AddNamedView addNamedView = new AddNamedView();
    addNamedView.setWriteAccessRoles(new ArrayList<>());

    // Act
    AddNamedView actualShallowCloneResult = addNamedView.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getViewAsJsonNode());
    assertNull(actualShallowCloneResult.getDescription());
    assertNull(actualShallowCloneResult.getName());
    assertNull(actualShallowCloneResult.getViewAsString());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getParameters());
    assertNull(actualShallowCloneResult.getReadAccessPredicate());
    assertNull(actualShallowCloneResult.getWriteAccessPredicate());
    assertNull(actualShallowCloneResult.getView());
    assertFalse(actualShallowCloneResult.isOverwriteFlag());
    assertTrue(actualShallowCloneResult.getWriteAccessRoles().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AddNamedView}
   *   <li>{@link AddNamedView#setDescription(String)}
   *   <li>{@link AddNamedView#setName(String)}
   *   <li>{@link AddNamedView#setOptions(Map)}
   *   <li>{@link AddNamedView#setOverwriteFlag(boolean)}
   *   <li>{@link AddNamedView#setParameters(Map)}
   *   <li>{@link AddNamedView#setReadAccessPredicate(AccessPredicate)}
   *   <li>{@link AddNamedView#setView(String)}
   *   <li>{@link AddNamedView#setWriteAccessPredicate(AccessPredicate)}
   *   <li>{@link AddNamedView#setWriteAccessRoles(List)}
   *   <li>{@link AddNamedView#getDescription()}
   *   <li>{@link AddNamedView#getName()}
   *   <li>{@link AddNamedView#getOptions()}
   *   <li>{@link AddNamedView#getParameters()}
   *   <li>{@link AddNamedView#getReadAccessPredicate()}
   *   <li>{@link AddNamedView#getViewAsString()}
   *   <li>{@link AddNamedView#getWriteAccessPredicate()}
   *   <li>{@link AddNamedView#getWriteAccessRoles()}
   *   <li>{@link AddNamedView#isOverwriteFlag()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddNamedView.<init>()",
    "String AddNamedView.getDescription()",
    "String AddNamedView.getName()",
    "Map AddNamedView.getOptions()",
    "Map AddNamedView.getParameters()",
    "AccessPredicate AddNamedView.getReadAccessPredicate()",
    "String AddNamedView.getViewAsString()",
    "AccessPredicate AddNamedView.getWriteAccessPredicate()",
    "List AddNamedView.getWriteAccessRoles()",
    "boolean AddNamedView.isOverwriteFlag()",
    "void AddNamedView.setDescription(String)",
    "void AddNamedView.setName(String)",
    "void AddNamedView.setOptions(Map)",
    "void AddNamedView.setOverwriteFlag(boolean)",
    "void AddNamedView.setParameters(Map)",
    "void AddNamedView.setReadAccessPredicate(AccessPredicate)",
    "void AddNamedView.setView(String)",
    "void AddNamedView.setWriteAccessPredicate(AccessPredicate)",
    "void AddNamedView.setWriteAccessRoles(List)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AddNamedView actualAddNamedView = new AddNamedView();
    actualAddNamedView.setDescription("The characteristics of someone or something");
    actualAddNamedView.setName("Name");
    HashMap<String, String> options = new HashMap<>();
    actualAddNamedView.setOptions(options);
    actualAddNamedView.setOverwriteFlag(true);
    HashMap<String, ViewParameterDetail> parameters = new HashMap<>();
    actualAddNamedView.setParameters(parameters);
    AccessPredicate readAccessPredicate = new AccessPredicate(mock(Predicate.class));
    actualAddNamedView.setReadAccessPredicate(readAccessPredicate);
    actualAddNamedView.setView("View");
    AccessPredicate writeAccessPredicate = new AccessPredicate(mock(Predicate.class));
    actualAddNamedView.setWriteAccessPredicate(writeAccessPredicate);
    ArrayList<String> writeAccessRoles = new ArrayList<>();
    actualAddNamedView.setWriteAccessRoles(writeAccessRoles);
    String actualDescription = actualAddNamedView.getDescription();
    String actualName = actualAddNamedView.getName();
    Map<String, String> actualOptions = actualAddNamedView.getOptions();
    Map<String, ViewParameterDetail> actualParameters = actualAddNamedView.getParameters();
    AccessPredicate actualReadAccessPredicate = actualAddNamedView.getReadAccessPredicate();
    String actualViewAsString = actualAddNamedView.getViewAsString();
    AccessPredicate actualWriteAccessPredicate = actualAddNamedView.getWriteAccessPredicate();
    List<String> actualWriteAccessRoles = actualAddNamedView.getWriteAccessRoles();
    boolean actualIsOverwriteFlagResult = actualAddNamedView.isOverwriteFlag();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("View", actualViewAsString);
    assertTrue(actualWriteAccessRoles.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualParameters.isEmpty());
    assertTrue(actualIsOverwriteFlagResult);
    assertSame(writeAccessRoles, actualWriteAccessRoles);
    assertSame(options, actualOptions);
    assertSame(parameters, actualParameters);
    assertSame(readAccessPredicate, actualReadAccessPredicate);
    assertSame(writeAccessPredicate, actualWriteAccessPredicate);
  }
}
