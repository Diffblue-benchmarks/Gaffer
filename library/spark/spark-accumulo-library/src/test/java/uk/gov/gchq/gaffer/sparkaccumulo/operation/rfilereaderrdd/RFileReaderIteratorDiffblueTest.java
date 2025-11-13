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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.rfilereaderrdd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.apache.hadoop.conf.Configuration;
import org.apache.spark.Partition;
import org.apache.spark.SecurityManager;
import org.apache.spark.SparkConf;
import org.apache.spark.TaskContext;
import org.apache.spark.TaskContextImpl;
import org.apache.spark.executor.TaskMetrics;
import org.apache.spark.memory.StaticMemoryManager;
import org.apache.spark.memory.TaskMemoryManager;
import org.apache.spark.metrics.MetricsSystem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import scala.Some;

class RFileReaderIteratorDiffblueTest {
  /**
   * Test {@link RFileReaderIterator#RFileReaderIterator(Partition, TaskContext, Configuration, Set)}.
   * <ul>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link RFileReaderIterator#RFileReaderIterator(Partition, TaskContext, Configuration, Set)}
   */
  @Test
  @DisplayName("Test new RFileReaderIterator(Partition, TaskContext, Configuration, Set); then return not hasNext")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RFileReaderIterator.<init>(Partition, TaskContext, Configuration, Set)"})
  void testNewRFileReaderIterator_thenReturnNotHasNext() throws UnsupportedEncodingException {
    // Arrange
    AccumuloTablet partition = new AccumuloTablet(1, 1, "42", "End");

    TaskMemoryManager taskMemoryManager = new TaskMemoryManager(new StaticMemoryManager(new SparkConf(), 10), 1L);

    Properties localProperties = new Properties();
    SparkConf conf = new SparkConf();
    SparkConf sparkConf = new SparkConf();
    MetricsSystem metricsSystem = new MetricsSystem("Instance", conf,
        new SecurityManager(sparkConf, new Some<>("AXAXAXAX".getBytes("UTF-8"))));

    TaskContextImpl taskContext = new TaskContextImpl(1, 10, 1, 1L, 10, taskMemoryManager, localProperties,
        metricsSystem, new TaskMetrics());

    Configuration configuration = new Configuration();

    // Act and Assert
    assertFalse((new RFileReaderIterator(partition, taskContext, configuration, new HashSet<>())).hasNext());
  }
}
