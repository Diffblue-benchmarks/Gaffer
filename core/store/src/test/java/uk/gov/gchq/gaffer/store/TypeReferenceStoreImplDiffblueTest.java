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

package uk.gov.gchq.gaffer.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl.Operations;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl.StoreTraits;

class TypeReferenceStoreImplDiffblueTest {
  /**
   * Test Operations new {@link Operations} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Operations}
   */
  @Test
  @DisplayName("Test Operations new Operations (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Operations.<init>()"})
  void testOperationsNewOperations() {
    // Arrange, Act and Assert
    assertEquals(
        "java.util.Set<java.lang.Class<? extends uk.gov.gchq.gaffer.operation.Operation>>",
        new Operations().getType().getTypeName());
  }

  /**
   * Test StoreTraits new {@link StoreTraits} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link StoreTraits}
   */
  @Test
  @DisplayName("Test StoreTraits new StoreTraits (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StoreTraits.<init>()"})
  void testStoreTraitsNewStoreTraits() {
    // Arrange, Act and Assert
    assertEquals(
        "java.util.Set<uk.gov.gchq.gaffer.store.StoreTrait>",
        new StoreTraits().getType().getTypeName());
  }
}
