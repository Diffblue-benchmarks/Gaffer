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

package uk.gov.gchq.gaffer.store.operation.add;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.StoreProperties;

class AddStorePropertiesToLibraryDiffblueTest {
  /**
   * Method under test: {@link AddStorePropertiesToLibrary.Builder#id(String)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    AddStorePropertiesToLibrary.Builder builder = new AddStorePropertiesToLibrary.Builder();

    // Act and Assert
    assertSame(builder, builder.id("42"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AddStorePropertiesToLibrary.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange and Act
    AddStorePropertiesToLibrary.Builder actualBuilder = new AddStorePropertiesToLibrary.Builder();

    // Assert
    AddStorePropertiesToLibrary _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getId());
    assertNull(_getOpResult.getParentPropertiesId());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getProperties());
    assertNull(_getOpResult.getStoreProperties());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Method under test:
   * {@link AddStorePropertiesToLibrary.Builder#parentPropertiesId(String)}
   */
  @Test
  void testBuilderParentPropertiesId() {
    // Arrange
    AddStorePropertiesToLibrary.Builder builder = new AddStorePropertiesToLibrary.Builder();

    // Act and Assert
    assertSame(builder, builder.parentPropertiesId("42"));
  }

  /**
   * Method under test:
   * {@link AddStorePropertiesToLibrary.Builder#storeProperties(StoreProperties)}
   */
  @Test
  void testBuilderStoreProperties() {
    // Arrange
    AddStorePropertiesToLibrary.Builder builder = new AddStorePropertiesToLibrary.Builder();

    // Act and Assert
    assertSame(builder, builder.storeProperties(null));
  }

  /**
   * Method under test: {@link AddStorePropertiesToLibrary#shallowClone()}
   */
  @Test
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    AddStorePropertiesToLibrary actualShallowCloneResult = (new AddStorePropertiesToLibrary()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getId());
    assertNull(actualShallowCloneResult.getParentPropertiesId());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getStoreProperties());
  }

  /**
   * Method under test: {@link AddStorePropertiesToLibrary#shallowClone()}
   */
  @Test
  void testShallowClone2() throws CloneFailedException {
    // Arrange
    AddStorePropertiesToLibrary addStorePropertiesToLibrary = new AddStorePropertiesToLibrary();
    addStorePropertiesToLibrary.setOptions(new HashMap<>());

    // Act
    AddStorePropertiesToLibrary actualShallowCloneResult = addStorePropertiesToLibrary.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getId());
    assertNull(actualShallowCloneResult.getParentPropertiesId());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getStoreProperties());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Method under test: {@link AddStorePropertiesToLibrary#shallowClone()}
   */
  @Test
  void testShallowClone3() throws CloneFailedException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    AddStorePropertiesToLibrary addStorePropertiesToLibrary = new AddStorePropertiesToLibrary();
    addStorePropertiesToLibrary.setOptions(options);

    // Act
    AddStorePropertiesToLibrary actualShallowCloneResult = addStorePropertiesToLibrary.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getId());
    assertNull(actualShallowCloneResult.getParentPropertiesId());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getStoreProperties());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Method under test: {@link AddStorePropertiesToLibrary#getProperties()}
   */
  @Test
  void testGetProperties() {
    // Arrange, Act and Assert
    assertNull((new AddStorePropertiesToLibrary()).getProperties());
  }

  /**
   * Method under test: {@link AddStorePropertiesToLibrary#getProperties()}
   */
  @Test
  void testGetProperties2() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.computeIfPresent("foo", mock(BiFunction.class));

    AddStorePropertiesToLibrary addStorePropertiesToLibrary = new AddStorePropertiesToLibrary();
    addStorePropertiesToLibrary.setOptions(options);

    // Act and Assert
    assertNull(addStorePropertiesToLibrary.getProperties());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link AddStorePropertiesToLibrary}
   *   <li>{@link AddStorePropertiesToLibrary#setId(String)}
   *   <li>{@link AddStorePropertiesToLibrary#setOptions(Map)}
   *   <li>{@link AddStorePropertiesToLibrary#setParentPropertiesId(String)}
   *   <li>{@link AddStorePropertiesToLibrary#setStoreProperties(StoreProperties)}
   *   <li>{@link AddStorePropertiesToLibrary#getId()}
   *   <li>{@link AddStorePropertiesToLibrary#getOptions()}
   *   <li>{@link AddStorePropertiesToLibrary#getParentPropertiesId()}
   *   <li>{@link AddStorePropertiesToLibrary#getStoreProperties()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AddStorePropertiesToLibrary actualAddStorePropertiesToLibrary = new AddStorePropertiesToLibrary();
    actualAddStorePropertiesToLibrary.setId("42");
    HashMap<String, String> options = new HashMap<>();
    actualAddStorePropertiesToLibrary.setOptions(options);
    actualAddStorePropertiesToLibrary.setParentPropertiesId("42");
    actualAddStorePropertiesToLibrary.setStoreProperties(null);
    String actualId = actualAddStorePropertiesToLibrary.getId();
    Map<String, String> actualOptions = actualAddStorePropertiesToLibrary.getOptions();
    String actualParentPropertiesId = actualAddStorePropertiesToLibrary.getParentPropertiesId();
    actualAddStorePropertiesToLibrary.getStoreProperties();

    // Assert that nothing has changed
    assertEquals("42", actualId);
    assertEquals("42", actualParentPropertiesId);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
