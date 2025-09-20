package uk.gov.gchq.gaffer.federated.simple.operation;

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
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federated.simple.operation.GetAllGraphInfo.Builder;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.MapStringObject;

class GetAllGraphInfoDiffblueTest {
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
    GetAllGraphInfo _getOpResult = actualBuilder._getOp();
    TypeReference<Map<String, Object>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof MapStringObject);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>", outputType.getTypeName());
    assertNull(_getOpResult.getOptions());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetAllGraphInfo actualGetAllGraphInfo = actualBuilder.build();
    assertSame(_getOpResult, actualGetAllGraphInfo);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllGraphInfo#shallowClone()}.
   *
   * <p>Method under test: {@link GetAllGraphInfo#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation GetAllGraphInfo.shallowClone()"})
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    Operation actualShallowCloneResult = new GetAllGraphInfo().shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof GetAllGraphInfo);
    TypeReference<Map<String, Object>> outputTypeReference =
        ((GetAllGraphInfo) actualShallowCloneResult).getOutputTypeReference();
    assertTrue(outputTypeReference instanceof MapStringObject);
    Type outputType = ((GetAllGraphInfo) actualShallowCloneResult).getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(
        expectedOutputClass, ((GetAllGraphInfo) actualShallowCloneResult).getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllGraphInfo#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetAllGraphInfo#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetAllGraphInfo.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Map<String, Object>> actualOutputTypeReference =
        new GetAllGraphInfo().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof MapStringObject);
    assertEquals(
        "java.util.Map<java.lang.String, java.lang.Object>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetAllGraphInfo}
   *   <li>{@link GetAllGraphInfo#setOptions(Map)}
   *   <li>{@link GetAllGraphInfo#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAllGraphInfo.<init>()",
    "Map GetAllGraphInfo.getOptions()",
    "void GetAllGraphInfo.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetAllGraphInfo actualGetAllGraphInfo = new GetAllGraphInfo();
    HashMap<String, String> options = new HashMap<>();
    actualGetAllGraphInfo.setOptions(options);
    Map<String, String> actualOptions = actualGetAllGraphInfo.getOptions();

    // Assert
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
