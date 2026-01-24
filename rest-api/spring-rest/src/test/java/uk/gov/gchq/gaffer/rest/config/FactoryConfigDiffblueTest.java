/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.rest.config;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.web.context.support.StandardServletEnvironment;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.get.GetAllElements;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;
import uk.gov.gchq.gaffer.rest.factory.DefaultExamplesFactory;
import uk.gov.gchq.gaffer.rest.factory.DefaultGraphFactory;
import uk.gov.gchq.gaffer.rest.factory.ExamplesFactory;
import uk.gov.gchq.gaffer.rest.factory.GraphFactory;
import uk.gov.gchq.gaffer.rest.factory.spring.UnknownUserFactory;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class FactoryConfigDiffblueTest {
  /**
   * Test {@link FactoryConfig#setToSystemProperties()}.
   *
   * <p>Method under test: {@link FactoryConfig#setToSystemProperties()}
   */
  @Test
  @DisplayName("Test setToSystemProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FactoryConfig.setToSystemProperties()"})
  void testSetToSystemProperties() {
    // Arrange
    FactoryConfig factoryConfig = new FactoryConfig();
    factoryConfig.setEnvironment(new StandardReactiveWebEnvironment());

    // Act and Assert
    assertDoesNotThrow(() -> factoryConfig.setToSystemProperties());
  }

  /**
   * Test {@link FactoryConfig#setToSystemProperties()}.
   *
   * <p>Method under test: {@link FactoryConfig#setToSystemProperties()}
   */
  @Test
  @DisplayName("Test setToSystemProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FactoryConfig.setToSystemProperties()"})
  void testSetToSystemProperties2() {
    // Arrange
    FactoryConfig factoryConfig = new FactoryConfig();
    factoryConfig.setEnvironment(new StandardServletEnvironment());

    // Act and Assert
    assertDoesNotThrow(() -> factoryConfig.setToSystemProperties());
  }

  /**
   * Test {@link FactoryConfig#setToSystemProperties()}.
   *
   * <p>Method under test: {@link FactoryConfig#setToSystemProperties()}
   */
  @Test
  @DisplayName("Test setToSystemProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FactoryConfig.setToSystemProperties()"})
  void testSetToSystemProperties3() {
    // Arrange
    StandardEnvironment environment = mock(StandardEnvironment.class);
    when(environment.getPropertySources()).thenReturn(new MutablePropertySources());

    FactoryConfig factoryConfig = new FactoryConfig();
    factoryConfig.setEnvironment(environment);

    // Act
    factoryConfig.setToSystemProperties();

    // Assert
    verify(environment).getPropertySources();
  }

  /**
   * Test {@link FactoryConfig#setToSystemProperties()}.
   *
   * <ul>
   *   <li>Given {@link FactoryConfig} (default constructor) Environment is {@link MockEnvironment}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FactoryConfig#setToSystemProperties()}
   */
  @Test
  @DisplayName(
      "Test setToSystemProperties(); given FactoryConfig (default constructor) Environment is MockEnvironment (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FactoryConfig.setToSystemProperties()"})
  void testSetToSystemProperties_givenFactoryConfigEnvironmentIsMockEnvironment() {
    // Arrange
    FactoryConfig factoryConfig = new FactoryConfig();
    factoryConfig.setEnvironment(new MockEnvironment());

    // Act and Assert
    assertDoesNotThrow(() -> factoryConfig.setToSystemProperties());
  }

  /**
   * Test {@link FactoryConfig#setToSystemProperties()}.
   *
   * <ul>
   *   <li>Given {@link FactoryConfig} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link FactoryConfig#setToSystemProperties()}
   */
  @Test
  @DisplayName(
      "Test setToSystemProperties(); given FactoryConfig (default constructor); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FactoryConfig.setToSystemProperties()"})
  void testSetToSystemProperties_givenFactoryConfig_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new FactoryConfig().setToSystemProperties());
  }

  /**
   * Test {@link FactoryConfig#setToSystemProperties()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FactoryConfig#setToSystemProperties()}
   */
  @Test
  @DisplayName("Test setToSystemProperties(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FactoryConfig.setToSystemProperties()"})
  void testSetToSystemProperties_thenThrowIllegalArgumentException() {
    // Arrange
    StandardEnvironment environment = mock(StandardEnvironment.class);
    when(environment.getPropertySources()).thenThrow(new IllegalArgumentException());

    FactoryConfig factoryConfig = new FactoryConfig();
    factoryConfig.setEnvironment(environment);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> factoryConfig.setToSystemProperties());
    verify(environment).getPropertySources();
  }

  /**
   * Test {@link FactoryConfig#createGraphFactory()}.
   *
   * <p>Method under test: {@link FactoryConfig#createGraphFactory()}
   */
  @Test
  @DisplayName("Test createGraphFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphFactory FactoryConfig.createGraphFactory()"})
  void testCreateGraphFactory() throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    GraphFactory actualCreateGraphFactoryResult = new FactoryConfig().createGraphFactory();

    // Assert
    assertTrue(actualCreateGraphFactoryResult instanceof DefaultGraphFactory);
    assertTrue(((DefaultGraphFactory) actualCreateGraphFactoryResult).isSingletonGraph());
  }

  /**
   * Test {@link FactoryConfig#createUserFactory()}.
   *
   * <p>Method under test: {@link FactoryConfig#createUserFactory()}
   */
  @Test
  @DisplayName("Test createUserFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.rest.factory.spring.AbstractUserFactory FactoryConfig.createUserFactory()"
  })
  void testCreateUserFactory() throws IllegalAccessException, InstantiationException {
    // Arrange, Act and Assert
    assertTrue(new FactoryConfig().createUserFactory() instanceof UnknownUserFactory);
  }

  /**
   * Test {@link FactoryConfig#createExamplesFactory()}.
   *
   * <p>Method under test: {@link FactoryConfig#createExamplesFactory()}
   */
  @Test
  @DisplayName("Test createExamplesFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExamplesFactory FactoryConfig.createExamplesFactory()"})
  void testCreateExamplesFactory() {
    // Arrange and Act
    ExamplesFactory actualCreateExamplesFactoryResult = new FactoryConfig().createExamplesFactory();

    // Assert
    GetAllElements allElements =
        ((DefaultExamplesFactory) actualCreateExamplesFactoryResult).getAllElements();
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        allElements.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    assertTrue(actualCreateExamplesFactoryResult instanceof DefaultExamplesFactory);
    Type outputType = allElements.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(allElements.getOptions());
    assertNull(allElements.getDirectedType());
    assertNull(allElements.getView());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, allElements.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }
}
