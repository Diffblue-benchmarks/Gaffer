package uk.gov.gchq.gaffer.tinkerpop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Graph.Features;
import org.apache.tinkerpop.gremlin.structure.Graph.Features.VertexFeatures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraphFeatures.GafferPopGraphEdgeFeatures;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraphFeatures.GafferPopGraphGraphFeatures;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraphFeatures.GafferPopGraphVertexFeatures;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopGraphFeatures.GafferPopGraphVertexPropertyFeatures;

class GafferPopGraphFeaturesDiffblueTest {
  /**
   * Test {@link GafferPopGraphFeatures#graph()}.
   *
   * <p>Method under test: {@link GafferPopGraphFeatures#graph()}
   */
  @Test
  @DisplayName("Test graph()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Graph.Features.GraphFeatures GafferPopGraphFeatures.graph()"})
  void testGraph() {
    // Arrange, Act and Assert
    assertTrue(new GafferPopGraphFeatures().graph() instanceof GafferPopGraphGraphFeatures);
  }

  /**
   * Test {@link GafferPopGraphFeatures#edge()}.
   *
   * <p>Method under test: {@link GafferPopGraphFeatures#edge()}
   */
  @Test
  @DisplayName("Test edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Graph.Features.EdgeFeatures GafferPopGraphFeatures.edge()"})
  void testEdge() {
    // Arrange, Act and Assert
    assertTrue(new GafferPopGraphFeatures().edge() instanceof GafferPopGraphEdgeFeatures);
  }

  /**
   * Test {@link GafferPopGraphFeatures#vertex()}.
   *
   * <p>Method under test: {@link GafferPopGraphFeatures#vertex()}
   */
  @Test
  @DisplayName("Test vertex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"VertexFeatures GafferPopGraphFeatures.vertex()"})
  void testVertex() {
    // Arrange and Act
    VertexFeatures actualVertexResult = new GafferPopGraphFeatures().vertex();

    // Assert
    assertTrue(actualVertexResult instanceof GafferPopGraphVertexFeatures);
    assertTrue(actualVertexResult.properties() instanceof GafferPopGraphVertexPropertyFeatures);
  }

  /**
   * Test new {@link GafferPopGraphFeatures} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link GafferPopGraphFeatures}
   */
  @Test
  @DisplayName("Test new GafferPopGraphFeatures (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGraphFeatures.<init>()"})
  void testNewGafferPopGraphFeatures() {
    // Arrange and Act
    GafferPopGraphFeatures actualGafferPopGraphFeatures = new GafferPopGraphFeatures();

    // Assert
    assertTrue(actualGafferPopGraphFeatures.edge() instanceof GafferPopGraphEdgeFeatures);
    assertTrue(actualGafferPopGraphFeatures.graph() instanceof GafferPopGraphGraphFeatures);
    VertexFeatures vertexResult = actualGafferPopGraphFeatures.vertex();
    assertTrue(vertexResult instanceof GafferPopGraphVertexFeatures);
    assertTrue(vertexResult.properties() instanceof GafferPopGraphVertexPropertyFeatures);
  }

  /**
   * Test {@link GafferPopGraphFeatures#toString()}.
   *
   * <p>Method under test: {@link GafferPopGraphFeatures#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String GafferPopGraphFeatures.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "FEATURES\n"
            + "> GraphFeatures\n"
            + ">-- Computer: false\n"
            + ">-- ConcurrentAccess: true\n"
            + ">-- IoRead: true\n"
            + ">-- IoWrite: true\n"
            + ">-- OrderabilitySemantics: true\n"
            + ">-- Persistence: true\n"
            + ">-- ServiceCall: false\n"
            + ">-- ThreadedTransactions: false\n"
            + ">-- Transactions: false\n"
            + "> VariableFeatures\n"
            + ">-- BooleanArrayValues: true\n"
            + ">-- BooleanValues: true\n"
            + ">-- ByteArrayValues: true\n"
            + ">-- ByteValues: true\n"
            + ">-- DoubleArrayValues: true\n"
            + ">-- DoubleValues: true\n"
            + ">-- FloatArrayValues: true\n"
            + ">-- FloatValues: true\n"
            + ">-- IntegerArrayValues: true\n"
            + ">-- IntegerValues: true\n"
            + ">-- LongArrayValues: true\n"
            + ">-- LongValues: true\n"
            + ">-- MapValues: true\n"
            + ">-- MixedListValues: true\n"
            + ">-- SerializableValues: true\n"
            + ">-- StringArrayValues: true\n"
            + ">-- StringValues: true\n"
            + ">-- UniformListValues: true\n"
            + ">-- Variables: true\n"
            + "> VertexFeatures\n"
            + ">-- AddProperty: true\n"
            + ">-- AnyIds: true\n"
            + ">-- CustomIds: true\n"
            + ">-- NullPropertyValues: true\n"
            + ">-- NumericIds: true\n"
            + ">-- RemoveProperty: false\n"
            + ">-- StringIds: true\n"
            + ">-- UserSuppliedIds: true\n"
            + ">-- UuidIds: true\n"
            + ">-- AddVertices: true\n"
            + ">-- DuplicateMultiProperties: true\n"
            + ">-- MetaProperties: true\n"
            + ">-- MultiProperties: true\n"
            + ">-- RemoveVertices: false\n"
            + ">-- Upsert: false\n"
            + "> VertexPropertyFeatures\n"
            + ">-- BooleanArrayValues: true\n"
            + ">-- BooleanValues: true\n"
            + ">-- ByteArrayValues: true\n"
            + ">-- ByteValues: true\n"
            + ">-- DoubleArrayValues: true\n"
            + ">-- DoubleValues: true\n"
            + ">-- FloatArrayValues: true\n"
            + ">-- FloatValues: true\n"
            + ">-- IntegerArrayValues: true\n"
            + ">-- IntegerValues: true\n"
            + ">-- LongArrayValues: true\n"
            + ">-- LongValues: true\n"
            + ">-- MapValues: true\n"
            + ">-- MixedListValues: true\n"
            + ">-- SerializableValues: true\n"
            + ">-- StringArrayValues: true\n"
            + ">-- StringValues: true\n"
            + ">-- UniformListValues: true\n"
            + ">-- Properties: true\n"
            + ">-- AnyIds: true\n"
            + ">-- CustomIds: true\n"
            + ">-- NullPropertyValues: true\n"
            + ">-- NumericIds: true\n"
            + ">-- RemoveProperty: false\n"
            + ">-- StringIds: true\n"
            + ">-- UserSuppliedIds: true\n"
            + ">-- UuidIds: true\n"
            + "> EdgeFeatures\n"
            + ">-- AddEdges: true\n"
            + ">-- RemoveEdges: false\n"
            + ">-- Upsert: false\n"
            + ">-- AddProperty: true\n"
            + ">-- AnyIds: true\n"
            + ">-- CustomIds: true\n"
            + ">-- NullPropertyValues: true\n"
            + ">-- NumericIds: true\n"
            + ">-- RemoveProperty: false\n"
            + ">-- StringIds: true\n"
            + ">-- UserSuppliedIds: true\n"
            + ">-- UuidIds: true\n"
            + "> EdgePropertyFeatures\n"
            + ">-- BooleanArrayValues: true\n"
            + ">-- BooleanValues: true\n"
            + ">-- ByteArrayValues: true\n"
            + ">-- ByteValues: true\n"
            + ">-- DoubleArrayValues: true\n"
            + ">-- DoubleValues: true\n"
            + ">-- FloatArrayValues: true\n"
            + ">-- FloatValues: true\n"
            + ">-- IntegerArrayValues: true\n"
            + ">-- IntegerValues: true\n"
            + ">-- LongArrayValues: true\n"
            + ">-- LongValues: true\n"
            + ">-- MapValues: true\n"
            + ">-- MixedListValues: true\n"
            + ">-- SerializableValues: true\n"
            + ">-- StringArrayValues: true\n"
            + ">-- StringValues: true\n"
            + ">-- UniformListValues: true\n"
            + ">-- Properties: true\n",
        new GafferPopGraphFeatures().toString());
  }
}
