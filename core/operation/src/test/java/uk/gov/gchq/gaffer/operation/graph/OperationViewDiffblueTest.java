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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.impl.get.GetAdjacentIds;

class OperationViewDiffblueTest {
  /**
   * Test Builder {@link OperationView.Builder#view(View)}.
   * <p>
   * Method under test: {@link OperationView.Builder#view(View)}
   */
  @Test
  @DisplayName("Test Builder view(View)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationView.Builder OperationView.Builder.view(View)"})
  void testBuilderView() {
    // Arrange
    GetAdjacentIds.Builder builder = new GetAdjacentIds.Builder();

    // Act and Assert
    assertSame(builder, builder.view(new View()));
  }

  /**
   * Test {@link OperationView#validate(Edge)} with {@code edge}.
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@code null}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validate(Edge)}
   */
  @Test
  @DisplayName("Test validate(Edge) with 'edge'; given OperationViewImpl (default constructor) View is 'null'; when 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@link View} (default constructor).</li>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validate(Edge)}
   */
  @Test
  @DisplayName("Test validate(Edge) with 'edge'; given OperationViewImpl (default constructor) View is View (default constructor); when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validate(Edge)"})
  void testValidateWithEdge_givenOperationViewImplViewIsView_whenEdgeWithGroup() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(new View());

    // Act and Assert
    assertFalse(operationViewImpl.validate(new Edge("Group")));
  }

  /**
   * Test {@link OperationView#validate(Edge)} with {@code edge}.
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor).</li>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validate(Edge)}
   */
  @Test
  @DisplayName("Test validate(Edge) with 'edge'; given OperationViewImpl (default constructor); when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validate(Edge)"})
  void testValidateWithEdge_givenOperationViewImpl_whenEdgeWithGroup() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();

    // Act and Assert
    assertFalse(operationViewImpl.validate(new Edge("Group")));
  }

  /**
   * Test {@link OperationView#validate(Element)} with {@code element}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@code DIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validate(Element)}
   */
  @Test
  @DisplayName("Test validate(Element) with 'element'; given GetAdjacentIds (default constructor) DirectedType is 'DIRECTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validate(Element)"})
  void testValidateWithElement_givenGetAdjacentIdsDirectedTypeIsDirected() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.DIRECTED);

    // Act and Assert
    assertFalse(getAdjacentIds.validate((Element) new Edge("Group")));
  }

  /**
   * Test {@link OperationView#validate(Element)} with {@code element}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) View is {@link View} (default constructor).</li>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validate(Element)}
   */
  @Test
  @DisplayName("Test validate(Element) with 'element'; given GetAdjacentIds (default constructor) View is View (default constructor); when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validate(Element)"})
  void testValidateWithElement_givenGetAdjacentIdsViewIsView_whenEdgeWithGroup() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setView(new View());

    // Act and Assert
    assertFalse(getAdjacentIds.validate((Element) new Edge("Group")));
  }

  /**
   * Test {@link OperationView#validate(Element)} with {@code element}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).</li>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validate(Element)}
   */
  @Test
  @DisplayName("Test validate(Element) with 'element'; given GetAdjacentIds (default constructor); when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validate(Element)"})
  void testValidateWithElement_givenGetAdjacentIds_whenEdgeWithGroup() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act and Assert
    assertFalse(getAdjacentIds.validate((Element) new Edge("Group")));
  }

  /**
   * Test {@link OperationView#validate(Element)} with {@code element}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validate(Element)}
   */
  @Test
  @DisplayName("Test validate(Element) with 'element'; given GetAdjacentIds (default constructor); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validate(Element)"})
  void testValidateWithElement_givenGetAdjacentIds_whenNull() {
    // Arrange, Act and Assert
    assertFalse((new GetAdjacentIds()).validate((Element) null));
  }

  /**
   * Test {@link OperationView#validate(Element)} with {@code element}.
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code Vertex} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validate(Element)}
   */
  @Test
  @DisplayName("Test validate(Element) with 'element'; when Builder (default constructor) group 'Group' vertex 'Vertex' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validate(Element)"})
  void testValidateWithElement_whenBuilderGroupGroupVertexVertexBuild() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    Entity element = (new Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertFalse(getAdjacentIds.validate((Element) element));
  }

  /**
   * Test {@link OperationView#validate(Entity)} with {@code entity}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).</li>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validate(Entity)}
   */
  @Test
  @DisplayName("Test validate(Entity) with 'entity'; given GetAdjacentIds (default constructor); when Entity(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validate(Entity)"})
  void testValidateWithEntity_givenGetAdjacentIds_whenEntityWithGroup() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act and Assert
    assertFalse(getAdjacentIds.validate(new Entity("Group")));
  }

  /**
   * Test {@link OperationView#validate(Entity)} with {@code entity}.
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@code null}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validate(Entity)}
   */
  @Test
  @DisplayName("Test validate(Entity) with 'entity'; given OperationViewImpl (default constructor) View is 'null'; when 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@link View} (default constructor).</li>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validate(Entity)}
   */
  @Test
  @DisplayName("Test validate(Entity) with 'entity'; given OperationViewImpl (default constructor) View is View (default constructor); when Entity(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validate(Entity)"})
  void testValidateWithEntity_givenOperationViewImplViewIsView_whenEntityWithGroup() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(new View());

    // Act and Assert
    assertFalse(operationViewImpl.validate(new Entity("Group")));
  }

  /**
   * Test {@link OperationView#validatePreAggregationFilter(Element)}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validatePreAggregationFilter(Element)}
   */
  @Test
  @DisplayName("Test validatePreAggregationFilter(Element); given GetAdjacentIds (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validatePreAggregationFilter(Element)"})
  void testValidatePreAggregationFilter_givenGetAdjacentIds() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act and Assert
    assertFalse(getAdjacentIds.validatePreAggregationFilter(new Edge("Group")));
  }

  /**
   * Test {@link OperationView#validatePreAggregationFilter(Element)}.
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validatePreAggregationFilter(Element)}
   */
  @Test
  @DisplayName("Test validatePreAggregationFilter(Element); given OperationViewImpl (default constructor) View is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validatePreAggregationFilter(Element)"})
  void testValidatePreAggregationFilter_givenOperationViewImplViewIsView() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(new View());

    // Act and Assert
    assertFalse(operationViewImpl.validatePreAggregationFilter(new Edge("Group")));
  }

  /**
   * Test {@link OperationView#validatePostAggregationFilter(Element)}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validatePostAggregationFilter(Element)}
   */
  @Test
  @DisplayName("Test validatePostAggregationFilter(Element); given GetAdjacentIds (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validatePostAggregationFilter(Element)"})
  void testValidatePostAggregationFilter_givenGetAdjacentIds() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act and Assert
    assertFalse(getAdjacentIds.validatePostAggregationFilter(new Edge("Group")));
  }

  /**
   * Test {@link OperationView#validatePostAggregationFilter(Element)}.
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validatePostAggregationFilter(Element)}
   */
  @Test
  @DisplayName("Test validatePostAggregationFilter(Element); given OperationViewImpl (default constructor) View is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validatePostAggregationFilter(Element)"})
  void testValidatePostAggregationFilter_givenOperationViewImplViewIsView() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(new View());

    // Act and Assert
    assertFalse(operationViewImpl.validatePostAggregationFilter(new Edge("Group")));
  }

  /**
   * Test {@link OperationView#validatePostTransformFilter(Element)}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validatePostTransformFilter(Element)}
   */
  @Test
  @DisplayName("Test validatePostTransformFilter(Element); given GetAdjacentIds (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validatePostTransformFilter(Element)"})
  void testValidatePostTransformFilter_givenGetAdjacentIds() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act and Assert
    assertFalse(getAdjacentIds.validatePostTransformFilter(new Edge("Group")));
  }

  /**
   * Test {@link OperationView#validatePostTransformFilter(Element)}.
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#validatePostTransformFilter(Element)}
   */
  @Test
  @DisplayName("Test validatePostTransformFilter(Element); given OperationViewImpl (default constructor) View is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.validatePostTransformFilter(Element)"})
  void testValidatePostTransformFilter_givenOperationViewImplViewIsView() {
    // Arrange
    OperationViewImpl operationViewImpl = new OperationViewImpl();
    operationViewImpl.setView(new View());

    // Act and Assert
    assertFalse(operationViewImpl.validatePostTransformFilter(new Edge("Group")));
  }

  /**
   * Test {@link OperationView#setViews(List)}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).</li>
   *   <li>Then {@link GetAdjacentIds} (default constructor) View is {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName("Test setViews(List); given GetAdjacentIds (default constructor); then GetAdjacentIds (default constructor) View is View (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link OperationViewImpl} (default constructor) View is {@link View} (default constructor).</li>
   *   <li>Then {@link OperationViewImpl} (default constructor) View is {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName("Test setViews(List); given OperationViewImpl (default constructor) View is View (default constructor); then OperationViewImpl (default constructor) View is View (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link View} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link View} (default constructor).</li>
   *   <li>Then {@link OperationViewImpl} (default constructor) View is {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName("Test setViews(List); given View (default constructor); when ArrayList() add View (default constructor); then OperationViewImpl (default constructor) View is View (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link OperationViewImpl} (default constructor) View {@link NamedView}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName("Test setViews(List); then OperationViewImpl (default constructor) View NamedView")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationView.setViews(List)"})
  void testSetViews_thenOperationViewImplViewNamedView() {
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link OperationViewImpl} (default constructor) View is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#setViews(List)}
   */
  @Test
  @DisplayName("Test setViews(List); when 'null'; then OperationViewImpl (default constructor) View is 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link OperationView#hasView(Operation)}
   */
  @Test
  @DisplayName("Test hasView(Operation) with 'Operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.hasView(Operation)"})
  void testHasViewWithOperation() {
    // Arrange, Act and Assert
    assertFalse(OperationView.hasView(new AddNamedOperation()));
  }

  /**
   * Test {@link OperationView#hasView(OperationView)} with {@code OperationView}.
   * <ul>
   *   <li>Given {@link View} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#hasView(OperationView)}
   */
  @Test
  @DisplayName("Test hasView(OperationView) with 'OperationView'; given View (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link GetAdjacentIds} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#hasView(OperationView)}
   */
  @Test
  @DisplayName("Test hasView(OperationView) with 'OperationView'; when GetAdjacentIds (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.hasView(OperationView)"})
  void testHasViewWithOperationView_whenGetAdjacentIds_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(OperationView.hasView((OperationView) new GetAdjacentIds()));
  }

  /**
   * Test {@link OperationView#hasView(OperationView)} with {@code OperationView}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationView#hasView(OperationView)}
   */
  @Test
  @DisplayName("Test hasView(OperationView) with 'OperationView'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationView.hasView(OperationView)"})
  void testHasViewWithOperationView_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(OperationView.hasView((OperationView) null));
  }
}
