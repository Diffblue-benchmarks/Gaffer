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

package uk.gov.gchq.gaffer.spark;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.spark.sql.SparkSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.user.User;

class SparkContextUtilDiffblueTest {
  /**
   * Test {@link SparkContextUtil#addSparkSession(Context, SparkSession)} with {@code context},
   * {@code sparkSession}.
   *
   * <ul>
   *   <li>Then calls {@link Context#setConfig(String, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SparkContextUtil#addSparkSession(Context, SparkSession)}
   */
  @Test
  @DisplayName(
      "Test addSparkSession(Context, SparkSession) with 'context', 'sparkSession'; then calls setConfig(String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SparkContextUtil.addSparkSession(Context, SparkSession)"})
  void testAddSparkSessionWithContextSparkSession_thenCallsSetConfig() {
    // Arrange
    Context context = mock(Context.class);
    doNothing().when(context).setConfig(Mockito.<String>any(), Mockito.<Object>any());

    // Act
    SparkContextUtil.addSparkSession(context, (SparkSession) null);

    // Assert
    verify(context).setConfig(eq("config.spark.context"), isNull());
  }

  /**
   * Test {@link SparkContextUtil#addSparkSession(Context, StoreProperties)} with {@code context},
   * {@code storeProperties}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkContextUtil#addSparkSession(Context, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test addSparkSession(Context, StoreProperties) with 'context', 'storeProperties'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SparkContextUtil.addSparkSession(Context, StoreProperties)"})
  void testAddSparkSessionWithContextStoreProperties_thenThrowIllegalArgumentException() {
    // Arrange
    Context context = new Context();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.get(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(Boolean.TRUE.toString());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> SparkContextUtil.addSparkSession(context, storeProperties));
    verify(storeProperties, atLeast(1)).get(Mockito.<String>any(), Mockito.<String>any());
  }

  /**
   * Test {@link SparkContextUtil#createContext(User, SparkSession)} with {@code user}, {@code
   * sparkSession}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   *   <li>Then return OriginalOpChain is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SparkContextUtil#createContext(User, SparkSession)}
   */
  @Test
  @DisplayName(
      "Test createContext(User, SparkSession) with 'user', 'sparkSession'; when User(); then return OriginalOpChain is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Context SparkContextUtil.createContext(User, SparkSession)"})
  void testCreateContextWithUserSparkSession_whenUser_thenReturnOriginalOpChainIsNull() {
    // Arrange
    User user = new User();

    // Act
    Context actualCreateContextResult = SparkContextUtil.createContext(user, (SparkSession) null);

    // Assert
    assertNull(actualCreateContextResult.getOriginalOpChain());
    assertTrue(actualCreateContextResult.getExporters().isEmpty());
    assertTrue(actualCreateContextResult.getVariables().isEmpty());
    assertSame(user, actualCreateContextResult.getUser());
  }

  /**
   * Test {@link SparkContextUtil#createContext(User, StoreProperties)} with {@code user}, {@code
   * storeProperties}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkContextUtil#createContext(User, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test createContext(User, StoreProperties) with 'user', 'storeProperties'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Context SparkContextUtil.createContext(User, StoreProperties)"})
  void testCreateContextWithUserStoreProperties_thenThrowIllegalArgumentException() {
    // Arrange
    User user = new User();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.get(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(Boolean.TRUE.toString());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> SparkContextUtil.createContext(user, storeProperties));
    verify(storeProperties, atLeast(1)).get(Mockito.<String>any(), Mockito.<String>any());
  }

  /**
   * Test {@link SparkContextUtil#getSparkSession(Context, StoreProperties)}.
   *
   * <ul>
   *   <li>Given {@link SparkSession}.
   *   <li>When {@link Context} {@link Context#getConfig(String)} return {@link SparkSession}.
   * </ul>
   *
   * <p>Method under test: {@link SparkContextUtil#getSparkSession(Context, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test getSparkSession(Context, StoreProperties); given SparkSession; when Context getConfig(String) return SparkSession")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SparkSession SparkContextUtil.getSparkSession(Context, StoreProperties)"})
  void testGetSparkSession_givenSparkSession_whenContextGetConfigReturnSparkSession() {
    // Arrange
    Context context = mock(Context.class);
    when(context.getConfig(Mockito.<String>any())).thenReturn(mock(SparkSession.class));

    // Act
    SparkContextUtil.getSparkSession(context, mock(StoreProperties.class));

    // Assert
    verify(context).getConfig("config.spark.context");
  }

  /**
   * Test {@link SparkContextUtil#getSparkSession(Context, StoreProperties)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkContextUtil#getSparkSession(Context, StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test getSparkSession(Context, StoreProperties); given TRUE toString; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SparkSession SparkContextUtil.getSparkSession(Context, StoreProperties)"})
  void testGetSparkSession_givenTrueToString_thenThrowIllegalArgumentException() {
    // Arrange
    Context context = mock(Context.class);
    when(context.getConfig(Mockito.<String>any())).thenReturn(null);

    StoreProperties properties = mock(StoreProperties.class);
    when(properties.get(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(Boolean.TRUE.toString());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> SparkContextUtil.getSparkSession(context, properties));
    verify(context).getConfig("config.spark.context");
    verify(properties, atLeast(1)).get(Mockito.<String>any(), Mockito.<String>any());
  }

  /**
   * Test {@link SparkContextUtil#createSparkSession(StoreProperties)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkContextUtil#createSparkSession(StoreProperties)}
   */
  @Test
  @DisplayName(
      "Test createSparkSession(StoreProperties); given TRUE toString; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SparkSession SparkContextUtil.createSparkSession(StoreProperties)"})
  void testCreateSparkSession_givenTrueToString_thenThrowIllegalArgumentException() {
    // Arrange
    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.get(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(Boolean.TRUE.toString());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> SparkContextUtil.createSparkSession(storeProperties));
    verify(storeProperties, atLeast(1)).get(Mockito.<String>any(), Mockito.<String>any());
  }
}
