package uk.gov.gchq.gaffer.operation.impl.compare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.compare.Min.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class MinDiffblueTest {
  /**
   * Test Builder {@link Builder#comparators(Comparator[])} with {@code Comparator[]}.
   *
   * <ul>
   *   <li>When {@link Comparator}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#comparators(Comparator[])}
   */
  @Test
  @DisplayName(
      "Test Builder comparators(Comparator[]) with 'Comparator[]'; when Comparator; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.comparators(Comparator[])"})
  void testBuilderComparatorsWithComparator_whenComparator_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualComparatorsResult = builder.comparators(mock(Comparator.class));

    // Assert
    assertSame(builder, actualComparatorsResult);
  }

  /**
   * Test Builder {@link Builder#comparators(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link Comparator}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Comparator}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#comparators(List)}
   */
  @Test
  @DisplayName(
      "Test Builder comparators(List) with 'List'; given Comparator; when ArrayList() add Comparator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.comparators(List)"})
  void testBuilderComparatorsWithList_givenComparator_whenArrayListAddComparator() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(mock(Comparator.class));

    // Act
    Builder actualComparatorsResult = builder.comparators(comparators);

    // Assert
    assertSame(builder, actualComparatorsResult);
  }

  /**
   * Test Builder {@link Builder#comparators(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link Comparator}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Comparator}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#comparators(List)}
   */
  @Test
  @DisplayName(
      "Test Builder comparators(List) with 'List'; given Comparator; when ArrayList() add Comparator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.comparators(List)"})
  void testBuilderComparatorsWithList_givenComparator_whenArrayListAddComparator2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    comparators.add(mock(Comparator.class));
    comparators.add(mock(Comparator.class));

    // Act
    Builder actualComparatorsResult = builder.comparators(comparators);

    // Assert
    assertSame(builder, actualComparatorsResult);
  }

  /**
   * Test Builder {@link Builder#comparators(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#comparators(List)}
   */
  @Test
  @DisplayName("Test Builder comparators(List) with 'List'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.comparators(List)"})
  void testBuilderComparatorsWithList_whenArrayList() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualComparatorsResult = builder.comparators(new ArrayList<>());

    // Assert
    assertSame(builder, actualComparatorsResult);
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
    Min _getOpResult = actualBuilder._getOp();
    TypeReference<Element> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Element);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getCombinedComparator());
    assertNull(_getOpResult.getComparators());
    assertNull(_getOpResult.getOptions());
    assertTrue(_getOpResult.getComparableGroupPropertyPairs().isEmpty());
    Class<Element> expectedOutputClass = Element.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Min actualMin = actualBuilder.build();
    assertSame(_getOpResult, actualMin);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test {@link Min#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Min#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable Min.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Min().getInput());
  }

  /**
   * Test {@link Min#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link Min#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference Min.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue(new Min().getOutputTypeReference() instanceof TypeReferenceImpl.Element);
  }

  /**
   * Test {@link Min#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Min} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link Min#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given Min (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Min Min.shallowClone()"})
  void testShallowClone_givenMinOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    Min min = new Min();
    min.setOptions(new HashMap<>());

    // Act
    Min actualShallowCloneResult = min.shallowClone();

    // Assert
    TypeReference<Element> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Element);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getCombinedComparator());
    assertNull(actualShallowCloneResult.getComparators());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.getComparableGroupPropertyPairs().isEmpty());
    Class<Element> expectedOutputClass = Element.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link Min#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Min} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Min#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given Min (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Min Min.shallowClone()"})
  void testShallowClone_givenMin_thenReturnOptionsIsNull() {
    // Arrange and Act
    Min actualShallowCloneResult = new Min().shallowClone();

    // Assert
    TypeReference<Element> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Element);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getCombinedComparator());
    assertNull(actualShallowCloneResult.getComparators());
    assertNull(actualShallowCloneResult.getOptions());
    assertTrue(actualShallowCloneResult.getComparableGroupPropertyPairs().isEmpty());
    Class<Element> expectedOutputClass = Element.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Min}
   *   <li>{@link Min#setComparators(List)}
   *   <li>{@link Min#setInput(Iterable)}
   *   <li>{@link Min#setOptions(Map)}
   *   <li>{@link Min#getComparators()}
   *   <li>{@link Min#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Min.<init>()",
    "List Min.getComparators()",
    "Map Min.getOptions()",
    "void Min.setComparators(List)",
    "void Min.setInput(Iterable)",
    "void Min.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Min actualMin = new Min();
    ArrayList<Comparator<Element>> comparators = new ArrayList<>();
    actualMin.setComparators(comparators);
    ArrayList<Element> input = new ArrayList<>();
    actualMin.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualMin.setOptions(options);
    List<Comparator<Element>> actualComparators = actualMin.getComparators();
    Map<String, String> actualOptions = actualMin.getOptions();

    // Assert
    Iterable<? extends Element> input2 = actualMin.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualComparators.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(comparators, actualComparators);
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
