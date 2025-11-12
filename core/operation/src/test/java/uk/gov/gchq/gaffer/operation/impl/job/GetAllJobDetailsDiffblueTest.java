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
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.jobtracker.JobDetail;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GetAllJobDetailsDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link GetAllJobDetails.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    GetAllJobDetails.Builder actualBuilder = new GetAllJobDetails.Builder();

    // Assert
    GetAllJobDetails _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<JobDetail>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.JobDetailIterable);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.jobtracker.JobDetail>", outputType.getTypeName());
    assertNull(_getOpResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetAllJobDetails#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<JobDetail>> actualOutputTypeReference = (new GetAllJobDetails()).getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.JobDetailIterable);
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.jobtracker.JobDetail>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link GetAllJobDetails#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetAllJobDetails getAllJobDetails = new GetAllJobDetails();
    getAllJobDetails.setOptions(options);

    // Act
    TypeReference<Iterable<JobDetail>> actualOutputTypeReference = getAllJobDetails.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.JobDetailIterable);
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.jobtracker.JobDetail>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link GetAllJobDetails#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange and Act
    GetAllJobDetails actualShallowCloneResult = (new GetAllJobDetails()).shallowClone();

    // Assert
    TypeReference<Iterable<JobDetail>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.JobDetailIterable);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.jobtracker.JobDetail>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetAllJobDetails#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    GetAllJobDetails getAllJobDetails = new GetAllJobDetails();
    getAllJobDetails.setOptions(new HashMap<>());

    // Act
    GetAllJobDetails actualShallowCloneResult = getAllJobDetails.shallowClone();

    // Assert
    TypeReference<Iterable<JobDetail>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.JobDetailIterable);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.jobtracker.JobDetail>", outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetAllJobDetails#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetAllJobDetails getAllJobDetails = new GetAllJobDetails();
    getAllJobDetails.setOptions(options);

    // Act
    GetAllJobDetails actualShallowCloneResult = getAllJobDetails.shallowClone();

    // Assert
    TypeReference<Iterable<JobDetail>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.JobDetailIterable);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.jobtracker.JobDetail>", outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetAllJobDetails}
   *   <li>{@link GetAllJobDetails#setOptions(Map)}
   *   <li>{@link GetAllJobDetails#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GetAllJobDetails actualGetAllJobDetails = new GetAllJobDetails();
    HashMap<String, String> options = new HashMap<>();
    actualGetAllJobDetails.setOptions(options);
    Map<String, String> actualOptions = actualGetAllJobDetails.getOptions();

    // Assert that nothing has changed
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
