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

package uk.gov.gchq.gaffer.store.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl;

class GetTraitsDiffblueTest {
  /**
   * Method under test: {@link GetTraits.Builder#currentTraits(boolean)}
   */
  @Test
  void testBuilderCurrentTraits() {
    // Arrange
    GetTraits.Builder builder = new GetTraits.Builder();

    // Act and Assert
    assertSame(builder, builder.currentTraits(true));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link GetTraits.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    GetTraits.Builder actualBuilder = new GetTraits.Builder();

    // Assert
    GetTraits _getOpResult = actualBuilder._getOp();
    TypeReference<Set<StoreTrait>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceStoreImpl.StoreTraits);
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.util.Set<uk.gov.gchq.gaffer.store.StoreTrait>", outputType.getTypeName());
    assertTrue(_getOpResult.getOptions().isEmpty());
    assertTrue(_getOpResult.isCurrentTraits());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetTraits#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    GetTraits actualShallowCloneResult = (new GetTraits()).shallowClone();

    // Assert
    TypeReference<Set<StoreTrait>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceStoreImpl.StoreTraits);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Set<uk.gov.gchq.gaffer.store.StoreTrait>", outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.isCurrentTraits());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetTraits#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetTraits getTraits = new GetTraits();
    getTraits.setOptions(options);

    // Act
    GetTraits actualShallowCloneResult = getTraits.shallowClone();

    // Assert
    TypeReference<Set<StoreTrait>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceStoreImpl.StoreTraits);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.util.Set<uk.gov.gchq.gaffer.store.StoreTrait>", outputType.getTypeName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.isCurrentTraits());
    Class<Set> expectedOutputClass = Set.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Method under test: {@link GetTraits#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Set<StoreTrait>> actualOutputTypeReference = (new GetTraits()).getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceStoreImpl.StoreTraits);
    assertEquals("java.util.Set<uk.gov.gchq.gaffer.store.StoreTrait>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Method under test: {@link GetTraits#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    GetTraits getTraits = new GetTraits();
    getTraits.setOptions(options);

    // Act
    TypeReference<Set<StoreTrait>> actualOutputTypeReference = getTraits.getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof TypeReferenceStoreImpl.StoreTraits);
    assertEquals("java.util.Set<uk.gov.gchq.gaffer.store.StoreTrait>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetTraits}
   *   <li>{@link GetTraits#setCurrentTraits(boolean)}
   *   <li>{@link GetTraits#setOptions(Map)}
   *   <li>{@link GetTraits#getOptions()}
   *   <li>{@link GetTraits#isCurrentTraits()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GetTraits actualGetTraits = new GetTraits();
    actualGetTraits.setCurrentTraits(true);
    HashMap<String, String> options = new HashMap<>();
    actualGetTraits.setOptions(options);
    Map<String, String> actualOptions = actualGetTraits.getOptions();
    boolean actualIsCurrentTraitsResult = actualGetTraits.isCurrentTraits();

    // Assert that nothing has changed
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsCurrentTraitsResult);
    assertSame(options, actualOptions);
  }
}
