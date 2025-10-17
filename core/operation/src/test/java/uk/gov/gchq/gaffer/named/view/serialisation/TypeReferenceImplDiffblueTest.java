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

package uk.gov.gchq.gaffer.named.view.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.view.serialisation.TypeReferenceImpl.IterableNamedView;

class TypeReferenceImplDiffblueTest {
  /**
   * Test IterableNamedView new {@link IterableNamedView} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link IterableNamedView}
   */
  @Test
  @DisplayName("Test IterableNamedView new IterableNamedView (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IterableNamedView.<init>()"})
  void testIterableNamedViewNewIterableNamedView() {
    // Arrange, Act and Assert
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.data.elementdefinition.view.NamedViewDetail>",
        new IterableNamedView().getType().getTypeName());
  }
}
