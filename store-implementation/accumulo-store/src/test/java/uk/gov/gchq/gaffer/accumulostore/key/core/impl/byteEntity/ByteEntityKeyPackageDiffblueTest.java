/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyBloomFunctor;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ByteEntityKeyPackageDiffblueTest {
  /**
   * Test {@link ByteEntityKeyPackage#ByteEntityKeyPackage()}.
   *
   * <p>Method under test: {@link ByteEntityKeyPackage#ByteEntityKeyPackage()}
   */
  @Test
  @DisplayName("Test new ByteEntityKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityKeyPackage.<init>()"})
  void testNewByteEntityKeyPackage() {
    // Arrange and Act
    ByteEntityKeyPackage actualByteEntityKeyPackage = new ByteEntityKeyPackage();

    // Assert
    assertTrue(actualByteEntityKeyPackage.getKeyFunctor() instanceof CoreKeyBloomFunctor);
    assertTrue(
        actualByteEntityKeyPackage.getIteratorFactory()
            instanceof ByteEntityIteratorSettingsFactory);
    assertNull(actualByteEntityKeyPackage.getKeyConverter());
    assertNull(actualByteEntityKeyPackage.getRangeFactory());
  }

  /**
   * Test {@link ByteEntityKeyPackage#ByteEntityKeyPackage(Schema)}.
   *
   * <ul>
   *   <li>Given {@code timestampProperty}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityKeyPackage#ByteEntityKeyPackage(Schema)}
   */
  @Test
  @DisplayName("Test new ByteEntityKeyPackage(Schema); given 'timestampProperty'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityKeyPackage.<init>(Schema)"})
  void testNewByteEntityKeyPackage_givenTimestampProperty() {
    // Arrange
    Schema schema = new Schema();
    schema.addConfig("timestampProperty", "Schema");

    // Act
    ByteEntityKeyPackage actualByteEntityKeyPackage = new ByteEntityKeyPackage(schema);

    // Assert
    assertTrue(actualByteEntityKeyPackage.getKeyFunctor() instanceof CoreKeyBloomFunctor);
    assertTrue(
        actualByteEntityKeyPackage.getKeyConverter() instanceof ByteEntityAccumuloElementConverter);
    assertTrue(
        actualByteEntityKeyPackage.getIteratorFactory()
            instanceof ByteEntityIteratorSettingsFactory);
    assertTrue(actualByteEntityKeyPackage.getRangeFactory() instanceof ByteEntityRangeFactory);
  }

  /**
   * Test {@link ByteEntityKeyPackage#ByteEntityKeyPackage(Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then KeyFunctor return {@link CoreKeyBloomFunctor}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityKeyPackage#ByteEntityKeyPackage(Schema)}
   */
  @Test
  @DisplayName(
      "Test new ByteEntityKeyPackage(Schema); when 'null'; then KeyFunctor return CoreKeyBloomFunctor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityKeyPackage.<init>(Schema)"})
  void testNewByteEntityKeyPackage_whenNull_thenKeyFunctorReturnCoreKeyBloomFunctor() {
    // Arrange and Act
    ByteEntityKeyPackage actualByteEntityKeyPackage = new ByteEntityKeyPackage(null);

    // Assert
    assertTrue(actualByteEntityKeyPackage.getKeyFunctor() instanceof CoreKeyBloomFunctor);
    assertTrue(
        actualByteEntityKeyPackage.getKeyConverter() instanceof ByteEntityAccumuloElementConverter);
    assertTrue(
        actualByteEntityKeyPackage.getIteratorFactory()
            instanceof ByteEntityIteratorSettingsFactory);
    assertTrue(actualByteEntityKeyPackage.getRangeFactory() instanceof ByteEntityRangeFactory);
  }

  /**
   * Test {@link ByteEntityKeyPackage#ByteEntityKeyPackage(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then KeyFunctor return {@link CoreKeyBloomFunctor}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityKeyPackage#ByteEntityKeyPackage(Schema)}
   */
  @Test
  @DisplayName(
      "Test new ByteEntityKeyPackage(Schema); when Schema(); then KeyFunctor return CoreKeyBloomFunctor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityKeyPackage.<init>(Schema)"})
  void testNewByteEntityKeyPackage_whenSchema_thenKeyFunctorReturnCoreKeyBloomFunctor() {
    // Arrange and Act
    ByteEntityKeyPackage actualByteEntityKeyPackage = new ByteEntityKeyPackage(new Schema());

    // Assert
    assertTrue(actualByteEntityKeyPackage.getKeyFunctor() instanceof CoreKeyBloomFunctor);
    assertTrue(
        actualByteEntityKeyPackage.getKeyConverter() instanceof ByteEntityAccumuloElementConverter);
    assertTrue(
        actualByteEntityKeyPackage.getIteratorFactory()
            instanceof ByteEntityIteratorSettingsFactory);
    assertTrue(actualByteEntityKeyPackage.getRangeFactory() instanceof ByteEntityRangeFactory);
  }

  /**
   * Test {@link ByteEntityKeyPackage#setSchema(Schema)}.
   *
   * <ul>
   *   <li>Given {@code timestampProperty}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityKeyPackage#setSchema(Schema)}
   */
  @Test
  @DisplayName("Test setSchema(Schema); given 'timestampProperty'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityKeyPackage.setSchema(Schema)"})
  void testSetSchema_givenTimestampProperty() {
    // Arrange
    ByteEntityKeyPackage byteEntityKeyPackage = new ByteEntityKeyPackage();

    Schema schema = new Schema();
    schema.addConfig("timestampProperty", "Schema");

    // Act
    byteEntityKeyPackage.setSchema(schema);

    // Assert
    assertTrue(
        byteEntityKeyPackage.getKeyConverter() instanceof ByteEntityAccumuloElementConverter);
    assertTrue(byteEntityKeyPackage.getRangeFactory() instanceof ByteEntityRangeFactory);
  }

  /**
   * Test {@link ByteEntityKeyPackage#setSchema(Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityKeyPackage#setSchema(Schema)}
   */
  @Test
  @DisplayName("Test setSchema(Schema); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityKeyPackage.setSchema(Schema)"})
  void testSetSchema_whenNull() {
    // Arrange
    ByteEntityKeyPackage byteEntityKeyPackage = new ByteEntityKeyPackage();

    // Act
    byteEntityKeyPackage.setSchema(null);

    // Assert
    assertTrue(
        byteEntityKeyPackage.getKeyConverter() instanceof ByteEntityAccumuloElementConverter);
    assertTrue(byteEntityKeyPackage.getRangeFactory() instanceof ByteEntityRangeFactory);
  }

  /**
   * Test {@link ByteEntityKeyPackage#setSchema(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityKeyPackage#setSchema(Schema)}
   */
  @Test
  @DisplayName("Test setSchema(Schema); when Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityKeyPackage.setSchema(Schema)"})
  void testSetSchema_whenSchema() {
    // Arrange
    ByteEntityKeyPackage byteEntityKeyPackage = new ByteEntityKeyPackage();

    // Act
    byteEntityKeyPackage.setSchema(new Schema());

    // Assert
    assertTrue(
        byteEntityKeyPackage.getKeyConverter() instanceof ByteEntityAccumuloElementConverter);
    assertTrue(byteEntityKeyPackage.getRangeFactory() instanceof ByteEntityRangeFactory);
  }
}
