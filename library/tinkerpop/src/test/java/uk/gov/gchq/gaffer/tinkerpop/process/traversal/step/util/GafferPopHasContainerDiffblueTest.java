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
import org.apache.tinkerpop.gremlin.structure.Element;
import org.apache.tinkerpop.gremlin.structure.Property;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopProperty;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopVertex;
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

  /**
   * Test {@link GafferPopHasContainer#testId(Element)}.
   *
   * <p>Method under test: {@link GafferPopHasContainer#testId(Element)}
   */
  @Test
  @DisplayName("Test testId(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testId(Element)"})
  void testTestId() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);
    GafferPopVertex element =
        new GafferPopVertex("Label", "xx[type=xx,  subType=xx,  value=xx]", null);

    // Act
    boolean actualTestIdResult = gafferPopHasContainer.testId(element);

    // Assert
    assertFalse(actualTestIdResult);
  }

  /**
   * Test {@link GafferPopHasContainer#testId(Element)}.
   *
   * <ul>
   *   <li>When {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and {@code Id} and graph is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#testId(Element)}
   */
  @Test
  @DisplayName(
      "Test testId(Element); when GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and 'Id' and graph is 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testId(Element)"})
  void testTestId_whenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnTrue() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);
    GafferPopVertex element = new GafferPopVertex("Label", "Id", null);

    // Act
    boolean actualTestIdResult = gafferPopHasContainer.testId(element);

    // Assert
    assertTrue(actualTestIdResult);
  }

  /**
   * Test {@link GafferPopHasContainer#testId(Element)}.
   *
   * <ul>
   *   <li>When {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and id is one and graph is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#testId(Element)}
   */
  @Test
  @DisplayName(
      "Test testId(Element); when GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and id is one and graph is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testId(Element)"})
  void testTestId_whenGafferPopVertexWithLabelAndIdIsOneAndGraphIsNull_thenReturnFalse() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);

    // Act
    boolean actualTestIdResult =
        gafferPopHasContainer.testId(new GafferPopVertex("Label", 1, null));

    // Assert
    assertFalse(actualTestIdResult);
  }

  /**
   * Test {@link GafferPopHasContainer#testIdAsString(Element)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#testIdAsString(Element)}
   */
  @Test
  @DisplayName("Test testIdAsString(Element); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testIdAsString(Element)"})
  void testTestIdAsString_thenReturnFalse() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);

    // Act
    boolean actualTestIdAsStringResult =
        gafferPopHasContainer.testIdAsString(new GafferPopVertex("Label", 1, null));

    // Assert
    assertFalse(actualTestIdAsStringResult);
  }

  /**
   * Test {@link GafferPopHasContainer#testIdAsString(Element)}.
   *
   * <ul>
   *   <li>When {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and {@code Id} and graph is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#testIdAsString(Element)}
   */
  @Test
  @DisplayName(
      "Test testIdAsString(Element); when GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and 'Id' and graph is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testIdAsString(Element)"})
  void testTestIdAsString_whenGafferPopVertexWithLabelAndIdAndGraphIsNull() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);
    GafferPopVertex element = new GafferPopVertex("Label", "Id", null);

    // Act
    boolean actualTestIdAsStringResult = gafferPopHasContainer.testIdAsString(element);

    // Assert
    assertTrue(actualTestIdAsStringResult);
  }

  /**
   * Test {@link GafferPopHasContainer#testIdAsString(Element)}.
   *
   * <ul>
   *   <li>When {@link HasContainer#HasContainer(String, P)} with {@code Key} and predicate is
   *       between {@code First} and {@code Second}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#testIdAsString(Element)}
   */
  @Test
  @DisplayName(
      "Test testIdAsString(Element); when HasContainer(String, P) with 'Key' and predicate is between 'First' and 'Second'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testIdAsString(Element)"})
  void testTestIdAsString_whenHasContainerWithKeyAndPredicateIsBetweenFirstAndSecond() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);
    P<?> predicate2 = P.between("First", "Second");
    HasContainer original2 = new HasContainer("Key", predicate2);
    GafferPopVertex element =
        new GafferPopVertex("Label", new GafferPopHasContainer(original2), null);

    // Act
    boolean actualTestIdAsStringResult = gafferPopHasContainer.testIdAsString(element);

    // Assert
    assertTrue(actualTestIdAsStringResult);
  }

  /**
   * Test {@link GafferPopHasContainer#testIdAsString(Element)}.
   *
   * <ul>
   *   <li>When {@link HasContainer#HasContainer(String, P)} with {@code Key} and predicate is
   *       between {@code null} and {@code Second}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#testIdAsString(Element)}
   */
  @Test
  @DisplayName(
      "Test testIdAsString(Element); when HasContainer(String, P) with 'Key' and predicate is between 'null' and 'Second'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testIdAsString(Element)"})
  void testTestIdAsString_whenHasContainerWithKeyAndPredicateIsBetweenNullAndSecond() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);
    P<?> predicate2 = P.between(null, "Second");
    HasContainer original2 = new HasContainer("Key", predicate2);
    GafferPopVertex element =
        new GafferPopVertex("Label", new GafferPopHasContainer(original2), null);

    // Act
    boolean actualTestIdAsStringResult = gafferPopHasContainer.testIdAsString(element);

    // Assert
    assertTrue(actualTestIdAsStringResult);
  }

  /**
   * Test {@link GafferPopHasContainer#testLabel(Element)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#testLabel(Element)}
   */
  @Test
  @DisplayName("Test testLabel(Element); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testLabel(Element)"})
  void testTestLabel_thenReturnFalse() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);
    GafferPopVertex element = new GafferPopVertex("gaffer.elements.notreadonly", "Id", null);

    // Act
    boolean actualTestLabelResult = gafferPopHasContainer.testLabel(element);

    // Assert
    assertFalse(actualTestLabelResult);
  }

  /**
   * Test {@link GafferPopHasContainer#testLabel(Element)}.
   *
   * <ul>
   *   <li>When {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and {@code Id} and graph is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#testLabel(Element)}
   */
  @Test
  @DisplayName(
      "Test testLabel(Element); when GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and 'Id' and graph is 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testLabel(Element)"})
  void testTestLabel_whenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnTrue() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);
    GafferPopVertex element = new GafferPopVertex("Label", "Id", null);

    // Act
    boolean actualTestLabelResult = gafferPopHasContainer.testLabel(element);

    // Assert
    assertTrue(actualTestLabelResult);
  }

  /**
   * Test {@link GafferPopHasContainer#testValue(Property)}.
   *
   * <p>Method under test: {@link GafferPopHasContainer#testValue(Property)}
   */
  @Test
  @DisplayName("Test testValue(Property)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testValue(Property)"})
  void testTestValue() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);
    GafferPopVertex element = new GafferPopVertex("Label", "Id", null);
    GafferPopProperty<Object> property = new GafferPopProperty<>(element, "Key", 42);

    // Act
    boolean actualTestValueResult = gafferPopHasContainer.testValue(property);

    // Assert
    assertFalse(actualTestValueResult);
  }

  /**
   * Test {@link GafferPopHasContainer#testValue(Property)}.
   *
   * <p>Method under test: {@link GafferPopHasContainer#testValue(Property)}
   */
  @Test
  @DisplayName("Test testValue(Property)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testValue(Property)"})
  void testTestValue2() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);
    GafferPopVertex element = new GafferPopVertex("Label", "Id", null);
    GafferPopProperty<Object> property =
        new GafferPopProperty<>(element, "Key", "xx[type=xx,  subType=xx,  value=xx]");

    // Act
    boolean actualTestValueResult = gafferPopHasContainer.testValue(property);

    // Assert
    assertFalse(actualTestValueResult);
  }

  /**
   * Test {@link GafferPopHasContainer#testValue(Property)}.
   *
   * <ul>
   *   <li>When {@link GafferPopProperty#GafferPopProperty(Element, String, Object)} with element is
   *       {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} and {@code Key}
   *       and {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#testValue(Property)}
   */
  @Test
  @DisplayName(
      "Test testValue(Property); when GafferPopProperty(Element, String, Object) with element is GafferPopVertex(String, Object, GafferPopGraph) and 'Key' and 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testValue(Property)"})
  void testTestValue_whenGafferPopPropertyWithElementIsGafferPopVertexAndKeyAndValue() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);
    GafferPopVertex element = new GafferPopVertex("Label", "Id", null);
    GafferPopProperty<Object> property = new GafferPopProperty<>(element, "Key", "Value");

    // Act
    boolean actualTestValueResult = gafferPopHasContainer.testValue(property);

    // Assert
    assertFalse(actualTestValueResult);
  }

  /**
   * Test {@link GafferPopHasContainer#testKey(Property)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#testKey(Property)}
   */
  @Test
  @DisplayName("Test testKey(Property); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testKey(Property)"})
  void testTestKey_thenReturnFalse() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);
    GafferPopVertex element = new GafferPopVertex("Label", "Id", null);
    GafferPopProperty<Object> property = new GafferPopProperty<>(element, "42", "Value");

    // Act
    boolean actualTestKeyResult = gafferPopHasContainer.testKey(property);

    // Assert
    assertFalse(actualTestKeyResult);
  }

  /**
   * Test {@link GafferPopHasContainer#testKey(Property)}.
   *
   * <ul>
   *   <li>When {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and {@code Id} and graph is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopHasContainer#testKey(Property)}
   */
  @Test
  @DisplayName(
      "Test testKey(Property); when GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and 'Id' and graph is 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopHasContainer.testKey(Property)"})
  void testTestKey_whenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnTrue() {
    // Arrange
    P<?> predicate = P.between("First", "Second");
    HasContainer original = new HasContainer("Key", predicate);
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(original);
    GafferPopVertex element = new GafferPopVertex("Label", "Id", null);
    GafferPopProperty<Object> property = new GafferPopProperty<>(element, "Key", "Value");

    // Act
    boolean actualTestKeyResult = gafferPopHasContainer.testKey(property);

    // Assert
    assertTrue(actualTestKeyResult);
  }
}
