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

package uk.gov.gchq.gaffer.operation.impl.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.operation.impl.output.ToEntitySeeds.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableEntitySeed;

class ToEntitySeedsDiffblueTest {
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
    ToEntitySeeds _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends EntitySeed>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableEntitySeed);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.operation.data.EntitySeed>",
        outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    ToEntitySeeds actualToEntitySeeds = actualBuilder.build();
    assertSame(_getOpResult, actualToEntitySeeds);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToEntitySeeds#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToEntitySeeds#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ToEntitySeeds.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ToEntitySeeds().getInput());
  }

  /**
   * Test {@link ToEntitySeeds#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ToEntitySeeds#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference ToEntitySeeds.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends EntitySeed>> actualOutputTypeReference =
        new ToEntitySeeds().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableEntitySeed);
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.operation.data.EntitySeed>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link ToEntitySeeds#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ToEntitySeeds} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToEntitySeeds#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ToEntitySeeds (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToEntitySeeds ToEntitySeeds.shallowClone()"})
  void testShallowClone_givenToEntitySeedsOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    ToEntitySeeds toEntitySeeds = new ToEntitySeeds();
    toEntitySeeds.setOptions(new HashMap<>());

    // Act
    ToEntitySeeds actualShallowCloneResult = toEntitySeeds.shallowClone();

    // Assert
    TypeReference<Iterable<? extends EntitySeed>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableEntitySeed);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.operation.data.EntitySeed>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToEntitySeeds#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ToEntitySeeds} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToEntitySeeds#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ToEntitySeeds (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToEntitySeeds ToEntitySeeds.shallowClone()"})
  void testShallowClone_givenToEntitySeeds_thenReturnOptionsIsNull() {
    // Arrange and Act
    ToEntitySeeds actualShallowCloneResult = new ToEntitySeeds().shallowClone();

    // Assert
    TypeReference<Iterable<? extends EntitySeed>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableEntitySeed);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.operation.data.EntitySeed>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
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
   *   <li>default or parameterless constructor of {@link ToEntitySeeds}
   *   <li>{@link ToEntitySeeds#setInput(Iterable)}
   *   <li>{@link ToEntitySeeds#setOptions(Map)}
   *   <li>{@link ToEntitySeeds#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToEntitySeeds.<init>()",
    "Map ToEntitySeeds.getOptions()",
    "void ToEntitySeeds.setInput(Iterable)",
    "void ToEntitySeeds.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ToEntitySeeds actualToEntitySeeds = new ToEntitySeeds();
    ArrayList<Object> input = new ArrayList<>();
    actualToEntitySeeds.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualToEntitySeeds.setOptions(options);
    Map<String, String> actualOptions = actualToEntitySeeds.getOptions();

    // Assert
    Iterable<?> input2 = actualToEntitySeeds.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
