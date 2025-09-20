package uk.gov.gchq.gaffer.spark.serialisation.kryo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Output;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.HyperLogLogPlusKryoSerializer;

class WrappedKryoSerializerDiffblueTest {
  /**
   * Test {@link WrappedKryoSerializer#write(Kryo, Output, Object)}.
   *
   * <ul>
   *   <li>When {@link Output} {@link Output#writeBytes(byte[])} does nothing.
   *   <li>Then calls {@link HyperLogLogPlus#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedKryoSerializer#write(Kryo, Output, Object)}
   */
  @Test
  @DisplayName(
      "Test write(Kryo, Output, Object); when Output writeBytes(byte[]) does nothing; then calls getBytes()")
  @Tag("MaintainedByDiffblue")
  void testWrite_whenOutputWriteBytesDoesNothing_thenCallsGetBytes()
      throws KryoException, IOException {
    // Arrange
    HyperLogLogPlusKryoSerializer hyperLogLogPlusKryoSerializer =
        new HyperLogLogPlusKryoSerializer();
    Kryo kryo = new Kryo();

    Output output = mock(Output.class);
    doNothing().when(output).writeBytes(Mockito.<byte[]>any());
    doNothing().when(output).writeInt(anyInt());

    HyperLogLogPlus hyperLogLogPlus = mock(HyperLogLogPlus.class);
    when(hyperLogLogPlus.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    hyperLogLogPlusKryoSerializer.write(kryo, output, hyperLogLogPlus);

    // Assert
    verify(hyperLogLogPlus).getBytes();
    verify(output).writeBytes(isA(byte[].class));
    verify(output).writeInt(8);
  }

  /**
   * Test {@link WrappedKryoSerializer#equals(Object)}, and {@link
   * WrappedKryoSerializer#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WrappedKryoSerializer#equals(Object)}
   *   <li>{@link WrappedKryoSerializer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HyperLogLogPlusKryoSerializer hyperLogLogPlusKryoSerializer =
        new HyperLogLogPlusKryoSerializer();

    // Act and Assert
    assertEquals(hyperLogLogPlusKryoSerializer, hyperLogLogPlusKryoSerializer);
    int expectedHashCodeResult = hyperLogLogPlusKryoSerializer.hashCode();
    assertEquals(expectedHashCodeResult, hyperLogLogPlusKryoSerializer.hashCode());
  }

  /**
   * Test {@link WrappedKryoSerializer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WrappedKryoSerializer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HyperLogLogPlusKryoSerializer hyperLogLogPlusKryoSerializer =
        new HyperLogLogPlusKryoSerializer();

    // Act and Assert
    assertNotEquals(hyperLogLogPlusKryoSerializer, new HyperLogLogPlusKryoSerializer());
  }

  /**
   * Test {@link WrappedKryoSerializer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WrappedKryoSerializer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HyperLogLogPlusKryoSerializer(), null);
  }

  /**
   * Test {@link WrappedKryoSerializer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WrappedKryoSerializer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HyperLogLogPlusKryoSerializer(), "Different type to WrappedKryoSerializer");
  }
}
