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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.theta.CompactSketch;
import org.apache.datasketches.theta.Union;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.exception.ConversionException;

class UnionConverterDiffblueTest {
  /**
   * Test {@link UnionConverter#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UnionConverter#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UnionConverter.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    UnionConverter unionConverter = new UnionConverter();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(unionConverter.canHandle(clazz));
  }

  /**
   * Test {@link UnionConverter#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Union}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UnionConverter#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'org.apache.datasketches.theta.Union'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UnionConverter.canHandle(Class)"})
  void testCanHandle_whenOrgApacheDatasketchesThetaUnion_thenReturnTrue() {
    // Arrange
    UnionConverter unionConverter = new UnionConverter();
    Class<Union> clazz = Union.class;

    // Act and Assert
    assertTrue(unionConverter.canHandle(clazz));
  }

  /**
   * Test {@link UnionConverter#convert(Object)}.
   *
   * <p>Method under test: {@link UnionConverter#convert(Object)}
   */
  @Test
  @DisplayName("Test convert(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double UnionConverter.convert(Object)"})
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
