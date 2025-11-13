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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NeptuneCsvElementGeneratorDiffblueTest {
  /**
   * Test {@link NeptuneCsvElementGenerator#getFields()}.
   * <p>
   * Method under test: {@link NeptuneCsvElementGenerator#getFields()}
   */
  @Test
  @DisplayName("Test getFields()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LinkedHashMap NeptuneCsvElementGenerator.getFields()"})
  void testGetFields() {
    // Arrange
    NeptuneCsvElementGenerator neptuneCsvElementGenerator = new NeptuneCsvElementGenerator();

    // Act and Assert
    assertEquals(neptuneCsvElementGenerator.fields, neptuneCsvElementGenerator.getFields());
  }

  /**
   * Test new {@link NeptuneCsvElementGenerator} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link NeptuneCsvElementGenerator}
   */
  @Test
  @DisplayName("Test new NeptuneCsvElementGenerator (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NeptuneCsvElementGenerator.<init>()"})
  void testNewNeptuneCsvElementGenerator() {
    // Arrange and Act
    NeptuneCsvElementGenerator actualNeptuneCsvElementGenerator = new NeptuneCsvElementGenerator();

    // Assert
    assertEquals("", actualNeptuneCsvElementGenerator.getNullString());
    LinkedHashMap<String, String> stringStringMap = actualNeptuneCsvElementGenerator.fields;
    assertEquals(5, stringStringMap.size());
    assertEquals(":END_ID", stringStringMap.get("DESTINATION"));
    assertEquals(":ID", stringStringMap.get("VERTEX"));
    assertEquals(":LABEL", stringStringMap.get("ENTITY_GROUP"));
    assertEquals(":START_ID", stringStringMap.get("SOURCE"));
    assertEquals(":TYPE", stringStringMap.get("EDGE_GROUP"));
    assertEquals(',', actualNeptuneCsvElementGenerator.getDelimiter());
    assertEquals(1, actualNeptuneCsvElementGenerator.getFirstRow());
    assertFalse(actualNeptuneCsvElementGenerator.getTrim());
    LinkedHashMap<String, String> expectedFields = actualNeptuneCsvElementGenerator.fields;
    assertEquals(expectedFields, actualNeptuneCsvElementGenerator.getFields());
  }
}
