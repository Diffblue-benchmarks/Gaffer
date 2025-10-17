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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.scalardd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.apache.hadoop.conf.Configuration;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SparkSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.spark.operation.scalardd.GetRDDOfAllElements;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.scalardd.GetRDDOfAllElementsHandler.EntryToElement;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.scalardd.GetRDDOfAllElementsHandler.FilterOutNull;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class GetRDDOfAllElementsHandlerDiffblueTest {
  /**
   * Test {@link GetRDDOfAllElementsHandler#doOperation(GetRDDOfAllElements, Context, Store)} with
   * {@code operation}, {@code context}, {@code store}.
   *
   * <p>Method under test: {@link GetRDDOfAllElementsHandler#doOperation(GetRDDOfAllElements,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetRDDOfAllElements, Context, Store) with 'operation', 'context', 'store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.spark.rdd.RDD GetRDDOfAllElementsHandler.doOperation(GetRDDOfAllElements, Context, Store)"
  })
  void testDoOperationWithOperationContextStore() throws OperationException {
    // Arrange
    GetRDDOfAllElementsHandler getRDDOfAllElementsHandler = new GetRDDOfAllElementsHandler();

    GetRDDOfAllElements operation = mock(GetRDDOfAllElements.class);
    when(operation.getOption(Mockito.<String>any()))
        .thenReturn("Exception decoding Configuration from options");
    doNothing().when(operation).addOption(Mockito.<String>any(), Mockito.<String>any());
    operation.addOption("Name", "42");

    SparkContext sparkContext = mock(SparkContext.class);
    when(sparkContext.hadoopConfiguration()).thenReturn(new Configuration());

    SparkSession sparkSession = mock(SparkSession.class);
    when(sparkSession.sparkContext()).thenReturn(sparkContext);

    Context context = mock(Context.class);
    when(context.getConfig(Mockito.<String>any())).thenReturn(sparkSession);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    doNothing().when(accumuloProperties).addOperationDeclarationPaths((String[]) Mockito.any());
    accumuloProperties.addOperationDeclarationPaths("New Paths");

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> getRDDOfAllElementsHandler.doOperation(operation, context, store));
    verify(sparkContext).hadoopConfiguration();
    verify(sparkSession).sparkContext();
    verify(store).getProperties();
    verify(operation).addOption("Name", "42");
    verify(operation).getOption("Hadoop_Configuration_Key");
    verify(context).getConfig("config.spark.context");
    verify(accumuloProperties).addOperationDeclarationPaths((String[]) Mockito.any());
  }

  /**
   * Test {@link GetRDDOfAllElementsHandler#doOperation(GetRDDOfAllElements, Context, Store)} with
   * {@code operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@code config.spark.context}.
   * </ul>
   *
   * <p>Method under test: {@link GetRDDOfAllElementsHandler#doOperation(GetRDDOfAllElements,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetRDDOfAllElements, Context, Store) with 'operation', 'context', 'store'; given 'config.spark.context'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.spark.rdd.RDD GetRDDOfAllElementsHandler.doOperation(GetRDDOfAllElements, Context, Store)"
  })
  void testDoOperationWithOperationContextStore_givenConfigSparkContext()
      throws OperationException {
    // Arrange
    GetRDDOfAllElementsHandler getRDDOfAllElementsHandler = new GetRDDOfAllElementsHandler();

    GetRDDOfAllElements operation = mock(GetRDDOfAllElements.class);
    when(operation.getOption(Mockito.<String>any())).thenReturn("config.spark.context");
    doNothing().when(operation).addOption(Mockito.<String>any(), Mockito.<String>any());
    operation.addOption("Name", "42");

    SparkContext sparkContext = mock(SparkContext.class);
    when(sparkContext.hadoopConfiguration()).thenReturn(new Configuration());

    SparkSession sparkSession = mock(SparkSession.class);
    when(sparkSession.sparkContext()).thenReturn(sparkContext);

    Context context = mock(Context.class);
    when(context.getConfig(Mockito.<String>any())).thenReturn(sparkSession);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    doNothing().when(accumuloProperties).addOperationDeclarationPaths((String[]) Mockito.any());
    accumuloProperties.addOperationDeclarationPaths("New Paths");

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> getRDDOfAllElementsHandler.doOperation(operation, context, store));
    verify(sparkContext).hadoopConfiguration();
    verify(sparkSession).sparkContext();
    verify(store).getProperties();
    verify(operation).addOption("Name", "42");
    verify(operation).getOption("Hadoop_Configuration_Key");
    verify(context).getConfig("config.spark.context");
    verify(accumuloProperties).addOperationDeclarationPaths((String[]) Mockito.any());
  }

  /**
   * Test {@link GetRDDOfAllElementsHandler#doOperation(GetRDDOfAllElements, Context, Store)} with
   * {@code operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link GetRDDOfAllElementsHandler#doOperation(GetRDDOfAllElements,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetRDDOfAllElements, Context, Store) with 'operation', 'context', 'store'; given 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.spark.rdd.RDD GetRDDOfAllElementsHandler.doOperation(GetRDDOfAllElements, Context, Store)"
  })
  void testDoOperationWithOperationContextStore_givenFoo() throws OperationException {
    // Arrange
    GetRDDOfAllElementsHandler getRDDOfAllElementsHandler = new GetRDDOfAllElementsHandler();

    GetRDDOfAllElements operation = mock(GetRDDOfAllElements.class);
    when(operation.getOption(Mockito.<String>any())).thenReturn("foo");
    doNothing().when(operation).addOption(Mockito.<String>any(), Mockito.<String>any());
    operation.addOption("Name", "42");

    SparkContext sparkContext = mock(SparkContext.class);
    when(sparkContext.hadoopConfiguration()).thenReturn(new Configuration());

    SparkSession sparkSession = mock(SparkSession.class);
    when(sparkSession.sparkContext()).thenReturn(sparkContext);

    Context context = mock(Context.class);
    when(context.getConfig(Mockito.<String>any())).thenReturn(sparkSession);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    doNothing().when(accumuloProperties).addOperationDeclarationPaths((String[]) Mockito.any());
    accumuloProperties.addOperationDeclarationPaths("New Paths");

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> getRDDOfAllElementsHandler.doOperation(operation, context, store));
    verify(sparkContext).hadoopConfiguration();
    verify(sparkSession).sparkContext();
    verify(store).getProperties();
    verify(operation).addOption("Name", "42");
    verify(operation).getOption("Hadoop_Configuration_Key");
    verify(context).getConfig("config.spark.context");
    verify(accumuloProperties).addOperationDeclarationPaths((String[]) Mockito.any());
  }

  /**
   * Test {@link GetRDDOfAllElementsHandler#doOperation(GetRDDOfAllElements, Context, Store)} with
   * {@code operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@code Option}.
   * </ul>
   *
   * <p>Method under test: {@link GetRDDOfAllElementsHandler#doOperation(GetRDDOfAllElements,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetRDDOfAllElements, Context, Store) with 'operation', 'context', 'store'; given 'Option'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.spark.rdd.RDD GetRDDOfAllElementsHandler.doOperation(GetRDDOfAllElements, Context, Store)"
  })
  void testDoOperationWithOperationContextStore_givenOption() throws OperationException {
    // Arrange
    GetRDDOfAllElementsHandler getRDDOfAllElementsHandler = new GetRDDOfAllElementsHandler();

    GetRDDOfAllElements operation = mock(GetRDDOfAllElements.class);
    when(operation.getOption(Mockito.<String>any())).thenReturn("Option");
    doNothing().when(operation).addOption(Mockito.<String>any(), Mockito.<String>any());
    operation.addOption("Name", "42");

    SparkContext sparkContext = mock(SparkContext.class);
    when(sparkContext.hadoopConfiguration()).thenReturn(new Configuration());

    SparkSession sparkSession = mock(SparkSession.class);
    when(sparkSession.sparkContext()).thenReturn(sparkContext);

    Context context = mock(Context.class);
    when(context.getConfig(Mockito.<String>any())).thenReturn(sparkSession);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    doNothing().when(accumuloProperties).addOperationDeclarationPaths((String[]) Mockito.any());
    accumuloProperties.addOperationDeclarationPaths("New Paths");

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> getRDDOfAllElementsHandler.doOperation(operation, context, store));
    verify(sparkContext).hadoopConfiguration();
    verify(sparkSession).sparkContext();
    verify(store).getProperties();
    verify(operation).addOption("Name", "42");
    verify(operation).getOption("Hadoop_Configuration_Key");
    verify(context).getConfig("config.spark.context");
    verify(accumuloProperties).addOperationDeclarationPaths((String[]) Mockito.any());
  }

  /**
   * Test EntryToElement {@link EntryToElement#EntryToElement(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link EntryToElement#EntryToElement(byte[])}
   */
  @Test
  @DisplayName(
      "Test EntryToElement new EntryToElement(byte[]); when array of byte with 'A' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntryToElement.<init>(byte[])"})
  void testEntryToElementNewEntryToElement_whenArrayOfByteWithAAndMinusOne() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new EntryToElement(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test EntryToElement {@link EntryToElement#EntryToElement(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.
   * </ul>
   *
   * <p>Method under test: {@link EntryToElement#EntryToElement(byte[])}
   */
  @Test
  @DisplayName(
      "Test EntryToElement new EntryToElement(byte[]); when array of byte with 'A' and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntryToElement.<init>(byte[])"})
  void testEntryToElementNewEntryToElement_whenArrayOfByteWithAAndZero() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new EntryToElement(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test EntryToElement {@link EntryToElement#EntryToElement(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link EntryToElement#EntryToElement(byte[])}
   */
  @Test
  @DisplayName(
      "Test EntryToElement new EntryToElement(byte[]); when array of byte with MIN_VALUE and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntryToElement.<init>(byte[])"})
  void testEntryToElementNewEntryToElement_whenArrayOfByteWithMin_valueAndX() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new EntryToElement(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test EntryToElement {@link EntryToElement#EntryToElement(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code X} and zero.
   * </ul>
   *
   * <p>Method under test: {@link EntryToElement#EntryToElement(byte[])}
   */
  @Test
  @DisplayName(
      "Test EntryToElement new EntryToElement(byte[]); when array of byte with 'X' and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntryToElement.<init>(byte[])"})
  void testEntryToElementNewEntryToElement_whenArrayOfByteWithXAndZero() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new EntryToElement(new byte[] {'X', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test EntryToElement {@link EntryToElement#EntryToElement(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link EntryToElement#EntryToElement(byte[])}
   */
  @Test
  @DisplayName("Test EntryToElement new EntryToElement(byte[]); when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntryToElement.<init>(byte[])"})
  void testEntryToElementNewEntryToElement_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new EntryToElement(new byte[] {}));
  }

  /**
   * Test EntryToElement {@link EntryToElement#EntryToElement(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link EntryToElement#EntryToElement(byte[])}
   */
  @Test
  @DisplayName("Test EntryToElement new EntryToElement(byte[]); when 'XXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntryToElement.<init>(byte[])"})
  void testEntryToElementNewEntryToElement_whenXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new EntryToElement("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test FilterOutNull {@link FilterOutNull#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FilterOutNull#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test FilterOutNull apply(Element) with 'Element'; when Edge(String) with 'Group'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FilterOutNull.apply(Element)"})
  void testFilterOutNullApplyWithElement_whenEdgeWithGroup_thenReturnTrue() {
    // Arrange
    FilterOutNull filterOutNull = new FilterOutNull();

    // Act
    Object actualApplyResult = filterOutNull.apply(new Edge("Group"));

    // Assert
    assertTrue((Boolean) actualApplyResult);
  }

  /**
   * Test FilterOutNull {@link FilterOutNull#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FilterOutNull#apply(Element)}
   */
  @Test
  @DisplayName("Test FilterOutNull apply(Element) with 'Element'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FilterOutNull.apply(Element)"})
  void testFilterOutNullApplyWithElement_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) new FilterOutNull().apply(null));
  }

  /**
   * Test FilterOutNull new {@link FilterOutNull} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FilterOutNull}
   */
  @Test
  @DisplayName("Test FilterOutNull new FilterOutNull (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilterOutNull.<init>()"})
  void testFilterOutNullNewFilterOutNull() {
    // Arrange, Act and Assert
    assertFalse((Boolean) new FilterOutNull().apply(null));
  }
}
