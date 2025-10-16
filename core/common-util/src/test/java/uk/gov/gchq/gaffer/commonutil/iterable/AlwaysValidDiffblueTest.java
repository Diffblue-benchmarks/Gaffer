package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlwaysValidDiffblueTest {
  /**
   * Test {@link AlwaysValid#validate(Object)}.
   *
   * <p>Method under test: {@link AlwaysValid#validate(Object)}
   */
  @Test
  @DisplayName("Test validate(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlwaysValid.validate(Object)"})
  void testValidate() {
    // Arrange
    AlwaysValid<Object> alwaysValid = new AlwaysValid<>();

    // Act and Assert
    assertTrue(alwaysValid.validate("Obj"));
  }
}
