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

package uk.gov.gchq.gaffer.named.operation;

import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.add.AddElementsFromKafka;

class ParameterDetailDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ParameterDetail.Builder}
   *   <li>{@link ParameterDetail.Builder#defaultValue(Object)}
   *   <li>{@link ParameterDetail.Builder#description(String)}
   *   <li>{@link ParameterDetail.Builder#options(List)}
   *   <li>{@link ParameterDetail.Builder#required(boolean)}
   *   <li>{@link ParameterDetail.Builder#valueClass(Class)}
   * </ul>
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ParameterDetail.Builder actualDescriptionResult = (new ParameterDetail.Builder()).defaultValue("Default Value")
        .description("The characteristics of someone or something");
    ParameterDetail.Builder actualRequiredResult = actualDescriptionResult.options(new ArrayList<>()).required(true);

    // Assert
    assertSame(actualRequiredResult, actualRequiredResult.valueClass(AddElementsFromKafka.DEFAULT_CONSUME_AS));
  }
}
