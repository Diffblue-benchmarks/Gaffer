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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.ToStringBuilder.GafferFullStyle;
import uk.gov.gchq.gaffer.commonutil.ToStringBuilder.GafferShortStyle;

class ToStringBuilderDiffblueTest {
  /**
   * Test GafferFullStyle {@link GafferFullStyle#append(StringBuffer, String, Object, Boolean)} with {@code StringBuffer}, {@code String}, {@code Object}, {@code Boolean}.
   * <p>
   * Method under test: {@link GafferFullStyle#append(StringBuffer, String, Object, Boolean)}
   */
  @Test
  @DisplayName("Test GafferFullStyle append(StringBuffer, String, Object, Boolean) with 'StringBuffer', 'String', 'Object', 'Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GafferFullStyle.append(StringBuffer, String, Object, Boolean)"})
  void testGafferFullStyleAppendWithStringBufferStringObjectBoolean() {
    // Arrange
    GafferFullStyle gafferFullStyle = new GafferFullStyle();
    StringBuffer buffer = new StringBuffer("foo");

    // Act
    gafferFullStyle.append(buffer, "Field Name", "Value", true);

    // Assert
    assertEquals("fooField Name=Value,", buffer.toString());
  }

  /**
   * Test GafferFullStyle {@link GafferFullStyle#append(StringBuffer, String, Object, Boolean)} with {@code StringBuffer}, {@code String}, {@code Object}, {@code Boolean}.
   * <p>
   * Method under test: {@link GafferFullStyle#append(StringBuffer, String, Object, Boolean)}
   */
  @Test
  @DisplayName("Test GafferFullStyle append(StringBuffer, String, Object, Boolean) with 'StringBuffer', 'String', 'Object', 'Boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GafferFullStyle.append(StringBuffer, String, Object, Boolean)"})
  void testGafferFullStyleAppendWithStringBufferStringObjectBoolean2() {
    // Arrange
    GafferFullStyle gafferFullStyle = new GafferFullStyle();
    StringBuffer buffer = new StringBuffer("foo");

    // Act
    gafferFullStyle.append(buffer, null, (Object) null, null);

    // Assert that nothing has changed
    assertEquals("foo", buffer.toString());
  }

  /**
   * Test {@link ToStringBuilder#ToStringBuilder(Object)}.
   * <p>
   * Method under test: {@link ToStringBuilder#ToStringBuilder(Object)}
   */
  @Test
  @DisplayName("Test new ToStringBuilder(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToStringBuilder.<init>(Object)"})
  void testNewToStringBuilder() {
    // Arrange and Act
    ToStringBuilder actualToStringBuilder = new ToStringBuilder("Object");

    // Assert
    ToStringStyle style = actualToStringBuilder.getStyle();
    assertTrue(style instanceof GafferShortStyle);
    assertEquals("Object", actualToStringBuilder.getObject());
    assertEquals("String[", actualToStringBuilder.getStringBuffer().toString());
    assertSame(actualToStringBuilder.SHORT_STYLE, style);
  }
}
