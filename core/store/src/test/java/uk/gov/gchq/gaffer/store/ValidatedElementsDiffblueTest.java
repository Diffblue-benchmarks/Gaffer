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

package uk.gov.gchq.gaffer.store;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ValidatedElementsDiffblueTest {
  /**
   * Test {@link ValidatedElements#ValidatedElements(Iterable, View, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not iterator hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidatedElements#ValidatedElements(Iterable, View, boolean)}
   */
  @Test
  @DisplayName("Test new ValidatedElements(Iterable, View, boolean); when ArrayList(); then return not iterator hasNext")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidatedElements.<init>(Iterable, View, boolean)"})
  void testNewValidatedElements_whenArrayList_thenReturnNotIteratorHasNext() {
    // Arrange
    ArrayList<Element> elements = new ArrayList<>();

    // Act and Assert
    assertFalse((new ValidatedElements(elements, new View(), true)).iterator().hasNext());
  }

  /**
   * Test {@link ValidatedElements#ValidatedElements(Iterable, Schema, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not iterator hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidatedElements#ValidatedElements(Iterable, Schema, boolean)}
   */
  @Test
  @DisplayName("Test new ValidatedElements(Iterable, Schema, boolean); when ArrayList(); then return not iterator hasNext")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidatedElements.<init>(Iterable, Schema, boolean)"})
  void testNewValidatedElements_whenArrayList_thenReturnNotIteratorHasNext2() {
    // Arrange
    ArrayList<Element> elements = new ArrayList<>();

    // Act and Assert
    assertFalse((new ValidatedElements(elements, new Schema(), true)).iterator().hasNext());
  }

  /**
   * Test {@link ValidatedElements#handleInvalidItem(Element)} with {@code Element}.
   * <p>
   * Method under test: {@link ValidatedElements#handleInvalidItem(Element)}
   */
  @Test
  @DisplayName("Test handleInvalidItem(Element) with 'Element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidatedElements.handleInvalidItem(Element)"})
  void testHandleInvalidItemWithElement() {
    // Arrange
    ValidatedElements validatedElements = new ValidatedElements(new ArrayList<>(), (View) null, true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validatedElements.handleInvalidItem(new Edge("Group")));
  }

  /**
   * Test {@link ValidatedElements#handleInvalidItem(Element)} with {@code Element}.
   * <p>
   * Method under test: {@link ValidatedElements#handleInvalidItem(Element)}
   */
  @Test
  @DisplayName("Test handleInvalidItem(Element) with 'Element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidatedElements.handleInvalidItem(Element)"})
  void testHandleInvalidItemWithElement2() {
    // Arrange
    ArrayList<Element> elements = new ArrayList<>();
    ValidatedElements validatedElements = new ValidatedElements(elements, new View(), true);
    Edge item = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validatedElements.handleInvalidItem(item));
  }

  /**
   * Test {@link ValidatedElements#handleInvalidItem(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidatedElements#handleInvalidItem(Element)}
   */
  @Test
  @DisplayName("Test handleInvalidItem(Element) with 'Element'; when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidatedElements.handleInvalidItem(Element)"})
  void testHandleInvalidItemWithElement_whenEdgeWithGroup() {
    // Arrange
    ArrayList<Element> elements = new ArrayList<>();
    ValidatedElements validatedElements = new ValidatedElements(elements, new View(), true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validatedElements.handleInvalidItem(new Edge("Group")));
  }

  /**
   * Test {@link ValidatedElements#handleInvalidItem(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidatedElements#handleInvalidItem(Element)}
   */
  @Test
  @DisplayName("Test handleInvalidItem(Element) with 'Element'; when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidatedElements.handleInvalidItem(Element)"})
  void testHandleInvalidItemWithElement_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<Element> elements = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ValidatedElements(elements, new View(), true)).handleInvalidItem(null));
  }

  /**
   * Test {@link ValidatedElements#transform(Element)} with {@code Element}.
   * <p>
   * Method under test: {@link ValidatedElements#transform(Element)}
   */
  @Test
  @DisplayName("Test transform(Element) with 'Element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ValidatedElements.transform(Element)"})
  void testTransformWithElement() {
    // Arrange
    ArrayList<Element> elements = new ArrayList<>();
    ValidatedElements validatedElements = new ValidatedElements(elements, new View(), true);
    Edge item = new Edge("Group");

    // Act and Assert
    assertSame(item, validatedElements.transform(item));
  }
}
