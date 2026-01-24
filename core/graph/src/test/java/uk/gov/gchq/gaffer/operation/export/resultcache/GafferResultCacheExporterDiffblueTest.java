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

package uk.gov.gchq.gaffer.operation.export.resultcache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.graph.Graph;
import uk.gov.gchq.gaffer.store.Context;

class GafferResultCacheExporterDiffblueTest {
  /**
   * Test {@link GafferResultCacheExporter#GafferResultCacheExporter(Context, String, Graph, String,
   * Set)}.
   *
   * <ul>
   *   <li>When {@link Context#Context()}.
   *   <li>Then return RequiredOpAuths size is one.
   * </ul>
   *
   * <p>Method under test: {@link GafferResultCacheExporter#GafferResultCacheExporter(Context,
   * String, Graph, String, Set)}
   */
  @Test
  @DisplayName(
      "Test new GafferResultCacheExporter(Context, String, Graph, String, Set); when Context(); then return RequiredOpAuths size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferResultCacheExporter.<init>(Context, String, Graph, String, Set)"})
  void testNewGafferResultCacheExporter_whenContext_thenReturnRequiredOpAuthsSizeIsOne() {
    // Arrange and Act
    GafferResultCacheExporter actualGafferResultCacheExporter =
        new GafferResultCacheExporter(new Context(), "42", null, "Visibility", null);

    // Assert
    TreeSet<String> requiredOpAuths = actualGafferResultCacheExporter.getRequiredOpAuths();
    assertEquals(1, requiredOpAuths.size());
    assertTrue(requiredOpAuths.contains("UNKNOWN"));
    assertEquals(requiredOpAuths, actualGafferResultCacheExporter.getUserOpAuths());
  }

  /**
   * Test {@link GafferResultCacheExporter#GafferResultCacheExporter(Context, String, Graph, String,
   * Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return JobId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GafferResultCacheExporter#GafferResultCacheExporter(Context,
   * String, Graph, String, Set)}
   */
  @Test
  @DisplayName(
      "Test new GafferResultCacheExporter(Context, String, Graph, String, Set); when HashSet(); then return JobId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferResultCacheExporter.<init>(Context, String, Graph, String, Set)"})
  void testNewGafferResultCacheExporter_whenHashSet_thenReturnJobIdIs42() {
    // Arrange
    Context context = new Context();
    HashSet<String> requiredOpAuths = new HashSet<>();

    // Act
    GafferResultCacheExporter actualGafferResultCacheExporter =
        new GafferResultCacheExporter(context, "42", null, "Visibility", requiredOpAuths);

    // Assert
    assertEquals("42", actualGafferResultCacheExporter.getJobId());
    assertEquals("Visibility", actualGafferResultCacheExporter.getVisibility());
    assertNull(actualGafferResultCacheExporter.getResultCache());
    Set<String> userOpAuths = actualGafferResultCacheExporter.getUserOpAuths();
    assertEquals(1, userOpAuths.size());
    assertTrue(userOpAuths.contains("UNKNOWN"));
    assertEquals(requiredOpAuths, actualGafferResultCacheExporter.getRequiredOpAuths());
    assertSame(context, actualGafferResultCacheExporter.getContext());
  }
}
