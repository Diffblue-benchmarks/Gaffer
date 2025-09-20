package uk.gov.gchq.gaffer.mapstore.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.mapstore.operation.CountAllElementsDefaultView.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class CountAllElementsDefaultViewDiffblueTest {
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
    CountAllElementsDefaultView _getOpResult = actualBuilder._getOp();
    TypeReference<Long> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Long);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<Long> expectedOutputClass = Long.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    CountAllElementsDefaultView actualCountAllElementsDefaultView = actualBuilder.build();
    assertSame(_getOpResult, actualCountAllElementsDefaultView);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test {@link CountAllElementsDefaultView#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CountAllElementsDefaultView#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable CountAllElementsDefaultView.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new CountAllElementsDefaultView().getInput());
  }

  /**
   * Test {@link CountAllElementsDefaultView#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link CountAllElementsDefaultView#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference CountAllElementsDefaultView.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue(
        new CountAllElementsDefaultView().getOutputTypeReference()
            instanceof TypeReferenceImpl.Long);
  }

  /**
   * Test {@link CountAllElementsDefaultView#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link CountAllElementsDefaultView} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CountAllElementsDefaultView#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given CountAllElementsDefaultView (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CountAllElementsDefaultView CountAllElementsDefaultView.shallowClone()"})
  void testShallowClone_givenCountAllElementsDefaultView_thenReturnOptionsIsNull() {
    // Arrange and Act
    CountAllElementsDefaultView actualShallowCloneResult =
        new CountAllElementsDefaultView().shallowClone();

    // Assert
    TypeReference<Long> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Long);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Long> expectedOutputClass = Long.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link CountAllElementsDefaultView#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link CountAllElementsDefaultView#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CountAllElementsDefaultView CountAllElementsDefaultView.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    CountAllElementsDefaultView countAllElementsDefaultView = new CountAllElementsDefaultView();
    countAllElementsDefaultView.setOptions(new HashMap<>());

    // Act
    CountAllElementsDefaultView actualShallowCloneResult =
        countAllElementsDefaultView.shallowClone();

    // Assert
    TypeReference<Long> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Long);
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Long> expectedOutputClass = Long.class;
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
   *   <li>default or parameterless constructor of {@link CountAllElementsDefaultView}
   *   <li>{@link CountAllElementsDefaultView#setInput(Iterable)}
   *   <li>{@link CountAllElementsDefaultView#setOptions(Map)}
   *   <li>{@link CountAllElementsDefaultView#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CountAllElementsDefaultView.<init>()",
    "Map CountAllElementsDefaultView.getOptions()",
    "void CountAllElementsDefaultView.setInput(Iterable)",
    "void CountAllElementsDefaultView.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    CountAllElementsDefaultView actualCountAllElementsDefaultView =
        new CountAllElementsDefaultView();
    ArrayList<Element> input = new ArrayList<>();
    actualCountAllElementsDefaultView.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualCountAllElementsDefaultView.setOptions(options);
    Map<String, String> actualOptions = actualCountAllElementsDefaultView.getOptions();

    // Assert
    Iterable<? extends Element> input2 = actualCountAllElementsDefaultView.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
