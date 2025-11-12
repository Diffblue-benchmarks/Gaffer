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

package uk.gov.gchq.gaffer.commonutil.elementvisibilityutil;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.elementvisibilityutil.exception.VisibilityParseException;

class VisibilityEvaluatorDiffblueTest {
  /**
   * Method under test: {@link VisibilityEvaluator#evaluate(ElementVisibility)}
   */
  @Test
  void testEvaluate() throws VisibilityParseException {
    // Arrange
    VisibilityEvaluator visibilityEvaluator = new VisibilityEvaluator(new Authorisations());

    // Act and Assert
    assertFalse(visibilityEvaluator.evaluate(new ElementVisibility("Expression")));
  }

  /**
   * Method under test: {@link VisibilityEvaluator#evaluate(ElementVisibility)}
   */
  @Test
  void testEvaluate2() throws VisibilityParseException {
    // Arrange
    VisibilityEvaluator visibilityEvaluator = new VisibilityEvaluator(new Authorisations());

    // Act and Assert
    assertTrue(visibilityEvaluator.evaluate(new ElementVisibility("")));
  }

  /**
   * Method under test: {@link VisibilityEvaluator#escape(byte[], boolean)}
   */
  @Test
  void testEscape() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualEscapeResult = VisibilityEvaluator.escape("AXAXAXAX".getBytes("UTF-8"), true);

    // Assert
    assertArrayEquals("\"AXAXAXAX\"".getBytes("UTF-8"), actualEscapeResult);
  }

  /**
   * Method under test: {@link VisibilityEvaluator#escape(byte[], boolean)}
   */
  @Test
  void testEscape2() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualEscapeResult = VisibilityEvaluator.escape("\"XAXAXAX".getBytes("UTF-8"), true);

    // Assert
    assertArrayEquals("\"\\\"XAXAXAX\"".getBytes("UTF-8"), actualEscapeResult);
  }

  /**
   * Method under test: {@link VisibilityEvaluator#escape(byte[], boolean)}
   */
  @Test
  void testEscape3() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualEscapeResult = VisibilityEvaluator.escape("\\XAXAXAX".getBytes("UTF-8"), true);

    // Assert
    assertArrayEquals("\"\\\\XAXAXAX\"".getBytes("UTF-8"), actualEscapeResult);
  }

  /**
   * Method under test: {@link VisibilityEvaluator#escape(byte[], boolean)}
   */
  @Test
  void testEscape4() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualEscapeResult = VisibilityEvaluator.escape("AXAXAXAX".getBytes("UTF-8"), false);

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualEscapeResult);
  }

  /**
   * Method under test: {@link VisibilityEvaluator#escape(byte[], boolean)}
   */
  @Test
  void testEscape5() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualEscapeResult = VisibilityEvaluator.escape("\"XAXAXAX".getBytes("UTF-8"), false);

    // Assert
    assertArrayEquals("\\\"XAXAXAX".getBytes("UTF-8"), actualEscapeResult);
  }
}
