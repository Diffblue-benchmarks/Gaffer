package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.mapper;

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
import org.apache.hadoop.mapreduce.MapContext;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.map.WrappedMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SampleDataForSplitPointsMapperDiffblueTest {
  /**
   * Test {@link SampleDataForSplitPointsMapper#setup(Context)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SampleDataForSplitPointsMapper#setup(Context)}
   */
  @Test
  @DisplayName("Test setup(Context); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SampleDataForSplitPointsMapper.setup(Context)"})
  void testSetup_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    SampleDataForSplitPointsMapper<Object, Object> sampleDataForSplitPointsMapper =
        new SampleDataForSplitPointsMapper<>();

    DataInputStream in = mock(DataInputStream.class);
    when(in.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new IllegalArgumentException());

    Configuration configuration = new Configuration();
    configuration.addResource(in);

    MapContext mapContext = mock(MapContext.class);
    when(mapContext.getConfiguration()).thenReturn(configuration);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> sampleDataForSplitPointsMapper.setup(new WrappedMapper().new Context(mapContext)));
    verify(in).read(isA(byte[].class), eq(0), eq(4000));
    verify(mapContext).getConfiguration();
  }
}
