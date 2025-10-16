package uk.gov.gchq.gaffer.flink.operation.handler;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;

class GafferSinkDiffblueTest {
  /**
   * Test {@link GafferSink#invoke(Element)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@link GafferAdder} {@link GafferAdder#add(Element)} does nothing.
   *   <li>Then calls {@link GafferAdder#add(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link GafferSink#invoke(Element)}
   */
  @Test
  @DisplayName(
      "Test invoke(Element) with 'element'; given GafferAdder add(Element) does nothing; then calls add(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferSink.invoke(Element)"})
  void testInvokeWithElement_givenGafferAdderAddDoesNothing_thenCallsAdd() throws Exception {
    // Arrange
    GafferAdder adder = mock(GafferAdder.class);
    doNothing().when(adder).add(Mockito.<Element>any());
    GafferSink gafferSink = new GafferSink(adder);

    // Act
    gafferSink.invoke(new Edge("Group"));

    // Assert
    verify(adder).add(isA(Element.class));
  }
}
