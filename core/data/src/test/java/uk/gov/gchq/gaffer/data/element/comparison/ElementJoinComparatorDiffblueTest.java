package uk.gov.gchq.gaffer.data.element.comparison;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class ElementJoinComparatorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementJoinComparator#ElementJoinComparator()}
   *   <li>{@link ElementJoinComparator#setGroupByProperties(Set)}
   *   <li>{@link ElementJoinComparator#getGroupByProperties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ElementJoinComparator.<init>()",
    "Set ElementJoinComparator.getGroupByProperties()",
    "void ElementJoinComparator.setGroupByProperties(Set)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ElementJoinComparator actualElementJoinComparator = new ElementJoinComparator();
    HashSet<String> groupByProperties = new HashSet<>();
    actualElementJoinComparator.setGroupByProperties(groupByProperties);
    Set<String> actualGroupByProperties = actualElementJoinComparator.getGroupByProperties();

    // Assert
    assertTrue(actualGroupByProperties.isEmpty());
    assertSame(groupByProperties, actualGroupByProperties);
  }

  /**
   * Test {@link ElementJoinComparator#ElementJoinComparator(Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#ElementJoinComparator(Set)}
   */
  @Test
  @DisplayName("Test new ElementJoinComparator(Set); given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementJoinComparator.<init>(Set)"})
  void testNewElementJoinComparator_given42_whenHashSetAdd42() {
    // Arrange
    HashSet<String> groupByProperties = new HashSet<>();
    groupByProperties.add("42");
    groupByProperties.add("foo");

    // Act and Assert
    assertEquals(
        groupByProperties, new ElementJoinComparator(groupByProperties).getGroupByProperties());
  }

  /**
   * Test {@link ElementJoinComparator#ElementJoinComparator(Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return GroupByProperties is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#ElementJoinComparator(Set)}
   */
  @Test
  @DisplayName(
      "Test new ElementJoinComparator(Set); given 'foo'; then return GroupByProperties is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementJoinComparator.<init>(Set)"})
  void testNewElementJoinComparator_givenFoo_thenReturnGroupByPropertiesIsHashSet() {
    // Arrange
    HashSet<String> groupByProperties = new HashSet<>();
    groupByProperties.add("foo");

    // Act and Assert
    assertEquals(
        groupByProperties, new ElementJoinComparator(groupByProperties).getGroupByProperties());
  }

  /**
   * Test {@link ElementJoinComparator#ElementJoinComparator(String[])}.
   *
   * <ul>
   *   <li>Then return GroupByProperties size is one.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#ElementJoinComparator(String[])}
   */
  @Test
  @DisplayName(
      "Test new ElementJoinComparator(String[]); then return GroupByProperties size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementJoinComparator.<init>(String[])"})
  void testNewElementJoinComparator_thenReturnGroupByPropertiesSizeIsOne() {
    // Arrange, Act and Assert
    Set<String> groupByProperties =
        new ElementJoinComparator("Group By Properties").getGroupByProperties();
    assertEquals(1, groupByProperties.size());
    assertTrue(groupByProperties.contains("Group By Properties"));
  }

  /**
   * Test {@link ElementJoinComparator#ElementJoinComparator(String[])}.
   *
   * <ul>
   *   <li>Then return GroupByProperties size is two.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#ElementJoinComparator(String[])}
   */
  @Test
  @DisplayName(
      "Test new ElementJoinComparator(String[]); then return GroupByProperties size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementJoinComparator.<init>(String[])"})
  void testNewElementJoinComparator_thenReturnGroupByPropertiesSizeIsTwo() {
    // Arrange and Act
    ElementJoinComparator actualElementJoinComparator =
        new ElementJoinComparator(
            "Group By Properties", "uk.gov.gchq.gaffer.data.element.Edge", "Group By Properties");

    // Assert
    Set<String> groupByProperties = actualElementJoinComparator.getGroupByProperties();
    assertEquals(2, groupByProperties.size());
    assertTrue(groupByProperties.contains("Group By Properties"));
    assertTrue(groupByProperties.contains("uk.gov.gchq.gaffer.data.element.Edge"));
  }

  /**
   * Test {@link ElementJoinComparator#ElementJoinComparator(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return GroupByProperties Empty.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#ElementJoinComparator(Set)}
   */
  @Test
  @DisplayName(
      "Test new ElementJoinComparator(Set); when HashSet(); then return GroupByProperties Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementJoinComparator.<init>(Set)"})
  void testNewElementJoinComparator_whenHashSet_thenReturnGroupByPropertiesEmpty() {
    // Arrange, Act and Assert
    assertTrue(new ElementJoinComparator(new HashSet<>()).getGroupByProperties().isEmpty());
  }

  /**
   * Test {@link ElementJoinComparator#test(Element, Element)} with {@code element}, {@code
   * element2}.
   *
   * <p>Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  @DisplayName("Test test(Element, Element) with 'element', 'element2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementJoinComparator.test(Element, Element)"})
  void testTestWithElementElement2() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();
    Edge element =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    Edge element2 = new Edge("Group", "Source", "Destination", true);

    // Act and Assert
    assertFalse(elementJoinComparator.test(element, element2));
  }

  /**
   * Test {@link ElementJoinComparator#test(Element, Element)} with {@code element}, {@code
   * element2}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  @DisplayName(
      "Test test(Element, Element) with 'element', 'element2'; given LinkedHashSet() add 'foo'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementJoinComparator.test(Element, Element)"})
  void testTestWithElementElement2_givenLinkedHashSetAddFoo_thenReturnTrue() {
    // Arrange
    LinkedHashSet<String> groupByProperties = new LinkedHashSet<>();
    groupByProperties.add("foo");

    ElementJoinComparator elementJoinComparator = new ElementJoinComparator(new HashSet<>());
    elementJoinComparator.setGroupByProperties(groupByProperties);
    Edge element =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertTrue(
        elementJoinComparator.test(
            element,
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build()));
  }

  /**
   * Test {@link ElementJoinComparator#test(Element, Element)} with {@code element}, {@code
   * element2}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code foo}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  @DisplayName(
      "Test test(Element, Element) with 'element', 'element2'; given LinkedHashSet() add 'foo'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementJoinComparator.test(Element, Element)"})
  void testTestWithElementElement2_givenLinkedHashSetAddFoo_whenNull_thenReturnFalse() {
    // Arrange
    LinkedHashSet<String> groupByProperties = new LinkedHashSet<>();
    groupByProperties.add("foo");

    ElementJoinComparator elementJoinComparator = new ElementJoinComparator(new HashSet<>());
    elementJoinComparator.setGroupByProperties(groupByProperties);

    // Act and Assert
    assertFalse(elementJoinComparator.test(null, new Edge("Group")));
  }

  /**
   * Test {@link ElementJoinComparator#test(Element, Element)} with {@code element}, {@code
   * element2}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code foo}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  @DisplayName(
      "Test test(Element, Element) with 'element', 'element2'; given LinkedHashSet() add 'foo'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementJoinComparator.test(Element, Element)"})
  void testTestWithElementElement2_givenLinkedHashSetAddFoo_whenNull_thenReturnFalse2() {
    // Arrange
    LinkedHashSet<String> groupByProperties = new LinkedHashSet<>();
    groupByProperties.add("foo");

    ElementJoinComparator elementJoinComparator = new ElementJoinComparator(new HashSet<>());
    elementJoinComparator.setGroupByProperties(groupByProperties);

    // Act and Assert
    assertFalse(elementJoinComparator.test(new Edge("Group"), null));
  }

  /**
   * Test {@link ElementJoinComparator#test(Element, Element)} with {@code element}, {@code
   * element2}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code foo}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  @DisplayName(
      "Test test(Element, Element) with 'element', 'element2'; given LinkedHashSet() add 'foo'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementJoinComparator.test(Element, Element)"})
  void testTestWithElementElement2_givenLinkedHashSetAddFoo_whenNull_thenReturnTrue() {
    // Arrange
    LinkedHashSet<String> groupByProperties = new LinkedHashSet<>();
    groupByProperties.add("foo");

    ElementJoinComparator elementJoinComparator = new ElementJoinComparator(new HashSet<>());
    elementJoinComparator.setGroupByProperties(groupByProperties);

    // Act and Assert
    assertTrue(elementJoinComparator.test(null, null));
  }

  /**
   * Test {@link ElementJoinComparator#test(Element, Element)} with {@code element}, {@code
   * element2}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  @DisplayName("Test test(Element, Element) with 'element', 'element2'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementJoinComparator.test(Element, Element)"})
  void testTestWithElementElement2_thenReturnTrue() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();
    Edge element =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertTrue(
        elementJoinComparator.test(
            element,
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build()));
  }

  /**
   * Test {@link ElementJoinComparator#test(Element, Element)} with {@code element}, {@code
   * element2}.
   *
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  @DisplayName(
      "Test test(Element, Element) with 'element', 'element2'; when Builder (default constructor) group 'Group' vertex 'Vertex' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementJoinComparator.test(Element, Element)"})
  void testTestWithElementElement2_whenBuilderGroupGroupVertexVertexBuild() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();
    Entity element = new Entity.Builder().group("Group").vertex("Vertex").build();

    // Act and Assert
    assertFalse(elementJoinComparator.test(element, new Edge("Group")));
  }

  /**
   * Test {@link ElementJoinComparator#test(Element, Element)} with {@code element}, {@code
   * element2}.
   *
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  @DisplayName(
      "Test test(Element, Element) with 'element', 'element2'; when Builder (default constructor) group 'Group' vertex 'Vertex' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementJoinComparator.test(Element, Element)"})
  void testTestWithElementElement2_whenBuilderGroupGroupVertexVertexBuild2() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();
    Entity element = new Entity.Builder().group("Group").vertex("Vertex").build();

    // Act and Assert
    assertTrue(
        elementJoinComparator.test(
            element, new Entity.Builder().group("Group").vertex("Vertex").build()));
  }

  /**
   * Test {@link ElementJoinComparator#test(Element, Element)} with {@code element}, {@code
   * element2}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  @DisplayName(
      "Test test(Element, Element) with 'element', 'element2'; when Edge(String) with 'Group'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementJoinComparator.test(Element, Element)"})
  void testTestWithElementElement2_whenEdgeWithGroup_thenReturnFalse() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();
    Edge element =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertFalse(elementJoinComparator.test(element, new Edge("Group")));
  }

  /**
   * Test {@link ElementJoinComparator#test(Element, Element)} with {@code element}, {@code
   * element2}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  @DisplayName(
      "Test test(Element, Element) with 'element', 'element2'; when Entity(String) with 'Group'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementJoinComparator.test(Element, Element)"})
  void testTestWithElementElement2_whenEntityWithGroup_thenReturnFalse() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();
    Entity element = new Entity.Builder().group("Group").vertex("Vertex").build();

    // Act and Assert
    assertFalse(elementJoinComparator.test(element, new Entity("Group")));
  }

  /**
   * Test {@link ElementJoinComparator#test(Element, Element)} with {@code element}, {@code
   * element2}.
   *
   * <p>Method under test: {@link ElementJoinComparator#test(Element, Element)}
   */
  @Test
  @DisplayName("Test test(Element, Element) with 'element', 'element2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementJoinComparator.test(Element, Element)"})
  void testTestWithElementElement22() {
    // Arrange
    ElementJoinComparator elementJoinComparator = new ElementJoinComparator();
    Edge element =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    Edge element2 = new Edge("Source", "Source", "Destination", true);

    // Act and Assert
    assertFalse(elementJoinComparator.test(element, element2));
  }
}
