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
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SchemaMigrationDiffblueTest {
  /**
   * Method under test: {@link SchemaMigration#setEntities(List)}
   */
  @Test
  void testSetEntities() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setEntities(new ArrayList<>());

    // Assert
    assertTrue(schemaMigration.getEntities().isEmpty());
  }

  /**
   * Method under test: {@link SchemaMigration#setEntities(List)}
   */
  @Test
  void testSetEntities2() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setEntities(null);

    // Assert
    assertTrue(schemaMigration.getEntities().isEmpty());
  }

  /**
   * Method under test: {@link SchemaMigration#setEntities(List)}
   */
  @Test
  void testSetEntities3() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    ArrayList<MigrateElement> entities = new ArrayList<>();
    entities.add(new MigrateElement());

    // Act
    schemaMigration.setEntities(entities);

    // Assert
    assertEquals(entities, schemaMigration.getEntities());
  }

  /**
   * Method under test: {@link SchemaMigration#setEntities(List)}
   */
  @Test
  void testSetEntities4() {
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
  void testGettersAndSetters() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setAggregateAfter(true);
    List<MigrateElement> actualEdges = schemaMigration.getEdges();
    List<MigrateElement> actualEntities = schemaMigration.getEntities();
    SchemaMigration.MigrationOutputType actualOutputType = schemaMigration.getOutputType();
    boolean actualIsAggregateAfterResult = schemaMigration.isAggregateAfter();

    // Assert that nothing has changed
    assertEquals(SchemaMigration.MigrationOutputType.OLD, actualOutputType);
    assertTrue(actualEdges.isEmpty());
    assertTrue(actualEntities.isEmpty());
    assertTrue(actualIsAggregateAfterResult);
  }

  /**
   * Method under test: {@link SchemaMigration#setEdges(List)}
   */
  @Test
  void testSetEdges() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setEdges(new ArrayList<>());

    // Assert
    assertTrue(schemaMigration.getEdges().isEmpty());
  }

  /**
   * Method under test: {@link SchemaMigration#setEdges(List)}
   */
  @Test
  void testSetEdges2() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setEdges(null);

    // Assert
    assertTrue(schemaMigration.getEdges().isEmpty());
  }

  /**
   * Method under test: {@link SchemaMigration#setEdges(List)}
   */
  @Test
  void testSetEdges3() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    ArrayList<MigrateElement> edges = new ArrayList<>();
    edges.add(new MigrateElement());

    // Act
    schemaMigration.setEdges(edges);

    // Assert
    assertEquals(edges, schemaMigration.getEdges());
  }

  /**
   * Method under test: {@link SchemaMigration#setEdges(List)}
   */
  @Test
  void testSetEdges4() {
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
   * Method under test:
   * {@link SchemaMigration#setOutputType(SchemaMigration.MigrationOutputType)}
   */
  @Test
  void testSetOutputType() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setOutputType(SchemaMigration.MigrationOutputType.NEW);

    // Assert
    assertEquals(SchemaMigration.MigrationOutputType.NEW, schemaMigration.getOutputType());
  }

  /**
   * Method under test:
   * {@link SchemaMigration#setOutputType(SchemaMigration.MigrationOutputType)}
   */
  @Test
  void testSetOutputType2() {
    // Arrange
    SchemaMigration schemaMigration = new SchemaMigration();

    // Act
    schemaMigration.setOutputType(null);

    // Assert
    assertNull(schemaMigration.getOutputType());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link SchemaMigration}
   */
  @Test
  void testNewSchemaMigration() {
    // Arrange and Act
    SchemaMigration actualSchemaMigration = new SchemaMigration();

    // Assert
    assertEquals(SchemaMigration.MigrationOutputType.OLD, actualSchemaMigration.getOutputType());
    assertFalse(actualSchemaMigration.isAggregateAfter());
    assertTrue(actualSchemaMigration.getEdges().isEmpty());
    assertTrue(actualSchemaMigration.getEntities().isEmpty());
  }
}
