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

package uk.gov.gchq.gaffer.operation.export.resultcache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.graph.Graph;
import uk.gov.gchq.gaffer.store.Context;

class GafferResultCacheExporterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GafferResultCacheExporter#getContext()}
   *   <li>{@link GafferResultCacheExporter#getJobId()}
   *   <li>{@link GafferResultCacheExporter#getRequiredOpAuths()}
   *   <li>{@link GafferResultCacheExporter#getResultCache()}
   *   <li>{@link GafferResultCacheExporter#getUserOpAuths()}
   *   <li>{@link GafferResultCacheExporter#getVisibility()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Context context = new Context();
    GafferResultCacheExporter gafferResultCacheExporter = new GafferResultCacheExporter(context, "42", null,
        "Visibility", new HashSet<>());

    // Act
    Context actualContext = gafferResultCacheExporter.getContext();
    String actualJobId = gafferResultCacheExporter.getJobId();
    TreeSet<String> actualRequiredOpAuths = gafferResultCacheExporter.getRequiredOpAuths();
    Graph actualResultCache = gafferResultCacheExporter.getResultCache();
    Set<String> actualUserOpAuths = gafferResultCacheExporter.getUserOpAuths();

    // Assert
    assertEquals("42", actualJobId);
    assertEquals("Visibility", gafferResultCacheExporter.getVisibility());
    assertNull(actualResultCache);
    assertEquals(1, actualUserOpAuths.size());
    assertTrue(actualUserOpAuths.contains("UNKNOWN"));
    assertTrue(actualRequiredOpAuths.isEmpty());
    assertSame(context, actualContext);
  }

  /**
   * Method under test:
   * {@link GafferResultCacheExporter#GafferResultCacheExporter(Context, String, Graph, String, Set)}
   */
  @Test
  void testNewGafferResultCacheExporter() {
    // Arrange
    Context context = new Context();

    // Act
    GafferResultCacheExporter actualGafferResultCacheExporter = new GafferResultCacheExporter(context, "42", null,
        "Visibility", new HashSet<>());

    // Assert
    assertEquals("42", actualGafferResultCacheExporter.getJobId());
    assertEquals("Visibility", actualGafferResultCacheExporter.getVisibility());
    assertNull(actualGafferResultCacheExporter.getResultCache());
    Set<String> userOpAuths = actualGafferResultCacheExporter.getUserOpAuths();
    assertEquals(1, userOpAuths.size());
    assertTrue(userOpAuths.contains("UNKNOWN"));
    assertTrue(actualGafferResultCacheExporter.getRequiredOpAuths().isEmpty());
    assertSame(context, actualGafferResultCacheExporter.getContext());
  }

  /**
   * Method under test:
   * {@link GafferResultCacheExporter#GafferResultCacheExporter(Context, String, Graph, String, Set)}
   */
  @Test
  void testNewGafferResultCacheExporter2() {
    // Arrange
    Context context = new Context();

    HashSet<String> requiredOpAuths = new HashSet<>();
    requiredOpAuths.add("foo");

    // Act
    GafferResultCacheExporter actualGafferResultCacheExporter = new GafferResultCacheExporter(context, "42", null,
        "Visibility", requiredOpAuths);

    // Assert
    assertEquals("42", actualGafferResultCacheExporter.getJobId());
    assertEquals("Visibility", actualGafferResultCacheExporter.getVisibility());
    assertNull(actualGafferResultCacheExporter.getResultCache());
    Set<String> userOpAuths = actualGafferResultCacheExporter.getUserOpAuths();
    assertEquals(1, userOpAuths.size());
    TreeSet<String> requiredOpAuths2 = actualGafferResultCacheExporter.getRequiredOpAuths();
    assertEquals(1, requiredOpAuths2.size());
    assertTrue(userOpAuths.contains("UNKNOWN"));
    assertTrue(requiredOpAuths2.contains("foo"));
    assertSame(context, actualGafferResultCacheExporter.getContext());
  }

  /**
   * Method under test:
   * {@link GafferResultCacheExporter#GafferResultCacheExporter(Context, String, Graph, String, Set)}
   */
  @Test
  void testNewGafferResultCacheExporter3() {
    // Arrange
    Context context = new Context();

    HashSet<String> requiredOpAuths = new HashSet<>();
    requiredOpAuths.add("42");
    requiredOpAuths.add("foo");

    // Act
    GafferResultCacheExporter actualGafferResultCacheExporter = new GafferResultCacheExporter(context, "42", null,
        "Visibility", requiredOpAuths);

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
