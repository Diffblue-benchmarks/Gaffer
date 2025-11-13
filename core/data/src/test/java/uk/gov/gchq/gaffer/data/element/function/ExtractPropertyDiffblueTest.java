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

package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.LazyEntity;
import uk.gov.gchq.gaffer.data.element.LazyProperties;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class ExtractPropertyDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractProperty#ExtractProperty()}
   *   <li>{@link ExtractProperty#setName(String)}
   *   <li>{@link ExtractProperty#toString()}
   *   <li>{@link ExtractProperty#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExtractProperty.<init>()", "void ExtractProperty.<init>(String)",
      "String ExtractProperty.getName()", "void ExtractProperty.setName(String)", "String ExtractProperty.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ExtractProperty actualExtractProperty = new ExtractProperty();
    actualExtractProperty.setName("Name");
    actualExtractProperty.toString();

    // Assert
    assertEquals("Name", actualExtractProperty.getName());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractProperty#ExtractProperty(String)}
   *   <li>{@link ExtractProperty#setName(String)}
   *   <li>{@link ExtractProperty#toString()}
   *   <li>{@link ExtractProperty#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExtractProperty.<init>()", "void ExtractProperty.<init>(String)",
      "String ExtractProperty.getName()", "void ExtractProperty.setName(String)", "String ExtractProperty.toString()"})
  void testGettersAndSetters_whenName() {
    // Arrange and Act
    ExtractProperty actualExtractProperty = new ExtractProperty("Name");
    actualExtractProperty.setName("Name");
    actualExtractProperty.toString();

    // Assert
    assertEquals("Name", actualExtractProperty.getName());
  }

  /**
   * Test {@link ExtractProperty#apply(Element)} with {@code Element}.
   * <p>
   * Method under test: {@link ExtractProperty#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExtractProperty.apply(Element)"})
  void testApplyWithElement() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("Name");
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any())).thenReturn("Property");
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    LazyEdge element = new LazyEdge(edge, valueLoader);

    // Act
    extractProperty.apply(element);

    // Assert
    verify(valueLoader).getProperty(eq("Name"), isA(Properties.class));
    Properties properties = element.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Property", properties.get("Name"));
    LazyProperties properties2 = element.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Property", properties2.get((Object) "Name"));
  }

  /**
   * Test {@link ExtractProperty#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@link ExtractProperty#ExtractProperty(String)} with {@code Name}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractProperty#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; given ExtractProperty(String) with 'Name'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExtractProperty.apply(Element)"})
  void testApplyWithElement_givenExtractPropertyWithName_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ExtractProperty("Name")).apply(null));
  }

  /**
   * Test {@link ExtractProperty#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@link ExtractProperty#ExtractProperty()}.</li>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractProperty#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; given ExtractProperty(); then return 'Property'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExtractProperty.apply(Element)"})
  void testApplyWithElement_givenExtractProperty_thenReturnProperty() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty();
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any())).thenReturn("Property");
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    LazyEdge element = new LazyEdge(edge, valueLoader);

    // Act
    Object actualApplyResult = extractProperty.apply(element);

    // Assert
    verify(valueLoader).getProperty(isNull(), isA(Properties.class));
    assertEquals("Property", actualApplyResult);
    assertTrue(element.getElement().getProperties().isEmpty());
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ExtractProperty#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractProperty#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; given 'Name'; then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExtractProperty.apply(Element)"})
  void testApplyWithElement_givenName_thenReturnValue() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("Name");
    Entity entity = (new Entity.Builder()).group("Group").vertex(2).build();

    LazyEntity element = new LazyEntity(entity, mock(ElementValueLoader.class));
    element.putProperty("Name", "Value");

    // Act and Assert
    assertEquals("Value", extractProperty.apply(element));
  }

  /**
   * Test {@link ExtractProperty#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractProperty#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; when Edge(String) with 'Group'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExtractProperty.apply(Element)"})
  void testApplyWithElement_whenEdgeWithGroup_thenReturnNull() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("Name");

    // Act and Assert
    assertNull(extractProperty.apply(new Edge("Group")));
  }

  /**
   * Test {@link ExtractProperty#equals(Object)}, and {@link ExtractProperty#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractProperty#equals(Object)}
   *   <li>{@link ExtractProperty#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExtractProperty.equals(Object)", "int ExtractProperty.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("Name");
    ExtractProperty extractProperty2 = new ExtractProperty("Name");

    // Act and Assert
    assertEquals(extractProperty, extractProperty2);
    int expectedHashCodeResult = extractProperty.hashCode();
    assertEquals(expectedHashCodeResult, extractProperty2.hashCode());
  }

  /**
   * Test {@link ExtractProperty#equals(Object)}, and {@link ExtractProperty#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractProperty#equals(Object)}
   *   <li>{@link ExtractProperty#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExtractProperty.equals(Object)", "int ExtractProperty.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("Name");

    // Act and Assert
    assertEquals(extractProperty, extractProperty);
    int expectedHashCodeResult = extractProperty.hashCode();
    assertEquals(expectedHashCodeResult, extractProperty.hashCode());
  }

  /**
   * Test {@link ExtractProperty#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExtractProperty.equals(Object)", "int ExtractProperty.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExtractProperty extractProperty = new ExtractProperty("uk.gov.gchq.gaffer.data.element.function.ExtractProperty");

    // Act and Assert
    assertNotEquals(extractProperty, new ExtractProperty("Name"));
  }

  /**
   * Test {@link ExtractProperty#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExtractProperty.equals(Object)", "int ExtractProperty.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExtractProperty("Name"), null);
  }

  /**
   * Test {@link ExtractProperty#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExtractProperty.equals(Object)", "int ExtractProperty.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExtractProperty("Name"), "Different type to ExtractProperty");
  }
}
