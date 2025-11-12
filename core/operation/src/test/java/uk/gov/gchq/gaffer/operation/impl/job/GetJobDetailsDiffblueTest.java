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
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.jobtracker.JobDetail;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GetJobDetailsDiffblueTest {
  /**
   * Method under test: {@link GetJobDetails.Builder#jobId(String)}
   */
  @Test
  void testBuilderJobId() {
    // Arrange
    GetJobDetails.Builder builder = new GetJobDetails.Builder();

    // Act and Assert
    assertSame(builder, builder.jobId("42"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link GetJobDetails.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    GetJobDetails.Builder actualBuilder = new GetJobDetails.Builder();

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
   * Method under test: {@link GetJobDetails#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue((new GetJobDetails()).getOutputTypeReference() instanceof TypeReferenceImpl.JobDetail);
  }

  /**
   * Method under test: {@link GetJobDetails#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetJobDetails getJobDetails = new GetJobDetails();
    getJobDetails.setOptions(options);

    // Act and Assert
    assertTrue(getJobDetails.getOutputTypeReference() instanceof TypeReferenceImpl.JobDetail);
  }

  /**
   * Method under test: {@link GetJobDetails#shallowClone()}
   */
  @Test
  void testShallowClone() {
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
   * Method under test: {@link GetJobDetails#shallowClone()}
   */
  @Test
  void testShallowClone2() {
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
   * Method under test: {@link GetJobDetails#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetJobDetails getJobDetails = new GetJobDetails();
    getJobDetails.setOptions(options);

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
  void testGettersAndSetters() {
    // Arrange and Act
    GetJobDetails actualGetJobDetails = new GetJobDetails();
    actualGetJobDetails.setJobId("42");
    HashMap<String, String> options = new HashMap<>();
    actualGetJobDetails.setOptions(options);
    String actualJobId = actualGetJobDetails.getJobId();
    Map<String, String> actualOptions = actualGetJobDetails.getOptions();

    // Assert that nothing has changed
    assertEquals("42", actualJobId);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
