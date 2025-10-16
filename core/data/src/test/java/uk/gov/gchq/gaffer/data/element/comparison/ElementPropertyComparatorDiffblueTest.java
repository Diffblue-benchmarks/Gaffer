package uk.gov.gchq.gaffer.data.element.comparison;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.comparison.ElementPropertyComparator.Builder;

class ElementPropertyComparatorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementPropertyComparator Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    Comparator comparator = mock(Comparator.class);

    // Act
    ElementPropertyComparator actualElementPropertyComparator =
        new Builder()
            .comparator(comparator)
            .groups("Group")
            .property("Property")
            .reverse(true)
            .build();

    // Assert
    assertEquals("Property", actualElementPropertyComparator.getProperty());
    Set<String> groups = actualElementPropertyComparator.getGroups();
    assertEquals(1, groups.size());
    assertTrue(groups.contains("Group"));
    assertTrue(actualElementPropertyComparator.getComparableGroupPropertyPairs().isEmpty());
    assertTrue(actualElementPropertyComparator.isReversed());
    assertSame(comparator, actualElementPropertyComparator.getComparator());
  }

  /**
   * Test Builder {@link Builder#comparator(Comparator)}.
   *
   * <p>Method under test: {@link Builder#comparator(Comparator)}
   */
  @Test
  @DisplayName("Test Builder comparator(Comparator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.comparator(Comparator)"})
  void testBuilderComparator() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualComparatorResult = builder.comparator(mock(Comparator.class));

    // Assert
    assertSame(builder, actualComparatorResult);
  }

  /**
   * Test Builder {@link Builder#groups(String[])}.
   *
   * <ul>
   *   <li>When {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#groups(String[])}
   */
  @Test
  @DisplayName("Test Builder groups(String[]); when 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.groups(String[])"})
  void testBuilderGroups_whenGroup() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGroupsResult = builder.groups("Group");

    // Assert
    assertSame(builder, actualGroupsResult);
  }

  /**
   * Test Builder {@link Builder#groups(String[])}.
   *
   * <ul>
   *   <li>When {@code Group} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#groups(String[])}
   */
  @Test
  @DisplayName("Test Builder groups(String[]); when 'Group' and '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.groups(String[])"})
  void testBuilderGroups_whenGroupAnd42() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGroupsResult = builder.groups("Group", "42", "Group");

    // Assert
    assertSame(builder, actualGroupsResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    ElementPropertyComparator elementPropertyComparator = new Builder().build();
    assertNull(elementPropertyComparator.getProperty());
    assertNull(elementPropertyComparator.getComparator());
    assertFalse(elementPropertyComparator.isReversed());
    assertTrue(elementPropertyComparator.getComparableGroupPropertyPairs().isEmpty());
    assertTrue(elementPropertyComparator.getGroups().isEmpty());
  }

  /**
   * Test Builder {@link Builder#property(String)}.
   *
   * <p>Method under test: {@link Builder#property(String)}
   */
  @Test
  @DisplayName("Test Builder property(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.property(String)"})
  void testBuilderProperty() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertyResult = builder.property("Property");

    // Assert
    assertSame(builder, actualPropertyResult);
  }

  /**
   * Test Builder {@link Builder#reverse(boolean)}.
   *
   * <p>Method under test: {@link Builder#reverse(boolean)}
   */
  @Test
  @DisplayName("Test Builder reverse(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.reverse(boolean)"})
  void testBuilderReverse() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualReverseResult = builder.reverse(true);

    // Assert
    assertSame(builder, actualReverseResult);
  }

  /**
   * Test {@link ElementPropertyComparator#compare(Element, Element)} with {@code Element}, {@code
   * Element}.
   *
   * <ul>
   *   <li>Given {@link ElementPropertyComparator} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#compare(Element, Element)}
   */
  @Test
  @DisplayName(
      "Test compare(Element, Element) with 'Element', 'Element'; given ElementPropertyComparator (default constructor); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ElementPropertyComparator.compare(Element, Element)"})
  void testCompareWithElementElement_givenElementPropertyComparator_thenReturnZero() {
    // Arrange
    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    Edge e1 = new Edge("Group");

    // Act and Assert
    assertEquals(0, elementPropertyComparator.compare(e1, new Edge("Group")));
  }

  /**
   * Test {@link ElementPropertyComparator#compare(Element, Element)} with {@code Element}, {@code
   * Element}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#compare(Element, Element)}
   */
  @Test
  @DisplayName("Test compare(Element, Element) with 'Element', 'Element'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ElementPropertyComparator.compare(Element, Element)"})
  void testCompareWithElementElement_thenReturnMinusOne() {
    // Arrange
    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setGroups(new HashSet<>());
    elementPropertyComparator.setComparator(null);
    elementPropertyComparator.setReversed(false);

    // Act and Assert
    assertEquals(-1, elementPropertyComparator.compare(new Edge("Group"), null));
  }

  /**
   * Test {@link ElementPropertyComparator#compare(Element, Element)} with {@code Element}, {@code
   * Element}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#compare(Element, Element)}
   */
  @Test
  @DisplayName("Test compare(Element, Element) with 'Element', 'Element'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ElementPropertyComparator.compare(Element, Element)"})
  void testCompareWithElementElement_thenReturnOne() {
    // Arrange
    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setGroups(new HashSet<>());
    elementPropertyComparator.setComparator(null);
    elementPropertyComparator.setReversed(false);

    // Act and Assert
    assertEquals(1, elementPropertyComparator.compare(null, new Edge("Group")));
  }

  /**
   * Test {@link ElementPropertyComparator#compare(Element, Element)} with {@code Element}, {@code
   * Element}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#compare(Element, Element)}
   */
  @Test
  @DisplayName("Test compare(Element, Element) with 'Element', 'Element'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ElementPropertyComparator.compare(Element, Element)"})
  void testCompareWithElementElement_thenReturnZero() {
    // Arrange
    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setGroups(new HashSet<>());
    elementPropertyComparator.setComparator(null);
    elementPropertyComparator.setReversed(false);

    // Act and Assert
    assertEquals(0, elementPropertyComparator.compare(null, null));
  }

  /**
   * Test {@link ElementPropertyComparator#_compare(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return one.
   *   <li>When {@code Val1}.
   *   <li>Then calls {@link Comparator#compare(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#_compare(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test _compare(Object, Object); given Comparator compare(Object, Object) return one; when 'Val1'; then calls compare(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ElementPropertyComparator._compare(Object, Object)"})
  void test_compare_givenComparatorCompareReturnOne_whenVal1_thenCallsCompare() {
    // Arrange
    Comparator comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setComparator(comparator);
    elementPropertyComparator.setReversed(false);

    // Act
    int actual_compareResult = elementPropertyComparator._compare("Val1", "Val2");

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, actual_compareResult);
  }

  /**
   * Test {@link ElementPropertyComparator#_compare(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link Comparator} {@link Comparator#compare(Object, Object)} return one.
   *   <li>When {@code Val1}.
   *   <li>Then calls {@link Comparator#compare(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#_compare(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test _compare(Object, Object); given Comparator compare(Object, Object) return one; when 'Val1'; then calls compare(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ElementPropertyComparator._compare(Object, Object)"})
  void test_compare_givenComparatorCompareReturnOne_whenVal1_thenCallsCompare2() {
    // Arrange
    Comparator comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setComparator(comparator);
    elementPropertyComparator.setReversed(true);

    // Act
    int actual_compareResult = elementPropertyComparator._compare("Val1", "Val2");

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, actual_compareResult);
  }

  /**
   * Test {@link ElementPropertyComparator#_compare(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link ElementPropertyComparator} (default constructor) Comparator is {@code null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#_compare(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test _compare(Object, Object); given ElementPropertyComparator (default constructor) Comparator is 'null'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ElementPropertyComparator._compare(Object, Object)"})
  void test_compare_givenElementPropertyComparatorComparatorIsNull_thenReturnMinusOne() {
    // Arrange
    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setComparator(null);
    elementPropertyComparator.setReversed(false);

    // Act and Assert
    assertEquals(-1, elementPropertyComparator._compare("Val1", null));
  }

  /**
   * Test {@link ElementPropertyComparator#_compare(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link ElementPropertyComparator} (default constructor) Comparator is {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#_compare(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test _compare(Object, Object); given ElementPropertyComparator (default constructor) Comparator is 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ElementPropertyComparator._compare(Object, Object)"})
  void test_compare_givenElementPropertyComparatorComparatorIsNull_thenReturnZero() {
    // Arrange
    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setComparator(null);
    elementPropertyComparator.setReversed(false);

    // Act and Assert
    assertEquals(0, elementPropertyComparator._compare(null, null));
  }

  /**
   * Test {@link ElementPropertyComparator#_compare(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link ElementPropertyComparator} (default constructor) Comparator is {@code null}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#_compare(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test _compare(Object, Object); given ElementPropertyComparator (default constructor) Comparator is 'null'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ElementPropertyComparator._compare(Object, Object)"})
  void test_compare_givenElementPropertyComparatorComparatorIsNull_whenNull() {
    // Arrange
    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setComparator(null);
    elementPropertyComparator.setReversed(false);

    // Act and Assert
    assertEquals(1, elementPropertyComparator._compare(null, "Val2"));
  }

  /**
   * Test {@link ElementPropertyComparator#_compare(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link ElementPropertyComparator} (default constructor) Reversed is {@code true}.
   *   <li>When {@code Val1}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#_compare(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test _compare(Object, Object); given ElementPropertyComparator (default constructor) Reversed is 'true'; when 'Val1'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ElementPropertyComparator._compare(Object, Object)"})
  void test_compare_givenElementPropertyComparatorReversedIsTrue_whenVal1_thenReturnOne() {
    // Arrange
    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setReversed(true);

    // Act and Assert
    assertEquals(1, elementPropertyComparator._compare("Val1", "Val2"));
  }

  /**
   * Test {@link ElementPropertyComparator#_compare(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link ElementPropertyComparator} (default constructor).
   *   <li>When {@code Val1}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#_compare(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test _compare(Object, Object); given ElementPropertyComparator (default constructor); when 'Val1'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ElementPropertyComparator._compare(Object, Object)"})
  void test_compare_givenElementPropertyComparator_whenVal1_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new ElementPropertyComparator()._compare("Val1", "Val2"));
  }

  /**
   * Test {@link ElementPropertyComparator#getComparableGroupPropertyPairs()}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor) comparator {@link Comparator} build.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName(
      "Test getComparableGroupPropertyPairs(); given Builder (default constructor) comparator Comparator build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ElementPropertyComparator.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenBuilderComparatorComparatorBuild() {
    // Arrange, Act and Assert
    assertTrue(
        new Builder()
            .comparator(mock(Comparator.class))
            .build()
            .getComparableGroupPropertyPairs()
            .isEmpty());
  }

  /**
   * Test {@link ElementPropertyComparator#getComparableGroupPropertyPairs()}.
   *
   * <ul>
   *   <li>Given {@link ElementPropertyComparator} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName(
      "Test getComparableGroupPropertyPairs(); given ElementPropertyComparator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ElementPropertyComparator.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenElementPropertyComparator() {
    // Arrange, Act and Assert
    assertTrue(new ElementPropertyComparator().getComparableGroupPropertyPairs().isEmpty());
  }

  /**
   * Test {@link ElementPropertyComparator#getComparableGroupPropertyPairs()}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName(
      "Test getComparableGroupPropertyPairs(); given LinkedHashSet() add '42'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ElementPropertyComparator.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenLinkedHashSetAdd42_thenReturnSizeIsTwo() {
    // Arrange
    LinkedHashSet<String> groups = new LinkedHashSet<>();
    groups.add("42");
    groups.add("foo");

    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setComparator(null);
    elementPropertyComparator.setGroups(groups);

    // Act and Assert
    assertEquals(2, elementPropertyComparator.getComparableGroupPropertyPairs().size());
  }

  /**
   * Test {@link ElementPropertyComparator#getComparableGroupPropertyPairs()}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code foo}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ElementPropertyComparator#getComparableGroupPropertyPairs()}
   */
  @Test
  @DisplayName(
      "Test getComparableGroupPropertyPairs(); given LinkedHashSet() add 'foo'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ElementPropertyComparator.getComparableGroupPropertyPairs()"})
  void testGetComparableGroupPropertyPairs_givenLinkedHashSetAddFoo_thenReturnSizeIsOne() {
    // Arrange
    LinkedHashSet<String> groups = new LinkedHashSet<>();
    groups.add("foo");

    ElementPropertyComparator elementPropertyComparator = new ElementPropertyComparator();
    elementPropertyComparator.setComparator(null);
    elementPropertyComparator.setGroups(groups);

    // Act and Assert
    assertEquals(1, elementPropertyComparator.getComparableGroupPropertyPairs().size());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementPropertyComparator#setComparator(Comparator)}
   *   <li>{@link ElementPropertyComparator#setGroups(Set)}
   *   <li>{@link ElementPropertyComparator#setProperty(String)}
   *   <li>{@link ElementPropertyComparator#setReversed(boolean)}
   *   <li>{@link ElementPropertyComparator#getComparator()}
   *   <li>{@link ElementPropertyComparator#getGroups()}
   *   <li>{@link ElementPropertyComparator#getProperty()}
   *   <li>{@link ElementPropertyComparator#isReversed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Comparator ElementPropertyComparator.getComparator()",
    "Set ElementPropertyComparator.getGroups()",
    "String ElementPropertyComparator.getProperty()",
    "boolean ElementPropertyComparator.isReversed()",
    "void ElementPropertyComparator.setComparator(Comparator)",
    "void ElementPropertyComparator.setGroups(Set)",
    "void ElementPropertyComparator.setProperty(String)",
    "void ElementPropertyComparator.setReversed(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    ElementPropertyComparator elementPropertyComparator =
        new Builder().comparator(mock(Comparator.class)).build();
    Comparator comparator = mock(Comparator.class);

    // Act
    elementPropertyComparator.setComparator(comparator);
    HashSet<String> groups = new HashSet<>();
    elementPropertyComparator.setGroups(groups);
    elementPropertyComparator.setProperty("Property");
    elementPropertyComparator.setReversed(true);
    Comparator actualComparator = elementPropertyComparator.getComparator();
    Set<String> actualGroups = elementPropertyComparator.getGroups();
    String actualProperty = elementPropertyComparator.getProperty();
    boolean actualIsReversedResult = elementPropertyComparator.isReversed();

    // Assert
    assertEquals("Property", actualProperty);
    assertTrue(actualGroups.isEmpty());
    assertTrue(actualIsReversedResult);
    assertSame(groups, actualGroups);
    assertSame(comparator, actualComparator);
  }

  /**
   * Test new {@link ElementPropertyComparator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ElementPropertyComparator}
   */
  @Test
  @DisplayName("Test new ElementPropertyComparator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementPropertyComparator.<init>()"})
  void testNewElementPropertyComparator() {
    // Arrange and Act
    ElementPropertyComparator actualElementPropertyComparator = new ElementPropertyComparator();

    // Assert
    assertNull(actualElementPropertyComparator.getProperty());
    assertNull(actualElementPropertyComparator.getComparator());
    assertFalse(actualElementPropertyComparator.isReversed());
    assertTrue(actualElementPropertyComparator.getComparableGroupPropertyPairs().isEmpty());
    assertTrue(actualElementPropertyComparator.getGroups().isEmpty());
  }
}
