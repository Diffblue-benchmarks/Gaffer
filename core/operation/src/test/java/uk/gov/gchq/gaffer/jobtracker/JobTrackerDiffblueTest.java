package uk.gov.gchq.gaffer.jobtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.jobtracker.JobDetail.Builder;
import uk.gov.gchq.gaffer.user.User;

class JobTrackerDiffblueTest {
  /**
   * Test {@link JobTracker#JobTracker(String)}.
   *
   * <ul>
   *   <li>Then return CacheName is {@code JobTracker_jobtracker}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#JobTracker(String)}
   */
  @Test
  @DisplayName("Test new JobTracker(String); then return CacheName is 'JobTracker_jobtracker'")
  @Tag("MaintainedByDiffblue")
  void testNewJobTracker_thenReturnCacheNameIsJobTrackerJobtracker() {
    // Arrange and Act
    JobTracker actualJobTracker = new JobTracker(JobTracker.JOB_TRACKER_CACHE_SERVICE_NAME);

    // Assert
    assertEquals("JobTracker_jobtracker", actualJobTracker.getCacheName());
    assertEquals("jobtracker", actualJobTracker.getSuffixCacheName());
    assertNull(actualJobTracker.getCache());
  }

  /**
   * Test {@link JobTracker#JobTracker(String)}.
   *
   * <ul>
   *   <li>Then return CacheName is {@code JobTracker_suffix job tracker cache name}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#JobTracker(String)}
   */
  @Test
  @DisplayName(
      "Test new JobTracker(String); then return CacheName is 'JobTracker_suffix job tracker cache name'")
  @Tag("MaintainedByDiffblue")
  void testNewJobTracker_thenReturnCacheNameIsJobTrackerSuffixJobTrackerCacheName() {
    // Arrange and Act
    JobTracker actualJobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    // Assert
    assertEquals("JobTracker_suffix job tracker cache name", actualJobTracker.getCacheName());
    assertEquals("suffix job tracker cache name", actualJobTracker.getSuffixCacheName());
    assertNull(actualJobTracker.getCache());
  }

