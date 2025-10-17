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

package uk.gov.gchq.gaffer.operation.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.impl.get.GetAdjacentIds;
import uk.gov.gchq.gaffer.operation.impl.get.GetAdjacentIds.Builder;

class OperationViewDiffblueTest {
  /**
   * Test Builder {@link OperationView.Builder#view(View)}.
   *
   * <p>Method under test: {@link OperationView.Builder#view(View)}
   */
  @Test
  @DisplayName("Test Builder view(View)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationView.Builder OperationView.Builder.view(View)"})
  void testBuilderView() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualViewResult = builder.view(new View());

    // Assert
    assertSame(builder, actualViewResult);
  }

  /**
   * Test {@link OperationView#validate(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validate(Edge)}
   */
  @Test
  @DisplayName(
      "Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor); when Edge(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validate(Edge)"})
  void testValidateWithEdge_givenGetAdjacentIds_whenEdgeWithGroup() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act
    boolean actualValidateResult = getAdjacentIds.validate(new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link OperationView#validate(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@code null}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validate(Edge)}
   */
  @Test
  @DisplayName(
      "Test validate(Edge) with 'edge'; given OperationViewImpl (default constructor) View is 'null'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validate(Edge)"})
  void testValidateWithEdge_givenOperationViewImplViewIsNull_whenNull() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(null);

    // Act and Assert
    assertFalse(operationViewImpl.validate((Edge) null));
  }

  /**
   * Test {@link OperationView#validate(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@link View} (default
   *       constructor).
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validate(Edge)}
   */
  @Test
  @DisplayName(
      "Test validate(Edge) with 'edge'; given OperationViewImpl (default constructor) View is View (default constructor); when Edge(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validate(Edge)"})
  void testValidateWithEdge_givenOperationViewImplViewIsView_whenEdgeWithGroup() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(new View());

    // Act
    boolean actualValidateResult = operationViewImpl.validate(new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link OperationView#validate(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor).
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validate(Edge)}
   */
  @Test
  @DisplayName(
      "Test validate(Edge) with 'edge'; given OperationViewImpl (default constructor); when Edge(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validate(Edge)"})
  void testValidateWithEdge_givenOperationViewImpl_whenEdgeWithGroup() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();

    // Act
    boolean actualValidateResult = operationViewImpl.validate(new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link OperationView#validate(Element)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'element'; given GetAdjacentIds (default constructor) DirectedType is 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validate(Element)"})
  void testValidateWithElement_givenGetAdjacentIdsDirectedTypeIsDirected() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.DIRECTED);

    // Act
    boolean actualValidateResult = getAdjacentIds.validate((Element) new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link OperationView#validate(Element)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'element'; given GetAdjacentIds (default constructor); when Edge(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validate(Element)"})
  void testValidateWithElement_givenGetAdjacentIds_whenEdgeWithGroup() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act
    boolean actualValidateResult = getAdjacentIds.validate((Element) new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link OperationView#validate(Element)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@code null}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'element'; given OperationViewImpl (default constructor) View is 'null'; when Edge(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validate(Element)"})
  void testValidateWithElement_givenOperationViewImplViewIsNull_whenEdgeWithGroup() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(null);

    // Act
    boolean actualValidateResult = operationViewImpl.validate((Element) new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link OperationView#validate(Element)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@code null}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'element'; given OperationViewImpl (default constructor) View is 'null'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validate(Element)"})
  void testValidateWithElement_givenOperationViewImplViewIsNull_whenNull() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(null);

    // Act and Assert
    assertFalse(operationViewImpl.validate((Element) null));
  }

  /**
   * Test {@link OperationView#validate(Element)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@link View} (default
   *       constructor).
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'element'; given OperationViewImpl (default constructor) View is View (default constructor); when Edge(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validate(Element)"})
  void testValidateWithElement_givenOperationViewImplViewIsView_whenEdgeWithGroup() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(new View());

    // Act
    boolean actualValidateResult = operationViewImpl.validate((Element) new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link OperationView#validate(Element)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validate(Element)}
   */
  @Test
  @DisplayName(
      "Test validate(Element) with 'element'; when Builder (default constructor) group 'Group' vertex 'Vertex' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validate(Element)"})
  void testValidateWithElement_whenBuilderGroupGroupVertexVertexBuild() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act
    boolean actualValidateResult =
        getAdjacentIds.validate(
            (Element) new Entity.Builder().group("Group").vertex("Vertex").build());

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link OperationView#validate(Entity)} with {@code entity}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validate(Entity)}
   */
  @Test
  @DisplayName(
      "Test validate(Entity) with 'entity'; given GetAdjacentIds (default constructor); when Entity(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validate(Entity)"})
  void testValidateWithEntity_givenGetAdjacentIds_whenEntityWithGroup() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act
    boolean actualValidateResult = getAdjacentIds.validate(new Entity("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link OperationView#validate(Entity)} with {@code entity}.
   *
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@code null}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validate(Entity)}
   */
  @Test
  @DisplayName(
      "Test validate(Entity) with 'entity'; given OperationViewImpl (default constructor) View is 'null'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validate(Entity)"})
  void testValidateWithEntity_givenOperationViewImplViewIsNull_whenNull() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(null);

    // Act and Assert
    assertFalse(operationViewImpl.validate((Entity) null));
  }

  /**
   * Test {@link OperationView#validate(Entity)} with {@code entity}.
   *
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@link View} (default
   *       constructor).
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validate(Entity)}
   */
  @Test
  @DisplayName(
      "Test validate(Entity) with 'entity'; given OperationViewImpl (default constructor) View is View (default constructor); when Entity(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validate(Entity)"})
  void testValidateWithEntity_givenOperationViewImplViewIsView_whenEntityWithGroup() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(new View());

    // Act
    boolean actualValidateResult = operationViewImpl.validate(new Entity("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link OperationView#validatePreAggregationFilter(Element)}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validatePreAggregationFilter(Element)}
   */
  @Test
  @DisplayName(
      "Test validatePreAggregationFilter(Element); given GetAdjacentIds (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validatePreAggregationFilter(Element)"})
  void testValidatePreAggregationFilter_givenGetAdjacentIds_thenReturnFalse() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act
    boolean actualValidatePreAggregationFilterResult =
        getAdjacentIds.validatePreAggregationFilter(new Edge("Group"));

    // Assert
    assertFalse(actualValidatePreAggregationFilterResult);
  }

  /**
   * Test {@link OperationView#validatePreAggregationFilter(Element)}.
   *
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@link View} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validatePreAggregationFilter(Element)}
   */
  @Test
  @DisplayName(
      "Test validatePreAggregationFilter(Element); given OperationViewImpl (default constructor) View is View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validatePreAggregationFilter(Element)"})
  void testValidatePreAggregationFilter_givenOperationViewImplViewIsView() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(new View());

    // Act
    boolean actualValidatePreAggregationFilterResult =
        operationViewImpl.validatePreAggregationFilter(new Edge("Group"));

    // Assert
    assertFalse(actualValidatePreAggregationFilterResult);
  }

  /**
   * Test {@link OperationView#validatePostAggregationFilter(Element)}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validatePostAggregationFilter(Element)}
   */
  @Test
  @DisplayName(
      "Test validatePostAggregationFilter(Element); given GetAdjacentIds (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validatePostAggregationFilter(Element)"})
  void testValidatePostAggregationFilter_givenGetAdjacentIds_thenReturnFalse() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act
    boolean actualValidatePostAggregationFilterResult =
        getAdjacentIds.validatePostAggregationFilter(new Edge("Group"));

    // Assert
    assertFalse(actualValidatePostAggregationFilterResult);
  }

  /**
   * Test {@link OperationView#validatePostAggregationFilter(Element)}.
   *
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@link View} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validatePostAggregationFilter(Element)}
   */
  @Test
  @DisplayName(
      "Test validatePostAggregationFilter(Element); given OperationViewImpl (default constructor) View is View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validatePostAggregationFilter(Element)"})
  void testValidatePostAggregationFilter_givenOperationViewImplViewIsView() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(new View());

    // Act
    boolean actualValidatePostAggregationFilterResult =
        operationViewImpl.validatePostAggregationFilter(new Edge("Group"));

    // Assert
    assertFalse(actualValidatePostAggregationFilterResult);
  }

  /**
   * Test {@link OperationView#validatePostTransformFilter(Element)}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validatePostTransformFilter(Element)}
   */
  @Test
  @DisplayName(
      "Test validatePostTransformFilter(Element); given GetAdjacentIds (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validatePostTransformFilter(Element)"})
  void testValidatePostTransformFilter_givenGetAdjacentIds_thenReturnFalse() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act
    boolean actualValidatePostTransformFilterResult =
        getAdjacentIds.validatePostTransformFilter(new Edge("Group"));

    // Assert
    assertFalse(actualValidatePostTransformFilterResult);
  }

  /**
   * Test {@link OperationView#validatePostTransformFilter(Element)}.
   *
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@link View} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#validatePostTransformFilter(Element)}
   */
  @Test
  @DisplayName(
      "Test validatePostTransformFilter(Element); given OperationViewImpl (default constructor) View is View (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.validatePostTransformFilter(Element)"})
  void testValidatePostTransformFilter_givenOperationViewImplViewIsView_thenReturnFalse() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(new View());

    // Act
    boolean actualValidatePostTransformFilterResult =
        operationViewImpl.validatePostTransformFilter(new Edge("Group"));

    // Assert
    assertFalse(actualValidatePostTransformFilterResult);
  }

  /**
   * Test {@link OperationView#setViews(List)}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).
   *   <li>Then {@link GetAdjacentIds} (default constructor) View is {@link View} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName(
      "Test setViews(List); given GetAdjacentIds (default constructor); then GetAdjacentIds (default constructor) View is View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationView.setViews(List)"})
  void testSetViews_givenGetAdjacentIds_thenGetAdjacentIdsViewIsView() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    ArrayList<View> views = new ArrayList<>();
    View view = new View();
    views.add(view);
    views.add(new View());

    // Act
    getAdjacentIds.setViews(views);

    // Assert
    assertEquals(view, getAdjacentIds.getView());
  }

  /**
   * Test {@link OperationView#setViews(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then {@link OperationViewImpl} (default constructor) View is {@link NamedView} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName(
      "Test setViews(List); given 'null'; when ArrayList() add 'null'; then OperationViewImpl (default constructor) View is NamedView (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationView.setViews(List)"})
  void testSetViews_givenNull_whenArrayListAddNull_thenOperationViewImplViewIsNamedView() {
    // Arrange
    NamedView view = new NamedView();
    view.setName("Name must be set");

    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(view);

    ArrayList<View> views = new ArrayList<>();
    views.add(null);

    // Act
    operationViewImpl.setViews(views);

    // Assert
    View view2 = operationViewImpl.getView();
    assertTrue(view2 instanceof NamedView);
    assertEquals(view, view2);
  }

  /**
   * Test {@link OperationView#setViews(List)}.
   *
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@link View} (default
   *       constructor).
   *   <li>Then {@link OperationViewImpl} (default constructor) View is {@link View} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName(
      "Test setViews(List); given OperationViewImpl (default constructor) View is View (default constructor); then OperationViewImpl (default constructor) View is View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationView.setViews(List)"})
  void testSetViews_givenOperationViewImplViewIsView_thenOperationViewImplViewIsView() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    View view = new View();
    operationViewImpl.setView(view);

    // Act
    operationViewImpl.setViews(new ArrayList<>());

    // Assert
    assertEquals(view, operationViewImpl.getView());
  }

  /**
   * Test {@link OperationView#setViews(List)}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor) AllEntities is {@code true}.
   *   <li>Then {@link OperationViewImpl} (default constructor) View is {@link View} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName(
      "Test setViews(List); given View (default constructor) AllEntities is 'true'; then OperationViewImpl (default constructor) View is View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationView.setViews(List)"})
  void testSetViews_givenViewAllEntitiesIsTrue_thenOperationViewImplViewIsView() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(null);

    View view = new View();
    view.setAllEntities(true);

    ArrayList<View> views = new ArrayList<>();
    views.add(view);

    // Act
    operationViewImpl.setViews(views);

    // Assert
    assertEquals(view, operationViewImpl.getView());
  }

  /**
   * Test {@link OperationView#setViews(List)}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link View} (default constructor).
   *   <li>Then {@link OperationViewImpl} (default constructor) View is {@link View} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName(
      "Test setViews(List); given View (default constructor); when ArrayList() add View (default constructor); then OperationViewImpl (default constructor) View is View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationView.setViews(List)"})
  void testSetViews_givenView_whenArrayListAddView_thenOperationViewImplViewIsView() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(null);

    ArrayList<View> views = new ArrayList<>();
    View view = new View();
    views.add(view);

    // Act
    operationViewImpl.setViews(views);

    // Assert
    assertEquals(view, operationViewImpl.getView());
  }

  /**
   * Test {@link OperationView#setViews(List)}.
   *
   * <ul>
   *   <li>Then {@link OperationViewImpl} (default constructor) View is {@link NamedView} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName(
      "Test setViews(List); then OperationViewImpl (default constructor) View is NamedView (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationView.setViews(List)"})
  void testSetViews_thenOperationViewImplViewIsNamedView() {
    // Arrange
    NamedView view = new NamedView();
    view.setName("Name must be set");

    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(view);

    NamedView namedView = new NamedView();
    namedView.setName("Name must be set");

    ArrayList<View> views = new ArrayList<>();
    views.add(namedView);

    // Act
    operationViewImpl.setViews(views);

    // Assert
    View view2 = operationViewImpl.getView();
    assertTrue(view2 instanceof NamedView);
    assertEquals(view, view2);
  }

  /**
   * Test {@link OperationView#setViews(List)}.
   *
   * <ul>
   *   <li>Then {@link OperationViewImpl} (default constructor) View MergedNamedViewNames size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName(
      "Test setViews(List); then OperationViewImpl (default constructor) View MergedNamedViewNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationView.setViews(List)"})
  void testSetViews_thenOperationViewImplViewMergedNamedViewNamesSizeIsOne() {
    // Arrange
    NamedView view = new NamedView();
    view.setName("View Name");

    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(view);

    NamedView namedView = new NamedView();
    namedView.setName("Name must be set");

    ArrayList<View> views = new ArrayList<>();
    views.add(namedView);

    // Act
    operationViewImpl.setViews(views);

    // Assert
    View view2 = operationViewImpl.getView();
    assertTrue(view2 instanceof NamedView);
    List<String> mergedNamedViewNames = ((NamedView) view2).getMergedNamedViewNames();
    assertEquals(1, mergedNamedViewNames.size());
    assertEquals("Name must be set", mergedNamedViewNames.get(0));
  }

  /**
   * Test {@link OperationView#setViews(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link OperationViewImpl} (default constructor) View is {@link NamedView} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName(
      "Test setViews(List); when ArrayList(); then OperationViewImpl (default constructor) View is NamedView (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationView.setViews(List)"})
  void testSetViews_whenArrayList_thenOperationViewImplViewIsNamedView() {
    // Arrange
    NamedView view = new NamedView();
    view.setName("Name must be set");

    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(view);

    // Act
    operationViewImpl.setViews(new ArrayList<>());

    // Assert
    View view2 = operationViewImpl.getView();
    assertTrue(view2 instanceof NamedView);
    assertEquals(view, view2);
  }

  /**
   * Test {@link OperationView#setViews(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link OperationViewImpl} (default constructor) View is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName(
      "Test setViews(List); when 'null'; then OperationViewImpl (default constructor) View is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationView.setViews(List)"})
  void testSetViews_whenNull_thenOperationViewImplViewIsNull() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(null);

    // Act
    operationViewImpl.setViews(null);

    // Assert that nothing has changed
    assertNull(operationViewImpl.getView());
  }

  /**
   * Test {@link OperationView#hasView(Operation)} with {@code Operation}.
   *
   * <p>Method under test: {@link OperationView#hasView(Operation)}
   */
  @Test
  @DisplayName("Test hasView(Operation) with 'Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.hasView(Operation)"})
  void testHasViewWithOperation() {
    // Arrange, Act and Assert
    assertFalse(OperationView.hasView(new AddNamedOperation()));
  }

  /**
   * Test {@link OperationView#hasView(OperationView)} with {@code OperationView}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#hasView(OperationView)}
   */
  @Test
  @DisplayName(
      "Test hasView(OperationView) with 'OperationView'; given View (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.hasView(OperationView)"})
  void testHasViewWithOperationView_givenView_thenReturnTrue() {
    // Arrange
    OperationViewImpl op = new OperationViewImpl();
    op.setView(new View());

    // Act and Assert
    assertTrue(OperationView.hasView(op));
  }

  /**
   * Test {@link OperationView#hasView(OperationView)} with {@code OperationView}.
   *
   * <ul>
   *   <li>When {@link GetAdjacentIds} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#hasView(OperationView)}
   */
  @Test
  @DisplayName(
      "Test hasView(OperationView) with 'OperationView'; when GetAdjacentIds (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.hasView(OperationView)"})
  void testHasViewWithOperationView_whenGetAdjacentIds_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(OperationView.hasView((OperationView) new GetAdjacentIds()));
  }

  /**
   * Test {@link OperationView#hasView(OperationView)} with {@code OperationView}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OperationView#hasView(OperationView)}
   */
  @Test
  @DisplayName("Test hasView(OperationView) with 'OperationView'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OperationView.hasView(OperationView)"})
  void testHasViewWithOperationView_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(OperationView.hasView((OperationView) null));
  }
}
