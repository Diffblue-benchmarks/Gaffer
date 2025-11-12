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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.store.StoreTrait;

class HasTraitDiffblueTest {
  /**
   * Method under test: {@link HasTrait.Builder#currentTraits(boolean)}
   */
  @Test
  void testBuilderCurrentTraits() {
    // Arrange
    HasTrait.Builder builder = new HasTrait.Builder();

    // Act and Assert
    assertSame(builder, builder.currentTraits(true));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link HasTrait.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    HasTrait.Builder actualBuilder = new HasTrait.Builder();

    // Assert
    HasTrait _getOpResult = actualBuilder._getOp();
    TypeReference<Boolean> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Boolean);
    assertNull(_getOpResult.getTrait());
    assertTrue(_getOpResult.getOptions().isEmpty());
    assertTrue(_getOpResult.isCurrentTraits());
    Class<Boolean> expectedOutputClass = Boolean.class;
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Method under test: {@link HasTrait.Builder#trait(StoreTrait)}
   */
  @Test
  void testBuilderTrait() {
    // Arrange
    HasTrait.Builder builder = new HasTrait.Builder();

    // Act and Assert
    assertSame(builder, builder.trait(StoreTrait.INGEST_AGGREGATION));
  }

  /**
   * Method under test: {@link HasTrait#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    HasTrait actualShallowCloneResult = (new HasTrait()).shallowClone();

    // Assert
    TypeReference<Boolean> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Boolean);
    assertNull(actualShallowCloneResult.getTrait());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.isCurrentTraits());
    Class<Boolean> expectedOutputClass = Boolean.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link HasTrait#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    HasTrait hasTrait = new HasTrait();
    hasTrait.setOptions(options);

    // Act
    HasTrait actualShallowCloneResult = hasTrait.shallowClone();

    // Assert
    TypeReference<Boolean> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Boolean);
    assertNull(actualShallowCloneResult.getTrait());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.isCurrentTraits());
    Class<Boolean> expectedOutputClass = Boolean.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
  }

  /**
   * Method under test: {@link HasTrait#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference() {
    // Arrange, Act and Assert
    assertTrue((new HasTrait()).getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
  }

  /**
   * Method under test: {@link HasTrait#getOutputTypeReference()}
   */
  @Test
  void testGetOutputTypeReference2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    HasTrait hasTrait = new HasTrait();
    hasTrait.setOptions(options);

    // Act and Assert
    assertTrue(hasTrait.getOutputTypeReference() instanceof TypeReferenceImpl.Boolean);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link HasTrait}
   *   <li>{@link HasTrait#setCurrentTraits(boolean)}
   *   <li>{@link HasTrait#setOptions(Map)}
   *   <li>{@link HasTrait#setTrait(StoreTrait)}
   *   <li>{@link HasTrait#getOptions()}
   *   <li>{@link HasTrait#getTrait()}
   *   <li>{@link HasTrait#isCurrentTraits()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    HasTrait actualHasTrait = new HasTrait();
    actualHasTrait.setCurrentTraits(true);
    HashMap<String, String> options = new HashMap<>();
    actualHasTrait.setOptions(options);
    actualHasTrait.setTrait(StoreTrait.INGEST_AGGREGATION);
    Map<String, String> actualOptions = actualHasTrait.getOptions();
    StoreTrait actualTrait = actualHasTrait.getTrait();
    boolean actualIsCurrentTraitsResult = actualHasTrait.isCurrentTraits();

    // Assert that nothing has changed
    assertEquals(StoreTrait.INGEST_AGGREGATION, actualTrait);
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsCurrentTraitsResult);
    assertSame(options, actualOptions);
  }
}
