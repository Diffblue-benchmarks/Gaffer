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
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsWithinSet;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class AccumuloIDWithinSetRetrieverDiffblueTest {
  /**
   * Test {@link AccumuloIDWithinSetRetriever#AccumuloIDWithinSetRetriever(AccumuloStore,
   * GetElementsWithinSet, User, boolean, IteratorSetting[])}.
   *
   * <ul>
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloIDWithinSetRetriever#AccumuloIDWithinSetRetriever(AccumuloStore, GetElementsWithinSet,
   * User, boolean, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloIDWithinSetRetriever(AccumuloStore, GetElementsWithinSet, User, boolean, IteratorSetting[]); then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloIDWithinSetRetriever.<init>(AccumuloStore, GetElementsWithinSet, User, boolean, IteratorSetting[])"
  })
  void testNewAccumuloIDWithinSetRetriever_thenCallsGetKeyPackage() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsWithinSet operation = new GetElementsWithinSet();
    User user = new User();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    // Act
    new AccumuloIDWithinSetRetriever(store, operation, user, true, iteratorSetting);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
  }

  /**
   * Test {@link AccumuloIDWithinSetRetriever#AccumuloIDWithinSetRetriever(AccumuloStore,
   * GetElementsWithinSet, User, boolean, IteratorSetting[])}.
   *
   * <ul>
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloIDWithinSetRetriever#AccumuloIDWithinSetRetriever(AccumuloStore, GetElementsWithinSet,
   * User, boolean, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloIDWithinSetRetriever(AccumuloStore, GetElementsWithinSet, User, boolean, IteratorSetting[]); then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloIDWithinSetRetriever.<init>(AccumuloStore, GetElementsWithinSet, User, boolean, IteratorSetting[])"
  })
  void testNewAccumuloIDWithinSetRetriever_thenCallsGetKeyPackage2() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsWithinSet operation = new GetElementsWithinSet();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    // Act
    new AccumuloIDWithinSetRetriever(store, operation, null, true, iteratorSetting);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
  }

  /**
   * Test {@link AccumuloIDWithinSetRetriever#AccumuloIDWithinSetRetriever(AccumuloStore,
   * GetElementsWithinSet, User, IteratorSetting[])}.
   *
   * <ul>
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloIDWithinSetRetriever#AccumuloIDWithinSetRetriever(AccumuloStore, GetElementsWithinSet,
   * User, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloIDWithinSetRetriever(AccumuloStore, GetElementsWithinSet, User, IteratorSetting[]); then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloIDWithinSetRetriever.<init>(AccumuloStore, GetElementsWithinSet, User, IteratorSetting[])"
  })
  void testNewAccumuloIDWithinSetRetriever_thenCallsGetKeyPackage3() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsWithinSet operation = new GetElementsWithinSet();
    User user = new User();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    // Act
    new AccumuloIDWithinSetRetriever(store, operation, user, iteratorSetting);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
  }

  /**
   * Test {@link AccumuloIDWithinSetRetriever#AccumuloIDWithinSetRetriever(AccumuloStore,
   * GetElementsWithinSet, User, IteratorSetting[])}.
   *
   * <ul>
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloIDWithinSetRetriever#AccumuloIDWithinSetRetriever(AccumuloStore, GetElementsWithinSet,
   * User, IteratorSetting[])}
   */
  @Test
  @DisplayName(
      "Test new AccumuloIDWithinSetRetriever(AccumuloStore, GetElementsWithinSet, User, IteratorSetting[]); then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloIDWithinSetRetriever.<init>(AccumuloStore, GetElementsWithinSet, User, IteratorSetting[])"
  })
  void testNewAccumuloIDWithinSetRetriever_thenCallsGetKeyPackage4() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsWithinSet operation = new GetElementsWithinSet();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    // Act
    new AccumuloIDWithinSetRetriever(store, operation, null, iteratorSetting);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
  }

  /**
   * Test {@link AccumuloIDWithinSetRetriever#hasSeeds()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Entity.Builder} (default constructor)
   *       group {@code Group} vertex {@code Vertex} build.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloIDWithinSetRetriever#hasSeeds()}
   */
  @Test
  @DisplayName(
      "Test hasSeeds(); given ArrayList() add Builder (default constructor) group 'Group' vertex 'Vertex' build; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AccumuloIDWithinSetRetriever.hasSeeds()"})
  void testHasSeeds_givenArrayListAddBuilderGroupGroupVertexVertexBuild_thenReturnTrue()
      throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());

    ArrayList<EntityId> entityIdList = new ArrayList<>();
    entityIdList.add(new Entity.Builder().group("Group").vertex("Vertex").build());

    GetElementsWithinSet operation = mock(GetElementsWithinSet.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput())
        .thenReturn(entityIdList);
    User user = new Builder().userId("42").build();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    AccumuloIDWithinSetRetriever accumuloIDWithinSetRetriever =
        new AccumuloIDWithinSetRetriever(store, operation, user, iteratorSetting);

    // Act
    boolean actualHasSeedsResult = accumuloIDWithinSetRetriever.hasSeeds();

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(operation).getInput();
    assertTrue(actualHasSeedsResult);
  }

  /**
   * Test {@link AccumuloIDWithinSetRetriever#hasSeeds()}.
   *
   * <ul>
   *   <li>Given {@link GetElementsWithinSet} {@link GetElementsWithinSet#close()} does nothing.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloIDWithinSetRetriever#hasSeeds()}
   */
  @Test
  @DisplayName(
      "Test hasSeeds(); given GetElementsWithinSet close() does nothing; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AccumuloIDWithinSetRetriever.hasSeeds()"})
  void testHasSeeds_givenGetElementsWithinSetCloseDoesNothing_thenReturnFalse()
      throws IOException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());

    GetElementsWithinSet operation = mock(GetElementsWithinSet.class);
    doNothing().when(operation).close();
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput())
        .thenReturn(new ArrayList<>());
    User user = new Builder().userId("42").build();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    AccumuloIDWithinSetRetriever accumuloIDWithinSetRetriever =
        new AccumuloIDWithinSetRetriever(store, operation, user, iteratorSetting);

    // Act
    boolean actualHasSeedsResult = accumuloIDWithinSetRetriever.hasSeeds();

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(operation).getInput();
    verify(operation).close();
    assertFalse(actualHasSeedsResult);
  }
}
