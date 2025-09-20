package uk.gov.gchq.gaffer.operation.impl.add;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.add.AddElementsFromKafka.Builder;
import uk.gov.gchq.koryphe.ValidationResult;

class AddElementsFromKafkaDiffblueTest {
  /**
   * Test Builder {@link Builder#bootstrapServers(String[])}.
   *
   * <p>Method under test: {@link Builder#bootstrapServers(String[])}
   */
  @Test
  @DisplayName("Test Builder bootstrapServers(String[])")
  @Tag("MaintainedByDiffblue")
  void testBuilderBootstrapServers() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualBootstrapServersResult = builder.bootstrapServers("Bootstrap Servers");

    // Assert
    assertSame(builder, actualBootstrapServersResult);
  }

  /**
   * Test Builder {@link Builder#generator(Class, Class)} with {@code consumeAs}, {@code generator}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#generator(Class, Class)}
   */
  @Test
  @DisplayName(
      "Test Builder generator(Class, Class) with 'consumeAs', 'generator'; when 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  void testBuilderGeneratorWithConsumeAsGenerator_whenJavaLangObject() {
    // Arrange
    Builder builder = new Builder();
    Class<Object> consumeAs = Object.class;
    Class<Function> forNameResult = Function.class;

    // Act
    Builder actualGeneratorResult =
        builder.generator(
            consumeAs, (Class<Function<? extends Iterable<?>, ?>>) (Class) forNameResult);

    // Assert
    assertSame(builder, actualGeneratorResult);
  }

  /**
   * Test Builder {@link Builder#generator(Class, Class)} with {@code consumeAs}, {@code generator}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#generator(Class, Class)}
   */
  @Test
  @DisplayName("Test Builder generator(Class, Class) with 'consumeAs', 'generator'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testBuilderGeneratorWithConsumeAsGenerator_whenNull() {
    // Arrange
    Builder builder = new Builder();
    Class<Function> forNameResult = Function.class;

    // Act
    Builder actualGeneratorResult =
        builder.generator(null, (Class<Function<? extends Iterable<?>, ?>>) (Class) forNameResult);

    // Assert
    assertSame(builder, actualGeneratorResult);
  }

  /**
   * Test Builder {@link Builder#generator(Class)} with {@code generator}.
   *
   * <p>Method under test: {@link Builder#generator(Class)}
   */
  @Test
  @DisplayName("Test Builder generator(Class) with 'generator'")
  @Tag("MaintainedByDiffblue")
  void testBuilderGeneratorWithGenerator() {
    // Arrange
    Builder builder = new Builder();
    Class<Function> forNameResult = Function.class;

    // Act
    Builder actualGeneratorResult =
        builder.generator(
            (Class<Function<Iterable<? extends String>, Iterable<? extends Element>>>)
                (Class) forNameResult);

    // Assert
    assertSame(builder, actualGeneratorResult);
  }

  /**
   * Test Builder {@link Builder#groupId(String)}.
   *
   * <p>Method under test: {@link Builder#groupId(String)}
   */
  @Test
  @DisplayName("Test Builder groupId(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderGroupId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGroupIdResult = builder.groupId("42");

    // Assert
    assertSame(builder, actualGroupIdResult);
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
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    AddElementsFromKafka _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getElementGenerator());
    assertNull(_getOpResult.getParallelism());
    assertNull(_getOpResult.getGroupId());
    assertNull(_getOpResult.getTopic());
    assertNull(_getOpResult.getBootstrapServers());
    assertNull(_getOpResult.getOptions());
    assertFalse(_getOpResult.isSkipInvalidElements());
    assertTrue(_getOpResult.isValidate());
    Class<String> expectedConsumeAs = String.class;
    assertEquals(expectedConsumeAs, _getOpResult.getConsumeAs());
    AddElementsFromKafka actualAddElementsFromKafka = actualBuilder.build();
    assertSame(_getOpResult, actualAddElementsFromKafka);
  }

  /**
   * Test Builder {@link Builder#parallelism(Integer)}.
   *
   * <p>Method under test: {@link Builder#parallelism(Integer)}
   */
  @Test
  @DisplayName("Test Builder parallelism(Integer)")
  @Tag("MaintainedByDiffblue")
  void testBuilderParallelism() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualParallelismResult = builder.parallelism(2);

    // Assert
    assertSame(builder, actualParallelismResult);
  }

  /**
   * Test Builder {@link Builder#topic(String)}.
   *
   * <p>Method under test: {@link Builder#topic(String)}
   */
  @Test
  @DisplayName("Test Builder topic(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderTopic() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualTopicResult = builder.topic("Topic");

    // Assert
    assertSame(builder, actualTopicResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AddElementsFromKafka#setBootstrapServers(String[])}
   *   <li>{@link AddElementsFromKafka#setElementGenerator(Class)}
   *   <li>{@link AddElementsFromKafka#setGroupId(String)}
   *   <li>{@link AddElementsFromKafka#setOptions(Map)}
   *   <li>{@link AddElementsFromKafka#setParallelism(Integer)}
   *   <li>{@link AddElementsFromKafka#setSkipInvalidElements(boolean)}
   *   <li>{@link AddElementsFromKafka#setTopic(String)}
   *   <li>{@link AddElementsFromKafka#setValidate(boolean)}
   *   <li>{@link AddElementsFromKafka#getBootstrapServers()}
   *   <li>{@link AddElementsFromKafka#getConsumeAs()}
   *   <li>{@link AddElementsFromKafka#getElementGenerator()}
   *   <li>{@link AddElementsFromKafka#getGroupId()}
   *   <li>{@link AddElementsFromKafka#getOptions()}
   *   <li>{@link AddElementsFromKafka#getParallelism()}
   *   <li>{@link AddElementsFromKafka#getTopic()}
   *   <li>{@link AddElementsFromKafka#isSkipInvalidElements()}
   *   <li>{@link AddElementsFromKafka#isValidate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange
    AddElementsFromKafka addElementsFromKafka = new AddElementsFromKafka();
    String[] bootstrapServers = new String[] {"Bootstrap Servers"};

    // Act
    addElementsFromKafka.setBootstrapServers(bootstrapServers);
    Class<Function> forNameResult = Function.class;
    addElementsFromKafka.setElementGenerator(
        (Class<Function<Iterable<?>, Iterable<? extends Element>>>) (Class) forNameResult);
    addElementsFromKafka.setGroupId("42");
    HashMap<String, String> options = new HashMap<>();
    addElementsFromKafka.setOptions(options);
    addElementsFromKafka.setParallelism(2);
    addElementsFromKafka.setSkipInvalidElements(true);
    addElementsFromKafka.setTopic("Topic");
    addElementsFromKafka.setValidate(true);
    String[] actualBootstrapServers = addElementsFromKafka.getBootstrapServers();
    Class<?> actualConsumeAs = addElementsFromKafka.getConsumeAs();
    Class<? extends Function<Iterable<?>, Iterable<? extends Element>>> actualElementGenerator =
        addElementsFromKafka.getElementGenerator();
    String actualGroupId = addElementsFromKafka.getGroupId();
    Map<String, String> actualOptions = addElementsFromKafka.getOptions();
    Integer actualParallelism = addElementsFromKafka.getParallelism();
    String actualTopic = addElementsFromKafka.getTopic();
    boolean actualIsSkipInvalidElementsResult = addElementsFromKafka.isSkipInvalidElements();
    boolean actualIsValidateResult = addElementsFromKafka.isValidate();

    // Assert
    assertEquals("42", actualGroupId);
    assertEquals("Topic", actualTopic);
    assertEquals(2, actualParallelism.intValue());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsSkipInvalidElementsResult);
    assertTrue(actualIsValidateResult);
    Class<String> expectedConsumeAs = String.class;
    assertEquals(expectedConsumeAs, actualConsumeAs);
    Class<Function> expectedElementGenerator = Function.class;
    assertEquals(expectedElementGenerator, actualElementGenerator);
    assertSame(options, actualOptions);
    assertSame(bootstrapServers, actualBootstrapServers);
    assertSame(AddElementsFromKafka.DEFAULT_CONSUME_AS, actualConsumeAs);
    assertSame((Class) forNameResult, actualElementGenerator);
    assertArrayEquals(new String[] {"Bootstrap Servers"}, actualBootstrapServers);
  }

  /**
   * Test {@link AddElementsFromKafka#setConsumeAs(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then {@link AddElementsFromKafka} (default constructor) ConsumeAs is {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromKafka#setConsumeAs(Class)}
   */
  @Test
  @DisplayName(
      "Test setConsumeAs(Class); when 'java.lang.Object'; then AddElementsFromKafka (default constructor) ConsumeAs is Object")
  @Tag("MaintainedByDiffblue")
  void testSetConsumeAs_whenJavaLangObject_thenAddElementsFromKafkaConsumeAsIsObject() {
    // Arrange
    AddElementsFromKafka addElementsFromKafka = new AddElementsFromKafka();
    Class<Object> consumeAs = Object.class;

    // Act
    addElementsFromKafka.setConsumeAs(consumeAs);

    // Assert
    Class<Object> expectedConsumeAs = Object.class;
    assertEquals(expectedConsumeAs, addElementsFromKafka.getConsumeAs());
  }

  /**
   * Test {@link AddElementsFromKafka#setConsumeAs(Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link AddElementsFromKafka} (default constructor) ConsumeAs is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromKafka#setConsumeAs(Class)}
   */
  @Test
  @DisplayName(
      "Test setConsumeAs(Class); when 'null'; then AddElementsFromKafka (default constructor) ConsumeAs is 'null'")
  @Tag("MaintainedByDiffblue")
  void testSetConsumeAs_whenNull_thenAddElementsFromKafkaConsumeAsIsNull() {
    // Arrange
    AddElementsFromKafka addElementsFromKafka = new AddElementsFromKafka();

    // Act
    addElementsFromKafka.setConsumeAs(null);

    // Assert
    assertNull(addElementsFromKafka.getConsumeAs());
  }

  /**
   * Test {@link AddElementsFromKafka#validate()}.
   *
   * <p>Method under test: {@link AddElementsFromKafka#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("MaintainedByDiffblue")
  void testValidate() {
    // Arrange and Act
    ValidationResult actualValidateResult = new AddElementsFromKafka().validate();

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "bootstrapServers is required for: AddElementsFromKafka\n"
            + "groupId is required for: AddElementsFromKafka\n"
            + "elementGenerator is required for: AddElementsFromKafka\n"
            + "topic is required for: AddElementsFromKafka",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(4, errors.size());
    assertTrue(errors.contains("bootstrapServers is required for: AddElementsFromKafka"));
    assertTrue(errors.contains("elementGenerator is required for: AddElementsFromKafka"));
    assertTrue(errors.contains("groupId is required for: AddElementsFromKafka"));
    assertTrue(errors.contains("topic is required for: AddElementsFromKafka"));
  }

  /**
   * Test {@link AddElementsFromKafka#validate()}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code foo}.
   *   <li>Then return Errors size is three.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromKafka#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given array of String with 'foo'; then return Errors size is three")
  @Tag("MaintainedByDiffblue")
  void testValidate_givenArrayOfStringWithFoo_thenReturnErrorsSizeIsThree() {
    // Arrange
    AddElementsFromKafka addElementsFromKafka = new AddElementsFromKafka();
    addElementsFromKafka.setBootstrapServers("foo");

    // Act
    ValidationResult actualValidateResult = addElementsFromKafka.validate();

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "groupId is required for: AddElementsFromKafka\n"
            + "elementGenerator is required for: AddElementsFromKafka\n"
            + "topic is required for: AddElementsFromKafka",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(3, errors.size());
    assertTrue(errors.contains("elementGenerator is required for: AddElementsFromKafka"));
    assertTrue(errors.contains("groupId is required for: AddElementsFromKafka"));
    assertTrue(errors.contains("topic is required for: AddElementsFromKafka"));
  }

  /**
   * Test {@link AddElementsFromKafka#validate()}.
   *
   * <ul>
   *   <li>Then return Errors contains {@code At least 1 bootstrap server is required.}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromKafka#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); then return Errors contains 'At least 1 bootstrap server is required.'")
  @Tag("MaintainedByDiffblue")
  void testValidate_thenReturnErrorsContainsAtLeast1BootstrapServerIsRequired() {
    // Arrange
    AddElementsFromKafka addElementsFromKafka = new AddElementsFromKafka();
    addElementsFromKafka.setBootstrapServers();

    // Act
    ValidationResult actualValidateResult = addElementsFromKafka.validate();

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "groupId is required for: AddElementsFromKafka\n"
            + "elementGenerator is required for: AddElementsFromKafka\n"
            + "topic is required for: AddElementsFromKafka\n"
            + "At least 1 bootstrap server is required.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(4, errors.size());
    assertTrue(errors.contains("At least 1 bootstrap server is required."));
    assertTrue(errors.contains("elementGenerator is required for: AddElementsFromKafka"));
    assertTrue(errors.contains("groupId is required for: AddElementsFromKafka"));
    assertTrue(errors.contains("topic is required for: AddElementsFromKafka"));
  }

  /**
   * Test {@link AddElementsFromKafka#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddElementsFromKafka} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromKafka#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddElementsFromKafka (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenAddElementsFromKafka_thenReturnOptionsIsNull() {
    // Arrange and Act
    AddElementsFromKafka actualShallowCloneResult = new AddElementsFromKafka().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getElementGenerator());
    assertNull(actualShallowCloneResult.getParallelism());
    assertNull(actualShallowCloneResult.getGroupId());
    assertNull(actualShallowCloneResult.getTopic());
    assertNull(actualShallowCloneResult.getBootstrapServers());
    assertNull(actualShallowCloneResult.getOptions());
    assertFalse(actualShallowCloneResult.isSkipInvalidElements());
    assertTrue(actualShallowCloneResult.isValidate());
    Class<String> expectedConsumeAs = String.class;
    assertEquals(expectedConsumeAs, actualShallowCloneResult.getConsumeAs());
  }

  /**
   * Test {@link AddElementsFromKafka#shallowClone()}.
   *
   * <ul>
   *   <li>Then return ConsumeAs is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromKafka#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return ConsumeAs is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_thenReturnConsumeAsIsNull() {
    // Arrange
    AddElementsFromKafka addElementsFromKafka = new AddElementsFromKafka();
    addElementsFromKafka.setConsumeAs(null);

    // Act
    AddElementsFromKafka actualShallowCloneResult = addElementsFromKafka.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getConsumeAs());
    assertNull(actualShallowCloneResult.getElementGenerator());
    assertNull(actualShallowCloneResult.getParallelism());
    assertNull(actualShallowCloneResult.getGroupId());
    assertNull(actualShallowCloneResult.getTopic());
    assertNull(actualShallowCloneResult.getBootstrapServers());
    assertNull(actualShallowCloneResult.getOptions());
    assertFalse(actualShallowCloneResult.isSkipInvalidElements());
    assertTrue(actualShallowCloneResult.isValidate());
  }

  /**
   * Test {@link AddElementsFromKafka#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddElementsFromKafka#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    AddElementsFromKafka addElementsFromKafka = new AddElementsFromKafka();
    addElementsFromKafka.setOptions(new HashMap<>());

    // Act
    AddElementsFromKafka actualShallowCloneResult = addElementsFromKafka.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getElementGenerator());
    assertNull(actualShallowCloneResult.getParallelism());
    assertNull(actualShallowCloneResult.getGroupId());
    assertNull(actualShallowCloneResult.getTopic());
    assertNull(actualShallowCloneResult.getBootstrapServers());
    assertFalse(actualShallowCloneResult.isSkipInvalidElements());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.isValidate());
    Class<String> expectedConsumeAs = String.class;
    assertEquals(expectedConsumeAs, actualShallowCloneResult.getConsumeAs());
  }

  /**
   * Test new {@link AddElementsFromKafka} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AddElementsFromKafka}
   */
  @Test
  @DisplayName("Test new AddElementsFromKafka (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewAddElementsFromKafka() {
    // Arrange and Act
    AddElementsFromKafka actualAddElementsFromKafka = new AddElementsFromKafka();

    // Assert
    assertNull(actualAddElementsFromKafka.getElementGenerator());
    assertNull(actualAddElementsFromKafka.getParallelism());
    assertNull(actualAddElementsFromKafka.getGroupId());
    assertNull(actualAddElementsFromKafka.getTopic());
    assertNull(actualAddElementsFromKafka.getBootstrapServers());
    assertNull(actualAddElementsFromKafka.getOptions());
    assertFalse(actualAddElementsFromKafka.isSkipInvalidElements());
    assertTrue(actualAddElementsFromKafka.isValidate());
    Class<String> expectedConsumeAs = String.class;
    assertEquals(expectedConsumeAs, actualAddElementsFromKafka.getConsumeAs());
  }
}
