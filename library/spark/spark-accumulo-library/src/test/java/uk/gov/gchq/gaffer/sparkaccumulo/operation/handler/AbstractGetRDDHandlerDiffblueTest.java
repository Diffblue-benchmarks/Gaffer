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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Set;
import javassist.Loader;
import org.apache.accumulo.core.client.IteratorSetting;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.iterators.SortedKeyValueIterator;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scala.Tuple2;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityIteratorSettingsFactory;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.key.exception.IteratorSettingException;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.graph.GraphFilters;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.spark.operation.javardd.GetJavaRDDOfAllElements;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.AbstractGetRDDHandler.FirstElement;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd.GetJavaRDDOfAllElementsHandler;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.user.User;

class AbstractGetRDDHandlerDiffblueTest {
  /**
   * Test {@link AbstractGetRDDHandler#addIterators(AccumuloStore, Configuration, User, Output)}.
   *
   * <p>Method under test: {@link AbstractGetRDDHandler#addIterators(AccumuloStore, Configuration,
   * User, Output)}
   */
  @Test
  @DisplayName("Test addIterators(AccumuloStore, Configuration, User, Output)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractGetRDDHandler.addIterators(AccumuloStore, Configuration, User, Output)"
  })
  void testAddIterators2() throws IteratorSettingException, OperationException, StoreException {
    // Arrange
    GetJavaRDDOfAllElementsHandler getJavaRDDOfAllElementsHandler =
        new GetJavaRDDOfAllElementsHandler();

    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        mock(ByteEntityIteratorSettingsFactory.class);
    IteratorSettingException iteratorSettingException =
        new IteratorSettingException("An error occurred", new Throwable());
    when(byteEntityIteratorSettingsFactory.getQueryTimeAggregatorIteratorSetting(
            Mockito.<View>any(), Mockito.<AccumuloStore>any()))
        .thenThrow(iteratorSettingException);

    ByteEntityKeyPackage byteEntityKeyPackage = mock(ByteEntityKeyPackage.class);
    when(byteEntityKeyPackage.getIteratorFactory()).thenReturn(byteEntityIteratorSettingsFactory);

    AccumuloStore accumuloStore = mock(AccumuloStore.class);
    when(accumuloStore.getKeyPackage()).thenReturn(byteEntityKeyPackage);
    doNothing()
        .when(accumuloStore)
        .updateConfiguration(
            Mockito.<Configuration>any(), Mockito.<GraphFilters>any(), Mockito.<User>any());
    Configuration conf = new Configuration();
    User user = new User();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            getJavaRDDOfAllElementsHandler.addIterators(
                accumuloStore, conf, user, new GetJavaRDDOfAllElements()));
    verify(accumuloStore).getKeyPackage();
    verify(accumuloStore)
        .updateConfiguration(isA(Configuration.class), isA(GraphFilters.class), isA(User.class));
    verify(byteEntityKeyPackage).getIteratorFactory();
    verify(byteEntityIteratorSettingsFactory)
        .getQueryTimeAggregatorIteratorSetting(isNull(), isA(AccumuloStore.class));
  }

  /**
   * Test {@link AbstractGetRDDHandler#addIterators(AccumuloStore, Configuration, User, Output)}.
   *
   * <ul>
   *   <li>Given {@link StoreException#StoreException(String)} with message is {@code An error
   *       occurred}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGetRDDHandler#addIterators(AccumuloStore, Configuration,
   * User, Output)}
   */
  @Test
  @DisplayName(
      "Test addIterators(AccumuloStore, Configuration, User, Output); given StoreException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractGetRDDHandler.addIterators(AccumuloStore, Configuration, User, Output)"
  })
  void testAddIterators_givenStoreExceptionWithMessageIsAnErrorOccurred()
      throws OperationException, StoreException {
    // Arrange
    GetJavaRDDOfAllElementsHandler getJavaRDDOfAllElementsHandler =
        new GetJavaRDDOfAllElementsHandler();

    AccumuloStore accumuloStore = mock(AccumuloStore.class);
    doThrow(new StoreException("An error occurred"))
        .when(accumuloStore)
        .updateConfiguration(
            Mockito.<Configuration>any(), Mockito.<GraphFilters>any(), Mockito.<User>any());
    Configuration conf = new Configuration();
    User user = new User();

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            getJavaRDDOfAllElementsHandler.addIterators(
                accumuloStore, conf, user, new GetJavaRDDOfAllElements()));
    verify(accumuloStore)
        .updateConfiguration(isA(Configuration.class), isA(GraphFilters.class), isA(User.class));
  }

  /**
   * Test FirstElement {@link FirstElement#apply(Tuple2)} with {@code Tuple2}.
   *
   * <p>Method under test: {@link FirstElement#apply(Tuple2)}
   */
  @Test
  @DisplayName("Test FirstElement apply(Tuple2) with 'Tuple2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element FirstElement.apply(Tuple2)"})
  void testFirstElementApplyWithTuple2() {
    // Arrange
    FirstElement firstElement = new FirstElement();
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    Tuple2<Element, NullWritable> tuple = new Tuple2<>(edge, NullWritable.get());

    // Act
    Element actualApplyResult = firstElement.apply(tuple);

    // Assert
    assertSame(tuple._1, actualApplyResult);
  }

  /**
   * Test {@link AbstractGetRDDHandler#getConfiguration(Output)}.
   *
   * <p>Method under test: {@link AbstractGetRDDHandler#getConfiguration(Output)}
   */
  @Test
  @DisplayName("Test getConfiguration(Output)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.getConfiguration(Output)"})
  void testGetConfiguration() throws OperationException {
    // Arrange
    GetJavaRDDOfAllElementsHandler getJavaRDDOfAllElementsHandler =
        new GetJavaRDDOfAllElementsHandler();

    GetJavaRDDOfAllElements getJavaRDDOfAllElements = new GetJavaRDDOfAllElements();
    getJavaRDDOfAllElements.addOption(
        AbstractGetRDDHandler.HADOOP_CONFIGURATION_KEY,
        AbstractGetRDDHandler.HADOOP_CONFIGURATION_KEY);

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> getJavaRDDOfAllElementsHandler.getConfiguration(getJavaRDDOfAllElements));
  }

  /**
   * Test {@link AbstractGetRDDHandler#getConfiguration(Output)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGetRDDHandler#getConfiguration(Output)}
   */
  @Test
  @DisplayName("Test getConfiguration(Output); given '42'; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.getConfiguration(Output)"})
  void testGetConfiguration_given42_thenReturnSizeIsZero() throws OperationException {
    // Arrange
    GetJavaRDDOfAllElementsHandler getJavaRDDOfAllElementsHandler =
        new GetJavaRDDOfAllElementsHandler();

    GetJavaRDDOfAllElements getJavaRDDOfAllElements = new GetJavaRDDOfAllElements();
    getJavaRDDOfAllElements.addOption(AbstractGetRDDHandler.HADOOP_CONFIGURATION_KEY, "42");

    // Act
    Configuration actualConfiguration =
        getJavaRDDOfAllElementsHandler.getConfiguration(getJavaRDDOfAllElements);

    // Assert
    assertEquals(0, actualConfiguration.size());
    Set<String> finalParameters = actualConfiguration.getFinalParameters();
    assertEquals(2, finalParameters.size());
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.attempts"));
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.retry.interval"));
  }

  /**
   * Test {@link AbstractGetRDDHandler#getConfiguration(Output)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGetRDDHandler#getConfiguration(Output)}
   */
  @Test
  @DisplayName("Test getConfiguration(Output); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.getConfiguration(Output)"})
  void testGetConfiguration_givenEmptyString() throws OperationException {
    // Arrange
    GetJavaRDDOfAllElementsHandler getJavaRDDOfAllElementsHandler =
        new GetJavaRDDOfAllElementsHandler();

    GetJavaRDDOfAllElements getJavaRDDOfAllElements = new GetJavaRDDOfAllElements();
    getJavaRDDOfAllElements.addOption(AbstractGetRDDHandler.HADOOP_CONFIGURATION_KEY, "");

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> getJavaRDDOfAllElementsHandler.getConfiguration(getJavaRDDOfAllElements));
  }

  /**
   * Test {@link AbstractGetRDDHandler#getConfiguration(Output)}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGetRDDHandler#getConfiguration(Output)}
   */
  @Test
  @DisplayName("Test getConfiguration(Output); given 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.getConfiguration(Output)"})
  void testGetConfiguration_givenValue() throws OperationException {
    // Arrange
    GetJavaRDDOfAllElementsHandler getJavaRDDOfAllElementsHandler =
        new GetJavaRDDOfAllElementsHandler();

    GetJavaRDDOfAllElements getJavaRDDOfAllElements = new GetJavaRDDOfAllElements();
    getJavaRDDOfAllElements.addOption(AbstractGetRDDHandler.HADOOP_CONFIGURATION_KEY, "Value");

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> getJavaRDDOfAllElementsHandler.getConfiguration(getJavaRDDOfAllElements));
  }

  /**
   * Test {@link AbstractGetRDDHandler#convertConfigurationToString(Configuration)}.
   *
   * <ul>
   *   <li>When {@link Configuration#Configuration(boolean)} with loadDefaults is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGetRDDHandler#convertConfigurationToString(Configuration)}
   */
  @Test
  @DisplayName(
      "Test convertConfigurationToString(Configuration); when Configuration(boolean) with loadDefaults is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractGetRDDHandler.convertConfigurationToString(Configuration)"})
  void testConvertConfigurationToString_whenConfigurationWithLoadDefaultsIsFalse()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        "AA==", AbstractGetRDDHandler.convertConfigurationToString(new Configuration(false)));
  }

  /**
   * Test {@link AbstractGetRDDHandler#convertStringToConfiguration(String)}.
   *
   * <p>Method under test: {@link AbstractGetRDDHandler#convertStringToConfiguration(String)}
   */
  @Test
  @DisplayName("Test convertStringToConfiguration(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.convertStringToConfiguration(String)"})
  void testConvertStringToConfiguration() throws IOException {
    // Arrange and Act
    Configuration actualConvertStringToConfigurationResult =
        AbstractGetRDDHandler.convertStringToConfiguration(
            "org.apache.accumulo.core.client.mapreduce.AccumuloInputFormat");

    // Assert
    assertEquals(0, actualConvertStringToConfigurationResult.size());
    Set<String> finalParameters = actualConvertStringToConfigurationResult.getFinalParameters();
    assertEquals(2, finalParameters.size());
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.attempts"));
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.retry.interval"));
  }

  /**
   * Test {@link AbstractGetRDDHandler#convertStringToConfiguration(String)}.
   *
   * <ul>
   *   <li>When {@code secret}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGetRDDHandler#convertStringToConfiguration(String)}
   */
  @Test
  @DisplayName("Test convertStringToConfiguration(String); when 'secret'; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.convertStringToConfiguration(String)"})
  void testConvertStringToConfiguration_whenSecret_thenReturnSizeIsZero() throws IOException {
    // Arrange and Act
    Configuration actualConvertStringToConfigurationResult =
        AbstractGetRDDHandler.convertStringToConfiguration("secret");

    // Assert
    assertEquals(0, actualConvertStringToConfigurationResult.size());
    Set<String> finalParameters = actualConvertStringToConfigurationResult.getFinalParameters();
    assertEquals(2, finalParameters.size());
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.attempts"));
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.retry.interval"));
  }

  /**
   * Test {@link AbstractGetRDDHandler#convertStringToConfiguration(String)}.
   *
   * <ul>
   *   <li>When {@code secretsecret}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGetRDDHandler#convertStringToConfiguration(String)}
   */
  @Test
  @DisplayName(
      "Test convertStringToConfiguration(String); when 'secretsecret'; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.convertStringToConfiguration(String)"})
  void testConvertStringToConfiguration_whenSecretsecret_thenReturnSizeIsZero() throws IOException {
    // Arrange and Act
    Configuration actualConvertStringToConfigurationResult =
        AbstractGetRDDHandler.convertStringToConfiguration("secretsecret");

    // Assert
    assertEquals(0, actualConvertStringToConfigurationResult.size());
    Set<String> finalParameters = actualConvertStringToConfigurationResult.getFinalParameters();
    assertEquals(2, finalParameters.size());
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.attempts"));
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.retry.interval"));
  }

  /**
   * Test {@link AbstractGetRDDHandler#convertStringToConfiguration(String)}.
   *
   * <ul>
   *   <li>When {@code GraphFilters}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGetRDDHandler#convertStringToConfiguration(String)}
   */
  @Test
  @DisplayName(
      "Test convertStringToConfiguration(String); when 'uk.gov.gchq.gaffer.operation.graph.GraphFilters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Configuration AbstractGetRDDHandler.convertStringToConfiguration(String)"})
  void testConvertStringToConfiguration_whenUkGovGchqGafferOperationGraphGraphFilters()
      throws IOException {
    // Arrange and Act
    Configuration actualConvertStringToConfigurationResult =
        AbstractGetRDDHandler.convertStringToConfiguration(
            "uk.gov.gchq.gaffer.operation.graph.GraphFilters");

    // Assert
    assertEquals(0, actualConvertStringToConfigurationResult.size());
    Set<String> finalParameters = actualConvertStringToConfigurationResult.getFinalParameters();
    assertEquals(2, finalParameters.size());
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.attempts"));
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.retry.interval"));
  }
}
