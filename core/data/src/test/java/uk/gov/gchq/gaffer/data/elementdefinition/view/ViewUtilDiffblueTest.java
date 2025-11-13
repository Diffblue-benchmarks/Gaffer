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

package uk.gov.gchq.gaffer.data.elementdefinition.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Properties;

class ViewUtilDiffblueTest {
  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Element)} with {@code elDef}, {@code element}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Edge#Edge(String)} with {@code Group} Property {@code 42} is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Element)}
   */
  @Test
  @DisplayName("Test removeProperties(ViewElementDefinition, Element) with 'elDef', 'element'; given '42'; when Edge(String) with 'Group' Property '42' is 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Element)"})
  void testRemovePropertiesWithElDefElement_given42_whenEdgeWithGroupProperty42IsValue() {
    // Arrange
    GlobalViewElementDefinition elDef = mock(GlobalViewElementDefinition.class);
    when(elDef.isAllProperties()).thenReturn(false);
    when(elDef.getProperties()).thenReturn(new HashSet<>());

    Edge element = new Edge("Group");
    element.putProperty("42", "Value");

    // Act
    ViewUtil.removeProperties(elDef, element);

    // Assert
    verify(elDef, atLeast(1)).getProperties();
    verify(elDef).isAllProperties();
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Element)} with {@code elDef}, {@code element}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link ViewElementDefinition#getProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Element)}
   */
  @Test
  @DisplayName("Test removeProperties(ViewElementDefinition, Element) with 'elDef', 'element'; given 'false'; then calls getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Element)"})
  void testRemovePropertiesWithElDefElement_givenFalse_thenCallsGetProperties() {
    // Arrange
    GlobalViewElementDefinition elDef = mock(GlobalViewElementDefinition.class);
    when(elDef.isAllProperties()).thenReturn(false);
    when(elDef.getProperties()).thenReturn(new HashSet<>());
    Edge element = new Edge("Group");

    // Act
    ViewUtil.removeProperties(elDef, element);

    // Assert that nothing has changed
    verify(elDef, atLeast(1)).getProperties();
    verify(elDef).isAllProperties();
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Element)} with {@code elDef}, {@code element}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Element)}
   */
  @Test
  @DisplayName("Test removeProperties(ViewElementDefinition, Element) with 'elDef', 'element'; when 'null'; then Edge(String) with 'Group' Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Element)"})
  void testRemovePropertiesWithElDefElement_whenNull_thenEdgeWithGroupPropertiesEmpty() {
    // Arrange
    Edge element = new Edge("Group");

    // Act
    ViewUtil.removeProperties((ViewElementDefinition) null, element);

    // Assert that nothing has changed
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Element)} with {@code elDef}, {@code element}.
   * <ul>
   *   <li>When {@link ViewElementDefinition} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Element)}
   */
  @Test
  @DisplayName("Test removeProperties(ViewElementDefinition, Element) with 'elDef', 'element'; when ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Element)"})
  void testRemovePropertiesWithElDefElement_whenViewElementDefinition() {
    // Arrange
    ViewElementDefinition elDef = new ViewElementDefinition();
    Edge element = new Edge("Group");

    // Act
    ViewUtil.removeProperties(elDef, element);

    // Assert that nothing has changed
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)} with {@code elDef}, {@code properties}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link ViewElementDefinition#getProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)}
   */
  @Test
  @DisplayName("Test removeProperties(ViewElementDefinition, Properties) with 'elDef', 'properties'; given HashSet(); then calls getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Properties)"})
  void testRemovePropertiesWithElDefProperties_givenHashSet_thenCallsGetProperties() {
    // Arrange
    GlobalViewElementDefinition elDef = mock(GlobalViewElementDefinition.class);
    when(elDef.isAllProperties()).thenReturn(false);
    when(elDef.getProperties()).thenReturn(new HashSet<>());
    Properties properties = new Properties();

    // Act
    ViewUtil.removeProperties(elDef, properties);

    // Assert that nothing has changed
    verify(elDef, atLeast(1)).getProperties();
    verify(elDef).isAllProperties();
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)} with {@code elDef}, {@code properties}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>When {@link Properties#Properties()} {@code 42} is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)}
   */
  @Test
  @DisplayName("Test removeProperties(ViewElementDefinition, Properties) with 'elDef', 'properties'; given HashSet(); when Properties() '42' is 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Properties)"})
  void testRemovePropertiesWithElDefProperties_givenHashSet_whenProperties42IsValue() {
    // Arrange
    GlobalViewElementDefinition elDef = mock(GlobalViewElementDefinition.class);
    when(elDef.isAllProperties()).thenReturn(false);
    when(elDef.getProperties()).thenReturn(new HashSet<>());

    Properties properties = new Properties();
    properties.put("42", "Value");

    // Act
    ViewUtil.removeProperties(elDef, properties);

    // Assert
    verify(elDef, atLeast(1)).getProperties();
    verify(elDef).isAllProperties();
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)} with {@code elDef}, {@code properties}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>When {@link Properties#Properties()} {@code Name} is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)}
   */
  @Test
  @DisplayName("Test removeProperties(ViewElementDefinition, Properties) with 'elDef', 'properties'; given 'Name'; when Properties() 'Name' is 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Properties)"})
  void testRemovePropertiesWithElDefProperties_givenName_whenPropertiesNameIsValue() {
    // Arrange
    GlobalViewElementDefinition elDef = mock(GlobalViewElementDefinition.class);
    when(elDef.isAllProperties()).thenReturn(false);
    when(elDef.getProperties()).thenReturn(new HashSet<>());

    Properties properties = new Properties();
    properties.put("Name", "Value");
    properties.put("42", "Value");

    // Act
    ViewUtil.removeProperties(elDef, properties);

    // Assert
    verify(elDef, atLeast(1)).getProperties();
    verify(elDef).isAllProperties();
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)} with {@code elDef}, {@code properties}.
   * <ul>
   *   <li>Then {@link Properties#Properties()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)}
   */
  @Test
  @DisplayName("Test removeProperties(ViewElementDefinition, Properties) with 'elDef', 'properties'; then Properties() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Properties)"})
  void testRemovePropertiesWithElDefProperties_thenPropertiesSizeIsOne() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("42");
    GlobalViewElementDefinition elDef = mock(GlobalViewElementDefinition.class);
    when(elDef.isAllProperties()).thenReturn(false);
    when(elDef.getProperties()).thenReturn(stringSet);

    Properties properties = new Properties();
    properties.putIfAbsent("foo", "42");
    properties.put("42", "Value");

    // Act
    ViewUtil.removeProperties(elDef, properties);

    // Assert
    verify(elDef, atLeast(1)).getProperties();
    verify(elDef).isAllProperties();
    assertEquals(1, properties.size());
    assertTrue(properties.containsKey("42"));
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)} with {@code elDef}, {@code properties}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Properties#Properties()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)}
   */
  @Test
  @DisplayName("Test removeProperties(ViewElementDefinition, Properties) with 'elDef', 'properties'; when 'null'; then Properties() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Properties)"})
  void testRemovePropertiesWithElDefProperties_whenNull_thenPropertiesEmpty() {
    // Arrange
    Properties properties = new Properties();

    // Act
    ViewUtil.removeProperties(null, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)} with {@code elDef}, {@code properties}.
   * <ul>
   *   <li>When {@link ViewElementDefinition} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)}
   */
  @Test
  @DisplayName("Test removeProperties(ViewElementDefinition, Properties) with 'elDef', 'properties'; when ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Properties)"})
  void testRemovePropertiesWithElDefProperties_whenViewElementDefinition() {
    // Arrange
    ViewElementDefinition elDef = new ViewElementDefinition();
    Properties properties = new Properties();

    // Act
    ViewUtil.removeProperties(elDef, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(View, Element)} with {@code view}, {@code element}.
   * <ul>
   *   <li>Given {@link ViewElementDefinition} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeProperties(View, Element)}
   */
  @Test
  @DisplayName("Test removeProperties(View, Element) with 'view', 'element'; given ViewElementDefinition (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewUtil.removeProperties(View, Element)"})
  void testRemovePropertiesWithViewElement_givenViewElementDefinition() {
    // Arrange
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());

    // Act
    ViewUtil.removeProperties(view, new Edge("Group"));

    // Assert
    verify(view).getElement(eq("Group"));
  }

  /**
   * Test {@link ViewUtil#removeProperties(View, Element)} with {@code view}, {@code element}.
   * <ul>
   *   <li>Then calls {@link ViewElementDefinition#getProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeProperties(View, Element)}
   */
  @Test
  @DisplayName("Test removeProperties(View, Element) with 'view', 'element'; then calls getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewUtil.removeProperties(View, Element)"})
  void testRemovePropertiesWithViewElement_thenCallsGetProperties() {
    // Arrange
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.isAllProperties()).thenReturn(false);
    when(globalViewElementDefinition.getProperties()).thenReturn(new HashSet<>());
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(globalViewElementDefinition);

    // Act
    ViewUtil.removeProperties(view, new Edge("Group"));

    // Assert
    verify(view).getElement(eq("Group"));
    verify(globalViewElementDefinition, atLeast(1)).getProperties();
    verify(globalViewElementDefinition).isAllProperties();
  }

  /**
   * Test {@link ViewUtil#removeProperties(View, Element)} with {@code view}, {@code element}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeProperties(View, Element)}
   */
  @Test
  @DisplayName("Test removeProperties(View, Element) with 'view', 'element'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ViewUtil.removeProperties(View, Element)"})
  void testRemovePropertiesWithViewElement_thenThrowIllegalArgumentException() {
    // Arrange
    GlobalViewElementDefinition globalViewElementDefinition = mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.isAllProperties()).thenThrow(new IllegalArgumentException("foo"));
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(globalViewElementDefinition);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ViewUtil.removeProperties(view, new Edge("Group")));
    verify(view).getElement(eq("Group"));
    verify(globalViewElementDefinition).isAllProperties();
  }

  /**
   * Test {@link ViewUtil#removeGroups(View, String[])}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link View} (default constructor) AllEntities is {@code true}.</li>
   *   <li>Then return {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeGroups(View, String[])}
   */
  @Test
  @DisplayName("Test removeGroups(View, String[]); given 'true'; when View (default constructor) AllEntities is 'true'; then return View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"View ViewUtil.removeGroups(View, String[])"})
  void testRemoveGroups_givenTrue_whenViewAllEntitiesIsTrue_thenReturnView() {
    // Arrange
    View view = new View();
    view.setAllEntities(true);

    // Act and Assert
    assertEquals(view, ViewUtil.removeGroups(view, "Groups"));
  }

  /**
   * Test {@link ViewUtil#removeGroups(View, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeGroups(View, String[])}
   */
  @Test
  @DisplayName("Test removeGroups(View, String[]); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"View ViewUtil.removeGroups(View, String[])"})
  void testRemoveGroups_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ViewUtil.removeGroups(null, null));
  }

  /**
   * Test {@link ViewUtil#removeGroups(View, String[])}.
   * <ul>
   *   <li>When {@link View} (default constructor).</li>
   *   <li>Then return {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeGroups(View, String[])}
   */
  @Test
  @DisplayName("Test removeGroups(View, String[]); when View (default constructor); then return View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"View ViewUtil.removeGroups(View, String[])"})
  void testRemoveGroups_whenView_thenReturnView() {
    // Arrange
    View view = new View();

    // Act and Assert
    assertEquals(view, ViewUtil.removeGroups(view, "Groups"));
  }

  /**
   * Test {@link ViewUtil#removeGroups(View, String[])}.
   * <ul>
   *   <li>When {@link View} (default constructor).</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ViewUtil#removeGroups(View, String[])}
   */
  @Test
  @DisplayName("Test removeGroups(View, String[]); when View (default constructor); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"View ViewUtil.removeGroups(View, String[])"})
  void testRemoveGroups_whenView_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ViewUtil.removeGroups(new View(), null));
  }
}
