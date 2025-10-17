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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.accumulo.core.client.AccumuloException;
import org.apache.accumulo.core.client.AccumuloSecurityException;
import org.apache.accumulo.core.client.TableNotFoundException;
import org.apache.accumulo.core.client.admin.TableOperations;
import org.apache.accumulo.core.clientImpl.ConnectorImpl;
import org.apache.hadoop.io.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.StoreException;

class AccumuloKeyRangePartitionerDiffblueTest {
  /**
   * Test {@link AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}
   */
  @Test
  @DisplayName("Test new AccumuloKeyRangePartitioner(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloKeyRangePartitioner.<init>(AccumuloStore)"})
  void testNewAccumuloKeyRangePartitioner() throws OperationException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new StoreException("An error occurred"));

    // Act and Assert
    assertThrows(OperationException.class, () -> new AccumuloKeyRangePartitioner(store));
    verify(store).getConnection();
  }

  /**
   * Test {@link AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}.
   *
   * <p>Method under test: {@link
   * AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}
   */
  @Test
  @DisplayName("Test new AccumuloKeyRangePartitioner(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloKeyRangePartitioner.<init>(AccumuloStore)"})
  void testNewAccumuloKeyRangePartitioner2()
      throws AccumuloException, AccumuloSecurityException, TableNotFoundException,
          OperationException, StoreException {
    // Arrange
    TableOperations tableOperations = mock(TableOperations.class);
    TableNotFoundException tableNotFoundException =
        new TableNotFoundException(
            "42", "Table Name", "The characteristics of someone or something");
    when(tableOperations.listSplits(Mockito.<String>any())).thenThrow(tableNotFoundException);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getConnection()).thenReturn(connectorImpl);

    // Act and Assert
    assertThrows(OperationException.class, () -> new AccumuloKeyRangePartitioner(store));
    verify(tableOperations).listSplits("Table Name");
    verify(connectorImpl).tableOperations();
    verify(store).getConnection();
    verify(store).getTableName();
  }

  /**
   * Test {@link AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then calls {@link Text#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}
   */
  @Test
  @DisplayName("Test new AccumuloKeyRangePartitioner(AccumuloStore); then calls getBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloKeyRangePartitioner.<init>(AccumuloStore)"})
  void testNewAccumuloKeyRangePartitioner_thenCallsGetBytes()
      throws UnsupportedEncodingException, AccumuloException, AccumuloSecurityException,
          TableNotFoundException, OperationException, StoreException {
    // Arrange
    Text text = mock(Text.class);
    when(text.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(text.getLength()).thenReturn(3);

    ArrayList<Text> textList = new ArrayList<>();
    textList.add(text);
    textList.add(new Text());

    TableOperations tableOperations = mock(TableOperations.class);
    when(tableOperations.listSplits(Mockito.<String>any())).thenReturn(textList);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getConnection()).thenReturn(connectorImpl);

    // Act
    AccumuloKeyRangePartitioner actualAccumuloKeyRangePartitioner =
        new AccumuloKeyRangePartitioner(store);

    // Assert
    verify(tableOperations).listSplits("Table Name");
    verify(connectorImpl).tableOperations();
    verify(text).getBytes();
    verify(text).getLength();
    verify(store).getConnection();
    verify(store).getTableName();
    assertEquals(3, actualAccumuloKeyRangePartitioner.numPartitions());
  }

  /**
   * Test {@link AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then return numPartitions is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloKeyRangePartitioner(AccumuloStore); then return numPartitions is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloKeyRangePartitioner.<init>(AccumuloStore)"})
  void testNewAccumuloKeyRangePartitioner_thenReturnNumPartitionsIsOne()
      throws AccumuloException, AccumuloSecurityException, TableNotFoundException,
          OperationException, StoreException {
    // Arrange
    TableOperations tableOperations = mock(TableOperations.class);
    when(tableOperations.listSplits(Mockito.<String>any())).thenReturn(new ArrayList<>());

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getConnection()).thenReturn(connectorImpl);

    // Act
    AccumuloKeyRangePartitioner actualAccumuloKeyRangePartitioner =
        new AccumuloKeyRangePartitioner(store);

    // Assert
    verify(tableOperations).listSplits("Table Name");
    verify(connectorImpl).tableOperations();
    verify(store).getConnection();
    verify(store).getTableName();
    assertEquals(1, actualAccumuloKeyRangePartitioner.numPartitions());
  }

  /**
   * Test {@link AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then return numPartitions is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloKeyRangePartitioner(AccumuloStore); then return numPartitions is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloKeyRangePartitioner.<init>(AccumuloStore)"})
  void testNewAccumuloKeyRangePartitioner_thenReturnNumPartitionsIsThree()
      throws AccumuloException, AccumuloSecurityException, TableNotFoundException,
          OperationException, StoreException {
    // Arrange
    ArrayList<Text> textList = new ArrayList<>();
    textList.add(new Text());
    textList.add(new Text());

    TableOperations tableOperations = mock(TableOperations.class);
    when(tableOperations.listSplits(Mockito.<String>any())).thenReturn(textList);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getConnection()).thenReturn(connectorImpl);

    // Act
    AccumuloKeyRangePartitioner actualAccumuloKeyRangePartitioner =
        new AccumuloKeyRangePartitioner(store);

    // Assert
    verify(tableOperations).listSplits("Table Name");
    verify(connectorImpl).tableOperations();
    verify(store).getConnection();
    verify(store).getTableName();
    assertEquals(3, actualAccumuloKeyRangePartitioner.numPartitions());
  }

  /**
   * Test {@link AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then return numPartitions is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloKeyRangePartitioner#AccumuloKeyRangePartitioner(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloKeyRangePartitioner(AccumuloStore); then return numPartitions is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloKeyRangePartitioner.<init>(AccumuloStore)"})
  void testNewAccumuloKeyRangePartitioner_thenReturnNumPartitionsIsTwo()
      throws AccumuloException, AccumuloSecurityException, TableNotFoundException,
          OperationException, StoreException {
    // Arrange
    ArrayList<Text> textList = new ArrayList<>();
    textList.add(new Text());

    TableOperations tableOperations = mock(TableOperations.class);
    when(tableOperations.listSplits(Mockito.<String>any())).thenReturn(textList);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getConnection()).thenReturn(connectorImpl);

    // Act
    AccumuloKeyRangePartitioner actualAccumuloKeyRangePartitioner =
        new AccumuloKeyRangePartitioner(store);

    // Assert
    verify(tableOperations).listSplits("Table Name");
    verify(connectorImpl).tableOperations();
    verify(store).getConnection();
    verify(store).getTableName();
    assertEquals(2, actualAccumuloKeyRangePartitioner.numPartitions());
  }

  /**
   * Test {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}.
   *
   * <p>Method under test: {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getSplits(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AccumuloKeyRangePartitioner.getSplits(AccumuloStore)"})
  void testGetSplits()
      throws AccumuloException, AccumuloSecurityException, TableNotFoundException,
          OperationException, StoreException {
    // Arrange
    TableOperations tableOperations = mock(TableOperations.class);
    TableNotFoundException tableNotFoundException =
        new TableNotFoundException(
            "42", "Table Name", "The characteristics of someone or something");
    when(tableOperations.listSplits(Mockito.<String>any())).thenThrow(tableNotFoundException);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getConnection()).thenReturn(connectorImpl);

    // Act and Assert
    assertThrows(OperationException.class, () -> AccumuloKeyRangePartitioner.getSplits(store));
    verify(tableOperations).listSplits("Table Name");
    verify(connectorImpl).tableOperations();
    verify(store).getConnection();
    verify(store).getTableName();
  }

  /**
   * Test {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Text#Text()}.
   *   <li>Then return array of {@link String} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getSplits(AccumuloStore); given ArrayList() add Text(); then return array of String with empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AccumuloKeyRangePartitioner.getSplits(AccumuloStore)"})
  void testGetSplits_givenArrayListAddText_thenReturnArrayOfStringWithEmptyString()
      throws AccumuloException, AccumuloSecurityException, TableNotFoundException,
          OperationException, StoreException {
    // Arrange
    ArrayList<Text> textList = new ArrayList<>();
    textList.add(new Text());

    TableOperations tableOperations = mock(TableOperations.class);
    when(tableOperations.listSplits(Mockito.<String>any())).thenReturn(textList);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getConnection()).thenReturn(connectorImpl);

    // Act
    String[] actualSplits = AccumuloKeyRangePartitioner.getSplits(store);

    // Assert
    verify(tableOperations).listSplits("Table Name");
    verify(connectorImpl).tableOperations();
    verify(store).getConnection();
    verify(store).getTableName();
    assertArrayEquals(new String[] {""}, actualSplits);
  }

  /**
   * Test {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link StoreException#StoreException(String)} with message is {@code An error
   *       occurred}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getSplits(AccumuloStore); given StoreException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AccumuloKeyRangePartitioner.getSplits(AccumuloStore)"})
  void testGetSplits_givenStoreExceptionWithMessageIsAnErrorOccurred()
      throws OperationException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new StoreException("An error occurred"));

    // Act and Assert
    assertThrows(OperationException.class, () -> AccumuloKeyRangePartitioner.getSplits(store));
    verify(store).getConnection();
  }

  /**
   * Test {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getSplits(AccumuloStore); then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AccumuloKeyRangePartitioner.getSplits(AccumuloStore)"})
  void testGetSplits_thenReturnArrayLengthIsZero()
      throws AccumuloException, AccumuloSecurityException, TableNotFoundException,
          OperationException, StoreException {
    // Arrange
    TableOperations tableOperations = mock(TableOperations.class);
    when(tableOperations.listSplits(Mockito.<String>any())).thenReturn(new ArrayList<>());

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getConnection()).thenReturn(connectorImpl);

    // Act
    String[] actualSplits = AccumuloKeyRangePartitioner.getSplits(store);

    // Assert
    verify(tableOperations).listSplits("Table Name");
    verify(connectorImpl).tableOperations();
    verify(store).getConnection();
    verify(store).getTableName();
    assertEquals(0, actualSplits.length);
  }

  /**
   * Test {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with empty string and empty string.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test getSplits(AccumuloStore); then return array of String with empty string and empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AccumuloKeyRangePartitioner.getSplits(AccumuloStore)"})
  void testGetSplits_thenReturnArrayOfStringWithEmptyStringAndEmptyString()
      throws AccumuloException, AccumuloSecurityException, TableNotFoundException,
          OperationException, StoreException {
    // Arrange
    ArrayList<Text> textList = new ArrayList<>();
    textList.add(new Text());
    textList.add(new Text());

    TableOperations tableOperations = mock(TableOperations.class);
    when(tableOperations.listSplits(Mockito.<String>any())).thenReturn(textList);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getConnection()).thenReturn(connectorImpl);

    // Act
    String[] actualSplits = AccumuloKeyRangePartitioner.getSplits(store);

    // Assert
    verify(tableOperations).listSplits("Table Name");
    verify(connectorImpl).tableOperations();
    verify(store).getConnection();
    verify(store).getTableName();
    assertArrayEquals(new String[] {"", ""}, actualSplits);
  }

  /**
   * Test {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then return first element is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloKeyRangePartitioner#getSplits(AccumuloStore)}
   */
  @Test
  @DisplayName("Test getSplits(AccumuloStore); then return first element is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AccumuloKeyRangePartitioner.getSplits(AccumuloStore)"})
  void testGetSplits_thenReturnFirstElementIsEmptyString()
      throws UnsupportedEncodingException, AccumuloException, AccumuloSecurityException,
          TableNotFoundException, OperationException, StoreException {
    // Arrange
    Text text = mock(Text.class);
    when(text.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(text.getLength()).thenReturn(3);

    ArrayList<Text> textList = new ArrayList<>();
    textList.add(text);
    textList.add(new Text());

    TableOperations tableOperations = mock(TableOperations.class);
    when(tableOperations.listSplits(Mockito.<String>any())).thenReturn(textList);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperations);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getConnection()).thenReturn(connectorImpl);

    // Act
    String[] actualSplits = AccumuloKeyRangePartitioner.getSplits(store);

    // Assert
    verify(tableOperations).listSplits("Table Name");
    verify(connectorImpl).tableOperations();
    verify(text).getBytes();
    verify(text).getLength();
    verify(store).getConnection();
    verify(store).getTableName();
    assertEquals("", actualSplits[0]);
    assertEquals(2, actualSplits.length);
  }
}
