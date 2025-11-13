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

package uk.gov.gchq.gaffer.spark.data.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.execution.aggregate.MutableAggregationBufferImpl;
import org.apache.spark.sql.test.ExamplePointUDT;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;

class RowToElementGeneratorDiffblueTest {
  /**
   * Test {@link RowToElementGenerator#apply(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link RowToElementGenerator#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable RowToElementGenerator.apply(Iterable)"})
  void testApplyWithIterable() {
    // Arrange
    RowToElementGenerator rowToElementGenerator = new RowToElementGenerator();

    // Act and Assert
    assertFalse(rowToElementGenerator.apply(new ArrayList<>()).iterator().hasNext());
  }

  /**
   * Test {@link RowToElementGenerator#_apply(Row)} with {@code Row}.
   * <p>
   * Method under test: {@link RowToElementGenerator#_apply(Row)}
   */
  @Test
  @DisplayName("Test _apply(Row) with 'Row'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element RowToElementGenerator._apply(Row)"})
  void test_applyWithRow() {
    // Arrange
    RowToElementGenerator rowToElementGenerator = new RowToElementGenerator();
    MutableAggregationBufferImpl row = mock(MutableAggregationBufferImpl.class);
    when(row.getAs(Mockito.<String>any())).thenReturn("As");
    ExamplePointUDT dataType = new ExamplePointUDT();
    when(row.schema())
        .thenReturn(new StructType(new StructField[]{new StructField("group", dataType, true, new Metadata())}));

    // Act
    Element actual_applyResult = rowToElementGenerator._apply(row);

    // Assert
    verify(row, atLeast(1)).getAs(Mockito.<String>any());
    verify(row, atLeast(1)).schema();
    assertTrue(actual_applyResult instanceof Entity);
    assertEquals("As", actual_applyResult.getGroup());
    assertEquals("As", ((Entity) actual_applyResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }

  /**
   * Test {@link RowToElementGenerator#_apply(Row)} with {@code Row}.
   * <p>
   * Method under test: {@link RowToElementGenerator#_apply(Row)}
   */
  @Test
  @DisplayName("Test _apply(Row) with 'Row'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element RowToElementGenerator._apply(Row)"})
  void test_applyWithRow2() {
    // Arrange
    RowToElementGenerator rowToElementGenerator = new RowToElementGenerator();
    MutableAggregationBufferImpl row = mock(MutableAggregationBufferImpl.class);
    when(row.isNullAt(anyInt())).thenReturn(true);
    when(row.fieldIndex(Mockito.<String>any())).thenReturn(1);
    when(row.getAs(Mockito.<String>any())).thenReturn("As");
    StructField structField = new StructField();
    when(row.schema()).thenReturn(new StructType(new StructField[]{structField, new StructField()}));

    // Act
    Element actual_applyResult = rowToElementGenerator._apply(row);

    // Assert
    verify(row, atLeast(1)).isNullAt(eq(1));
    verify(row, atLeast(1)).fieldIndex(isNull());
    verify(row, atLeast(1)).getAs(Mockito.<String>any());
    verify(row, atLeast(1)).schema();
    assertTrue(actual_applyResult instanceof Entity);
    assertEquals("As", actual_applyResult.getGroup());
    assertEquals("As", ((Entity) actual_applyResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }

  /**
   * Test {@link RowToElementGenerator#_apply(Row)} with {@code Row}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link MutableAggregationBufferImpl} {@link MutableAggregationBufferImpl#isNullAt(int)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowToElementGenerator#_apply(Row)}
   */
  @Test
  @DisplayName("Test _apply(Row) with 'Row'; given 'false'; when MutableAggregationBufferImpl isNullAt(int) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element RowToElementGenerator._apply(Row)"})
  void test_applyWithRow_givenFalse_whenMutableAggregationBufferImplIsNullAtReturnFalse() {
    // Arrange
    RowToElementGenerator rowToElementGenerator = new RowToElementGenerator();
    MutableAggregationBufferImpl row = mock(MutableAggregationBufferImpl.class);
    when(row.isNullAt(anyInt())).thenReturn(false);
    when(row.fieldIndex(Mockito.<String>any())).thenReturn(1);
    when(row.getAs(Mockito.<String>any())).thenReturn("As");
    when(row.schema()).thenReturn(new StructType(new StructField[]{new StructField()}));

    // Act
    Element actual_applyResult = rowToElementGenerator._apply(row);

    // Assert
    verify(row).isNullAt(eq(1));
    verify(row).fieldIndex(isNull());
    verify(row, atLeast(1)).getAs(Mockito.<String>any());
    verify(row, atLeast(1)).schema();
    assertTrue(actual_applyResult instanceof Entity);
    assertEquals("As", actual_applyResult.getGroup());
    assertEquals("As", ((Entity) actual_applyResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }

  /**
   * Test {@link RowToElementGenerator#_apply(Row)} with {@code Row}.
   * <ul>
   *   <li>Given {@link StructField} {@link StructField#name()} return {@code Name}.</li>
   *   <li>Then calls {@link StructField#name()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowToElementGenerator#_apply(Row)}
   */
  @Test
  @DisplayName("Test _apply(Row) with 'Row'; given StructField name() return 'Name'; then calls name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element RowToElementGenerator._apply(Row)"})
  void test_applyWithRow_givenStructFieldNameReturnName_thenCallsName() {
    // Arrange
    RowToElementGenerator rowToElementGenerator = new RowToElementGenerator();
    StructField structField = mock(StructField.class);
    when(structField.name()).thenReturn("Name");
    StructType structType = new StructType(new StructField[]{structField});
    MutableAggregationBufferImpl row = mock(MutableAggregationBufferImpl.class);
    when(row.isNullAt(anyInt())).thenReturn(true);
    when(row.fieldIndex(Mockito.<String>any())).thenReturn(1);
    when(row.getAs(Mockito.<String>any())).thenReturn("As");
    when(row.schema()).thenReturn(structType);

    // Act
    Element actual_applyResult = rowToElementGenerator._apply(row);

    // Assert
    verify(row).isNullAt(eq(1));
    verify(row).fieldIndex(eq("Name"));
    verify(row, atLeast(1)).getAs(Mockito.<String>any());
    verify(row, atLeast(1)).schema();
    verify(structField, atLeast(1)).name();
    assertTrue(actual_applyResult instanceof Entity);
    assertEquals("As", actual_applyResult.getGroup());
    assertEquals("As", ((Entity) actual_applyResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }

  /**
   * Test {@link RowToElementGenerator#_apply(Row)} with {@code Row}.
   * <ul>
   *   <li>Given {@link StructField} {@link StructField#name()} return {@code vertex}.</li>
   *   <li>Then calls {@link StructField#name()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowToElementGenerator#_apply(Row)}
   */
  @Test
  @DisplayName("Test _apply(Row) with 'Row'; given StructField name() return 'vertex'; then calls name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element RowToElementGenerator._apply(Row)"})
  void test_applyWithRow_givenStructFieldNameReturnVertex_thenCallsName() {
    // Arrange
    RowToElementGenerator rowToElementGenerator = new RowToElementGenerator();
    StructField structField = mock(StructField.class);
    when(structField.name()).thenReturn("vertex");
    StructType structType = new StructType(new StructField[]{structField});
    MutableAggregationBufferImpl row = mock(MutableAggregationBufferImpl.class);
    when(row.getAs(Mockito.<String>any())).thenReturn("As");
    when(row.schema()).thenReturn(structType);

    // Act
    Element actual_applyResult = rowToElementGenerator._apply(row);

    // Assert
    verify(row, atLeast(1)).getAs(Mockito.<String>any());
    verify(row, atLeast(1)).schema();
    verify(structField, atLeast(1)).name();
    assertTrue(actual_applyResult instanceof Entity);
    assertEquals("As", actual_applyResult.getGroup());
    assertEquals("As", ((Entity) actual_applyResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }

  /**
   * Test {@link RowToElementGenerator#_apply(Row)} with {@code Row}.
   * <ul>
   *   <li>Given {@link StructType#StructType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowToElementGenerator#_apply(Row)}
   */
  @Test
  @DisplayName("Test _apply(Row) with 'Row'; given StructType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element RowToElementGenerator._apply(Row)"})
  void test_applyWithRow_givenStructType() {
    // Arrange
    RowToElementGenerator rowToElementGenerator = new RowToElementGenerator();
    MutableAggregationBufferImpl row = mock(MutableAggregationBufferImpl.class);
    when(row.getAs(Mockito.<String>any())).thenReturn("As");
    when(row.schema()).thenReturn(new StructType());

    // Act
    Element actual_applyResult = rowToElementGenerator._apply(row);

    // Assert
    verify(row, atLeast(1)).getAs(Mockito.<String>any());
    verify(row, atLeast(1)).schema();
    assertTrue(actual_applyResult instanceof Entity);
    assertEquals("As", actual_applyResult.getGroup());
    assertEquals("As", ((Entity) actual_applyResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }

  /**
   * Test {@link RowToElementGenerator#_apply(Row)} with {@code Row}.
   * <ul>
   *   <li>Given {@link StructType#StructType(StructField[])} with fields is array of {@link StructField} with {@link StructField#StructField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowToElementGenerator#_apply(Row)}
   */
  @Test
  @DisplayName("Test _apply(Row) with 'Row'; given StructType(StructField[]) with fields is array of StructField with StructField()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element RowToElementGenerator._apply(Row)"})
  void test_applyWithRow_givenStructTypeWithFieldsIsArrayOfStructFieldWithStructField() {
    // Arrange
    RowToElementGenerator rowToElementGenerator = new RowToElementGenerator();
    MutableAggregationBufferImpl row = mock(MutableAggregationBufferImpl.class);
    when(row.isNullAt(anyInt())).thenReturn(true);
    when(row.fieldIndex(Mockito.<String>any())).thenReturn(1);
    when(row.getAs(Mockito.<String>any())).thenReturn("As");
    when(row.schema()).thenReturn(new StructType(new StructField[]{new StructField()}));

    // Act
    Element actual_applyResult = rowToElementGenerator._apply(row);

    // Assert
    verify(row).isNullAt(eq(1));
    verify(row).fieldIndex(isNull());
    verify(row, atLeast(1)).getAs(Mockito.<String>any());
    verify(row, atLeast(1)).schema();
    assertTrue(actual_applyResult instanceof Entity);
    assertEquals("As", actual_applyResult.getGroup());
    assertEquals("As", ((Entity) actual_applyResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }

  /**
   * Test {@link RowToElementGenerator#_apply(Row)} with {@code Row}.
   * <ul>
   *   <li>Then calls {@link StructType#fieldNames()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowToElementGenerator#_apply(Row)}
   */
  @Test
  @DisplayName("Test _apply(Row) with 'Row'; then calls fieldNames()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element RowToElementGenerator._apply(Row)"})
  void test_applyWithRow_thenCallsFieldNames() {
    // Arrange
    RowToElementGenerator rowToElementGenerator = new RowToElementGenerator();
    StructType structType = mock(StructType.class);
    when(structType.fieldNames()).thenReturn(new String[]{"Field Names"});
    MutableAggregationBufferImpl row = mock(MutableAggregationBufferImpl.class);
    when(row.isNullAt(anyInt())).thenReturn(true);
    when(row.fieldIndex(Mockito.<String>any())).thenReturn(1);
    when(row.getAs(Mockito.<String>any())).thenReturn("As");
    when(row.schema()).thenReturn(structType);

    // Act
    Element actual_applyResult = rowToElementGenerator._apply(row);

    // Assert
    verify(row).isNullAt(eq(1));
    verify(row).fieldIndex(eq("Field Names"));
    verify(row, atLeast(1)).getAs(Mockito.<String>any());
    verify(row, atLeast(1)).schema();
    verify(structType, atLeast(1)).fieldNames();
    assertTrue(actual_applyResult instanceof Entity);
    assertEquals("As", actual_applyResult.getGroup());
    assertEquals("As", ((Entity) actual_applyResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }
}
