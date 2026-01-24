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

package uk.gov.gchq.gaffer.federated.simple.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Predicate;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.predicate.AccessPredicate;
import uk.gov.gchq.gaffer.federated.simple.operation.AddGraph.Builder;
import uk.gov.gchq.gaffer.graph.GraphConfig;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AddGraphDiffblueTest {
  /**
   * Test Builder {@link Builder#graphConfig(GraphConfig)}.
   *
   * <p>Method under test: {@link Builder#graphConfig(GraphConfig)}
   */
  @Test
  @DisplayName("Test Builder graphConfig(GraphConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphConfig(GraphConfig)"})
  void testBuilderGraphConfig() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphConfigResult = builder.graphConfig(new GraphConfig());

    // Assert
    assertSame(builder, actualGraphConfigResult);
  }

  /**
   * Test Builder {@link Builder#isPublic(Boolean)}.
   *
   * <p>Method under test: {@link Builder#isPublic(Boolean)}
   */
  @Test
  @DisplayName("Test Builder isPublic(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isPublic(Boolean)"})
  void testBuilderIsPublic() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIsPublicResult = builder.isPublic(true);

    // Assert
    assertSame(builder, actualIsPublicResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    AddGraph _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.isPublic());
    assertNull(_getOpResult.getOwner());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getProperties());
    assertNull(_getOpResult.getReadPredicate());
    assertNull(_getOpResult.getWritePredicate());
    assertNull(_getOpResult.getGraphConfig());
    assertNull(_getOpResult.getSchema());
    AddGraph actualAddGraph = actualBuilder.build();
    assertSame(_getOpResult, actualAddGraph);
  }

  /**
   * Test Builder {@link Builder#owner(String)}.
   *
   * <p>Method under test: {@link Builder#owner(String)}
   */
  @Test
  @DisplayName("Test Builder owner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.owner(String)"})
  void testBuilderOwner() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOwnerResult = builder.owner("Owner");

    // Assert
    assertSame(builder, actualOwnerResult);
  }

  /**
   * Test Builder {@link Builder#properties(Properties)}.
   *
   * <p>Method under test: {@link Builder#properties(Properties)}
   */
  @Test
  @DisplayName("Test Builder properties(Properties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.properties(Properties)"})
  void testBuilderProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertiesResult = builder.properties(new Properties());

    // Assert
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test Builder {@link Builder#readPredicate(AccessPredicate)}.
   *
   * <p>Method under test: {@link Builder#readPredicate(AccessPredicate)}
   */
  @Test
  @DisplayName("Test Builder readPredicate(AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.readPredicate(AccessPredicate)"})
  void testBuilderReadPredicate() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualReadPredicateResult =
        builder.readPredicate(new AccessPredicate(mock(Predicate.class)));

    // Assert
    assertSame(builder, actualReadPredicateResult);
  }

  /**
   * Test Builder {@link Builder#schema(Schema)}.
   *
   * <p>Method under test: {@link Builder#schema(Schema)}
   */
  @Test
  @DisplayName("Test Builder schema(Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.schema(Schema)"})
  void testBuilderSchema() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSchemaResult = builder.schema(new Schema());

    // Assert
    assertSame(builder, actualSchemaResult);
  }

  /**
   * Test Builder {@link Builder#writePredicate(AccessPredicate)}.
   *
   * <p>Method under test: {@link Builder#writePredicate(AccessPredicate)}
   */
  @Test
  @DisplayName("Test Builder writePredicate(AccessPredicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.writePredicate(AccessPredicate)"})
  void testBuilderWritePredicate() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualWritePredicateResult =
        builder.writePredicate(new AccessPredicate(mock(Predicate.class)));

    // Assert
    assertSame(builder, actualWritePredicateResult);
  }

  /**
   * Test {@link AddGraph#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddGraph#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddGraph (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation AddGraph.shallowClone()"})
  void testShallowClone_givenAddGraphOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    AddGraph addGraph = new AddGraph();
    addGraph.setOptions(new HashMap<>());

    // Act
    Operation actualShallowCloneResult = addGraph.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof AddGraph);
    assertNull(((AddGraph) actualShallowCloneResult).isPublic());
    assertNull(((AddGraph) actualShallowCloneResult).getOwner());
    assertNull(((AddGraph) actualShallowCloneResult).getProperties());
    assertNull(((AddGraph) actualShallowCloneResult).getReadPredicate());
    assertNull(((AddGraph) actualShallowCloneResult).getWritePredicate());
    assertNull(((AddGraph) actualShallowCloneResult).getGraphConfig());
    assertNull(((AddGraph) actualShallowCloneResult).getSchema());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link AddGraph#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddGraph#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddGraph (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation AddGraph.shallowClone()"})
  void testShallowClone_givenAddGraph_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    Operation actualShallowCloneResult = new AddGraph().shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof AddGraph);
    assertNull(((AddGraph) actualShallowCloneResult).isPublic());
    assertNull(((AddGraph) actualShallowCloneResult).getOwner());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(((AddGraph) actualShallowCloneResult).getProperties());
    assertNull(((AddGraph) actualShallowCloneResult).getReadPredicate());
    assertNull(((AddGraph) actualShallowCloneResult).getWritePredicate());
    assertNull(((AddGraph) actualShallowCloneResult).getGraphConfig());
    assertNull(((AddGraph) actualShallowCloneResult).getSchema());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AddGraph}
   *   <li>{@link AddGraph#setGraphConfig(GraphConfig)}
   *   <li>{@link AddGraph#setIsPublic(Boolean)}
   *   <li>{@link AddGraph#setOptions(Map)}
   *   <li>{@link AddGraph#setOwner(String)}
   *   <li>{@link AddGraph#setProperties(Properties)}
   *   <li>{@link AddGraph#setReadPredicate(AccessPredicate)}
   *   <li>{@link AddGraph#setSchema(Schema)}
   *   <li>{@link AddGraph#setWritePredicate(AccessPredicate)}
   *   <li>{@link AddGraph#getGraphConfig()}
   *   <li>{@link AddGraph#getOptions()}
   *   <li>{@link AddGraph#getOwner()}
   *   <li>{@link AddGraph#getProperties()}
   *   <li>{@link AddGraph#getReadPredicate()}
   *   <li>{@link AddGraph#getSchema()}
   *   <li>{@link AddGraph#getWritePredicate()}
   *   <li>{@link AddGraph#isPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddGraph.<init>()",
    "GraphConfig AddGraph.getGraphConfig()",
    "Map AddGraph.getOptions()",
    "String AddGraph.getOwner()",
    "Properties AddGraph.getProperties()",
    "AccessPredicate AddGraph.getReadPredicate()",
    "Schema AddGraph.getSchema()",
    "AccessPredicate AddGraph.getWritePredicate()",
    "Boolean AddGraph.isPublic()",
    "void AddGraph.setGraphConfig(GraphConfig)",
    "void AddGraph.setIsPublic(Boolean)",
    "void AddGraph.setOptions(Map)",
    "void AddGraph.setOwner(String)",
    "void AddGraph.setProperties(Properties)",
    "void AddGraph.setReadPredicate(AccessPredicate)",
    "void AddGraph.setSchema(Schema)",
    "void AddGraph.setWritePredicate(AccessPredicate)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AddGraph actualAddGraph = new AddGraph();
    GraphConfig graphConfig =
        new GraphConfig.Builder()
            .description("The characteristics of someone or something")
            .build();
    actualAddGraph.setGraphConfig(graphConfig);
    actualAddGraph.setIsPublic(true);
    HashMap<String, String> options = new HashMap<>();
    actualAddGraph.setOptions(options);
    actualAddGraph.setOwner("Owner");
    Properties properties = new Properties();
    actualAddGraph.setProperties(properties);
    AccessPredicate readPredicate = new AccessPredicate(mock(Predicate.class));
    actualAddGraph.setReadPredicate(readPredicate);
    Schema schema = new Schema();
    actualAddGraph.setSchema(schema);
    AccessPredicate writePredicate = new AccessPredicate(mock(Predicate.class));
    actualAddGraph.setWritePredicate(writePredicate);
    GraphConfig actualGraphConfig = actualAddGraph.getGraphConfig();
    Map<String, String> actualOptions = actualAddGraph.getOptions();
    String actualOwner = actualAddGraph.getOwner();
    Properties actualProperties = actualAddGraph.getProperties();
    AccessPredicate actualReadPredicate = actualAddGraph.getReadPredicate();
    Schema actualSchema = actualAddGraph.getSchema();
    AccessPredicate actualWritePredicate = actualAddGraph.getWritePredicate();
    Boolean actualIsPublicResult = actualAddGraph.isPublic();

    // Assert
    assertEquals("Owner", actualOwner);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsPublicResult);
    assertSame(options, actualOptions);
    assertSame(properties, actualProperties);
    assertSame(readPredicate, actualReadPredicate);
    assertSame(writePredicate, actualWritePredicate);
    assertSame(schema, actualSchema);
    assertSame(graphConfig, actualGraphConfig);
  }
}
