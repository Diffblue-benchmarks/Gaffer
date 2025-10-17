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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.MapType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import scala.math.Integral;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.api.TypeTags;
import scala.reflect.api.TypeTags.TypeTagImpl;
import uk.gov.gchq.gaffer.types.FreqMap;

class FreqMapConverterDiffblueTest {
  /**
   * Test {@link FreqMapConverter#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapConverter#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FreqMapConverter.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    FreqMapConverter freqMapConverter = new FreqMapConverter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(freqMapConverter.canHandle(clazz));
  }

  /**
   * Test {@link FreqMapConverter#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code FreqMap}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapConverter#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'uk.gov.gchq.gaffer.types.FreqMap'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FreqMapConverter.canHandle(Class)"})
  void testCanHandle_whenUkGovGchqGafferTypesFreqMap_thenReturnTrue() {
    // Arrange
    FreqMapConverter freqMapConverter = new FreqMapConverter();
    Class<FreqMap> clazz = FreqMap.class;

    // Act and Assert
    assertTrue(freqMapConverter.canHandle(clazz));
  }

  /**
   * Test {@link FreqMapConverter#convertedType()}.
   *
   * <p>Method under test: {@link FreqMapConverter#convertedType()}
   */
  @Test
  @DisplayName("Test convertedType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataType FreqMapConverter.convertedType()"})
  void testConvertedType() {
    // Arrange and Act
    DataType actualConvertedTypeResult = new FreqMapConverter().convertedType();

    // Assert
    DataType copy$default$2Result = ((MapType) actualConvertedTypeResult).copy$default$2();
    assertTrue(copy$default$2Result instanceof org.apache.spark.sql.types.LongType$);
    assertTrue(actualConvertedTypeResult instanceof MapType);
    DataType copy$default$1Result = ((MapType) actualConvertedTypeResult).copy$default$1();
    assertTrue(copy$default$1Result instanceof org.apache.spark.sql.types.StringType$);
    Integral<Object> integralResult =
        ((org.apache.spark.sql.types.LongType$) copy$default$2Result).integral();
    assertTrue(integralResult instanceof Numeric.LongIsIntegral$);
    assertTrue(
        ((org.apache.spark.sql.types.LongType$) copy$default$2Result).ordering()
            instanceof Ordering.Long$);
    assertTrue(
        ((org.apache.spark.sql.types.LongType$) copy$default$2Result).tag() instanceof TypeTagImpl);
    assertTrue(
        ((org.apache.spark.sql.types.StringType$) copy$default$1Result).tag()
            instanceof TypeTagImpl);
    assertTrue(((MapType) actualConvertedTypeResult).copy$default$3());
    assertTrue(((MapType) actualConvertedTypeResult).valueContainsNull());
    assertSame(copy$default$2Result, ((MapType) actualConvertedTypeResult).valueType());
    assertSame(copy$default$1Result, ((MapType) actualConvertedTypeResult).keyType());
    assertSame(
        integralResult, ((org.apache.spark.sql.types.LongType$) copy$default$2Result).numeric());
  }
}
