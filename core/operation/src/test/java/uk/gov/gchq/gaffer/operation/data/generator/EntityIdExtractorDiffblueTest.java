/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.operation.data.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.IdentifierType;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;

class EntityIdExtractorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityIdExtractor#EntityIdExtractor(IdentifierType)}
   *   <li>{@link EntityIdExtractor#setEdgeIdentifierToExtract(IdentifierType)}
   *   <li>{@link EntityIdExtractor#getEdgeIdentifierToExtract()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityIdExtractor.<init>(IdentifierType)",
    "IdentifierType EntityIdExtractor.getEdgeIdentifierToExtract()",
    "void EntityIdExtractor.setEdgeIdentifierToExtract(IdentifierType)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityIdExtractor actualEntityIdExtractor = new EntityIdExtractor(IdentifierType.VERTEX);
    actualEntityIdExtractor.setEdgeIdentifierToExtract(IdentifierType.VERTEX);

    // Assert
    assertEquals(IdentifierType.VERTEX, actualEntityIdExtractor.getEdgeIdentifierToExtract());
  }

  /**
   * Test {@link EntityIdExtractor#EntityIdExtractor()}.
   *
   * <p>Method under test: {@link EntityIdExtractor#EntityIdExtractor()}
   */
  @Test
  @DisplayName("Test new EntityIdExtractor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityIdExtractor.<init>()"})
  void testNewEntityIdExtractor() {
    // Arrange, Act and Assert
    assertEquals(IdentifierType.DESTINATION, new EntityIdExtractor().getEdgeIdentifierToExtract());
  }

  /**
   * Test {@link EntityIdExtractor#_apply(Element)}.
   *
   * <p>Method under test: {@link EntityIdExtractor#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdExtractor._apply(Element)"})
  void test_apply() {
    // Arrange
    EntityIdExtractor entityIdExtractor =
        new EntityIdExtractor(IdentifierType.ADJACENT_MATCHED_VERTEX);

    // Act
    EntityId actual_applyResult = entityIdExtractor._apply(new Edge("Group"));

    // Assert
    assertTrue(actual_applyResult instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actual_applyResult.getClassName());
    assertNull(actual_applyResult.getVertex());
  }

  /**
   * Test {@link EntityIdExtractor#_apply(Element)}.
   *
   * <ul>
   *   <li>Given {@link EntityIdExtractor#EntityIdExtractor(IdentifierType)} with
   *       edgeIdentifierToExtract is {@link IdentifierType#MATCHED_VERTEX}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdExtractor#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); given EntityIdExtractor(IdentifierType) with edgeIdentifierToExtract is MATCHED_VERTEX")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdExtractor._apply(Element)"})
  void test_apply_givenEntityIdExtractorWithEdgeIdentifierToExtractIsMatched_vertex() {
    // Arrange
    EntityIdExtractor entityIdExtractor = new EntityIdExtractor(IdentifierType.MATCHED_VERTEX);

    // Act
    EntityId actual_applyResult = entityIdExtractor._apply(new Edge("Group"));

    // Assert
    assertTrue(actual_applyResult instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actual_applyResult.getClassName());
    assertNull(actual_applyResult.getVertex());
  }

  /**
   * Test {@link EntityIdExtractor#_apply(Element)}.
   *
   * <ul>
   *   <li>Given {@link EntityIdExtractor#EntityIdExtractor(IdentifierType)} with
   *       edgeIdentifierToExtract is {@link IdentifierType#SOURCE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdExtractor#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); given EntityIdExtractor(IdentifierType) with edgeIdentifierToExtract is SOURCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdExtractor._apply(Element)"})
  void test_apply_givenEntityIdExtractorWithEdgeIdentifierToExtractIsSource() {
    // Arrange
    EntityIdExtractor entityIdExtractor = new EntityIdExtractor(IdentifierType.SOURCE);

    // Act
    EntityId actual_applyResult = entityIdExtractor._apply(new Edge("Group"));

    // Assert
    assertTrue(actual_applyResult instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actual_applyResult.getClassName());
    assertNull(actual_applyResult.getVertex());
  }

  /**
   * Test {@link EntityIdExtractor#_apply(Element)}.
   *
   * <ul>
   *   <li>Given {@link EntityIdExtractor#EntityIdExtractor()}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@link EntitySeed}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdExtractor#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); given EntityIdExtractor(); when Edge(String) with 'Group'; then return EntitySeed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdExtractor._apply(Element)"})
  void test_apply_givenEntityIdExtractor_whenEdgeWithGroup_thenReturnEntitySeed() {
    // Arrange
    EntityIdExtractor entityIdExtractor = new EntityIdExtractor();

    // Act
    EntityId actual_applyResult = entityIdExtractor._apply(new Edge("Group"));

    // Assert
    assertTrue(actual_applyResult instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actual_applyResult.getClassName());
    assertNull(actual_applyResult.getVertex());
  }

  /**
   * Test {@link EntityIdExtractor#_apply(Element)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdExtractor#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdExtractor._apply(Element)"})
  void test_apply_thenThrowIllegalArgumentException() {
    // Arrange
    EntityIdExtractor entityIdExtractor = new EntityIdExtractor(IdentifierType.VERTEX);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityIdExtractor._apply(new Edge("Group")));
  }

  /**
   * Test {@link EntityIdExtractor#_apply(Element)}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdExtractor#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element); when Entity(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityIdExtractor._apply(Element)"})
  void test_apply_whenEntityWithGroup() {
    // Arrange
    EntityIdExtractor entityIdExtractor = new EntityIdExtractor(IdentifierType.SOURCE);

    // Act
    EntityId actual_applyResult = entityIdExtractor._apply(new Entity("Group"));

    // Assert
    assertTrue(actual_applyResult instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actual_applyResult.getClassName());
    assertNull(actual_applyResult.getVertex());
  }
}
