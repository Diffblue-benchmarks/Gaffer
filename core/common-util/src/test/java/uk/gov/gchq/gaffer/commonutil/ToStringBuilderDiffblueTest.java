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

package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

class ToStringBuilderDiffblueTest {
  /**
   * Method under test:
   * {@link ToStringBuilder.GafferFullStyle#append(StringBuffer, String, Object, Boolean)}
   */
  @Test
  void testGafferFullStyleAppend() {
    // Arrange
    ToStringBuilder.GafferFullStyle gafferFullStyle = new ToStringBuilder.GafferFullStyle();
    StringBuffer buffer = new StringBuffer("foo");

    // Act
    gafferFullStyle.append(buffer, "Field Name", "Value", true);

    // Assert
    assertEquals("fooField Name=Value,", buffer.toString());
  }

  /**
   * Method under test:
   * {@link ToStringBuilder.GafferFullStyle#append(StringBuffer, String, Object, Boolean)}
   */
  @Test
  void testGafferFullStyleAppend2() {
    // Arrange
    ToStringBuilder.GafferFullStyle gafferFullStyle = new ToStringBuilder.GafferFullStyle();
    StringBuffer buffer = new StringBuffer("foo");

    // Act
    gafferFullStyle.append(buffer, null, (Object) null, null);

    // Assert that nothing has changed
    assertEquals("foo", buffer.toString());
  }

  /**
   * Method under test: {@link ToStringBuilder#ToStringBuilder(Object)}
   */
  @Test
  void testNewToStringBuilder() {
    // Arrange and Act
    ToStringBuilder actualToStringBuilder = new ToStringBuilder("Object");

    // Assert
    ToStringStyle style = actualToStringBuilder.getStyle();
    assertTrue(style instanceof ToStringBuilder.GafferShortStyle);
    assertEquals("Object", actualToStringBuilder.getObject());
    assertEquals("String[", actualToStringBuilder.getStringBuffer().toString());
    assertSame(actualToStringBuilder.SHORT_STYLE, style);
  }
}
