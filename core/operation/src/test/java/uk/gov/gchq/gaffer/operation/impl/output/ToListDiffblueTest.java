package uk.gov.gchq.gaffer.operation.impl.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.output.ToList.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ToListDiffblueTest {
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
    Builder<Object> actualBuilder = new Builder<>();

    // Assert
    ToList<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<List<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    ToList<Object> actualToList = actualBuilder.build();
    assertSame(_getOpResult, actualToList);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToList#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToList#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ToList.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange
    ToList<Object> toList = new ToList<>();

    // Act and Assert
    assertNull(toList.getInput());
  }

  /**
   * Test {@link ToList#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ToList#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference ToList.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    ToList<Object> toList = new ToList<>();

    // Act
    TypeReference<List<?>> actualOutputTypeReference = toList.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.List);
    assertEquals("java.util.List<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link ToList#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ToList} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToList#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ToList (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToList ToList.shallowClone()"})
  void testShallowClone_givenToListOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    ToList<Object> toList = new ToList<>();
    toList.setOptions(new HashMap<>());

    // Act
    ToList<Object> actualShallowCloneResult = toList.shallowClone();

    // Assert
    TypeReference<List<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToList#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ToList} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToList#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ToList (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToList ToList.shallowClone()"})
  void testShallowClone_givenToList_thenReturnOptionsIsNull() {
    // Arrange
    ToList<Object> toList = new ToList<>();

    // Act
    ToList<Object> actualShallowCloneResult = toList.shallowClone();

    // Assert
    TypeReference<List<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.List);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.List<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<List> expectedOutputClass = List.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ToList}
   *   <li>{@link ToList#setInput(Iterable)}
   *   <li>{@link ToList#setOptions(Map)}
   *   <li>{@link ToList#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToList.<init>()",
    "Map ToList.getOptions()",
    "void ToList.setInput(Iterable)",
    "void ToList.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ToList<Object> actualToList = new ToList<>();
    ArrayList<Object> input = new ArrayList<>();
    actualToList.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualToList.setOptions(options);
    Map<String, String> actualOptions = actualToList.getOptions();

    // Assert
    Iterable<?> input2 = actualToList.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
