package uk.gov.gchq.gaffer.tinkerpop.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopVertex;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class GafferEntityGeneratorDiffblueTest {
  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return Vertex size is one.
   * </ul>
   *
   * <p>Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopVertex) with 'GafferPopVertex'; given '42'; then return Vertex size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  void test_applyWithGafferPopVertex_given42_thenReturnVertexSizeIsOne() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    GafferPopVertex vertex = new GafferPopVertex("Label", objectList, null);

    // Act and Assert
    Object vertex2 = gafferEntityGenerator._apply(vertex).getVertex();
    assertTrue(vertex2 instanceof List);
    assertEquals(1, ((List<String>) vertex2).size());
    assertEquals("42", ((List<String>) vertex2).get(0));
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return Vertex size is two.
   * </ul>
   *
   * <p>Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopVertex) with 'GafferPopVertex'; given '42'; then return Vertex size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  void test_applyWithGafferPopVertex_given42_thenReturnVertexSizeIsTwo() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");
    GafferPopVertex vertex = new GafferPopVertex("Label", objectList, null);

    // Act and Assert
    Object vertex2 = gafferEntityGenerator._apply(vertex).getVertex();
    assertTrue(vertex2 instanceof List);
    assertEquals(2, ((List<String>) vertex2).size());
    assertEquals("42", ((List<String>) vertex2).get(0));
    assertEquals("42", ((List<String>) vertex2).get(1));
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   *
   * <ul>
   *   <li>Then return Group is {@code Label}.
   * </ul>
   *
   * <p>Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @DisplayName("Test _apply(GafferPopVertex) with 'GafferPopVertex'; then return Group is 'Label'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  void test_applyWithGafferPopVertex_thenReturnGroupIsLabel() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();
    GafferPopVertex vertex = new GafferPopVertex("Label", new ArrayList<>(), null);

    // Act
    Entity actual_applyResult = gafferEntityGenerator._apply(vertex);

    // Assert
    Object vertex2 = actual_applyResult.getVertex();
    assertTrue(vertex2 instanceof List);
    assertEquals("Label", actual_applyResult.getGroup());
    assertTrue(((List<Object>) vertex2).isEmpty());
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   *
   * <ul>
   *   <li>Then return Group is {@code xx[type=xx, subType=xx, value=xx]}.
   * </ul>
   *
   * <p>Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopVertex) with 'GafferPopVertex'; then return Group is 'xx[type=xx, subType=xx, value=xx]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  void test_applyWithGafferPopVertex_thenReturnGroupIsXxTypeXxSubTypeXxValueXx() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();
    GafferPopVertex vertex = new GafferPopVertex("xx[type=xx,  subType=xx,  value=xx]", "Id", null);

    // Act
    Entity actual_applyResult = gafferEntityGenerator._apply(vertex);

    // Assert
    assertEquals("Id", actual_applyResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertEquals("xx[type=xx,  subType=xx,  value=xx]", actual_applyResult.getGroup());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   *
   * <ul>
   *   <li>Then return Vertex intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopVertex) with 'GafferPopVertex'; then return Vertex intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  void test_applyWithGafferPopVertex_thenReturnVertexIntValueIsOne() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();

    // Act
    Entity actual_applyResult = gafferEntityGenerator._apply(new GafferPopVertex("Label", 1, null));

    // Assert
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertEquals(1, ((Integer) actual_applyResult.getVertex()).intValue());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   *
   * <ul>
   *   <li>Then Vertex return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @DisplayName("Test _apply(GafferPopVertex) with 'GafferPopVertex'; then Vertex return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  void test_applyWithGafferPopVertex_thenVertexReturnSet() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();
    GafferPopVertex vertex = new GafferPopVertex("Label", new HashSet<>(), null);

    // Act
    Entity actual_applyResult = gafferEntityGenerator._apply(vertex);

    // Assert
    Object vertex2 = actual_applyResult.getVertex();
    assertTrue(vertex2 instanceof Set);
    assertEquals("Label", actual_applyResult.getGroup());
    assertTrue(((Set<Object>) vertex2).isEmpty());
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   *
   * <ul>
   *   <li>Then Vertex return {@link TypeSubTypeValue}.
   * </ul>
   *
   * <p>Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopVertex) with 'GafferPopVertex'; then Vertex return TypeSubTypeValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  void test_applyWithGafferPopVertex_thenVertexReturnTypeSubTypeValue() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();
    GafferPopVertex vertex =
        new GafferPopVertex("Label", "xx[type=xx,  subType=xx,  value=xx]", null);

    // Act and Assert
    Object vertex2 = gafferEntityGenerator._apply(vertex).getVertex();
    assertTrue(vertex2 instanceof TypeSubTypeValue);
    assertEquals("xx", ((TypeSubTypeValue) vertex2).getSubType());
    assertEquals("xx", ((TypeSubTypeValue) vertex2).getType());
    assertEquals("xx", ((TypeSubTypeValue) vertex2).getValue());
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   *
   * <ul>
   *   <li>When {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and {@code Id} and graph is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopVertex) with 'GafferPopVertex'; when GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and 'Id' and graph is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  void test_applyWithGafferPopVertex_whenGafferPopVertexWithLabelAndIdAndGraphIsNull() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();
    GafferPopVertex vertex = new GafferPopVertex("Label", "Id", null);

    // Act
    Entity actual_applyResult = gafferEntityGenerator._apply(vertex);

    // Assert
    assertEquals("Id", actual_applyResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @DisplayName(
      "Test _apply(GafferPopVertex) with 'GafferPopVertex'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  void test_applyWithGafferPopVertex_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GafferEntityGenerator()._apply(null));
  }
}
