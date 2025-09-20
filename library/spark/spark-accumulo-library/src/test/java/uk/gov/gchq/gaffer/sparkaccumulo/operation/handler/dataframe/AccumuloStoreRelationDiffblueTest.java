package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.dataframe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scala.collection.Iterable;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Stream.Cons;
import scala.collection.immutable.Vector;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.property.Converter;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.property.impl.FreqMapConverter;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.user.User;

class AccumuloStoreRelationDiffblueTest {
  /**
   * Test {@link AccumuloStoreRelation#AccumuloStoreRelation(Context, List, View, AccumuloStore,
   * Map)}.
   *
   * <ul>
   *   <li>Given {@link FreqMapConverter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStoreRelation#AccumuloStoreRelation(Context, List, View,
   * AccumuloStore, Map)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloStoreRelation(Context, List, View, AccumuloStore, Map); given FreqMapConverter (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewAccumuloStoreRelation_givenFreqMapConverter() {
    // Arrange
    Context context = new Context();

    ArrayList<Converter> converters = new ArrayList<>();
    converters.add(new FreqMapConverter());
    View view = new View();
    AccumuloStore store = new AccumuloStore();

    // Act
    AccumuloStoreRelation actualAccumuloStoreRelation =
        new AccumuloStoreRelation(context, converters, view, store, new HashMap<>());

    // Assert
    StructType schemaResult = actualAccumuloStoreRelation.schema();
    assertTrue(schemaResult.toList() instanceof scala.collection.immutable.$colon$colon);
    assertTrue(schemaResult.toStream() instanceof Cons);
    assertTrue(schemaResult.toIndexedSeq() instanceof Vector);
    Object actualReprResult = schemaResult.repr();
    assertSame(schemaResult, actualReprResult);
    Seq<StructField> actualSeqResult = schemaResult.seq();
    assertSame(schemaResult, actualSeqResult);
    Iterable<StructField> actualToIterableResult = schemaResult.toIterable();
    assertSame(schemaResult, actualToIterableResult);
    Seq<StructField> actualToSeqResult = schemaResult.toSeq();
    assertSame(schemaResult, actualToSeqResult);
    Traversable<StructField> actualToTraversableResult = schemaResult.toTraversable();
    assertSame(schemaResult, actualToTraversableResult);
  }

  /**
   * Test {@link AccumuloStoreRelation#AccumuloStoreRelation(Context, List, View, AccumuloStore,
   * Map)}.
   *
   * <ul>
   *   <li>Given {@link FreqMapConverter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStoreRelation#AccumuloStoreRelation(Context, List, View,
   * AccumuloStore, Map)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloStoreRelation(Context, List, View, AccumuloStore, Map); given FreqMapConverter (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewAccumuloStoreRelation_givenFreqMapConverter2() {
    // Arrange
    Context context = new Context();

    ArrayList<Converter> converters = new ArrayList<>();
    converters.add(new FreqMapConverter());
    converters.add(new FreqMapConverter());
    View view = new View();
    AccumuloStore store = new AccumuloStore();

    // Act
    AccumuloStoreRelation actualAccumuloStoreRelation =
        new AccumuloStoreRelation(context, converters, view, store, new HashMap<>());

    // Assert
    StructType schemaResult = actualAccumuloStoreRelation.schema();
    assertTrue(schemaResult.toList() instanceof scala.collection.immutable.$colon$colon);
    assertTrue(schemaResult.toStream() instanceof Cons);
    assertTrue(schemaResult.toIndexedSeq() instanceof Vector);
    Object actualReprResult = schemaResult.repr();
    assertSame(schemaResult, actualReprResult);
    Seq<StructField> actualSeqResult = schemaResult.seq();
    assertSame(schemaResult, actualSeqResult);
    Iterable<StructField> actualToIterableResult = schemaResult.toIterable();
    assertSame(schemaResult, actualToIterableResult);
    Seq<StructField> actualToSeqResult = schemaResult.toSeq();
    assertSame(schemaResult, actualToSeqResult);
    Traversable<StructField> actualToTraversableResult = schemaResult.toTraversable();
    assertSame(schemaResult, actualToTraversableResult);
  }

  /**
   * Test {@link AccumuloStoreRelation#schema()}.
   *
   * <p>Method under test: {@link AccumuloStoreRelation#schema()}
   */
  @Test
  @DisplayName("Test schema()")
  @Tag("MaintainedByDiffblue")
  void testSchema() {
    // Arrange
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    ArrayList<Converter> converters = new ArrayList<>();
    View view = new View();
    AccumuloStore store = new AccumuloStore();

    AccumuloStoreRelation accumuloStoreRelation =
        new AccumuloStoreRelation(context, converters, view, store, new HashMap<>());

    // Act
    StructType actualSchemaResult = accumuloStoreRelation.schema();

    // Assert
    assertTrue(actualSchemaResult.companion() instanceof scala.collection.Seq$);
    Object distinctResult = actualSchemaResult.distinct();
    assertTrue(distinctResult instanceof scala.collection.immutable.$colon$colon);
    scala.collection.immutable.List<StructField> toListResult = actualSchemaResult.toList();
    assertTrue(toListResult instanceof scala.collection.immutable.$colon$colon);
    Object initResult = actualSchemaResult.init();
    assertTrue(initResult instanceof scala.collection.immutable.Nil$);
    Stream<StructField> toStreamResult = actualSchemaResult.toStream();
    assertTrue(toStreamResult instanceof Cons);
    IndexedSeq<StructField> toIndexedSeqResult = actualSchemaResult.toIndexedSeq();
    assertTrue(toIndexedSeqResult instanceof Vector);
    assertEquals(1, actualSchemaResult.length());
    assertEquals(1, actualSchemaResult.size());
    StructField[] copy$default$1Result = actualSchemaResult.copy$default$1();
    assertEquals(1, copy$default$1Result.length);
    assertFalse(actualSchemaResult.isEmpty());
    assertTrue(actualSchemaResult.hasDefiniteSize());
    assertTrue(actualSchemaResult.isTraversableAgain());
    assertEquals(distinctResult, actualSchemaResult.toVector());
    assertEquals(distinctResult, toListResult);
    assertEquals(distinctResult, toStreamResult);
    assertEquals(distinctResult, toIndexedSeqResult);
    assertSame(copy$default$1Result, actualSchemaResult.fields());
    Object actualReprResult = actualSchemaResult.repr();
    assertSame(actualSchemaResult, actualReprResult);
    Seq<StructField> actualSeqResult = actualSchemaResult.seq();
    assertSame(actualSchemaResult, actualSeqResult);
    Iterable<StructField> actualToIterableResult = actualSchemaResult.toIterable();
    assertSame(actualSchemaResult, actualToIterableResult);
    Seq<StructField> actualToSeqResult = actualSchemaResult.toSeq();
    assertSame(actualSchemaResult, actualToSeqResult);
    Traversable<StructField> actualToTraversableResult = actualSchemaResult.toTraversable();
    assertSame(actualSchemaResult, actualToTraversableResult);
    assertSame(initResult, actualSchemaResult.tail());
  }

