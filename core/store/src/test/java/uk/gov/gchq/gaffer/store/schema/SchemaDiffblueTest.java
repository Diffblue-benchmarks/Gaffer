package uk.gov.gchq.gaffer.store.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.store.schema.Schema.BaseBuilder;
import uk.gov.gchq.gaffer.store.schema.Schema.Builder;
import uk.gov.gchq.koryphe.ValidationResult;

class SchemaDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#config(Map)} with {@code config}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#config(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder config(Map) with 'config'; given Builder(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.config(Map)"})
  void testBaseBuilderConfigWithConfig_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConfigResult = builder.config(new HashMap<>());

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#config(String, String)} with {@code key}, {@code value}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#config(String, String)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder config(String, String) with 'key', 'value'; given Builder(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.config(String, String)"})
  void testBaseBuilderConfigWithKeyValue_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConfigResult = builder.config("Key", "42");

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Path[])} with {@code filePaths}.
   *
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(Path[])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(Path[]) with 'filePaths'; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Path[])"})
  void testBaseBuilderJsonWithFilePaths_thenReturnBuilder() throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    Builder actualJsonResult = builder.json(new Path[] {});

    // Assert
    assertSame(builder, actualJsonResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Path[])} with {@code filePaths}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(Path[])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder json(Path[]) with 'filePaths'; when Property is 'java.io.tmpdir' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Path[])"})
  void testBaseBuilderJsonWithFilePaths_whenPropertyIsJavaIoTmpdirIsEmptyString()
      throws SchemaException {
    // Arrange, Act and Assert
    assertThrows(
        SchemaException.class,
        () -> new Builder().json(Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Path[])} with {@code filePaths}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(Path[])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder json(Path[]) with 'filePaths'; when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Path[])"})
  void testBaseBuilderJsonWithFilePaths_whenPropertyIsJavaIoTmpdirIsTestTxt()
      throws SchemaException {
    // Arrange, Act and Assert
    assertThrows(
        SchemaException.class,
        () -> new Builder().json(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(InputStream[])} with {@code inputStreams}.
   *
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(InputStream[])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(InputStream[]) with 'inputStreams'; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(InputStream[])"})
  void testBaseBuilderJsonWithInputStreams_thenReturnBuilder() throws SchemaException {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualJsonResult = builder.json(new InputStream[] {});

    // Assert
    assertSame(builder, actualJsonResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(byte[][])} with {@code jsonBytes}.
   *
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(byte[][])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(byte[][]) with 'jsonBytes'; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(byte[][])"})
  void testBaseBuilderJsonWithJsonBytes_thenReturnBuilder() throws SchemaException {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualJsonResult = builder.json(new byte[][] {});

    // Assert
    assertSame(builder, actualJsonResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(Schema)} with {@code Schema}.
   *
   * <p>Method under test: {@link BaseBuilder#merge(Schema)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(Schema) with 'Schema'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(Schema)"})
  void testBaseBuilderMergeWithSchema() {
    // Arrange
    Builder builder = new Builder();

    TypeDefinition.Builder builder2 = new TypeDefinition.Builder();
    builder2.description("The characteristics of someone or something");
    TypeDefinition typeDefinition = builder2.aggregateFunction(mock(BinaryOperator.class)).build();

    HashMap<String, TypeDefinition> types = new HashMap<>();
    types.put("foo", typeDefinition);

    // Act and Assert
    assertThrows(SchemaException.class, () -> builder.merge(new Schema(types)));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(Schema)} with {@code Schema}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#merge(Schema)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder merge(Schema) with 'Schema'; given Builder(); when 'null'; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(Schema)"})
  void testBaseBuilderMergeWithSchema_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualMergeResult = builder.merge(null);

    // Assert
    assertSame(builder, actualMergeResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(Schema)} with {@code Schema}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then throw {@link SchemaException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#merge(Schema)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder merge(Schema) with 'Schema'; given 'foo'; then throw SchemaException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(Schema)"})
  void testBaseBuilderMergeWithSchema_givenFoo_thenThrowSchemaException() {
    // Arrange
    Builder builder = new Builder();

    HashMap<String, TypeDefinition> types = new HashMap<>();
    types.put(
        "foo", new TypeDefinition.Builder().aggregateFunction(mock(BinaryOperator.class)).build());

    // Act and Assert
    assertThrows(SchemaException.class, () -> builder.merge(new Schema(types)));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(Schema)} with {@code Schema}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then throw {@link SchemaException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#merge(Schema)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder merge(Schema) with 'Schema'; given 'java.lang.Object'; then throw SchemaException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(Schema)"})
  void testBaseBuilderMergeWithSchema_givenJavaLangObject_thenThrowSchemaException() {
    // Arrange
    Builder builder = new Builder();

    TypeDefinition.Builder builder2 = new TypeDefinition.Builder();
    Class<Object> clazz = Object.class;
    builder2.clazz(clazz);
    TypeDefinition typeDefinition = builder2.aggregateFunction(mock(BinaryOperator.class)).build();

    HashMap<String, TypeDefinition> types = new HashMap<>();
    types.put("foo", typeDefinition);

    // Act and Assert
    assertThrows(SchemaException.class, () -> builder.merge(new Schema(types)));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(Schema)} with {@code Schema}.
   *
   * <ul>
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#merge(Schema)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(Schema) with 'Schema'; then calls apply(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(Schema)"})
  void testBaseBuilderMergeWithSchema_thenCallsApply() {
    // Arrange
    Builder builder = new Builder();

    BiFunction<String, TypeDefinition, TypeDefinition> biFunction = mock(BiFunction.class);
    when(biFunction.apply(Mockito.<String>any(), Mockito.<TypeDefinition>any()))
        .thenReturn(
            new TypeDefinition.Builder().aggregateFunction(mock(BinaryOperator.class)).build());

    HashMap<String, TypeDefinition> types = new HashMap<>();
    types.put(
        "42", new TypeDefinition.Builder().aggregateFunction(mock(BinaryOperator.class)).build());
    types.replaceAll(biFunction);
    types.put(
        "foo", new TypeDefinition.Builder().aggregateFunction(mock(BinaryOperator.class)).build());

    // Act and Assert
    assertThrows(SchemaException.class, () -> builder.merge(new Schema(types)));
    verify(biFunction).apply(eq("42"), isA(TypeDefinition.class));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#type(String, Class)} with {@code typeName}, {@code
   * typeClass}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#type(String, Class)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder type(String, Class) with 'typeName', 'typeClass'; given Builder(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.type(String, Class)"})
  void testBaseBuilderTypeWithTypeNameTypeClass_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();
    Class<Object> typeClass = Object.class;

    // Act
    Builder actualTypeResult = builder.type("Type Name", typeClass);

    // Assert
    assertSame(builder, actualTypeResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#type(String, TypeDefinition)} with {@code typeName}, {@code
   * type}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#type(String, TypeDefinition)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder type(String, TypeDefinition) with 'typeName', 'type'; given Builder(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.type(String, TypeDefinition)"})
  void testBaseBuilderTypeWithTypeNameType_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualTypeResult = builder.type("Type Name", new TypeDefinition());

    // Assert
    assertSame(builder, actualTypeResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#types(Map)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#types(Map)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder types(Map); given Builder(); when HashMap(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.types(Map)"})
  void testBaseBuilderTypes_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualTypesResult = builder.types(new HashMap<>());

    // Assert
    assertSame(builder, actualTypesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#vertexSerialiser(Serialiser)}.
   *
   * <ul>
   *   <li>When {@link AvroSerialiser} (default constructor).
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#vertexSerialiser(Serialiser)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder vertexSerialiser(Serialiser); when AvroSerialiser (default constructor); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.vertexSerialiser(Serialiser)"})
  void testBaseBuilderVertexSerialiser_whenAvroSerialiser_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualVertexSerialiserResult = builder.vertexSerialiser(new AvroSerialiser());

    // Assert
    assertSame(builder, actualVertexSerialiserResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#visibilityProperty(String)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#visibilityProperty(String)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder visibilityProperty(String); given Builder(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.visibilityProperty(String)"})
  void testBaseBuilderVisibilityProperty_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualVisibilityPropertyResult = builder.visibilityProperty("Visibility Property");

    // Assert
    assertSame(builder, actualVisibilityPropertyResult);
  }

  /**
   * Test Builder {@link Builder#Builder(Schema)}.
   *
   * <p>Method under test: {@link Builder#Builder(Schema)}
   */
  @Test
  @DisplayName("Test Builder new Builder(Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>(Schema)"})
  void testBuilderNewBuilder() {
    // Arrange
    TypeDefinition.Builder builder = new TypeDefinition.Builder();
    builder.description("The characteristics of someone or something");
    TypeDefinition typeDefinition = builder.aggregateFunction(mock(BinaryOperator.class)).build();

    HashMap<String, TypeDefinition> types = new HashMap<>();
    types.put("foo", typeDefinition);

    // Act and Assert
    assertThrows(SchemaException.class, () -> new Builder(new Schema(types)));
  }

  /**
   * Test Builder {@link Builder#Builder(Schema)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then throw {@link SchemaException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#Builder(Schema)}
   */
  @Test
  @DisplayName("Test Builder new Builder(Schema); given 'foo'; then throw SchemaException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>(Schema)"})
  void testBuilderNewBuilder_givenFoo_thenThrowSchemaException() {
    // Arrange
    HashMap<String, TypeDefinition> types = new HashMap<>();
    types.put(
        "foo", new TypeDefinition.Builder().aggregateFunction(mock(BinaryOperator.class)).build());

    // Act and Assert
    assertThrows(SchemaException.class, () -> new Builder(new Schema(types)));
  }

  /**
   * Test Builder {@link Builder#Builder(Schema)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then throw {@link SchemaException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#Builder(Schema)}
   */
  @Test
  @DisplayName(
      "Test Builder new Builder(Schema); given 'java.lang.Object'; then throw SchemaException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>(Schema)"})
  void testBuilderNewBuilder_givenJavaLangObject_thenThrowSchemaException() {
    // Arrange
    TypeDefinition.Builder builder = new TypeDefinition.Builder();
    Class<Object> clazz = Object.class;
    builder.clazz(clazz);
    TypeDefinition typeDefinition = builder.aggregateFunction(mock(BinaryOperator.class)).build();

    HashMap<String, TypeDefinition> types = new HashMap<>();
    types.put("foo", typeDefinition);

    // Act and Assert
    assertThrows(SchemaException.class, () -> new Builder(new Schema(types)));
  }

  /**
   * Test Builder {@link Builder#Builder(Schema)}.
   *
   * <ul>
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#Builder(Schema)}
   */
  @Test
  @DisplayName("Test Builder new Builder(Schema); then calls apply(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>(Schema)"})
  void testBuilderNewBuilder_thenCallsApply() {
    // Arrange
    BiFunction<String, TypeDefinition, TypeDefinition> biFunction = mock(BiFunction.class);
    when(biFunction.apply(Mockito.<String>any(), Mockito.<TypeDefinition>any()))
        .thenReturn(
            new TypeDefinition.Builder().aggregateFunction(mock(BinaryOperator.class)).build());

    HashMap<String, TypeDefinition> types = new HashMap<>();
    types.put(
        "42", new TypeDefinition.Builder().aggregateFunction(mock(BinaryOperator.class)).build());
    types.replaceAll(biFunction);
    types.put(
        "foo", new TypeDefinition.Builder().aggregateFunction(mock(BinaryOperator.class)).build());

    // Act and Assert
    assertThrows(SchemaException.class, () -> new Builder(new Schema(types)));
    verify(biFunction).apply(eq("42"), isA(TypeDefinition.class));
  }

  /**
   * Test Builder {@link Builder#self()}.
   *
   * <p>Method under test: {@link Builder#self()}
   */
  @Test
  @DisplayName("Test Builder self()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.self()"})
  void testBuilderSelf() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSelfResult = builder.self();

    // Assert
    assertSame(builder, actualSelfResult);
  }

  /**
   * Test {@link Schema#isAggregationEnabled()}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema(Map)} with types is {@link HashMap#HashMap()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Schema#isAggregationEnabled()}
   */
  @Test
  @DisplayName(
      "Test isAggregationEnabled(); given Schema(Map) with types is HashMap(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Schema.isAggregationEnabled()"})
  void testIsAggregationEnabled_givenSchemaWithTypesIsHashMap_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Schema(new HashMap<>()).isAggregationEnabled());
  }

  /**
   * Test {@link Schema#isAggregationEnabled()}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Schema#isAggregationEnabled()}
   */
  @Test
  @DisplayName("Test isAggregationEnabled(); given Schema(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Schema.isAggregationEnabled()"})
  void testIsAggregationEnabled_givenSchema_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Schema().isAggregationEnabled());
  }

  /**
   * Test {@link Schema#getAggregatedGroups()}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema(Map)} with types is {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Schema#getAggregatedGroups()}
   */
  @Test
  @DisplayName(
      "Test getAggregatedGroups(); given Schema(Map) with types is HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List Schema.getAggregatedGroups()"})
  void testGetAggregatedGroups_givenSchemaWithTypesIsHashMap_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new Schema(new HashMap<>()).getAggregatedGroups().isEmpty());
  }

  /**
   * Test {@link Schema#getAggregatedGroups()}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Schema#getAggregatedGroups()}
   */
  @Test
  @DisplayName("Test getAggregatedGroups(); given Schema(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List Schema.getAggregatedGroups()"})
  void testGetAggregatedGroups_givenSchema_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new Schema().getAggregatedGroups().isEmpty());
  }

  /**
   * Test {@link Schema#validate()}.
   *
   * <p>Method under test: {@link Schema#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult Schema.validate()"})
  void testValidate() throws SchemaException {
    // Arrange and Act
    ValidationResult actualValidateResult = new Schema().validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link Schema#hasValidation()}.
   *
   * <p>Method under test: {@link Schema#hasValidation()}
   */
  @Test
  @DisplayName("Test hasValidation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Schema.hasValidation()"})
  void testHasValidation() {
    // Arrange, Act and Assert
    assertFalse(new Schema().hasValidation());
  }

  /**
   * Test {@link Schema#getType(String)}.
   *
   * <p>Method under test: {@link Schema#getType(String)}
   */
  @Test
  @DisplayName("Test getType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeDefinition Schema.getType(String)"})
  void testGetType() {
    // Arrange and Act
    TypeDefinition actualType = new Schema().getType("Type Name");

    // Assert
    assertNull(actualType.getClazz());
    assertNull(actualType.getClassString());
    assertNull(actualType.getDescription());
    assertNull(actualType.getFullClassString());
    assertNull(actualType.getValidateFunctions());
    assertNull(actualType.getAggregateFunction());
    assertNull(actualType.getSerialiser());
  }

  /**
   * Test {@link Schema#getElement(String)}.
   *
   * <p>Method under test: {@link Schema#getElement(String)}
   */
  @Test
  @DisplayName("Test getElement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaElementDefinition Schema.getElement(String)"})
  void testGetElement() {
    // Arrange, Act and Assert
    assertNull(new Schema().getElement("Group"));
  }

  /**
   * Test {@link Schema#getConfig(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()} addConfig {@code Key} and {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Schema#getConfig(String)}
   */
  @Test
  @DisplayName(
      "Test getConfig(String) with 'String'; given Schema() addConfig 'Key' and '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Schema.getConfig(String)"})
  void testGetConfigWithString_givenSchemaAddConfigKeyAnd42_thenReturn42() {
    // Arrange
    Schema schema = new Schema();
    schema.addConfig("Key", "42");

    // Act and Assert
    assertEquals("42", schema.getConfig("Key"));
  }

  /**
   * Test {@link Schema#getConfig(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Schema#getConfig(String)}
   */
  @Test
  @DisplayName("Test getConfig(String) with 'String'; given Schema(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Schema.getConfig(String)"})
  void testGetConfigWithString_givenSchema_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Schema().getConfig("Key"));
  }
}
