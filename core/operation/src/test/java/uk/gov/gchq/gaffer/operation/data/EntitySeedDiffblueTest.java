package uk.gov.gchq.gaffer.operation.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntitySeedDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitySeed#EntitySeed()}
   *   <li>{@link EntitySeed#setVertex(Object)}
   *   <li>{@link EntitySeed#toString()}
   *   <li>{@link EntitySeed#getVertex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntitySeed.<init>()",
    "void EntitySeed.<init>(Object)",
    "Object EntitySeed.getVertex()",
    "void EntitySeed.setVertex(Object)",
    "String EntitySeed.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntitySeed actualEntitySeed = new EntitySeed();
    actualEntitySeed.setVertex("Vertex");
    String actualToStringResult = actualEntitySeed.toString();

    // Assert
    assertEquals("EntitySeed[vertex=Vertex]", actualToStringResult);
    assertEquals("Vertex", actualEntitySeed.getVertex());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Vertex}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitySeed#EntitySeed(Object)}
   *   <li>{@link EntitySeed#setVertex(Object)}
   *   <li>{@link EntitySeed#toString()}
   *   <li>{@link EntitySeed#getVertex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Vertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntitySeed.<init>()",
    "void EntitySeed.<init>(Object)",
    "Object EntitySeed.getVertex()",
    "void EntitySeed.setVertex(Object)",
    "String EntitySeed.toString()"
  })
  void testGettersAndSetters_whenVertex() {
    // Arrange and Act
    EntitySeed actualEntitySeed = new EntitySeed("Vertex");
    actualEntitySeed.setVertex("Vertex");
    String actualToStringResult = actualEntitySeed.toString();

    // Assert
    assertEquals("EntitySeed[vertex=Vertex]", actualToStringResult);
    assertEquals("Vertex", actualEntitySeed.getVertex());
  }

  /**
   * Test {@link EntitySeed#equals(Object)}, and {@link EntitySeed#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitySeed#equals(Object)}
   *   <li>{@link EntitySeed#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntitySeed.equals(Object)", "int EntitySeed.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitySeed entitySeed = new EntitySeed();
    EntitySeed entitySeed2 = new EntitySeed();

    // Act and Assert
    assertEquals(entitySeed, entitySeed2);
    assertEquals(entitySeed.hashCode(), entitySeed2.hashCode());
  }

  /**
   * Test {@link EntitySeed#equals(Object)}, and {@link EntitySeed#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitySeed#equals(Object)}
   *   <li>{@link EntitySeed#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntitySeed.equals(Object)", "int EntitySeed.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntitySeed entitySeed = new EntitySeed();

    // Act and Assert
    assertEquals(entitySeed, entitySeed);
    int expectedHashCodeResult = entitySeed.hashCode();
    assertEquals(expectedHashCodeResult, entitySeed.hashCode());
  }

  /**
   * Test {@link EntitySeed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitySeed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntitySeed.equals(Object)", "int EntitySeed.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntitySeed entitySeed = new EntitySeed();
    entitySeed.setVertex("Vertex");

    // Act and Assert
    assertNotEquals(entitySeed, new EntitySeed());
  }

  /**
   * Test {@link EntitySeed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitySeed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntitySeed.equals(Object)", "int EntitySeed.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntitySeed entitySeed = new EntitySeed();
    entitySeed.setVertex(new EntitySeed());

    EntitySeed entitySeed2 = new EntitySeed();
    entitySeed2.setVertex("Vertex");

    // Act and Assert
    assertNotEquals(entitySeed, entitySeed2);
  }

  /**
   * Test {@link EntitySeed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitySeed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntitySeed.equals(Object)", "int EntitySeed.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntitySeed(), null);
  }

  /**
   * Test {@link EntitySeed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitySeed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntitySeed.equals(Object)", "int EntitySeed.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntitySeed(), "Different type to EntitySeed");
  }
}
