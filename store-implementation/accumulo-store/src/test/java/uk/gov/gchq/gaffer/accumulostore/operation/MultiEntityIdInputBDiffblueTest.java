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

package uk.gov.gchq.gaffer.accumulostore.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets.Builder;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;
import uk.gov.gchq.koryphe.iterable.MappedIterable;
import uk.gov.gchq.koryphe.iterable.MappedIterator;

class MultiEntityIdInputBDiffblueTest {
  /**
   * Test Builder {@link MultiEntityIdInputB.Builder#inputB(EntityId[])} with {@code EntityId[]}.
   *
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.
   *   <li>Then return {@link GetElementsBetweenSets.Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInputB.Builder#inputB(EntityId[])}
   */
  @Test
  @DisplayName(
      "Test Builder inputB(EntityId[]) with 'EntityId[]'; when EntitySeed(); then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MultiEntityIdInputB.Builder MultiEntityIdInputB.Builder.inputB(EntityId[])"})
  void testBuilderInputBWithEntityId_whenEntitySeed_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputBResult = builder.inputB(new EntitySeed());

    // Assert
    assertSame(builder, actualInputBResult);
  }

  /**
   * Test Builder {@link MultiEntityIdInputB.Builder#inputB(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then _getOp OutputTypeReference return {@link TypeReferenceImpl.IterableElement}.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInputB.Builder#inputB(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder inputB(Iterable) with 'Iterable'; then _getOp OutputTypeReference return IterableElement")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MultiEntityIdInputB.Builder MultiEntityIdInputB.Builder.inputB(Iterable)"})
  void testBuilderInputBWithIterable_then_getOpOutputTypeReferenceReturnIterableElement() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputBResult = builder.inputB(new ArrayList<>());

    // Assert
    GetElementsBetweenSets _getOpResult = actualInputBResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof IterableElement);
    Iterable<? extends EntityId> inputB = _getOpResult.getInputB();
    assertTrue(inputB instanceof MappedIterable);
    Iterator<? extends EntityId> iteratorResult = inputB.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    GetElementsBetweenSets actualGetElementsBetweenSets = actualInputBResult.build();
    assertSame(_getOpResult, actualGetElementsBetweenSets);
  }

  /**
   * Test Builder {@link MultiEntityIdInputB.Builder#inputB(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link GetElementsBetweenSets.Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInputB.Builder#inputB(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder inputB(Iterable) with 'Iterable'; when 'null'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MultiEntityIdInputB.Builder MultiEntityIdInputB.Builder.inputB(Iterable)"})
  void testBuilderInputBWithIterable_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputBResult = builder.inputB((Iterable) null);

    // Assert
    assertSame(builder, actualInputBResult);
  }

  /**
   * Test Builder {@link MultiEntityIdInputB.Builder#inputB(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code Input B}.
   *   <li>Then return {@link GetElementsBetweenSets.Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInputB.Builder#inputB(Object[])}
   */
  @Test
  @DisplayName(
      "Test Builder inputB(Object[]) with 'Object[]'; when 'Input B'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MultiEntityIdInputB.Builder MultiEntityIdInputB.Builder.inputB(Object[])"})
  void testBuilderInputBWithObject_whenInputB_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputBResult = builder.inputB("Input B");

    // Assert
    assertSame(builder, actualInputBResult);
  }

  /**
   * Test Builder {@link MultiEntityIdInputB.Builder#inputIdsB(Iterable)}.
   *
   * <p>Method under test: {@link MultiEntityIdInputB.Builder#inputIdsB(Iterable)}
   */
  @Test
  @DisplayName("Test Builder inputIdsB(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MultiEntityIdInputB.Builder MultiEntityIdInputB.Builder.inputIdsB(Iterable)"})
  void testBuilderInputIdsB() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputIdsBResult = builder.inputIdsB(new ArrayList<>());

    // Assert
    assertSame(builder, actualInputIdsBResult);
  }

  /**
   * Test {@link MultiEntityIdInputB#setInputBFromVerticesAndIds(Object[])}.
   *
   * <ul>
   *   <li>When {@code Input B}.
   *   <li>Then {@link GetElementsBetweenSets} (default constructor) InputB {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInputB#setInputBFromVerticesAndIds(Object[])}
   */
  @Test
  @DisplayName(
      "Test setInputBFromVerticesAndIds(Object[]); when 'Input B'; then GetElementsBetweenSets (default constructor) InputB List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiEntityIdInputB.setInputBFromVerticesAndIds(Object[])"})
  void testSetInputBFromVerticesAndIds_whenInputB_thenGetElementsBetweenSetsInputBList() {
    // Arrange
    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();

    // Act
    getElementsBetweenSets.setInputBFromVerticesAndIds("Input B");

    // Assert
    Iterable<? extends EntityId> inputB = getElementsBetweenSets.getInputB();
    assertTrue(inputB instanceof List);
    assertEquals(1, ((List<? extends EntityId>) inputB).size());
    EntityId getResult = ((List<? extends EntityId>) inputB).get(0);
    assertTrue(getResult instanceof EntitySeed);
    assertEquals("Input B", getResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", getResult.getClassName());
  }

  /**
   * Test {@link MultiEntityIdInputB#setInputBFromVerticesAndIds(Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link GetElementsBetweenSets} (default constructor) InputB is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInputB#setInputBFromVerticesAndIds(Object[])}
   */
  @Test
  @DisplayName(
      "Test setInputBFromVerticesAndIds(Object[]); when 'null'; then GetElementsBetweenSets (default constructor) InputB is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiEntityIdInputB.setInputBFromVerticesAndIds(Object[])"})
  void testSetInputBFromVerticesAndIds_whenNull_thenGetElementsBetweenSetsInputBIsNull() {
    // Arrange
    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();

    // Act
    getElementsBetweenSets.setInputBFromVerticesAndIds(null);

    // Assert that nothing has changed
    assertNull(getElementsBetweenSets.getInputB());
  }

  /**
   * Test {@link MultiEntityIdInputB#createInputBArray()}.
   *
   * <ul>
   *   <li>Given {@link GetElementsBetweenSets} (default constructor) InputB is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInputB#createInputBArray()}
   */
  @Test
  @DisplayName(
      "Test createInputBArray(); given GetElementsBetweenSets (default constructor) InputB is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] MultiEntityIdInputB.createInputBArray()"})
  void testCreateInputBArray_givenGetElementsBetweenSetsInputBIsArrayList() {
    // Arrange
    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();
    getElementsBetweenSets.setInputB(new ArrayList<>());

    // Act and Assert
    assertEquals(0, getElementsBetweenSets.createInputBArray().length);
  }

  /**
   * Test {@link MultiEntityIdInputB#createInputBArray()}.
   *
   * <ul>
   *   <li>Given {@link GetElementsBetweenSets} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInputB#createInputBArray()}
   */
  @Test
  @DisplayName(
      "Test createInputBArray(); given GetElementsBetweenSets (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] MultiEntityIdInputB.createInputBArray()"})
  void testCreateInputBArray_givenGetElementsBetweenSets_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GetElementsBetweenSets().createInputBArray());
  }

  /**
   * Test {@link MultiEntityIdInputB#createInputBArray()}.
   *
   * <ul>
   *   <li>Then first element return {@link Entity}.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInputB#createInputBArray()}
   */
  @Test
  @DisplayName("Test createInputBArray(); then first element return Entity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] MultiEntityIdInputB.createInputBArray()"})
  void testCreateInputBArray_thenFirstElementReturnEntity() {
    // Arrange
    ArrayList<EntityId> entityIdList = new ArrayList<>();
    entityIdList.add(new Entity.Builder().group("Group").vertex("Vertex").build());

    Iterable<EntityId> inputB = mock(Iterable.class);
    when(inputB.iterator()).thenReturn(entityIdList.iterator());

    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();
    getElementsBetweenSets.setInputB(inputB);

    // Act
    Object[] actualCreateInputBArrayResult = getElementsBetweenSets.createInputBArray();

    // Assert
    verify(inputB).iterator();
    Object object = actualCreateInputBArrayResult[0];
    assertTrue(object instanceof Entity);
    assertEquals("Group", ((Entity) object).getGroup());
    assertEquals("Vertex", ((Entity) object).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", ((Entity) object).getClassName());
    assertEquals(1, actualCreateInputBArrayResult.length);
    assertTrue(((Entity) object).getProperties().isEmpty());
  }

  /**
   * Test {@link MultiEntityIdInputB#createInputBArray()}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInputB#createInputBArray()}
   */
  @Test
  @DisplayName("Test createInputBArray(); then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] MultiEntityIdInputB.createInputBArray()"})
  void testCreateInputBArray_thenReturnArrayLengthIsZero() {
    // Arrange
    Iterable<EntityId> inputB = mock(Iterable.class);

    ArrayList<EntityId> entityIdList = new ArrayList<>();
    when(inputB.iterator()).thenReturn(entityIdList.iterator());

    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();
    getElementsBetweenSets.setInputB(inputB);

    // Act
    Object[] actualCreateInputBArrayResult = getElementsBetweenSets.createInputBArray();

    // Assert
    verify(inputB).iterator();
    assertEquals(0, actualCreateInputBArrayResult.length);
  }

  /**
   * Test {@link MultiEntityIdInputB#setInputB(EntityId[])} with {@code EntityId[]}.
   *
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.
   *   <li>Then {@link GetElementsBetweenSets} (default constructor) InputB {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInputB#setInputB(EntityId[])}
   */
  @Test
  @DisplayName(
      "Test setInputB(EntityId[]) with 'EntityId[]'; when EntitySeed(); then GetElementsBetweenSets (default constructor) InputB List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiEntityIdInputB.setInputB(EntityId[])"})
  void testSetInputBWithEntityId_whenEntitySeed_thenGetElementsBetweenSetsInputBList() {
    // Arrange
    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();
    EntitySeed entitySeed = new EntitySeed();

    // Act
    getElementsBetweenSets.setInputB(entitySeed);

    // Assert
    Iterable<? extends EntityId> inputB = getElementsBetweenSets.getInputB();
    assertTrue(inputB instanceof List);
    assertEquals(1, ((List<? extends EntityId>) inputB).size());
    assertSame(entitySeed, ((List<? extends EntityId>) inputB).get(0));
  }
}
