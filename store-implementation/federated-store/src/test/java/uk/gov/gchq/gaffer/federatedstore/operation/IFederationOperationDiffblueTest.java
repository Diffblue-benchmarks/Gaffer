package uk.gov.gchq.gaffer.federatedstore.operation;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.operation.AddGraph.Builder;
import uk.gov.gchq.gaffer.federatedstore.operation.IFederationOperation.BaseBuilder;

class IFederationOperationDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#setUserRequestingAdminUsage(boolean)}.
   *
   * <p>Method under test: {@link BaseBuilder#setUserRequestingAdminUsage(boolean)}
   */
  @Test
  @DisplayName("Test BaseBuilder setUserRequestingAdminUsage(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.operation.Operation.BaseBuilder BaseBuilder.setUserRequestingAdminUsage(boolean)"
  })
  void testBaseBuilderSetUserRequestingAdminUsage() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSetUserRequestingAdminUsageResult = builder.setUserRequestingAdminUsage(true);

    // Assert
    assertSame(builder, actualSetUserRequestingAdminUsageResult);
  }
}
