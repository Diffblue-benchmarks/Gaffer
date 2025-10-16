package uk.gov.gchq.gaffer.proxystore.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.proxystore.operation.GetProxyUrl.Builder;

class GetProxyUrlDiffblueTest {
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
    GetProxyUrl _getOpResult = actualBuilder._getOp();
    TypeReference<String> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.String);
    assertTrue(_getOpResult.getOptions().isEmpty());
    Class<String> expectedOutputClass = String.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    GetProxyUrl actualGetProxyUrl = actualBuilder.build();
    assertSame(_getOpResult, actualGetProxyUrl);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test {@link GetProxyUrl#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetProxyUrl#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetProxyUrl.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue(new GetProxyUrl().getOutputTypeReference() instanceof TypeReferenceImpl.String);
  }

  /**
   * Test {@link GetProxyUrl#shallowClone()}.
   *
   * <p>Method under test: {@link GetProxyUrl#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetProxyUrl GetProxyUrl.shallowClone()"})
  void testShallowClone() throws CloneFailedException {
    // Arrange
    GetProxyUrl getProxyUrl = new GetProxyUrl();

    // Act
    GetProxyUrl actualShallowCloneResult = getProxyUrl.shallowClone();

    // Assert
    assertEquals(getProxyUrl, actualShallowCloneResult);
  }

  /**
   * Test {@link GetProxyUrl#equals(Object)}, and {@link GetProxyUrl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GetProxyUrl#equals(Object)}
   *   <li>{@link GetProxyUrl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GetProxyUrl.equals(Object)", "int GetProxyUrl.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GetProxyUrl getProxyUrl = new GetProxyUrl();
    GetProxyUrl getProxyUrl2 = new GetProxyUrl();

    // Act and Assert
    assertEquals(getProxyUrl, getProxyUrl2);
    assertEquals(getProxyUrl.hashCode(), getProxyUrl2.hashCode());
  }

  /**
   * Test {@link GetProxyUrl#equals(Object)}, and {@link GetProxyUrl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GetProxyUrl#equals(Object)}
   *   <li>{@link GetProxyUrl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GetProxyUrl.equals(Object)", "int GetProxyUrl.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GetProxyUrl getProxyUrl = new GetProxyUrl();

    // Act and Assert
    assertEquals(getProxyUrl, getProxyUrl);
    int expectedHashCodeResult = getProxyUrl.hashCode();
    assertEquals(expectedHashCodeResult, getProxyUrl.hashCode());
  }

  /**
   * Test {@link GetProxyUrl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GetProxyUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GetProxyUrl.equals(Object)", "int GetProxyUrl.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GetProxyUrl getProxyUrl = new GetProxyUrl();
    getProxyUrl.addOption("https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertNotEquals(getProxyUrl, new GetProxyUrl());
  }

  /**
   * Test {@link GetProxyUrl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GetProxyUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GetProxyUrl.equals(Object)", "int GetProxyUrl.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GetProxyUrl(), null);
  }

  /**
   * Test {@link GetProxyUrl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GetProxyUrl#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GetProxyUrl.equals(Object)", "int GetProxyUrl.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GetProxyUrl(), "Different type to GetProxyUrl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetProxyUrl}
   *   <li>{@link GetProxyUrl#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetProxyUrl.<init>()", "java.util.Map GetProxyUrl.getOptions()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new GetProxyUrl().getOptions().isEmpty());
  }
}
