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

package uk.gov.gchq.gaffer.operation.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.operation.impl.get.GetElements;
import uk.gov.gchq.gaffer.operation.impl.get.GetElements.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;
import uk.gov.gchq.koryphe.iterable.MappedIterable;
import uk.gov.gchq.koryphe.iterable.MappedIterator;

class MultiElementIdInputDiffblueTest {
  /**
   * Test Builder {@link MultiElementIdInput.Builder#inputIds(Iterable)}.
   * <p>
   * Method under test: {@link MultiElementIdInput.Builder#inputIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder inputIds(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MultiElementIdInput.Builder MultiElementIdInput.Builder.inputIds(Iterable)"})
  void testBuilderInputIds() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.inputIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link MultiElementIdInput.Builder#input(ElementId[])} with {@code ElementId[]}.
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiElementIdInput.Builder#input(ElementId[])}
   */
  @Test
  @DisplayName("Test Builder input(ElementId[]) with 'ElementId[]'; when EdgeSeed(); then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MultiElementIdInput.Builder MultiElementIdInput.Builder.input(ElementId[])"})
  void testBuilderInputWithElementId_whenEdgeSeed_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.input(new EdgeSeed()));
  }

  /**
   * Test Builder {@link MultiElementIdInput.Builder#input(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then _getOp OutputTypeReference return {@link TypeReferenceImpl.IterableElement}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiElementIdInput.Builder#input(Iterable)}
   */
  @Test
  @DisplayName("Test Builder input(Iterable) with 'Iterable'; then _getOp OutputTypeReference return IterableElement")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MultiElementIdInput.Builder MultiElementIdInput.Builder.input(Iterable)"})
  void testBuilderInputWithIterable_then_getOpOutputTypeReferenceReturnIterableElement() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputResult = builder.input(new ArrayList<>());

    // Assert
    GetElements _getOpResult = actualInputResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof IterableElement);
    Iterable<? extends ElementId> input = _getOpResult.getInput();
    assertTrue(input instanceof MappedIterable);
    Iterator<? extends ElementId> iteratorResult = input.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    assertSame(_getOpResult, actualInputResult.build());
  }

  /**
   * Test Builder {@link MultiElementIdInput.Builder#input(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiElementIdInput.Builder#input(Iterable)}
   */
  @Test
  @DisplayName("Test Builder input(Iterable) with 'Iterable'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MultiElementIdInput.Builder MultiElementIdInput.Builder.input(Iterable)"})
  void testBuilderInputWithIterable_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.input((Iterable) null));
  }

  /**
   * Test Builder {@link MultiElementIdInput.Builder#input(Object[])} with {@code Object[]}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@link Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiElementIdInput.Builder#input(Object[])}
   */
  @Test
  @DisplayName("Test Builder input(Object[]) with 'Object[]'; when 'Input'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MultiElementIdInput.Builder MultiElementIdInput.Builder.input(Object[])"})
  void testBuilderInputWithObject_whenInput_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.input("Input"));
  }

  /**
   * Test {@link MultiElementIdInput#setInputFromVerticesAndIds(Object[])}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then {@link GetElements} (default constructor) Input {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiElementIdInput#setInputFromVerticesAndIds(Object[])}
   */
  @Test
  @DisplayName("Test setInputFromVerticesAndIds(Object[]); when 'Input'; then GetElements (default constructor) Input List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MultiElementIdInput.setInputFromVerticesAndIds(Object[])"})
  void testSetInputFromVerticesAndIds_whenInput_thenGetElementsInputList() {
    // Arrange
    GetElements getElements = new GetElements();

    // Act
    getElements.setInputFromVerticesAndIds("Input");

    // Assert
    Iterable<? extends ElementId> input = getElements.getInput();
    assertTrue(input instanceof List);
    assertEquals(1, ((List<? extends ElementId>) input).size());
    ElementId getResult = ((List<? extends ElementId>) input).get(0);
    assertTrue(getResult instanceof EntitySeed);
    assertEquals("Input", ((EntitySeed) getResult).getVertex());
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", getResult.getClassName());
  }

  /**
   * Test {@link MultiElementIdInput#setInputFromVerticesAndIds(Object[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link GetElements} (default constructor) Input is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiElementIdInput#setInputFromVerticesAndIds(Object[])}
   */
  @Test
  @DisplayName("Test setInputFromVerticesAndIds(Object[]); when 'null'; then GetElements (default constructor) Input is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MultiElementIdInput.setInputFromVerticesAndIds(Object[])"})
  void testSetInputFromVerticesAndIds_whenNull_thenGetElementsInputIsNull() {
    // Arrange
    GetElements getElements = new GetElements();

    // Act
    getElements.setInputFromVerticesAndIds(null);

    // Assert that nothing has changed
    assertNull(getElements.getInput());
  }

  /**
   * Test {@link MultiElementIdInput#createInputArray()}.
   * <ul>
   *   <li>Given {@link GetElements} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiElementIdInput#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); given GetElements (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] MultiElementIdInput.createInputArray()"})
  void testCreateInputArray_givenGetElements_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new GetElements()).createInputArray());
  }

  /**
   * Test {@link MultiElementIdInput#createInputArray()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiElementIdInput#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] MultiElementIdInput.createInputArray()"})
  void testCreateInputArray_thenReturnArrayLengthIsZero() {
    // Arrange
    GetElements getElements = new GetElements();
    getElements.setInput(new ArrayList<>());

    // Act and Assert
    assertEquals(0, getElements.createInputArray().length);
  }

  /**
   * Test {@link MultiElementIdInput#setInput(ElementId[])} with {@code ElementId[]}.
   * <ul>
   *   <li>Then {@link GetElements} (default constructor) Input {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiElementIdInput#setInput(ElementId[])}
   */
  @Test
  @DisplayName("Test setInput(ElementId[]) with 'ElementId[]'; then GetElements (default constructor) Input List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MultiElementIdInput.setInput(ElementId[])"})
  void testSetInputWithElementId_thenGetElementsInputList() {
    // Arrange
    GetElements getElements = new GetElements();
    EdgeSeed edgeSeed = new EdgeSeed();

    // Act
    getElements.setInput(new ElementId[]{edgeSeed});

    // Assert
    Iterable<? extends ElementId> input = getElements.getInput();
    assertTrue(input instanceof List);
    assertEquals(1, ((List<? extends ElementId>) input).size());
    assertSame(edgeSeed, ((List<? extends ElementId>) input).get(0));
  }
}
