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

package uk.gov.gchq.gaffer.operation.impl.get;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters.IncludeIncomingOutgoingType;
import uk.gov.gchq.gaffer.operation.impl.get.GetElements.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;

class GetElementsDiffblueTest {
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
    GetElements _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends Element>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getDirectedType());
    assertNull(_getOpResult.getView());
    assertNull(_getOpResult.getIncludeIncomingOutGoing());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetElements#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link GetElements#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference GetElements.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends Element>> actualOutputTypeReference = (new GetElements()).getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableElement);
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetElements#shallowClone()}.
   * <ul>
   *   <li>Given {@link GetElements} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link GetElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetElements (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetElements GetElements.shallowClone()"})
  void testShallowClone_givenGetElements() {
    // Arrange
    GetElements getElements = new GetElements();

    // Act and Assert
    assertEquals(getElements, getElements.shallowClone());
  }

  /**
   * Test {@link GetElements#shallowClone()}.
   * <ul>
   *   <li>Given {@link GetElements} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetElements (default constructor) Options is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetElements GetElements.shallowClone()"})
  void testShallowClone_givenGetElementsOptionsIsHashMap() {
    // Arrange
    GetElements getElements = new GetElements();
    getElements.setOptions(new HashMap<>());

    // Act and Assert
    assertEquals(getElements, getElements.shallowClone());
  }

  /**
   * Test {@link GetElements#equals(Object)}, and {@link GetElements#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GetElements#equals(Object)}
   *   <li>{@link GetElements#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetElements.equals(Object)", "int GetElements.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GetElements getElements = new GetElements();
    GetElements getElements2 = new GetElements();

    // Act and Assert
    assertEquals(getElements, getElements2);
    int expectedHashCodeResult = getElements.hashCode();
    assertEquals(expectedHashCodeResult, getElements2.hashCode());
  }

  /**
   * Test {@link GetElements#equals(Object)}, and {@link GetElements#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GetElements#equals(Object)}
   *   <li>{@link GetElements#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetElements.equals(Object)", "int GetElements.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GetElements getElements = new GetElements();

    // Act and Assert
    assertEquals(getElements, getElements);
    int expectedHashCodeResult = getElements.hashCode();
    assertEquals(expectedHashCodeResult, getElements.hashCode());
  }

  /**
   * Test {@link GetElements#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetElements#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetElements.equals(Object)", "int GetElements.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GetElements getElements = new GetElements();
    getElements.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType.EITHER);

    // Act and Assert
    assertNotEquals(getElements, new GetElements());
  }

  /**
   * Test {@link GetElements#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetElements#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetElements.equals(Object)", "int GetElements.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GetElements(), null);
  }

  /**
   * Test {@link GetElements#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetElements#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GetElements.equals(Object)", "int GetElements.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GetElements(), "Different type to GetElements");
  }
}
