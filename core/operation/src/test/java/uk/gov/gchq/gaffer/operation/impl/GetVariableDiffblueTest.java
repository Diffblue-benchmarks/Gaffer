package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.GetVariable.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GetVariableDiffblueTest {
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
    Builder actualBuilder = new Builder();

    // Assert
    GetVariable _getOpResult = actualBuilder._getOp();
    TypeReference<Object> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getVariableName());
    assertNull(_getOpResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    GetVariable actualGetVariable = actualBuilder.build();
    assertSame(_getOpResult, actualGetVariable);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test Builder {@link Builder#variableName(String)}.
   *
   * <p>Method under test: {@link Builder#variableName(String)}
   */
  @Test
  @DisplayName("Test Builder variableName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.variableName(String)"})
  void testBuilderVariableName() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualVariableNameResult = builder.variableName("Variable Name");

    // Assert
    assertSame(builder, actualVariableNameResult);
  }

  /**
   * Test {@link GetVariable#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetVariable#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetVariable.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue(new GetVariable().getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test {@link GetVariable#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetVariable} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetVariable#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetVariable (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetVariable GetVariable.shallowClone()"})
  void testShallowClone_givenGetVariableOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    GetVariable getVariable = new GetVariable();
    getVariable.setOptions(new HashMap<>());

    // Act
    GetVariable actualShallowCloneResult = getVariable.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getVariableName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link GetVariable#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetVariable} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetVariable#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetVariable (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetVariable GetVariable.shallowClone()"})
  void testShallowClone_givenGetVariable_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    GetVariable actualShallowCloneResult = new GetVariable().shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertNull(actualShallowCloneResult.getVariableName());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetVariable}
   *   <li>{@link GetVariable#setOptions(Map)}
   *   <li>{@link GetVariable#setVariableName(String)}
   *   <li>{@link GetVariable#getOptions()}
   *   <li>{@link GetVariable#getVariableName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetVariable.<init>()",
    "Map GetVariable.getOptions()",
    "String GetVariable.getVariableName()",
    "void GetVariable.setOptions(Map)",
    "void GetVariable.setVariableName(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetVariable actualGetVariable = new GetVariable();
    HashMap<String, String> options = new HashMap<>();
    actualGetVariable.setOptions(options);
    actualGetVariable.setVariableName("Variable Name");
    Map<String, String> actualOptions = actualGetVariable.getOptions();

    // Assert
    assertEquals("Variable Name", actualGetVariable.getVariableName());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
