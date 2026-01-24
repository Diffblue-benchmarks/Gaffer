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

package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.Count.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class CountDiffblueTest {
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
    Count<Object> _getOpResult = actualBuilder._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Long);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<Long> expectedOutputClass = Long.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    Count<Object> actualCount = actualBuilder.build();
    assertSame(_getOpResult, actualCount);
  }

  /**
   * Test {@link Count#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Count#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable Count.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange
    Count<Object> count = new Count<>();

    // Act and Assert
    assertNull(count.getInput());
  }

  /**
   * Test {@link Count#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link Count#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.core.type.TypeReference Count.getOutputTypeReference()"
  })
  void testGetOutputTypeReference() {
    // Arrange
    Count<Object> count = new Count<>();

    // Act and Assert
    assertTrue(count.getOutputTypeReference() instanceof TypeReferenceImpl.Long);
  }

  /**
   * Test {@link Count#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Count} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link Count#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given Count (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Count Count.shallowClone()"})
  void testShallowClone_givenCountOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    Count<Object> count = new Count<>();
    count.setOptions(new HashMap<>());

    // Act
    Count actualShallowCloneResult = count.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Long);
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Long> expectedOutputClass = Long.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test {@link Count#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Count} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Count#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given Count (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Count Count.shallowClone()"})
  void testShallowClone_givenCount_thenReturnOptionsIsNull() {
    // Arrange
    Count<Object> count = new Count<>();

    // Act
    Count actualShallowCloneResult = count.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Long);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Long> expectedOutputClass = Long.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Count}
   *   <li>{@link Count#setInput(Iterable)}
   *   <li>{@link Count#setOptions(Map)}
   *   <li>{@link Count#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Count.<init>()",
    "Map Count.getOptions()",
    "void Count.setInput(Iterable)",
    "void Count.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Count<Object> actualCount = new Count<>();
    ArrayList<Object> input = new ArrayList<>();
    actualCount.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualCount.setOptions(options);
    Map<String, String> actualOptions = actualCount.getOptions();

    // Assert
    Iterable<?> input2 = actualCount.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
