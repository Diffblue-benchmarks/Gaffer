package uk.gov.gchq.gaffer.accumulostore.key.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.accumulo.core.data.ArrayByteSequence;
import org.apache.accumulo.core.data.ByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Range;
import org.apache.accumulo.core.iterators.ColumnFamilyCounter;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.OptionDescriber.IteratorOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.impl.RowIDAggregator.PropertiesIterator;
import uk.gov.gchq.gaffer.store.schema.Schema;

class RowIDAggregatorDiffblueTest {
  /**
   * Test new {@link RowIDAggregator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link RowIDAggregator}
   */
  @Test
  @DisplayName("Test new RowIDAggregator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RowIDAggregator.<init>()"})
  void testNewRowIDAggregator() {
    // Arrange and Act
    RowIDAggregator actualRowIDAggregator = new RowIDAggregator();

    // Assert
    assertNull(actualRowIDAggregator.getTopKey());
    assertNull(actualRowIDAggregator.getTopValue());
  }

  /**
   * Test {@link RowIDAggregator#describeOptions()}.
   *
   * <p>Method under test: {@link RowIDAggregator#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorOptions RowIDAggregator.describeOptions()"})
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult = new RowIDAggregator().describeOptions();

    // Assert
    assertEquals(
        "Applies a findTop function to triples of (column qualifier, column visibility, value) with identical"
            + " (rowKey, column family)",
        actualDescribeOptionsResult.getDescription());
    assertEquals("Column_Qualifier_Aggregator", actualDescribeOptionsResult.getName());
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(2, namedOptions.size());
    assertEquals(
        "Required: The element converter class to be used for key/value conversion",
        namedOptions.get("accumulostore.key.element_converter"));
    assertEquals("Required: The json serialised form of the schema", namedOptions.get("Schema"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Test PropertiesIterator {@link PropertiesIterator#hasNext()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesIterator#hasNext()}
   */
  @Test
  @DisplayName("Test PropertiesIterator hasNext(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PropertiesIterator.hasNext()"})
  void testPropertiesIteratorHasNext_thenReturnFalse() throws IOException {
    // Arrange
    ColumnFamilyCounter source = new ColumnFamilyCounter();
    Range currentRange = new Range();
    ArrayList<ByteSequence> currentColumnFamilies = new ArrayList<>();
    Key workKeyRef = new Key();

    PropertiesIterator propertiesIterator =
        new PropertiesIterator(
            source,
            currentRange,
            currentColumnFamilies,
            true,
            "Group",
            workKeyRef,
            new ByteEntityAccumuloElementConverter(new Schema()));

    // Act and Assert
    assertFalse(propertiesIterator.hasNext());
  }

  /**
   * Test PropertiesIterator {@link PropertiesIterator#next()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesIterator#next()}
   */
  @Test
  @DisplayName("Test PropertiesIterator next(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"uk.gov.gchq.gaffer.data.element.Properties PropertiesIterator.next()"})
  void testPropertiesIteratorNext_thenThrowRuntimeException() throws IOException {
    // Arrange
    ColumnFamilyCounter source = mock(ColumnFamilyCounter.class);
    doThrow(new IOException()).when(source).next();

    Key workKeyRef = mock(Key.class);
    doNothing().when(workKeyRef).set(Mockito.<Key>any());
    Range currentRange = new Range();
    ArrayList<ByteSequence> currentColumnFamilies = new ArrayList<>();

    PropertiesIterator propertiesIterator =
        new PropertiesIterator(
            source,
            currentRange,
            currentColumnFamilies,
            true,
            "Group",
            workKeyRef,
            new ByteEntityAccumuloElementConverter(new Schema()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> propertiesIterator.next());
    verify(workKeyRef).set(isNull());
    verify(source).next();
  }

  /**
   * Test PropertiesIterator {@link PropertiesIterator#remove()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesIterator#remove()}
   */
  @Test
  @DisplayName("Test PropertiesIterator remove(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PropertiesIterator.remove()"})
  void testPropertiesIteratorRemove_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    ColumnFamilyCounter source = new ColumnFamilyCounter();
    Range currentRange = new Range();
    ArrayList<ByteSequence> currentColumnFamilies = new ArrayList<>();
    Key workKeyRef = new Key();

    PropertiesIterator propertiesIterator =
        new PropertiesIterator(
            source,
            currentRange,
            currentColumnFamilies,
            true,
            "Group",
            workKeyRef,
            new ByteEntityAccumuloElementConverter(new Schema()));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> propertiesIterator.remove());
  }

  /**
   * Test {@link RowIDAggregator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link HashMap#HashMap()} {@code Schema} is {@code Options}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RowIDAggregator#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); given 'Options'; when HashMap() 'Schema' is 'Options'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RowIDAggregator.validateOptions(Map)"})
  void testValidateOptions_givenOptions_whenHashMapSchemaIsOptions_thenReturnTrue() {
    // Arrange
    RowIDAggregator rowIDAggregator = new RowIDAggregator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Schema", "Options");
    options.put("columnFamily", "Options");

    // Act and Assert
    assertTrue(rowIDAggregator.validateOptions(options));
  }

  /**
   * Test {@link RowIDAggregator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code Schema} is {@code Schema}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RowIDAggregator#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); when HashMap() 'Schema' is 'Schema'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RowIDAggregator.validateOptions(Map)"})
  void testValidateOptions_whenHashMapSchemaIsSchema_thenThrowIllegalArgumentException() {
    // Arrange
    RowIDAggregator rowIDAggregator = new RowIDAggregator();

    HashMap<String, String> options = new HashMap<>();
    options.put("Schema", "Schema");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rowIDAggregator.validateOptions(options));
  }

  /**
   * Test {@link RowIDAggregator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RowIDAggregator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RowIDAggregator.validateOptions(Map)"})
  void testValidateOptions_whenHashMap_thenThrowIllegalArgumentException() {
    // Arrange
    RowIDAggregator rowIDAggregator = new RowIDAggregator();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> rowIDAggregator.validateOptions(new HashMap<>()));
  }

  /**
   * Test {@link RowIDAggregator#seek(Range, Collection, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ArrayByteSequence#ArrayByteSequence(String)} with s is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link RowIDAggregator#seek(Range, Collection, boolean)}
   */
  @Test
  @DisplayName(
      "Test seek(Range, Collection, boolean); given ArrayByteSequence(String) with s is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RowIDAggregator.seek(Range, Collection, boolean)"})
  void testSeek_givenArrayByteSequenceWithSIsFoo() throws IOException {
    // Arrange
    RowIDAggregator rowIDAggregator = new RowIDAggregator();
    Range range = new Range();

    ArrayList<ByteSequence> columnFamilies = new ArrayList<>();
    columnFamilies.add(new ArrayByteSequence("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> rowIDAggregator.seek(range, columnFamilies, true));
  }

  /**
   * Test {@link RowIDAggregator#seek(Range, Collection, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ArrayByteSequence#ArrayByteSequence(String)} with s is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link RowIDAggregator#seek(Range, Collection, boolean)}
   */
  @Test
  @DisplayName(
      "Test seek(Range, Collection, boolean); given ArrayByteSequence(String) with s is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RowIDAggregator.seek(Range, Collection, boolean)"})
  void testSeek_givenArrayByteSequenceWithSIsFoo2() throws IOException {
    // Arrange
    RowIDAggregator rowIDAggregator = new RowIDAggregator();
    Range range = new Range();

    ArrayList<ByteSequence> columnFamilies = new ArrayList<>();
    columnFamilies.add(new ArrayByteSequence("foo"));
    columnFamilies.add(new ArrayByteSequence("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> rowIDAggregator.seek(range, columnFamilies, true));
  }

  /**
   * Test {@link RowIDAggregator#seek(Range, Collection, boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link RowIDAggregator#seek(Range, Collection, boolean)}
   */
  @Test
  @DisplayName(
      "Test seek(Range, Collection, boolean); when ArrayList(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RowIDAggregator.seek(Range, Collection, boolean)"})
  void testSeek_whenArrayList_thenThrowIllegalStateException() throws IOException {
    // Arrange
    RowIDAggregator rowIDAggregator = new RowIDAggregator();
    Range range = new Range();

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> rowIDAggregator.seek(range, new ArrayList<>(), true));
  }

  /**
   * Test {@link RowIDAggregator#getTopKey()}.
   *
   * <p>Method under test: {@link RowIDAggregator#getTopKey()}
   */
  @Test
  @DisplayName("Test getTopKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key RowIDAggregator.getTopKey()"})
  void testGetTopKey() {
    // Arrange, Act and Assert
    assertNull(new RowIDAggregator().getTopKey());
  }

  /**
   * Test {@link RowIDAggregator#getTopValue()}.
   *
   * <p>Method under test: {@link RowIDAggregator#getTopValue()}
   */
  @Test
  @DisplayName("Test getTopValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.accumulo.core.data.Value RowIDAggregator.getTopValue()"})
  void testGetTopValue() {
    // Arrange, Act and Assert
    assertNull(new RowIDAggregator().getTopValue());
  }

  /**
   * Test {@link RowIDAggregator#hasTop()}.
   *
   * <p>Method under test: {@link RowIDAggregator#hasTop()}
   */
  @Test
  @DisplayName("Test hasTop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RowIDAggregator.hasTop()"})
  void testHasTop() {
    // Arrange, Act and Assert
    assertFalse(new RowIDAggregator().hasTop());
  }
}
