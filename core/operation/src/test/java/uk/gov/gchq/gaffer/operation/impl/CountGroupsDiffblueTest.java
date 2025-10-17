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

package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.GroupCounts;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.CountGroups.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class CountGroupsDiffblueTest {
  /**
   * Test Builder {@link Builder#limit(Integer)}.
   *
   * <p>Method under test: {@link Builder#limit(Integer)}
   */
  @Test
  @DisplayName("Test Builder limit(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.limit(Integer)"})
  void testBuilderLimit() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualLimitResult = builder.limit(1);

    // Assert
    assertSame(builder, actualLimitResult);
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
    Builder actualBuilder = new Builder();

    // Assert
    CountGroups _getOpResult = actualBuilder._getOp();
    TypeReference<GroupCounts> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.CountGroups);
    assertNull(_getOpResult.getLimit());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<GroupCounts> expectedOutputClass = GroupCounts.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    CountGroups actualCountGroups = actualBuilder.build();
    assertSame(_getOpResult, actualCountGroups);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CountGroups#CountGroups()}
   *   <li>{@link CountGroups#setInput(Iterable)}
   *   <li>{@link CountGroups#setLimit(Integer)}
   *   <li>{@link CountGroups#setOptions(Map)}
   *   <li>{@link CountGroups#getLimit()}
   *   <li>{@link CountGroups#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CountGroups.<init>()",
    "void CountGroups.<init>(Integer)",
    "Integer CountGroups.getLimit()",
    "Map CountGroups.getOptions()",
    "void CountGroups.setInput(Iterable)",
    "void CountGroups.setLimit(Integer)",
    "void CountGroups.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    CountGroups actualCountGroups = new CountGroups();
    ArrayList<Element> input = new ArrayList<>();
    actualCountGroups.setInput(input);
    actualCountGroups.setLimit(1);
    HashMap<String, String> options = new HashMap<>();
    actualCountGroups.setOptions(options);
    Integer actualLimit = actualCountGroups.getLimit();
    Map<String, String> actualOptions = actualCountGroups.getOptions();

    // Assert
    Iterable<? extends Element> input2 = actualCountGroups.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(1, actualLimit.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CountGroups#CountGroups(Integer)}
   *   <li>{@link CountGroups#setInput(Iterable)}
   *   <li>{@link CountGroups#setLimit(Integer)}
   *   <li>{@link CountGroups#setOptions(Map)}
   *   <li>{@link CountGroups#getLimit()}
   *   <li>{@link CountGroups#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CountGroups.<init>()",
    "void CountGroups.<init>(Integer)",
    "Integer CountGroups.getLimit()",
    "Map CountGroups.getOptions()",
    "void CountGroups.setInput(Iterable)",
    "void CountGroups.setLimit(Integer)",
    "void CountGroups.setOptions(Map)"
  })
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    CountGroups actualCountGroups = new CountGroups(1);
    ArrayList<Element> input = new ArrayList<>();
    actualCountGroups.setInput(input);
    actualCountGroups.setLimit(1);
    HashMap<String, String> options = new HashMap<>();
    actualCountGroups.setOptions(options);
    Integer actualLimit = actualCountGroups.getLimit();
    Map<String, String> actualOptions = actualCountGroups.getOptions();

    // Assert
    Iterable<? extends Element> input2 = actualCountGroups.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(1, actualLimit.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }

  /**
   * Test {@link CountGroups#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link CountGroups#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference CountGroups.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue(new CountGroups().getOutputTypeReference() instanceof TypeReferenceImpl.CountGroups);
  }

  /**
   * Test {@link CountGroups#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CountGroups#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable CountGroups.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new CountGroups().getInput());
  }

  /**
   * Test {@link CountGroups#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link CountGroups#CountGroups()} Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link CountGroups#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given CountGroups() Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CountGroups CountGroups.shallowClone()"})
  void testShallowClone_givenCountGroupsOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    CountGroups countGroups = new CountGroups();
    countGroups.setOptions(new HashMap<>());

    // Act
    CountGroups actualShallowCloneResult = countGroups.shallowClone();

    // Assert
    TypeReference<GroupCounts> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.CountGroups);
    assertNull(actualShallowCloneResult.getLimit());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<GroupCounts> expectedOutputClass = GroupCounts.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link CountGroups#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link CountGroups#CountGroups()}.
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CountGroups#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given CountGroups(); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CountGroups CountGroups.shallowClone()"})
  void testShallowClone_givenCountGroups_thenReturnOptionsIsNull() {
    // Arrange and Act
    CountGroups actualShallowCloneResult = new CountGroups().shallowClone();

    // Assert
    TypeReference<GroupCounts> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.CountGroups);
    assertNull(actualShallowCloneResult.getLimit());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<GroupCounts> expectedOutputClass = GroupCounts.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }
}
