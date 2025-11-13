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

package uk.gov.gchq.gaffer.graph.hook.migrate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.graph.hook.migrate.SchemaMigration.MigrationOutputType;

class SchemaMigrationDiffblueTest {
  /**
   * Test {@link SchemaMigration#setEntities(List)}.
   * <ul>
   *   <li>Given {@link MigrateElement#MigrateElement()}.</li>
   *   <li>Then {@link SchemaMigration} (default constructor) Entities is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaMigration#setEntities(List)}
   */
  @Test
  @DisplayName("Test setEntities(List); given MigrateElement(); then SchemaMigration (default constructor) Entities is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaMigration.setEntities(List)"})
  void testSetEntities_givenMigrateElement_thenSchemaMigrationEntitiesIsArrayList() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    ArrayList<MigrateElement> entities = new ArrayList<>();
    entities.add(new MigrateElement());
    entities.add(new MigrateElement());

    // Act
    schemaMigration.setEntities(entities);

    // Assert
    assertEquals(entities, schemaMigration.getEntities());
  }

  /**
   * Test {@link SchemaMigration#setEntities(List)}.
   * <ul>
   *   <li>Given {@link MigrateElement#MigrateElement()}.</li>
   *   <li>Then {@link SchemaMigration} (default constructor) Entities size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaMigration#setEntities(List)}
   */
  @Test
  @DisplayName("Test setEntities(List); given MigrateElement(); then SchemaMigration (default constructor) Entities size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaMigration.setEntities(List)"})
  void testSetEntities_givenMigrateElement_thenSchemaMigrationEntitiesSizeIsOne() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    ArrayList<MigrateElement> entities = new ArrayList<>();
    MigrateElement migrateElement = new MigrateElement();
    entities.add(migrateElement);

    // Act
    schemaMigration.setEntities(entities);

    // Assert
    List<MigrateElement> entities2 = schemaMigration.getEntities();
    assertEquals(1, entities2.size());
    assertSame(migrateElement, entities2.get(0));
  }

  /**
   * Test {@link SchemaMigration#setEntities(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link SchemaMigration} (default constructor) Entities Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaMigration#setEntities(List)}
   */
  @Test
  @DisplayName("Test setEntities(List); when ArrayList(); then SchemaMigration (default constructor) Entities Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaMigration.setEntities(List)"})
  void testSetEntities_whenArrayList_thenSchemaMigrationEntitiesEmpty() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setEntities(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(schemaMigration.getEntities().isEmpty());
  }

  /**
   * Test {@link SchemaMigration#setEntities(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SchemaMigration} (default constructor) Entities Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaMigration#setEntities(List)}
   */
  @Test
  @DisplayName("Test setEntities(List); when 'null'; then SchemaMigration (default constructor) Entities Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaMigration.setEntities(List)"})
  void testSetEntities_whenNull_thenSchemaMigrationEntitiesEmpty() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setEntities(null);

    // Assert that nothing has changed
    assertTrue(schemaMigration.getEntities().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SchemaMigration#setAggregateAfter(boolean)}
   *   <li>{@link SchemaMigration#getEdges()}
   *   <li>{@link SchemaMigration#getEntities()}
   *   <li>{@link SchemaMigration#getOutputType()}
   *   <li>{@link SchemaMigration#isAggregateAfter()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SchemaMigration.getEdges()", "List SchemaMigration.getEntities()",
      "MigrationOutputType SchemaMigration.getOutputType()", "boolean SchemaMigration.isAggregateAfter()",
      "void SchemaMigration.setAggregateAfter(boolean)"})
  void testGettersAndSetters() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setAggregateAfter(true);
    List<MigrateElement> actualEdges = schemaMigration.getEdges();
    List<MigrateElement> actualEntities = schemaMigration.getEntities();
    MigrationOutputType actualOutputType = schemaMigration.getOutputType();
    boolean actualIsAggregateAfterResult = schemaMigration.isAggregateAfter();

    // Assert
    assertEquals(MigrationOutputType.OLD, actualOutputType);
    assertTrue(actualEdges.isEmpty());
    assertTrue(actualEntities.isEmpty());
    assertTrue(actualIsAggregateAfterResult);
  }

  /**
   * Test {@link SchemaMigration#setEdges(List)}.
   * <ul>
   *   <li>Given {@link MigrateElement#MigrateElement()}.</li>
   *   <li>Then {@link SchemaMigration} (default constructor) Edges is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaMigration#setEdges(List)}
   */
  @Test
  @DisplayName("Test setEdges(List); given MigrateElement(); then SchemaMigration (default constructor) Edges is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaMigration.setEdges(List)"})
  void testSetEdges_givenMigrateElement_thenSchemaMigrationEdgesIsArrayList() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    ArrayList<MigrateElement> edges = new ArrayList<>();
    edges.add(new MigrateElement());
    edges.add(new MigrateElement());

    // Act
    schemaMigration.setEdges(edges);

    // Assert
    assertEquals(edges, schemaMigration.getEdges());
  }

  /**
   * Test {@link SchemaMigration#setEdges(List)}.
   * <ul>
   *   <li>Given {@link MigrateElement#MigrateElement()}.</li>
   *   <li>Then {@link SchemaMigration} (default constructor) Edges size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaMigration#setEdges(List)}
   */
  @Test
  @DisplayName("Test setEdges(List); given MigrateElement(); then SchemaMigration (default constructor) Edges size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaMigration.setEdges(List)"})
  void testSetEdges_givenMigrateElement_thenSchemaMigrationEdgesSizeIsOne() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    ArrayList<MigrateElement> edges = new ArrayList<>();
    MigrateElement migrateElement = new MigrateElement();
    edges.add(migrateElement);

    // Act
    schemaMigration.setEdges(edges);

    // Assert
    List<MigrateElement> edges2 = schemaMigration.getEdges();
    assertEquals(1, edges2.size());
    assertSame(migrateElement, edges2.get(0));
  }

  /**
   * Test {@link SchemaMigration#setEdges(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link SchemaMigration} (default constructor) Edges Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaMigration#setEdges(List)}
   */
  @Test
  @DisplayName("Test setEdges(List); when ArrayList(); then SchemaMigration (default constructor) Edges Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaMigration.setEdges(List)"})
  void testSetEdges_whenArrayList_thenSchemaMigrationEdgesEmpty() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setEdges(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(schemaMigration.getEdges().isEmpty());
  }

  /**
   * Test {@link SchemaMigration#setEdges(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SchemaMigration} (default constructor) Edges Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaMigration#setEdges(List)}
   */
  @Test
  @DisplayName("Test setEdges(List); when 'null'; then SchemaMigration (default constructor) Edges Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaMigration.setEdges(List)"})
  void testSetEdges_whenNull_thenSchemaMigrationEdgesEmpty() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setEdges(null);

    // Assert that nothing has changed
    assertTrue(schemaMigration.getEdges().isEmpty());
  }

  /**
   * Test {@link SchemaMigration#setOutputType(MigrationOutputType)}.
   * <ul>
   *   <li>When {@code NEW}.</li>
   *   <li>Then {@link SchemaMigration} (default constructor) OutputType is {@code NEW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaMigration#setOutputType(MigrationOutputType)}
   */
  @Test
  @DisplayName("Test setOutputType(MigrationOutputType); when 'NEW'; then SchemaMigration (default constructor) OutputType is 'NEW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaMigration.setOutputType(MigrationOutputType)"})
  void testSetOutputType_whenNew_thenSchemaMigrationOutputTypeIsNew() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setOutputType(MigrationOutputType.NEW);

    // Assert
    assertEquals(MigrationOutputType.NEW, schemaMigration.getOutputType());
  }

  /**
   * Test {@link SchemaMigration#setOutputType(MigrationOutputType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SchemaMigration} (default constructor) OutputType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchemaMigration#setOutputType(MigrationOutputType)}
   */
  @Test
  @DisplayName("Test setOutputType(MigrationOutputType); when 'null'; then SchemaMigration (default constructor) OutputType is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaMigration.setOutputType(MigrationOutputType)"})
  void testSetOutputType_whenNull_thenSchemaMigrationOutputTypeIsNull() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setOutputType(null);

    // Assert
    assertNull(schemaMigration.getOutputType());
  }

  /**
   * Test new {@link SchemaMigration} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link SchemaMigration}
   */
  @Test
  @DisplayName("Test new SchemaMigration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchemaMigration.<init>()"})
  void testNewSchemaMigration() {
    // Arrange and Act
    SchemaMigration actualSchemaMigration = new SchemaMigration();

    // Assert
    assertEquals(MigrationOutputType.OLD, actualSchemaMigration.getOutputType());
    assertFalse(actualSchemaMigration.isAggregateAfter());
    assertTrue(actualSchemaMigration.getEdges().isEmpty());
    assertTrue(actualSchemaMigration.getEntities().isEmpty());
  }
}
