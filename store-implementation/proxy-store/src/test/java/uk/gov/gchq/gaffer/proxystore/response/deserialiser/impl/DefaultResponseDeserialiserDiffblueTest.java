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
