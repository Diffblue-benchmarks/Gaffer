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

package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.handler;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.hdfs.operation.SampleDataForSplitPoints;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreException;

class SampleDataForSplitPointsHandlerDiffblueTest {
  /**
   * Test {@link SampleDataForSplitPointsHandler#doOperation(SampleDataForSplitPoints, Context, Store)} with {@code SampleDataForSplitPoints}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link SampleDataForSplitPointsHandler#doOperation(SampleDataForSplitPoints, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(SampleDataForSplitPoints, Context, Store) with 'SampleDataForSplitPoints', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void SampleDataForSplitPointsHandler.doOperation(SampleDataForSplitPoints, Context, Store)"})
  void testDoOperationWithSampleDataForSplitPointsContextStore() throws OperationException, StoreException {
    // Arrange
    SampleDataForSplitPointsHandler sampleDataForSplitPointsHandler = new SampleDataForSplitPointsHandler();
    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    Context context = new Context();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTabletServers()).thenThrow(new StoreException("An error occurred"));

    // Act and Assert
    assertThrows(OperationException.class,
        () -> sampleDataForSplitPointsHandler.doOperation(operation, context, store));
    verify(store).getTabletServers();
  }

  /**
   * Test {@link SampleDataForSplitPointsHandler#doOperation(SampleDataForSplitPoints, Context, Store)} with {@code SampleDataForSplitPoints}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link SampleDataForSplitPointsHandler#doOperation(SampleDataForSplitPoints, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(SampleDataForSplitPoints, Context, Store) with 'SampleDataForSplitPoints', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void SampleDataForSplitPointsHandler.doOperation(SampleDataForSplitPoints, Context, Store)"})
  void testDoOperationWithSampleDataForSplitPointsContextStore2() throws OperationException, StoreException {
    // Arrange
    SampleDataForSplitPointsHandler sampleDataForSplitPointsHandler = new SampleDataForSplitPointsHandler();

    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    operation.addInputMapperPairs(new HashMap<>());
    Context context = new Context();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("There is only 1 tablet server so no split points will be calculated.");
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTabletServers()).thenReturn(stringList);

    // Act
    Void actualDoOperationResult = sampleDataForSplitPointsHandler.doOperation(operation, context, store);

    // Assert
    verify(store, atLeast(1)).getTabletServers();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link SampleDataForSplitPointsHandler#doOperation(SampleDataForSplitPoints, Context, Store)} with {@code SampleDataForSplitPoints}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataForSplitPointsHandler#doOperation(SampleDataForSplitPoints, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(SampleDataForSplitPoints, Context, Store) with 'SampleDataForSplitPoints', 'Context', 'Store'; given ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void SampleDataForSplitPointsHandler.doOperation(SampleDataForSplitPoints, Context, Store)"})
  void testDoOperationWithSampleDataForSplitPointsContextStore_givenArrayList()
      throws OperationException, StoreException {
    // Arrange
    SampleDataForSplitPointsHandler sampleDataForSplitPointsHandler = new SampleDataForSplitPointsHandler();
    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    Context context = new Context();
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTabletServers()).thenReturn(new ArrayList<>());

    // Act
    Void actualDoOperationResult = sampleDataForSplitPointsHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getTabletServers();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link SampleDataForSplitPointsHandler#doOperation(SampleDataForSplitPoints, Context, Store)} with {@code SampleDataForSplitPoints}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataForSplitPointsHandler#doOperation(SampleDataForSplitPoints, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(SampleDataForSplitPoints, Context, Store) with 'SampleDataForSplitPoints', 'Context', 'Store'; given ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void SampleDataForSplitPointsHandler.doOperation(SampleDataForSplitPoints, Context, Store)"})
  void testDoOperationWithSampleDataForSplitPointsContextStore_givenTen() throws OperationException, StoreException {
    // Arrange
    SampleDataForSplitPointsHandler sampleDataForSplitPointsHandler = new SampleDataForSplitPointsHandler();
    SampleDataForSplitPoints operation = mock(SampleDataForSplitPoints.class);
    doNothing().when(operation).addInputMapperPair(Mockito.<String>any(), Mockito.<String>any());
    when(operation.getNumSplits()).thenReturn(10);
    when(operation.getCommandLineArgs()).thenReturn(new String[]{"Command Line Args"});
    when(operation.getInputMapperPairs()).thenReturn(new HashMap<>());
    operation.addInputMapperPair("Number of tablet servers is {}", "Number of tablet servers is {}");
    Context context = new Context();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("There is only 1 tablet server so no split points will be calculated.");
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTabletServers()).thenReturn(stringList);

    // Act
    Void actualDoOperationResult = sampleDataForSplitPointsHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getTabletServers();
    verify(operation).addInputMapperPair(eq("Number of tablet servers is {}"), eq("Number of tablet servers is {}"));
    verify(operation, atLeast(1)).getCommandLineArgs();
    verify(operation).getInputMapperPairs();
    verify(operation, atLeast(1)).getNumSplits();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link SampleDataForSplitPointsHandler#doOperation(SampleDataForSplitPoints, Context, Store)} with {@code SampleDataForSplitPoints}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataForSplitPointsHandler#doOperation(SampleDataForSplitPoints, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(SampleDataForSplitPoints, Context, Store) with 'SampleDataForSplitPoints', 'Context', 'Store'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Void SampleDataForSplitPointsHandler.doOperation(SampleDataForSplitPoints, Context, Store)"})
  void testDoOperationWithSampleDataForSplitPointsContextStore_givenZero() throws OperationException, StoreException {
    // Arrange
    SampleDataForSplitPointsHandler sampleDataForSplitPointsHandler = new SampleDataForSplitPointsHandler();
    SampleDataForSplitPoints operation = mock(SampleDataForSplitPoints.class);
    doNothing().when(operation).addInputMapperPair(Mockito.<String>any(), Mockito.<String>any());
    when(operation.getNumSplits()).thenReturn(0);
    when(operation.getCommandLineArgs()).thenReturn(new String[]{"Command Line Args"});
    when(operation.getInputMapperPairs()).thenReturn(new HashMap<>());
    operation.addInputMapperPair("Number of tablet servers is {}", "Number of tablet servers is {}");
    Context context = new Context();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("There is only 1 tablet server so no split points will be calculated.");
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTabletServers()).thenReturn(stringList);

    // Act
    Void actualDoOperationResult = sampleDataForSplitPointsHandler.doOperation(operation, context, store);

    // Assert
    verify(store, atLeast(1)).getTabletServers();
    verify(operation).addInputMapperPair(eq("Number of tablet servers is {}"), eq("Number of tablet servers is {}"));
    verify(operation, atLeast(1)).getCommandLineArgs();
    verify(operation).getInputMapperPairs();
    verify(operation, atLeast(1)).getNumSplits();
    assertNull(actualDoOperationResult);
  }
}
