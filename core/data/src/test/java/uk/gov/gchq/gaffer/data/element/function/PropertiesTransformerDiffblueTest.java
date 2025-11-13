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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.function.PropertiesTransformer.Builder;

class PropertiesTransformerDiffblueTest {
  /**
   * Test {@link PropertiesTransformer#apply(Properties)} with {@code properties}.
   * <ul>
   *   <li>Given {@link PropertiesTransformer} (default constructor).</li>
   *   <li>Then return {@link Properties#Properties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesTransformer#apply(Properties)}
   */
  @Test
  @DisplayName("Test apply(Properties) with 'properties'; given PropertiesTransformer (default constructor); then return Properties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Properties PropertiesTransformer.apply(Properties)"})
  void testApplyWithProperties_givenPropertiesTransformer_thenReturnProperties() {
    // Arrange
    PropertiesTransformer propertiesTransformer = new PropertiesTransformer();
    Properties properties = new Properties();

    // Act and Assert
    assertSame(properties, propertiesTransformer.apply(properties));
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertiesTransformer Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue((new Builder()).build().getComponents().isEmpty());
  }

  /**
   * Test Builder {@link Builder#execute(Function)}.
   * <p>
   * Method under test: {@link Builder#execute(Function)}
   */
  @Test
  @DisplayName("Test Builder execute(Function)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertiesTransformer.ExecutedBuilder Builder.execute(Function)"})
  void testBuilderExecute() {
    // Arrange, Act and Assert
    assertTrue((new Builder()).execute(mock(Function.class)).build().getComponents().isEmpty());
  }

  /**
   * Test Builder {@link Builder#Builder()}.
   * <p>
   * Method under test: {@link Builder#Builder()}
   */
  @Test
  @DisplayName("Test Builder new Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    assertTrue((new Builder()).build().getComponents().isEmpty());
  }

  /**
   * Test {@link PropertiesTransformer#equals(Object)}, and {@link PropertiesTransformer#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesTransformer#equals(Object)}
   *   <li>{@link PropertiesTransformer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesTransformer.equals(Object)", "int PropertiesTransformer.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PropertiesTransformer buildResult = (new Builder()).build();
    PropertiesTransformer buildResult2 = (new Builder()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link PropertiesTransformer#equals(Object)}, and {@link PropertiesTransformer#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertiesTransformer#equals(Object)}
   *   <li>{@link PropertiesTransformer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesTransformer.equals(Object)", "int PropertiesTransformer.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PropertiesTransformer buildResult = (new Builder()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link PropertiesTransformer#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesTransformer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesTransformer.equals(Object)", "int PropertiesTransformer.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PropertiesTransformer buildResult = (new Builder()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link PropertiesTransformer#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesTransformer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesTransformer.equals(Object)", "int PropertiesTransformer.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PropertiesTransformer buildResult = (new Builder()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to PropertiesTransformer");
  }

  /**
   * Test new {@link PropertiesTransformer} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PropertiesTransformer}
   */
  @Test
  @DisplayName("Test new PropertiesTransformer (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PropertiesTransformer.<init>()"})
  void testNewPropertiesTransformer() {
    // Arrange, Act and Assert
    assertTrue((new PropertiesTransformer()).getComponents().isEmpty());
  }

  /**
   * Test {@link PropertiesTransformer#toString()}.
   * <p>
   * Method under test: {@link PropertiesTransformer#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PropertiesTransformer.toString()"})
  void testToString() {
    // Arrange
    PropertiesTransformer buildResult = (new Builder()).build();

    // Act and Assert
    assertEquals("PropertiesTransformer[propertiesTuple=PropertiesTuple[]]", buildResult.toString());
  }
}
