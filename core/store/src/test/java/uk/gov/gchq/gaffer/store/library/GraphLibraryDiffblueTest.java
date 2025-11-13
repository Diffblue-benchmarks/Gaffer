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

package uk.gov.gchq.gaffer.store.library;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.exception.OverwritingException;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class GraphLibraryDiffblueTest {
  /**
   * Test {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)} with {@code
   * graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <p>Method under test: {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.add(String, String, Schema, String, StoreProperties)"})
  void testAddWithGraphIdSchemaIdSchemaPropertiesIdProperties() throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.add("42", "42", new Schema(), "42", null));
  }

  /**
   * Test {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)} with {@code
   * graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <p>Method under test: {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.add(String, String, Schema, String, StoreProperties)"})
  void testAddWithGraphIdSchemaIdSchemaPropertiesIdProperties2() throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.add("42", "42", null, "42", new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)} with {@code
   * graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <p>Method under test: {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.add(String, String, Schema, String, StoreProperties)"})
  void testAddWithGraphIdSchemaIdSchemaPropertiesIdProperties3() throws OverwritingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new FileGraphLibrary().add("42", "42", null, "42", null));
  }

  /**
   * Test {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)} with {@code
   * graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <p>Method under test: {@link GraphLibrary#add(String, String, Schema, String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.add(String, String, Schema, String, StoreProperties)"})
  void testAddWithGraphIdSchemaIdSchemaPropertiesIdProperties4() throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.add(null, "42", schema, "42", new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#add(String, Schema, StoreProperties)} with {@code graphId}, {@code
   * schema}, {@code properties}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#add(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; when '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.add(String, Schema, StoreProperties)"})
  void testAddWithGraphIdSchemaProperties_when42_thenThrowIllegalArgumentException()
      throws OverwritingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new FileGraphLibrary().add("42", null, null));
  }

  /**
   * Test {@link GraphLibrary#add(String, Schema, StoreProperties)} with {@code graphId}, {@code
   * schema}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#add(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; when Schema(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.add(String, Schema, StoreProperties)"})
  void testAddWithGraphIdSchemaProperties_whenSchema_thenThrowIllegalArgumentException()
      throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> fileGraphLibrary.add("42", new Schema(), null));
  }

  /**
   * Test {@link GraphLibrary#add(String, Schema, StoreProperties)} with {@code graphId}, {@code
   * schema}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#add(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; when Schema(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.add(String, Schema, StoreProperties)"})
  void testAddWithGraphIdSchemaProperties_whenSchema_thenThrowIllegalArgumentException2()
      throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.add(null, schema, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#add(String, Schema, StoreProperties)} with {@code graphId}, {@code
   * schema}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#add(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test add(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; when StoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.add(String, Schema, StoreProperties)"})
  void testAddWithGraphIdSchemaProperties_whenStoreProperties() throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.add("42", null, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, String, Schema, String, StoreProperties)} with
   * {@code graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, String, Schema, String,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphLibrary.addOrUpdate(String, String, Schema, String, StoreProperties)"
  })
  void testAddOrUpdateWithGraphIdSchemaIdSchemaPropertiesIdProperties() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdate("42", "42", new Schema(), "42", null));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, String, Schema, String, StoreProperties)} with
   * {@code graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, String, Schema, String,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphLibrary.addOrUpdate(String, String, Schema, String, StoreProperties)"
  })
  void testAddOrUpdateWithGraphIdSchemaIdSchemaPropertiesIdProperties2() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdate("42", "42", null, "42", new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, String, Schema, String, StoreProperties)} with
   * {@code graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, String, Schema, String,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphLibrary.addOrUpdate(String, String, Schema, String, StoreProperties)"
  })
  void testAddOrUpdateWithGraphIdSchemaIdSchemaPropertiesIdProperties3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new FileGraphLibrary().addOrUpdate("42", "42", null, "42", null));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, String, Schema, String, StoreProperties)} with
   * {@code graphId}, {@code schemaId}, {@code schema}, {@code propertiesId}, {@code properties}.
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, String, Schema, String,
   * StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, String, Schema, String, StoreProperties) with 'graphId', 'schemaId', 'schema', 'propertiesId', 'properties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphLibrary.addOrUpdate(String, String, Schema, String, StoreProperties)"
  })
  void testAddOrUpdateWithGraphIdSchemaIdSchemaPropertiesIdProperties4() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdate(null, "42", schema, "42", new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)} with {@code graphId},
   * {@code schema}, {@code properties}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.addOrUpdate(String, Schema, StoreProperties)"})
  void testAddOrUpdateWithGraphIdSchemaProperties_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new FileGraphLibrary().addOrUpdate("42", null, null));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)} with {@code graphId},
   * {@code schema}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; when Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.addOrUpdate(String, Schema, StoreProperties)"})
  void testAddOrUpdateWithGraphIdSchemaProperties_whenSchema() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdate("42", new Schema(), null));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)} with {@code graphId},
   * {@code schema}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; when Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.addOrUpdate(String, Schema, StoreProperties)"})
  void testAddOrUpdateWithGraphIdSchemaProperties_whenSchema2() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdate(null, schema, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)} with {@code graphId},
   * {@code schema}, {@code properties}.
   *
   * <ul>
   *   <li>When {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdate(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdate(String, Schema, StoreProperties) with 'graphId', 'schema', 'properties'; when StoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.addOrUpdate(String, Schema, StoreProperties)"})
  void testAddOrUpdateWithGraphIdSchemaProperties_whenStoreProperties() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdate("42", null, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#get(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#get(String)}
   */
  @Test
  @DisplayName("Test get(String); when '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"uk.gov.gchq.gaffer.commonutil.pair.Pair GraphLibrary.get(String)"})
  void testGet_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FileGraphLibrary().get("42"));
  }

  /**
   * Test {@link GraphLibrary#get(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#get(String)}
   */
  @Test
  @DisplayName("Test get(String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"uk.gov.gchq.gaffer.commonutil.pair.Pair GraphLibrary.get(String)"})
  void testGet_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new FileGraphLibrary().get(null));
  }

  /**
   * Test {@link GraphLibrary#getSchema(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#getSchema(String)}
   */
  @Test
  @DisplayName("Test getSchema(String); when '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema GraphLibrary.getSchema(String)"})
  void testGetSchema_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FileGraphLibrary().getSchema("42"));
  }

  /**
   * Test {@link GraphLibrary#getSchema(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#getSchema(String)}
   */
  @Test
  @DisplayName("Test getSchema(String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema GraphLibrary.getSchema(String)"})
  void testGetSchema_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new FileGraphLibrary().getSchema(null));
  }

  /**
   * Test {@link GraphLibrary#getProperties(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#getProperties(String)}
   */
  @Test
  @DisplayName("Test getProperties(String); when '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StoreProperties GraphLibrary.getProperties(String)"})
  void testGetProperties_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FileGraphLibrary().getProperties("42"));
  }

  /**
   * Test {@link GraphLibrary#getProperties(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#getProperties(String)}
   */
  @Test
  @DisplayName("Test getProperties(String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StoreProperties GraphLibrary.getProperties(String)"})
  void testGetProperties_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new FileGraphLibrary().getProperties(null));
  }

  /**
   * Test {@link GraphLibrary#exists(String)}.
   *
   * <p>Method under test: {@link GraphLibrary#exists(String)}
   */
  @Test
  @DisplayName("Test exists(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphLibrary.exists(String)"})
  void testExists() {
    // Arrange, Act and Assert
    assertFalse(new FileGraphLibrary().exists("42"));
  }

  /**
   * Test {@link GraphLibrary#addSchema(String, Schema)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addSchema(String, Schema)}
   */
  @Test
  @DisplayName("Test addSchema(String, Schema); when '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.addSchema(String, Schema)"})
  void testAddSchema_when42_thenThrowIllegalArgumentException() throws OverwritingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new FileGraphLibrary().addSchema("42", null));
  }

  /**
   * Test {@link GraphLibrary#addSchema(String, Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addSchema(String, Schema)}
   */
  @Test
  @DisplayName("Test addSchema(String, Schema); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.addSchema(String, Schema)"})
  void testAddSchema_whenNull_thenThrowIllegalArgumentException() throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> fileGraphLibrary.addSchema(null, new Schema()));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdateSchema(String, Schema)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdateSchema(String, Schema)}
   */
  @Test
  @DisplayName("Test addOrUpdateSchema(String, Schema); when '42'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.addOrUpdateSchema(String, Schema)"})
  void testAddOrUpdateSchema_when42_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new FileGraphLibrary().addOrUpdateSchema("42", null));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdateSchema(String, Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdateSchema(String, Schema)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdateSchema(String, Schema); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.addOrUpdateSchema(String, Schema)"})
  void testAddOrUpdateSchema_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdateSchema(null, new Schema()));
  }

  /**
   * Test {@link GraphLibrary#addProperties(String, StoreProperties)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addProperties(String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addProperties(String, StoreProperties); when '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.addProperties(String, StoreProperties)"})
  void testAddProperties_when42_thenThrowIllegalArgumentException() throws OverwritingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new FileGraphLibrary().addProperties("42", null));
  }

  /**
   * Test {@link GraphLibrary#addProperties(String, StoreProperties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addProperties(String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addProperties(String, StoreProperties); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.addProperties(String, StoreProperties)"})
  void testAddProperties_whenNull_thenThrowIllegalArgumentException() throws OverwritingException {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addProperties(null, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdateProperties(String, StoreProperties)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdateProperties(String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdateProperties(String, StoreProperties); when '42'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.addOrUpdateProperties(String, StoreProperties)"})
  void testAddOrUpdateProperties_when42_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new FileGraphLibrary().addOrUpdateProperties("42", null));
  }

  /**
   * Test {@link GraphLibrary#addOrUpdateProperties(String, StoreProperties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#addOrUpdateProperties(String, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdateProperties(String, StoreProperties); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.addOrUpdateProperties(String, StoreProperties)"})
  void testAddOrUpdateProperties_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.addOrUpdateProperties(null, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#checkExisting(String, Schema, StoreProperties)} with {@code String},
   * {@code Schema}, {@code StoreProperties}.
   *
   * <p>Method under test: {@link GraphLibrary#checkExisting(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test checkExisting(String, Schema, StoreProperties) with 'String', 'Schema', 'StoreProperties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.checkExisting(String, Schema, StoreProperties)"})
  void testCheckExistingWithStringSchemaStoreProperties() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.checkExisting(null, schema, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#checkExisting(String, Schema, StoreProperties)} with {@code String},
   * {@code Schema}, {@code StoreProperties}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#checkExisting(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test checkExisting(String, Schema, StoreProperties) with 'String', 'Schema', 'StoreProperties'; when '42'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphLibrary.checkExisting(String, Schema, StoreProperties)"})
  void testCheckExistingWithStringSchemaStoreProperties_when42_thenDoesNotThrow() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();

    // Act and Assert
    assertDoesNotThrow(() -> fileGraphLibrary.checkExisting("42", null, new StoreProperties()));
  }

  /**
   * Test {@link GraphLibrary#resolveSchema(Schema, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#resolveSchema(Schema, List)}
   */
  @Test
  @DisplayName("Test resolveSchema(Schema, List); given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema GraphLibrary.resolveSchema(Schema, List)"})
  void testResolveSchema_givenNull_whenArrayListAddNull() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();
    Schema schema = new Schema();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.resolveSchema(schema, parentSchemaIds));
  }

  /**
   * Test {@link GraphLibrary#resolveSchema(Schema, List)}.
   *
   * <ul>
   *   <li>Given {@code Parent Schema Ids}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Parent Schema Ids}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#resolveSchema(Schema, List)}
   */
  @Test
  @DisplayName(
      "Test resolveSchema(Schema, List); given 'Parent Schema Ids'; when ArrayList() add 'Parent Schema Ids'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Schema GraphLibrary.resolveSchema(Schema, List)"})
  void testResolveSchema_givenParentSchemaIds_whenArrayListAddParentSchemaIds() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();
    Schema schema = new Schema();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("Parent Schema Ids");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> fileGraphLibrary.resolveSchema(schema, parentSchemaIds));
  }

  /**
   * Test {@link GraphLibrary#resolveStoreProperties(StoreProperties, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#resolveStoreProperties(StoreProperties, String)}
   */
  @Test
  @DisplayName("Test resolveStoreProperties(StoreProperties, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StoreProperties GraphLibrary.resolveStoreProperties(StoreProperties, String)"
  })
  void testResolveStoreProperties_when42() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();
    StoreProperties properties = new StoreProperties();

    // Act
    StoreProperties actualResolveStorePropertiesResult =
        fileGraphLibrary.resolveStoreProperties(properties, "42");

    // Assert
    assertEquals(properties, actualResolveStorePropertiesResult);
  }

  /**
   * Test {@link GraphLibrary#resolveStoreProperties(StoreProperties, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphLibrary#resolveStoreProperties(StoreProperties, String)}
   */
  @Test
  @DisplayName("Test resolveStoreProperties(StoreProperties, String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StoreProperties GraphLibrary.resolveStoreProperties(StoreProperties, String)"
  })
  void testResolveStoreProperties_whenNull() {
    // Arrange
    FileGraphLibrary fileGraphLibrary = new FileGraphLibrary();
    StoreProperties properties = new StoreProperties();

    // Act
    StoreProperties actualResolveStorePropertiesResult =
        fileGraphLibrary.resolveStoreProperties(properties, null);

    // Assert
    assertEquals(properties, actualResolveStorePropertiesResult);
  }
}
