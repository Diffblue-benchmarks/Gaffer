/*
 * Copyright 2025 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WrappedKryoSerializer.write(Kryo, Output, Object)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WrappedKryoSerializer.equals(Object)",
    "int WrappedKryoSerializer.hashCode()"
  })
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WrappedKryoSerializer.equals(Object)",
    "int WrappedKryoSerializer.hashCode()"
  })
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WrappedKryoSerializer.equals(Object)",
    "int WrappedKryoSerializer.hashCode()"
  })
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WrappedKryoSerializer.equals(Object)",
    "int WrappedKryoSerializer.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HyperLogLogPlusKryoSerializer(), "Different type to WrappedKryoSerializer");
  }
}
