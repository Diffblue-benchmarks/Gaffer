package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PropertiesDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Properties#Properties()}
   *   <li>{@link Properties#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Properties[]", new Properties().toString());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Properties#Properties(Map)}
   *   <li>{@link Properties#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashMap()")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenHashMap() {
    // Arrange, Act and Assert
    assertEquals("Properties[]", new Properties(new HashMap<>()).toString());
  }

  /**
   * Test {@link Properties#Properties(String, Object)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Properties#Properties(String, Object)}
   */
  @Test
  @DisplayName("Test new Properties(String, Object); when 'Name'; then return Empty")
  @Tag("MaintainedByDiffblue")
  void testNewProperties_whenName_thenReturnEmpty() {
    // Arrange and Act
    Properties actualProperties = new Properties("Name", null);

    // Assert
    assertTrue(actualProperties.isEmpty());
  }

  /**
   * Test {@link Properties#Properties(String, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Properties#Properties(String, Object)}
   */
  @Test
  @DisplayName("Test new Properties(String, Object); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  void testNewProperties_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Properties actualProperties = new Properties(null, null);

    // Assert
    assertTrue(actualProperties.isEmpty());
  }

  /**
   * Test {@link Properties#Properties(String, Object)}.
   *
   * <ul>
   *   <li>When {@code Property}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Properties#Properties(String, Object)}
   */
  @Test
  @DisplayName("Test new Properties(String, Object); when 'Property'; then return size is one")
  @Tag("MaintainedByDiffblue")
  void testNewProperties_whenProperty_thenReturnSizeIsOne() {
    // Arrange and Act
    Properties actualProperties = new Properties("Name", "Property");

    // Assert
    assertEquals(1, actualProperties.size());
    assertEquals("Property", actualProperties.get("Name"));
  }

  /**
   * Test {@link Properties#put(String, Object)} with {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Properties#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; when 'Name'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testPutWithStringObject_whenName_thenReturnNull() {
    // Arrange
    Properties properties = new Properties();

    // Act and Assert
    assertNull(properties.put("Name", null));
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link Properties#put(String, Object)} with {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Properties#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testPutWithStringObject_whenNull_thenReturnNull() {
    // Arrange
    Properties properties = new Properties();

    // Act and Assert
    assertNull(properties.put(null, null));
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link Properties#put(String, Object)} with {@code String}, {@code Object}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then {@link Properties#Properties()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Properties#put(String, Object)}
   */
  @Test
  @DisplayName(
      "Test put(String, Object) with 'String', 'Object'; when 'Value'; then Properties() size is one")
  @Tag("MaintainedByDiffblue")
  void testPutWithStringObject_whenValue_thenPropertiesSizeIsOne() {
    // Arrange
    Properties properties = new Properties();

    // Act
    properties.put("Name", "Value");

    // Assert
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
  }

  /**
   * Test {@link Properties#clone()}.
   *
   * <p>Method under test: {@link Properties#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("MaintainedByDiffblue")
  void testClone() {
    // Arrange
    Properties properties = new Properties();

    // Act
    Properties actualCloneResult = properties.clone();

    // Assert
    assertEquals(properties, actualCloneResult);
  }

  /**
   * Test {@link Properties#keepOnly(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then {@link Properties#Properties()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Properties#keepOnly(Collection)}
   */
  @Test
  @DisplayName(
      "Test keepOnly(Collection); given '42'; when ArrayList() add '42'; then Properties() Empty")
  @Tag("MaintainedByDiffblue")
  void testKeepOnly_given42_whenArrayListAdd42_thenPropertiesEmpty() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Name", "Value");

    ArrayList<String> propertiesToKeep = new ArrayList<>();
    propertiesToKeep.add("42");
    propertiesToKeep.add("foo");

    // Act
    properties.keepOnly(propertiesToKeep);

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link Properties#keepOnly(Collection)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then {@link Properties#Properties()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Properties#keepOnly(Collection)}
   */
  @Test
  @DisplayName(
      "Test keepOnly(Collection); given 'foo'; when ArrayList() add 'foo'; then Properties() Empty")
  @Tag("MaintainedByDiffblue")
  void testKeepOnly_givenFoo_whenArrayListAddFoo_thenPropertiesEmpty() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Name", "Value");

    ArrayList<String> propertiesToKeep = new ArrayList<>();
    propertiesToKeep.add("foo");

    // Act
    properties.keepOnly(propertiesToKeep);

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link Properties#keepOnly(Collection)}.
   *
   * <ul>
   *   <li>Given {@link Properties#Properties()} IfAbsent {@code foo} is {@code 42}.
   *   <li>Then {@link Properties#Properties()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Properties#keepOnly(Collection)}
   */
  @Test
  @DisplayName(
      "Test keepOnly(Collection); given Properties() IfAbsent 'foo' is '42'; then Properties() size is one")
  @Tag("MaintainedByDiffblue")
  void testKeepOnly_givenPropertiesIfAbsentFooIs42_thenPropertiesSizeIsOne() {
    // Arrange
    Properties properties = new Properties();
    properties.putIfAbsent("foo", "42");
    properties.put("Name", "Value");

    ArrayList<String> propertiesToKeep = new ArrayList<>();
    propertiesToKeep.add("foo");

    // Act
    properties.keepOnly(propertiesToKeep);

    // Assert
    assertEquals(1, properties.size());
    assertTrue(properties.containsKey("foo"));
  }

  /**
   * Test {@link Properties#keepOnly(Collection)}.
   *
   * <ul>
   *   <li>Given {@link Properties#Properties()} {@code Map} is {@code Value}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link Properties#Properties()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Properties#keepOnly(Collection)}
   */
  @Test
  @DisplayName(
      "Test keepOnly(Collection); given Properties() 'java.util.Map' is 'Value'; when ArrayList(); then Properties() Empty")
  @Tag("MaintainedByDiffblue")
  void testKeepOnly_givenPropertiesJavaUtilMapIsValue_whenArrayList_thenPropertiesEmpty() {
    // Arrange
    Properties properties = new Properties();
    properties.put("java.util.Map", "Value");
    properties.put("Name", "Value");

    // Act
    properties.keepOnly(new ArrayList<>());

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link Properties#keepOnly(Collection)}.
   *
   * <ul>
   *   <li>Given {@link Properties#Properties()} {@code Name} is {@code Value}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link Properties#Properties()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Properties#keepOnly(Collection)}
   */
  @Test
  @DisplayName(
      "Test keepOnly(Collection); given Properties() 'Name' is 'Value'; when ArrayList(); then Properties() Empty")
  @Tag("MaintainedByDiffblue")
  void testKeepOnly_givenPropertiesNameIsValue_whenArrayList_thenPropertiesEmpty() {
    // Arrange
    Properties properties = new Properties();
    properties.put("Name", "Value");

    // Act
    properties.keepOnly(new ArrayList<>());

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link Properties#keepOnly(Collection)}.
   *
   * <ul>
   *   <li>Given {@link Properties#Properties()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link Properties#Properties()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Properties#keepOnly(Collection)}
   */
  @Test
  @DisplayName(
      "Test keepOnly(Collection); given Properties(); when ArrayList(); then Properties() Empty")
  @Tag("MaintainedByDiffblue")
  void testKeepOnly_givenProperties_whenArrayList_thenPropertiesEmpty() {
    // Arrange
    Properties properties = new Properties();

    // Act
    properties.keepOnly(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }
}
