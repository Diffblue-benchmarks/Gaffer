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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.rfilereaderrdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Set;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.ConfigurationWithLogging;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UtilsDiffblueTest {
  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName("Test serialiseConfiguration(Configuration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Utils.serialiseConfiguration(Configuration)"})
  void testSerialiseConfiguration() throws IOException {
    // Arrange
    YarnConfiguration configuration = new YarnConfiguration(new Configuration());
    configuration.addResource("42");

    // Act
    byte[] actualSerialiseConfigurationResult = Utils.serialiseConfiguration(configuration);

    // Assert
    assertEquals((byte) -114, actualSerialiseConfigurationResult[0]);
    assertEquals((byte) -38, actualSerialiseConfigurationResult[140381]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140366]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140374]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140372]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140377]);
    assertEquals((byte) -56, actualSerialiseConfigurationResult[140376]);
    assertEquals((byte) -71, actualSerialiseConfigurationResult[140382]);
    assertEquals((byte) -85, actualSerialiseConfigurationResult[140375]);
    assertEquals((byte) -90, actualSerialiseConfigurationResult[2]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140379]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140385]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140386]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140387]);
    assertEquals(140388, actualSerialiseConfigurationResult.length);
    assertEquals((byte) 17, actualSerialiseConfigurationResult[140383]);
    assertEquals((byte) 18, actualSerialiseConfigurationResult[140384]);
    assertEquals((byte) 1, actualSerialiseConfigurationResult[140378]);
    assertEquals((byte) 5, actualSerialiseConfigurationResult[1]);
    assertEquals('!', actualSerialiseConfigurationResult[3]);
    assertEquals('(', actualSerialiseConfigurationResult[140363]);
    assertEquals(')', actualSerialiseConfigurationResult[140373]);
    assertEquals(',', actualSerialiseConfigurationResult[140371]);
    assertEquals('.', actualSerialiseConfigurationResult[13]);
    assertEquals('.', actualSerialiseConfigurationResult[24]);
    assertEquals('I', actualSerialiseConfigurationResult[140368]);
    assertEquals('J', actualSerialiseConfigurationResult[140364]);
    assertEquals('K', actualSerialiseConfigurationResult[140370]);
    assertEquals('M', actualSerialiseConfigurationResult[140365]);
    assertEquals('M', actualSerialiseConfigurationResult[140367]);
    assertEquals('M', actualSerialiseConfigurationResult[140369]);
    assertEquals('^', actualSerialiseConfigurationResult[140380]);
    assertEquals('a', actualSerialiseConfigurationResult[5]);
    assertEquals('b', actualSerialiseConfigurationResult[Short.SIZE]);
    assertEquals('c', actualSerialiseConfigurationResult[11]);
    assertEquals('d', actualSerialiseConfigurationResult[9]);
    assertEquals('e', actualSerialiseConfigurationResult[12]);
    assertEquals('e', actualSerialiseConfigurationResult[8]);
    assertEquals('h', actualSerialiseConfigurationResult[17]);
    assertEquals('i', actualSerialiseConfigurationResult[18]);
    assertEquals('j', actualSerialiseConfigurationResult[14]);
    assertEquals('m', actualSerialiseConfigurationResult[4]);
    assertEquals('o', actualSerialiseConfigurationResult[15]);
    assertEquals('o', actualSerialiseConfigurationResult[21]);
    assertEquals('p', actualSerialiseConfigurationResult[6]);
    assertEquals('r', actualSerialiseConfigurationResult[22]);
    assertEquals('r', actualSerialiseConfigurationResult[7]);
    assertEquals('s', actualSerialiseConfigurationResult[19]);
    assertEquals('t', actualSerialiseConfigurationResult[20]);
    assertEquals('u', actualSerialiseConfigurationResult[10]);
    assertEquals('y', actualSerialiseConfigurationResult[23]);
  }

  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Configuration#Configuration()} addResource {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName(
      "Test serialiseConfiguration(Configuration); given '42'; when Configuration() addResource '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Utils.serialiseConfiguration(Configuration)"})
  void testSerialiseConfiguration_given42_whenConfigurationAddResource42() throws IOException {
    // Arrange
    Configuration configuration = new Configuration();
    configuration.addResource("42");

    // Act
    byte[] actualSerialiseConfigurationResult = Utils.serialiseConfiguration(configuration);

    // Assert
    assertEquals((byte) -114, actualSerialiseConfigurationResult[0]);
    assertEquals((byte) -38, actualSerialiseConfigurationResult[140381]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140366]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140374]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140372]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140377]);
    assertEquals((byte) -56, actualSerialiseConfigurationResult[140376]);
    assertEquals((byte) -71, actualSerialiseConfigurationResult[140382]);
    assertEquals((byte) -85, actualSerialiseConfigurationResult[140375]);
    assertEquals((byte) -90, actualSerialiseConfigurationResult[2]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140379]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140385]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140386]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140387]);
    assertEquals(140388, actualSerialiseConfigurationResult.length);
    assertEquals((byte) 17, actualSerialiseConfigurationResult[140383]);
    assertEquals((byte) 18, actualSerialiseConfigurationResult[140384]);
    assertEquals((byte) 1, actualSerialiseConfigurationResult[140378]);
    assertEquals((byte) 5, actualSerialiseConfigurationResult[1]);
    assertEquals('!', actualSerialiseConfigurationResult[3]);
    assertEquals('(', actualSerialiseConfigurationResult[140363]);
    assertEquals(')', actualSerialiseConfigurationResult[140373]);
    assertEquals(',', actualSerialiseConfigurationResult[140371]);
    assertEquals('.', actualSerialiseConfigurationResult[13]);
    assertEquals('.', actualSerialiseConfigurationResult[24]);
    assertEquals('I', actualSerialiseConfigurationResult[140368]);
    assertEquals('J', actualSerialiseConfigurationResult[140364]);
    assertEquals('K', actualSerialiseConfigurationResult[140370]);
    assertEquals('M', actualSerialiseConfigurationResult[140365]);
    assertEquals('M', actualSerialiseConfigurationResult[140367]);
    assertEquals('M', actualSerialiseConfigurationResult[140369]);
    assertEquals('^', actualSerialiseConfigurationResult[140380]);
    assertEquals('a', actualSerialiseConfigurationResult[5]);
    assertEquals('b', actualSerialiseConfigurationResult[Short.SIZE]);
    assertEquals('c', actualSerialiseConfigurationResult[11]);
    assertEquals('d', actualSerialiseConfigurationResult[9]);
    assertEquals('e', actualSerialiseConfigurationResult[12]);
    assertEquals('e', actualSerialiseConfigurationResult[8]);
    assertEquals('h', actualSerialiseConfigurationResult[17]);
    assertEquals('i', actualSerialiseConfigurationResult[18]);
    assertEquals('j', actualSerialiseConfigurationResult[14]);
    assertEquals('m', actualSerialiseConfigurationResult[4]);
    assertEquals('o', actualSerialiseConfigurationResult[15]);
    assertEquals('o', actualSerialiseConfigurationResult[21]);
    assertEquals('p', actualSerialiseConfigurationResult[6]);
    assertEquals('r', actualSerialiseConfigurationResult[22]);
    assertEquals('r', actualSerialiseConfigurationResult[7]);
    assertEquals('s', actualSerialiseConfigurationResult[19]);
    assertEquals('t', actualSerialiseConfigurationResult[20]);
    assertEquals('u', actualSerialiseConfigurationResult[10]);
    assertEquals('y', actualSerialiseConfigurationResult[23]);
  }

  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>Given {@link Configuration#Configuration()}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName("Test serialiseConfiguration(Configuration); given Configuration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Utils.serialiseConfiguration(Configuration)"})
  void testSerialiseConfiguration_givenConfiguration() throws IOException {
    // Arrange
    Configuration configuration = new Configuration();
    configuration.addResource(new Configuration());

    // Act
    byte[] actualSerialiseConfigurationResult = Utils.serialiseConfiguration(configuration);

    // Assert
    assertEquals((byte) -114, actualSerialiseConfigurationResult[0]);
    assertEquals((byte) -38, actualSerialiseConfigurationResult[140381]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140366]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140374]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140372]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140377]);
    assertEquals((byte) -56, actualSerialiseConfigurationResult[140376]);
    assertEquals((byte) -71, actualSerialiseConfigurationResult[140382]);
    assertEquals((byte) -85, actualSerialiseConfigurationResult[140375]);
    assertEquals((byte) -90, actualSerialiseConfigurationResult[2]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140379]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140385]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140386]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140387]);
    assertEquals(140388, actualSerialiseConfigurationResult.length);
    assertEquals((byte) 17, actualSerialiseConfigurationResult[140383]);
    assertEquals((byte) 18, actualSerialiseConfigurationResult[140384]);
    assertEquals((byte) 1, actualSerialiseConfigurationResult[140378]);
    assertEquals((byte) 5, actualSerialiseConfigurationResult[1]);
    assertEquals('!', actualSerialiseConfigurationResult[3]);
    assertEquals('(', actualSerialiseConfigurationResult[140363]);
    assertEquals(')', actualSerialiseConfigurationResult[140373]);
    assertEquals(',', actualSerialiseConfigurationResult[140371]);
    assertEquals('.', actualSerialiseConfigurationResult[13]);
    assertEquals('.', actualSerialiseConfigurationResult[24]);
    assertEquals('I', actualSerialiseConfigurationResult[140368]);
    assertEquals('J', actualSerialiseConfigurationResult[140364]);
    assertEquals('K', actualSerialiseConfigurationResult[140370]);
    assertEquals('M', actualSerialiseConfigurationResult[140365]);
    assertEquals('M', actualSerialiseConfigurationResult[140367]);
    assertEquals('M', actualSerialiseConfigurationResult[140369]);
    assertEquals('^', actualSerialiseConfigurationResult[140380]);
    assertEquals('a', actualSerialiseConfigurationResult[5]);
    assertEquals('b', actualSerialiseConfigurationResult[Short.SIZE]);
    assertEquals('c', actualSerialiseConfigurationResult[11]);
    assertEquals('d', actualSerialiseConfigurationResult[9]);
    assertEquals('e', actualSerialiseConfigurationResult[12]);
    assertEquals('e', actualSerialiseConfigurationResult[8]);
    assertEquals('h', actualSerialiseConfigurationResult[17]);
    assertEquals('i', actualSerialiseConfigurationResult[18]);
    assertEquals('j', actualSerialiseConfigurationResult[14]);
    assertEquals('m', actualSerialiseConfigurationResult[4]);
    assertEquals('o', actualSerialiseConfigurationResult[15]);
    assertEquals('o', actualSerialiseConfigurationResult[21]);
    assertEquals('p', actualSerialiseConfigurationResult[6]);
    assertEquals('r', actualSerialiseConfigurationResult[22]);
    assertEquals('r', actualSerialiseConfigurationResult[7]);
    assertEquals('s', actualSerialiseConfigurationResult[19]);
    assertEquals('t', actualSerialiseConfigurationResult[20]);
    assertEquals('u', actualSerialiseConfigurationResult[10]);
    assertEquals('y', actualSerialiseConfigurationResult[23]);
  }

  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>Given {@link Path#Path(String)} with {@code Path String}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName("Test serialiseConfiguration(Configuration); given Path(String) with 'Path String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Utils.serialiseConfiguration(Configuration)"})
  void testSerialiseConfiguration_givenPathWithPathString()
      throws IOException, IllegalArgumentException {
    // Arrange
    Configuration configuration = new Configuration();
    configuration.addResource(new Path("Path String"));

    // Act
    byte[] actualSerialiseConfigurationResult = Utils.serialiseConfiguration(configuration);

    // Assert
    assertEquals((byte) -114, actualSerialiseConfigurationResult[0]);
    assertEquals((byte) -38, actualSerialiseConfigurationResult[140381]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140366]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140374]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140372]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140377]);
    assertEquals((byte) -56, actualSerialiseConfigurationResult[140376]);
    assertEquals((byte) -71, actualSerialiseConfigurationResult[140382]);
    assertEquals((byte) -85, actualSerialiseConfigurationResult[140375]);
    assertEquals((byte) -90, actualSerialiseConfigurationResult[2]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140379]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140385]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140386]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140387]);
    assertEquals(140388, actualSerialiseConfigurationResult.length);
    assertEquals((byte) 17, actualSerialiseConfigurationResult[140383]);
    assertEquals((byte) 18, actualSerialiseConfigurationResult[140384]);
    assertEquals((byte) 1, actualSerialiseConfigurationResult[140378]);
    assertEquals((byte) 5, actualSerialiseConfigurationResult[1]);
    assertEquals('!', actualSerialiseConfigurationResult[3]);
    assertEquals('(', actualSerialiseConfigurationResult[140363]);
    assertEquals(')', actualSerialiseConfigurationResult[140373]);
    assertEquals(',', actualSerialiseConfigurationResult[140371]);
    assertEquals('.', actualSerialiseConfigurationResult[13]);
    assertEquals('.', actualSerialiseConfigurationResult[24]);
    assertEquals('I', actualSerialiseConfigurationResult[140368]);
    assertEquals('J', actualSerialiseConfigurationResult[140364]);
    assertEquals('K', actualSerialiseConfigurationResult[140370]);
    assertEquals('M', actualSerialiseConfigurationResult[140365]);
    assertEquals('M', actualSerialiseConfigurationResult[140367]);
    assertEquals('M', actualSerialiseConfigurationResult[140369]);
    assertEquals('^', actualSerialiseConfigurationResult[140380]);
    assertEquals('a', actualSerialiseConfigurationResult[5]);
    assertEquals('b', actualSerialiseConfigurationResult[Short.SIZE]);
    assertEquals('c', actualSerialiseConfigurationResult[11]);
    assertEquals('d', actualSerialiseConfigurationResult[9]);
    assertEquals('e', actualSerialiseConfigurationResult[12]);
    assertEquals('e', actualSerialiseConfigurationResult[8]);
    assertEquals('h', actualSerialiseConfigurationResult[17]);
    assertEquals('i', actualSerialiseConfigurationResult[18]);
    assertEquals('j', actualSerialiseConfigurationResult[14]);
    assertEquals('m', actualSerialiseConfigurationResult[4]);
    assertEquals('o', actualSerialiseConfigurationResult[15]);
    assertEquals('o', actualSerialiseConfigurationResult[21]);
    assertEquals('p', actualSerialiseConfigurationResult[6]);
    assertEquals('r', actualSerialiseConfigurationResult[22]);
    assertEquals('r', actualSerialiseConfigurationResult[7]);
    assertEquals('s', actualSerialiseConfigurationResult[19]);
    assertEquals('t', actualSerialiseConfigurationResult[20]);
    assertEquals('u', actualSerialiseConfigurationResult[10]);
    assertEquals('y', actualSerialiseConfigurationResult[23]);
  }

  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>When {@link Configuration#Configuration()}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName("Test serialiseConfiguration(Configuration); when Configuration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Utils.serialiseConfiguration(Configuration)"})
  void testSerialiseConfiguration_whenConfiguration() throws IOException {
    // Arrange and Act
    byte[] actualSerialiseConfigurationResult = Utils.serialiseConfiguration(new Configuration());

    // Assert
    assertEquals((byte) -114, actualSerialiseConfigurationResult[0]);
    assertEquals((byte) -38, actualSerialiseConfigurationResult[140381]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140366]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140374]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140372]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140377]);
    assertEquals((byte) -56, actualSerialiseConfigurationResult[140376]);
    assertEquals((byte) -71, actualSerialiseConfigurationResult[140382]);
    assertEquals((byte) -85, actualSerialiseConfigurationResult[140375]);
    assertEquals((byte) -90, actualSerialiseConfigurationResult[2]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140379]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140385]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140386]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140387]);
    assertEquals(140388, actualSerialiseConfigurationResult.length);
    assertEquals((byte) 17, actualSerialiseConfigurationResult[140383]);
    assertEquals((byte) 18, actualSerialiseConfigurationResult[140384]);
    assertEquals((byte) 1, actualSerialiseConfigurationResult[140378]);
    assertEquals((byte) 5, actualSerialiseConfigurationResult[1]);
    assertEquals('!', actualSerialiseConfigurationResult[3]);
    assertEquals('(', actualSerialiseConfigurationResult[140363]);
    assertEquals(')', actualSerialiseConfigurationResult[140373]);
    assertEquals(',', actualSerialiseConfigurationResult[140371]);
    assertEquals('.', actualSerialiseConfigurationResult[13]);
    assertEquals('.', actualSerialiseConfigurationResult[24]);
    assertEquals('I', actualSerialiseConfigurationResult[140368]);
    assertEquals('J', actualSerialiseConfigurationResult[140364]);
    assertEquals('K', actualSerialiseConfigurationResult[140370]);
    assertEquals('M', actualSerialiseConfigurationResult[140365]);
    assertEquals('M', actualSerialiseConfigurationResult[140367]);
    assertEquals('M', actualSerialiseConfigurationResult[140369]);
    assertEquals('^', actualSerialiseConfigurationResult[140380]);
    assertEquals('a', actualSerialiseConfigurationResult[5]);
    assertEquals('b', actualSerialiseConfigurationResult[Short.SIZE]);
    assertEquals('c', actualSerialiseConfigurationResult[11]);
    assertEquals('d', actualSerialiseConfigurationResult[9]);
    assertEquals('e', actualSerialiseConfigurationResult[12]);
    assertEquals('e', actualSerialiseConfigurationResult[8]);
    assertEquals('h', actualSerialiseConfigurationResult[17]);
    assertEquals('i', actualSerialiseConfigurationResult[18]);
    assertEquals('j', actualSerialiseConfigurationResult[14]);
    assertEquals('m', actualSerialiseConfigurationResult[4]);
    assertEquals('o', actualSerialiseConfigurationResult[15]);
    assertEquals('o', actualSerialiseConfigurationResult[21]);
    assertEquals('p', actualSerialiseConfigurationResult[6]);
    assertEquals('r', actualSerialiseConfigurationResult[22]);
    assertEquals('r', actualSerialiseConfigurationResult[7]);
    assertEquals('s', actualSerialiseConfigurationResult[19]);
    assertEquals('t', actualSerialiseConfigurationResult[20]);
    assertEquals('u', actualSerialiseConfigurationResult[10]);
    assertEquals('y', actualSerialiseConfigurationResult[23]);
  }

  /**
   * Test {@link Utils#deserialiseConfiguration(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link Utils#deserialiseConfiguration(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialiseConfiguration(byte[]); when array of byte with zero and 'X'; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Configuration Utils.deserialiseConfiguration(byte[])"})
  void testDeserialiseConfiguration_whenArrayOfByteWithZeroAndX_thenReturnSizeIsZero()
      throws IOException {
    // Arrange and Act
    Configuration actualDeserialiseConfigurationResult =
        Utils.deserialiseConfiguration(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(0, actualDeserialiseConfigurationResult.size());
    Set<String> finalParameters = actualDeserialiseConfigurationResult.getFinalParameters();
    assertEquals(2, finalParameters.size());
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.attempts"));
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.retry.interval"));
  }
}
