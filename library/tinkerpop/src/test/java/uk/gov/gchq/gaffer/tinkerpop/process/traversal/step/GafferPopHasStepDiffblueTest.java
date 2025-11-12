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

import static org.junit.Assert.assertFalse;
import org.apache.tinkerpop.gremlin.groovy.jsr223.dsl.credential.DefaultCredentialTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.step.filter.HasStep;
import org.apache.tinkerpop.gremlin.structure.Element;
import org.junit.Test;

public class GafferPopHasStepDiffblueTest {
  /**
   * Method under test: {@link GafferPopHasStep#GafferPopHasStep(HasStep)}
   */
  @Test
  public void testNewGafferPopHasStep() {
    // Arrange and Act
    GafferPopHasStep<Element> actualGafferPopHasStep = new GafferPopHasStep<>(
        new HasStep<>(new DefaultCredentialTraversal()));

    // Assert
    assertFalse(actualGafferPopHasStep.hasNext());
  }
}
