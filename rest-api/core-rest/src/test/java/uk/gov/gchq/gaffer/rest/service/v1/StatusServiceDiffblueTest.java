package uk.gov.gchq.gaffer.rest.service.v1;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.rest.factory.GraphFactory;

@ExtendWith(MockitoExtension.class)
class StatusServiceDiffblueTest {
  @Mock private GraphFactory graphFactory;

  @InjectMocks private StatusService statusService;

  /**
   * Test {@link StatusService#status()}.
   *
   * <p>Method under test: {@link StatusService#status()}
   */
  @Test
  @DisplayName("Test status()")
  @Tag("MaintainedByDiffblue")
  void testStatus() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> statusService.status());
    verify(graphFactory).getGraph();
  }
}
