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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Set;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.NullWritable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import scala.Tuple2;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.spark.operation.javardd.GetJavaRDDOfAllElements;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.AbstractGetRDDHandler.FirstElement;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd.GetJavaRDDOfAllElementsHandler;

class AbstractGetRDDHandlerDiffblueTest {
  /**
   * Test FirstElement {@link FirstElement#apply(Tuple2)} with {@code Tuple2}.
   * <ul>
   *   <li>Then return {@link Tuple2#Tuple2(Object, Object)} with _1 is {@link Edge#Edge(String)} and _2 is {@link NullWritable#get()} {@link Tuple2#_1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirstElement#apply(Tuple2)}
   */
  @Test
  @DisplayName("Test FirstElement apply(Tuple2) with 'Tuple2'; then return Tuple2(Object, Object) with _1 is Edge(String) and _2 is get() _1")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element FirstElement.apply(Tuple2)"})
  void testFirstElementApplyWithTuple2_thenReturnTuple2With_1IsEdgeAnd_2IsGet_1() {
    // Arrange
    FirstElement firstElement = new FirstElement();
    Edge edge = new Edge("Group");
    Tuple2<Element, NullWritable> tuple = new Tuple2<>(edge, NullWritable.get());

    // Act and Assert
    assertSame(tuple._1, firstElement.apply(tuple));
  }

  /**
   * Test {@link AbstractGetRDDHandler#getConfiguration(Output)}.
   * <p>
   * Method under test: {@link AbstractGetRDDHandler#getConfiguration(Output)}
   */
  @Test
  @DisplayName("Test getConfiguration(Output)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.getConfiguration(Output)"})
  void testGetConfiguration() throws OperationException {
    // Arrange
    GetJavaRDDOfAllElementsHandler getJavaRDDOfAllElementsHandler = new GetJavaRDDOfAllElementsHandler();

    GetJavaRDDOfAllElements getJavaRDDOfAllElements = new GetJavaRDDOfAllElements();
    getJavaRDDOfAllElements.addOption(AbstractGetRDDHandler.HADOOP_CONFIGURATION_KEY,
        AbstractGetRDDHandler.HADOOP_CONFIGURATION_KEY);

    // Act and Assert
    assertThrows(OperationException.class,
        () -> getJavaRDDOfAllElementsHandler.getConfiguration(getJavaRDDOfAllElements));
  }

  /**
   * Test {@link AbstractGetRDDHandler#getConfiguration(Output)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGetRDDHandler#getConfiguration(Output)}
   */
  @Test
  @DisplayName("Test getConfiguration(Output); given '42'; then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.getConfiguration(Output)"})
  void testGetConfiguration_given42_thenReturnSizeIsZero() throws OperationException {
    // Arrange
    GetJavaRDDOfAllElementsHandler getJavaRDDOfAllElementsHandler = new GetJavaRDDOfAllElementsHandler();

    GetJavaRDDOfAllElements getJavaRDDOfAllElements = new GetJavaRDDOfAllElements();
    getJavaRDDOfAllElements.addOption(AbstractGetRDDHandler.HADOOP_CONFIGURATION_KEY, "42");

    // Act
    Configuration actualConfiguration = getJavaRDDOfAllElementsHandler.getConfiguration(getJavaRDDOfAllElements);

    // Assert
    assertEquals(0, actualConfiguration.size());
    Set<String> finalParameters = actualConfiguration.getFinalParameters();
    assertEquals(2, finalParameters.size());
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.attempts"));
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.retry.interval"));
  }

  /**
   * Test {@link AbstractGetRDDHandler#getConfiguration(Output)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGetRDDHandler#getConfiguration(Output)}
   */
  @Test
  @DisplayName("Test getConfiguration(Output); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.getConfiguration(Output)"})
  void testGetConfiguration_givenEmptyString() throws OperationException {
    // Arrange
    GetJavaRDDOfAllElementsHandler getJavaRDDOfAllElementsHandler = new GetJavaRDDOfAllElementsHandler();

    GetJavaRDDOfAllElements getJavaRDDOfAllElements = new GetJavaRDDOfAllElements();
    getJavaRDDOfAllElements.addOption(AbstractGetRDDHandler.HADOOP_CONFIGURATION_KEY, "");

    // Act and Assert
    assertThrows(OperationException.class,
        () -> getJavaRDDOfAllElementsHandler.getConfiguration(getJavaRDDOfAllElements));
  }

  /**
   * Test {@link AbstractGetRDDHandler#getConfiguration(Output)}.
   * <ul>
   *   <li>Given {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGetRDDHandler#getConfiguration(Output)}
   */
  @Test
  @DisplayName("Test getConfiguration(Output); given 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.getConfiguration(Output)"})
  void testGetConfiguration_givenValue() throws OperationException {
    // Arrange
    GetJavaRDDOfAllElementsHandler getJavaRDDOfAllElementsHandler = new GetJavaRDDOfAllElementsHandler();

    GetJavaRDDOfAllElements getJavaRDDOfAllElements = new GetJavaRDDOfAllElements();
    getJavaRDDOfAllElements.addOption(AbstractGetRDDHandler.HADOOP_CONFIGURATION_KEY, "Value");

    // Act and Assert
    assertThrows(OperationException.class,
        () -> getJavaRDDOfAllElementsHandler.getConfiguration(getJavaRDDOfAllElements));
  }

  /**
   * Test {@link AbstractGetRDDHandler#convertStringToConfiguration(String)}.
   * <ul>
   *   <li>When {@code secret}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGetRDDHandler#convertStringToConfiguration(String)}
   */
  @Test
  @DisplayName("Test convertStringToConfiguration(String); when 'secret'; then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.convertStringToConfiguration(String)"})
  void testConvertStringToConfiguration_whenSecret_thenReturnSizeIsZero() throws IOException {
    // Arrange and Act
    Configuration actualConvertStringToConfigurationResult = AbstractGetRDDHandler
        .convertStringToConfiguration("secret");

    // Assert
    assertEquals(0, actualConvertStringToConfigurationResult.size());
    Set<String> finalParameters = actualConvertStringToConfigurationResult.getFinalParameters();
    assertEquals(2, finalParameters.size());
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.attempts"));
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.retry.interval"));
  }

  /**
   * Test {@link AbstractGetRDDHandler#convertStringToConfiguration(String)}.
   * <ul>
   *   <li>When {@code uk.gov.gchq.gaffer.operation.graph.GraphFilters}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGetRDDHandler#convertStringToConfiguration(String)}
   */
  @Test
  @DisplayName("Test convertStringToConfiguration(String); when 'uk.gov.gchq.gaffer.operation.graph.GraphFilters'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.convertStringToConfiguration(String)"})
  void testConvertStringToConfiguration_whenUkGovGchqGafferOperationGraphGraphFilters() throws IOException {
    // Arrange and Act
    Configuration actualConvertStringToConfigurationResult = AbstractGetRDDHandler
        .convertStringToConfiguration("uk.gov.gchq.gaffer.operation.graph.GraphFilters");

    // Assert
    assertEquals(0, actualConvertStringToConfigurationResult.size());
    Set<String> finalParameters = actualConvertStringToConfigurationResult.getFinalParameters();
    assertEquals(2, finalParameters.size());
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.attempts"));
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.retry.interval"));
  }
}
