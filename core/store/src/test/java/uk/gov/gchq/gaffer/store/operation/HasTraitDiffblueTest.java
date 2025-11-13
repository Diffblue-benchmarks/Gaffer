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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.operation.HasTrait.Builder;

class HasTraitDiffblueTest {
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
    HasTrait _getOpResult = actualBuilder._getOp();
    TypeReference<Boolean> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Boolean);
    assertNull(_getOpResult.getTrait());
    assertTrue(_getOpResult.getOptions().isEmpty());
    assertTrue(_getOpResult.isCurrentTraits());
    Class<Boolean> expectedOutputClass = Boolean.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test Builder {@link Builder#trait(StoreTrait)}.
   * <p>
   * Method under test: {@link Builder#trait(StoreTrait)}
   */
  @Test
  @DisplayName("Test Builder trait(StoreTrait)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.trait(StoreTrait)"})
  void testBuilderTrait() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.trait(StoreTrait.INGEST_AGGREGATION));
  }

  /**
   * Test {@link HasTrait#shallowClone()}.
   * <p>
   * Method under test: {@link HasTrait#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HasTrait HasTrait.shallowClone()"})
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    HasTrait actualShallowCloneResult = (new HasTrait()).shallowClone();

    // Assert
    TypeReference<Boolean> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Boolean);
    assertNull(actualShallowCloneResult.getTrait());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.isCurrentTraits());
    Class<Boolean> expectedOutputClass = Boolean.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link HasTrait#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link HasTrait#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference HasTrait.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue((new HasTrait()).getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link HasTrait}
   *   <li>{@link HasTrait#setCurrentTraits(boolean)}
   *   <li>{@link HasTrait#setOptions(Map)}
   *   <li>{@link HasTrait#setTrait(StoreTrait)}
   *   <li>{@link HasTrait#getOptions()}
   *   <li>{@link HasTrait#getTrait()}
   *   <li>{@link HasTrait#isCurrentTraits()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HasTrait.<init>()", "Map HasTrait.getOptions()", "StoreTrait HasTrait.getTrait()",
      "boolean HasTrait.isCurrentTraits()", "void HasTrait.setCurrentTraits(boolean)", "void HasTrait.setOptions(Map)",
      "void HasTrait.setTrait(StoreTrait)"})
  void testGettersAndSetters() {
    // Arrange and Act
    HasTrait actualHasTrait = new HasTrait();
    actualHasTrait.setCurrentTraits(true);
    HashMap<String, String> options = new HashMap<>();
    actualHasTrait.setOptions(options);
    actualHasTrait.setTrait(StoreTrait.INGEST_AGGREGATION);
    Map<String, String> actualOptions = actualHasTrait.getOptions();
    StoreTrait actualTrait = actualHasTrait.getTrait();
    boolean actualIsCurrentTraitsResult = actualHasTrait.isCurrentTraits();

    // Assert
    assertEquals(StoreTrait.INGEST_AGGREGATION, actualTrait);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsCurrentTraitsResult);
    assertSame(options, actualOptions);
  }
}
