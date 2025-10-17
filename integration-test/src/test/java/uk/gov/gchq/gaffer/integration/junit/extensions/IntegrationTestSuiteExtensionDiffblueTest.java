/*
 * Copyright 2025 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.integration.junit.extensions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.engine.execution.DefaultTestInstances;
import org.mockito.Mockito;

class IntegrationTestSuiteExtensionDiffblueTest {
  /**
   * Test {@link IntegrationTestSuiteExtension#beforeAll(ExtensionContext)}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationTestSuiteExtension#beforeAll(ExtensionContext)}
   */
  @Test
  @DisplayName("Test beforeAll(ExtensionContext); given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationTestSuiteExtension.beforeAll(ExtensionContext)"})
  void testBeforeAll_givenEmpty() {
    // Arrange
    IntegrationTestSuiteExtension integrationTestSuiteExtension =
        new IntegrationTestSuiteExtension();

    ExtensionContext extensionContext = mock(ExtensionContext.class);
    Optional<String> emptyResult = Optional.empty();
    when(extensionContext.getConfigurationParameter(Mockito.<String>any())).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> integrationTestSuiteExtension.beforeAll(extensionContext));
    verify(extensionContext).getConfigurationParameter("initClass");
  }

  /**
   * Test {@link IntegrationTestSuiteExtension#beforeAll(ExtensionContext)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationTestSuiteExtension#beforeAll(ExtensionContext)}
   */
  @Test
  @DisplayName("Test beforeAll(ExtensionContext); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationTestSuiteExtension.beforeAll(ExtensionContext)"})
  void testBeforeAll_givenIllegalArgumentException() {
    // Arrange
    IntegrationTestSuiteExtension integrationTestSuiteExtension =
        new IntegrationTestSuiteExtension();

    ExtensionContext extensionContext = mock(ExtensionContext.class);
    when(extensionContext.getConfigurationParameter(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> integrationTestSuiteExtension.beforeAll(extensionContext));
    verify(extensionContext).getConfigurationParameter("initClass");
  }

  /**
   * Test {@link IntegrationTestSuiteExtension#beforeAll(ExtensionContext)}.
   *
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationTestSuiteExtension#beforeAll(ExtensionContext)}
   */
  @Test
  @DisplayName("Test beforeAll(ExtensionContext); given Optional with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationTestSuiteExtension.beforeAll(ExtensionContext)"})
  void testBeforeAll_givenOptionalWithFoo() {
    // Arrange
    IntegrationTestSuiteExtension integrationTestSuiteExtension =
        new IntegrationTestSuiteExtension();

    ExtensionContext extensionContext = mock(ExtensionContext.class);
    Optional<String> ofResult = Optional.of("foo");
    when(extensionContext.getConfigurationParameter(Mockito.<String>any())).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        ParameterResolutionException.class,
        () -> integrationTestSuiteExtension.beforeAll(extensionContext));
    verify(extensionContext).getConfigurationParameter("initClass");
  }

  /**
   * Test {@link IntegrationTestSuiteExtension#beforeAll(ExtensionContext)}.
   *
   * <ul>
   *   <li>Given {@link Optional} with {@code [[[Lxxx;}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationTestSuiteExtension#beforeAll(ExtensionContext)}
   */
  @Test
  @DisplayName("Test beforeAll(ExtensionContext); given Optional with '[[[Lxxx;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationTestSuiteExtension.beforeAll(ExtensionContext)"})
  void testBeforeAll_givenOptionalWithLxxx() {
    // Arrange
    IntegrationTestSuiteExtension integrationTestSuiteExtension =
        new IntegrationTestSuiteExtension();

    ExtensionContext extensionContext = mock(ExtensionContext.class);
    Optional<String> ofResult = Optional.of("[[[Lxxx;");
    when(extensionContext.getConfigurationParameter(Mockito.<String>any())).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        ParameterResolutionException.class,
        () -> integrationTestSuiteExtension.beforeAll(extensionContext));
    verify(extensionContext).getConfigurationParameter("initClass");
  }

  /**
   * Test {@link IntegrationTestSuiteExtension#beforeAll(ExtensionContext)}.
   *
   * <ul>
   *   <li>Given {@link Optional} with {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationTestSuiteExtension#beforeAll(ExtensionContext)}
   */
  @Test
  @DisplayName("Test beforeAll(ExtensionContext); given Optional with 'not blank'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationTestSuiteExtension.beforeAll(ExtensionContext)"})
  void testBeforeAll_givenOptionalWithNotBlank() {
    // Arrange
    IntegrationTestSuiteExtension integrationTestSuiteExtension =
        new IntegrationTestSuiteExtension();

    ExtensionContext extensionContext = mock(ExtensionContext.class);
    Optional<String> ofResult = Optional.of("not blank");
    when(extensionContext.getConfigurationParameter(Mockito.<String>any())).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        ParameterResolutionException.class,
        () -> integrationTestSuiteExtension.beforeAll(extensionContext));
    verify(extensionContext).getConfigurationParameter("initClass");
  }

  /**
   * Test {@link IntegrationTestSuiteExtension#beforeEach(ExtensionContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link DefaultTestInstances#getAllInstances()}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationTestSuiteExtension#beforeEach(ExtensionContext)}
   */
  @Test
  @DisplayName(
      "Test beforeEach(ExtensionContext); given ArrayList() add '42'; then calls getAllInstances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationTestSuiteExtension.beforeEach(ExtensionContext)"})
  void testBeforeEach_givenArrayListAdd42_thenCallsGetAllInstances() {
    // Arrange
    IntegrationTestSuiteExtension integrationTestSuiteExtension =
        new IntegrationTestSuiteExtension();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    DefaultTestInstances defaultTestInstances = mock(DefaultTestInstances.class);
    when(defaultTestInstances.getAllInstances()).thenReturn(objectList);

    ExtensionContext context = mock(ExtensionContext.class);
    when(context.getRequiredTestInstances()).thenReturn(defaultTestInstances);

    // Act
    integrationTestSuiteExtension.beforeEach(context);

    // Assert
    verify(context).getRequiredTestInstances();
    verify(defaultTestInstances).getAllInstances();
  }

  /**
   * Test {@link IntegrationTestSuiteExtension#beforeEach(ExtensionContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link DefaultTestInstances#getAllInstances()}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationTestSuiteExtension#beforeEach(ExtensionContext)}
   */
  @Test
  @DisplayName(
      "Test beforeEach(ExtensionContext); given ArrayList() add '42'; then calls getAllInstances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationTestSuiteExtension.beforeEach(ExtensionContext)"})
  void testBeforeEach_givenArrayListAdd42_thenCallsGetAllInstances2() {
    // Arrange
    IntegrationTestSuiteExtension integrationTestSuiteExtension =
        new IntegrationTestSuiteExtension();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");

    DefaultTestInstances defaultTestInstances = mock(DefaultTestInstances.class);
    when(defaultTestInstances.getAllInstances()).thenReturn(objectList);

    ExtensionContext context = mock(ExtensionContext.class);
    when(context.getRequiredTestInstances()).thenReturn(defaultTestInstances);

    // Act
    integrationTestSuiteExtension.beforeEach(context);

    // Assert
    verify(context).getRequiredTestInstances();
    verify(defaultTestInstances).getAllInstances();
  }

  /**
   * Test {@link IntegrationTestSuiteExtension#beforeEach(ExtensionContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then calls {@link DefaultTestInstances#getAllInstances()}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationTestSuiteExtension#beforeEach(ExtensionContext)}
   */
  @Test
  @DisplayName(
      "Test beforeEach(ExtensionContext); given ArrayList() add two; then calls getAllInstances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationTestSuiteExtension.beforeEach(ExtensionContext)"})
  void testBeforeEach_givenArrayListAddTwo_thenCallsGetAllInstances() {
    // Arrange
    IntegrationTestSuiteExtension integrationTestSuiteExtension =
        new IntegrationTestSuiteExtension();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add(2);

    DefaultTestInstances defaultTestInstances = mock(DefaultTestInstances.class);
    when(defaultTestInstances.getAllInstances()).thenReturn(objectList);

    ExtensionContext context = mock(ExtensionContext.class);
    when(context.getRequiredTestInstances()).thenReturn(defaultTestInstances);

    // Act
    integrationTestSuiteExtension.beforeEach(context);

    // Assert
    verify(context).getRequiredTestInstances();
    verify(defaultTestInstances).getAllInstances();
  }

  /**
   * Test {@link IntegrationTestSuiteExtension#beforeEach(ExtensionContext)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultTestInstances#getAllInstances()}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationTestSuiteExtension#beforeEach(ExtensionContext)}
   */
  @Test
  @DisplayName("Test beforeEach(ExtensionContext); then calls getAllInstances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegrationTestSuiteExtension.beforeEach(ExtensionContext)"})
  void testBeforeEach_thenCallsGetAllInstances() {
    // Arrange
    IntegrationTestSuiteExtension integrationTestSuiteExtension =
        new IntegrationTestSuiteExtension();

    DefaultTestInstances defaultTestInstances = mock(DefaultTestInstances.class);
    when(defaultTestInstances.getAllInstances()).thenReturn(new ArrayList<>());

    ExtensionContext context = mock(ExtensionContext.class);
    when(context.getRequiredTestInstances()).thenReturn(defaultTestInstances);

    // Act
    integrationTestSuiteExtension.beforeEach(context);

    // Assert
    verify(context).getRequiredTestInstances();
    verify(defaultTestInstances).getAllInstances();
  }

  /**
   * Test {@link IntegrationTestSuiteExtension#supportsParameter(ParameterContext,
   * ExtensionContext)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationTestSuiteExtension#supportsParameter(ParameterContext,
   * ExtensionContext)}
   */
  @Test
  @DisplayName(
      "Test supportsParameter(ParameterContext, ExtensionContext); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IntegrationTestSuiteExtension.supportsParameter(ParameterContext, ExtensionContext)"
  })
  void testSupportsParameter_thenThrowIllegalArgumentException() {
    // Arrange
    IntegrationTestSuiteExtension integrationTestSuiteExtension =
        new IntegrationTestSuiteExtension();

    ParameterContext parameterContext = mock(ParameterContext.class);
    when(parameterContext.getParameter()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            integrationTestSuiteExtension.supportsParameter(
                parameterContext, mock(ExtensionContext.class)));
    verify(parameterContext).getParameter();
  }

  /**
   * Test {@link IntegrationTestSuiteExtension#resolveParameter(ParameterContext,
   * ExtensionContext)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link IntegrationTestSuiteExtension#resolveParameter(ParameterContext,
   * ExtensionContext)}
   */
  @Test
  @DisplayName(
      "Test resolveParameter(ParameterContext, ExtensionContext); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object IntegrationTestSuiteExtension.resolveParameter(ParameterContext, ExtensionContext)"
  })
  void testResolveParameter_thenThrowIllegalArgumentException()
      throws ParameterResolutionException {
    // Arrange
    IntegrationTestSuiteExtension integrationTestSuiteExtension =
        new IntegrationTestSuiteExtension();

    ParameterContext parameterContext = mock(ParameterContext.class);
    when(parameterContext.getParameter()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            integrationTestSuiteExtension.resolveParameter(
                parameterContext, mock(ExtensionContext.class)));
    verify(parameterContext).getParameter();
  }

  /**
   * Test {@link IntegrationTestSuiteExtension#evaluateExecutionCondition(ExtensionContext)}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return Reason is {@code Test enabled}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IntegrationTestSuiteExtension#evaluateExecutionCondition(ExtensionContext)}
   */
  @Test
  @DisplayName(
      "Test evaluateExecutionCondition(ExtensionContext); given empty; then return Reason is 'Test enabled'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConditionEvaluationResult IntegrationTestSuiteExtension.evaluateExecutionCondition(ExtensionContext)"
  })
  void testEvaluateExecutionCondition_givenEmpty_thenReturnReasonIsTestEnabled() {
    // Arrange
    IntegrationTestSuiteExtension integrationTestSuiteExtension =
        new IntegrationTestSuiteExtension();

    ExtensionContext context = mock(ExtensionContext.class);
    Optional<Method> emptyResult = Optional.empty();
    when(context.getTestMethod()).thenReturn(emptyResult);

    // Act
    ConditionEvaluationResult actualEvaluateExecutionConditionResult =
        integrationTestSuiteExtension.evaluateExecutionCondition(context);

    // Assert
    verify(context).getTestMethod();
    Optional<String> reason = actualEvaluateExecutionConditionResult.getReason();
    assertEquals("Test enabled", reason.get());
    assertFalse(actualEvaluateExecutionConditionResult.isDisabled());
    assertTrue(reason.isPresent());
  }

  /**
   * Test {@link IntegrationTestSuiteExtension#evaluateExecutionCondition(ExtensionContext)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IntegrationTestSuiteExtension#evaluateExecutionCondition(ExtensionContext)}
   */
  @Test
  @DisplayName(
      "Test evaluateExecutionCondition(ExtensionContext); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConditionEvaluationResult IntegrationTestSuiteExtension.evaluateExecutionCondition(ExtensionContext)"
  })
  void testEvaluateExecutionCondition_thenThrowIllegalArgumentException() {
    // Arrange
    IntegrationTestSuiteExtension integrationTestSuiteExtension =
        new IntegrationTestSuiteExtension();

    ExtensionContext context = mock(ExtensionContext.class);
    when(context.getTestMethod()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> integrationTestSuiteExtension.evaluateExecutionCondition(context));
    verify(context).getTestMethod();
  }
}
