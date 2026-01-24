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

package uk.gov.gchq.gaffer.hdfs.operation.handler.job.tool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.hdfs.operation.SampleDataForSplitPoints;
import uk.gov.gchq.gaffer.hdfs.operation.handler.job.factory.SampleDataForSplitPointsJobFactory;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class SampleDataAndCreateSplitsFileToolDiffblueTest {
  /**
   * Test {@link
   * SampleDataAndCreateSplitsFileTool#SampleDataAndCreateSplitsFileTool(SampleDataForSplitPointsJobFactory,
   * SampleDataForSplitPoints, Store)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link
   * SampleDataAndCreateSplitsFileTool#SampleDataAndCreateSplitsFileTool(SampleDataForSplitPointsJobFactory,
   * SampleDataForSplitPoints, Store)}
   */
  @Test
  @DisplayName(
      "Test new SampleDataAndCreateSplitsFileTool(SampleDataForSplitPointsJobFactory, SampleDataForSplitPoints, Store); given one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SampleDataAndCreateSplitsFileTool.<init>(SampleDataForSplitPointsJobFactory, SampleDataForSplitPoints, Store)"
  })
  void testNewSampleDataAndCreateSplitsFileTool_givenOne() {
    // Arrange
    SampleDataForSplitPointsJobFactory jobFactory = mock(SampleDataForSplitPointsJobFactory.class);

    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    operation.setNumSplits(1);

    // Act
    SampleDataAndCreateSplitsFileTool actualSampleDataAndCreateSplitsFileTool =
        new SampleDataAndCreateSplitsFileTool(
            jobFactory, operation, new TestAddToGraphLibraryImpl());

    // Assert
    assertNull(actualSampleDataAndCreateSplitsFileTool.getConf());
  }

  /**
   * Test {@link
   * SampleDataAndCreateSplitsFileTool#SampleDataAndCreateSplitsFileTool(SampleDataForSplitPointsJobFactory,
   * SampleDataForSplitPoints, Store)}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * SampleDataAndCreateSplitsFileTool#SampleDataAndCreateSplitsFileTool(SampleDataForSplitPointsJobFactory,
   * SampleDataForSplitPoints, Store)}
   */
  @Test
  @DisplayName(
      "Test new SampleDataAndCreateSplitsFileTool(SampleDataForSplitPointsJobFactory, SampleDataForSplitPoints, Store); given zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SampleDataAndCreateSplitsFileTool.<init>(SampleDataForSplitPointsJobFactory, SampleDataForSplitPoints, Store)"
  })
  void testNewSampleDataAndCreateSplitsFileTool_givenZero() {
    // Arrange
    SampleDataForSplitPointsJobFactory jobFactory = mock(SampleDataForSplitPointsJobFactory.class);
    when(jobFactory.getExpectedNumberOfSplits(Mockito.<Store>any())).thenReturn(10);

    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();
    operation.setNumSplits(0);

    // Act
    SampleDataAndCreateSplitsFileTool actualSampleDataAndCreateSplitsFileTool =
        new SampleDataAndCreateSplitsFileTool(
            jobFactory, operation, new TestAddToGraphLibraryImpl());

    // Assert
    verify(jobFactory).getExpectedNumberOfSplits(isA(Store.class));
    assertNull(actualSampleDataAndCreateSplitsFileTool.getConf());
  }

  /**
   * Test {@link
   * SampleDataAndCreateSplitsFileTool#SampleDataAndCreateSplitsFileTool(SampleDataForSplitPointsJobFactory,
   * SampleDataForSplitPoints, Store)}.
   *
   * <ul>
   *   <li>When {@link SampleDataForSplitPoints} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SampleDataAndCreateSplitsFileTool#SampleDataAndCreateSplitsFileTool(SampleDataForSplitPointsJobFactory,
   * SampleDataForSplitPoints, Store)}
   */
  @Test
  @DisplayName(
      "Test new SampleDataAndCreateSplitsFileTool(SampleDataForSplitPointsJobFactory, SampleDataForSplitPoints, Store); when SampleDataForSplitPoints (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SampleDataAndCreateSplitsFileTool.<init>(SampleDataForSplitPointsJobFactory, SampleDataForSplitPoints, Store)"
  })
  void testNewSampleDataAndCreateSplitsFileTool_whenSampleDataForSplitPoints() {
    // Arrange
    SampleDataForSplitPointsJobFactory jobFactory = mock(SampleDataForSplitPointsJobFactory.class);
    when(jobFactory.getExpectedNumberOfSplits(Mockito.<Store>any())).thenReturn(10);
    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();

    // Act
    SampleDataAndCreateSplitsFileTool actualSampleDataAndCreateSplitsFileTool =
        new SampleDataAndCreateSplitsFileTool(
            jobFactory, operation, new TestAddToGraphLibraryImpl());

    // Assert
    verify(jobFactory).getExpectedNumberOfSplits(isA(Store.class));
    assertNull(actualSampleDataAndCreateSplitsFileTool.getConf());
  }

  /**
   * Test {@link SampleDataAndCreateSplitsFileTool#run(String[])}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SampleDataAndCreateSplitsFileTool#run(String[])}
   */
  @Test
  @DisplayName("Test run(String[]); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SampleDataAndCreateSplitsFileTool.run(String[])"})
  void testRun_thenReturnOne() throws IOException, OperationException {
    // Arrange
    SampleDataForSplitPointsJobFactory jobFactory = mock(SampleDataForSplitPointsJobFactory.class);
    when(jobFactory.getExpectedNumberOfSplits(Mockito.<Store>any())).thenReturn(10);
    when(jobFactory.createJobs(Mockito.<SampleDataForSplitPoints>any(), Mockito.<Store>any()))
        .thenReturn(new ArrayList<>());
    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();

    SampleDataAndCreateSplitsFileTool sampleDataAndCreateSplitsFileTool =
        new SampleDataAndCreateSplitsFileTool(
            jobFactory, operation, new TestAddToGraphLibraryImpl());

    // Act
    int actualRunResult = sampleDataAndCreateSplitsFileTool.run(new String[] {"Strings"});

    // Assert
    verify(jobFactory).createJobs(isA(SampleDataForSplitPoints.class), isA(Store.class));
    verify(jobFactory).getExpectedNumberOfSplits(isA(Store.class));
    assertEquals(1, actualRunResult);
  }

  /**
   * Test {@link SampleDataAndCreateSplitsFileTool#run(String[])}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link SampleDataAndCreateSplitsFileTool#run(String[])}
   */
  @Test
  @DisplayName("Test run(String[]); then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SampleDataAndCreateSplitsFileTool.run(String[])"})
  void testRun_thenThrowOperationException() throws IOException, OperationException {
    // Arrange
    SampleDataForSplitPointsJobFactory jobFactory = mock(SampleDataForSplitPointsJobFactory.class);
    when(jobFactory.getExpectedNumberOfSplits(Mockito.<Store>any())).thenReturn(10);
    when(jobFactory.createJobs(Mockito.<SampleDataForSplitPoints>any(), Mockito.<Store>any()))
        .thenThrow(new IOException());
    SampleDataForSplitPoints operation = new SampleDataForSplitPoints();

    SampleDataAndCreateSplitsFileTool sampleDataAndCreateSplitsFileTool =
        new SampleDataAndCreateSplitsFileTool(
            jobFactory, operation, new TestAddToGraphLibraryImpl());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> sampleDataAndCreateSplitsFileTool.run(new String[] {"Strings"}));
    verify(jobFactory).createJobs(isA(SampleDataForSplitPoints.class), isA(Store.class));
    verify(jobFactory).getExpectedNumberOfSplits(isA(Store.class));
  }
}
