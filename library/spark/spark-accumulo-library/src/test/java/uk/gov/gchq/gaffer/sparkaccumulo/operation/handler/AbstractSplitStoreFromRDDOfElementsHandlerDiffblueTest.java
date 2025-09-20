package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.javardd.SplitStoreFromJavaRDDOfElementsHandler;
import uk.gov.gchq.gaffer.store.Context;

class AbstractSplitStoreFromRDDOfElementsHandlerDiffblueTest {
  /**
   * Test {@link AbstractSplitStoreFromRDDOfElementsHandler#adjustFractionToSampleForSize(Double,
   * Integer, long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code 0.001}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSplitStoreFromRDDOfElementsHandler#adjustFractionToSampleForSize(Double, Integer,
   * long)}
   */
  @Test
  @DisplayName(
      "Test adjustFractionToSampleForSize(Double, Integer, long); when 'null'; then return '0.001'")
  @Tag("MaintainedByDiffblue")
  void testAdjustFractionToSampleForSize_whenNull_thenReturn0001() {
    // Arrange, Act and Assert
    assertEquals(
        0.001d,
        new SplitStoreFromJavaRDDOfElementsHandler().adjustFractionToSampleForSize(null, null, 3L));
  }

  /**
   * Test {@link AbstractSplitStoreFromRDDOfElementsHandler#adjustFractionToSampleForSize(Double,
   * Integer, long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code 0.001}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSplitStoreFromRDDOfElementsHandler#adjustFractionToSampleForSize(Double, Integer,
   * long)}
   */
  @Test
  @DisplayName(
      "Test adjustFractionToSampleForSize(Double, Integer, long); when 'null'; then return '0.001'")
  @Tag("MaintainedByDiffblue")
  void testAdjustFractionToSampleForSize_whenNull_thenReturn00012() {
    // Arrange, Act and Assert
    assertEquals(
        0.001d,
        new SplitStoreFromJavaRDDOfElementsHandler().adjustFractionToSampleForSize(null, 3, 3L));
  }

  /**
   * Test {@link AbstractSplitStoreFromRDDOfElementsHandler#adjustFractionToSampleForSize(Double,
   * Integer, long)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSplitStoreFromRDDOfElementsHandler#adjustFractionToSampleForSize(Double, Integer,
   * long)}
   */
  @Test
  @DisplayName(
      "Test adjustFractionToSampleForSize(Double, Integer, long); when ten; then return one")
  @Tag("MaintainedByDiffblue")
  void testAdjustFractionToSampleForSize_whenTen_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1.0d,
        new SplitStoreFromJavaRDDOfElementsHandler().adjustFractionToSampleForSize(10.0d, 3, 3L));
  }

  /**
   * Test {@link AbstractSplitStoreFromRDDOfElementsHandler#adjustFractionToSampleForSize(Double,
   * Integer, long)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSplitStoreFromRDDOfElementsHandler#adjustFractionToSampleForSize(Double, Integer,
   * long)}
   */
  @Test
  @DisplayName(
      "Test adjustFractionToSampleForSize(Double, Integer, long); when ten; then return ten")
  @Tag("MaintainedByDiffblue")
  void testAdjustFractionToSampleForSize_whenTen_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(
        10.0d,
        new SplitStoreFromJavaRDDOfElementsHandler()
            .adjustFractionToSampleForSize(10.0d, null, 3L));
  }

  /**
   * Test {@link AbstractSplitStoreFromRDDOfElementsHandler#createSplitPoints(AccumuloStore,
   * Context, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link AccumuloStore#execute(Output, Context)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSplitStoreFromRDDOfElementsHandler#createSplitPoints(AccumuloStore, Context, List)}
   */
  @Test
  @DisplayName(
      "Test createSplitPoints(AccumuloStore, Context, List); given '42'; when ArrayList() add '42'; then calls execute(Output, Context)")
  @Tag("MaintainedByDiffblue")
  void testCreateSplitPoints_given42_whenArrayListAdd42_thenCallsExecute()
      throws OperationException {
    // Arrange
    SplitStoreFromJavaRDDOfElementsHandler splitStoreFromJavaRDDOfElementsHandler =
        new SplitStoreFromJavaRDDOfElementsHandler();

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.execute(Mockito.<Output<Object>>any(), Mockito.<Context>any()))
        .thenReturn("Execute");
    Context context = new Context();

    ArrayList<String> sample = new ArrayList<>();
    sample.add("42");
    sample.add("foo");

    // Act
    splitStoreFromJavaRDDOfElementsHandler.createSplitPoints(store, context, sample);

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
  }

  /**
   * Test {@link AbstractSplitStoreFromRDDOfElementsHandler#createSplitPoints(AccumuloStore,
   * Context, List)}.
   *
   * <ul>
   *   <li>Given {@code Execute}.
   *   <li>Then calls {@link AccumuloStore#execute(Output, Context)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSplitStoreFromRDDOfElementsHandler#createSplitPoints(AccumuloStore, Context, List)}
   */
  @Test
  @DisplayName(
      "Test createSplitPoints(AccumuloStore, Context, List); given 'Execute'; then calls execute(Output, Context)")
  @Tag("MaintainedByDiffblue")
  void testCreateSplitPoints_givenExecute_thenCallsExecute() throws OperationException {
    // Arrange
    SplitStoreFromJavaRDDOfElementsHandler splitStoreFromJavaRDDOfElementsHandler =
        new SplitStoreFromJavaRDDOfElementsHandler();

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.execute(Mockito.<Output<Object>>any(), Mockito.<Context>any()))
        .thenReturn("Execute");
    Context context = new Context();

    // Act
    splitStoreFromJavaRDDOfElementsHandler.createSplitPoints(store, context, new ArrayList<>());

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
  }

  /**
   * Test {@link AbstractSplitStoreFromRDDOfElementsHandler#createSplitPoints(AccumuloStore,
   * Context, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then calls {@link AccumuloStore#execute(Output, Context)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractSplitStoreFromRDDOfElementsHandler#createSplitPoints(AccumuloStore, Context, List)}
   */
  @Test
  @DisplayName(
      "Test createSplitPoints(AccumuloStore, Context, List); given 'foo'; when ArrayList() add 'foo'; then calls execute(Output, Context)")
  @Tag("MaintainedByDiffblue")
  void testCreateSplitPoints_givenFoo_whenArrayListAddFoo_thenCallsExecute()
      throws OperationException {
    // Arrange
    SplitStoreFromJavaRDDOfElementsHandler splitStoreFromJavaRDDOfElementsHandler =
        new SplitStoreFromJavaRDDOfElementsHandler();

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.execute(Mockito.<Output<Object>>any(), Mockito.<Context>any()))
        .thenReturn("Execute");
    Context context = new Context();

    ArrayList<String> sample = new ArrayList<>();
    sample.add("foo");

    // Act
    splitStoreFromJavaRDDOfElementsHandler.createSplitPoints(store, context, sample);

    // Assert
    verify(store).execute(isA(Output.class), isA(Context.class));
  }
}
