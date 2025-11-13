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

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewParameterDetail.Builder;

class ViewParameterDetailDiffblueTest {
  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Builder}
   *   <li>{@link Builder#defaultValue(Object)}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#required(boolean)}
   *   <li>{@link Builder#valueClass(Class)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Builder.<init>()",
    "ViewParameterDetail Builder.build()",
    "Builder Builder.defaultValue(Object)",
    "Builder Builder.description(String)",
    "Builder Builder.required(boolean)",
    "Builder Builder.valueClass(Class)"
  })
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualRequiredResult =
        new Builder()
            .defaultValue("Default Value")
            .description("The characteristics of someone or something")
            .required(true);
    Class<Object> clazz = Object.class;
    Builder actualValueClassResult = actualRequiredResult.valueClass(clazz);

    // Assert
    assertSame(actualRequiredResult, actualValueClassResult);
  }

  /**
   * Test {@link ViewParameterDetail#ViewParameterDetail(String, Class, boolean, Object)}.
   *
   * <p>Method under test: {@link ViewParameterDetail#ViewParameterDetail(String, Class, boolean,
   * Object)}
   */
  @Test
  @DisplayName("Test new ViewParameterDetail(String, Class, boolean, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewParameterDetail.<init>(String, Class, boolean, Object)"})
  void testNewViewParameterDetail() {
    // Arrange
    Class<ViewParameterDetail> clazz = ViewParameterDetail.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new ViewParameterDetail(
                "The characteristics of someone or something", clazz, false, "Default Value"));
  }

  /**
   * Test {@link ViewParameterDetail#ViewParameterDetail(String, Class, boolean, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ViewParameterDetail#ViewParameterDetail(String, Class, boolean,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new ViewParameterDetail(String, Class, boolean, Object); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewParameterDetail.<init>(String, Class, boolean, Object)"})
  void testNewViewParameterDetail_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new ViewParameterDetail(
                "The characteristics of someone or something", null, false, "Default Value"));
  }

  /**
   * Test {@link ViewParameterDetail#ViewParameterDetail(String, Class, boolean, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ViewParameterDetail#ViewParameterDetail(String, Class, boolean,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new ViewParameterDetail(String, Class, boolean, Object); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewParameterDetail.<init>(String, Class, boolean, Object)"})
  void testNewViewParameterDetail_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ViewParameterDetail(null, clazz, false, "Default Value"));
  }

  /**
   * Test {@link ViewParameterDetail#ViewParameterDetail(String, Class, boolean, Object)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ViewParameterDetail#ViewParameterDetail(String, Class, boolean,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new ViewParameterDetail(String, Class, boolean, Object); when 'true'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ViewParameterDetail.<init>(String, Class, boolean, Object)"})
  void testNewViewParameterDetail_whenTrue_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new ViewParameterDetail(
                "The characteristics of someone or something", clazz, true, "Default Value"));
  }
}
