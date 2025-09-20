package uk.gov.gchq.gaffer.operation.impl.get;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.impl.get.GetAllElements.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;

class GetAllElementsDiffblueTest {
  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    GetAllElements _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getDirectedType());
    assertNull(_getOpResult.getView());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetAllElements actualGetAllElements = actualBuilder.build();
    assertSame(_getOpResult, actualGetAllElements);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllElements#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetAllElements#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends Element>> actualOutputTypeReference =
        new GetAllElements().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableElement);
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetAllElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAllElements} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetAllElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAllElements (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetAllElementsOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    GetAllElements getAllElements = new GetAllElements();
    getAllElements.setOptions(new HashMap<>());

    // Act
    GetAllElements actualShallowCloneResult = getAllElements.shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAllElements} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAllElements (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetAllElements_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetAllElements actualShallowCloneResult = new GetAllElements().shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetAllElements}
   *   <li>{@link GetAllElements#setDirectedType(DirectedType)}
   *   <li>{@link GetAllElements#setOptions(Map)}
   *   <li>{@link GetAllElements#setView(View)}
   *   <li>{@link GetAllElements#getDirectedType()}
   *   <li>{@link GetAllElements#getOptions()}
   *   <li>{@link GetAllElements#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    GetAllElements actualGetAllElements = new GetAllElements();
    actualGetAllElements.setDirectedType(DirectedType.EITHER);
    HashMap<String, String> options = new HashMap<>();
    actualGetAllElements.setOptions(options);
    View view = new View();
    actualGetAllElements.setView(view);
    DirectedType actualDirectedType = actualGetAllElements.getDirectedType();
    Map<String, String> actualOptions = actualGetAllElements.getOptions();
    View actualView = actualGetAllElements.getView();

    // Assert
    assertEquals(DirectedType.EITHER, actualDirectedType);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
    assertSame(view, actualView);
  }
}
