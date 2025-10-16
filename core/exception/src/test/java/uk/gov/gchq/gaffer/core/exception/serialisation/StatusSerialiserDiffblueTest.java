package uk.gov.gchq.gaffer.core.exception.serialisation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.core.exception.Status;

class StatusSerialiserDiffblueTest {
  /**
   * Test {@link StatusSerialiser#serialize(Status, JsonGenerator, SerializerProvider)} with {@code
   * Status}, {@code JsonGenerator}, {@code SerializerProvider}.
   *
   * <ul>
   *   <li>Then calls {@link JsonGenerator#writeString(String)}.
   * </ul>
   *
   * <p>Method under test: {@link StatusSerialiser#serialize(Status, JsonGenerator,
   * SerializerProvider)}
   */
  @Test
  @DisplayName(
      "Test serialize(Status, JsonGenerator, SerializerProvider) with 'Status', 'JsonGenerator', 'SerializerProvider'; then calls writeString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusSerialiser.serialize(Status, JsonGenerator, SerializerProvider)"})
  void testSerializeWithStatusJsonGeneratorSerializerProvider_thenCallsWriteString()
      throws IOException {
    // Arrange
    StatusSerialiser statusSerialiser = new StatusSerialiser();

    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeString(Mockito.<String>any());
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(d);
    JsonGeneratorDelegate generator = new JsonGeneratorDelegate(d2, true);

    // Act
    statusSerialiser.serialize(Status.CONTINUE, generator, new Impl());

    // Assert
    verify(d).writeString("Continue");
  }

  /**
   * Test new {@link StatusSerialiser} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link StatusSerialiser}
   */
  @Test
  @DisplayName("Test new StatusSerialiser (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatusSerialiser.<init>()"})
  void testNewStatusSerialiser() {
    // Arrange and Act
    StatusSerialiser actualStatusSerialiser = new StatusSerialiser();

    // Assert
    assertNull(actualStatusSerialiser.getDelegatee());
    assertFalse(actualStatusSerialiser.isUnwrappingSerializer());
  }
}
