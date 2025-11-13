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

package uk.gov.gchq.gaffer.hdfs.operation.mapper.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.MapContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TextMapperGeneratorDiffblueTest {
  /**
   * Test {@link TextMapperGenerator#TextMapperGenerator()}.
   *
   * <p>Method under test: {@link TextMapperGenerator#TextMapperGenerator()}
   */
  @Test
  @DisplayName("Test new TextMapperGenerator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextMapperGenerator.<init>()"})
  void testNewTextMapperGenerator() {
    // Arrange, Act and Assert
    assertNull(new TextMapperGenerator().getElementGenerator());
  }

  /**
   * Test {@link TextMapperGenerator#getElements(LongWritable, Text, MapContext)} with {@code
   * LongWritable}, {@code Text}, {@code MapContext}.
   *
   * <p>Method under test: {@link TextMapperGenerator#getElements(LongWritable, Text, MapContext)}
   */
  @Test
  @DisplayName(
      "Test getElements(LongWritable, Text, MapContext) with 'LongWritable', 'Text', 'MapContext'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Iterable TextMapperGenerator.getElements(LongWritable, Text, MapContext)"
  })
  void testGetElementsWithLongWritableTextMapContext() {
    // Arrange
    JsonMapperGenerator jsonMapperGenerator = new JsonMapperGenerator();
    LongWritable keyIn = new LongWritable();

    // Act and Assert
    assertEquals(
        -1L,
        jsonMapperGenerator
            .getElements(keyIn, new Text(), mock(MapContext.class))
            .spliterator()
            .getExactSizeIfKnown());
  }
}
