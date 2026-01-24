/*
 * Copyright 2026 Crown Copyright
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.HashMap;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.hdfs.operation.AddElementsFromHdfs;
import uk.gov.gchq.gaffer.hdfs.operation.MapReduce;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class TextJobInitialiserDiffblueTest {
  /**
   * Test {@link TextJobInitialiser#initialiseJob(Job, MapReduce, Store)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link Job#Job()} Configuration {@link JobConf}.
   * </ul>
   *
   * <p>Method under test: {@link TextJobInitialiser#initialiseJob(Job, MapReduce, Store)}
   */
  @Test
  @DisplayName(
      "Test initialiseJob(Job, MapReduce, Store); given HashMap(); then Job() Configuration JobConf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextJobInitialiser.initialiseJob(Job, MapReduce, Store)"})
  void testInitialiseJob_givenHashMap_thenJobConfigurationJobConf() throws IOException {
    // Arrange
    TextJobInitialiser textJobInitialiser = new TextJobInitialiser();
    Job job = new Job();

    AddElementsFromHdfs operation = new AddElementsFromHdfs();
    operation.addInputMapperPairs(new HashMap<>());

    // Act
    textJobInitialiser.initialiseJob(job, operation, new TestAddToGraphLibraryImpl());

    // Assert
    Configuration configuration = job.getConfiguration();
    assertTrue(configuration instanceof JobConf);
    assertEquals(964, configuration.size());
  }
}
