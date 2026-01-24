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

package uk.gov.gchq.gaffer.commonutil.elementvisibilityutil;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.elementvisibilityutil.exception.VisibilityParseException;

class VisibilityEvaluatorDiffblueTest {
  /**
   * Test {@link VisibilityEvaluator#evaluate(ElementVisibility)} with {@code visibility}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VisibilityEvaluator#evaluate(ElementVisibility)}
   */
  @Test
  @DisplayName("Test evaluate(ElementVisibility) with 'visibility'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VisibilityEvaluator.evaluate(ElementVisibility)"})
  void testEvaluateWithVisibility_thenReturnTrue() throws VisibilityParseException {
    // Arrange
    VisibilityEvaluator visibilityEvaluator = new VisibilityEvaluator(new Authorisations());

    // Act
    boolean actualEvaluateResult = visibilityEvaluator.evaluate(new ElementVisibility(""));

    // Assert
    assertTrue(actualEvaluateResult);
  }

  /**
   * Test {@link VisibilityEvaluator#evaluate(ElementVisibility)} with {@code visibility}.
   *
   * <ul>
   *   <li>When {@link ElementVisibility#ElementVisibility(String)} with {@code Expression}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VisibilityEvaluator#evaluate(ElementVisibility)}
   */
  @Test
  @DisplayName(
      "Test evaluate(ElementVisibility) with 'visibility'; when ElementVisibility(String) with 'Expression'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VisibilityEvaluator.evaluate(ElementVisibility)"})
  void testEvaluateWithVisibility_whenElementVisibilityWithExpression_thenReturnFalse()
      throws VisibilityParseException {
    // Arrange
    VisibilityEvaluator visibilityEvaluator = new VisibilityEvaluator(new Authorisations());

    // Act
    boolean actualEvaluateResult =
        visibilityEvaluator.evaluate(new ElementVisibility("Expression"));

    // Assert
    assertFalse(actualEvaluateResult);
  }

  /**
   * Test {@link VisibilityEvaluator#escape(byte[], boolean)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code "AXAXAXAX"} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link VisibilityEvaluator#escape(byte[], boolean)}
   */
  @Test
  @DisplayName(
      "Test escape(byte[], boolean); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '\"AXAXAXAX\"' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] VisibilityEvaluator.escape(byte[], boolean)"})
  void testEscape_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "\"AXAXAXAX\"".getBytes("UTF-8"),
        VisibilityEvaluator.escape("AXAXAXAX".getBytes("UTF-8"), true));
  }

  /**
   * Test {@link VisibilityEvaluator#escape(byte[], boolean)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link VisibilityEvaluator#escape(byte[], boolean)}
   */
  @Test
  @DisplayName(
      "Test escape(byte[], boolean); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] VisibilityEvaluator.escape(byte[], boolean)"})
  void testEscape_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxaxBytesIsUtf82()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        VisibilityEvaluator.escape("AXAXAXAX".getBytes("UTF-8"), false));
  }

  /**
   * Test {@link VisibilityEvaluator#escape(byte[], boolean)}.
   *
   * <ul>
   *   <li>When {@code "XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code "\"XAXAXAX"} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link VisibilityEvaluator#escape(byte[], boolean)}
   */
  @Test
  @DisplayName(
      "Test escape(byte[], boolean); when '\"XAXAXAX' Bytes is 'UTF-8'; then return '\"\\\"XAXAXAX\"' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] VisibilityEvaluator.escape(byte[], boolean)"})
  void testEscape_whenXaxaxaxBytesIsUtf8_thenReturnXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "\"\\\"XAXAXAX\"".getBytes("UTF-8"),
        VisibilityEvaluator.escape("\"XAXAXAX".getBytes("UTF-8"), true));
  }

  /**
   * Test {@link VisibilityEvaluator#escape(byte[], boolean)}.
   *
   * <ul>
   *   <li>When {@code \XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code "\\XAXAXAX"} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link VisibilityEvaluator#escape(byte[], boolean)}
   */
  @Test
  @DisplayName(
      "Test escape(byte[], boolean); when '\\XAXAXAX' Bytes is 'UTF-8'; then return '\"\\\\XAXAXAX\"' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] VisibilityEvaluator.escape(byte[], boolean)"})
  void testEscape_whenXaxaxaxBytesIsUtf8_thenReturnXaxaxaxBytesIsUtf82()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "\"\\\\XAXAXAX\"".getBytes("UTF-8"),
        VisibilityEvaluator.escape("\\XAXAXAX".getBytes("UTF-8"), true));
  }

  /**
   * Test {@link VisibilityEvaluator#escape(byte[], boolean)}.
   *
   * <ul>
   *   <li>When {@code "XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code \"XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link VisibilityEvaluator#escape(byte[], boolean)}
   */
  @Test
  @DisplayName(
      "Test escape(byte[], boolean); when '\"XAXAXAX' Bytes is 'UTF-8'; then return '\\\"XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] VisibilityEvaluator.escape(byte[], boolean)"})
  void testEscape_whenXaxaxaxBytesIsUtf8_thenReturnXaxaxaxBytesIsUtf83()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "\\\"XAXAXAX".getBytes("UTF-8"),
        VisibilityEvaluator.escape("\"XAXAXAX".getBytes("UTF-8"), false));
  }
}
