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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.job.CancelScheduledJob.Builder;

class CancelScheduledJobDiffblueTest {
  /**
   * Test Builder {@link Builder#jobId(String)}.
   * <p>
   * Method under test: {@link Builder#jobId(String)}
   */
  @Test
  @DisplayName("Test Builder jobId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.jobId(String)"})
  void testBuilderJobId() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.jobId("42"));
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    CancelScheduledJob _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getJobId());
    assertNull(_getOpResult.getOptions());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Test {@link CancelScheduledJob#shallowClone()}.
   * <ul>
   *   <li>Given {@link CancelScheduledJob} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelScheduledJob#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given CancelScheduledJob (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CancelScheduledJob CancelScheduledJob.shallowClone()"})
  void testShallowClone_givenCancelScheduledJobOptionsIsHashMap_thenReturnOptionsEmpty() throws CloneFailedException {
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
   * Test {@link CancelScheduledJob#shallowClone()}.
   * <ul>
   *   <li>Given {@link CancelScheduledJob} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelScheduledJob#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given CancelScheduledJob (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CancelScheduledJob CancelScheduledJob.shallowClone()"})
  void testShallowClone_givenCancelScheduledJob_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    CancelScheduledJob actualShallowCloneResult = (new CancelScheduledJob()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CancelScheduledJob.<init>()", "String CancelScheduledJob.getJobId()",
      "Map CancelScheduledJob.getOptions()", "void CancelScheduledJob.setJobId(String)",
      "void CancelScheduledJob.setOptions(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    CancelScheduledJob actualCancelScheduledJob = new CancelScheduledJob();
    actualCancelScheduledJob.setJobId("42");
    HashMap<String, String> options = new HashMap<>();
    actualCancelScheduledJob.setOptions(options);
    String actualJobId = actualCancelScheduledJob.getJobId();
    Map<String, String> actualOptions = actualCancelScheduledJob.getOptions();

    // Assert
    assertEquals("42", actualJobId);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
