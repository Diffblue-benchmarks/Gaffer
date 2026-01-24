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

package uk.gov.gchq.gaffer.accumulostore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.iterators.SortedKeyValueIterator;
import org.apache.hadoop.util.bloom.BloomFilter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.AccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.exception.IteratorSettingException;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters.IncludeIncomingOutgoingType;
import uk.gov.gchq.gaffer.store.schema.Schema;

class IteratorSettingBuilderDiffblueTest {
  /**
   * Test {@link IteratorSettingBuilder#build()}.
   *
   * <p>Method under test: {@link IteratorSettingBuilder#build()}
   */
  @Test
  @DisplayName("Test build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IteratorSettingBuilder.<init>(IteratorSetting)",
    "IteratorSetting IteratorSettingBuilder.build()"
  })
  void testBuild() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act
    IteratorSettingBuilder actualIteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);
    IteratorSetting actualIteratorSetting =
        actualIteratorSettingBuilder.combinerColumnFamilies(new ArrayList<>()).build();

    // Assert
    Map<String, String> options = actualIteratorSetting.getOptions();
    assertEquals(1, options.size());
    assertEquals("", options.get(TableUtils.COLUMN_FAMILIES_OPTION));
    assertEquals("Name", actualIteratorSetting.getName());
    assertEquals(
        "org.apache.accumulo.core.iterators.SortedKeyValueIterator",
        actualIteratorSetting.getIteratorClass());
    assertEquals(1, actualIteratorSetting.getPriority());
  }

  /**
   * Test {@link IteratorSettingBuilder#IteratorSettingBuilder(int, String, String)}.
   *
   * <ul>
   *   <li>Then return build IteratorClass is {@code Iterator Class}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#IteratorSettingBuilder(int, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new IteratorSettingBuilder(int, String, String); then return build IteratorClass is 'Iterator Class'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IteratorSettingBuilder.<init>(int, String, String)"})
  void testNewIteratorSettingBuilder_thenReturnBuildIteratorClassIsIteratorClass() {
    // Arrange and Act
    IteratorSettingBuilder actualIteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Assert
    IteratorSetting iteratorSetting = actualIteratorSettingBuilder.build();
    assertEquals("Iterator Class", iteratorSetting.getIteratorClass());
    assertEquals("Name", iteratorSetting.getName());
    assertEquals(1, iteratorSetting.getPriority());
    assertTrue(iteratorSetting.getOptions().isEmpty());
  }

  /**
   * Test {@link IteratorSettingBuilder#IteratorSettingBuilder(int, String, Class)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return build Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#IteratorSettingBuilder(int, String, Class)}
   */
  @Test
  @DisplayName(
      "Test new IteratorSettingBuilder(int, String, Class); when 'Name'; then return build Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IteratorSettingBuilder.<init>(int, String, Class)"})
  void testNewIteratorSettingBuilder_whenName_thenReturnBuildNameIsName() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act
    IteratorSettingBuilder actualIteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Assert
    IteratorSetting iteratorSetting = actualIteratorSettingBuilder.build();
    assertEquals("Name", iteratorSetting.getName());
    assertEquals(
        "org.apache.accumulo.core.iterators.SortedKeyValueIterator",
        iteratorSetting.getIteratorClass());
    assertEquals(1, iteratorSetting.getPriority());
    assertTrue(iteratorSetting.getOptions().isEmpty());
  }

  /**
   * Test {@link IteratorSettingBuilder#option(String, String)}.
   *
   * <p>Method under test: {@link IteratorSettingBuilder#option(String, String)}
   */
  @Test
  @DisplayName("Test option(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.option(String, String)"})
  void testOption() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualOptionResult = iteratorSettingBuilder.option("Option", "42");

    // Assert
    assertSame(iteratorSettingBuilder, actualOptionResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#all()}.
   *
   * <p>Method under test: {@link IteratorSettingBuilder#all()}
   */
  @Test
  @DisplayName("Test all()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.all()"})
  void testAll() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualAllResult = iteratorSettingBuilder.all();

    // Assert
    assertSame(iteratorSettingBuilder, actualAllResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#columnFamily(String)}.
   *
   * <p>Method under test: {@link IteratorSettingBuilder#columnFamily(String)}
   */
  @Test
  @DisplayName("Test columnFamily(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.columnFamily(String)"})
  void testColumnFamily() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualColumnFamilyResult =
        iteratorSettingBuilder.columnFamily("Column Family");

    // Assert
    assertSame(iteratorSettingBuilder, actualColumnFamilyResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#combinerColumnFamilies(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#combinerColumnFamilies(List)}
   */
  @Test
  @DisplayName("Test combinerColumnFamilies(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.combinerColumnFamilies(List)"})
  void testCombinerColumnFamilies_given42_whenArrayListAdd42() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    ArrayList<String> columnFamilies = new ArrayList<>();
    columnFamilies.add("42");
    columnFamilies.add("foo");

    // Act
    IteratorSettingBuilder actualCombinerColumnFamiliesResult =
        iteratorSettingBuilder.combinerColumnFamilies(columnFamilies);

    // Assert
    assertSame(iteratorSettingBuilder, actualCombinerColumnFamiliesResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#combinerColumnFamilies(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#combinerColumnFamilies(List)}
   */
  @Test
  @DisplayName("Test combinerColumnFamilies(List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.combinerColumnFamilies(List)"})
  void testCombinerColumnFamilies_givenFoo_whenArrayListAddFoo() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    ArrayList<String> columnFamilies = new ArrayList<>();
    columnFamilies.add("foo");

    // Act
    IteratorSettingBuilder actualCombinerColumnFamiliesResult =
        iteratorSettingBuilder.combinerColumnFamilies(columnFamilies);

    // Assert
    assertSame(iteratorSettingBuilder, actualCombinerColumnFamiliesResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#combinerColumnFamilies(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#combinerColumnFamilies(List)}
   */
  @Test
  @DisplayName("Test combinerColumnFamilies(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.combinerColumnFamilies(List)"})
  void testCombinerColumnFamilies_whenArrayList() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualCombinerColumnFamiliesResult =
        iteratorSettingBuilder.combinerColumnFamilies(new ArrayList<>());

    // Assert
    assertSame(iteratorSettingBuilder, actualCombinerColumnFamiliesResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#bloomFilter(BloomFilter)}.
   *
   * <ul>
   *   <li>When {@link BloomFilter#BloomFilter()}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#bloomFilter(BloomFilter)}
   */
  @Test
  @DisplayName("Test bloomFilter(BloomFilter); when BloomFilter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.bloomFilter(BloomFilter)"})
  void testBloomFilter_whenBloomFilter() throws IteratorSettingException {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualBloomFilterResult =
        iteratorSettingBuilder.bloomFilter(new BloomFilter());

    // Assert
    assertSame(iteratorSettingBuilder, actualBloomFilterResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#bloomFilter(BloomFilter)}.
   *
   * <ul>
   *   <li>When thirteen.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#bloomFilter(BloomFilter)}
   */
  @Test
  @DisplayName("Test bloomFilter(BloomFilter); when thirteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.bloomFilter(BloomFilter)"})
  void testBloomFilter_whenThirteen() throws IteratorSettingException {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualBloomFilterResult =
        iteratorSettingBuilder.bloomFilter(BloomFilterUtils.getBloomFilter(13));

    // Assert
    assertSame(iteratorSettingBuilder, actualBloomFilterResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#bloomFilter(BloomFilter)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#bloomFilter(BloomFilter)}
   */
  @Test
  @DisplayName("Test bloomFilter(BloomFilter); when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.bloomFilter(BloomFilter)"})
  void testBloomFilter_whenThree() throws IteratorSettingException {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualBloomFilterResult =
        iteratorSettingBuilder.bloomFilter(BloomFilterUtils.getBloomFilter(3));

    // Assert
    assertSame(iteratorSettingBuilder, actualBloomFilterResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#includeEdges(boolean)}.
   *
   * <p>Method under test: {@link IteratorSettingBuilder#includeEdges(boolean)}
   */
  @Test
  @DisplayName("Test includeEdges(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.includeEdges(boolean)"})
  void testIncludeEdges() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualIncludeEdgesResult = iteratorSettingBuilder.includeEdges(true);

    // Assert
    assertSame(iteratorSettingBuilder, actualIncludeEdgesResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#includeEdges(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#includeEdges(boolean)}
   */
  @Test
  @DisplayName("Test includeEdges(boolean); when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.includeEdges(boolean)"})
  void testIncludeEdges_whenFalse() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualIncludeEdgesResult = iteratorSettingBuilder.includeEdges(false);

    // Assert
    assertSame(iteratorSettingBuilder, actualIncludeEdgesResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#directedType(DirectedType)}.
   *
   * <ul>
   *   <li>When {@code DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#directedType(DirectedType)}
   */
  @Test
  @DisplayName("Test directedType(DirectedType); when 'DIRECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.directedType(DirectedType)"})
  void testDirectedType_whenDirected() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualDirectedTypeResult =
        iteratorSettingBuilder.directedType(DirectedType.DIRECTED);

    // Assert
    assertSame(iteratorSettingBuilder, actualDirectedTypeResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#directedType(DirectedType)}.
   *
   * <ul>
   *   <li>When {@code EITHER}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#directedType(DirectedType)}
   */
  @Test
  @DisplayName("Test directedType(DirectedType); when 'EITHER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.directedType(DirectedType)"})
  void testDirectedType_whenEither() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualDirectedTypeResult =
        iteratorSettingBuilder.directedType(DirectedType.EITHER);

    // Assert
    assertSame(iteratorSettingBuilder, actualDirectedTypeResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#directedType(DirectedType)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#directedType(DirectedType)}
   */
  @Test
  @DisplayName("Test directedType(DirectedType); when UNDIRECTED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.directedType(DirectedType)"})
  void testDirectedType_whenUndirected() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualDirectedTypeResult =
        iteratorSettingBuilder.directedType(DirectedType.UNDIRECTED);

    // Assert
    assertSame(iteratorSettingBuilder, actualDirectedTypeResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}.
   *
   * <ul>
   *   <li>When {@code EITHER}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test includeIncomingOutgoing(IncludeIncomingOutgoingType); when 'EITHER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSettingBuilder IteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType)"
  })
  void testIncludeIncomingOutgoing_whenEither() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualIncludeIncomingOutgoingResult =
        iteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType.EITHER);

    // Assert
    assertSame(iteratorSettingBuilder, actualIncludeIncomingOutgoingResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}.
   *
   * <ul>
   *   <li>When {@code INCOMING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test includeIncomingOutgoing(IncludeIncomingOutgoingType); when 'INCOMING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSettingBuilder IteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType)"
  })
  void testIncludeIncomingOutgoing_whenIncoming() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualIncludeIncomingOutgoingResult =
        iteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType.INCOMING);

    // Assert
    assertSame(iteratorSettingBuilder, actualIncludeIncomingOutgoingResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}.
   *
   * <ul>
   *   <li>When {@link IncludeIncomingOutgoingType#OUTGOING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test includeIncomingOutgoing(IncludeIncomingOutgoingType); when OUTGOING")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSettingBuilder IteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType)"
  })
  void testIncludeIncomingOutgoing_whenOutgoing() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualIncludeIncomingOutgoingResult =
        iteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType.OUTGOING);

    // Assert
    assertSame(iteratorSettingBuilder, actualIncludeIncomingOutgoingResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#includeEntities(boolean)}.
   *
   * <p>Method under test: {@link IteratorSettingBuilder#includeEntities(boolean)}
   */
  @Test
  @DisplayName("Test includeEntities(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.includeEntities(boolean)"})
  void testIncludeEntities() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualIncludeEntitiesResult =
        iteratorSettingBuilder.includeEntities(true);

    // Assert
    assertSame(iteratorSettingBuilder, actualIncludeEntitiesResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#includeEntities(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#includeEntities(boolean)}
   */
  @Test
  @DisplayName("Test includeEntities(boolean); when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.includeEntities(boolean)"})
  void testIncludeEntities_whenFalse() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualIncludeEntitiesResult =
        iteratorSettingBuilder.includeEntities(false);

    // Assert
    assertSame(iteratorSettingBuilder, actualIncludeEntitiesResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#deduplicateUndirectedEdges(boolean)}.
   *
   * <p>Method under test: {@link IteratorSettingBuilder#deduplicateUndirectedEdges(boolean)}
   */
  @Test
  @DisplayName("Test deduplicateUndirectedEdges(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSettingBuilder IteratorSettingBuilder.deduplicateUndirectedEdges(boolean)"
  })
  void testDeduplicateUndirectedEdges() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualDeduplicateUndirectedEdgesResult =
        iteratorSettingBuilder.deduplicateUndirectedEdges(true);

    // Assert
    assertSame(iteratorSettingBuilder, actualDeduplicateUndirectedEdgesResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#deduplicateUndirectedEdges(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#deduplicateUndirectedEdges(boolean)}
   */
  @Test
  @DisplayName("Test deduplicateUndirectedEdges(boolean); when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSettingBuilder IteratorSettingBuilder.deduplicateUndirectedEdges(boolean)"
  })
  void testDeduplicateUndirectedEdges_whenFalse() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualDeduplicateUndirectedEdgesResult =
        iteratorSettingBuilder.deduplicateUndirectedEdges(false);

    // Assert
    assertSame(iteratorSettingBuilder, actualDeduplicateUndirectedEdgesResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#keyConverter(AccumuloElementConverter)} with {@code
   * AccumuloElementConverter}.
   *
   * <p>Method under test: {@link IteratorSettingBuilder#keyConverter(AccumuloElementConverter)}
   */
  @Test
  @DisplayName("Test keyConverter(AccumuloElementConverter) with 'AccumuloElementConverter'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSettingBuilder IteratorSettingBuilder.keyConverter(AccumuloElementConverter)"
  })
  void testKeyConverterWithAccumuloElementConverter() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);

    // Act
    IteratorSettingBuilder actualKeyConverterResult =
        iteratorSettingBuilder.keyConverter(new ByteEntityAccumuloElementConverter(new Schema()));

    // Assert
    assertSame(iteratorSettingBuilder, actualKeyConverterResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#keyConverter(Class)} with {@code Class}.
   *
   * <p>Method under test: {@link IteratorSettingBuilder#keyConverter(Class)}
   */
  @Test
  @DisplayName("Test keyConverter(Class) with 'Class'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.keyConverter(Class)"})
  void testKeyConverterWithClass() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(
            1, "Name", (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult);
    Class<AccumuloElementConverter> converter = AccumuloElementConverter.class;

    // Act
    IteratorSettingBuilder actualKeyConverterResult =
        iteratorSettingBuilder.keyConverter(converter);

    // Assert
    assertSame(iteratorSettingBuilder, actualKeyConverterResult);
  }
}
