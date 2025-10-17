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

package uk.gov.gchq.gaffer.rest.service.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import javax.ws.rs.core.Response;
import org.glassfish.hk2.utilities.NamedImpl;
import org.glassfish.hk2.utilities.UnqualifiedImpl;
import org.glassfish.jersey.message.internal.OutboundJaxrsResponse;
import org.glassfish.jersey.server.ChunkedOutput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.gchq.gaffer.commonutil.exception.UnauthorisedException;
import uk.gov.gchq.gaffer.core.exception.Error;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.Limit;
import uk.gov.gchq.gaffer.rest.factory.ExamplesFactory;
import uk.gov.gchq.gaffer.rest.factory.GraphFactory;
import uk.gov.gchq.gaffer.rest.factory.UserFactory;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.user.User;

@ExtendWith(MockitoExtension.class)
class OperationServiceV2DiffblueTest {
  @Mock private GraphFactory graphFactory;

  @InjectMocks private OperationServiceV2 operationServiceV2;

  @Mock private UserFactory userFactory;

  /**
   * Test {@link OperationServiceV2#getOperations()}.
   *
   * <p>Method under test: {@link OperationServiceV2#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.getOperations()"})
  void testGetOperations() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new UnauthorisedException("An error occurred"));

    // Act and Assert
    assertThrows(UnauthorisedException.class, () -> operationServiceV2.getOperations());
    verify(graphFactory).getGraph();
  }

  /**
   * Test {@link OperationServiceV2#getOperationDetails()}.
   *
   * <p>Method under test: {@link OperationServiceV2#getOperationDetails()}
   */
  @Test
  @DisplayName("Test getOperationDetails()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.getOperationDetails()"})
  void testGetOperationDetails() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new UnauthorisedException("An error occurred"));

    // Act and Assert
    assertThrows(UnauthorisedException.class, () -> operationServiceV2.getOperationDetails());
    verify(graphFactory).getGraph();
  }

  /**
   * Test {@link OperationServiceV2#execute(Operation)}.
   *
   * <p>Method under test: {@link OperationServiceV2#execute(Operation)}
   */
  @Test
  @DisplayName("Test execute(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.execute(Operation)"})
  void testExecute() {
    // Arrange
    when(userFactory.createContext()).thenThrow(new UnauthorisedException("An error occurred"));
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertThrows(UnauthorisedException.class, () -> operationServiceV2.execute(operation));
    verify(userFactory).createContext();
  }

  /**
   * Test {@link OperationServiceV2#execute(Operation)}.
   *
   * <ul>
   *   <li>When {@link Limit#Limit()}.
   *   <li>Then calls {@link GraphFactory#getGraph()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#execute(Operation)}
   */
  @Test
  @DisplayName("Test execute(Operation); when Limit(); then calls getGraph()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.execute(Operation)"})
  void testExecute_whenLimit_thenCallsGetGraph() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new UnauthorisedException("An error occurred"));

    Builder builder = new Builder();
    when(userFactory.createContext())
        .thenReturn(builder.user(new User.Builder().userId("42").build()).build());

    // Act and Assert
    assertThrows(UnauthorisedException.class, () -> operationServiceV2.execute(new Limit<>()));
    verify(graphFactory).getGraph();
    verify(userFactory).createContext();
  }

  /**
   * Test {@link OperationServiceV2#execute(Operation)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link GraphFactory#getGraph()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#execute(Operation)}
   */
  @Test
  @DisplayName("Test execute(Operation); when 'null'; then calls getGraph()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.execute(Operation)"})
  void testExecute_whenNull_thenCallsGetGraph() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new UnauthorisedException("An error occurred"));

    Builder builder = new Builder();
    when(userFactory.createContext())
        .thenReturn(builder.user(new User.Builder().userId("42").build()).build());

    // Act and Assert
    assertThrows(UnauthorisedException.class, () -> operationServiceV2.execute(null));
    verify(graphFactory).getGraph();
    verify(userFactory).createContext();
  }

  /**
   * Test {@link OperationServiceV2#execute(Operation)}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   *   <li>Then calls {@link GraphFactory#getGraph()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#execute(Operation)}
   */
  @Test
  @DisplayName(
      "Test execute(Operation); when wrap NamedOperation (default constructor); then calls getGraph()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.execute(Operation)"})
  void testExecute_whenWrapNamedOperation_thenCallsGetGraph() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new UnauthorisedException("An error occurred"));

    Builder builder = new Builder();
    when(userFactory.createContext())
        .thenReturn(builder.user(new User.Builder().userId("42").build()).build());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertThrows(UnauthorisedException.class, () -> operationServiceV2.execute(operation));
    verify(graphFactory).getGraph();
    verify(userFactory).createContext();
  }

  /**
   * Test {@link OperationServiceV2#executeChunked(Operation)}.
   *
   * <ul>
   *   <li>Given {@link UnauthorisedException#UnauthorisedException(String)} with message is {@code
   *       An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#executeChunked(Operation)}
   */
  @Test
  @DisplayName(
      "Test executeChunked(Operation); given UnauthorisedException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.executeChunked(Operation)"})
  void testExecuteChunked_givenUnauthorisedExceptionWithMessageIsAnErrorOccurred()
      throws IOException {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new UnauthorisedException("An error occurred"));

    Builder builder = new Builder();
    when(userFactory.createContext())
        .thenReturn(builder.user(new User.Builder().userId("42").build()).build());

    OperationChain<Object> operation = mock(OperationChain.class);
    doThrow(new UnauthorisedException("An error occurred")).when(operation).close();
    OperationChain<Object> operation2 = OperationChain.wrap(operation);

    // Act
    Response actualExecuteChunkedResult = operationServiceV2.executeChunked(operation2);

    // Assert
    verify(operation).close();
    verify(graphFactory).getGraph();
    verify(userFactory).createContext();
    assertTrue(actualExecuteChunkedResult instanceof OutboundJaxrsResponse);
    assertEquals(1, actualExecuteChunkedResult.getStringHeaders().size());
  }

  /**
   * Test {@link OperationServiceV2#executeChunked(Operation)}.
   *
   * <ul>
   *   <li>Then throw {@link UnauthorisedException}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#executeChunked(Operation)}
   */
  @Test
  @DisplayName("Test executeChunked(Operation); then throw UnauthorisedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.executeChunked(Operation)"})
  void testExecuteChunked_thenThrowUnauthorisedException() {
    // Arrange
    when(userFactory.createContext()).thenThrow(new UnauthorisedException("An error occurred"));
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertThrows(UnauthorisedException.class, () -> operationServiceV2.executeChunked(operation));
    verify(userFactory).createContext();
  }

  /**
   * Test {@link OperationServiceV2#executeChunked(Operation)}.
   *
   * <ul>
   *   <li>When {@link OperationChain} {@link OperationChain#close()} does nothing.
   *   <li>Then calls {@link OperationChain#close()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#executeChunked(Operation)}
   */
  @Test
  @DisplayName(
      "Test executeChunked(Operation); when OperationChain close() does nothing; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.executeChunked(Operation)"})
  void testExecuteChunked_whenOperationChainCloseDoesNothing_thenCallsClose() throws IOException {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new UnauthorisedException("An error occurred"));

    Builder builder = new Builder();
    when(userFactory.createContext())
        .thenReturn(builder.user(new User.Builder().userId("42").build()).build());

    OperationChain<Object> operation = mock(OperationChain.class);
    doNothing().when(operation).close();
    OperationChain<Object> operation2 = OperationChain.wrap(operation);

    // Act
    Response actualExecuteChunkedResult = operationServiceV2.executeChunked(operation2);

    // Assert
    verify(operation).close();
    verify(graphFactory).getGraph();
    verify(userFactory).createContext();
    assertTrue(actualExecuteChunkedResult instanceof OutboundJaxrsResponse);
    assertEquals(1, actualExecuteChunkedResult.getStringHeaders().size());
  }

  /**
   * Test {@link OperationServiceV2#executeChunked(Operation)}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   *   <li>Then return {@link OutboundJaxrsResponse}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#executeChunked(Operation)}
   */
  @Test
  @DisplayName(
      "Test executeChunked(Operation); when wrap NamedOperation (default constructor); then return OutboundJaxrsResponse")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.executeChunked(Operation)"})
  void testExecuteChunked_whenWrapNamedOperation_thenReturnOutboundJaxrsResponse() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new UnauthorisedException("An error occurred"));

    Builder builder = new Builder();
    when(userFactory.createContext())
        .thenReturn(builder.user(new User.Builder().userId("42").build()).build());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act
    Response actualExecuteChunkedResult = operationServiceV2.executeChunked(operation);

    // Assert
    verify(graphFactory).getGraph();
    verify(userFactory).createContext();
    assertTrue(actualExecuteChunkedResult instanceof OutboundJaxrsResponse);
    assertEquals(1, actualExecuteChunkedResult.getStringHeaders().size());
  }

  /**
   * Test {@link OperationServiceV2#executeChunkedChain(OperationChain)}.
   *
   * <ul>
   *   <li>Given {@link UnauthorisedException#UnauthorisedException(String)} with message is {@code
   *       An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#executeChunkedChain(OperationChain)}
   */
  @Test
  @DisplayName(
      "Test executeChunkedChain(OperationChain); given UnauthorisedException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.executeChunkedChain(OperationChain)"})
  void testExecuteChunkedChain_givenUnauthorisedExceptionWithMessageIsAnErrorOccurred()
      throws IOException {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new UnauthorisedException("An error occurred"));

    Builder builder = new Builder();
    when(userFactory.createContext())
        .thenReturn(builder.user(new User.Builder().userId("42").build()).build());

    OperationChain<Object> operation = mock(OperationChain.class);
    doThrow(new UnauthorisedException("An error occurred")).when(operation).close();
    OperationChain<Object> operation2 = OperationChain.wrap(operation);
    OperationChain<?> opChain = OperationChain.wrap(operation2);

    // Act
    Response actualExecuteChunkedChainResult = operationServiceV2.executeChunkedChain(opChain);

    // Assert
    verify(operation).close();
    verify(graphFactory).getGraph();
    verify(userFactory).createContext();
    assertTrue(actualExecuteChunkedChainResult instanceof OutboundJaxrsResponse);
    assertEquals(1, actualExecuteChunkedChainResult.getStringHeaders().size());
  }

  /**
   * Test {@link OperationServiceV2#executeChunkedChain(OperationChain)}.
   *
   * <ul>
   *   <li>Then throw {@link UnauthorisedException}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#executeChunkedChain(OperationChain)}
   */
  @Test
  @DisplayName("Test executeChunkedChain(OperationChain); then throw UnauthorisedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.executeChunkedChain(OperationChain)"})
  void testExecuteChunkedChain_thenThrowUnauthorisedException() {
    // Arrange
    when(userFactory.createContext()).thenThrow(new UnauthorisedException("An error occurred"));
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    OperationChain<?> opChain = OperationChain.wrap(operation);

    // Act and Assert
    assertThrows(
        UnauthorisedException.class, () -> operationServiceV2.executeChunkedChain(opChain));
    verify(userFactory).createContext();
  }

  /**
   * Test {@link OperationServiceV2#executeChunkedChain(OperationChain)}.
   *
   * <ul>
   *   <li>When {@link OperationChain} {@link OperationChain#close()} does nothing.
   *   <li>Then calls {@link OperationChain#close()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#executeChunkedChain(OperationChain)}
   */
  @Test
  @DisplayName(
      "Test executeChunkedChain(OperationChain); when OperationChain close() does nothing; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.executeChunkedChain(OperationChain)"})
  void testExecuteChunkedChain_whenOperationChainCloseDoesNothing_thenCallsClose()
      throws IOException {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new UnauthorisedException("An error occurred"));

    Builder builder = new Builder();
    when(userFactory.createContext())
        .thenReturn(builder.user(new User.Builder().userId("42").build()).build());

    OperationChain<Object> operation = mock(OperationChain.class);
    doNothing().when(operation).close();
    OperationChain<Object> operation2 = OperationChain.wrap(operation);
    OperationChain<?> opChain = OperationChain.wrap(operation2);

    // Act
    Response actualExecuteChunkedChainResult = operationServiceV2.executeChunkedChain(opChain);

    // Assert
    verify(operation).close();
    verify(graphFactory).getGraph();
    verify(userFactory).createContext();
    assertTrue(actualExecuteChunkedChainResult instanceof OutboundJaxrsResponse);
    assertEquals(1, actualExecuteChunkedChainResult.getStringHeaders().size());
  }

  /**
   * Test {@link OperationServiceV2#executeChunkedChain(OperationChain)}.
   *
   * <ul>
   *   <li>When wrap wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#executeChunkedChain(OperationChain)}
   */
  @Test
  @DisplayName(
      "Test executeChunkedChain(OperationChain); when wrap wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.executeChunkedChain(OperationChain)"})
  void testExecuteChunkedChain_whenWrapWrapNamedOperation() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new UnauthorisedException("An error occurred"));

    Builder builder = new Builder();
    when(userFactory.createContext())
        .thenReturn(builder.user(new User.Builder().userId("42").build()).build());
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    OperationChain<?> opChain = OperationChain.wrap(operation);

    // Act
    Response actualExecuteChunkedChainResult = operationServiceV2.executeChunkedChain(opChain);

    // Assert
    verify(graphFactory).getGraph();
    verify(userFactory).createContext();
    assertTrue(actualExecuteChunkedChainResult instanceof OutboundJaxrsResponse);
    assertEquals(1, actualExecuteChunkedChainResult.getStringHeaders().size());
  }

  /**
   * Test {@link OperationServiceV2#operationDetails(String)}.
   *
   * <p>Method under test: {@link OperationServiceV2#operationDetails(String)}
   */
  @Test
  @DisplayName("Test operationDetails(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.operationDetails(String)"})
  void testOperationDetails() throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    Response actualOperationDetailsResult = new OperationServiceV2().operationDetails("Class Name");

    // Assert
    assertTrue(actualOperationDetailsResult instanceof OutboundJaxrsResponse);
    Object entity = actualOperationDetailsResult.getEntity();
    assertTrue(entity instanceof Error);
    assertEquals(
        "Class: Class Name was not found on the classpath.", ((Error) entity).getSimpleMessage());
    assertEquals(1, actualOperationDetailsResult.getStringHeaders().size());
    assertSame(
        entity, ((OutboundJaxrsResponse) actualOperationDetailsResult).getContext().getEntity());
  }

  /**
   * Test {@link OperationServiceV2#operationDetails(String)}.
   *
   * <p>Method under test: {@link OperationServiceV2#operationDetails(String)}
   */
  @Test
  @DisplayName("Test operationDetails(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.operationDetails(String)"})
  void testOperationDetails2() throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    Response actualOperationDetailsResult = new OperationServiceV2().operationDetails(".");

    // Assert
    assertTrue(actualOperationDetailsResult instanceof OutboundJaxrsResponse);
    Object entity = actualOperationDetailsResult.getEntity();
    assertTrue(entity instanceof Error);
    assertEquals("Class: . was not found on the classpath.", ((Error) entity).getSimpleMessage());
    assertEquals(1, actualOperationDetailsResult.getStringHeaders().size());
    assertSame(
        entity, ((OutboundJaxrsResponse) actualOperationDetailsResult).getContext().getEntity());
  }

  /**
   * Test {@link OperationServiceV2#operationDetails(String)}.
   *
   * <p>Method under test: {@link OperationServiceV2#operationDetails(String)}
   */
  @Test
  @DisplayName("Test operationDetails(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.operationDetails(String)"})
  void testOperationDetails3() throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    Response actualOperationDetailsResult = new OperationServiceV2().operationDetails("[]");

    // Assert
    assertTrue(actualOperationDetailsResult instanceof OutboundJaxrsResponse);
    Object entity = actualOperationDetailsResult.getEntity();
    assertTrue(entity instanceof Error);
    assertEquals("Class: [] was not found on the classpath.", ((Error) entity).getSimpleMessage());
    assertEquals(1, actualOperationDetailsResult.getStringHeaders().size());
    assertSame(
        entity, ((OutboundJaxrsResponse) actualOperationDetailsResult).getContext().getEntity());
  }

  /**
   * Test {@link OperationServiceV2#operationExample(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#operationExample(String)}
   */
  @Test
  @DisplayName("Test operationExample(String); when 'Class Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.operationExample(String)"})
  void testOperationExample_whenClassName() throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    Response actualOperationExampleResult = new OperationServiceV2().operationExample("Class Name");

    // Assert
    assertTrue(actualOperationExampleResult instanceof OutboundJaxrsResponse);
    assertEquals(1, actualOperationExampleResult.getStringHeaders().size());
  }

  /**
   * Test {@link OperationServiceV2#operationExample(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#operationExample(String)}
   */
  @Test
  @DisplayName("Test operationExample(String); when '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.operationExample(String)"})
  void testOperationExample_whenDot() throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    Response actualOperationExampleResult = new OperationServiceV2().operationExample(".");

    // Assert
    assertTrue(actualOperationExampleResult instanceof OutboundJaxrsResponse);
    assertEquals(1, actualOperationExampleResult.getStringHeaders().size());
  }

  /**
   * Test {@link OperationServiceV2#operationExample(String)}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#operationExample(String)}
   */
  @Test
  @DisplayName("Test operationExample(String); when '[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.operationExample(String)"})
  void testOperationExample_whenLeftSquareBracketRightSquareBracket()
      throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    Response actualOperationExampleResult = new OperationServiceV2().operationExample("[]");

    // Assert
    assertTrue(actualOperationExampleResult instanceof OutboundJaxrsResponse);
    assertEquals(1, actualOperationExampleResult.getStringHeaders().size());
  }

  /**
   * Test {@link OperationServiceV2#nextOperations(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#nextOperations(String)}
   */
  @Test
  @DisplayName("Test nextOperations(String); when '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.nextOperations(String)"})
  void testNextOperations_whenDot() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new OperationServiceV2().nextOperations("."));
  }

  /**
   * Test {@link OperationServiceV2#nextOperations(String)}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#nextOperations(String)}
   */
  @Test
  @DisplayName("Test nextOperations(String); when '[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.nextOperations(String)"})
  void testNextOperations_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new OperationServiceV2().nextOperations("[]"));
  }

  /**
   * Test {@link OperationServiceV2#nextOperations(String)}.
   *
   * <ul>
   *   <li>When {@code Operation Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#nextOperations(String)}
   */
  @Test
  @DisplayName("Test nextOperations(String); when 'Operation Class Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response OperationServiceV2.nextOperations(String)"})
  void testNextOperations_whenOperationClassName() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new OperationServiceV2().nextOperations("Operation Class Name"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OperationServiceV2#getExamplesFactory()}
   *   <li>{@link OperationServiceV2#getGraphFactory()}
   *   <li>{@link OperationServiceV2#getUserFactory()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExamplesFactory OperationServiceV2.getExamplesFactory()",
    "GraphFactory OperationServiceV2.getGraphFactory()",
    "UserFactory OperationServiceV2.getUserFactory()",
    "void OperationServiceV2.postOperationHook(OperationChain, Context)",
    "void OperationServiceV2.preOperationHook(OperationChain, Context)"
  })
  void testGettersAndSetters() {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();

    // Act
    ExamplesFactory actualExamplesFactory = operationServiceV2.getExamplesFactory();
    GraphFactory actualGraphFactory = operationServiceV2.getGraphFactory();

    // Assert
    assertNull(actualExamplesFactory);
    assertNull(actualGraphFactory);
    assertNull(operationServiceV2.getUserFactory());
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName(
      "Test chunkResult(Object, ChunkedOutput); given '42'; when ArrayList() add '42'; then calls write(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_given42_whenArrayListAdd42_thenCallsWrite() throws IOException {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(objectList, output);

    // Assert
    verify(output).write("\"42\"");
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName(
      "Test chunkResult(Object, ChunkedOutput); given '42'; when ArrayList() add '42'; then calls write(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_given42_whenArrayListAdd42_thenCallsWrite2() throws IOException {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");

    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(objectList, output);

    // Assert
    verify(output, atLeast(1)).write("\"42\"");
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenA() throws IOException {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    objectList.add(byteArrayInputStream);

    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(objectList, output);

    // Assert
    verify(output, atLeast(1)).write(Mockito.<String>any());
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName(
      "Test chunkResult(Object, ChunkedOutput); given ArrayList() add '42'; when ArrayList() add ArrayList(); then calls write(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenArrayListAdd42_whenArrayListAddArrayList_thenCallsWrite()
      throws IOException {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    ArrayList<Object> objectList2 = new ArrayList<>();
    objectList2.add("42");
    objectList2.add(objectList);

    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(objectList2, output);

    // Assert
    verify(output, atLeast(1)).write(Mockito.<String>any());
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName(
      "Test chunkResult(Object, ChunkedOutput); given ArrayList() add '42'; when ArrayList() add ArrayList(); then calls write(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenArrayListAdd42_whenArrayListAddArrayList_thenCallsWrite2()
      throws IOException {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");

    ArrayList<Object> objectList2 = new ArrayList<>();
    objectList2.add("42");
    objectList2.add(objectList);

    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(objectList2, output);

    // Assert
    verify(output, atLeast(1)).write(Mockito.<String>any());
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName(
      "Test chunkResult(Object, ChunkedOutput); given ArrayList(); when ArrayList() add ArrayList(); then calls write(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenArrayList_whenArrayListAddArrayList_thenCallsWrite()
      throws IOException {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add(new ArrayList<>());

    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(objectList, output);

    // Assert
    verify(output, atLeast(1)).write(Mockito.<String>any());
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>When {@link ChunkedOutput} {@link ChunkedOutput#write(Object)} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName(
      "Test chunkResult(Object, ChunkedOutput); given IOException(); when ChunkedOutput write(Object) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenIOException_whenChunkedOutputWriteThrowIOException()
      throws IOException {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();

    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doThrow(new IOException()).when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult("Result", output);

    // Assert
    verify(output).write("\"Result\"");
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>When {@link ChunkedOutput} {@link ChunkedOutput#write(Object)} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName(
      "Test chunkResult(Object, ChunkedOutput); given IOException(); when ChunkedOutput write(Object) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenIOException_whenChunkedOutputWriteThrowIOException2()
      throws IOException {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doThrow(new IOException()).when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(objectList, output);

    // Assert
    verify(output).write("\"42\"");
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   *
   * <ul>
   *   <li>Given {@link StringWriter#StringWriter()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link StringWriter#StringWriter()}.
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName(
      "Test chunkResult(Object, ChunkedOutput); given StringWriter(); when ArrayList() add StringWriter(); then calls write(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenStringWriter_whenArrayListAddStringWriter_thenCallsWrite()
      throws IOException {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add(new StringWriter());

    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(objectList, output);

    // Assert
    verify(output, atLeast(1)).write(Mockito.<String>any());
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   *
   * <ul>
   *   <li>When {@code Annotation}.
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName(
      "Test chunkResult(Object, ChunkedOutput); when 'java.lang.annotation.Annotation'; then calls write(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_whenJavaLangAnnotationAnnotation_thenCallsWrite() throws IOException {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();
    Class<Annotation> forNameResult = Annotation.class;
    UnqualifiedImpl unqualifiedImpl = new UnqualifiedImpl(forNameResult);

    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(unqualifiedImpl, output);

    // Assert
    verify(output).write("{}");
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   *
   * <ul>
   *   <li>When {@link NamedImpl#NamedImpl(String)} with {@code Name}.
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName(
      "Test chunkResult(Object, ChunkedOutput); when NamedImpl(String) with 'Name'; then calls write(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_whenNamedImplWithName_thenCallsWrite() throws IOException {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();
    NamedImpl namedImpl = new NamedImpl("Name");

    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(namedImpl, output);

    // Assert
    verify(output).write("{}");
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); when 'null'; then calls write(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_whenNull_thenCallsWrite() throws IOException {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();

    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(null, output);

    // Assert
    verify(output).write("null");
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   *
   * <ul>
   *   <li>When {@code Result}.
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); when 'Result'; then calls write(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_whenResult_thenCallsWrite() throws IOException {
    // Arrange
    OperationServiceV2 operationServiceV2 = new OperationServiceV2();

    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult("Result", output);

    // Assert
    verify(output).write("\"Result\"");
  }

  /**
   * Test new {@link OperationServiceV2} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OperationServiceV2}
   */
  @Test
  @DisplayName("Test new OperationServiceV2 (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OperationServiceV2.<init>()"})
  void testNewOperationServiceV2() {
    // Arrange and Act
    OperationServiceV2 actualOperationServiceV2 = new OperationServiceV2();

    // Assert
    ObjectMapper objectMapper = actualOperationServiceV2.mapper;
    JsonFactory factory = objectMapper.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(
        objectMapper.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
    assertTrue(objectMapper.getVisibilityChecker() instanceof Std);
    assertTrue(objectMapper.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
    assertTrue(objectMapper.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(objectMapper.getSerializerFactory() instanceof BeanSerializerFactory);
    assertTrue(objectMapper.getSerializerProvider() instanceof Impl);
    assertTrue(objectMapper.getSerializerProviderInstance() instanceof Impl);
    assertTrue(objectMapper.getDateFormat() instanceof StdDateFormat);
    assertNull(objectMapper.getInjectableValues());
    assertNull(objectMapper.getPropertyNamingStrategy());
    assertNull(actualOperationServiceV2.getExamplesFactory());
    assertNull(actualOperationServiceV2.getGraphFactory());
    assertNull(actualOperationServiceV2.getUserFactory());
    assertEquals(3, objectMapper.getRegisteredModuleIds().size());
    assertSame(factory, objectMapper.getJsonFactory());
  }
}
