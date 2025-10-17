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

package uk.gov.gchq.gaffer.federatedstore.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.operation.GetAllGraphInfo.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.MapStringObject;

class GetAllGraphInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#graphIDsCSV(String)}.
   *
   * <ul>
   *   <li>Then _getOp OutputTypeReference return {@link TypeReferenceImpl.MapStringObject}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#graphIDsCSV(String)}
   */
  @Test
  @DisplayName(
      "Test Builder graphIDsCSV(String); then _getOp OutputTypeReference return MapStringObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphIDsCSV(String)"})
  void testBuilderGraphIDsCSV_then_getOpOutputTypeReferenceReturnMapStringObject() {
    // Arrange and Act
    Builder actualGraphIDsCSVResult = new Builder().graphIDsCSV("Graph Ids CSV");

    // Assert
    GetAllGraphInfo _getOpResult = actualGraphIDsCSVResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof MapStringObject);
    List<String> graphIds = _getOpResult.getGraphIds();
    assertEquals(1, graphIds.size());
    assertEquals("Graph Ids CSV", graphIds.get(0));
    GetAllGraphInfo actualGetAllGraphInfo = actualGraphIDsCSVResult.build();
    assertSame(_getOpResult, actualGetAllGraphInfo);
  }

  /**
   * Test Builder {@link Builder#graphIDsCSV(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#graphIDsCSV(String)}
   */
  @Test
  @DisplayName(
      "Test Builder graphIDsCSV(String); when 'null'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphIDsCSV(String)"})
  void testBuilderGraphIDsCSV_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphIDsCSVResult = builder.graphIDsCSV(null);

    // Assert
    assertSame(builder, actualGraphIDsCSVResult);
  }

  /**
   * Test Builder {@link Builder#graphIDs(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#graphIDs(List)}
   */
  @Test
  @DisplayName("Test Builder graphIDs(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphIDs(List)"})
  void testBuilderGraphIDs_given42_whenArrayListAdd42() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> graphIds = new ArrayList<>();
    graphIds.add("42");
    graphIds.add("foo");

    // Act
    Builder actualGraphIDsResult = builder.graphIDs(graphIds);

    // Assert
    assertSame(builder, actualGraphIDsResult);
  }

  /**
   * Test Builder {@link Builder#graphIDs(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#graphIDs(List)}
   */
  @Test
  @DisplayName("Test Builder graphIDs(List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphIDs(List)"})
  void testBuilderGraphIDs_givenFoo_whenArrayListAddFoo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> graphIds = new ArrayList<>();
    graphIds.add("foo");

    // Act
    Builder actualGraphIDsResult = builder.graphIDs(graphIds);

    // Assert
    assertSame(builder, actualGraphIDsResult);
  }

  /**
   * Test Builder {@link Builder#graphIDs(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#graphIDs(List)}
   */
  @Test
  @DisplayName("Test Builder graphIDs(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphIDs(List)"})
  void testBuilderGraphIDs_whenArrayList() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphIDsResult = builder.graphIDs(new ArrayList<>());

    // Assert
    assertSame(builder, actualGraphIDsResult);
  }

  /**
   * Test Builder {@link Builder#graphIDs(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#graphIDs(List)}
   */
  @Test
  @DisplayName("Test Builder graphIDs(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphIDs(List)"})
  void testBuilderGraphIDs_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphIDsResult = builder.graphIDs(null);

    // Assert
    assertSame(builder, actualGraphIDsResult);
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
    GetAllGraphInfo _getOpResult = actualBuilder._getOp();
    TypeReference<Map<String, Object>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof MapStringObject);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>", outputType.getTypeName());
    assertNull(_getOpResult.getGraphIds());
    assertNull(_getOpResult.getOptions());
    assertFalse(_getOpResult.isUserRequestingAdminUsage());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetAllGraphInfo actualGetAllGraphInfo = actualBuilder.build();
    assertSame(_getOpResult, actualGetAllGraphInfo);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllGraphInfo#graphIds(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then {@link GetAllGraphInfo} (default constructor) GraphIds is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#graphIds(List)}
   */
  @Test
  @DisplayName(
      "Test graphIds(List); given '42'; when ArrayList() add '42'; then GetAllGraphInfo (default constructor) GraphIds is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphInfo GetAllGraphInfo.graphIds(List)"})
  void testGraphIds_given42_whenArrayListAdd42_thenGetAllGraphInfoGraphIdsIsArrayList() {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();

    ArrayList<String> graphsIds = new ArrayList<>();
    graphsIds.add("42");
    graphsIds.add("foo");

    // Act
    GetAllGraphInfo actualGraphIdsResult = getAllGraphInfo.graphIds(graphsIds);

    // Assert
    assertEquals(graphsIds, getAllGraphInfo.getGraphIds());
    assertSame(getAllGraphInfo, actualGraphIdsResult);
  }

  /**
   * Test {@link GetAllGraphInfo#graphIds(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then {@link GetAllGraphInfo} (default constructor) GraphIds is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#graphIds(List)}
   */
  @Test
  @DisplayName(
      "Test graphIds(List); given 'foo'; when ArrayList() add 'foo'; then GetAllGraphInfo (default constructor) GraphIds is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphInfo GetAllGraphInfo.graphIds(List)"})
  void testGraphIds_givenFoo_whenArrayListAddFoo_thenGetAllGraphInfoGraphIdsIsArrayList() {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();

    ArrayList<String> graphsIds = new ArrayList<>();
    graphsIds.add("foo");

    // Act
    GetAllGraphInfo actualGraphIdsResult = getAllGraphInfo.graphIds(graphsIds);

    // Assert
    assertEquals(graphsIds, getAllGraphInfo.getGraphIds());
    assertSame(getAllGraphInfo, actualGraphIdsResult);
  }

  /**
   * Test {@link GetAllGraphInfo#graphIds(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link GetAllGraphInfo} (default constructor) GraphIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#graphIds(List)}
   */
  @Test
  @DisplayName(
      "Test graphIds(List); when ArrayList(); then GetAllGraphInfo (default constructor) GraphIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphInfo GetAllGraphInfo.graphIds(List)"})
  void testGraphIds_whenArrayList_thenGetAllGraphInfoGraphIdsEmpty() {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();

    // Act
    GetAllGraphInfo actualGraphIdsResult = getAllGraphInfo.graphIds(new ArrayList<>());

    // Assert
    assertTrue(getAllGraphInfo.getGraphIds().isEmpty());
    assertSame(getAllGraphInfo, actualGraphIdsResult);
  }

  /**
   * Test {@link GetAllGraphInfo#graphIds(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link GetAllGraphInfo} (default constructor) GraphIds is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#graphIds(List)}
   */
  @Test
  @DisplayName(
      "Test graphIds(List); when 'null'; then GetAllGraphInfo (default constructor) GraphIds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphInfo GetAllGraphInfo.graphIds(List)"})
  void testGraphIds_whenNull_thenGetAllGraphInfoGraphIdsIsNull() {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();

    // Act
    GetAllGraphInfo actualGraphIdsResult = getAllGraphInfo.graphIds(null);

    // Assert
    assertNull(getAllGraphInfo.getGraphIds());
    assertSame(getAllGraphInfo, actualGraphIdsResult);
  }

  /**
   * Test {@link GetAllGraphInfo#graphIdsCSV(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then {@link GetAllGraphInfo} (default constructor) GraphIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#graphIdsCSV(String)}
   */
  @Test
  @DisplayName(
      "Test graphIdsCSV(String); when empty string; then GetAllGraphInfo (default constructor) GraphIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphInfo GetAllGraphInfo.graphIdsCSV(String)"})
  void testGraphIdsCSV_whenEmptyString_thenGetAllGraphInfoGraphIdsEmpty() {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();

    // Act
    GetAllGraphInfo actualGraphIdsCSVResult = getAllGraphInfo.graphIdsCSV("");

    // Assert
    assertTrue(getAllGraphInfo.getGraphIds().isEmpty());
    assertSame(getAllGraphInfo, actualGraphIdsCSVResult);
  }

  /**
   * Test {@link GetAllGraphInfo#graphIdsCSV(String)}.
   *
   * <ul>
   *   <li>When {@code Graph Ids}.
   *   <li>Then OutputTypeReference return {@link TypeReferenceImpl.MapStringObject}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#graphIdsCSV(String)}
   */
  @Test
  @DisplayName(
      "Test graphIdsCSV(String); when 'Graph Ids'; then OutputTypeReference return MapStringObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphInfo GetAllGraphInfo.graphIdsCSV(String)"})
  void testGraphIdsCSV_whenGraphIds_thenOutputTypeReferenceReturnMapStringObject() {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();

    // Act
    GetAllGraphInfo actualGraphIdsCSVResult = getAllGraphInfo.graphIdsCSV("Graph Ids");

    // Assert
    assertTrue(actualGraphIdsCSVResult.getOutputTypeReference() instanceof MapStringObject);
    List<String> graphIds = getAllGraphInfo.getGraphIds();
    assertEquals(1, graphIds.size());
    assertEquals("Graph Ids", graphIds.get(0));
    List<String> graphIds2 = actualGraphIdsCSVResult.getGraphIds();
    assertEquals(1, graphIds2.size());
    assertEquals("Graph Ids", graphIds2.get(0));
  }

  /**
   * Test {@link GetAllGraphInfo#graphIdsCSV(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link GetAllGraphInfo} (default constructor) GraphIds is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#graphIdsCSV(String)}
   */
  @Test
  @DisplayName(
      "Test graphIdsCSV(String); when 'null'; then GetAllGraphInfo (default constructor) GraphIds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphInfo GetAllGraphInfo.graphIdsCSV(String)"})
  void testGraphIdsCSV_whenNull_thenGetAllGraphInfoGraphIdsIsNull() {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();

    // Act
    GetAllGraphInfo actualGraphIdsCSVResult = getAllGraphInfo.graphIdsCSV(null);

    // Assert
    assertNull(getAllGraphInfo.getGraphIds());
    assertSame(getAllGraphInfo, actualGraphIdsCSVResult);
  }

  /**
   * Test {@link GetAllGraphInfo#getGraphIds()}.
   *
   * <ul>
   *   <li>Given {@link GetAllGraphInfo} (default constructor) graphIds {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#getGraphIds()}
   */
  @Test
  @DisplayName(
      "Test getGraphIds(); given GetAllGraphInfo (default constructor) graphIds ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GetAllGraphInfo.getGraphIds()"})
  void testGetGraphIds_givenGetAllGraphInfoGraphIdsArrayList_thenReturnEmpty() {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();
    getAllGraphInfo.graphIds(new ArrayList<>());

    // Act and Assert
    assertTrue(getAllGraphInfo.getGraphIds().isEmpty());
  }

  /**
   * Test {@link GetAllGraphInfo#getGraphIds()}.
   *
   * <ul>
   *   <li>Given {@link GetAllGraphInfo} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#getGraphIds()}
   */
  @Test
  @DisplayName(
      "Test getGraphIds(); given GetAllGraphInfo (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GetAllGraphInfo.getGraphIds()"})
  void testGetGraphIds_givenGetAllGraphInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GetAllGraphInfo().getGraphIds());
  }

  /**
   * Test {@link GetAllGraphInfo#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetAllGraphInfo#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetAllGraphInfo.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Map<String, Object>> actualOutputTypeReference =
        new GetAllGraphInfo().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof MapStringObject);
    assertEquals(
        "java.util.Map<java.lang.String, java.lang.Object>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetAllGraphInfo#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAllGraphInfo} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetAllGraphInfo (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphInfo GetAllGraphInfo.shallowClone()"})
  void testShallowClone_givenGetAllGraphInfo() throws CloneFailedException {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();

    // Act
    GetAllGraphInfo actualShallowCloneResult = getAllGraphInfo.shallowClone();

    // Assert
    assertEquals(getAllGraphInfo, actualShallowCloneResult);
  }

  /**
   * Test {@link GetAllGraphInfo#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAllGraphInfo} (default constructor) graphIds {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAllGraphInfo (default constructor) graphIds ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphInfo GetAllGraphInfo.shallowClone()"})
  void testShallowClone_givenGetAllGraphInfoGraphIdsArrayList() throws CloneFailedException {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();
    getAllGraphInfo.graphIds(new ArrayList<>());

    // Act
    GetAllGraphInfo actualShallowCloneResult = getAllGraphInfo.shallowClone();

    // Assert
    assertEquals(getAllGraphInfo, actualShallowCloneResult);
  }

  /**
   * Test {@link GetAllGraphInfo#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAllGraphInfo} (default constructor) Options is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAllGraphInfo (default constructor) Options is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphInfo GetAllGraphInfo.shallowClone()"})
  void testShallowClone_givenGetAllGraphInfoOptionsIsHashMap() throws CloneFailedException {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();
    getAllGraphInfo.setOptions(new HashMap<>());

    // Act
    GetAllGraphInfo actualShallowCloneResult = getAllGraphInfo.shallowClone();

    // Assert
    assertEquals(getAllGraphInfo, actualShallowCloneResult);
  }

  /**
   * Test {@link GetAllGraphInfo#equals(Object)}, and {@link GetAllGraphInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GetAllGraphInfo#equals(Object)}
   *   <li>{@link GetAllGraphInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GetAllGraphInfo.equals(Object)", "int GetAllGraphInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();
    GetAllGraphInfo getAllGraphInfo2 = new GetAllGraphInfo();

    // Act and Assert
    assertEquals(getAllGraphInfo, getAllGraphInfo2);
    assertEquals(getAllGraphInfo.hashCode(), getAllGraphInfo2.hashCode());
  }

  /**
   * Test {@link GetAllGraphInfo#equals(Object)}, and {@link GetAllGraphInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GetAllGraphInfo#equals(Object)}
   *   <li>{@link GetAllGraphInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GetAllGraphInfo.equals(Object)", "int GetAllGraphInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();

    // Act and Assert
    assertEquals(getAllGraphInfo, getAllGraphInfo);
    int expectedHashCodeResult = getAllGraphInfo.hashCode();
    assertEquals(expectedHashCodeResult, getAllGraphInfo.hashCode());
  }

  /**
   * Test {@link GetAllGraphInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GetAllGraphInfo.equals(Object)", "int GetAllGraphInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();
    getAllGraphInfo.graphIds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(getAllGraphInfo, new GetAllGraphInfo());
  }

  /**
   * Test {@link GetAllGraphInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GetAllGraphInfo.equals(Object)", "int GetAllGraphInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GetAllGraphInfo(), null);
  }

  /**
   * Test {@link GetAllGraphInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GetAllGraphInfo.equals(Object)", "int GetAllGraphInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GetAllGraphInfo(), "Different type to GetAllGraphInfo");
  }

  /**
   * Test {@link GetAllGraphInfo#setUserRequestingAdminUsage(boolean)}.
   *
   * <p>Method under test: {@link GetAllGraphInfo#setUserRequestingAdminUsage(boolean)}
   */
  @Test
  @DisplayName("Test setUserRequestingAdminUsage(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphInfo GetAllGraphInfo.setUserRequestingAdminUsage(boolean)"})
  void testSetUserRequestingAdminUsage() {
    // Arrange
    GetAllGraphInfo getAllGraphInfo = new GetAllGraphInfo();

    // Act
    GetAllGraphInfo actualSetUserRequestingAdminUsageResult =
        getAllGraphInfo.setUserRequestingAdminUsage(true);

    // Assert
    assertTrue(getAllGraphInfo.isUserRequestingAdminUsage());
    assertSame(getAllGraphInfo, actualSetUserRequestingAdminUsageResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetAllGraphInfo}
   *   <li>{@link GetAllGraphInfo#setOptions(Map)}
   *   <li>{@link GetAllGraphInfo#getOptions()}
   *   <li>{@link GetAllGraphInfo#isUserRequestingAdminUsage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAllGraphInfo.<init>()",
    "Map GetAllGraphInfo.getOptions()",
    "boolean GetAllGraphInfo.isUserRequestingAdminUsage()",
    "void GetAllGraphInfo.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetAllGraphInfo actualGetAllGraphInfo = new GetAllGraphInfo();
    HashMap<String, String> options = new HashMap<>();
    actualGetAllGraphInfo.setOptions(options);
    Map<String, String> actualOptions = actualGetAllGraphInfo.getOptions();

    // Assert
    assertFalse(actualGetAllGraphInfo.isUserRequestingAdminUsage());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
