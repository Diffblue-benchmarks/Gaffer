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

package uk.gov.gchq.gaffer.accumulostore.inputformat;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.apache.accumulo.core.client.mapred.RangeInputSplit;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.function.ElementFilter;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;

class ElementInputFormatDiffblueTest {
  /**
   * Test {@link ElementInputFormat#createRecordReader(InputSplit, TaskAttemptContext)}.
   *
   * <ul>
   *   <li>Given {@link SchemaException#SchemaException(String)} with message is {@code An error
   *       occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ElementInputFormat#createRecordReader(InputSplit,
   * TaskAttemptContext)}
   */
  @Test
  @DisplayName(
      "Test createRecordReader(InputSplit, TaskAttemptContext); given SchemaException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.hadoop.mapreduce.RecordReader ElementInputFormat.createRecordReader(InputSplit, TaskAttemptContext)"
  })
  void testCreateRecordReader_givenSchemaExceptionWithMessageIsAnErrorOccurred()
      throws IOException {
    // Arrange
    ElementInputFormat elementInputFormat = new ElementInputFormat();
    RangeInputSplit split = new RangeInputSplit();

    TaskAttemptContext context = mock(TaskAttemptContext.class);
    when(context.getConfiguration()).thenThrow(new SchemaException("An error occurred"));

    // Act and Assert
    assertThrows(
        SchemaException.class, () -> elementInputFormat.createRecordReader(split, context));
    verify(context).getConfiguration();
  }

  /**
   * Test {@link ElementInputFormat#createRecordReader(InputSplit, TaskAttemptContext)}.
   *
   * <ul>
   *   <li>Then calls {@link DataInputStream#read(byte[], int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementInputFormat#createRecordReader(InputSplit,
   * TaskAttemptContext)}
   */
  @Test
  @DisplayName(
      "Test createRecordReader(InputSplit, TaskAttemptContext); then calls read(byte[], int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.hadoop.mapreduce.RecordReader ElementInputFormat.createRecordReader(InputSplit, TaskAttemptContext)"
  })
  void testCreateRecordReader_thenCallsRead() throws IOException {
    // Arrange
    ElementInputFormat elementInputFormat = new ElementInputFormat();
    RangeInputSplit split = new RangeInputSplit();

    DataInputStream in = mock(DataInputStream.class);
    when(in.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new SchemaException("An error occurred"));

    Configuration configuration = new Configuration();
    configuration.addResource(in);

    TaskAttemptContext context = mock(TaskAttemptContext.class);
    when(context.getConfiguration()).thenReturn(configuration);

    // Act and Assert
    assertThrows(
        SchemaException.class, () -> elementInputFormat.createRecordReader(split, context));
    verify(in).read(isA(byte[].class), eq(0), eq(4000));
    verify(context).getConfiguration();
  }

  /**
   * Test {@link ElementInputFormat#doPostFilter(Element, View)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementInputFormat#doPostFilter(Element, View)}
   */
  @Test
  @DisplayName(
      "Test doPostFilter(Element, View); when Edge(String) with 'Group'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementInputFormat.doPostFilter(Element, View)"})
  void testDoPostFilter_whenEdgeWithGroup_thenReturnTrue() {
    // Arrange
    Edge element = new Edge("Group");

    // Act and Assert
    assertTrue(ElementInputFormat.doPostFilter(element, new View()));
  }

  /**
   * Test {@link ElementInputFormat#postFilter(Element, ElementFilter)}.
   *
   * <ul>
   *   <li>When {@link ElementFilter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ElementInputFormat#postFilter(Element, ElementFilter)}
   */
  @Test
  @DisplayName("Test postFilter(Element, ElementFilter); when ElementFilter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementInputFormat.postFilter(Element, ElementFilter)"})
  void testPostFilter_whenElementFilter() {
    // Arrange
    Edge element = new Edge("Group");

    // Act and Assert
    assertTrue(ElementInputFormat.postFilter(element, new ElementFilter()));
  }

  /**
   * Test {@link ElementInputFormat#postFilter(Element, ElementFilter)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementInputFormat#postFilter(Element, ElementFilter)}
   */
  @Test
  @DisplayName("Test postFilter(Element, ElementFilter); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementInputFormat.postFilter(Element, ElementFilter)"})
  void testPostFilter_whenNull() {
    // Arrange, Act and Assert
    assertTrue(ElementInputFormat.postFilter(new Edge("Group"), null));
  }
}
