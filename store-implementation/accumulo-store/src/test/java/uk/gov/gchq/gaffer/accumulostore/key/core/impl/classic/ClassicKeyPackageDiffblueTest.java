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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyBloomFunctor;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ClassicKeyPackageDiffblueTest {
  /**
   * Test {@link ClassicKeyPackage#ClassicKeyPackage()}.
   *
   * <p>Method under test: {@link ClassicKeyPackage#ClassicKeyPackage()}
   */
  @Test
  @DisplayName("Test new ClassicKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassicKeyPackage.<init>()"})
  void testNewClassicKeyPackage() {
    // Arrange and Act
    ClassicKeyPackage actualClassicKeyPackage = new ClassicKeyPackage();

    // Assert
    assertTrue(actualClassicKeyPackage.getKeyFunctor() instanceof CoreKeyBloomFunctor);
    assertTrue(
        actualClassicKeyPackage.getIteratorFactory() instanceof ClassicIteratorSettingsFactory);
    assertNull(actualClassicKeyPackage.getKeyConverter());
    assertNull(actualClassicKeyPackage.getRangeFactory());
  }

  /**
   * Test {@link ClassicKeyPackage#ClassicKeyPackage(Schema)}.
   *
   * <ul>
   *   <li>Given {@code timestampProperty}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicKeyPackage#ClassicKeyPackage(Schema)}
   */
  @Test
  @DisplayName("Test new ClassicKeyPackage(Schema); given 'timestampProperty'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassicKeyPackage.<init>(Schema)"})
  void testNewClassicKeyPackage_givenTimestampProperty() {
    // Arrange
    Schema schema = new Schema();
    schema.addConfig("timestampProperty", "Schema");

    // Act
    ClassicKeyPackage actualClassicKeyPackage = new ClassicKeyPackage(schema);

    // Assert
    assertTrue(actualClassicKeyPackage.getKeyFunctor() instanceof CoreKeyBloomFunctor);
    assertTrue(
        actualClassicKeyPackage.getKeyConverter() instanceof ClassicAccumuloElementConverter);
    assertTrue(
        actualClassicKeyPackage.getIteratorFactory() instanceof ClassicIteratorSettingsFactory);
    assertTrue(actualClassicKeyPackage.getRangeFactory() instanceof ClassicRangeFactory);
  }

  /**
   * Test {@link ClassicKeyPackage#ClassicKeyPackage(Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then KeyFunctor return {@link CoreKeyBloomFunctor}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicKeyPackage#ClassicKeyPackage(Schema)}
   */
  @Test
  @DisplayName(
      "Test new ClassicKeyPackage(Schema); when 'null'; then KeyFunctor return CoreKeyBloomFunctor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassicKeyPackage.<init>(Schema)"})
  void testNewClassicKeyPackage_whenNull_thenKeyFunctorReturnCoreKeyBloomFunctor() {
    // Arrange and Act
    ClassicKeyPackage actualClassicKeyPackage = new ClassicKeyPackage(null);

    // Assert
    assertTrue(actualClassicKeyPackage.getKeyFunctor() instanceof CoreKeyBloomFunctor);
    assertTrue(
        actualClassicKeyPackage.getKeyConverter() instanceof ClassicAccumuloElementConverter);
    assertTrue(
        actualClassicKeyPackage.getIteratorFactory() instanceof ClassicIteratorSettingsFactory);
    assertTrue(actualClassicKeyPackage.getRangeFactory() instanceof ClassicRangeFactory);
  }

  /**
   * Test {@link ClassicKeyPackage#ClassicKeyPackage(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then KeyFunctor return {@link CoreKeyBloomFunctor}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicKeyPackage#ClassicKeyPackage(Schema)}
   */
  @Test
  @DisplayName(
      "Test new ClassicKeyPackage(Schema); when Schema(); then KeyFunctor return CoreKeyBloomFunctor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassicKeyPackage.<init>(Schema)"})
  void testNewClassicKeyPackage_whenSchema_thenKeyFunctorReturnCoreKeyBloomFunctor() {
    // Arrange and Act
    ClassicKeyPackage actualClassicKeyPackage = new ClassicKeyPackage(new Schema());

    // Assert
    assertTrue(actualClassicKeyPackage.getKeyFunctor() instanceof CoreKeyBloomFunctor);
    assertTrue(
        actualClassicKeyPackage.getKeyConverter() instanceof ClassicAccumuloElementConverter);
    assertTrue(
        actualClassicKeyPackage.getIteratorFactory() instanceof ClassicIteratorSettingsFactory);
    assertTrue(actualClassicKeyPackage.getRangeFactory() instanceof ClassicRangeFactory);
  }

  /**
   * Test {@link ClassicKeyPackage#setSchema(Schema)}.
   *
   * <ul>
   *   <li>Given {@code timestampProperty}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicKeyPackage#setSchema(Schema)}
   */
  @Test
  @DisplayName("Test setSchema(Schema); given 'timestampProperty'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassicKeyPackage.setSchema(Schema)"})
  void testSetSchema_givenTimestampProperty() {
    // Arrange
    ClassicKeyPackage classicKeyPackage = new ClassicKeyPackage();

    Schema schema = new Schema();
    schema.addConfig("timestampProperty", "Schema");

    // Act
    classicKeyPackage.setSchema(schema);

    // Assert
    assertTrue(classicKeyPackage.getKeyConverter() instanceof ClassicAccumuloElementConverter);
    assertTrue(classicKeyPackage.getRangeFactory() instanceof ClassicRangeFactory);
  }

  /**
   * Test {@link ClassicKeyPackage#setSchema(Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicKeyPackage#setSchema(Schema)}
   */
  @Test
  @DisplayName("Test setSchema(Schema); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassicKeyPackage.setSchema(Schema)"})
  void testSetSchema_whenNull() {
    // Arrange
    ClassicKeyPackage classicKeyPackage = new ClassicKeyPackage();

    // Act
    classicKeyPackage.setSchema(null);

    // Assert
    assertTrue(classicKeyPackage.getKeyConverter() instanceof ClassicAccumuloElementConverter);
    assertTrue(classicKeyPackage.getRangeFactory() instanceof ClassicRangeFactory);
  }

  /**
   * Test {@link ClassicKeyPackage#setSchema(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassicKeyPackage#setSchema(Schema)}
   */
  @Test
  @DisplayName("Test setSchema(Schema); when Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassicKeyPackage.setSchema(Schema)"})
  void testSetSchema_whenSchema() {
    // Arrange
    ClassicKeyPackage classicKeyPackage = new ClassicKeyPackage();

    // Act
    classicKeyPackage.setSchema(new Schema());

    // Assert
    assertTrue(classicKeyPackage.getKeyConverter() instanceof ClassicAccumuloElementConverter);
    assertTrue(classicKeyPackage.getRangeFactory() instanceof ClassicRangeFactory);
  }
}
