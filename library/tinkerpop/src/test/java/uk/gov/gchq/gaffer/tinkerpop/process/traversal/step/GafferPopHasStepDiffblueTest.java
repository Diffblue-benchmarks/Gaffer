/*
 * Copyright 2026 Crown Copyright
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.tinkerpop.gremlin.groovy.jsr223.dsl.credential.DefaultCredentialTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.P;
import org.apache.tinkerpop.gremlin.process.traversal.TextP;
import org.apache.tinkerpop.gremlin.process.traversal.step.filter.HasStep;
import org.apache.tinkerpop.gremlin.process.traversal.step.util.HasContainer;
import org.apache.tinkerpop.gremlin.structure.Element;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GafferPopHasStepDiffblueTest {
  /**
   * Test {@link GafferPopHasStep#GafferPopHasStep(HasStep)}.
   *
   * <p>Method under test: {@link GafferPopHasStep#GafferPopHasStep(HasStep)}
   */
  @Test
  @DisplayName("Test new GafferPopHasStep(HasStep)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasStep.<init>(HasStep)"})
  void testNewGafferPopHasStep() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    P<?> predicate = P.between("First", "Second");
    HasContainer hasContainer = new HasContainer("Key", predicate);

    HasStep<Element> originalHasStep = new HasStep<>(traversal, hasContainer);

    // Act
    GafferPopHasStep<Element> actualGafferPopHasStep = new GafferPopHasStep<>(originalHasStep);

    // Assert
    assertFalse(actualGafferPopHasStep.hasNext());
  }

  /**
   * Test {@link GafferPopHasStep#GafferPopHasStep(HasStep)}.
   *
   * <p>Method under test: {@link GafferPopHasStep#GafferPopHasStep(HasStep)}
   */
  @Test
  @DisplayName("Test new GafferPopHasStep(HasStep)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasStep.<init>(HasStep)"})
  void testNewGafferPopHasStep2() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    P<?> predicate = P.between("First", "Second");
    HasContainer hasContainer = new HasContainer("Key", predicate);

    HasStep<Element> originalHasStep = new HasStep<>(traversal, hasContainer);
    P<?> predicate2 = P.between("First", "Second");
    HasContainer hasContainer2 =
        new HasContainer("xx[type=xx,  subType=xx,  value=xx]", predicate2);
    originalHasStep.addHasContainer(hasContainer2);

    // Act
    GafferPopHasStep<Element> actualGafferPopHasStep = new GafferPopHasStep<>(originalHasStep);

    // Assert
    assertFalse(actualGafferPopHasStep.hasNext());
  }

  /**
   * Test {@link GafferPopHasStep#GafferPopHasStep(HasStep)}.
   *
   * <p>Method under test: {@link GafferPopHasStep#GafferPopHasStep(HasStep)}
   */
  @Test
  @DisplayName("Test new GafferPopHasStep(HasStep)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasStep.<init>(HasStep)"})
  void testNewGafferPopHasStep3() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    P<?> predicate = P.between("First", "Second");
    HasContainer hasContainer = new HasContainer("Key", predicate);

    HasStep<Element> originalHasStep = new HasStep<>(traversal, hasContainer);
    P<?> predicate2 = P.between("xx[type=xx,  subType=xx,  value=xx]", "Second");
    HasContainer hasContainer2 =
        new HasContainer("xx[type=xx,  subType=xx,  value=xx]", predicate2);
    originalHasStep.addHasContainer(hasContainer2);

    // Act
    GafferPopHasStep<Element> actualGafferPopHasStep = new GafferPopHasStep<>(originalHasStep);

    // Assert
    assertFalse(actualGafferPopHasStep.hasNext());
  }

  /**
   * Test {@link GafferPopHasStep#GafferPopHasStep(HasStep)}.
   *
   * <p>Method under test: {@link GafferPopHasStep#GafferPopHasStep(HasStep)}
   */
  @Test
  @DisplayName("Test new GafferPopHasStep(HasStep)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasStep.<init>(HasStep)"})
  void testNewGafferPopHasStep4() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    P<?> predicate = P.between("First", "Second");
    HasContainer hasContainer = new HasContainer("Key", predicate);

    HasStep<Element> originalHasStep = new HasStep<>(traversal, hasContainer);
    P<?> predicate2 = P.between(1, "Second");
    HasContainer hasContainer2 =
        new HasContainer("xx[type=xx,  subType=xx,  value=xx]", predicate2);
    originalHasStep.addHasContainer(hasContainer2);

    // Act
    GafferPopHasStep<Element> actualGafferPopHasStep = new GafferPopHasStep<>(originalHasStep);

    // Assert
    assertFalse(actualGafferPopHasStep.hasNext());
  }

  /**
   * Test {@link GafferPopHasStep#GafferPopHasStep(HasStep)}.
   *
   * <ul>
   *   <li>When {@link HasContainer#HasContainer(String, P)} with {@code Key} and predicate is
   *       containing {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasStep#GafferPopHasStep(HasStep)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopHasStep(HasStep); when HasContainer(String, P) with 'Key' and predicate is containing '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasStep.<init>(HasStep)"})
  void testNewGafferPopHasStep_whenHasContainerWithKeyAndPredicateIsContaining42() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    HasContainer hasContainer = new HasContainer("Key", TextP.containing("42"));

    HasStep<Element> originalHasStep = new HasStep<>(traversal, hasContainer);

    // Act
    GafferPopHasStep<Element> actualGafferPopHasStep = new GafferPopHasStep<>(originalHasStep);

    // Assert
    assertFalse(actualGafferPopHasStep.hasNext());
  }

  /**
   * Test {@link GafferPopHasStep#GafferPopHasStep(HasStep)}.
   *
   * <ul>
   *   <li>When {@link HasContainer#HasContainer(String, P)} with {@code Key} and predicate is
   *       endingWith {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasStep#GafferPopHasStep(HasStep)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopHasStep(HasStep); when HasContainer(String, P) with 'Key' and predicate is endingWith '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasStep.<init>(HasStep)"})
  void testNewGafferPopHasStep_whenHasContainerWithKeyAndPredicateIsEndingWith42() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    HasContainer hasContainer = new HasContainer("Key", TextP.endingWith("42"));

    HasStep<Element> originalHasStep = new HasStep<>(traversal, hasContainer);

    // Act
    GafferPopHasStep<Element> actualGafferPopHasStep = new GafferPopHasStep<>(originalHasStep);

    // Assert
    assertFalse(actualGafferPopHasStep.hasNext());
  }

  /**
   * Test {@link GafferPopHasStep#GafferPopHasStep(HasStep)}.
   *
   * <ul>
   *   <li>When {@link HasContainer#HasContainer(String, P)} with {@code Key} and predicate is eq
   *       {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasStep#GafferPopHasStep(HasStep)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopHasStep(HasStep); when HasContainer(String, P) with 'Key' and predicate is eq 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasStep.<init>(HasStep)"})
  void testNewGafferPopHasStep_whenHasContainerWithKeyAndPredicateIsEqValue() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    P<?> predicate = P.eq("Value");
    HasContainer hasContainer = new HasContainer("Key", predicate);

    HasStep<Element> originalHasStep = new HasStep<>(traversal, hasContainer);

    // Act
    GafferPopHasStep<Element> actualGafferPopHasStep = new GafferPopHasStep<>(originalHasStep);

    // Assert
    assertFalse(actualGafferPopHasStep.hasNext());
  }

  /**
   * Test {@link GafferPopHasStep#GafferPopHasStep(HasStep)}.
   *
   * <ul>
   *   <li>When {@link HasContainer#HasContainer(String, P)} with {@code Key} and predicate is gt
   *       {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasStep#GafferPopHasStep(HasStep)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopHasStep(HasStep); when HasContainer(String, P) with 'Key' and predicate is gt 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasStep.<init>(HasStep)"})
  void testNewGafferPopHasStep_whenHasContainerWithKeyAndPredicateIsGtValue() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    P<?> predicate = P.gt("Value");
    HasContainer hasContainer = new HasContainer("Key", predicate);

    HasStep<Element> originalHasStep = new HasStep<>(traversal, hasContainer);

    // Act
    GafferPopHasStep<Element> actualGafferPopHasStep = new GafferPopHasStep<>(originalHasStep);

    // Assert
    assertFalse(actualGafferPopHasStep.hasNext());
  }

  /**
   * Test {@link GafferPopHasStep#GafferPopHasStep(HasStep)}.
   *
   * <ul>
   *   <li>When {@link HasContainer#HasContainer(String, P)} with {@code Key} and predicate is
   *       notContaining {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasStep#GafferPopHasStep(HasStep)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopHasStep(HasStep); when HasContainer(String, P) with 'Key' and predicate is notContaining '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasStep.<init>(HasStep)"})
  void testNewGafferPopHasStep_whenHasContainerWithKeyAndPredicateIsNotContaining42() {
    // Arrange
    DefaultCredentialTraversal traversal = new DefaultCredentialTraversal();
    HasContainer hasContainer = new HasContainer("Key", TextP.notContaining("42"));

    HasStep<Element> originalHasStep = new HasStep<>(traversal, hasContainer);

    // Act
    GafferPopHasStep<Element> actualGafferPopHasStep = new GafferPopHasStep<>(originalHasStep);

    // Assert
    assertFalse(actualGafferPopHasStep.hasNext());
  }
}
