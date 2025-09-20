package uk.gov.gchq.gaffer.accumulostore.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.accumulo.core.data.ArrayByteSequence;
import org.apache.accumulo.core.data.ByteSequence;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.AccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AccumuloEntityValueLoaderDiffblueTest {
  /**
   * Test {@link AccumuloEntityValueLoader#AccumuloEntityValueLoader(String, Key, Value,
   * AccumuloElementConverter, Schema)}.
   *
   * <ul>
   *   <li>Given {@code timestampProperty}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloEntityValueLoader#AccumuloEntityValueLoader(String, Key,
   * Value, AccumuloElementConverter, Schema)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloEntityValueLoader(String, Key, Value, AccumuloElementConverter, Schema); given 'timestampProperty'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloEntityValueLoader.<init>(String, Key, Value, AccumuloElementConverter, Schema)"
  })
  void testNewAccumuloEntityValueLoader_givenTimestampProperty() {
    // Arrange
    Key key = new Key();
    Value value = new Value();
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    Schema schema = new Schema();
    schema.addConfig("timestampProperty", "Schema");

    // Act
    AccumuloEntityValueLoader actualAccumuloEntityValueLoader =
        new AccumuloEntityValueLoader("Group", key, value, elementConverter, schema);

    // Assert
    Key key2 = actualAccumuloEntityValueLoader.key;
    ByteSequence columnFamilyData = key2.getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    ByteSequence columnQualifierData = key2.getColumnQualifierData();
    assertTrue(columnQualifierData instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData = key2.getColumnVisibilityData();
    assertTrue(columnVisibilityData instanceof ArrayByteSequence);
    ByteSequence rowData = key2.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    assertTrue(
        actualAccumuloEntityValueLoader.elementConverter
            instanceof ByteEntityAccumuloElementConverter);
    assertEquals(0, key2.getLength());
    assertEquals(0, key2.getSize());
    assertFalse(key2.isDeleted());
    assertEquals(Long.MAX_VALUE, key2.getTimestamp());
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    assertEquals(columnFamilyData, rowData);
  }

  /**
   * Test {@link AccumuloEntityValueLoader#AccumuloEntityValueLoader(String, Key, Value,
   * AccumuloElementConverter, Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloEntityValueLoader#AccumuloEntityValueLoader(String, Key,
   * Value, AccumuloElementConverter, Schema)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloEntityValueLoader(String, Key, Value, AccumuloElementConverter, Schema); when Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloEntityValueLoader.<init>(String, Key, Value, AccumuloElementConverter, Schema)"
  })
  void testNewAccumuloEntityValueLoader_whenSchema() {
    // Arrange
    Key key = new Key();
    Value value = new Value();
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    // Act
    AccumuloEntityValueLoader actualAccumuloEntityValueLoader =
        new AccumuloEntityValueLoader("Group", key, value, elementConverter, new Schema());

    // Assert
    Key key2 = actualAccumuloEntityValueLoader.key;
    ByteSequence columnFamilyData = key2.getColumnFamilyData();
    assertTrue(columnFamilyData instanceof ArrayByteSequence);
    ByteSequence columnQualifierData = key2.getColumnQualifierData();
    assertTrue(columnQualifierData instanceof ArrayByteSequence);
    ByteSequence columnVisibilityData = key2.getColumnVisibilityData();
    assertTrue(columnVisibilityData instanceof ArrayByteSequence);
    ByteSequence rowData = key2.getRowData();
    assertTrue(rowData instanceof ArrayByteSequence);
    assertTrue(
        actualAccumuloEntityValueLoader.elementConverter
            instanceof ByteEntityAccumuloElementConverter);
    assertEquals(0, key2.getLength());
    assertEquals(0, key2.getSize());
    assertFalse(key2.isDeleted());
    assertEquals(Long.MAX_VALUE, key2.getTimestamp());
    assertEquals(columnFamilyData, columnQualifierData);
    assertEquals(columnFamilyData, columnVisibilityData);
    assertEquals(columnFamilyData, rowData);
  }
}
