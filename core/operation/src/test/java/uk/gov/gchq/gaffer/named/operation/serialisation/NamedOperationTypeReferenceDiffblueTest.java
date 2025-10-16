package uk.gov.gchq.gaffer.named.operation.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.serialisation.NamedOperationTypeReference.IterableNamedOperationDetail;

class NamedOperationTypeReferenceDiffblueTest {
  /**
   * Test IterableNamedOperationDetail new {@link IterableNamedOperationDetail} (default
   * constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * IterableNamedOperationDetail}
   */
  @Test
  @DisplayName(
      "Test IterableNamedOperationDetail new IterableNamedOperationDetail (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IterableNamedOperationDetail.<init>()"})
  void testIterableNamedOperationDetailNewIterableNamedOperationDetail() {
    // Arrange, Act and Assert
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.named.operation.NamedOperationDetail>",
        new IterableNamedOperationDetail().getType().getTypeName());
  }
}
