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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.hadoop.io.NullWritable;
import org.apache.spark.MapOutputTracker;
import org.apache.spark.SecurityManager;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.SparkEnv;
import org.apache.spark.broadcast.BroadcastManager;
import org.apache.spark.memory.MemoryManager;
import org.apache.spark.metrics.MetricsSystem;
import org.apache.spark.rpc.RpcEnv;
import org.apache.spark.scheduler.OutputCommitCoordinator;
import org.apache.spark.serializer.Serializer;
import org.apache.spark.serializer.SerializerManager;
import org.apache.spark.shuffle.ShuffleManager;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.storage.BlockManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scala.Tuple2;
import uk.gov.gchq.gaffer.accumulostore.AccumuloProperties;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd.GetJavaRDDOfElementsInRangesHandler.FirstElement;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.javardd.GetJavaRDDOfElementsInRanges;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class GetJavaRDDOfElementsInRangesHandlerDiffblueTest {
  /**
   * Test {@link GetJavaRDDOfElementsInRangesHandler#doOperation(GetJavaRDDOfElementsInRanges,
   * Context, Store)} with {@code operation}, {@code context}, {@code store}.
   *
   * <ul>
   *   <li>Given {@code Option}.
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetJavaRDDOfElementsInRangesHandler#doOperation(GetJavaRDDOfElementsInRanges, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetJavaRDDOfElementsInRanges, Context, Store) with 'operation', 'context', 'store'; given 'Option'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.spark.api.java.JavaRDD GetJavaRDDOfElementsInRangesHandler.doOperation(GetJavaRDDOfElementsInRanges, Context, Store)"
  })
  void testDoOperationWithOperationContextStore_givenOption_thenThrowOperationException()
      throws OperationException {
    // Arrange
    GetJavaRDDOfElementsInRangesHandler getJavaRDDOfElementsInRangesHandler =
        new GetJavaRDDOfElementsInRangesHandler();

    GetJavaRDDOfElementsInRanges operation = mock(GetJavaRDDOfElementsInRanges.class);
    when(operation.getOption(Mockito.<String>any())).thenReturn("Option");
    doNothing().when(operation).addOption(Mockito.<String>any(), Mockito.<String>any());
    operation.addOption("Name", "42");

    SparkContext sparkContext = mock(SparkContext.class);
    SparkEnv sparkEnv =
        new SparkEnv(
            "42",
            mock(RpcEnv.class),
            mock(Serializer.class),
            mock(Serializer.class),
            mock(SerializerManager.class),
            mock(MapOutputTracker.class),
            mock(ShuffleManager.class),
            mock(BroadcastManager.class),
            mock(BlockManager.class),
            mock(SecurityManager.class),
            mock(MetricsSystem.class),
            mock(MemoryManager.class),
            mock(OutputCommitCoordinator.class),
            mock(SparkConf.class));
    when(sparkContext.env()).thenReturn(sparkEnv);

    SparkSession sparkSession = mock(SparkSession.class);
    when(sparkSession.sparkContext()).thenReturn(sparkContext);

    Context context = mock(Context.class);
    when(context.getConfig(Mockito.<String>any())).thenReturn(sparkSession);

    AccumuloProperties accumuloProperties = mock(AccumuloProperties.class);
    doNothing().when(accumuloProperties).addOperationDeclarationPaths((String[]) Mockito.any());
    accumuloProperties.addOperationDeclarationPaths("New Paths");

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getProperties()).thenReturn(accumuloProperties);

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> getJavaRDDOfElementsInRangesHandler.doOperation(operation, context, store));
    verify(sparkContext).env();
    verify(sparkSession).sparkContext();
    verify(store).getProperties();
    verify(operation).addOption("Name", "42");
    verify(operation).getOption("Hadoop_Configuration_Key");
    verify(context).getConfig("config.spark.context");
    verify(accumuloProperties).addOperationDeclarationPaths((String[]) Mockito.any());
  }

  /**
   * Test FirstElement {@link FirstElement#call(Tuple2)} with {@code Tuple2}.
   *
   * <p>Method under test: {@link FirstElement#call(Tuple2)}
   */
  @Test
  @DisplayName("Test FirstElement call(Tuple2) with 'Tuple2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element FirstElement.call(Tuple2)"})
  void testFirstElementCallWithTuple2() throws Exception {
    // Arrange
    FirstElement firstElement = new FirstElement();
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    Tuple2<Element, NullWritable> tuple = new Tuple2<>(edge, NullWritable.get());

    // Act
    Element actualCallResult = firstElement.call(tuple);

    // Assert
    assertSame(tuple._1, actualCallResult);
  }
}
