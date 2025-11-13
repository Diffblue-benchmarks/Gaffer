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
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer;
import uk.gov.gchq.gaffer.operation.impl.function.Transform.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;

class TransformDiffblueTest {
  /**
   * Test Builder {@link Builder#edge(String, ElementTransformer)}.
   * <p>
   * Method under test: {@link Builder#edge(String, ElementTransformer)}
   */
  @Test
  @DisplayName("Test Builder edge(String, ElementTransformer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edge(String, ElementTransformer)"})
  void testBuilderEdge() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.edge("Group", new ElementTransformer()));
  }

  /**
   * Test Builder {@link Builder#edges(Map)}.
   * <p>
   * Method under test: {@link Builder#edges(Map)}
   */
  @Test
  @DisplayName("Test Builder edges(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Map)"})
  void testBuilderEdges() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.edges(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#entities(Map)}.
   * <p>
   * Method under test: {@link Builder#entities(Map)}
   */
  @Test
  @DisplayName("Test Builder entities(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Map)"})
  void testBuilderEntities() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.entities(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#entity(String, ElementTransformer)}.
   * <p>
   * Method under test: {@link Builder#entity(String, ElementTransformer)}
   */
  @Test
  @DisplayName("Test Builder entity(String, ElementTransformer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entity(String, ElementTransformer)"})
  void testBuilderEntity() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.entity("Group", new ElementTransformer()));
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    Transform _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends Element>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getEdges());
    assertNull(_getOpResult.getEntities());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link Transform#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link Transform#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference Transform.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends Element>> actualOutputTypeReference = (new Transform()).getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableElement);
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link Transform#shallowClone()}.
   * <ul>
   *   <li>Given {@link Transform} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Transform#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given Transform (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Transform Transform.shallowClone()"})
  void testShallowClone_givenTransformOptionsIsHashMap_thenReturnOptionsEmpty() throws CloneFailedException {
    // Arrange
    Transform transform = new Transform();
    transform.setOptions(new HashMap<>());

    // Act
    Transform actualShallowCloneResult = transform.shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getEdges());
    assertNull(actualShallowCloneResult.getEntities());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link Transform#shallowClone()}.
   * <ul>
   *   <li>Given {@link Transform} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Transform#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given Transform (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Transform Transform.shallowClone()"})
  void testShallowClone_givenTransform_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    Transform actualShallowCloneResult = (new Transform()).shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Transform}
   *   <li>{@link Transform#setEdges(Map)}
   *   <li>{@link Transform#setEntities(Map)}
   *   <li>{@link Transform#setInput(Iterable)}
   *   <li>{@link Transform#setOptions(Map)}
   *   <li>{@link Transform#getEdges()}
   *   <li>{@link Transform#getEntities()}
   *   <li>{@link Transform#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Transform.<init>()", "Map Transform.getEdges()", "Map Transform.getEntities()",
      "Map Transform.getOptions()", "void Transform.setEdges(Map)", "void Transform.setEntities(Map)",
      "void Transform.setInput(Iterable)", "void Transform.setOptions(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    Transform actualTransform = new Transform();
    HashMap<String, ElementTransformer> edges = new HashMap<>();
    actualTransform.setEdges(edges);
    HashMap<String, ElementTransformer> entities = new HashMap<>();
    actualTransform.setEntities(entities);
    ArrayList<Element> input = new ArrayList<>();
    actualTransform.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualTransform.setOptions(options);
    Map<String, ElementTransformer> actualEdges = actualTransform.getEdges();
    Map<String, ElementTransformer> actualEntities = actualTransform.getEntities();
    Map<String, String> actualOptions = actualTransform.getOptions();

    // Assert
    Iterable<? extends Element> input2 = actualTransform.getInput();
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
