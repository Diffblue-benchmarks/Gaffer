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

package uk.gov.gchq.gaffer.hdfs.operation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.apache.hadoop.mapreduce.Partitioner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.hdfs.operation.AddElementsFromHdfs.Builder;
import uk.gov.gchq.gaffer.hdfs.operation.handler.job.initialiser.JobInitialiser;

class AddElementsFromHdfsDiffblueTest {
  /**
   * Test Builder {@link Builder#failurePath(String)}.
   *
   * <p>Method under test: {@link Builder#failurePath(String)}
   */
  @Test
  @DisplayName("Test Builder failurePath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.failurePath(String)"})
  void testBuilderFailurePath() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualFailurePathResult = builder.failurePath("Failure Path");

    // Assert
    assertSame(builder, actualFailurePathResult);
  }

  /**
   * Test Builder {@link Builder#inputMapperPairs(Map)}.
   *
   * <p>Method under test: {@link Builder#inputMapperPairs(Map)}
   */
  @Test
  @DisplayName("Test Builder inputMapperPairs(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inputMapperPairs(Map)"})
  void testBuilderInputMapperPairs() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputMapperPairsResult = builder.inputMapperPairs(new HashMap<>());

    // Assert
    assertSame(builder, actualInputMapperPairsResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    AddElementsFromHdfs _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getPartitioner());
    assertNull(_getOpResult.getMaxMapTasks());
    assertNull(_getOpResult.getMaxReduceTasks());
    assertNull(_getOpResult.getMinMapTasks());
    assertNull(_getOpResult.getMinReduceTasks());
    assertNull(_getOpResult.getNumMapTasks());
    assertNull(_getOpResult.getFailurePath());
    assertNull(_getOpResult.getOutputPath());
    assertNull(_getOpResult.getSplitsFilePath());
    assertNull(_getOpResult.getWorkingPath());
    assertNull(_getOpResult.getCommandLineArgs());
    assertNull(_getOpResult.getInputMapperPairs());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getJobInitialiser());
    assertFalse(_getOpResult.isUseProvidedSplits());
    assertTrue(_getOpResult.isValidate());
    AddElementsFromHdfs actualAddElementsFromHdfs = actualBuilder.build();
    assertSame(_getOpResult, actualAddElementsFromHdfs);
  }

  /**
   * Test Builder {@link Builder#validate(boolean)}.
   *
   * <p>Method under test: {@link Builder#validate(boolean)}
   */
  @Test
  @DisplayName("Test Builder validate(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.validate(boolean)"})
  void testBuilderValidate() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualValidateResult = builder.validate(true);

    // Assert
    assertSame(builder, actualValidateResult);
  }

  /**
   * Test Builder {@link Builder#workingPath(String)}.
   *
   * <p>Method under test: {@link Builder#workingPath(String)}
   */
  @Test
  @DisplayName("Test Builder workingPath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.workingPath(String)"})
  void testBuilderWorkingPath() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualWorkingPathResult = builder.workingPath("Working Path");

    // Assert
    assertSame(builder, actualWorkingPathResult);
  }

  /**
   * Test {@link AddElementsFromHdfs#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddElementsFromHdfs} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromHdfs#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddElementsFromHdfs (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddElementsFromHdfs AddElementsFromHdfs.shallowClone()"})
  void testShallowClone_givenAddElementsFromHdfsOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    AddElementsFromHdfs addElementsFromHdfs = new AddElementsFromHdfs();
    addElementsFromHdfs.setOptions(new HashMap<>());

    // Act
    AddElementsFromHdfs actualShallowCloneResult = addElementsFromHdfs.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getMaxMapTasks());
    assertNull(actualShallowCloneResult.getMinMapTasks());
    assertNull(actualShallowCloneResult.getNumMapTasks());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link AddElementsFromHdfs#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddElementsFromHdfs} (default constructor).
   *   <li>Then return MaxMapTasks is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromHdfs#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddElementsFromHdfs (default constructor); then return MaxMapTasks is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddElementsFromHdfs AddElementsFromHdfs.shallowClone()"})
  void testShallowClone_givenAddElementsFromHdfs_thenReturnMaxMapTasksIsNull() {
    // Arrange and Act
    AddElementsFromHdfs actualShallowCloneResult = new AddElementsFromHdfs().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getMaxMapTasks());
    assertNull(actualShallowCloneResult.getMinMapTasks());
    assertNull(actualShallowCloneResult.getNumMapTasks());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test {@link AddElementsFromHdfs#shallowClone()}.
   *
   * <ul>
   *   <li>Then return MaxMapTasks intValue is three.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromHdfs#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return MaxMapTasks intValue is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddElementsFromHdfs AddElementsFromHdfs.shallowClone()"})
  void testShallowClone_thenReturnMaxMapTasksIntValueIsThree() {
    // Arrange
    AddElementsFromHdfs addElementsFromHdfs = new AddElementsFromHdfs();
    addElementsFromHdfs.setMaxMapTasks(3);

    // Act
    AddElementsFromHdfs actualShallowCloneResult = addElementsFromHdfs.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getMinMapTasks());
    assertNull(actualShallowCloneResult.getNumMapTasks());
    assertNull(actualShallowCloneResult.getOptions());
    assertEquals(3, actualShallowCloneResult.getMaxMapTasks().intValue());
  }

  /**
   * Test {@link AddElementsFromHdfs#shallowClone()}.
   *
   * <ul>
   *   <li>Then return MinMapTasks intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromHdfs#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return MinMapTasks intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddElementsFromHdfs AddElementsFromHdfs.shallowClone()"})
  void testShallowClone_thenReturnMinMapTasksIntValueIsOne() {
    // Arrange
    AddElementsFromHdfs addElementsFromHdfs = new AddElementsFromHdfs();
    addElementsFromHdfs.setMinMapTasks(1);

    // Act
    AddElementsFromHdfs actualShallowCloneResult = addElementsFromHdfs.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getMaxMapTasks());
    assertNull(actualShallowCloneResult.getNumMapTasks());
    assertNull(actualShallowCloneResult.getOptions());
    assertEquals(1, actualShallowCloneResult.getMinMapTasks().intValue());
  }

  /**
   * Test {@link AddElementsFromHdfs#shallowClone()}.
   *
   * <ul>
   *   <li>Then return NumMapTasks intValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromHdfs#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return NumMapTasks intValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddElementsFromHdfs AddElementsFromHdfs.shallowClone()"})
  void testShallowClone_thenReturnNumMapTasksIntValueIsTen() {
    // Arrange
    AddElementsFromHdfs addElementsFromHdfs = new AddElementsFromHdfs();
    addElementsFromHdfs.setNumMapTasks(10);

    // Act
    AddElementsFromHdfs actualShallowCloneResult = addElementsFromHdfs.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getMaxMapTasks());
    assertNull(actualShallowCloneResult.getMinMapTasks());
    assertNull(actualShallowCloneResult.getOptions());
    assertEquals(10, actualShallowCloneResult.getNumMapTasks().intValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AddElementsFromHdfs}
   *   <li>{@link AddElementsFromHdfs#setCommandLineArgs(String[])}
   *   <li>{@link AddElementsFromHdfs#setFailurePath(String)}
   *   <li>{@link AddElementsFromHdfs#setInputMapperPairs(Map)}
   *   <li>{@link AddElementsFromHdfs#setJobInitialiser(JobInitialiser)}
   *   <li>{@link AddElementsFromHdfs#setMaxMapTasks(Integer)}
   *   <li>{@link AddElementsFromHdfs#setMaxReduceTasks(Integer)}
   *   <li>{@link AddElementsFromHdfs#setMinMapTasks(Integer)}
   *   <li>{@link AddElementsFromHdfs#setMinReduceTasks(Integer)}
   *   <li>{@link AddElementsFromHdfs#setNumMapTasks(Integer)}
   *   <li>{@link AddElementsFromHdfs#setOptions(Map)}
   *   <li>{@link AddElementsFromHdfs#setOutputPath(String)}
   *   <li>{@link AddElementsFromHdfs#setPartitioner(Class)}
   *   <li>{@link AddElementsFromHdfs#setSplitsFilePath(String)}
   *   <li>{@link AddElementsFromHdfs#setUseProvidedSplits(boolean)}
   *   <li>{@link AddElementsFromHdfs#setValidate(boolean)}
   *   <li>{@link AddElementsFromHdfs#setWorkingPath(String)}
   *   <li>{@link AddElementsFromHdfs#getCommandLineArgs()}
   *   <li>{@link AddElementsFromHdfs#getFailurePath()}
   *   <li>{@link AddElementsFromHdfs#getInputMapperPairs()}
   *   <li>{@link AddElementsFromHdfs#getJobInitialiser()}
   *   <li>{@link AddElementsFromHdfs#getMaxMapTasks()}
   *   <li>{@link AddElementsFromHdfs#getMaxReduceTasks()}
   *   <li>{@link AddElementsFromHdfs#getMinMapTasks()}
   *   <li>{@link AddElementsFromHdfs#getMinReduceTasks()}
   *   <li>{@link AddElementsFromHdfs#getNumMapTasks()}
   *   <li>{@link AddElementsFromHdfs#getOptions()}
   *   <li>{@link AddElementsFromHdfs#getOutputPath()}
   *   <li>{@link AddElementsFromHdfs#getPartitioner()}
   *   <li>{@link AddElementsFromHdfs#getSplitsFilePath()}
   *   <li>{@link AddElementsFromHdfs#getWorkingPath()}
   *   <li>{@link AddElementsFromHdfs#isUseProvidedSplits()}
   *   <li>{@link AddElementsFromHdfs#isValidate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddElementsFromHdfs.<init>()",
    "String[] AddElementsFromHdfs.getCommandLineArgs()",
    "String AddElementsFromHdfs.getFailurePath()",
    "Map AddElementsFromHdfs.getInputMapperPairs()",
    "JobInitialiser AddElementsFromHdfs.getJobInitialiser()",
    "Integer AddElementsFromHdfs.getMaxMapTasks()",
    "Integer AddElementsFromHdfs.getMaxReduceTasks()",
    "Integer AddElementsFromHdfs.getMinMapTasks()",
    "Integer AddElementsFromHdfs.getMinReduceTasks()",
    "Integer AddElementsFromHdfs.getNumMapTasks()",
    "Map AddElementsFromHdfs.getOptions()",
    "String AddElementsFromHdfs.getOutputPath()",
    "Class AddElementsFromHdfs.getPartitioner()",
    "String AddElementsFromHdfs.getSplitsFilePath()",
    "String AddElementsFromHdfs.getWorkingPath()",
    "boolean AddElementsFromHdfs.isUseProvidedSplits()",
    "boolean AddElementsFromHdfs.isValidate()",
    "void AddElementsFromHdfs.setCommandLineArgs(String[])",
    "void AddElementsFromHdfs.setFailurePath(String)",
    "void AddElementsFromHdfs.setInputMapperPairs(Map)",
    "void AddElementsFromHdfs.setJobInitialiser(JobInitialiser)",
    "void AddElementsFromHdfs.setMaxMapTasks(Integer)",
    "void AddElementsFromHdfs.setMaxReduceTasks(Integer)",
    "void AddElementsFromHdfs.setMinMapTasks(Integer)",
    "void AddElementsFromHdfs.setMinReduceTasks(Integer)",
    "void AddElementsFromHdfs.setNumMapTasks(Integer)",
    "void AddElementsFromHdfs.setOptions(Map)",
    "void AddElementsFromHdfs.setOutputPath(String)",
    "void AddElementsFromHdfs.setPartitioner(Class)",
    "void AddElementsFromHdfs.setSplitsFilePath(String)",
    "void AddElementsFromHdfs.setUseProvidedSplits(boolean)",
    "void AddElementsFromHdfs.setValidate(boolean)",
    "void AddElementsFromHdfs.setWorkingPath(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AddElementsFromHdfs actualAddElementsFromHdfs = new AddElementsFromHdfs();
    String[] commandLineArgs = new String[] {"Command Line Args"};
    actualAddElementsFromHdfs.setCommandLineArgs(commandLineArgs);
    actualAddElementsFromHdfs.setFailurePath("Failure Path");
    HashMap<String, String> inputMapperPairs = new HashMap<>();
    actualAddElementsFromHdfs.setInputMapperPairs(inputMapperPairs);
    JobInitialiser jobInitialiser = mock(JobInitialiser.class);
    actualAddElementsFromHdfs.setJobInitialiser(jobInitialiser);
    actualAddElementsFromHdfs.setMaxMapTasks(3);
    actualAddElementsFromHdfs.setMaxReduceTasks(3);
    actualAddElementsFromHdfs.setMinMapTasks(1);
    actualAddElementsFromHdfs.setMinReduceTasks(1);
    actualAddElementsFromHdfs.setNumMapTasks(10);
    HashMap<String, String> options = new HashMap<>();
    actualAddElementsFromHdfs.setOptions(options);
    actualAddElementsFromHdfs.setOutputPath("Output Path");
    Class<Partitioner> partitioner = Partitioner.class;
    actualAddElementsFromHdfs.setPartitioner(partitioner);
    actualAddElementsFromHdfs.setSplitsFilePath("/directory/foo.txt");
    actualAddElementsFromHdfs.setUseProvidedSplits(true);
    actualAddElementsFromHdfs.setValidate(true);
    actualAddElementsFromHdfs.setWorkingPath("Working Path");
    String[] actualCommandLineArgs = actualAddElementsFromHdfs.getCommandLineArgs();
    String actualFailurePath = actualAddElementsFromHdfs.getFailurePath();
    Map<String, String> actualInputMapperPairs = actualAddElementsFromHdfs.getInputMapperPairs();
    JobInitialiser actualJobInitialiser = actualAddElementsFromHdfs.getJobInitialiser();
    Integer actualMaxMapTasks = actualAddElementsFromHdfs.getMaxMapTasks();
    Integer actualMaxReduceTasks = actualAddElementsFromHdfs.getMaxReduceTasks();
    Integer actualMinMapTasks = actualAddElementsFromHdfs.getMinMapTasks();
    Integer actualMinReduceTasks = actualAddElementsFromHdfs.getMinReduceTasks();
    Integer actualNumMapTasks = actualAddElementsFromHdfs.getNumMapTasks();
    Map<String, String> actualOptions = actualAddElementsFromHdfs.getOptions();
    String actualOutputPath = actualAddElementsFromHdfs.getOutputPath();
    Class<? extends Partitioner> actualPartitioner = actualAddElementsFromHdfs.getPartitioner();
    String actualSplitsFilePath = actualAddElementsFromHdfs.getSplitsFilePath();
    String actualWorkingPath = actualAddElementsFromHdfs.getWorkingPath();
    boolean actualIsUseProvidedSplitsResult = actualAddElementsFromHdfs.isUseProvidedSplits();
    boolean actualIsValidateResult = actualAddElementsFromHdfs.isValidate();

    // Assert
    assertEquals("/directory/foo.txt", actualSplitsFilePath);
    assertEquals("Failure Path", actualFailurePath);
    assertEquals("Output Path", actualOutputPath);
    assertEquals("Working Path", actualWorkingPath);
    assertEquals(1, actualMinMapTasks.intValue());
    assertEquals(1, actualMinReduceTasks.intValue());
    assertEquals(10, actualNumMapTasks.intValue());
    assertEquals(3, actualMaxMapTasks.intValue());
    assertEquals(3, actualMaxReduceTasks.intValue());
    assertTrue(actualInputMapperPairs.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsUseProvidedSplitsResult);
    assertTrue(actualIsValidateResult);
    Class<Partitioner> expectedPartitioner = Partitioner.class;
    assertEquals(expectedPartitioner, actualPartitioner);
    assertSame(inputMapperPairs, actualInputMapperPairs);
    assertSame(options, actualOptions);
    assertSame(partitioner, actualPartitioner);
    assertSame(commandLineArgs, actualCommandLineArgs);
    assertSame(jobInitialiser, actualJobInitialiser);
    assertArrayEquals(new String[] {"Command Line Args"}, actualCommandLineArgs);
  }
}
