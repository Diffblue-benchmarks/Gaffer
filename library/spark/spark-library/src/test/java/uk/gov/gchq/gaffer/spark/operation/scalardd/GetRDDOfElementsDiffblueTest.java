package uk.gov.gchq.gaffer.spark.operation.scalardd;

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
import org.apache.spark.rdd.RDD;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters.IncludeIncomingOutgoingType;
import uk.gov.gchq.gaffer.spark.operation.scalardd.GetRDDOfElements.Builder;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl.RDDElement;

class GetRDDOfElementsDiffblueTest {
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
    GetRDDOfElements _getOpResult = actualBuilder._getOp();
    TypeReference<RDD<Element>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof RDDElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "org.apache.spark.rdd.RDD<uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getDirectedType());
    assertNull(_getOpResult.getView());
    assertNull(_getOpResult.getIncludeIncomingOutGoing());
    Class<RDD> expectedOutputClass = RDD.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetRDDOfElements actualGetRDDOfElements = actualBuilder.build();
    assertSame(_getOpResult, actualGetRDDOfElements);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetRDDOfElements}
   *   <li>{@link GetRDDOfElements#setDirectedType(DirectedType)}
   *   <li>{@link GetRDDOfElements#setIncludeIncomingOutGoing(IncludeIncomingOutgoingType)}
   *   <li>{@link GetRDDOfElements#setInput(Iterable)}
   *   <li>{@link GetRDDOfElements#setOptions(Map)}
   *   <li>{@link GetRDDOfElements#setView(View)}
   *   <li>{@link GetRDDOfElements#getDirectedType()}
   *   <li>{@link GetRDDOfElements#getIncludeIncomingOutGoing()}
   *   <li>{@link GetRDDOfElements#getOptions()}
   *   <li>{@link GetRDDOfElements#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetRDDOfElements.<init>()",
    "DirectedType GetRDDOfElements.getDirectedType()",
    "IncludeIncomingOutgoingType GetRDDOfElements.getIncludeIncomingOutGoing()",
    "Map GetRDDOfElements.getOptions()",
    "View GetRDDOfElements.getView()",
    "void GetRDDOfElements.setDirectedType(DirectedType)",
    "void GetRDDOfElements.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType)",
    "void GetRDDOfElements.setInput(Iterable)",
    "void GetRDDOfElements.setOptions(Map)",
    "void GetRDDOfElements.setView(View)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetRDDOfElements actualGetRDDOfElements = new GetRDDOfElements();
    actualGetRDDOfElements.setDirectedType(DirectedType.EITHER);
    actualGetRDDOfElements.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType.EITHER);
    ArrayList<ElementId> input = new ArrayList<>();
    actualGetRDDOfElements.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualGetRDDOfElements.setOptions(options);
    View view = new View();
    actualGetRDDOfElements.setView(view);
    DirectedType actualDirectedType = actualGetRDDOfElements.getDirectedType();
    IncludeIncomingOutgoingType actualIncludeIncomingOutGoing =
        actualGetRDDOfElements.getIncludeIncomingOutGoing();
    Map<String, String> actualOptions = actualGetRDDOfElements.getOptions();
    View actualView = actualGetRDDOfElements.getView();

    // Assert
    Iterable<? extends ElementId> input2 = actualGetRDDOfElements.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(DirectedType.EITHER, actualDirectedType);
    assertEquals(IncludeIncomingOutgoingType.EITHER, actualIncludeIncomingOutGoing);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(view, actualView);
  }

  /**
   * Test {@link GetRDDOfElements#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetRDDOfElements#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetRDDOfElements.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<RDD<Element>> actualOutputTypeReference =
        new GetRDDOfElements().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof RDDElement);
    assertEquals(
        "org.apache.spark.rdd.RDD<uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetRDDOfElements#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetRDDOfElements#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetRDDOfElements.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GetRDDOfElements().getInput());
  }

  /**
   * Test {@link GetRDDOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetRDDOfElements} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetRDDOfElements (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetRDDOfElements GetRDDOfElements.shallowClone()"})
  void testShallowClone_givenGetRDDOfElementsOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    GetRDDOfElements getRDDOfElements = new GetRDDOfElements();
    getRDDOfElements.setOptions(new HashMap<>());

    // Act
    GetRDDOfElements actualShallowCloneResult = getRDDOfElements.shallowClone();

    // Assert
    TypeReference<RDD<Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof RDDElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "org.apache.spark.rdd.RDD<uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertNull(actualShallowCloneResult.getIncludeIncomingOutGoing());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<RDD> expectedOutputClass = RDD.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetRDDOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetRDDOfElements} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetRDDOfElements (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetRDDOfElements GetRDDOfElements.shallowClone()"})
  void testShallowClone_givenGetRDDOfElements_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetRDDOfElements actualShallowCloneResult = new GetRDDOfElements().shallowClone();

    // Assert
    TypeReference<RDD<Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof RDDElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "org.apache.spark.rdd.RDD<uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertNull(actualShallowCloneResult.getIncludeIncomingOutGoing());
    Class<RDD> expectedOutputClass = RDD.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }
}
