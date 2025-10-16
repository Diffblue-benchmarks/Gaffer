package uk.gov.gchq.gaffer.accumulostore.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.accumulo.core.clientImpl.ClientContext;
import org.apache.accumulo.core.clientImpl.ConnectorImpl;
import org.apache.accumulo.core.clientImpl.TableOperationsImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityIteratorSettingsFactory;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.key.exception.IteratorSettingException;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AddUpdateTableIteratorDiffblueTest {
  /**
   * Test {@link AddUpdateTableIterator#updateIterator(AccumuloStore, String, IteratorSetting)} with
   * {@code store}, {@code iteratorName}, {@code iteratorSetting}.
   *
   * <p>Method under test: {@link AddUpdateTableIterator#updateIterator(AccumuloStore, String,
   * IteratorSetting)}
   */
  @Test
  @DisplayName(
      "Test updateIterator(AccumuloStore, String, IteratorSetting) with 'store', 'iteratorName', 'iteratorSetting'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddUpdateTableIterator.updateIterator(AccumuloStore, String, IteratorSetting)"
  })
  void testUpdateIteratorWithStoreIteratorNameIteratorSetting() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new StoreException("An error occurred"));
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    // Act and Assert
    assertThrows(
        StoreException.class,
        () -> AddUpdateTableIterator.updateIterator(store, "Iterator Name", iteratorSetting));
    verify(store).getConnection();
  }

  /**
   * Test {@link AddUpdateTableIterator#updateIterator(AccumuloStore, String, IteratorSetting)} with
   * {@code store}, {@code iteratorName}, {@code iteratorSetting}.
   *
   * <p>Method under test: {@link AddUpdateTableIterator#updateIterator(AccumuloStore, String,
   * IteratorSetting)}
   */
  @Test
  @DisplayName(
      "Test updateIterator(AccumuloStore, String, IteratorSetting) with 'store', 'iteratorName', 'iteratorSetting'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddUpdateTableIterator.updateIterator(AccumuloStore, String, IteratorSetting)"
  })
  void testUpdateIteratorWithStoreIteratorNameIteratorSetting2() throws StoreException {
    // Arrange
    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations())
        .thenReturn(new TableOperationsImpl(new ClientContext(new Properties())));

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getConnection()).thenReturn(connectorImpl);
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");

    // Act and Assert
    assertThrows(
        StoreException.class,
        () -> AddUpdateTableIterator.updateIterator(store, "Iterator Name", iteratorSetting));
    verify(connectorImpl).tableOperations();
    verify(store).getConnection();
    verify(store).getTableName();
  }

  /**
   * Test {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)} with {@code store},
   * {@code iteratorName}.
   *
   * <p>Method under test: {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)}
   */
  @Test
  @DisplayName("Test addIterator(AccumuloStore, String) with 'store', 'iteratorName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddUpdateTableIterator.addIterator(AccumuloStore, String)"})
  void testAddIteratorWithStoreIteratorName() throws StoreException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenThrow(new IllegalArgumentException());
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> AddUpdateTableIterator.addIterator(store, "Iterator Name"));
    verify(store).getKeyPackage();
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)} with {@code store},
   * {@code iteratorName}.
   *
   * <p>Method under test: {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)}
   */
  @Test
  @DisplayName("Test addIterator(AccumuloStore, String) with 'store', 'iteratorName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddUpdateTableIterator.addIterator(AccumuloStore, String)"})
  void testAddIteratorWithStoreIteratorName2() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AddUpdateTableIterator.addIterator(
                store, AccumuloStoreConstants.VALIDATOR_ITERATOR_NAME));
    verify(store).getProperties();
  }

  /**
   * Test {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)} with {@code store},
   * {@code iteratorName}.
   *
   * <p>Method under test: {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)}
   */
  @Test
  @DisplayName("Test addIterator(AccumuloStore, String) with 'store', 'iteratorName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddUpdateTableIterator.addIterator(AccumuloStore, String)"})
  void testAddIteratorWithStoreIteratorName3() throws IteratorSettingException, StoreException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(true);

    ByteEntityIteratorSettingsFactory iteratorFactory =
        mock(ByteEntityIteratorSettingsFactory.class);
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");
    when(iteratorFactory.getIteratorSetting(Mockito.<AccumuloStore>any(), Mockito.<String>any()))
        .thenReturn(iteratorSetting);

    ByteEntityKeyPackage byteEntityKeyPackage = new ByteEntityKeyPackage();
    byteEntityKeyPackage.setIteratorFactory(iteratorFactory);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new StoreException("An error occurred"));
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        StoreException.class,
        () ->
            AddUpdateTableIterator.addIterator(
                store, AccumuloStoreConstants.AGGREGATOR_ITERATOR_NAME));
    verify(store).getConnection();
    verify(store).getKeyPackage();
    verify(iteratorFactory).getIteratorSetting(isA(AccumuloStore.class), eq("Aggregator"));
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)} with {@code store},
   * {@code iteratorName}.
   *
   * <p>Method under test: {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)}
   */
  @Test
  @DisplayName("Test addIterator(AccumuloStore, String) with 'store', 'iteratorName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddUpdateTableIterator.addIterator(AccumuloStore, String)"})
  void testAddIteratorWithStoreIteratorName4() throws IteratorSettingException, StoreException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(true);

    ByteEntityIteratorSettingsFactory iteratorFactory =
        mock(ByteEntityIteratorSettingsFactory.class);
    IteratorSettingException iteratorSettingException =
        new IteratorSettingException("An error occurred", new Throwable());
    when(iteratorFactory.getIteratorSetting(Mockito.<AccumuloStore>any(), Mockito.<String>any()))
        .thenThrow(iteratorSettingException);

    ByteEntityKeyPackage byteEntityKeyPackage = new ByteEntityKeyPackage();
    byteEntityKeyPackage.setIteratorFactory(iteratorFactory);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        StoreException.class,
        () ->
            AddUpdateTableIterator.addIterator(
                store, AccumuloStoreConstants.AGGREGATOR_ITERATOR_NAME));
    verify(store).getKeyPackage();
    verify(iteratorFactory).getIteratorSetting(isA(AccumuloStore.class), eq("Aggregator"));
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)} with {@code store},
   * {@code iteratorName}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)}
   */
  @Test
  @DisplayName(
      "Test addIterator(AccumuloStore, String) with 'store', 'iteratorName'; given Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddUpdateTableIterator.addIterator(AccumuloStore, String)"})
  void testAddIteratorWithStoreIteratorName_givenSchema() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());

    // Act
    AddUpdateTableIterator.addIterator(store, "Iterator Name");

    // Assert
    verify(store).getSchema();
  }

  /**
   * Test {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)} with {@code store},
   * {@code iteratorName}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#isAggregationEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)}
   */
  @Test
  @DisplayName(
      "Test addIterator(AccumuloStore, String) with 'store', 'iteratorName'; given Schema isAggregationEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddUpdateTableIterator.addIterator(AccumuloStore, String)"})
  void testAddIteratorWithStoreIteratorName_givenSchemaIsAggregationEnabledReturnFalse()
      throws StoreException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);

    // Act
    AddUpdateTableIterator.addIterator(store, "Iterator Name");

    // Assert
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)} with {@code store},
   * {@code iteratorName}.
   *
   * <ul>
   *   <li>Then calls {@link AccumuloProperties#getEnableValidatorIterator()}.
   * </ul>
   *
   * <p>Method under test: {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)}
   */
  @Test
  @DisplayName(
      "Test addIterator(AccumuloStore, String) with 'store', 'iteratorName'; then calls getEnableValidatorIterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddUpdateTableIterator.addIterator(AccumuloStore, String)"})
  void testAddIteratorWithStoreIteratorName_thenCallsGetEnableValidatorIterator()
      throws StoreException {
    // Arrange
    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);

    // Act
    AddUpdateTableIterator.addIterator(store, AccumuloStoreConstants.VALIDATOR_ITERATOR_NAME);

    // Assert
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(store).getProperties();
  }

  /**
   * Test {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)} with {@code store},
   * {@code iteratorName}.
   *
   * <ul>
   *   <li>Then calls {@link AccumuloStore#getTableName()}.
   * </ul>
   *
   * <p>Method under test: {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)}
   */
  @Test
  @DisplayName(
      "Test addIterator(AccumuloStore, String) with 'store', 'iteratorName'; then calls getTableName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddUpdateTableIterator.addIterator(AccumuloStore, String)"})
  void testAddIteratorWithStoreIteratorName_thenCallsGetTableName()
      throws IteratorSettingException, StoreException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(true);

    ByteEntityIteratorSettingsFactory iteratorFactory =
        mock(ByteEntityIteratorSettingsFactory.class);
    when(iteratorFactory.getIteratorSetting(Mockito.<AccumuloStore>any(), Mockito.<String>any()))
        .thenReturn(null);

    ByteEntityKeyPackage byteEntityKeyPackage = new ByteEntityKeyPackage();
    byteEntityKeyPackage.setIteratorFactory(iteratorFactory);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenThrow(new IllegalArgumentException());
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            AddUpdateTableIterator.addIterator(
                store, AccumuloStoreConstants.AGGREGATOR_ITERATOR_NAME));
    verify(store).getKeyPackage();
    verify(store).getTableName();
    verify(iteratorFactory).getIteratorSetting(isA(AccumuloStore.class), eq("Aggregator"));
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)} with {@code store},
   * {@code iteratorName}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#hasValidation()}.
   * </ul>
   *
   * <p>Method under test: {@link AddUpdateTableIterator#addIterator(AccumuloStore, String)}
   */
  @Test
  @DisplayName(
      "Test addIterator(AccumuloStore, String) with 'store', 'iteratorName'; then calls hasValidation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddUpdateTableIterator.addIterator(AccumuloStore, String)"})
  void testAddIteratorWithStoreIteratorName_thenCallsHasValidation()
      throws UnsupportedEncodingException, SchemaException, StoreException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.hasValidation()).thenReturn(true);
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new StoreException("An error occurred"));
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(
        StoreException.class,
        () ->
            AddUpdateTableIterator.addIterator(
                store, AccumuloStoreConstants.VALIDATOR_ITERATOR_NAME));
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(store).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store).getProperties();
    verify(store, atLeast(1)).getSchema();
    verify(schema).hasValidation();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
  }
}
