package uk.gov.gchq.gaffer.accumulostore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.accumulo.core.client.AccumuloException;
import org.apache.accumulo.core.client.AccumuloSecurityException;
import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.accumulo.core.client.NamespaceExistsException;
import org.apache.accumulo.core.client.TableExistsException;
import org.apache.accumulo.core.client.TableNotFoundException;
import org.apache.accumulo.core.clientImpl.ConnectorImpl;
import org.apache.accumulo.core.clientImpl.NamespaceOperationsImpl;
import org.apache.accumulo.core.clientImpl.TableOperationsImpl;
import org.apache.accumulo.core.iterators.IteratorUtil;
import org.apache.accumulo.core.iterators.IteratorUtil.IteratorScope;
import org.apache.hadoop.io.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.AccumuloRuntimeException;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyBloomFunctor;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class TableUtilsDiffblueTest {
  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists() throws AccumuloException, TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.getIteratorSetting(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<IteratorScope>any()))
        .thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.ensureTableExists(store));
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl).getIteratorSetting("Table Name", "Aggregator", IteratorScope.majc);
    verify(tableOperationsImpl).exists("Table Name");
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store).getProperties();
    verify(store).getTableName();
    verify(store, atLeast(1)).getSchema();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists2() throws AccumuloException, TableNotFoundException, StoreException {
    // Arrange
    ArrayList<Entry<String, String>> entryList = new ArrayList<>();
    entryList.add(
        new SimpleEntry<>(
            "gaffer.store.accumulo.enable.validator.iterator",
            "gaffer.store.accumulo.enable.validator.iterator"));

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.getProperties(Mockito.<String>any())).thenReturn(entryList);
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");
    when(tableOperationsImpl.getIteratorSetting(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<IteratorScope>any()))
        .thenReturn(iteratorSetting);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(StoreException.class, () -> TableUtils.ensureTableExists(store));
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl, atLeast(1))
        .getIteratorSetting(eq("Table Name"), Mockito.<String>any(), Mockito.<IteratorScope>any());
    verify(tableOperationsImpl).exists("Table Name");
    verify(tableOperationsImpl).getProperties("Table Name");
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store).getProperties();
    verify(store).getTableName();
    verify(store, atLeast(1)).getSchema();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists3() throws AccumuloException, TableNotFoundException, StoreException {
    // Arrange
    IteratorSetting iteratorSetting = mock(IteratorSetting.class);
    when(iteratorSetting.removeOption(Mockito.<String>any()))
        .thenThrow(new AccumuloRuntimeException("An error occurred"));

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.getIteratorSetting(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<IteratorScope>any()))
        .thenReturn(iteratorSetting);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.ensureTableExists(store));
    verify(iteratorSetting).removeOption("Schema");
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl).getIteratorSetting("Table Name", "Aggregator", IteratorScope.majc);
    verify(tableOperationsImpl).exists("Table Name");
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(store, atLeast(1)).getConnection();
    verify(store).getProperties();
    verify(store).getTableName();
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists4() throws StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace())
        .thenThrow(new AccumuloRuntimeException("An error occurred"));

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.ensureTableExists(store));
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(accumuloProperties).getNamespace();
    verify(store, atLeast(1)).getConnection();
    verify(store).getProperties();
    verify(store, atLeast(1)).getTableName();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists5() throws StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations())
        .thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.ensureTableExists(store));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(accumuloProperties).getNamespace();
    verify(store, atLeast(1)).getConnection();
    verify(store).getProperties();
    verify(store, atLeast(1)).getTableName();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists6()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperationsImpl namespaceOperationsImpl = mock(NamespaceOperationsImpl.class);
    when(namespaceOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperationsImpl);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor()).thenReturn(null);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    ByteEntityKeyPackage byteEntityKeyPackage = mock(ByteEntityKeyPackage.class);
    when(byteEntityKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.ensureTableExists(store));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(namespaceOperationsImpl).exists("not blank");
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(byteEntityKeyPackage).getKeyFunctor();
    verify(schema).getGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists7()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setLocalityGroups(Mockito.<String>any(), Mockito.<Map<String, Set<Text>>>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperationsImpl namespaceOperationsImpl = mock(NamespaceOperationsImpl.class);
    when(namespaceOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperationsImpl);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Creating table {} as user {}");
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    ByteEntityKeyPackage byteEntityKeyPackage = mock(ByteEntityKeyPackage.class);
    when(byteEntityKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act
    TableUtils.ensureTableExists(store);

    // Assert
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(namespaceOperationsImpl).exists("not blank");
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl).setLocalityGroups(eq("Table Name"), isA(Map.class));
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(byteEntityKeyPackage).getKeyFunctor();
    verify(schema).getGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists8()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperationsImpl namespaceOperationsImpl = mock(NamespaceOperationsImpl.class);
    when(namespaceOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperationsImpl);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor()).thenReturn(null);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(true);

    ByteEntityKeyPackage byteEntityKeyPackage = mock(ByteEntityKeyPackage.class);
    when(byteEntityKeyPackage.getIteratorFactory())
        .thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(byteEntityKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.ensureTableExists(store));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(namespaceOperationsImpl).exists("not blank");
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(byteEntityKeyPackage).getIteratorFactory();
    verify(byteEntityKeyPackage).getKeyFunctor();
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties} {@link AccumuloProperties#getNamespace()} return empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test ensureTableExists(AccumuloStore); given AccumuloProperties getNamespace() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_givenAccumuloPropertiesGetNamespaceReturnEmptyString()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setLocalityGroups(Mockito.<String>any(), Mockito.<Map<String, Set<Text>>>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("");
    when(accumuloProperties.getTableFileReplicationFactor()).thenReturn(null);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    ByteEntityKeyPackage byteEntityKeyPackage = mock(ByteEntityKeyPackage.class);
    when(byteEntityKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act
    TableUtils.ensureTableExists(store);

    // Assert
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl).setLocalityGroups(eq("Table Name"), isA(Map.class));
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(byteEntityKeyPackage).getKeyFunctor();
    verify(schema).getGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link AccumuloRuntimeException#AccumuloRuntimeException(String)} with message is
   *       {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test ensureTableExists(AccumuloStore); given AccumuloRuntimeException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_givenAccumuloRuntimeExceptionWithMessageIsAnErrorOccurred()
      throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.ensureTableExists(store));
    verify(store).getConnection();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code Creating table {} as user {}}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test ensureTableExists(AccumuloStore); given HashSet() add 'Creating table {} as user {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_givenHashSetAddCreatingTableAsUser()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setLocalityGroups(Mockito.<String>any(), Mockito.<Map<String, Set<Text>>>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperationsImpl namespaceOperationsImpl = mock(NamespaceOperationsImpl.class);
    when(namespaceOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperationsImpl);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor()).thenReturn(null);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    ByteEntityKeyPackage byteEntityKeyPackage = mock(ByteEntityKeyPackage.class);
    when(byteEntityKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Creating table {} as user {}");

    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenReturn(stringSet);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act
    TableUtils.ensureTableExists(store);

    // Assert
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(namespaceOperationsImpl).exists("not blank");
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl).setLocalityGroups(eq("Table Name"), isA(Map.class));
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(byteEntityKeyPackage).getKeyFunctor();
    verify(schema).getGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AccumuloStore} {@link AccumuloStore#getTableName()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test ensureTableExists(AccumuloStore); given 'null'; when AccumuloStore getTableName() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_givenNull_whenAccumuloStoreGetTableNameReturnNull()
      throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn(null);

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.ensureTableExists(store));
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   *   <li>When {@link AccumuloStore} {@link AccumuloStore#getSchema()} return {@link
   *       Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test ensureTableExists(AccumuloStore); given Schema(); when AccumuloStore getSchema() return Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_givenSchema_whenAccumuloStoreGetSchemaReturnSchema()
      throws AccumuloException, TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.getProperties(Mockito.<String>any())).thenReturn(new ArrayList<>());
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");
    when(tableOperationsImpl.getIteratorSetting(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<IteratorScope>any()))
        .thenReturn(iteratorSetting);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(StoreException.class, () -> TableUtils.ensureTableExists(store));
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl, atLeast(1))
        .getIteratorSetting(eq("Table Name"), Mockito.<String>any(), Mockito.<IteratorScope>any());
    verify(tableOperationsImpl).exists("Table Name");
    verify(tableOperationsImpl).getProperties("Table Name");
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store).getProperties();
    verify(store).getTableName();
    verify(store, atLeast(1)).getSchema();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link TableOperationsImpl} {@link TableOperationsImpl#getIteratorSetting(String,
   *       String, IteratorScope)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test ensureTableExists(AccumuloStore); given TableOperationsImpl getIteratorSetting(String, String, IteratorScope) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_givenTableOperationsImplGetIteratorSettingReturnNull()
      throws AccumuloException, TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.getProperties(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(tableOperationsImpl.getIteratorSetting(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<IteratorScope>any()))
        .thenReturn(null);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(StoreException.class, () -> TableUtils.ensureTableExists(store));
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl, atLeast(1))
        .getIteratorSetting(eq("Table Name"), Mockito.<String>any(), Mockito.<IteratorScope>any());
    verify(tableOperationsImpl).exists("Table Name");
    verify(tableOperationsImpl).getProperties("Table Name");
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store).getProperties();
    verify(store).getTableName();
    verify(store, atLeast(1)).getSchema();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then calls {@link NamespaceOperationsImpl#create(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore); then calls create(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_thenCallsCreate()
      throws AccumuloException, AccumuloSecurityException, NamespaceExistsException,
          TableExistsException, TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setLocalityGroups(Mockito.<String>any(), Mockito.<Map<String, Set<Text>>>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperationsImpl namespaceOperationsImpl = mock(NamespaceOperationsImpl.class);
    when(namespaceOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing().when(namespaceOperationsImpl).create(Mockito.<String>any());

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperationsImpl);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor()).thenReturn(null);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    ByteEntityKeyPackage byteEntityKeyPackage = mock(ByteEntityKeyPackage.class);
    when(byteEntityKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act
    TableUtils.ensureTableExists(store);

    // Assert
    verify(connectorImpl, atLeast(1)).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl, atLeast(1)).whoami();
    verify(namespaceOperationsImpl).create("not blank");
    verify(namespaceOperationsImpl).exists("not blank");
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl).setLocalityGroups(eq("Table Name"), isA(Map.class));
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(byteEntityKeyPackage).getKeyFunctor();
    verify(schema).getGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getAggregatedGroups()}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore); then calls getAggregatedGroups()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_thenCallsGetAggregatedGroups()
      throws UnsupportedEncodingException, AccumuloException, TableNotFoundException,
          SchemaException, StoreException {
    // Arrange
    IteratorSetting iteratorSetting = mock(IteratorSetting.class);
    when(iteratorSetting.removeOption(Mockito.<String>any())).thenReturn("Remove Option");

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.getProperties(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(tableOperationsImpl.getIteratorSetting(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<IteratorScope>any()))
        .thenReturn(iteratorSetting);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenReturn(new ArrayList<>());
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(StoreException.class, () -> TableUtils.ensureTableExists(store));
    verify(iteratorSetting, atLeast(1)).removeOption(Mockito.<String>any());
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl, atLeast(1))
        .getIteratorSetting(eq("Table Name"), Mockito.<String>any(), Mockito.<IteratorScope>any());
    verify(tableOperationsImpl).exists("Table Name");
    verify(tableOperationsImpl).getProperties("Table Name");
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store).getProperties();
    verify(store).getTableName();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getAggregatedGroups();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#getAggregatedGroups()}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore); then calls getAggregatedGroups()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_thenCallsGetAggregatedGroups2()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperationsImpl namespaceOperationsImpl = mock(NamespaceOperationsImpl.class);
    when(namespaceOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperationsImpl);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor()).thenReturn(null);

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.ensureTableExists(store));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(namespaceOperationsImpl).exists("not blank");
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then calls {@link ByteEntityKeyPackage#getIteratorFactory()}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore); then calls getIteratorFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_thenCallsGetIteratorFactory()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperationsImpl namespaceOperationsImpl = mock(NamespaceOperationsImpl.class);
    when(namespaceOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperationsImpl);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor()).thenReturn(null);

    ByteEntityKeyPackage byteEntityKeyPackage = mock(ByteEntityKeyPackage.class);
    when(byteEntityKeyPackage.getIteratorFactory())
        .thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(byteEntityKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.ensureTableExists(store));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(namespaceOperationsImpl).exists("not blank");
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(byteEntityKeyPackage).getIteratorFactory();
    verify(byteEntityKeyPackage).getKeyFunctor();
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#hasValidation()}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore); then calls hasValidation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_thenCallsHasValidation()
      throws UnsupportedEncodingException, AccumuloException, TableNotFoundException,
          SchemaException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.getProperties(Mockito.<String>any())).thenReturn(new ArrayList<>());
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");
    when(tableOperationsImpl.getIteratorSetting(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<IteratorScope>any()))
        .thenReturn(iteratorSetting);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.isAggregationEnabled()).thenReturn(false);
    when(schema.hasValidation()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(StoreException.class, () -> TableUtils.ensureTableExists(store));
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl, atLeast(1))
        .getIteratorSetting(eq("Table Name"), Mockito.<String>any(), Mockito.<IteratorScope>any());
    verify(tableOperationsImpl).exists("Table Name");
    verify(tableOperationsImpl).getProperties("Table Name");
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store).getProperties();
    verify(store).getTableName();
    verify(store, atLeast(1)).getSchema();
    verify(schema).hasValidation();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then calls {@link IteratorSetting#removeOption(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore); then calls removeOption(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_thenCallsRemoveOption()
      throws AccumuloException, TableNotFoundException, StoreException {
    // Arrange
    IteratorSetting iteratorSetting = mock(IteratorSetting.class);
    when(iteratorSetting.removeOption(Mockito.<String>any())).thenReturn("Remove Option");

    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.getProperties(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(tableOperationsImpl.getIteratorSetting(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<IteratorScope>any()))
        .thenReturn(iteratorSetting);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(StoreException.class, () -> TableUtils.ensureTableExists(store));
    verify(iteratorSetting, atLeast(1)).removeOption(Mockito.<String>any());
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl, atLeast(1))
        .getIteratorSetting(eq("Table Name"), Mockito.<String>any(), Mockito.<IteratorScope>any());
    verify(tableOperationsImpl).exists("Table Name");
    verify(tableOperationsImpl).getProperties("Table Name");
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(store, atLeast(1)).getConnection();
    verify(store).getProperties();
    verify(store).getTableName();
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then calls {@link TableOperationsImpl#setLocalityGroups(String, Map)}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore); then calls setLocalityGroups(String, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_thenCallsSetLocalityGroups()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setLocalityGroups(Mockito.<String>any(), Mockito.<Map<String, Set<Text>>>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    NamespaceOperationsImpl namespaceOperationsImpl = mock(NamespaceOperationsImpl.class);
    when(namespaceOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperationsImpl);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");
    when(accumuloProperties.getTableFileReplicationFactor()).thenReturn(null);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    ByteEntityKeyPackage byteEntityKeyPackage = mock(ByteEntityKeyPackage.class);
    when(byteEntityKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenReturn(new HashSet<>());
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act
    TableUtils.ensureTableExists(store);

    // Assert
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(namespaceOperationsImpl).exists("not blank");
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl).setLocalityGroups(eq("Table Name"), isA(Map.class));
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(accumuloProperties).getNamespace();
    verify(accumuloProperties).getTableFileReplicationFactor();
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(byteEntityKeyPackage).getKeyFunctor();
    verify(schema).getGroups();
    verify(store, atLeast(1)).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link TableUtils#ensureTableExists(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then throw {@link StoreException}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#ensureTableExists(AccumuloStore)}
   */
  @Test
  @DisplayName("Test ensureTableExists(AccumuloStore); then throw StoreException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.ensureTableExists(AccumuloStore)"})
  void testEnsureTableExists_thenThrowStoreException()
      throws AccumuloException, TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.getProperties(Mockito.<String>any())).thenReturn(new ArrayList<>());
    IteratorSetting iteratorSetting = new IteratorSetting(1, "Name", "Iterator Class");
    when(tableOperationsImpl.getIteratorSetting(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<IteratorScope>any()))
        .thenReturn(iteratorSetting);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(StoreException.class, () -> TableUtils.ensureTableExists(store));
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl, atLeast(1))
        .getIteratorSetting(eq("Table Name"), Mockito.<String>any(), Mockito.<IteratorScope>any());
    verify(tableOperationsImpl).exists("Table Name");
    verify(tableOperationsImpl).getProperties("Table Name");
    verify(accumuloProperties).getEnableValidatorIterator();
    verify(store, atLeast(1)).getConnection();
    verify(store).getProperties();
    verify(store).getTableName();
    verify(store).getSchema();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link TableUtils#createTable(AccumuloStore)}.
   *
   * <p>Method under test: {@link TableUtils#createTable(AccumuloStore)}
   */
  @Test
  @DisplayName("Test createTable(AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.createTable(AccumuloStore)"})
  void testCreateTable() throws TableExistsException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations())
        .thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.createTable(store));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl).tableOperations();
    verify(tableOperationsImpl).exists("Table Name");
    verify(accumuloProperties).getNamespace();
    verify(store).getConnection();
    verify(store).getProperties();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#createTable(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties#AccumuloProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#createTable(AccumuloStore)}
   */
  @Test
  @DisplayName("Test createTable(AccumuloStore); given AccumuloProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.createTable(AccumuloStore)"})
  void testCreateTable_givenAccumuloProperties() throws TableExistsException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.whoami()).thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.createTable(store));
    verify(connectorImpl).tableOperations();
    verify(connectorImpl).whoami();
    verify(tableOperationsImpl).exists("Table Name");
    verify(store).getConnection();
    verify(store).getProperties();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#createTable(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties} {@link AccumuloProperties#getNamespace()} return space.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#createTable(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test createTable(AccumuloStore); given AccumuloProperties getNamespace() return space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.createTable(AccumuloStore)"})
  void testCreateTable_givenAccumuloPropertiesGetNamespaceReturnSpace()
      throws TableExistsException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.whoami()).thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn(" ");

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.createTable(store));
    verify(connectorImpl).tableOperations();
    verify(connectorImpl).whoami();
    verify(tableOperationsImpl).exists("Table Name");
    verify(accumuloProperties).getNamespace();
    verify(store).getConnection();
    verify(store).getProperties();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#createTable(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link AccumuloRuntimeException#AccumuloRuntimeException(String)} with message is
   *       {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#createTable(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test createTable(AccumuloStore); given AccumuloRuntimeException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.createTable(AccumuloStore)"})
  void testCreateTable_givenAccumuloRuntimeExceptionWithMessageIsAnErrorOccurred()
      throws TableExistsException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.createTable(store));
    verify(store).getConnection();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#createTable(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link NamespaceOperationsImpl} {@link NamespaceOperationsImpl#exists(String)}
   *       return {@code false}.
   *   <li>Then calls {@link NamespaceOperationsImpl#exists(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#createTable(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test createTable(AccumuloStore); given NamespaceOperationsImpl exists(String) return 'false'; then calls exists(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.createTable(AccumuloStore)"})
  void testCreateTable_givenNamespaceOperationsImplExistsReturnFalse_thenCallsExists()
      throws TableExistsException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);

    NamespaceOperationsImpl namespaceOperationsImpl = mock(NamespaceOperationsImpl.class);
    when(namespaceOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperationsImpl);
    when(connectorImpl.whoami()).thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.createTable(store));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl).tableOperations();
    verify(connectorImpl).whoami();
    verify(namespaceOperationsImpl).exists("not blank");
    verify(tableOperationsImpl).exists("Table Name");
    verify(accumuloProperties).getNamespace();
    verify(store).getConnection();
    verify(store).getProperties();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#createTable(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link NamespaceOperationsImpl} {@link NamespaceOperationsImpl#exists(String)}
   *       return {@code true}.
   *   <li>Then calls {@link NamespaceOperationsImpl#exists(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#createTable(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test createTable(AccumuloStore); given NamespaceOperationsImpl exists(String) return 'true'; then calls exists(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.createTable(AccumuloStore)"})
  void testCreateTable_givenNamespaceOperationsImplExistsReturnTrue_thenCallsExists()
      throws TableExistsException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);

    NamespaceOperationsImpl namespaceOperationsImpl = mock(NamespaceOperationsImpl.class);
    when(namespaceOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperationsImpl);
    when(connectorImpl.whoami()).thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("not blank");

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.createTable(store));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl).tableOperations();
    verify(connectorImpl).whoami();
    verify(namespaceOperationsImpl).exists("not blank");
    verify(tableOperationsImpl).exists("Table Name");
    verify(accumuloProperties).getNamespace();
    verify(store).getConnection();
    verify(store).getProperties();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#createTable(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AccumuloStore} {@link AccumuloStore#getTableName()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#createTable(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test createTable(AccumuloStore); given 'null'; when AccumuloStore getTableName() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.createTable(AccumuloStore)"})
  void testCreateTable_givenNull_whenAccumuloStoreGetTableNameReturnNull()
      throws TableExistsException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getTableName()).thenReturn(null);

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.createTable(store));
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#createTable(AccumuloStore)}.
   *
   * <ul>
   *   <li>Given {@link TableOperationsImpl} {@link TableOperationsImpl#exists(String)} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#createTable(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test createTable(AccumuloStore); given TableOperationsImpl exists(String) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.createTable(AccumuloStore)"})
  void testCreateTable_givenTableOperationsImplExistsReturnTrue()
      throws TableExistsException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act
    TableUtils.createTable(store);

    // Assert
    verify(connectorImpl).tableOperations();
    verify(tableOperationsImpl).exists("Table Name");
    verify(store).getConnection();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#createTable(AccumuloStore)}.
   *
   * <ul>
   *   <li>Then calls {@link TableOperationsImpl#removeIterator(String, String, EnumSet)}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#createTable(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test createTable(AccumuloStore); then calls removeIterator(String, String, EnumSet)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableUtils.createTable(AccumuloStore)"})
  void testCreateTable_thenCallsRemoveIterator()
      throws AccumuloException, AccumuloSecurityException, TableExistsException,
          TableNotFoundException, StoreException {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing()
        .when(tableOperationsImpl)
        .removeIterator(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<EnumSet<IteratorScope>>any());
    doNothing().when(tableOperationsImpl).create(Mockito.<String>any());
    doNothing()
        .when(tableOperationsImpl)
        .setLocalityGroups(Mockito.<String>any(), Mockito.<Map<String, Set<Text>>>any());
    doNothing()
        .when(tableOperationsImpl)
        .setProperty(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");

    // Act
    TableUtils.createTable(store);

    // Assert
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl).exists("Table Name");
    verify(tableOperationsImpl).setLocalityGroups(eq("Table Name"), isA(Map.class));
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(store, atLeast(1)).getSchema();
  }

  /**
   * Test {@link TableUtils#createBatchWriter(AccumuloStore)} with {@code store}.
   *
   * <ul>
   *   <li>Then throw {@link AccumuloRuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#createBatchWriter(AccumuloStore)}
   */
  @Test
  @DisplayName(
      "Test createBatchWriter(AccumuloStore) with 'store'; then throw AccumuloRuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.accumulo.core.client.BatchWriter TableUtils.createBatchWriter(AccumuloStore)"
  })
  void testCreateBatchWriterWithStore_thenThrowAccumuloRuntimeException() throws StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new AccumuloRuntimeException("An error occurred"));
    when(store.getTableName()).thenReturn("Table Name");
    when(store.getProperties()).thenReturn(new AccumuloProperties());

    // Act and Assert
    assertThrows(AccumuloRuntimeException.class, () -> TableUtils.createBatchWriter(store));
    verify(store).getConnection();
    verify(store, atLeast(1)).getProperties();
    verify(store).getTableName();
  }

  /**
   * Test {@link TableUtils#getTableName(AccumuloProperties, String)}.
   *
   * <ul>
   *   <li>Given {@code accumulo.namespace}.
   *   <li>Then return {@code 42.42}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#getTableName(AccumuloProperties, String)}
   */
  @Test
  @DisplayName(
      "Test getTableName(AccumuloProperties, String); given 'accumulo.namespace'; then return '42.42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableUtils.getTableName(AccumuloProperties, String)"})
  void testGetTableName_givenAccumuloNamespace_thenReturn4242() {
    // Arrange
    AccumuloProperties accumuloProperties = new AccumuloProperties();
    accumuloProperties.set("accumulo.namespace", "42");

    // Act and Assert
    assertEquals("42.42", TableUtils.getTableName(accumuloProperties, "42"));
  }

  /**
   * Test {@link TableUtils#getTableName(AccumuloProperties, String)}.
   *
   * <ul>
   *   <li>When {@link AccumuloProperties#AccumuloProperties()}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TableUtils#getTableName(AccumuloProperties, String)}
   */
  @Test
  @DisplayName(
      "Test getTableName(AccumuloProperties, String); when AccumuloProperties(); then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableUtils.getTableName(AccumuloProperties, String)"})
  void testGetTableName_whenAccumuloProperties_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", TableUtils.getTableName(new AccumuloProperties(), "42"));
  }
}
