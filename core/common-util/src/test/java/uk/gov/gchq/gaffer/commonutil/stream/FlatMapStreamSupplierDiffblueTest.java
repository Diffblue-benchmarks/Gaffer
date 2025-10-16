package uk.gov.gchq.gaffer.commonutil.stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterable;

class FlatMapStreamSupplierDiffblueTest {
  /**
   * Test {@link FlatMapStreamSupplier#FlatMapStreamSupplier(Iterable, Function)}.
   *
   * <p>Method under test: {@link FlatMapStreamSupplier#FlatMapStreamSupplier(Iterable, Function)}
   */
  @Test
  @DisplayName("Test new FlatMapStreamSupplier(Iterable, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlatMapStreamSupplier.<init>(Iterable, Function)"})
  void testNewFlatMapStreamSupplier() {
    // Arrange and Act
    FlatMapStreamSupplier<Object, Object> actualFlatMapStreamSupplier =
        new FlatMapStreamSupplier<>(new ArrayList<>(), mock(Function.class));

    // Assert
    Stream<Object> getResult = actualFlatMapStreamSupplier.get();
    assertTrue(getResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link FlatMapStreamSupplier#get()}.
   *
   * <ul>
   *   <li>Given {@link FlatMapStreamSupplier#FlatMapStreamSupplier(Iterable, Function)} with input
   *       is {@link ArrayList#ArrayList()} and {@link Function}.
   * </ul>
   *
   * <p>Method under test: {@link FlatMapStreamSupplier#get()}
   */
  @Test
  @DisplayName(
      "Test get(); given FlatMapStreamSupplier(Iterable, Function) with input is ArrayList() and Function")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream FlatMapStreamSupplier.get()"})
  void testGet_givenFlatMapStreamSupplierWithInputIsArrayListAndFunction() {
    // Arrange
    FlatMapStreamSupplier<Object, Object> flatMapStreamSupplier =
        new FlatMapStreamSupplier<>(new ArrayList<>(), mock(Function.class));

    // Act
    Stream<Object> actualGetResult = flatMapStreamSupplier.get();

    // Assert
    assertTrue(actualGetResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link FlatMapStreamSupplier#get()}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} return {@link ArrayList#ArrayList()}
   *       stream.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link FlatMapStreamSupplier#get()}
   */
  @Test
  @DisplayName("Test get(); given Supplier get() return ArrayList() stream; then calls get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream FlatMapStreamSupplier.get()"})
  void testGet_givenSupplierGetReturnArrayListStream_thenCallsGet() {
    // Arrange
    Supplier<Stream<Object>> streamSupplier = mock(Supplier.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    when(streamSupplier.get()).thenReturn(streamResult);
    StreamIterable<Object> input = new StreamIterable<>(streamSupplier);
    FlatMapStreamSupplier<Object, Object> flatMapStreamSupplier =
        new FlatMapStreamSupplier<>(input, mock(Function.class));

    // Act
    Stream<Object> actualGetResult = flatMapStreamSupplier.get();

    // Assert
    verify(streamSupplier).get();
    assertTrue(actualGetResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