  /**
   * Test {@link AccumuloStoreRelation#buildScan(String[])} with {@code requiredColumns}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStoreRelation#buildScan(String[])}
   */
  @Test
  @DisplayName("Test buildScan(String[]) with 'requiredColumns'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuildScanWithRequiredColumns_thenReturnNull() throws OperationException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.execute(Mockito.<Output<RDD<Element>>>any(), Mockito.<Context>any()))
        .thenThrow(new OperationException("An error occurred"));
    when(store.getSchema()).thenReturn(new Schema());

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    ArrayList<Converter> converters = new ArrayList<>();
    View view = new View();

    AccumuloStoreRelation accumuloStoreRelation =
        new AccumuloStoreRelation(context, converters, view, store, new HashMap<>());

    // Act
    RDD<Row> actualBuildScanResult =
        accumuloStoreRelation.buildScan(new String[] {"Required Columns"});

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
    verify(store).getSchema();
    assertNull(actualBuildScanResult);
  }

  /**
   * Test {@link AccumuloStoreRelation#buildScan(String[])} with {@code requiredColumns}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStoreRelation#buildScan(String[])}
   */
  @Test
  @DisplayName("Test buildScan(String[]) with 'requiredColumns'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuildScanWithRequiredColumns_thenReturnNull2() throws OperationException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.execute(Mockito.<Output<RDD<Element>>>any(), Mockito.<Context>any()))
        .thenThrow(new OperationException("An error occurred"));
    when(store.getSchema()).thenReturn(new Schema());

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    ArrayList<Converter> converters = new ArrayList<>();
    View view = new View();

    AccumuloStoreRelation accumuloStoreRelation =
        new AccumuloStoreRelation(context, converters, view, store, new HashMap<>());

    // Act
    RDD<Row> actualBuildScanResult = accumuloStoreRelation.buildScan(new String[] {});

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
    verify(store).getSchema();
    assertNull(actualBuildScanResult);
  }

  /**
   * Test {@link AccumuloStoreRelation#buildScan()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloStoreRelation#buildScan()}
   */
  @Test
  @DisplayName("Test buildScan(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuildScan_thenReturnNull() throws OperationException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.execute(Mockito.<Output<RDD<Element>>>any(), Mockito.<Context>any()))
        .thenThrow(new OperationException("An error occurred"));
    when(store.getSchema()).thenReturn(new Schema());

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    ArrayList<Converter> converters = new ArrayList<>();
    View view = new View();

    AccumuloStoreRelation accumuloStoreRelation =
        new AccumuloStoreRelation(context, converters, view, store, new HashMap<>());

    // Act
    RDD<Row> actualBuildScanResult = accumuloStoreRelation.buildScan();

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
    verify(store).getSchema();
    assertNull(actualBuildScanResult);
  }
}
