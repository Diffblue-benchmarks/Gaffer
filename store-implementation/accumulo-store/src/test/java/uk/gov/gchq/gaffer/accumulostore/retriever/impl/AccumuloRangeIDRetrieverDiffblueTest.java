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

package uk.gov.gchq.gaffer.accumulostore.retriever.impl;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.accumulo.core.client.IteratorSetting;
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
   *   <li>Given {@link ByteEntityKeyPackage#ByteEntityKeyPackage()}.
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloRangeIDRetriever#AccumuloRangeIDRetriever(AccumuloStore,
   * InputOutput, User, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloRangeIDRetriever(AccumuloStore, InputOutput, User, IteratorSetting[]); given ByteEntityKeyPackage(); then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloRangeIDRetriever.<init>(AccumuloStore, InputOutput, User, IteratorSetting[])"
  })
  void testNewAccumuloRangeIDRetriever_givenByteEntityKeyPackage_thenCallsGetKeyPackage()
      throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsInRanges getElementsInRanges = new GetElementsInRanges();
    User user = new User();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    // Act
    new AccumuloRangeIDRetriever<>(store, getElementsInRanges, user, iteratorSetting);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
  }

  /**
   * Test {@link AccumuloRangeIDRetriever#AccumuloRangeIDRetriever(AccumuloStore, InputOutput, User,
   * IteratorSetting[])}.
   *
   * <ul>
   *   <li>Given {@link ByteEntityKeyPackage#ByteEntityKeyPackage()}.
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloRangeIDRetriever#AccumuloRangeIDRetriever(AccumuloStore,
   * InputOutput, User, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloRangeIDRetriever(AccumuloStore, InputOutput, User, IteratorSetting[]); given ByteEntityKeyPackage(); then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloRangeIDRetriever.<init>(AccumuloStore, InputOutput, User, IteratorSetting[])"
  })
  void testNewAccumuloRangeIDRetriever_givenByteEntityKeyPackage_thenCallsGetKeyPackage2()
      throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    User user = new User();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    // Act
    new AccumuloRangeIDRetriever<>(store, null, user, iteratorSetting);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
  }

  /**
   * Test {@link AccumuloRangeIDRetriever#AccumuloRangeIDRetriever(AccumuloStore, InputOutput, User,
   * IteratorSetting[])}.
   *
   * <ul>
   *   <li>Given {@link ByteEntityKeyPackage#ByteEntityKeyPackage()}.
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloRangeIDRetriever#AccumuloRangeIDRetriever(AccumuloStore,
   * InputOutput, User, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloRangeIDRetriever(AccumuloStore, InputOutput, User, IteratorSetting[]); given ByteEntityKeyPackage(); then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloRangeIDRetriever.<init>(AccumuloStore, InputOutput, User, IteratorSetting[])"
  })
  void testNewAccumuloRangeIDRetriever_givenByteEntityKeyPackage_thenCallsGetKeyPackage3()
      throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsInRanges getElementsInRanges = new GetElementsInRanges();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    // Act
    new AccumuloRangeIDRetriever<>(store, getElementsInRanges, null, iteratorSetting);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
  }
}
