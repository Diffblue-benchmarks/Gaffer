package uk.gov.gchq.gaffer.spark.serialisation.kryo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.factories.SerializerFactory;
import com.esotericsoftware.kryo.util.DefaultClassResolver;
import com.esotericsoftware.kryo.util.ListReferenceResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.EdgeKryoSerializer;

class RegistratorDiffblueTest {
  /**
   * Test {@link Registrator#registerClasses(Kryo)}.
   *
   * <p>Method under test: {@link Registrator#registerClasses(Kryo)}
   */
  @Test
  @DisplayName("Test registerClasses(Kryo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Registrator.registerClasses(Kryo)"})
  void testRegisterClasses() {
    // Arrange
    Registrator registrator = new Registrator();
    Kryo kryo = new Kryo(new ListReferenceResolver());

    // Act
    registrator.registerClasses(kryo);

    // Assert
    assertEquals(25, kryo.getNextRegistrationId());
  }

  /**
   * Test {@link Registrator#registerClasses(Kryo)}.
   *
   * <p>Method under test: {@link Registrator#registerClasses(Kryo)}
   */
  @Test
  @DisplayName("Test registerClasses(Kryo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Registrator.registerClasses(Kryo)"})
  void testRegisterClasses2() {
    // Arrange
    Registrator registrator = new Registrator();
    DefaultClassResolver classResolver = new DefaultClassResolver();
    Kryo kryo = new Kryo(classResolver, new ListReferenceResolver());

    // Act
    registrator.registerClasses(kryo);

    // Assert
    assertEquals(25, kryo.getNextRegistrationId());
  }

  /**
   * Test {@link Registrator#registerClasses(Kryo)}.
   *
   * <ul>
   *   <li>Then calls {@link SerializerFactory#makeSerializer(Kryo, Class)}.
   * </ul>
   *
   * <p>Method under test: {@link Registrator#registerClasses(Kryo)}
   */
  @Test
  @DisplayName("Test registerClasses(Kryo); then calls makeSerializer(Kryo, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Registrator.registerClasses(Kryo)"})
  void testRegisterClasses_thenCallsMakeSerializer() {
    // Arrange
    Registrator registrator = new Registrator();

    SerializerFactory serializerFactory = mock(SerializerFactory.class);
    when(serializerFactory.makeSerializer(Mockito.<Kryo>any(), Mockito.<Class<?>>any()))
        .thenReturn(new EdgeKryoSerializer());
    DefaultClassResolver classResolver = new DefaultClassResolver();

    Kryo kryo = new Kryo(classResolver, new ListReferenceResolver());
    Class<Object> type = Object.class;

    kryo.addDefaultSerializer(type, serializerFactory);
    Class<Object> type2 = Object.class;
    kryo.addDefaultSerializer(type2, mock(SerializerFactory.class));
    Class<Object> type3 = Object.class;
    kryo.addDefaultSerializer(type3, mock(SerializerFactory.class));
    Class<Object> type4 = Object.class;
    kryo.addDefaultSerializer(type4, mock(SerializerFactory.class));
    Class<Object> type5 = Object.class;
    kryo.addDefaultSerializer(type5, mock(SerializerFactory.class));
    Class<Object> type6 = Object.class;
    kryo.addDefaultSerializer(type6, mock(SerializerFactory.class));
    Class<Object> type7 = Object.class;
    kryo.addDefaultSerializer(type7, mock(SerializerFactory.class));
    Class<Object> type8 = Object.class;
    kryo.addDefaultSerializer(type8, mock(SerializerFactory.class));
    Class<Object> type9 = Object.class;
    kryo.addDefaultSerializer(type9, mock(SerializerFactory.class));
    Class<Object> type10 = Object.class;
    kryo.addDefaultSerializer(type10, mock(SerializerFactory.class));
    Class<Object> type11 = Object.class;
    kryo.addDefaultSerializer(type11, new EdgeKryoSerializer());

    // Act
    registrator.registerClasses(kryo);

    // Assert
    verify(serializerFactory).makeSerializer(isA(Kryo.class), isA(Class.class));
    assertEquals(25, kryo.getNextRegistrationId());
  }

  /**
   * Test {@link Registrator#registerClasses(Kryo)}.
   *
   * <ul>
   *   <li>Then {@link Kryo#Kryo()} NextRegistrationId is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link Registrator#registerClasses(Kryo)}
   */
  @Test
  @DisplayName("Test registerClasses(Kryo); then Kryo() NextRegistrationId is twenty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Registrator.registerClasses(Kryo)"})
  void testRegisterClasses_thenKryoNextRegistrationIdIsTwentyFive() {
    // Arrange
    Registrator registrator = new Registrator();

    Kryo kryo = new Kryo();
    Class<Object> type = Object.class;
    kryo.addDefaultSerializer(type, new EdgeKryoSerializer());

    // Act
    registrator.registerClasses(kryo);

    // Assert
    assertEquals(25, kryo.getNextRegistrationId());
  }
}
