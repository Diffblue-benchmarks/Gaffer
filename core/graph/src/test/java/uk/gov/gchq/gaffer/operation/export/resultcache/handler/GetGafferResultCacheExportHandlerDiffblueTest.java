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

package uk.gov.gchq.gaffer.operation.export.resultcache.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.export.resultcache.GafferResultCacheExporter;

class GetGafferResultCacheExportHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetGafferResultCacheExportHandler}
   *   <li>{@link GetGafferResultCacheExportHandler#setGraphId(String)}
   *   <li>{@link GetGafferResultCacheExportHandler#setStorePropertiesPath(String)}
   *   <li>{@link GetGafferResultCacheExportHandler#setTimeToLive(Long)}
   *   <li>{@link GetGafferResultCacheExportHandler#setVisibility(String)}
   *   <li>{@link GetGafferResultCacheExportHandler#getExporterClass()}
   *   <li>{@link GetGafferResultCacheExportHandler#getGraphId()}
   *   <li>{@link GetGafferResultCacheExportHandler#getStorePropertiesPath()}
   *   <li>{@link GetGafferResultCacheExportHandler#getTimeToLive()}
   *   <li>{@link GetGafferResultCacheExportHandler#getVisibility()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetGafferResultCacheExportHandler.<init>()",
      "Class GetGafferResultCacheExportHandler.getExporterClass()",
      "String GetGafferResultCacheExportHandler.getGraphId()",
      "String GetGafferResultCacheExportHandler.getStorePropertiesPath()",
      "Long GetGafferResultCacheExportHandler.getTimeToLive()",
      "String GetGafferResultCacheExportHandler.getVisibility()",
      "void GetGafferResultCacheExportHandler.setGraphId(String)",
      "void GetGafferResultCacheExportHandler.setStorePropertiesPath(String)",
      "void GetGafferResultCacheExportHandler.setTimeToLive(Long)",
      "void GetGafferResultCacheExportHandler.setVisibility(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    GetGafferResultCacheExportHandler actualGetGafferResultCacheExportHandler = new GetGafferResultCacheExportHandler();
    actualGetGafferResultCacheExportHandler.setGraphId("42");
    actualGetGafferResultCacheExportHandler.setStorePropertiesPath("Cache Store Properties Path");
    actualGetGafferResultCacheExportHandler.setTimeToLive(10L);
    actualGetGafferResultCacheExportHandler.setVisibility("Visibility");
    Class<GafferResultCacheExporter> actualExporterClass = actualGetGafferResultCacheExportHandler.getExporterClass();
    String actualGraphId = actualGetGafferResultCacheExportHandler.getGraphId();
    String actualStorePropertiesPath = actualGetGafferResultCacheExportHandler.getStorePropertiesPath();
    Long actualTimeToLive = actualGetGafferResultCacheExportHandler.getTimeToLive();

    // Assert
    assertEquals("42", actualGraphId);
    assertEquals("Cache Store Properties Path", actualStorePropertiesPath);
    assertEquals("Visibility", actualGetGafferResultCacheExportHandler.getVisibility());
    assertEquals(10L, actualTimeToLive.longValue());
    Class<GafferResultCacheExporter> expectedExporterClass = GafferResultCacheExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
