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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.DataInputStream;
import java.io.IOException;
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
import org.mockito.Mockito;
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
    // Arrange and Act
    IteratorSettingBuilder actualIteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");
    IteratorSetting actualIteratorSetting =
        actualIteratorSettingBuilder.combinerColumnFamilies(new ArrayList<>()).build();

    // Assert
    Map<String, String> options = actualIteratorSetting.getOptions();
    assertEquals(1, options.size());
    assertEquals("", options.get(TableUtils.COLUMN_FAMILIES_OPTION));
    assertEquals("Iterator Class", actualIteratorSetting.getIteratorClass());
    assertEquals("Name", actualIteratorSetting.getName());
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
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");

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
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");

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
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act
    IteratorSettingBuilder actualColumnFamilyResult =
        iteratorSettingBuilder.columnFamily("Column Family");

    // Assert
    assertSame(iteratorSettingBuilder, actualColumnFamilyResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#combinerColumnFamilies(List)}.
   *
   * <p>Method under test: {@link IteratorSettingBuilder#combinerColumnFamilies(List)}
   */
  @Test
  @DisplayName("Test combinerColumnFamilies(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.combinerColumnFamilies(List)"})
  void testCombinerColumnFamilies() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act
    IteratorSettingBuilder actualCombinerColumnFamiliesResult =
        iteratorSettingBuilder.combinerColumnFamilies(new ArrayList<>());

    // Assert
    assertSame(iteratorSettingBuilder, actualCombinerColumnFamiliesResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#bloomFilter(BloomFilter)}.
   *
   * <p>Method under test: {@link IteratorSettingBuilder#bloomFilter(BloomFilter)}
   */
  @Test
  @DisplayName("Test bloomFilter(BloomFilter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.bloomFilter(BloomFilter)"})
  void testBloomFilter() throws IteratorSettingException {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");

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
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act
    IteratorSettingBuilder actualIncludeEdgesResult = iteratorSettingBuilder.includeEdges(true);

    // Assert
    assertSame(iteratorSettingBuilder, actualIncludeEdgesResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#includeEdges(boolean)}.
   *
   * <ul>
   *   <li>Then return {@link IteratorSettingBuilder#IteratorSettingBuilder(IteratorSetting)} with
   *       setting is {@link IteratorSetting#IteratorSetting(DataInput)}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#includeEdges(boolean)}
   */
  @Test
  @DisplayName(
      "Test includeEdges(boolean); then return IteratorSettingBuilder(IteratorSetting) with setting is IteratorSetting(DataInput)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.includeEdges(boolean)"})
  void testIncludeEdges_thenReturnIteratorSettingBuilderWithSettingIsIteratorSetting()
      throws IOException {
    // Arrange
    DataInputStream din = mock(DataInputStream.class);
    when(din.readByte()).thenReturn((byte) 'A');
    when(din.readInt()).thenReturn(1);
    doNothing().when(din).readFully(Mockito.<byte[]>any());

    IteratorSetting setting = new IteratorSetting(din);
    setting.addOption(AccumuloStoreConstants.INCLUDE_EDGES, Boolean.TRUE.toString());
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(setting);

    // Act
    IteratorSettingBuilder actualIncludeEdgesResult = iteratorSettingBuilder.includeEdges(false);

    // Assert
    verify(din, atLeast(1)).readByte();
    verify(din, atLeast(1)).readFully(Mockito.<byte[]>any());
    verify(din, atLeast(1)).readInt();
    assertSame(iteratorSettingBuilder, actualIncludeEdgesResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#directedType(DirectedType)}.
   *
   * <p>Method under test: {@link IteratorSettingBuilder#directedType(DirectedType)}
   */
  @Test
  @DisplayName("Test directedType(DirectedType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.directedType(DirectedType)"})
  void testDirectedType() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");

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
   *   <li>When {@link DirectedType#DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#directedType(DirectedType)}
   */
  @Test
  @DisplayName("Test directedType(DirectedType); when DIRECTED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.directedType(DirectedType)"})
  void testDirectedType_whenDirected() throws IOException {
    // Arrange
    DataInputStream din = mock(DataInputStream.class);
    when(din.readByte()).thenReturn((byte) 'A');
    when(din.readInt()).thenReturn(1);
    doNothing().when(din).readFully(Mockito.<byte[]>any());

    IteratorSetting setting = new IteratorSetting(din);
    setting.addOption(AccumuloStoreConstants.DIRECTED_EDGE_ONLY, Boolean.TRUE.toString());
    setting.addOption(AccumuloStoreConstants.UNDIRECTED_EDGE_ONLY, Boolean.TRUE.toString());
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(setting);

    // Act
    IteratorSettingBuilder actualDirectedTypeResult =
        iteratorSettingBuilder.directedType(DirectedType.DIRECTED);

    // Assert
    verify(din, atLeast(1)).readByte();
    verify(din, atLeast(1)).readFully(Mockito.<byte[]>any());
    verify(din, atLeast(1)).readInt();
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
  void testDirectedType_whenUndirected() throws IOException {
    // Arrange
    DataInputStream din = mock(DataInputStream.class);
    when(din.readByte()).thenReturn((byte) 'A');
    when(din.readInt()).thenReturn(1);
    doNothing().when(din).readFully(Mockito.<byte[]>any());

    IteratorSetting setting = new IteratorSetting(din);
    setting.addOption(AccumuloStoreConstants.DIRECTED_EDGE_ONLY, Boolean.TRUE.toString());
    setting.addOption(AccumuloStoreConstants.UNDIRECTED_EDGE_ONLY, Boolean.TRUE.toString());
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(setting);

    // Act
    IteratorSettingBuilder actualDirectedTypeResult =
        iteratorSettingBuilder.directedType(DirectedType.UNDIRECTED);

    // Assert
    verify(din, atLeast(1)).readByte();
    verify(din, atLeast(1)).readFully(Mockito.<byte[]>any());
    verify(din, atLeast(1)).readInt();
    assertSame(iteratorSettingBuilder, actualDirectedTypeResult);
  }

  /**
   * Test {@link IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}.
   *
   * <p>Method under test: {@link
   * IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test includeIncomingOutgoing(IncludeIncomingOutgoingType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSettingBuilder IteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType)"
  })
  void testIncludeIncomingOutgoing() {
    // Arrange
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");

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
   *   <li>When {@link IncludeIncomingOutgoingType#INCOMING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IteratorSettingBuilder#includeIncomingOutgoing(IncludeIncomingOutgoingType)}
   */
  @Test
  @DisplayName("Test includeIncomingOutgoing(IncludeIncomingOutgoingType); when INCOMING")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSettingBuilder IteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType)"
  })
  void testIncludeIncomingOutgoing_whenIncoming() throws IOException {
    // Arrange
    DataInputStream din = mock(DataInputStream.class);
    when(din.readByte()).thenReturn((byte) 'A');
    when(din.readInt()).thenReturn(1);
    doNothing().when(din).readFully(Mockito.<byte[]>any());

    IteratorSetting setting = new IteratorSetting(din);
    setting.addOption(AccumuloStoreConstants.INCOMING_EDGE_ONLY, Boolean.TRUE.toString());
    setting.addOption(AccumuloStoreConstants.OUTGOING_EDGE_ONLY, Boolean.TRUE.toString());
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(setting);

    // Act
    IteratorSettingBuilder actualIncludeIncomingOutgoingResult =
        iteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType.INCOMING);

    // Assert
    verify(din, atLeast(1)).readByte();
    verify(din, atLeast(1)).readFully(Mockito.<byte[]>any());
    verify(din, atLeast(1)).readInt();
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
  void testIncludeIncomingOutgoing_whenOutgoing() throws IOException {
    // Arrange
    DataInputStream din = mock(DataInputStream.class);
    when(din.readByte()).thenReturn((byte) 'A');
    when(din.readInt()).thenReturn(1);
    doNothing().when(din).readFully(Mockito.<byte[]>any());

    IteratorSetting setting = new IteratorSetting(din);
    setting.addOption(AccumuloStoreConstants.INCOMING_EDGE_ONLY, Boolean.TRUE.toString());
    setting.addOption(AccumuloStoreConstants.OUTGOING_EDGE_ONLY, Boolean.TRUE.toString());
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(setting);

    // Act
    IteratorSettingBuilder actualIncludeIncomingOutgoingResult =
        iteratorSettingBuilder.includeIncomingOutgoing(IncludeIncomingOutgoingType.OUTGOING);

    // Assert
    verify(din, atLeast(1)).readByte();
    verify(din, atLeast(1)).readFully(Mockito.<byte[]>any());
    verify(din, atLeast(1)).readInt();
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
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");

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
   *   <li>Then return {@link IteratorSettingBuilder#IteratorSettingBuilder(IteratorSetting)} with
   *       setting is {@link IteratorSetting#IteratorSetting(DataInput)}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorSettingBuilder#includeEntities(boolean)}
   */
  @Test
  @DisplayName(
      "Test includeEntities(boolean); then return IteratorSettingBuilder(IteratorSetting) with setting is IteratorSetting(DataInput)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorSettingBuilder IteratorSettingBuilder.includeEntities(boolean)"})
  void testIncludeEntities_thenReturnIteratorSettingBuilderWithSettingIsIteratorSetting()
      throws IOException {
    // Arrange
    DataInputStream din = mock(DataInputStream.class);
    when(din.readByte()).thenReturn((byte) 'A');
    when(din.readInt()).thenReturn(1);
    doNothing().when(din).readFully(Mockito.<byte[]>any());

    IteratorSetting setting = new IteratorSetting(din);
    setting.addOption(AccumuloStoreConstants.INCLUDE_ENTITIES, Boolean.TRUE.toString());
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(setting);

    // Act
    IteratorSettingBuilder actualIncludeEntitiesResult =
        iteratorSettingBuilder.includeEntities(false);

    // Assert
    verify(din, atLeast(1)).readByte();
    verify(din, atLeast(1)).readFully(Mockito.<byte[]>any());
    verify(din, atLeast(1)).readInt();
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
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");

    // Act
    IteratorSettingBuilder actualDeduplicateUndirectedEdgesResult =
        iteratorSettingBuilder.deduplicateUndirectedEdges(true);

    // Assert
    assertSame(iteratorSettingBuilder, actualDeduplicateUndirectedEdgesResult);
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
  void testDeduplicateUndirectedEdges2() throws IOException {
    // Arrange
    DataInputStream din = mock(DataInputStream.class);
    when(din.readByte()).thenReturn((byte) 'A');
    when(din.readInt()).thenReturn(1);
    doNothing().when(din).readFully(Mockito.<byte[]>any());

    IteratorSetting setting = new IteratorSetting(din);
    setting.addOption(AccumuloStoreConstants.DEDUPLICATE_UNDIRECTED_EDGES, Boolean.TRUE.toString());
    IteratorSettingBuilder iteratorSettingBuilder = new IteratorSettingBuilder(setting);

    // Act
    IteratorSettingBuilder actualDeduplicateUndirectedEdgesResult =
        iteratorSettingBuilder.deduplicateUndirectedEdges(false);

    // Assert
    verify(din, atLeast(1)).readByte();
    verify(din, atLeast(1)).readFully(Mockito.<byte[]>any());
    verify(din, atLeast(1)).readInt();
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
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");

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
    IteratorSettingBuilder iteratorSettingBuilder =
        new IteratorSettingBuilder(1, "Name", "Iterator Class");
    Class<AccumuloElementConverter> converter = AccumuloElementConverter.class;

    // Act
    IteratorSettingBuilder actualKeyConverterResult =
        iteratorSettingBuilder.keyConverter(converter);

    // Assert
    assertSame(iteratorSettingBuilder, actualKeyConverterResult);
  }
}
