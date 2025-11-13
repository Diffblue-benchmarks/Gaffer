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
