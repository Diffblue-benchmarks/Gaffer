package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GroupUtilDiffblueTest {
  /**
   * Test {@link GroupUtil#validateName(String)}.
   *
   * <ul>
   *   <li>When {@code [a-zA-Z0-9|-]*}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupUtil#validateName(String)}
   */
  @Test
  @DisplayName(
      "Test validateName(String); when '[a-zA-Z0-9|-]*'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupUtil.validateName(String)"})
  void testValidateName_whenAZAZ09_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> GroupUtil.validateName("[a-zA-Z0-9|-]*"));
  }
}
