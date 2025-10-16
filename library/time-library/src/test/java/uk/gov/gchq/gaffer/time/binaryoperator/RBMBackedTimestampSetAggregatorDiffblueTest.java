package uk.gov.gchq.gaffer.time.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.time.CommonTimeUtil;
import uk.gov.gchq.gaffer.time.CommonTimeUtil.TimeBucket;
import uk.gov.gchq.gaffer.time.RBMBackedTimestampSet;

class RBMBackedTimestampSetAggregatorDiffblueTest {
  /**
   * Test {@link RBMBackedTimestampSetAggregator#_apply(RBMBackedTimestampSet,
   * RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}, {@code RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetAggregator#_apply(RBMBackedTimestampSet,
   * RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName(
      "Test _apply(RBMBackedTimestampSet, RBMBackedTimestampSet) with 'RBMBackedTimestampSet', 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet RBMBackedTimestampSetAggregator._apply(RBMBackedTimestampSet, RBMBackedTimestampSet)"
  })
  void test_applyWithRBMBackedTimestampSetRBMBackedTimestampSet() {
    // Arrange
    RBMBackedTimestampSetAggregator rbmBackedTimestampSetAggregator =
        new RBMBackedTimestampSetAggregator();
    RBMBackedTimestampSet a = new RBMBackedTimestampSet(TimeBucket.SECOND);

    // Act
    RBMBackedTimestampSet actual_applyResult =
        rbmBackedTimestampSetAggregator._apply(a, new RBMBackedTimestampSet(TimeBucket.SECOND));

    // Assert
    assertSame(a, actual_applyResult);
  }

  /**
   * Test {@link RBMBackedTimestampSetAggregator#_apply(RBMBackedTimestampSet,
   * RBMBackedTimestampSet)} with {@code RBMBackedTimestampSet}, {@code RBMBackedTimestampSet}.
   *
   * <p>Method under test: {@link RBMBackedTimestampSetAggregator#_apply(RBMBackedTimestampSet,
   * RBMBackedTimestampSet)}
   */
  @Test
  @DisplayName(
      "Test _apply(RBMBackedTimestampSet, RBMBackedTimestampSet) with 'RBMBackedTimestampSet', 'RBMBackedTimestampSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RBMBackedTimestampSet RBMBackedTimestampSetAggregator._apply(RBMBackedTimestampSet, RBMBackedTimestampSet)"
  })
  void test_applyWithRBMBackedTimestampSetRBMBackedTimestampSet2() {
    // Arrange
    RBMBackedTimestampSetAggregator rbmBackedTimestampSetAggregator =
        new RBMBackedTimestampSetAggregator();
    RBMBackedTimestampSet a = new RBMBackedTimestampSet(TimeBucket.MINUTE);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            rbmBackedTimestampSetAggregator._apply(
                a, new RBMBackedTimestampSet(TimeBucket.SECOND)));
  }
}
