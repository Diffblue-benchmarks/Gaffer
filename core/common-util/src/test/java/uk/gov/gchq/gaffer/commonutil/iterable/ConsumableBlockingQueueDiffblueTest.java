package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConsumableBlockingQueueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConsumableBlockingQueue#ConsumableBlockingQueue(int)}
   *   <li>{@link ConsumableBlockingQueue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConsumableBlockingQueue.<init>(int)",
    "java.lang.String ConsumableBlockingQueue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ConsumableBlockingQueue<Object> actualConsumableBlockingQueue =
        new ConsumableBlockingQueue<>(3);

    // Assert
    assertEquals("ConsumableBlockingQueue[items={}]", actualConsumableBlockingQueue.toString());
  }
}
