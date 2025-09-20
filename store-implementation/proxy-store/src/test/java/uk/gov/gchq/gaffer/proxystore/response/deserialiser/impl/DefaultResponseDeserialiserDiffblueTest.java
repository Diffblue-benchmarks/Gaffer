package uk.gov.gchq.gaffer.proxystore.response.deserialiser.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class DefaultResponseDeserialiserDiffblueTest {
  /**
   * Test {@link DefaultResponseDeserialiser#deserialise(String)}.
   *
   * <ul>
   *   <li>When {@code Json String}.
   *   <li>Then return {@code Json String}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultResponseDeserialiser#deserialise(String)}
   */
  @Test
  @DisplayName("Test deserialise(String); when 'Json String'; then return 'Json String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DefaultResponseDeserialiser.deserialise(String)"})
  void testDeserialise_whenJsonString_thenReturnJsonString() throws SerialisationException {
    // Arrange
    DefaultResponseDeserialiser<Object> defaultResponseDeserialiser =
        new DefaultResponseDeserialiser<>(new TypeReferenceImpl.Object());

    // Act and Assert
    assertEquals("Json String", defaultResponseDeserialiser.deserialise("Json String"));
  }
}
