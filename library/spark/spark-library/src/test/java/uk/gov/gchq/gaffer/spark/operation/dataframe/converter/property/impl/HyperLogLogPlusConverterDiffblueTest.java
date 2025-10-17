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

package uk.gov.gchq.gaffer.spark.operation.dataframe.converter.property.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.exception.ConversionException;

class HyperLogLogPlusConverterDiffblueTest {
  /**
   * Test {@link HyperLogLogPlusConverter#canHandle(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusConverter#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HyperLogLogPlusConverter.canHandle(Class)"})
  void testCanHandle_thenReturnTrue() {
    // Arrange
    HyperLogLogPlusConverter hyperLogLogPlusConverter = new HyperLogLogPlusConverter();
    Class<HyperLogLogPlus> clazz = HyperLogLogPlus.class;

    // Act and Assert
    assertTrue(hyperLogLogPlusConverter.canHandle(clazz));
  }

  /**
   * Test {@link HyperLogLogPlusConverter#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusConverter#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HyperLogLogPlusConverter.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    HyperLogLogPlusConverter hyperLogLogPlusConverter = new HyperLogLogPlusConverter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(hyperLogLogPlusConverter.canHandle(clazz));
  }

  /**
   * Test {@link HyperLogLogPlusConverter#convert(Object)}.
   *
   * <ul>
   *   <li>Given four.
   *   <li>Then return longValue is four.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusConverter#convert(Object)}
   */
  @Test
  @DisplayName("Test convert(Object); given four; then return longValue is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long HyperLogLogPlusConverter.convert(Object)"})
  void testConvert_givenFour_thenReturnLongValueIsFour() throws ConversionException {
    // Arrange
    HyperLogLogPlusConverter hyperLogLogPlusConverter = new HyperLogLogPlusConverter();

    HyperLogLogPlus hyperLogLogPlus = mock(HyperLogLogPlus.class);
    when(hyperLogLogPlus.cardinality()).thenReturn(4L);

    // Act
    Long actualConvertResult = hyperLogLogPlusConverter.convert(hyperLogLogPlus);

    // Assert
    verify(hyperLogLogPlus).cardinality();
    assertEquals(4L, actualConvertResult.longValue());
  }
}
