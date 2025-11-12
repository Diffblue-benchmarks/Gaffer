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

package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.IdentifierType;
import uk.gov.gchq.gaffer.data.element.LazyEdge;

class ExtractIdDiffblueTest {
  /**
   * Method under test: {@link ExtractId#apply(Element)}
   */
  @Test
  void testApply() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.VERTEX);

    // Act and Assert
    assertNull(extractId.apply(new Edge("Group")));
  }

  /**
   * Method under test: {@link ExtractId#apply(Element)}
   */
  @Test
  void testApply2() {
    // Arrange, Act and Assert
    assertNull((new ExtractId(IdentifierType.VERTEX)).apply(null));
  }

  /**
   * Method under test: {@link ExtractId#apply(Element)}
   */
  @Test
  void testApply3() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.VERTEX);
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualApplyResult = extractId.apply(new LazyEdge(new Edge("Group"), valueLoader));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualApplyResult);
  }

  /**
   * Method under test: {@link ExtractId#apply(Element)}
   */
  @Test
  void testApply4() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.GROUP);
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualApplyResult = extractId.apply(new LazyEdge(new Edge("Group"), valueLoader));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Group", actualApplyResult);
  }

  /**
   * Method under test: {@link ExtractId#apply(Element)}
   */
  @Test
  void testApply5() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.DIRECTED);
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    extractId.apply(new LazyEdge(new Edge("Group", "Source", "Destination", true), valueLoader));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractId#equals(Object)}
   *   <li>{@link ExtractId#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.VERTEX);
    ExtractId extractId2 = new ExtractId(IdentifierType.VERTEX);

    // Act and Assert
    assertEquals(extractId, extractId2);
    int expectedHashCodeResult = extractId.hashCode();
    assertEquals(expectedHashCodeResult, extractId2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractId#equals(Object)}
   *   <li>{@link ExtractId#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.VERTEX);

    // Act and Assert
    assertEquals(extractId, extractId);
    int expectedHashCodeResult = extractId.hashCode();
    assertEquals(expectedHashCodeResult, extractId.hashCode());
  }

  /**
   * Method under test: {@link ExtractId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.SOURCE);

    // Act and Assert
    assertNotEquals(extractId, new ExtractId(IdentifierType.VERTEX));
  }

  /**
   * Method under test: {@link ExtractId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExtractId(IdentifierType.VERTEX), null);
  }

  /**
   * Method under test: {@link ExtractId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExtractId(IdentifierType.VERTEX), "Different type to ExtractId");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractId#ExtractId()}
   *   <li>{@link ExtractId#setId(IdentifierType)}
   *   <li>{@link ExtractId#toString()}
   *   <li>{@link ExtractId#getId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ExtractId actualExtractId = new ExtractId();
    actualExtractId.setId(IdentifierType.VERTEX);
    actualExtractId.toString();

    // Assert that nothing has changed
    assertEquals(IdentifierType.VERTEX, actualExtractId.getId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractId#ExtractId(IdentifierType)}
   *   <li>{@link ExtractId#setId(IdentifierType)}
   *   <li>{@link ExtractId#toString()}
   *   <li>{@link ExtractId#getId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ExtractId actualExtractId = new ExtractId(IdentifierType.VERTEX);
    actualExtractId.setId(IdentifierType.VERTEX);
    actualExtractId.toString();

    // Assert that nothing has changed
    assertEquals(IdentifierType.VERTEX, actualExtractId.getId());
  }
}
