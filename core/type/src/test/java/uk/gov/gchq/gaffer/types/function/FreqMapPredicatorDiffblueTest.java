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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.types.FreqMap;
import uk.gov.gchq.koryphe.impl.predicate.If;
import uk.gov.gchq.koryphe.predicate.KoryphePredicate;

class FreqMapPredicatorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FreqMapPredicator#FreqMapPredicator()}
   *   <li>{@link FreqMapPredicator#setPredicate(KoryphePredicate)}
   *   <li>{@link FreqMapPredicator#getPredicate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FreqMapPredicator.<init>()", "void FreqMapPredicator.<init>(KoryphePredicate)",
      "KoryphePredicate FreqMapPredicator.getPredicate()", "void FreqMapPredicator.setPredicate(KoryphePredicate)"})
  void testGettersAndSetters() {
    // Arrange and Act
    FreqMapPredicator actualFreqMapPredicator = new FreqMapPredicator();
    If<String> predicate = new If<>();
    actualFreqMapPredicator.setPredicate(predicate);

    // Assert
    assertSame(predicate, actualFreqMapPredicator.getPredicate());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link If#If()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FreqMapPredicator#FreqMapPredicator(KoryphePredicate)}
   *   <li>{@link FreqMapPredicator#setPredicate(KoryphePredicate)}
   *   <li>{@link FreqMapPredicator#getPredicate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when If()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FreqMapPredicator.<init>()", "void FreqMapPredicator.<init>(KoryphePredicate)",
      "KoryphePredicate FreqMapPredicator.getPredicate()", "void FreqMapPredicator.setPredicate(KoryphePredicate)"})
  void testGettersAndSetters_whenIf() {
    // Arrange and Act
    FreqMapPredicator actualFreqMapPredicator = new FreqMapPredicator(new If<>());
    If<String> predicate = new If<>();
    actualFreqMapPredicator.setPredicate(predicate);

    // Assert
    assertSame(predicate, actualFreqMapPredicator.getPredicate());
  }

  /**
   * Test {@link FreqMapPredicator#apply(FreqMap)} with {@code FreqMap}.
   * <ul>
   *   <li>Given {@link FreqMapPredicator#FreqMapPredicator()} Predicate is {@link If#If()}.</li>
   *   <li>When {@link FreqMap#FreqMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  @DisplayName("Test apply(FreqMap) with 'FreqMap'; given FreqMapPredicator() Predicate is If(); when FreqMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapPredicator.apply(FreqMap)"})
  void testApplyWithFreqMap_givenFreqMapPredicatorPredicateIsIf_whenFreqMap() {
    // Arrange
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator();
    freqMapPredicator.setPredicate(new If<>());
    FreqMap freqMap = new FreqMap();

    // Act and Assert
    assertEquals(freqMap, freqMapPredicator.apply(freqMap));
  }

  /**
   * Test {@link FreqMapPredicator#apply(FreqMap)} with {@code FreqMap}.
   * <ul>
   *   <li>Given {@link FreqMapPredicator#FreqMapPredicator(KoryphePredicate)} with predicate is {@link If#If()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  @DisplayName("Test apply(FreqMap) with 'FreqMap'; given FreqMapPredicator(KoryphePredicate) with predicate is If(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapPredicator.apply(FreqMap)"})
  void testApplyWithFreqMap_givenFreqMapPredicatorWithPredicateIsIf_thenReturnEmpty() {
    // Arrange
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator(new If<>());

    FreqMap freqMap = new FreqMap();
    freqMap.put("foo", 1L);

    // Act and Assert
    assertTrue(freqMapPredicator.apply(freqMap).isEmpty());
  }

  /**
   * Test {@link FreqMapPredicator#apply(FreqMap)} with {@code FreqMap}.
   * <ul>
   *   <li>Given {@link FreqMapPredicator#FreqMapPredicator(KoryphePredicate)} with predicate is {@link If#If()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  @DisplayName("Test apply(FreqMap) with 'FreqMap'; given FreqMapPredicator(KoryphePredicate) with predicate is If(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapPredicator.apply(FreqMap)"})
  void testApplyWithFreqMap_givenFreqMapPredicatorWithPredicateIsIf_thenReturnEmpty2() {
    // Arrange
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator(new If<>());

    FreqMap freqMap = new FreqMap();
    freqMap.put("java.lang.Long", 0L);
    freqMap.put("foo", 1L);

    // Act and Assert
    assertTrue(freqMapPredicator.apply(freqMap).isEmpty());
  }

  /**
   * Test {@link FreqMapPredicator#apply(FreqMap)} with {@code FreqMap}.
   * <ul>
   *   <li>Given {@link FreqMapPredicator#FreqMapPredicator()}.</li>
   *   <li>Then return {@link FreqMap#FreqMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  @DisplayName("Test apply(FreqMap) with 'FreqMap'; given FreqMapPredicator(); then return FreqMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapPredicator.apply(FreqMap)"})
  void testApplyWithFreqMap_givenFreqMapPredicator_thenReturnFreqMap() {
    // Arrange
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator();

    FreqMap freqMap = new FreqMap();
    freqMap.put("foo", 1L);

    // Act and Assert
    assertEquals(freqMap, freqMapPredicator.apply(freqMap));
  }

  /**
   * Test {@link FreqMapPredicator#apply(FreqMap)} with {@code FreqMap}.
   * <ul>
   *   <li>Given {@link FreqMapPredicator#FreqMapPredicator()}.</li>
   *   <li>When {@link FreqMap#FreqMap()}.</li>
   *   <li>Then return {@link FreqMap#FreqMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  @DisplayName("Test apply(FreqMap) with 'FreqMap'; given FreqMapPredicator(); when FreqMap(); then return FreqMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapPredicator.apply(FreqMap)"})
  void testApplyWithFreqMap_givenFreqMapPredicator_whenFreqMap_thenReturnFreqMap() {
    // Arrange
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator();
    FreqMap freqMap = new FreqMap();

    // Act and Assert
    assertEquals(freqMap, freqMapPredicator.apply(freqMap));
  }

  /**
   * Test {@link FreqMapPredicator#apply(FreqMap)} with {@code FreqMap}.
   * <ul>
   *   <li>Given {@code java.lang.Long}.</li>
   *   <li>When {@link FreqMap#FreqMap()} {@code java.lang.Long} is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  @DisplayName("Test apply(FreqMap) with 'FreqMap'; given 'java.lang.Long'; when FreqMap() 'java.lang.Long' is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapPredicator.apply(FreqMap)"})
  void testApplyWithFreqMap_givenJavaLangLong_whenFreqMapJavaLangLongIsZero() {
    // Arrange
    FreqMapPredicator freqMapPredicator = new FreqMapPredicator();

    FreqMap freqMap = new FreqMap();
    freqMap.put("java.lang.Long", 0L);
    freqMap.put("foo", 1L);

    // Act and Assert
    assertEquals(freqMap, freqMapPredicator.apply(freqMap));
  }

  /**
   * Test {@link FreqMapPredicator#apply(FreqMap)} with {@code FreqMap}.
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.</li>
   *   <li>Then calls {@link Predicate#test(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapPredicator#apply(FreqMap)}
   */
  @Test
  @DisplayName("Test apply(FreqMap) with 'FreqMap'; given Predicate test(Object) return 'true'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapPredicator.apply(FreqMap)"})
  void testApplyWithFreqMap_givenPredicateTestReturnTrue_thenCallsTest() {
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
    assertEquals(freqMap, actualApplyResult);
  }
}
