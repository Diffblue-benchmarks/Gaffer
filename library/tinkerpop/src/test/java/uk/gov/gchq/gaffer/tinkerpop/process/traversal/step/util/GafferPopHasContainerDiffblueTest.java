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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.apache.tinkerpop.gremlin.process.traversal.TextP;
import org.apache.tinkerpop.gremlin.process.traversal.step.util.HasContainer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import uk.gov.gchq.koryphe.impl.predicate.Not;
import uk.gov.gchq.koryphe.impl.predicate.Regex;
import uk.gov.gchq.koryphe.impl.predicate.StringContains;

public class GafferPopHasContainerDiffblueTest {
  /**
   * Test {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}.
   * <ul>
   *   <li>Then GafferPredicate return {@link Not}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopHasContainer.<init>(HasContainer)"})
  public void testNewGafferPopHasContainer_thenGafferPredicateReturnNot() {
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
    assertFalse(((StringContains) predicate2).getIgnoreCase());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }

  /**
   * Test {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}.
   * <ul>
   *   <li>Then GafferPredicate return {@link Regex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopHasContainer.<init>(HasContainer)"})
  public void testNewGafferPopHasContainer_thenGafferPredicateReturnRegex() {
    // Arrange
    TextP predicate = TextP.endingWith("42");

    // Act
    GafferPopHasContainer actualGafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Could not translate Gremlin predicate: ", predicate));

    // Assert
    Predicate gafferPredicate = actualGafferPopHasContainer.getGafferPredicate();
    assertTrue(gafferPredicate instanceof Regex);
    assertEquals(".*42$", ((Regex) gafferPredicate).getControlValue().pattern());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }

  /**
   * Test {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}.
   * <ul>
   *   <li>Then GafferPredicate return {@link StringContains}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopHasContainer#GafferPopHasContainer(HasContainer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopHasContainer.<init>(HasContainer)"})
  public void testNewGafferPopHasContainer_thenGafferPredicateReturnStringContains() {
    // Arrange
    TextP predicate = TextP.containing("42");

    // Act
    GafferPopHasContainer actualGafferPopHasContainer = new GafferPopHasContainer(
        new HasContainer("Could not translate Gremlin predicate: ", predicate));

    // Assert
    Predicate gafferPredicate = actualGafferPopHasContainer.getGafferPredicate();
    assertTrue(gafferPredicate instanceof StringContains);
    assertEquals("42", ((StringContains) gafferPredicate).getValue());
    assertFalse(((StringContains) gafferPredicate).getIgnoreCase());
    assertSame(predicate, actualGafferPopHasContainer.getPredicate());
  }
}
