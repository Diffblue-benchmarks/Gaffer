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

package uk.gov.gchq.gaffer.tinkerpop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GafferPopElementDiffblueTest {
  /**
   * Test {@link GafferPopElement#id()}.
   *
   * <ul>
   *   <li>Given {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and {@code Id} and graph is {@code null}.
   *   <li>Then return {@code Id}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopElement#id()}
   */
  @Test
  @DisplayName(
      "Test id(); given GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and 'Id' and graph is 'null'; then return 'Id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object GafferPopElement.id()"})
  void testId_givenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnId() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    // Act
    Object actualIdResult = gafferPopVertex.id();

    // Assert
    assertEquals("Id", actualIdResult);
    assertSame(gafferPopVertex.id, actualIdResult);
  }

  /**
   * Test {@link GafferPopElement#label()}.
   *
   * <ul>
   *   <li>Given {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and {@code Id} and graph is {@code null}.
   *   <li>Then return {@code Label}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopElement#label()}
   */
  @Test
  @DisplayName(
      "Test label(); given GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and 'Id' and graph is 'null'; then return 'Label'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String GafferPopElement.label()"})
  void testLabel_givenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnLabel() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    // Act and Assert
    assertEquals("Label", gafferPopVertex.label());
  }

  /**
   * Test {@link GafferPopElement#setReadOnly()}.
   *
   * <ul>
   *   <li>Then {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and {@code Id} and graph is {@code null} ReadOnly.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopElement#setReadOnly()}
   */
  @Test
  @DisplayName(
      "Test setReadOnly(); then GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and 'Id' and graph is 'null' ReadOnly")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopElement.setReadOnly()"})
  void testSetReadOnly_thenGafferPopVertexWithLabelAndIdAndGraphIsNullReadOnly() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    // Act
    gafferPopVertex.setReadOnly();

    // Assert
    assertTrue(gafferPopVertex.isReadOnly());
  }

  /**
   * Test {@link GafferPopElement#isReadOnly()}.
   *
   * <ul>
   *   <li>Given {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and {@code Id} and graph is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopElement#isReadOnly()}
   */
  @Test
  @DisplayName(
      "Test isReadOnly(); given GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and 'Id' and graph is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopElement.isReadOnly()"})
  void testIsReadOnly_givenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnFalse() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    // Act and Assert
    assertFalse(gafferPopVertex.isReadOnly());
  }

  /**
   * Test {@link GafferPopElement#graph()}.
   *
   * <ul>
   *   <li>Given {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and {@code Id} and graph is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopElement#graph()}
   */
  @Test
  @DisplayName(
      "Test graph(); given GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and 'Id' and graph is 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"uk.gov.gchq.gaffer.tinkerpop.GafferPopGraph GafferPopElement.graph()"})
  void testGraph_givenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnNull() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    // Act and Assert
    assertNull(gafferPopVertex.graph());
  }
}
