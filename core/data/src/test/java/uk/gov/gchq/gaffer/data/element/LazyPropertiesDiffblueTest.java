package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  void testContainsKey_thenReturnTrue() {
    // Arrange
    LazyProperties lazyProperties =
        new LazyProperties(new Properties(), mock(ElementValueLoader.class));
    lazyProperties.put("uk.gov.gchq.gaffer.data.element.LazyProperties", "Property");

    // Act and Assert
    assertTrue(lazyProperties.containsKey("uk.gov.gchq.gaffer.data.element.LazyProperties"));
  }
}
