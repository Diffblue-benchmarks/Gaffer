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

package uk.gov.gchq.gaffer.spark.operation.dataframe.converter.property.impl.datasketches.theta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.datasketches.theta.CompactSketch;
import org.apache.datasketches.theta.Union;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DoubleType$;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.exception.ConversionException;

class UnionConverterDiffblueTest {
  /**
   * Method under test: {@link UnionConverter#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    UnionConverter unionConverter = new UnionConverter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(unionConverter.canHandle(clazz));
  }

  /**
   * Method under test: {@link UnionConverter#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    UnionConverter unionConverter = new UnionConverter();
    Class<Union> clazz = Union.class;

    // Act and Assert
    assertTrue(unionConverter.canHandle(clazz));
  }

  /**
   * Method under test: {@link UnionConverter#convertedType()}
   */
  @Test
  void testConvertedType() {
    // Arrange and Act
    DataType actualConvertedTypeResult = (new UnionConverter()).convertedType();

    // Assert
    assertSame(((DoubleType$) actualConvertedTypeResult).MODULE$, actualConvertedTypeResult);
  }

  /**
   * Method under test: {@link UnionConverter#convert(Object)}
   */
  @Test
  void testConvert() throws ConversionException {
    // Arrange
    UnionConverter unionConverter = new UnionConverter();
    CompactSketch compactSketch = mock(CompactSketch.class);
    when(compactSketch.getEstimate()).thenReturn(10.0d);
    Union union = mock(Union.class);
    when(union.getResult()).thenReturn(compactSketch);

    // Act
    Double actualConvertResult = unionConverter.convert(union);

    // Assert
    verify(compactSketch).getEstimate();
    verify(union).getResult();
    assertEquals(10.0d, actualConvertResult.doubleValue());
  }
}
