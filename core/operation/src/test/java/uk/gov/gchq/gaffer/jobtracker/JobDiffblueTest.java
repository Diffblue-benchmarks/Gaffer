package uk.gov.gchq.gaffer.jobtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;

class JobDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Job#Job()}
   *   <li>{@link Job#setOperation(Operation)}
   *   <li>{@link Job#setRepeat(Repeat)}
   *   <li>{@link Job#toString()}
   *   <li>{@link Job#getOperation()}
   *   <li>{@link Job#getRepeat()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Job.<init>()",
    "void Job.<init>(Repeat)",
    "void Job.<init>(Repeat, Operation)",
    "Operation Job.getOperation()",
    "Repeat Job.getRepeat()",
    "void Job.setOperation(Operation)",
    "void Job.setRepeat(Repeat)",
    "java.lang.String Job.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Job actualJob = new Job();
    AddNamedOperation operation = new AddNamedOperation();
    actualJob.setOperation(operation);
    Repeat repeat = new Repeat();
    actualJob.setRepeat(repeat);
    actualJob.toString();
    Operation actualOperation = actualJob.getOperation();

    // Assert
    assertSame(repeat, actualJob.getRepeat());
    assertSame(operation, actualOperation);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link AddNamedOperation} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Job#Job(Repeat, Operation)}
   *   <li>{@link Job#setOperation(Operation)}
   *   <li>{@link Job#setRepeat(Repeat)}
   *   <li>{@link Job#toString()}
   *   <li>{@link Job#getOperation()}
   *   <li>{@link Job#getRepeat()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when AddNamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Job.<init>()",
    "void Job.<init>(Repeat)",
    "void Job.<init>(Repeat, Operation)",
    "Operation Job.getOperation()",
    "Repeat Job.getRepeat()",
    "void Job.setOperation(Operation)",
    "void Job.setRepeat(Repeat)",
    "java.lang.String Job.toString()"
  })
  void testGettersAndSetters_whenAddNamedOperation() {
    // Arrange
    Repeat repeat = new Repeat();

    // Act
    Job actualJob = new Job(repeat, new AddNamedOperation());
    AddNamedOperation operation = new AddNamedOperation();
    actualJob.setOperation(operation);
    Repeat repeat2 = new Repeat();
    actualJob.setRepeat(repeat2);
    actualJob.toString();
    Operation actualOperation = actualJob.getOperation();

    // Assert
    assertSame(repeat2, actualJob.getRepeat());
    assertSame(operation, actualOperation);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Repeat#Repeat()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Job#Job(Repeat)}
   *   <li>{@link Job#setOperation(Operation)}
   *   <li>{@link Job#setRepeat(Repeat)}
   *   <li>{@link Job#toString()}
   *   <li>{@link Job#getOperation()}
   *   <li>{@link Job#getRepeat()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Repeat()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Job.<init>()",
    "void Job.<init>(Repeat)",
    "void Job.<init>(Repeat, Operation)",
    "Operation Job.getOperation()",
    "Repeat Job.getRepeat()",
    "void Job.setOperation(Operation)",
    "void Job.setRepeat(Repeat)",
    "java.lang.String Job.toString()"
  })
  void testGettersAndSetters_whenRepeat() {
    // Arrange and Act
    Job actualJob = new Job(new Repeat());
    AddNamedOperation operation = new AddNamedOperation();
    actualJob.setOperation(operation);
    Repeat repeat = new Repeat();
    actualJob.setRepeat(repeat);
    actualJob.toString();
    Operation actualOperation = actualJob.getOperation();

    // Assert
    assertSame(repeat, actualJob.getRepeat());
    assertSame(operation, actualOperation);
  }

  /**
   * Test {@link Job#equals(Object)}, and {@link Job#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Job#equals(Object)}
   *   <li>{@link Job#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Job.equals(Object)", "int Job.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Job job = new Job();

    // Act and Assert
    assertEquals(job, job);
    int expectedHashCodeResult = job.hashCode();
    assertEquals(expectedHashCodeResult, job.hashCode());
  }

  /**
   * Test {@link Job#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Job#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Job.equals(Object)", "int Job.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Job(), null);
  }

  /**
   * Test {@link Job#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Job#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Job.equals(Object)", "int Job.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Job(), "Different type to Job");
  }
}
