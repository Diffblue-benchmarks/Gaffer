package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GroupedPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GroupedProperties#GroupedProperties()}
   *   <li>{@link GroupedProperties#setGroup(String)}
   *   <li>{@link GroupedProperties#getGroup()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GroupedProperties.<init>()",
    "void GroupedProperties.<init>(String)",
    "String GroupedProperties.getGroup()",
    "void GroupedProperties.setGroup(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GroupedProperties actualGroupedProperties = new GroupedProperties();
    actualGroupedProperties.setGroup("Group");

    // Assert
    assertEquals("Group", actualGroupedProperties.getGroup());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Group}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GroupedProperties#GroupedProperties(String)}
   *   <li>{@link GroupedProperties#setGroup(String)}
   *   <li>{@link GroupedProperties#getGroup()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GroupedProperties.<init>()",
    "void GroupedProperties.<init>(String)",
    "String GroupedProperties.getGroup()",
    "void GroupedProperties.setGroup(String)"
  })
  void testGettersAndSetters_whenGroup() {
    // Arrange and Act
    GroupedProperties actualGroupedProperties = new GroupedProperties("Group");
    actualGroupedProperties.setGroup("Group");

    // Assert
    assertEquals("Group", actualGroupedProperties.getGroup());
  }

  /**
   * Test {@link GroupedProperties#equals(Object)}, and {@link GroupedProperties#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GroupedProperties#equals(Object)}
   *   <li>{@link GroupedProperties#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GroupedProperties.equals(Object)",
    "int GroupedProperties.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GroupedProperties groupedProperties = new GroupedProperties();
    GroupedProperties groupedProperties2 = new GroupedProperties();

    // Act and Assert
    assertEquals(groupedProperties, groupedProperties2);
    assertEquals(groupedProperties.hashCode(), groupedProperties2.hashCode());
  }

  /**
   * Test {@link GroupedProperties#equals(Object)}, and {@link GroupedProperties#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GroupedProperties#equals(Object)}
   *   <li>{@link GroupedProperties#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GroupedProperties.equals(Object)",
    "int GroupedProperties.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GroupedProperties groupedProperties = new GroupedProperties();

    // Act and Assert
    assertEquals(groupedProperties, groupedProperties);
    int expectedHashCodeResult = groupedProperties.hashCode();
    assertEquals(expectedHashCodeResult, groupedProperties.hashCode());
  }

  /**
   * Test {@link GroupedProperties#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GroupedProperties#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GroupedProperties.equals(Object)",
    "int GroupedProperties.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GroupedProperties groupedProperties = new GroupedProperties();
    groupedProperties.setGroup("Group");

    // Act and Assert
    assertNotEquals(groupedProperties, new GroupedProperties());
  }

  /**
   * Test {@link GroupedProperties#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GroupedProperties#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GroupedProperties.equals(Object)",
    "int GroupedProperties.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GroupedProperties(), null);
  }

  /**
   * Test {@link GroupedProperties#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GroupedProperties#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GroupedProperties.equals(Object)",
    "int GroupedProperties.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GroupedProperties(), "Different type to GroupedProperties");
  }
}
