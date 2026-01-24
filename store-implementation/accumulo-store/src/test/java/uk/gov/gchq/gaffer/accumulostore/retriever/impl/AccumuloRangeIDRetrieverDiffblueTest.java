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

package uk.gov.gchq.gaffer.accumulostore.retriever.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.iterators.SortedKeyValueIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsInRanges;
import uk.gov.gchq.gaffer.operation.io.InputOutput;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.user.User;

class AccumuloRangeIDRetrieverDiffblueTest {
  /**
   * Test {@link AccumuloRangeIDRetriever#AccumuloRangeIDRetriever(AccumuloStore, InputOutput, User,
   * IteratorSetting[])}.
   *
   * <ul>
   *   <li>Then return spliterator ExactSizeIfKnown is minus one.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloRangeIDRetriever#AccumuloRangeIDRetriever(AccumuloStore,
   * InputOutput, User, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloRangeIDRetriever(AccumuloStore, InputOutput, User, IteratorSetting[]); then return spliterator ExactSizeIfKnown is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloRangeIDRetriever.<init>(AccumuloStore, InputOutput, User, IteratorSetting[])"
  })
  void testNewAccumuloRangeIDRetriever_thenReturnSpliteratorExactSizeIfKnownIsMinusOne()
      throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsInRanges getElementsInRanges = new GetElementsInRanges();
    User user = new User();
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act
    AccumuloRangeIDRetriever<GetElementsInRanges> actualAccumuloRangeIDRetriever =
        new AccumuloRangeIDRetriever<>(
            store,
            getElementsInRanges,
            user,
            new IteratorSetting(
                1, (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult));

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    assertEquals(-1L, actualAccumuloRangeIDRetriever.spliterator().getExactSizeIfKnown());
  }

  /**
   * Test {@link AccumuloRangeIDRetriever#AccumuloRangeIDRetriever(AccumuloStore, InputOutput, User,
   * IteratorSetting[])}.
   *
   * <ul>
   *   <li>Then return spliterator ExactSizeIfKnown is minus one.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloRangeIDRetriever#AccumuloRangeIDRetriever(AccumuloStore,
   * InputOutput, User, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloRangeIDRetriever(AccumuloStore, InputOutput, User, IteratorSetting[]); then return spliterator ExactSizeIfKnown is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloRangeIDRetriever.<init>(AccumuloStore, InputOutput, User, IteratorSetting[])"
  })
  void testNewAccumuloRangeIDRetriever_thenReturnSpliteratorExactSizeIfKnownIsMinusOne2()
      throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    User user = new User();
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act
    AccumuloRangeIDRetriever<GetElementsInRanges> actualAccumuloRangeIDRetriever =
        new AccumuloRangeIDRetriever<>(
            store,
            null,
            user,
            new IteratorSetting(
                1, (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult));

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    assertEquals(-1L, actualAccumuloRangeIDRetriever.spliterator().getExactSizeIfKnown());
  }

  /**
   * Test {@link AccumuloRangeIDRetriever#AccumuloRangeIDRetriever(AccumuloStore, InputOutput, User,
   * IteratorSetting[])}.
   *
   * <ul>
   *   <li>Then return spliterator ExactSizeIfKnown is minus one.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloRangeIDRetriever#AccumuloRangeIDRetriever(AccumuloStore,
   * InputOutput, User, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloRangeIDRetriever(AccumuloStore, InputOutput, User, IteratorSetting[]); then return spliterator ExactSizeIfKnown is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloRangeIDRetriever.<init>(AccumuloStore, InputOutput, User, IteratorSetting[])"
  })
  void testNewAccumuloRangeIDRetriever_thenReturnSpliteratorExactSizeIfKnownIsMinusOne3()
      throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsInRanges getElementsInRanges = new GetElementsInRanges();
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act
    AccumuloRangeIDRetriever<GetElementsInRanges> actualAccumuloRangeIDRetriever =
        new AccumuloRangeIDRetriever<>(
            store,
            getElementsInRanges,
            null,
            new IteratorSetting(
                1, (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult));

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    assertEquals(-1L, actualAccumuloRangeIDRetriever.spliterator().getExactSizeIfKnown());
  }
}
