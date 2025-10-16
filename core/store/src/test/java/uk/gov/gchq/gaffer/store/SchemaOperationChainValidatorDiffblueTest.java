package uk.gov.gchq.gaffer.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.ViewValidator;
import uk.gov.gchq.gaffer.user.User;

class SchemaOperationChainValidatorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then return {@link SchemaOperationChainValidator#schema} is {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SchemaOperationChainValidator#SchemaOperationChainValidator(ViewValidator,
   *       Schema)}
   *   <li>{@link SchemaOperationChainValidator#setSchema(Schema)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Schema(); then return schema is Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SchemaOperationChainValidator.<init>(ViewValidator)",
    "void SchemaOperationChainValidator.<init>(ViewValidator, Schema)",
    "void SchemaOperationChainValidator.setSchema(Schema)"
  })
  void testGettersAndSetters_whenSchema_thenReturnSchemaIsSchema() {
    // Arrange
    ViewValidator viewValidator = new ViewValidator();
    Schema schema = new Schema();

    // Act
    SchemaOperationChainValidator actualSchemaOperationChainValidator =
        new SchemaOperationChainValidator(viewValidator, schema);
    actualSchemaOperationChainValidator.setSchema(new Schema());

    // Assert
    assertEquals(schema, actualSchemaOperationChainValidator.schema);
  }

  /**
   * Test {@link SchemaOperationChainValidator#getSchema(Operation, User, Store)}.
   *
   * <p>Method under test: {@link SchemaOperationChainValidator#getSchema(Operation, User, Store)}
   */
  @Test
  @DisplayName("Test getSchema(Operation, User, Store)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema SchemaOperationChainValidator.getSchema(Operation, User, Store)"})
  void testGetSchema() {
    // Arrange
    SchemaOperationChainValidator schemaOperationChainValidator =
        new SchemaOperationChainValidator(new ViewValidator());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    User user = new User();

    // Act and Assert
    assertNull(
        schemaOperationChainValidator.getSchema(operation, user, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link SchemaOperationChainValidator#getStoreTraits(Store, Context)}.
   *
   * <p>Method under test: {@link SchemaOperationChainValidator#getStoreTraits(Store, Context)}
   */
  @Test
  @DisplayName("Test getStoreTraits(Store, Context)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SchemaOperationChainValidator.getStoreTraits(Store, Context)"})
  void testGetStoreTraits() {
    // Arrange
    SchemaOperationChainValidator schemaOperationChainValidator =
        new SchemaOperationChainValidator(new ViewValidator());
    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();

    // Act
    Set<StoreTrait> actualStoreTraits =
        schemaOperationChainValidator.getStoreTraits(store, new Context());

    // Assert
    assertEquals(10, actualStoreTraits.size());
    assertTrue(actualStoreTraits.contains(StoreTrait.INGEST_AGGREGATION));
    assertTrue(actualStoreTraits.contains(StoreTrait.MATCHED_VERTEX));
    assertTrue(actualStoreTraits.contains(StoreTrait.ORDERED));
    assertTrue(actualStoreTraits.contains(StoreTrait.POST_AGGREGATION_FILTERING));
    assertTrue(actualStoreTraits.contains(StoreTrait.POST_TRANSFORMATION_FILTERING));
    assertTrue(actualStoreTraits.contains(StoreTrait.PRE_AGGREGATION_FILTERING));
    assertTrue(actualStoreTraits.contains(StoreTrait.QUERY_AGGREGATION));
    assertTrue(actualStoreTraits.contains(StoreTrait.STORE_VALIDATION));
    assertTrue(actualStoreTraits.contains(StoreTrait.TRANSFORMATION));
    assertTrue(actualStoreTraits.contains(StoreTrait.VISIBILITY));
  }
}
