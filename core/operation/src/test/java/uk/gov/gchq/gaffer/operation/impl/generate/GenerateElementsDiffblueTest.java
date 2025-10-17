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

package uk.gov.gchq.gaffer.operation.impl.generate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.generate.GenerateElements.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;

class GenerateElementsDiffblueTest {
  /**
   * Test Builder {@link Builder#generator(Function)}.
   *
   * <p>Method under test: {@link Builder#generator(Function)}
   */
  @Test
  @DisplayName("Test Builder generator(Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.generator(Function)"})
  void testBuilderGenerator() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualGeneratorResult = builder.generator(mock(Function.class));

    // Assert
    assertSame(builder, actualGeneratorResult);
  }

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
    Builder<Object> actualBuilder = new Builder<>();

    // Assert
    GenerateElements<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getElementGenerator());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GenerateElements<Object> actualGenerateElements = actualBuilder.build();
    assertSame(_getOpResult, actualGenerateElements);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GenerateElements#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GenerateElements#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GenerateElements.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange
    GenerateElements<Object> generateElements = new GenerateElements<>();

    // Act and Assert
    assertNull(generateElements.getInput());
  }

  /**
   * Test {@link GenerateElements#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GenerateElements#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GenerateElements.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    GenerateElements<Object> generateElements = new GenerateElements<>();

    // Act
    TypeReference<Iterable<? extends Element>> actualOutputTypeReference =
        generateElements.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableElement);
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GenerateElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GenerateElements#GenerateElements()} Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GenerateElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GenerateElements() Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GenerateElements GenerateElements.shallowClone()"})
  void testShallowClone_givenGenerateElementsOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    GenerateElements<Object> generateElements = new GenerateElements<>();
    generateElements.setOptions(new HashMap<>());

    // Act
    GenerateElements<Object> actualShallowCloneResult = generateElements.shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getElementGenerator());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GenerateElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GenerateElements#GenerateElements()}.
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GenerateElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GenerateElements(); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GenerateElements GenerateElements.shallowClone()"})
  void testShallowClone_givenGenerateElements_thenReturnOptionsIsNull() {
    // Arrange
    GenerateElements<Object> generateElements = new GenerateElements<>();

    // Act
    GenerateElements<Object> actualShallowCloneResult = generateElements.shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getElementGenerator());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }
}
