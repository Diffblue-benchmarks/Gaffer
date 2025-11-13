/*
 * Copyright 2025 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.jobtracker;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.<init>(String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.<init>(String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JobTracker.getCacheNameFrom(String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JobTracker.getSuffixCacheName()"})
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
   * <p>Method under test: {@link JobTracker#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JobTracker.getSuffixCacheName()"})
  void testGetSuffixCacheName2() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description(JobTracker.JOB_TRACKER_CACHE_SERVICE_NAME)
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
   * <p>Method under test: {@link JobTracker#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JobTracker.getSuffixCacheName()"})
  void testGetSuffixCacheName3() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description(JobTracker.JOB_TRACKER_CACHE_SERVICE_NAME)
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.SCHEDULED_PARENT);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JobTracker.getSuffixCacheName()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
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

    // Act and Assert
    assertDoesNotThrow(
        () -> jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob2() {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob3() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("jobId is required")
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob4() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder().description("").jobId("42").opChain("Op Chain").parentJobId("42");

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob5() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder().description("42").jobId("42").opChain("Op Chain").parentJobId("42");

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob6() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

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
    JobDetail jobDetail3 = new JobDetail();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail3, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob7() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder().description("").jobId("42").opChain("Op Chain").parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(null, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link JobDetail#JobDetail()} JobId is {@code 42}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdateJob(JobDetail, User); given '42'; when JobDetail() JobId is '42'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob_given42_whenJobDetailJobIdIs42_thenDoesNotThrow() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder().description("42").jobId("42").opChain("Op Chain").parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

    JobDetail jobDetail2 = new JobDetail();
    jobDetail2.setJobId("42");

    // Act and Assert
    assertDoesNotThrow(() -> jobTracker.addOrUpdateJob(jobDetail2, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link JobDetail#JobDetail()} ParentJobId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdateJob(JobDetail, User); given '42'; when JobDetail() ParentJobId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob_given42_whenJobDetailParentJobIdIs42() {
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
    jobDetail2.setParentJobId("42");

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
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
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User); given 'jobId is required'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob_givenJobIdIsRequired() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("jobId is required")
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
    jobDetail2.setSerialisedOperationChain("jobId is required");

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
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
   *   <li>Given {@code RUNNING}.
   *   <li>When {@link JobDetail#JobDetail()} Status is {@code RUNNING}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName(
      "Test addOrUpdateJob(JobDetail, User); given 'RUNNING'; when JobDetail() Status is 'RUNNING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob_givenRunning_whenJobDetailStatusIsRunning() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder().description("42").jobId("42").opChain("Op Chain").parentJobId("42");

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
   * Test {@link JobTracker#getAllJobs(User)}.
   *
   * <p>Method under test: {@link JobTracker#getAllJobs(User)}
   */
  @Test
  @DisplayName("Test getAllJobs(User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable JobTracker.getAllJobs(User)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable JobTracker.getAllJobs(User)"})
  void testGetAllJobs2() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op ChainOp Chain")
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
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail2 = statusResult2.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail2, new User.Builder().userId("42").build());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> jobTracker.getAllJobs(new User()).iterator());
  }

  /**
   * Test {@link JobTracker#getAllJobs(User)}.
   *
   * <ul>
   *   <li>Given {@link JobTracker#JobTracker(String)} with {@code Suffix Job Tracker Cache Name}.
   * </ul>
   *
   * <p>Method under test: {@link JobTracker#getAllJobs(User)}
   */
  @Test
  @DisplayName(
      "Test getAllJobs(User); given JobTracker(String) with 'Suffix Job Tracker Cache Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable JobTracker.getAllJobs(User)"})
  void testGetAllJobs_givenJobTrackerWithSuffixJobTrackerCacheName() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> jobTracker.getAllJobs(new User()).iterator());
  }

  /**
   * Test {@link JobTracker#getAllScheduledJobs()}.
   *
   * <p>Method under test: {@link JobTracker#getAllScheduledJobs()}
   */
  @Test
  @DisplayName("Test getAllScheduledJobs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable JobTracker.getAllScheduledJobs()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable JobTracker.getAllScheduledJobs()"})
  void testGetAllScheduledJobs2() {
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
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId(null).build());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable JobTracker.getAllScheduledJobs()"})
  void testGetAllScheduledJobs3() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Error getting all keysError getting all keys")
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable JobTracker.getAllScheduledJobs()"})
  void testGetAllScheduledJobs4() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Error getting all keysError getting all keys")
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat())
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.CANCELLED);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();
    jobTracker.addOrUpdateJob(jobDetail, new User.Builder().userId("42").build());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Iterable JobTracker.getAllScheduledJobs()"})
  void testGetAllScheduledJobs_givenJobTrackerWithSuffixJobTrackerCacheName() {
    // Arrange, Act and Assert
    assertThrows(
        GafferRuntimeException.class,
        () -> new JobTracker("Suffix Job Tracker Cache Name").getAllScheduledJobs().iterator());
  }
}
