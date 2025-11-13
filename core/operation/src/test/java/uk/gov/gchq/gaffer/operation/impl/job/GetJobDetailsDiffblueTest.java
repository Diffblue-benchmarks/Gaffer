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
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.jobtracker.JobDetail;
import uk.gov.gchq.gaffer.operation.impl.job.GetJobDetails.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GetJobDetailsDiffblueTest {
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
    GetJobDetails _getOpResult = actualBuilder._getOp();
    TypeReference<JobDetail> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.JobDetail);
    assertNull(_getOpResult.getJobId());
    assertNull(_getOpResult.getOptions());
    Class<JobDetail> expectedOutputClass = JobDetail.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test {@link GetJobDetails#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link GetJobDetails#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference GetJobDetails.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue((new GetJobDetails()).getOutputTypeReference() instanceof TypeReferenceImpl.JobDetail);
  }

  /**
   * Test {@link GetJobDetails#shallowClone()}.
   * <ul>
   *   <li>Given {@link GetJobDetails} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetJobDetails#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetJobDetails (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetJobDetails GetJobDetails.shallowClone()"})
  void testShallowClone_givenGetJobDetailsOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    GetJobDetails getJobDetails = new GetJobDetails();
    getJobDetails.setOptions(new HashMap<>());

    // Act
    GetJobDetails actualShallowCloneResult = getJobDetails.shallowClone();

    // Assert
    TypeReference<JobDetail> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.JobDetail);
    assertNull(actualShallowCloneResult.getJobId());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<JobDetail> expectedOutputClass = JobDetail.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link GetJobDetails#shallowClone()}.
   * <ul>
   *   <li>Given {@link GetJobDetails} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetJobDetails#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetJobDetails (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetJobDetails GetJobDetails.shallowClone()"})
  void testShallowClone_givenGetJobDetails_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetJobDetails actualShallowCloneResult = (new GetJobDetails()).shallowClone();

    // Assert
    TypeReference<JobDetail> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.JobDetail);
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getOptions());
    Class<JobDetail> expectedOutputClass = JobDetail.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetJobDetails}
   *   <li>{@link GetJobDetails#setJobId(String)}
   *   <li>{@link GetJobDetails#setOptions(Map)}
   *   <li>{@link GetJobDetails#getJobId()}
   *   <li>{@link GetJobDetails#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetJobDetails.<init>()", "String GetJobDetails.getJobId()", "Map GetJobDetails.getOptions()",
      "void GetJobDetails.setJobId(String)", "void GetJobDetails.setOptions(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    GetJobDetails actualGetJobDetails = new GetJobDetails();
    actualGetJobDetails.setJobId("42");
    HashMap<String, String> options = new HashMap<>();
    actualGetJobDetails.setOptions(options);
    String actualJobId = actualGetJobDetails.getJobId();
    Map<String, String> actualOptions = actualGetJobDetails.getOptions();

    // Assert
    assertEquals("42", actualJobId);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
