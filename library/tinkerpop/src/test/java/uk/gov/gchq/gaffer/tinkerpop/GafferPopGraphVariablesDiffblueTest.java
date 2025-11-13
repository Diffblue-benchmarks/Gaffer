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

package uk.gov.gchq.gaffer.tinkerpop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GafferPopGraphVariablesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GafferPopGraphVariables#GafferPopGraphVariables()}
   *   <li>{@link GafferPopGraphVariables#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraphVariables.<init>()", "void GafferPopGraphVariables.<init>(Map)",
      "String GafferPopGraphVariables.toString()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("variables[size:0]", (new GafferPopGraphVariables()).toString());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GafferPopGraphVariables#GafferPopGraphVariables(Map)}
   *   <li>{@link GafferPopGraphVariables#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraphVariables.<init>()", "void GafferPopGraphVariables.<init>(Map)",
      "String GafferPopGraphVariables.toString()"})
  public void testGettersAndSetters_whenHashMap() {
    // Arrange, Act and Assert
    assertEquals("variables[size:0]", (new GafferPopGraphVariables(new HashMap<>())).toString());
  }

  /**
   * Test {@link GafferPopGraphVariables#keys()}.
   * <p>
   * Method under test: {@link GafferPopGraphVariables#keys()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Set GafferPopGraphVariables.keys()"})
  public void testKeys() {
    // Arrange, Act and Assert
    assertTrue((new GafferPopGraphVariables()).keys().isEmpty());
  }

  /**
   * Test {@link GafferPopGraphVariables#get(String)}.
   * <p>
   * Method under test: {@link GafferPopGraphVariables#get(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Optional GafferPopGraphVariables.get(String)"})
  public void testGet() {
    // Arrange, Act and Assert
    assertFalse((new GafferPopGraphVariables()).get("Key").isPresent());
  }

  /**
   * Test {@link GafferPopGraphVariables#set(String, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link GafferPopGraphVariables#USER}.</li>
   *   <li>Then {@link GafferPopGraphVariables#GafferPopGraphVariables()} OperationOptions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraphVariables#set(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraphVariables.set(String, Object)"})
  public void testSet_given42_whenUser_thenGafferPopGraphVariablesOperationOptionsEmpty() {
    // Arrange
    GafferPopGraphVariables gafferPopGraphVariables = new GafferPopGraphVariables();

    LinkedHashSet<Object> objectSet = new LinkedHashSet<>();
    objectSet.add("42");

    // Act
    gafferPopGraphVariables.set(GafferPopGraphVariables.USER, objectSet);

    // Assert that nothing has changed
    assertTrue(gafferPopGraphVariables.getOperationOptions().isEmpty());
  }

  /**
   * Test {@link GafferPopGraphVariables#set(String, Object)}.
   * <ul>
   *   <li>Then {@link GafferPopGraphVariables#GafferPopGraphVariables()} OperationOptions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraphVariables#set(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraphVariables.set(String, Object)"})
  public void testSet_thenGafferPopGraphVariablesOperationOptionsSizeIsOne() {
    // Arrange
    GafferPopGraphVariables gafferPopGraphVariables = new GafferPopGraphVariables();

    LinkedHashSet<Object> objectSet = new LinkedHashSet<>();
    objectSet.add("Updating graph variable: {} to {}");

    // Act
    gafferPopGraphVariables.set(GafferPopGraphVariables.OP_OPTIONS, objectSet);

    // Assert
    Map<String, String> operationOptions = gafferPopGraphVariables.getOperationOptions();
    assertEquals(1, operationOptions.size());
    assertEquals(" {} to {}", operationOptions.get("Updating graph variable"));
  }

  /**
   * Test {@link GafferPopGraphVariables#set(String, Object)}.
   * <ul>
   *   <li>Then not {@link GafferPopGraphVariables#GafferPopGraphVariables()} IncludeOrphanedVertices.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraphVariables#set(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraphVariables.set(String, Object)"})
  public void testSet_thenNotGafferPopGraphVariablesIncludeOrphanedVertices() {
    // Arrange
    GafferPopGraphVariables gafferPopGraphVariables = new GafferPopGraphVariables();

    LinkedHashSet<Object> objectSet = new LinkedHashSet<>();
    objectSet.add("42");

    // Act
    gafferPopGraphVariables.set(GafferPopGraphVariables.INCLUDE_ORPHANED_VERTICES, objectSet);

    // Assert
    assertFalse(gafferPopGraphVariables.getIncludeOrphanedVertices());
    assertTrue(gafferPopGraphVariables.getOperationOptions().isEmpty());
  }

  /**
   * Test {@link GafferPopGraphVariables#set(String, Object)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link GafferPopGraphVariables#GafferPopGraphVariables()} OperationOptions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraphVariables#set(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraphVariables.set(String, Object)"})
  public void testSet_whenArrayList_thenGafferPopGraphVariablesOperationOptionsEmpty() {
    // Arrange
    GafferPopGraphVariables gafferPopGraphVariables = new GafferPopGraphVariables();

    // Act
    gafferPopGraphVariables.set(GafferPopGraphVariables.OP_OPTIONS, new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(gafferPopGraphVariables.getOperationOptions().isEmpty());
  }

  /**
   * Test {@link GafferPopGraphVariables#set(String, Object)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link GafferPopGraphVariables#GafferPopGraphVariables()} OperationOptions is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraphVariables#set(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraphVariables.set(String, Object)"})
  public void testSet_whenHashMap_thenGafferPopGraphVariablesOperationOptionsIsHashMap() {
    // Arrange
    GafferPopGraphVariables gafferPopGraphVariables = new GafferPopGraphVariables();
    HashMap<Object, Object> objectObjectMap = new HashMap<>();

    // Act
    gafferPopGraphVariables.set(GafferPopGraphVariables.OP_OPTIONS, objectObjectMap);

    // Assert
    assertSame(objectObjectMap, gafferPopGraphVariables.getOperationOptions());
  }

  /**
   * Test {@link GafferPopGraphVariables#set(String, Object)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then {@link GafferPopGraphVariables#GafferPopGraphVariables()} OperationOptions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraphVariables#set(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraphVariables.set(String, Object)"})
  public void testSet_whenKey_thenGafferPopGraphVariablesOperationOptionsEmpty() {
    // Arrange
    GafferPopGraphVariables gafferPopGraphVariables = new GafferPopGraphVariables();

    // Act
    gafferPopGraphVariables.set("Key", "Value");

    // Assert that nothing has changed
    assertTrue(gafferPopGraphVariables.getOperationOptions().isEmpty());
  }

  /**
   * Test {@link GafferPopGraphVariables#set(String, Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then {@link GafferPopGraphVariables#GafferPopGraphVariables()} OperationOptions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopGraphVariables#set(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopGraphVariables.set(String, Object)"})
  public void testSet_whenValue_thenGafferPopGraphVariablesOperationOptionsEmpty() {
    // Arrange
    GafferPopGraphVariables gafferPopGraphVariables = new GafferPopGraphVariables();

    // Act
    gafferPopGraphVariables.set(GafferPopGraphVariables.OP_OPTIONS, "Value");

    // Assert that nothing has changed
    assertTrue(gafferPopGraphVariables.getOperationOptions().isEmpty());
  }

  /**
   * Test {@link GafferPopGraphVariables#getOperationOptions()}.
   * <p>
   * Method under test: {@link GafferPopGraphVariables#getOperationOptions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map GafferPopGraphVariables.getOperationOptions()"})
  public void testGetOperationOptions() {
    // Arrange, Act and Assert
    assertTrue((new GafferPopGraphVariables()).getOperationOptions().isEmpty());
  }

  /**
   * Test {@link GafferPopGraphVariables#getUser()}.
   * <p>
   * Method under test: {@link GafferPopGraphVariables#getUser()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"uk.gov.gchq.gaffer.user.User GafferPopGraphVariables.getUser()"})
  public void testGetUser() {
    // Arrange, Act and Assert
    assertNull((new GafferPopGraphVariables()).getUser());
  }

  /**
   * Test {@link GafferPopGraphVariables#getElementsLimit()}.
   * <p>
   * Method under test: {@link GafferPopGraphVariables#getElementsLimit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Integer GafferPopGraphVariables.getElementsLimit()"})
  public void testGetElementsLimit() {
    // Arrange, Act and Assert
    assertNull((new GafferPopGraphVariables()).getElementsLimit());
  }

  /**
   * Test {@link GafferPopGraphVariables#getHasStepFilterStage()}.
   * <p>
   * Method under test: {@link GafferPopGraphVariables#getHasStepFilterStage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String GafferPopGraphVariables.getHasStepFilterStage()"})
  public void testGetHasStepFilterStage() {
    // Arrange, Act and Assert
    assertNull((new GafferPopGraphVariables()).getHasStepFilterStage());
  }

  /**
   * Test {@link GafferPopGraphVariables#getLastOperationChain()}.
   * <p>
   * Method under test: {@link GafferPopGraphVariables#getLastOperationChain()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"uk.gov.gchq.gaffer.operation.OperationChain GafferPopGraphVariables.getLastOperationChain()"})
  public void testGetLastOperationChain() {
    // Arrange, Act and Assert
    assertNull((new GafferPopGraphVariables()).getLastOperationChain());
  }
}
