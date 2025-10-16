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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.ValidateOperationChain.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.koryphe.ValidationResult;

class ValidateOperationChainDiffblueTest {
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
    ValidateOperationChain _getOpResult = actualBuilder._getOp();
    TypeReference<ValidationResult> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.ValidationResult);
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getOperationChain());
    Class<ValidationResult> expectedOutputClass = ValidationResult.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    ValidateOperationChain actualValidateOperationChain = actualBuilder.build();
    assertSame(_getOpResult, actualValidateOperationChain);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test Builder {@link Builder#operationChain(OperationChain)}.
   *
   * <p>Method under test: {@link Builder#operationChain(OperationChain)}
   */
  @Test
  @DisplayName("Test Builder operationChain(OperationChain)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operationChain(OperationChain)"})
  void testBuilderOperationChain() {
    // Arrange
    Builder builder = new Builder();
    OperationChain<?> opChain = OperationChain.wrap(new AddNamedOperation());

    // Act
    Builder actualOperationChainResult = builder.operationChain(opChain);

    // Assert
    assertSame(builder, actualOperationChainResult);
  }

  /**
   * Test {@link ValidateOperationChain#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ValidateOperationChain#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference ValidateOperationChain.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue(
        new ValidateOperationChain().getOutputTypeReference()
            instanceof TypeReferenceImpl.ValidationResult);
  }

  /**
   * Test {@link ValidateOperationChain#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ValidateOperationChain} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateOperationChain#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ValidateOperationChain (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidateOperationChain ValidateOperationChain.shallowClone()"})
  void testShallowClone_givenValidateOperationChain_thenReturnOptionsIsNull() {
    // Arrange and Act
    ValidateOperationChain actualShallowCloneResult = new ValidateOperationChain().shallowClone();

    // Assert
    TypeReference<ValidationResult> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.ValidationResult);
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getOperationChain());
    Class<ValidationResult> expectedOutputClass = ValidationResult.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link ValidateOperationChain#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ValidateOperationChain#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidateOperationChain ValidateOperationChain.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    ValidateOperationChain validateOperationChain = new ValidateOperationChain();
    validateOperationChain.setOptions(new HashMap<>());

    // Act
    ValidateOperationChain actualShallowCloneResult = validateOperationChain.shallowClone();

    // Assert
    TypeReference<ValidationResult> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.ValidationResult);
    assertNull(actualShallowCloneResult.getOperationChain());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<ValidationResult> expectedOutputClass = ValidationResult.class;
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
   *   <li>default or parameterless constructor of {@link ValidateOperationChain}
   *   <li>{@link ValidateOperationChain#setOptions(Map)}
   *   <li>{@link ValidateOperationChain#getOperationChain()}
   *   <li>{@link ValidateOperationChain#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateOperationChain.<init>()",
    "OperationChain ValidateOperationChain.getOperationChain()",
    "Map ValidateOperationChain.getOptions()",
    "void ValidateOperationChain.setOperationChain(OperationChain)",
    "void ValidateOperationChain.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ValidateOperationChain actualValidateOperationChain = new ValidateOperationChain();
    HashMap<String, String> options = new HashMap<>();
    actualValidateOperationChain.setOptions(options);
    OperationChain actualOperationChain = actualValidateOperationChain.getOperationChain();
    Map<String, String> actualOptions = actualValidateOperationChain.getOptions();

    // Assert
    assertNull(actualOperationChain);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
