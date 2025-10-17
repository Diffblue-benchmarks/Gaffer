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

package uk.gov.gchq.gaffer.operation.impl.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.function.Aggregate.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;
import uk.gov.gchq.gaffer.operation.util.AggregatePair;

class AggregateDiffblueTest {
  /**
   * Test Builder {@link Builder#edge(String, AggregatePair)}.
   *
   * <p>Method under test: {@link Builder#edge(String, AggregatePair)}
   */
  @Test
  @DisplayName("Test Builder edge(String, AggregatePair)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edge(String, AggregatePair)"})
  void testBuilderEdge() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgeResult = builder.edge("Group", new AggregatePair());

    // Assert
    assertSame(builder, actualEdgeResult);
  }

  /**
   * Test Builder {@link Builder#edges(Map)}.
   *
   * <p>Method under test: {@link Builder#edges(Map)}
   */
  @Test
  @DisplayName("Test Builder edges(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Map)"})
  void testBuilderEdges() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgesResult = builder.edges(new HashMap<>());

    // Assert
    assertSame(builder, actualEdgesResult);
  }

  /**
   * Test Builder {@link Builder#entities(Map)}.
   *
   * <p>Method under test: {@link Builder#entities(Map)}
   */
  @Test
  @DisplayName("Test Builder entities(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Map)"})
  void testBuilderEntities() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntitiesResult = builder.entities(new HashMap<>());

    // Assert
    assertSame(builder, actualEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#entity(String, AggregatePair)}.
   *
   * <p>Method under test: {@link Builder#entity(String, AggregatePair)}
   */
  @Test
  @DisplayName("Test Builder entity(String, AggregatePair)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entity(String, AggregatePair)"})
  void testBuilderEntity() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntityResult = builder.entity("Group", new AggregatePair());

    // Assert
    assertSame(builder, actualEntityResult);
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
    Aggregate _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getEdges());
    assertNull(_getOpResult.getEntities());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    Aggregate actualAggregate = actualBuilder.build();
    assertSame(_getOpResult, actualAggregate);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link Aggregate#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Aggregate#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable Aggregate.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Aggregate().getInput());
  }

  /**
   * Test {@link Aggregate#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link Aggregate#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference Aggregate.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends Element>> actualOutputTypeReference =
        new Aggregate().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableElement);
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link Aggregate#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Aggregate} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link Aggregate#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given Aggregate (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Aggregate Aggregate.shallowClone()"})
  void testShallowClone_givenAggregateOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    Aggregate aggregate = new Aggregate();
    aggregate.setOptions(new HashMap<>());

    // Act
    Aggregate actualShallowCloneResult = aggregate.shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getEdges());
    assertNull(actualShallowCloneResult.getEntities());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link Aggregate#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Aggregate} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Aggregate#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given Aggregate (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Aggregate Aggregate.shallowClone()"})
  void testShallowClone_givenAggregate_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    Aggregate actualShallowCloneResult = new Aggregate().shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getEdges());
    assertNull(actualShallowCloneResult.getEntities());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Aggregate}
   *   <li>{@link Aggregate#setEdges(Map)}
   *   <li>{@link Aggregate#setEntities(Map)}
   *   <li>{@link Aggregate#setInput(Iterable)}
   *   <li>{@link Aggregate#setOptions(Map)}
   *   <li>{@link Aggregate#getEdges()}
   *   <li>{@link Aggregate#getEntities()}
   *   <li>{@link Aggregate#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Aggregate.<init>()",
    "Map Aggregate.getEdges()",
    "Map Aggregate.getEntities()",
    "Map Aggregate.getOptions()",
    "void Aggregate.setEdges(Map)",
    "void Aggregate.setEntities(Map)",
    "void Aggregate.setInput(Iterable)",
    "void Aggregate.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Aggregate actualAggregate = new Aggregate();
    HashMap<String, AggregatePair> edges = new HashMap<>();
    actualAggregate.setEdges(edges);
    HashMap<String, AggregatePair> entities = new HashMap<>();
    actualAggregate.setEntities(entities);
    ArrayList<Element> input = new ArrayList<>();
    actualAggregate.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualAggregate.setOptions(options);
    Map<String, AggregatePair> actualEdges = actualAggregate.getEdges();
    Map<String, AggregatePair> actualEntities = actualAggregate.getEntities();
    Map<String, String> actualOptions = actualAggregate.getOptions();

    // Assert
    Iterable<? extends Element> input2 = actualAggregate.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualEdges.isEmpty());
    assertTrue(actualEntities.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(edges, actualEdges);
    assertSame(entities, actualEntities);
    assertSame(options, actualOptions);
  }
}
