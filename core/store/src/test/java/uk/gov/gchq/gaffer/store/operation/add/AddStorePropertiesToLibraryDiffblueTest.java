/*
 * Copyright 2026 Crown Copyright
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.operation.add.AddStorePropertiesToLibrary.Builder;

class AddStorePropertiesToLibraryDiffblueTest {
  /**
   * Test Builder {@link Builder#id(String)}.
   *
   * <p>Method under test: {@link Builder#id(String)}
   */
  @Test
  @DisplayName("Test Builder id(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(String)"})
  void testBuilderId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIdResult = builder.id("42");

    // Assert
    assertSame(builder, actualIdResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    AddStorePropertiesToLibrary _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getId());
    assertNull(_getOpResult.getParentPropertiesId());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getProperties());
    assertNull(_getOpResult.getStoreProperties());
    AddStorePropertiesToLibrary actualAddStorePropertiesToLibrary = actualBuilder.build();
    assertSame(_getOpResult, actualAddStorePropertiesToLibrary);
  }

  /**
   * Test Builder {@link Builder#parentPropertiesId(String)}.
   *
   * <p>Method under test: {@link Builder#parentPropertiesId(String)}
   */
  @Test
  @DisplayName("Test Builder parentPropertiesId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentPropertiesId(String)"})
  void testBuilderParentPropertiesId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualParentPropertiesIdResult = builder.parentPropertiesId("42");

    // Assert
    assertSame(builder, actualParentPropertiesIdResult);
  }

  /**
   * Test Builder {@link Builder#storeProperties(StoreProperties)}.
   *
   * <p>Method under test: {@link Builder#storeProperties(StoreProperties)}
   */
  @Test
  @DisplayName("Test Builder storeProperties(StoreProperties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.storeProperties(StoreProperties)"})
  void testBuilderStoreProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualStorePropertiesResult = builder.storeProperties(new StoreProperties());

    // Assert
    assertSame(builder, actualStorePropertiesResult);
  }

  /**
   * Test {@link AddStorePropertiesToLibrary#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddStorePropertiesToLibrary} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddStorePropertiesToLibrary#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddStorePropertiesToLibrary (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddStorePropertiesToLibrary AddStorePropertiesToLibrary.shallowClone()"})
  void testShallowClone_givenAddStorePropertiesToLibrary_thenReturnOptionsIsNull()
      throws CloneFailedException {
    // Arrange and Act
    AddStorePropertiesToLibrary actualShallowCloneResult =
        new AddStorePropertiesToLibrary().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getId());
    assertNull(actualShallowCloneResult.getParentPropertiesId());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getStoreProperties());
  }

  /**
   * Test {@link AddStorePropertiesToLibrary#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddStorePropertiesToLibrary#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AddStorePropertiesToLibrary AddStorePropertiesToLibrary.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() throws CloneFailedException {
    // Arrange
    AddStorePropertiesToLibrary addStorePropertiesToLibrary = new AddStorePropertiesToLibrary();
    addStorePropertiesToLibrary.setOptions(new HashMap<>());

    // Act
    AddStorePropertiesToLibrary actualShallowCloneResult =
        addStorePropertiesToLibrary.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getId());
    assertNull(actualShallowCloneResult.getParentPropertiesId());
    assertNull(actualShallowCloneResult.getProperties());
    assertNull(actualShallowCloneResult.getStoreProperties());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link AddStorePropertiesToLibrary#getProperties()}.
   *
   * <ul>
   *   <li>Given {@link AddStorePropertiesToLibrary} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddStorePropertiesToLibrary#getProperties()}
   */
  @Test
  @DisplayName(
      "Test getProperties(); given AddStorePropertiesToLibrary (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Properties AddStorePropertiesToLibrary.getProperties()"})
  void testGetProperties_givenAddStorePropertiesToLibrary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AddStorePropertiesToLibrary().getProperties());
  }

  /**
   * Test {@link AddStorePropertiesToLibrary#getProperties()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AddStorePropertiesToLibrary#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Properties AddStorePropertiesToLibrary.getProperties()"})
  void testGetProperties_thenReturnSizeIsOne() {
    // Arrange
    AddStorePropertiesToLibrary addStorePropertiesToLibrary = new AddStorePropertiesToLibrary();
    addStorePropertiesToLibrary.setStoreProperties(new StoreProperties());

    // Act
    Properties actualProperties = addStorePropertiesToLibrary.getProperties();

    // Assert
    assertEquals(1, actualProperties.size());
    assertEquals(
        "uk.gov.gchq.gaffer.store.StoreProperties",
        actualProperties.get("gaffer.store.properties.class"));
  }

  /**
   * Test {@link AddStorePropertiesToLibrary#setProperties(Properties)}.
   *
   * <ul>
   *   <li>Then {@link AddStorePropertiesToLibrary} (default constructor) Properties is {@link
   *       Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link AddStorePropertiesToLibrary#setProperties(Properties)}
   */
  @Test
  @DisplayName(
      "Test setProperties(Properties); then AddStorePropertiesToLibrary (default constructor) Properties is Properties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddStorePropertiesToLibrary.setProperties(Properties)"})
  void testSetProperties_thenAddStorePropertiesToLibraryPropertiesIsProperties() {
    // Arrange
    AddStorePropertiesToLibrary addStorePropertiesToLibrary = new AddStorePropertiesToLibrary();
    Properties properties = new Properties();

    // Act
    addStorePropertiesToLibrary.setProperties(properties);

    // Assert
    assertSame(properties, addStorePropertiesToLibrary.getProperties());
  }

  /**
   * Test {@link AddStorePropertiesToLibrary#setProperties(Properties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link AddStorePropertiesToLibrary} (default constructor) Properties is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link AddStorePropertiesToLibrary#setProperties(Properties)}
   */
  @Test
  @DisplayName(
      "Test setProperties(Properties); when 'null'; then AddStorePropertiesToLibrary (default constructor) Properties is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddStorePropertiesToLibrary.setProperties(Properties)"})
  void testSetProperties_whenNull_thenAddStorePropertiesToLibraryPropertiesIsNull() {
    // Arrange
    AddStorePropertiesToLibrary addStorePropertiesToLibrary = new AddStorePropertiesToLibrary();

    // Act
    addStorePropertiesToLibrary.setProperties(null);

    // Assert that nothing has changed
    assertNull(addStorePropertiesToLibrary.getProperties());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AddStorePropertiesToLibrary}
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddStorePropertiesToLibrary.<init>()",
    "String AddStorePropertiesToLibrary.getId()",
    "Map AddStorePropertiesToLibrary.getOptions()",
    "String AddStorePropertiesToLibrary.getParentPropertiesId()",
    "StoreProperties AddStorePropertiesToLibrary.getStoreProperties()",
    "void AddStorePropertiesToLibrary.setId(String)",
    "void AddStorePropertiesToLibrary.setOptions(Map)",
    "void AddStorePropertiesToLibrary.setParentPropertiesId(String)",
    "void AddStorePropertiesToLibrary.setStoreProperties(StoreProperties)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AddStorePropertiesToLibrary actualAddStorePropertiesToLibrary =
        new AddStorePropertiesToLibrary();
    actualAddStorePropertiesToLibrary.setId("42");
    HashMap<String, String> options = new HashMap<>();
    actualAddStorePropertiesToLibrary.setOptions(options);
    actualAddStorePropertiesToLibrary.setParentPropertiesId("42");
    StoreProperties properties = new StoreProperties();
    actualAddStorePropertiesToLibrary.setStoreProperties(properties);
    String actualId = actualAddStorePropertiesToLibrary.getId();
    Map<String, String> actualOptions = actualAddStorePropertiesToLibrary.getOptions();
    String actualParentPropertiesId = actualAddStorePropertiesToLibrary.getParentPropertiesId();
    StoreProperties actualStoreProperties = actualAddStorePropertiesToLibrary.getStoreProperties();

    // Assert
    assertEquals("42", actualId);
    assertEquals("42", actualParentPropertiesId);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
    assertSame(properties, actualStoreProperties);
  }
}
