package uk.gov.gchq.gaffer.accumulostore.key.core;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.accumulo.core.data.Range;
import org.apache.accumulo.core.dataImpl.thrift.TKey;
import org.apache.accumulo.core.dataImpl.thrift.TRange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityRangeFactory;
import uk.gov.gchq.gaffer.accumulostore.key.exception.RangeFactoryException;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.operation.graph.GraphFilters;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AbstractCoreKeyRangeFactoryDiffblueTest {
  /**
   * Test {@link AbstractCoreKeyRangeFactory#getRange(ElementId, GraphFilters)} with {@code
   * elementId}, {@code operation}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyRangeFactory#getRange(ElementId, GraphFilters)}
   */
  @Test
  @DisplayName(
      "Test getRange(ElementId, GraphFilters) with 'elementId', 'operation'; given View (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List AbstractCoreKeyRangeFactory.getRange(ElementId, GraphFilters)"
  })
  void testGetRangeWithElementIdOperation_givenView_thenReturnEmpty() throws RangeFactoryException {
    // Arrange
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(new Schema());
    EdgeSeed elementId = new EdgeSeed();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setView(new View());

    // Act and Assert
    assertTrue(byteEntityRangeFactory.getRange(elementId, operation).isEmpty());
  }

  /**
   * Test {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}.
   *
   * <ul>
   *   <li>Then return toThrift Start ColFamily is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoreKeyRangeFactory#getRangeFromPair(Pair, GraphFilters)}
   */
  @Test
  @DisplayName(
      "Test getRangeFromPair(Pair, GraphFilters); then return toThrift Start ColFamily is empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Range AbstractCoreKeyRangeFactory.getRangeFromPair(Pair, GraphFilters)"})
  void testGetRangeFromPair_thenReturnToThriftStartColFamilyIsEmptyArrayOfByte()
      throws RangeFactoryException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVertexSerialiser()).thenReturn(new AvroSerialiser());
    ByteEntityRangeFactory byteEntityRangeFactory = new ByteEntityRangeFactory(schema);
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    Edge edge2 =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    Pair<ElementId, ElementId> pairRange = new Pair<>(edge, edge2);

    View view = mock(View.class);
    when(view.hasEdges()).thenReturn(false);
    when(view.hasEntities()).thenReturn(true);

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setView(view);

    // Act
    Range actualRangeFromPair = byteEntityRangeFactory.getRangeFromPair(pairRange, operation);

    // Assert
    verify(view, atLeast(1)).hasEdges();
    verify(view, atLeast(1)).hasEntities();
    verify(schema, atLeast(1)).getVertexSerialiser();
    TRange toThriftResult = actualRangeFromPair.toThrift();
    TKey start = toThriftResult.getStart();
    assertArrayEquals(new byte[] {}, start.getColFamily());
    TKey stop = toThriftResult.getStop();
    assertArrayEquals(new byte[] {}, stop.getColFamily());
    assertArrayEquals(new byte[] {}, start.getColQualifier());
    assertArrayEquals(new byte[] {}, stop.getColQualifier());
    assertArrayEquals(new byte[] {}, start.getColVisibility());
    assertArrayEquals(new byte[] {}, stop.getColVisibility());
    assertArrayEquals(
        new byte[] {}, actualRangeFromPair.getEndKey().getColumnVisibilityParsed().flatten());
    assertArrayEquals(
        new byte[] {}, actualRangeFromPair.getStartKey().getColumnVisibilityParsed().flatten());
  }
}
