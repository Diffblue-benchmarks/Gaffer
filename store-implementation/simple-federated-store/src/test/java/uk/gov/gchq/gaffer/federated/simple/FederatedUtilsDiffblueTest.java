package uk.gov.gchq.gaffer.federated.simple;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FederatedUtilsDiffblueTest {
  /**
   * Test {@link FederatedUtils#doGraphsShareGroups(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedUtils#doGraphsShareGroups(List)}
   */
  @Test
  @DisplayName("Test doGraphsShareGroups(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FederatedUtils.doGraphsShareGroups(List)"})
  void testDoGraphsShareGroups_whenArrayList() {
    // Arrange, Act and Assert
    assertFalse(FederatedUtils.doGraphsShareGroups(new ArrayList<>()));
  }
}
