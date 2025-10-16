package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonUtilDiffblueTest {
  /**
   * Test {@link JsonUtil#equals(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and {@code X}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#equals(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test equals(byte[], byte[]) with 'byte[]', 'byte[]'; when array of byte with 'A' and 'X'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonUtil.equals(byte[], byte[])"})
  void testEqualsWithByteByte_whenArrayOfByteWithAAndX_thenReturnFalse() {
    // Arrange and Act
    boolean actualEqualsResult =
        JsonUtil.equals(null, new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertFalse(actualEqualsResult);
  }

  /**
   * Test {@link JsonUtil#equals(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   *
   * <ul>
   *   <li>When array of {@code byte} with three and {@code X}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#equals(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test equals(byte[], byte[]) with 'byte[]', 'byte[]'; when array of byte with three and 'X'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonUtil.equals(byte[], byte[])"})
  void testEqualsWithByteByte_whenArrayOfByteWithThreeAndX_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualEqualsResult =
        JsonUtil.equals(
            new byte[] {3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualEqualsResult);
  }

  /**
   * Test {@link JsonUtil#equals(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#equals(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test equals(byte[], byte[]) with 'byte[]', 'byte[]'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonUtil.equals(byte[], byte[])"})
  void testEqualsWithByteByte_whenAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualEqualsResult =
        JsonUtil.equals("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualEqualsResult);
  }

  /**
   * Test {@link JsonUtil#equals(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#equals(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test equals(byte[], byte[]) with 'byte[]', 'byte[]'; when empty array of byte; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonUtil.equals(byte[], byte[])"})
  void testEqualsWithByteByte_whenEmptyArrayOfByte_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualEqualsResult = JsonUtil.equals(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualEqualsResult);
  }

  /**
   * Test {@link JsonUtil#equals(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#equals(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test equals(byte[], byte[]) with 'byte[]', 'byte[]'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonUtil.equals(byte[], byte[])"})
  void testEqualsWithByteByte_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JsonUtil.equals((byte[]) null, null));
  }

  /**
   * Test {@link JsonUtil#equals(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#equals(String, String)}
   */
  @Test
  @DisplayName(
      "Test equals(String, String) with 'String', 'String'; when '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonUtil.equals(String, String)"})
  void testEqualsWithStringString_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JsonUtil.equals("42", "Actual Json"));
  }

  /**
   * Test {@link JsonUtil#equals(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#equals(String, String)}
   */
  @Test
  @DisplayName(
      "Test equals(String, String) with 'String', 'String'; when empty string; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonUtil.equals(String, String)"})
  void testEqualsWithStringString_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JsonUtil.equals("", "Actual Json"));
  }

  /**
   * Test {@link JsonUtil#equals(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When {@code Error comparing json. expectedJson: {} actual json:}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#equals(String, String)}
   */
  @Test
  @DisplayName(
      "Test equals(String, String) with 'String', 'String'; when 'Error comparing json. expectedJson: {} actual json:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonUtil.equals(String, String)"})
  void testEqualsWithStringString_whenErrorComparingJsonExpectedJsonActualJson() {
    // Arrange, Act and Assert
    assertFalse(
        JsonUtil.equals("42", "Error comparing json.\nexpectedJson:\n {}\n actual json:\n"));
  }

  /**
   * Test {@link JsonUtil#equals(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When {@code Expected Json}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#equals(String, String)}
   */
  @Test
  @DisplayName(
      "Test equals(String, String) with 'String', 'String'; when 'Expected Json'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonUtil.equals(String, String)"})
  void testEqualsWithStringString_whenExpectedJson_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JsonUtil.equals("Expected Json", "Actual Json"));
  }

  /**
   * Test {@link JsonUtil#equals(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#equals(String, String)}
   */
  @Test
  @DisplayName(
      "Test equals(String, String) with 'String', 'String'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonUtil.equals(String, String)"})
  void testEqualsWithStringString_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JsonUtil.equals(null, "Actual Json"));
  }

  /**
   * Test {@link JsonUtil#equals(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonUtil#equals(String, String)}
   */
  @Test
  @DisplayName(
      "Test equals(String, String) with 'String', 'String'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonUtil.equals(String, String)"})
  void testEqualsWithStringString_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JsonUtil.equals((String) null, null));
  }
}
