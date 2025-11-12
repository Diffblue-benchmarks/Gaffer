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

package uk.gov.gchq.gaffer.operation.impl.export.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.koryphe.iterable.LimitedIterable;
import uk.gov.gchq.koryphe.iterable.LimitedIterator;

class SetExporterDiffblueTest {
  /**
   * Method under test: {@link SetExporter#get(String)}
   */
  @Test
  void testGet() {
    // Arrange and Act
    Iterable<?> actualGetResult = (new SetExporter()).get("Key");
    Iterator<?> actualIteratorResult = actualGetResult.iterator();

    // Assert
    assertTrue(actualGetResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertNull(((LimitedIterable<?>) actualGetResult).getEnd());
    assertEquals(0, ((LimitedIterable<?>) actualGetResult).getStart());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Method under test: {@link SetExporter#get(String, int, Integer)}
   */
  @Test
  void testGet2() {
    // Arrange and Act
    Iterable<?> actualGetResult = (new SetExporter()).get("Key", 1, 3);
    Iterator<?> actualIteratorResult = actualGetResult.iterator();

    // Assert
    assertTrue(actualGetResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertEquals(1, ((LimitedIterable<?>) actualGetResult).getStart());
    assertEquals(3, ((LimitedIterable<?>) actualGetResult).getEnd().intValue());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Method under test: {@link SetExporter#get(String, int, Integer)}
   */
  @Test
  void testGet3() {
    // Arrange and Act
    Iterable<?> actualGetResult = (new SetExporter()).get("Key", 1, null);
    Iterator<?> actualIteratorResult = actualGetResult.iterator();

    // Assert
    assertTrue(actualGetResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertNull(((LimitedIterable<?>) actualGetResult).getEnd());
    assertEquals(1, ((LimitedIterable<?>) actualGetResult).getStart());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Method under test: {@link SetExporter#get(String, int, Integer)}
   */
  @Test
  void testGet4() {
    // Arrange and Act
    Iterable<?> actualGetResult = (new SetExporter()).get("Key", 0, 3);
    Iterator<?> actualIteratorResult = actualGetResult.iterator();

    // Assert
    assertTrue(actualGetResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertEquals(0, ((LimitedIterable<?>) actualGetResult).getStart());
    assertEquals(3, ((LimitedIterable<?>) actualGetResult).getEnd().intValue());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Method under test: {@link SetExporter#get(String, int, Integer)}
   */
  @Test
  void testGet5() {
    // Arrange
    ArrayList<Object> results = new ArrayList<>();
    results.add("42");

    SetExporter setExporter = new SetExporter();
    setExporter.add("Key", results);

    // Act
    Iterable<?> actualGetResult = setExporter.get("Key", 1, 3);
    Iterator<?> actualIteratorResult = actualGetResult.iterator();

    // Assert
    assertTrue(actualGetResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertEquals(1, ((LimitedIterable<?>) actualGetResult).getStart());
    assertEquals(3, ((LimitedIterable<?>) actualGetResult).getEnd().intValue());
    assertFalse(actualIteratorResult.hasNext());
  }
}
