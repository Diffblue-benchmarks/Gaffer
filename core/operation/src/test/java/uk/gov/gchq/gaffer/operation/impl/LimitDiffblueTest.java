package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.Limit.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableObj;

class LimitDiffblueTest {
  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder<Object> actualBuilder = new Builder<>();

    // Assert
    Limit<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(_getOpResult.getResultLimit());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertTrue(_getOpResult.getTruncate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    Limit<Object> actualLimit = actualBuilder.build();
    assertSame(_getOpResult, actualLimit);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test Builder {@link Builder#resultLimit(Integer)}.
   *
   * <p>Method under test: {@link Builder#resultLimit(Integer)}
   */
  @Test
  @DisplayName("Test Builder resultLimit(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.resultLimit(Integer)"})
  void testBuilderResultLimit() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualResultLimitResult = builder.resultLimit(1);

    // Assert
    assertSame(builder, actualResultLimitResult);
  }

  /**
   * Test Builder {@link Builder#truncate(Boolean)}.
   *
   * <p>Method under test: {@link Builder#truncate(Boolean)}
   */
  @Test
  @DisplayName("Test Builder truncate(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.truncate(Boolean)"})
  void testBuilderTruncate() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualTruncateResult = builder.truncate(true);

    // Assert
    assertSame(builder, actualTruncateResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Limit#Limit()}
   *   <li>{@link Limit#setInput(Iterable)}
   *   <li>{@link Limit#setOptions(Map)}
   *   <li>{@link Limit#setResultLimit(Integer)}
   *   <li>{@link Limit#setTruncate(boolean)}
   *   <li>{@link Limit#getOptions()}
   *   <li>{@link Limit#getResultLimit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Limit.<init>()",
    "void Limit.<init>(Integer)",
    "void Limit.<init>(Integer, boolean)",
    "Map Limit.getOptions()",
    "Integer Limit.getResultLimit()",
    "void Limit.setInput(Iterable)",
    "void Limit.setOptions(Map)",
    "void Limit.setResultLimit(Integer)",
    "void Limit.setTruncate(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Limit<Object> actualLimit = new Limit<>();
    ArrayList<Object> input = new ArrayList<>();
    actualLimit.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualLimit.setOptions(options);
    actualLimit.setResultLimit(1);
    actualLimit.setTruncate(true);
    Map<String, String> actualOptions = actualLimit.getOptions();
    Integer actualResultLimit = actualLimit.getResultLimit();

    // Assert
    Iterable<?> input2 = actualLimit.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(1, actualResultLimit.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Limit#Limit(Integer)}
   *   <li>{@link Limit#setInput(Iterable)}
   *   <li>{@link Limit#setOptions(Map)}
   *   <li>{@link Limit#setResultLimit(Integer)}
   *   <li>{@link Limit#setTruncate(boolean)}
   *   <li>{@link Limit#getOptions()}
   *   <li>{@link Limit#getResultLimit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Limit.<init>()",
    "void Limit.<init>(Integer)",
    "void Limit.<init>(Integer, boolean)",
    "Map Limit.getOptions()",
    "Integer Limit.getResultLimit()",
    "void Limit.setInput(Iterable)",
    "void Limit.setOptions(Map)",
    "void Limit.setResultLimit(Integer)",
    "void Limit.setTruncate(boolean)"
  })
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    Limit<Object> actualLimit = new Limit<>(1);
    ArrayList<Object> input = new ArrayList<>();
    actualLimit.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualLimit.setOptions(options);
    actualLimit.setResultLimit(1);
    actualLimit.setTruncate(true);
    Map<String, String> actualOptions = actualLimit.getOptions();
    Integer actualResultLimit = actualLimit.getResultLimit();

    // Assert
    Iterable<?> input2 = actualLimit.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(1, actualResultLimit.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Limit#Limit(Integer, boolean)}
   *   <li>{@link Limit#setInput(Iterable)}
   *   <li>{@link Limit#setOptions(Map)}
   *   <li>{@link Limit#setResultLimit(Integer)}
   *   <li>{@link Limit#setTruncate(boolean)}
   *   <li>{@link Limit#getOptions()}
   *   <li>{@link Limit#getResultLimit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Limit.<init>()",
    "void Limit.<init>(Integer)",
    "void Limit.<init>(Integer, boolean)",
    "Map Limit.getOptions()",
    "Integer Limit.getResultLimit()",
    "void Limit.setInput(Iterable)",
    "void Limit.setOptions(Map)",
    "void Limit.setResultLimit(Integer)",
    "void Limit.setTruncate(boolean)"
  })
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    Limit<Object> actualLimit = new Limit<>(1, true);
    ArrayList<Object> input = new ArrayList<>();
    actualLimit.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualLimit.setOptions(options);
    actualLimit.setResultLimit(1);
    actualLimit.setTruncate(true);
    Map<String, String> actualOptions = actualLimit.getOptions();
    Integer actualResultLimit = actualLimit.getResultLimit();

    // Assert
    Iterable<?> input2 = actualLimit.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(1, actualResultLimit.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }

  /**
   * Test {@link Limit#getTruncate()}.
   *
   * <ul>
   *   <li>Given {@link Limit#Limit(Integer, boolean)} with resultLimit is one and truncate is
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Limit#getTruncate()}
   */
  @Test
  @DisplayName(
      "Test getTruncate(); given Limit(Integer, boolean) with resultLimit is one and truncate is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Limit.getTruncate()"})
  void testGetTruncate_givenLimitWithResultLimitIsOneAndTruncateIsFalse_thenReturnFalse() {
    // Arrange
    Limit<Object> limit = new Limit<>(1, false);

    // Act and Assert
    assertFalse(limit.getTruncate());
  }

  /**
   * Test {@link Limit#getTruncate()}.
   *
   * <ul>
   *   <li>Given {@link Limit#Limit()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Limit#getTruncate()}
   */
  @Test
  @DisplayName("Test getTruncate(); given Limit(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Limit.getTruncate()"})
  void testGetTruncate_givenLimit_thenReturnTrue() {
    // Arrange
    Limit<Object> limit = new Limit<>();

    // Act and Assert
    assertTrue(limit.getTruncate());
  }

  /**
   * Test {@link Limit#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Limit#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable Limit.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange
    Limit<Object> limit = new Limit<>();

    // Act and Assert
    assertNull(limit.getInput());
  }

  /**
   * Test {@link Limit#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link Limit#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference Limit.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    Limit<Object> limit = new Limit<>();

    // Act
    TypeReference<Iterable<?>> actualOutputTypeReference = limit.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link Limit#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Limit#Limit()} Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link Limit#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given Limit() Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Limit Limit.shallowClone()"})
  void testShallowClone_givenLimitOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    Limit<Object> limit = new Limit<>();
    limit.setOptions(new HashMap<>());

    // Act
    Limit<Object> actualShallowCloneResult = limit.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getResultLimit());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.getTruncate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link Limit#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Limit#Limit()}.
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Limit#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given Limit(); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Limit Limit.shallowClone()"})
  void testShallowClone_givenLimit_thenReturnOptionsIsNull() {
    // Arrange
    Limit<Object> limit = new Limit<>();

    // Act
    Limit<Object> actualShallowCloneResult = limit.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getResultLimit());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertTrue(actualShallowCloneResult.getTruncate());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }
}
