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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.koryphe.iterable.LimitedIterable;
import uk.gov.gchq.koryphe.iterable.LimitedIterator;

class SetExporterDiffblueTest {
  /**
   * Test {@link SetExporter#add(String, Iterable)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then calls {@link Iterable#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetExporter#add(String, Iterable)}
   */
  @Test
  @DisplayName("Test add(String, Iterable); given ArrayList() add '42'; then calls iterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetExporter.add(String, Iterable)"})
  void testAdd_givenArrayListAdd42_thenCallsIterator() {
    // Arrange
    SetExporter setExporter = new SetExporter();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Iterable<Object> results = mock(Iterable.class);
    when(results.iterator()).thenReturn(objectList.iterator());

    // Act
    setExporter.add("Key", results);

    // Assert
    verify(results).iterator();
  }

  /**
   * Test {@link SetExporter#add(String, Iterable)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link Iterable#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetExporter#add(String, Iterable)}
   */
  @Test
  @DisplayName("Test add(String, Iterable); given ArrayList() iterator; then calls iterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetExporter.add(String, Iterable)"})
  void testAdd_givenArrayListIterator_thenCallsIterator() {
    // Arrange
    SetExporter setExporter = new SetExporter();
    Iterable<Object> results = mock(Iterable.class);

    ArrayList<Object> objectList = new ArrayList<>();
    when(results.iterator()).thenReturn(objectList.iterator());

    // Act
    setExporter.add("Key", results);

    // Assert
    verify(results).iterator();
  }

  /**
   * Test {@link SetExporter#get(String)} with {@code key}.
   * <p>
   * Method under test: {@link SetExporter#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable SetExporter.get(String)"})
  void testGetWithKey() {
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
   * Test {@link SetExporter#get(String, int, Integer)} with {@code key}, {@code start}, {@code end}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>When one.</li>
   *   <li>Then return Start is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetExporter#get(String, int, Integer)}
   */
  @Test
  @DisplayName("Test get(String, int, Integer) with 'key', 'start', 'end'; given ArrayList() add '42'; when one; then return Start is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable SetExporter.get(String, int, Integer)"})
  void testGetWithKeyStartEnd_givenArrayListAdd42_whenOne_thenReturnStartIsOne() {
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

  /**
   * Test {@link SetExporter#get(String, int, Integer)} with {@code key}, {@code start}, {@code end}.
   * <ul>
   *   <li>Given {@link SetExporter} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return End is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetExporter#get(String, int, Integer)}
   */
  @Test
  @DisplayName("Test get(String, int, Integer) with 'key', 'start', 'end'; given SetExporter (default constructor); when 'null'; then return End is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable SetExporter.get(String, int, Integer)"})
  void testGetWithKeyStartEnd_givenSetExporter_whenNull_thenReturnEndIsNull() {
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
   * Test {@link SetExporter#get(String, int, Integer)} with {@code key}, {@code start}, {@code end}.
   * <ul>
   *   <li>Given {@link SetExporter} (default constructor).</li>
   *   <li>When one.</li>
   *   <li>Then return Start is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetExporter#get(String, int, Integer)}
   */
  @Test
  @DisplayName("Test get(String, int, Integer) with 'key', 'start', 'end'; given SetExporter (default constructor); when one; then return Start is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable SetExporter.get(String, int, Integer)"})
  void testGetWithKeyStartEnd_givenSetExporter_whenOne_thenReturnStartIsOne() {
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
   * Test {@link SetExporter#get(String, int, Integer)} with {@code key}, {@code start}, {@code end}.
   * <ul>
   *   <li>Given {@link SetExporter} (default constructor).</li>
   *   <li>When zero.</li>
   *   <li>Then return Start is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetExporter#get(String, int, Integer)}
   */
  @Test
  @DisplayName("Test get(String, int, Integer) with 'key', 'start', 'end'; given SetExporter (default constructor); when zero; then return Start is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable SetExporter.get(String, int, Integer)"})
  void testGetWithKeyStartEnd_givenSetExporter_whenZero_thenReturnStartIsZero() {
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SetExporter}
   *   <li>{@link SetExporter#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetExporter.<init>()", "String SetExporter.toString()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("SetExporter[exports={}]", (new SetExporter()).toString());
  }
}
