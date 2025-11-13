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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.jobtracker.JobDetail.Builder;
import uk.gov.gchq.gaffer.user.User;

class JobTrackerDiffblueTest {
  /**
   * Test {@link JobTracker#JobTracker(String)}.
   * <ul>
   *   <li>Then return CacheName is {@code JobTracker_jobtracker}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobTracker#JobTracker(String)}
   */
  @Test
  @DisplayName("Test new JobTracker(String); then return CacheName is 'JobTracker_jobtracker'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return CacheName is {@code JobTracker_suffix job tracker cache name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobTracker#JobTracker(String)}
   */
  @Test
  @DisplayName("Test new JobTracker(String); then return CacheName is 'JobTracker_suffix job tracker cache name'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link JobTracker#getCacheNameFrom(String)}
   */
  @Test
  @DisplayName("Test getCacheNameFrom(String) with 'suffixJobTrackerCacheName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JobTracker.getCacheNameFrom(String)"})
  void testGetCacheNameFromWithSuffixJobTrackerCacheName() {
    // Arrange, Act and Assert
    assertEquals("JobTracker_suffix job tracker cache name",
        JobTracker.getCacheNameFrom("Suffix Job Tracker Cache Name"));
  }

  /**
   * Test {@link JobTracker#getSuffixCacheName()}.
   * <p>
   * Method under test: {@link JobTracker#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JobTracker.getSuffixCacheName()"})
  void testGetSuffixCacheName() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");
    Builder parentJobIdResult = (new Builder()).description("The characteristics of someone or something")
        .jobId("42")
        .opChain("Op Chain")
        .parentJobId("Parent Job Id");
    Builder statusResult = parentJobIdResult.repeat(new Repeat())
        .serialisedOperationChain("Serialised Operation Chain")
        .status(JobStatus.RUNNING);
    User user = (new User.Builder()).userId("42").build();
    JobDetail jobDetail = statusResult.user(user).build();
    User user2 = (new User.Builder()).userId("42").build();
    jobTracker.addOrUpdateJob(jobDetail, user2);

    // Act and Assert
    assertEquals("suffix job tracker cache name", jobTracker.getSuffixCacheName());
  }

  /**
   * Test {@link JobTracker#getSuffixCacheName()}.
   * <p>
   * Method under test: {@link JobTracker#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JobTracker.getSuffixCacheName()"})
  void testGetSuffixCacheName2() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");
    Builder parentJobIdResult = (new Builder()).description("The characteristics of someone or something")
        .jobId("42")
        .opChain("Op Chain")
        .parentJobId("42");
    Builder statusResult = parentJobIdResult.repeat(new Repeat())
        .serialisedOperationChain("Serialised Operation Chain")
        .status(JobStatus.SCHEDULED_PARENT);
    User user = (new User.Builder()).userId("42").build();
    JobDetail jobDetail = statusResult.user(user).build();
    User user2 = (new User.Builder()).userId("42").build();
    jobTracker.addOrUpdateJob(jobDetail, user2);

    // Act and Assert
    assertEquals("suffix job tracker cache name", jobTracker.getSuffixCacheName());
  }

  /**
   * Test {@link JobTracker#getSuffixCacheName()}.
   * <ul>
   *   <li>Given {@link JobTracker#JobTracker(String)} with {@code Suffix Job Tracker Cache Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobTracker#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName(); given JobTracker(String) with 'Suffix Job Tracker Cache Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JobTracker.getSuffixCacheName()"})
  void testGetSuffixCacheName_givenJobTrackerWithSuffixJobTrackerCacheName() {
    // Arrange, Act and Assert
    assertEquals("suffix job tracker cache name",
        (new JobTracker("Suffix Job Tracker Cache Name")).getSuffixCacheName());
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   * <p>
   * Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");
    Builder parentJobIdResult = (new Builder()).description("Description")
        .jobId("42")
        .opChain("Op Chain")
        .parentJobId("42");
    Builder statusResult = parentJobIdResult.repeat(new Repeat())
        .serialisedOperationChain("Serialised Operation Chain")
        .status(JobStatus.RUNNING);
    User user = (new User.Builder()).userId("42").build();
    JobDetail jobDetail = statusResult.user(user).build();
    User user2 = (new User.Builder()).userId("42").build();
    jobTracker.addOrUpdateJob(jobDetail, user2);
    JobDetail jobDetail2 = new JobDetail();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail2, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   * <p>
   * Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob2() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");
    Builder parentJobIdResult = (new Builder()).description("42").jobId("42").opChain("Op Chain").parentJobId("42");
    Builder statusResult = parentJobIdResult.repeat(new Repeat())
        .serialisedOperationChain("Serialised Operation Chain")
        .status(JobStatus.RUNNING);
    User user = (new User.Builder()).userId("42").build();
    JobDetail jobDetail = statusResult.user(user).build();
    User user2 = (new User.Builder()).userId("42").build();
    jobTracker.addOrUpdateJob(jobDetail, user2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(null, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   * <p>
   * Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob3() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");
    Builder parentJobIdResult = (new Builder()).description("The characteristics of someone or something")
        .jobId("42")
        .opChain("Op Chain")
        .parentJobId("");
    Builder statusResult = parentJobIdResult.repeat(new Repeat())
        .serialisedOperationChain("Serialised Operation Chain")
        .status(JobStatus.RUNNING);
    User user = (new User.Builder()).userId("42").build();
    JobDetail jobDetail = statusResult.user(user).build();
    User user2 = (new User.Builder()).userId("42").build();
    jobTracker.addOrUpdateJob(jobDetail, user2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(null, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   * <p>
   * Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob4() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");
    Builder parentJobIdResult = (new Builder()).description("The characteristics of someone or something")
        .jobId("42")
        .opChain("Op Chain")
        .parentJobId("42");
    Builder statusResult = parentJobIdResult.repeat(new Repeat())
        .serialisedOperationChain("")
        .status(JobStatus.RUNNING);
    User user = (new User.Builder()).userId("42").build();
    JobDetail jobDetail = statusResult.user(user).build();
    User user2 = (new User.Builder()).userId("42").build();
    jobTracker.addOrUpdateJob(jobDetail, user2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(null, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   * <p>
   * Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob5() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");
    Builder parentJobIdResult = (new Builder()).description("The characteristics of someone or something")
        .jobId("42")
        .opChain("Op Chain")
        .parentJobId("42");
    Builder statusResult = parentJobIdResult.repeat(new Repeat())
        .serialisedOperationChain("Serialised Operation Chain")
        .status(JobStatus.FINISHED);
    User user = (new User.Builder()).userId("42").build();
    JobDetail jobDetail = statusResult.user(user).build();
    User user2 = (new User.Builder()).userId("42").build();
    jobTracker.addOrUpdateJob(jobDetail, user2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(null, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   * <p>
   * Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob6() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");
    Builder parentJobIdResult = (new Builder()).description("The characteristics of someone or something")
        .jobId("42")
        .opChain("Op Chain")
        .parentJobId("42");
    Builder statusResult = parentJobIdResult.repeat(new Repeat())
        .serialisedOperationChain("Serialised Operation Chain")
        .status(JobStatus.RUNNING);
    User user = (new User.Builder()).userId("42").build();
    JobDetail jobDetail = statusResult.user(user).build();
    User user2 = (new User.Builder()).userId("").build();
    jobTracker.addOrUpdateJob(jobDetail, user2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(null, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   * <p>
   * Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob7() {
    // Arrange
    JobTracker jobTracker = new JobTracker("uk.gov.gchq.gaffer.jobtracker.JobDetail");
    Builder parentJobIdResult = (new Builder()).description("42").jobId("42").opChain("Op Chain").parentJobId("42");
    Builder statusResult = parentJobIdResult.repeat(new Repeat())
        .serialisedOperationChain("Serialised Operation Chain")
        .status(JobStatus.RUNNING);
    User user = (new User.Builder()).userId("42").build();
    JobDetail jobDetail = statusResult.user(user).build();
    User user2 = (new User.Builder()).userId("42").build();
    jobTracker.addOrUpdateJob(jobDetail, user2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(null, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   * <p>
   * Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob8() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");
    Builder parentJobIdResult = (new Builder()).description("42").jobId("Job Id").opChain("Op Chain").parentJobId("42");
    Builder statusResult = parentJobIdResult.repeat(new Repeat())
        .serialisedOperationChain("Serialised Operation Chain")
        .status(JobStatus.RUNNING);
    User user = (new User.Builder()).userId("42").build();
    JobDetail jobDetail = statusResult.user(user).build();
    User user2 = (new User.Builder()).userId("42").build();
    jobTracker.addOrUpdateJob(jobDetail, user2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(null, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   * <p>
   * Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob9() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");
    Builder parentJobIdResult = (new Builder()).description("42").jobId("42").opChain("Op Chain").parentJobId("42");
    Builder statusResult = parentJobIdResult.repeat(new Repeat())
        .serialisedOperationChain("Serialised Operation Chain")
        .status(JobStatus.RUNNING);
    User user = (new User.Builder()).userId("42").build();
    JobDetail jobDetail = statusResult.user(user).build();
    User user2 = (new User.Builder()).userId("").build();
    jobTracker.addOrUpdateJob(jobDetail, user2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(null, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   * <p>
   * Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob10() {
    // Arrange
    JobTracker jobTracker = new JobTracker("");
    Builder parentJobIdResult = (new Builder()).description("The characteristics of someone or something")
        .jobId("42")
        .opChain("Op Chain")
        .parentJobId("42");
    Builder statusResult = parentJobIdResult.repeat(new Repeat())
        .serialisedOperationChain("")
        .status(JobStatus.RUNNING);
    User user = (new User.Builder()).userId("42").build();
    JobDetail jobDetail = statusResult.user(user).build();
    User user2 = (new User.Builder()).userId("42").build();
    jobTracker.addOrUpdateJob(jobDetail, user2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(null, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link JobDetail#JobDetail()} JobId is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User); given empty string; when JobDetail() JobId is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob_givenEmptyString_whenJobDetailJobIdIsEmptyString() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    JobDetail jobDetail = new JobDetail();
    jobDetail.setJobId("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   * <ul>
   *   <li>Given {@link JobTracker#JobTracker(String)} with {@code Suffix Job Tracker Cache Name}.</li>
   *   <li>When {@link JobDetail#JobDetail()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User); given JobTracker(String) with 'Suffix Job Tracker Cache Name'; when JobDetail()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob_givenJobTrackerWithSuffixJobTrackerCacheName_whenJobDetail() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");
    JobDetail jobDetail = new JobDetail();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(jobDetail, new User()));
  }

  /**
   * Test {@link JobTracker#addOrUpdateJob(JobDetail, User)}.
   * <ul>
   *   <li>Given {@link JobTracker#JobTracker(String)} with {@code Suffix Job Tracker Cache Name}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JobTracker#addOrUpdateJob(JobDetail, User)}
   */
  @Test
  @DisplayName("Test addOrUpdateJob(JobDetail, User); given JobTracker(String) with 'Suffix Job Tracker Cache Name'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobTracker.addOrUpdateJob(JobDetail, User)"})
  void testAddOrUpdateJob_givenJobTrackerWithSuffixJobTrackerCacheName_whenNull() {
    // Arrange
    JobTracker jobTracker = new JobTracker("Suffix Job Tracker Cache Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jobTracker.addOrUpdateJob(null, new User()));
  }
}
