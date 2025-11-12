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

package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.handler.job.partitioner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import javassist.Loader;
import org.apache.accumulo.core.bloomfilter.BloomFilter;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.ConfigurationWithLogging;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.junit.jupiter.api.Test;

class GafferRangePartitionerDiffblueTest {
  /**
   * Method under test:
   * {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  void testGetPartition() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(new Configuration());
    Text key = new Text();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> gafferRangePartitioner.getPartition(key, new BloomFilter(3, 19088743, 1), 10));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  void testGetPartition2() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(new ConfigurationWithLogging(new Configuration()));
    Text key = new Text();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> gafferRangePartitioner.getPartition(key, new BloomFilter(3, 19088743, 1), 10));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  void testGetPartition3() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(new JobConf());
    Text key = new Text();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> gafferRangePartitioner.getPartition(key, new BloomFilter(3, 19088743, 1), 10));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  void testGetPartition4() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(new YarnConfiguration(new Configuration()));
    Text key = new Text();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> gafferRangePartitioner.getPartition(key, new BloomFilter(3, 19088743, 1), 10));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  void testGetPartition5() {
    // Arrange
    Configuration conf = new Configuration();
    conf.addResource(" not found in distributed cache");

    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(conf);
    Text key = new Text();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> gafferRangePartitioner.getPartition(key, new BloomFilter(3, 19088743, 1), 10));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  void testGetPartition6() throws IllegalArgumentException {
    // Arrange
    Configuration conf = new Configuration();
    conf.addResource(new Path(" not found in distributed cache"));
    conf.addResource(" not found in distributed cache");

    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(conf);
    Text key = new Text();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> gafferRangePartitioner.getPartition(key, new BloomFilter(3, 19088743, 1), 10));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  void testGetPartition7() {
    // Arrange
    Configuration conf = new Configuration();
    conf.addResource(new Configuration());
    conf.addResource(" not found in distributed cache");

    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(conf);
    Text key = new Text();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> gafferRangePartitioner.getPartition(key, new BloomFilter(3, 19088743, 1), 10));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  void testGetPartition8() {
    // Arrange
    Configuration conf = new Configuration();
    conf.setAllowNullValueProperties(true);
    conf.addResource(" not found in distributed cache");

    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(conf);
    Text key = new Text();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> gafferRangePartitioner.getPartition(key, new BloomFilter(3, 19088743, 1), 10));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#getPartition(Text, Writable, int)}
   */
  @Test
  void testGetPartition9() {
    // Arrange
    Configuration conf = new Configuration();
    conf.setClassLoader(new Loader());
    conf.addResource(" not found in distributed cache");

    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(conf);
    Text key = new Text();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> gafferRangePartitioner.getPartition(key, new BloomFilter(3, 19088743, 1), 10));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#findPartition(Text, Text[], int)}
   */
  @Test
  void testFindPartition() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    Text key = new Text();

    // Act and Assert
    assertEquals(0, gafferRangePartitioner.findPartition(key, new Text[]{new Text()}, 10));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#findPartition(Text, Text[], int)}
   */
  @Test
  void testFindPartition2() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(new Configuration());
    Text key = new Text();

    // Act and Assert
    assertEquals(0, gafferRangePartitioner.findPartition(key, new Text[]{new Text()}, 2));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#findPartition(Text, Text[], int)}
   */
  @Test
  void testFindPartition3() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    gafferRangePartitioner.setConf(new Configuration());
    Text key = new Text();

    // Act and Assert
    assertEquals(0, gafferRangePartitioner.findPartition(key, new Text[]{new Text()}, 1));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#findPartition(Text, Text[], int)}
   */
  @Test
  void testFindPartition4() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    Text key = new Text("String");

    // Act and Assert
    assertEquals(13, gafferRangePartitioner.findPartition(key, new Text[]{new Text()}, 10));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#findPartition(Text, Text[], int)}
   */
  @Test
  void testFindPartition5() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();

    // Act and Assert
    assertEquals(0, gafferRangePartitioner.findPartition(new Text(), new Text[]{}, 10));
  }

  /**
   * Method under test:
   * {@link GafferRangePartitioner#findPartition(Text, Text[], int)}
   */
  @Test
  void testFindPartition6() {
    // Arrange
    GafferRangePartitioner gafferRangePartitioner = new GafferRangePartitioner();
    Text key = new Text("String");
    Text text = new Text();

    // Act and Assert
    assertEquals(23, gafferRangePartitioner.findPartition(key, new Text[]{text, new Text()}, 10));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GafferRangePartitioner}
   *   <li>{@link GafferRangePartitioner#setConf(Configuration)}
   *   <li>{@link GafferRangePartitioner#getConf()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GafferRangePartitioner actualGafferRangePartitioner = new GafferRangePartitioner();
    Configuration conf = new Configuration();
    actualGafferRangePartitioner.setConf(conf);

    // Assert that nothing has changed
    assertSame(conf, actualGafferRangePartitioner.getConf());
  }
}
