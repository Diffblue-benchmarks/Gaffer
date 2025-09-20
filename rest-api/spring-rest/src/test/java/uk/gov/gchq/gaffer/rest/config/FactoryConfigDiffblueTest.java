package uk.gov.gchq.gaffer.rest.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
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
@ExtendWith(MockitoExtension.class)
class FactoryConfigDiffblueTest {
  @InjectMocks private FactoryConfig factoryConfig;

  /**
   * Test {@link FactoryConfig#setToSystemProperties()}.
   *
   * <p>Method under test: {@link FactoryConfig#setToSystemProperties()}
   */
  @Test
  @DisplayName("Test setToSystemProperties()")
  @Tag("MaintainedByDiffblue")
  void testSetToSystemProperties() {
    // Arrange
    StandardEnvironment environment = mock(StandardEnvironment.class);
    when(environment.getPropertySources()).thenReturn(new MutablePropertySources());
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
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FactoryConfig#setToSystemProperties()}
   */
  @Test
  @DisplayName("Test setToSystemProperties(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testSetToSystemProperties_thenThrowIllegalArgumentException() {
    // Arrange
    StandardEnvironment environment = mock(StandardEnvironment.class);
    when(environment.getPropertySources()).thenThrow(new IllegalArgumentException());
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
  @Tag("MaintainedByDiffblue")
  void testCreateGraphFactory() throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    GraphFactory actualCreateGraphFactoryResult = factoryConfig.createGraphFactory();

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
  @Tag("MaintainedByDiffblue")
  void testCreateUserFactory() throws IllegalAccessException, InstantiationException {
    // Arrange, Act and Assert
    assertTrue(factoryConfig.createUserFactory() instanceof UnknownUserFactory);
  }

  /**
   * Test {@link FactoryConfig#createExamplesFactory()}.
   *
   * <p>Method under test: {@link FactoryConfig#createExamplesFactory()}
   */
  @Test
  @DisplayName("Test createExamplesFactory()")
  @Tag("MaintainedByDiffblue")
  void testCreateExamplesFactory() {
    // Arrange and Act
    ExamplesFactory actualCreateExamplesFactoryResult = factoryConfig.createExamplesFactory();

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
