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

package uk.gov.gchq.gaffer.hdfs.operation.handler.job.tool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.hdfs.operation.AddElementsFromHdfs;
import uk.gov.gchq.gaffer.hdfs.operation.handler.job.factory.AddElementsFromHdfsJobFactory;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;

class AddElementsFromHdfsToolDiffblueTest {
  /**
   * Test {@link AddElementsFromHdfsTool#run(String[])}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromHdfsTool#run(String[])}
   */
  @Test
  @DisplayName("Test run(String[]); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AddElementsFromHdfsTool.run(String[])"})
  void testRun_thenReturnOne() throws Exception {
    // Arrange
    AddElementsFromHdfsJobFactory jobFactory = mock(AddElementsFromHdfsJobFactory.class);
    doNothing().when(jobFactory).prepareStore(Mockito.<Store>any());
    when(jobFactory.createJobs(Mockito.<AddElementsFromHdfs>any(), Mockito.<Store>any()))
        .thenReturn(new ArrayList<>());
    AddElementsFromHdfs operation = new AddElementsFromHdfs();

    AddElementsFromHdfsTool addElementsFromHdfsTool =
        new AddElementsFromHdfsTool(jobFactory, operation, new TestAddToGraphLibraryImpl());

    // Act
    int actualRunResult = addElementsFromHdfsTool.run(new String[] {"Strings"});

    // Assert
    verify(jobFactory).prepareStore(isA(Store.class));
    verify(jobFactory).createJobs(isA(AddElementsFromHdfs.class), isA(Store.class));
    assertEquals(1, actualRunResult);
  }
}
