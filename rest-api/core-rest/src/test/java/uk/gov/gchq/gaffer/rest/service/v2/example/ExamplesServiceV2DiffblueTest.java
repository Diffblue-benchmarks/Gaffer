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

package uk.gov.gchq.gaffer.rest.service.v2.example;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.rest.factory.ExamplesFactory;

@ExtendWith(MockitoExtension.class)
class ExamplesServiceV2DiffblueTest {
  @Mock private ExamplesFactory examplesFactory;

  @InjectMocks private ExamplesServiceV2 examplesServiceV2;

  /**
   * Test {@link ExamplesServiceV2#execute()}.
   *
   * <ul>
   *   <li>Then throw {@link InstantiationException}.
   * </ul>
   *
   * <p>Method under test: {@link ExamplesServiceV2#execute()}
   */
  @Test
  @DisplayName("Test execute(); then throw InstantiationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation ExamplesServiceV2.execute()"})
  void testExecute_thenThrowInstantiationException()
      throws IllegalAccessException, InstantiationException {
    // Arrange
    when(examplesFactory.generateExample(Mockito.<Class<Operation>>any()))
        .thenThrow(new InstantiationException());

    // Act and Assert
    assertThrows(InstantiationException.class, () -> examplesServiceV2.execute());
    verify(examplesFactory).generateExample(isA(Class.class));
  }

  /**
   * Test {@link ExamplesServiceV2#executeChunked()}.
   *
   * <ul>
   *   <li>Then throw {@link InstantiationException}.
   * </ul>
   *
   * <p>Method under test: {@link ExamplesServiceV2#executeChunked()}
   */
  @Test
  @DisplayName("Test executeChunked(); then throw InstantiationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation ExamplesServiceV2.executeChunked()"})
  void testExecuteChunked_thenThrowInstantiationException()
      throws IllegalAccessException, InstantiationException {
    // Arrange
    when(examplesFactory.generateExample(Mockito.<Class<Operation>>any()))
        .thenThrow(new InstantiationException());

    // Act and Assert
    assertThrows(InstantiationException.class, () -> examplesServiceV2.executeChunked());
    verify(examplesFactory).generateExample(isA(Class.class));
  }
}
