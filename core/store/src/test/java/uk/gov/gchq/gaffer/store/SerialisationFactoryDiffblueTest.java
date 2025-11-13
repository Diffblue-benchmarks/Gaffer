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

package uk.gov.gchq.gaffer.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.serialisation.FreqMapSerialiser;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.serialisation.TypeSubTypeValueSerialiser;
import uk.gov.gchq.gaffer.serialisation.TypeValueSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.BooleanSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.JavaSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.StringSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.TreeSetStringSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.ordered.OrderedDateSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.ordered.OrderedDoubleSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.ordered.OrderedFloatSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.ordered.OrderedIntegerSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.ordered.OrderedLongSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.raw.CompactRawLongSerialiser;

class SerialisationFactoryDiffblueTest {
  /**
   * Test {@link SerialisationFactory#SerialisationFactory()}.
   * <p>
   * Method under test: {@link SerialisationFactory#SerialisationFactory()}
   */
  @Test
  @DisplayName("Test new SerialisationFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SerialisationFactory.<init>()"})
  void testNewSerialisationFactory() {
    // Arrange, Act and Assert
    List<Serialiser> serialisers = (new SerialisationFactory()).getSerialisers();
    assertEquals(14, serialisers.size());
    Serialiser getResult = serialisers.get(13);
    assertTrue(getResult instanceof FreqMapSerialiser);
    Serialiser getResult2 = serialisers.get(12);
    assertTrue(getResult2 instanceof TypeSubTypeValueSerialiser);
    Serialiser getResult3 = serialisers.get(11);
    assertTrue(getResult3 instanceof TypeValueSerialiser);
    Serialiser getResult4 = serialisers.get(1);
    assertTrue(getResult4 instanceof OrderedDateSerialiser);
    Serialiser getResult5 = serialisers.get(2);
    assertTrue(getResult5 instanceof OrderedIntegerSerialiser);
    Serialiser getResult6 = serialisers.get(0);
    assertTrue(getResult6 instanceof OrderedLongSerialiser);
    assertFalse(getResult.isConsistent());
    assertTrue(getResult6.isConsistent());
    assertTrue(getResult4.isConsistent());
    assertTrue(getResult3.isConsistent());
    assertTrue(getResult2.isConsistent());
    assertTrue(getResult5.isConsistent());
  }

  /**
   * Test {@link SerialisationFactory#SerialisationFactory(Serialiser[])}.
   * <ul>
   *   <li>When {@link AvroSerialiser} (default constructor).</li>
   *   <li>Then return Serialisers size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SerialisationFactory#SerialisationFactory(Serialiser[])}
   */
  @Test
  @DisplayName("Test new SerialisationFactory(Serialiser[]); when AvroSerialiser (default constructor); then return Serialisers size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SerialisationFactory.<init>(Serialiser[])"})
  void testNewSerialisationFactory_whenAvroSerialiser_thenReturnSerialisersSizeIsOne() {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();

    // Act and Assert
    List<Serialiser> serialisers = (new SerialisationFactory(avroSerialiser)).getSerialisers();
    assertEquals(1, serialisers.size());
    Serialiser getResult = serialisers.get(0);
    assertTrue(getResult instanceof AvroSerialiser);
    assertFalse(getResult.isConsistent());
    assertSame(avroSerialiser, getResult);
  }

  /**
   * Test {@link SerialisationFactory#getSerialisers()}.
   * <p>
   * Method under test: {@link SerialisationFactory#getSerialisers()}
   */
  @Test
  @DisplayName("Test getSerialisers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SerialisationFactory.getSerialisers()"})
  void testGetSerialisers() {
    // Arrange and Act
    List<Serialiser> actualSerialisers = (new SerialisationFactory()).getSerialisers();

    // Assert
    assertEquals(14, actualSerialisers.size());
    assertTrue(actualSerialisers.get(13) instanceof FreqMapSerialiser);
    assertTrue(actualSerialisers.get(12) instanceof TypeSubTypeValueSerialiser);
    assertTrue(actualSerialisers.get(11) instanceof TypeValueSerialiser);
    assertTrue(actualSerialisers.get(9) instanceof BooleanSerialiser);
    assertTrue(actualSerialisers.get(5) instanceof StringSerialiser);
    assertTrue(actualSerialisers.get(10) instanceof TreeSetStringSerialiser);
    assertTrue(actualSerialisers.get(1) instanceof OrderedDateSerialiser);
    assertTrue(actualSerialisers.get(3) instanceof OrderedDoubleSerialiser);
    assertTrue(actualSerialisers.get(4) instanceof OrderedFloatSerialiser);
    assertTrue(actualSerialisers.get(2) instanceof OrderedIntegerSerialiser);
    assertTrue(actualSerialisers.get(0) instanceof OrderedLongSerialiser);
    assertTrue(actualSerialisers.get(8) instanceof CompactRawLongSerialiser);
  }

  /**
   * Test {@link SerialisationFactory#addSerialisers(Serialiser[])}.
   * <ul>
   *   <li>Then {@link SerialisationFactory#SerialisationFactory()} Serialisers size is fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link SerialisationFactory#addSerialisers(Serialiser[])}
   */
  @Test
  @DisplayName("Test addSerialisers(Serialiser[]); then SerialisationFactory() Serialisers size is fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SerialisationFactory.addSerialisers(Serialiser[])"})
  void testAddSerialisers_thenSerialisationFactorySerialisersSizeIsFifteen() {
    // Arrange
    SerialisationFactory serialisationFactory = new SerialisationFactory();
    AvroSerialiser avroSerialiser = new AvroSerialiser();

    // Act
    serialisationFactory.addSerialisers(avroSerialiser);

    // Assert
    List<Serialiser> serialisers = serialisationFactory.getSerialisers();
    assertEquals(15, serialisers.size());
    assertSame(avroSerialiser, serialisers.get(14));
  }

  /**
   * Test {@link SerialisationFactory#addSerialisers(Serialiser[])}.
   * <ul>
   *   <li>Then {@link SerialisationFactory#SerialisationFactory()} Serialisers size is fourteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link SerialisationFactory#addSerialisers(Serialiser[])}
   */
  @Test
  @DisplayName("Test addSerialisers(Serialiser[]); then SerialisationFactory() Serialisers size is fourteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SerialisationFactory.addSerialisers(Serialiser[])"})
  void testAddSerialisers_thenSerialisationFactorySerialisersSizeIsFourteen() {
    // Arrange
    SerialisationFactory serialisationFactory = new SerialisationFactory();

    // Act
    serialisationFactory.addSerialisers(new FreqMapSerialiser());

    // Assert that nothing has changed
    assertEquals(14, serialisationFactory.getSerialisers().size());
  }

  /**
   * Test {@link SerialisationFactory#getSerialiser(Class, boolean, boolean)} with {@code objClass}, {@code preserveOrder}, {@code consistentSerialiser}.
   * <p>
   * Method under test: {@link SerialisationFactory#getSerialiser(Class, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getSerialiser(Class, boolean, boolean) with 'objClass', 'preserveOrder', 'consistentSerialiser'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serialiser SerialisationFactory.getSerialiser(Class, boolean, boolean)"})
  void testGetSerialiserWithObjClassPreserveOrderConsistentSerialiser() {
    // Arrange
    SerialisationFactory serialisationFactory = new SerialisationFactory();
    Class<Object> objClass = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> serialisationFactory.getSerialiser(objClass, true, true));
  }

  /**
   * Test {@link SerialisationFactory#getSerialiser(Class, boolean, boolean)} with {@code objClass}, {@code preserveOrder}, {@code consistentSerialiser}.
   * <p>
   * Method under test: {@link SerialisationFactory#getSerialiser(Class, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getSerialiser(Class, boolean, boolean) with 'objClass', 'preserveOrder', 'consistentSerialiser'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serialiser SerialisationFactory.getSerialiser(Class, boolean, boolean)"})
  void testGetSerialiserWithObjClassPreserveOrderConsistentSerialiser2() {
    // Arrange
    SerialisationFactory serialisationFactory = new SerialisationFactory();
    Class<Serialiser> objClass = Serialiser.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> serialisationFactory.getSerialiser(objClass, true, true));
  }

  /**
   * Test {@link SerialisationFactory#getSerialiser(Class, boolean, boolean)} with {@code objClass}, {@code preserveOrder}, {@code consistentSerialiser}.
   * <p>
   * Method under test: {@link SerialisationFactory#getSerialiser(Class, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getSerialiser(Class, boolean, boolean) with 'objClass', 'preserveOrder', 'consistentSerialiser'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serialiser SerialisationFactory.getSerialiser(Class, boolean, boolean)"})
  void testGetSerialiserWithObjClassPreserveOrderConsistentSerialiser3() {
    // Arrange
    SerialisationFactory serialisationFactory = new SerialisationFactory();
    Class<Serialiser> objClass = Serialiser.class;

    // Act
    Serialiser actualSerialiser = serialisationFactory.getSerialiser(objClass, false, true);

    // Assert
    assertTrue(actualSerialiser instanceof JavaSerialiser);
    assertFalse(actualSerialiser.isConsistent());
  }

  /**
   * Test {@link SerialisationFactory#getSerialiser(Class, boolean, boolean)} with {@code objClass}, {@code preserveOrder}, {@code consistentSerialiser}.
   * <p>
   * Method under test: {@link SerialisationFactory#getSerialiser(Class, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getSerialiser(Class, boolean, boolean) with 'objClass', 'preserveOrder', 'consistentSerialiser'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serialiser SerialisationFactory.getSerialiser(Class, boolean, boolean)"})
  void testGetSerialiserWithObjClassPreserveOrderConsistentSerialiser4() {
    // Arrange
    SerialisationFactory serialisationFactory = new SerialisationFactory(new AvroSerialiser());
    Class<Serialiser> objClass = Serialiser.class;

    // Act
    Serialiser actualSerialiser = serialisationFactory.getSerialiser(objClass, false, true);

    // Assert
    assertTrue(actualSerialiser instanceof JavaSerialiser);
    assertFalse(actualSerialiser.isConsistent());
  }

  /**
   * Test {@link SerialisationFactory#getSerialiser(Class, boolean, boolean)} with {@code objClass}, {@code preserveOrder}, {@code consistentSerialiser}.
   * <p>
   * Method under test: {@link SerialisationFactory#getSerialiser(Class, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getSerialiser(Class, boolean, boolean) with 'objClass', 'preserveOrder', 'consistentSerialiser'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serialiser SerialisationFactory.getSerialiser(Class, boolean, boolean)"})
  void testGetSerialiserWithObjClassPreserveOrderConsistentSerialiser5() {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();
    SerialisationFactory serialisationFactory = new SerialisationFactory(avroSerialiser);
    Class<Serialiser> objClass = Serialiser.class;

    // Act
    Serialiser actualSerialiser = serialisationFactory.getSerialiser(objClass, false, false);

    // Assert
    assertTrue(actualSerialiser instanceof AvroSerialiser);
    assertFalse(actualSerialiser.isConsistent());
    assertSame(avroSerialiser, actualSerialiser);
  }

  /**
   * Test {@link SerialisationFactory#getSerialiser(Class, boolean, boolean)} with {@code objClass}, {@code preserveOrder}, {@code consistentSerialiser}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SerialisationFactory#getSerialiser(Class, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getSerialiser(Class, boolean, boolean) with 'objClass', 'preserveOrder', 'consistentSerialiser'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serialiser SerialisationFactory.getSerialiser(Class, boolean, boolean)"})
  void testGetSerialiserWithObjClassPreserveOrderConsistentSerialiser_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new SerialisationFactory()).getSerialiser(null, true, true));
  }

  /**
   * Test {@link SerialisationFactory#getSerialiser(Class)} with {@code objClass}.
   * <ul>
   *   <li>Then return {@link AvroSerialiser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SerialisationFactory#getSerialiser(Class)}
   */
  @Test
  @DisplayName("Test getSerialiser(Class) with 'objClass'; then return AvroSerialiser")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serialiser SerialisationFactory.getSerialiser(Class)"})
  void testGetSerialiserWithObjClass_thenReturnAvroSerialiser() {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();
    SerialisationFactory serialisationFactory = new SerialisationFactory(avroSerialiser);
    Class<Object> objClass = Object.class;

    // Act
    Serialiser actualSerialiser = serialisationFactory.getSerialiser(objClass);

    // Assert
    assertTrue(actualSerialiser instanceof AvroSerialiser);
    assertFalse(actualSerialiser.isConsistent());
    assertSame(avroSerialiser, actualSerialiser);
  }

  /**
   * Test {@link SerialisationFactory#getSerialiser(Class)} with {@code objClass}.
   * <ul>
   *   <li>Then return {@link JavaSerialiser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SerialisationFactory#getSerialiser(Class)}
   */
  @Test
  @DisplayName("Test getSerialiser(Class) with 'objClass'; then return JavaSerialiser")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serialiser SerialisationFactory.getSerialiser(Class)"})
  void testGetSerialiserWithObjClass_thenReturnJavaSerialiser() {
    // Arrange
    SerialisationFactory serialisationFactory = new SerialisationFactory();
    Class<Serialiser> objClass = Serialiser.class;

    // Act
    Serialiser actualSerialiser = serialisationFactory.getSerialiser(objClass);

    // Assert
    assertTrue(actualSerialiser instanceof JavaSerialiser);
    assertFalse(actualSerialiser.isConsistent());
  }

  /**
   * Test {@link SerialisationFactory#getSerialiser(Class)} with {@code objClass}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SerialisationFactory#getSerialiser(Class)}
   */
  @Test
  @DisplayName("Test getSerialiser(Class) with 'objClass'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serialiser SerialisationFactory.getSerialiser(Class)"})
  void testGetSerialiserWithObjClass_thenThrowIllegalArgumentException() {
    // Arrange
    SerialisationFactory serialisationFactory = new SerialisationFactory();
    Class<Object> objClass = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> serialisationFactory.getSerialiser(objClass));
  }

  /**
   * Test {@link SerialisationFactory#getSerialiser(Class)} with {@code objClass}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SerialisationFactory#getSerialiser(Class)}
   */
  @Test
  @DisplayName("Test getSerialiser(Class) with 'objClass'; when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Serialiser SerialisationFactory.getSerialiser(Class)"})
  void testGetSerialiserWithObjClass_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new SerialisationFactory()).getSerialiser(null));
  }
}
