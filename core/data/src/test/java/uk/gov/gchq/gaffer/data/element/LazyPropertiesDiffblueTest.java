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

package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LazyPropertiesDiffblueTest {
  /**
   * Test {@link LazyProperties#LazyProperties(Properties, ElementValueLoader)}.
   *
   * <p>Method under test: {@link LazyProperties#LazyProperties(Properties, ElementValueLoader)}
   */
  @Test
  @DisplayName("Test new LazyProperties(Properties, ElementValueLoader)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyProperties.<init>(Properties, ElementValueLoader)"})
  void testNewLazyProperties() {
    // Arrange and Act
    LazyProperties actualLazyProperties =
        new LazyProperties(new Properties(), mock(ElementValueLoader.class));

    // Assert
    assertTrue(actualLazyProperties.isEmpty());
  }

  /**
   * Test {@link LazyProperties#getProperties()}.
   *
   * <p>Method under test: {@link LazyProperties#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Properties LazyProperties.getProperties()"})
  void testGetProperties() {
    // Arrange
    Properties properties = new Properties();
    LazyProperties lazyProperties = new LazyProperties(properties, mock(ElementValueLoader.class));

    // Act and Assert
    assertSame(properties, lazyProperties.getProperties());
  }

  /**
   * Test {@link LazyProperties#put(String, Object)} with {@code String}, {@code Object}.
   *
   * <p>Method under test: {@link LazyProperties#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyProperties.put(String, Object)"})
  void testPutWithStringObject() {
    // Arrange
    LazyProperties lazyProperties =
        new LazyProperties(new Properties(), mock(ElementValueLoader.class));

    // Act
    lazyProperties.put("Name", "Property");

    // Assert
    assertEquals(1, lazyProperties.size());
    assertEquals("Property", lazyProperties.get((Object) "Name"));
  }

  /**
   * Test {@link LazyProperties#put(String, Object)} with {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LazyProperties#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; when 'Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyProperties.put(String, Object)"})
  void testPutWithStringObject_whenName_thenReturnNull() {
    // Arrange
    LazyProperties lazyProperties =
        new LazyProperties(new Properties(), mock(ElementValueLoader.class));

    // Act and Assert
    assertNull(lazyProperties.put("Name", null));
    assertTrue(lazyProperties.isEmpty());
  }

  /**
   * Test {@link LazyProperties#put(String, Object)} with {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LazyProperties#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyProperties.put(String, Object)"})
  void testPutWithStringObject_whenNull_thenReturnNull() {
    // Arrange
    LazyProperties lazyProperties =
        new LazyProperties(new Properties(), mock(ElementValueLoader.class));

    // Act and Assert
    assertNull(lazyProperties.put(null, null));
    assertTrue(lazyProperties.isEmpty());
  }

  /**
   * Test {@link LazyProperties#containsKey(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LazyProperties#containsKey(Object)}
   */
  @Test
  @DisplayName("Test containsKey(Object); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LazyProperties.containsKey(Object)"})
  void testContainsKey_thenReturnFalse() {
    // Arrange
    LazyProperties lazyProperties =
        new LazyProperties(new Properties(), mock(ElementValueLoader.class));

    // Act and Assert
    assertFalse(lazyProperties.containsKey("Key"));
  }

  /**
   * Test {@link LazyProperties#containsKey(Object)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LazyProperties#containsKey(Object)}
   */
  @Test
  @DisplayName("Test containsKey(Object); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LazyProperties.containsKey(Object)"})
  void testContainsKey_thenReturnTrue() {
    // Arrange
    LazyProperties lazyProperties =
        new LazyProperties(new Properties(), mock(ElementValueLoader.class));
    lazyProperties.put("uk.gov.gchq.gaffer.data.element.LazyProperties", "Property");

    // Act and Assert
    assertTrue(lazyProperties.containsKey("uk.gov.gchq.gaffer.data.element.LazyProperties"));
  }
}
