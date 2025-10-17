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

package uk.gov.gchq.gaffer.tinkerpop.process.traversal.step.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.function.Predicate;
import org.apache.tinkerpop.gremlin.process.traversal.P;
import org.apache.tinkerpop.gremlin.process.traversal.TextP;
import org.apache.tinkerpop.gremlin.process.traversal.step.util.HasContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;
import uk.gov.gchq.koryphe.impl.predicate.And;
import uk.gov.gchq.koryphe.impl.predicate.IsEqual;
import uk.gov.gchq.koryphe.impl.predicate.IsMoreThan;
import uk.gov.gchq.koryphe.impl.predicate.Not;
import uk.gov.gchq.koryphe.impl.predicate.Regex;
import uk.gov.gchq.koryphe.impl.predicate.StringContains;

class GafferPopHasContainerDiffblueTest {
  /**
   * Test {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}.
   *
   * <p>Method under test: {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  @DisplayName("Test new GafferPopHasContainer(HasContainer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasContainer.<init>(HasContainer)"})
  void testNewGafferPopHasContainer() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);

    // Act
    GafferPopHasContainer actualGafferPopHasContainer = new GafferPopHasContainer(original);

    // Assert
    Predicate gafferPredicate = actualGafferPopHasContainer.getGafferPredicate();
    assertTrue(gafferPredicate instanceof And);
    List components = ((And) gafferPredicate).getComponents();
    assertEquals(2, components.size());
    Object getResult = components.get(0);
    assertTrue(getResult instanceof IsMoreThan);
    assertEquals("First", ((IsMoreThan) getResult).getControlValue());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }

  /**
   * Test {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}.
   *
   * <p>Method under test: {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  @DisplayName("Test new GafferPopHasContainer(HasContainer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasContainer.<init>(HasContainer)"})
  void testNewGafferPopHasContainer2() {
    // Arrange
    P<?> predicate = P.between("xx[type=xx,  subType=xx,  value=xx]", "Second");
    HasContainer original = new HasContainer("Key", predicate);

    // Act
    GafferPopHasContainer actualGafferPopHasContainer = new GafferPopHasContainer(original);

    // Assert
    Predicate gafferPredicate = actualGafferPopHasContainer.getGafferPredicate();
    List components = ((And) gafferPredicate).getComponents();
    assertEquals(2, components.size());
    Object getResult = components.get(0);
    Comparable controlValue = ((IsMoreThan) getResult).getControlValue();
    assertTrue(controlValue instanceof TypeSubTypeValue);
    assertTrue(gafferPredicate instanceof And);
    assertTrue(getResult instanceof IsMoreThan);
    assertEquals("xx", ((TypeSubTypeValue) controlValue).getSubType());
    assertEquals("xx", ((TypeSubTypeValue) controlValue).getType());
    assertEquals("xx", ((TypeSubTypeValue) controlValue).getValue());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }

  /**
   * Test {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}.
   *
   * <p>Method under test: {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  @DisplayName("Test new GafferPopHasContainer(HasContainer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasContainer.<init>(HasContainer)"})
  void testNewGafferPopHasContainer3() {
    // Arrange
    P<?> predicate = P.between(true, "Second");
    HasContainer original = new HasContainer("Key", predicate);

    // Act
    GafferPopHasContainer actualGafferPopHasContainer = new GafferPopHasContainer(original);

    // Assert
    Predicate gafferPredicate = actualGafferPopHasContainer.getGafferPredicate();
    assertTrue(gafferPredicate instanceof And);
    List components = ((And) gafferPredicate).getComponents();
    assertEquals(2, components.size());
    Object getResult = components.get(0);
    assertTrue(getResult instanceof IsMoreThan);
    assertTrue((Boolean) ((IsMoreThan) getResult).getControlValue());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }

  /**
   * Test {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}.
   *
   * <ul>
   *   <li>Then GafferPredicate return {@link IsEqual}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  @DisplayName("Test new GafferPopHasContainer(HasContainer); then GafferPredicate return IsEqual")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasContainer.<init>(HasContainer)"})
  void testNewGafferPopHasContainer_thenGafferPredicateReturnIsEqual() {
    // Arrange
    P<?> predicate = P.eq("Value");
    HasContainer original = new HasContainer("Key", predicate);

    // Act
    GafferPopHasContainer actualGafferPopHasContainer = new GafferPopHasContainer(original);

    // Assert
    Predicate gafferPredicate = actualGafferPopHasContainer.getGafferPredicate();
    assertTrue(gafferPredicate instanceof IsEqual);
    assertEquals("Value", ((IsEqual) gafferPredicate).getControlValue());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }

  /**
   * Test {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}.
   *
   * <ul>
   *   <li>Then GafferPredicate return {@link IsMoreThan}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopHasContainer(HasContainer); then GafferPredicate return IsMoreThan")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasContainer.<init>(HasContainer)"})
  void testNewGafferPopHasContainer_thenGafferPredicateReturnIsMoreThan() {
    // Arrange
    P<?> predicate = P.gt("Value");
    HasContainer original = new HasContainer("Key", predicate);

    // Act
    GafferPopHasContainer actualGafferPopHasContainer = new GafferPopHasContainer(original);

    // Assert
    Predicate gafferPredicate = actualGafferPopHasContainer.getGafferPredicate();
    assertTrue(gafferPredicate instanceof IsMoreThan);
    assertEquals("Value", ((IsMoreThan) gafferPredicate).getControlValue());
    assertFalse(((IsMoreThan) gafferPredicate).getOrEqualTo());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }

  /**
   * Test {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}.
   *
   * <ul>
   *   <li>Then GafferPredicate return {@link Not}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  @DisplayName("Test new GafferPopHasContainer(HasContainer); then GafferPredicate return Not")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasContainer.<init>(HasContainer)"})
  void testNewGafferPopHasContainer_thenGafferPredicateReturnNot() {
    // Arrange
    TextP predicate = TextP.notContaining("42");
    HasContainer original = new HasContainer("Key", predicate);

    // Act
    GafferPopHasContainer actualGafferPopHasContainer = new GafferPopHasContainer(original);

    // Assert
    Predicate gafferPredicate = actualGafferPopHasContainer.getGafferPredicate();
    assertTrue(gafferPredicate instanceof Not);
    Predicate predicate2 = ((Not) gafferPredicate).getPredicate();
    assertTrue(predicate2 instanceof StringContains);
    assertEquals("42", ((StringContains) predicate2).getValue());
    assertFalse(((StringContains) predicate2).getIgnoreCase());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }

  /**
   * Test {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}.
   *
   * <ul>
   *   <li>Then GafferPredicate return {@link Regex}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  @DisplayName("Test new GafferPopHasContainer(HasContainer); then GafferPredicate return Regex")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasContainer.<init>(HasContainer)"})
  void testNewGafferPopHasContainer_thenGafferPredicateReturnRegex() {
    // Arrange
    TextP predicate = TextP.endingWith("42");
    HasContainer original = new HasContainer("Key", predicate);

    // Act
    GafferPopHasContainer actualGafferPopHasContainer = new GafferPopHasContainer(original);

    // Assert
    Predicate gafferPredicate = actualGafferPopHasContainer.getGafferPredicate();
    assertTrue(gafferPredicate instanceof Regex);
    assertEquals(".*42$", ((Regex) gafferPredicate).getControlValue().pattern());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }

  /**
   * Test {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}.
   *
   * <ul>
   *   <li>Then GafferPredicate return {@link StringContains}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  @DisplayName(
      "Test new GafferPopHasContainer(HasContainer); then GafferPredicate return StringContains")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopHasContainer.<init>(HasContainer)"})
  void testNewGafferPopHasContainer_thenGafferPredicateReturnStringContains() {
    // Arrange
    TextP predicate = TextP.containing("42");
    HasContainer original = new HasContainer("Key", predicate);

    // Act
    GafferPopHasContainer actualGafferPopHasContainer = new GafferPopHasContainer(original);

    // Assert
    Predicate gafferPredicate = actualGafferPopHasContainer.getGafferPredicate();
    assertTrue(gafferPredicate instanceof StringContains);
    assertEquals("42", ((StringContains) gafferPredicate).getValue());
    assertFalse(((StringContains) gafferPredicate).getIgnoreCase());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }

  /**
   * Test {@link GafferPopHasContainer#getGafferPredicate()}.
   *
   * <p>Method under test: {@link GafferPopHasContainer#getGafferPredicate()}
   */
  @Test
  @DisplayName("Test getGafferPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Predicate GafferPopHasContainer.getGafferPredicate()"})
  void testGetGafferPredicate() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);

    // Act
    Predicate actualGafferPredicate = gafferPopHasContainer.getGafferPredicate();

    // Assert
    assertSame(gafferPopHasContainer.gafferPredicate, actualGafferPredicate);
  }
}
