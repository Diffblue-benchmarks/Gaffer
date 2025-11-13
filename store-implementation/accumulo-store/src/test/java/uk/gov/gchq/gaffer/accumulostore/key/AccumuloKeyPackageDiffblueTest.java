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

package uk.gov.gchq.gaffer.accumulostore.key;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.accumulo.core.file.keyfunctor.KeyFunctor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyBloomFunctor;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityIteratorSettingsFactory;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityRangeFactory;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AccumuloKeyPackageDiffblueTest {
  /**
   * Test {@link AccumuloKeyPackage#getRangeFactory()}.
   * <p>
   * Method under test: {@link AccumuloKeyPackage#getRangeFactory()}
   */
  @Test
  @DisplayName("Test getRangeFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RangeFactory AccumuloKeyPackage.getRangeFactory()"})
  void testGetRangeFactory() {
    // Arrange, Act and Assert
    assertNull((new ByteEntityKeyPackage()).getRangeFactory());
  }

  /**
   * Test {@link AccumuloKeyPackage#getKeyConverter()}.
   * <p>
   * Method under test: {@link AccumuloKeyPackage#getKeyConverter()}
   */
  @Test
  @DisplayName("Test getKeyConverter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AccumuloElementConverter AccumuloKeyPackage.getKeyConverter()"})
  void testGetKeyConverter() {
    // Arrange, Act and Assert
    assertNull((new ByteEntityKeyPackage()).getKeyConverter());
  }

  /**
   * Test {@link AccumuloKeyPackage#getIteratorFactory()}.
   * <p>
   * Method under test: {@link AccumuloKeyPackage#getIteratorFactory()}
   */
  @Test
  @DisplayName("Test getIteratorFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingFactory AccumuloKeyPackage.getIteratorFactory()"})
  void testGetIteratorFactory() {
    // Arrange and Act
    IteratorSettingFactory actualIteratorFactory = (new ByteEntityKeyPackage()).getIteratorFactory();

    // Assert
    assertTrue(actualIteratorFactory instanceof ByteEntityIteratorSettingsFactory);
    assertNull(actualIteratorFactory.getEdgeEntityDirectionFilterIteratorSetting(null));
  }

  /**
   * Test {@link AccumuloKeyPackage#setRangeFactory(RangeFactory)}.
   * <p>
   * Method under test: {@link AccumuloKeyPackage#setRangeFactory(RangeFactory)}
   */
  @Test
  @DisplayName("Test setRangeFactory(RangeFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloKeyPackage.setRangeFactory(RangeFactory)"})
  void testSetRangeFactory() {
    // Arrange
    ByteEntityKeyPackage byteEntityKeyPackage = new ByteEntityKeyPackage();
    ByteEntityRangeFactory rangeFactory = new ByteEntityRangeFactory(new Schema());

    // Act
    byteEntityKeyPackage.setRangeFactory(rangeFactory);

    // Assert
    assertSame(rangeFactory, byteEntityKeyPackage.getRangeFactory());
  }

  /**
   * Test {@link AccumuloKeyPackage#setKeyConverter(AccumuloElementConverter)}.
   * <p>
   * Method under test: {@link AccumuloKeyPackage#setKeyConverter(AccumuloElementConverter)}
   */
  @Test
  @DisplayName("Test setKeyConverter(AccumuloElementConverter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloKeyPackage.setKeyConverter(AccumuloElementConverter)"})
  void testSetKeyConverter() {
    // Arrange
    ByteEntityKeyPackage byteEntityKeyPackage = new ByteEntityKeyPackage();
    ByteEntityAccumuloElementConverter keyConverter = new ByteEntityAccumuloElementConverter(new Schema());

    // Act
    byteEntityKeyPackage.setKeyConverter(keyConverter);

    // Assert
    assertSame(keyConverter, byteEntityKeyPackage.getKeyConverter());
  }

  /**
   * Test {@link AccumuloKeyPackage#setIteratorFactory(IteratorSettingFactory)}.
   * <p>
   * Method under test: {@link AccumuloKeyPackage#setIteratorFactory(IteratorSettingFactory)}
   */
  @Test
  @DisplayName("Test setIteratorFactory(IteratorSettingFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloKeyPackage.setIteratorFactory(IteratorSettingFactory)"})
  void testSetIteratorFactory() {
    // Arrange
    ByteEntityKeyPackage byteEntityKeyPackage = new ByteEntityKeyPackage();
    ByteEntityIteratorSettingsFactory iteratorFactory = new ByteEntityIteratorSettingsFactory();

    // Act
    byteEntityKeyPackage.setIteratorFactory(iteratorFactory);

    // Assert
    assertSame(iteratorFactory, byteEntityKeyPackage.getIteratorFactory());
  }

  /**
   * Test {@link AccumuloKeyPackage#getKeyFunctor()}.
   * <p>
   * Method under test: {@link AccumuloKeyPackage#getKeyFunctor()}
   */
  @Test
  @DisplayName("Test getKeyFunctor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyFunctor AccumuloKeyPackage.getKeyFunctor()"})
  void testGetKeyFunctor() {
    // Arrange, Act and Assert
    assertTrue((new ByteEntityKeyPackage()).getKeyFunctor() instanceof CoreKeyBloomFunctor);
  }

  /**
   * Test {@link AccumuloKeyPackage#setKeyFunctor(KeyFunctor)}.
   * <p>
   * Method under test: {@link AccumuloKeyPackage#setKeyFunctor(KeyFunctor)}
   */
  @Test
  @DisplayName("Test setKeyFunctor(KeyFunctor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloKeyPackage.setKeyFunctor(KeyFunctor)"})
  void testSetKeyFunctor() {
    // Arrange
    ByteEntityKeyPackage byteEntityKeyPackage = new ByteEntityKeyPackage();
    CoreKeyBloomFunctor bloomFunctor = new CoreKeyBloomFunctor();

    // Act
    byteEntityKeyPackage.setKeyFunctor(bloomFunctor);

    // Assert
    assertSame(bloomFunctor, byteEntityKeyPackage.getKeyFunctor());
  }
}
