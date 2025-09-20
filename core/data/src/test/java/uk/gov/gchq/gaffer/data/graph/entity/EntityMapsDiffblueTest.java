package uk.gov.gchq.gaffer.data.graph.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityMapsDiffblueTest {
  /**
   * Test {@link EntityMaps#add(EntityMap)}.
   *
   * <p>Method under test: {@link EntityMaps#add(EntityMap)}
   */
  @Test
  @DisplayName("Test add(EntityMap)")
  @Tag("MaintainedByDiffblue")
  void testAdd() {
    // Arrange
    SimpleEntityMaps simpleEntityMaps = new SimpleEntityMaps();

    // Act
    simpleEntityMaps.add(new EntityMap());

    // Assert
    assertEquals(1, simpleEntityMaps.size());
  }

  /**
   * Test {@link EntityMaps#get(int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleEntityMaps} (default constructor) add {@link EntityMap} (default
   *       constructor).
   *   <li>Then return Vertices Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityMaps#get(int)}
   */
  @Test
  @DisplayName(
      "Test get(int); given SimpleEntityMaps (default constructor) add EntityMap (default constructor); then return Vertices Empty")
  @Tag("MaintainedByDiffblue")
  void testGet_givenSimpleEntityMapsAddEntityMap_thenReturnVerticesEmpty() {
    // Arrange
    SimpleEntityMaps simpleEntityMaps = new SimpleEntityMaps();
    simpleEntityMaps.add(new EntityMap());
    EntityMap entityMap = new EntityMap();
    simpleEntityMaps.add(entityMap);

    // Act
    EntityMap actualGetResult = simpleEntityMaps.get(1);

    // Assert
    assertTrue(actualGetResult.getVertices().isEmpty());
    assertSame(entityMap, actualGetResult);
  }

  /**
   * Test {@link EntityMaps#size()}.
   *
   * <p>Method under test: {@link EntityMaps#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new SimpleEntityMaps().size());
  }

  /**
   * Test {@link EntityMaps#empty()}.
   *
   * <ul>
   *   <li>Given {@link EntityMaps} {@link EntityMaps#empty()} return {@code false}.
   *   <li>Then calls {@link EntityMaps#empty()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMaps#empty()}
   */
  @Test
  @DisplayName("Test empty(); given EntityMaps empty() return 'false'; then calls empty()")
  @Tag("MaintainedByDiffblue")
  void testEmpty_givenEntityMapsEmptyReturnFalse_thenCallsEmpty() {
    // Arrange
    EntityMaps entityMaps = mock(EntityMaps.class);
    when(entityMaps.empty()).thenReturn(false);

    // Act
    entityMaps.empty();

    // Assert
    verify(entityMaps).empty();
  }

  /**
   * Test {@link EntityMaps#empty()}.
   *
   * <ul>
   *   <li>Given {@link SimpleEntityMaps} (default constructor) add {@link EntityMap} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMaps#empty()}
   */
  @Test
  @DisplayName(
      "Test empty(); given SimpleEntityMaps (default constructor) add EntityMap (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testEmpty_givenSimpleEntityMapsAddEntityMap_thenReturnFalse() {
    // Arrange
    SimpleEntityMaps simpleEntityMaps = new SimpleEntityMaps();
    simpleEntityMaps.add(new EntityMap());

    // Act and Assert
    assertFalse(simpleEntityMaps.empty());
  }

  /**
   * Test {@link EntityMaps#empty()}.
   *
   * <ul>
   *   <li>Given {@link SimpleEntityMaps} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMaps#empty()}
   */
  @Test
  @DisplayName("Test empty(); given SimpleEntityMaps (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testEmpty_givenSimpleEntityMaps_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new SimpleEntityMaps().empty());
  }

  /**
   * Test {@link EntityMaps#iterator()}.
   *
   * <p>Method under test: {@link EntityMaps#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("MaintainedByDiffblue")
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse(new SimpleEntityMaps().iterator().hasNext());
  }
}
