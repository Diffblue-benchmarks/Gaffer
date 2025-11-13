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

package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OneOrMoreDiffblueTest {
  /**
   * Test {@link OneOrMore#OneOrMore()}.
   * <p>
   * Method under test: {@link OneOrMore#OneOrMore()}
   */
  @Test
  @DisplayName("Test new OneOrMore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OneOrMore.<init>()"})
  void testNewOneOrMore() {
    // Arrange and Act
    OneOrMore<Object> actualOneOrMore = new OneOrMore<>();

    // Assert
    assertEquals(0, actualOneOrMore.size());
    assertTrue(actualOneOrMore.isEmpty());
  }

  /**
   * Test {@link OneOrMore#OneOrMore(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#OneOrMore(boolean)}
   */
  @Test
  @DisplayName("Test new OneOrMore(boolean); when 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OneOrMore.<init>(boolean)"})
  void testNewOneOrMore_whenFalse() {
    // Arrange and Act
    OneOrMore<Object> actualOneOrMore = new OneOrMore<>(false);

    // Assert
    assertEquals(0, actualOneOrMore.size());
    assertTrue(actualOneOrMore.isEmpty());
  }

  /**
   * Test {@link OneOrMore#OneOrMore(boolean, Object)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#OneOrMore(boolean, Object)}
   */
  @Test
  @DisplayName("Test new OneOrMore(boolean, Object); when 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OneOrMore.<init>(boolean, Object)"})
  void testNewOneOrMore_whenFalse2() {
    // Arrange and Act
    OneOrMore<Object> actualOneOrMore = new OneOrMore<>(false, "Item");

    // Assert
    assertEquals(1, actualOneOrMore.size());
    assertFalse(actualOneOrMore.isEmpty());
  }

  /**
   * Test {@link OneOrMore#OneOrMore(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#OneOrMore(boolean)}
   */
  @Test
  @DisplayName("Test new OneOrMore(boolean); when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OneOrMore.<init>(boolean)"})
  void testNewOneOrMore_whenTrue() {
    // Arrange and Act
    OneOrMore<Object> actualOneOrMore = new OneOrMore<>(true);

    // Assert
    assertEquals(0, actualOneOrMore.size());
    assertTrue(actualOneOrMore.isEmpty());
  }

  /**
   * Test {@link OneOrMore#OneOrMore(boolean, Object)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#OneOrMore(boolean, Object)}
   */
  @Test
  @DisplayName("Test new OneOrMore(boolean, Object); when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OneOrMore.<init>(boolean, Object)"})
  void testNewOneOrMore_whenTrue2() {
    // Arrange and Act
    OneOrMore<Object> actualOneOrMore = new OneOrMore<>(true, "Item");

    // Assert
    assertEquals(1, actualOneOrMore.size());
    assertFalse(actualOneOrMore.isEmpty());
  }

  /**
   * Test {@link OneOrMore#add(Object)}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()} add forty-two.</li>
   *   <li>Then {@link OneOrMore#OneOrMore()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); given OneOrMore() add forty-two; then OneOrMore() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.add(Object)"})
  void testAdd_givenOneOrMoreAddFortyTwo_thenOneOrMoreSizeIsTwo() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();
    oneOrMore.add(42);

    // Act
    boolean actualAddResult = oneOrMore.add("Item");

    // Assert
    assertEquals(2, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link OneOrMore#add(Object)}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.</li>
   *   <li>Then {@link OneOrMore#OneOrMore()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); given OneOrMore(); then OneOrMore() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.add(Object)"})
  void testAdd_givenOneOrMore_thenOneOrMoreSizeIsOne() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act
    boolean actualAddResult = oneOrMore.add("Item");

    // Assert
    assertEquals(1, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link OneOrMore#add(Object)}.
   * <ul>
   *   <li>Then {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code false} and {@code Item} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); then OneOrMore(boolean, Object) with deduplicate is 'false' and 'Item' size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.add(Object)"})
  void testAdd_thenOneOrMoreWithDeduplicateIsFalseAndItemSizeIsTwo() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(false, "Item");

    // Act
    boolean actualAddResult = oneOrMore.add("Item");

    // Assert
    assertEquals(2, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link OneOrMore#add(Object)}.
   * <ul>
   *   <li>Then {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and {@code Item} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); then OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item' size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.add(Object)"})
  void testAdd_thenOneOrMoreWithDeduplicateIsTrueAndItemSizeIsOne() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    // Act
    boolean actualAddResult = oneOrMore.add("Item");

    // Assert
    assertEquals(1, oneOrMore.size());
    assertFalse(actualAddResult);
    assertFalse(oneOrMore.isEmpty());
  }

  /**
   * Test {@link OneOrMore#add(Object)}.
   * <ul>
   *   <li>Then {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and {@code Item} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); then OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item' size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.add(Object)"})
  void testAdd_thenOneOrMoreWithDeduplicateIsTrueAndItemSizeIsTwo() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");
    oneOrMore.add(42);

    // Act
    boolean actualAddResult = oneOrMore.add("Item");

    // Assert
    assertEquals(2, oneOrMore.size());
    assertFalse(actualAddResult);
    assertFalse(oneOrMore.isEmpty());
  }

  /**
   * Test {@link OneOrMore#addAll(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link OneOrMore#OneOrMore()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection); given '42'; when ArrayList() add '42'; then OneOrMore() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.addAll(Collection)"})
  void testAddAll_given42_whenArrayListAdd42_thenOneOrMoreSizeIsOne() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = oneOrMore.addAll(items);

    // Assert
    assertEquals(1, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link OneOrMore#addAll(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link OneOrMore#OneOrMore()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection); given '42'; when ArrayList() add '42'; then OneOrMore() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.addAll(Collection)"})
  void testAddAll_given42_whenArrayListAdd42_thenOneOrMoreSizeIsOne2() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");
    items.add("42");

    // Act
    boolean actualAddAllResult = oneOrMore.addAll(items);

    // Assert
    assertEquals(1, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link OneOrMore#addAll(Collection)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then {@link OneOrMore#OneOrMore()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection); given two; when ArrayList() add two; then OneOrMore() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.addAll(Collection)"})
  void testAddAll_givenTwo_whenArrayListAddTwo_thenOneOrMoreSizeIsTwo() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    ArrayList<Object> items = new ArrayList<>();
    items.add(2);
    items.add("42");

    // Act
    boolean actualAddAllResult = oneOrMore.addAll(items);

    // Assert
    assertEquals(2, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link OneOrMore#addAll(Collection)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then {@link OneOrMore#OneOrMore()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection); given two; when ArrayList() add two; then OneOrMore() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.addAll(Collection)"})
  void testAddAll_givenTwo_whenArrayListAddTwo_thenOneOrMoreSizeIsTwo2() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    ArrayList<Object> items = new ArrayList<>();
    items.add(2);
    items.add("42");
    items.add("42");

    // Act
    boolean actualAddAllResult = oneOrMore.addAll(items);

    // Assert
    assertEquals(2, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link OneOrMore#addAll(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link OneOrMore#OneOrMore()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection); when ArrayList(); then OneOrMore() size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.addAll(Collection)"})
  void testAddAll_whenArrayList_thenOneOrMoreSizeIsZero() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act
    boolean actualAddAllResult = oneOrMore.addAll(new ArrayList<>());

    // Assert
    assertEquals(0, oneOrMore.size());
    assertFalse(actualAddAllResult);
    assertTrue(oneOrMore.isEmpty());
  }

  /**
   * Test {@link OneOrMore#size()}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and {@code Item} add forty-two.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#size()}
   */
  @Test
  @DisplayName("Test size(); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item' add forty-two; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int OneOrMore.size()"})
  void testSize_givenOneOrMoreWithDeduplicateIsTrueAndItemAddFortyTwo_thenReturnTwo() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");
    oneOrMore.add(42);

    // Act and Assert
    assertEquals(2, oneOrMore.size());
  }

  /**
   * Test {@link OneOrMore#size()}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and {@code Item}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#size()}
   */
  @Test
  @DisplayName("Test size(); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int OneOrMore.size()"})
  void testSize_givenOneOrMoreWithDeduplicateIsTrueAndItem_thenReturnOne() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    // Act and Assert
    assertEquals(1, oneOrMore.size());
  }

  /**
   * Test {@link OneOrMore#size()}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#size()}
   */
  @Test
  @DisplayName("Test size(); given OneOrMore(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int OneOrMore.size()"})
  void testSize_givenOneOrMore_thenReturnZero() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertEquals(0, oneOrMore.size());
  }

  /**
   * Test {@link OneOrMore#isEmpty()}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and {@code Item} add forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item' add forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.isEmpty()"})
  void testIsEmpty_givenOneOrMoreWithDeduplicateIsTrueAndItemAddFortyTwo() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");
    oneOrMore.add(42);

    // Act and Assert
    assertFalse(oneOrMore.isEmpty());
  }

  /**
   * Test {@link OneOrMore#isEmpty()}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and {@code Item}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.isEmpty()"})
  void testIsEmpty_givenOneOrMoreWithDeduplicateIsTrueAndItem_thenReturnFalse() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    // Act and Assert
    assertFalse(oneOrMore.isEmpty());
  }

  /**
   * Test {@link OneOrMore#isEmpty()}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given OneOrMore(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.isEmpty()"})
  void testIsEmpty_givenOneOrMore_thenReturnTrue() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertTrue(oneOrMore.isEmpty());
  }

  /**
   * Test {@link OneOrMore#contains(Object)}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#contains(Object)}
   */
  @Test
  @DisplayName("Test contains(Object); given OneOrMore() add '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.contains(Object)"})
  void testContains_givenOneOrMoreAdd42_thenReturnTrue() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();
    oneOrMore.add("42");

    // Act and Assert
    assertTrue(oneOrMore.contains("42"));
  }

  /**
   * Test {@link OneOrMore#contains(Object)}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and {@code Item} add forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#contains(Object)}
   */
  @Test
  @DisplayName("Test contains(Object); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item' add forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.contains(Object)"})
  void testContains_givenOneOrMoreWithDeduplicateIsTrueAndItemAddFortyTwo() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");
    oneOrMore.add(42);

    // Act and Assert
    assertFalse(oneOrMore.contains("42"));
  }

  /**
   * Test {@link OneOrMore#contains(Object)}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and {@code Item}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#contains(Object)}
   */
  @Test
  @DisplayName("Test contains(Object); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.contains(Object)"})
  void testContains_givenOneOrMoreWithDeduplicateIsTrueAndItem_thenReturnFalse() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    // Act and Assert
    assertFalse(oneOrMore.contains("42"));
  }

  /**
   * Test {@link OneOrMore#contains(Object)}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#contains(Object)}
   */
  @Test
  @DisplayName("Test contains(Object); given OneOrMore(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.contains(Object)"})
  void testContains_givenOneOrMore_thenReturnFalse() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertFalse(oneOrMore.contains("42"));
  }

  /**
   * Test {@link OneOrMore#iterator()}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given OneOrMore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterator OneOrMore.iterator()"})
  void testIterator_givenOneOrMore() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertFalse(oneOrMore.iterator().hasNext());
  }

  /**
   * Test {@link OneOrMore#iterator()}.
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and {@code Item}.</li>
   *   <li>Then return next is {@code Item}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item'; then return next is 'Item'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterator OneOrMore.iterator()"})
  void testIterator_givenOneOrMoreWithDeduplicateIsTrueAndItem_thenReturnNextIsItem() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    // Act
    Iterator<Object> actualIteratorResult = oneOrMore.iterator();

    // Assert
    assertEquals("Item", actualIteratorResult.next());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link OneOrMore#iterator()}.
   * <ul>
   *   <li>Then return next intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); then return next intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterator OneOrMore.iterator()"})
  void testIterator_thenReturnNextIntValueIsFortyTwo() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");
    oneOrMore.add(42);

    // Act
    Iterator<Object> actualIteratorResult = oneOrMore.iterator();

    // Assert
    assertEquals("Item", actualIteratorResult.next());
    assertEquals(42, ((Integer) actualIteratorResult.next()).intValue());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link OneOrMore#equals(Object)}, and {@link OneOrMore#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OneOrMore#equals(Object)}
   *   <li>{@link OneOrMore#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.equals(Object)", "int OneOrMore.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();
    OneOrMore<Object> oneOrMore2 = new OneOrMore<>();

    // Act and Assert
    assertEquals(oneOrMore, oneOrMore2);
    int expectedHashCodeResult = oneOrMore.hashCode();
    assertEquals(expectedHashCodeResult, oneOrMore2.hashCode());
  }

  /**
   * Test {@link OneOrMore#equals(Object)}, and {@link OneOrMore#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OneOrMore#equals(Object)}
   *   <li>{@link OneOrMore#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.equals(Object)", "int OneOrMore.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertEquals(oneOrMore, oneOrMore);
    int expectedHashCodeResult = oneOrMore.hashCode();
    assertEquals(expectedHashCodeResult, oneOrMore.hashCode());
  }

  /**
   * Test {@link OneOrMore#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.equals(Object)", "int OneOrMore.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();
    oneOrMore.add("Item");

    // Act and Assert
    assertNotEquals(oneOrMore, new OneOrMore<>());
  }

  /**
   * Test {@link OneOrMore#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.equals(Object)", "int OneOrMore.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertNotEquals(oneOrMore, null);
  }

  /**
   * Test {@link OneOrMore#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OneOrMore#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OneOrMore.equals(Object)", "int OneOrMore.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertNotEquals(oneOrMore, "Different type to OneOrMore");
  }

  /**
   * Test {@link OneOrMore#toString()}.
   * <p>
   * Method under test: {@link OneOrMore#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String OneOrMore.toString()"})
  void testToString() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertEquals("OneOrMore[deduplicate=true]", oneOrMore.toString());
  }
}
