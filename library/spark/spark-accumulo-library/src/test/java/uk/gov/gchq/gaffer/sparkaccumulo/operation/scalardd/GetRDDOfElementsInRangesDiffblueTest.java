package uk.gov.gchq.gaffer.sparkaccumulo.operation.scalardd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import org.apache.spark.rdd.RDD;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl.RDDElement;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.scalardd.GetRDDOfElementsInRanges.Builder;

class GetRDDOfElementsInRangesDiffblueTest {
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
    GetRDDOfElementsInRanges _getOpResult = actualBuilder._getOp();
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
    GetRDDOfElementsInRanges actualGetRDDOfElementsInRanges = actualBuilder.build();
    assertSame(_getOpResult, actualGetRDDOfElementsInRanges);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetRDDOfElementsInRanges#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetRDDOfElementsInRanges#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable GetRDDOfElementsInRanges.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GetRDDOfElementsInRanges().getInput());
  }

  /**
   * Test {@link GetRDDOfElementsInRanges#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetRDDOfElementsInRanges#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetRDDOfElementsInRanges.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<RDD<Element>> actualOutputTypeReference =
        new GetRDDOfElementsInRanges().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof RDDElement);
    assertEquals(
        "org.apache.spark.rdd.RDD<uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetRDDOfElementsInRanges#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetRDDOfElementsInRanges} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetRDDOfElementsInRanges#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetRDDOfElementsInRanges (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetRDDOfElementsInRanges GetRDDOfElementsInRanges.shallowClone()"})
  void testShallowClone_givenGetRDDOfElementsInRanges_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetRDDOfElementsInRanges actualShallowCloneResult =
        new GetRDDOfElementsInRanges().shallowClone();

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

  /**
   * Test {@link GetRDDOfElementsInRanges#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetRDDOfElementsInRanges#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetRDDOfElementsInRanges GetRDDOfElementsInRanges.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    GetRDDOfElementsInRanges getRDDOfElementsInRanges = new GetRDDOfElementsInRanges();
    getRDDOfElementsInRanges.setOptions(new HashMap<>());

    // Act
    GetRDDOfElementsInRanges actualShallowCloneResult = getRDDOfElementsInRanges.shallowClone();

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
}
