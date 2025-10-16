package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterable;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterator;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementTuple;
import uk.gov.gchq.koryphe.tuple.Tuple;

class TupleToElementsDiffblueTest {
  /**
   * Test {@link TupleToElements#apply(Tuple)} with {@code Tuple}.
   *
   * <p>Method under test: {@link TupleToElements#apply(Tuple)}
   */
  @Test
  @DisplayName("Test apply(Tuple) with 'Tuple'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable TupleToElements.apply(Tuple)"})
  void testApplyWithTuple() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    // Act
    Iterable<Element> actualApplyResult = tupleToElements.apply(new ElementTuple());
    Iterator<Element> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertTrue(actualApplyResult instanceof StreamIterable);
    Iterator<Element> iteratorResult = actualApplyResult.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
    Stream<Element> stream = ((StreamIterable<Element>) actualApplyResult).getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link TupleToElements#setElements(List)}.
   *
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()}.
   *   <li>Then {@link TupleToElements} (default constructor) Elements size is one.
   * </ul>
   *
   * <p>Method under test: {@link TupleToElements#setElements(List)}
   */
  @Test
  @DisplayName(
      "Test setElements(List); given ElementTupleDefinition(); then TupleToElements (default constructor) Elements size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TupleToElements.setElements(List)"})
  void testSetElements_givenElementTupleDefinition_thenTupleToElementsElementsSizeIsOne() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    ArrayList<ElementTupleDefinition> elements = new ArrayList<>();
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elements.add(elementTupleDefinition);

    // Act
    tupleToElements.setElements(elements);

    // Assert
    List<ElementTupleDefinition> elements2 = tupleToElements.getElements();
    assertEquals(1, elements2.size());
    assertSame(elementTupleDefinition, elements2.get(0));
  }

  /**
   * Test {@link TupleToElements#setElements(List)}.
   *
   * <ul>
   *   <li>Then {@link TupleToElements} (default constructor) Elements is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TupleToElements#setElements(List)}
   */
  @Test
  @DisplayName(
      "Test setElements(List); then TupleToElements (default constructor) Elements is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TupleToElements.setElements(List)"})
  void testSetElements_thenTupleToElementsElementsIsArrayList() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    ArrayList<ElementTupleDefinition> elements = new ArrayList<>();
    elements.add(new ElementTupleDefinition());
    elements.add(new ElementTupleDefinition());

    // Act
    tupleToElements.setElements(elements);

    // Assert
    assertEquals(elements, tupleToElements.getElements());
  }

  /**
   * Test {@link TupleToElements#setElements(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link TupleToElements} (default constructor) Elements Empty.
   * </ul>
   *
   * <p>Method under test: {@link TupleToElements#setElements(List)}
   */
  @Test
  @DisplayName(
      "Test setElements(List); when ArrayList(); then TupleToElements (default constructor) Elements Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TupleToElements.setElements(List)"})
  void testSetElements_whenArrayList_thenTupleToElementsElementsEmpty() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    // Act
    tupleToElements.setElements(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(tupleToElements.getElements().isEmpty());
  }

  /**
   * Test {@link TupleToElements#element(ElementTupleDefinition)}.
   *
   * <p>Method under test: {@link TupleToElements#element(ElementTupleDefinition)}
   */
  @Test
  @DisplayName("Test element(ElementTupleDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TupleToElements TupleToElements.element(ElementTupleDefinition)"})
  void testElement() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    // Act
    TupleToElements actualElementResult = tupleToElements.element(new ElementTupleDefinition());

    // Assert
    assertSame(tupleToElements, actualElementResult);
  }

  /**
   * Test {@link TupleToElements#elements(List)}.
   *
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()}.
   *   <li>Then return Elements is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TupleToElements#elements(List)}
   */
  @Test
  @DisplayName(
      "Test elements(List); given ElementTupleDefinition(); then return Elements is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TupleToElements TupleToElements.elements(List)"})
  void testElements_givenElementTupleDefinition_thenReturnElementsIsArrayList() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    ArrayList<ElementTupleDefinition> elementDef = new ArrayList<>();
    elementDef.add(new ElementTupleDefinition());

    // Act and Assert
    assertEquals(elementDef, tupleToElements.elements(elementDef).getElements());
  }

  /**
   * Test {@link TupleToElements#elements(List)}.
   *
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()}.
   *   <li>Then return Elements size is two.
   * </ul>
   *
   * <p>Method under test: {@link TupleToElements#elements(List)}
   */
  @Test
  @DisplayName(
      "Test elements(List); given ElementTupleDefinition(); then return Elements size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TupleToElements TupleToElements.elements(List)"})
  void testElements_givenElementTupleDefinition_thenReturnElementsSizeIsTwo() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    ArrayList<ElementTupleDefinition> elementDef = new ArrayList<>();
    elementDef.add(new ElementTupleDefinition());
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementDef.add(elementTupleDefinition);

    // Act and Assert
    List<ElementTupleDefinition> elements = tupleToElements.elements(elementDef).getElements();
    assertEquals(2, elements.size());
    assertSame(elementTupleDefinition, elements.get(1));
  }

  /**
   * Test {@link TupleToElements#elements(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link TupleToElements} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TupleToElements#elements(List)}
   */
  @Test
  @DisplayName(
      "Test elements(List); when ArrayList(); then return TupleToElements (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TupleToElements TupleToElements.elements(List)"})
  void testElements_whenArrayList_thenReturnTupleToElements() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    // Act
    TupleToElements actualElementsResult = tupleToElements.elements(new ArrayList<>());

    // Assert
    assertSame(tupleToElements, actualElementsResult);
  }

  /**
   * Test {@link TupleToElements#useGroupMapping(boolean)}.
   *
   * <p>Method under test: {@link TupleToElements#useGroupMapping(boolean)}
   */
  @Test
  @DisplayName("Test useGroupMapping(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TupleToElements TupleToElements.useGroupMapping(boolean)"})
  void testUseGroupMapping() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    // Act
    TupleToElements actualUseGroupMappingResult = tupleToElements.useGroupMapping(true);

    // Assert
    assertTrue(tupleToElements.getUseGroupMapping());
    assertSame(tupleToElements, actualUseGroupMappingResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TupleToElements}
   *   <li>{@link TupleToElements#setUseGroupMapping(boolean)}
   *   <li>{@link TupleToElements#getElements()}
   *   <li>{@link TupleToElements#getUseGroupMapping()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TupleToElements.<init>()",
    "List TupleToElements.getElements()",
    "boolean TupleToElements.getUseGroupMapping()",
    "void TupleToElements.setUseGroupMapping(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TupleToElements actualTupleToElements = new TupleToElements();
    actualTupleToElements.setUseGroupMapping(true);
    List<ElementTupleDefinition> actualElements = actualTupleToElements.getElements();
    boolean actualUseGroupMapping = actualTupleToElements.getUseGroupMapping();

    // Assert
    assertTrue(actualElements.isEmpty());
    assertTrue(actualUseGroupMapping);
  }
}
