package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.reducer;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.DataInputStream;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.ReduceContext;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.reduce.WrappedReducer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AccumuloKeyValueReducerDiffblueTest {
  /**
   * Test {@link AccumuloKeyValueReducer#setup(Context)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloKeyValueReducer#setup(Context)}
   */
  @Test
  @DisplayName("Test setup(Context); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloKeyValueReducer.setup(Context)"})
  void testSetup_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    AccumuloKeyValueReducer accumuloKeyValueReducer = new AccumuloKeyValueReducer();

    DataInputStream in = mock(DataInputStream.class);
    when(in.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new IllegalArgumentException());

    Configuration configuration = new Configuration();
    configuration.addResource(in);

    ReduceContext reduceContext = mock(ReduceContext.class);
    when(reduceContext.getConfiguration()).thenReturn(configuration);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> accumuloKeyValueReducer.setup(new WrappedReducer().new Context(reduceContext)));
    verify(in).read(isA(byte[].class), eq(0), eq(4000));
    verify(reduceContext).getConfiguration();
  }
}
