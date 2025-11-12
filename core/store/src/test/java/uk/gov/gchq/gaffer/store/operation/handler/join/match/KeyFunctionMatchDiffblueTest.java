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

package uk.gov.gchq.gaffer.store.operation.handler.join.match;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.koryphe.impl.function.Identity;

class KeyFunctionMatchDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link KeyFunctionMatch.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    KeyFunctionMatch buildResult = (new KeyFunctionMatch.Builder()).build();
    Function firstKeyFunction = buildResult.getFirstKeyFunction();
    assertTrue(firstKeyFunction instanceof Identity);
    Function secondKeyFunction = buildResult.getSecondKeyFunction();
    assertTrue(secondKeyFunction instanceof Identity);
    assertEquals(firstKeyFunction, secondKeyFunction);
  }

  /**
   * Method under test: {@link KeyFunctionMatch#init(Iterable)}
   */
  @Test
  void testInit() {
    // Arrange
    Function secondKeyFunction = mock(Function.class);
    when(secondKeyFunction.apply(Mockito.<Object>any())).thenThrow(new IllegalArgumentException("foo"));
    KeyFunctionMatch keyFunctionMatch = new KeyFunctionMatch(mock(Function.class), secondKeyFunction);

    ArrayList<Object> matchCandidates = new ArrayList<>();
    matchCandidates.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> keyFunctionMatch.init(matchCandidates));
    verify(secondKeyFunction).apply(isA(Object.class));
  }

  /**
   * Method under test: {@link KeyFunctionMatch#matching(Object)}
   */
  @Test
  void testMatching() {
    // Arrange, Act and Assert
    assertTrue((new KeyFunctionMatch()).matching("Test Object").isEmpty());
  }

  /**
   * Method under test: {@link KeyFunctionMatch#matching(Object)}
   */
  @Test
  void testMatching2() {
    // Arrange
    Function firstKeyFunction = mock(Function.class);
    when(firstKeyFunction.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    List actualMatchingResult = (new KeyFunctionMatch(firstKeyFunction, mock(Function.class))).matching("Test Object");

    // Assert
    verify(firstKeyFunction).apply(isA(Object.class));
    assertTrue(actualMatchingResult.isEmpty());
  }

  /**
   * Method under test: {@link KeyFunctionMatch#matching(Object)}
   */
  @Test
  void testMatching3() {
    // Arrange
    Function firstKeyFunction = mock(Function.class);
    when(firstKeyFunction.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function firstKeyFunction2 = mock(Function.class);
    when(firstKeyFunction2.apply(Mockito.<Object>any())).thenThrow(new IllegalArgumentException("foo"));

    KeyFunctionMatch keyFunctionMatch = new KeyFunctionMatch(firstKeyFunction, mock(Function.class));
    keyFunctionMatch.setFirstKeyFunction(firstKeyFunction2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> keyFunctionMatch.matching("Test Object"));
    verify(firstKeyFunction2).apply(isA(Object.class));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KeyFunctionMatch#equals(Object)}
   *   <li>{@link KeyFunctionMatch#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KeyFunctionMatch keyFunctionMatch = new KeyFunctionMatch();
    KeyFunctionMatch keyFunctionMatch2 = new KeyFunctionMatch();

    // Act and Assert
    assertEquals(keyFunctionMatch, keyFunctionMatch2);
    int expectedHashCodeResult = keyFunctionMatch.hashCode();
    assertEquals(expectedHashCodeResult, keyFunctionMatch2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KeyFunctionMatch#equals(Object)}
   *   <li>{@link KeyFunctionMatch#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KeyFunctionMatch keyFunctionMatch = new KeyFunctionMatch();

    // Act and Assert
    assertEquals(keyFunctionMatch, keyFunctionMatch);
    int expectedHashCodeResult = keyFunctionMatch.hashCode();
    assertEquals(expectedHashCodeResult, keyFunctionMatch.hashCode());
  }

  /**
   * Method under test: {@link KeyFunctionMatch#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KeyFunctionMatch keyFunctionMatch = new KeyFunctionMatch(mock(Function.class), mock(Function.class));

    // Act and Assert
    assertNotEquals(keyFunctionMatch, new KeyFunctionMatch());
  }

  /**
   * Method under test: {@link KeyFunctionMatch#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeyFunctionMatch(), null);
  }

  /**
   * Method under test: {@link KeyFunctionMatch#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KeyFunctionMatch(), "Different type to KeyFunctionMatch");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KeyFunctionMatch#KeyFunctionMatch(Function, Function)}
   *   <li>{@link KeyFunctionMatch#setFirstKeyFunction(Function)}
   *   <li>{@link KeyFunctionMatch#setSecondKeyFunction(Function)}
   *   <li>{@link KeyFunctionMatch#getFirstKeyFunction()}
   *   <li>{@link KeyFunctionMatch#getSecondKeyFunction()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    KeyFunctionMatch actualKeyFunctionMatch = new KeyFunctionMatch(mock(Function.class), mock(Function.class));
    Function firstKeyFunction = mock(Function.class);
    actualKeyFunctionMatch.setFirstKeyFunction(firstKeyFunction);
    Function secondKeyFunction = mock(Function.class);
    actualKeyFunctionMatch.setSecondKeyFunction(secondKeyFunction);
    Function actualFirstKeyFunction = actualKeyFunctionMatch.getFirstKeyFunction();

    // Assert that nothing has changed
    assertSame(firstKeyFunction, actualFirstKeyFunction);
    assertSame(secondKeyFunction, actualKeyFunctionMatch.getSecondKeyFunction());
  }

  /**
   * Method under test: {@link KeyFunctionMatch#KeyFunctionMatch()}
   */
  @Test
  void testNewKeyFunctionMatch() {
    // Arrange and Act
    KeyFunctionMatch actualKeyFunctionMatch = new KeyFunctionMatch();

    // Assert
    Function firstKeyFunction = actualKeyFunctionMatch.getFirstKeyFunction();
    assertTrue(firstKeyFunction instanceof Identity);
    Function secondKeyFunction = actualKeyFunctionMatch.getSecondKeyFunction();
    assertTrue(secondKeyFunction instanceof Identity);
    assertEquals(firstKeyFunction, secondKeyFunction);
  }
}
