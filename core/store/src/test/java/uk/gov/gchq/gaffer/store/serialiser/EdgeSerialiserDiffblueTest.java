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

package uk.gov.gchq.gaffer.store.serialiser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class EdgeSerialiserDiffblueTest {
  /**
   * Test {@link EdgeSerialiser#EdgeSerialiser()}.
   *
   * <p>Method under test: {@link EdgeSerialiser#EdgeSerialiser()}
   */
  @Test
  @DisplayName("Test new EdgeSerialiser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSerialiser.<init>()"})
  void testNewEdgeSerialiser() {
    // Arrange and Act
    EdgeSerialiser actualEdgeSerialiser = new EdgeSerialiser();

    // Assert
    assertNull(actualEdgeSerialiser.vertexSerialiser);
    assertNull(actualEdgeSerialiser.schema);
    assertFalse(actualEdgeSerialiser.isConsistent());
  }

  /**
   * Test {@link EdgeSerialiser#EdgeSerialiser(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSerialiser#EdgeSerialiser(Schema)}
   */
  @Test
  @DisplayName(
      "Test new EdgeSerialiser(Schema); when Schema(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSerialiser.<init>(Schema)"})
  void testNewEdgeSerialiser_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new EdgeSerialiser(new Schema()));
  }

  /**
   * Test {@link EdgeSerialiser#updateSchema(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSerialiser#updateSchema(Schema)}
   */
  @Test
  @DisplayName("Test updateSchema(Schema); when Schema(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSerialiser.updateSchema(Schema)"})
  void testUpdateSchema_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> edgeSerialiser.updateSchema(new Schema()));
  }

  /**
   * Test {@link EdgeSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(edgeSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link EdgeSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Edge}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName(
      "Test canHandle(Class); when 'uk.gov.gchq.gaffer.data.element.Edge'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSerialiser.canHandle(Class)"})
  void testCanHandle_whenUkGovGchqGafferDataElementEdge_thenReturnTrue() {
    // Arrange
    EdgeSerialiser edgeSerialiser = new EdgeSerialiser();
    Class<Edge> clazz = Edge.class;

    // Act and Assert
    assertTrue(edgeSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link EdgeSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link EdgeSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new EdgeSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link EdgeSerialiser#isConsistent()}.
   *
   * <p>Method under test: {@link EdgeSerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSerialiser.isConsistent()"})
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertFalse(new EdgeSerialiser().isConsistent());
  }
}
