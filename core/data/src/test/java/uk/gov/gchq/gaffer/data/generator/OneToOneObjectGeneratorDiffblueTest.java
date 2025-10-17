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

package uk.gov.gchq.gaffer.data.generator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OneToOneObjectGeneratorDiffblueTest {
  /**
   * Test {@link OneToOneObjectGenerator#apply(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link OneToOneObjectGenerator#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable OneToOneObjectGenerator.apply(Iterable)"})
  void testApplyWithIterable() {
    // Arrange
    CsvGenerator csvGenerator = new CsvGenerator();

    // Act and Assert
    assertFalse(csvGenerator.apply(new ArrayList<>()).iterator().hasNext());
  }
}
