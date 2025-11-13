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

package uk.gov.gchq.gaffer.federated.simple.operation;

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
import java.util.Set;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federated.simple.operation.GetAllGraphIds.Builder;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GetAllGraphIdsDiffblueTest {
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
    GetAllGraphIds _getOpResult = actualBuilder._getOp();
    TypeReference<Set<String>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Set);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.Set<T>", outputType.getTypeName());
    assertNull(_getOpResult.getOptions());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetAllGraphIds actualGetAllGraphIds = actualBuilder.build();
    assertSame(_getOpResult, actualGetAllGraphIds);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllGraphIds#shallowClone()}.
   *
   * <p>Method under test: {@link GetAllGraphIds#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation GetAllGraphIds.shallowClone()"})
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    Operation actualShallowCloneResult = new GetAllGraphIds().shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof GetAllGraphIds);
    TypeReference<Set<String>> outputTypeReference =
        ((GetAllGraphIds) actualShallowCloneResult).getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Set);
    Type outputType = ((GetAllGraphIds) actualShallowCloneResult).getOutputType();
    assertEquals("java.util.Set<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, ((GetAllGraphIds) actualShallowCloneResult).getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllGraphIds#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetAllGraphIds#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetAllGraphIds.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Set<String>> actualOutputTypeReference =
        new GetAllGraphIds().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.Set);
    assertEquals("java.util.Set<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetAllGraphIds}
   *   <li>{@link GetAllGraphIds#setOptions(Map)}
   *   <li>{@link GetAllGraphIds#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAllGraphIds.<init>()",
    "Map GetAllGraphIds.getOptions()",
    "void GetAllGraphIds.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetAllGraphIds actualGetAllGraphIds = new GetAllGraphIds();
    HashMap<String, String> options = new HashMap<>();
    actualGetAllGraphIds.setOptions(options);
    Map<String, String> actualOptions = actualGetAllGraphIds.getOptions();

    // Assert
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
