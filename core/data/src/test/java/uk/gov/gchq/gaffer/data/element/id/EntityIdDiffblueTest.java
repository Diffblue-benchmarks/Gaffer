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

package uk.gov.gchq.gaffer.data.element.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.LazyEntity;

class EntityIdDiffblueTest {
  /**
   * Method under test: {@link EntityId#isRelated(EdgeId)}
   */
  @Test
  void testIsRelated() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEntity lazyEntity = new LazyEntity(new Entity("Group"), valueLoader);

    // Act
    ElementId.Matches actualIsRelatedResult = lazyEntity
        .isRelated((EdgeId) new Edge("Group", "Source", "Destination", true));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(ElementId.Matches.NONE, actualIsRelatedResult);
  }

  /**
   * Method under test: {@link EntityId#isRelated(ElementId)}
   */
  @Test
  void testIsRelated2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEntity lazyEntity = new LazyEntity(new Entity("Group"), valueLoader);

    // Act
    ElementId.Matches actualIsRelatedResult = lazyEntity.isRelated(new Entity("Group"));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(ElementId.Matches.VERTEX, actualIsRelatedResult);
  }

  /**
   * Method under test: {@link EntityId#isRelated(ElementId)}
   */
  @Test
  void testIsRelated3() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEntity lazyEntity = new LazyEntity(new Entity("Group"), valueLoader);

    // Act
    ElementId.Matches actualIsRelatedResult = lazyEntity.isRelated(new Entity("Group", "Vertex"));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(ElementId.Matches.NONE, actualIsRelatedResult);
  }

  /**
   * Method under test: {@link EntityId#isRelated(ElementId)}
   */
  @Test
  void testIsRelated4() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEntity lazyEntity = new LazyEntity(new Entity("Group"), valueLoader);

    // Act
    ElementId.Matches actualIsRelatedResult = lazyEntity
        .isRelated((ElementId) new Edge("Group", "Source", "Destination", true));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(ElementId.Matches.NONE, actualIsRelatedResult);
  }

  /**
   * Method under test: {@link EntityId#isRelated(ElementId)}
   */
  @Test
  void testIsRelated5() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEntity lazyEntity = new LazyEntity(new Entity("Group"), valueLoader);

    // Act
    ElementId.Matches actualIsRelatedResult = lazyEntity
        .isRelated((ElementId) new Edge("Group", null, "Destination", true));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(ElementId.Matches.SOURCE, actualIsRelatedResult);
  }

  /**
   * Method under test: {@link EntityId#isRelated(ElementId)}
   */
  @Test
  void testIsRelated6() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEntity lazyEntity = new LazyEntity(new Entity("Group"), valueLoader);

    // Act
    ElementId.Matches actualIsRelatedResult = lazyEntity.isRelated((ElementId) new Edge("Group", "Source", null, true));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(ElementId.Matches.DESTINATION, actualIsRelatedResult);
  }
}
