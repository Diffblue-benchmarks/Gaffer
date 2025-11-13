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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.job.GetJobResults.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableObj;

class GetJobResultsDiffblueTest {
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
    GetJobResults _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(_getOpResult.getJobId());
    assertNull(_getOpResult.getKey());
    assertNull(_getOpResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetJobResults actualGetJobResults = actualBuilder.build();
    assertSame(_getOpResult, actualGetJobResults);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetJobResults#setKey(String)}.
   *
   * <ul>
   *   <li>When {@code ALL}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link GetJobResults#setKey(String)}
   */
  @Test
  @DisplayName("Test setKey(String); when 'ALL'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetJobResults.setKey(String)"})
  void testSetKey_whenAll_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new GetJobResults().setKey("ALL"));
  }

  /**
   * Test {@link GetJobResults#setKey(String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GetJobResults#setKey(String)}
   */
  @Test
  @DisplayName("Test setKey(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetJobResults.setKey(String)"})
  void testSetKey_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GetJobResults().setKey("Key"));
  }

  /**
   * Test {@link GetJobResults#setKey(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link GetJobResults#setKey(String)}
   */
  @Test
  @DisplayName("Test setKey(String); when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetJobResults.setKey(String)"})
  void testSetKey_whenNull_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new GetJobResults().setKey(null));
  }

  /**
   * Test {@link GetJobResults#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetJobResults} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetJobResults#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetJobResults (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetJobResults GetJobResults.shallowClone()"})
  void testShallowClone_givenGetJobResultsOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    GetJobResults getJobResults = new GetJobResults();
    getJobResults.setOptions(new HashMap<>());

    // Act
    GetJobResults actualShallowCloneResult = getJobResults.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getKey());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetJobResults#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetJobResults} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetJobResults#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetJobResults (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetJobResults GetJobResults.shallowClone()"})
  void testShallowClone_givenGetJobResults_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetJobResults actualShallowCloneResult = new GetJobResults().shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetJobResults}
   *   <li>{@link GetJobResults#setOptions(Map)}
   *   <li>{@link GetJobResults#getKey()}
   *   <li>{@link GetJobResults#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetJobResults.<init>()",
    "String GetJobResults.getKey()",
    "Map GetJobResults.getOptions()",
    "void GetJobResults.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetJobResults actualGetJobResults = new GetJobResults();
    HashMap<String, String> options = new HashMap<>();
    actualGetJobResults.setOptions(options);
    String actualKey = actualGetJobResults.getKey();
    Map<String, String> actualOptions = actualGetJobResults.getOptions();

    // Assert
    assertNull(actualGetJobResults.getJobId());
    assertNull(actualKey);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
