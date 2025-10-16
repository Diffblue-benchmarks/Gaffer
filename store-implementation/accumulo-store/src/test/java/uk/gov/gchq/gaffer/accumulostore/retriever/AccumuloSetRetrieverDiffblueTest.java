package uk.gov.gchq.gaffer.accumulostore.retriever;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class AccumuloSetRetrieverDiffblueTest {
  /**
   * Test {@link AccumuloSetRetriever#setReadEntriesIntoMemory(boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloSetRetriever#setReadEntriesIntoMemory(boolean)}
   */
  @Test
  @DisplayName("Test setReadEntriesIntoMemory(boolean); then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloSetRetriever.setReadEntriesIntoMemory(boolean)"})
  void testSetReadEntriesIntoMemory_thenCallsGetKeyPackage() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    User user = new Builder().userId("42").build();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    AccumuloIDBetweenSetsRetriever accumuloIDBetweenSetsRetriever =
        new AccumuloIDBetweenSetsRetriever(store, operation, user, iteratorSetting);

    // Act
    accumuloIDBetweenSetsRetriever.setReadEntriesIntoMemory(true);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
  }

  /**
   * Test {@link AccumuloSetRetriever#iterator()}.
   *
   * <ul>
   *   <li>Then return {@link EmptyIterator}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloSetRetriever#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); then return EmptyIterator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator AccumuloSetRetriever.iterator()"})
  void testIterator_thenReturnEmptyIterator() throws IOException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());

    GetElementsBetweenSets operation = mock(GetElementsBetweenSets.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput())
        .thenReturn(new ArrayList<>());
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInputB())
        .thenReturn(new ArrayList<>());
    doNothing().when(operation).close();
    User user = new Builder().userId("42").build();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    AccumuloIDBetweenSetsRetriever accumuloIDBetweenSetsRetriever =
        new AccumuloIDBetweenSetsRetriever(store, operation, user, iteratorSetting);

    // Act
    Iterator<Element> actualIteratorResult = accumuloIDBetweenSetsRetriever.iterator();

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
   *
   * <ul>
   *   <li>Given {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloSetRetriever#extractVertices(Iterator)}
   */
  @Test
  @DisplayName(
      "Test extractVertices(Iterator); given Builder (default constructor) group 'Group' vertex 'Vertex' build; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AccumuloSetRetriever.extractVertices(Iterator)"})
  void testExtractVertices_givenBuilderGroupGroupVertexVertexBuild_thenReturnSizeIsOne()
      throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    User user = new Builder().userId("42").build();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    AccumuloIDBetweenSetsRetriever accumuloIDBetweenSetsRetriever =
        new AccumuloIDBetweenSetsRetriever(store, operation, user, iteratorSetting);

    ArrayList<EntityId> entityIdList = new ArrayList<>();
    entityIdList.add(new Entity.Builder().group("Group").vertex("Vertex").build());
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
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloSetRetriever#extractVertices(Iterator)}
   */
  @Test
  @DisplayName("Test extractVertices(Iterator); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AccumuloSetRetriever.extractVertices(Iterator)"})
  void testExtractVertices_thenReturnEmpty() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    User user = new Builder().userId("42").build();
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    AccumuloIDBetweenSetsRetriever accumuloIDBetweenSetsRetriever =
        new AccumuloIDBetweenSetsRetriever(store, operation, user, iteratorSetting);

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
