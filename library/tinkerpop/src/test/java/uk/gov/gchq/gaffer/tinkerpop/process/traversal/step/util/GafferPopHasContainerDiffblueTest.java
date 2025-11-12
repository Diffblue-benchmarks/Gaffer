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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.function.Predicate;
import org.apache.tinkerpop.gremlin.process.traversal.TextP;
import org.apache.tinkerpop.gremlin.process.traversal.step.util.HasContainer;
import org.apache.tinkerpop.gremlin.structure.Element;
import org.apache.tinkerpop.gremlin.structure.Property;
import org.junit.Test;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopProperty;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopVertex;
import uk.gov.gchq.koryphe.impl.predicate.Not;
import uk.gov.gchq.koryphe.impl.predicate.Regex;
import uk.gov.gchq.koryphe.impl.predicate.StringContains;

public class GafferPopHasContainerDiffblueTest {
  /**
   * Method under test:
   * {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  public void testNewGafferPopHasContainer() {
    // Arrange
    TextP predicate = TextP.containing("42");

    // Act
    GafferPopHasContainer actualGafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Could not translate Gremlin predicate: ", predicate));

    // Assert
    Predicate gafferPredicate = actualGafferPopHasContainer.getGafferPredicate();
    assertTrue(gafferPredicate instanceof StringContains);
    assertEquals("42", ((StringContains) gafferPredicate).getValue());
    assertEquals("42", actualGafferPopHasContainer.getValue());
    assertEquals("Could not translate Gremlin predicate: ", actualGafferPopHasContainer.getKey());
    assertFalse(((StringContains) gafferPredicate).getIgnoreCase());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testId(Element)}
   */
  @Test
  public void testTestId() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.containing("42")));

    // Act and Assert
    assertFalse(gafferPopHasContainer.testId(new GafferPopVertex("Label", "Id", null)));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testId(Element)}
   */
  @Test
  public void testTestId2() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.endingWith("42")));

    // Act and Assert
    assertFalse(gafferPopHasContainer.testId(new GafferPopVertex("Label", "Id", null)));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testId(Element)}
   */
  @Test
  public void testTestId3() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.notContaining("42")));

    // Act and Assert
    assertTrue(gafferPopHasContainer.testId(new GafferPopVertex("Label", "Id", null)));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testId(Element)}
   */
  @Test
  public void testTestId4() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.containing("42")));

    // Act and Assert
    assertFalse(gafferPopHasContainer.testId(new GafferPopVertex("Label", null, null)));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testIdAsString(Element)}
   */
  @Test
  public void testTestIdAsString() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.containing("42")));

    // Act and Assert
    assertFalse(gafferPopHasContainer.testIdAsString(new GafferPopVertex("Label", "Id", null)));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testIdAsString(Element)}
   */
  @Test
  public void testTestIdAsString2() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.endingWith("42")));

    // Act and Assert
    assertFalse(gafferPopHasContainer.testIdAsString(new GafferPopVertex("Label", "Id", null)));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testIdAsString(Element)}
   */
  @Test
  public void testTestIdAsString3() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.notContaining("42")));

    // Act and Assert
    assertTrue(gafferPopHasContainer.testIdAsString(new GafferPopVertex("Label", "Id", null)));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testIdAsString(Element)}
   */
  @Test
  public void testTestIdAsString4() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.endingWith("")));

    // Act and Assert
    assertTrue(gafferPopHasContainer.testIdAsString(new GafferPopVertex("Label", "Id", null)));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testLabel(Element)}
   */
  @Test
  public void testTestLabel() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.containing("42")));

    // Act and Assert
    assertFalse(gafferPopHasContainer.testLabel(new GafferPopVertex("Label", "Id", null)));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testLabel(Element)}
   */
  @Test
  public void testTestLabel2() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.endingWith("42")));

    // Act and Assert
    assertFalse(gafferPopHasContainer.testLabel(new GafferPopVertex("Label", "Id", null)));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testLabel(Element)}
   */
  @Test
  public void testTestLabel3() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.notContaining("42")));

    // Act and Assert
    assertTrue(gafferPopHasContainer.testLabel(new GafferPopVertex("Label", "Id", null)));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testLabel(Element)}
   */
  @Test
  public void testTestLabel4() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.endingWith("")));

    // Act and Assert
    assertTrue(gafferPopHasContainer.testLabel(new GafferPopVertex("Label", "Id", null)));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testValue(Property)}
   */
  @Test
  public void testTestValue() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.containing("42")));

    // Act and Assert
    assertFalse(gafferPopHasContainer
        .testValue(new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null), "Key", "Value")));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testValue(Property)}
   */
  @Test
  public void testTestValue2() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.endingWith("42")));

    // Act and Assert
    assertFalse(gafferPopHasContainer
        .testValue(new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null), "Key", "Value")));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testValue(Property)}
   */
  @Test
  public void testTestValue3() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.notContaining("42")));

    // Act and Assert
    assertTrue(gafferPopHasContainer
        .testValue(new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null), "Key", "Value")));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testValue(Property)}
   */
  @Test
  public void testTestValue4() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.containing("42")));

    // Act and Assert
    assertFalse(gafferPopHasContainer
        .testValue(new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null), "Key", null)));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testKey(Property)}
   */
  @Test
  public void testTestKey() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.containing("42")));

    // Act and Assert
    assertFalse(gafferPopHasContainer
        .testKey(new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null), "Key", "Value")));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testKey(Property)}
   */
  @Test
  public void testTestKey2() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.endingWith("42")));

    // Act and Assert
    assertFalse(gafferPopHasContainer
        .testKey(new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null), "Key", "Value")));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testKey(Property)}
   */
  @Test
  public void testTestKey3() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.notContaining("42")));

    // Act and Assert
    assertTrue(gafferPopHasContainer
        .testKey(new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null), "Key", "Value")));
  }

  /**
   * Method under test: {@link GafferPopHasContainer#testKey(Property)}
   */
  @Test
  public void testTestKey4() {
    // Arrange
    GafferPopHasContainer gafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Key", TextP.endingWith("")));

    // Act and Assert
    assertTrue(gafferPopHasContainer
        .testKey(new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null), "Key", "Value")));
  }

  /**
   * Method under test:
   * {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  public void testNewGafferPopHasContainer2() {
    // Arrange
    TextP predicate = TextP.endingWith("42");

    // Act
    GafferPopHasContainer actualGafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Could not translate Gremlin predicate: ", predicate));

    // Assert
    Predicate gafferPredicate = actualGafferPopHasContainer.getGafferPredicate();
    assertTrue(gafferPredicate instanceof Regex);
    assertEquals(".*42$", ((Regex) gafferPredicate).getControlValue().pattern());
    assertEquals("42", actualGafferPopHasContainer.getValue());
    assertEquals("Could not translate Gremlin predicate: ", actualGafferPopHasContainer.getKey());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }

  /**
   * Method under test:
   * {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  public void testNewGafferPopHasContainer3() {
    // Arrange
    TextP predicate = TextP.notContaining("42");

    // Act
    GafferPopHasContainer actualGafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Could not translate Gremlin predicate: ", predicate));

    // Assert
    Predicate gafferPredicate = actualGafferPopHasContainer.getGafferPredicate();
    assertTrue(gafferPredicate instanceof Not);
    Predicate predicate2 = ((Not) gafferPredicate).getPredicate();
    assertTrue(predicate2 instanceof StringContains);
    assertEquals("42", ((StringContains) predicate2).getValue());
    assertEquals("42", actualGafferPopHasContainer.getValue());
    assertEquals("Could not translate Gremlin predicate: ", actualGafferPopHasContainer.getKey());
    assertFalse(((StringContains) predicate2).getIgnoreCase());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }
}
