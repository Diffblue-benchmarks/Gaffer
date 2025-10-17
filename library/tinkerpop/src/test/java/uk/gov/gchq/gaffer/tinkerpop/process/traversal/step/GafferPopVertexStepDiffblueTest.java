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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.apache.tinkerpop.gremlin.groovy.jsr223.dsl.credential.DefaultCredentialTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.step.map.VertexStep;
import org.apache.tinkerpop.gremlin.process.traversal.traverser.TraverserRequirement;
import org.apache.tinkerpop.gremlin.structure.Direction;
import org.apache.tinkerpop.gremlin.structure.Element;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GafferPopVertexStepDiffblueTest {
  /**
   * Test {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}.
   *
   * <p>Method under test: {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}
   */
  @Test
  @DisplayName("Test new GafferPopVertexStep(VertexStep)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopVertexStep.<init>(VertexStep)"})
  void testNewGafferPopVertexStep() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    VertexStep<Element> originalVertexStep =
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels");

    // Act
    GafferPopVertexStep<Element> actualGafferPopVertexStep =
        new GafferPopVertexStep<>(originalVertexStep);

    // Assert
    assertFalse(actualGafferPopVertexStep.hasNext());
  }

  /**
   * Test {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}
   */
  @Test
  @DisplayName("Test new GafferPopVertexStep(VertexStep); given '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopVertexStep.<init>(VertexStep)"})
  void testNewGafferPopVertexStep_given42() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    VertexStep<Element> originalVertexStep =
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels");
    originalVertexStep.addLabel("42");
    originalVertexStep.addLabel("Label");

    // Act
    GafferPopVertexStep<Element> actualGafferPopVertexStep =
        new GafferPopVertexStep<>(originalVertexStep);

    // Assert
    assertFalse(actualGafferPopVertexStep.hasNext());
  }

  /**
   * Test {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}.
   *
   * <ul>
   *   <li>Given {@code Label}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertexStep#GafferPopVertexStep(VertexStep)}
   */
  @Test
  @DisplayName("Test new GafferPopVertexStep(VertexStep); given 'Label'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopVertexStep.<init>(VertexStep)"})
  void testNewGafferPopVertexStep_givenLabel() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    VertexStep<Element> originalVertexStep =
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels");
    originalVertexStep.addLabel("Label");

    // Act
    GafferPopVertexStep<Element> actualGafferPopVertexStep =
        new GafferPopVertexStep<>(originalVertexStep);

    // Assert
    assertFalse(actualGafferPopVertexStep.hasNext());
  }

  /**
   * Test {@link GafferPopVertexStep#returnsVertex()}.
   *
   * <ul>
   *   <li>Given {@code Element}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertexStep#returnsVertex()}
   */
  @Test
  @DisplayName(
      "Test returnsVertex(); given 'org.apache.tinkerpop.gremlin.structure.Element'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopVertexStep.returnsVertex()"})
  void testReturnsVertex_givenOrgApacheTinkerpopGremlinStructureElement_thenReturnFalse() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    VertexStep<Element> originalVertexStep =
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels");
    GafferPopVertexStep<Element> gafferPopVertexStep =
        new GafferPopVertexStep<>(originalVertexStep);

    // Act and Assert
    assertFalse(gafferPopVertexStep.returnsVertex());
  }

  /**
   * Test {@link GafferPopVertexStep#returnsEdge()}.
   *
   * <ul>
   *   <li>Given {@code Element}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertexStep#returnsEdge()}
   */
  @Test
  @DisplayName(
      "Test returnsEdge(); given 'org.apache.tinkerpop.gremlin.structure.Element'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopVertexStep.returnsEdge()"})
  void testReturnsEdge_givenOrgApacheTinkerpopGremlinStructureElement_thenReturnFalse() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    VertexStep<Element> originalVertexStep =
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels");
    GafferPopVertexStep<Element> gafferPopVertexStep =
        new GafferPopVertexStep<>(originalVertexStep);

    // Act and Assert
    assertFalse(gafferPopVertexStep.returnsEdge());
  }

  /**
   * Test {@link GafferPopVertexStep#equals(Object)}, and {@link GafferPopVertexStep#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GafferPopVertexStep#equals(Object)}
   *   <li>{@link GafferPopVertexStep#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GafferPopVertexStep.equals(Object)",
    "int GafferPopVertexStep.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    VertexStep<Element> originalVertexStep =
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels");
    GafferPopVertexStep<Element> gafferPopVertexStep =
        new GafferPopVertexStep<>(originalVertexStep);
    DefaultCredentialTraversal traversal2 = new DefaultCredentialTraversal();
    Class<Element> returnClass2 = Element.class;

    VertexStep<Element> originalVertexStep2 =
        new VertexStep<>(traversal2, returnClass2, Direction.OUT, "Edge Labels");
    GafferPopVertexStep<Element> gafferPopVertexStep2 =
        new GafferPopVertexStep<>(originalVertexStep2);

    // Act and Assert
    assertEquals(gafferPopVertexStep, gafferPopVertexStep2);
    assertEquals(gafferPopVertexStep.hashCode(), gafferPopVertexStep2.hashCode());
  }

  /**
   * Test {@link GafferPopVertexStep#equals(Object)}, and {@link GafferPopVertexStep#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GafferPopVertexStep#equals(Object)}
   *   <li>{@link GafferPopVertexStep#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GafferPopVertexStep.equals(Object)",
    "int GafferPopVertexStep.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    VertexStep<Element> originalVertexStep =
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels");
    GafferPopVertexStep<Element> gafferPopVertexStep =
        new GafferPopVertexStep<>(originalVertexStep);

    // Act and Assert
    assertEquals(gafferPopVertexStep, gafferPopVertexStep);
    int expectedHashCodeResult = gafferPopVertexStep.hashCode();
    assertEquals(expectedHashCodeResult, gafferPopVertexStep.hashCode());
  }

  /**
   * Test {@link GafferPopVertexStep#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertexStep#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GafferPopVertexStep.equals(Object)",
    "int GafferPopVertexStep.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    VertexStep<Element> originalVertexStep =
        new VertexStep<>(traversal, returnClass, Direction.OUT, null);
    GafferPopVertexStep<Element> gafferPopVertexStep =
        new GafferPopVertexStep<>(originalVertexStep);
    DefaultCredentialTraversal traversal2 = new DefaultCredentialTraversal();
    Class<Element> returnClass2 = Element.class;

    VertexStep<Element> originalVertexStep2 =
        new VertexStep<>(traversal2, returnClass2, Direction.OUT, "Edge Labels");

    // Act and Assert
    assertNotEquals(gafferPopVertexStep, new GafferPopVertexStep<>(originalVertexStep2));
  }

  /**
   * Test {@link GafferPopVertexStep#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertexStep#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GafferPopVertexStep.equals(Object)",
    "int GafferPopVertexStep.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;
    GafferPopVertexStep<Element> gafferPopVertexStep =
        new GafferPopVertexStep<>(new VertexStep<>(traversal, returnClass, Direction.OUT));
    DefaultCredentialTraversal traversal2 = new DefaultCredentialTraversal();
    Class<Element> returnClass2 = Element.class;

    VertexStep<Element> originalVertexStep =
        new VertexStep<>(traversal2, returnClass2, Direction.OUT, "Edge Labels");

    // Act and Assert
    assertNotEquals(gafferPopVertexStep, new GafferPopVertexStep<>(originalVertexStep));
  }

  /**
   * Test {@link GafferPopVertexStep#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertexStep#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GafferPopVertexStep.equals(Object)",
    "int GafferPopVertexStep.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    VertexStep<Element> originalVertexStep =
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels");
    GafferPopVertexStep<Element> gafferPopVertexStep =
        new GafferPopVertexStep<>(originalVertexStep);

    // Act and Assert
    assertNotEquals(gafferPopVertexStep, null);
  }

  /**
   * Test {@link GafferPopVertexStep#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertexStep#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GafferPopVertexStep.equals(Object)",
    "int GafferPopVertexStep.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    VertexStep<Element> originalVertexStep =
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels");
    GafferPopVertexStep<Element> gafferPopVertexStep =
        new GafferPopVertexStep<>(originalVertexStep);

    // Act and Assert
    assertNotEquals(gafferPopVertexStep, "Different type to GafferPopVertexStep");
  }

  /**
   * Test {@link GafferPopVertexStep#getRequirements()}.
   *
   * <p>Method under test: {@link GafferPopVertexStep#getRequirements()}
   */
  @Test
  @DisplayName("Test getRequirements()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GafferPopVertexStep.getRequirements()"})
  void testGetRequirements() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    Class<Element> returnClass = Element.class;

    VertexStep<Element> originalVertexStep =
        new VertexStep<>(traversal, returnClass, Direction.OUT, "Edge Labels");
    GafferPopVertexStep<Element> gafferPopVertexStep =
        new GafferPopVertexStep<>(originalVertexStep);

    // Act
    Set<TraverserRequirement> actualRequirements = gafferPopVertexStep.getRequirements();

    // Assert
    assertEquals(1, actualRequirements.size());
    assertTrue(actualRequirements.contains(TraverserRequirement.OBJECT));
  }
}
