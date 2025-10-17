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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.AccumuloRuntimeException;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.store.StoreException;

class TableUtilsDiffblueTest {
  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AccumuloStore} {@link AccumuloStore#getTableName()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test ensureTableExists(AccumuloStore); given 'null'; when AccumuloStore getTableName() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_givenNull_whenAccumuloStoreGetTableNameReturnNull()
      throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn(null);
    doNothing().when(store).addElements(Mockito.<Iterable<Element>>any());
    store.addElements(new ArrayList<>());

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.ensureTableExists(store));
    verify(store).addElements(isA(Iterable.class));
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then calls {@link AccumuloStore#getConnection()}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore); then calls getConnection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_thenCallsGetConnection() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(store.getTableName()).thenReturn("Table Name");
    doNothing().when(store).addElements(Mockito.<Iterable<Element>>any());
    store.addElements(new ArrayList<>());

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.ensureTableExists(store));
    verify(store).addElements(isA(Iterable.class));
    verify(store).getConnection();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#getTableName(AccumuloProperties, String)}.
   *
   * <ul>
   *   <li>Given {@code accumulo.namespace}.
   *   <li>Then return {@code 42.42}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#getTableName(AccumuloProperties, String)}
   */
  @Test
  @DisplayName(
      "Test getTableName(AccumuloProperties, String); given 'accumulo.namespace'; then return '42.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableUtils.getTableName(AccumuloProperties, String)"})
  void testGetTableName_givenAccumuloNamespace_thenReturn4242() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();
    accumuloProperties.set("accumulo.namespace", "42");

    // Act and Assert
    assertEquals("42.42", TableUtils.getTableName(accumuloProperties, "42"));
  }

  /**
   * Test {@link TableUtils#getTableName(AccumuloProperties, String)}.
   *
   * <ul>
   *   <li>When {@link AccumuloProperties#AccumuloProperties()}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#getTableName(AccumuloProperties, String)}
   */
  @Test
  @DisplayName(
      "Test getTableName(AccumuloProperties, String); when AccumuloProperties(); then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableUtils.getTableName(AccumuloProperties, String)"})
  void testGetTableName_whenAccumuloProperties_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", TableUtils.getTableName(new AccumuloProperties(), "42"));
  }
}
