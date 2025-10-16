package uk.gov.gchq.gaffer.operation.impl.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.output.ToStream.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ToStreamDiffblueTest {
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
    ToStream<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Stream<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Stream);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.stream.Stream<T>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    Class<Stream> expectedOutputClass = Stream.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    ToStream<Object> actualToStream = actualBuilder.build();
    assertSame(_getOpResult, actualToStream);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToStream#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToStream#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ToStream.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange
    ToStream<Object> toStream = new ToStream<>();

    // Act and Assert
    assertNull(toStream.getInput());
  }

  /**
   * Test {@link ToStream#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ToStream#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference ToStream.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    ToStream<Object> toStream = new ToStream<>();

    // Act
    TypeReference<Stream<?>> actualOutputTypeReference = toStream.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceImpl.Stream);
    assertEquals("java.util.stream.Stream<T>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link ToStream#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ToStream} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToStream#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ToStream (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToStream ToStream.shallowClone()"})
  void testShallowClone_givenToStreamOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    ToStream<Object> toStream = new ToStream<>();
    toStream.setOptions(new HashMap<>());

    // Act
    ToStream<Object> actualShallowCloneResult = toStream.shallowClone();

    // Assert
    TypeReference<Stream<?>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Stream);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.stream.Stream<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Stream> expectedOutputClass = Stream.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToStream#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ToStream} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToStream#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ToStream (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToStream ToStream.shallowClone()"})
  void testShallowClone_givenToStream_thenReturnOptionsIsNull() {
    // Arrange
    ToStream<Object> toStream = new ToStream<>();

    // Act
    ToStream<Object> actualShallowCloneResult = toStream.shallowClone();

    // Assert
    TypeReference<Stream<?>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Stream);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.stream.Stream<T>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Stream> expectedOutputClass = Stream.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ToStream}
   *   <li>{@link ToStream#setInput(Iterable)}
   *   <li>{@link ToStream#setOptions(Map)}
   *   <li>{@link ToStream#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToStream.<init>()",
    "Map ToStream.getOptions()",
    "void ToStream.setInput(Iterable)",
    "void ToStream.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ToStream<Object> actualToStream = new ToStream<>();
    ArrayList<Object> input = new ArrayList<>();
    actualToStream.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualToStream.setOptions(options);
    Map<String, String> actualOptions = actualToStream.getOptions();

    // Assert
    Iterable<?> input2 = actualToStream.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
