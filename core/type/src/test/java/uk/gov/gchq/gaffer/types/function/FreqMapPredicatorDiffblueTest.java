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

package uk.gov.gchq.gaffer.types.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.types.FreqMap;
import uk.gov.gchq.koryphe.impl.predicate.If;
import uk.gov.gchq.koryphe.predicate.KoryphePredicate;

class FreqMapPredicatorDiffblueTest {
  /**
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  void testApply() {
    // Arrange
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator();

    // Act and Assert
    assertTrue(freqMapPredicator.apply(new FreqMap()).isEmpty());
  }

  /**
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  void testApply2() {
    // Arrange
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator();
    freqMapPredicator.setPredicate(new If<>());

    // Act and Assert
    assertTrue(freqMapPredicator.apply(new FreqMap()).isEmpty());
  }

  /**
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  void testApply3() {
    // Arrange
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator();

    FreqMap freqMap = new FreqMap();
    freqMap.put("foo", 1L);

    // Act
    FreqMap actualApplyResult = freqMapPredicator.apply(freqMap);

    // Assert
    assertEquals(1, actualApplyResult.size());
    assertEquals(1L, actualApplyResult.get("foo").longValue());
  }

  /**
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  void testApply4() {
    // Arrange
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator();

    FreqMap freqMap = new FreqMap();
    freqMap.put("java.lang.Long", 0L);
    freqMap.put("foo", 1L);

    // Act and Assert
    assertEquals(freqMap, freqMapPredicator.apply(freqMap));
  }

  /**
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  void testApply5() {
    // Arrange
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator();

    FreqMap freqMap = new FreqMap();
    freqMap.computeIfPresent("foo", mock(BiFunction.class));
    freqMap.put("foo", 1L);

    // Act
    FreqMap actualApplyResult = freqMapPredicator.apply(freqMap);

    // Assert
    assertEquals(1, actualApplyResult.size());
    assertEquals(1L, actualApplyResult.get("foo").longValue());
  }

  /**
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  void testApply6() {
    // Arrange
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator(new If<>());

    FreqMap freqMap = new FreqMap();
    freqMap.put("foo", 1L);

    // Act and Assert
    assertTrue(freqMapPredicator.apply(freqMap).isEmpty());
  }

  /**
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  void testApply7() {
    // Arrange
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator(new If<>());

    FreqMap freqMap = new FreqMap();
    freqMap.put("java.lang.Long", 0L);
    freqMap.put("foo", 1L);

    // Act and Assert
    assertTrue(freqMapPredicator.apply(freqMap).isEmpty());
  }

  /**
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  void testApply8() {
    // Arrange
    Predicate<String> then = mock(Predicate.class);
    when(then.test(Mockito.<String>any())).thenReturn(true);
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator(new If<>(true, then));

    FreqMap freqMap = new FreqMap();
    freqMap.put("foo", 1L);

    // Act
    FreqMap actualApplyResult = freqMapPredicator.apply(freqMap);

    // Assert
    verify(then).test(eq("foo"));
    assertEquals(1, actualApplyResult.size());
    assertEquals(1L, actualApplyResult.get("foo").longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FreqMapPredicator#FreqMapPredicator()}
   *   <li>{@link FreqMapPredicator#setPredicate(KoryphePredicate)}
   *   <li>{@link FreqMapPredicator#getPredicate()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    FreqMapPredicator actualFreqMapPredicator = new FreqMapPredicator();
    If<String> predicate = new If<>();
    actualFreqMapPredicator.setPredicate(predicate);

    // Assert that nothing has changed
    assertSame(predicate, actualFreqMapPredicator.getPredicate());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FreqMapPredicator#FreqMapPredicator(KoryphePredicate)}
   *   <li>{@link FreqMapPredicator#setPredicate(KoryphePredicate)}
   *   <li>{@link FreqMapPredicator#getPredicate()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    FreqMapPredicator actualFreqMapPredicator = new FreqMapPredicator(new If<>());
    If<String> predicate = new If<>();
    actualFreqMapPredicator.setPredicate(predicate);

    // Assert that nothing has changed
    assertSame(predicate, actualFreqMapPredicator.getPredicate());
  }
}
