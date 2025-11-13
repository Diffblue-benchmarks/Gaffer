/*
 * Copyright 2025 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.spark.operation.javardd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.spark.api.java.JavaRDD;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters.IncludeIncomingOutgoingType;
import uk.gov.gchq.gaffer.spark.operation.javardd.GetJavaRDDOfElements.Builder;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl.JavaRDDElement;

class GetJavaRDDOfElementsDiffblueTest {
  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    GetJavaRDDOfElements _getOpResult = actualBuilder._getOp();
    TypeReference<JavaRDD<Element>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof JavaRDDElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("org.apache.spark.api.java.JavaRDD<uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getDirectedType());
    assertNull(_getOpResult.getView());
    assertNull(_getOpResult.getIncludeIncomingOutGoing());
    Class<JavaRDD> expectedOutputClass = JavaRDD.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetJavaRDDOfElements}
   *   <li>{@link GetJavaRDDOfElements#setDirectedType(DirectedType)}
   *   <li>{@link GetJavaRDDOfElements#setIncludeIncomingOutGoing(IncludeIncomingOutgoingType)}
   *   <li>{@link GetJavaRDDOfElements#setInput(Iterable)}
   *   <li>{@link GetJavaRDDOfElements#setOptions(Map)}
   *   <li>{@link GetJavaRDDOfElements#setView(View)}
   *   <li>{@link GetJavaRDDOfElements#getDirectedType()}
   *   <li>{@link GetJavaRDDOfElements#getIncludeIncomingOutGoing()}
   *   <li>{@link GetJavaRDDOfElements#getOptions()}
   *   <li>{@link GetJavaRDDOfElements#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetJavaRDDOfElements.<init>()", "DirectedType GetJavaRDDOfElements.getDirectedType()",
      "IncludeIncomingOutgoingType GetJavaRDDOfElements.getIncludeIncomingOutGoing()",
      "Map GetJavaRDDOfElements.getOptions()", "View GetJavaRDDOfElements.getView()",
      "void GetJavaRDDOfElements.setDirectedType(DirectedType)",
      "void GetJavaRDDOfElements.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType)",
      "void GetJavaRDDOfElements.setInput(Iterable)", "void GetJavaRDDOfElements.setOptions(Map)",
      "void GetJavaRDDOfElements.setView(View)"})
  void testGettersAndSetters() {
    // Arrange and Act
    GetJavaRDDOfElements actualGetJavaRDDOfElements = new GetJavaRDDOfElements();
    actualGetJavaRDDOfElements.setDirectedType(DirectedType.EITHER);
    actualGetJavaRDDOfElements.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType.EITHER);
    ArrayList<ElementId> input = new ArrayList<>();
    actualGetJavaRDDOfElements.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualGetJavaRDDOfElements.setOptions(options);
    View view = new View();
    actualGetJavaRDDOfElements.setView(view);
    DirectedType actualDirectedType = actualGetJavaRDDOfElements.getDirectedType();
    IncludeIncomingOutgoingType actualIncludeIncomingOutGoing = actualGetJavaRDDOfElements.getIncludeIncomingOutGoing();
    Map<String, String> actualOptions = actualGetJavaRDDOfElements.getOptions();
    View actualView = actualGetJavaRDDOfElements.getView();

    // Assert
    Iterable<? extends ElementId> input2 = actualGetJavaRDDOfElements.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(DirectedType.EITHER, actualDirectedType);
    assertEquals(IncludeIncomingOutgoingType.EITHER, actualIncludeIncomingOutGoing);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(view, actualView);
  }

  /**
   * Test {@link GetJavaRDDOfElements#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link GetJavaRDDOfElements#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference GetJavaRDDOfElements.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<JavaRDD<Element>> actualOutputTypeReference = (new GetJavaRDDOfElements()).getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof JavaRDDElement);
    assertEquals("org.apache.spark.api.java.JavaRDD<uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetJavaRDDOfElements#shallowClone()}.
   * <ul>
   *   <li>Given {@link GetJavaRDDOfElements} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetJavaRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetJavaRDDOfElements (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetJavaRDDOfElements GetJavaRDDOfElements.shallowClone()"})
  void testShallowClone_givenGetJavaRDDOfElements_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetJavaRDDOfElements actualShallowCloneResult = (new GetJavaRDDOfElements()).shallowClone();

    // Assert
    TypeReference<JavaRDD<Element>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof JavaRDDElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("org.apache.spark.api.java.JavaRDD<uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertNull(actualShallowCloneResult.getIncludeIncomingOutGoing());
    Class<JavaRDD> expectedOutputClass = JavaRDD.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetJavaRDDOfElements#shallowClone()}.
   * <ul>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetJavaRDDOfElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetJavaRDDOfElements GetJavaRDDOfElements.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    GetJavaRDDOfElements getJavaRDDOfElements = new GetJavaRDDOfElements();
    getJavaRDDOfElements.setOptions(new HashMap<>());

    // Act
    GetJavaRDDOfElements actualShallowCloneResult = getJavaRDDOfElements.shallowClone();

    // Assert
    TypeReference<JavaRDD<Element>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof JavaRDDElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("org.apache.spark.api.java.JavaRDD<uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertNull(actualShallowCloneResult.getIncludeIncomingOutGoing());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<JavaRDD> expectedOutputClass = JavaRDD.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }
}
