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

package uk.gov.gchq.gaffer.accumulostore.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AddUpdateTableIteratorDiffblueTest {
  /**
   * Test {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)} with {@code store}, {@code iteratorName}.
   * <p>
   * Method under test: {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)}
   */
  @Test
  @DisplayName("Test addIterator(AccumuloStore, String) with 'store', 'iteratorName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AddUpdateTableIterator.addIterator(AccumuloStore, String)"})
  void testAddIteratorWithStoreIteratorName() throws StoreException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenThrow(new IllegalArgumentException(AccumuloStoreConstants.VALIDATOR_ITERATOR_NAME));
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AddUpdateTableIterator.addIterator(store, "Iterator Name"));
    verify(store).getKeyPackage();
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)} with {@code store}, {@code iteratorName}.
   * <ul>
   *   <li>Given {@link Schema#Schema()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)}
   */
  @Test
  @DisplayName("Test addIterator(AccumuloStore, String) with 'store', 'iteratorName'; given Schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AddUpdateTableIterator.addIterator(AccumuloStore, String)"})
  void testAddIteratorWithStoreIteratorName_givenSchema() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    AddUpdateTableIterator.addIterator(store, "Iterator Name");

    // Assert
    verify(store).getSchema();
  }

  /**
   * Test {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)} with {@code store}, {@code iteratorName}.
   * <ul>
   *   <li>Then calls {@link AccumuloProperties#getEnableValidatorIterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)}
   */
  @Test
  @DisplayName("Test addIterator(AccumuloStore, String) with 'store', 'iteratorName'; then calls getEnableValidatorIterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AddUpdateTableIterator.addIterator(AccumuloStore, String)"})
  void testAddIteratorWithStoreIteratorName_thenCallsGetEnableValidatorIterator()
      throws UnsupportedEncodingException, SchemaException, StoreException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.hasValidation()).thenReturn(true);
    when(schema.isAggregationEnabled()).thenReturn(true);
    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(true);
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new IllegalArgumentException(AccumuloStoreConstants.VALIDATOR_ITERATOR_NAME));
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> AddUpdateTableIterator.addIterator(store, AccumuloStoreConstants.VALIDATOR_ITERATOR_NAME));
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(store).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store).getProperties();
    verify(store, atLeast(1)).getSchema();
    verify(schema).hasValidation();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
  }
}
