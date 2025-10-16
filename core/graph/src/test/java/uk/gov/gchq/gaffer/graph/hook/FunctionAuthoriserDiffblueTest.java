package uk.gov.gchq.gaffer.graph.hook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FunctionAuthoriserDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FunctionAuthoriser#FunctionAuthoriser()}
   *   <li>{@link FunctionAuthoriser#setUnauthorisedFunctions(List)}
   *   <li>{@link FunctionAuthoriser#getUnauthorisedFunctions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FunctionAuthoriser.<init>()",
    "List FunctionAuthoriser.getUnauthorisedFunctions()",
    "void FunctionAuthoriser.setUnauthorisedFunctions(List)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    FunctionAuthoriser actualFunctionAuthoriser = new FunctionAuthoriser();
    ArrayList<Class<? extends Function>> unauthorisedFunctions = new ArrayList<>();
    actualFunctionAuthoriser.setUnauthorisedFunctions(unauthorisedFunctions);
    List<Class<? extends Function>> actualUnauthorisedFunctions =
        actualFunctionAuthoriser.getUnauthorisedFunctions();

    // Assert
    assertTrue(actualUnauthorisedFunctions.isEmpty());
    assertSame(unauthorisedFunctions, actualUnauthorisedFunctions);
  }

  /**
   * Test {@link FunctionAuthoriser#FunctionAuthoriser(List)}.
   *
   * <ul>
   *   <li>Then return UnauthorisedFunctions is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionAuthoriser#FunctionAuthoriser(List)}
   */
  @Test
  @DisplayName(
      "Test new FunctionAuthoriser(List); then return UnauthorisedFunctions is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FunctionAuthoriser.<init>(List)"})
  void testNewFunctionAuthoriser_thenReturnUnauthorisedFunctionsIsArrayList() {
    // Arrange
    ArrayList<Class<? extends Function>> unauthorisedFunctions = new ArrayList<>();
    Class<Function> forNameResult = Function.class;
    unauthorisedFunctions.add(forNameResult);
    Class<Function> forNameResult2 = Function.class;
    unauthorisedFunctions.add(forNameResult2);

    // Act and Assert
    assertSame(
        unauthorisedFunctions,
        new FunctionAuthoriser(unauthorisedFunctions).getUnauthorisedFunctions());
  }

  /**
   * Test {@link FunctionAuthoriser#FunctionAuthoriser(List)}.
   *
   * <ul>
   *   <li>Then return UnauthorisedFunctions size is one.
   * </ul>
   *
   * <p>Method under test: {@link FunctionAuthoriser#FunctionAuthoriser(List)}
   */
  @Test
  @DisplayName("Test new FunctionAuthoriser(List); then return UnauthorisedFunctions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FunctionAuthoriser.<init>(List)"})
  void testNewFunctionAuthoriser_thenReturnUnauthorisedFunctionsSizeIsOne() {
    // Arrange
    ArrayList<Class<? extends Function>> unauthorisedFunctions = new ArrayList<>();
    Class<Function> forNameResult = Function.class;
    unauthorisedFunctions.add(forNameResult);

    // Act and Assert
    List<Class<? extends Function>> unauthorisedFunctions2 =
        new FunctionAuthoriser(unauthorisedFunctions).getUnauthorisedFunctions();
    assertEquals(1, unauthorisedFunctions2.size());
    Class<Function> expectedGetResult = Function.class;
    assertEquals(expectedGetResult, unauthorisedFunctions2.get(0));
    assertSame(unauthorisedFunctions, unauthorisedFunctions2);
  }

  /**
   * Test {@link FunctionAuthoriser#FunctionAuthoriser(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return UnauthorisedFunctions Empty.
   * </ul>
   *
   * <p>Method under test: {@link FunctionAuthoriser#FunctionAuthoriser(List)}
   */
  @Test
  @DisplayName(
      "Test new FunctionAuthoriser(List); when ArrayList(); then return UnauthorisedFunctions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FunctionAuthoriser.<init>(List)"})
  void testNewFunctionAuthoriser_whenArrayList_thenReturnUnauthorisedFunctionsEmpty() {
    // Arrange, Act and Assert
    assertTrue(new FunctionAuthoriser(new ArrayList<>()).getUnauthorisedFunctions().isEmpty());
  }
}
