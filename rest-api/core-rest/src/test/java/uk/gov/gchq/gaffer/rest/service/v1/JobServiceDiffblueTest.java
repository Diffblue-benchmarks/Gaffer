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
import uk.gov.gchq.gaffer.operation.OperationChainDAO;
import uk.gov.gchq.gaffer.rest.factory.GraphFactory;
import uk.gov.gchq.gaffer.rest.factory.UserFactory;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.user.User;

@ExtendWith(MockitoExtension.class)
class JobServiceDiffblueTest {
  @Mock private GraphFactory graphFactory;

  @InjectMocks private JobService jobService;

  @Mock private UserFactory userFactory;

  /**
   * Test {@link JobService#executeJob(OperationChainDAO)}.
   *
   * <ul>
   *   <li>Given {@link GraphFactory} {@link GraphFactory#getGraph()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link GraphFactory#getGraph()}.
   * </ul>
   *
   * <p>Method under test: {@link JobService#executeJob(OperationChainDAO)}
   */
  @Test
  @DisplayName(
      "Test executeJob(OperationChainDAO); given GraphFactory getGraph() throw RuntimeException(); then calls getGraph()")
  @Tag("MaintainedByDiffblue")
  void testExecuteJob_givenGraphFactoryGetGraphThrowRuntimeException_thenCallsGetGraph() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new RuntimeException());

    Builder builder = new Builder();
    when(userFactory.createContext())
        .thenReturn(builder.user(new User.Builder().userId("42").build()).build());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jobService.executeJob(new OperationChainDAO()));
    verify(graphFactory).getGraph();
    verify(userFactory).createContext();
  }

  /**
   * Test {@link JobService#executeJob(OperationChainDAO)}.
   *
   * <ul>
   *   <li>Given {@link UserFactory} {@link UserFactory#createContext()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link JobService#executeJob(OperationChainDAO)}
   */
  @Test
  @DisplayName(
      "Test executeJob(OperationChainDAO); given UserFactory createContext() throw RuntimeException()")
  @Tag("MaintainedByDiffblue")
  void testExecuteJob_givenUserFactoryCreateContextThrowRuntimeException() {
    // Arrange
    when(userFactory.createContext()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jobService.executeJob(new OperationChainDAO()));
    verify(userFactory).createContext();
  }

  /**
   * Test {@link JobService#details(String)} with {@code String}.
   *
   * <p>Method under test: {@link JobService#details(String)}
   */
  @Test
  @DisplayName("Test details(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  void testDetailsWithString() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jobService.details("42"));
    verify(graphFactory).getGraph();
  }
}
