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

package uk.gov.gchq.gaffer.core.exception.serialisation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.core.exception.Status;

class StatusSerialiserDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link StatusSerialiser}
   */
  @Test
  void testNewStatusSerialiser() {
    // Arrange and Act
    StatusSerialiser actualStatusSerialiser = new StatusSerialiser();

    // Assert
    assertNull(actualStatusSerialiser.getDelegatee());
    assertFalse(actualStatusSerialiser.isUnwrappingSerializer());
  }

  /**
   * Method under test:
   * {@link StatusSerialiser#serialize(Status, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize() throws IOException {
    // Arrange
    StatusSerialiser statusSerialiser = new StatusSerialiser();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeString(Mockito.<String>any());
    JsonGeneratorDelegate generator = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    // Act
    statusSerialiser.serialize(Status.CONTINUE, generator, new DefaultSerializerProvider.Impl());

    // Assert
    verify(d).writeString(eq("Continue"));
  }
}
