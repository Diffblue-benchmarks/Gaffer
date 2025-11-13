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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.gchq.gaffer.core.exception.Error;
import uk.gov.gchq.gaffer.rest.factory.ExamplesFactory;
import uk.gov.gchq.gaffer.rest.factory.GraphFactory;

@ExtendWith(MockitoExtension.class)
class OperationServiceV2DiffblueTest {
  @InjectMocks
  private OperationServiceV2 operationServiceV2;

  /**
   * Test {@link OperationServiceV2#operationDetails(String)}.
   * <p>
   * Method under test: {@link OperationServiceV2#operationDetails(String)}
   */
  @Test
  @DisplayName("Test operationDetails(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Response OperationServiceV2.operationDetails(String)"})
  void testOperationDetails() throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    Response actualOperationDetailsResult = operationServiceV2.operationDetails("Class Name");

    // Assert
    assertTrue(actualOperationDetailsResult instanceof OutboundJaxrsResponse);
    Object entity = actualOperationDetailsResult.getEntity();
    assertTrue(entity instanceof Error);
    assertEquals("Class: Class Name was not found on the classpath.", ((Error) entity).getSimpleMessage());
    assertEquals(1, actualOperationDetailsResult.getStringHeaders().size());
    assertSame(entity, ((OutboundJaxrsResponse) actualOperationDetailsResult).getContext().getEntity());
  }

  /**
   * Test {@link OperationServiceV2#operationDetails(String)}.
   * <p>
   * Method under test: {@link OperationServiceV2#operationDetails(String)}
   */
  @Test
  @DisplayName("Test operationDetails(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Response OperationServiceV2.operationDetails(String)"})
  void testOperationDetails2() throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    Response actualOperationDetailsResult = operationServiceV2.operationDetails(".");

    // Assert
    assertTrue(actualOperationDetailsResult instanceof OutboundJaxrsResponse);
    Object entity = actualOperationDetailsResult.getEntity();
    assertTrue(entity instanceof Error);
    assertEquals("Class: . was not found on the classpath.", ((Error) entity).getSimpleMessage());
    assertEquals(1, actualOperationDetailsResult.getStringHeaders().size());
    assertSame(entity, ((OutboundJaxrsResponse) actualOperationDetailsResult).getContext().getEntity());
  }

  /**
   * Test {@link OperationServiceV2#operationDetails(String)}.
   * <p>
   * Method under test: {@link OperationServiceV2#operationDetails(String)}
   */
  @Test
  @DisplayName("Test operationDetails(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Response OperationServiceV2.operationDetails(String)"})
  void testOperationDetails3() throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    Response actualOperationDetailsResult = operationServiceV2.operationDetails("[]");

    // Assert
    assertTrue(actualOperationDetailsResult instanceof OutboundJaxrsResponse);
    Object entity = actualOperationDetailsResult.getEntity();
    assertTrue(entity instanceof Error);
    assertEquals("Class: [] was not found on the classpath.", ((Error) entity).getSimpleMessage());
    assertEquals(1, actualOperationDetailsResult.getStringHeaders().size());
    assertSame(entity, ((OutboundJaxrsResponse) actualOperationDetailsResult).getContext().getEntity());
  }

  /**
   * Test {@link OperationServiceV2#operationExample(String)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#operationExample(String)}
   */
  @Test
  @DisplayName("Test operationExample(String); when 'Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Response OperationServiceV2.operationExample(String)"})
  void testOperationExample_whenClassName() throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    Response actualOperationExampleResult = operationServiceV2.operationExample("Class Name");

    // Assert
    assertTrue(actualOperationExampleResult instanceof OutboundJaxrsResponse);
    assertEquals(1, actualOperationExampleResult.getStringHeaders().size());
  }

  /**
   * Test {@link OperationServiceV2#operationExample(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#operationExample(String)}
   */
  @Test
  @DisplayName("Test operationExample(String); when '.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Response OperationServiceV2.operationExample(String)"})
  void testOperationExample_whenDot() throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    Response actualOperationExampleResult = operationServiceV2.operationExample(".");

    // Assert
    assertTrue(actualOperationExampleResult instanceof OutboundJaxrsResponse);
    assertEquals(1, actualOperationExampleResult.getStringHeaders().size());
  }

  /**
   * Test {@link OperationServiceV2#operationExample(String)}.
   * <ul>
   *   <li>When {@code []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#operationExample(String)}
   */
  @Test
  @DisplayName("Test operationExample(String); when '[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Response OperationServiceV2.operationExample(String)"})
  void testOperationExample_whenLeftSquareBracketRightSquareBracket()
      throws IllegalAccessException, InstantiationException {
    // Arrange and Act
    Response actualOperationExampleResult = operationServiceV2.operationExample("[]");

    // Assert
    assertTrue(actualOperationExampleResult instanceof OutboundJaxrsResponse);
    assertEquals(1, actualOperationExampleResult.getStringHeaders().size());
  }

  /**
   * Test {@link OperationServiceV2#nextOperations(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#nextOperations(String)}
   */
  @Test
  @DisplayName("Test nextOperations(String); when '.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Response OperationServiceV2.nextOperations(String)"})
  void testNextOperations_whenDot() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> operationServiceV2.nextOperations("."));
  }

  /**
   * Test {@link OperationServiceV2#nextOperations(String)}.
   * <ul>
   *   <li>When {@code []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#nextOperations(String)}
   */
  @Test
  @DisplayName("Test nextOperations(String); when '[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Response OperationServiceV2.nextOperations(String)"})
  void testNextOperations_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> operationServiceV2.nextOperations("[]"));
  }

  /**
   * Test {@link OperationServiceV2#nextOperations(String)}.
   * <ul>
   *   <li>When {@code Operation Class Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#nextOperations(String)}
   */
  @Test
  @DisplayName("Test nextOperations(String); when 'Operation Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Response OperationServiceV2.nextOperations(String)"})
  void testNextOperations_whenOperationClassName() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> operationServiceV2.nextOperations("Operation Class Name"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OperationServiceV2#getExamplesFactory()}
   *   <li>{@link OperationServiceV2#getGraphFactory()}
   *   <li>{@link OperationServiceV2#getUserFactory()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExamplesFactory OperationServiceV2.getExamplesFactory()",
      "GraphFactory OperationServiceV2.getGraphFactory()",
      "uk.gov.gchq.gaffer.rest.factory.UserFactory OperationServiceV2.getUserFactory()",
      "void OperationServiceV2.postOperationHook(uk.gov.gchq.gaffer.operation.OperationChain, uk.gov.gchq.gaffer.store.Context)",
      "void OperationServiceV2.preOperationHook(uk.gov.gchq.gaffer.operation.OperationChain, uk.gov.gchq.gaffer.store.Context)"})
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
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given '42'; when ArrayList() add '42'; then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_given42_whenArrayListAdd42_thenCallsWrite() throws IOException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(objectList, output);

    // Assert
    verify(output).write(eq("\"42\""));
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given '42'; when ArrayList() add '42'; then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_given42_whenArrayListAdd42_thenCallsWrite2() throws IOException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(objectList, output);

    // Assert
    verify(output, atLeast(1)).write(eq("\"42\""));
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenA() throws IOException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(objectList, output);

    // Assert
    verify(output, atLeast(1)).write(Mockito.<String>any());
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given ArrayList() add '42'; when ArrayList() add ArrayList(); then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenArrayListAdd42_whenArrayListAddArrayList_thenCallsWrite() throws IOException {
    // Arrange
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given ArrayList() add '42'; when ArrayList() add ArrayList(); then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenArrayListAdd42_whenArrayListAddArrayList_thenCallsWrite2() throws IOException {
    // Arrange
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given ArrayList(); when ArrayList() add ArrayList(); then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenArrayList_whenArrayListAddArrayList_thenCallsWrite() throws IOException {
    // Arrange
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
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given IOException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenIOExceptionWithFoo() throws IOException {
    // Arrange
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doThrow(new IOException("foo")).when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult("Result", output);

    // Assert
    verify(output).write(eq("\"Result\""));
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given IOException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenIOExceptionWithFoo2() throws IOException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doThrow(new IOException("foo")).when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(objectList, output);

    // Assert
    verify(output).write(eq("\"42\""));
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>When {@code Annotation}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); when 'java.lang.annotation.Annotation'; then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_whenJavaLangAnnotationAnnotation_thenCallsWrite() throws IOException {
    // Arrange
    Class<Annotation> forNameResult = Annotation.class;
    UnqualifiedImpl unqualifiedImpl = new UnqualifiedImpl(forNameResult);
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(unqualifiedImpl, output);

    // Assert
    verify(output).write(eq("{}"));
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>When {@link NamedImpl#NamedImpl(String)} with {@code Name}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); when NamedImpl(String) with 'Name'; then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_whenNamedImplWithName_thenCallsWrite() throws IOException {
    // Arrange
    NamedImpl namedImpl = new NamedImpl("Name");
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(namedImpl, output);

    // Assert
    verify(output).write(eq("{}"));
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); when 'null'; then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_whenNull_thenCallsWrite() throws IOException {
    // Arrange
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult(null, output);

    // Assert
    verify(output).write(eq("null"));
  }

  /**
   * Test {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>When {@code Result}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationServiceV2#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); when 'Result'; then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationServiceV2.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_whenResult_thenCallsWrite() throws IOException {
    // Arrange
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationServiceV2.chunkResult("Result", output);

    // Assert
    verify(output).write(eq("\"Result\""));
  }

  /**
   * Test new {@link OperationServiceV2} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link OperationServiceV2}
   */
  @Test
  @DisplayName("Test new OperationServiceV2 (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationServiceV2.<init>()"})
  void testNewOperationServiceV2() {
    // Arrange and Act
    OperationServiceV2 actualOperationServiceV2 = new OperationServiceV2();

    // Assert
    ObjectMapper objectMapper = actualOperationServiceV2.mapper;
    JsonFactory factory = objectMapper.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(objectMapper.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
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
