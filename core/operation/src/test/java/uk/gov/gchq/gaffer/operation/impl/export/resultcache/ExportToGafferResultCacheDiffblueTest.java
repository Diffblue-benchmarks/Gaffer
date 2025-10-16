package uk.gov.gchq.gaffer.operation.impl.export.resultcache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.resultcache.ExportToGafferResultCache.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class ExportToGafferResultCacheDiffblueTest {
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
    ExportToGafferResultCache<Object> _getOpResult = actualBuilder._getOp();
    TypeReference<Object> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getKey());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getOpAuths());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    ExportToGafferResultCache<Object> actualExportToGafferResultCache = actualBuilder.build();
    assertSame(_getOpResult, actualExportToGafferResultCache);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test Builder {@link Builder#opAuths(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#opAuths(Set)}
   */
  @Test
  @DisplayName("Test Builder opAuths(Set) with 'Set'; given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.opAuths(Set)"})
  void testBuilderOpAuthsWithSet_given42_whenHashSetAdd42() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    HashSet<String> opAuths = new HashSet<>();
    opAuths.add("42");
    opAuths.add("foo");

    // Act
    Builder<Object> actualOpAuthsResult = builder.opAuths(opAuths);

    // Assert
    assertSame(builder, actualOpAuthsResult);
  }

  /**
   * Test Builder {@link Builder#opAuths(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#opAuths(Set)}
   */
  @Test
  @DisplayName("Test Builder opAuths(Set) with 'Set'; given 'foo'; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.opAuths(Set)"})
  void testBuilderOpAuthsWithSet_givenFoo_whenHashSetAddFoo() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    HashSet<String> opAuths = new HashSet<>();
    opAuths.add("foo");

    // Act
    Builder<Object> actualOpAuthsResult = builder.opAuths(opAuths);

    // Assert
    assertSame(builder, actualOpAuthsResult);
  }

  /**
   * Test Builder {@link Builder#opAuths(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#opAuths(Set)}
   */
  @Test
  @DisplayName("Test Builder opAuths(Set) with 'Set'; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.opAuths(Set)"})
  void testBuilderOpAuthsWithSet_whenHashSet() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualOpAuthsResult = builder.opAuths(new HashSet<>());

    // Assert
    assertSame(builder, actualOpAuthsResult);
  }

  /**
   * Test Builder {@link Builder#opAuths(String[])} with {@code String[]}.
   *
   * <ul>
   *   <li>When {@code Op Auths} and {@code 42}.
   *   <li>Then return _getOp OpAuths size is two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#opAuths(String[])}
   */
  @Test
  @DisplayName(
      "Test Builder opAuths(String[]) with 'String[]'; when 'Op Auths' and '42'; then return _getOp OpAuths size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.opAuths(String[])"})
  void testBuilderOpAuthsWithString_whenOpAuthsAnd42_thenReturn_getOpOpAuthsSizeIsTwo() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualOpAuthsResult = builder.opAuths("Op Auths", "42", "Op Auths");

    // Assert
    ExportToGafferResultCache<Object> _getOpResult = actualOpAuthsResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    Set<String> opAuths = _getOpResult.getOpAuths();
    assertEquals(2, opAuths.size());
    assertTrue(opAuths.contains("42"));
    ExportToGafferResultCache<Object> actualExportToGafferResultCache = actualOpAuthsResult.build();
    assertSame(_getOpResult, actualExportToGafferResultCache);
  }

  /**
   * Test Builder {@link Builder#opAuths(String[])} with {@code String[]}.
   *
   * <ul>
   *   <li>When {@code Op Auths}.
   *   <li>Then return _getOp OpAuths size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#opAuths(String[])}
   */
  @Test
  @DisplayName(
      "Test Builder opAuths(String[]) with 'String[]'; when 'Op Auths'; then return _getOp OpAuths size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.opAuths(String[])"})
  void testBuilderOpAuthsWithString_whenOpAuths_thenReturn_getOpOpAuthsSizeIsOne() {
    // Arrange
    Builder<Object> builder = new Builder<>();

    // Act
    Builder<Object> actualOpAuthsResult = builder.opAuths("Op Auths");

    // Assert
    ExportToGafferResultCache<Object> _getOpResult = actualOpAuthsResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertEquals(1, _getOpResult.getOpAuths().size());
    ExportToGafferResultCache<Object> actualExportToGafferResultCache = actualOpAuthsResult.build();
    assertSame(_getOpResult, actualExportToGafferResultCache);
  }

  /**
   * Test {@link ExportToGafferResultCache#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link ExportToGafferResultCache} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExportToGafferResultCache#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given ExportToGafferResultCache (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExportToGafferResultCache ExportToGafferResultCache.shallowClone()"})
  void testShallowClone_givenExportToGafferResultCache_thenReturnOptionsIsNull() {
    // Arrange
    ExportToGafferResultCache<Object> exportToGafferResultCache = new ExportToGafferResultCache<>();

    // Act
    ExportToGafferResultCache<Object> actualShallowCloneResult =
        exportToGafferResultCache.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getOpAuths());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link ExportToGafferResultCache#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link ExportToGafferResultCache#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExportToGafferResultCache ExportToGafferResultCache.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    ExportToGafferResultCache<Object> exportToGafferResultCache = new ExportToGafferResultCache<>();
    exportToGafferResultCache.setOptions(new HashMap<>());

    // Act
    ExportToGafferResultCache<Object> actualShallowCloneResult =
        exportToGafferResultCache.shallowClone();

    // Assert
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getOpAuths());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link ExportToGafferResultCache#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link ExportToGafferResultCache#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference ExportToGafferResultCache.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    ExportToGafferResultCache<Object> exportToGafferResultCache = new ExportToGafferResultCache<>();

    // Act and Assert
    assertTrue(
        exportToGafferResultCache.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExportToGafferResultCache}
   *   <li>{@link ExportToGafferResultCache#setInput(Object)}
   *   <li>{@link ExportToGafferResultCache#setKey(String)}
   *   <li>{@link ExportToGafferResultCache#setOpAuths(Set)}
   *   <li>{@link ExportToGafferResultCache#setOptions(Map)}
   *   <li>{@link ExportToGafferResultCache#getInput()}
   *   <li>{@link ExportToGafferResultCache#getKey()}
   *   <li>{@link ExportToGafferResultCache#getOpAuths()}
   *   <li>{@link ExportToGafferResultCache#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExportToGafferResultCache.<init>()",
    "Object ExportToGafferResultCache.getInput()",
    "String ExportToGafferResultCache.getKey()",
    "Set ExportToGafferResultCache.getOpAuths()",
    "Map ExportToGafferResultCache.getOptions()",
    "void ExportToGafferResultCache.setInput(Object)",
    "void ExportToGafferResultCache.setKey(String)",
    "void ExportToGafferResultCache.setOpAuths(Set)",
    "void ExportToGafferResultCache.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ExportToGafferResultCache<Object> actualExportToGafferResultCache =
        new ExportToGafferResultCache<>();
    actualExportToGafferResultCache.setInput("Input");
    actualExportToGafferResultCache.setKey("Key");
    HashSet<String> opAuths = new HashSet<>();
    actualExportToGafferResultCache.setOpAuths(opAuths);
    HashMap<String, String> options = new HashMap<>();
    actualExportToGafferResultCache.setOptions(options);
    Object actualInput = actualExportToGafferResultCache.getInput();
    String actualKey = actualExportToGafferResultCache.getKey();
    Set<String> actualOpAuths = actualExportToGafferResultCache.getOpAuths();
    Map<String, String> actualOptions = actualExportToGafferResultCache.getOptions();

    // Assert
    assertEquals("Input", actualInput);
    assertEquals("Key", actualKey);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualOpAuths.isEmpty());
    assertSame(options, actualOptions);
    assertSame(opAuths, actualOpAuths);
  }
}
