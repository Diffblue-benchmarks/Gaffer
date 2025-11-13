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

package uk.gov.gchq.gaffer.spark.operation.dataframe.converter.schema;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.apache.spark.sql.types.StructType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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
   * <ul>
   *   <li>Given {@link FreqMapConverter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema, View, List)}
   */
  @Test
  @DisplayName("Test new SchemaToStructTypeConverter(Schema, View, List); given FreqMapConverter (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaToStructTypeConverter.<init>(Schema, View, List)"})
  void testNewSchemaToStructTypeConverter_givenFreqMapConverter() {
    // Arrange
    Schema schema = new Schema();
    View view = new View();

    ArrayList<Converter> converters = new ArrayList<>();
    converters.add(new FreqMapConverter());

    // Act and Assert
    StructType structType = (new SchemaToStructTypeConverter(schema, view, converters)).getStructType();
    assertTrue(structType.toList() instanceof scala.collection.immutable.$colon$colon);
    assertTrue(structType.toStream() instanceof Cons);
    assertTrue(structType.toIndexedSeq() instanceof Vector);
    assertSame(structType, structType.repr());
    assertSame(structType, structType.seq());
    assertSame(structType, structType.toIterable());
    assertSame(structType, structType.toSeq());
    assertSame(structType, structType.toTraversable());
  }

  /**
   * Test {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema, View, List)}.
   * <ul>
   *   <li>Given {@link FreqMapConverter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema, View, List)}
   */
  @Test
  @DisplayName("Test new SchemaToStructTypeConverter(Schema, View, List); given FreqMapConverter (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaToStructTypeConverter.<init>(Schema, View, List)"})
  void testNewSchemaToStructTypeConverter_givenFreqMapConverter2() {
    // Arrange
    Schema schema = new Schema();
    View view = new View();

    ArrayList<Converter> converters = new ArrayList<>();
    converters.add(new FreqMapConverter());
    converters.add(new FreqMapConverter());

    // Act and Assert
    StructType structType = (new SchemaToStructTypeConverter(schema, view, converters)).getStructType();
    assertTrue(structType.toList() instanceof scala.collection.immutable.$colon$colon);
    assertTrue(structType.toStream() instanceof Cons);
    assertTrue(structType.toIndexedSeq() instanceof Vector);
    assertSame(structType, structType.repr());
    assertSame(structType, structType.seq());
    assertSame(structType, structType.toIterable());
    assertSame(structType, structType.toSeq());
    assertSame(structType, structType.toTraversable());
  }

  /**
   * Test {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema, View, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema, View, List)}
   */
  @Test
  @DisplayName("Test new SchemaToStructTypeConverter(Schema, View, List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaToStructTypeConverter.<init>(Schema, View, List)"})
  void testNewSchemaToStructTypeConverter_whenArrayList() {
    // Arrange
    Schema schema = new Schema();
    View view = new View();

    // Act and Assert
    StructType structType = (new SchemaToStructTypeConverter(schema, view, new ArrayList<>())).getStructType();
    assertTrue(structType.toList() instanceof scala.collection.immutable.$colon$colon);
    assertTrue(structType.toStream() instanceof Cons);
    assertTrue(structType.toIndexedSeq() instanceof Vector);
    assertSame(structType, structType.repr());
    assertSame(structType, structType.seq());
    assertSame(structType, structType.toIterable());
    assertSame(structType, structType.toSeq());
    assertSame(structType, structType.toTraversable());
  }

  /**
   * Test {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema, View, List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaToStructTypeConverter#SchemaToStructTypeConverter(Schema, View, List)}
   */
  @Test
  @DisplayName("Test new SchemaToStructTypeConverter(Schema, View, List); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaToStructTypeConverter.<init>(Schema, View, List)"})
  void testNewSchemaToStructTypeConverter_whenNull() {
    // Arrange
    Schema schema = new Schema();

    // Act and Assert
    StructType structType = (new SchemaToStructTypeConverter(schema, new View(), null)).getStructType();
    assertTrue(structType.toList() instanceof scala.collection.immutable.$colon$colon);
    assertTrue(structType.toStream() instanceof Cons);
    assertTrue(structType.toIndexedSeq() instanceof Vector);
    assertSame(structType, structType.repr());
    assertSame(structType, structType.seq());
    assertSame(structType, structType.toIterable());
    assertSame(structType, structType.toSeq());
    assertSame(structType, structType.toTraversable());
  }
}
