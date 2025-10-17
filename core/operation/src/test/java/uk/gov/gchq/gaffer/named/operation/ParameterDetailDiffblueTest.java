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

package uk.gov.gchq.gaffer.named.operation;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.ParameterDetail.Builder;
import uk.gov.gchq.gaffer.operation.impl.add.AddElementsFromKafka;

class ParameterDetailDiffblueTest {
  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Builder}
   *   <li>{@link Builder#defaultValue(Object)}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#options(List)}
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
    "ParameterDetail Builder.build()",
    "Builder Builder.defaultValue(Object)",
    "Builder Builder.description(String)",
    "Builder Builder.options(List)",
    "Builder Builder.required(boolean)",
    "Builder Builder.valueClass(Class)"
  })
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualDescriptionResult =
        new Builder()
            .defaultValue("Default Value")
            .description("The characteristics of someone or something");
    Builder actualRequiredResult =
        actualDescriptionResult.options(new ArrayList<>()).required(true);
    Builder actualValueClassResult =
        actualRequiredResult.valueClass(AddElementsFromKafka.DEFAULT_CONSUME_AS);

    // Assert
    assertSame(actualRequiredResult, actualValueClassResult);
  }

  /**
   * Test {@link ParameterDetail#ParameterDetail(String, Class, boolean, Object, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ParameterDetail#ParameterDetail(String, Class, boolean, Object,
   * List)}
   */
  @Test
  @DisplayName(
      "Test new ParameterDetail(String, Class, boolean, Object, List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ParameterDetail.<init>(String, Class, boolean, Object, List)"})
  void testNewParameterDetail_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<Object> options = new ArrayList<>();
    options.add("42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new ParameterDetail(
                "The characteristics of someone or something",
                AddElementsFromKafka.DEFAULT_CONSUME_AS,
                true,
                "Default Value",
                options));
  }

  /**
   * Test {@link ParameterDetail#ParameterDetail(String, Class, boolean, Object, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ParameterDetail#ParameterDetail(String, Class, boolean, Object,
   * List)}
   */
  @Test
  @DisplayName(
      "Test new ParameterDetail(String, Class, boolean, Object, List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ParameterDetail.<init>(String, Class, boolean, Object, List)"})
  void testNewParameterDetail_given42_whenArrayListAdd422() {
    // Arrange
    ArrayList<Object> options = new ArrayList<>();
    options.add("42");
    options.add("42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new ParameterDetail(
                "The characteristics of someone or something",
                AddElementsFromKafka.DEFAULT_CONSUME_AS,
                true,
                "Default Value",
                options));
  }

  /**
   * Test {@link ParameterDetail#ParameterDetail(String, Class, boolean, Object, List)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ParameterDetail#ParameterDetail(String, Class, boolean, Object,
   * List)}
   */
  @Test
  @DisplayName(
      "Test new ParameterDetail(String, Class, boolean, Object, List); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ParameterDetail.<init>(String, Class, boolean, Object, List)"})
  void testNewParameterDetail_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange
    Class<ParameterDetail> clazz = ParameterDetail.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new ParameterDetail(
                "The characteristics of someone or something",
                clazz,
                false,
                42,
                new ArrayList<>()));
  }

  /**
   * Test {@link ParameterDetail#ParameterDetail(String, Class, boolean, Object, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ParameterDetail#ParameterDetail(String, Class, boolean, Object,
   * List)}
   */
  @Test
  @DisplayName(
      "Test new ParameterDetail(String, Class, boolean, Object, List); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ParameterDetail.<init>(String, Class, boolean, Object, List)"})
  void testNewParameterDetail_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ParameterDetail(null, null, false, null, new ArrayList<>()));
  }

  /**
   * Test {@link ParameterDetail#ParameterDetail(String, Class, boolean, Object, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ParameterDetail#ParameterDetail(String, Class, boolean, Object,
   * List)}
   */
  @Test
  @DisplayName(
      "Test new ParameterDetail(String, Class, boolean, Object, List); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ParameterDetail.<init>(String, Class, boolean, Object, List)"})
  void testNewParameterDetail_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new ParameterDetail(
                "The characteristics of someone or something",
                null,
                false,
                null,
                new ArrayList<>()));
  }

  /**
   * Test {@link ParameterDetail#ParameterDetail(String, Class, boolean, Object, List)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ParameterDetail#ParameterDetail(String, Class, boolean, Object,
   * List)}
   */
  @Test
  @DisplayName(
      "Test new ParameterDetail(String, Class, boolean, Object, List); when 'true'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ParameterDetail.<init>(String, Class, boolean, Object, List)"})
  void testNewParameterDetail_whenTrue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new ParameterDetail(
                "The characteristics of someone or something",
                AddElementsFromKafka.DEFAULT_CONSUME_AS,
                true,
                "Default Value",
                new ArrayList<>()));
  }
}
