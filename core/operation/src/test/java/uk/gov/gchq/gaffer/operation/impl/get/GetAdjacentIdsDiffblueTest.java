package uk.gov.gchq.gaffer.operation.impl.get;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters.IncludeIncomingOutgoingType;
import uk.gov.gchq.gaffer.operation.impl.get.GetAdjacentIds.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableEntityId;

class GetAdjacentIdsDiffblueTest {
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
    GetAdjacentIds _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends EntityId>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableEntityId);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.id.EntityId>",
        outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getDirectedType());
    assertNull(_getOpResult.getView());
    assertNull(_getOpResult.getIncludeIncomingOutGoing());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetAdjacentIds actualGetAdjacentIds = actualBuilder.build();
    assertSame(_getOpResult, actualGetAdjacentIds);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAdjacentIds#setView(View)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link GetAdjacentIds} (default constructor) View is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetAdjacentIds#setView(View)}
   */
  @Test
  @DisplayName(
      "Test setView(View); when 'null'; then GetAdjacentIds (default constructor) View is 'null'")
  @Tag("MaintainedByDiffblue")
  void testSetView_whenNull_thenGetAdjacentIdsViewIsNull() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act
    getAdjacentIds.setView(null);

    // Assert that nothing has changed
    assertNull(getAdjacentIds.getView());
  }

  /**
   * Test {@link GetAdjacentIds#setView(View)}.
   *
   * <ul>
   *   <li>When {@link View} (default constructor).
   *   <li>Then {@link GetAdjacentIds} (default constructor) View is {@link View} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetAdjacentIds#setView(View)}
   */
  @Test
  @DisplayName(
      "Test setView(View); when View (default constructor); then GetAdjacentIds (default constructor) View is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testSetView_whenView_thenGetAdjacentIdsViewIsView() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    View view = new View();

    // Act
    getAdjacentIds.setView(view);

    // Assert
    assertSame(view, getAdjacentIds.getView());
  }

  /**
   * Test {@link GetAdjacentIds#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetAdjacentIds#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GetAdjacentIds().getInput());
  }

  /**
   * Test {@link GetAdjacentIds#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetAdjacentIds#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends EntityId>> actualOutputTypeReference =
        new GetAdjacentIds().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableEntityId);
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.id.EntityId>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetAdjacentIds#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetAdjacentIds#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAdjacentIds (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetAdjacentIdsOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setOptions(new HashMap<>());

    // Act
    GetAdjacentIds actualShallowCloneResult = getAdjacentIds.shallowClone();

    // Assert
    TypeReference<Iterable<? extends EntityId>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableEntityId);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.id.EntityId>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertNull(actualShallowCloneResult.getIncludeIncomingOutGoing());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetAdjacentIds#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) View is {@link View} (default
   *       constructor).
   *   <li>Then return View is {@link View} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetAdjacentIds#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAdjacentIds (default constructor) View is View (default constructor); then return View is View (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetAdjacentIdsViewIsView_thenReturnViewIsView() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    View view = new View();
    getAdjacentIds.setView(view);

    // Act and Assert
    assertSame(view, getAdjacentIds.shallowClone().getView());
  }

  /**
   * Test {@link GetAdjacentIds#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetAdjacentIds#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetAdjacentIds (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetAdjacentIds_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetAdjacentIds actualShallowCloneResult = new GetAdjacentIds().shallowClone();

    // Assert
    TypeReference<Iterable<? extends EntityId>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableEntityId);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.id.EntityId>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertNull(actualShallowCloneResult.getIncludeIncomingOutGoing());
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
   *   <li>default or parameterless constructor of {@link GetAdjacentIds}
   *   <li>{@link GetAdjacentIds#setDirectedType(DirectedType)}
   *   <li>{@link GetAdjacentIds#setIncludeIncomingOutGoing(IncludeIncomingOutgoingType)}
   *   <li>{@link GetAdjacentIds#setInput(Iterable)}
   *   <li>{@link GetAdjacentIds#setOptions(Map)}
   *   <li>{@link GetAdjacentIds#getDirectedType()}
   *   <li>{@link GetAdjacentIds#getIncludeIncomingOutGoing()}
   *   <li>{@link GetAdjacentIds#getOptions()}
   *   <li>{@link GetAdjacentIds#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    GetAdjacentIds actualGetAdjacentIds = new GetAdjacentIds();
    actualGetAdjacentIds.setDirectedType(DirectedType.EITHER);
    actualGetAdjacentIds.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType.EITHER);
    ArrayList<EntityId> input = new ArrayList<>();
    actualGetAdjacentIds.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualGetAdjacentIds.setOptions(options);
    DirectedType actualDirectedType = actualGetAdjacentIds.getDirectedType();
    IncludeIncomingOutgoingType actualIncludeIncomingOutGoing =
        actualGetAdjacentIds.getIncludeIncomingOutGoing();
    Map<String, String> actualOptions = actualGetAdjacentIds.getOptions();
    View actualView = actualGetAdjacentIds.getView();

    // Assert
    Iterable<? extends EntityId> input2 = actualGetAdjacentIds.getInput();
    assertTrue(input2 instanceof List);
    assertNull(actualView);
    assertEquals(DirectedType.EITHER, actualDirectedType);
    assertEquals(IncludeIncomingOutgoingType.EITHER, actualIncludeIncomingOutGoing);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
  }
}
