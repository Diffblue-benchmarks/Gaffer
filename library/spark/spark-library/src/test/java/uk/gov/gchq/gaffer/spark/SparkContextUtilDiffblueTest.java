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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.spark.sql.SparkSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.StoreProperties;

class SparkContextUtilDiffblueTest {
  /**
   * Test {@link SparkContextUtil#getSparkSession(Context, StoreProperties)}.
   * <ul>
   *   <li>Given {@link SparkSession}.</li>
   *   <li>When {@link Context} {@link Context#getConfig(String)} return {@link SparkSession}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkContextUtil#getSparkSession(Context, StoreProperties)}
   */
  @Test
  @DisplayName("Test getSparkSession(Context, StoreProperties); given SparkSession; when Context getConfig(String) return SparkSession")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkSession SparkContextUtil.getSparkSession(Context, StoreProperties)"})
  void testGetSparkSession_givenSparkSession_whenContextGetConfigReturnSparkSession() {
    // Arrange
    Context context = mock(Context.class);
    when(context.getConfig(Mockito.<String>any())).thenReturn(mock(SparkSession.class));

    // Act
    SparkContextUtil.getSparkSession(context, new StoreProperties());

    // Assert
    verify(context).getConfig(eq("config.spark.context"));
  }

  /**
   * Test {@link SparkContextUtil#getSparkSession(Context, StoreProperties)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkContextUtil#getSparkSession(Context, StoreProperties)}
   */
  @Test
  @DisplayName("Test getSparkSession(Context, StoreProperties); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SparkSession SparkContextUtil.getSparkSession(Context, StoreProperties)"})
  void testGetSparkSession_thenThrowIllegalArgumentException() {
    // Arrange
    Context context = mock(Context.class);
    when(context.getConfig(Mockito.<String>any())).thenReturn(null);
    StoreProperties properties = mock(StoreProperties.class);
    when(properties.get(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException(SparkContextUtil.SPARK_CONTEXT_CONFIG_KEY));
    doNothing().when(properties).addOperationDeclarationPaths((String[]) Mockito.any());
    properties.addOperationDeclarationPaths(SparkContextUtil.SPARK_CONTEXT_CONFIG_KEY);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SparkContextUtil.getSparkSession(context, properties));
    verify(context).getConfig(eq("config.spark.context"));
    verify(properties).addOperationDeclarationPaths((String[]) Mockito.any());
    verify(properties).get(eq("spark.appname"), eq("Gaffer"));
  }
}
