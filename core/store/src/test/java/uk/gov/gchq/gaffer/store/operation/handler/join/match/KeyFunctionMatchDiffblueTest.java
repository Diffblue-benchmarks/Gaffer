package uk.gov.gchq.gaffer.store.operation.handler.join.match;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.store.operation.handler.join.match.KeyFunctionMatch.Builder;
import uk.gov.gchq.koryphe.impl.function.Identity;

class KeyFunctionMatchDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#firstKeyFunction(Function)}
   *   <li>{@link Builder#secondKeyFunction(Function)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "KeyFunctionMatch Builder.build()",
    "Builder Builder.firstKeyFunction(Function)",
    "Builder Builder.secondKeyFunction(Function)"
  })
  void testBuilderBuild() {
    // Arrange
    Function firstKeyFunction = mock(Function.class);
    Function secondKeyFunction = mock(Function.class);

    // Act
    KeyFunctionMatch actualKeyFunctionMatch =
        new Builder()
            .firstKeyFunction(firstKeyFunction)
            .secondKeyFunction(secondKeyFunction)
            .build();

    // Assert
    assertSame(firstKeyFunction, actualKeyFunctionMatch.getFirstKeyFunction());
    assertSame(secondKeyFunction, actualKeyFunctionMatch.getSecondKeyFunction());
  }

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
    // Arrange, Act and Assert
    KeyFunctionMatch keyFunctionMatch = new Builder().build();
    Function firstKeyFunction = keyFunctionMatch.getFirstKeyFunction();
    assertTrue(firstKeyFunction instanceof Identity);
    Function secondKeyFunction = keyFunctionMatch.getSecondKeyFunction();
    assertTrue(secondKeyFunction instanceof Identity);
    assertEquals(firstKeyFunction, secondKeyFunction);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyFunctionMatch#KeyFunctionMatch(Function, Function)}
   *   <li>{@link KeyFunctionMatch#setFirstKeyFunction(Function)}
   *   <li>{@link KeyFunctionMatch#setSecondKeyFunction(Function)}
   *   <li>{@link KeyFunctionMatch#getFirstKeyFunction()}
   *   <li>{@link KeyFunctionMatch#getSecondKeyFunction()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void KeyFunctionMatch.<init>(Function, Function)",
    "Function KeyFunctionMatch.getFirstKeyFunction()",
    "Function KeyFunctionMatch.getSecondKeyFunction()",
    "void KeyFunctionMatch.setFirstKeyFunction(Function)",
    "void KeyFunctionMatch.setSecondKeyFunction(Function)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    KeyFunctionMatch actualKeyFunctionMatch =
        new KeyFunctionMatch(mock(Function.class), mock(Function.class));
    Function firstKeyFunction = mock(Function.class);
    actualKeyFunctionMatch.setFirstKeyFunction(firstKeyFunction);
    Function secondKeyFunction = mock(Function.class);
    actualKeyFunctionMatch.setSecondKeyFunction(secondKeyFunction);
    Function actualFirstKeyFunction = actualKeyFunctionMatch.getFirstKeyFunction();

    // Assert
    assertSame(firstKeyFunction, actualFirstKeyFunction);
    assertSame(secondKeyFunction, actualKeyFunctionMatch.getSecondKeyFunction());
  }

  /**
   * Test {@link KeyFunctionMatch#KeyFunctionMatch()}.
   *
   * <p>Method under test: {@link KeyFunctionMatch#KeyFunctionMatch()}
   */
  @Test
  @DisplayName("Test new KeyFunctionMatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeyFunctionMatch.<init>()"})
  void testNewKeyFunctionMatch() {
    // Arrange and Act
    KeyFunctionMatch actualKeyFunctionMatch = new KeyFunctionMatch();

    // Assert
    Function firstKeyFunction = actualKeyFunctionMatch.getFirstKeyFunction();
    assertTrue(firstKeyFunction instanceof Identity);
    Function secondKeyFunction = actualKeyFunctionMatch.getSecondKeyFunction();
    assertTrue(secondKeyFunction instanceof Identity);
    assertEquals(firstKeyFunction, secondKeyFunction);
  }

  /**
   * Test {@link KeyFunctionMatch#init(Iterable)}.
   *
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KeyFunctionMatch#init(Iterable)}
   */
  @Test
  @DisplayName(
      "Test init(Iterable); given Function apply(Object) throw IllegalArgumentException(); then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeyFunctionMatch.init(Iterable)"})
  void testInit_givenFunctionApplyThrowIllegalArgumentException_thenCallsApply() {
    // Arrange
    Function secondKeyFunction = mock(Function.class);
    when(secondKeyFunction.apply(Mockito.<Object>any())).thenThrow(new IllegalArgumentException());
    KeyFunctionMatch keyFunctionMatch =
        new Builder()
            .firstKeyFunction(mock(Function.class))
            .secondKeyFunction(secondKeyFunction)
            .build();

    ArrayList<Object> matchCandidates = new ArrayList<>();
    matchCandidates.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> keyFunctionMatch.init(matchCandidates));
    verify(secondKeyFunction).apply(isA(Object.class));
  }

  /**
   * Test {@link KeyFunctionMatch#init(Iterable)}.
   *
   * <ul>
   *   <li>Given {@link KeyFunctionMatch#KeyFunctionMatch()}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link KeyFunctionMatch#init(Iterable)}
   */
  @Test
  @DisplayName(
      "Test init(Iterable); given KeyFunctionMatch(); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeyFunctionMatch.init(Iterable)"})
  void testInit_givenKeyFunctionMatch_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new KeyFunctionMatch().init(null));
  }

  /**
   * Test {@link KeyFunctionMatch#matching(Object)}.
   *
   * <p>Method under test: {@link KeyFunctionMatch#matching(Object)}
   */
  @Test
  @DisplayName("Test matching(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List KeyFunctionMatch.matching(Object)"})
  void testMatching() {
    // Arrange
    KeyFunctionMatch keyFunctionMatch = new KeyFunctionMatch(mock(Function.class), null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> keyFunctionMatch.matching("Test Object"));
  }

  /**
   * Test {@link KeyFunctionMatch#matching(Object)}.
   *
   * <p>Method under test: {@link KeyFunctionMatch#matching(Object)}
   */
  @Test
  @DisplayName("Test matching(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List KeyFunctionMatch.matching(Object)"})
  void testMatching2() {
    // Arrange
    KeyFunctionMatch keyFunctionMatch = new KeyFunctionMatch(null, null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> keyFunctionMatch.matching("Test Object"));
  }

  /**
   * Test {@link KeyFunctionMatch#matching(Object)}.
   *
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KeyFunctionMatch#matching(Object)}
   */
  @Test
  @DisplayName(
      "Test matching(Object); given Function apply(Object) throw IllegalArgumentException(); then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List KeyFunctionMatch.matching(Object)"})
  void testMatching_givenFunctionApplyThrowIllegalArgumentException_thenCallsApply() {
    // Arrange
    Function firstKeyFunction = mock(Function.class);
    when(firstKeyFunction.apply(Mockito.<Object>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new Builder()
                .firstKeyFunction(firstKeyFunction)
                .secondKeyFunction(mock(Function.class))
                .build()
                .matching("Test Object"));
    verify(firstKeyFunction).apply(isA(Object.class));
  }

  /**
   * Test {@link KeyFunctionMatch#matching(Object)}.
   *
   * <ul>
   *   <li>Given {@link KeyFunctionMatch#KeyFunctionMatch()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link KeyFunctionMatch#matching(Object)}
   */
  @Test
  @DisplayName("Test matching(Object); given KeyFunctionMatch(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List KeyFunctionMatch.matching(Object)"})
  void testMatching_givenKeyFunctionMatch_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new KeyFunctionMatch().matching("Test Object").isEmpty());
  }

  /**
   * Test {@link KeyFunctionMatch#equals(Object)}, and {@link KeyFunctionMatch#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyFunctionMatch#equals(Object)}
   *   <li>{@link KeyFunctionMatch#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KeyFunctionMatch.equals(Object)", "int KeyFunctionMatch.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KeyFunctionMatch keyFunctionMatch =
        new Builder()
            .firstKeyFunction(mock(Function.class))
            .secondKeyFunction(mock(Function.class))
            .build();

    // Act and Assert
    assertEquals(keyFunctionMatch, keyFunctionMatch);
    int expectedHashCodeResult = keyFunctionMatch.hashCode();
    assertEquals(expectedHashCodeResult, keyFunctionMatch.hashCode());
  }

  /**
   * Test {@link KeyFunctionMatch#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyFunctionMatch#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KeyFunctionMatch.equals(Object)", "int KeyFunctionMatch.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KeyFunctionMatch keyFunctionMatch =
        new Builder()
            .firstKeyFunction(mock(Function.class))
            .secondKeyFunction(mock(Function.class))
            .build();

    // Act and Assert
    assertNotEquals(
        keyFunctionMatch,
        new Builder()
            .firstKeyFunction(mock(Function.class))
            .secondKeyFunction(mock(Function.class))
            .build());
  }

  /**
   * Test {@link KeyFunctionMatch#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyFunctionMatch#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KeyFunctionMatch.equals(Object)", "int KeyFunctionMatch.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder()
            .firstKeyFunction(mock(Function.class))
            .secondKeyFunction(mock(Function.class))
            .build(),
        null);
  }

  /**
   * Test {@link KeyFunctionMatch#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KeyFunctionMatch#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean KeyFunctionMatch.equals(Object)", "int KeyFunctionMatch.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder()
            .firstKeyFunction(mock(Function.class))
            .secondKeyFunction(mock(Function.class))
            .build(),
        "Different type to KeyFunctionMatch");
  }
}
