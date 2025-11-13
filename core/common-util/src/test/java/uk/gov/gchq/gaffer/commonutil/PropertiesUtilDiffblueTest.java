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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PropertiesUtilDiffblueTest {
  /**
   * Test {@link PropertiesUtil#validateName(String)}.
   * <ul>
   *   <li>When {@code [a-zA-Z0-9|-]*}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesUtil#validateName(String)}
   */
  @Test
  @DisplayName("Test validateName(String); when '[a-zA-Z0-9|-]*'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PropertiesUtil.validateName(String)"})
  void testValidateName_whenAZAZ09_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PropertiesUtil.validateName("[a-zA-Z0-9|-]*"));
  }

  /**
   * Test {@link PropertiesUtil#isValidName(String)}.
   * <ul>
   *   <li>When {@code [a-zA-Z0-9|-]*}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesUtil#isValidName(String)}
   */
  @Test
  @DisplayName("Test isValidName(String); when '[a-zA-Z0-9|-]*'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesUtil.isValidName(String)"})
  void testIsValidName_whenAZAZ09_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PropertiesUtil.isValidName("[a-zA-Z0-9|-]*"));
  }

  /**
   * Test {@link PropertiesUtil#isValidName(String)}.
   * <ul>
   *   <li>When {@code Property}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertiesUtil#isValidName(String)}
   */
  @Test
  @DisplayName("Test isValidName(String); when 'Property'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertiesUtil.isValidName(String)"})
  void testIsValidName_whenProperty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PropertiesUtil.isValidName("Property"));
  }

  /**
   * Test {@link PropertiesUtil#stripInvalidCharacters(String)}.
   * <p>
   * Method under test: {@link PropertiesUtil#stripInvalidCharacters(String)}
   */
  @Test
  @DisplayName("Test stripInvalidCharacters(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PropertiesUtil.stripInvalidCharacters(String)"})
  void testStripInvalidCharacters() {
    // Arrange, Act and Assert
    assertEquals("Property", PropertiesUtil.stripInvalidCharacters("Property"));
  }
}
