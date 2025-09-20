package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PropertiesUtilDiffblueTest {
  /**
   * Test {@link PropertiesUtil#validateName(String)}.
   *
   * <ul>
   *   <li>When {@code [a-zA-Z0-9|-]*}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesUtil#validateName(String)}
   */
  @Test
  @DisplayName(
      "Test validateName(String); when '[a-zA-Z0-9|-]*'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testValidateName_whenAZAZ09_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> PropertiesUtil.validateName("[a-zA-Z0-9|-]*"));
  }

  /**
   * Test {@link PropertiesUtil#isValidName(String)}.
   *
   * <ul>
   *   <li>When {@code [a-zA-Z0-9|-]*}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesUtil#isValidName(String)}
   */
  @Test
  @DisplayName("Test isValidName(String); when '[a-zA-Z0-9|-]*'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testIsValidName_whenAZAZ09_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PropertiesUtil.isValidName("[a-zA-Z0-9|-]*"));
  }

  /**
   * Test {@link PropertiesUtil#isValidName(String)}.
   *
   * <ul>
   *   <li>When {@code Property}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesUtil#isValidName(String)}
   */
  @Test
  @DisplayName("Test isValidName(String); when 'Property'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testIsValidName_whenProperty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PropertiesUtil.isValidName("Property"));
  }

  /**
   * Test {@link PropertiesUtil#stripInvalidCharacters(String)}.
   *
   * <p>Method under test: {@link PropertiesUtil#stripInvalidCharacters(String)}
   */
  @Test
  @DisplayName("Test stripInvalidCharacters(String)")
  @Tag("MaintainedByDiffblue")
  void testStripInvalidCharacters() {
    // Arrange, Act and Assert
    assertEquals("Property", PropertiesUtil.stripInvalidCharacters("Property"));
  }
}
