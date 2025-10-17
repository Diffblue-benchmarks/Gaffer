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

package uk.gov.gchq.gaffer.operation.impl.output;

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.operation.impl.output.ToVertices.Builder;
import uk.gov.gchq.gaffer.operation.impl.output.ToVertices.EdgeVertices;
import uk.gov.gchq.gaffer.operation.impl.output.ToVertices.UseMatchedVertex;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableObj;

class ToVerticesDiffblueTest {
  /**
   * Test Builder {@link Builder#edgeVertices(EdgeVertices)}.
   *
   * <p>Method under test: {@link Builder#edgeVertices(EdgeVertices)}
   */
  @Test
  @DisplayName("Test Builder edgeVertices(EdgeVertices)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edgeVertices(EdgeVertices)"})
  void testBuilderEdgeVertices() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgeVerticesResult = builder.edgeVertices(EdgeVertices.NONE);

    // Assert
    assertSame(builder, actualEdgeVerticesResult);
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
    ToVertices _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getEdgeVertices());
    assertNull(_getOpResult.getUseMatchedVertex());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    ToVertices actualToVertices = actualBuilder.build();
    assertSame(_getOpResult, actualToVertices);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test Builder {@link Builder#useMatchedVertex(UseMatchedVertex)}.
   *
   * <p>Method under test: {@link Builder#useMatchedVertex(UseMatchedVertex)}
   */
  @Test
  @DisplayName("Test Builder useMatchedVertex(UseMatchedVertex)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.useMatchedVertex(UseMatchedVertex)"})
  void testBuilderUseMatchedVertex() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualUseMatchedVertexResult = builder.useMatchedVertex(UseMatchedVertex.IGNORE);

    // Assert
    assertSame(builder, actualUseMatchedVertexResult);
  }

  /**
   * Test {@link ToVertices#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToVertices#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ToVertices.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ToVertices().getInput());
  }

  /**
   * Test {@link ToVertices#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ToVertices#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference ToVertices.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<?>> actualOutputTypeReference =
        new ToVertices().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link ToVertices#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ToVertices} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToVertices#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ToVertices (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToVertices ToVertices.shallowClone()"})
  void testShallowClone_givenToVerticesOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    ToVertices toVertices = new ToVertices();
    toVertices.setOptions(new HashMap<>());

    // Act
    ToVertices actualShallowCloneResult = toVertices.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getEdgeVertices());
    assertNull(actualShallowCloneResult.getUseMatchedVertex());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToVertices#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ToVertices} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToVertices#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ToVertices (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToVertices ToVertices.shallowClone()"})
  void testShallowClone_givenToVertices_thenReturnOptionsIsNull() {
    // Arrange and Act
    ToVertices actualShallowCloneResult = new ToVertices().shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getEdgeVertices());
    assertNull(actualShallowCloneResult.getUseMatchedVertex());
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
   *   <li>default or parameterless constructor of {@link ToVertices}
   *   <li>{@link ToVertices#setEdgeVertices(EdgeVertices)}
   *   <li>{@link ToVertices#setInput(Iterable)}
   *   <li>{@link ToVertices#setOptions(Map)}
   *   <li>{@link ToVertices#setUseMatchedVertex(UseMatchedVertex)}
   *   <li>{@link ToVertices#getEdgeVertices()}
   *   <li>{@link ToVertices#getOptions()}
   *   <li>{@link ToVertices#getUseMatchedVertex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToVertices.<init>()",
    "EdgeVertices ToVertices.getEdgeVertices()",
    "Map ToVertices.getOptions()",
    "UseMatchedVertex ToVertices.getUseMatchedVertex()",
    "void ToVertices.setEdgeVertices(EdgeVertices)",
    "void ToVertices.setInput(Iterable)",
    "void ToVertices.setOptions(Map)",
    "void ToVertices.setUseMatchedVertex(UseMatchedVertex)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ToVertices actualToVertices = new ToVertices();
    actualToVertices.setEdgeVertices(EdgeVertices.NONE);
    ArrayList<ElementId> input = new ArrayList<>();
    actualToVertices.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualToVertices.setOptions(options);
    actualToVertices.setUseMatchedVertex(UseMatchedVertex.IGNORE);
    EdgeVertices actualEdgeVertices = actualToVertices.getEdgeVertices();
    Map<String, String> actualOptions = actualToVertices.getOptions();
    UseMatchedVertex actualUseMatchedVertex = actualToVertices.getUseMatchedVertex();

    // Assert
    Iterable<? extends ElementId> input2 = actualToVertices.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(EdgeVertices.NONE, actualEdgeVertices);
    assertEquals(UseMatchedVertex.IGNORE, actualUseMatchedVertex);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
