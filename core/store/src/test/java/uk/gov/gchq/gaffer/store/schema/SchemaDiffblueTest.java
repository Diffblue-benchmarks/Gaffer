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

package uk.gov.gchq.gaffer.store.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.store.schema.Schema.BaseBuilder;
import uk.gov.gchq.gaffer.store.schema.Schema.Builder;
import uk.gov.gchq.koryphe.ValidationResult;

class SchemaDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#config(Map)} with {@code config}.
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#config(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder config(Map) with 'config'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.config(Map)"})
  void testBaseBuilderConfigWithConfig_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.config(new HashMap<>()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#config(String, String)} with {@code key}, {@code value}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#config(String, String)}
   */
  @Test
  @DisplayName("Test BaseBuilder config(String, String) with 'key', 'value'; given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.config(String, String)"})
  void testBaseBuilderConfigWithKeyValue_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.config("Key", "42"));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Path[])} with {@code filePaths}.
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#json(Path[])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(Path[]) with 'filePaths'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Path[])"})
  void testBaseBuilderJsonWithFilePaths_thenReturnBuilder() throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertSame(builder, builder.json(new Path[]{}));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(byte[][])} with {@code jsonBytes}.
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#json(byte[][])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(byte[][]) with 'jsonBytes'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(byte[][])"})
  void testBaseBuilderJsonWithJsonBytes_thenReturnBuilder() throws SchemaException {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.json(new byte[][]{}));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(Schema)} with {@code Schema}.
   * <p>
   * Method under test: {@link BaseBuilder#merge(Schema)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(Schema) with 'Schema'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(Schema)"})
  void testBaseBuilderMergeWithSchema() {
    // Arrange
    Builder builder = new Builder();

    TypeDefinition.Builder builder2 = new TypeDefinition.Builder();
    builder2.description("The characteristics of someone or something");
    TypeDefinition buildResult = builder2.<BinaryOperator<Object>, Object>aggregateFunction(mock(BinaryOperator.class))
        .build();

    HashMap<String, TypeDefinition> types = new HashMap<>();
    types.put("foo", buildResult);

    // Act and Assert
    assertThrows(SchemaException.class, () -> builder.merge(new Schema(types)));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(Schema)} with {@code Schema}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#merge(Schema)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(Schema) with 'Schema'; given Builder(); when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(Schema)"})
  void testBaseBuilderMergeWithSchema_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.merge(null));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(Schema)} with {@code Schema}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then throw {@link SchemaException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#merge(Schema)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(Schema) with 'Schema'; given 'foo'; then throw SchemaException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(Schema)"})
  void testBaseBuilderMergeWithSchema_givenFoo_thenThrowSchemaException() {
    // Arrange
    Builder builder = new Builder();

    HashMap<String, TypeDefinition> types = new HashMap<>();
    TypeDefinition buildResult = (new TypeDefinition.Builder())
        .<BinaryOperator<Object>, Object>aggregateFunction(mock(BinaryOperator.class))
        .build();
    types.put("foo", buildResult);

    // Act and Assert
    assertThrows(SchemaException.class, () -> builder.merge(new Schema(types)));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#merge(Schema)} with {@code Schema}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then throw {@link SchemaException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#merge(Schema)}
   */
  @Test
  @DisplayName("Test BaseBuilder merge(Schema) with 'Schema'; given 'java.lang.Object'; then throw SchemaException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.merge(Schema)"})
  void testBaseBuilderMergeWithSchema_givenJavaLangObject_thenThrowSchemaException() {
    // Arrange
    Builder builder = new Builder();

    TypeDefinition.Builder builder2 = new TypeDefinition.Builder();
    Class<Object> clazz = Object.class;
    builder2.clazz(clazz);
    TypeDefinition buildResult = builder2.<BinaryOperator<Object>, Object>aggregateFunction(mock(BinaryOperator.class))
        .build();

    HashMap<String, TypeDefinition> types = new HashMap<>();
    types.put("foo", buildResult);

    // Act and Assert
    assertThrows(SchemaException.class, () -> builder.merge(new Schema(types)));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#type(String, TypeDefinition)} with {@code typeName}, {@code type}.
   * <ul>
   *   <li>Given {@link Builder#Builder()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#type(String, TypeDefinition)}
   */
  @Test
  @DisplayName("Test BaseBuilder type(String, TypeDefinition) with 'typeName', 'type'; given Builder(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.type(String, TypeDefinition)"})
  void testBaseBuilderTypeWithTypeNameType_givenBuilder_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.type("Type Name", new TypeDefinition()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#types(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#types(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder types(Map); when HashMap(); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.types(Map)"})
  void testBaseBuilderTypes_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.types(new HashMap<>()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#types(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#types(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder types(Map); when 'null'; then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.types(Map)"})
  void testBaseBuilderTypes_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.types(null));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#vertexSerialiser(Serialiser)}.
   * <ul>
   *   <li>When {@link AvroSerialiser} (default constructor).</li>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#vertexSerialiser(Serialiser)}
   */
  @Test
  @DisplayName("Test BaseBuilder vertexSerialiser(Serialiser); when AvroSerialiser (default constructor); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.vertexSerialiser(Serialiser)"})
  void testBaseBuilderVertexSerialiser_whenAvroSerialiser_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.vertexSerialiser(new AvroSerialiser()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#visibilityProperty(String)}.
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseBuilder#visibilityProperty(String)}
   */
  @Test
  @DisplayName("Test BaseBuilder visibilityProperty(String); then return Builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.visibilityProperty(String)"})
  void testBaseBuilderVisibilityProperty_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.visibilityProperty("Visibility Property"));
  }

  /**
   * Test Builder {@link Builder#self()}.
   * <p>
   * Method under test: {@link Builder#self()}
   */
  @Test
  @DisplayName("Test Builder self()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.self()"})
  void testBuilderSelf() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.self());
  }

  /**
   * Test {@link Schema#isAggregationEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Schema#isAggregationEnabled()}
   */
  @Test
  @DisplayName("Test isAggregationEnabled(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Schema.isAggregationEnabled()"})
  void testIsAggregationEnabled_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Schema()).isAggregationEnabled());
  }

  /**
   * Test {@link Schema#isAggregationEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Schema#isAggregationEnabled()}
   */
  @Test
  @DisplayName("Test isAggregationEnabled(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Schema.isAggregationEnabled()"})
  void testIsAggregationEnabled_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse((new Schema()).isAggregationEnabled());
  }

  /**
   * Test {@link Schema#isAggregationEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Schema#isAggregationEnabled()}
   */
  @Test
  @DisplayName("Test isAggregationEnabled(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Schema.isAggregationEnabled()"})
  void testIsAggregationEnabled_thenReturnFalse3() {
    // Arrange, Act and Assert
    assertFalse((new Schema()).isAggregationEnabled());
  }

  /**
   * Test {@link Schema#isAggregationEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Schema#isAggregationEnabled()}
   */
  @Test
  @DisplayName("Test isAggregationEnabled(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Schema.isAggregationEnabled()"})
  void testIsAggregationEnabled_thenReturnFalse4() {
    // Arrange, Act and Assert
    assertFalse((new Schema()).isAggregationEnabled());
  }

  /**
   * Test {@link Schema#getAggregatedGroups()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Schema#getAggregatedGroups()}
   */
  @Test
  @DisplayName("Test getAggregatedGroups(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List Schema.getAggregatedGroups()"})
  void testGetAggregatedGroups_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new Schema()).getAggregatedGroups().isEmpty());
  }

  /**
   * Test {@link Schema#getAggregatedGroups()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Schema#getAggregatedGroups()}
   */
  @Test
  @DisplayName("Test getAggregatedGroups(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List Schema.getAggregatedGroups()"})
  void testGetAggregatedGroups_thenReturnEmpty2() {
    // Arrange, Act and Assert
    assertTrue((new Schema()).getAggregatedGroups().isEmpty());
  }

  /**
   * Test {@link Schema#getAggregatedGroups()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Schema#getAggregatedGroups()}
   */
  @Test
  @DisplayName("Test getAggregatedGroups(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List Schema.getAggregatedGroups()"})
  void testGetAggregatedGroups_thenReturnEmpty3() {
    // Arrange, Act and Assert
    assertTrue((new Schema()).getAggregatedGroups().isEmpty());
  }

  /**
   * Test {@link Schema#getAggregatedGroups()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Schema#getAggregatedGroups()}
   */
  @Test
  @DisplayName("Test getAggregatedGroups(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List Schema.getAggregatedGroups()"})
  void testGetAggregatedGroups_thenReturnEmpty4() {
    // Arrange, Act and Assert
    assertTrue((new Schema()).getAggregatedGroups().isEmpty());
  }

  /**
   * Test {@link Schema#validate()}.
   * <p>
   * Method under test: {@link Schema#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult Schema.validate()"})
  void testValidate() throws SchemaException {
    // Arrange and Act
    ValidationResult actualValidateResult = (new Schema()).validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link Schema#hasValidation()}.
   * <p>
   * Method under test: {@link Schema#hasValidation()}
   */
  @Test
  @DisplayName("Test hasValidation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Schema.hasValidation()"})
  void testHasValidation() {
    // Arrange, Act and Assert
    assertFalse((new Schema()).hasValidation());
  }

  /**
   * Test {@link Schema#getType(String)}.
   * <p>
   * Method under test: {@link Schema#getType(String)}
   */
  @Test
  @DisplayName("Test getType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeDefinition Schema.getType(String)"})
  void testGetType() {
    // Arrange and Act
    TypeDefinition actualType = (new Schema()).getType("Type Name");

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
   * <p>
   * Method under test: {@link Schema#getElement(String)}
   */
  @Test
  @DisplayName("Test getElement(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaElementDefinition Schema.getElement(String)"})
  void testGetElement() {
    // Arrange, Act and Assert
    assertNull((new Schema()).getElement("Group"));
  }

  /**
   * Test {@link Schema#getConfig(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link Schema#Schema()} addConfig {@code Key} and {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Schema#getConfig(String)}
   */
  @Test
  @DisplayName("Test getConfig(String) with 'String'; given Schema() addConfig 'Key' and '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Schema#Schema()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Schema#getConfig(String)}
   */
  @Test
  @DisplayName("Test getConfig(String) with 'String'; given Schema(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Schema.getConfig(String)"})
  void testGetConfigWithString_givenSchema_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Schema()).getConfig("Key"));
  }
}
