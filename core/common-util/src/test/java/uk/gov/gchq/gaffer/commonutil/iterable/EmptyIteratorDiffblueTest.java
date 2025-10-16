package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EmptyIteratorDiffblueTest {
  /**
   * Test {@link EmptyIterator#next()}.
   *
   * <p>Method under test: {@link EmptyIterator#next()}
   */
  @Test
  @DisplayName("Test next()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EmptyIterator.next()"})
  void testNext() {
    // Arrange
    EmptyIterator<Object> emptyIterator = new EmptyIterator<>();

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> emptyIterator.next());
  }

  /**
   * Test {@link EmptyIterator#remove()}.
   *
   * <p>Method under test: {@link EmptyIterator#remove()}
   */
  @Test
  @DisplayName("Test remove()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmptyIterator.remove()"})
  void testRemove() {
    // Arrange
    EmptyIterator<Object> emptyIterator = new EmptyIterator<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> emptyIterator.remove());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EmptyIterator}
   *   <li>{@link EmptyIterator#close()}
   *   <li>{@link EmptyIterator#hasNext()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EmptyIterator.<init>()",
    "void EmptyIterator.close()",
    "boolean EmptyIterator.hasNext()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EmptyIterator<Object> actualEmptyIterator = new EmptyIterator<>();
    actualEmptyIterator.close();

    // Assert
    assertFalse(actualEmptyIterator.hasNext());
    assertFalse(actualEmptyIterator.hasNext());
  }
}
