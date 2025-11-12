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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.LongType$;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.exception.ConversionException;

class HyperLogLogPlusConverterDiffblueTest {
  /**
   * Method under test: {@link HyperLogLogPlusConverter#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    HyperLogLogPlusConverter hyperLogLogPlusConverter = new HyperLogLogPlusConverter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(hyperLogLogPlusConverter.canHandle(clazz));
  }

  /**
   * Method under test: {@link HyperLogLogPlusConverter#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    HyperLogLogPlusConverter hyperLogLogPlusConverter = new HyperLogLogPlusConverter();
    Class<HyperLogLogPlus> clazz = HyperLogLogPlus.class;

    // Act and Assert
    assertTrue(hyperLogLogPlusConverter.canHandle(clazz));
  }

  /**
   * Method under test: {@link HyperLogLogPlusConverter#convertedType()}
   */
  @Test
  void testConvertedType() {
    // Arrange and Act
    DataType actualConvertedTypeResult = (new HyperLogLogPlusConverter()).convertedType();

    // Assert
    assertSame(((LongType$) actualConvertedTypeResult).MODULE$, actualConvertedTypeResult);
  }

  /**
   * Method under test: {@link HyperLogLogPlusConverter#convert(Object)}
   */
  @Test
  void testConvert() throws ConversionException {
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
