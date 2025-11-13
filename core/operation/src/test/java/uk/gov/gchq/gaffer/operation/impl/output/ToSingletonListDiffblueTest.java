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

package uk.gov.gchq.gaffer.operation.impl.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.output.ToSingletonList.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ToSingletonListDiffblueTest {
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
    ToSingletonList<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<List<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    ToSingletonList<Object> actualToSingletonList = actualBuilder.build();
    assertSame(_getOpResult, actualToSingletonList);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToSingletonList#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ToSingletonList#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference ToSingletonList.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    ToSingletonList<Object> toSingletonList = new ToSingletonList<>();

    // Act
    TypeReference<List<?>> actualOutputTypeReference = toSingletonList.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.List);
    assertEquals("java.util.List<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link ToSingletonList#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ToSingletonList} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToSingletonList#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ToSingletonList (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToSingletonList ToSingletonList.shallowClone()"})
  void testShallowClone_givenToSingletonListOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    ToSingletonList<Object> toSingletonList = new ToSingletonList<>();
    toSingletonList.setOptions(new HashMap<>());

    // Act
    ToSingletonList<Object> actualShallowCloneResult = toSingletonList.shallowClone();

    // Assert
    TypeReference<List<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToSingletonList#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ToSingletonList} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToSingletonList#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ToSingletonList (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToSingletonList ToSingletonList.shallowClone()"})
  void testShallowClone_givenToSingletonList_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange
    ToSingletonList<Object> toSingletonList = new ToSingletonList<>();

    // Act
    ToSingletonList<Object> actualShallowCloneResult = toSingletonList.shallowClone();

    // Assert
    TypeReference<List<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ToSingletonList}
   *   <li>{@link ToSingletonList#setInput(Object)}
   *   <li>{@link ToSingletonList#setOptions(Map)}
   *   <li>{@link ToSingletonList#getInput()}
   *   <li>{@link ToSingletonList#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToSingletonList.<init>()",
    "Object ToSingletonList.getInput()",
    "Map ToSingletonList.getOptions()",
    "void ToSingletonList.setInput(Object)",
    "void ToSingletonList.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ToSingletonList<Object> actualToSingletonList = new ToSingletonList<>();
    actualToSingletonList.setInput("Input");
    HashMap<String, String> options = new HashMap<>();
    actualToSingletonList.setOptions(options);
    Object actualInput = actualToSingletonList.getInput();
    Map<String, String> actualOptions = actualToSingletonList.getOptions();

    // Assert
    assertEquals("Input", actualInput);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
