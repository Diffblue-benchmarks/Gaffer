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

package uk.gov.gchq.gaffer.tinkerpop.process.traversal.step;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Set;
import org.apache.tinkerpop.gremlin.groovy.jsr223.dsl.credential.CredentialTraversalSource;
import org.apache.tinkerpop.gremlin.groovy.jsr223.dsl.credential.DefaultCredentialTraversal;
import org.apache.tinkerpop.gremlin.process.remote.EmbeddedRemoteConnection;
import org.apache.tinkerpop.gremlin.process.remote.RemoteConnection;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.step.map.VertexStep;
import org.apache.tinkerpop.gremlin.process.traversal.traverser.TraverserRequirement;
import org.apache.tinkerpop.gremlin.structure.Direction;
import org.apache.tinkerpop.gremlin.structure.Element;
import org.junit.Test;

public class GafferPopVertexStepDiffblueTest {
  /**
   * Method under test: {@link GafferPopVertexStep#returnsVertex()}
   */
  @Test
  public void testReturnsVertex() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));

    // Act and Assert
    assertFalse(gafferPopVertexStep.returnsVertex());
  }

  /**
   * Method under test: {@link GafferPopVertexStep#returnsVertex()}
   */
  @Test
  public void testReturnsVertex2() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal(new CredentialTraversalSource(
        new EmbeddedRemoteConnection(new GraphTraversalSource(mock(RemoteConnection.class)))));
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));

    // Act and Assert
    assertFalse(gafferPopVertexStep.returnsVertex());
  }

  /**
   * Method under test: {@link GafferPopVertexStep#returnsEdge()}
   */
  @Test
  public void testReturnsEdge() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));

    // Act and Assert
    assertFalse(gafferPopVertexStep.returnsEdge());
  }

  /**
   * Method under test: {@link GafferPopVertexStep#returnsEdge()}
   */
  @Test
  public void testReturnsEdge2() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal(new CredentialTraversalSource(
        new EmbeddedRemoteConnection(new GraphTraversalSource(mock(RemoteConnection.class)))));
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));

    // Act and Assert
    assertFalse(gafferPopVertexStep.returnsEdge());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GafferPopVertexStep#equals(Object)}
   *   <li>{@link GafferPopVertexStep#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));
    DefaultCredentialTraversal traversal2 = new DefaultCredentialTraversal();
    Class<Element> returnClass2 = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep2 = new GafferPopVertexStep<>(
        new VertexStep<>(traversal2, returnClass2, Direction.OUT, "Edge Labels"));

    // Act and Assert
    assertEquals(gafferPopVertexStep, gafferPopVertexStep2);
    int expectedHashCodeResult = gafferPopVertexStep.hashCode();
    assertEquals(expectedHashCodeResult, gafferPopVertexStep2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GafferPopVertexStep#equals(Object)}
   *   <li>{@link GafferPopVertexStep#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));

    // Act and Assert
    assertEquals(gafferPopVertexStep, gafferPopVertexStep);
    int expectedHashCodeResult = gafferPopVertexStep.hashCode();
    assertEquals(expectedHashCodeResult, gafferPopVertexStep.hashCode());
  }

  /**
   * Method under test: {@link GafferPopVertexStep#getRequirements()}
   */
  @Test
  public void testGetRequirements() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));

    // Act
    Set<TraverserRequirement> actualRequirements = gafferPopVertexStep.getRequirements();

    // Assert
    assertEquals(1, actualRequirements.size());
    assertTrue(actualRequirements.contains(TraverserRequirement.OBJECT));
  }

  /**
   * Method under test: {@link GafferPopVertexStep#getRequirements()}
   */
  @Test
  public void testGetRequirements2() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal(new CredentialTraversalSource(
        new EmbeddedRemoteConnection(new GraphTraversalSource(mock(RemoteConnection.class)))));
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));

    // Act
    Set<TraverserRequirement> actualRequirements = gafferPopVertexStep.getRequirements();

    // Assert
    assertEquals(1, actualRequirements.size());
    assertTrue(actualRequirements.contains(TraverserRequirement.OBJECT));
  }

  /**
   * Method under test: {@link GafferPopVertexStep#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));

    // Act and Assert
    assertNotEquals(gafferPopVertexStep, null);
  }

  /**
   * Method under test: {@link GafferPopVertexStep#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));

    // Act and Assert
    assertNotEquals(gafferPopVertexStep, "Different type to GafferPopVertexStep");
  }

  /**
   * Method under test:
   * {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}
   */
  @Test
  public void testNewGafferPopVertexStep() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    // Act
    GafferPopVertexStep<Element> actualGafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));

    // Assert
    assertFalse(actualGafferPopVertexStep.hasNext());
  }

  /**
   * Method under test:
   * {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}
   */
  @Test
  public void testNewGafferPopVertexStep2() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal(new CredentialTraversalSource(
        new EmbeddedRemoteConnection(new GraphTraversalSource(mock(RemoteConnection.class)))));
    Class<Element> returnClass = Element.class;

    // Act
    GafferPopVertexStep<Element> actualGafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));

    // Assert
    assertFalse(actualGafferPopVertexStep.hasNext());
  }

  /**
   * Method under test:
   * {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}
   */
  @Test
  public void testNewGafferPopVertexStep3() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    VertexStep<Element> originalVertexStep = new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels");
    originalVertexStep.addLabel("Label");

    // Act
    GafferPopVertexStep<Element> actualGafferPopVertexStep = new GafferPopVertexStep<>(originalVertexStep);

    // Assert
    assertFalse(actualGafferPopVertexStep.hasNext());
  }

  /**
   * Method under test:
   * {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}
   */
  @Test
  public void testNewGafferPopVertexStep4() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    VertexStep<Element> originalVertexStep = new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels");
    originalVertexStep.addLabel("42");
    originalVertexStep.addLabel("Label");

    // Act
    GafferPopVertexStep<Element> actualGafferPopVertexStep = new GafferPopVertexStep<>(originalVertexStep);

    // Assert
    assertFalse(actualGafferPopVertexStep.hasNext());
  }
}
