package uk.gov.gchq.gaffer.commonutil.pair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PairDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Pair#Pair()}
   *   <li>{@link Pair#setFirst(Object)}
   *   <li>{@link Pair#setSecond(Object)}
   *   <li>{@link Pair#toString()}
   *   <li>{@link Pair#getFirst()}
   *   <li>{@link Pair#getSecond()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Pair.<init>()",
    "void Pair.<init>(Object)",
    "void Pair.<init>(Object, Object)",
    "Object Pair.getFirst()",
    "Object Pair.getSecond()",
    "void Pair.setFirst(Object)",
    "void Pair.setSecond(Object)",
    "String Pair.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Pair<Object, Object> actualPair = new Pair<>();
    actualPair.setFirst("First");
    actualPair.setSecond("Second");
    String actualToStringResult = actualPair.toString();
    Object actualFirst = actualPair.getFirst();

    // Assert
    assertEquals("First", actualFirst);
    assertEquals("Pair[first=First,second=Second]", actualToStringResult);
    assertEquals("Second", actualPair.getSecond());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code First}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Pair#Pair(Object)}
   *   <li>{@link Pair#setFirst(Object)}
   *   <li>{@link Pair#setSecond(Object)}
   *   <li>{@link Pair#toString()}
   *   <li>{@link Pair#getFirst()}
   *   <li>{@link Pair#getSecond()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'First'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Pair.<init>()",
    "void Pair.<init>(Object)",
    "void Pair.<init>(Object, Object)",
    "Object Pair.getFirst()",
    "Object Pair.getSecond()",
    "void Pair.setFirst(Object)",
    "void Pair.setSecond(Object)",
    "String Pair.toString()"
  })
  void testGettersAndSetters_whenFirst() {
    // Arrange and Act
    Pair<Object, Object> actualPair = new Pair<>("First");
    actualPair.setFirst("First");
    actualPair.setSecond("Second");
    String actualToStringResult = actualPair.toString();
    Object actualFirst = actualPair.getFirst();

    // Assert
    assertEquals("First", actualFirst);
    assertEquals("Pair[first=First,second=Second]", actualToStringResult);
    assertEquals("Second", actualPair.getSecond());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Second}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Pair#Pair(Object, Object)}
   *   <li>{@link Pair#setFirst(Object)}
   *   <li>{@link Pair#setSecond(Object)}
   *   <li>{@link Pair#toString()}
   *   <li>{@link Pair#getFirst()}
   *   <li>{@link Pair#getSecond()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Second'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Pair.<init>()",
    "void Pair.<init>(Object)",
    "void Pair.<init>(Object, Object)",
    "Object Pair.getFirst()",
    "Object Pair.getSecond()",
    "void Pair.setFirst(Object)",
    "void Pair.setSecond(Object)",
    "String Pair.toString()"
  })
  void testGettersAndSetters_whenSecond() {
    // Arrange and Act
    Pair<Object, Object> actualPair = new Pair<>("First", "Second");
    actualPair.setFirst("First");
    actualPair.setSecond("Second");
    String actualToStringResult = actualPair.toString();
    Object actualFirst = actualPair.getFirst();

    // Assert
    assertEquals("First", actualFirst);
    assertEquals("Pair[first=First,second=Second]", actualToStringResult);
    assertEquals("Second", actualPair.getSecond());
  }

  /**
   * Test {@link Pair#equals(Object)}, and {@link Pair#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Pair#equals(Object)}
   *   <li>{@link Pair#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Pair.equals(Object)", "int Pair.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>();
    Pair<Object, Object> pair2 = new Pair<>();

    // Act and Assert
    assertEquals(pair, pair2);
    assertEquals(pair.hashCode(), pair2.hashCode());
  }

  /**
   * Test {@link Pair#equals(Object)}, and {@link Pair#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Pair#equals(Object)}
   *   <li>{@link Pair#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Pair.equals(Object)", "int Pair.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>();

    // Act and Assert
    assertEquals(pair, pair);
    int expectedHashCodeResult = pair.hashCode();
    assertEquals(expectedHashCodeResult, pair.hashCode());
  }

  /**
   * Test {@link Pair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Pair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Pair.equals(Object)", "int Pair.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>();
    pair.setFirst("First");

    // Act and Assert
    assertNotEquals(pair, new Pair<>());
  }

  /**
   * Test {@link Pair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Pair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Pair.equals(Object)", "int Pair.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>();

    // Act and Assert
    assertNotEquals(pair, null);
  }

  /**
   * Test {@link Pair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Pair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Pair.equals(Object)", "int Pair.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>();

    // Act and Assert
    assertNotEquals(pair, "Different type to Pair");
  }
}
