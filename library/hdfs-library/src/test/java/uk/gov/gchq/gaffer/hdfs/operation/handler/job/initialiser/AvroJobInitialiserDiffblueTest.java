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
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.hadoop.mapreduce.Job;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.hdfs.operation.AddElementsFromHdfs;
import uk.gov.gchq.gaffer.hdfs.operation.MapReduce;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class AvroJobInitialiserDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AvroJobInitialiser#AvroJobInitialiser()}
   *   <li>{@link AvroJobInitialiser#setAvroSchemaFilePath(String)}
   *   <li>{@link AvroJobInitialiser#getAvroSchemaFilePath()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AvroJobInitialiser.<init>()",
    "void AvroJobInitialiser.<init>(String)",
    "String AvroJobInitialiser.getAvroSchemaFilePath()",
    "void AvroJobInitialiser.setAvroSchemaFilePath(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AvroJobInitialiser actualAvroJobInitialiser = new AvroJobInitialiser();
    actualAvroJobInitialiser.setAvroSchemaFilePath("/directory/foo.txt");

    // Assert
    assertEquals("/directory/foo.txt", actualAvroJobInitialiser.getAvroSchemaFilePath());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code /directory/foo.txt}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AvroJobInitialiser#AvroJobInitialiser(String)}
   *   <li>{@link AvroJobInitialiser#setAvroSchemaFilePath(String)}
   *   <li>{@link AvroJobInitialiser#getAvroSchemaFilePath()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '/directory/foo.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AvroJobInitialiser.<init>()",
    "void AvroJobInitialiser.<init>(String)",
    "String AvroJobInitialiser.getAvroSchemaFilePath()",
    "void AvroJobInitialiser.setAvroSchemaFilePath(String)"
  })
  void testGettersAndSetters_whenDirectoryFooTxt() {
    // Arrange and Act
    AvroJobInitialiser actualAvroJobInitialiser = new AvroJobInitialiser("/directory/foo.txt");
    actualAvroJobInitialiser.setAvroSchemaFilePath("/directory/foo.txt");

    // Assert
    assertEquals("/directory/foo.txt", actualAvroJobInitialiser.getAvroSchemaFilePath());
  }

  /**
   * Test {@link AvroJobInitialiser#initialiseJob(Job, MapReduce, Store)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AvroJobInitialiser#initialiseJob(Job, MapReduce, Store)}
   */
  @Test
  @DisplayName("Test initialiseJob(Job, MapReduce, Store); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AvroJobInitialiser.initialiseJob(Job, MapReduce, Store)"})
  void testInitialiseJob_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    AvroJobInitialiser avroJobInitialiser = new AvroJobInitialiser(null);
    Job job = new Job();
    AddElementsFromHdfs operation = new AddElementsFromHdfs();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> avroJobInitialiser.initialiseJob(job, operation, new TestAddToGraphLibraryImpl()));
  }
}
