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
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;

class JobDetailDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JobDetail.Builder#build()}
   *   <li>default or parameterless constructor of {@link JobDetail.Builder}
   *   <li>{@link JobDetail.Builder#description(String)}
   *   <li>{@link JobDetail.Builder#jobId(String)}
   *   <li>{@link JobDetail.Builder#opChain(String)}
   *   <li>{@link JobDetail.Builder#parentJobId(String)}
   *   <li>{@link JobDetail.Builder#repeat(Repeat)}
   *   <li>{@link JobDetail.Builder#serialisedOperationChain(String)}
   *   <li>{@link JobDetail.Builder#status(JobStatus)}
   *   <li>{@link JobDetail.Builder#user(User)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    JobDetail.Builder parentJobIdResult = (new JobDetail.Builder())
        .description("The characteristics of someone or something")
        .jobId("42")
        .opChain("Op Chain")
        .parentJobId("42");
    Repeat repeat = new Repeat();
    JobDetail.Builder statusResult = parentJobIdResult.repeat(repeat)
        .serialisedOperationChain("Serialised Operation Chain")
        .status(JobStatus.RUNNING);
    User user = new User();

    // Act
    JobDetail actualBuildResult = statusResult.user(user).build();

    // Assert
    assertEquals("42", actualBuildResult.getJobId());
    assertEquals("42", actualBuildResult.getParentJobId());
    assertEquals("Op Chain", actualBuildResult.getOpChain());
    assertEquals("Serialised Operation Chain", actualBuildResult.getSerialisedOperationChain());
    assertEquals("The characteristics of someone or something", actualBuildResult.getDescription());
    assertNull(actualBuildResult.getEndTime());
    assertEquals(JobStatus.RUNNING, actualBuildResult.getStatus());
    assertSame(repeat, actualBuildResult.getRepeat());
    assertSame(user, actualBuildResult.getUser());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JobDetail#JobDetail()}
   *   <li>{@link JobDetail#setDescription(String)}
   *   <li>{@link JobDetail#setEndTime(Long)}
   *   <li>{@link JobDetail#setJobId(String)}
   *   <li>{@link JobDetail#setOpChain(String)}
   *   <li>{@link JobDetail#setParentJobId(String)}
   *   <li>{@link JobDetail#setRepeat(Repeat)}
   *   <li>{@link JobDetail#setSerialisedOperationChain(String)}
   *   <li>{@link JobDetail#setStartTime(Long)}
   *   <li>{@link JobDetail#setStatus(JobStatus)}
   *   <li>{@link JobDetail#setUser(User)}
   *   <li>{@link JobDetail#getDescription()}
   *   <li>{@link JobDetail#getEndTime()}
   *   <li>{@link JobDetail#getJobId()}
   *   <li>{@link JobDetail#getOpChain()}
   *   <li>{@link JobDetail#getParentJobId()}
   *   <li>{@link JobDetail#getRepeat()}
   *   <li>{@link JobDetail#getSerialisedOperationChain()}
   *   <li>{@link JobDetail#getStartTime()}
   *   <li>{@link JobDetail#getStatus()}
   *   <li>{@link JobDetail#getUser()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    JobDetail actualJobDetail = new JobDetail();
    actualJobDetail.setDescription("The characteristics of someone or something");
    actualJobDetail.setEndTime(1L);
    actualJobDetail.setJobId("42");
    actualJobDetail.setOpChain("Op Chain");
    actualJobDetail.setParentJobId("42");
    Repeat repeat = new Repeat();
    actualJobDetail.setRepeat(repeat);
    actualJobDetail.setSerialisedOperationChain("Serialised Operation Chain");
    actualJobDetail.setStartTime(1L);
    actualJobDetail.setStatus(JobStatus.RUNNING);
    User user = new User();
    actualJobDetail.setUser(user);
    String actualDescription = actualJobDetail.getDescription();
    Long actualEndTime = actualJobDetail.getEndTime();
    String actualJobId = actualJobDetail.getJobId();
    String actualOpChain = actualJobDetail.getOpChain();
    String actualParentJobId = actualJobDetail.getParentJobId();
    Repeat actualRepeat = actualJobDetail.getRepeat();
    String actualSerialisedOperationChain = actualJobDetail.getSerialisedOperationChain();
    Long actualStartTime = actualJobDetail.getStartTime();
    JobStatus actualStatus = actualJobDetail.getStatus();
    User actualUser = actualJobDetail.getUser();

    // Assert that nothing has changed
    assertEquals("42", actualJobId);
    assertEquals("42", actualParentJobId);
    assertEquals("Op Chain", actualOpChain);
    assertEquals("Serialised Operation Chain", actualSerialisedOperationChain);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1L, actualEndTime.longValue());
    assertEquals(1L, actualStartTime.longValue());
    assertEquals(JobStatus.RUNNING, actualStatus);
    assertSame(repeat, actualRepeat);
    assertSame(user, actualUser);
  }

  /**
   * Method under test:
   * {@link JobDetail#JobDetail(String, String, User, String, String, JobStatus, String, Repeat)}
   */
  @Test
  void testNewJobDetail() {
    // Arrange
    User user = new User();
    Repeat repeat = new Repeat();

    // Act
    JobDetail actualJobDetail = new JobDetail("42", "42", user, "Op Chain", "Serialised Operation Chain",
        JobStatus.RUNNING, "The characteristics of someone or something", repeat);

    // Assert
    assertEquals("42", actualJobDetail.getJobId());
    assertEquals("42", actualJobDetail.getParentJobId());
    assertEquals("Op Chain", actualJobDetail.getOpChain());
    assertEquals("Serialised Operation Chain", actualJobDetail.getSerialisedOperationChain());
    assertEquals("The characteristics of someone or something", actualJobDetail.getDescription());
    assertNull(actualJobDetail.getEndTime());
    assertEquals(JobStatus.RUNNING, actualJobDetail.getStatus());
    assertSame(repeat, actualJobDetail.getRepeat());
    assertSame(user, actualJobDetail.getUser());
  }

  /**
   * Method under test:
   * {@link JobDetail#JobDetail(String, String, User, String, JobStatus, String)}
   */
  @Test
  void testNewJobDetail2() {
    // Arrange
    User user = new User();

    // Act
    JobDetail actualJobDetail = new JobDetail("42", "42", user, "Op Chain", JobStatus.RUNNING,
        "The characteristics of someone or something");

    // Assert
    assertEquals("42", actualJobDetail.getJobId());
    assertEquals("42", actualJobDetail.getParentJobId());
    assertEquals("Op Chain", actualJobDetail.getOpChain());
    assertEquals("The characteristics of someone or something", actualJobDetail.getDescription());
    assertNull(actualJobDetail.getEndTime());
    assertNull(actualJobDetail.getSerialisedOperationChain());
    assertNull(actualJobDetail.getRepeat());
    assertEquals(JobStatus.RUNNING, actualJobDetail.getStatus());
    assertSame(user, actualJobDetail.getUser());
  }

  /**
   * Method under test: {@link JobDetail#JobDetail(JobDetail, JobDetail)}
   */
  @Test
  void testNewJobDetail3() {
    // Arrange
    JobDetail oldJobDetail = new JobDetail();

    // Act
    JobDetail actualJobDetail = new JobDetail(oldJobDetail, new JobDetail());

    // Assert
    assertNull(actualJobDetail.getEndTime());
    assertNull(actualJobDetail.getDescription());
    assertNull(actualJobDetail.getJobId());
    assertNull(actualJobDetail.getOpChain());
    assertNull(actualJobDetail.getParentJobId());
    assertNull(actualJobDetail.getSerialisedOperationChain());
    assertNull(actualJobDetail.getStatus());
    assertNull(actualJobDetail.getRepeat());
    assertNull(actualJobDetail.getUser());
  }

  /**
   * Method under test: {@link JobDetail#JobDetail(JobDetail, JobDetail)}
   */
  @Test
  void testNewJobDetail4() {
    // Arrange
    JobDetail oldJobDetail = new JobDetail();
    oldJobDetail.setJobId("Old Job Detail");
    User user = new User();
    oldJobDetail.setUser(user);
    oldJobDetail.setOpChain("Old Job Detail");
    oldJobDetail.setSerialisedOperationChain("Old Job Detail");
    oldJobDetail.setDescription("Old Job Detail");
    oldJobDetail.setStatus(JobStatus.RUNNING);
    oldJobDetail.setParentJobId("Old Job Detail");
    oldJobDetail.setRepeat(new Repeat());
    oldJobDetail.setStartTime(null);

    JobDetail newJobDetail = new JobDetail();
    newJobDetail.setJobId(null);
    newJobDetail.setUser(null);
    newJobDetail.setOpChain(null);
    newJobDetail.setSerialisedOperationChain((String) null);
    newJobDetail.setDescription(null);
    newJobDetail.setStatus(null);
    newJobDetail.setParentJobId(null);
    Repeat repeat = new Repeat();
    newJobDetail.setRepeat(repeat);

    // Act
    JobDetail actualJobDetail = new JobDetail(oldJobDetail, newJobDetail);

    // Assert
    assertEquals("Old Job Detail", actualJobDetail.getDescription());
    assertEquals("Old Job Detail", actualJobDetail.getJobId());
    assertEquals("Old Job Detail", actualJobDetail.getOpChain());
    assertEquals("Old Job Detail", actualJobDetail.getParentJobId());
    assertEquals("Old Job Detail", actualJobDetail.getSerialisedOperationChain());
    assertNull(actualJobDetail.getEndTime());
    assertEquals(JobStatus.RUNNING, actualJobDetail.getStatus());
    assertSame(repeat, actualJobDetail.getRepeat());
    assertSame(user, actualJobDetail.getUser());
  }

  /**
   * Method under test: {@link JobDetail#JobDetail(JobDetail, JobDetail)}
   */
  @Test
  void testNewJobDetail5() {
    // Arrange
    JobDetail oldJobDetail = new JobDetail();
    JobDetail oldJobDetail2 = new JobDetail(oldJobDetail, new JobDetail());

    // Act
    JobDetail actualJobDetail = new JobDetail(oldJobDetail2, new JobDetail());

    // Assert
    assertNull(oldJobDetail2.getEndTime());
    assertNull(oldJobDetail2.getDescription());
    assertNull(actualJobDetail.getDescription());
    assertNull(oldJobDetail2.getJobId());
    assertNull(actualJobDetail.getJobId());
    assertNull(oldJobDetail2.getOpChain());
    assertNull(actualJobDetail.getOpChain());
    assertNull(oldJobDetail2.getParentJobId());
    assertNull(actualJobDetail.getParentJobId());
    assertNull(oldJobDetail2.getSerialisedOperationChain());
    assertNull(actualJobDetail.getSerialisedOperationChain());
    assertNull(oldJobDetail2.getStatus());
    assertNull(actualJobDetail.getStatus());
    assertNull(oldJobDetail2.getRepeat());
    assertNull(actualJobDetail.getRepeat());
    assertNull(oldJobDetail2.getUser());
    assertNull(actualJobDetail.getUser());
  }
}
