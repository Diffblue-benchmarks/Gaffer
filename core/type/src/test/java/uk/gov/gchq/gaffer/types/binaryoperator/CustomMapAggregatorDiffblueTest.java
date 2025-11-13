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

package uk.gov.gchq.gaffer.types.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.types.CustomMap;

class CustomMapAggregatorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomMapAggregator#CustomMapAggregator()}
   *   <li>{@link CustomMapAggregator#setBinaryOperator(BinaryOperator)}
   *   <li>{@link CustomMapAggregator#getBinaryOperator()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomMapAggregator.<init>()", "BinaryOperator CustomMapAggregator.getBinaryOperator()",
      "void CustomMapAggregator.setBinaryOperator(BinaryOperator)"})
  void testGettersAndSetters() {
    // Arrange and Act
    CustomMapAggregator<Object, Object> actualCustomMapAggregator = new CustomMapAggregator<>();
    BinaryOperator<Object> binaryOperator = mock(BinaryOperator.class);
    actualCustomMapAggregator.setBinaryOperator(binaryOperator);

    // Assert
    assertSame(binaryOperator, actualCustomMapAggregator.getBinaryOperator());
  }

  /**
   * Test {@link CustomMapAggregator#CustomMapAggregator(BinaryOperator)}.
   * <p>
   * Method under test: {@link CustomMapAggregator#CustomMapAggregator(BinaryOperator)}
   */
  @Test
  @DisplayName("Test new CustomMapAggregator(BinaryOperator)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomMapAggregator.<init>(BinaryOperator)"})
  void testNewCustomMapAggregator() {
    // Arrange
    BinaryOperator<Object> binaryOperator = mock(BinaryOperator.class);

    // Act
    CustomMapAggregator<Object, Object> actualCustomMapAggregator = new CustomMapAggregator<>(binaryOperator);

    // Assert
    assertSame(binaryOperator, actualCustomMapAggregator.getBinaryOperator());
  }

  /**
   * Test {@link CustomMapAggregator#_apply(CustomMap, CustomMap)} with {@code CustomMap}, {@code CustomMap}.
   * <p>
   * Method under test: {@link CustomMapAggregator#_apply(CustomMap, CustomMap)}
   */
  @Test
  @DisplayName("Test _apply(CustomMap, CustomMap) with 'CustomMap', 'CustomMap'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CustomMap CustomMapAggregator._apply(CustomMap, CustomMap)"})
  void test_applyWithCustomMapCustomMap() {
    // Arrange
    CustomMapAggregator<Object, Object> customMapAggregator = new CustomMapAggregator<>();
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> state = new CustomMap<>(keySerialiser, new AvroSerialiser());

    AvroSerialiser keySerialiser2 = new AvroSerialiser();

    // Act
    CustomMap<Object, Object> actual_applyResult = customMapAggregator._apply(state,
        new CustomMap<>(keySerialiser2, new AvroSerialiser()));

    // Assert
    assertTrue(actual_applyResult.getValueSerialiser() instanceof AvroSerialiser);
    assertEquals(0, state.size());
    assertEquals(0, actual_applyResult.size());
    assertTrue(actual_applyResult.getMap().isEmpty());
    assertTrue(state.getJsonStorage().isEmpty());
    assertTrue(actual_applyResult.getJsonStorage().isEmpty());
    assertTrue(state.isEmpty());
    assertTrue(actual_applyResult.isEmpty());
  }

  /**
   * Test {@link CustomMapAggregator#_apply(CustomMap, CustomMap)} with {@code CustomMap}, {@code CustomMap}.
   * <ul>
   *   <li>Then return Map size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomMapAggregator#_apply(CustomMap, CustomMap)}
   */
  @Test
  @DisplayName("Test _apply(CustomMap, CustomMap) with 'CustomMap', 'CustomMap'; then return Map size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CustomMap CustomMapAggregator._apply(CustomMap, CustomMap)"})
  void test_applyWithCustomMapCustomMap_thenReturnMapSizeIsOne() {
    // Arrange
    BinaryOperator<Object> binaryOperator = mock(BinaryOperator.class);
    when(binaryOperator.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn("Apply");
    CustomMapAggregator<Object, Object> customMapAggregator = new CustomMapAggregator<>(binaryOperator);
    AvroSerialiser keySerialiser = new AvroSerialiser();
    CustomMap<Object, Object> state = new CustomMap<>(keySerialiser, new AvroSerialiser());

    AvroSerialiser keySerialiser2 = new AvroSerialiser();

    CustomMap<Object, Object> input = new CustomMap<>(keySerialiser2, new AvroSerialiser());
    input.put("Key", "Value");

    // Act
    CustomMap<Object, Object> actual_applyResult = customMapAggregator._apply(state, input);

    // Assert
    verify(binaryOperator).apply(isNull(), isA(Object.class));
    assertTrue(actual_applyResult.getValueSerialiser() instanceof AvroSerialiser);
    HashMap<Object, Object> map = actual_applyResult.getMap();
    assertEquals(1, map.size());
    assertEquals("Apply", map.get("Key"));
    assertEquals(1, state.getJsonStorage().size());
    assertEquals(1, actual_applyResult.getJsonStorage().size());
    assertEquals(1, state.size());
    assertEquals(1, actual_applyResult.size());
    assertFalse(state.isEmpty());
    assertFalse(actual_applyResult.isEmpty());
  }
}
