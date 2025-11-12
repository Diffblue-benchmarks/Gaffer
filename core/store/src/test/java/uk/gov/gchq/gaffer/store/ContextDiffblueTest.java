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

package uk.gov.gchq.gaffer.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.export.Exporter;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.LocalFileExporter;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.store.operation.DeleteAllData;
import uk.gov.gchq.gaffer.user.User;

class ContextDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Context.Builder#build()}
   *   <li>{@link Context.Builder#user(User)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    Context.Builder builder = new Context.Builder();
    User user = new User();

    // Act
    Context actualBuildResult = builder.user(user).build();

    // Assert
    assertNull(actualBuildResult.getOriginalOpChain());
    assertTrue(actualBuildResult.getExporters().isEmpty());
    assertTrue(actualBuildResult.getVariables().isEmpty());
    assertSame(user, actualBuildResult.getUser());
  }

  /**
   * Method under test: {@link Context.Builder#config(String, Object)}
   */
  @Test
  void testBuilderConfig() {
    // Arrange
    Context.Builder builder = new Context.Builder();

    // Act and Assert
    assertSame(builder, builder.config("Key", "Value"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link Context.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    Context buildResult = (new Context.Builder()).build();
    User user = buildResult.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertNull(buildResult.getOriginalOpChain());
    assertTrue(buildResult.getExporters().isEmpty());
    assertTrue(buildResult.getVariables().isEmpty());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
  }

  /**
   * Method under test: {@link Context.Builder#variable(String, Object)}
   */
  @Test
  void testBuilderVariable() {
    // Arrange
    Context.Builder builder = new Context.Builder();

    // Act and Assert
    assertSame(builder, builder.variable("Key", "Value"));
  }

  /**
   * Method under test: {@link Context.Builder#variables(Map)}
   */
  @Test
  void testBuilderVariables() {
    // Arrange
    Context.Builder builder = new Context.Builder();

    // Act and Assert
    assertSame(builder, builder.variables(new HashMap<>()));
  }

  /**
   * Method under test: {@link Context.Builder#variables(Map)}
   */
  @Test
  void testBuilderVariables2() {
    // Arrange
    Context.Builder builder = new Context.Builder();

    HashMap<String, Object> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertSame(builder, builder.variables(variables));
  }

  /**
   * Method under test: {@link Context#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange and Act
    Context actualShallowCloneResult = (new Context()).shallowClone();

    // Assert
    User user = actualShallowCloneResult.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertNull(actualShallowCloneResult.getOriginalOpChain());
    assertTrue(actualShallowCloneResult.getExporters().isEmpty());
    assertTrue(actualShallowCloneResult.getVariables().isEmpty());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
  }

  /**
   * Method under test: {@link Context#shallowClone()}
   */
  @Test
  void testShallowClone2() {
    // Arrange
    Context context = new Context();
    OperationChain<?> originalOpChain = new OperationChain<>();
    context.setOriginalOpChain(originalOpChain);

    // Act
    Context actualShallowCloneResult = context.shallowClone();

    // Assert
    User user = actualShallowCloneResult.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertTrue(actualShallowCloneResult.getExporters().isEmpty());
    assertTrue(actualShallowCloneResult.getVariables().isEmpty());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
    assertEquals(originalOpChain, actualShallowCloneResult.getOriginalOpChain());
  }

  /**
   * Method under test: {@link Context#shallowClone()}
   */
  @Test
  void testShallowClone3() {
    // Arrange
    Context context = new Context();
    context.setOriginalOpChain(new OperationChain<>(new DeleteAllData()));

    // Act
    Context actualShallowCloneResult = context.shallowClone();

    // Assert
    OperationChain<?> originalOpChain = actualShallowCloneResult.getOriginalOpChain();
    TypeReference<?> outputTypeReference = originalOpChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Void);
    List<Operation> operations = originalOpChain.getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof DeleteAllData);
    User user = actualShallowCloneResult.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertTrue(actualShallowCloneResult.getExporters().isEmpty());
    assertTrue(getResult.getOptions().isEmpty());
    assertTrue(originalOpChain.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.getVariables().isEmpty());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
    Class<Void> expectedOutputClass = Void.class;
    Class<?> outputClass = originalOpChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, originalOpChain.getOperationsClass());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, originalOpChain.getOutputType());
  }

  /**
   * Method under test: {@link Context#shallowClone()}
   */
  @Test
  void testShallowClone4() {
    // Arrange
    Context context = new Context();
    OperationChain<?> originalOpChain = new OperationChain<>(new OperationChain<>());
    context.setOriginalOpChain(originalOpChain);

    // Act
    Context actualShallowCloneResult = context.shallowClone();

    // Assert
    User user = actualShallowCloneResult.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertTrue(actualShallowCloneResult.getExporters().isEmpty());
    assertTrue(actualShallowCloneResult.getVariables().isEmpty());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
    assertEquals(originalOpChain, actualShallowCloneResult.getOriginalOpChain());
  }

  /**
   * Method under test: {@link Context#getVariable(String)}
   */
  @Test
  void testGetVariable() {
    // Arrange, Act and Assert
    assertNull((new Context()).getVariable("Key"));
  }

  /**
   * Method under test: {@link Context#getVariable(String)}
   */
  @Test
  void testGetVariable2() {
    // Arrange
    HashMap<String, Object> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));

    Context context = new Context();
    context.addVariables(variables);

    // Act and Assert
    assertNull(context.getVariable("Key"));
  }

  /**
   * Method under test: {@link Context#setVariable(String, Object)}
   */
  @Test
  void testSetVariable() {
    // Arrange
    Context context = new Context();

    // Act
    context.setVariable("Key", "Value");

    // Assert
    Map<String, Object> variables = context.getVariables();
    assertEquals(1, variables.size());
    assertEquals("Value", variables.get("Key"));
  }

  /**
   * Method under test: {@link Context#setVariable(String, Object)}
   */
  @Test
  void testSetVariable2() {
    // Arrange
    Context context = new Context();
    context.setVariables(null);

    // Act
    context.setVariable("Key", "Value");

    // Assert
    Map<String, Object> variables = context.getVariables();
    assertEquals(1, variables.size());
    assertEquals("Value", variables.get("Key"));
  }

  /**
   * Method under test: {@link Context#addVariables(Map)}
   */
  @Test
  void testAddVariables() {
    // Arrange
    Context context = new Context();

    // Act
    context.addVariables(new HashMap<>());

    // Assert
    assertTrue(context.getVariables().isEmpty());
  }

  /**
   * Method under test: {@link Context#addVariables(Map)}
   */
  @Test
  void testAddVariables2() {
    // Arrange
    Context context = new Context();
    context.setVariables(null);

    // Act
    context.addVariables(new HashMap<>());

    // Assert
    assertTrue(context.getVariables().isEmpty());
  }

  /**
   * Method under test: {@link Context#addVariables(Map)}
   */
  @Test
  void testAddVariables3() {
    // Arrange
    Context context = new Context();

    HashMap<String, Object> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    context.addVariables(variables);

    // Assert
    assertTrue(context.getVariables().isEmpty());
  }

  /**
   * Method under test: {@link Context#getExporters()}
   */
  @Test
  void testGetExporters() {
    // Arrange, Act and Assert
    assertTrue((new Context()).getExporters().isEmpty());
  }

  /**
   * Method under test: {@link Context#getExporters()}
   */
  @Test
  void testGetExporters2() {
    // Arrange
    HashMap<String, Object> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));

    Context context = new Context();
    context.addVariables(variables);

    // Act and Assert
    assertTrue(context.getExporters().isEmpty());
  }

  /**
   * Method under test: {@link Context#addExporter(Exporter)}
   */
  @Test
  void testAddExporter() {
    // Arrange
    Context context = new Context();

    // Act
    context.addExporter(new LocalFileExporter());

    // Assert
    assertEquals(1, context.getExporters().size());
  }

  /**
   * Method under test: {@link Context#addExporter(Exporter)}
   */
  @Test
  void testAddExporter2() {
    // Arrange
    Context context = new Context();
    context.addExporter(new LocalFileExporter());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> context.addExporter(new LocalFileExporter()));
  }

  /**
   * Method under test: {@link Context#getExporter(Class)}
   */
  @Test
  void testGetExporter() {
    // Arrange
    Context context = new Context();
    Class<Object> exporterClass = Object.class;

    // Act and Assert
    assertNull(context.getExporter(exporterClass));
  }

  /**
   * Method under test: {@link Context#getExporter(Class)}
   */
  @Test
  void testGetExporter2() {
    // Arrange
    Context context = new Context();
    LocalFileExporter exporter = new LocalFileExporter();
    context.addExporter(exporter);
    Class<Object> exporterClass = Object.class;

    // Act
    Object actualExporter = context.getExporter(exporterClass);

    // Assert
    assertTrue(actualExporter instanceof LocalFileExporter);
    assertSame(exporter, actualExporter);
  }

  /**
   * Method under test: {@link Context#getExporter(Class)}
   */
  @Test
  void testGetExporter3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Context()).getExporter(null));
  }

  /**
   * Method under test: {@link Context#getExporter(Class)}
   */
  @Test
  void testGetExporter4() {
    // Arrange
    Context context = new Context();
    context.addExporter(new LocalFileExporter());
    Class<Class> exporterClass = Class.class;

    // Act and Assert
    assertNull(context.getExporter(exporterClass));
  }

  /**
   * Method under test: {@link Context#getConfig(String)}
   */
  @Test
  void testGetConfig() {
    // Arrange, Act and Assert
    assertNull((new Context()).getConfig("Key"));
  }

  /**
   * Method under test: {@link Context#getConfig(String)}
   */
  @Test
  void testGetConfig2() {
    // Arrange
    HashMap<String, Object> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));

    Context context = new Context();
    context.addVariables(variables);

    // Act and Assert
    assertNull(context.getConfig("Key"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Context#equals(Object)}
   *   <li>{@link Context#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Context context = new Context();

    // Act and Assert
    assertEquals(context, context);
    int expectedHashCodeResult = context.hashCode();
    assertEquals(expectedHashCodeResult, context.hashCode());
  }

  /**
   * Method under test: {@link Context#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Context context = new Context();

    // Act and Assert
    assertNotEquals(context, new Context());
  }

  /**
   * Method under test: {@link Context#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Context context = new Context();
    context.setOriginalOpChain(mock(OperationChain.class));

    // Act and Assert
    assertNotEquals(context, new Context());
  }

  /**
   * Method under test: {@link Context#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Context(), null);
  }

  /**
   * Method under test: {@link Context#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Context(), "Different type to Context");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Context#setOriginalOpChain(OperationChain)}
   *   <li>{@link Context#setVariables(Map)}
   *   <li>{@link Context#getJobId()}
   *   <li>{@link Context#getOriginalOpChain()}
   *   <li>{@link Context#getUser()}
   *   <li>{@link Context#getVariables()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Context context = new Context();
    OperationChain<?> originalOpChain = new OperationChain<>();

    // Act
    context.setOriginalOpChain(originalOpChain);
    HashMap<String, Object> variables = new HashMap<>();
    context.setVariables(variables);
    context.getJobId();
    OperationChain<?> actualOriginalOpChain = context.getOriginalOpChain();
    User actualUser = context.getUser();
    Map<String, Object> actualVariables = context.getVariables();

    // Assert that nothing has changed
    assertEquals("UNKNOWN", actualUser.getUserId());
    assertTrue(actualVariables.isEmpty());
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertSame(variables, actualVariables);
    assertSame(originalOpChain, actualOriginalOpChain);
  }

  /**
   * Method under test: {@link Context#Context()}
   */
  @Test
  void testNewContext() {
    // Arrange and Act
    Context actualContext = new Context();

    // Assert
    User user = actualContext.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertNull(actualContext.getOriginalOpChain());
    assertTrue(actualContext.getExporters().isEmpty());
    assertTrue(actualContext.getVariables().isEmpty());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
  }

  /**
   * Method under test: {@link Context#Context(Context)}
   */
  @Test
  void testNewContext2() {
    // Arrange and Act
    Context actualContext = new Context(new Context());

    // Assert
    User user = actualContext.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertNull(actualContext.getOriginalOpChain());
    assertTrue(actualContext.getExporters().isEmpty());
    assertTrue(actualContext.getVariables().isEmpty());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
  }

  /**
   * Method under test: {@link Context#Context(Context)}
   */
  @Test
  void testNewContext3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Context((Context) null));
  }

  /**
   * Method under test: {@link Context#Context(Context)}
   */
  @Test
  void testNewContext4() {
    // Arrange
    Context context = new Context();
    OperationChain<?> originalOpChain = new OperationChain<>();
    context.setOriginalOpChain(originalOpChain);

    // Act
    Context actualContext = new Context(context);

    // Assert
    User user = actualContext.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertTrue(actualContext.getExporters().isEmpty());
    assertTrue(actualContext.getVariables().isEmpty());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
    assertEquals(originalOpChain, actualContext.getOriginalOpChain());
  }

  /**
   * Method under test: {@link Context#Context(Context)}
   */
  @Test
  void testNewContext5() {
    // Arrange
    Context context = new Context();
    context.setOriginalOpChain(new OperationChain<>(new DeleteAllData()));

    // Act
    Context actualContext = new Context(context);

    // Assert
    OperationChain<?> originalOpChain = actualContext.getOriginalOpChain();
    TypeReference<?> outputTypeReference = originalOpChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Void);
    List<Operation> operations = originalOpChain.getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof DeleteAllData);
    User user = actualContext.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertTrue(actualContext.getExporters().isEmpty());
    assertTrue(getResult.getOptions().isEmpty());
    assertTrue(originalOpChain.getOptions().isEmpty());
    assertTrue(actualContext.getVariables().isEmpty());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
    Class<Void> expectedOutputClass = Void.class;
    Class<?> outputClass = originalOpChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, originalOpChain.getOperationsClass());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, originalOpChain.getOutputType());
  }

  /**
   * Method under test: {@link Context#Context(Context)}
   */
  @Test
  void testNewContext6() {
    // Arrange
    Context context = new Context();
    OperationChain<?> originalOpChain = new OperationChain<>(new OperationChain<>());
    context.setOriginalOpChain(originalOpChain);

    // Act
    Context actualContext = new Context(context);

    // Assert
    User user = actualContext.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertTrue(actualContext.getExporters().isEmpty());
    assertTrue(actualContext.getVariables().isEmpty());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
    assertEquals(originalOpChain, actualContext.getOriginalOpChain());
  }

  /**
   * Method under test: {@link Context#Context(User)}
   */
  @Test
  void testNewContext7() {
    // Arrange
    User user = new User();

    // Act
    Context actualContext = new Context(user);

    // Assert
    assertNull(actualContext.getOriginalOpChain());
    assertTrue(actualContext.getExporters().isEmpty());
    assertTrue(actualContext.getVariables().isEmpty());
    assertSame(user, actualContext.getUser());
  }

  /**
   * Method under test: {@link Context#Context(User)}
   */
  @Test
  void testNewContext8() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Context((User) null));
  }
}
