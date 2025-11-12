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

package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class StreamFlatMapIterableDiffblueTest {
  /**
   * Method under test:
   * {@link StreamFlatMapIterable#StreamFlatMapIterable(Iterable, Function)}
   */
  @Test
  void testNewStreamFlatMapIterable() {
    // Arrange and Act
    StreamFlatMapIterable<Object, Object> actualStreamFlatMapIterable = new StreamFlatMapIterable<>(new ArrayList<>(),
        mock(Function.class));

    // Assert
    Iterator<Object> iteratorResult = actualStreamFlatMapIterable.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertFalse(iteratorResult.hasNext());
    Stream<Object> stream = actualStreamFlatMapIterable.getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
