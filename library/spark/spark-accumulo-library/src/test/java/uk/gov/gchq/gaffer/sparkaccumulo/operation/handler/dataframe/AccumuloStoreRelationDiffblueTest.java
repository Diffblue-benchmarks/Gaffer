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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.dataframe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Stream.Cons;
import scala.collection.immutable.Vector;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.property.Converter;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.property.impl.FreqMapConverter;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.user.User;

class AccumuloStoreRelationDiffblueTest {
  /**
   * Test {@link AccumuloStoreRelation#AccumuloStoreRelation(Context, List, View, AccumuloStore, Map)}.
   * <ul>
   *   <li>Given {@link FreqMapConverter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloStoreRelation#AccumuloStoreRelation(Context, List, View, AccumuloStore, Map)}
   */
  @Test
  @DisplayName("Test new AccumuloStoreRelation(Context, List, View, AccumuloStore, Map); given FreqMapConverter (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloStoreRelation.<init>(Context, List, View, AccumuloStore, Map)"})
  void testNewAccumuloStoreRelation_givenFreqMapConverter() {
    // Arrange
    Context context = new Context();

    ArrayList<Converter> converters = new ArrayList<>();
    converters.add(new FreqMapConverter());
    View view = new View();
    AccumuloStore store = new AccumuloStore();

    // Act and Assert
    StructType schemaResult = (new AccumuloStoreRelation(context, converters, view, store, new HashMap<>())).schema();
    assertTrue(schemaResult.toList() instanceof scala.collection.immutable.$colon$colon);
    assertTrue(schemaResult.toStream() instanceof Cons);
    assertTrue(schemaResult.toIndexedSeq() instanceof Vector);
    assertSame(schemaResult, schemaResult.repr());
    assertSame(schemaResult, schemaResult.seq());
    assertSame(schemaResult, schemaResult.toIterable());
    assertSame(schemaResult, schemaResult.toSeq());
    assertSame(schemaResult, schemaResult.toTraversable());
  }

  /**
   * Test {@link AccumuloStoreRelation#AccumuloStoreRelation(Context, List, View, AccumuloStore, Map)}.
   * <ul>
   *   <li>Given {@link FreqMapConverter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloStoreRelation#AccumuloStoreRelation(Context, List, View, AccumuloStore, Map)}
   */
  @Test
  @DisplayName("Test new AccumuloStoreRelation(Context, List, View, AccumuloStore, Map); given FreqMapConverter (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloStoreRelation.<init>(Context, List, View, AccumuloStore, Map)"})
  void testNewAccumuloStoreRelation_givenFreqMapConverter2() {
    // Arrange
    Context context = new Context();

    ArrayList<Converter> converters = new ArrayList<>();
    converters.add(new FreqMapConverter());
    converters.add(new FreqMapConverter());
    View view = new View();
    AccumuloStore store = new AccumuloStore();

    // Act and Assert
    StructType schemaResult = (new AccumuloStoreRelation(context, converters, view, store, new HashMap<>())).schema();
    assertTrue(schemaResult.toList() instanceof scala.collection.immutable.$colon$colon);
    assertTrue(schemaResult.toStream() instanceof Cons);
    assertTrue(schemaResult.toIndexedSeq() instanceof Vector);
    assertSame(schemaResult, schemaResult.repr());
    assertSame(schemaResult, schemaResult.seq());
    assertSame(schemaResult, schemaResult.toIterable());
    assertSame(schemaResult, schemaResult.toSeq());
    assertSame(schemaResult, schemaResult.toTraversable());
  }

  /**
   * Test {@link AccumuloStoreRelation#AccumuloStoreRelation(Context, List, View, AccumuloStore, Map)}.
   * <ul>
   *   <li>When {@link Context.Builder} (default constructor) user {@link User.Builder} (default constructor) userId {@code 42} build build.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloStoreRelation#AccumuloStoreRelation(Context, List, View, AccumuloStore, Map)}
   */
  @Test
  @DisplayName("Test new AccumuloStoreRelation(Context, List, View, AccumuloStore, Map); when Builder (default constructor) user Builder (default constructor) userId '42' build build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloStoreRelation.<init>(Context, List, View, AccumuloStore, Map)"})
  void testNewAccumuloStoreRelation_whenBuilderUserBuilderUserId42BuildBuild() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    ArrayList<Converter> converters = new ArrayList<>();
    View view = new View();
    AccumuloStore store = new AccumuloStore();

    // Act and Assert
    StructType schemaResult = (new AccumuloStoreRelation(context, converters, view, store, new HashMap<>())).schema();
    assertTrue(schemaResult.toList() instanceof scala.collection.immutable.$colon$colon);
    assertTrue(schemaResult.toStream() instanceof Cons);
    assertTrue(schemaResult.toIndexedSeq() instanceof Vector);
    assertSame(schemaResult, schemaResult.repr());
    assertSame(schemaResult, schemaResult.seq());
    assertSame(schemaResult, schemaResult.toIterable());
    assertSame(schemaResult, schemaResult.toSeq());
    assertSame(schemaResult, schemaResult.toTraversable());
  }

  /**
   * Test {@link AccumuloStoreRelation#schema()}.
   * <p>
   * Method under test: {@link AccumuloStoreRelation#schema()}
   */
  @Test
  @DisplayName("Test schema()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StructType AccumuloStoreRelation.schema()"})
  void testSchema() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    ArrayList<Converter> converters = new ArrayList<>();
    View view = new View();
    AccumuloStore store = new AccumuloStore();

    // Act
    StructType actualSchemaResult = (new AccumuloStoreRelation(context, converters, view, store, new HashMap<>()))
        .schema();

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
    assertSame(actualSchemaResult, actualSchemaResult.repr());
    assertSame(actualSchemaResult, actualSchemaResult.seq());
    assertSame(actualSchemaResult, actualSchemaResult.toIterable());
    assertSame(actualSchemaResult, actualSchemaResult.toSeq());
    assertSame(actualSchemaResult, actualSchemaResult.toTraversable());
    assertSame(initResult, actualSchemaResult.tail());
  }
}
