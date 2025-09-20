package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.handler.job.tool;

import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.accumulo.core.clientImpl.ConnectorImpl;
import org.apache.accumulo.core.clientImpl.NamespaceOperationsImpl;
import org.apache.accumulo.core.clientImpl.TableOperationsImpl;
import org.apache.accumulo.core.iterators.IteratorUtil;
import org.apache.accumulo.core.iterators.IteratorUtil.IteratorScope;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyBloomFunctor;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ImportElementsToAccumuloToolDiffblueTest {
  /**
   * Test {@link ImportElementsToAccumuloTool#ImportElementsToAccumuloTool(String, String,
   * AccumuloStore)}.
   *
   * <p>Method under test: {@link ImportElementsToAccumuloTool#ImportElementsToAccumuloTool(String,
   * String, AccumuloStore)}
   */
  @Test
  @DisplayName("Test new ImportElementsToAccumuloTool(String, String, AccumuloStore)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImportElementsToAccumuloTool.<init>(String, String, AccumuloStore)"})
  void testNewImportElementsToAccumuloTool() {
    // Arrange and Act
    ImportElementsToAccumuloTool actualImportElementsToAccumuloTool =
        new ImportElementsToAccumuloTool("Input Path", "Failure Path", new AccumuloStore());

    // Assert
    assertNull(actualImportElementsToAccumuloTool.getConf());
  }

  /**
   * Test {@link ImportElementsToAccumuloTool#ImportElementsToAccumuloTool(String, String,
   * AccumuloStore, Map)}.
   *
   * <p>Method under test: {@link ImportElementsToAccumuloTool#ImportElementsToAccumuloTool(String,
   * String, AccumuloStore, Map)}
   */
  @Test
  @DisplayName("Test new ImportElementsToAccumuloTool(String, String, AccumuloStore, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImportElementsToAccumuloTool.<init>(String, String, AccumuloStore, Map)"
  })
  void testNewImportElementsToAccumuloTool2() {
    // Arrange
    AccumuloStore store = new AccumuloStore();

    // Act
    ImportElementsToAccumuloTool actualImportElementsToAccumuloTool =
        new ImportElementsToAccumuloTool("Input Path", "Failure Path", store, new HashMap<>());

    // Assert
    assertNull(actualImportElementsToAccumuloTool.getConf());
  }

  /**
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   *
   * <ul>
   *   <li>Given {@link AccumuloProperties} {@link AccumuloProperties#getNamespace()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName(
      "Test run(String[]); given AccumuloProperties getNamespace() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun_givenAccumuloPropertiesGetNamespaceThrowIllegalArgumentException() throws Exception {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenThrow(new IllegalArgumentException());

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");
    ImportElementsToAccumuloTool importElementsToAccumuloTool =
        new ImportElementsToAccumuloTool("Input Path", "Failure Path", store);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> importElementsToAccumuloTool.run(new String[] {"Strings"}));
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(accumuloProperties).getNamespace();
    verify(store, atLeast(1)).getConnection();
    verify(store).getProperties();
    verify(store, atLeast(1)).getTableName();
  }

  /**
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   *
   * <ul>
   *   <li>Given {@link AccumuloStore} {@link AccumuloStore#getConnection()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName(
      "Test run(String[]); given AccumuloStore getConnection() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun_givenAccumuloStoreGetConnectionThrowIllegalArgumentException() throws Exception {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getConnection()).thenThrow(new IllegalArgumentException());
    when(store.getTableName()).thenReturn("Table Name");
    ImportElementsToAccumuloTool importElementsToAccumuloTool =
        new ImportElementsToAccumuloTool("Input Path", "Failure Path", store);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> importElementsToAccumuloTool.run(new String[] {"Strings"}));
    verify(store).getConnection();
    verify(store, atLeast(1)).getTableName();
  }

  /**
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   *
   * <ul>
   *   <li>Given {@link ConnectorImpl} {@link ConnectorImpl#namespaceOperations()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName(
      "Test run(String[]); given ConnectorImpl namespaceOperations() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun_givenConnectorImplNamespaceOperationsThrowIllegalArgumentException()
      throws Exception {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenThrow(new IllegalArgumentException());
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("Namespace");

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");
    ImportElementsToAccumuloTool importElementsToAccumuloTool =
        new ImportElementsToAccumuloTool("Input Path", "Failure Path", store);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> importElementsToAccumuloTool.run(new String[] {"Strings"}));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(accumuloProperties).getNamespace();
    verify(store, atLeast(1)).getConnection();
    verify(store).getProperties();
    verify(store, atLeast(1)).getTableName();
  }

  /**
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   *
   * <ul>
   *   <li>Given {@link NamespaceOperationsImpl} {@link NamespaceOperationsImpl#exists(String)}
   *       return {@code false}.
   *   <li>Then calls {@link NamespaceOperationsImpl#create(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName(
      "Test run(String[]); given NamespaceOperationsImpl exists(String) return 'false'; then calls create(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun_givenNamespaceOperationsImplExistsReturnFalse_thenCallsCreate() throws Exception {
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
    when(namespaceOperationsImpl.exists(Mockito.<String>any())).thenReturn(false);
    doNothing().when(namespaceOperationsImpl).create(Mockito.<String>any());

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.namespaceOperations()).thenReturn(namespaceOperationsImpl);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    when(accumuloProperties.getNamespace()).thenReturn("Namespace");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Table File Replication Factor");
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    ByteEntityKeyPackage byteEntityKeyPackage = mock(ByteEntityKeyPackage.class);
    when(byteEntityKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenThrow(new IllegalArgumentException());
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");
    ImportElementsToAccumuloTool importElementsToAccumuloTool =
        new ImportElementsToAccumuloTool("Input Path", "Failure Path", store);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> importElementsToAccumuloTool.run(new String[] {"Strings"}));
    verify(connectorImpl, atLeast(1)).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl, atLeast(1)).whoami();
    verify(namespaceOperationsImpl).create("Namespace");
    verify(namespaceOperationsImpl).exists("Namespace");
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
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#getGroups()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link Schema#getGroups()}.
   * </ul>
   *
   * <p>Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName(
      "Test run(String[]); given Schema getGroups() throw IllegalArgumentException(); then calls getGroups()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun_givenSchemaGetGroupsThrowIllegalArgumentException_thenCallsGetGroups()
      throws Exception {
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
    when(accumuloProperties.getNamespace()).thenReturn("Namespace");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Table File Replication Factor");
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(false);

    ByteEntityKeyPackage byteEntityKeyPackage = mock(ByteEntityKeyPackage.class);
    when(byteEntityKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.getGroups()).thenThrow(new IllegalArgumentException());
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");
    ImportElementsToAccumuloTool importElementsToAccumuloTool =
        new ImportElementsToAccumuloTool("Input Path", "Failure Path", store);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> importElementsToAccumuloTool.run(new String[] {"Strings"}));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(namespaceOperationsImpl).exists("Namespace");
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
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#isAggregationEnabled()} return {@code true}.
   *   <li>Then calls {@link Schema#getAggregatedGroups()}.
   * </ul>
   *
   * <p>Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName(
      "Test run(String[]); given Schema isAggregationEnabled() return 'true'; then calls getAggregatedGroups()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun_givenSchemaIsAggregationEnabledReturnTrue_thenCallsGetAggregatedGroups()
      throws Exception {
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

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.whoami()).thenReturn("Whoami");
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    Schema schema = mock(Schema.class);
    when(schema.getAggregatedGroups()).thenThrow(new IllegalArgumentException());
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");
    ImportElementsToAccumuloTool importElementsToAccumuloTool =
        new ImportElementsToAccumuloTool("Input Path", "Failure Path", store);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> importElementsToAccumuloTool.run(new String[] {"Strings"}));
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(tableOperationsImpl).removeIterator(eq("Table Name"), eq("vers"), isA(EnumSet.class));
    verify(tableOperationsImpl).create("Table Name");
    verify(tableOperationsImpl, atLeast(1)).exists("Table Name");
    verify(tableOperationsImpl, atLeast(1))
        .setProperty(eq("Table Name"), Mockito.<String>any(), Mockito.<String>any());
    verify(store, atLeast(1)).getConnection();
    verify(store, atLeast(1)).getKeyPackage();
    verify(store, atLeast(1)).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(store, atLeast(1)).getSchema();
    verify(schema).getAggregatedGroups();
    verify(schema).isAggregationEnabled();
  }

  /**
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   *
   * <ul>
   *   <li>Given {@link Schema} {@link Schema#isAggregationEnabled()} return {@code true}.
   *   <li>Then calls {@link ByteEntityKeyPackage#getIteratorFactory()}.
   * </ul>
   *
   * <p>Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName(
      "Test run(String[]); given Schema isAggregationEnabled() return 'true'; then calls getIteratorFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun_givenSchemaIsAggregationEnabledReturnTrue_thenCallsGetIteratorFactory()
      throws Exception {
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
    when(accumuloProperties.getNamespace()).thenReturn("Namespace");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Table File Replication Factor");

    ByteEntityKeyPackage byteEntityKeyPackage = mock(ByteEntityKeyPackage.class);
    when(byteEntityKeyPackage.getIteratorFactory()).thenThrow(new IllegalArgumentException());
    when(byteEntityKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");
    ImportElementsToAccumuloTool importElementsToAccumuloTool =
        new ImportElementsToAccumuloTool("Input Path", "Failure Path", store);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> importElementsToAccumuloTool.run(new String[] {"Strings"}));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(namespaceOperationsImpl).exists("Namespace");
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
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   *
   * <ul>
   *   <li>Then calls {@link ByteEntityKeyPackage#getIteratorFactory()}.
   * </ul>
   *
   * <p>Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName("Test run(String[]); then calls getIteratorFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun_thenCallsGetIteratorFactory() throws Exception {
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
    when(accumuloProperties.getNamespace()).thenReturn("Namespace");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Table File Replication Factor");
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(true);

    ByteEntityKeyPackage byteEntityKeyPackage = mock(ByteEntityKeyPackage.class);
    when(byteEntityKeyPackage.getIteratorFactory()).thenThrow(new IllegalArgumentException());
    when(byteEntityKeyPackage.getKeyFunctor()).thenReturn(new CoreKeyBloomFunctor());

    Schema schema = mock(Schema.class);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");
    ImportElementsToAccumuloTool importElementsToAccumuloTool =
        new ImportElementsToAccumuloTool("Input Path", "Failure Path", store);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> importElementsToAccumuloTool.run(new String[] {"Strings"}));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(namespaceOperationsImpl).exists("Namespace");
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
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   *
   * <ul>
   *   <li>Then calls {@link TableOperationsImpl#getIteratorSetting(String, String, IteratorScope)}.
   * </ul>
   *
   * <p>Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName("Test run(String[]); then calls getIteratorSetting(String, String, IteratorScope)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun_thenCallsGetIteratorSetting() throws Exception {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.getIteratorSetting(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<IteratorScope>any()))
        .thenThrow(new IllegalArgumentException());
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");
    ImportElementsToAccumuloTool importElementsToAccumuloTool =
        new ImportElementsToAccumuloTool("Input Path", "Failure Path", store);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> importElementsToAccumuloTool.run(new String[] {"Strings"}));
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(tableOperationsImpl).getIteratorSetting("Table Name", "Aggregator", IteratorScope.majc);
    verify(tableOperationsImpl).exists("Table Name");
    verify(store, atLeast(1)).getConnection();
    verify(store).getKeyPackage();
    verify(store).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(store, atLeast(1)).getSchema();
  }

  /**
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#hasValidation()}.
   * </ul>
   *
   * <p>Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName("Test run(String[]); then calls hasValidation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun_thenCallsHasValidation() throws Exception {
    // Arrange
    TableOperationsImpl tableOperationsImpl = mock(TableOperationsImpl.class);
    when(tableOperationsImpl.exists(Mockito.<String>any())).thenReturn(true);

    ConnectorImpl connectorImpl = mock(ConnectorImpl.class);
    when(connectorImpl.tableOperations()).thenReturn(tableOperationsImpl);

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenThrow(new IllegalArgumentException());
    when(schema.hasValidation()).thenReturn(true);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(new AccumuloProperties());
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");
    ImportElementsToAccumuloTool importElementsToAccumuloTool =
        new ImportElementsToAccumuloTool("Input Path", "Failure Path", store);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> importElementsToAccumuloTool.run(new String[] {"Strings"}));
    verify(connectorImpl).tableOperations();
    verify(tableOperationsImpl).exists("Table Name");
    verify(store).getConnection();
    verify(store).getKeyPackage();
    verify(store).getProperties();
    verify(store, atLeast(1)).getTableName();
    verify(store, atLeast(1)).getSchema();
    verify(schema).hasValidation();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link ImportElementsToAccumuloTool#run(String[])}.
   *
   * <ul>
   *   <li>Then calls {@link Schema#hasValidation()}.
   * </ul>
   *
   * <p>Method under test: {@link ImportElementsToAccumuloTool#run(String[])}
   */
  @Test
  @DisplayName("Test run(String[]); then calls hasValidation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImportElementsToAccumuloTool.run(String[])"})
  void testRun_thenCallsHasValidation2() throws Exception {
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
    when(accumuloProperties.getNamespace()).thenReturn("Namespace");
    when(accumuloProperties.getTableFileReplicationFactor())
        .thenReturn("Table File Replication Factor");
    when(accumuloProperties.getEnableValidatorIterator()).thenReturn(true);

    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenThrow(new IllegalArgumentException());
    when(schema.hasValidation()).thenReturn(true);
    when(schema.isAggregationEnabled()).thenReturn(false);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    when(store.getProperties()).thenReturn(accumuloProperties);
    when(store.getConnection()).thenReturn(connectorImpl);
    when(store.getTableName()).thenReturn("Table Name");
    ImportElementsToAccumuloTool importElementsToAccumuloTool =
        new ImportElementsToAccumuloTool("Input Path", "Failure Path", store);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> importElementsToAccumuloTool.run(new String[] {"Strings"}));
    verify(connectorImpl).namespaceOperations();
    verify(connectorImpl, atLeast(1)).tableOperations();
    verify(connectorImpl).whoami();
    verify(namespaceOperationsImpl).exists("Namespace");
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
    verify(store, atLeast(1)).getSchema();
    verify(schema).hasValidation();
    verify(schema).isAggregationEnabled();
    verify(schema).toCompactJson();
  }
}
