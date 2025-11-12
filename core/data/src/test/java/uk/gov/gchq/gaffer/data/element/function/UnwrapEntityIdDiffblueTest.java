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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.LazyEntity;

class UnwrapEntityIdDiffblueTest {
  /**
   * Method under test: {@link UnwrapEntityId#apply(Object)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertEquals("Item", (new UnwrapEntityId()).apply("Item"));
    assertNull((new UnwrapEntityId()).apply(null));
  }

  /**
   * Method under test: {@link UnwrapEntityId#apply(Object)}
   */
  @Test
  void testApply2() {
    // Arrange
    UnwrapEntityId unwrapEntityId = new UnwrapEntityId();

    // Act and Assert
    assertNull(unwrapEntityId.apply(new Entity("Group")));
  }

  /**
   * Method under test: {@link UnwrapEntityId#apply(Object)}
   */
  @Test
  void testApply3() {
    // Arrange
    UnwrapEntityId unwrapEntityId = new UnwrapEntityId();
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualApplyResult = unwrapEntityId.apply(new LazyEntity(new Entity("Group"), valueLoader));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualApplyResult);
  }
}
