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

package uk.gov.gchq.gaffer.named.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import uk.gov.gchq.gaffer.named.operation.GetAllNamedOperations.Builder;
import uk.gov.gchq.gaffer.named.operation.serialisation.NamedOperationTypeReference;
import uk.gov.gchq.gaffer.named.operation.serialisation.NamedOperationTypeReference.IterableNamedOperationDetail;

class GetAllNamedOperationsDiffblueTest {
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
    GetAllNamedOperations _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<NamedOperationDetail>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableNamedOperationDetail);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        outputType.getTypeName());
    assertNull(_getOpResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetAllNamedOperations actualGetAllNamedOperations = actualBuilder.build();
    assertSame(_getOpResult, actualGetAllNamedOperations);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllNamedOperations#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetAllNamedOperations#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetAllNamedOperations.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<NamedOperationDetail>> actualOutputTypeReference =
        new GetAllNamedOperations().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableNamedOperationDetail);
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetAllNamedOperations#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAllNamedOperations} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllNamedOperations#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAllNamedOperations (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllNamedOperations GetAllNamedOperations.shallowClone()"})
  void testShallowClone_givenGetAllNamedOperations_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetAllNamedOperations actualShallowCloneResult = new GetAllNamedOperations().shallowClone();

    // Assert
    TypeReference<Iterable<NamedOperationDetail>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableNamedOperationDetail);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllNamedOperations#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetAllNamedOperations#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllNamedOperations GetAllNamedOperations.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    GetAllNamedOperations getAllNamedOperations = new GetAllNamedOperations();
    getAllNamedOperations.setOptions(new HashMap<>());

    // Act
    GetAllNamedOperations actualShallowCloneResult = getAllNamedOperations.shallowClone();

    // Assert
    TypeReference<Iterable<NamedOperationDetail>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableNamedOperationDetail);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
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
   *   <li>default or parameterless constructor of {@link GetAllNamedOperations}
   *   <li>{@link GetAllNamedOperations#setOptions(Map)}
   *   <li>{@link GetAllNamedOperations#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAllNamedOperations.<init>()",
    "Map GetAllNamedOperations.getOptions()",
    "void GetAllNamedOperations.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetAllNamedOperations actualGetAllNamedOperations = new GetAllNamedOperations();
    HashMap<String, String> options = new HashMap<>();
    actualGetAllNamedOperations.setOptions(options);
    Map<String, String> actualOptions = actualGetAllNamedOperations.getOptions();

    // Assert
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
