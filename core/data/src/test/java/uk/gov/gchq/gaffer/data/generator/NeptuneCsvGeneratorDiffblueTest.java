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

package uk.gov.gchq.gaffer.data.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class NeptuneCsvGeneratorDiffblueTest {
  /**
   * Method under test: {@link NeptuneCsvGenerator#getDefaultFields()}
   */
  @Test
  void testGetDefaultFields() {
    // Arrange and Act
    LinkedHashMap<String, String> actualDefaultFields = (new NeptuneCsvGenerator()).getDefaultFields();

    // Assert
    assertEquals(5, actualDefaultFields.size());
    assertEquals(":END_ID", actualDefaultFields.get("DESTINATION"));
    assertEquals(":ID", actualDefaultFields.get("VERTEX"));
    assertEquals(":LABEL", actualDefaultFields.get("ENTITY_GROUP"));
    assertEquals(":START_ID", actualDefaultFields.get("SOURCE"));
    assertEquals(":TYPE", actualDefaultFields.get("EDGE_GROUP"));
  }

  /**
   * Method under test: {@link NeptuneCsvGenerator#getDefaultFields()}
   */
  @Test
  void testGetDefaultFields2() {
    // Arrange
    LinkedHashMap<String, Class<?>> schemaProperties = new LinkedHashMap<>();
    schemaProperties.replaceAll(mock(BiFunction.class));

    NeptuneCsvGenerator neptuneCsvGenerator = new NeptuneCsvGenerator();
    neptuneCsvGenerator.addAdditionalFieldsFromSchemaProperties(schemaProperties);

    // Act
    LinkedHashMap<String, String> actualDefaultFields = neptuneCsvGenerator.getDefaultFields();

    // Assert
    assertEquals(5, actualDefaultFields.size());
    assertEquals(":END_ID", actualDefaultFields.get("DESTINATION"));
    assertEquals(":ID", actualDefaultFields.get("VERTEX"));
    assertEquals(":LABEL", actualDefaultFields.get("ENTITY_GROUP"));
    assertEquals(":START_ID", actualDefaultFields.get("SOURCE"));
    assertEquals(":TYPE", actualDefaultFields.get("EDGE_GROUP"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NeptuneCsvGenerator#getFields()}
   *   <li>{@link NeptuneCsvGenerator#getIncludeDefaultFields()}
   *   <li>{@link NeptuneCsvGenerator#getIncludeSchemaProperties()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    NeptuneCsvGenerator neptuneCsvGenerator = new NeptuneCsvGenerator();

    // Act
    LinkedHashMap<String, String> actualFields = neptuneCsvGenerator.getFields();
    boolean actualIncludeDefaultFields = neptuneCsvGenerator.getIncludeDefaultFields();
    boolean actualIncludeSchemaProperties = neptuneCsvGenerator.getIncludeSchemaProperties();

    // Assert
    assertEquals(5, actualFields.size());
    assertEquals(":END_ID", actualFields.get("DESTINATION"));
    assertEquals(":ID", actualFields.get("VERTEX"));
    assertEquals(":LABEL", actualFields.get("ENTITY_GROUP"));
    assertEquals(":START_ID", actualFields.get("SOURCE"));
    assertEquals(":TYPE", actualFields.get("EDGE_GROUP"));
    assertTrue(actualIncludeDefaultFields);
    assertTrue(actualIncludeSchemaProperties);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link NeptuneCsvGenerator}
   */
  @Test
  void testNewNeptuneCsvGenerator() {
    // Arrange and Act
    NeptuneCsvGenerator actualNeptuneCsvGenerator = new NeptuneCsvGenerator();

    // Assert
    assertEquals(" ", actualNeptuneCsvGenerator.getCommaReplacement());
    LinkedHashMap<String, String> defaultFields = actualNeptuneCsvGenerator.getDefaultFields();
    assertEquals(5, defaultFields.size());
    assertEquals(":END_ID", defaultFields.get("DESTINATION"));
    assertEquals(":ID", defaultFields.get("VERTEX"));
    assertEquals(":ID,:LABEL,:TYPE,:START_ID,:END_ID", actualNeptuneCsvGenerator.getHeader());
    assertEquals(":LABEL", defaultFields.get("ENTITY_GROUP"));
    assertEquals(":START_ID", defaultFields.get("SOURCE"));
    assertEquals(":TYPE", defaultFields.get("EDGE_GROUP"));
    assertFalse(actualNeptuneCsvGenerator.isQuoted());
    assertTrue(actualNeptuneCsvGenerator.getConstants().isEmpty());
    assertTrue(actualNeptuneCsvGenerator.getIncludeDefaultFields());
    assertTrue(actualNeptuneCsvGenerator.getIncludeSchemaProperties());
    assertEquals(defaultFields, actualNeptuneCsvGenerator.getFields());
  }
}
