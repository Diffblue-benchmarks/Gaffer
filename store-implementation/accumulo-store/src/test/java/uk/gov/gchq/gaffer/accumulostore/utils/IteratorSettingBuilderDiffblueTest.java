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

package uk.gov.gchq.gaffer.accumulostore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedList;
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
   * <p>
   * Method under test: {@link IteratorSettingBuilder#build()}
   */
  @Test
  @DisplayName("Test build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IteratorSettingBuilder.<init>(IteratorSetting)",
      "IteratorSetting IteratorSettingBuilder.build()"})
  void testBuild() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act
    IteratorSetting actualBuildResult = iteratorSettingBuilder.combinerColumnFamilies(new ArrayList<>()).build();

    // Assert
    Map<String, String> options = actualBuildResult.getOptions();
    assertEquals(1, options.size());
    assertEquals("", options.get(TableUtils.COLUMN_FAMILIES_OPTION));
    assertEquals("Iterator Class", actualBuildResult.getIteratorClass());
    assertEquals("Name", actualBuildResult.getName());
    assertEquals(1, actualBuildResult.getPriority());
  }

  /**
   * Test {@link IteratorSettingBuilder#IteratorSettingBuilder(int, String, String)}.
   * <ul>
   *   <li>Then return build IteratorClass is {@code Iterator Class}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#IteratorSettingBuilder(int, String, String)}
   */
  @Test
  @DisplayName("Test new IteratorSettingBuilder(int, String, String); then return build IteratorClass is 'Iterator Class'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IteratorSettingBuilder.<init>(int, String, String)"})
  void testNewIteratorSettingBuilder_thenReturnBuildIteratorClassIsIteratorClass() {
    // Arrange, Act and Assert
    IteratorSetting buildResult = (new IteratorSettingBuilder(1, "Name", "Iterator Class")).build();
    assertEquals("Iterator Class", buildResult.getIteratorClass());
    assertEquals("Name", buildResult.getName());
    assertEquals(1, buildResult.getPriority());
    assertTrue(buildResult.getOptions().isEmpty());
  }

  /**
   * Test {@link IteratorSettingBuilder#IteratorSettingBuilder(int, String, Class)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return build Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#IteratorSettingBuilder(int, String, Class)}
   */
  @Test
  @DisplayName("Test new IteratorSettingBuilder(int, String, Class); when 'Name'; then return build Name is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IteratorSettingBuilder.<init>(int, String, Class)"})
  void testNewIteratorSettingBuilder_whenName_thenReturnBuildNameIsName() {
    // Arrange
    Class<SortedKeyValueIterator> forNameResult = SortedKeyValueIterator.class;

    // Act and Assert
    IteratorSetting buildResult = (new IteratorSettingBuilder(1, "Name",
        (Class<SortedKeyValueIterator<Key, Value>>) (Class) forNameResult)).build();
    assertEquals("Name", buildResult.getName());
    assertEquals("org.apache.accumulo.core.iterators.SortedKeyValueIterator", buildResult.getIteratorClass());
    assertEquals(1, buildResult.getPriority());
    assertTrue(buildResult.getOptions().isEmpty());
  }

  /**
   * Test {@link IteratorSettingBuilder#option(String, String)}.
   * <p>
   * Method under test: {@link IteratorSettingBuilder#option(String, String)}
   */
  @Test
  @DisplayName("Test option(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.option(String, String)"})
  void testOption() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.option("Option", "42"));
  }

  /**
   * Test {@link IteratorSettingBuilder#all()}.
   * <ul>
   *   <li>Then return {@link IteratorSettingBuilder#IteratorSettingBuilder(int, String, String)} with priority is one and {@code Name} and {@code Iterator Class}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#all()}
   */
  @Test
  @DisplayName("Test all(); then return IteratorSettingBuilder(int, String, String) with priority is one and 'Name' and 'Iterator Class'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.all()"})
  void testAll_thenReturnIteratorSettingBuilderWithPriorityIsOneAndNameAndIteratorClass() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.all());
  }

  /**
   * Test {@link IteratorSettingBuilder#columnFamily(String)}.
   * <p>
   * Method under test: {@link IteratorSettingBuilder#columnFamily(String)}
   */
  @Test
  @DisplayName("Test columnFamily(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.columnFamily(String)"})
  void testColumnFamily() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.columnFamily("Column Family"));
  }

  /**
   * Test {@link IteratorSettingBuilder#combinerColumnFamilies(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#combinerColumnFamilies(List)}
   */
  @Test
  @DisplayName("Test combinerColumnFamilies(List); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.combinerColumnFamilies(List)"})
  void testCombinerColumnFamilies_given42_whenArrayListAdd42() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    ArrayList<String> columnFamilies = new ArrayList<>();
    columnFamilies.add("42");
    columnFamilies.add("foo");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.combinerColumnFamilies(columnFamilies));
  }

  /**
   * Test {@link IteratorSettingBuilder#combinerColumnFamilies(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#combinerColumnFamilies(List)}
   */
  @Test
  @DisplayName("Test combinerColumnFamilies(List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.combinerColumnFamilies(List)"})
  void testCombinerColumnFamilies_givenFoo_whenArrayListAddFoo() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    ArrayList<String> columnFamilies = new ArrayList<>();
    columnFamilies.add("foo");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.combinerColumnFamilies(columnFamilies));
  }

  /**
   * Test {@link IteratorSettingBuilder#combinerColumnFamilies(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#combinerColumnFamilies(List)}
   */
  @Test
  @DisplayName("Test combinerColumnFamilies(List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.combinerColumnFamilies(List)"})
  void testCombinerColumnFamilies_whenArrayList() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.combinerColumnFamilies(new ArrayList<>()));
  }

  /**
   * Test {@link IteratorSettingBuilder#combinerColumnFamilies(List)}.
   * <ul>
   *   <li>When {@link LinkedList#LinkedList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#combinerColumnFamilies(List)}
   */
  @Test
  @DisplayName("Test combinerColumnFamilies(List); when LinkedList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.combinerColumnFamilies(List)"})
  void testCombinerColumnFamilies_whenLinkedList() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.combinerColumnFamilies(new LinkedList<>()));
  }

  /**
   * Test {@link IteratorSettingBuilder#bloomFilter(BloomFilter)}.
   * <ul>
   *   <li>When thirteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#bloomFilter(BloomFilter)}
   */
  @Test
  @DisplayName("Test bloomFilter(BloomFilter); when thirteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.bloomFilter(BloomFilter)"})
  void testBloomFilter_whenThirteen() throws IteratorSettingException {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.bloomFilter(BloomFilterUtils.getBloomFilter(13)));
  }

  /**
   * Test {@link IteratorSettingBuilder#bloomFilter(BloomFilter)}.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#bloomFilter(BloomFilter)}
   */
  @Test
  @DisplayName("Test bloomFilter(BloomFilter); when three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.bloomFilter(BloomFilter)"})
  void testBloomFilter_whenThree() throws IteratorSettingException {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.bloomFilter(BloomFilterUtils.getBloomFilter(3)));
  }

  /**
   * Test {@link IteratorSettingBuilder#includeEdges(boolean)}.
   * <p>
   * Method under test: {@link IteratorSettingBuilder#includeEdges(boolean)}
   */
  @Test
  @DisplayName("Test includeEdges(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.includeEdges(boolean)"})
  void testIncludeEdges() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.includeEdges(true));
  }

  /**
   * Test {@link IteratorSettingBuilder#includeEdges(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#includeEdges(boolean)}
   */
  @Test
  @DisplayName("Test includeEdges(boolean); when 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.includeEdges(boolean)"})
  void testIncludeEdges_whenFalse() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.includeEdges(false));
  }

  /**
   * Test {@link IteratorSettingBuilder#directedType(DirectedType)}.
   * <ul>
   *   <li>When {@link DirectedType#DIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#directedType(DirectedType)}
   */
  @Test
  @DisplayName("Test directedType(DirectedType); when DIRECTED")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.directedType(DirectedType)"})
  void testDirectedType_whenDirected() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.directedType(DirectedType.DIRECTED));
  }

  /**
   * Test {@link IteratorSettingBuilder#directedType(DirectedType)}.
   * <ul>
   *   <li>When {@code EITHER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#directedType(DirectedType)}
   */
  @Test
  @DisplayName("Test directedType(DirectedType); when 'EITHER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.directedType(DirectedType)"})
  void testDirectedType_whenEither() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.directedType(DirectedType.EITHER));
  }

  /**
   * Test {@link IteratorSettingBuilder#directedType(DirectedType)}.
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#directedType(DirectedType)}
   */
  @Test
  @DisplayName("Test directedType(DirectedType); when UNDIRECTED")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.directedType(DirectedType)"})
  void testDirectedType_whenUndirected() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.directedType(DirectedType.UNDIRECTED));
  }

  /**
   * Test {@link IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}.
   * <ul>
   *   <li>When {@code EITHER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test includeIncomingOutgoing(IncludeIncomingOutgoingType); when 'EITHER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSettingBuilder IteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType)"})
  void testIncludeIncomingOutgoing_whenEither() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder,
        iteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType.EITHER));
  }

  /**
   * Test {@link IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}.
   * <ul>
   *   <li>When {@link IncludeIncomingOutgoingType#INCOMING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test includeIncomingOutgoing(IncludeIncomingOutgoingType); when INCOMING")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSettingBuilder IteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType)"})
  void testIncludeIncomingOutgoing_whenIncoming() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder,
        iteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType.INCOMING));
  }

  /**
   * Test {@link IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}.
   * <ul>
   *   <li>When {@link IncludeIncomingOutgoingType#OUTGOING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test includeIncomingOutgoing(IncludeIncomingOutgoingType); when OUTGOING")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IteratorSettingBuilder IteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType)"})
  void testIncludeIncomingOutgoing_whenOutgoing() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder,
        iteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType.OUTGOING));
  }

  /**
   * Test {@link IteratorSettingBuilder#includeEntities(boolean)}.
   * <p>
   * Method under test: {@link IteratorSettingBuilder#includeEntities(boolean)}
   */
  @Test
  @DisplayName("Test includeEntities(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.includeEntities(boolean)"})
  void testIncludeEntities() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.includeEntities(true));
  }

  /**
   * Test {@link IteratorSettingBuilder#includeEntities(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#includeEntities(boolean)}
   */
  @Test
  @DisplayName("Test includeEntities(boolean); when 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.includeEntities(boolean)"})
  void testIncludeEntities_whenFalse() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.includeEntities(false));
  }

  /**
   * Test {@link IteratorSettingBuilder#deduplicateUndirectedEdges(boolean)}.
   * <p>
   * Method under test: {@link IteratorSettingBuilder#deduplicateUndirectedEdges(boolean)}
   */
  @Test
  @DisplayName("Test deduplicateUndirectedEdges(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.deduplicateUndirectedEdges(boolean)"})
  void testDeduplicateUndirectedEdges() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.deduplicateUndirectedEdges(true));
  }

  /**
   * Test {@link IteratorSettingBuilder#deduplicateUndirectedEdges(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IteratorSettingBuilder#deduplicateUndirectedEdges(boolean)}
   */
  @Test
  @DisplayName("Test deduplicateUndirectedEdges(boolean); when 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.deduplicateUndirectedEdges(boolean)"})
  void testDeduplicateUndirectedEdges_whenFalse() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.deduplicateUndirectedEdges(false));
  }

  /**
   * Test {@link IteratorSettingBuilder#keyConverter(AccumuloElementConverter)} with {@code AccumuloElementConverter}.
   * <p>
   * Method under test: {@link IteratorSettingBuilder#keyConverter(AccumuloElementConverter)}
   */
  @Test
  @DisplayName("Test keyConverter(AccumuloElementConverter) with 'AccumuloElementConverter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.keyConverter(AccumuloElementConverter)"})
  void testKeyConverterWithAccumuloElementConverter() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act and Assert
    assertSame(iteratorSettingBuilder,
        iteratorSettingBuilder.keyConverter(new ByteEntityAccumuloElementConverter(new Schema())));
  }

  /**
   * Test {@link IteratorSettingBuilder#keyConverter(Class)} with {@code Class}.
   * <p>
   * Method under test: {@link IteratorSettingBuilder#keyConverter(Class)}
   */
  @Test
  @DisplayName("Test keyConverter(Class) with 'Class'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.keyConverter(Class)"})
  void testKeyConverterWithClass() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(1, "Name", "Iterator Class");
    Class<AccumuloElementConverter> converter = AccumuloElementConverter.class;

    // Act and Assert
    assertSame(iteratorSettingBuilder, iteratorSettingBuilder.keyConverter(converter));
  }
}
