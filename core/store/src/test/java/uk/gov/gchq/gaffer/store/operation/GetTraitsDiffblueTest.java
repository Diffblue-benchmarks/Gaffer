package uk.gov.gchq.gaffer.store.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl.StoreTraits;
import uk.gov.gchq.gaffer.store.operation.GetTraits.Builder;

class GetTraitsDiffblueTest {
  /**
   * Test Builder {@link Builder#currentTraits(boolean)}.
   *
   * <p>Method under test: {@link Builder#currentTraits(boolean)}
   */
  @Test
  @DisplayName("Test Builder currentTraits(boolean)")
  @Tag("MaintainedByDiffblue")
  void testBuilderCurrentTraits() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualCurrentTraitsResult = builder.currentTraits(true);

    // Assert
    assertSame(builder, actualCurrentTraitsResult);
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
    GetTraits _getOpResult = actualBuilder._getOp();
    TypeReference<Set<StoreTrait>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof StoreTraits);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.Set<uk.gov.gchq.gaffer.store.StoreTrait>", outputType.getTypeName());
    assertTrue(_getOpResult.getOptions().isEmpty());
    assertTrue(_getOpResult.isCurrentTraits());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetTraits actualGetTraits = actualBuilder.build();
    assertSame(_getOpResult, actualGetTraits);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetTraits#shallowClone()}.
   *
   * <p>Method under test: {@link GetTraits#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("MaintainedByDiffblue")
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    GetTraits actualShallowCloneResult = new GetTraits().shallowClone();

    // Assert
    TypeReference<Set<StoreTrait>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof StoreTraits);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Set<uk.gov.gchq.gaffer.store.StoreTrait>", outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.isCurrentTraits());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetTraits#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetTraits#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Set<StoreTrait>> actualOutputTypeReference =
        new GetTraits().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof StoreTraits);
    assertEquals(
        "java.util.Set<uk.gov.gchq.gaffer.store.StoreTrait>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetTraits}
   *   <li>{@link GetTraits#setCurrentTraits(boolean)}
   *   <li>{@link GetTraits#setOptions(Map)}
   *   <li>{@link GetTraits#getOptions()}
   *   <li>{@link GetTraits#isCurrentTraits()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    GetTraits actualGetTraits = new GetTraits();
    actualGetTraits.setCurrentTraits(true);
    HashMap<String, String> options = new HashMap<>();
    actualGetTraits.setOptions(options);
    Map<String, String> actualOptions = actualGetTraits.getOptions();
    boolean actualIsCurrentTraitsResult = actualGetTraits.isCurrentTraits();

    // Assert
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsCurrentTraitsResult);
    assertSame(options, actualOptions);
  }
}
