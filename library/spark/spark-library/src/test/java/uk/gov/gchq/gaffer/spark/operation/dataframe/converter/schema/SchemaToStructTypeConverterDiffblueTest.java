package uk.gov.gchq.gaffer.spark.operation.dataframe.converter.schema;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import scala.collection.Iterable;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Stream.Cons;
import scala.collection.immutable.Vector;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.property.Converter;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.property.impl.FreqMapConverter;
import uk.gov.gchq.gaffer.store.schema.Schema;

class SchemaToStructTypeConverterDiffblueTest {
  /**
   * Test {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema, View, List)}.
   *
   * <ul>
   *   <li>Given {@link FreqMapConverter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema,
   * View, List)}
   */
  @Test
  @DisplayName(
      "Test new SchemaToStructTypeConverter(Schema, View, List); given FreqMapConverter (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewSchemaToStructTypeConverter_givenFreqMapConverter() {
    // Arrange
    Schema schema = new Schema();
    View view = new View();

    ArrayList<Converter> converters = new ArrayList<>();
    converters.add(new FreqMapConverter());

    // Act
    SchemaToStructTypeConverter actualSchemaToStructTypeConverter =
        new SchemaToStructTypeConverter(schema, view, converters);

    // Assert
    StructType structType = actualSchemaToStructTypeConverter.getStructType();
    assertTrue(structType.toList() instanceof scala.collection.immutable.$colon$colon);
    assertTrue(structType.toStream() instanceof Cons);
    assertTrue(structType.toIndexedSeq() instanceof Vector);
    Object actualReprResult = structType.repr();
    assertSame(structType, actualReprResult);
    Seq<StructField> actualSeqResult = structType.seq();
    assertSame(structType, actualSeqResult);
    Iterable<StructField> actualToIterableResult = structType.toIterable();
    assertSame(structType, actualToIterableResult);
    Seq<StructField> actualToSeqResult = structType.toSeq();
    assertSame(structType, actualToSeqResult);
    Traversable<StructField> actualToTraversableResult = structType.toTraversable();
    assertSame(structType, actualToTraversableResult);
  }

  /**
   * Test {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema, View, List)}.
   *
   * <ul>
   *   <li>Given {@link FreqMapConverter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema,
   * View, List)}
   */
  @Test
  @DisplayName(
      "Test new SchemaToStructTypeConverter(Schema, View, List); given FreqMapConverter (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewSchemaToStructTypeConverter_givenFreqMapConverter2() {
    // Arrange
    Schema schema = new Schema();
    View view = new View();

    ArrayList<Converter> converters = new ArrayList<>();
    converters.add(new FreqMapConverter());
    converters.add(new FreqMapConverter());

    // Act
    SchemaToStructTypeConverter actualSchemaToStructTypeConverter =
        new SchemaToStructTypeConverter(schema, view, converters);

    // Assert
    StructType structType = actualSchemaToStructTypeConverter.getStructType();
    assertTrue(structType.toList() instanceof scala.collection.immutable.$colon$colon);
    assertTrue(structType.toStream() instanceof Cons);
    assertTrue(structType.toIndexedSeq() instanceof Vector);
    Object actualReprResult = structType.repr();
    assertSame(structType, actualReprResult);
    Seq<StructField> actualSeqResult = structType.seq();
    assertSame(structType, actualSeqResult);
    Iterable<StructField> actualToIterableResult = structType.toIterable();
    assertSame(structType, actualToIterableResult);
    Seq<StructField> actualToSeqResult = structType.toSeq();
    assertSame(structType, actualToSeqResult);
    Traversable<StructField> actualToTraversableResult = structType.toTraversable();
    assertSame(structType, actualToTraversableResult);
  }

  /**
   * Test {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema, View, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema,
   * View, List)}
   */
  @Test
  @DisplayName("Test new SchemaToStructTypeConverter(Schema, View, List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testNewSchemaToStructTypeConverter_whenArrayList() {
    // Arrange
    Schema schema = new Schema();
    View view = new View();

    // Act
    SchemaToStructTypeConverter actualSchemaToStructTypeConverter =
        new SchemaToStructTypeConverter(schema, view, new ArrayList<>());

    // Assert
    StructType structType = actualSchemaToStructTypeConverter.getStructType();
    assertTrue(structType.toList() instanceof scala.collection.immutable.$colon$colon);
    assertTrue(structType.toStream() instanceof Cons);
    assertTrue(structType.toIndexedSeq() instanceof Vector);
    Object actualReprResult = structType.repr();
    assertSame(structType, actualReprResult);
    Seq<StructField> actualSeqResult = structType.seq();
    assertSame(structType, actualSeqResult);
    Iterable<StructField> actualToIterableResult = structType.toIterable();
    assertSame(structType, actualToIterableResult);
    Seq<StructField> actualToSeqResult = structType.toSeq();
    assertSame(structType, actualToSeqResult);
    Traversable<StructField> actualToTraversableResult = structType.toTraversable();
    assertSame(structType, actualToTraversableResult);
  }

  /**
   * Test {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema, View, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema,
   * View, List)}
   */
  @Test
  @DisplayName("Test new SchemaToStructTypeConverter(Schema, View, List); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testNewSchemaToStructTypeConverter_whenNull() {
    // Arrange
    Schema schema = new Schema();

    // Act
    SchemaToStructTypeConverter actualSchemaToStructTypeConverter =
        new SchemaToStructTypeConverter(schema, new View(), null);

    // Assert
    StructType structType = actualSchemaToStructTypeConverter.getStructType();
    assertTrue(structType.toList() instanceof scala.collection.immutable.$colon$colon);
    assertTrue(structType.toStream() instanceof Cons);
    assertTrue(structType.toIndexedSeq() instanceof Vector);
    Object actualReprResult = structType.repr();
    assertSame(structType, actualReprResult);
    Seq<StructField> actualSeqResult = structType.seq();
    assertSame(structType, actualSeqResult);
    Iterable<StructField> actualToIterableResult = structType.toIterable();
    assertSame(structType, actualToIterableResult);
    Seq<StructField> actualToSeqResult = structType.toSeq();
    assertSame(structType, actualToSeqResult);
    Traversable<StructField> actualToTraversableResult = structType.toTraversable();
    assertSame(structType, actualToTraversableResult);
  }
}
