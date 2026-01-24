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

package uk.gov.gchq.gaffer.store.library;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NoGraphLibraryDiffblueTest {
  /**
   * Test new {@link NoGraphLibrary} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link NoGraphLibrary}
   */
  @Test
  @DisplayName("Test new NoGraphLibrary (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NoGraphLibrary.<init>()"})
  void testNewNoGraphLibrary() {
    // Arrange and Act
    NoGraphLibrary actualNoGraphLibrary = new NoGraphLibrary();

    // Assert
    assertNull(actualNoGraphLibrary._getSchema("42"));
    assertNull(actualNoGraphLibrary.get("42"));
    assertNull(actualNoGraphLibrary._getProperties("42"));
    assertFalse(actualNoGraphLibrary.exists("42"));
  }

  /**
   * Test {@link NoGraphLibrary#getIds(String)}.
   *
   * <p>Method under test: {@link NoGraphLibrary#getIds(String)}
   */
  @Test
  @DisplayName("Test getIds(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"uk.gov.gchq.gaffer.commonutil.pair.Pair NoGraphLibrary.getIds(String)"})
  void testGetIds() {
    // Arrange, Act and Assert
    assertNull(new NoGraphLibrary().getIds("42"));
  }

  /**
   * Test {@link NoGraphLibrary#_getSchema(String)}.
   *
   * <p>Method under test: {@link NoGraphLibrary#_getSchema(String)}
   */
  @Test
  @DisplayName("Test _getSchema(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] NoGraphLibrary._getSchema(String)"})
  void test_getSchema() {
    // Arrange, Act and Assert
    assertNull(new NoGraphLibrary()._getSchema("42"));
  }

  /**
   * Test {@link NoGraphLibrary#_getProperties(String)}.
   *
   * <p>Method under test: {@link NoGraphLibrary#_getProperties(String)}
   */
  @Test
  @DisplayName("Test _getProperties(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.StoreProperties NoGraphLibrary._getProperties(String)"
  })
  void test_getProperties() {
    // Arrange, Act and Assert
    assertNull(new NoGraphLibrary()._getProperties("42"));
  }
}
