package uk.gov.gchq.gaffer.operation.impl.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.generator.CsvGenerator;
import uk.gov.gchq.gaffer.operation.impl.output.ToCsv.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableString;

class ToCsvDiffblueTest {
  /**
   * Test Builder {@link Builder#generator(CsvGenerator)}.
   *
   * <p>Method under test: {@link Builder#generator(CsvGenerator)}
   */
  @Test
  @DisplayName("Test Builder generator(CsvGenerator)")
  @Tag("MaintainedByDiffblue")
  void testBuilderGenerator() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGeneratorResult = builder.generator(new CsvGenerator());

    // Assert
    assertSame(builder, actualGeneratorResult);
  }

  /**
   * Test Builder {@link Builder#includeHeader(boolean)}.
   *
   * <p>Method under test: {@link Builder#includeHeader(boolean)}
   */
  @Test
  @DisplayName("Test Builder includeHeader(boolean)")
  @Tag("MaintainedByDiffblue")
  void testBuilderIncludeHeader() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIncludeHeaderResult = builder.includeHeader(true);

    // Assert
    assertSame(builder, actualIncludeHeaderResult);
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
    ToCsv _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends String>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableString);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends java.lang.String>", outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getCsvGenerator());
    assertTrue(_getOpResult.isIncludeHeader());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    ToCsv actualToCsv = actualBuilder.build();
    assertSame(_getOpResult, actualToCsv);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToCsv#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToCsv#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ToCsv().getInput());
  }

  /**
   * Test {@link ToCsv#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ToCsv#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends String>> actualOutputTypeReference =
        new ToCsv().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableString);
    assertEquals(
        "java.lang.Iterable<? extends java.lang.String>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link ToCsv#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ToCsv} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToCsv#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ToCsv (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenToCsvOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    ToCsv toCsv = new ToCsv();
    toCsv.setOptions(new HashMap<>());

    // Act
    ToCsv actualShallowCloneResult = toCsv.shallowClone();

    // Assert
    TypeReference<Iterable<? extends String>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableString);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends java.lang.String>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getCsvGenerator());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.isIncludeHeader());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ToCsv#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ToCsv} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToCsv#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ToCsv (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenToCsv_thenReturnOptionsIsNull() {
    // Arrange and Act
    ToCsv actualShallowCloneResult = new ToCsv().shallowClone();

    // Assert
    TypeReference<Iterable<? extends String>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableString);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<? extends java.lang.String>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getCsvGenerator());
    assertTrue(actualShallowCloneResult.isIncludeHeader());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ToCsv}
   *   <li>{@link ToCsv#setCsvGenerator(CsvGenerator)}
   *   <li>{@link ToCsv#setIncludeHeader(boolean)}
   *   <li>{@link ToCsv#setInput(Iterable)}
   *   <li>{@link ToCsv#setOptions(Map)}
   *   <li>{@link ToCsv#getCsvGenerator()}
   *   <li>{@link ToCsv#getOptions()}
   *   <li>{@link ToCsv#isIncludeHeader()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ToCsv actualToCsv = new ToCsv();
    CsvGenerator csvGenerator =
        new CsvGenerator.Builder().commaReplacement("Comma Replacement").quoted(true).build();
    actualToCsv.setCsvGenerator(csvGenerator);
    actualToCsv.setIncludeHeader(true);
    ArrayList<Element> input = new ArrayList<>();
    actualToCsv.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualToCsv.setOptions(options);
    CsvGenerator actualCsvGenerator = actualToCsv.getCsvGenerator();
    Map<String, String> actualOptions = actualToCsv.getOptions();
    boolean actualIsIncludeHeaderResult = actualToCsv.isIncludeHeader();

    // Assert
    Iterable<? extends Element> input2 = actualToCsv.getInput();
    assertTrue(input2 instanceof List);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsIncludeHeaderResult);
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(csvGenerator, actualCsvGenerator);
  }
}
