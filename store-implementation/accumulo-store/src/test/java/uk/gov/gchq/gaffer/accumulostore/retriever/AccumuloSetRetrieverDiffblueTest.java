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

package uk.gov.gchq.gaffer.accumulostore.retriever;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.apache.accumulo.core.client.IteratorSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.accumulostore.retriever.impl.AccumuloIDBetweenSetsRetriever;
import uk.gov.gchq.gaffer.commonutil.iterable.EmptyIterator;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class AccumuloSetRetrieverDiffblueTest {
  /**
   * Test {@link AccumuloSetRetriever#setReadEntriesIntoMemory(boolean)}.
   * <ul>
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloSetRetriever#setReadEntriesIntoMemory(boolean)}
   */
  @Test
  @DisplayName("Test setReadEntriesIntoMemory(boolean); then calls getKeyPackage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloSetRetriever.setReadEntriesIntoMemory(boolean)"})
  void testSetReadEntriesIntoMemory_thenCallsGetKeyPackage() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    User user = (new Builder()).userId("42").build();

    // Act
    (new AccumuloIDBetweenSetsRetriever(store, operation, user, new IteratorSetting(1, "Name", "Iterator Class")))
        .setReadEntriesIntoMemory(true);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
  }

  /**
   * Test {@link AccumuloSetRetriever#iterator()}.
   * <ul>
   *   <li>Then return {@link EmptyIterator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloSetRetriever#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); then return EmptyIterator")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterator AccumuloSetRetriever.iterator()"})
  void testIterator_thenReturnEmptyIterator() throws IOException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput()).thenReturn(new ArrayList<>());
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInputB()).thenReturn(new ArrayList<>());
    doNothing().when(operation).close();
    User user = (new Builder()).userId("42").build();

    // Act
    Iterator<Element> actualIteratorResult = (new AccumuloIDBetweenSetsRetriever(store, operation, user,
        new IteratorSetting(1, "Name", "Iterator Class"))).iterator();

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(operation).close();
    verify(operation).getInput();
    verify(operation).getInputB();
    assertTrue(actualIteratorResult instanceof EmptyIterator);
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AccumuloSetRetriever#extractVertices(Iterator)}.
   * <ul>
   *   <li>Given {@link EntitySeed#EntitySeed()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloSetRetriever#extractVertices(Iterator)}
   */
  @Test
  @DisplayName("Test extractVertices(Iterator); given EntitySeed(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set AccumuloSetRetriever.extractVertices(Iterator)"})
  void testExtractVertices_givenEntitySeed_thenReturnSizeIsOne() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    User user = (new Builder()).userId("42").build();
    AccumuloIDBetweenSetsRetriever accumuloIDBetweenSetsRetriever = new AccumuloIDBetweenSetsRetriever(store, operation,
        user, new IteratorSetting(1, "Name", "Iterator Class"));

    ArrayList<EntityId> entityIdList = new ArrayList<>();
    entityIdList.add(new EntitySeed());
    Iterator<EntityId> seeds = entityIdList.iterator();

    // Act
    Set<Object> actualExtractVerticesResult = accumuloIDBetweenSetsRetriever.extractVertices(seeds);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    assertEquals(1, actualExtractVerticesResult.size());
    assertFalse(seeds.hasNext());
  }

  /**
   * Test {@link AccumuloSetRetriever#extractVertices(Iterator)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloSetRetriever#extractVertices(Iterator)}
   */
  @Test
  @DisplayName("Test extractVertices(Iterator); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set AccumuloSetRetriever.extractVertices(Iterator)"})
  void testExtractVertices_thenReturnEmpty() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    User user = (new Builder()).userId("42").build();
    AccumuloIDBetweenSetsRetriever accumuloIDBetweenSetsRetriever = new AccumuloIDBetweenSetsRetriever(store, operation,
        user, new IteratorSetting(1, "Name", "Iterator Class"));

    ArrayList<EntityId> entityIdList = new ArrayList<>();
    Iterator<EntityId> seeds = entityIdList.iterator();

    // Act
    Set<Object> actualExtractVerticesResult = accumuloIDBetweenSetsRetriever.extractVertices(seeds);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    assertFalse(seeds.hasNext());
    assertTrue(actualExtractVerticesResult.isEmpty());
  }
}
