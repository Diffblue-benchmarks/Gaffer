package uk.gov.gchq.gaffer.operation.impl.export.resultcache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.resultcache.GetGafferResultCacheExport.Builder;
import uk.gov.gchq.gaffer.operation.impl.job.GetJobResults;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableObj;

class GetGafferResultCacheExportDiffblueTest {
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
    Builder actualBuilder = new Builder();

    // Assert
    GetGafferResultCacheExport _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    assertEquals("ALL", _getOpResult.getKey());
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(_getOpResult.getJobId());
    assertNull(_getOpResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetGafferResultCacheExport actualGetGafferResultCacheExport = actualBuilder.build();
    assertSame(_getOpResult, actualGetGafferResultCacheExport);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetGafferResultCacheExport#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetGafferResultCacheExport#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetGafferResultCacheExport.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<?>> actualOutputTypeReference =
        new GetGafferResultCacheExport().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetGafferResultCacheExport#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetGafferResultCacheExport} (default constructor).
   *   <li>Then return KeyOrDefault is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link GetGafferResultCacheExport#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetGafferResultCacheExport (default constructor); then return KeyOrDefault is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetGafferResultCacheExport GetGafferResultCacheExport.shallowClone()"})
  void testShallowClone_givenGetGafferResultCacheExport_thenReturnKeyOrDefaultIsAll() {
    // Arrange and Act
    GetGafferResultCacheExport actualShallowCloneResult =
        new GetGafferResultCacheExport().shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertEquals("ALL", actualShallowCloneResult.getKey());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetGafferResultCacheExport#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetJobResults} (default constructor).
   *   <li>Then return {@link GetJobResults}.
   * </ul>
   *
   * <p>Method under test: {@link GetGafferResultCacheExport#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetJobResults (default constructor); then return GetJobResults")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetGafferResultCacheExport GetGafferResultCacheExport.shallowClone()"})
  void testShallowClone_givenGetJobResults_thenReturnGetJobResults() {
    // Arrange and Act
    GetJobResults actualShallowCloneResult = new GetJobResults().shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof GetJobResults);
    assertTrue(actualShallowCloneResult.getOutputTypeReference() instanceof IterableObj);
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test {@link GetGafferResultCacheExport#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetGafferResultCacheExport#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetGafferResultCacheExport GetGafferResultCacheExport.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    GetGafferResultCacheExport getGafferResultCacheExport = new GetGafferResultCacheExport();
    getGafferResultCacheExport.setOptions(new HashMap<>());

    // Act
    GetGafferResultCacheExport actualShallowCloneResult = getGafferResultCacheExport.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    assertEquals("ALL", actualShallowCloneResult.getKey());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getJobId());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
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
   *   <li>default or parameterless constructor of {@link GetGafferResultCacheExport}
   *   <li>{@link GetGafferResultCacheExport#setJobId(String)}
   *   <li>{@link GetGafferResultCacheExport#setKey(String)}
   *   <li>{@link GetGafferResultCacheExport#setOptions(Map)}
   *   <li>{@link GetGafferResultCacheExport#getJobId()}
   *   <li>{@link GetGafferResultCacheExport#getKey()}
   *   <li>{@link GetGafferResultCacheExport#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetGafferResultCacheExport.<init>()",
    "String GetGafferResultCacheExport.getJobId()",
    "String GetGafferResultCacheExport.getKey()",
    "Map GetGafferResultCacheExport.getOptions()",
    "void GetGafferResultCacheExport.setJobId(String)",
    "void GetGafferResultCacheExport.setKey(String)",
    "void GetGafferResultCacheExport.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetGafferResultCacheExport actualGetGafferResultCacheExport = new GetGafferResultCacheExport();
    actualGetGafferResultCacheExport.setJobId("42");
    actualGetGafferResultCacheExport.setKey("Key");
    HashMap<String, String> options = new HashMap<>();
    actualGetGafferResultCacheExport.setOptions(options);
    String actualJobId = actualGetGafferResultCacheExport.getJobId();
    String actualKey = actualGetGafferResultCacheExport.getKey();
    Map<String, String> actualOptions = actualGetGafferResultCacheExport.getOptions();

    // Assert
    assertEquals("42", actualJobId);
    assertEquals("Key", actualKey);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
