package uk.gov.gchq.gaffer.federated.simple.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import uk.gov.gchq.gaffer.federated.simple.operation.ChangeGraphId.Builder;
import uk.gov.gchq.gaffer.operation.Operation;

class ChangeGraphIdDiffblueTest {
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
    ChangeGraphId _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getGraphId());
    assertNull(_getOpResult.getNewGraphId());
    assertNull(_getOpResult.getOptions());
    ChangeGraphId actualChangeGraphId = actualBuilder.build();
    assertSame(_getOpResult, actualChangeGraphId);
  }

  /**
   * Test Builder {@link Builder#newGraphId(String)}.
   *
   * <p>Method under test: {@link Builder#newGraphId(String)}
   */
  @Test
  @DisplayName("Test Builder newGraphId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newGraphId(String)"})
  void testBuilderNewGraphId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualNewGraphIdResult = builder.newGraphId("42");

    // Assert
    assertSame(builder, actualNewGraphIdResult);
  }

  /**
   * Test {@link ChangeGraphId#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ChangeGraphId} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphId#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ChangeGraphId (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation ChangeGraphId.shallowClone()"})
  void testShallowClone_givenChangeGraphIdOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    ChangeGraphId changeGraphId = new ChangeGraphId();
    changeGraphId.setOptions(new HashMap<>());

    // Act
    Operation actualShallowCloneResult = changeGraphId.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof ChangeGraphId);
    assertNull(((ChangeGraphId) actualShallowCloneResult).getGraphId());
    assertNull(((ChangeGraphId) actualShallowCloneResult).getNewGraphId());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link ChangeGraphId#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ChangeGraphId} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphId#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ChangeGraphId (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation ChangeGraphId.shallowClone()"})
  void testShallowClone_givenChangeGraphId_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    Operation actualShallowCloneResult = new ChangeGraphId().shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof ChangeGraphId);
    assertNull(((ChangeGraphId) actualShallowCloneResult).getGraphId());
    assertNull(((ChangeGraphId) actualShallowCloneResult).getNewGraphId());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ChangeGraphId}
   *   <li>{@link ChangeGraphId#setGraphId(String)}
   *   <li>{@link ChangeGraphId#setNewGraphId(String)}
   *   <li>{@link ChangeGraphId#setOptions(Map)}
   *   <li>{@link ChangeGraphId#getGraphId()}
   *   <li>{@link ChangeGraphId#getNewGraphId()}
   *   <li>{@link ChangeGraphId#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeGraphId.<init>()",
    "String ChangeGraphId.getGraphId()",
    "String ChangeGraphId.getNewGraphId()",
    "Map ChangeGraphId.getOptions()",
    "void ChangeGraphId.setGraphId(String)",
    "void ChangeGraphId.setNewGraphId(String)",
    "void ChangeGraphId.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ChangeGraphId actualChangeGraphId = new ChangeGraphId();
    actualChangeGraphId.setGraphId("42");
    actualChangeGraphId.setNewGraphId("42");
    HashMap<String, String> options = new HashMap<>();
    actualChangeGraphId.setOptions(options);
    String actualGraphId = actualChangeGraphId.getGraphId();
    String actualNewGraphId = actualChangeGraphId.getNewGraphId();
    Map<String, String> actualOptions = actualChangeGraphId.getOptions();

    // Assert
    assertEquals("42", actualGraphId);
    assertEquals("42", actualNewGraphId);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
