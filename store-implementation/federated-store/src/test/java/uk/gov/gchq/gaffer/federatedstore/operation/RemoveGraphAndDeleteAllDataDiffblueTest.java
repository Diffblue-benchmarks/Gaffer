package uk.gov.gchq.gaffer.federatedstore.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.operation.RemoveGraphAndDeleteAllData.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class RemoveGraphAndDeleteAllDataDiffblueTest {
  /**
   * Test Builder {@link Builder#graphId(String)}.
   *
   * <p>Method under test: {@link Builder#graphId(String)}
   */
  @Test
  @DisplayName("Test Builder graphId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.graphId(String)"})
  void testBuilderGraphId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGraphIdResult = builder.graphId("42");

    // Assert
    assertSame(builder, actualGraphIdResult);
  }

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
    RemoveGraphAndDeleteAllData _getOpResult = actualBuilder._getOp();
    TypeReference<Boolean> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Boolean);
    assertNull(_getOpResult.getGraphId());
    assertNull(_getOpResult.getOptions());
    assertFalse(_getOpResult.isUserRequestingAdminUsage());
    assertTrue(_getOpResult.isRemoveCache());
    Class<Boolean> expectedOutputClass = Boolean.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    RemoveGraphAndDeleteAllData actualRemoveGraphAndDeleteAllData = actualBuilder.build();
    assertSame(_getOpResult, actualRemoveGraphAndDeleteAllData);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test {@link RemoveGraphAndDeleteAllData#shallowClone()}.
   *
   * <p>Method under test: {@link RemoveGraphAndDeleteAllData#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RemoveGraphAndDeleteAllData RemoveGraphAndDeleteAllData.shallowClone()"})
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    RemoveGraphAndDeleteAllData actualShallowCloneResult =
        new RemoveGraphAndDeleteAllData().shallowClone();

    // Assert
    TypeReference<Boolean> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Boolean);
    assertNull(actualShallowCloneResult.getGraphId());
    assertNull(actualShallowCloneResult.getOptions());
    assertFalse(actualShallowCloneResult.isUserRequestingAdminUsage());
    assertTrue(actualShallowCloneResult.isRemoveCache());
    Class<Boolean> expectedOutputClass = Boolean.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Test new {@link RemoveGraphAndDeleteAllData} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * RemoveGraphAndDeleteAllData}
   */
  @Test
  @DisplayName("Test new RemoveGraphAndDeleteAllData (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoveGraphAndDeleteAllData.<init>()"})
  void testNewRemoveGraphAndDeleteAllData() {
    // Arrange and Act
    RemoveGraphAndDeleteAllData actualRemoveGraphAndDeleteAllData =
        new RemoveGraphAndDeleteAllData();

    // Assert
    assertNull(actualRemoveGraphAndDeleteAllData.getGraphId());
    assertNull(actualRemoveGraphAndDeleteAllData.getOptions());
    assertFalse(actualRemoveGraphAndDeleteAllData.isUserRequestingAdminUsage());
    assertTrue(actualRemoveGraphAndDeleteAllData.isRemoveCache());
  }
}
