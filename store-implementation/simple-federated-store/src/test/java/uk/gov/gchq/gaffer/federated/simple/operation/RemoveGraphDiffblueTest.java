package uk.gov.gchq.gaffer.federated.simple.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federated.simple.operation.RemoveGraph.Builder;
import uk.gov.gchq.gaffer.operation.Operation;

class RemoveGraphDiffblueTest {
  /**
   * Test Builder {@link Builder#deleteAllData(boolean)}.
   *
   * <p>Method under test: {@link Builder#deleteAllData(boolean)}
   */
  @Test
  @DisplayName("Test Builder deleteAllData(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.deleteAllData(boolean)"})
  void testBuilderDeleteAllData() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDeleteAllDataResult = builder.deleteAllData(true);

    // Assert
    assertSame(builder, actualDeleteAllDataResult);
  }

  /**
   * Test Builder {@link Builder#graphId(String)}.
   *
   * <p>Method under test: {@link Builder#graphId(String)}
   */
  @Test
  @DisplayName("Test Builder graphId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphId(String)"})
  void testBuilderGraphId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphIdResult = builder.graphId("42");

    // Assert
    assertSame(builder, actualGraphIdResult);
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
    RemoveGraph _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getGraphId());
    assertNull(_getOpResult.getOptions());
    assertFalse(_getOpResult.getDeleteAllData());
    RemoveGraph actualRemoveGraph = actualBuilder.build();
    assertSame(_getOpResult, actualRemoveGraph);
  }

  /**
   * Test {@link RemoveGraph#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link RemoveGraph} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link RemoveGraph#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given RemoveGraph (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation RemoveGraph.shallowClone()"})
  void testShallowClone_givenRemoveGraphOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    RemoveGraph removeGraph = new RemoveGraph();
    removeGraph.setOptions(new HashMap<>());

    // Act
    Operation actualShallowCloneResult = removeGraph.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof RemoveGraph);
    assertNull(((RemoveGraph) actualShallowCloneResult).getGraphId());
    assertFalse(((RemoveGraph) actualShallowCloneResult).getDeleteAllData());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link RemoveGraph#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link RemoveGraph} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveGraph#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given RemoveGraph (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation RemoveGraph.shallowClone()"})
  void testShallowClone_givenRemoveGraph_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    Operation actualShallowCloneResult = new RemoveGraph().shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof RemoveGraph);
    assertNull(((RemoveGraph) actualShallowCloneResult).getGraphId());
    assertNull(actualShallowCloneResult.getOptions());
    assertFalse(((RemoveGraph) actualShallowCloneResult).getDeleteAllData());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RemoveGraph}
   *   <li>{@link RemoveGraph#setDeleteAllData(boolean)}
   *   <li>{@link RemoveGraph#setGraphId(String)}
   *   <li>{@link RemoveGraph#setOptions(Map)}
   *   <li>{@link RemoveGraph#getDeleteAllData()}
   *   <li>{@link RemoveGraph#getGraphId()}
   *   <li>{@link RemoveGraph#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RemoveGraph.<init>()",
    "boolean RemoveGraph.getDeleteAllData()",
    "String RemoveGraph.getGraphId()",
    "Map RemoveGraph.getOptions()",
    "void RemoveGraph.setDeleteAllData(boolean)",
    "void RemoveGraph.setGraphId(String)",
    "void RemoveGraph.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RemoveGraph actualRemoveGraph = new RemoveGraph();
    actualRemoveGraph.setDeleteAllData(true);
    actualRemoveGraph.setGraphId("42");
    HashMap<String, String> options = new HashMap<>();
    actualRemoveGraph.setOptions(options);
    boolean actualDeleteAllData = actualRemoveGraph.getDeleteAllData();
    String actualGraphId = actualRemoveGraph.getGraphId();
    Map<String, String> actualOptions = actualRemoveGraph.getOptions();

    // Assert
    assertEquals("42", actualGraphId);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualDeleteAllData);
    assertSame(options, actualOptions);
  }
}
