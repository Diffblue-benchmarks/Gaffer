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

package uk.gov.gchq.gaffer.tinkerpop;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GafferPopPropertyDiffblueTest {
  /**
   * Test {@link GafferPopProperty#isPresent()}.
   * <ul>
   *   <li>Given {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code Label} and {@code Id} and graph is {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopProperty#isPresent()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GafferPopProperty.isPresent()"})
  public void testIsPresent_givenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnTrue() {
    // Arrange
    GafferPopProperty<Object> gafferPopProperty = new GafferPopProperty<>(new GafferPopVertex("Label", "Id", null),
        "Key", "Value");

    // Act and Assert
    assertTrue(gafferPopProperty.isPresent());
  }
}
