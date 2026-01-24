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

package uk.gov.gchq.gaffer.federatedstore.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.operation.GetAllGraphIds.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableString;

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
    TypeReference<Iterable<? extends String>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableString);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends java.lang.String>", outputType.getTypeName());
    assertNull(_getOpResult.getOptions());
    assertFalse(_getOpResult.isUserRequestingAdminUsage());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetAllGraphIds actualGetAllGraphIds = actualBuilder.build();
    assertSame(_getOpResult, actualGetAllGraphIds);
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
    TypeReference<Iterable<? extends String>> actualOutputTypeReference =
        new GetAllGraphIds().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableString);
    assertEquals(
        "java.lang.Iterable<? extends java.lang.String>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetAllGraphIds#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAllGraphIds} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphIds#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAllGraphIds (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphIds GetAllGraphIds.shallowClone()"})
  void testShallowClone_givenGetAllGraphIdsOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    GetAllGraphIds getAllGraphIds = new GetAllGraphIds();
    getAllGraphIds.setOptions(new HashMap<>());

    // Act
    GetAllGraphIds actualShallowCloneResult = getAllGraphIds.shallowClone();

    // Assert
    TypeReference<Iterable<? extends String>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableString);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends java.lang.String>", outputType.getTypeName());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllGraphIds#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAllGraphIds} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllGraphIds#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAllGraphIds (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphIds GetAllGraphIds.shallowClone()"})
  void testShallowClone_givenGetAllGraphIds_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    GetAllGraphIds actualShallowCloneResult = new GetAllGraphIds().shallowClone();

    // Assert
    TypeReference<Iterable<? extends String>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableString);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends java.lang.String>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getOptions());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllGraphIds#setUserRequestingAdminUsage(boolean)}.
   *
   * <p>Method under test: {@link GetAllGraphIds#setUserRequestingAdminUsage(boolean)}
   */
  @Test
  @DisplayName("Test setUserRequestingAdminUsage(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllGraphIds GetAllGraphIds.setUserRequestingAdminUsage(boolean)"})
  void testSetUserRequestingAdminUsage() {
    // Arrange
    GetAllGraphIds getAllGraphIds = new GetAllGraphIds();

    // Act
    GetAllGraphIds actualSetUserRequestingAdminUsageResult =
        getAllGraphIds.setUserRequestingAdminUsage(true);

    // Assert
    assertTrue(getAllGraphIds.isUserRequestingAdminUsage());
    assertSame(getAllGraphIds, actualSetUserRequestingAdminUsageResult);
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
   *   <li>{@link GetAllGraphIds#isUserRequestingAdminUsage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAllGraphIds.<init>()",
    "Map GetAllGraphIds.getOptions()",
    "boolean GetAllGraphIds.isUserRequestingAdminUsage()",
    "void GetAllGraphIds.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetAllGraphIds actualGetAllGraphIds = new GetAllGraphIds();
    HashMap<String, String> options = new HashMap<>();
    actualGetAllGraphIds.setOptions(options);
    Map<String, String> actualOptions = actualGetAllGraphIds.getOptions();

    // Assert
    assertFalse(actualGetAllGraphIds.isUserRequestingAdminUsage());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
