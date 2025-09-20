package uk.gov.gchq.gaffer.tinkerpop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GafferPopGraphVariablesDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GafferPopGraphVariables#GafferPopGraphVariables()}
   *   <li>{@link GafferPopGraphVariables#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("variables[size:0]", new GafferPopGraphVariables().toString());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GafferPopGraphVariables#GafferPopGraphVariables(Map)}
   *   <li>{@link GafferPopGraphVariables#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashMap()")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenHashMap() {
    // Arrange, Act and Assert
    assertEquals("variables[size:0]", new GafferPopGraphVariables(new HashMap<>()).toString());
  }

  /**
   * Test {@link GafferPopGraphVariables#keys()}.
   *
   * <p>Method under test: {@link GafferPopGraphVariables#keys()}
   */
  @Test
  @DisplayName("Test keys()")
  @Tag("MaintainedByDiffblue")
  void testKeys() {
    // Arrange, Act and Assert
    assertTrue(new GafferPopGraphVariables().keys().isEmpty());
  }

  /**
   * Test {@link GafferPopGraphVariables#get(String)}.
   *
   * <p>Method under test: {@link GafferPopGraphVariables#get(String)}
   */
  @Test
  @DisplayName("Test get(String)")
  @Tag("MaintainedByDiffblue")
  void testGet() {
    // Arrange, Act and Assert
    assertFalse(new GafferPopGraphVariables().get("Key").isPresent());
  }

  /**
   * Test {@link GafferPopGraphVariables#set(String, Object)}.
   *
   * <p>Method under test: {@link GafferPopGraphVariables#set(String, Object)}
   */
  @Test
  @DisplayName("Test set(String, Object)")
  @Tag("MaintainedByDiffblue")
  void testSet() {
    // Arrange
    HashMap<String, Object> variables = new HashMap<>();
    variables.put(GafferPopGraphVariables.OP_OPTIONS, "Variables");
    GafferPopGraphVariables gafferPopGraphVariables = new GafferPopGraphVariables(variables);

    LinkedHashSet<Object> objectSet = new LinkedHashSet<>();
    objectSet.add("foo:bar");

    // Act
    gafferPopGraphVariables.set(GafferPopGraphVariables.OP_OPTIONS, objectSet);

    // Assert
    Map<String, String> operationOptions = gafferPopGraphVariables.getOperationOptions();
    assertEquals(1, operationOptions.size());
    assertEquals("bar", operationOptions.get("foo"));
  }

  /**
   * Test {@link GafferPopGraphVariables#set(String, Object)}.
   *
   * <p>Method under test: {@link GafferPopGraphVariables#set(String, Object)}
   */
  @Test
  @DisplayName("Test set(String, Object)")
  @Tag("MaintainedByDiffblue")
  void testSet2() {
    // Arrange
    HashMap<String, Object> variables = new HashMap<>();
    variables.put(GafferPopGraphVariables.OP_OPTIONS, "Variables");
    GafferPopGraphVariables gafferPopGraphVariables = new GafferPopGraphVariables(variables);

    LinkedHashSet<Object> objectSet = new LinkedHashSet<>();
    objectSet.add("");

    // Act
    gafferPopGraphVariables.set(GafferPopGraphVariables.INCLUDE_ORPHANED_VERTICES, objectSet);

    // Assert
    assertFalse(gafferPopGraphVariables.getIncludeOrphanedVertices());
  }

  /**
   * Test {@link GafferPopGraphVariables#set(String, Object)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link GafferPopGraphVariables#GafferPopGraphVariables()} OperationOptions is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraphVariables#set(String, Object)}
   */
  @Test
  @DisplayName(
      "Test set(String, Object); when HashMap(); then GafferPopGraphVariables() OperationOptions is HashMap()")
  @Tag("MaintainedByDiffblue")
  void testSet_whenHashMap_thenGafferPopGraphVariablesOperationOptionsIsHashMap() {
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
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then {@link GafferPopGraphVariables#GafferPopGraphVariables()} OperationOptions Empty.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraphVariables#set(String, Object)}
   */
  @Test
  @DisplayName(
      "Test set(String, Object); when 'Key'; then GafferPopGraphVariables() OperationOptions Empty")
  @Tag("MaintainedByDiffblue")
  void testSet_whenKey_thenGafferPopGraphVariablesOperationOptionsEmpty() {
    // Arrange
    GafferPopGraphVariables gafferPopGraphVariables = new GafferPopGraphVariables();

    // Act
    gafferPopGraphVariables.set("Key", "Value");

    // Assert that nothing has changed
    assertTrue(gafferPopGraphVariables.getOperationOptions().isEmpty());
  }

  /**
   * Test {@link GafferPopGraphVariables#set(String, Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then {@link GafferPopGraphVariables#GafferPopGraphVariables()} OperationOptions Empty.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraphVariables#set(String, Object)}
   */
  @Test
  @DisplayName(
      "Test set(String, Object); when 'Value'; then GafferPopGraphVariables() OperationOptions Empty")
  @Tag("MaintainedByDiffblue")
  void testSet_whenValue_thenGafferPopGraphVariablesOperationOptionsEmpty() {
    // Arrange
    GafferPopGraphVariables gafferPopGraphVariables = new GafferPopGraphVariables();

    // Act
    gafferPopGraphVariables.set(GafferPopGraphVariables.OP_OPTIONS, "Value");

    // Assert that nothing has changed
    assertTrue(gafferPopGraphVariables.getOperationOptions().isEmpty());
  }

  /**
   * Test {@link GafferPopGraphVariables#setOperationOptions(Iterable)}.
   *
   * <p>Method under test: {@link GafferPopGraphVariables#setOperationOptions(Iterable)}
   */
  @Test
  @DisplayName("Test setOperationOptions(Iterable)")
  @Tag("MaintainedByDiffblue")
  void testSetOperationOptions() {
    // Arrange
    HashMap<String, Object> variables = new HashMap<>();
    variables.put(GafferPopGraphVariables.OP_OPTIONS, "Variables");
    GafferPopGraphVariables gafferPopGraphVariables = new GafferPopGraphVariables(variables);

    LinkedHashSet<String> opOptions = new LinkedHashSet<>();
    opOptions.add("foo:bar");

    // Act
    gafferPopGraphVariables.setOperationOptions(opOptions);

    // Assert
    Map<String, String> operationOptions = gafferPopGraphVariables.getOperationOptions();
    assertEquals(1, operationOptions.size());
    assertEquals("bar", operationOptions.get("foo"));
  }

  /**
   * Test {@link GafferPopGraphVariables#setOperationOptions(Iterable)}.
   *
   * <ul>
   *   <li>Then {@link GafferPopGraphVariables#GafferPopGraphVariables()} OperationOptions Empty.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopGraphVariables#setOperationOptions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test setOperationOptions(Iterable); then GafferPopGraphVariables() OperationOptions Empty")
  @Tag("MaintainedByDiffblue")
  void testSetOperationOptions_thenGafferPopGraphVariablesOperationOptionsEmpty() {
    // Arrange
    GafferPopGraphVariables gafferPopGraphVariables = new GafferPopGraphVariables();

    // Act
    gafferPopGraphVariables.setOperationOptions(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(gafferPopGraphVariables.getOperationOptions().isEmpty());
  }

  /**
   * Test {@link GafferPopGraphVariables#getOperationOptions()}.
   *
   * <p>Method under test: {@link GafferPopGraphVariables#getOperationOptions()}
   */
  @Test
  @DisplayName("Test getOperationOptions()")
  @Tag("MaintainedByDiffblue")
  void testGetOperationOptions() {
    // Arrange, Act and Assert
    assertTrue(new GafferPopGraphVariables().getOperationOptions().isEmpty());
  }

  /**
   * Test {@link GafferPopGraphVariables#getUser()}.
   *
   * <p>Method under test: {@link GafferPopGraphVariables#getUser()}
   */
  @Test
  @DisplayName("Test getUser()")
  @Tag("MaintainedByDiffblue")
  void testGetUser() {
    // Arrange, Act and Assert
    assertNull(new GafferPopGraphVariables().getUser());
  }

  /**
   * Test {@link GafferPopGraphVariables#getElementsLimit()}.
   *
   * <p>Method under test: {@link GafferPopGraphVariables#getElementsLimit()}
   */
  @Test
  @DisplayName("Test getElementsLimit()")
  @Tag("MaintainedByDiffblue")
  void testGetElementsLimit() {
    // Arrange, Act and Assert
    assertNull(new GafferPopGraphVariables().getElementsLimit());
  }

  /**
   * Test {@link GafferPopGraphVariables#getHasStepFilterStage()}.
   *
   * <p>Method under test: {@link GafferPopGraphVariables#getHasStepFilterStage()}
   */
  @Test
  @DisplayName("Test getHasStepFilterStage()")
  @Tag("MaintainedByDiffblue")
  void testGetHasStepFilterStage() {
    // Arrange, Act and Assert
    assertNull(new GafferPopGraphVariables().getHasStepFilterStage());
  }

  /**
   * Test {@link GafferPopGraphVariables#getLastOperationChain()}.
   *
   * <p>Method under test: {@link GafferPopGraphVariables#getLastOperationChain()}
   */
  @Test
  @DisplayName("Test getLastOperationChain()")
  @Tag("MaintainedByDiffblue")
  void testGetLastOperationChain() {
    // Arrange, Act and Assert
    assertNull(new GafferPopGraphVariables().getLastOperationChain());
  }
}
