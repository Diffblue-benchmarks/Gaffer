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

package uk.gov.gchq.gaffer.graph.hook.migrate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewElementDefinition;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.impl.function.Aggregate;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.koryphe.tuple.binaryoperator.TupleAdaptedBinaryOperator;
import uk.gov.gchq.koryphe.tuple.predicate.TupleAdaptedPredicate;

class ViewMigrationDiffblueTest {
  /**
   * Method under test:
   * {@link ViewMigration#createMigrationOps(boolean, Iterable)}
   */
  @Test
  void testCreateMigrationOps() {
    // Arrange and Act
    List<Operation> actualCreateMigrationOpsResult = ViewMigration.createMigrationOps(true, new ArrayList<>());

    // Assert
    assertEquals(1, actualCreateMigrationOpsResult.size());
    Operation getResult = actualCreateMigrationOpsResult.get(0);
    assertTrue(getResult instanceof Aggregate);
    TypeReference<Iterable<? extends Element>> outputTypeReference = ((Aggregate) getResult).getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableElement);
    Type outputType = ((Aggregate) getResult).getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
    assertNull(((Aggregate) getResult).getInput());
    assertNull(getResult.getOptions());
    assertNull(((Aggregate) getResult).getEdges());
    assertNull(((Aggregate) getResult).getEntities());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, ((Aggregate) getResult).getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test:
   * {@link ViewMigration#createMigrationOps(boolean, Iterable)}
   */
  @Test
  void testCreateMigrationOps2() {
    // Arrange
    LinkedHashSet<ViewMigration> views = new LinkedHashSet<>();
    views.add(new ViewMigration(true));

    // Act
    List<Operation> actualCreateMigrationOpsResult = ViewMigration.createMigrationOps(false, views);

    // Assert
    assertTrue(actualCreateMigrationOpsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ViewMigration#createMigrationOps(boolean, Iterable, Iterable)}
   */
  @Test
  void testCreateMigrationOps3() {
    // Arrange
    ArrayList<ViewMigration> views1 = new ArrayList<>();

    // Act
    List<Operation> actualCreateMigrationOpsResult = ViewMigration.createMigrationOps(true, views1, new ArrayList<>());

    // Assert
    assertEquals(1, actualCreateMigrationOpsResult.size());
    Operation getResult = actualCreateMigrationOpsResult.get(0);
    assertTrue(getResult instanceof Aggregate);
    TypeReference<Iterable<? extends Element>> outputTypeReference = ((Aggregate) getResult).getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableElement);
    Type outputType = ((Aggregate) getResult).getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
    assertNull(((Aggregate) getResult).getInput());
    assertNull(getResult.getOptions());
    assertNull(((Aggregate) getResult).getEdges());
    assertNull(((Aggregate) getResult).getEntities());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, ((Aggregate) getResult).getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test:
   * {@link ViewMigration#createMigrationOps(boolean, Iterable, Iterable)}
   */
  @Test
  void testCreateMigrationOps4() {
    // Arrange
    ArrayList<ViewMigration> views1 = new ArrayList<>();

    // Act
    List<Operation> actualCreateMigrationOpsResult = ViewMigration.createMigrationOps(false, views1, new ArrayList<>());

    // Assert
    assertTrue(actualCreateMigrationOpsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ViewMigration#createMigrationOps(boolean, Iterable, Iterable)}
   */
  @Test
  void testCreateMigrationOps5() {
    // Arrange
    ArrayList<ViewMigration> views1 = new ArrayList<>();
    views1.add(new ViewMigration(true));

    // Act
    List<Operation> actualCreateMigrationOpsResult = ViewMigration.createMigrationOps(true, views1, new ArrayList<>());

    // Assert
    assertEquals(1, actualCreateMigrationOpsResult.size());
    Operation getResult = actualCreateMigrationOpsResult.get(0);
    assertTrue(getResult instanceof Aggregate);
    TypeReference<Iterable<? extends Element>> outputTypeReference = ((Aggregate) getResult).getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.IterableElement);
    Type outputType = ((Aggregate) getResult).getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
    assertNull(((Aggregate) getResult).getInput());
    assertNull(getResult.getOptions());
    assertNull(((Aggregate) getResult).getEdges());
    assertNull(((Aggregate) getResult).getEntities());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, ((Aggregate) getResult).getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test:
   * {@link ViewMigration#update(MigrateElement, String, ViewElementDefinition)}
   */
  @Test
  void testUpdate() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    // Act and Assert
    assertSame(viewMigration, viewMigration.update(migration, "Group", new ViewElementDefinition()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#update(MigrateElement, String, ViewElementDefinition)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    ViewElementDefinition elementDefinition = new ViewElementDefinition();
    elementDefinition.setGroupBy(new LinkedHashSet<>());

    // Act and Assert
    assertSame(viewMigration, viewMigration.update(migration, "Group", elementDefinition));
  }

  /**
   * Method under test:
   * {@link ViewMigration#prepareBuilder(ViewElementDefinition)}
   */
  @Test
  void testPrepareBuilder() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act and Assert
    assertSame(viewMigration, viewMigration.prepareBuilder(new ViewElementDefinition()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#prepareBuilder(ViewElementDefinition)}
   */
  @Test
  void testPrepareBuilder2() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act and Assert
    assertSame(viewMigration, viewMigration.prepareBuilder(null));
  }

  /**
   * Method under test:
   * {@link ViewMigration#prepareBuilder(ViewElementDefinition)}
   */
  @Test
  void testPrepareBuilder3() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    ViewElementDefinition elementDef = new ViewElementDefinition();
    elementDef.setGroupBy(new LinkedHashSet<>());

    // Act and Assert
    assertSame(viewMigration, viewMigration.prepareBuilder(elementDef));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePreAggregationFilters(ElementFilter)}
   */
  @Test
  void testUpdatePreAggregationFilters() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act and Assert
    assertSame(viewMigration, viewMigration.updatePreAggregationFilters(new ElementFilter()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePreAggregationFilters(ElementFilter)}
   */
  @Test
  void testUpdatePreAggregationFilters2() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    ElementFilter filter = new ElementFilter();
    filter.test(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertSame(viewMigration, viewMigration.updatePreAggregationFilters(filter));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePreAggregationFilters(ElementTransformer, ElementFilter)}
   */
  @Test
  void testUpdatePreAggregationFilters3() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer transformer = new ElementTransformer();

    // Act and Assert
    assertSame(viewMigration, viewMigration.updatePreAggregationFilters(transformer, new ElementFilter()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePreAggregationFilters(ElementTransformer, ElementFilter)}
   */
  @Test
  void testUpdatePreAggregationFilters4() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePreAggregationFilters(new ElementTransformer(), (ElementFilter) null));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePreAggregationFilters(ElementTransformer, ElementFilter)}
   */
  @Test
  void testUpdatePreAggregationFilters5() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer transformer = new ElementTransformer();

    ElementFilter filter = new ElementFilter();
    filter.setComponents(null);

    // Act and Assert
    assertSame(viewMigration, viewMigration.updatePreAggregationFilters(transformer, filter));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePreAggregationFilters(ElementTransformer, ElementFilter)}
   */
  @Test
  void testUpdatePreAggregationFilters6() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    ElementTransformer transformer = new ElementTransformer();
    transformer.apply(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertSame(viewMigration, viewMigration.updatePreAggregationFilters(transformer, new ElementFilter()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePreAggregationFilters(ElementTransformer, ElementFilter)}
   */
  @Test
  void testUpdatePreAggregationFilters7() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer transformer = new ElementTransformer();

    LinkedList<TupleAdaptedPredicate<String, ?>> components = new LinkedList<>();
    components.add(new TupleAdaptedPredicate<>());

    ElementFilter filter = new ElementFilter();
    filter.setComponents(components);

    // Act and Assert
    assertSame(viewMigration, viewMigration.updatePreAggregationFilters(transformer, filter));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePreAggregationFilters(ElementTransformer, ViewElementDefinition)}
   */
  @Test
  void testUpdatePreAggregationFilters8() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer transformer = new ElementTransformer();

    // Act and Assert
    assertSame(viewMigration, viewMigration.updatePreAggregationFilters(transformer, new ViewElementDefinition()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePreAggregationFilters(ElementTransformer, ViewElementDefinition)}
   */
  @Test
  void testUpdatePreAggregationFilters9() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    ElementTransformer transformer = new ElementTransformer();
    transformer.apply(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertSame(viewMigration, viewMigration.updatePreAggregationFilters(transformer, new ViewElementDefinition()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePreAggregationFilters(ViewElementDefinition)}
   */
  @Test
  void testUpdatePreAggregationFilters10() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act and Assert
    assertSame(viewMigration, viewMigration.updatePreAggregationFilters(new ViewElementDefinition()));
  }

  /**
   * Method under test: {@link ViewMigration#updateAggregator(ElementAggregator)}
   */
  @Test
  void testUpdateAggregator() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act and Assert
    assertSame(viewMigration, viewMigration.updateAggregator(new ElementAggregator()));
  }

  /**
   * Method under test: {@link ViewMigration#updateAggregator(ElementAggregator)}
   */
  @Test
  void testUpdateAggregator2() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    ArrayList<TupleAdaptedBinaryOperator<String, ?>> components = new ArrayList<>();
    components.add(0, new TupleAdaptedBinaryOperator<>(mock(BinaryOperator.class), new String[]{"Selection"}));

    ElementAggregator aggregator = new ElementAggregator();
    aggregator.setComponents(components);

    // Act and Assert
    assertSame(viewMigration, viewMigration.updateAggregator(aggregator));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updateAggregator(ViewElementDefinition)}
   */
  @Test
  void testUpdateAggregator3() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act and Assert
    assertSame(viewMigration, viewMigration.updateAggregator(new ViewElementDefinition()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String, ElementFilter)}
   */
  @Test
  void testUpdatePostAggregationFilters() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    // Act and Assert
    assertSame(viewMigration, viewMigration.updatePostAggregationFilters(migration, "Group", new ElementFilter()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String, ElementFilter)}
   */
  @Test
  void testUpdatePostAggregationFilters2() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostAggregationFilters(new MigrateElement(), "Group", (ElementFilter) null));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String, ElementFilter)}
   */
  @Test
  void testUpdatePostAggregationFilters3() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    ElementFilter filter = new ElementFilter();
    filter.test(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertSame(viewMigration, viewMigration.updatePostAggregationFilters(migration, "Group", filter));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String, ElementTransformer, ElementFilter)}
   */
  @Test
  void testUpdatePostAggregationFilters4() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();
    ElementTransformer transformer = new ElementTransformer();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostAggregationFilters(migration, "Group", transformer, new ElementFilter()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String, ElementTransformer, ElementFilter)}
   */
  @Test
  void testUpdatePostAggregationFilters5() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostAggregationFilters(migration, "Group", new ElementTransformer(), (ElementFilter) null));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String, ElementTransformer, ElementFilter)}
   */
  @Test
  void testUpdatePostAggregationFilters6() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    ElementTransformer transformer = new ElementTransformer();
    transformer.apply(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostAggregationFilters(migration, "Group", transformer, new ElementFilter()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String, ElementTransformer, ViewElementDefinition)}
   */
  @Test
  void testUpdatePostAggregationFilters7() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();
    ElementTransformer transformer = new ElementTransformer();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostAggregationFilters(migration, "Group", transformer, new ViewElementDefinition()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String, ElementTransformer, ViewElementDefinition)}
   */
  @Test
  void testUpdatePostAggregationFilters8() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    ElementTransformer transformer = new ElementTransformer();
    transformer.apply(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostAggregationFilters(migration, "Group", transformer, new ViewElementDefinition()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostAggregationFilters(MigrateElement, String, ViewElementDefinition)}
   */
  @Test
  void testUpdatePostAggregationFilters9() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostAggregationFilters(migration, "Group", new ViewElementDefinition()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updateTransformer(MigrateElement.ElementType, String, ElementTransformer)}
   */
  @Test
  void testUpdateTransformer() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updateTransformer(MigrateElement.ElementType.EDGE, "Group", new ElementTransformer()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updateTransformer(MigrateElement.ElementType, String, ElementTransformer)}
   */
  @Test
  void testUpdateTransformer2() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act and Assert
    assertSame(viewMigration, viewMigration.updateTransformer(MigrateElement.ElementType.EDGE, "Group", null));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updateTransformer(MigrateElement.ElementType, String, ElementTransformer)}
   */
  @Test
  void testUpdateTransformer3() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    ElementTransformer transformer = new ElementTransformer();
    transformer.apply(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertSame(viewMigration, viewMigration.updateTransformer(MigrateElement.ElementType.EDGE, "Group", transformer));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updateTransformer(MigrateElement, String, ElementTransformer, ElementTransformer)}
   */
  @Test
  void testUpdateTransformer4() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();
    ElementTransformer migrationTransform = new ElementTransformer();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updateTransformer(migration, "Group", migrationTransform, new ElementTransformer()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updateTransformer(MigrateElement, String, ElementTransformer, ElementTransformer)}
   */
  @Test
  void testUpdateTransformer5() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updateTransformer(migration, "Group", new ElementTransformer(), (ElementTransformer) null));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updateTransformer(MigrateElement, String, ElementTransformer, ElementTransformer)}
   */
  @Test
  void testUpdateTransformer6() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    ElementTransformer migrationTransform = new ElementTransformer();
    migrationTransform.apply(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updateTransformer(migration, "Group", migrationTransform, new ElementTransformer()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updateTransformer(MigrateElement, String, ElementTransformer, ViewElementDefinition)}
   */
  @Test
  void testUpdateTransformer7() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();
    ElementTransformer migrationTransform = new ElementTransformer();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updateTransformer(migration, "Group", migrationTransform, new ViewElementDefinition()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updateTransformer(MigrateElement, String, ElementTransformer, ViewElementDefinition)}
   */
  @Test
  void testUpdateTransformer8() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    ElementTransformer migrationTransform = new ElementTransformer();
    migrationTransform.apply(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updateTransformer(migration, "Group", migrationTransform, new ViewElementDefinition()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostTransformFilters(MigrateElement, String, ElementFilter)}
   */
  @Test
  void testUpdatePostTransformFilters() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    // Act and Assert
    assertSame(viewMigration, viewMigration.updatePostTransformFilters(migration, "Group", new ElementFilter()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostTransformFilters(MigrateElement, String, ElementFilter)}
   */
  @Test
  void testUpdatePostTransformFilters2() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostTransformFilters(new MigrateElement(), "Group", (ElementFilter) null));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostTransformFilters(MigrateElement, String, ElementFilter)}
   */
  @Test
  void testUpdatePostTransformFilters3() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    ElementFilter filter = new ElementFilter();
    filter.test(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertSame(viewMigration, viewMigration.updatePostTransformFilters(migration, "Group", filter));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostTransformFilters(MigrateElement, String, ElementTransformer, ElementFilter)}
   */
  @Test
  void testUpdatePostTransformFilters4() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer toNewTransform = new ElementTransformer();
    MigrateElement migration = new MigrateElement(MigrateElement.ElementType.EDGE, "ELEMENT", "ELEMENT", toNewTransform,
        new ElementTransformer());

    ElementTransformer transformer = new ElementTransformer();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostTransformFilters(migration, "Group", transformer, new ElementFilter()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostTransformFilters(MigrateElement, String, ElementTransformer, ElementFilter)}
   */
  @Test
  void testUpdatePostTransformFilters5() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(false);
    ElementTransformer toNewTransform = new ElementTransformer();
    MigrateElement migration = new MigrateElement(MigrateElement.ElementType.EDGE, "ELEMENT", "ELEMENT", toNewTransform,
        new ElementTransformer());

    ElementTransformer transformer = new ElementTransformer();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostTransformFilters(migration, "Group", transformer, new ElementFilter()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostTransformFilters(MigrateElement, String, ElementTransformer, ElementFilter)}
   */
  @Test
  void testUpdatePostTransformFilters6() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer toNewTransform = new ElementTransformer();
    MigrateElement migration = new MigrateElement(MigrateElement.ElementType.ENTITY, "ELEMENT", "ELEMENT",
        toNewTransform, new ElementTransformer());

    ElementTransformer transformer = new ElementTransformer();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostTransformFilters(migration, "Group", transformer, new ElementFilter()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostTransformFilters(MigrateElement, String, ElementTransformer, ViewElementDefinition)}
   */
  @Test
  void testUpdatePostTransformFilters7() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer toNewTransform = new ElementTransformer();
    MigrateElement migration = new MigrateElement(MigrateElement.ElementType.EDGE, "ELEMENT", "ELEMENT", toNewTransform,
        new ElementTransformer());

    ElementTransformer transformer = new ElementTransformer();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostTransformFilters(migration, "Group", transformer, new ViewElementDefinition()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostTransformFilters(MigrateElement, String, ElementTransformer, ViewElementDefinition)}
   */
  @Test
  void testUpdatePostTransformFilters8() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(false);
    ElementTransformer toNewTransform = new ElementTransformer();
    MigrateElement migration = new MigrateElement(MigrateElement.ElementType.EDGE, "ELEMENT", "ELEMENT", toNewTransform,
        new ElementTransformer());

    ElementTransformer transformer = new ElementTransformer();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostTransformFilters(migration, "Group", transformer, new ViewElementDefinition()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostTransformFilters(MigrateElement, String, ElementTransformer, ViewElementDefinition)}
   */
  @Test
  void testUpdatePostTransformFilters9() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    ElementTransformer toNewTransform = new ElementTransformer();
    MigrateElement migration = new MigrateElement(MigrateElement.ElementType.ENTITY, "ELEMENT", "ELEMENT",
        toNewTransform, new ElementTransformer());

    ElementTransformer transformer = new ElementTransformer();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostTransformFilters(migration, "Group", transformer, new ViewElementDefinition()));
  }

  /**
   * Method under test:
   * {@link ViewMigration#updatePostTransformFilters(MigrateElement, String, ViewElementDefinition)}
   */
  @Test
  void testUpdatePostTransformFilters10() {
    // Arrange
    ViewMigration viewMigration = new ViewMigration(true);
    MigrateElement migration = new MigrateElement();

    // Act and Assert
    assertSame(viewMigration,
        viewMigration.updatePostTransformFilters(migration, "Group", new ViewElementDefinition()));
  }

  /**
   * Method under test: {@link ViewMigration#buildViewElementDefinition()}
   */
  @Test
  void testBuildViewElementDefinition() throws SchemaException {
    // Arrange and Act
    ViewElementDefinition actualBuildViewElementDefinitionResult = (new ViewMigration(true))
        .buildViewElementDefinition();

    // Assert
    assertNull(actualBuildViewElementDefinitionResult.getTransformFunctions());
    assertNull(actualBuildViewElementDefinitionResult.getPostAggregationFilterFunctions());
    assertNull(actualBuildViewElementDefinitionResult.getPostTransformFilterFunctions());
    assertNull(actualBuildViewElementDefinitionResult.getPreAggregationFilterFunctions());
    assertNull(actualBuildViewElementDefinitionResult.getTransientPropertyMapWithClassNames());
    assertNull(actualBuildViewElementDefinitionResult.getExcludeProperties());
    assertNull(actualBuildViewElementDefinitionResult.getGroupBy());
    assertNull(actualBuildViewElementDefinitionResult.getProperties());
    assertNull(actualBuildViewElementDefinitionResult.getAggregator());
    assertNull(actualBuildViewElementDefinitionResult.getPostAggregationFilter());
    assertNull(actualBuildViewElementDefinitionResult.getPostTransformFilter());
    assertNull(actualBuildViewElementDefinitionResult.getPreAggregationFilter());
    assertNull(actualBuildViewElementDefinitionResult.getTransformer());
    assertFalse(actualBuildViewElementDefinitionResult.hasPostAggregationFilters());
    assertFalse(actualBuildViewElementDefinitionResult.hasPostTransformFilters());
    assertFalse(actualBuildViewElementDefinitionResult.hasPreAggregationFilters());
    assertFalse(actualBuildViewElementDefinitionResult.hasTransform());
    assertFalse(actualBuildViewElementDefinitionResult.isEmpty());
    assertTrue(actualBuildViewElementDefinitionResult.getTransientPropertyClasses().isEmpty());
    assertTrue(actualBuildViewElementDefinitionResult.getTransientPropertyMap().isEmpty());
    assertTrue(actualBuildViewElementDefinitionResult.getTransientProperties().isEmpty());
    assertTrue(actualBuildViewElementDefinitionResult.isAllProperties());
    assertArrayEquals(new byte[]{'{', '}'}, actualBuildViewElementDefinitionResult.toCompactJson());
  }

  /**
   * Method under test: {@link ViewMigration#ViewMigration(boolean)}
   */
  @Test
  void testNewViewMigration() throws SchemaException {
    // Arrange, Act and Assert
    ViewElementDefinition buildViewElementDefinitionResult = (new ViewMigration(true)).buildViewElementDefinition();
    assertNull(buildViewElementDefinitionResult.getTransformFunctions());
    assertNull(buildViewElementDefinitionResult.getPostAggregationFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getPostTransformFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilterFunctions());
    assertNull(buildViewElementDefinitionResult.getTransientPropertyMapWithClassNames());
    assertNull(buildViewElementDefinitionResult.getExcludeProperties());
    assertNull(buildViewElementDefinitionResult.getGroupBy());
    assertNull(buildViewElementDefinitionResult.getProperties());
    assertNull(buildViewElementDefinitionResult.getAggregator());
    assertNull(buildViewElementDefinitionResult.getPostAggregationFilter());
    assertNull(buildViewElementDefinitionResult.getPostTransformFilter());
    assertNull(buildViewElementDefinitionResult.getPreAggregationFilter());
    assertNull(buildViewElementDefinitionResult.getTransformer());
    assertFalse(buildViewElementDefinitionResult.hasPostAggregationFilters());
    assertFalse(buildViewElementDefinitionResult.hasPostTransformFilters());
    assertFalse(buildViewElementDefinitionResult.hasPreAggregationFilters());
    assertFalse(buildViewElementDefinitionResult.hasTransform());
    assertFalse(buildViewElementDefinitionResult.isEmpty());
    assertTrue(buildViewElementDefinitionResult.getTransientPropertyClasses().isEmpty());
    assertTrue(buildViewElementDefinitionResult.getTransientPropertyMap().isEmpty());
    assertTrue(buildViewElementDefinitionResult.getTransientProperties().isEmpty());
    assertTrue(buildViewElementDefinitionResult.isAllProperties());
    assertArrayEquals(new byte[]{'{', '}'}, buildViewElementDefinitionResult.toCompactJson());
  }
}
