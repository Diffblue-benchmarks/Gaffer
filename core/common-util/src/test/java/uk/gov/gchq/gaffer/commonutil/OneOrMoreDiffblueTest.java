package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Method under test: {@link OneOrMore#OneOrMore()}
   */
  @Test
  @DisplayName("Test new OneOrMore()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#OneOrMore(boolean)}
   */
  @Test
  @DisplayName("Test new OneOrMore(boolean); when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#OneOrMore(boolean, Object)}
   */
  @Test
  @DisplayName("Test new OneOrMore(boolean, Object); when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#OneOrMore(boolean)}
   */
  @Test
  @DisplayName("Test new OneOrMore(boolean); when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#OneOrMore(boolean, Object)}
   */
  @Test
  @DisplayName("Test new OneOrMore(boolean, Object); when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.
   *   <li>Then {@link OneOrMore#OneOrMore()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object); given OneOrMore(); then OneOrMore() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code false} and
   *       {@code Item} size is three.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); then OneOrMore(boolean, Object) with deduplicate is 'false' and 'Item' size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.add(Object)"})
  void testAdd_thenOneOrMoreWithDeduplicateIsFalseAndItemSizeIsThree() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(false, "Item");
    oneOrMore.add("Item");

    // Act
    boolean actualAddResult = oneOrMore.add("Item");

    // Assert
    assertEquals(3, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link OneOrMore#add(Object)}.
   *
   * <ul>
   *   <li>Then {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code false} and
   *       {@code Item} size is two.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); then OneOrMore(boolean, Object) with deduplicate is 'false' and 'Item' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and
   *       item is forty-two size is two.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); then OneOrMore(boolean, Object) with deduplicate is 'true' and item is forty-two size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.add(Object)"})
  void testAdd_thenOneOrMoreWithDeduplicateIsTrueAndItemIsFortyTwoSizeIsTwo() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, 42);

    // Act
    boolean actualAddResult = oneOrMore.add("Item");

    // Assert
    assertEquals(2, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link OneOrMore#add(Object)}.
   *
   * <ul>
   *   <li>Then {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and
   *       {@code Item} size is one.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object); then OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link OneOrMore#addAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then {@link OneOrMore#OneOrMore()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection); given OneOrMore(); when ArrayList() add '42'; then OneOrMore() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.addAll(Collection)"})
  void testAddAll_givenOneOrMore_whenArrayListAdd42_thenOneOrMoreSizeIsOne() {
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
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then {@link OneOrMore#OneOrMore()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection); given OneOrMore(); when ArrayList() add '42'; then OneOrMore() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.addAll(Collection)"})
  void testAddAll_givenOneOrMore_whenArrayListAdd42_thenOneOrMoreSizeIsOne2() {
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
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link OneOrMore#OneOrMore()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection); given OneOrMore(); when ArrayList(); then OneOrMore() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.addAll(Collection)"})
  void testAddAll_givenOneOrMore_whenArrayList_thenOneOrMoreSizeIsZero() {
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
   * Test {@link OneOrMore#addAll(Collection)}.
   *
   * <ul>
   *   <li>Then {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code false} and
   *       {@code Item} size is two.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection); then OneOrMore(boolean, Object) with deduplicate is 'false' and 'Item' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.addAll(Collection)"})
  void testAddAll_thenOneOrMoreWithDeduplicateIsFalseAndItemSizeIsTwo() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(false, "Item");

    ArrayList<Object> items = new ArrayList<>();
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
   *
   * <ul>
   *   <li>Then {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and
   *       {@code Item} size is two.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection); then OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.addAll(Collection)"})
  void testAddAll_thenOneOrMoreWithDeduplicateIsTrueAndItemSizeIsTwo() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    ArrayList<Object> items = new ArrayList<>();
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
   *
   * <ul>
   *   <li>Then {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and
   *       {@code Item} size is two.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection); then OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.addAll(Collection)"})
  void testAddAll_thenOneOrMoreWithDeduplicateIsTrueAndItemSizeIsTwo2() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    ArrayList<Object> items = new ArrayList<>();
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
   * Test {@link OneOrMore#size()}.
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and
   *       {@code Item} add forty-two.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#size()}
   */
  @Test
  @DisplayName(
      "Test size(); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item' add forty-two; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and
   *       {@code Item}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#size()}
   */
  @Test
  @DisplayName(
      "Test size(); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int OneOrMore.size()"})
  void testSize_givenOneOrMoreWithDeduplicateIsTrueAndItem_thenReturnOne() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    // Act and Assert
    assertEquals(1, oneOrMore.size());
  }

  /**
   * Test {@link OneOrMore#size()}.
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#size()}
   */
  @Test
  @DisplayName("Test size(); given OneOrMore(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int OneOrMore.size()"})
  void testSize_givenOneOrMore_thenReturnZero() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertEquals(0, oneOrMore.size());
  }

  /**
   * Test {@link OneOrMore#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and
   *       {@code Item} add forty-two.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#isEmpty()}
   */
  @Test
  @DisplayName(
      "Test isEmpty(); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item' add forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and
   *       {@code Item}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#isEmpty()}
   */
  @Test
  @DisplayName(
      "Test isEmpty(); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.isEmpty()"})
  void testIsEmpty_givenOneOrMoreWithDeduplicateIsTrueAndItem_thenReturnFalse() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    // Act and Assert
    assertFalse(oneOrMore.isEmpty());
  }

  /**
   * Test {@link OneOrMore#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given OneOrMore(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.isEmpty()"})
  void testIsEmpty_givenOneOrMore_thenReturnTrue() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertTrue(oneOrMore.isEmpty());
  }

  /**
   * Test {@link OneOrMore#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and
   *       item is {@code 42} add {@code Item}.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#contains(Object)}
   */
  @Test
  @DisplayName(
      "Test contains(Object); given OneOrMore(boolean, Object) with deduplicate is 'true' and item is '42' add 'Item'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.contains(Object)"})
  void testContains_givenOneOrMoreWithDeduplicateIsTrueAndItemIs42AddItem() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "42");
    oneOrMore.add("Item");

    // Act and Assert
    assertTrue(oneOrMore.contains("42"));
  }

  /**
   * Test {@link OneOrMore#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and
   *       item is {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#contains(Object)}
   */
  @Test
  @DisplayName(
      "Test contains(Object); given OneOrMore(boolean, Object) with deduplicate is 'true' and item is '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.contains(Object)"})
  void testContains_givenOneOrMoreWithDeduplicateIsTrueAndItemIs42_thenReturnTrue() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "42");

    // Act and Assert
    assertTrue(oneOrMore.contains("42"));
  }

  /**
   * Test {@link OneOrMore#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and
   *       {@code Item}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#contains(Object)}
   */
  @Test
  @DisplayName(
      "Test contains(Object); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.contains(Object)"})
  void testContains_givenOneOrMoreWithDeduplicateIsTrueAndItem_thenReturnFalse() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    // Act and Assert
    assertFalse(oneOrMore.contains("42"));
  }

  /**
   * Test {@link OneOrMore#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#contains(Object)}
   */
  @Test
  @DisplayName("Test contains(Object); given OneOrMore(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.contains(Object)"})
  void testContains_givenOneOrMore_thenReturnFalse() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertFalse(oneOrMore.contains("42"));
  }

  /**
   * Test {@link OneOrMore#iterator()}.
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore()}.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given OneOrMore()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator OneOrMore.iterator()"})
  void testIterator_givenOneOrMore() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertFalse(oneOrMore.iterator().hasNext());
  }

  /**
   * Test {@link OneOrMore#iterator()}.
   *
   * <ul>
   *   <li>Given {@link OneOrMore#OneOrMore(boolean, Object)} with deduplicate is {@code true} and
   *       {@code Item}.
   *   <li>Then return next is {@code Item}.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#iterator()}
   */
  @Test
  @DisplayName(
      "Test iterator(); given OneOrMore(boolean, Object) with deduplicate is 'true' and 'Item'; then return next is 'Item'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return next intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); then return next intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OneOrMore#equals(Object)}
   *   <li>{@link OneOrMore#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.equals(Object)", "int OneOrMore.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();
    OneOrMore<Object> oneOrMore2 = new OneOrMore<>();

    // Act and Assert
    assertEquals(oneOrMore, oneOrMore2);
    assertEquals(oneOrMore.hashCode(), oneOrMore2.hashCode());
  }

  /**
   * Test {@link OneOrMore#equals(Object)}, and {@link OneOrMore#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OneOrMore#equals(Object)}
   *   <li>{@link OneOrMore#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.equals(Object)", "int OneOrMore.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();
    oneOrMore.add(new OneOrMore<>());

    OneOrMore<Object> oneOrMore2 = new OneOrMore<>();
    oneOrMore2.add("Item");

    // Act and Assert
    assertNotEquals(oneOrMore, oneOrMore2);
  }

  /**
   * Test {@link OneOrMore#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.equals(Object)", "int OneOrMore.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertNotEquals(oneOrMore, null);
  }

  /**
   * Test {@link OneOrMore#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OneOrMore#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OneOrMore.equals(Object)", "int OneOrMore.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertNotEquals(oneOrMore, "Different type to OneOrMore");
  }

  /**
   * Test {@link OneOrMore#toString()}.
   *
   * <p>Method under test: {@link OneOrMore#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String OneOrMore.toString()"})
  void testToString() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertEquals("OneOrMore[deduplicate=true]", oneOrMore.toString());
  }
}
