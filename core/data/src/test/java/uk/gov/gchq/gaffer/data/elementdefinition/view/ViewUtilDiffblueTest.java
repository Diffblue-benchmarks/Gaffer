/*
 * Copyright 2026 Crown Copyright
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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Element)} with {@code elDef},
   * {@code element}.
   *
   * <ul>
   *   <li>Given {@code directed}.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Element)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(ViewElementDefinition, Element) with 'elDef', 'element'; given 'directed'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Element)"})
  void testRemovePropertiesWithElDefElement_givenDirected() {
    // Arrange
    GlobalViewElementDefinition elDef = mock(GlobalViewElementDefinition.class);
    when(elDef.isAllProperties()).thenReturn(false);
    when(elDef.getProperties()).thenReturn(new HashSet<>());

    Edge element = new Edge("Group");
    element.putProperty("directed", "Value");
    element.putProperty("Name", "Value");

    // Act
    ViewUtil.removeProperties(elDef, element);

    // Assert
    verify(elDef, atLeast(1)).getProperties();
    verify(elDef).isAllProperties();
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Element)} with {@code elDef},
   * {@code element}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link GlobalViewElementDefinition#getProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Element)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(ViewElementDefinition, Element) with 'elDef', 'element'; given 'false'; then calls getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Element)} with {@code elDef},
   * {@code element}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Element)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(ViewElementDefinition, Element) with 'elDef', 'element'; given 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Element)"})
  void testRemovePropertiesWithElDefElement_givenName() {
    // Arrange
    GlobalViewElementDefinition elDef = mock(GlobalViewElementDefinition.class);
    when(elDef.isAllProperties()).thenReturn(false);
    when(elDef.getProperties()).thenReturn(new HashSet<>());

    Edge element = new Edge("Group");
    element.putProperty("Name", "Value");

    // Act
    ViewUtil.removeProperties(elDef, element);

    // Assert
    verify(elDef, atLeast(1)).getProperties();
    verify(elDef).isAllProperties();
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Element)} with {@code elDef},
   * {@code element}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Properties Empty.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Element)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(ViewElementDefinition, Element) with 'elDef', 'element'; when 'null'; then Edge(String) with 'Group' Properties Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Element)} with {@code elDef},
   * {@code element}.
   *
   * <ul>
   *   <li>When {@link ViewElementDefinition} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Element)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(ViewElementDefinition, Element) with 'elDef', 'element'; when ViewElementDefinition (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)} with {@code elDef},
   * {@code properties}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then calls {@link GlobalViewElementDefinition#getProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(ViewElementDefinition, Properties) with 'elDef', 'properties'; given HashSet(); then calls getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)} with {@code elDef},
   * {@code properties}.
   *
   * <ul>
   *   <li>Given {@code java.util.Map}.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(ViewElementDefinition, Properties) with 'elDef', 'properties'; given 'java.util.Map'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Properties)"})
  void testRemovePropertiesWithElDefProperties_givenJavaUtilMap() {
    // Arrange
    GlobalViewElementDefinition elDef = mock(GlobalViewElementDefinition.class);
    when(elDef.isAllProperties()).thenReturn(false);
    when(elDef.getProperties()).thenReturn(new HashSet<>());

    Properties properties = new Properties();
    properties.put("java.util.Map", "Value");
    properties.put("Name", "Value");

    // Act
    ViewUtil.removeProperties(elDef, properties);

    // Assert
    verify(elDef, atLeast(1)).getProperties();
    verify(elDef).isAllProperties();
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)} with {@code elDef},
   * {@code properties}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Properties#Properties()} {@code Name} is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(ViewElementDefinition, Properties) with 'elDef', 'properties'; given 'Name'; when Properties() 'Name' is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Properties)"})
  void testRemovePropertiesWithElDefProperties_givenName_whenPropertiesNameIsValue() {
    // Arrange
    GlobalViewElementDefinition elDef = mock(GlobalViewElementDefinition.class);
    when(elDef.isAllProperties()).thenReturn(false);
    when(elDef.getProperties()).thenReturn(new HashSet<>());

    Properties properties = new Properties();
    properties.put("Name", "Value");

    // Act
    ViewUtil.removeProperties(elDef, properties);

    // Assert
    verify(elDef, atLeast(1)).getProperties();
    verify(elDef).isAllProperties();
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)} with {@code elDef},
   * {@code properties}.
   *
   * <ul>
   *   <li>Then {@link Properties#Properties()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(ViewElementDefinition, Properties) with 'elDef', 'properties'; then Properties() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(ViewElementDefinition, Properties)"})
  void testRemovePropertiesWithElDefProperties_thenPropertiesSizeIsOne() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    GlobalViewElementDefinition elDef = mock(GlobalViewElementDefinition.class);
    when(elDef.isAllProperties()).thenReturn(false);
    when(elDef.getProperties()).thenReturn(stringSet);

    Properties properties = new Properties();
    properties.putIfAbsent("foo", "42");

    // Act
    ViewUtil.removeProperties(elDef, properties);

    // Assert that nothing has changed
    verify(elDef, atLeast(1)).getProperties();
    verify(elDef).isAllProperties();
    assertEquals(1, properties.size());
    assertTrue(properties.containsKey("foo"));
  }

  /**
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)} with {@code elDef},
   * {@code properties}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link Properties#Properties()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(ViewElementDefinition, Properties) with 'elDef', 'properties'; when 'null'; then Properties() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)} with {@code elDef},
   * {@code properties}.
   *
   * <ul>
   *   <li>When {@link ViewElementDefinition} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(ViewElementDefinition, Properties)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(ViewElementDefinition, Properties) with 'elDef', 'properties'; when ViewElementDefinition (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(View, Element)}
   */
  @Test
  @DisplayName("Test removeProperties(View, Element) with 'view', 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(View, Element)"})
  void testRemovePropertiesWithViewElement() {
    // Arrange
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ViewUtil.removeProperties(view, new Edge("Group")));
    verify(view).getElement("Group");
  }

  /**
   * Test {@link ViewUtil#removeProperties(View, Element)} with {@code view}, {@code element}.
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(View, Element)}
   */
  @Test
  @DisplayName("Test removeProperties(View, Element) with 'view', 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(View, Element)"})
  void testRemovePropertiesWithViewElement2() {
    // Arrange
    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.isAllProperties()).thenThrow(new IllegalArgumentException());

    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(globalViewElementDefinition);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ViewUtil.removeProperties(view, new Edge("Group")));
    verify(view).getElement("Group");
    verify(globalViewElementDefinition).isAllProperties();
  }

  /**
   * Test {@link ViewUtil#removeProperties(View, Element)} with {@code view}, {@code element}.
   *
   * <ul>
   *   <li>Given {@code directed}.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(View, Element)}
   */
  @Test
  @DisplayName("Test removeProperties(View, Element) with 'view', 'element'; given 'directed'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(View, Element)"})
  void testRemovePropertiesWithViewElement_givenDirected() {
    // Arrange
    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.isAllProperties()).thenReturn(false);
    when(globalViewElementDefinition.getProperties()).thenReturn(new HashSet<>());

    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(globalViewElementDefinition);

    Edge element = new Edge("Group");
    element.putProperty("directed", "Value");

    // Act
    ViewUtil.removeProperties(view, element);

    // Assert
    verify(view).getElement("Group");
    verify(globalViewElementDefinition, atLeast(1)).getProperties();
    verify(globalViewElementDefinition).isAllProperties();
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(View, Element)} with {@code view}, {@code element}.
   *
   * <ul>
   *   <li>Given {@link Properties#Properties()} {@code java.util.Map} is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(View, Element)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(View, Element) with 'view', 'element'; given Properties() 'java.util.Map' is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(View, Element)"})
  void testRemovePropertiesWithViewElement_givenPropertiesJavaUtilMapIsValue() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("");
    stringSet.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.isAllProperties()).thenReturn(false);
    when(globalViewElementDefinition.getProperties()).thenReturn(stringSet);

    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(globalViewElementDefinition);

    Properties properties = new Properties();
    properties.put("java.util.Map", "Value");
    properties.putIfAbsent("foo", "42");

    Element element = mock(Element.class);
    when(element.getGroup()).thenReturn("Group");
    when(element.getProperties()).thenReturn(properties);

    // Act
    ViewUtil.removeProperties(view, element);

    // Assert
    verify(element).getGroup();
    verify(element).getProperties();
    verify(view).getElement("Group");
    verify(globalViewElementDefinition, atLeast(1)).getProperties();
    verify(globalViewElementDefinition).isAllProperties();
  }

  /**
   * Test {@link ViewUtil#removeProperties(View, Element)} with {@code view}, {@code element}.
   *
   * <ul>
   *   <li>Given {@link ViewElementDefinition} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(View, Element)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(View, Element) with 'view', 'element'; given ViewElementDefinition (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(View, Element)"})
  void testRemovePropertiesWithViewElement_givenViewElementDefinition() {
    // Arrange
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());
    Edge element = new Edge("Group");

    // Act
    ViewUtil.removeProperties(view, element);

    // Assert that nothing has changed
    verify(view).getElement("Group");
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(View, Element)} with {@code view}, {@code element}.
   *
   * <ul>
   *   <li>Then calls {@link GlobalViewElementDefinition#getProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(View, Element)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(View, Element) with 'view', 'element'; then calls getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(View, Element)"})
  void testRemovePropertiesWithViewElement_thenCallsGetProperties() {
    // Arrange
    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.isAllProperties()).thenReturn(false);
    when(globalViewElementDefinition.getProperties()).thenReturn(new HashSet<>());

    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(globalViewElementDefinition);
    Edge element = new Edge("Group");

    // Act
    ViewUtil.removeProperties(view, element);

    // Assert that nothing has changed
    verify(view).getElement("Group");
    verify(globalViewElementDefinition, atLeast(1)).getProperties();
    verify(globalViewElementDefinition).isAllProperties();
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(View, Element)} with {@code view}, {@code element}.
   *
   * <ul>
   *   <li>Then calls {@link Element#getProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(View, Element)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(View, Element) with 'view', 'element'; then calls getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(View, Element)"})
  void testRemovePropertiesWithViewElement_thenCallsGetProperties2() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("");
    stringSet.add("foo");

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.isAllProperties()).thenReturn(false);
    when(globalViewElementDefinition.getProperties()).thenReturn(stringSet);

    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(globalViewElementDefinition);

    Properties properties = new Properties();
    properties.putIfAbsent("foo", "42");

    Element element = mock(Element.class);
    when(element.getGroup()).thenReturn("Group");
    when(element.getProperties()).thenReturn(properties);

    // Act
    ViewUtil.removeProperties(view, element);

    // Assert
    verify(element).getGroup();
    verify(element).getProperties();
    verify(view).getElement("Group");
    verify(globalViewElementDefinition, atLeast(1)).getProperties();
    verify(globalViewElementDefinition).isAllProperties();
  }

  /**
   * Test {@link ViewUtil#removeProperties(View, Element)} with {@code view}, {@code element}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Properties Empty.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(View, Element)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(View, Element) with 'view', 'element'; when 'null'; then Edge(String) with 'Group' Properties Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(View, Element)"})
  void testRemovePropertiesWithViewElement_whenNull_thenEdgeWithGroupPropertiesEmpty() {
    // Arrange
    Edge element = new Edge("Group");

    // Act
    ViewUtil.removeProperties((View) null, element);

    // Assert that nothing has changed
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeProperties(View, Element)} with {@code view}, {@code element}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(View, Element)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(View, Element) with 'view', 'element'; when View (default constructor); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(View, Element)"})
  void testRemovePropertiesWithViewElement_whenView_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> ViewUtil.removeProperties(new View(), null));
  }

  /**
   * Test {@link ViewUtil#removeProperties(View, Element)} with {@code view}, {@code element}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Properties Empty.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeProperties(View, Element)}
   */
  @Test
  @DisplayName(
      "Test removeProperties(View, Element) with 'view', 'element'; when View (default constructor); then Edge(String) with 'Group' Properties Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewUtil.removeProperties(View, Element)"})
  void testRemovePropertiesWithViewElement_whenView_thenEdgeWithGroupPropertiesEmpty() {
    // Arrange
    View view = new View();
    Edge element = new Edge("Group");

    // Act
    ViewUtil.removeProperties(view, element);

    // Assert that nothing has changed
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ViewUtil#removeGroups(View, String[])}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link View} (default constructor) AllEntities is {@code true}.
   *   <li>Then return {@link View} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeGroups(View, String[])}
   */
  @Test
  @DisplayName(
      "Test removeGroups(View, String[]); given 'true'; when View (default constructor) AllEntities is 'true'; then return View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View ViewUtil.removeGroups(View, String[])"})
  void testRemoveGroups_givenTrue_whenViewAllEntitiesIsTrue_thenReturnView() {
    // Arrange
    View view = new View();
    view.setAllEntities(true);

    // Act
    View actualRemoveGroupsResult = ViewUtil.removeGroups(view, "Groups");

    // Assert
    assertEquals(view, actualRemoveGroupsResult);
  }

  /**
   * Test {@link ViewUtil#removeGroups(View, String[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeGroups(View, String[])}
   */
  @Test
  @DisplayName(
      "Test removeGroups(View, String[]); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View ViewUtil.removeGroups(View, String[])"})
  void testRemoveGroups_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ViewUtil.removeGroups(null, "Groups"));
  }

  /**
   * Test {@link ViewUtil#removeGroups(View, String[])}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then return {@link View} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeGroups(View, String[])}
   */
  @Test
  @DisplayName(
      "Test removeGroups(View, String[]); when View (default constructor); then return View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View ViewUtil.removeGroups(View, String[])"})
  void testRemoveGroups_whenView_thenReturnView() {
    // Arrange
    View view = new View();

    // Act
    View actualRemoveGroupsResult = ViewUtil.removeGroups(view, "Groups");

    // Assert
    assertEquals(view, actualRemoveGroupsResult);
  }

  /**
   * Test {@link ViewUtil#removeGroups(View, String[])}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ViewUtil#removeGroups(View, String[])}
   */
  @Test
  @DisplayName(
      "Test removeGroups(View, String[]); when View (default constructor); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"View ViewUtil.removeGroups(View, String[])"})
  void testRemoveGroups_whenView_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ViewUtil.removeGroups(new View(), null));
  }
}
