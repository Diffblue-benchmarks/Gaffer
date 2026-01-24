/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.spark.operation.graphframe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.graphframes.GraphFrame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.property.Converter;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.property.impl.FreqMapConverter;
import uk.gov.gchq.gaffer.spark.operation.graphframe.GetGraphFrameOfElements.Builder;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl;
import uk.gov.gchq.koryphe.ValidationResult;

class GetGraphFrameOfElementsDiffblueTest {
  /**
   * Test Builder {@link Builder#converters(List)}.
   *
   * <ul>
   *   <li>Then return _getOp Converters is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#converters(List)}
   */
  @Test
  @DisplayName("Test Builder converters(List); then return _getOp Converters is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.converters(List)"})
  void testBuilderConverters_thenReturn_getOpConvertersIsArrayList() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Converter> converters = new ArrayList<>();
    converters.add(new FreqMapConverter());

    // Act and Assert
    assertSame(converters, builder.converters(converters)._getOp().getConverters());
  }

  /**
   * Test Builder {@link Builder#converters(List)}.
   *
   * <ul>
   *   <li>Then return _getOp Converters is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#converters(List)}
   */
  @Test
  @DisplayName("Test Builder converters(List); then return _getOp Converters is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.converters(List)"})
  void testBuilderConverters_thenReturn_getOpConvertersIsArrayList2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Converter> converters = new ArrayList<>();
    converters.add(new FreqMapConverter());
    converters.add(new FreqMapConverter());

    // Act and Assert
    assertSame(converters, builder.converters(converters)._getOp().getConverters());
  }

  /**
   * Test Builder {@link Builder#converters(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#converters(List)}
   */
  @Test
  @DisplayName(
      "Test Builder converters(List); when ArrayList(); then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.converters(List)"})
  void testBuilderConverters_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConvertersResult = builder.converters(new ArrayList<>());

    // Assert
    assertSame(builder, actualConvertersResult);
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
    GetGraphFrameOfElements _getOpResult = actualBuilder._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceSparkImpl.GraphFrame);
    assertNull(_getOpResult.getConverters());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getDirectedType());
    assertNull(_getOpResult.getView());
    Class<GraphFrame> expectedOutputClass = GraphFrame.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetGraphFrameOfElements actualGetGraphFrameOfElements = actualBuilder.build();
    assertSame(_getOpResult, actualGetGraphFrameOfElements);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetGraphFrameOfElements}
   *   <li>{@link GetGraphFrameOfElements#setConverters(List)}
   *   <li>{@link GetGraphFrameOfElements#setDirectedType(DirectedType)}
   *   <li>{@link GetGraphFrameOfElements#setOptions(Map)}
   *   <li>{@link GetGraphFrameOfElements#setView(View)}
   *   <li>{@link GetGraphFrameOfElements#getConverters()}
   *   <li>{@link GetGraphFrameOfElements#getDirectedType()}
   *   <li>{@link GetGraphFrameOfElements#getOptions()}
   *   <li>{@link GetGraphFrameOfElements#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetGraphFrameOfElements.<init>()",
    "List GetGraphFrameOfElements.getConverters()",
    "DirectedType GetGraphFrameOfElements.getDirectedType()",
    "Map GetGraphFrameOfElements.getOptions()",
    "View GetGraphFrameOfElements.getView()",
    "void GetGraphFrameOfElements.setConverters(List)",
    "void GetGraphFrameOfElements.setDirectedType(DirectedType)",
    "void GetGraphFrameOfElements.setOptions(Map)",
    "void GetGraphFrameOfElements.setView(View)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetGraphFrameOfElements actualGetGraphFrameOfElements = new GetGraphFrameOfElements();
    ArrayList<Converter> converters = new ArrayList<>();
    actualGetGraphFrameOfElements.setConverters(converters);
    actualGetGraphFrameOfElements.setDirectedType(DirectedType.EITHER);
    HashMap<String, String> options = new HashMap<>();
    actualGetGraphFrameOfElements.setOptions(options);
    View view = new View();
    actualGetGraphFrameOfElements.setView(view);
    List<Converter> actualConverters = actualGetGraphFrameOfElements.getConverters();
    DirectedType actualDirectedType = actualGetGraphFrameOfElements.getDirectedType();
    Map<String, String> actualOptions = actualGetGraphFrameOfElements.getOptions();
    View actualView = actualGetGraphFrameOfElements.getView();

    // Assert
    assertEquals(DirectedType.EITHER, actualDirectedType);
    assertTrue(actualConverters.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(converters, actualConverters);
    assertSame(options, actualOptions);
    assertSame(view, actualView);
  }

  /**
   * Test {@link GetGraphFrameOfElements#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetGraphFrameOfElements#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.fasterxml.jackson.core.type.TypeReference GetGraphFrameOfElements.getOutputTypeReference()"
  })
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue(
        new GetGraphFrameOfElements().getOutputTypeReference()
            instanceof TypeReferenceSparkImpl.GraphFrame);
  }

  /**
   * Test {@link GetGraphFrameOfElements#validate()}.
   *
   * <p>Method under test: {@link GetGraphFrameOfElements#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult GetGraphFrameOfElements.validate()"})
  void testValidate() {
    // Arrange and Act
    ValidationResult actualValidateResult = new GetGraphFrameOfElements().validate();

    // Assert
    assertEquals(
        "Validation errors: \nview is required for: GetGraphFrameOfElements",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("view is required for: GetGraphFrameOfElements"));
  }

  /**
   * Test {@link GetGraphFrameOfElements#validate()}.
   *
   * <p>Method under test: {@link GetGraphFrameOfElements#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult GetGraphFrameOfElements.validate()"})
  void testValidate2() {
    // Arrange
    GetGraphFrameOfElements getGraphFrameOfElements = new GetGraphFrameOfElements();
    getGraphFrameOfElements.setView(new View());

    // Act
    ValidationResult actualValidateResult = getGraphFrameOfElements.validate();

    // Assert
    assertEquals(
        "Validation errors: \nCannot create a GraphFrame unless the View contains edges or entities.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(
        errors.contains("Cannot create a GraphFrame unless the View contains edges or entities."));
  }

  /**
   * Test {@link GetGraphFrameOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetGraphFrameOfElements} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetGraphFrameOfElements#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetGraphFrameOfElements (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetGraphFrameOfElements GetGraphFrameOfElements.shallowClone()"})
  void testShallowClone_givenGetGraphFrameOfElements_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetGraphFrameOfElements actualShallowCloneResult = new GetGraphFrameOfElements().shallowClone();

    // Assert
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference()
            instanceof TypeReferenceSparkImpl.GraphFrame);
    assertNull(actualShallowCloneResult.getConverters());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    Class<GraphFrame> expectedOutputClass = GraphFrame.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test {@link GetGraphFrameOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetGraphFrameOfElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetGraphFrameOfElements GetGraphFrameOfElements.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    GetGraphFrameOfElements getGraphFrameOfElements = new GetGraphFrameOfElements();
    getGraphFrameOfElements.setOptions(new HashMap<>());

    // Act
    GetGraphFrameOfElements actualShallowCloneResult = getGraphFrameOfElements.shallowClone();

    // Assert
    assertTrue(
        actualShallowCloneResult.getOutputTypeReference()
            instanceof TypeReferenceSparkImpl.GraphFrame);
    assertNull(actualShallowCloneResult.getConverters());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<GraphFrame> expectedOutputClass = GraphFrame.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }
}
