package uk.gov.gchq.gaffer.sparkaccumulo.operation.utils.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.spark.broadcast.TorrentBroadcast;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scala.Tuple2;
import uk.gov.gchq.gaffer.accumulostore.key.AccumuloElementConverter;
import uk.gov.gchq.gaffer.accumulostore.key.MockAccumuloElementConverter;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;

class ElementConverterFunctionDiffblueTest {
  /**
   * Test {@link ElementConverterFunction#call(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Then return next.
   * </ul>
   *
   * <p>Method under test: {@link ElementConverterFunction#call(Element)}
   */
  @Test
  @DisplayName("Test call(Element) with 'Element'; then return next")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator ElementConverterFunction.call(Element)"})
  void testCallWithElement_thenReturnNext() throws Exception {
    // Arrange
    TorrentBroadcast<AccumuloElementConverter> converterBroadcast = mock(TorrentBroadcast.class);

    MockAccumuloElementConverter mockAccumuloElementConverter =
        mock(MockAccumuloElementConverter.class);
    when(mockAccumuloElementConverter.getValueFromElement(Mockito.<Element>any()))
        .thenReturn(new Value());
    Key key = new Key();
    Pair<Key, Key> pair = new Pair<>(key, new Key());
    when(mockAccumuloElementConverter.getKeysFromElement(Mockito.<Element>any())).thenReturn(pair);
    when(converterBroadcast.value()).thenReturn(mockAccumuloElementConverter);
    Edge e = new Edge("Group");

    // Act
    Iterator<Tuple2<Key, Value>> actualCallResult =
        new ElementConverterFunction(converterBroadcast).call(e);

    // Assert
    Tuple2<Key, Value> nextResult = actualCallResult.next();
    Tuple2<Key, Value> actualNextResult = actualCallResult.next();
    boolean actualHasNextResult = actualCallResult.hasNext();
    verify(converterBroadcast, atLeast(1)).value();
    verify(mockAccumuloElementConverter).getKeysFromElement(isA(Element.class));
    verify(mockAccumuloElementConverter).getValueFromElement(isA(Element.class));
    assertFalse(actualHasNextResult);
    assertEquals(nextResult, actualNextResult);
    assertSame(key, nextResult._1());
    assertSame(key, nextResult._1);
  }

  /**
   * Test {@link ElementConverterFunction#call(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Then return next _1 is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementConverterFunction#call(Element)}
   */
  @Test
  @DisplayName("Test call(Element) with 'Element'; then return next _1 is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator ElementConverterFunction.call(Element)"})
  void testCallWithElement_thenReturnNext_1IsNull() throws Exception {
    // Arrange
    MockAccumuloElementConverter mockAccumuloElementConverter =
        mock(MockAccumuloElementConverter.class);
    Value value = new Value();
    when(mockAccumuloElementConverter.getValueFromElement(Mockito.<Element>any()))
        .thenReturn(value);
    when(mockAccumuloElementConverter.getKeysFromElement(Mockito.<Element>any()))
        .thenReturn(new Pair<>());

    TorrentBroadcast<AccumuloElementConverter> converterBroadcast = mock(TorrentBroadcast.class);
    when(converterBroadcast.value()).thenReturn(mockAccumuloElementConverter);
    ElementConverterFunction elementConverterFunction =
        new ElementConverterFunction(converterBroadcast);

    // Act
    Iterator<Tuple2<Key, Value>> actualCallResult =
        elementConverterFunction.call(new Edge("Group"));

    // Assert
    verify(converterBroadcast, atLeast(1)).value();
    verify(mockAccumuloElementConverter).getKeysFromElement(isA(Element.class));
    verify(mockAccumuloElementConverter).getValueFromElement(isA(Element.class));
    Tuple2<Key, Value> nextResult = actualCallResult.next();
    assertNull(nextResult._1());
    assertNull(nextResult._1);
    assertFalse(actualCallResult.hasNext());
    assertSame(value, nextResult._2());
    assertSame(value, nextResult._2);
  }
}
