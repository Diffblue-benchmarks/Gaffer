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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Set;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UtilsDiffblueTest {
  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   * <ul>
   *   <li>When {@link YarnConfiguration#YarnConfiguration(Configuration)} with conf is {@link Configuration#Configuration()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName("Test serialiseConfiguration(Configuration); when YarnConfiguration(Configuration) with conf is Configuration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] Utils.serialiseConfiguration(Configuration)"})
  void testSerialiseConfiguration_whenYarnConfigurationWithConfIsConfiguration() throws IOException {
    // Arrange and Act
    byte[] actualSerialiseConfigurationResult = Utils
        .serialiseConfiguration(new YarnConfiguration(new Configuration()));

    // Assert
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
    assertEquals('(', actualSerialiseConfigurationResult[140363]);
    assertEquals(')', actualSerialiseConfigurationResult[140373]);
    assertEquals(',', actualSerialiseConfigurationResult[140371]);
    assertEquals('I', actualSerialiseConfigurationResult[140368]);
    assertEquals('J', actualSerialiseConfigurationResult[140364]);
    assertEquals('K', actualSerialiseConfigurationResult[140370]);
    assertEquals('M', actualSerialiseConfigurationResult[140365]);
    assertEquals('M', actualSerialiseConfigurationResult[140367]);
    assertEquals('M', actualSerialiseConfigurationResult[140369]);
    assertEquals('^', actualSerialiseConfigurationResult[140380]);
  }

  /**
   * Test {@link Utils#deserialiseConfiguration(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#deserialiseConfiguration(byte[])}
   */
  @Test
  @DisplayName("Test deserialiseConfiguration(byte[]); when array of byte with zero and 'X'; then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Configuration Utils.deserialiseConfiguration(byte[])"})
  void testDeserialiseConfiguration_whenArrayOfByteWithZeroAndX_thenReturnSizeIsZero() throws IOException {
    // Arrange and Act
    Configuration actualDeserialiseConfigurationResult = Utils
        .deserialiseConfiguration(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(0, actualDeserialiseConfigurationResult.size());
    Set<String> finalParameters = actualDeserialiseConfigurationResult.getFinalParameters();
    assertEquals(2, finalParameters.size());
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.attempts"));
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.retry.interval"));
  }
}
