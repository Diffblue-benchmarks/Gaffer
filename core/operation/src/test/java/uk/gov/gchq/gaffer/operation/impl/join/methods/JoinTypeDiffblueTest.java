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

package uk.gov.gchq.gaffer.operation.impl.join.methods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.koryphe.tuple.MapTuple;

class JoinTypeDiffblueTest {
  /**
   * Test {@link JoinType#createInstance()}.
   * <p>
   * Method under test: {@link JoinType#createInstance()}
   */
  @Test
  @DisplayName("Test createInstance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JoinFunction JoinType.createInstance()"})
  void testCreateInstance() {
    // Arrange and Act
    JoinFunction actualCreateInstanceResult = JoinType.FULL.createInstance();

    // Assert
    MapTuple joinAggregatedResult = actualCreateInstanceResult.joinAggregated("Key", null, "Key Name", "42");
    Iterable<Object> valuesResult = joinAggregatedResult.values();
    assertTrue(valuesResult instanceof Collection);
    assertTrue(actualCreateInstanceResult instanceof FullJoin);
    Map values = joinAggregatedResult.getValues();
    assertEquals(2, values.size());
    assertEquals("Key", values.get("Key Name"));
    Iterator<Object> iteratorResult = joinAggregatedResult.iterator();
    assertEquals("Key", iteratorResult.next());
    assertNull(iteratorResult.next());
    assertNull(values.get("42"));
    assertEquals(2, ((Collection<Object>) valuesResult).size());
    assertFalse(iteratorResult.hasNext());
  }
}
