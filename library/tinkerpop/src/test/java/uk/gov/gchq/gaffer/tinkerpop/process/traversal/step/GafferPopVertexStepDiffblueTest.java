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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.apache.tinkerpop.gremlin.groovy.jsr223.dsl.credential.DefaultCredentialTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.step.map.VertexStep;
import org.apache.tinkerpop.gremlin.process.traversal.traverser.TraverserRequirement;
import org.apache.tinkerpop.gremlin.structure.Direction;
import org.apache.tinkerpop.gremlin.structure.Element;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GafferPopVertexStepDiffblueTest {
  /**
   * Test {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}.
   * <p>
   * Method under test: {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopVertexStep.<init>(VertexStep)"})
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
   * Test {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopVertexStep.<init>(VertexStep)"})
  public void testNewGafferPopVertexStep_given42() {
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

  /**
   * Test {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}.
   * <ul>
   *   <li>Given {@code Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopVertexStep.<init>(VertexStep)"})
  public void testNewGafferPopVertexStep_givenLabel() {
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
   * Test {@link GafferPopVertexStep#returnsVertex()}.
   * <ul>
   *   <li>Given {@code Element}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertexStep#returnsVertex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GafferPopVertexStep.returnsVertex()"})
  public void testReturnsVertex_givenOrgApacheTinkerpopGremlinStructureElement_thenReturnFalse() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));

    // Act and Assert
    assertFalse(gafferPopVertexStep.returnsVertex());
  }

  /**
   * Test {@link GafferPopVertexStep#returnsEdge()}.
   * <ul>
   *   <li>Given {@code Element}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertexStep#returnsEdge()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GafferPopVertexStep.returnsEdge()"})
  public void testReturnsEdge_givenOrgApacheTinkerpopGremlinStructureElement_thenReturnFalse() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels"));

    // Act and Assert
    assertFalse(gafferPopVertexStep.returnsEdge());
  }

  /**
   * Test {@link GafferPopVertexStep#equals(Object)}, and {@link GafferPopVertexStep#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GafferPopVertexStep#equals(Object)}
   *   <li>{@link GafferPopVertexStep#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GafferPopVertexStep.equals(Object)", "int GafferPopVertexStep.hashCode()"})
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
   * Test {@link GafferPopVertexStep#equals(Object)}, and {@link GafferPopVertexStep#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GafferPopVertexStep#equals(Object)}
   *   <li>{@link GafferPopVertexStep#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GafferPopVertexStep.equals(Object)", "int GafferPopVertexStep.hashCode()"})
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
   * Test {@link GafferPopVertexStep#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertexStep#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GafferPopVertexStep.equals(Object)", "int GafferPopVertexStep.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT, null));
    DefaultCredentialTraversal traversal2 = new DefaultCredentialTraversal();
    Class<Element> returnClass2 = Element.class;

    // Act and Assert
    assertNotEquals(gafferPopVertexStep,
        new GafferPopVertexStep<>(new VertexStep<>(traversal2, returnClass2, Direction.OUT, "Edge Labels")));
  }

  /**
   * Test {@link GafferPopVertexStep#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertexStep#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GafferPopVertexStep.equals(Object)", "int GafferPopVertexStep.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep = new GafferPopVertexStep<>(
        new VertexStep<>(traversal, returnClass, Direction.OUT));
    DefaultCredentialTraversal traversal2 = new DefaultCredentialTraversal();
    Class<Element> returnClass2 = Element.class;

    // Act and Assert
    assertNotEquals(gafferPopVertexStep,
        new GafferPopVertexStep<>(new VertexStep<>(traversal2, returnClass2, Direction.OUT, "Edge Labels")));
  }

  /**
   * Test {@link GafferPopVertexStep#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertexStep#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GafferPopVertexStep.equals(Object)", "int GafferPopVertexStep.hashCode()"})
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
   * Test {@link GafferPopVertexStep#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertexStep#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GafferPopVertexStep.equals(Object)", "int GafferPopVertexStep.hashCode()"})
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
   * Test {@link GafferPopVertexStep#getRequirements()}.
   * <p>
   * Method under test: {@link GafferPopVertexStep#getRequirements()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set GafferPopVertexStep.getRequirements()"})
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
}