  /**
   * Test {@link JobTracker#getCacheNameFrom(String)} with {@code suffixJobTrackerCacheName}.
   *
   * <p>Method under test: {@link JobTracker#getCacheNameFrom(String)}
   */
  @Test
  @DisplayName("Test getCacheNameFrom(String) with 'suffixJobTrackerCacheName'")
  @Tag("MaintainedByDiffblue")
  void testGetCacheNameFromWithSuffixJobTrackerCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "JobTracker_suffix job tracker cache name",
        JobTracker.getCacheNameFrom("Suffix Job Tracker Cache Name"));
  }

  /**
   * Test {@link JobTracker#getSuffixCacheName()}.
   *
   * <p>Method under test: {@link JobTracker#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName()")
  @Tag("MaintainedByDiffblue")
  void testGetSuffixCacheName() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    // Act and Assert
    assertEquals("suffix job tracker cache name", jobTracker.getSuffixCacheName());
  }

  /**
   * Test {@link JobTracker#getSuffixCacheName()}.
   *
   * <ul>
   *   <li>Given {@link JobTracker#JobTracker(String)} with {@code Suffix Job Tracker Cache Name}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#getSuffixCacheName()}
   */
  @Test
  @DisplayName(
      "Test getSuffixCacheName(); given JobTracker(String) with 'Suffix Job Tracker Cache Name'")
  @Tag("MaintainedByDiffblue")
  void testGetSuffixCacheName_givenJobTrackerWithSuffixJobTrackerCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix job tracker cache name",
        new JobTracker("Suffix Job Tracker Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateJob() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());
    JobDetail jobDetail2 = new JobDetail();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail2, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateJob2() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("jobId is required")
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());
    JobDetail jobDetail2 = new JobDetail();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail2, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateJob3() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("")
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());
    JobDetail jobDetail2 = new JobDetail();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail2, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateJob4() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("jobId is required");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());
    JobDetail jobDetail2 = new JobDetail();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail2, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateJob5() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain((String) null)
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());
    JobDetail jobDetail2 = new JobDetail();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail2, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User); given empty string")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateJob_givenEmptyString() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");
    JobDetail oldJobDetail = new JobDetail();

    JobDetail jobDetail = new JobDetail(oldJobDetail, new JobDetail());
    jobDetail.setJobId("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <ul>
   *   <li>Given {@code jobId is required}.
   *   <li>When {@link JobDetail#JobDetail()} OpChain is {@code jobId is required}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdateJob(JobDetail, User); given 'jobId is required'; when JobDetail() OpChain is 'jobId is required'")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateJob_givenJobIdIsRequired_whenJobDetailOpChainIsJobIdIsRequired() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("jobId is required");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    JobDetail jobDetail2 = new JobDetail();
    jobDetail2.setOpChain("jobId is required");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail2, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <ul>
   *   <li>Given {@link JobTracker#JobTracker(String)} with {@code Suffix Job Tracker Cache Name}.
   *   <li>When {@link JobDetail#JobDetail()}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdateJob(JobDetail, User); given JobTracker(String) with 'Suffix Job Tracker Cache Name'; when JobDetail()")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateJob_givenJobTrackerWithSuffixJobTrackerCacheName_whenJobDetail() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");
    JobDetail jobDetail = new JobDetail();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <ul>
   *   <li>Given {@link JobTracker#JobTracker(String)} with {@code Suffix Job Tracker Cache Name}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdateJob(JobDetail, User); given JobTracker(String) with 'Suffix Job Tracker Cache Name'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateJob_givenJobTrackerWithSuffixJobTrackerCacheName_whenNull() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(null, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link JobDetail#JobDetail()} EndTime is one.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User); given one; when JobDetail() EndTime is one")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateJob_givenOne_whenJobDetailEndTimeIsOne() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("jobId is required");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    JobDetail jobDetail2 = new JobDetail();
    jobDetail2.setEndTime(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail2, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <ul>
   *   <li>Given {@code RUNNING}.
   *   <li>When {@link JobDetail#JobDetail()} Status is {@code RUNNING}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdateJob(JobDetail, User); given 'RUNNING'; when JobDetail() Status is 'RUNNING'")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateJob_givenRunning_whenJobDetailStatusIsRunning() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("jobId is required");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    JobDetail jobDetail2 = new JobDetail();
    jobDetail2.setStatus(JobStatus.RUNNING);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail2, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <ul>
   *   <li>Given {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdateJob(JobDetail, User); given 'The characteristics of someone or something'")
  @Tag("MaintainedByDiffblue")
  void testAddOrUpdateJob_givenTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    JobDetail jobDetail2 = new JobDetail();
    jobDetail2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail2, new User()));
  }

  /**
   * Test {@link JobTracker#getAllJobs(User)}.
   *
   * <p>Method under test: {@link JobTracker#getAllJobs(User)}
   */
  @Test
  @DisplayName("Test getAllJobs(User)")
  @Tag("MaintainedByDiffblue")
  void testGetAllJobs() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> jobTracker.getAllJobs(new User()).iterator());
  }

  /**
   * Test {@link JobTracker#getAllJobs(User)}.
   *
   * <p>Method under test: {@link JobTracker#getAllJobs(User)}
   */
  @Test
  @DisplayName("Test getAllJobs(User)")
  @Tag("MaintainedByDiffblue")
  void testGetAllJobs2() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("42")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> jobTracker.getAllJobs(new User()).iterator());
  }

  /**
   * Test {@link JobTracker#getAllJobs(User)}.
   *
   * <p>Method under test: {@link JobTracker#getAllJobs(User)}
   */
  @Test
  @DisplayName("Test getAllJobs(User)")
  @Tag("MaintainedByDiffblue")
  void testGetAllJobs3() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain((String) null)
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    Builder parentJobIdResult2 =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("42");

    Builder statusResult2 =
        parentJobIdResult2
            .repeat(new Repeat())
            .serialisedOperationChain("42")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail2 = statusResult2.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail2, new User.Builder().userId("42").build());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> jobTracker.getAllJobs(null).iterator());
  }

  /**
   * Test {@link JobTracker#getAllJobs(User)}.
   *
   * <p>Method under test: {@link JobTracker#getAllJobs(User)}
   */
  @Test
  @DisplayName("Test getAllJobs(User)")
  @Tag("MaintainedByDiffblue")
  void testGetAllJobs4() {
    // Arrange
    JobTracker jobTracker = new JobTracker("JobTrackeruk.gov.gchq.gaffer.jobtracker.JobTracker");
    User user = new User();

    // Act
    jobTracker.getAllJobs(user);

    // Assert that nothing has changed
    assertEquals(
        "JobTracker_jobtrackeruk.gov.gchq.gaffer.jobtracker.jobtracker", jobTracker.getCacheName());
    assertEquals("UNKNOWN", user.getUserId());
    assertEquals(
        "jobtrackeruk.gov.gchq.gaffer.jobtracker.jobtracker", jobTracker.getSuffixCacheName());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
  }

  /**
   * Test {@link JobTracker#getAllJobs(User)}.
   *
   * <ul>
   *   <li>Given {@link JobTracker#JobTracker(String)} with {@code Suffix Job Tracker Cache Name}.
   *   <li>When {@link User#User()}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#getAllJobs(User)}
   */
  @Test
  @DisplayName(
      "Test getAllJobs(User); given JobTracker(String) with 'Suffix Job Tracker Cache Name'; when User()")
  @Tag("MaintainedByDiffblue")
  void testGetAllJobs_givenJobTrackerWithSuffixJobTrackerCacheName_whenUser() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> jobTracker.getAllJobs(new User()).iterator());
  }

  /**
   * Test {@link JobTracker#getAllJobs(User)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#getAllJobs(User)}
   */
  @Test
  @DisplayName("Test getAllJobs(User); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetAllJobs_whenNull() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("42")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> jobTracker.getAllJobs(null).iterator());
  }

  /**
   * Test {@link JobTracker#getAllScheduledJobs()}.
   *
   * <p>Method under test: {@link JobTracker#getAllScheduledJobs()}
   */
  @Test
  @DisplayName("Test getAllScheduledJobs()")
  @Tag("MaintainedByDiffblue")
  void testGetAllScheduledJobs() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> jobTracker.getAllScheduledJobs().iterator());
  }

  /**
   * Test {@link JobTracker#getAllScheduledJobs()}.
   *
   * <p>Method under test: {@link JobTracker#getAllScheduledJobs()}
   */
  @Test
  @DisplayName("Test getAllScheduledJobs()")
  @Tag("MaintainedByDiffblue")
  void testGetAllScheduledJobs2() {
    // Arrange
    JobTracker jobTracker = new JobTracker("java.lang.Iterable");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> jobTracker.getAllScheduledJobs().iterator());
  }

  /**
   * Test {@link JobTracker#getAllScheduledJobs()}.
   *
   * <p>Method under test: {@link JobTracker#getAllScheduledJobs()}
   */
  @Test
  @DisplayName("Test getAllScheduledJobs()")
  @Tag("MaintainedByDiffblue")
  void testGetAllScheduledJobs3() {
    // Arrange
    JobTracker jobTracker = new JobTracker("java.lang.Iterable");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    Builder parentJobIdResult2 =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("42");

    Builder statusResult2 =
        parentJobIdResult2
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail2 = statusResult2.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail2, new User.Builder().userId("42").build());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> jobTracker.getAllScheduledJobs().iterator());
  }

  /**
   * Test {@link JobTracker#getAllScheduledJobs()}.
   *
   * <ul>
   *   <li>Given {@link JobTracker#JobTracker(String)} with {@code Suffix Job Tracker Cache Name}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#getAllScheduledJobs()}
   */
  @Test
  @DisplayName(
      "Test getAllScheduledJobs(); given JobTracker(String) with 'Suffix Job Tracker Cache Name'")
  @Tag("MaintainedByDiffblue")
  void testGetAllScheduledJobs_givenJobTrackerWithSuffixJobTrackerCacheName() {
    // Arrange, Act and Assert
    assertThrows(
        GafferRuntimeException.class,
        () -> new JobTracker("Suffix Job Tracker Cache Name").getAllScheduledJobs().iterator());
  }
}
