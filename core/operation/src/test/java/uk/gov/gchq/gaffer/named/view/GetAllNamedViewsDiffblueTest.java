package uk.gov.gchq.gaffer.named.view;

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
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedViewDetail;
import uk.gov.gchq.gaffer.named.view.GetAllNamedViews.Builder;
import uk.gov.gchq.gaffer.named.view.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.named.view.serialisation.TypeReferenceImpl.IterableNamedView;

class GetAllNamedViewsDiffblueTest {
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
    GetAllNamedViews _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<NamedViewDetail>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableNamedView);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.data.elementdefinition.view.NamedViewDetail>",
        outputType.getTypeName());
    assertNull(_getOpResult.getOptions());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetAllNamedViews actualGetAllNamedViews = actualBuilder.build();
    assertSame(_getOpResult, actualGetAllNamedViews);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllNamedViews#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetAllNamedViews#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetAllNamedViews.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<NamedViewDetail>> actualOutputTypeReference =
        new GetAllNamedViews().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableNamedView);
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.data.elementdefinition.view.NamedViewDetail>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetAllNamedViews#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAllNamedViews} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetAllNamedViews#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAllNamedViews (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllNamedViews GetAllNamedViews.shallowClone()"})
  void testShallowClone_givenGetAllNamedViewsOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    GetAllNamedViews getAllNamedViews = new GetAllNamedViews();
    getAllNamedViews.setOptions(new HashMap<>());

    // Act
    GetAllNamedViews actualShallowCloneResult = getAllNamedViews.shallowClone();

    // Assert
    TypeReference<Iterable<NamedViewDetail>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableNamedView);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.data.elementdefinition.view.NamedViewDetail>",
        outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAllNamedViews#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAllNamedViews} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllNamedViews#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAllNamedViews (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetAllNamedViews GetAllNamedViews.shallowClone()"})
  void testShallowClone_givenGetAllNamedViews_thenReturnOptionsIsNull()
      throws CloneFailedException {
    // Arrange and Act
    GetAllNamedViews actualShallowCloneResult = new GetAllNamedViews().shallowClone();

    // Assert
    TypeReference<Iterable<NamedViewDetail>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableNamedView);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.data.elementdefinition.view.NamedViewDetail>",
        outputType.getTypeName());
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
   *   <li>default or parameterless constructor of {@link GetAllNamedViews}
   *   <li>{@link GetAllNamedViews#setOptions(Map)}
   *   <li>{@link GetAllNamedViews#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAllNamedViews.<init>()",
    "Map GetAllNamedViews.getOptions()",
    "void GetAllNamedViews.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetAllNamedViews actualGetAllNamedViews = new GetAllNamedViews();
    HashMap<String, String> options = new HashMap<>();
    actualGetAllNamedViews.setOptions(options);
    Map<String, String> actualOptions = actualGetAllNamedViews.getOptions();

    // Assert
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
