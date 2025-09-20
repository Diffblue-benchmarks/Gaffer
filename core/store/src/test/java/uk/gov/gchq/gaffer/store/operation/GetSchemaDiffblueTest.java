package uk.gov.gchq.gaffer.store.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl;
import uk.gov.gchq.gaffer.store.operation.GetSchema.Builder;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GetSchemaDiffblueTest {
  /**
   * Test Builder {@link Builder#compact(boolean)}.
   *
   * <p>Method under test: {@link Builder#compact(boolean)}
   */
  @Test
  @DisplayName("Test Builder compact(boolean)")
  @Tag("MaintainedByDiffblue")
  void testBuilderCompact() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualCompactResult = builder.compact(true);

    // Assert
    assertSame(builder, actualCompactResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    GetSchema _getOpResult = actualBuilder._getOp();
    TypeReference<Schema> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceStoreImpl.Schema);
    assertNull(_getOpResult.getOptions());
    assertFalse(_getOpResult.isCompact());
    Class<Schema> expectedOutputClass = Schema.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    GetSchema actualGetSchema = actualBuilder.build();
    assertSame(_getOpResult, actualGetSchema);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test {@link GetSchema#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetSchema} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetSchema#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetSchema (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetSchemaOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    GetSchema getSchema = new GetSchema();
    getSchema.setOptions(new HashMap<>());

    // Act
    GetSchema actualShallowCloneResult = getSchema.shallowClone();

    // Assert
    TypeReference<Schema> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceStoreImpl.Schema);
    assertFalse(actualShallowCloneResult.isCompact());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Schema> expectedOutputClass = Schema.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link GetSchema#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetSchema} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetSchema#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetSchema (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetSchema_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    GetSchema actualShallowCloneResult = new GetSchema().shallowClone();

    // Assert
    TypeReference<Schema> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceStoreImpl.Schema);
    assertNull(actualShallowCloneResult.getOptions());
    assertFalse(actualShallowCloneResult.isCompact());
    Class<Schema> expectedOutputClass = Schema.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link GetSchema#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetSchema#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue(new GetSchema().getOutputTypeReference() instanceof TypeReferenceStoreImpl.Schema);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetSchema}
   *   <li>{@link GetSchema#setCompact(boolean)}
   *   <li>{@link GetSchema#setOptions(Map)}
   *   <li>{@link GetSchema#getOptions()}
   *   <li>{@link GetSchema#isCompact()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    GetSchema actualGetSchema = new GetSchema();
    actualGetSchema.setCompact(true);
    HashMap<String, String> options = new HashMap<>();
    actualGetSchema.setOptions(options);
    Map<String, String> actualOptions = actualGetSchema.getOptions();
    boolean actualIsCompactResult = actualGetSchema.isCompact();

    // Assert
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsCompactResult);
    assertSame(options, actualOptions);
  }
}
