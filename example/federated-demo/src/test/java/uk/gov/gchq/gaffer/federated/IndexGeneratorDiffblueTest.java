package uk.gov.gchq.gaffer.federated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class IndexGeneratorDiffblueTest {
  /**
   * Test {@link IndexGenerator#_apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Then return first ClassName is {@code Entity}.
   * </ul>
   *
   * <p>Method under test: {@link IndexGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element) with 'Element'; then return first ClassName is 'uk.gov.gchq.gaffer.data.element.Entity'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithElement_thenReturnFirstClassNameIsUkGovGchqGafferDataElementEntity() {
    // Arrange
    IndexGenerator indexGenerator = new IndexGenerator();

    Entity element = new Entity("Group");
    element.putProperty("Name", "Value");

    // Act
    Iterable<Element> actual_applyResult = indexGenerator._apply(element);
    Iterator<Element> actualIteratorResult = actual_applyResult.iterator();

    // Assert
    assertTrue(actual_applyResult instanceof List);
    assertEquals(1, ((List<Element>) actual_applyResult).size());
    Element getResult = ((List<Element>) actual_applyResult).get(0);
    assertTrue(getResult instanceof Entity);
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", getResult.getClassName());
    assertEquals("Name|Entity", getResult.getGroup());
    assertTrue(getResult.getProperties().isEmpty());
    assertEquals("Value", ((Entity) getResult).getVertex());
    Element actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(getResult, actualNextResult);
  }

  /**
   * Test {@link IndexGenerator#_apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Then return first Group is {@code Name|Edge}.
   * </ul>
   *
   * <p>Method under test: {@link IndexGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element) with 'Element'; then return first Group is 'Name|Edge'")
  @Tag("MaintainedByDiffblue")
  void test_applyWithElement_thenReturnFirstGroupIsNameEdge() {
    // Arrange
    IndexGenerator indexGenerator = new IndexGenerator();

    Edge element =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    element.putProperty("Name", "Value");

    // Act
    Iterable<Element> actual_applyResult = indexGenerator._apply(element);
    Iterator<Element> actualIteratorResult = actual_applyResult.iterator();

    // Assert
    assertTrue(actual_applyResult instanceof List);
    assertEquals(1, ((List<Element>) actual_applyResult).size());
    Element getResult = ((List<Element>) actual_applyResult).get(0);
    assertTrue(getResult instanceof Entity);
    assertEquals("Name|Edge", getResult.getGroup());
    Properties properties = getResult.getProperties();
    assertEquals(3, properties.size());
    Object getResult2 = properties.get("directed");
    Object getResult3 = properties.get("destination");
    assertTrue((Boolean) getResult2);
    assertEquals("Dest", getResult3);
    assertEquals("Source", properties.get("source"));
    Element actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(getResult, actualNextResult);
  }

  /**
   * Test {@link IndexGenerator#_apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link IndexGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element) with 'Element'; when Entity(String) with 'Group'; then return Empty")
  @Tag("MaintainedByDiffblue")
  void test_applyWithElement_whenEntityWithGroup_thenReturnEmpty() {
    // Arrange
    IndexGenerator indexGenerator = new IndexGenerator();

    // Act
    Iterable<Element> actual_applyResult = indexGenerator._apply(new Entity("Group"));
    Iterator<Element> actualIteratorResult = actual_applyResult.iterator();

    // Assert
    assertTrue(actual_applyResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Element>) actual_applyResult).isEmpty());
  }
}
