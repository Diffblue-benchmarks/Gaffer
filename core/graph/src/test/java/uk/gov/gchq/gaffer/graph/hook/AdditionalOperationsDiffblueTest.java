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

package uk.gov.gchq.gaffer.graph.hook;

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
import uk.gov.gchq.gaffer.operation.Operation;

class AdditionalOperationsDiffblueTest {
  /**
   * Test new {@link AdditionalOperations} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AdditionalOperations}
   */
  @Test
  @DisplayName("Test new AdditionalOperations (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.<init>()"})
  void testNewAdditionalOperations() {
    // Arrange and Act
    AdditionalOperations actualAdditionalOperations = new AdditionalOperations();

    // Assert
    List<Operation> end = actualAdditionalOperations.getEnd();
    assertTrue(end.isEmpty());
    Map<String, List<Operation>> after = actualAdditionalOperations.getAfter();
    assertTrue(after.isEmpty());
    assertSame(after, actualAdditionalOperations.getBefore());
    assertSame(end, actualAdditionalOperations.getStart());
  }

  /**
   * Test {@link AdditionalOperations#getStart()}.
   *
   * <ul>
   *   <li>Given {@link AdditionalOperations} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#getStart()}
   */
  @Test
  @DisplayName(
      "Test getStart(); given AdditionalOperations (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdditionalOperations.getStart()"})
  void testGetStart_givenAdditionalOperations_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new AdditionalOperations().getStart().isEmpty());
  }

  /**
   * Test {@link AdditionalOperations#getStart()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#getStart()}
   */
  @Test
  @DisplayName("Test getStart(); given ArrayList() add 'null'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdditionalOperations.getStart()"})
  void testGetStart_givenArrayListAddNull_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Operation> start = new ArrayList<>();
    start.add(null);

    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setAfter(new HashMap<>());
    additionalOperations.setBefore(new HashMap<>());
    additionalOperations.setEnd(new ArrayList<>());
    additionalOperations.setStart(start);

    // Act
    List<Operation> actualStart = additionalOperations.getStart();

    // Assert
    assertEquals(1, actualStart.size());
    assertNull(actualStart.get(0));
  }

  /**
   * Test {@link AdditionalOperations#setStart(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link AdditionalOperations} (default constructor) Start is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setStart(List)}
   */
  @Test
  @DisplayName(
      "Test setStart(List); given 'null'; then AdditionalOperations (default constructor) Start is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setStart(List)"})
  void testSetStart_givenNull_thenAdditionalOperationsStartIsArrayList() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setAfter(new HashMap<>());
    additionalOperations.setBefore(new HashMap<>());
    additionalOperations.setEnd(new ArrayList<>());
    additionalOperations.setStart(new ArrayList<>());

    ArrayList<Operation> start = new ArrayList<>();
    start.add(null);

    // Act
    additionalOperations.setStart(start);

    // Assert
    assertEquals(start, additionalOperations.getStart());
  }

  /**
   * Test {@link AdditionalOperations#getEnd()}.
   *
   * <ul>
   *   <li>Given {@link AdditionalOperations} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#getEnd()}
   */
  @Test
  @DisplayName("Test getEnd(); given AdditionalOperations (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdditionalOperations.getEnd()"})
  void testGetEnd_givenAdditionalOperations_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new AdditionalOperations().getEnd().isEmpty());
  }

  /**
   * Test {@link AdditionalOperations#getEnd()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#getEnd()}
   */
  @Test
  @DisplayName("Test getEnd(); given ArrayList() add 'null'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AdditionalOperations.getEnd()"})
  void testGetEnd_givenArrayListAddNull_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Operation> end = new ArrayList<>();
    end.add(null);

    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setAfter(new HashMap<>());
    additionalOperations.setBefore(new HashMap<>());
    additionalOperations.setStart(new ArrayList<>());
    additionalOperations.setEnd(end);

    // Act
    List<Operation> actualEnd = additionalOperations.getEnd();

    // Assert
    assertEquals(1, actualEnd.size());
    assertNull(actualEnd.get(0));
  }

  /**
   * Test {@link AdditionalOperations#setEnd(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then {@link AdditionalOperations} (default constructor) Start Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setEnd(List)}
   */
  @Test
  @DisplayName(
      "Test setEnd(List); given 'null'; when ArrayList() add 'null'; then AdditionalOperations (default constructor) Start Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setEnd(List)"})
  void testSetEnd_givenNull_whenArrayListAddNull_thenAdditionalOperationsStartEmpty() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setAfter(new HashMap<>());
    additionalOperations.setBefore(new HashMap<>());
    additionalOperations.setEnd(new ArrayList<>());
    additionalOperations.setStart(new ArrayList<>());

    ArrayList<Operation> end = new ArrayList<>();
    end.add(null);

    // Act
    additionalOperations.setEnd(end);

    // Assert
    assertTrue(additionalOperations.getStart().isEmpty());
    assertEquals(end, additionalOperations.getEnd());
  }

  /**
   * Test {@link AdditionalOperations#setEnd(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link AdditionalOperations} (default constructor) End Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setEnd(List)}
   */
  @Test
  @DisplayName(
      "Test setEnd(List); when ArrayList(); then AdditionalOperations (default constructor) End Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setEnd(List)"})
  void testSetEnd_whenArrayList_thenAdditionalOperationsEndEmpty() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();

    // Act
    additionalOperations.setEnd(new ArrayList<>());

    // Assert that nothing has changed
    List<Operation> end = additionalOperations.getEnd();
    assertTrue(end.isEmpty());
    assertSame(end, additionalOperations.getStart());
  }

  /**
   * Test {@link AdditionalOperations#setEnd(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link AdditionalOperations} (default constructor) End Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setEnd(List)}
   */
  @Test
  @DisplayName(
      "Test setEnd(List); when 'null'; then AdditionalOperations (default constructor) End Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setEnd(List)"})
  void testSetEnd_whenNull_thenAdditionalOperationsEndEmpty() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setAfter(new HashMap<>());
    additionalOperations.setBefore(new HashMap<>());
    additionalOperations.setEnd(new ArrayList<>());
    additionalOperations.setStart(new ArrayList<>());

    // Act
    additionalOperations.setEnd(null);

    // Assert that nothing has changed
    List<Operation> end = additionalOperations.getEnd();
    assertTrue(end.isEmpty());
    assertSame(end, additionalOperations.getStart());
  }

  /**
   * Test {@link AdditionalOperations#getBefore()}.
   *
   * <ul>
   *   <li>Given {@link AdditionalOperations} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#getBefore()}
   */
  @Test
  @DisplayName(
      "Test getBefore(); given AdditionalOperations (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AdditionalOperations.getBefore()"})
  void testGetBefore_givenAdditionalOperations_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new AdditionalOperations().getBefore().isEmpty());
  }

  /**
   * Test {@link AdditionalOperations#getBefore()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code .} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code .} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#getBefore()}
   */
  @Test
  @DisplayName("Test getBefore(); given HashMap() '.' is ArrayList(); then return '.' Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AdditionalOperations.getBefore()"})
  void testGetBefore_givenHashMapDotIsArrayList_thenReturnDotEmpty() {
    // Arrange
    HashMap<String, List<Operation>> before = new HashMap<>();
    before.put(".", new ArrayList<>());

    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setBefore(before);

    // Act
    Map<String, List<Operation>> actualBefore = additionalOperations.getBefore();

    // Assert
    assertEquals(1, actualBefore.size());
    assertTrue(actualBefore.get(".").isEmpty());
  }

  /**
   * Test {@link AdditionalOperations#getBefore()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code foo} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#getBefore()}
   */
  @Test
  @DisplayName("Test getBefore(); given HashMap() 'foo' is ArrayList(); then return 'foo' Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AdditionalOperations.getBefore()"})
  void testGetBefore_givenHashMapFooIsArrayList_thenReturnFooEmpty() {
    // Arrange
    HashMap<String, List<Operation>> before = new HashMap<>();
    before.put("foo", new ArrayList<>());

    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setBefore(before);

    // Act
    Map<String, List<Operation>> actualBefore = additionalOperations.getBefore();

    // Assert
    assertEquals(1, actualBefore.size());
    assertTrue(actualBefore.get("foo").isEmpty());
  }

  /**
   * Test {@link AdditionalOperations#getBefore()}.
   *
   * <ul>
   *   <li>Then return {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#getBefore()}
   */
  @Test
  @DisplayName("Test getBefore(); then return HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AdditionalOperations.getBefore()"})
  void testGetBefore_thenReturnHashMap() {
    // Arrange
    HashMap<String, List<Operation>> before = new HashMap<>();
    before.put("[]", new ArrayList<>());
    before.put("foo", new ArrayList<>());

    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setBefore(before);

    // Act and Assert
    assertEquals(before, additionalOperations.getBefore());
  }

  /**
   * Test {@link AdditionalOperations#setBefore(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then {@link AdditionalOperations} (default constructor) Before {@code foo} is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setBefore(Map)}
   */
  @Test
  @DisplayName(
      "Test setBefore(Map); given ArrayList() add 'null'; then AdditionalOperations (default constructor) Before 'foo' is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setBefore(Map)"})
  void testSetBefore_givenArrayListAddNull_thenAdditionalOperationsBeforeFooIsArrayList() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();

    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(null);

    HashMap<String, List<Operation>> before = new HashMap<>();
    before.put("foo", operationList);

    // Act
    additionalOperations.setBefore(before);

    // Assert
    Map<String, List<Operation>> before2 = additionalOperations.getBefore();
    assertEquals(1, before2.size());
    assertEquals(operationList, before2.get("foo"));
  }

  /**
   * Test {@link AdditionalOperations#setBefore(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then {@link AdditionalOperations} (default constructor) Before size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setBefore(Map)}
   */
  @Test
  @DisplayName(
      "Test setBefore(Map); given ArrayList(); then AdditionalOperations (default constructor) Before size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setBefore(Map)"})
  void testSetBefore_givenArrayList_thenAdditionalOperationsBeforeSizeIsOne() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();

    HashMap<String, List<Operation>> before = new HashMap<>();
    before.put("foo", new ArrayList<>());

    // Act
    additionalOperations.setBefore(before);

    // Assert
    assertEquals(1, additionalOperations.getBefore().size());
  }

  /**
   * Test {@link AdditionalOperations#setBefore(Map)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link HashMap#HashMap()} {@code .} is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setBefore(Map)}
   */
  @Test
  @DisplayName("Test setBefore(Map); given '.'; when HashMap() '.' is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setBefore(Map)"})
  void testSetBefore_givenDot_whenHashMapDotIsArrayList() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();

    HashMap<String, List<Operation>> before = new HashMap<>();
    before.put(".", new ArrayList<>());

    // Act
    additionalOperations.setBefore(before);

    // Assert
    assertEquals(1, additionalOperations.getBefore().size());
  }

  /**
   * Test {@link AdditionalOperations#setBefore(Map)}.
   *
   * <ul>
   *   <li>Then {@link AdditionalOperations} (default constructor) Before is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setBefore(Map)}
   */
  @Test
  @DisplayName(
      "Test setBefore(Map); then AdditionalOperations (default constructor) Before is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setBefore(Map)"})
  void testSetBefore_thenAdditionalOperationsBeforeIsHashMap() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();

    HashMap<String, List<Operation>> before = new HashMap<>();
    before.put("[]", new ArrayList<>());
    before.put("foo", new ArrayList<>());

    // Act
    additionalOperations.setBefore(before);

    // Assert
    assertEquals(before, additionalOperations.getBefore());
  }

  /**
   * Test {@link AdditionalOperations#getAfter()}.
   *
   * <ul>
   *   <li>Given {@link AdditionalOperations} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#getAfter()}
   */
  @Test
  @DisplayName(
      "Test getAfter(); given AdditionalOperations (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AdditionalOperations.getAfter()"})
  void testGetAfter_givenAdditionalOperations_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new AdditionalOperations().getAfter().isEmpty());
  }

  /**
   * Test {@link AdditionalOperations#getAfter()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code .} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code .} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#getAfter()}
   */
  @Test
  @DisplayName("Test getAfter(); given HashMap() '.' is ArrayList(); then return '.' Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AdditionalOperations.getAfter()"})
  void testGetAfter_givenHashMapDotIsArrayList_thenReturnDotEmpty() {
    // Arrange
    HashMap<String, List<Operation>> after = new HashMap<>();
    after.put(".", new ArrayList<>());

    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setAfter(after);

    // Act
    Map<String, List<Operation>> actualAfter = additionalOperations.getAfter();

    // Assert
    assertEquals(1, actualAfter.size());
    assertTrue(actualAfter.get(".").isEmpty());
  }

  /**
   * Test {@link AdditionalOperations#getAfter()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code foo} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#getAfter()}
   */
  @Test
  @DisplayName("Test getAfter(); given HashMap() 'foo' is ArrayList(); then return 'foo' Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AdditionalOperations.getAfter()"})
  void testGetAfter_givenHashMapFooIsArrayList_thenReturnFooEmpty() {
    // Arrange
    HashMap<String, List<Operation>> after = new HashMap<>();
    after.put("foo", new ArrayList<>());

    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setAfter(after);

    // Act
    Map<String, List<Operation>> actualAfter = additionalOperations.getAfter();

    // Assert
    assertEquals(1, actualAfter.size());
    assertTrue(actualAfter.get("foo").isEmpty());
  }

  /**
   * Test {@link AdditionalOperations#getAfter()}.
   *
   * <ul>
   *   <li>Then return {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#getAfter()}
   */
  @Test
  @DisplayName("Test getAfter(); then return HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AdditionalOperations.getAfter()"})
  void testGetAfter_thenReturnHashMap() {
    // Arrange
    HashMap<String, List<Operation>> after = new HashMap<>();
    after.put("[]", new ArrayList<>());
    after.put("foo", new ArrayList<>());

    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setAfter(after);

    // Act and Assert
    assertEquals(after, additionalOperations.getAfter());
  }

  /**
   * Test {@link AdditionalOperations#setAfter(Map)}.
   *
   * <ul>
   *   <li>Given {@link AdditionalOperations} (default constructor) After is {@link
   *       HashMap#HashMap()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setAfter(Map)}
   */
  @Test
  @DisplayName(
      "Test setAfter(Map); given AdditionalOperations (default constructor) After is HashMap(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setAfter(Map)"})
  void testSetAfter_givenAdditionalOperationsAfterIsHashMap_whenNull() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setAfter(new HashMap<>());
    additionalOperations.setBefore(new HashMap<>());
    additionalOperations.setEnd(new ArrayList<>());
    additionalOperations.setStart(new ArrayList<>());

    // Act
    additionalOperations.setAfter(null);

    // Assert that nothing has changed
    Map<String, List<Operation>> after = additionalOperations.getAfter();
    assertTrue(after.isEmpty());
    assertSame(after, additionalOperations.getBefore());
  }

  /**
   * Test {@link AdditionalOperations#setAfter(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then {@link AdditionalOperations} (default constructor) After {@code foo} is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setAfter(Map)}
   */
  @Test
  @DisplayName(
      "Test setAfter(Map); given ArrayList() add 'null'; then AdditionalOperations (default constructor) After 'foo' is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setAfter(Map)"})
  void testSetAfter_givenArrayListAddNull_thenAdditionalOperationsAfterFooIsArrayList() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();

    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(null);

    HashMap<String, List<Operation>> after = new HashMap<>();
    after.put("foo", operationList);

    // Act
    additionalOperations.setAfter(after);

    // Assert
    Map<String, List<Operation>> after2 = additionalOperations.getAfter();
    assertEquals(1, after2.size());
    assertTrue(additionalOperations.getBefore().isEmpty());
    assertEquals(operationList, after2.get("foo"));
  }

  /**
   * Test {@link AdditionalOperations#setAfter(Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then {@link AdditionalOperations} (default constructor) Before Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setAfter(Map)}
   */
  @Test
  @DisplayName(
      "Test setAfter(Map); given ArrayList(); then AdditionalOperations (default constructor) Before Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setAfter(Map)"})
  void testSetAfter_givenArrayList_thenAdditionalOperationsBeforeEmpty() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();

    HashMap<String, List<Operation>> after = new HashMap<>();
    after.put("foo", new ArrayList<>());

    // Act
    additionalOperations.setAfter(after);

    // Assert
    assertEquals(1, additionalOperations.getAfter().size());
    assertTrue(additionalOperations.getBefore().isEmpty());
  }

  /**
   * Test {@link AdditionalOperations#setAfter(Map)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link HashMap#HashMap()} {@code .} is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setAfter(Map)}
   */
  @Test
  @DisplayName("Test setAfter(Map); given '.'; when HashMap() '.' is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setAfter(Map)"})
  void testSetAfter_givenDot_whenHashMapDotIsArrayList() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();

    HashMap<String, List<Operation>> after = new HashMap<>();
    after.put(".", new ArrayList<>());

    // Act
    additionalOperations.setAfter(after);

    // Assert
    assertEquals(1, additionalOperations.getAfter().size());
    assertTrue(additionalOperations.getBefore().isEmpty());
  }

  /**
   * Test {@link AdditionalOperations#setAfter(Map)}.
   *
   * <ul>
   *   <li>Then {@link AdditionalOperations} (default constructor) After is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setAfter(Map)}
   */
  @Test
  @DisplayName(
      "Test setAfter(Map); then AdditionalOperations (default constructor) After is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setAfter(Map)"})
  void testSetAfter_thenAdditionalOperationsAfterIsHashMap() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();

    HashMap<String, List<Operation>> after = new HashMap<>();
    after.put("[]", new ArrayList<>());
    after.put("foo", new ArrayList<>());

    // Act
    additionalOperations.setAfter(after);

    // Assert
    assertEquals(after, additionalOperations.getAfter());
  }

  /**
   * Test {@link AdditionalOperations#setAfter(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link AdditionalOperations} (default constructor) After Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalOperations#setAfter(Map)}
   */
  @Test
  @DisplayName(
      "Test setAfter(Map); when HashMap(); then AdditionalOperations (default constructor) After Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdditionalOperations.setAfter(Map)"})
  void testSetAfter_whenHashMap_thenAdditionalOperationsAfterEmpty() {
    // Arrange
    AdditionalOperations additionalOperations = new AdditionalOperations();

    // Act
    additionalOperations.setAfter(new HashMap<>());

    // Assert that nothing has changed
    Map<String, List<Operation>> after = additionalOperations.getAfter();
    assertTrue(after.isEmpty());
    assertSame(after, additionalOperations.getBefore());
  }
}
