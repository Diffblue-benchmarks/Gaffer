package uk.gov.gchq.gaffer.operation.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.operation.impl.GetWalks;
import uk.gov.gchq.gaffer.operation.impl.GetWalks.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableWalk;
import uk.gov.gchq.koryphe.iterable.MappedIterable;
import uk.gov.gchq.koryphe.iterable.MappedIterator;

class MultiEntityIdInputDiffblueTest {
  /**
   * Test Builder {@link MultiEntityIdInput.Builder#inputIds(Iterable)}.
   *
   * <p>Method under test: {@link MultiEntityIdInput.Builder#inputIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder inputIds(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MultiEntityIdInput.Builder MultiEntityIdInput.Builder.inputIds(Iterable)"})
  void testBuilderInputIds() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputIdsResult = builder.inputIds(new ArrayList<>());

    // Assert
    assertSame(builder, actualInputIdsResult);
  }

  /**
   * Test Builder {@link MultiEntityIdInput.Builder#input(EntityId[])} with {@code EntityId[]}.
   *
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.
   *   <li>Then return {@link GetWalks.Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInput.Builder#input(EntityId[])}
   */
  @Test
  @DisplayName(
      "Test Builder input(EntityId[]) with 'EntityId[]'; when EntitySeed(); then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MultiEntityIdInput.Builder MultiEntityIdInput.Builder.input(EntityId[])"})
  void testBuilderInputWithEntityId_whenEntitySeed_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputResult = builder.input(new EntitySeed());

    // Assert
    assertSame(builder, actualInputResult);
  }

  /**
   * Test Builder {@link MultiEntityIdInput.Builder#input(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then _getOp OutputTypeReference return {@link TypeReferenceImpl.IterableWalk}.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInput.Builder#input(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder input(Iterable) with 'Iterable'; then _getOp OutputTypeReference return IterableWalk")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MultiEntityIdInput.Builder MultiEntityIdInput.Builder.input(Iterable)"})
  void testBuilderInputWithIterable_then_getOpOutputTypeReferenceReturnIterableWalk() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputResult = builder.input(new ArrayList<>());

    // Assert
    GetWalks _getOpResult = actualInputResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof IterableWalk);
    Iterable<? extends EntityId> input = _getOpResult.getInput();
    assertTrue(input instanceof MappedIterable);
    Iterator<? extends EntityId> iteratorResult = input.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    GetWalks actualGetWalks = actualInputResult.build();
    assertSame(_getOpResult, actualGetWalks);
  }

  /**
   * Test Builder {@link MultiEntityIdInput.Builder#input(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link GetWalks.Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInput.Builder#input(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder input(Iterable) with 'Iterable'; when 'null'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MultiEntityIdInput.Builder MultiEntityIdInput.Builder.input(Iterable)"})
  void testBuilderInputWithIterable_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputResult = builder.input((Iterable) null);

    // Assert
    assertSame(builder, actualInputResult);
  }

  /**
   * Test Builder {@link MultiEntityIdInput.Builder#input(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@link GetWalks.Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInput.Builder#input(Object[])}
   */
  @Test
  @DisplayName(
      "Test Builder input(Object[]) with 'Object[]'; when 'Input'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MultiEntityIdInput.Builder MultiEntityIdInput.Builder.input(Object[])"})
  void testBuilderInputWithObject_whenInput_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputResult = builder.input("Input");

    // Assert
    assertSame(builder, actualInputResult);
  }

  /**
   * Test {@link MultiEntityIdInput#setInputFromVerticesAndIds(Object[])}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then {@link GetWalks} (default constructor) Input {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInput#setInputFromVerticesAndIds(Object[])}
   */
  @Test
  @DisplayName(
      "Test setInputFromVerticesAndIds(Object[]); when 'Input'; then GetWalks (default constructor) Input List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiEntityIdInput.setInputFromVerticesAndIds(Object[])"})
  void testSetInputFromVerticesAndIds_whenInput_thenGetWalksInputList() {
    // Arrange
    GetWalks getWalks = new GetWalks();

    // Act
    getWalks.setInputFromVerticesAndIds("Input");

    // Assert
    Iterable<? extends EntityId> input = getWalks.getInput();
    assertTrue(input instanceof List);
    assertEquals(1, ((List<? extends EntityId>) input).size());
    EntityId getResult = ((List<? extends EntityId>) input).get(0);
    assertTrue(getResult instanceof EntitySeed);
    assertEquals("Input", getResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", getResult.getClassName());
  }

  /**
   * Test {@link MultiEntityIdInput#setInputFromVerticesAndIds(Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link GetWalks} (default constructor) Input is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInput#setInputFromVerticesAndIds(Object[])}
   */
  @Test
  @DisplayName(
      "Test setInputFromVerticesAndIds(Object[]); when 'null'; then GetWalks (default constructor) Input is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiEntityIdInput.setInputFromVerticesAndIds(Object[])"})
  void testSetInputFromVerticesAndIds_whenNull_thenGetWalksInputIsNull() {
    // Arrange
    GetWalks getWalks = new GetWalks();

    // Act
    getWalks.setInputFromVerticesAndIds(null);

    // Assert that nothing has changed
    assertNull(getWalks.getInput());
  }

  /**
   * Test {@link MultiEntityIdInput#createInputArray()}.
   *
   * <ul>
   *   <li>Given {@link GetWalks} (default constructor) Input is {@link ArrayList#ArrayList()}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInput#createInputArray()}
   */
  @Test
  @DisplayName(
      "Test createInputArray(); given GetWalks (default constructor) Input is ArrayList(); then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] MultiEntityIdInput.createInputArray()"})
  void testCreateInputArray_givenGetWalksInputIsArrayList_thenReturnArrayLengthIsZero() {
    // Arrange
    GetWalks getWalks = new GetWalks();
    getWalks.setInput(new ArrayList<>());

    // Act and Assert
    assertEquals(0, getWalks.createInputArray().length);
  }

  /**
   * Test {@link MultiEntityIdInput#createInputArray()}.
   *
   * <ul>
   *   <li>Given {@link GetWalks} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInput#createInputArray()}
   */
  @Test
  @DisplayName("Test createInputArray(); given GetWalks (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] MultiEntityIdInput.createInputArray()"})
  void testCreateInputArray_givenGetWalks_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GetWalks().createInputArray());
  }

  /**
   * Test {@link MultiEntityIdInput#setInput(EntityId[])} with {@code EntityId[]}.
   *
   * <ul>
   *   <li>When array of {@link EntityId} with {@link EntitySeed#EntitySeed()}.
   *   <li>Then {@link GetWalks} (default constructor) Input {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link MultiEntityIdInput#setInput(EntityId[])}
   */
  @Test
  @DisplayName(
      "Test setInput(EntityId[]) with 'EntityId[]'; when array of EntityId with EntitySeed(); then GetWalks (default constructor) Input List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiEntityIdInput.setInput(EntityId[])"})
  void testSetInputWithEntityId_whenArrayOfEntityIdWithEntitySeed_thenGetWalksInputList() {
    // Arrange
    GetWalks getWalks = new GetWalks();
    EntitySeed entitySeed = new EntitySeed();

    // Act
    getWalks.setInput(new EntityId[] {entitySeed});

    // Assert
    Iterable<? extends EntityId> input = getWalks.getInput();
    assertTrue(input instanceof List);
    assertEquals(1, ((List<? extends EntityId>) input).size());
    assertSame(entitySeed, ((List<? extends EntityId>) input).get(0));
  }
}
