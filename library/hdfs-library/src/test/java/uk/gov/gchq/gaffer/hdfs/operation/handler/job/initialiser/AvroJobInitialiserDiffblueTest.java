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

package uk.gov.gchq.gaffer.hdfs.operation.handler.job.initialiser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AvroJobInitialiserDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AvroJobInitialiser#AvroJobInitialiser()}
   *   <li>{@link AvroJobInitialiser#setAvroSchemaFilePath(String)}
   *   <li>{@link AvroJobInitialiser#getAvroSchemaFilePath()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AvroJobInitialiser.<init>()", "void AvroJobInitialiser.<init>(String)",
      "String AvroJobInitialiser.getAvroSchemaFilePath()", "void AvroJobInitialiser.setAvroSchemaFilePath(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    AvroJobInitialiser actualAvroJobInitialiser = new AvroJobInitialiser();
    actualAvroJobInitialiser.setAvroSchemaFilePath("/directory/foo.txt");

    // Assert
    assertEquals("/directory/foo.txt", actualAvroJobInitialiser.getAvroSchemaFilePath());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code /directory/foo.txt}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AvroJobInitialiser#AvroJobInitialiser(String)}
   *   <li>{@link AvroJobInitialiser#setAvroSchemaFilePath(String)}
   *   <li>{@link AvroJobInitialiser#getAvroSchemaFilePath()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '/directory/foo.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AvroJobInitialiser.<init>()", "void AvroJobInitialiser.<init>(String)",
      "String AvroJobInitialiser.getAvroSchemaFilePath()", "void AvroJobInitialiser.setAvroSchemaFilePath(String)"})
  void testGettersAndSetters_whenDirectoryFooTxt() {
    // Arrange and Act
    AvroJobInitialiser actualAvroJobInitialiser = new AvroJobInitialiser("/directory/foo.txt");
    actualAvroJobInitialiser.setAvroSchemaFilePath("/directory/foo.txt");

    // Assert
    assertEquals("/directory/foo.txt", actualAvroJobInitialiser.getAvroSchemaFilePath());
  }
}
