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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.store.operation.handler.join.match.KeyFunctionMatch.Builder;
import uk.gov.gchq.koryphe.impl.function.Identity;

class KeyFunctionMatchDiffblueTest {
  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    KeyFunctionMatch buildResult = (new Builder()).build();
    Function firstKeyFunction = buildResult.getFirstKeyFunction();
    assertTrue(firstKeyFunction instanceof Identity);
    Function secondKeyFunction = buildResult.getSecondKeyFunction();
    assertTrue(secondKeyFunction instanceof Identity);
    assertEquals(firstKeyFunction, secondKeyFunction);
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void KeyFunctionMatch.<init>(Function, Function)",
      "Function KeyFunctionMatch.getFirstKeyFunction()", "Function KeyFunctionMatch.getSecondKeyFunction()",
      "void KeyFunctionMatch.setFirstKeyFunction(Function)", "void KeyFunctionMatch.setSecondKeyFunction(Function)"})
  void testGettersAndSetters() {
    // Arrange and Act
    KeyFunctionMatch actualKeyFunctionMatch = new KeyFunctionMatch(mock(Function.class), mock(Function.class));
    Function firstKeyFunction = mock(Function.class);
    actualKeyFunctionMatch.setFirstKeyFunction(firstKeyFunction);
    Function secondKeyFunction = mock(Function.class);
    actualKeyFunctionMatch.setSecondKeyFunction(secondKeyFunction);
    Function actualFirstKeyFunction = actualKeyFunctionMatch.getFirstKeyFunction();

    // Assert
    assertSame(firstKeyFunction, actualFirstKeyFunction);
    assertSame(secondKeyFunction, actualKeyFunctionMatch.getSecondKeyFunction());
  }

  /**
   * Test {@link KeyFunctionMatch#KeyFunctionMatch()}.
   * <p>
   * Method under test: {@link KeyFunctionMatch#KeyFunctionMatch()}
   */
  @Test
  @DisplayName("Test new KeyFunctionMatch()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void KeyFunctionMatch.<init>()"})
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

  /**
   * Test {@link KeyFunctionMatch#init(Iterable)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFunctionMatch#init(Iterable)}
   */
  @Test
  @DisplayName("Test init(Iterable); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void KeyFunctionMatch.init(Iterable)"})
  void testInit_thenThrowIllegalArgumentException() {
    // Arrange
    Function secondKeyFunction = mock(Function.class);
    when(secondKeyFunction.apply(Mockito.<Object>any())).thenThrow(new IllegalArgumentException("foo"));
    KeyFunctionMatch buildResult = (new Builder()).firstKeyFunction(mock(Function.class))
        .secondKeyFunction(secondKeyFunction)
        .build();

    ArrayList<Object> matchCandidates = new ArrayList<>();
    matchCandidates.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> buildResult.init(matchCandidates));
    verify(secondKeyFunction).apply(isA(Object.class));
  }

  /**
   * Test {@link KeyFunctionMatch#matching(Object)}.
   * <ul>
   *   <li>Given {@link KeyFunctionMatch#KeyFunctionMatch()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFunctionMatch#matching(Object)}
   */
  @Test
  @DisplayName("Test matching(Object); given KeyFunctionMatch(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List KeyFunctionMatch.matching(Object)"})
  void testMatching_givenKeyFunctionMatch_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new KeyFunctionMatch()).matching("Test Object").isEmpty());
  }

  /**
   * Test {@link KeyFunctionMatch#matching(Object)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFunctionMatch#matching(Object)}
   */
  @Test
  @DisplayName("Test matching(Object); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List KeyFunctionMatch.matching(Object)"})
  void testMatching_thenThrowIllegalArgumentException() {
    // Arrange
    Function firstKeyFunction = mock(Function.class);
    when(firstKeyFunction.apply(Mockito.<Object>any())).thenThrow(new IllegalArgumentException("foo"));
    KeyFunctionMatch buildResult = (new Builder()).firstKeyFunction(firstKeyFunction)
        .secondKeyFunction(mock(Function.class))
        .build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> buildResult.matching("Test Object"));
    verify(firstKeyFunction).apply(isA(Object.class));
  }

  /**
   * Test {@link KeyFunctionMatch#equals(Object)}, and {@link KeyFunctionMatch#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeyFunctionMatch#equals(Object)}
   *   <li>{@link KeyFunctionMatch#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean KeyFunctionMatch.equals(Object)", "int KeyFunctionMatch.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KeyFunctionMatch buildResult = (new Builder()).firstKeyFunction(mock(Function.class))
        .secondKeyFunction(mock(Function.class))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link KeyFunctionMatch#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFunctionMatch#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean KeyFunctionMatch.equals(Object)", "int KeyFunctionMatch.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KeyFunctionMatch buildResult = (new Builder()).firstKeyFunction(mock(Function.class))
        .secondKeyFunction(mock(Function.class))
        .build();
    KeyFunctionMatch buildResult2 = (new Builder()).firstKeyFunction(mock(Function.class))
        .secondKeyFunction(mock(Function.class))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link KeyFunctionMatch#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFunctionMatch#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean KeyFunctionMatch.equals(Object)", "int KeyFunctionMatch.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    KeyFunctionMatch buildResult = (new Builder()).firstKeyFunction(mock(Function.class))
        .secondKeyFunction(mock(Function.class))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link KeyFunctionMatch#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFunctionMatch#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean KeyFunctionMatch.equals(Object)", "int KeyFunctionMatch.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    KeyFunctionMatch buildResult = (new Builder()).firstKeyFunction(mock(Function.class))
        .secondKeyFunction(mock(Function.class))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to KeyFunctionMatch");
  }
}
