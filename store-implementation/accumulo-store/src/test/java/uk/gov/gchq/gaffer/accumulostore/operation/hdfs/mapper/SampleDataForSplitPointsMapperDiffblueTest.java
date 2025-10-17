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
