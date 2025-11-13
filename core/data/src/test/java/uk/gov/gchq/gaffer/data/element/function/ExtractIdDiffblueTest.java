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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.IdentifierType;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class ExtractIdDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtractId#ExtractId()}
   *   <li>{@link ExtractId#setId(IdentifierType)}
   *   <li>{@link ExtractId#toString()}
   *   <li>{@link ExtractId#getId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExtractId.<init>()",
    "void ExtractId.<init>(IdentifierType)",
    "IdentifierType ExtractId.getId()",
    "void ExtractId.setId(IdentifierType)",
    "java.lang.String ExtractId.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ExtractId actualExtractId = new ExtractId();
    actualExtractId.setId(IdentifierType.VERTEX);
    actualExtractId.toString();

    // Assert
    assertEquals(IdentifierType.VERTEX, actualExtractId.getId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code VERTEX}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtractId#ExtractId(IdentifierType)}
   *   <li>{@link ExtractId#setId(IdentifierType)}
   *   <li>{@link ExtractId#toString()}
   *   <li>{@link ExtractId#getId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'VERTEX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExtractId.<init>()",
    "void ExtractId.<init>(IdentifierType)",
    "IdentifierType ExtractId.getId()",
    "void ExtractId.setId(IdentifierType)",
    "java.lang.String ExtractId.toString()"
  })
  void testGettersAndSetters_whenVertex() {
    // Arrange and Act
    ExtractId actualExtractId = new ExtractId(IdentifierType.VERTEX);
    actualExtractId.setId(IdentifierType.VERTEX);
    actualExtractId.toString();

    // Assert
    assertEquals(IdentifierType.VERTEX, actualExtractId.getId());
  }

  /**
   * Test {@link ExtractId#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link ExtractId#ExtractId(IdentifierType)} with id is {@code DIRECTED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractId#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; given ExtractId(IdentifierType) with id is 'DIRECTED'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ExtractId.apply(Element)"})
  void testApplyWithElement_givenExtractIdWithIdIsDirected_thenReturnFalse() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.DIRECTED);

    // Act
    Object actualApplyResult = extractId.apply(new Edge("Group"));

    // Assert
    assertFalse((Boolean) actualApplyResult);
  }

  /**
   * Test {@link ExtractId#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link ExtractId#ExtractId(IdentifierType)} with id is {@code GROUP}.
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractId#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; given ExtractId(IdentifierType) with id is 'GROUP'; then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ExtractId.apply(Element)"})
  void testApplyWithElement_givenExtractIdWithIdIsGroup_thenReturnGroup() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.GROUP);

    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge element = new LazyEdge(edge, valueLoader);

    // Act
    Object actualApplyResult = extractId.apply(element);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Group", actualApplyResult);
  }

  /**
   * Test {@link ExtractId#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link ExtractId#ExtractId(IdentifierType)} with id is {@code VERTEX}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractId#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; given ExtractId(IdentifierType) with id is 'VERTEX'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ExtractId.apply(Element)"})
  void testApplyWithElement_givenExtractIdWithIdIsVertex_thenReturnNull() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.VERTEX);

    // Act
    Object actualApplyResult = extractId.apply(new Edge("Group"));

    // Assert
    assertNull(actualApplyResult);
  }

  /**
   * Test {@link ExtractId#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link ExtractId#ExtractId(IdentifierType)} with id is {@code VERTEX}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractId#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; given ExtractId(IdentifierType) with id is 'VERTEX'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ExtractId.apply(Element)"})
  void testApplyWithElement_givenExtractIdWithIdIsVertex_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ExtractId(IdentifierType.VERTEX).apply(null));
  }

  /**
   * Test {@link ExtractId#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractId#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ExtractId.apply(Element)"})
  void testApplyWithElement_thenReturnTrue() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.DIRECTED);

    // Act
    Object actualApplyResult =
        extractId.apply(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    assertTrue((Boolean) actualApplyResult);
  }

  /**
   * Test {@link ExtractId#equals(Object)}, and {@link ExtractId#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtractId#equals(Object)}
   *   <li>{@link ExtractId#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExtractId.equals(Object)", "int ExtractId.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.VERTEX);
    ExtractId extractId2 = new ExtractId(IdentifierType.VERTEX);

    // Act and Assert
    assertEquals(extractId, extractId2);
    assertEquals(extractId.hashCode(), extractId2.hashCode());
  }

  /**
   * Test {@link ExtractId#equals(Object)}, and {@link ExtractId#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtractId#equals(Object)}
   *   <li>{@link ExtractId#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExtractId.equals(Object)", "int ExtractId.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.VERTEX);

    // Act and Assert
    assertEquals(extractId, extractId);
    int expectedHashCodeResult = extractId.hashCode();
    assertEquals(expectedHashCodeResult, extractId.hashCode());
  }

  /**
   * Test {@link ExtractId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ExtractId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExtractId.equals(Object)", "int ExtractId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExtractId extractId = new ExtractId(IdentifierType.SOURCE);

    // Act and Assert
    assertNotEquals(extractId, new ExtractId(IdentifierType.VERTEX));
  }

  /**
   * Test {@link ExtractId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ExtractId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExtractId.equals(Object)", "int ExtractId.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExtractId(IdentifierType.VERTEX), null);
  }

  /**
   * Test {@link ExtractId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ExtractId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExtractId.equals(Object)", "int ExtractId.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExtractId(IdentifierType.VERTEX), "Different type to ExtractId");
  }
}
