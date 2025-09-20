package uk.gov.gchq.gaffer.operation.impl.get;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.get.GetFromEndpoint.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class GetFromEndpointDiffblueTest {
  /**
   * Test Builder {@link Builder#endpoint(String)}.
   *
   * <p>Method under test: {@link Builder#endpoint(String)}
   */
  @Test
  @DisplayName("Test Builder endpoint(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderEndpoint() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEndpointResult = builder.endpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    assertSame(builder, actualEndpointResult);
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
    GetFromEndpoint _getOpResult = actualBuilder._getOp();
    TypeReference<String> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.String);
    assertNull(_getOpResult.getEndpoint());
    assertNull(_getOpResult.getOptions());
    Class<String> expectedOutputClass = String.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    GetFromEndpoint actualGetFromEndpoint = actualBuilder.build();
    assertSame(_getOpResult, actualGetFromEndpoint);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test {@link GetFromEndpoint#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetFromEndpoint} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetFromEndpoint#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetFromEndpoint (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetFromEndpointOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    GetFromEndpoint getFromEndpoint = new GetFromEndpoint();
    getFromEndpoint.setOptions(new HashMap<>());

    // Act
    GetFromEndpoint actualShallowCloneResult = getFromEndpoint.shallowClone();

    // Assert
    TypeReference<String> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.String);
    assertNull(actualShallowCloneResult.getEndpoint());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<String> expectedOutputClass = String.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link GetFromEndpoint#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetFromEndpoint} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetFromEndpoint#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetFromEndpoint (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetFromEndpoint_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    GetFromEndpoint actualShallowCloneResult = new GetFromEndpoint().shallowClone();

    // Assert
    TypeReference<String> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.String);
    assertNull(actualShallowCloneResult.getEndpoint());
    assertNull(actualShallowCloneResult.getOptions());
    Class<String> expectedOutputClass = String.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test {@link GetFromEndpoint#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetFromEndpoint#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue(new GetFromEndpoint().getOutputTypeReference() instanceof TypeReferenceImpl.String);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetFromEndpoint}
   *   <li>{@link GetFromEndpoint#setEndpoint(String)}
   *   <li>{@link GetFromEndpoint#setOptions(Map)}
   *   <li>{@link GetFromEndpoint#getEndpoint()}
   *   <li>{@link GetFromEndpoint#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    GetFromEndpoint actualGetFromEndpoint = new GetFromEndpoint();
    actualGetFromEndpoint.setEndpoint("https://config.us-east-2.amazonaws.com");
    HashMap<String, String> options = new HashMap<>();
    actualGetFromEndpoint.setOptions(options);
    String actualEndpoint = actualGetFromEndpoint.getEndpoint();
    Map<String, String> actualOptions = actualGetFromEndpoint.getOptions();

    // Assert
    assertEquals("https://config.us-east-2.amazonaws.com", actualEndpoint);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
