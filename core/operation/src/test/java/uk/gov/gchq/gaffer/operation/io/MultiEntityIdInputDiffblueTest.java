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
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.operation.impl.GetWalks;
import uk.gov.gchq.gaffer.operation.impl.GetWalks.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableWalk;
import uk.gov.gchq.koryphe.iterable.MappedIterable;
import uk.gov.gchq.koryphe.iterable.MappedIterator;

class MultiEntityIdInputDiffblueTest {
  /**
   * Test Builder {@link MultiEntityIdInput.Builder#inputIds(Iterable)}.
   * <p>
   * Method under test: {@link MultiEntityIdInput.Builder#inputIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder inputIds(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MultiEntityIdInput.Builder MultiEntityIdInput.Builder.inputIds(Iterable)"})
  void testBuilderInputIds() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.inputIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link MultiEntityIdInput.Builder#input(EntityId[])} with {@code EntityId[]}.
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.</li>
   *   <li>Then return {@link GetWalks.Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiEntityIdInput.Builder#input(EntityId[])}
   */
  @Test
  @DisplayName("Test Builder input(EntityId[]) with 'EntityId[]'; when EntitySeed(); then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MultiEntityIdInput.Builder MultiEntityIdInput.Builder.input(EntityId[])"})
  void testBuilderInputWithEntityId_whenEntitySeed_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.input(new EntitySeed()));
  }

  /**
   * Test Builder {@link MultiEntityIdInput.Builder#input(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then _getOp OutputTypeReference return {@link TypeReferenceImpl.IterableWalk}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiEntityIdInput.Builder#input(Iterable)}
   */
  @Test
  @DisplayName("Test Builder input(Iterable) with 'Iterable'; then _getOp OutputTypeReference return IterableWalk")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MultiEntityIdInput.Builder MultiEntityIdInput.Builder.input(Iterable)"})
  void testBuilderInputWithIterable_then_getOpOutputTypeReferenceReturnIterableWalk() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputResult = builder.input(new ArrayList<>());

    // Assert
    GetWalks _getOpResult = actualInputResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof IterableWalk);
    Iterable<? extends EntityId> input = _getOpResult.getInput();
    assertTrue(input instanceof MappedIterable);
    Iterator<? extends EntityId> iteratorResult = input.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    assertSame(_getOpResult, actualInputResult.build());
  }

  /**
   * Test Builder {@link MultiEntityIdInput.Builder#input(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link GetWalks.Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiEntityIdInput.Builder#input(Iterable)}
   */
  @Test
  @DisplayName("Test Builder input(Iterable) with 'Iterable'; when 'null'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MultiEntityIdInput.Builder MultiEntityIdInput.Builder.input(Iterable)"})
  void testBuilderInputWithIterable_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.input((Iterable) null));
  }

  /**
   * Test Builder {@link MultiEntityIdInput.Builder#input(Object[])} with {@code Object[]}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@link GetWalks.Builder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiEntityIdInput.Builder#input(Object[])}
   */
  @Test
  @DisplayName("Test Builder input(Object[]) with 'Object[]'; when 'Input'; then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MultiEntityIdInput.Builder MultiEntityIdInput.Builder.input(Object[])"})
  void testBuilderInputWithObject_whenInput_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.input("Input"));
  }

  /**
   * Test {@link MultiEntityIdInput#setInputFromVerticesAndIds(Object[])}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then {@link GetWalks} (default constructor) Input {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiEntityIdInput#setInputFromVerticesAndIds(Object[])}
   */
  @Test
  @DisplayName("Test setInputFromVerticesAndIds(Object[]); when 'Input'; then GetWalks (default constructor) Input List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MultiEntityIdInput.setInputFromVerticesAndIds(Object[])"})
  void testSetInputFromVerticesAndIds_whenInput_thenGetWalksInputList() {
    // Arrange
    GetWalks getWalks = new GetWalks();

    // Act
    getWalks.setInputFromVerticesAndIds("Input");

    // Assert
    Iterable<? extends EntityId> input = getWalks.getInput();
    assertTrue(input instanceof List);
    assertEquals(1, ((List<? extends EntityId>) input).size());
    EntityId getResult = ((List<? extends EntityId>) input).get(0);
    assertTrue(getResult instanceof EntitySeed);
    assertEquals("Input", getResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", getResult.getClassName());
  }

  /**
   * Test {@link MultiEntityIdInput#setInputFromVerticesAndIds(Object[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link GetWalks} (default constructor) Input is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiEntityIdInput#setInputFromVerticesAndIds(Object[])}
   */
  @Test
  @DisplayName("Test setInputFromVerticesAndIds(Object[]); when 'null'; then GetWalks (default constructor) Input is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MultiEntityIdInput.setInputFromVerticesAndIds(Object[])"})
  void testSetInputFromVerticesAndIds_whenNull_thenGetWalksInputIsNull() {
    // Arrange
    GetWalks getWalks = new GetWalks();

    // Act
    getWalks.setInputFromVerticesAndIds(null);

    // Assert that nothing has changed
    assertNull(getWalks.getInput());
  }

  /**
   * Test {@link MultiEntityIdInput#createInputArray()}.
   * <ul>
   *   <li>Given {@link GetWalks} (default constructor) Input is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiEntityIdInput#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); given GetWalks (default constructor) Input is ArrayList(); then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] MultiEntityIdInput.createInputArray()"})
  void testCreateInputArray_givenGetWalksInputIsArrayList_thenReturnArrayLengthIsZero() {
    // Arrange
    GetWalks getWalks = new GetWalks();
    getWalks.setInput(new ArrayList<>());

    // Act and Assert
    assertEquals(0, getWalks.createInputArray().length);
  }

  /**
   * Test {@link MultiEntityIdInput#createInputArray()}.
   * <ul>
   *   <li>Given {@link GetWalks} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiEntityIdInput#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); given GetWalks (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[] MultiEntityIdInput.createInputArray()"})
  void testCreateInputArray_givenGetWalks_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new GetWalks()).createInputArray());
  }

  /**
   * Test {@link MultiEntityIdInput#setInput(EntityId[])} with {@code EntityId[]}.
   * <ul>
   *   <li>When array of {@link EntityId} with {@link EntitySeed#EntitySeed()}.</li>
   *   <li>Then {@link GetWalks} (default constructor) Input {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiEntityIdInput#setInput(EntityId[])}
   */
  @Test
  @DisplayName("Test setInput(EntityId[]) with 'EntityId[]'; when array of EntityId with EntitySeed(); then GetWalks (default constructor) Input List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MultiEntityIdInput.setInput(EntityId[])"})
  void testSetInputWithEntityId_whenArrayOfEntityIdWithEntitySeed_thenGetWalksInputList() {
    // Arrange
    GetWalks getWalks = new GetWalks();
    EntitySeed entitySeed = new EntitySeed();

    // Act
    getWalks.setInput(new EntityId[]{entitySeed});

    // Assert
    Iterable<? extends EntityId> input = getWalks.getInput();
    assertTrue(input instanceof List);
    assertEquals(1, ((List<? extends EntityId>) input).size());
    assertSame(entitySeed, ((List<? extends EntityId>) input).get(0));
  }
}
