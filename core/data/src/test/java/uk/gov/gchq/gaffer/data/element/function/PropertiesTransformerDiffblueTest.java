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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Properties;

class PropertiesTransformerDiffblueTest {
  /**
   * Method under test: {@link PropertiesTransformer#apply(Properties)}
   */
  @Test
  void testApply() {
    // Arrange
    PropertiesTransformer propertiesTransformer = new PropertiesTransformer();
    Properties properties = new Properties();

    // Act
    Properties actualApplyResult = propertiesTransformer.apply(properties);

    // Assert
    assertTrue(actualApplyResult.isEmpty());
    assertSame(properties, actualApplyResult);
  }

  /**
   * Method under test: {@link PropertiesTransformer#apply(Properties)}
   */
  @Test
  void testApply2() {
    // Arrange
    PropertiesTransformer propertiesTransformer = new PropertiesTransformer();

    Properties properties = new Properties();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    Properties actualApplyResult = propertiesTransformer.apply(properties);

    // Assert
    assertTrue(actualApplyResult.isEmpty());
    assertSame(properties, actualApplyResult);
  }

  /**
   * Method under test: {@link PropertiesTransformer.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue((new PropertiesTransformer.Builder()).build().getComponents().isEmpty());
  }

  /**
   * Method under test: {@link PropertiesTransformer.Builder#execute(Function)}
   */
  @Test
  void testBuilderExecute() {
    // Arrange, Act and Assert
    assertTrue((new PropertiesTransformer.Builder()).execute(mock(Function.class)).build().getComponents().isEmpty());
  }

  /**
   * Method under test: {@link PropertiesTransformer.Builder#Builder()}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    assertTrue((new PropertiesTransformer.Builder()).build().getComponents().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesTransformer#equals(Object)}
   *   <li>{@link PropertiesTransformer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PropertiesTransformer propertiesTransformer = new PropertiesTransformer();
    PropertiesTransformer propertiesTransformer2 = new PropertiesTransformer();

    // Act and Assert
    assertEquals(propertiesTransformer, propertiesTransformer2);
    int expectedHashCodeResult = propertiesTransformer.hashCode();
    assertEquals(expectedHashCodeResult, propertiesTransformer2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesTransformer#equals(Object)}
   *   <li>{@link PropertiesTransformer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PropertiesTransformer propertiesTransformer = new PropertiesTransformer();

    // Act and Assert
    assertEquals(propertiesTransformer, propertiesTransformer);
    int expectedHashCodeResult = propertiesTransformer.hashCode();
    assertEquals(expectedHashCodeResult, propertiesTransformer.hashCode());
  }

  /**
   * Method under test: {@link PropertiesTransformer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PropertiesTransformer propertiesTransformer = new PropertiesTransformer();

    // Act and Assert
    assertNotEquals(propertiesTransformer, new ElementAggregator());
  }

  /**
   * Method under test: {@link PropertiesTransformer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new PropertiesTransformer(), mock(ElementAggregator.class));
  }

  /**
   * Method under test: {@link PropertiesTransformer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PropertiesTransformer(), null);
  }

  /**
   * Method under test: {@link PropertiesTransformer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PropertiesTransformer(), "Different type to PropertiesTransformer");
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PropertiesTransformer}
   */
  @Test
  void testNewPropertiesTransformer() {
    // Arrange, Act and Assert
    assertTrue((new PropertiesTransformer()).getComponents().isEmpty());
  }
}
