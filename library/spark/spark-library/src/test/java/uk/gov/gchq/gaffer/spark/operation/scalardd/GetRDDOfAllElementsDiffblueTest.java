package uk.gov.gchq.gaffer.spark.operation.scalardd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.apache.spark.rdd.RDD;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.spark.operation.scalardd.GetRDDOfAllElements.Builder;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl.RDDElement;

class GetRDDOfAllElementsDiffblueTest {
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
    GetRDDOfAllElements _getOpResult = actualBuilder._getOp();
    TypeReference<RDD<Element>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof RDDElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "org.apache.spark.rdd.RDD<uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getDirectedType());
    assertNull(_getOpResult.getView());
    Class<RDD> expectedOutputClass = RDD.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetRDDOfAllElements actualGetRDDOfAllElements = actualBuilder.build();
    assertSame(_getOpResult, actualGetRDDOfAllElements);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetRDDOfAllElements}
   *   <li>{@link GetRDDOfAllElements#setDirectedType(DirectedType)}
   *   <li>{@link GetRDDOfAllElements#setOptions(Map)}
   *   <li>{@link GetRDDOfAllElements#setView(View)}
   *   <li>{@link GetRDDOfAllElements#getDirectedType()}
   *   <li>{@link GetRDDOfAllElements#getOptions()}
   *   <li>{@link GetRDDOfAllElements#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    GetRDDOfAllElements actualGetRDDOfAllElements = new GetRDDOfAllElements();
    actualGetRDDOfAllElements.setDirectedType(DirectedType.EITHER);
    HashMap<String, String> options = new HashMap<>();
    actualGetRDDOfAllElements.setOptions(options);
    View view = new View();
    actualGetRDDOfAllElements.setView(view);
    DirectedType actualDirectedType = actualGetRDDOfAllElements.getDirectedType();
    Map<String, String> actualOptions = actualGetRDDOfAllElements.getOptions();
    View actualView = actualGetRDDOfAllElements.getView();

    // Assert
    assertEquals(DirectedType.EITHER, actualDirectedType);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
    assertSame(view, actualView);
  }

  /**
   * Test {@link GetRDDOfAllElements#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetRDDOfAllElements#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<RDD<Element>> actualOutputTypeReference =
        new GetRDDOfAllElements().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof RDDElement);
    assertEquals(
        "org.apache.spark.rdd.RDD<uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetRDDOfAllElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetRDDOfAllElements} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetRDDOfAllElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetRDDOfAllElements (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetRDDOfAllElementsOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    GetRDDOfAllElements getRDDOfAllElements = new GetRDDOfAllElements();
    getRDDOfAllElements.setOptions(new HashMap<>());

    // Act
    GetRDDOfAllElements actualShallowCloneResult = getRDDOfAllElements.shallowClone();

    // Assert
    TypeReference<RDD<Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof RDDElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "org.apache.spark.rdd.RDD<uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<RDD> expectedOutputClass = RDD.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetRDDOfAllElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetRDDOfAllElements} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetRDDOfAllElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetRDDOfAllElements (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetRDDOfAllElements_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetRDDOfAllElements actualShallowCloneResult = new GetRDDOfAllElements().shallowClone();

    // Assert
    TypeReference<RDD<Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof RDDElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "org.apache.spark.rdd.RDD<uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    Class<RDD> expectedOutputClass = RDD.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }
}
