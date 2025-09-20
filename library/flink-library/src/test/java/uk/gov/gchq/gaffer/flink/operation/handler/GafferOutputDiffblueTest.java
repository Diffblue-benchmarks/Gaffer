package uk.gov.gchq.gaffer.flink.operation.handler;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;

class GafferOutputDiffblueTest {
  /**
   * Test {@link GafferOutput#writeRecord(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link GafferAdder} {@link GafferAdder#add(Element)} does nothing.
   *   <li>Then calls {@link GafferAdder#add(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link GafferOutput#writeRecord(Element)}
   */
  @Test
  @DisplayName(
      "Test writeRecord(Element) with 'Element'; given GafferAdder add(Element) does nothing; then calls add(Element)")
  @Tag("MaintainedByDiffblue")
  void testWriteRecordWithElement_givenGafferAdderAddDoesNothing_thenCallsAdd() {
    // Arrange
    GafferAdder adder = mock(GafferAdder.class);
    doNothing().when(adder).add(Mockito.<Element>any());
    GafferOutput gafferOutput = new GafferOutput(adder);

    // Act
    gafferOutput.writeRecord(new Edge("Group"));

    // Assert
    verify(adder).add(isA(Element.class));
  }
}
