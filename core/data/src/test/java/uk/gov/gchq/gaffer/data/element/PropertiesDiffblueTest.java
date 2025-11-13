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

package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Properties#Properties()}
   *   <li>{@link Properties#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Properties.<init>()", "void Properties.<init>(Map)", "String Properties.toString()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Properties[]", (new Properties()).toString());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Properties#Properties(Map)}
   *   <li>{@link Properties#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Properties.<init>()", "void Properties.<init>(Map)", "String Properties.toString()"})
  void testGettersAndSetters_whenHashMap() {
    // Arrange, Act and Assert
    assertEquals("Properties[]", (new Properties(new HashMap<>())).toString());
  }

  /**
   * Test {@link Properties#Properties(String, Object)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Properties#Properties(String, Object)}
   */
  @Test
  @DisplayName("Test new Properties(String, Object); when 'Name'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Properties.<init>(String, Object)"})
  void testNewProperties_whenName_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new Properties("Name", null)).isEmpty());
  }

  /**
   * Test {@link Properties#Properties(String, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Properties#Properties(String, Object)}
   */
  @Test
  @DisplayName("Test new Properties(String, Object); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Properties.<init>(String, Object)"})
  void testNewProperties_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new Properties(null, null)).isEmpty());
  }

  /**
   * Test {@link Properties#Properties(String, Object)}.
   * <ul>
   *   <li>When {@code Property}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Properties#Properties(String, Object)}
   */
  @Test
  @DisplayName("Test new Properties(String, Object); when 'Property'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Properties.<init>(String, Object)"})
  void testNewProperties_whenProperty_thenReturnSizeIsOne() {
    // Arrange and Act
    Properties actualProperties = new Properties("Name", "Property");

    // Assert
    assertEquals(1, actualProperties.size());
    assertEquals("Property", actualProperties.get("Name"));
  }

  /**
   * Test {@link Properties#put(String, Object)} with {@code String}, {@code Object}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Properties#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; when 'Name'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Properties.put(String, Object)"})
  void testPutWithStringObject_whenName_thenReturnNull() {
    // Arrange
    Properties properties = new Properties();

    // Act and Assert
    assertNull(properties.put("Name", null));
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link Properties#put(String, Object)} with {@code String}, {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Properties#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Properties.put(String, Object)"})
  void testPutWithStringObject_whenNull_thenReturnNull() {
    // Arrange
    Properties properties = new Properties();

    // Act and Assert
    assertNull(properties.put(null, null));
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link Properties#put(String, Object)} with {@code String}, {@code Object}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then {@link Properties#Properties()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Properties#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; when 'Value'; then Properties() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Properties.put(String, Object)"})
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
   * <p>
   * Method under test: {@link Properties#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Properties Properties.clone()"})
  void testClone() {
    // Arrange
    Properties properties = new Properties();

    // Act and Assert
    assertEquals(properties, properties.clone());
  }

  /**
   * Test {@link Properties#keepOnly(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link Properties#Properties()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Properties#keepOnly(Collection)}
   */
  @Test
  @DisplayName("Test keepOnly(Collection); given '42'; when ArrayList() add '42'; then Properties() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Properties.keepOnly(Collection)"})
  void testKeepOnly_given42_whenArrayListAdd42_thenPropertiesEmpty() {
    // Arrange
    Properties properties = new Properties();

    ArrayList<String> propertiesToKeep = new ArrayList<>();
    propertiesToKeep.add("42");
    propertiesToKeep.add("foo");

    // Act
    properties.keepOnly(propertiesToKeep);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link Properties#keepOnly(Collection)}.
   * <ul>
   *   <li>Given {@link Properties#Properties()} IfAbsent {@code foo} is {@code 42}.</li>
   *   <li>Then {@link Properties#Properties()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Properties#keepOnly(Collection)}
   */
  @Test
  @DisplayName("Test keepOnly(Collection); given Properties() IfAbsent 'foo' is '42'; then Properties() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Properties.keepOnly(Collection)"})
  void testKeepOnly_givenPropertiesIfAbsentFooIs42_thenPropertiesSizeIsOne() {
    // Arrange
    Properties properties = new Properties();
    properties.putIfAbsent("foo", "42");

    ArrayList<String> propertiesToKeep = new ArrayList<>();
    propertiesToKeep.add("foo");

    // Act
    properties.keepOnly(propertiesToKeep);

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    assertTrue(properties.containsKey("foo"));
  }

  /**
   * Test {@link Properties#keepOnly(Collection)}.
   * <ul>
   *   <li>Given {@link Properties#Properties()} {@code Map} is {@code Value}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link Properties#Properties()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Properties#keepOnly(Collection)}
   */
  @Test
  @DisplayName("Test keepOnly(Collection); given Properties() 'java.util.Map' is 'Value'; when ArrayList(); then Properties() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Properties.keepOnly(Collection)"})
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
   * <ul>
   *   <li>Given {@link Properties#Properties()} {@code Name} is {@code Value}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link Properties#Properties()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Properties#keepOnly(Collection)}
   */
  @Test
  @DisplayName("Test keepOnly(Collection); given Properties() 'Name' is 'Value'; when ArrayList(); then Properties() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Properties.keepOnly(Collection)"})
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
   * <ul>
   *   <li>Given {@link Properties#Properties()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then {@link Properties#Properties()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Properties#keepOnly(Collection)}
   */
  @Test
  @DisplayName("Test keepOnly(Collection); given Properties(); when ArrayList() add 'foo'; then Properties() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Properties.keepOnly(Collection)"})
  void testKeepOnly_givenProperties_whenArrayListAddFoo_thenPropertiesEmpty() {
    // Arrange
    Properties properties = new Properties();

    ArrayList<String> propertiesToKeep = new ArrayList<>();
    propertiesToKeep.add("foo");

    // Act
    properties.keepOnly(propertiesToKeep);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link Properties#keepOnly(Collection)}.
   * <ul>
   *   <li>Given {@link Properties#Properties()}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link Properties#Properties()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Properties#keepOnly(Collection)}
   */
  @Test
  @DisplayName("Test keepOnly(Collection); given Properties(); when ArrayList(); then Properties() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Properties.keepOnly(Collection)"})
  void testKeepOnly_givenProperties_whenArrayList_thenPropertiesEmpty() {
    // Arrange
    Properties properties = new Properties();

    // Act
    properties.keepOnly(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }
}
