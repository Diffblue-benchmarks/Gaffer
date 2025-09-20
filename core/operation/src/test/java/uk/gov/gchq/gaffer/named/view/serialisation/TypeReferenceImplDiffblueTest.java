package uk.gov.gchq.gaffer.named.view.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.view.serialisation.TypeReferenceImpl.IterableNamedView;

class TypeReferenceImplDiffblueTest {
  /**
   * Test IterableNamedView new {@link IterableNamedView} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link IterableNamedView}
   */
  @Test
  @DisplayName("Test IterableNamedView new IterableNamedView (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testIterableNamedViewNewIterableNamedView() {
    // Arrange, Act and Assert
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.data.elementdefinition.view.NamedViewDetail>",
        new IterableNamedView().getType().getTypeName());
  }
}
