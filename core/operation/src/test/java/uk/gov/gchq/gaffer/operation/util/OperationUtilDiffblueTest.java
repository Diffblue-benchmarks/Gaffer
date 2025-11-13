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

package uk.gov.gchq.gaffer.operation.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.impl.OperationImpl;
import uk.gov.gchq.koryphe.iterable.MappedIterable;
import uk.gov.gchq.koryphe.iterable.MappedIterator;

class OperationUtilDiffblueTest {
  /**
   * Test {@link OperationUtil#toElementIds(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link MappedIterable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#toElementIds(Iterable)}
   */
  @Test
  @DisplayName("Test toElementIds(Iterable) with 'Iterable'; when ArrayList(); then return MappedIterable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable OperationUtil.toElementIds(Iterable)"})
  void testToElementIdsWithIterable_whenArrayList_thenReturnMappedIterable() {
    // Arrange and Act
    Iterable<? extends ElementId> actualToElementIdsResult = OperationUtil.toElementIds(new ArrayList<>());
    Iterator<? extends ElementId> actualIteratorResult = actualToElementIdsResult.iterator();

    // Assert
    assertTrue(actualToElementIdsResult instanceof MappedIterable);
    Iterator<? extends ElementId> iteratorResult = actualToElementIdsResult.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertTrue(actualIteratorResult instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link OperationUtil#fromElementIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link MappedIterable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#fromElementIds(Iterable)}
   */
  @Test
  @DisplayName("Test fromElementIds(Iterable); when ArrayList(); then return MappedIterable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable OperationUtil.fromElementIds(Iterable)"})
  void testFromElementIds_whenArrayList_thenReturnMappedIterable() {
    // Arrange and Act
    Iterable<?> actualFromElementIdsResult = OperationUtil.fromElementIds(new ArrayList<>());
    Iterator<?> actualIteratorResult = actualFromElementIdsResult.iterator();

    // Assert
    assertTrue(actualFromElementIdsResult instanceof MappedIterable);
    Iterator<?> iteratorResult = actualFromElementIdsResult.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertTrue(actualIteratorResult instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link OperationUtil#toEntityIds(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link MappedIterable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#toEntityIds(Iterable)}
   */
  @Test
  @DisplayName("Test toEntityIds(Iterable) with 'Iterable'; when ArrayList(); then return MappedIterable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable OperationUtil.toEntityIds(Iterable)"})
  void testToEntityIdsWithIterable_whenArrayList_thenReturnMappedIterable() {
    // Arrange and Act
    Iterable<? extends EntityId> actualToEntityIdsResult = OperationUtil.toEntityIds(new ArrayList<>());
    Iterator<? extends EntityId> actualIteratorResult = actualToEntityIdsResult.iterator();

    // Assert
    assertTrue(actualToEntityIdsResult instanceof MappedIterable);
    Iterator<? extends EntityId> iteratorResult = actualToEntityIdsResult.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertTrue(actualIteratorResult instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link OperationUtil#fromEntityIds(Iterable)}.
   * <p>
   * Method under test: {@link OperationUtil#fromEntityIds(Iterable)}
   */
  @Test
  @DisplayName("Test fromEntityIds(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable OperationUtil.fromEntityIds(Iterable)"})
  void testFromEntityIds() {
    // Arrange and Act
    Iterable<?> actualFromEntityIdsResult = OperationUtil.fromEntityIds(new ArrayList<>());
    Iterator<?> actualIteratorResult = actualFromEntityIdsResult.iterator();

    // Assert
    assertTrue(actualFromEntityIdsResult instanceof MappedIterable);
    Iterator<?> iteratorResult = actualFromEntityIdsResult.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertTrue(actualIteratorResult instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link OperationUtil#extractNextOp(Iterator)}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#extractNextOp(Iterator)}
   */
  @Test
  @DisplayName("Test extractNextOp(Iterator); given AddNamedOperation (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation OperationUtil.extractNextOp(Iterator)"})
  void testExtractNextOp_givenAddNamedOperation_thenReturnNull() {
    // Arrange
    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(new AddNamedOperation());
    Iterator<Operation> itr = operationList.iterator();

    // Act and Assert
    assertNull(OperationUtil.extractNextOp(itr));
    assertFalse(itr.hasNext());
  }

  /**
   * Test {@link OperationUtil#extractNextOp(Iterator)}.
   * <ul>
   *   <li>Given {@link OperationImpl} (default constructor).</li>
   *   <li>Then return {@link OperationImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationUtil#extractNextOp(Iterator)}
   */
  @Test
  @DisplayName("Test extractNextOp(Iterator); given OperationImpl (default constructor); then return OperationImpl")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation OperationUtil.extractNextOp(Iterator)"})
  void testExtractNextOp_givenOperationImpl_thenReturnOperationImpl() {
    // Arrange
    ArrayList<Operation> operationList = new ArrayList<>();
    operationList.add(new OperationImpl());

    // Act
    Operation actualExtractNextOpResult = OperationUtil.extractNextOp(operationList.iterator());

    // Assert
    assertTrue(actualExtractNextOpResult instanceof OperationImpl);
    assertNull(((OperationImpl) actualExtractNextOpResult).getRequiredField1());
    assertNull(((OperationImpl) actualExtractNextOpResult).getOptionalField1());
    assertNull(actualExtractNextOpResult.getOptions());
    assertNull(((OperationImpl) actualExtractNextOpResult).getOptionalField2());
    assertNull(((OperationImpl) actualExtractNextOpResult).getRequiredField2());
  }
}
