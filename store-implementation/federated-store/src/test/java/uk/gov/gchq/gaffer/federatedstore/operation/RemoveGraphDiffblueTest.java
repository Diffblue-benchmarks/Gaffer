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
import uk.gov.gchq.gaffer.federatedstore.operation.RemoveGraph.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class RemoveGraphDiffblueTest {
  /**
   * Test Builder {@link Builder#graphId(String)}.
   * <p>
   * Method under test: {@link Builder#graphId(String)}
   */
  @Test
  @DisplayName("Test Builder graphId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.graphId(String)"})
  void testBuilderGraphId() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.graphId("42"));
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
    RemoveGraph _getOpResult = actualBuilder._getOp();
    TypeReference<Boolean> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Boolean);
    assertNull(_getOpResult.getGraphId());
    assertNull(_getOpResult.getOptions());
    assertFalse(_getOpResult.isUserRequestingAdminUsage());
    assertTrue(_getOpResult.isRemoveCache());
    Class<Boolean> expectedOutputClass = Boolean.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test Builder {@link Builder#removeCache(boolean)}.
   * <p>
   * Method under test: {@link Builder#removeCache(boolean)}
   */
  @Test
  @DisplayName("Test Builder removeCache(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.removeCache(boolean)"})
  void testBuilderRemoveCache() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.removeCache(true));
  }

  /**
   * Test {@link RemoveGraph#shallowClone()}.
   * <ul>
   *   <li>Given {@link RemoveGraphAndDeleteAllData} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveGraph#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given RemoveGraphAndDeleteAllData (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoveGraph RemoveGraph.shallowClone()"})
  void testShallowClone_givenRemoveGraphAndDeleteAllData() throws CloneFailedException {
    // Arrange and Act
    RemoveGraphAndDeleteAllData actualShallowCloneResult = (new RemoveGraphAndDeleteAllData()).shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof RemoveGraphAndDeleteAllData);
    assertTrue(actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test {@link RemoveGraph#shallowClone()}.
   * <ul>
   *   <li>Given {@link RemoveGraph} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveGraph#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given RemoveGraph (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoveGraph RemoveGraph.shallowClone()"})
  void testShallowClone_givenRemoveGraphOptionsIsHashMap_thenReturnOptionsEmpty() throws CloneFailedException {
    // Arrange
    RemoveGraph removeGraph = new RemoveGraph();
    removeGraph.setOptions(new HashMap<>());

    // Act
    RemoveGraph actualShallowCloneResult = removeGraph.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link RemoveGraph#shallowClone()}.
   * <ul>
   *   <li>Given {@link RemoveGraph} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveGraph#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given RemoveGraph (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoveGraph RemoveGraph.shallowClone()"})
  void testShallowClone_givenRemoveGraph_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    RemoveGraph actualShallowCloneResult = (new RemoveGraph()).shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
    assertNull(actualShallowCloneResult.getOptions());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
  }

  /**
   * Test {@link RemoveGraph#shallowClone()}.
   * <ul>
   *   <li>Then return UserRequestingAdminUsage.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveGraph#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return UserRequestingAdminUsage")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoveGraph RemoveGraph.shallowClone()"})
  void testShallowClone_thenReturnUserRequestingAdminUsage() throws CloneFailedException {
    // Arrange
    RemoveGraphAndDeleteAllData removeGraphAndDeleteAllData = new RemoveGraphAndDeleteAllData();
    removeGraphAndDeleteAllData.setUserRequestingAdminUsage(true);

    // Act
    RemoveGraphAndDeleteAllData actualShallowCloneResult = removeGraphAndDeleteAllData.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof RemoveGraphAndDeleteAllData);
    assertTrue(actualShallowCloneResult.getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
    assertTrue(actualShallowCloneResult.isUserRequestingAdminUsage());
  }

  /**
   * Test {@link RemoveGraph#setUserRequestingAdminUsage(boolean)}.
   * <p>
   * Method under test: {@link RemoveGraph#setUserRequestingAdminUsage(boolean)}
   */
  @Test
  @DisplayName("Test setUserRequestingAdminUsage(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoveGraph RemoveGraph.setUserRequestingAdminUsage(boolean)"})
  void testSetUserRequestingAdminUsage() {
    // Arrange
    RemoveGraph removeGraph = new RemoveGraph();

    // Act
    RemoveGraph actualSetUserRequestingAdminUsageResult = removeGraph.setUserRequestingAdminUsage(true);

    // Assert
    assertTrue(removeGraph.isUserRequestingAdminUsage());
    assertSame(removeGraph, actualSetUserRequestingAdminUsageResult);
  }

  /**
   * Test {@link RemoveGraph#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link RemoveGraph#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference RemoveGraph.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue((new RemoveGraph()).getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RemoveGraph}
   *   <li>{@link RemoveGraph#setGraphId(String)}
   *   <li>{@link RemoveGraph#setOptions(Map)}
   *   <li>{@link RemoveGraph#setRemoveCache(boolean)}
   *   <li>{@link RemoveGraph#getGraphId()}
   *   <li>{@link RemoveGraph#getOptions()}
   *   <li>{@link RemoveGraph#isRemoveCache()}
   *   <li>{@link RemoveGraph#isUserRequestingAdminUsage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RemoveGraph.<init>()", "String RemoveGraph.getGraphId()", "Map RemoveGraph.getOptions()",
      "boolean RemoveGraph.isRemoveCache()", "boolean RemoveGraph.isUserRequestingAdminUsage()",
      "void RemoveGraph.setGraphId(String)", "void RemoveGraph.setOptions(Map)",
      "void RemoveGraph.setRemoveCache(boolean)"})
  void testGettersAndSetters() {
    // Arrange and Act
    RemoveGraph actualRemoveGraph = new RemoveGraph();
    actualRemoveGraph.setGraphId("42");
    HashMap<String, String> options = new HashMap<>();
    actualRemoveGraph.setOptions(options);
    actualRemoveGraph.setRemoveCache(true);
    String actualGraphId = actualRemoveGraph.getGraphId();
    Map<String, String> actualOptions = actualRemoveGraph.getOptions();
    boolean actualIsRemoveCacheResult = actualRemoveGraph.isRemoveCache();

    // Assert
    assertEquals("42", actualGraphId);
    assertFalse(actualRemoveGraph.isUserRequestingAdminUsage());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsRemoveCacheResult);
    assertSame(options, actualOptions);
  }
}
