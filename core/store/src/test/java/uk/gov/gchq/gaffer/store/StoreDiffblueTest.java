package uk.gov.gchq.gaffer.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.jobtracker.Job;
import uk.gov.gchq.gaffer.jobtracker.Repeat;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.named.operation.GetAllNamedOperations;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.GetVariable;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.store.library.FileGraphLibrary;
import uk.gov.gchq.gaffer.store.library.GraphLibrary;
import uk.gov.gchq.gaffer.store.operation.OperationChainValidator;
import uk.gov.gchq.gaffer.store.operation.OperationUtil;
import uk.gov.gchq.gaffer.store.operation.handler.OperationChainHandler;
import uk.gov.gchq.gaffer.store.operation.handler.OperationHandler;
import uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.optimiser.OperationChainOptimiser;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition;
import uk.gov.gchq.gaffer.store.schema.TypeDefinition;
import uk.gov.gchq.gaffer.store.schema.TypeDefinition.Builder;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.koryphe.ValidationResult;

class StoreDiffblueTest {
  /**
   * Test {@link Store#createStore(String, Schema, StoreProperties)} with {@code String}, {@code
   * Schema}, {@code StoreProperties}.
   *
   * <ul>
   *   <li>Given {@link StoreProperties#STORE_CLASS}.
   * </ul>
   *
   * <p>Method under test: {@link Store#createStore(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test createStore(String, Schema, StoreProperties) with 'String', 'Schema', 'StoreProperties'; given STORE_CLASS")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Store Store.createStore(String, Schema, StoreProperties)"})
  void testCreateStoreWithStringSchemaStoreProperties_givenStore_class() {
    // Arrange
    Schema schema = new Schema();

    StoreProperties storeProperties = new StoreProperties();
    storeProperties.set(StoreProperties.STORE_CLASS, "42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Store.createStore("42", schema, storeProperties));
  }

  /**
   * Test {@link Store#createStore(String, Schema, StoreProperties)} with {@code String}, {@code
   * Schema}, {@code StoreProperties}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Store#createStore(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test createStore(String, Schema, StoreProperties) with 'String', 'Schema', 'StoreProperties'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Store Store.createStore(String, Schema, StoreProperties)"})
  void testCreateStoreWithStringSchemaStoreProperties_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Store.createStore("42", new Schema(), null));
  }

  /**
   * Test {@link Store#createStore(String, Schema, StoreProperties)} with {@code String}, {@code
   * Schema}, {@code StoreProperties}.
   *
   * <ul>
   *   <li>When {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link Store#createStore(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test createStore(String, Schema, StoreProperties) with 'String', 'Schema', 'StoreProperties'; when StoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Store Store.createStore(String, Schema, StoreProperties)"})
  void testCreateStoreWithStringSchemaStoreProperties_whenStoreProperties() {
    // Arrange
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Store.createStore("42", schema, new StoreProperties()));
  }

  /**
   * Test {@link Store#execute(OperationChain, Context)} with {@code OperationChain}, {@code
   * Context}.
   *
   * <ul>
   *   <li>When wrap {@link GetVariable} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Store#execute(OperationChain, Context)}
   */
  @Test
  @DisplayName(
      "Test execute(OperationChain, Context) with 'OperationChain', 'Context'; when wrap GetVariable (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Store.execute(OperationChain, Context)"})
  void testExecuteWithOperationChainContext_whenWrapGetVariable() throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    OperationChain<Object> operation = OperationChain.wrap(new GetVariable());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> testAddToGraphLibraryImpl.execute(operation, new Context()));
  }

  /**
   * Test {@link Store#execute(OperationChain, Context)} with {@code OperationChain}, {@code
   * Context}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Store#execute(OperationChain, Context)}
   */
  @Test
  @DisplayName(
      "Test execute(OperationChain, Context) with 'OperationChain', 'Context'; when wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Store.execute(OperationChain, Context)"})
  void testExecuteWithOperationChainContext_whenWrapNamedOperation() throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> testAddToGraphLibraryImpl.execute(operation, new Context()));
  }

  /**
   * Test {@link Store#execute(Operation, Context)} with {@code Operation}, {@code Context}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Store#execute(Operation, Context)}
   */
  @Test
  @DisplayName("Test execute(Operation, Context) with 'Operation', 'Context'; given HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.execute(Operation, Context)"})
  void testExecuteWithOperationContext_givenHashMap() throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    AddNamedOperation operation = new AddNamedOperation();
    operation.setOptions(new HashMap<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> testAddToGraphLibraryImpl.execute(operation, new Context()));
  }

  /**
   * Test {@link Store#execute(Operation, Context)} with {@code Operation}, {@code Context}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AddNamedOperation} (default constructor) Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Store#execute(Operation, Context)}
   */
  @Test
  @DisplayName(
      "Test execute(Operation, Context) with 'Operation', 'Context'; given 'null'; when AddNamedOperation (default constructor) Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.execute(Operation, Context)"})
  void testExecuteWithOperationContext_givenNull_whenAddNamedOperationOptionsIsNull()
      throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    AddNamedOperation operation = new AddNamedOperation();
    operation.setOptions(null);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> testAddToGraphLibraryImpl.execute(operation, new Context()));
  }

  /**
   * Test {@link Store#execute(Operation, Context)} with {@code Operation}, {@code Context}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Store#execute(Operation, Context)}
   */
  @Test
  @DisplayName(
      "Test execute(Operation, Context) with 'Operation', 'Context'; when wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.execute(Operation, Context)"})
  void testExecuteWithOperationContext_whenWrapNamedOperation() throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> testAddToGraphLibraryImpl.execute(operation, new Context()));
  }

  /**
   * Test {@link Store#execute(Output, Context)} with {@code Output}, {@code Context}.
   *
   * <p>Method under test: {@link Store#execute(Output, Context)}
   */
  @Test
  @DisplayName("Test execute(Output, Context) with 'Output', 'Context'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Store.execute(Output, Context)"})
  void testExecuteWithOutputContext() throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    NamedOperation<Object, Object> operation = new NamedOperation<>();
    operation.addOption("Operation %s is not supported by the %s.", "42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> testAddToGraphLibraryImpl.execute(operation, new Context()));
  }

  /**
   * Test {@link Store#execute(Output, Context)} with {@code Output}, {@code Context}.
   *
   * <p>Method under test: {@link Store#execute(Output, Context)}
   */
  @Test
  @DisplayName("Test execute(Output, Context) with 'Output', 'Context'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Store.execute(Output, Context)"})
  void testExecuteWithOutputContext2() throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    GetVariable operation = new GetVariable();
    operation.addOption("Operation %s is not supported by the %s.", "42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> testAddToGraphLibraryImpl.execute(operation, new Context()));
  }

  /**
   * Test {@link Store#execute(Output, Context)} with {@code Output}, {@code Context}.
   *
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Store#execute(Output, Context)}
   */
  @Test
  @DisplayName(
      "Test execute(Output, Context) with 'Output', 'Context'; when NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Store.execute(Output, Context)"})
  void testExecuteWithOutputContext_whenNamedOperation() throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    NamedOperation<Object, Object> operation = new NamedOperation<>();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> testAddToGraphLibraryImpl.execute(operation, new Context()));
  }

  /**
   * Test {@link Store#execute(Output, Context)} with {@code Output}, {@code Context}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Store#execute(Output, Context)}
   */
  @Test
  @DisplayName("Test execute(Output, Context) with 'Output', 'Context'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Store.execute(Output, Context)"})
  void testExecuteWithOutputContext_whenNull() throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> testAddToGraphLibraryImpl.execute((Output<Object>) null, new Context()));
  }

  /**
   * Test {@link Store#executeJob(Job, Context)} with {@code job}, {@code context}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Store#executeJob(Job, Context)}
   */
  @Test
  @DisplayName(
      "Test executeJob(Job, Context) with 'job', 'context'; given AddNamedOperation (default constructor) Options is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetail Store.executeJob(Job, Context)"})
  void testExecuteJobWithJobContext_givenAddNamedOperationOptionsIsHashMap()
      throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    AddNamedOperation operation = new AddNamedOperation();
    operation.setOptions(new HashMap<>());

    Job job = new Job(new Repeat());
    job.setOperation(operation);

    // Act and Assert
    assertThrows(
        OperationException.class, () -> testAddToGraphLibraryImpl.executeJob(job, new Context()));
  }

  /**
   * Test {@link Store#executeJob(Job, Context)} with {@code job}, {@code context}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Store#executeJob(Job, Context)}
   */
  @Test
  @DisplayName(
      "Test executeJob(Job, Context) with 'job', 'context'; given AddNamedOperation (default constructor) Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetail Store.executeJob(Job, Context)"})
  void testExecuteJobWithJobContext_givenAddNamedOperationOptionsIsNull()
      throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    AddNamedOperation operation = new AddNamedOperation();
    operation.setOptions(null);

    Job job = new Job(new Repeat());
    job.setOperation(operation);

    // Act and Assert
    assertThrows(
        OperationException.class, () -> testAddToGraphLibraryImpl.executeJob(job, new Context()));
  }

  /**
   * Test {@link Store#executeJob(Job, Context)} with {@code job}, {@code context}.
   *
   * <ul>
   *   <li>Given wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Store#executeJob(Job, Context)}
   */
  @Test
  @DisplayName(
      "Test executeJob(Job, Context) with 'job', 'context'; given wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetail Store.executeJob(Job, Context)"})
  void testExecuteJobWithJobContext_givenWrapNamedOperation() throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    Job job = new Job(new Repeat());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    job.setOperation(operation);

    // Act and Assert
    assertThrows(
        OperationException.class, () -> testAddToGraphLibraryImpl.executeJob(job, new Context()));
  }

  /**
   * Test {@link Store#executeJob(Job, Context)} with {@code job}, {@code context}.
   *
   * <ul>
   *   <li>When {@link Job#Job()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Store#executeJob(Job, Context)}
   */
  @Test
  @DisplayName(
      "Test executeJob(Job, Context) with 'job', 'context'; when Job(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetail Store.executeJob(Job, Context)"})
  void testExecuteJobWithJobContext_whenJob_thenThrowIllegalArgumentException()
      throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Job job = new Job();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> testAddToGraphLibraryImpl.executeJob(job, new Context()));
  }

  /**
   * Test {@link Store#executeJob(OperationChain, Context, String)} with {@code operationChain},
   * {@code context}, {@code parentJobId}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Store#executeJob(OperationChain, Context, String)}
   */
  @Test
  @DisplayName(
      "Test executeJob(OperationChain, Context, String) with 'operationChain', 'context', 'parentJobId'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetail Store.executeJob(OperationChain, Context, String)"})
  void testExecuteJobWithOperationChainContextParentJobId_whenNull() throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> testAddToGraphLibraryImpl.executeJob(null, new Context(), "42"));
  }

  /**
   * Test {@link Store#executeJob(OperationChain, Context, String)} with {@code operationChain},
   * {@code context}, {@code parentJobId}.
   *
   * <ul>
   *   <li>When wrap {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Store#executeJob(OperationChain, Context, String)}
   */
  @Test
  @DisplayName(
      "Test executeJob(OperationChain, Context, String) with 'operationChain', 'context', 'parentJobId'; when wrap 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetail Store.executeJob(OperationChain, Context, String)"})
  void testExecuteJobWithOperationChainContextParentJobId_whenWrapNull() throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    OperationChain<?> operationChain = OperationChain.wrap(null);

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> testAddToGraphLibraryImpl.executeJob(operationChain, new Context(), "42"));
  }

  /**
   * Test {@link Store#executeJob(OperationChain, Context, String)} with {@code operationChain},
   * {@code context}, {@code parentJobId}.
   *
   * <ul>
   *   <li>When wrap wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Store#executeJob(OperationChain, Context, String)}
   */
  @Test
  @DisplayName(
      "Test executeJob(OperationChain, Context, String) with 'operationChain', 'context', 'parentJobId'; when wrap wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetail Store.executeJob(OperationChain, Context, String)"})
  void testExecuteJobWithOperationChainContextParentJobId_whenWrapWrapNamedOperation()
      throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    OperationChain<?> operationChain = OperationChain.wrap(operation);

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> testAddToGraphLibraryImpl.executeJob(operationChain, new Context(), "42"));
  }

  /**
   * Test {@link Store#executeJob(OperationChain, Context)} with {@code operationChain}, {@code
   * context}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Store#executeJob(OperationChain, Context)}
   */
  @Test
  @DisplayName(
      "Test executeJob(OperationChain, Context) with 'operationChain', 'context'; when 'null'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetail Store.executeJob(OperationChain, Context)"})
  void testExecuteJobWithOperationChainContext_whenNull_thenThrowOperationException()
      throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> testAddToGraphLibraryImpl.executeJob((OperationChain<?>) null, new Context()));
  }

  /**
   * Test {@link Store#executeJob(OperationChain, Context)} with {@code operationChain}, {@code
   * context}.
   *
   * <ul>
   *   <li>When wrap {@code null}.
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Store#executeJob(OperationChain, Context)}
   */
  @Test
  @DisplayName(
      "Test executeJob(OperationChain, Context) with 'operationChain', 'context'; when wrap 'null'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetail Store.executeJob(OperationChain, Context)"})
  void testExecuteJobWithOperationChainContext_whenWrapNull_thenThrowOperationException()
      throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    OperationChain<?> operationChain = OperationChain.wrap(null);

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> testAddToGraphLibraryImpl.executeJob(operationChain, new Context()));
  }

  /**
   * Test {@link Store#executeJob(OperationChain, Context)} with {@code operationChain}, {@code
   * context}.
   *
   * <ul>
   *   <li>When wrap wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Store#executeJob(OperationChain, Context)}
   */
  @Test
  @DisplayName(
      "Test executeJob(OperationChain, Context) with 'operationChain', 'context'; when wrap wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetail Store.executeJob(OperationChain, Context)"})
  void testExecuteJobWithOperationChainContext_whenWrapWrapNamedOperation()
      throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    OperationChain<?> operationChain = OperationChain.wrap(operation);

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> testAddToGraphLibraryImpl.executeJob(operationChain, new Context()));
  }

  /**
   * Test {@link Store#executeJob(Operation, Context)} with {@code operation}, {@code context}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Store#executeJob(Operation, Context)}
   */
  @Test
  @DisplayName("Test executeJob(Operation, Context) with 'operation', 'context'; given HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetail Store.executeJob(Operation, Context)"})
  void testExecuteJobWithOperationContext_givenHashMap() throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    AddNamedOperation operation = new AddNamedOperation();
    operation.setOptions(new HashMap<>());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> testAddToGraphLibraryImpl.executeJob(operation, new Context()));
  }

  /**
   * Test {@link Store#executeJob(Operation, Context)} with {@code operation}, {@code context}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AddNamedOperation} (default constructor) Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Store#executeJob(Operation, Context)}
   */
  @Test
  @DisplayName(
      "Test executeJob(Operation, Context) with 'operation', 'context'; given 'null'; when AddNamedOperation (default constructor) Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetail Store.executeJob(Operation, Context)"})
  void testExecuteJobWithOperationContext_givenNull_whenAddNamedOperationOptionsIsNull()
      throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    AddNamedOperation operation = new AddNamedOperation();
    operation.setOptions(null);

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> testAddToGraphLibraryImpl.executeJob(operation, new Context()));
  }

  /**
   * Test {@link Store#executeJob(Operation, Context)} with {@code operation}, {@code context}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Store#executeJob(Operation, Context)}
   */
  @Test
  @DisplayName(
      "Test executeJob(Operation, Context) with 'operation', 'context'; when 'null'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobDetail Store.executeJob(Operation, Context)"})
  void testExecuteJobWithOperationContext_whenNull_thenThrowOperationException()
      throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> testAddToGraphLibraryImpl.executeJob((Operation) null, new Context()));
  }

  /**
   * Test {@link Store#getExecutorService()}.
   *
   * <p>Method under test: {@link Store#getExecutorService()}
   */
  @Test
  @DisplayName("Test getExecutorService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.concurrent.ScheduledExecutorService Store.getExecutorService()"})
  void testGetExecutorService() {
    // Arrange, Act and Assert
    assertNull(new TestAddToGraphLibraryImpl().getExecutorService());
  }

  /**
   * Test {@link Store#getJobTracker()}.
   *
   * <p>Method under test: {@link Store#getJobTracker()}
   */
  @Test
  @DisplayName("Test getJobTracker()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JobTracker Store.getJobTracker()"})
  void testGetJobTracker() {
    // Arrange, Act and Assert
    assertNull(new TestAddToGraphLibraryImpl().getJobTracker());
  }

  /**
   * Test {@link Store#isSupported(Class)}.
   *
   * <ul>
   *   <li>Given {@link TestAddToGraphLibraryImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Store#isSupported(Class)}
   */
  @Test
  @DisplayName(
      "Test isSupported(Class); given TestAddToGraphLibraryImpl (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Store.isSupported(Class)"})
  void testIsSupported_givenTestAddToGraphLibraryImpl_thenReturnFalse() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<Operation> operationClass = Operation.class;

    // Act and Assert
    assertFalse(testAddToGraphLibraryImpl.isSupported(operationClass));
  }

  /**
   * Test {@link Store#isSupported(Class)}.
   *
   * <ul>
   *   <li>Given {@code Operation}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Store#isSupported(Class)}
   */
  @Test
  @DisplayName(
      "Test isSupported(Class); given 'uk.gov.gchq.gaffer.operation.Operation'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Store.isSupported(Class)"})
  void testIsSupported_givenUkGovGchqGafferOperationOperation_thenReturnTrue() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<Operation> opClass = Operation.class;
    testAddToGraphLibraryImpl.addOperationHandler(opClass, mock(OperationHandler.class));
    Class<Operation> operationClass = Operation.class;

    // Act and Assert
    assertTrue(testAddToGraphLibraryImpl.isSupported(operationClass));
  }

  /**
   * Test {@link Store#getSupportedOperations()}.
   *
   * <p>Method under test: {@link Store#getSupportedOperations()}
   */
  @Test
  @DisplayName("Test getSupportedOperations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Store.getSupportedOperations()"})
  void testGetSupportedOperations() {
    // Arrange, Act and Assert
    assertTrue(new TestAddToGraphLibraryImpl().getSupportedOperations().isEmpty());
  }

  /**
   * Test {@link Store#getNextOperations(Class)}.
   *
   * <p>Method under test: {@link Store#getNextOperations(Class)}
   */
  @Test
  @DisplayName("Test getNextOperations(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Store.getNextOperations(Class)"})
  void testGetNextOperations() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    testAddToGraphLibraryImpl.addOperationChainOptimisers(new ArrayList<>());
    Class<GetAllNamedOperations> operation = GetAllNamedOperations.class;

    // Act and Assert
    assertTrue(testAddToGraphLibraryImpl.getNextOperations(operation).isEmpty());
  }

  /**
   * Test {@link Store#getNextOperations(Class)}.
   *
   * <ul>
   *   <li>Given {@link TestAddToGraphLibraryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Store#getNextOperations(Class)}
   */
  @Test
  @DisplayName(
      "Test getNextOperations(Class); given TestAddToGraphLibraryImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Store.getNextOperations(Class)"})
  void testGetNextOperations_givenTestAddToGraphLibraryImpl() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<GetAllNamedOperations> operation = GetAllNamedOperations.class;

    // Act and Assert
    assertTrue(testAddToGraphLibraryImpl.getNextOperations(operation).isEmpty());
  }

  /**
   * Test {@link Store#getNextOperations(Class)}.
   *
   * <ul>
   *   <li>Given {@link TestAddToGraphLibraryImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Store#getNextOperations(Class)}
   */
  @Test
  @DisplayName(
      "Test getNextOperations(Class); given TestAddToGraphLibraryImpl (default constructor); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Store.getNextOperations(Class)"})
  void testGetNextOperations_givenTestAddToGraphLibraryImpl_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new TestAddToGraphLibraryImpl().getNextOperations(null).isEmpty());
  }

  /**
   * Test {@link Store#getNextOperations(Class)}.
   *
   * <ul>
   *   <li>Given {@code Operation}.
   * </ul>
   *
   * <p>Method under test: {@link Store#getNextOperations(Class)}
   */
  @Test
  @DisplayName("Test getNextOperations(Class); given 'uk.gov.gchq.gaffer.operation.Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Store.getNextOperations(Class)"})
  void testGetNextOperations_givenUkGovGchqGafferOperationOperation() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<Operation> opClass = Operation.class;
    testAddToGraphLibraryImpl.addOperationHandler(opClass, mock(OperationHandler.class));
    Class<GetAllNamedOperations> operation = GetAllNamedOperations.class;

    // Act and Assert
    assertTrue(testAddToGraphLibraryImpl.getNextOperations(operation).isEmpty());
  }

  /**
   * Test {@link Store#getNextOperations(Class)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Store#getNextOperations(Class)}
   */
  @Test
  @DisplayName("Test getNextOperations(Class); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Store.getNextOperations(Class)"})
  void testGetNextOperations_thenReturnSizeIsOne() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<NamedOperation> opClass = NamedOperation.class;
    testAddToGraphLibraryImpl.addOperationHandler(opClass, mock(OperationHandler.class));
    Class<GetAllNamedOperations> operation = GetAllNamedOperations.class;

    // Act and Assert
    assertEquals(1, testAddToGraphLibraryImpl.getNextOperations(operation).size());
  }

  /**
   * Test {@link Store#getNextOperations(Class)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Store#getNextOperations(Class)}
   */
  @Test
  @DisplayName("Test getNextOperations(Class); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Store.getNextOperations(Class)"})
  void testGetNextOperations_thenReturnSizeIsOne2() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<NamedOperation> opClass = NamedOperation.class;
    testAddToGraphLibraryImpl.addOperationHandler(opClass, mock(OperationHandler.class));
    Class<NamedOperation> operation = NamedOperation.class;

    // Act and Assert
    assertEquals(1, testAddToGraphLibraryImpl.getNextOperations(operation).size());
  }

  /**
   * Test {@link Store#getNextOperations(Class)}.
   *
   * <ul>
   *   <li>When {@code NamedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link Store#getNextOperations(Class)}
   */
  @Test
  @DisplayName(
      "Test getNextOperations(Class); when 'uk.gov.gchq.gaffer.named.operation.NamedOperation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Store.getNextOperations(Class)"})
  void testGetNextOperations_whenUkGovGchqGafferNamedOperationNamedOperation() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<NamedOperation> operation = NamedOperation.class;

    // Act and Assert
    assertTrue(testAddToGraphLibraryImpl.getNextOperations(operation).isEmpty());
  }

  /**
   * Test {@link Store#getNextOperations(Class)}.
   *
   * <ul>
   *   <li>When {@code Operation}.
   * </ul>
   *
   * <p>Method under test: {@link Store#getNextOperations(Class)}
   */
  @Test
  @DisplayName("Test getNextOperations(Class); when 'uk.gov.gchq.gaffer.operation.Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Store.getNextOperations(Class)"})
  void testGetNextOperations_whenUkGovGchqGafferOperationOperation() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<Operation> operation = Operation.class;

    // Act and Assert
    assertTrue(testAddToGraphLibraryImpl.getNextOperations(operation).isEmpty());
  }

  /**
   * Test {@link Store#getGraphId()}.
   *
   * <p>Method under test: {@link Store#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Store.getGraphId()"})
  void testGetGraphId() {
    // Arrange, Act and Assert
    assertNull(new TestAddToGraphLibraryImpl().getGraphId());
  }

  /**
   * Test {@link Store#getSchema()}.
   *
   * <p>Method under test: {@link Store#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema Store.getSchema()"})
  void testGetSchema() {
    // Arrange, Act and Assert
    assertNull(new TestAddToGraphLibraryImpl().getSchema());
  }

  /**
   * Test {@link Store#setOriginalSchema(Schema)}.
   *
   * <p>Method under test: {@link Store#setOriginalSchema(Schema)}
   */
  @Test
  @DisplayName("Test setOriginalSchema(Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.setOriginalSchema(Schema)"})
  void testSetOriginalSchema() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Schema originalSchema = new Schema();

    // Act
    testAddToGraphLibraryImpl.setOriginalSchema(originalSchema);

    // Assert
    assertSame(originalSchema, testAddToGraphLibraryImpl.getOriginalSchema());
  }

  /**
   * Test {@link Store#getOriginalSchema()}.
   *
   * <p>Method under test: {@link Store#getOriginalSchema()}
   */
  @Test
  @DisplayName("Test getOriginalSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema Store.getOriginalSchema()"})
  void testGetOriginalSchema() {
    // Arrange, Act and Assert
    assertNull(new TestAddToGraphLibraryImpl().getOriginalSchema());
  }

  /**
   * Test {@link Store#getProperties()}.
   *
   * <p>Method under test: {@link Store#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StoreProperties Store.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertNull(new TestAddToGraphLibraryImpl().getProperties());
  }

  /**
   * Test {@link Store#getGraphLibrary()}.
   *
   * <p>Method under test: {@link Store#getGraphLibrary()}
   */
  @Test
  @DisplayName("Test getGraphLibrary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphLibrary Store.getGraphLibrary()"})
  void testGetGraphLibrary() {
    // Arrange, Act and Assert
    assertNull(new TestAddToGraphLibraryImpl().getGraphLibrary());
  }

  /**
   * Test {@link Store#setGraphLibrary(GraphLibrary)}.
   *
   * <p>Method under test: {@link Store#setGraphLibrary(GraphLibrary)}
   */
  @Test
  @DisplayName("Test setGraphLibrary(GraphLibrary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.setGraphLibrary(GraphLibrary)"})
  void testSetGraphLibrary() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    FileGraphLibrary library = new FileGraphLibrary();

    // Act
    testAddToGraphLibraryImpl.setGraphLibrary(library);

    // Assert
    assertSame(library, testAddToGraphLibraryImpl.getGraphLibrary());
  }

  /**
   * Test {@link Store#optimiseSchema()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Store#optimiseSchema()}
   */
  @Test
  @DisplayName("Test optimiseSchema(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.optimiseSchema()"})
  void testOptimiseSchema_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new TestAddToGraphLibraryImpl().optimiseSchema());
  }

  /**
   * Test {@link Store#validateSchemas()}.
   *
   * <p>Method under test: {@link Store#validateSchemas()}
   */
  @Test
  @DisplayName("Test validateSchemas()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.validateSchemas()"})
  void testValidateSchemas() {
    // Arrange, Act and Assert
    assertThrows(SchemaException.class, () -> new TestAddToGraphLibraryImpl().validateSchemas());
  }

  /**
   * Test {@link Store#createContext(User)}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   *   <li>Then return OriginalOpChain is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Store#createContext(User)}
   */
  @Test
  @DisplayName("Test createContext(User); when User(); then return OriginalOpChain is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Context Store.createContext(User)"})
  void testCreateContext_whenUser_thenReturnOriginalOpChainIsNull() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    User user = new User();

    // Act
    Context actualCreateContextResult = testAddToGraphLibraryImpl.createContext(user);

    // Assert
    assertNull(actualCreateContextResult.getOriginalOpChain());
    assertTrue(actualCreateContextResult.getExporters().isEmpty());
    assertTrue(actualCreateContextResult.getVariables().isEmpty());
    assertSame(user, actualCreateContextResult.getUser());
  }

  /**
   * Test {@link Store#getPropertiesClass()}.
   *
   * <p>Method under test: {@link Store#getPropertiesClass()}
   */
  @Test
  @DisplayName("Test getPropertiesClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class Store.getPropertiesClass()"})
  void testGetPropertiesClass() {
    // Arrange and Act
    Class<? extends StoreProperties> actualPropertiesClass =
        new TestAddToGraphLibraryImpl().getPropertiesClass();

    // Assert
    Class<StoreProperties> expectedPropertiesClass = StoreProperties.class;
    assertEquals(expectedPropertiesClass, actualPropertiesClass);
  }

  /**
   * Test {@link Store#validateConsistentGroupByProperties(Entry, ValidationResult)}.
   *
   * <p>Method under test: {@link Store#validateConsistentGroupByProperties(Entry,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateConsistentGroupByProperties(Entry, ValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.validateConsistentGroupByProperties(Entry, ValidationResult)"})
  void testValidateConsistentGroupByProperties() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Group By");

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any()))
        .thenReturn(new Builder().aggregateFunction(mock(BinaryOperator.class)).build());
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    // Act
    testAddToGraphLibraryImpl.validateConsistentGroupByProperties(
        schemaElementDefinitionEntry, OperationUtil.isValid(output, input));

    // Assert
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getPropertyTypeDef("Group By");
  }

  /**
   * Test {@link Store#validateConsistentGroupByProperties(Entry, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Store#validateConsistentGroupByProperties(Entry,
   * ValidationResult)}
   */
  @Test
  @DisplayName("Test validateConsistentGroupByProperties(Entry, ValidationResult); given HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.validateConsistentGroupByProperties(Entry, ValidationResult)"})
  void testValidateConsistentGroupByProperties_givenHashSet() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(new HashSet<>());
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    // Act
    testAddToGraphLibraryImpl.validateConsistentGroupByProperties(
        schemaElementDefinitionEntry, OperationUtil.isValid(output, input));

    // Assert
    verify(schemaEdgeDefinition).getGroupBy();
  }

  /**
   * Test {@link Store#validateConsistentGroupByProperties(Entry, ValidationResult)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Store#validateConsistentGroupByProperties(Entry,
   * ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateConsistentGroupByProperties(Entry, ValidationResult); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.validateConsistentGroupByProperties(Entry, ValidationResult)"})
  void testValidateConsistentGroupByProperties_thenThrowIllegalArgumentException() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    LinkedHashSet<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Group By");

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    when(schemaEdgeDefinition.getGroupBy()).thenReturn(stringSet);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            testAddToGraphLibraryImpl.validateConsistentGroupByProperties(
                schemaElementDefinitionEntry, OperationUtil.isValid(output, input)));
    verify(schemaEdgeDefinition).getGroupBy();
    verify(schemaEdgeDefinition).getPropertyTypeDef("Group By");
  }

  /**
   * Test {@link Store#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <p>Method under test: {@link Store#validateSchemaElementDefinition(Entry, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", new SchemaEdgeDefinition());
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult validationResult = OperationUtil.isValid(output, input);

    // Act
    testAddToGraphLibraryImpl.validateSchemaElementDefinition(
        schemaElementDefinitionEntry, validationResult);

    // Assert that nothing has changed
    assertEquals("Validation errors: \n", validationResult.getErrorString());
    assertTrue(validationResult.getErrors().isEmpty());
    assertTrue(validationResult.isValid());
  }

  /**
   * Test {@link Store#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <p>Method under test: {@link Store#validateSchemaElementDefinition(Entry, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition2() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any()))
        .thenReturn(new Builder().aggregateFunction(mock(BinaryOperator.class)).build());
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult validationResult = OperationUtil.isValid(output, input);

    // Act
    testAddToGraphLibraryImpl.validateSchemaElementDefinition(
        schemaElementDefinitionEntry, validationResult);

    // Assert
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyClass("foo");
    verify(schemaEdgeDefinition).getPropertyTypeDef("foo");
    assertEquals(
        "Validation errors: \nCould not find a serialiser for property 'foo' in the group 'foo'.",
        validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(validationResult.isValid());
    assertTrue(
        errors.contains("Could not find a serialiser for property 'foo' in the group 'foo'."));
  }

  /**
   * Test {@link Store#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Store#validateSchemaElementDefinition(Entry, ValidationResult)}
   */
  @Test
  @DisplayName("Test validateSchemaElementDefinition(Entry, ValidationResult); given HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition_givenHashSet() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getProperties()).thenReturn(new HashSet<>());
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult validationResult = OperationUtil.isValid(output, input);

    // Act
    testAddToGraphLibraryImpl.validateSchemaElementDefinition(
        schemaElementDefinitionEntry, validationResult);

    // Assert that nothing has changed
    verify(schemaEdgeDefinition).getProperties();
    assertEquals("Validation errors: \n", validationResult.getErrorString());
    assertTrue(validationResult.getErrors().isEmpty());
    assertTrue(validationResult.isValid());
  }

  /**
   * Test {@link Store#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Store#validateSchemaElementDefinition(Entry, ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateSchemaElementDefinition(Entry, ValidationResult); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition_thenThrowIllegalArgumentException() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            testAddToGraphLibraryImpl.validateSchemaElementDefinition(
                schemaElementDefinitionEntry, OperationUtil.isValid(output, input)));
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition).getPropertyClass("foo");
  }

  /**
   * Test {@link Store#validateSchemaElementDefinition(Entry, ValidationResult)}.
   *
   * <ul>
   *   <li>Then Valid {@link Object} is {@link Object} ErrorString is a string.
   * </ul>
   *
   * <p>Method under test: {@link Store#validateSchemaElementDefinition(Entry, ValidationResult)}
   */
  @Test
  @DisplayName(
      "Test validateSchemaElementDefinition(Entry, ValidationResult); then Valid Object is Object ErrorString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.validateSchemaElementDefinition(Entry, ValidationResult)"})
  void testValidateSchemaElementDefinition_thenValidObjectIsObjectErrorStringIsAString() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("42");
    stringSet.add("foo");
    stringSet.add("foo");

    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(schemaEdgeDefinition.getPropertyClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(schemaEdgeDefinition.getPropertyTypeDef(Mockito.<String>any()))
        .thenReturn(new Builder().aggregateFunction(mock(BinaryOperator.class)).build());
    when(schemaEdgeDefinition.getProperties()).thenReturn(stringSet);
    SimpleEntry<String, SchemaElementDefinition> schemaElementDefinitionEntry =
        new SimpleEntry<>("foo", schemaEdgeDefinition);
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult validationResult = OperationUtil.isValid(output, input);

    // Act
    testAddToGraphLibraryImpl.validateSchemaElementDefinition(
        schemaElementDefinitionEntry, validationResult);

    // Assert
    verify(schemaEdgeDefinition).getProperties();
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyClass(Mockito.<String>any());
    verify(schemaEdgeDefinition, atLeast(1)).getPropertyTypeDef(Mockito.<String>any());
    assertEquals(
        "Validation errors: \n"
            + "Could not find a serialiser for property 'foo' in the group 'foo'.\n"
            + "Could not find a serialiser for property '42' in the group 'foo'.",
        validationResult.getErrorString());
    Set<String> errors = validationResult.getErrors();
    assertEquals(2, errors.size());
    assertFalse(validationResult.isValid());
    assertTrue(
        errors.contains("Could not find a serialiser for property '42' in the group 'foo'."));
    assertTrue(
        errors.contains("Could not find a serialiser for property 'foo' in the group 'foo'."));
  }

  /**
   * Test {@link Store#validateSchema(ValidationResult, Serialiser)}.
   *
   * <ul>
   *   <li>When {@link AvroSerialiser} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Store#validateSchema(ValidationResult, Serialiser)}
   */
  @Test
  @DisplayName(
      "Test validateSchema(ValidationResult, Serialiser); when AvroSerialiser (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.validateSchema(ValidationResult, Serialiser)"})
  void testValidateSchema_whenAvroSerialiser() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult validationResult = OperationUtil.isValid(output, input);

    // Act
    testAddToGraphLibraryImpl.validateSchema(validationResult, new AvroSerialiser());

    // Assert that nothing has changed
    assertEquals("Validation errors: \n", validationResult.getErrorString());
    assertTrue(validationResult.getErrors().isEmpty());
    assertTrue(validationResult.isValid());
  }

  /**
   * Test {@link Store#validateSchema(ValidationResult, Serialiser)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then Valid {@link Object} is {@link Object} ErrorString is {@code Validation errors:}.
   * </ul>
   *
   * <p>Method under test: {@link Store#validateSchema(ValidationResult, Serialiser)}
   */
  @Test
  @DisplayName(
      "Test validateSchema(ValidationResult, Serialiser); when 'null'; then Valid Object is Object ErrorString is 'Validation errors:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.validateSchema(ValidationResult, Serialiser)"})
  void testValidateSchema_whenNull_thenValidObjectIsObjectErrorStringIsValidationErrors() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<Object> output = Object.class;
    Class<Object> input = Object.class;

    ValidationResult validationResult = OperationUtil.isValid(output, input);

    // Act
    testAddToGraphLibraryImpl.validateSchema(validationResult, null);

    // Assert that nothing has changed
    assertEquals("Validation errors: \n", validationResult.getErrorString());
    assertTrue(validationResult.getErrors().isEmpty());
    assertTrue(validationResult.isValid());
  }

  /**
   * Test {@link Store#createSchemaOptimiser()}.
   *
   * <p>Method under test: {@link Store#createSchemaOptimiser()}
   */
  @Test
  @DisplayName("Test createSchemaOptimiser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaOptimiser Store.createSchemaOptimiser()"})
  void testCreateSchemaOptimiser() {
    // Arrange, Act and Assert
    assertNull(new TestAddToGraphLibraryImpl().createSchemaOptimiser().optimise(null, true));
  }

  /**
   * Test {@link Store#getOperationChainValidator()}.
   *
   * <p>Method under test: {@link Store#getOperationChainValidator()}
   */
  @Test
  @DisplayName("Test getOperationChainValidator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationChainValidator Store.getOperationChainValidator()"})
  void testGetOperationChainValidator() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    // Act
    OperationChainValidator actualOperationChainValidator =
        testAddToGraphLibraryImpl.getOperationChainValidator();

    // Assert
    assertSame(testAddToGraphLibraryImpl.opChainValidator, actualOperationChainValidator);
  }

  /**
   * Test {@link Store#addOperationChainOptimisers(List)}.
   *
   * <p>Method under test: {@link Store#addOperationChainOptimisers(List)}
   */
  @Test
  @DisplayName("Test addOperationChainOptimisers(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.addOperationChainOptimisers(List)"})
  void testAddOperationChainOptimisers() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    ArrayList<OperationChainOptimiser> newOpChainOptimisers = new ArrayList<>();
    newOpChainOptimisers.add(mock(OperationChainOptimiser.class));
    newOpChainOptimisers.add(mock(OperationChainOptimiser.class));

    // Act
    testAddToGraphLibraryImpl.addOperationChainOptimisers(newOpChainOptimisers);

    // Assert
    assertEquals(2, testAddToGraphLibraryImpl.getOperationChainOptimisers().size());
    assertEquals(2, testAddToGraphLibraryImpl.opChainOptimisers.size());
  }

  /**
   * Test {@link Store#addOperationChainOptimisers(List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Store#addOperationChainOptimisers(List)}
   */
  @Test
  @DisplayName("Test addOperationChainOptimisers(List); then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.addOperationChainOptimisers(List)"})
  void testAddOperationChainOptimisers_thenArrayListSizeIsOne() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    ArrayList<OperationChainOptimiser> newOpChainOptimisers = new ArrayList<>();
    newOpChainOptimisers.add(mock(OperationChainOptimiser.class));

    // Act
    testAddToGraphLibraryImpl.addOperationChainOptimisers(newOpChainOptimisers);

    // Assert
    assertEquals(1, newOpChainOptimisers.size());
    List<OperationChainOptimiser> operationChainOptimisers =
        testAddToGraphLibraryImpl.getOperationChainOptimisers();
    assertEquals(1, operationChainOptimisers.size());
    List<OperationChainOptimiser> operationChainOptimiserList =
        testAddToGraphLibraryImpl.opChainOptimisers;
    assertEquals(1, operationChainOptimiserList.size());
    OperationChainOptimiser getResult = newOpChainOptimisers.get(0);
    assertSame(getResult, operationChainOptimisers.get(0));
    assertSame(getResult, operationChainOptimiserList.get(0));
  }

  /**
   * Test {@link Store#addOperationChainOptimisers(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Store#addOperationChainOptimisers(List)}
   */
  @Test
  @DisplayName("Test addOperationChainOptimisers(List); when ArrayList(); then ArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.addOperationChainOptimisers(List)"})
  void testAddOperationChainOptimisers_whenArrayList_thenArrayListEmpty() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    ArrayList<OperationChainOptimiser> newOpChainOptimisers = new ArrayList<>();

    // Act
    testAddToGraphLibraryImpl.addOperationChainOptimisers(newOpChainOptimisers);

    // Assert that nothing has changed
    assertTrue(newOpChainOptimisers.isEmpty());
    assertTrue(testAddToGraphLibraryImpl.getOperationChainOptimisers().isEmpty());
    assertTrue(testAddToGraphLibraryImpl.opChainOptimisers.isEmpty());
  }

  /**
   * Test {@link Store#getOperationChainOptimisers()}.
   *
   * <p>Method under test: {@link Store#getOperationChainOptimisers()}
   */
  @Test
  @DisplayName("Test getOperationChainOptimisers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Store.getOperationChainOptimisers()"})
  void testGetOperationChainOptimisers() {
    // Arrange, Act and Assert
    assertTrue(new TestAddToGraphLibraryImpl().getOperationChainOptimisers().isEmpty());
  }

  /**
   * Test {@link Store#getOperationChainHandler()}.
   *
   * <ul>
   *   <li>Then return {@link OperationChainHandler}.
   * </ul>
   *
   * <p>Method under test: {@link Store#getOperationChainHandler()}
   */
  @Test
  @DisplayName("Test getOperationChainHandler(); then return OperationChainHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationHandler Store.getOperationChainHandler()"})
  void testGetOperationChainHandler_thenReturnOperationChainHandler() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    // Act and Assert
    assertTrue(
        testAddToGraphLibraryImpl.getOperationChainHandler() instanceof OperationChainHandler);
    assertNull(testAddToGraphLibraryImpl.getGraphId());
    assertNull(testAddToGraphLibraryImpl.getExecutorService());
    assertNull(testAddToGraphLibraryImpl.getJobTracker());
    assertNull(testAddToGraphLibraryImpl.getProperties());
    assertNull(testAddToGraphLibraryImpl.getGraphLibrary());
    assertNull(testAddToGraphLibraryImpl.getOriginalSchema());
    assertNull(testAddToGraphLibraryImpl.getSchema());
    assertTrue(testAddToGraphLibraryImpl.getOperationChainOptimisers().isEmpty());
    assertTrue(testAddToGraphLibraryImpl.opChainOptimisers.isEmpty());
    assertTrue(testAddToGraphLibraryImpl.getSupportedOperations().isEmpty());
    Class<StoreProperties> expectedPropertiesClass = StoreProperties.class;
    assertEquals(expectedPropertiesClass, testAddToGraphLibraryImpl.getPropertiesClass());
  }

  /**
   * Test {@link Store#doUnhandledOperation(Operation, Context)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Store#doUnhandledOperation(Operation, Context)}
   */
  @Test
  @DisplayName(
      "Test doUnhandledOperation(Operation, Context); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Store.doUnhandledOperation(Operation, Context)"})
  void testDoUnhandledOperation_thenThrowUnsupportedOperationException() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> testAddToGraphLibraryImpl.doUnhandledOperation(operation, new Context()));
  }

  /**
   * Test {@link Store#addOperationHandler(Class, OperationHandler)} with {@code Class}, {@code
   * OperationHandler}.
   *
   * <p>Method under test: {@link Store#addOperationHandler(Class, OperationHandler)}
   */
  @Test
  @DisplayName("Test addOperationHandler(Class, OperationHandler) with 'Class', 'OperationHandler'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.addOperationHandler(Class, OperationHandler)"})
  void testAddOperationHandlerWithClassOperationHandler() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<Operation> opClass = Operation.class;

    // Act
    testAddToGraphLibraryImpl.addOperationHandler(opClass, mock(OperationHandler.class));

    // Assert
    assertEquals(1, testAddToGraphLibraryImpl.getSupportedOperations().size());
  }

  /**
   * Test {@link Store#addOperationHandler(Class, OperationHandler)} with {@code Class}, {@code
   * OperationHandler}.
   *
   * <p>Method under test: {@link Store#addOperationHandler(Class, OperationHandler)}
   */
  @Test
  @DisplayName("Test addOperationHandler(Class, OperationHandler) with 'Class', 'OperationHandler'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.addOperationHandler(Class, OperationHandler)"})
  void testAddOperationHandlerWithClassOperationHandler2() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<Operation> opClass = Operation.class;

    // Act
    testAddToGraphLibraryImpl.addOperationHandler(opClass, null);

    // Assert that nothing has changed
    assertTrue(testAddToGraphLibraryImpl.getSupportedOperations().isEmpty());
  }

  /**
   * Test {@link Store#addOperationHandler(Class, OutputOperationHandler)} with {@code Class},
   * {@code OutputOperationHandler}.
   *
   * <p>Method under test: {@link Store#addOperationHandler(Class, OutputOperationHandler)}
   */
  @Test
  @DisplayName(
      "Test addOperationHandler(Class, OutputOperationHandler) with 'Class', 'OutputOperationHandler'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.addOperationHandler(Class, OutputOperationHandler)"})
  void testAddOperationHandlerWithClassOutputOperationHandler() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<Output> forNameResult = Output.class;

    // Act
    testAddToGraphLibraryImpl.addOperationHandler(
        (Class<Output<Object>>) (Class) forNameResult, mock(OutputOperationHandler.class));

    // Assert
    assertEquals(1, testAddToGraphLibraryImpl.getSupportedOperations().size());
  }

  /**
   * Test {@link Store#getOperationHandler(Class)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Store#getOperationHandler(Class)}
   */
  @Test
  @DisplayName("Test getOperationHandler(Class); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OperationHandler Store.getOperationHandler(Class)"})
  void testGetOperationHandler_thenReturnNull() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    Class<Operation> opClass = Operation.class;

    // Act and Assert
    assertNull(testAddToGraphLibraryImpl.getOperationHandler(opClass));
  }

  /**
   * Test {@link Store#handleOperation(Operation, Context)}.
   *
   * <ul>
   *   <li>When wrap {@link GetVariable} (default constructor).
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link Store#handleOperation(Operation, Context)}
   */
  @Test
  @DisplayName(
      "Test handleOperation(Operation, Context); when wrap GetVariable (default constructor); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Store.handleOperation(Operation, Context)"})
  void testHandleOperation_whenWrapGetVariable_thenThrowUnsupportedOperationException()
      throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    OperationChain<Object> operation = OperationChain.wrap(new GetVariable());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> testAddToGraphLibraryImpl.handleOperation(operation, new Context()));
  }

  /**
   * Test {@link Store#handleOperation(Operation, Context)}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Store#handleOperation(Operation, Context)}
   */
  @Test
  @DisplayName(
      "Test handleOperation(Operation, Context); when wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Store.handleOperation(Operation, Context)"})
  void testHandleOperation_whenWrapNamedOperation() throws OperationException {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> testAddToGraphLibraryImpl.handleOperation(operation, new Context()));
  }

  /**
   * Test {@link Store#startCacheServiceLoader(StoreProperties)}.
   *
   * <p>Method under test: {@link Store#startCacheServiceLoader(StoreProperties)}
   */
  @Test
  @DisplayName("Test startCacheServiceLoader(StoreProperties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Store.startCacheServiceLoader(StoreProperties)"})
  void testStartCacheServiceLoader() {
    // Arrange
    TestAddToGraphLibraryImpl testAddToGraphLibraryImpl = new TestAddToGraphLibraryImpl();

    StoreProperties properties = mock(StoreProperties.class);
    when(properties.getJobTrackerEnabled()).thenReturn(false);
    when(properties.getNamedOperationEnabled()).thenReturn(false);
    when(properties.getNamedViewEnabled()).thenReturn(false);
    when(properties.getDefaultCacheServiceClass()).thenReturn(null);
    when(properties.getJobTrackerCacheServiceClass()).thenReturn(null);
    when(properties.getNamedOperationCacheServiceClass()).thenReturn(null);
    when(properties.getNamedViewCacheServiceClass()).thenReturn(null);

    // Act
    testAddToGraphLibraryImpl.startCacheServiceLoader(properties);

    // Assert
    verify(properties).getDefaultCacheServiceClass();
    verify(properties).getJobTrackerCacheServiceClass();
    verify(properties).getJobTrackerEnabled();
    verify(properties).getNamedOperationCacheServiceClass();
    verify(properties).getNamedOperationEnabled();
    verify(properties).getNamedViewCacheServiceClass();
    verify(properties).getNamedViewEnabled();
  }
}
