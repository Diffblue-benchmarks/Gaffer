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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.jobtracker.JobDetail.Builder;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.OperationImpl;
import uk.gov.gchq.gaffer.user.User;

class JobDetailDiffblueTest {
  /**
   * Test Builder {@link Builder#opChain(OperationChain)} with {@code OperationChain}.
   *
   * <p>Method under test: {@link Builder#opChain(OperationChain)}
   */
  @Test
  @DisplayName("Test Builder opChain(OperationChain) with 'OperationChain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.opChain(OperationChain)"})
  void testBuilderOpChainWithOperationChain() {
    // Arrange
    Builder builder = new Builder();
    OperationChain<?> opChain = OperationChain.wrap(new AddNamedOperation());

    // Act
    Builder actualOpChainResult = builder.opChain(opChain);

    // Assert
    assertEquals("OperationChain[AddNamedOperation]", builder.build().getOpChain());
    assertSame(builder, actualOpChainResult);
  }

  /**
   * Test Builder {@link Builder#opChain(OperationChain)} with {@code OperationChain}.
   *
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build OpChain is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Builder#opChain(OperationChain)}
   */
  @Test
  @DisplayName(
      "Test Builder opChain(OperationChain) with 'OperationChain'; then Builder (default constructor) build OpChain is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.opChain(OperationChain)"})
  void testBuilderOpChainWithOperationChain_thenBuilderBuildOpChainIsEmptyString() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOpChainResult = builder.opChain((OperationChain) null);

    // Assert
    assertEquals("", builder.build().getOpChain());
    assertSame(builder, actualOpChainResult);
  }

  /**
   * Test Builder {@link Builder#opChain(OperationChain)} with {@code OperationChain}.
   *
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build OpChain is {@code OperationChain[]}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#opChain(OperationChain)}
   */
  @Test
  @DisplayName(
      "Test Builder opChain(OperationChain) with 'OperationChain'; then Builder (default constructor) build OpChain is 'OperationChain[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.opChain(OperationChain)"})
  void testBuilderOpChainWithOperationChain_thenBuilderBuildOpChainIsOperationChain() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOpChainResult = builder.opChain(new OperationChain());

    // Assert
    assertEquals("OperationChain[]", builder.build().getOpChain());
    assertSame(builder, actualOpChainResult);
  }

  /**
   * Test Builder {@link Builder#serialisedOperationChain(OperationChain)} with {@code opChain}.
   *
   * <p>Method under test: {@link Builder#serialisedOperationChain(OperationChain)}
   */
  @Test
  @DisplayName("Test Builder serialisedOperationChain(OperationChain) with 'opChain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.serialisedOperationChain(OperationChain)"})
  void testBuilderSerialisedOperationChainWithOpChain() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSerialisedOperationChainResult =
        builder.serialisedOperationChain((OperationChain) null);

    // Assert
    assertEquals("", builder.build().getSerialisedOperationChain());
    assertSame(builder, actualSerialisedOperationChainResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
   *   <li>{@link JobDetail#toString()}
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JobDetail.<init>()",
    "String JobDetail.getDescription()",
    "Long JobDetail.getEndTime()",
    "String JobDetail.getJobId()",
    "String JobDetail.getOpChain()",
    "String JobDetail.getParentJobId()",
    "Repeat JobDetail.getRepeat()",
    "String JobDetail.getSerialisedOperationChain()",
    "Long JobDetail.getStartTime()",
    "JobStatus JobDetail.getStatus()",
    "User JobDetail.getUser()",
    "void JobDetail.setDescription(String)",
    "void JobDetail.setEndTime(Long)",
    "void JobDetail.setJobId(String)",
    "void JobDetail.setOpChain(String)",
    "void JobDetail.setParentJobId(String)",
    "void JobDetail.setRepeat(Repeat)",
    "void JobDetail.setSerialisedOperationChain(String)",
    "void JobDetail.setStartTime(Long)",
    "void JobDetail.setStatus(JobStatus)",
    "void JobDetail.setUser(User)",
    "String JobDetail.toString()"
  })
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
    User user = new User.Builder().userId("42").build();
    actualJobDetail.setUser(user);
    String actualToStringResult = actualJobDetail.toString();
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

    // Assert
    assertEquals("42", actualJobId);
    assertEquals("42", actualParentJobId);
    assertEquals(
        "JobDetail[jobId=42,user=User[userId=42,dataAuths=[],opAuths=[]],status=RUNNING,startTime=1,endTime"
            + "=1,opChain=Op Chain,serialisedOperationChain=Serialised Operation Chain,description=The characteristics"
            + " of someone or something,parentJobId=42,repeat=Repeat[initialDelay=0,repeatPeriod=0,timeUnit=SECONDS"
            + "]]",
        actualToStringResult);
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
   * Test {@link JobDetail#JobDetail(String, String, User, String, String, JobStatus, String,
   * Repeat)}.
   *
   * <p>Method under test: {@link JobDetail#JobDetail(String, String, User, String, String,
   * JobStatus, String, Repeat)}
   */
  @Test
  @DisplayName(
      "Test new JobDetail(String, String, User, String, String, JobStatus, String, Repeat)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JobDetail.<init>(String, String, User, String, String, JobStatus, String, Repeat)"
  })
  void testNewJobDetail() {
    // Arrange
    User user = new User();
    Repeat repeat = new Repeat();

    // Act
    JobDetail actualJobDetail =
        new JobDetail(
            "42",
            "42",
            user,
            "Op Chain",
            "Serialised Operation Chain",
            JobStatus.RUNNING,
            "The characteristics of someone or something",
            repeat);

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
   * Test {@link JobDetail#JobDetail(String, String, User, String, JobStatus, String)}.
   *
   * <p>Method under test: {@link JobDetail#JobDetail(String, String, User, String, JobStatus,
   * String)}
   */
  @Test
  @DisplayName("Test new JobDetail(String, String, User, String, JobStatus, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobDetail.<init>(String, String, User, String, JobStatus, String)"})
  void testNewJobDetail2() {
    // Arrange
    User user = new User();

    // Act
    JobDetail actualJobDetail =
        new JobDetail(
            "42",
            "42",
            user,
            "Op Chain",
            JobStatus.RUNNING,
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
   * Test {@link JobDetail#JobDetail(JobDetail, JobDetail)}.
   *
   * <ul>
   *   <li>Then return JobId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetail#JobDetail(JobDetail, JobDetail)}
   */
  @Test
  @DisplayName("Test new JobDetail(JobDetail, JobDetail); then return JobId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobDetail.<init>(JobDetail, JobDetail)"})
  void testNewJobDetail_thenReturnJobIdIs42() {
    // Arrange
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
    JobDetail oldJobDetail = statusResult.user(new User.Builder().userId("42").build()).build();

    Builder parentJobIdResult2 =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("42");
    Repeat repeat = new Repeat();

    Builder statusResult2 =
        parentJobIdResult2
            .repeat(repeat)
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail newJobDetail = statusResult2.user(new User.Builder().userId("42").build()).build();

    // Act
    JobDetail actualJobDetail = new JobDetail(oldJobDetail, newJobDetail);

    // Assert
    assertEquals("42", actualJobDetail.getJobId());
    assertEquals("42", actualJobDetail.getParentJobId());
    User user = actualJobDetail.getUser();
    assertEquals("42", user.getUserId());
    assertEquals("Op Chain", actualJobDetail.getOpChain());
    assertEquals("Serialised Operation Chain", actualJobDetail.getSerialisedOperationChain());
    assertEquals("The characteristics of someone or something", actualJobDetail.getDescription());
    assertEquals(JobStatus.RUNNING, actualJobDetail.getStatus());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
    assertSame(repeat, actualJobDetail.getRepeat());
  }

  /**
   * Test {@link JobDetail#JobDetail(String, String, User, OperationChain, JobStatus, String)}.
   *
   * <ul>
   *   <li>Then return OpChain is {@code OperationChain[AddNamedOperation]}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetail#JobDetail(String, String, User, OperationChain,
   * JobStatus, String)}
   */
  @Test
  @DisplayName(
      "Test new JobDetail(String, String, User, OperationChain, JobStatus, String); then return OpChain is 'OperationChain[AddNamedOperation]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JobDetail.<init>(String, String, User, OperationChain, JobStatus, String)"
  })
  void testNewJobDetail_thenReturnOpChainIsOperationChainAddNamedOperation() {
    // Arrange
    User user = new User();
    OperationChain<?> opChain = OperationChain.wrap(new AddNamedOperation());

    // Act
    JobDetail actualJobDetail =
        new JobDetail(
            "42",
            "42",
            user,
            opChain,
            JobStatus.RUNNING,
            "The characteristics of someone or something");

    // Assert
    assertEquals("42", actualJobDetail.getJobId());
    assertEquals("42", actualJobDetail.getParentJobId());
    assertEquals("OperationChain[AddNamedOperation]", actualJobDetail.getOpChain());
    assertEquals("The characteristics of someone or something", actualJobDetail.getDescription());
    assertNull(actualJobDetail.getEndTime());
    assertNull(actualJobDetail.getSerialisedOperationChain());
    assertNull(actualJobDetail.getRepeat());
    assertEquals(JobStatus.RUNNING, actualJobDetail.getStatus());
    assertSame(user, actualJobDetail.getUser());
  }

  /**
   * Test {@link JobDetail#JobDetail(String, User, OperationChain, JobStatus, String)}.
   *
   * <ul>
   *   <li>Then return OpChain is {@code OperationChain[AddNamedOperation]}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetail#JobDetail(String, User, OperationChain, JobStatus,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new JobDetail(String, User, OperationChain, JobStatus, String); then return OpChain is 'OperationChain[AddNamedOperation]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobDetail.<init>(String, User, OperationChain, JobStatus, String)"})
  void testNewJobDetail_thenReturnOpChainIsOperationChainAddNamedOperation2() {
    // Arrange
    User user = new User();
    OperationChain<?> opChain = OperationChain.wrap(new AddNamedOperation());

    // Act
    JobDetail actualJobDetail =
        new JobDetail(
            "42", user, opChain, JobStatus.RUNNING, "The characteristics of someone or something");

    // Assert
    assertEquals("42", actualJobDetail.getJobId());
    assertEquals("OperationChain[AddNamedOperation]", actualJobDetail.getOpChain());
    assertEquals("The characteristics of someone or something", actualJobDetail.getDescription());
    assertNull(actualJobDetail.getEndTime());
    assertNull(actualJobDetail.getParentJobId());
    assertNull(actualJobDetail.getSerialisedOperationChain());
    assertNull(actualJobDetail.getRepeat());
    assertEquals(JobStatus.RUNNING, actualJobDetail.getStatus());
    assertSame(user, actualJobDetail.getUser());
  }

  /**
   * Test {@link JobDetail#JobDetail(JobDetail, JobDetail)}.
   *
   * <ul>
   *   <li>When {@link JobDetail#JobDetail()}.
   *   <li>Then return EndTime is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetail#JobDetail(JobDetail, JobDetail)}
   */
  @Test
  @DisplayName(
      "Test new JobDetail(JobDetail, JobDetail); when JobDetail(); then return EndTime is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobDetail.<init>(JobDetail, JobDetail)"})
  void testNewJobDetail_whenJobDetail_thenReturnEndTimeIsNull() {
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
   * Test {@link JobDetail#JobDetail(String, String, User, OperationChain, JobStatus, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return OpChain is empty string.
   * </ul>
   *
   * <p>Method under test: {@link JobDetail#JobDetail(String, String, User, OperationChain,
   * JobStatus, String)}
   */
  @Test
  @DisplayName(
      "Test new JobDetail(String, String, User, OperationChain, JobStatus, String); when 'null'; then return OpChain is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JobDetail.<init>(String, String, User, OperationChain, JobStatus, String)"
  })
  void testNewJobDetail_whenNull_thenReturnOpChainIsEmptyString() {
    // Arrange
    User user = new User();

    // Act
    JobDetail actualJobDetail =
        new JobDetail(
            "42",
            "42",
            user,
            (OperationChain<?>) null,
            JobStatus.RUNNING,
            "The characteristics of someone or something");

    // Assert
    assertEquals("", actualJobDetail.getOpChain());
    assertEquals("42", actualJobDetail.getJobId());
    assertEquals("42", actualJobDetail.getParentJobId());
    assertEquals("The characteristics of someone or something", actualJobDetail.getDescription());
    assertNull(actualJobDetail.getEndTime());
    assertNull(actualJobDetail.getSerialisedOperationChain());
    assertNull(actualJobDetail.getRepeat());
    assertEquals(JobStatus.RUNNING, actualJobDetail.getStatus());
    assertSame(user, actualJobDetail.getUser());
  }

  /**
   * Test {@link JobDetail#JobDetail(String, User, OperationChain, JobStatus, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return OpChain is empty string.
   * </ul>
   *
   * <p>Method under test: {@link JobDetail#JobDetail(String, User, OperationChain, JobStatus,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new JobDetail(String, User, OperationChain, JobStatus, String); when 'null'; then return OpChain is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobDetail.<init>(String, User, OperationChain, JobStatus, String)"})
  void testNewJobDetail_whenNull_thenReturnOpChainIsEmptyString2() {
    // Arrange
    User user = new User();

    // Act
    JobDetail actualJobDetail =
        new JobDetail(
            "42", user, null, JobStatus.RUNNING, "The characteristics of someone or something");

    // Assert
    assertEquals("", actualJobDetail.getOpChain());
    assertEquals("42", actualJobDetail.getJobId());
    assertEquals("The characteristics of someone or something", actualJobDetail.getDescription());
    assertNull(actualJobDetail.getEndTime());
    assertNull(actualJobDetail.getParentJobId());
    assertNull(actualJobDetail.getSerialisedOperationChain());
    assertNull(actualJobDetail.getRepeat());
    assertEquals(JobStatus.RUNNING, actualJobDetail.getStatus());
    assertSame(user, actualJobDetail.getUser());
  }

  /**
   * Test {@link JobDetail#JobDetail(String, String, User, OperationChain, JobStatus, String)}.
   *
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.
   *   <li>Then return OpChain is {@code OperationChain[]}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetail#JobDetail(String, String, User, OperationChain,
   * JobStatus, String)}
   */
  @Test
  @DisplayName(
      "Test new JobDetail(String, String, User, OperationChain, JobStatus, String); when OperationChain(); then return OpChain is 'OperationChain[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JobDetail.<init>(String, String, User, OperationChain, JobStatus, String)"
  })
  void testNewJobDetail_whenOperationChain_thenReturnOpChainIsOperationChain() {
    // Arrange
    User user = new User();

    // Act
    JobDetail actualJobDetail =
        new JobDetail(
            "42",
            "42",
            user,
            new OperationChain<>(),
            JobStatus.RUNNING,
            "The characteristics of someone or something");

    // Assert
    assertEquals("42", actualJobDetail.getJobId());
    assertEquals("42", actualJobDetail.getParentJobId());
    assertEquals("OperationChain[]", actualJobDetail.getOpChain());
    assertEquals("The characteristics of someone or something", actualJobDetail.getDescription());
    assertNull(actualJobDetail.getEndTime());
    assertNull(actualJobDetail.getSerialisedOperationChain());
    assertNull(actualJobDetail.getRepeat());
    assertEquals(JobStatus.RUNNING, actualJobDetail.getStatus());
    assertSame(user, actualJobDetail.getUser());
  }

  /**
   * Test {@link JobDetail#JobDetail(String, User, OperationChain, JobStatus, String)}.
   *
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.
   *   <li>Then return OpChain is {@code OperationChain[]}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetail#JobDetail(String, User, OperationChain, JobStatus,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new JobDetail(String, User, OperationChain, JobStatus, String); when OperationChain(); then return OpChain is 'OperationChain[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobDetail.<init>(String, User, OperationChain, JobStatus, String)"})
  void testNewJobDetail_whenOperationChain_thenReturnOpChainIsOperationChain2() {
    // Arrange
    User user = new User();

    // Act
    JobDetail actualJobDetail =
        new JobDetail(
            "42",
            user,
            new OperationChain<>(),
            JobStatus.RUNNING,
            "The characteristics of someone or something");

    // Assert
    assertEquals("42", actualJobDetail.getJobId());
    assertEquals("OperationChain[]", actualJobDetail.getOpChain());
    assertEquals("The characteristics of someone or something", actualJobDetail.getDescription());
    assertNull(actualJobDetail.getEndTime());
    assertNull(actualJobDetail.getParentJobId());
    assertNull(actualJobDetail.getSerialisedOperationChain());
    assertNull(actualJobDetail.getRepeat());
    assertEquals(JobStatus.RUNNING, actualJobDetail.getStatus());
    assertSame(user, actualJobDetail.getUser());
  }

  /**
   * Test {@link JobDetail#setSerialisedOperationChain(OperationChain)} with {@code operationChain}.
   *
   * <p>Method under test: {@link JobDetail#setSerialisedOperationChain(OperationChain)}
   */
  @Test
  @DisplayName("Test setSerialisedOperationChain(OperationChain) with 'operationChain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobDetail.setSerialisedOperationChain(OperationChain)"})
  void testSetSerialisedOperationChainWithOperationChain() {
    // Arrange
    JobDetail jobDetail = new JobDetail();
    OperationChain<?> operationChain = OperationChain.wrap(new AddNamedOperation());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jobDetail.setSerialisedOperationChain(operationChain));
  }

  /**
   * Test {@link JobDetail#setSerialisedOperationChain(OperationChain)} with {@code operationChain}.
   *
   * <p>Method under test: {@link JobDetail#setSerialisedOperationChain(OperationChain)}
   */
  @Test
  @DisplayName("Test setSerialisedOperationChain(OperationChain) with 'operationChain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobDetail.setSerialisedOperationChain(OperationChain)"})
  void testSetSerialisedOperationChainWithOperationChain2() {
    // Arrange
    JobDetail jobDetail = new JobDetail();

    // Act
    jobDetail.setSerialisedOperationChain((OperationChain) null);

    // Assert
    assertEquals("", jobDetail.getSerialisedOperationChain());
  }

  /**
   * Test {@link JobDetail#setSerialisedOperationChain(OperationChain)} with {@code operationChain}.
   *
   * <p>Method under test: {@link JobDetail#setSerialisedOperationChain(OperationChain)}
   */
  @Test
  @DisplayName("Test setSerialisedOperationChain(OperationChain) with 'operationChain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobDetail.setSerialisedOperationChain(OperationChain)"})
  void testSetSerialisedOperationChainWithOperationChain3() {
    // Arrange
    JobDetail jobDetail = new JobDetail();

    AddNamedOperation operation = new AddNamedOperation();
    operation.setOperationChain("filterFieldsByName");
    OperationChain<?> operationChain = OperationChain.wrap(operation);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jobDetail.setSerialisedOperationChain(operationChain));
  }

  /**
   * Test {@link JobDetail#setSerialisedOperationChain(OperationChain)} with {@code operationChain}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JobDetail#setSerialisedOperationChain(OperationChain)}
   */
  @Test
  @DisplayName(
      "Test setSerialisedOperationChain(OperationChain) with 'operationChain'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JobDetail.setSerialisedOperationChain(OperationChain)"})
  void testSetSerialisedOperationChainWithOperationChain_givenNull() {
    // Arrange
    JobDetail jobDetail = new JobDetail();

    OperationImpl operation = new OperationImpl();
    operation.addOption(null, "filterFieldsByName");
    OperationChain<?> operationChain = OperationChain.wrap(operation);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jobDetail.setSerialisedOperationChain(operationChain));
  }

  /**
   * Test {@link JobDetail#equals(Object)}, and {@link JobDetail#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JobDetail#equals(Object)}
   *   <li>{@link JobDetail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JobDetail.equals(Object)", "int JobDetail.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
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

    // Act and Assert
    assertEquals(jobDetail, jobDetail2);
    assertEquals(jobDetail.hashCode(), jobDetail2.hashCode());
  }

  /**
   * Test {@link JobDetail#equals(Object)}, and {@link JobDetail#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JobDetail#equals(Object)}
   *   <li>{@link JobDetail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JobDetail.equals(Object)", "int JobDetail.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
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
    assertEquals(jobDetail, jobDetail);
    int expectedHashCodeResult = jobDetail.hashCode();
    assertEquals(expectedHashCodeResult, jobDetail.hashCode());
  }

  /**
   * Test {@link JobDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JobDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JobDetail.equals(Object)", "int JobDetail.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder parentJobIdResult =
        new Builder()
            .description("The characteristics of someone or something")
            .jobId("42")
            .opChain("Op Chain")
            .parentJobId("42");

    Builder statusResult =
        parentJobIdResult
            .repeat(new Repeat(1L, 1L, TimeUnit.NANOSECONDS))
            .serialisedOperationChain("Serialised Operation Chain")
            .status(JobStatus.RUNNING);
    JobDetail jobDetail = statusResult.user(new User.Builder().userId("42").build()).build();

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

    // Act and Assert
    assertNotEquals(jobDetail, statusResult2.user(new User.Builder().userId("42").build()).build());
  }

  /**
   * Test {@link JobDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JobDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JobDetail.equals(Object)", "int JobDetail.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
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

    // Act and Assert
    assertNotEquals(statusResult.user(new User.Builder().userId("42").build()).build(), null);
  }

  /**
   * Test {@link JobDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JobDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JobDetail.equals(Object)", "int JobDetail.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
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

    // Act and Assert
    assertNotEquals(
        statusResult.user(new User.Builder().userId("42").build()).build(),
        "Different type to JobDetail");
  }
}
