package uk.gov.gchq.gaffer.spark.operation.javardd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.apache.spark.api.java.JavaRDD;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.spark.operation.javardd.GetJavaRDDOfAllElements.Builder;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl.JavaRDDElement;

class GetJavaRDDOfAllElementsDiffblueTest {
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
    GetJavaRDDOfAllElements _getOpResult = actualBuilder._getOp();
    TypeReference<JavaRDD<Element>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof JavaRDDElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "org.apache.spark.api.java.JavaRDD<uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getDirectedType());
    assertNull(_getOpResult.getView());
    Class<JavaRDD> expectedOutputClass = JavaRDD.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetJavaRDDOfAllElements actualGetJavaRDDOfAllElements = actualBuilder.build();
    assertSame(_getOpResult, actualGetJavaRDDOfAllElements);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetJavaRDDOfAllElements}
   *   <li>{@link GetJavaRDDOfAllElements#setDirectedType(DirectedType)}
   *   <li>{@link GetJavaRDDOfAllElements#setOptions(Map)}
   *   <li>{@link GetJavaRDDOfAllElements#setView(View)}
   *   <li>{@link GetJavaRDDOfAllElements#getDirectedType()}
   *   <li>{@link GetJavaRDDOfAllElements#getOptions()}
   *   <li>{@link GetJavaRDDOfAllElements#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetJavaRDDOfAllElements.<init>()",
    "DirectedType GetJavaRDDOfAllElements.getDirectedType()",
    "Map GetJavaRDDOfAllElements.getOptions()",
    "View GetJavaRDDOfAllElements.getView()",
    "void GetJavaRDDOfAllElements.setDirectedType(DirectedType)",
    "void GetJavaRDDOfAllElements.setOptions(Map)",
    "void GetJavaRDDOfAllElements.setView(View)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetJavaRDDOfAllElements actualGetJavaRDDOfAllElements = new GetJavaRDDOfAllElements();
    actualGetJavaRDDOfAllElements.setDirectedType(DirectedType.EITHER);
    HashMap<String, String> options = new HashMap<>();
    actualGetJavaRDDOfAllElements.setOptions(options);
    View view = new View();
    actualGetJavaRDDOfAllElements.setView(view);
    DirectedType actualDirectedType = actualGetJavaRDDOfAllElements.getDirectedType();
    Map<String, String> actualOptions = actualGetJavaRDDOfAllElements.getOptions();
    View actualView = actualGetJavaRDDOfAllElements.getView();

    // Assert
    assertEquals(DirectedType.EITHER, actualDirectedType);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
    assertSame(view, actualView);
  }

  /**
   * Test {@link GetJavaRDDOfAllElements#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetJavaRDDOfAllElements#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetJavaRDDOfAllElements.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<JavaRDD<Element>> actualOutputTypeReference =
        new GetJavaRDDOfAllElements().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof JavaRDDElement);
    assertEquals(
        "org.apache.spark.api.java.JavaRDD<uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetJavaRDDOfAllElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetJavaRDDOfAllElements} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetJavaRDDOfAllElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetJavaRDDOfAllElements (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetJavaRDDOfAllElements GetJavaRDDOfAllElements.shallowClone()"})
  void testShallowClone_givenGetJavaRDDOfAllElements_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetJavaRDDOfAllElements actualShallowCloneResult = new GetJavaRDDOfAllElements().shallowClone();

    // Assert
    TypeReference<JavaRDD<Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof JavaRDDElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "org.apache.spark.api.java.JavaRDD<uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    Class<JavaRDD> expectedOutputClass = JavaRDD.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetJavaRDDOfAllElements#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetJavaRDDOfAllElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetJavaRDDOfAllElements GetJavaRDDOfAllElements.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    GetJavaRDDOfAllElements getJavaRDDOfAllElements = new GetJavaRDDOfAllElements();
    getJavaRDDOfAllElements.setOptions(new HashMap<>());

    // Act
    GetJavaRDDOfAllElements actualShallowCloneResult = getJavaRDDOfAllElements.shallowClone();

    // Assert
    TypeReference<JavaRDD<Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof JavaRDDElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "org.apache.spark.api.java.JavaRDD<uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<JavaRDD> expectedOutputClass = JavaRDD.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }
}
