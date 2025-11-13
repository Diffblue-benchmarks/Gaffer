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

package uk.gov.gchq.gaffer.rest.service.v1;

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
import static org.mockito.Mockito.when;
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
import org.glassfish.hk2.utilities.NamedImpl;
import org.glassfish.hk2.utilities.UnqualifiedImpl;
import org.glassfish.jersey.server.ChunkedOutput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;

@ExtendWith(MockitoExtension.class)
class OperationServiceDiffblueTest {
  @InjectMocks
  private OperationService operationService;

  /**
   * Test {@link OperationService#executeChunked(Operation)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link OperationChain} {@link OperationChain#getOperations()} return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#executeChunked(Operation)}
   */
  @Test
  @DisplayName("Test executeChunked(Operation); given ArrayList(); when OperationChain getOperations() return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ChunkedOutput OperationService.executeChunked(Operation)"})
  void testExecuteChunked_givenArrayList_whenOperationChainGetOperationsReturnArrayList() {
    // Arrange
    OperationChain<Object> operation = mock(OperationChain.class);
    when(operation.getOperations()).thenReturn(new ArrayList<>());

    // Act
    ChunkedOutput<String> actualExecuteChunkedResult = operationService.executeChunked(operation);

    // Assert
    verify(operation).getOperations();
    Class<String> expectedRawType = String.class;
    Class<?> rawType = actualExecuteChunkedResult.getRawType();
    assertEquals(expectedRawType, rawType);
    assertSame(rawType, actualExecuteChunkedResult.getType());
  }

  /**
   * Test {@link OperationService#executeChunked(Operation)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with cr lf.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#executeChunked(Operation)}
   */
  @Test
  @DisplayName("Test executeChunked(Operation); given RuntimeException(String) with cr lf; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ChunkedOutput OperationService.executeChunked(Operation)"})
  void testExecuteChunked_givenRuntimeExceptionWithCrLf_thenThrowRuntimeException() {
    // Arrange
    OperationChain<Object> operation = mock(OperationChain.class);
    when(operation.getOperations()).thenThrow(new RuntimeException("\r\n"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> operationService.executeChunked(operation));
    verify(operation).getOperations();
  }

  /**
   * Test {@link OperationService#executeChunked(Operation)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return RawType is {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#executeChunked(Operation)}
   */
  @Test
  @DisplayName("Test executeChunked(Operation); when OperationChain(); then return RawType is String")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ChunkedOutput OperationService.executeChunked(Operation)"})
  void testExecuteChunked_whenOperationChain_thenReturnRawTypeIsString() {
    // Arrange and Act
    ChunkedOutput<String> actualExecuteChunkedResult = operationService.executeChunked(new OperationChain<>());

    // Assert
    Class<String> expectedRawType = String.class;
    Class<?> rawType = actualExecuteChunkedResult.getRawType();
    assertEquals(expectedRawType, rawType);
    assertSame(rawType, actualExecuteChunkedResult.getType());
  }

  /**
   * Test {@link OperationService#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given '42'; when ArrayList() add '42'; then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationService.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_given42_whenArrayListAdd42_thenCallsWrite() throws IOException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationService.chunkResult(objectList, output);

    // Assert
    verify(output).write(eq("\"42\""));
  }

  /**
   * Test {@link OperationService#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given '42'; when ArrayList() add '42'; then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationService.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_given42_whenArrayListAdd42_thenCallsWrite2() throws IOException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationService.chunkResult(objectList, output);

    // Assert
    verify(output, atLeast(1)).write(eq("\"42\""));
  }

  /**
   * Test {@link OperationService#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationService.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenA() throws IOException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationService.chunkResult(objectList, output);

    // Assert
    verify(output, atLeast(1)).write(Mockito.<String>any());
  }

  /**
   * Test {@link OperationService#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given ArrayList() add '42'; when ArrayList() add ArrayList(); then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationService.chunkResult(Object, ChunkedOutput)"})
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
    operationService.chunkResult(objectList2, output);

    // Assert
    verify(output, atLeast(1)).write(Mockito.<String>any());
  }

  /**
   * Test {@link OperationService#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given ArrayList() add '42'; when ArrayList() add ArrayList(); then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationService.chunkResult(Object, ChunkedOutput)"})
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
    operationService.chunkResult(objectList2, output);

    // Assert
    verify(output, atLeast(1)).write(Mockito.<String>any());
  }

  /**
   * Test {@link OperationService#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given ArrayList(); when ArrayList() add ArrayList(); then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationService.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenArrayList_whenArrayListAddArrayList_thenCallsWrite() throws IOException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add(new ArrayList<>());
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationService.chunkResult(objectList, output);

    // Assert
    verify(output, atLeast(1)).write(Mockito.<String>any());
  }

  /**
   * Test {@link OperationService#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given IOException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationService.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenIOExceptionWithFoo() throws IOException {
    // Arrange
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doThrow(new IOException("foo")).when(output).write(Mockito.<String>any());

    // Act
    operationService.chunkResult("Result", output);

    // Assert
    verify(output).write(eq("\"Result\""));
  }

  /**
   * Test {@link OperationService#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); given IOException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationService.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_givenIOExceptionWithFoo2() throws IOException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doThrow(new IOException("foo")).when(output).write(Mockito.<String>any());

    // Act
    operationService.chunkResult(objectList, output);

    // Assert
    verify(output).write(eq("\"42\""));
  }

  /**
   * Test {@link OperationService#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>When {@code Annotation}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); when 'java.lang.annotation.Annotation'; then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationService.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_whenJavaLangAnnotationAnnotation_thenCallsWrite() throws IOException {
    // Arrange
    Class<Annotation> forNameResult = Annotation.class;
    UnqualifiedImpl unqualifiedImpl = new UnqualifiedImpl(forNameResult);
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationService.chunkResult(unqualifiedImpl, output);

    // Assert
    verify(output).write(eq("{}"));
  }

  /**
   * Test {@link OperationService#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>When {@link NamedImpl#NamedImpl(String)} with {@code Name}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); when NamedImpl(String) with 'Name'; then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationService.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_whenNamedImplWithName_thenCallsWrite() throws IOException {
    // Arrange
    NamedImpl namedImpl = new NamedImpl("Name");
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationService.chunkResult(namedImpl, output);

    // Assert
    verify(output).write(eq("{}"));
  }

  /**
   * Test {@link OperationService#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); when 'null'; then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationService.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_whenNull_thenCallsWrite() throws IOException {
    // Arrange
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationService.chunkResult(null, output);

    // Assert
    verify(output).write(eq("null"));
  }

  /**
   * Test {@link OperationService#chunkResult(Object, ChunkedOutput)}.
   * <ul>
   *   <li>When {@code Result}.</li>
   *   <li>Then calls {@link ChunkedOutput#write(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationService#chunkResult(Object, ChunkedOutput)}
   */
  @Test
  @DisplayName("Test chunkResult(Object, ChunkedOutput); when 'Result'; then calls write(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationService.chunkResult(Object, ChunkedOutput)"})
  void testChunkResult_whenResult_thenCallsWrite() throws IOException {
    // Arrange
    ChunkedOutput<String> output = mock(ChunkedOutput.class);
    doNothing().when(output).write(Mockito.<String>any());

    // Act
    operationService.chunkResult("Result", output);

    // Assert
    verify(output).write(eq("\"Result\""));
  }

  /**
   * Test new {@link OperationService} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link OperationService}
   */
  @Test
  @DisplayName("Test new OperationService (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationService.<init>()"})
  void testNewOperationService() {
    // Arrange, Act and Assert
    ObjectMapper objectMapper = (new OperationService()).mapper;
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
    assertEquals(3, objectMapper.getRegisteredModuleIds().size());
    assertSame(factory, objectMapper.getJsonFactory());
  }
}
