package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.SplitStoreFromIterable.Builder;

class SplitStoreFromIterableDiffblueTest {
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
    Builder<Object> actualBuilder = new Builder<>();

    // Assert
    SplitStoreFromIterable<Object> _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    SplitStoreFromIterable<Object> actualSplitStoreFromIterable = actualBuilder.build();
    assertSame(_getOpResult, actualSplitStoreFromIterable);
  }

  /**
   * Test {@link SplitStoreFromIterable#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link SplitStoreFromIterable} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromIterable#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given SplitStoreFromIterable (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SplitStoreFromIterable SplitStoreFromIterable.shallowClone()"})
  void testShallowClone_givenSplitStoreFromIterable_thenReturnOptionsIsNull() {
    // Arrange
    SplitStoreFromIterable<Object> splitStoreFromIterable = new SplitStoreFromIterable<>();

    // Act
    SplitStoreFromIterable<Object> actualShallowCloneResult = splitStoreFromIterable.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test {@link SplitStoreFromIterable#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromIterable#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SplitStoreFromIterable SplitStoreFromIterable.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    SplitStoreFromIterable<Object> splitStoreFromIterable = new SplitStoreFromIterable<>();
    splitStoreFromIterable.setOptions(new HashMap<>());

    // Act
    SplitStoreFromIterable<Object> actualShallowCloneResult = splitStoreFromIterable.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link SplitStoreFromIterable#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SplitStoreFromIterable#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable SplitStoreFromIterable.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange
    SplitStoreFromIterable<Object> splitStoreFromIterable = new SplitStoreFromIterable<>();

    // Act and Assert
    assertNull(splitStoreFromIterable.getInput());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SplitStoreFromIterable}
   *   <li>{@link SplitStoreFromIterable#setInput(Iterable)}
   *   <li>{@link SplitStoreFromIterable#setOptions(Map)}
   *   <li>{@link SplitStoreFromIterable#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SplitStoreFromIterable.<init>()",
    "Map SplitStoreFromIterable.getOptions()",
    "void SplitStoreFromIterable.setInput(Iterable)",
    "void SplitStoreFromIterable.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SplitStoreFromIterable<Object> actualSplitStoreFromIterable = new SplitStoreFromIterable<>();
    ArrayList<Object> input = new ArrayList<>();
    actualSplitStoreFromIterable.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualSplitStoreFromIterable.setOptions(options);
    Map<String, String> actualOptions = actualSplitStoreFromIterable.getOptions();

    // Assert
    Iterable<?> input2 = actualSplitStoreFromIterable.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
