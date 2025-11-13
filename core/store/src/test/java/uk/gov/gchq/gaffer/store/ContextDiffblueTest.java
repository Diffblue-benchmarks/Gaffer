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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.export.Exporter;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.LocalFileExporter;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.user.User;

class ContextDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#user(User)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Context Builder.build()", "Builder Builder.user(User)"})
  void testBuilderBuild() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();

    // Act
    Context actualBuildResult = builder.user(user).build();

    // Assert
    User user2 = actualBuildResult.getUser();
    assertEquals("42", user2.getUserId());
    assertNull(actualBuildResult.getOriginalOpChain());
    assertTrue(actualBuildResult.getExporters().isEmpty());
    assertTrue(actualBuildResult.getVariables().isEmpty());
    assertTrue(user2.getDataAuths().isEmpty());
    assertTrue(user2.getOpAuths().isEmpty());
  }

  /**
   * Test Builder {@link Builder#config(String, Object)}.
   * <p>
   * Method under test: {@link Builder#config(String, Object)}
   */
  @Test
  @DisplayName("Test Builder config(String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.config(String, Object)"})
  void testBuilderConfig() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.config("Key", "Value"));
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    Context buildResult = (new Builder()).build();
    User user = buildResult.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertNull(buildResult.getOriginalOpChain());
    assertTrue(buildResult.getExporters().isEmpty());
    assertTrue(buildResult.getVariables().isEmpty());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
  }

  /**
   * Test Builder {@link Builder#variable(String, Object)}.
   * <p>
   * Method under test: {@link Builder#variable(String, Object)}
   */
  @Test
  @DisplayName("Test Builder variable(String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.variable(String, Object)"})
  void testBuilderVariable() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.variable("Key", "Value"));
  }

  /**
   * Test Builder {@link Builder#variables(Map)}.
   * <p>
   * Method under test: {@link Builder#variables(Map)}
   */
  @Test
  @DisplayName("Test Builder variables(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.variables(Map)"})
  void testBuilderVariables() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.variables(new HashMap<>()));
  }

  /**
   * Test {@link Context#Context()}.
   * <p>
   * Method under test: {@link Context#Context()}
   */
  @Test
  @DisplayName("Test new Context()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Context.<init>()"})
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
   * Test {@link Context#Context(Context)}.
   * <ul>
   *   <li>When {@link Context#Context()}.</li>
   *   <li>Then return User UserId is {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#Context(Context)}
   */
  @Test
  @DisplayName("Test new Context(Context); when Context(); then return User UserId is 'UNKNOWN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Context.<init>(Context)"})
  void testNewContext_whenContext_thenReturnUserUserIdIsUnknown() {
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
   * Test {@link Context#Context(Context)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#Context(Context)}
   */
  @Test
  @DisplayName("Test new Context(Context); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Context.<init>(Context)"})
  void testNewContext_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Context((Context) null));
  }

  /**
   * Test {@link Context#Context(User)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#Context(User)}
   */
  @Test
  @DisplayName("Test new Context(User); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Context.<init>(User)"})
  void testNewContext_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Context((User) null));
  }

  /**
   * Test {@link Context#Context(User)}.
   * <ul>
   *   <li>When {@link User#User()}.</li>
   *   <li>Then return OriginalOpChain is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#Context(User)}
   */
  @Test
  @DisplayName("Test new Context(User); when User(); then return OriginalOpChain is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Context.<init>(User)"})
  void testNewContext_whenUser_thenReturnOriginalOpChainIsNull() {
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
   * Test {@link Context#shallowClone()}.
   * <p>
   * Method under test: {@link Context#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Context Context.shallowClone()"})
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Context#setVariables(Map)}
   *   <li>{@link Context#toString()}
   *   <li>{@link Context#getJobId()}
   *   <li>{@link Context#getOriginalOpChain()}
   *   <li>{@link Context#getUser()}
   *   <li>{@link Context#getVariables()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Context.getJobId()", "OperationChain Context.getOriginalOpChain()",
      "User Context.getUser()", "Map Context.getVariables()", "void Context.setOriginalOpChain(OperationChain)",
      "void Context.setVariables(Map)", "String Context.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();
    HashMap<String, Object> variables = new HashMap<>();

    // Act
    buildResult.setVariables(variables);
    buildResult.toString();
    buildResult.getJobId();
    OperationChain<?> actualOriginalOpChain = buildResult.getOriginalOpChain();
    User actualUser = buildResult.getUser();
    Map<String, Object> actualVariables = buildResult.getVariables();

    // Assert
    assertEquals("42", actualUser.getUserId());
    assertNull(actualOriginalOpChain);
    assertTrue(actualVariables.isEmpty());
    assertTrue(actualUser.getDataAuths().isEmpty());
    assertTrue(actualUser.getOpAuths().isEmpty());
    assertSame(variables, actualVariables);
  }

  /**
   * Test {@link Context#getVariable(String)}.
   * <p>
   * Method under test: {@link Context#getVariable(String)}
   */
  @Test
  @DisplayName("Test getVariable(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Context.getVariable(String)"})
  void testGetVariable() {
    // Arrange, Act and Assert
    assertNull((new Context()).getVariable("Key"));
  }

  /**
   * Test {@link Context#setVariable(String, Object)}.
   * <ul>
   *   <li>Given {@link Context#Context()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#setVariable(String, Object)}
   */
  @Test
  @DisplayName("Test setVariable(String, Object); given Context()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Context.setVariable(String, Object)"})
  void testSetVariable_givenContext() {
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
   * Test {@link Context#setVariable(String, Object)}.
   * <ul>
   *   <li>Given {@link Context#Context()} Variables is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#setVariable(String, Object)}
   */
  @Test
  @DisplayName("Test setVariable(String, Object); given Context() Variables is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Context.setVariable(String, Object)"})
  void testSetVariable_givenContextVariablesIsNull() {
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
   * Test {@link Context#addVariables(Map)}.
   * <ul>
   *   <li>Given {@link Context#Context()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#addVariables(Map)}
   */
  @Test
  @DisplayName("Test addVariables(Map); given Context()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Context.addVariables(Map)"})
  void testAddVariables_givenContext() {
    // Arrange
    Context context = new Context();

    // Act
    context.addVariables(new HashMap<>());

    // Assert that nothing has changed
    assertTrue(context.getVariables().isEmpty());
  }

  /**
   * Test {@link Context#addVariables(Map)}.
   * <ul>
   *   <li>Given {@link Context#Context()} Variables is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#addVariables(Map)}
   */
  @Test
  @DisplayName("Test addVariables(Map); given Context() Variables is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Context.addVariables(Map)"})
  void testAddVariables_givenContextVariablesIsNull() {
    // Arrange
    Context context = new Context();
    context.setVariables(null);

    // Act
    context.addVariables(new HashMap<>());

    // Assert
    assertTrue(context.getVariables().isEmpty());
  }

  /**
   * Test {@link Context#getExporters()}.
   * <p>
   * Method under test: {@link Context#getExporters()}
   */
  @Test
  @DisplayName("Test getExporters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Collection Context.getExporters()"})
  void testGetExporters() {
    // Arrange, Act and Assert
    assertTrue((new Context()).getExporters().isEmpty());
  }

  /**
   * Test {@link Context#addExporter(Exporter)}.
   * <ul>
   *   <li>Given {@link Context#Context()}.</li>
   *   <li>When {@link LocalFileExporter} (default constructor).</li>
   *   <li>Then {@link Context#Context()} Exporters size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#addExporter(Exporter)}
   */
  @Test
  @DisplayName("Test addExporter(Exporter); given Context(); when LocalFileExporter (default constructor); then Context() Exporters size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Context.addExporter(Exporter)"})
  void testAddExporter_givenContext_whenLocalFileExporter_thenContextExportersSizeIsOne() {
    // Arrange
    Context context = new Context();

    // Act
    context.addExporter(new LocalFileExporter());

    // Assert
    assertEquals(1, context.getExporters().size());
  }

  /**
   * Test {@link Context#addExporter(Exporter)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#addExporter(Exporter)}
   */
  @Test
  @DisplayName("Test addExporter(Exporter); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Context.addExporter(Exporter)"})
  void testAddExporter_thenThrowIllegalArgumentException() {
    // Arrange
    Context context = new Context();
    context.addExporter(new LocalFileExporter());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> context.addExporter(new LocalFileExporter()));
  }

  /**
   * Test {@link Context#getExporter(Class)}.
   * <ul>
   *   <li>Given {@link Context#Context()}.</li>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#getExporter(Class)}
   */
  @Test
  @DisplayName("Test getExporter(Class); given Context(); when 'java.lang.Object'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Context.getExporter(Class)"})
  void testGetExporter_givenContext_whenJavaLangObject_thenReturnNull() {
    // Arrange
    Context context = new Context();
    Class<Object> exporterClass = Object.class;

    // Act and Assert
    assertNull(context.getExporter(exporterClass));
  }

  /**
   * Test {@link Context#getExporter(Class)}.
   * <ul>
   *   <li>Given {@link Context#Context()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#getExporter(Class)}
   */
  @Test
  @DisplayName("Test getExporter(Class); given Context(); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Context.getExporter(Class)"})
  void testGetExporter_givenContext_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Context()).getExporter(null));
  }

  /**
   * Test {@link Context#getExporter(Class)}.
   * <ul>
   *   <li>Then return {@link LocalFileExporter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#getExporter(Class)}
   */
  @Test
  @DisplayName("Test getExporter(Class); then return LocalFileExporter")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Context.getExporter(Class)"})
  void testGetExporter_thenReturnLocalFileExporter() {
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
   * Test {@link Context#getExporter(Class)}.
   * <ul>
   *   <li>When {@code Class}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#getExporter(Class)}
   */
  @Test
  @DisplayName("Test getExporter(Class); when 'java.lang.Class'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Context.getExporter(Class)"})
  void testGetExporter_whenJavaLangClass_thenReturnNull() {
    // Arrange
    Context context = new Context();
    context.addExporter(new LocalFileExporter());
    Class<Class> exporterClass = Class.class;

    // Act and Assert
    assertNull(context.getExporter(exporterClass));
  }

  /**
   * Test {@link Context#getConfig(String)}.
   * <p>
   * Method under test: {@link Context#getConfig(String)}
   */
  @Test
  @DisplayName("Test getConfig(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Context.getConfig(String)"})
  void testGetConfig() {
    // Arrange, Act and Assert
    assertNull((new Context()).getConfig("Key"));
  }

  /**
   * Test {@link Context#equals(Object)}, and {@link Context#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Context#equals(Object)}
   *   <li>{@link Context#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Context.equals(Object)", "int Context.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link Context#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Context.equals(Object)", "int Context.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();

    Builder builder2 = new Builder();
    User user2 = (new User.Builder()).userId("42").build();
    Context buildResult2 = builder2.user(user2).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link Context#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Context.equals(Object)", "int Context.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link Context#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Context#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Context.equals(Object)", "int Context.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context buildResult = builder.user(user).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to Context");
  }
}
