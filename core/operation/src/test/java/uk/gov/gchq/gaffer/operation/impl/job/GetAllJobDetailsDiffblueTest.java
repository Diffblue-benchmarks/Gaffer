package uk.gov.gchq.gaffer.operation.impl.job;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.jobtracker.JobDetail;
import uk.gov.gchq.gaffer.operation.impl.job.GetAllJobDetails.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.JobDetailIterable;

class GetAllJobDetailsDiffblueTest {
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
    GetAllJobDetails _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<JobDetail>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof JobDetailIterable);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.jobtracker.JobDetail>", outputType.getTypeName());
    assertNull(_getOpResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetAllJobDetails actualGetAllJobDetails = actualBuilder.build();
    assertSame(_getOpResult, actualGetAllJobDetails);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllJobDetails#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetAllJobDetails#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<JobDetail>> actualOutputTypeReference =
        new GetAllJobDetails().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof JobDetailIterable);
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.jobtracker.JobDetail>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetAllJobDetails#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAllJobDetails} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetAllJobDetails#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAllJobDetails (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetAllJobDetailsOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    GetAllJobDetails getAllJobDetails = new GetAllJobDetails();
    getAllJobDetails.setOptions(new HashMap<>());

    // Act
    GetAllJobDetails actualShallowCloneResult = getAllJobDetails.shallowClone();

    // Assert
    TypeReference<Iterable<JobDetail>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof JobDetailIterable);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.jobtracker.JobDetail>", outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllJobDetails#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAllJobDetails} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllJobDetails#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAllJobDetails (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetAllJobDetails_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetAllJobDetails actualShallowCloneResult = new GetAllJobDetails().shallowClone();

    // Assert
    TypeReference<Iterable<JobDetail>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof JobDetailIterable);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.jobtracker.JobDetail>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getOptions());
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
   *   <li>default or parameterless constructor of {@link GetAllJobDetails}
   *   <li>{@link GetAllJobDetails#setOptions(Map)}
   *   <li>{@link GetAllJobDetails#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    GetAllJobDetails actualGetAllJobDetails = new GetAllJobDetails();
    HashMap<String, String> options = new HashMap<>();
    actualGetAllJobDetails.setOptions(options);
    Map<String, String> actualOptions = actualGetAllJobDetails.getOptions();

    // Assert
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
