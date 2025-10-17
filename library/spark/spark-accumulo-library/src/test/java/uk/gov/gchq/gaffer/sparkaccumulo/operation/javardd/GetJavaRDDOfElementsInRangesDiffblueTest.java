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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.javardd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import org.apache.spark.api.java.JavaRDD;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl.JavaRDDElement;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.javardd.GetJavaRDDOfElementsInRanges.Builder;

class GetJavaRDDOfElementsInRangesDiffblueTest {
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
    GetJavaRDDOfElementsInRanges _getOpResult = actualBuilder._getOp();
    TypeReference<JavaRDD<Element>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof JavaRDDElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "org.apache.spark.api.java.JavaRDD<uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getDirectedType());
    assertNull(_getOpResult.getView());
    assertNull(_getOpResult.getIncludeIncomingOutGoing());
    Class<JavaRDD> expectedOutputClass = JavaRDD.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetJavaRDDOfElementsInRanges actualGetJavaRDDOfElementsInRanges = actualBuilder.build();
    assertSame(_getOpResult, actualGetJavaRDDOfElementsInRanges);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetJavaRDDOfElementsInRanges#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetJavaRDDOfElementsInRanges#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable GetJavaRDDOfElementsInRanges.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GetJavaRDDOfElementsInRanges().getInput());
  }

  /**
   * Test {@link GetJavaRDDOfElementsInRanges#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetJavaRDDOfElementsInRanges#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetJavaRDDOfElementsInRanges.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<JavaRDD<Element>> actualOutputTypeReference =
        new GetJavaRDDOfElementsInRanges().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof JavaRDDElement);
    assertEquals(
        "org.apache.spark.api.java.JavaRDD<uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetJavaRDDOfElementsInRanges#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetJavaRDDOfElementsInRanges} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetJavaRDDOfElementsInRanges#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetJavaRDDOfElementsInRanges (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetJavaRDDOfElementsInRanges GetJavaRDDOfElementsInRanges.shallowClone()"})
  void testShallowClone_givenGetJavaRDDOfElementsInRanges_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetJavaRDDOfElementsInRanges actualShallowCloneResult =
        new GetJavaRDDOfElementsInRanges().shallowClone();

    // Assert
    TypeReference<JavaRDD<Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof JavaRDDElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "org.apache.spark.api.java.JavaRDD<uk.gov.gchq.gaffer.data.element.Element>",
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
   * Test {@link GetJavaRDDOfElementsInRanges#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetJavaRDDOfElementsInRanges#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetJavaRDDOfElementsInRanges GetJavaRDDOfElementsInRanges.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    GetJavaRDDOfElementsInRanges getJavaRDDOfElementsInRanges = new GetJavaRDDOfElementsInRanges();
    getJavaRDDOfElementsInRanges.setOptions(new HashMap<>());

    // Act
    GetJavaRDDOfElementsInRanges actualShallowCloneResult =
        getJavaRDDOfElementsInRanges.shallowClone();

    // Assert
    TypeReference<JavaRDD<Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof JavaRDDElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "org.apache.spark.api.java.JavaRDD<uk.gov.gchq.gaffer.data.element.Element>",
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
