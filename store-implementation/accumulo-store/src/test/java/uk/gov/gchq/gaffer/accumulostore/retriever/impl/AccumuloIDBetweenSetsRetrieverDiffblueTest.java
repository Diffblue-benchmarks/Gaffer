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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.accumulo.core.client.IteratorSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.user.User;

class AccumuloIDBetweenSetsRetrieverDiffblueTest {
  /**
   * Test {@link AccumuloIDBetweenSetsRetriever#AccumuloIDBetweenSetsRetriever(AccumuloStore,
   * GetElementsBetweenSets, User, boolean, IteratorSetting[])}.
   *
   * <ul>
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloIDBetweenSetsRetriever#AccumuloIDBetweenSetsRetriever(AccumuloStore,
   * GetElementsBetweenSets, User, boolean, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloIDBetweenSetsRetriever(AccumuloStore, GetElementsBetweenSets, User, boolean, IteratorSetting[]); then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloIDBetweenSetsRetriever.<init>(AccumuloStore, GetElementsBetweenSets, User, boolean, IteratorSetting[])"
  })
  void testNewAccumuloIDBetweenSetsRetriever_thenCallsGetKeyPackage() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    User user = new User();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    // Act
    new AccumuloIDBetweenSetsRetriever(store, operation, user, true, iteratorSetting);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
  }

  /**
   * Test {@link AccumuloIDBetweenSetsRetriever#AccumuloIDBetweenSetsRetriever(AccumuloStore,
   * GetElementsBetweenSets, User, boolean, IteratorSetting[])}.
   *
   * <ul>
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloIDBetweenSetsRetriever#AccumuloIDBetweenSetsRetriever(AccumuloStore,
   * GetElementsBetweenSets, User, boolean, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloIDBetweenSetsRetriever(AccumuloStore, GetElementsBetweenSets, User, boolean, IteratorSetting[]); then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloIDBetweenSetsRetriever.<init>(AccumuloStore, GetElementsBetweenSets, User, boolean, IteratorSetting[])"
  })
  void testNewAccumuloIDBetweenSetsRetriever_thenCallsGetKeyPackage2() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    // Act
    new AccumuloIDBetweenSetsRetriever(store, operation, null, true, iteratorSetting);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
  }

  /**
   * Test {@link AccumuloIDBetweenSetsRetriever#AccumuloIDBetweenSetsRetriever(AccumuloStore,
   * GetElementsBetweenSets, User, IteratorSetting[])}.
   *
   * <ul>
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloIDBetweenSetsRetriever#AccumuloIDBetweenSetsRetriever(AccumuloStore,
   * GetElementsBetweenSets, User, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloIDBetweenSetsRetriever(AccumuloStore, GetElementsBetweenSets, User, IteratorSetting[]); then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloIDBetweenSetsRetriever.<init>(AccumuloStore, GetElementsBetweenSets, User, IteratorSetting[])"
  })
  void testNewAccumuloIDBetweenSetsRetriever_thenCallsGetKeyPackage3() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    User user = new User();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    // Act
    new AccumuloIDBetweenSetsRetriever(store, operation, user, iteratorSetting);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
  }

  /**
   * Test {@link AccumuloIDBetweenSetsRetriever#AccumuloIDBetweenSetsRetriever(AccumuloStore,
   * GetElementsBetweenSets, User, IteratorSetting[])}.
   *
   * <ul>
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloIDBetweenSetsRetriever#AccumuloIDBetweenSetsRetriever(AccumuloStore,
   * GetElementsBetweenSets, User, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloIDBetweenSetsRetriever(AccumuloStore, GetElementsBetweenSets, User, IteratorSetting[]); then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloIDBetweenSetsRetriever.<init>(AccumuloStore, GetElementsBetweenSets, User, IteratorSetting[])"
  })
  void testNewAccumuloIDBetweenSetsRetriever_thenCallsGetKeyPackage4() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    // Act
    new AccumuloIDBetweenSetsRetriever(store, operation, null, iteratorSetting);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
  }

  /**
   * Test {@link AccumuloIDBetweenSetsRetriever#hasSeeds()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Entity.Builder} (default constructor)
   *       group {@code Group} vertex {@code Vertex} build.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloIDBetweenSetsRetriever#hasSeeds()}
   */
  @Test
  @DisplayName(
      "Test hasSeeds(); given ArrayList() add Builder (default constructor) group 'Group' vertex 'Vertex' build; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AccumuloIDBetweenSetsRetriever.hasSeeds()"})
  void testHasSeeds_givenArrayListAddBuilderGroupGroupVertexVertexBuild_thenReturnFalse()
      throws IOException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());

    ArrayList<EntityId> entityIdList = new ArrayList<>();
    entityIdList.add(new Builder().group("Group").vertex("Vertex").build());

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput())
        .thenReturn(entityIdList);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInputB())
        .thenReturn(new ArrayList<>());
    doNothing().when(operation).close();
    User user = new User.Builder().userId("42").build();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    AccumuloIDBetweenSetsRetriever accumuloIDBetweenSetsRetriever =
        new AccumuloIDBetweenSetsRetriever(store, operation, user, iteratorSetting);

    // Act
    boolean actualHasSeedsResult = accumuloIDBetweenSetsRetriever.hasSeeds();

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(operation).close();
    verify(operation).getInput();
    verify(operation).getInputB();
    assertFalse(actualHasSeedsResult);
  }

  /**
   * Test {@link AccumuloIDBetweenSetsRetriever#hasSeeds()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Entity.Builder} (default constructor)
   *       group {@code Group} vertex {@code Vertex} build.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloIDBetweenSetsRetriever#hasSeeds()}
   */
  @Test
  @DisplayName(
      "Test hasSeeds(); given ArrayList() add Builder (default constructor) group 'Group' vertex 'Vertex' build; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AccumuloIDBetweenSetsRetriever.hasSeeds()"})
  void testHasSeeds_givenArrayListAddBuilderGroupGroupVertexVertexBuild_thenReturnTrue()
      throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());

    ArrayList<EntityId> entityIdList = new ArrayList<>();
    entityIdList.add(new Builder().group("Group").vertex("Vertex").build());

    ArrayList<EntityId> entityIdList2 = new ArrayList<>();
    entityIdList2.add(new Builder().group("Group").vertex("Vertex").build());

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput())
        .thenReturn(entityIdList);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInputB())
        .thenReturn(entityIdList2);
    User user = new User.Builder().userId("42").build();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    AccumuloIDBetweenSetsRetriever accumuloIDBetweenSetsRetriever =
        new AccumuloIDBetweenSetsRetriever(store, operation, user, iteratorSetting);

    // Act
    boolean actualHasSeedsResult = accumuloIDBetweenSetsRetriever.hasSeeds();

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(operation).getInput();
    verify(operation).getInputB();
    assertTrue(actualHasSeedsResult);
  }

  /**
   * Test {@link AccumuloIDBetweenSetsRetriever#hasSeeds()}.
   *
   * <ul>
   *   <li>Given {@link GetElementsBetweenSets} {@link GetElementsBetweenSets#close()} does nothing.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloIDBetweenSetsRetriever#hasSeeds()}
   */
  @Test
  @DisplayName(
      "Test hasSeeds(); given GetElementsBetweenSets close() does nothing; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AccumuloIDBetweenSetsRetriever.hasSeeds()"})
  void testHasSeeds_givenGetElementsBetweenSetsCloseDoesNothing_thenReturnFalse()
      throws IOException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput())
        .thenReturn(new ArrayList<>());
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInputB())
        .thenReturn(new ArrayList<>());
    doNothing().when(operation).close();
    User user = new User.Builder().userId("42").build();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    AccumuloIDBetweenSetsRetriever accumuloIDBetweenSetsRetriever =
        new AccumuloIDBetweenSetsRetriever(store, operation, user, iteratorSetting);

    // Act
    boolean actualHasSeedsResult = accumuloIDBetweenSetsRetriever.hasSeeds();

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(operation).close();
    verify(operation).getInput();
    verify(operation).getInputB();
    assertFalse(actualHasSeedsResult);
  }
}
