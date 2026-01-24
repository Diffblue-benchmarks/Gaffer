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

package uk.gov.gchq.gaffer.flink.operation.handler;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;

class GafferOutputDiffblueTest {
  /**
   * Test {@link GafferOutput#writeRecord(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link GafferAdder} {@link GafferAdder#add(Element)} does nothing.
   *   <li>Then calls {@link GafferAdder#add(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link GafferOutput#writeRecord(Element)}
   */
  @Test
  @DisplayName(
      "Test writeRecord(Element) with 'Element'; given GafferAdder add(Element) does nothing; then calls add(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferOutput.writeRecord(Element)"})
  void testWriteRecordWithElement_givenGafferAdderAddDoesNothing_thenCallsAdd() {
    // Arrange
    GafferAdder adder = mock(GafferAdder.class);
    doNothing().when(adder).add(Mockito.<Element>any());
    GafferOutput gafferOutput = new GafferOutput(adder);

    // Act
    gafferOutput.writeRecord(new Edge("Group"));

    // Assert
    verify(adder).add(isA(Element.class));
  }
}
