package uk.gov.gchq.gaffer.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#user(User)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilder = new Builder();
    User user = new User.Builder().userId("42").build();
    Context actualContext = actualBuilder.user(user).build();

    // Assert
    assertNull(actualContext.getOriginalOpChain());
    assertTrue(actualContext.getExporters().isEmpty());
    assertTrue(actualContext.getVariables().isEmpty());
    assertSame(user, actualContext.getUser());
  }

  /**
   * Test Builder {@link Builder#config(String, Object)}.
   *
   * <p>Method under test: {@link Builder#config(String, Object)}
   */
  @Test
  @DisplayName("Test Builder config(String, Object)")
  @Tag("MaintainedByDiffblue")
  void testBuilderConfig() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConfigResult = builder.config("Key", "Value");

    // Assert
    assertSame(builder, actualConfigResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    Context context = new Builder().build();
    User user = context.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertNull(context.getOriginalOpChain());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
  }

  /**
   * Test Builder {@link Builder#variable(String, Object)}.
   *
   * <p>Method under test: {@link Builder#variable(String, Object)}
   */
  @Test
  @DisplayName("Test Builder variable(String, Object)")
  @Tag("MaintainedByDiffblue")
  void testBuilderVariable() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualVariableResult = builder.variable("Key", "Value");

    // Assert
    assertSame(builder, actualVariableResult);
  }

  /**
   * Test Builder {@link Builder#variables(Map)}.
   *
   * <p>Method under test: {@link Builder#variables(Map)}
   */
  @Test
  @DisplayName("Test Builder variables(Map)")
  @Tag("MaintainedByDiffblue")
  void testBuilderVariables() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualVariablesResult = builder.variables(new HashMap<>());

    // Assert
    assertSame(builder, actualVariablesResult);
  }

  /**
   * Test {@link Context#Context()}.
   *
   * <p>Method under test: {@link Context#Context()}
   */
  @Test
  @DisplayName("Test new Context()")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>When {@link Context#Context()}.
   *   <li>Then return User UserId is {@code UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link Context#Context(Context)}
   */
  @Test
  @DisplayName("Test new Context(Context); when Context(); then return User UserId is 'UNKNOWN'")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Context#Context(Context)}
   */
  @Test
  @DisplayName("Test new Context(Context); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewContext_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Context((Context) null));
  }

  /**
   * Test {@link Context#Context(User)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Context#Context(User)}
   */
  @Test
  @DisplayName("Test new Context(User); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testNewContext_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Context((User) null));
  }

  /**
   * Test {@link Context#Context(User)}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   *   <li>Then return OriginalOpChain is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Context#Context(User)}
   */
  @Test
  @DisplayName("Test new Context(User); when User(); then return OriginalOpChain is 'null'")
  @Tag("MaintainedByDiffblue")
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
   *
   * <p>Method under test: {@link Context#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("MaintainedByDiffblue")
  void testShallowClone() {
    // Arrange and Act
    Context actualShallowCloneResult = new Context().shallowClone();

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
   *
   * <p>Methods under test:
   *
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
  void testGettersAndSetters() {
    // Arrange
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    HashMap<String, Object> variables = new HashMap<>();

    // Act
    context.setVariables(variables);
    context.toString();
    context.getJobId();
    OperationChain<?> actualOriginalOpChain = context.getOriginalOpChain();
    User actualUser = context.getUser();
    Map<String, Object> actualVariables = context.getVariables();

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
   *
   * <p>Method under test: {@link Context#getVariable(String)}
   */
  @Test
  @DisplayName("Test getVariable(String)")
  @Tag("MaintainedByDiffblue")
  void testGetVariable() {
    // Arrange, Act and Assert
    assertNull(new Context().getVariable("Key"));
  }

  /**
   * Test {@link Context#setVariable(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link Context#Context()}.
   *   <li>Then {@link Context#Context()} Variables size is one.
   * </ul>
   *
   * <p>Method under test: {@link Context#setVariable(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setVariable(String, Object); given Context(); then Context() Variables size is one")
  @Tag("MaintainedByDiffblue")
  void testSetVariable_givenContext_thenContextVariablesSizeIsOne() {
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
   *
   * <ul>
   *   <li>Then {@link Context#Context(Context)} with context is {@link Context#Context()} Variables
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link Context#setVariable(String, Object)}
   */
  @Test
  @DisplayName(
      "Test setVariable(String, Object); then Context(Context) with context is Context() Variables size is one")
  @Tag("MaintainedByDiffblue")
  void testSetVariable_thenContextWithContextIsContextVariablesSizeIsOne() {
    // Arrange
    Context context = new Context(new Context());
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
   *
   * <ul>
   *   <li>Given {@link Context#Context()}.
   *   <li>Then {@link Context#Context()} Variables Empty.
   * </ul>
   *
   * <p>Method under test: {@link Context#addVariables(Map)}
   */
  @Test
  @DisplayName("Test addVariables(Map); given Context(); then Context() Variables Empty")
  @Tag("MaintainedByDiffblue")
  void testAddVariables_givenContext_thenContextVariablesEmpty() {
    // Arrange
    Context context = new Context();

    // Act
    context.addVariables(new HashMap<>());

    // Assert that nothing has changed
    assertTrue(context.getVariables().isEmpty());
  }

  /**
   * Test {@link Context#addVariables(Map)}.
   *
   * <ul>
   *   <li>Then {@link Context#Context(Context)} with context is {@link Context#Context()} Variables
   *       Empty.
   * </ul>
   *
   * <p>Method under test: {@link Context#addVariables(Map)}
   */
  @Test
  @DisplayName(
      "Test addVariables(Map); then Context(Context) with context is Context() Variables Empty")
  @Tag("MaintainedByDiffblue")
  void testAddVariables_thenContextWithContextIsContextVariablesEmpty() {
    // Arrange
    Context context = new Context(new Context());
    context.setVariables(null);

    // Act
    context.addVariables(new HashMap<>());

    // Assert
    assertTrue(context.getVariables().isEmpty());
  }

  /**
   * Test {@link Context#getExporters()}.
   *
   * <p>Method under test: {@link Context#getExporters()}
   */
  @Test
  @DisplayName("Test getExporters()")
  @Tag("MaintainedByDiffblue")
  void testGetExporters() {
    // Arrange, Act and Assert
    assertTrue(new Context().getExporters().isEmpty());
  }

  /**
   * Test {@link Context#addExporter(Exporter)}.
   *
   * <ul>
   *   <li>Given {@link Context#Context()}.
   *   <li>When {@link LocalFileExporter} (default constructor).
   *   <li>Then {@link Context#Context()} Exporters size is one.
   * </ul>
   *
   * <p>Method under test: {@link Context#addExporter(Exporter)}
   */
  @Test
  @DisplayName(
      "Test addExporter(Exporter); given Context(); when LocalFileExporter (default constructor); then Context() Exporters size is one")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Context#addExporter(Exporter)}
   */
  @Test
  @DisplayName("Test addExporter(Exporter); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testAddExporter_thenThrowIllegalArgumentException() {
    // Arrange
    Context context = new Context();
    context.addExporter(new LocalFileExporter());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> context.addExporter(new LocalFileExporter()));
  }

  /**
   * Test {@link Context#getExporter(Class)}.
   *
   * <ul>
   *   <li>Given {@link Context#Context()}.
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Context#getExporter(Class)}
   */
  @Test
  @DisplayName(
      "Test getExporter(Class); given Context(); when 'java.lang.Object'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetExporter_givenContext_whenJavaLangObject_thenReturnNull() {
    // Arrange
    Context context = new Context();
    Class<Object> exporterClass = Object.class;

    // Act and Assert
    assertNull(context.getExporter(exporterClass));
  }

  /**
   * Test {@link Context#getExporter(Class)}.
   *
   * <ul>
   *   <li>Given {@link Context#Context()}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Context#getExporter(Class)}
   */
  @Test
  @DisplayName(
      "Test getExporter(Class); given Context(); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testGetExporter_givenContext_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Context().getExporter(null));
  }

  /**
   * Test {@link Context#getExporter(Class)}.
   *
   * <ul>
   *   <li>Then return {@link LocalFileExporter}.
   * </ul>
   *
   * <p>Method under test: {@link Context#getExporter(Class)}
   */
  @Test
  @DisplayName("Test getExporter(Class); then return LocalFileExporter")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>When {@code Class}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Context#getExporter(Class)}
   */
  @Test
  @DisplayName("Test getExporter(Class); when 'java.lang.Class'; then return 'null'")
  @Tag("MaintainedByDiffblue")
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
   *
   * <p>Method under test: {@link Context#getConfig(String)}
   */
  @Test
  @DisplayName("Test getConfig(String)")
  @Tag("MaintainedByDiffblue")
  void testGetConfig() {
    // Arrange, Act and Assert
    assertNull(new Context().getConfig("Key"));
  }

  /**
   * Test {@link Context#equals(Object)}, and {@link Context#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Context#equals(Object)}
   *   <li>{@link Context#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();

    // Act and Assert
    assertEquals(context, context);
    int expectedHashCodeResult = context.hashCode();
    assertEquals(expectedHashCodeResult, context.hashCode());
  }

  /**
   * Test {@link Context#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Context#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();

    Builder builder2 = new Builder();

    // Act and Assert
    assertNotEquals(context, builder2.user(new User.Builder().userId("42").build()).build());
  }

  /**
   * Test {@link Context#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Context#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertNotEquals(builder.user(new User.Builder().userId("42").build()).build(), null);
  }

  /**
   * Test {@link Context#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Context#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertNotEquals(
        builder.user(new User.Builder().userId("42").build()).build(), "Different type to Context");
  }
}
