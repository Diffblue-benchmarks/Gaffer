package uk.gov.gchq.gaffer.operation.impl.export.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.set.ExportToSet.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ExportToSetDiffblueTest {
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
    ExportToSet<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Object> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getKey());
    assertNull(_getOpResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    ExportToSet<Object> actualExportToSet = actualBuilder.build();
    assertSame(_getOpResult, actualExportToSet);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test {@link ExportToSet#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ExportToSet#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference ExportToSet.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    ExportToSet<Object> exportToSet = new ExportToSet<>();

    // Act and Assert
    assertTrue(exportToSet.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test {@link ExportToSet#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ExportToSet} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ExportToSet#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ExportToSet (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExportToSet ExportToSet.shallowClone()"})
  void testShallowClone_givenExportToSetOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    ExportToSet<Object> exportToSet = new ExportToSet<>();
    exportToSet.setOptions(new HashMap<>());

    // Act
    ExportToSet<Object> actualShallowCloneResult = exportToSet.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getKey());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link ExportToSet#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ExportToSet} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExportToSet#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ExportToSet (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExportToSet ExportToSet.shallowClone()"})
  void testShallowClone_givenExportToSet_thenReturnOptionsIsNull() {
    // Arrange
    ExportToSet<Object> exportToSet = new ExportToSet<>();

    // Act
    ExportToSet<Object> actualShallowCloneResult = exportToSet.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToSet}
   *   <li>{@link ExportToSet#setInput(Object)}
   *   <li>{@link ExportToSet#setKey(String)}
   *   <li>{@link ExportToSet#setOptions(Map)}
   *   <li>{@link ExportToSet#getInput()}
   *   <li>{@link ExportToSet#getKey()}
   *   <li>{@link ExportToSet#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExportToSet.<init>()",
    "Object ExportToSet.getInput()",
    "String ExportToSet.getKey()",
    "Map ExportToSet.getOptions()",
    "void ExportToSet.setInput(Object)",
    "void ExportToSet.setKey(String)",
    "void ExportToSet.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ExportToSet<Object> actualExportToSet = new ExportToSet<>();
    actualExportToSet.setInput("Input");
    actualExportToSet.setKey("Key");
    HashMap<String, String> options = new HashMap<>();
    actualExportToSet.setOptions(options);
    Object actualInput = actualExportToSet.getInput();
    String actualKey = actualExportToSet.getKey();
    Map<String, String> actualOptions = actualExportToSet.getOptions();

    // Assert
    assertEquals("Input", actualInput);
    assertEquals("Key", actualKey);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
