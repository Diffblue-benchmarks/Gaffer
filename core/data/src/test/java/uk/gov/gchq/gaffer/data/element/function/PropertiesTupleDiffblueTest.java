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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Collection;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Properties;

class PropertiesTupleDiffblueTest {
  /**
   * Method under test: {@link PropertiesTuple#get(String)}
   */
  @Test
  void testGet() {
    // Arrange, Act and Assert
    assertNull((new PropertiesTuple()).get(PropertiesTuple.PROPERTIES));
    assertNull((new PropertiesTuple(new Properties())).get("Property Name"));
  }

  /**
   * Method under test: {@link PropertiesTuple#get(String)}
   */
  @Test
  void testGet2() {
    // Arrange
    Properties properties = new Properties();
    properties.computeIfPresent(PropertiesTuple.PROPERTIES, mock(BiFunction.class));

    // Act and Assert
    assertNull((new PropertiesTuple(properties)).get("Property Name"));
  }

  /**
   * Method under test: {@link PropertiesTuple#values()}
   */
  @Test
  void testValues() {
    // Arrange
    Properties properties = new Properties();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    Iterable<Object> actualValuesResult = (new PropertiesTuple(properties)).values();

    // Assert
    assertTrue(actualValuesResult instanceof Collection);
    assertFalse(actualValuesResult.iterator().hasNext());
    assertTrue(((Collection<Object>) actualValuesResult).isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesTuple#equals(Object)}
   *   <li>{@link PropertiesTuple#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PropertiesTuple propertiesTuple = new PropertiesTuple();
    PropertiesTuple propertiesTuple2 = new PropertiesTuple();

    // Act and Assert
    assertEquals(propertiesTuple, propertiesTuple2);
    int expectedHashCodeResult = propertiesTuple.hashCode();
    assertEquals(expectedHashCodeResult, propertiesTuple2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesTuple#equals(Object)}
   *   <li>{@link PropertiesTuple#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PropertiesTuple propertiesTuple = new PropertiesTuple();

    // Act and Assert
    assertEquals(propertiesTuple, propertiesTuple);
    int expectedHashCodeResult = propertiesTuple.hashCode();
    assertEquals(expectedHashCodeResult, propertiesTuple.hashCode());
  }

  /**
   * Method under test: {@link PropertiesTuple#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PropertiesTuple propertiesTuple = new PropertiesTuple();
    propertiesTuple.setProperties(new Properties());

    // Act and Assert
    assertNotEquals(propertiesTuple, new PropertiesTuple());
  }

  /**
   * Method under test: {@link PropertiesTuple#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Properties properties = new Properties();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    PropertiesTuple propertiesTuple = new PropertiesTuple();
    propertiesTuple.setProperties(properties);

    // Act and Assert
    assertNotEquals(propertiesTuple, new PropertiesTuple());
  }

  /**
   * Method under test: {@link PropertiesTuple#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PropertiesTuple(), null);
  }

  /**
   * Method under test: {@link PropertiesTuple#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PropertiesTuple(), "Different type to PropertiesTuple");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesTuple#PropertiesTuple()}
   *   <li>{@link PropertiesTuple#setProperties(Properties)}
   *   <li>{@link PropertiesTuple#getProperties()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PropertiesTuple actualPropertiesTuple = new PropertiesTuple();
    Properties properties = new Properties();
    actualPropertiesTuple.setProperties(properties);

    // Assert that nothing has changed
    assertSame(properties, actualPropertiesTuple.getProperties());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesTuple#PropertiesTuple(Properties)}
   *   <li>{@link PropertiesTuple#setProperties(Properties)}
   *   <li>{@link PropertiesTuple#getProperties()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    PropertiesTuple actualPropertiesTuple = new PropertiesTuple(new Properties());
    Properties properties = new Properties();
    actualPropertiesTuple.setProperties(properties);

    // Assert that nothing has changed
    assertSame(properties, actualPropertiesTuple.getProperties());
  }
}
