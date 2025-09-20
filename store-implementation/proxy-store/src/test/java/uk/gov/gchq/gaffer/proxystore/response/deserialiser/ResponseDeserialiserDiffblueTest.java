package uk.gov.gchq.gaffer.proxystore.response.deserialiser;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.proxystore.response.deserialiser.impl.OperationsResponseDeserialiser;

class ResponseDeserialiserDiffblueTest {
  /**
   * Test {@link ResponseDeserialiser#encodeString(String)}.
   *
   * <p>Method under test: {@link ResponseDeserialiser#encodeString(String)}
   */
  @Test
  @DisplayName("Test encodeString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ResponseDeserialiser.encodeString(String)"})
  void testEncodeString() throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "Json String".getBytes("UTF-8"),
        new OperationsResponseDeserialiser().encodeString("Json String"));
  }
}
