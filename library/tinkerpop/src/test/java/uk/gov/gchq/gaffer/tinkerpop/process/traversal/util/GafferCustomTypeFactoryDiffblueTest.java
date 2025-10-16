package uk.gov.gchq.gaffer.tinkerpop.process.traversal.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class GafferCustomTypeFactoryDiffblueTest {
  /**
   * Test {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link LinkedList#LinkedList()} add {@code 42}.
   *   <li>Then return {@link LinkedList#LinkedList()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  @DisplayName(
      "Test parseAsCustomTypeIfValid(Object); given '42'; when LinkedList() add '42'; then return LinkedList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseAsCustomTypeIfValid(Object)"})
  void testParseAsCustomTypeIfValid_given42_whenLinkedListAdd42_thenReturnLinkedList() {
    // Arrange
    LinkedList<Object> objectList = new LinkedList<>();
    objectList.add("42");
    objectList.add("42");

    // Act
    Object actualParseAsCustomTypeIfValidResult =
        GafferCustomTypeFactory.parseAsCustomTypeIfValid(objectList);

    // Assert
    assertEquals(objectList, actualParseAsCustomTypeIfValidResult);
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link LinkedList#LinkedList()} add {@code 42}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  @DisplayName(
      "Test parseAsCustomTypeIfValid(Object); given '42'; when LinkedList() add '42'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseAsCustomTypeIfValid(Object)"})
  void testParseAsCustomTypeIfValid_given42_whenLinkedListAdd42_thenReturnList() {
    // Arrange
    LinkedList<Object> objectList = new LinkedList<>();
    objectList.add("42");

    // Act
    Object actualParseAsCustomTypeIfValidResult =
        GafferCustomTypeFactory.parseAsCustomTypeIfValid(objectList);

    // Assert
    assertTrue(actualParseAsCustomTypeIfValidResult instanceof List);
    assertEquals(1, ((List<String>) actualParseAsCustomTypeIfValidResult).size());
    assertEquals("42", ((List<String>) actualParseAsCustomTypeIfValidResult).get(0));
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}.
   *
   * <ul>
   *   <li>Then return {@link TypeSubTypeValue}.
   * </ul>
   *
   * <p>Method under test: {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  @DisplayName("Test parseAsCustomTypeIfValid(Object); then return TypeSubTypeValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseAsCustomTypeIfValid(Object)"})
  void testParseAsCustomTypeIfValid_thenReturnTypeSubTypeValue() {
    // Arrange and Act
    Object actualParseAsCustomTypeIfValidResult =
        GafferCustomTypeFactory.parseAsCustomTypeIfValid("xx[type=xx,  subType=xx,  value=xx]");

    // Assert
    assertTrue(actualParseAsCustomTypeIfValidResult instanceof TypeSubTypeValue);
    assertEquals("xx", ((TypeSubTypeValue) actualParseAsCustomTypeIfValidResult).getSubType());
    assertEquals("xx", ((TypeSubTypeValue) actualParseAsCustomTypeIfValidResult).getType());
    assertEquals("xx", ((TypeSubTypeValue) actualParseAsCustomTypeIfValidResult).getValue());
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  @DisplayName("Test parseAsCustomTypeIfValid(Object); when ArrayList(); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseAsCustomTypeIfValid(Object)"})
  void testParseAsCustomTypeIfValid_whenArrayList_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    Object actualParseAsCustomTypeIfValidResult =
        GafferCustomTypeFactory.parseAsCustomTypeIfValid(objectList);

    // Assert
    assertEquals(objectList, actualParseAsCustomTypeIfValidResult);
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  @DisplayName("Test parseAsCustomTypeIfValid(Object); when HashSet(); then return HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseAsCustomTypeIfValid(Object)"})
  void testParseAsCustomTypeIfValid_whenHashSet_thenReturnHashSet() {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();

    // Act
    Object actualParseAsCustomTypeIfValidResult =
        GafferCustomTypeFactory.parseAsCustomTypeIfValid(objectSet);

    // Assert
    assertEquals(objectSet, actualParseAsCustomTypeIfValidResult);
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link GafferCustomTypeFactory#parseAsCustomTypeIfValid(Object)}
   */
  @Test
  @DisplayName("Test parseAsCustomTypeIfValid(Object); when 'Value'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseAsCustomTypeIfValid(Object)"})
  void testParseAsCustomTypeIfValid_whenValue_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals("Value", GafferCustomTypeFactory.parseAsCustomTypeIfValid("Value"));
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  @DisplayName(
      "Test parseForGraphSONv3(Object); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseForGraphSONv3(Object)"})
  void testParseForGraphSONv3_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    // Act
    Object actualParseForGraphSONv3Result = GafferCustomTypeFactory.parseForGraphSONv3(objectList);

    // Assert
    assertTrue(actualParseForGraphSONv3Result instanceof List);
    assertEquals(1, ((List<String>) actualParseForGraphSONv3Result).size());
    assertEquals("42", ((List<String>) actualParseForGraphSONv3Result).get(0));
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  @DisplayName(
      "Test parseForGraphSONv3(Object); given '42'; when ArrayList() add '42'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseForGraphSONv3(Object)"})
  void testParseForGraphSONv3_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");

    // Act
    Object actualParseForGraphSONv3Result = GafferCustomTypeFactory.parseForGraphSONv3(objectList);

    // Assert
    assertTrue(actualParseForGraphSONv3Result instanceof List);
    assertEquals(2, ((List<String>) actualParseForGraphSONv3Result).size());
    assertEquals("42", ((List<String>) actualParseForGraphSONv3Result).get(0));
    assertEquals("42", ((List<String>) actualParseForGraphSONv3Result).get(1));
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  @DisplayName("Test parseForGraphSONv3(Object); when ArrayList(); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseForGraphSONv3(Object)"})
  void testParseForGraphSONv3_whenArrayList_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    Object actualParseForGraphSONv3Result = GafferCustomTypeFactory.parseForGraphSONv3(objectList);

    // Assert
    assertEquals(objectList, actualParseForGraphSONv3Result);
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  @DisplayName("Test parseForGraphSONv3(Object); when HashSet(); then return HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseForGraphSONv3(Object)"})
  void testParseForGraphSONv3_whenHashSet_thenReturnHashSet() {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();

    // Act
    Object actualParseForGraphSONv3Result = GafferCustomTypeFactory.parseForGraphSONv3(objectSet);

    // Assert
    assertEquals(objectSet, actualParseForGraphSONv3Result);
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  @DisplayName("Test parseForGraphSONv3(Object); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseForGraphSONv3(Object)"})
  void testParseForGraphSONv3_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(GafferCustomTypeFactory.parseForGraphSONv3(null));
  }

  /**
   * Test {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link GafferCustomTypeFactory#parseForGraphSONv3(Object)}
   */
  @Test
  @DisplayName("Test parseForGraphSONv3(Object); when 'Value'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GafferCustomTypeFactory.parseForGraphSONv3(Object)"})
  void testParseForGraphSONv3_whenValue_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals("Value", GafferCustomTypeFactory.parseForGraphSONv3("Value"));
  }
}
