package uk.gov.gchq.gaffer.proxystore.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.MapStringObject;
import uk.gov.gchq.gaffer.proxystore.operation.GetProxyProperties.Builder;

class GetProxyPropertiesDiffblueTest {
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
    GetProxyProperties _getOpResult = actualBuilder._getOp();
    TypeReference<Map<String, Object>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof MapStringObject);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>", outputType.getTypeName());
    assertTrue(_getOpResult.getOptions().isEmpty());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetProxyProperties actualGetProxyProperties = actualBuilder.build();
    assertSame(_getOpResult, actualGetProxyProperties);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetProxyProperties#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetProxyProperties#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetProxyProperties.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Map<String, Object>> actualOutputTypeReference =
        new GetProxyProperties().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof MapStringObject);
    assertEquals(
        "java.util.Map<java.lang.String, java.lang.Object>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetProxyProperties#shallowClone()}.
   *
   * <p>Method under test: {@link GetProxyProperties#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation GetProxyProperties.shallowClone()"})
  void testShallowClone() throws CloneFailedException {
    // Arrange
    GetProxyProperties getProxyProperties = new GetProxyProperties();

    // Act
    Operation actualShallowCloneResult = getProxyProperties.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof GetProxyProperties);
    assertEquals(getProxyProperties, actualShallowCloneResult);
  }

  /**
   * Test {@link GetProxyProperties#equals(Object)}, and {@link GetProxyProperties#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GetProxyProperties#equals(Object)}
   *   <li>{@link GetProxyProperties#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GetProxyProperties.equals(Object)",
    "int GetProxyProperties.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GetProxyProperties getProxyProperties = new GetProxyProperties();
    GetProxyProperties getProxyProperties2 = new GetProxyProperties();

    // Act and Assert
    assertEquals(getProxyProperties, getProxyProperties2);
    assertEquals(getProxyProperties.hashCode(), getProxyProperties2.hashCode());
  }

  /**
   * Test {@link GetProxyProperties#equals(Object)}, and {@link GetProxyProperties#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GetProxyProperties#equals(Object)}
   *   <li>{@link GetProxyProperties#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GetProxyProperties.equals(Object)",
    "int GetProxyProperties.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GetProxyProperties getProxyProperties = new GetProxyProperties();

    // Act and Assert
    assertEquals(getProxyProperties, getProxyProperties);
    int expectedHashCodeResult = getProxyProperties.hashCode();
    assertEquals(expectedHashCodeResult, getProxyProperties.hashCode());
  }

  /**
   * Test {@link GetProxyProperties#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GetProxyProperties#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GetProxyProperties.equals(Object)",
    "int GetProxyProperties.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GetProxyProperties getProxyProperties = new GetProxyProperties();
    getProxyProperties.addOption("Name", "42");

    // Act and Assert
    assertNotEquals(getProxyProperties, new GetProxyProperties());
  }

  /**
   * Test {@link GetProxyProperties#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GetProxyProperties#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GetProxyProperties.equals(Object)",
    "int GetProxyProperties.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GetProxyProperties(), null);
  }

  /**
   * Test {@link GetProxyProperties#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GetProxyProperties#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GetProxyProperties.equals(Object)",
    "int GetProxyProperties.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GetProxyProperties(), "Different type to GetProxyProperties");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetProxyProperties}
   *   <li>{@link GetProxyProperties#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetProxyProperties.<init>()", "Map GetProxyProperties.getOptions()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new GetProxyProperties().getOptions().isEmpty());
  }
}
