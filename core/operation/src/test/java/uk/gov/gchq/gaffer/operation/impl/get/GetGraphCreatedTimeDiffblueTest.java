package uk.gov.gchq.gaffer.operation.impl.get;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.impl.get.GetGraphCreatedTime.Builder;

class GetGraphCreatedTimeDiffblueTest {
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
    GetGraphCreatedTime _getOpResult = actualBuilder._getOp();
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.String>", outputType.getTypeName());
    assertNull(_getOpResult.getOptions());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetGraphCreatedTime actualGetGraphCreatedTime = actualBuilder.build();
    assertSame(_getOpResult, actualGetGraphCreatedTime);
    assertSame(outputType, _getOpResult.getOutputTypeReference().getType());
  }

  /**
   * Test {@link GetGraphCreatedTime#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetGraphCreatedTime} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetGraphCreatedTime#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetGraphCreatedTime (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetGraphCreatedTimeOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    GetGraphCreatedTime getGraphCreatedTime = new GetGraphCreatedTime();
    getGraphCreatedTime.setOptions(new HashMap<>());

    // Act
    Operation actualShallowCloneResult = getGraphCreatedTime.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof GetGraphCreatedTime);
    Type outputType = ((GetGraphCreatedTime) actualShallowCloneResult).getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.String>", outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(
        expectedOutputClass, ((GetGraphCreatedTime) actualShallowCloneResult).getOutputClass());
    assertSame(
        outputType,
        ((GetGraphCreatedTime) actualShallowCloneResult).getOutputTypeReference().getType());
  }

  /**
   * Test {@link GetGraphCreatedTime#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetGraphCreatedTime} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetGraphCreatedTime#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetGraphCreatedTime (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetGraphCreatedTime_thenReturnOptionsIsNull()
      throws CloneFailedException {
    // Arrange and Act
    Operation actualShallowCloneResult = new GetGraphCreatedTime().shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof GetGraphCreatedTime);
    Type outputType = ((GetGraphCreatedTime) actualShallowCloneResult).getOutputType();
    assertEquals("java.util.Map<java.lang.String, java.lang.String>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getOptions());
    Class<Map> expectedOutputClass = Map.class;
    assertEquals(
        expectedOutputClass, ((GetGraphCreatedTime) actualShallowCloneResult).getOutputClass());
    assertSame(
        outputType,
        ((GetGraphCreatedTime) actualShallowCloneResult).getOutputTypeReference().getType());
  }

  /**
   * Test {@link GetGraphCreatedTime#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetGraphCreatedTime#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertEquals(
        "java.util.Map<java.lang.String, java.lang.String>",
        new GetGraphCreatedTime().getOutputTypeReference().getType().getTypeName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetGraphCreatedTime}
   *   <li>{@link GetGraphCreatedTime#setOptions(Map)}
   *   <li>{@link GetGraphCreatedTime#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    GetGraphCreatedTime actualGetGraphCreatedTime = new GetGraphCreatedTime();
    HashMap<String, String> options = new HashMap<>();
    actualGetGraphCreatedTime.setOptions(options);
    Map<String, String> actualOptions = actualGetGraphCreatedTime.getOptions();

    // Assert
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
