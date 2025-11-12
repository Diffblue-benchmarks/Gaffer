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

package uk.gov.gchq.gaffer.data.elementdefinition.view;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ViewParameterDetailDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ViewParameterDetail.Builder}
   *   <li>{@link ViewParameterDetail.Builder#defaultValue(Object)}
   *   <li>{@link ViewParameterDetail.Builder#description(String)}
   *   <li>{@link ViewParameterDetail.Builder#required(boolean)}
   *   <li>{@link ViewParameterDetail.Builder#valueClass(Class)}
   * </ul>
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    ViewParameterDetail.Builder actualRequiredResult = (new ViewParameterDetail.Builder()).defaultValue("Default Value")
        .description("The characteristics of someone or something")
        .required(true);
    Class<Object> clazz = Object.class;

    // Assert
    assertSame(actualRequiredResult, actualRequiredResult.valueClass(clazz));
  }
}
