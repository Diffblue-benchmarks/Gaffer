package uk.gov.gchq.gaffer.operation.impl.job;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.job.CancelScheduledJob.Builder;

class CancelScheduledJobDiffblueTest {
  /**
   * Test Builder {@link Builder#jobId(String)}.
   *
   * <p>Method under test: {@link Builder#jobId(String)}
   */
  @Test
  @DisplayName("Test Builder jobId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.jobId(String)"})
  void testBuilderJobId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualJobIdResult = builder.jobId("42");

    // Assert
    assertSame(builder, actualJobIdResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    CancelScheduledJob _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getJobId());
    assertNull(_getOpResult.getOptions());
    CancelScheduledJob actualCancelScheduledJob = actualBuilder.build();
    assertSame(_getOpResult, actualCancelScheduledJob);
  }

  /**
   * Test {@link CancelScheduledJob#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link CancelScheduledJob} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link CancelScheduledJob#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given CancelScheduledJob (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CancelScheduledJob CancelScheduledJob.shallowClone()"})
  void testShallowClone_givenCancelScheduledJobOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    CancelScheduledJob cancelScheduledJob = new CancelScheduledJob();
    cancelScheduledJob.setOptions(new HashMap<>());

    // Act
    CancelScheduledJob actualShallowCloneResult = cancelScheduledJob.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getJobId());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link CancelScheduledJob#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link CancelScheduledJob} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CancelScheduledJob#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given CancelScheduledJob (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CancelScheduledJob CancelScheduledJob.shallowClone()"})
  void testShallowClone_givenCancelScheduledJob_thenReturnOptionsIsNull()
      throws CloneFailedException {
    // Arrange and Act
    CancelScheduledJob actualShallowCloneResult = new CancelScheduledJob().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CancelScheduledJob}
   *   <li>{@link CancelScheduledJob#setJobId(String)}
   *   <li>{@link CancelScheduledJob#setOptions(Map)}
   *   <li>{@link CancelScheduledJob#getJobId()}
   *   <li>{@link CancelScheduledJob#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CancelScheduledJob.<init>()",
    "String CancelScheduledJob.getJobId()",
    "Map CancelScheduledJob.getOptions()",
    "void CancelScheduledJob.setJobId(String)",
    "void CancelScheduledJob.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    CancelScheduledJob actualCancelScheduledJob = new CancelScheduledJob();
    actualCancelScheduledJob.setJobId("42");
    HashMap<String, String> options = new HashMap<>();
    actualCancelScheduledJob.setOptions(options);
    String actualJobId = actualCancelScheduledJob.getJobId();
    Map<String, String> actualOptions = actualCancelScheduledJob.getOptions();

    // Assert
    assertEquals("42", actualJobId);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
