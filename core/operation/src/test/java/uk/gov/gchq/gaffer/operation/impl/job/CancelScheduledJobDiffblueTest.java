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

package uk.gov.gchq.gaffer.operation.impl.job;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;

class CancelScheduledJobDiffblueTest {
  /**
   * Method under test: {@link CancelScheduledJob.Builder#jobId(String)}
   */
  @Test
  void testBuilderJobId() {
    // Arrange
    CancelScheduledJob.Builder builder = new CancelScheduledJob.Builder();

    // Act and Assert
    assertSame(builder, builder.jobId("42"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link CancelScheduledJob.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    CancelScheduledJob.Builder actualBuilder = new CancelScheduledJob.Builder();

    // Assert
    CancelScheduledJob _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getJobId());
    assertNull(_getOpResult.getOptions());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CancelScheduledJob}
   *   <li>{@link CancelScheduledJob#setJobId(String)}
   *   <li>{@link CancelScheduledJob#setOptions(Map)}
   *   <li>{@link CancelScheduledJob#getJobId()}
   *   <li>{@link CancelScheduledJob#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CancelScheduledJob actualCancelScheduledJob = new CancelScheduledJob();
    actualCancelScheduledJob.setJobId("42");
    HashMap<String, String> options = new HashMap<>();
    actualCancelScheduledJob.setOptions(options);
    String actualJobId = actualCancelScheduledJob.getJobId();
    Map<String, String> actualOptions = actualCancelScheduledJob.getOptions();

    // Assert that nothing has changed
    assertEquals("42", actualJobId);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }

  /**
   * Method under test: {@link CancelScheduledJob#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    CancelScheduledJob actualShallowCloneResult = (new CancelScheduledJob()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Method under test: {@link CancelScheduledJob#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    CancelScheduledJob cancelScheduledJob = new CancelScheduledJob();
    cancelScheduledJob.setOptions(new HashMap<>());

    // Act
    CancelScheduledJob actualShallowCloneResult = cancelScheduledJob.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getJobId());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Method under test: {@link CancelScheduledJob#shallowClone()}
   */
  @Test
  void testShallowClone3() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    CancelScheduledJob cancelScheduledJob = new CancelScheduledJob();
    cancelScheduledJob.setOptions(options);

    // Act
    CancelScheduledJob actualShallowCloneResult = cancelScheduledJob.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getJobId());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }
}
