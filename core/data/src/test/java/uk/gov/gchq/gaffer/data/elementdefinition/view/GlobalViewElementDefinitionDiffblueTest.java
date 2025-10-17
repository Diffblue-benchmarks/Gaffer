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

package uk.gov.gchq.gaffer.data.elementdefinition.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.view.GlobalViewElementDefinition.BaseBuilder;
import uk.gov.gchq.gaffer.data.elementdefinition.view.GlobalViewElementDefinition.Builder;

class GlobalViewElementDefinitionDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#groups(String[])}.
   *
   * <p>Method under test: {@link BaseBuilder#groups(String[])}
   */
  @Test
  @DisplayName("Test BaseBuilder groups(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.groups(String[])"})
  void testBaseBuilderGroups() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualGroupsResult = builder.groups("Groups");

    // Assert
    assertSame(builder, actualGroupsResult);
  }

  /**
   * Test Builder {@link Builder#Builder(GlobalViewElementDefinition)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#Builder(GlobalViewElementDefinition)}
   */
  @Test
  @DisplayName("Test Builder new Builder(GlobalViewElementDefinition); given LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>(GlobalViewElementDefinition)"})
  void testBuilderNewBuilder_givenLinkedHashSet() {
    // Arrange
    GlobalViewElementDefinition viewElementDef = new GlobalViewElementDefinition();
    viewElementDef.setGroupBy(new LinkedHashSet<>());

    // Act and Assert
    assertEquals(viewElementDef, new Builder(viewElementDef).getElementDef());
  }

  /**
   * Test Builder {@link Builder#Builder(GlobalViewElementDefinition)}.
   *
   * <ul>
   *   <li>When {@link GlobalViewElementDefinition} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#Builder(GlobalViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder new Builder(GlobalViewElementDefinition); when GlobalViewElementDefinition (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>(GlobalViewElementDefinition)"})
  void testBuilderNewBuilder_whenGlobalViewElementDefinition() {
    // Arrange
    GlobalViewElementDefinition viewElementDef = new GlobalViewElementDefinition();

    // Act and Assert
    assertEquals(viewElementDef, new Builder(viewElementDef).getElementDef());
  }

  /**
   * Test Builder {@link Builder#self()}.
   *
   * <p>Method under test: {@link Builder#self()}
   */
  @Test
  @DisplayName("Test Builder self()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.self()"})
  void testBuilderSelf() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSelfResult = builder.self();

    // Assert
    assertSame(builder, actualSelfResult);
  }

  /**
   * Test {@link GlobalViewElementDefinition#equals(Object)}, and {@link
   * GlobalViewElementDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GlobalViewElementDefinition#equals(Object)}
   *   <li>{@link GlobalViewElementDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GlobalViewElementDefinition.equals(Object)",
    "int GlobalViewElementDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GlobalViewElementDefinition globalViewElementDefinition = new GlobalViewElementDefinition();
    GlobalViewElementDefinition globalViewElementDefinition2 = new GlobalViewElementDefinition();

    // Act and Assert
    assertEquals(globalViewElementDefinition, globalViewElementDefinition2);
    assertEquals(globalViewElementDefinition.hashCode(), globalViewElementDefinition2.hashCode());
  }

  /**
   * Test {@link GlobalViewElementDefinition#equals(Object)}, and {@link
   * GlobalViewElementDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GlobalViewElementDefinition#equals(Object)}
   *   <li>{@link GlobalViewElementDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GlobalViewElementDefinition.equals(Object)",
    "int GlobalViewElementDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GlobalViewElementDefinition globalViewElementDefinition = new GlobalViewElementDefinition();

    // Act and Assert
    assertEquals(globalViewElementDefinition, globalViewElementDefinition);
    int expectedHashCodeResult = globalViewElementDefinition.hashCode();
    assertEquals(expectedHashCodeResult, globalViewElementDefinition.hashCode());
  }

  /**
   * Test {@link GlobalViewElementDefinition#equals(GlobalViewElementDefinition)} with {@code
   * entity}.
   *
   * <ul>
   *   <li>Given {@link GlobalViewElementDefinition} (default constructor) GroupBy is {@link
   *       LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link GlobalViewElementDefinition#equals(GlobalViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test equals(GlobalViewElementDefinition) with 'entity'; given GlobalViewElementDefinition (default constructor) GroupBy is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GlobalViewElementDefinition.equals(GlobalViewElementDefinition)"})
  void testEqualsWithEntity_givenGlobalViewElementDefinitionGroupByIsLinkedHashSet() {
    // Arrange
    GlobalViewElementDefinition globalViewElementDefinition = new GlobalViewElementDefinition();
    globalViewElementDefinition.setGroupBy(new LinkedHashSet<>());

    // Act and Assert
    assertFalse(globalViewElementDefinition.equals(new GlobalViewElementDefinition()));
  }

  /**
   * Test {@link GlobalViewElementDefinition#equals(GlobalViewElementDefinition)} with {@code
   * entity}.
   *
   * <ul>
   *   <li>Given {@link GlobalViewElementDefinition} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GlobalViewElementDefinition#equals(GlobalViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test equals(GlobalViewElementDefinition) with 'entity'; given GlobalViewElementDefinition (default constructor); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GlobalViewElementDefinition.equals(GlobalViewElementDefinition)"})
  void testEqualsWithEntity_givenGlobalViewElementDefinition_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new GlobalViewElementDefinition().equals((GlobalViewElementDefinition) null));
  }

  /**
   * Test {@link GlobalViewElementDefinition#equals(GlobalViewElementDefinition)} with {@code
   * entity}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link GlobalViewElementDefinition#equals(GlobalViewElementDefinition)}
   */
  @Test
  @DisplayName("Test equals(GlobalViewElementDefinition) with 'entity'; given LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GlobalViewElementDefinition.equals(GlobalViewElementDefinition)"})
  void testEqualsWithEntity_givenLinkedHashSet() {
    // Arrange
    GlobalViewElementDefinition globalViewElementDefinition = new GlobalViewElementDefinition();

    GlobalViewElementDefinition entity = new GlobalViewElementDefinition();
    entity.setGroupBy(new LinkedHashSet<>());

    // Act and Assert
    assertFalse(globalViewElementDefinition.equals(entity));
  }

  /**
   * Test {@link GlobalViewElementDefinition#equals(GlobalViewElementDefinition)} with {@code
   * entity}.
   *
   * <ul>
   *   <li>When {@link GlobalViewElementDefinition} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GlobalViewElementDefinition#equals(GlobalViewElementDefinition)}
   */
  @Test
  @DisplayName(
      "Test equals(GlobalViewElementDefinition) with 'entity'; when GlobalViewElementDefinition (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GlobalViewElementDefinition.equals(GlobalViewElementDefinition)"})
  void testEqualsWithEntity_whenGlobalViewElementDefinition_thenReturnTrue() {
    // Arrange
    GlobalViewElementDefinition globalViewElementDefinition = new GlobalViewElementDefinition();

    // Act and Assert
    assertTrue(globalViewElementDefinition.equals(new GlobalViewElementDefinition()));
  }

  /**
   * Test {@link GlobalViewElementDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GlobalViewElementDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GlobalViewElementDefinition.equals(Object)",
    "int GlobalViewElementDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GlobalViewElementDefinition(), 1);
  }

  /**
   * Test {@link GlobalViewElementDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GlobalViewElementDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GlobalViewElementDefinition.equals(Object)",
    "int GlobalViewElementDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    GlobalViewElementDefinition globalViewElementDefinition = new GlobalViewElementDefinition();
    globalViewElementDefinition.setGroupBy(new LinkedHashSet<>());

    // Act and Assert
    assertNotEquals(globalViewElementDefinition, new GlobalViewElementDefinition());
  }

  /**
   * Test {@link GlobalViewElementDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GlobalViewElementDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GlobalViewElementDefinition.equals(Object)",
    "int GlobalViewElementDefinition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GlobalViewElementDefinition(), null);
  }

  /**
   * Test {@link GlobalViewElementDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GlobalViewElementDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GlobalViewElementDefinition.equals(Object)",
    "int GlobalViewElementDefinition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new GlobalViewElementDefinition(), "Different type to GlobalViewElementDefinition");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GlobalViewElementDefinition}
   *   <li>{@link GlobalViewElementDefinition#getGroups()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GlobalViewElementDefinition.<init>()",
    "java.util.Set GlobalViewElementDefinition.getGroups()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GlobalViewElementDefinition actualGlobalViewElementDefinition =
        new GlobalViewElementDefinition();

    // Assert
    assertNull(actualGlobalViewElementDefinition.getGroups());
    assertNull(actualGlobalViewElementDefinition.getExcludeProperties());
    assertNull(actualGlobalViewElementDefinition.getGroupBy());
    assertNull(actualGlobalViewElementDefinition.getProperties());
    assertNull(actualGlobalViewElementDefinition.getAggregator());
    assertNull(actualGlobalViewElementDefinition.getPostAggregationFilter());
    assertNull(actualGlobalViewElementDefinition.getPostTransformFilter());
    assertNull(actualGlobalViewElementDefinition.getPreAggregationFilter());
    assertNull(actualGlobalViewElementDefinition.getTransformer());
    assertTrue(actualGlobalViewElementDefinition.getTransientPropertyMap().isEmpty());
  }
}
