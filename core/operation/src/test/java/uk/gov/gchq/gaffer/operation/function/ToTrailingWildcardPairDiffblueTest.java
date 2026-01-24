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

package uk.gov.gchq.gaffer.operation.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;

class ToTrailingWildcardPairDiffblueTest {
  /**
   * Test {@link ToTrailingWildcardPair#apply(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then First return {@link EntitySeed}.
   * </ul>
   *
   * <p>Method under test: {@link ToTrailingWildcardPair#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String) with 'String'; when 'Input'; then First return EntitySeed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pair ToTrailingWildcardPair.apply(String)"})
  void testApplyWithString_whenInput_thenFirstReturnEntitySeed() {
    // Arrange and Act
    Pair<EntityId, EntityId> actualApplyResult = new ToTrailingWildcardPair().apply("Input");

    // Assert
    EntityId first = actualApplyResult.getFirst();
    assertTrue(first instanceof EntitySeed);
    EntityId second = actualApplyResult.getSecond();
    assertTrue(second instanceof EntitySeed);
    assertEquals("Input", first.getVertex());
    assertEquals("Input~", second.getVertex());
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", first.getClassName());
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", second.getClassName());
  }

  /**
   * Test {@link ToTrailingWildcardPair#apply(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToTrailingWildcardPair#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String) with 'String'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pair ToTrailingWildcardPair.apply(String)"})
  void testApplyWithString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ToTrailingWildcardPair().apply(null));
  }

  /**
   * Test {@link ToTrailingWildcardPair#setEndOfRange(String)}.
   *
   * <ul>
   *   <li>Then {@link ToTrailingWildcardPair} (default constructor) EndOfRange is {@code End Of
   *       Range}.
   * </ul>
   *
   * <p>Method under test: {@link ToTrailingWildcardPair#setEndOfRange(String)}
   */
  @Test
  @DisplayName(
      "Test setEndOfRange(String); then ToTrailingWildcardPair (default constructor) EndOfRange is 'End Of Range'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToTrailingWildcardPair.setEndOfRange(String)"})
  void testSetEndOfRange_thenToTrailingWildcardPairEndOfRangeIsEndOfRange() {
    // Arrange
    ToTrailingWildcardPair toTrailingWildcardPair = new ToTrailingWildcardPair();

    // Act
    toTrailingWildcardPair.setEndOfRange("End Of Range");

    // Assert
    assertEquals("End Of Range", toTrailingWildcardPair.getEndOfRange());
  }

  /**
   * Test {@link ToTrailingWildcardPair#setEndOfRange(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ToTrailingWildcardPair} (default constructor) EndOfRange is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ToTrailingWildcardPair#setEndOfRange(String)}
   */
  @Test
  @DisplayName(
      "Test setEndOfRange(String); when 'null'; then ToTrailingWildcardPair (default constructor) EndOfRange is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToTrailingWildcardPair.setEndOfRange(String)"})
  void testSetEndOfRange_whenNull_thenToTrailingWildcardPairEndOfRangeIsEmptyString() {
    // Arrange
    ToTrailingWildcardPair toTrailingWildcardPair = new ToTrailingWildcardPair();

    // Act
    toTrailingWildcardPair.setEndOfRange(null);

    // Assert
    assertEquals("", toTrailingWildcardPair.getEndOfRange());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ToTrailingWildcardPair}
   *   <li>{@link ToTrailingWildcardPair#getEndOfRange()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToTrailingWildcardPair.<init>()",
    "String ToTrailingWildcardPair.getEndOfRange()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("~", new ToTrailingWildcardPair().getEndOfRange());
  }
}
