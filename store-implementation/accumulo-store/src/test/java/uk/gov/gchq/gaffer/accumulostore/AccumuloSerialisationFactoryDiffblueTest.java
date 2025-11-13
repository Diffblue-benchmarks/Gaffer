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

package uk.gov.gchq.gaffer.accumulostore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.ordered.OrderedDateSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.ordered.OrderedIntegerSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.ordered.OrderedLongSerialiser;
import uk.gov.gchq.gaffer.sketches.datasketches.sampling.serialisation.ReservoirNumbersUnionSerialiser;
import uk.gov.gchq.gaffer.sketches.datasketches.sampling.serialisation.ReservoirStringsUnionSerialiser;
import uk.gov.gchq.gaffer.sketches.datasketches.theta.serialisation.UnionSerialiser;

class AccumuloSerialisationFactoryDiffblueTest {
  /**
   * Test new {@link AccumuloSerialisationFactory} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AccumuloSerialisationFactory}
   */
  @Test
  @DisplayName("Test new AccumuloSerialisationFactory (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloSerialisationFactory.<init>()"})
  void testNewAccumuloSerialisationFactory() {
    // Arrange, Act and Assert
    List<Serialiser> serialisers = (new AccumuloSerialisationFactory()).getSerialisers();
    assertEquals(24, serialisers.size());
    Serialiser getResult = serialisers.get(1);
    assertTrue(getResult instanceof OrderedDateSerialiser);
    Serialiser getResult2 = serialisers.get(2);
    assertTrue(getResult2 instanceof OrderedIntegerSerialiser);
    Serialiser getResult3 = serialisers.get(0);
    assertTrue(getResult3 instanceof OrderedLongSerialiser);
    Serialiser getResult4 = serialisers.get(21);
    assertTrue(getResult4 instanceof ReservoirNumbersUnionSerialiser);
    Serialiser getResult5 = serialisers.get(22);
    assertTrue(getResult5 instanceof ReservoirStringsUnionSerialiser);
    Serialiser getResult6 = serialisers.get(23);
    assertTrue(getResult6 instanceof UnionSerialiser);
    assertFalse(getResult4.isConsistent());
    assertFalse(getResult5.isConsistent());
    assertFalse(getResult6.isConsistent());
    assertTrue(getResult3.isConsistent());
    assertTrue(getResult.isConsistent());
    assertTrue(getResult2.isConsistent());
  }
}
