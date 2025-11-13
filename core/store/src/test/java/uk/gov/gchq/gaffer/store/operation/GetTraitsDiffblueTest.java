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

package uk.gov.gchq.gaffer.store.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl.StoreTraits;
import uk.gov.gchq.gaffer.store.operation.GetTraits.Builder;

class GetTraitsDiffblueTest {
  /**
   * Test Builder {@link Builder#currentTraits(boolean)}.
   * <p>
   * Method under test: {@link Builder#currentTraits(boolean)}
   */
  @Test
  @DisplayName("Test Builder currentTraits(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.currentTraits(boolean)"})
  void testBuilderCurrentTraits() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.currentTraits(true));
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
    GetTraits _getOpResult = actualBuilder._getOp();
    TypeReference<Set<StoreTrait>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof StoreTraits);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.Set<uk.gov.gchq.gaffer.store.StoreTrait>", outputType.getTypeName());
    assertTrue(_getOpResult.getOptions().isEmpty());
    assertTrue(_getOpResult.isCurrentTraits());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetTraits#shallowClone()}.
   * <p>
   * Method under test: {@link GetTraits#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetTraits GetTraits.shallowClone()"})
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    GetTraits actualShallowCloneResult = (new GetTraits()).shallowClone();

    // Assert
    TypeReference<Set<StoreTrait>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof StoreTraits);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Set<uk.gov.gchq.gaffer.store.StoreTrait>", outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.isCurrentTraits());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetTraits#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link GetTraits#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference GetTraits.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Set<StoreTrait>> actualOutputTypeReference = (new GetTraits()).getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof StoreTraits);
    assertEquals("java.util.Set<uk.gov.gchq.gaffer.store.StoreTrait>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetTraits}
   *   <li>{@link GetTraits#setCurrentTraits(boolean)}
   *   <li>{@link GetTraits#setOptions(Map)}
   *   <li>{@link GetTraits#getOptions()}
   *   <li>{@link GetTraits#isCurrentTraits()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetTraits.<init>()", "Map GetTraits.getOptions()", "boolean GetTraits.isCurrentTraits()",
      "void GetTraits.setCurrentTraits(boolean)", "void GetTraits.setOptions(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    GetTraits actualGetTraits = new GetTraits();
    actualGetTraits.setCurrentTraits(true);
    HashMap<String, String> options = new HashMap<>();
    actualGetTraits.setOptions(options);
    Map<String, String> actualOptions = actualGetTraits.getOptions();
    boolean actualIsCurrentTraitsResult = actualGetTraits.isCurrentTraits();

    // Assert
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsCurrentTraitsResult);
    assertSame(options, actualOptions);
  }
}
