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
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.export.resultcache.GafferResultCacheExporter;

class ExportToGafferResultCacheHandlerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ExportToGafferResultCacheHandler}
   *   <li>{@link ExportToGafferResultCacheHandler#setGraphId(String)}
   *   <li>{@link ExportToGafferResultCacheHandler#setStorePropertiesPath(String)}
   *   <li>{@link ExportToGafferResultCacheHandler#setTimeToLive(Long)}
   *   <li>{@link ExportToGafferResultCacheHandler#setVisibility(String)}
   *   <li>{@link ExportToGafferResultCacheHandler#getExporterClass()}
   *   <li>{@link ExportToGafferResultCacheHandler#getGraphId()}
   *   <li>{@link ExportToGafferResultCacheHandler#getStorePropertiesPath()}
   *   <li>{@link ExportToGafferResultCacheHandler#getTimeToLive()}
   *   <li>{@link ExportToGafferResultCacheHandler#getVisibility()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ExportToGafferResultCacheHandler actualExportToGafferResultCacheHandler = new ExportToGafferResultCacheHandler();
    actualExportToGafferResultCacheHandler.setGraphId("42");
    actualExportToGafferResultCacheHandler.setStorePropertiesPath("Cache Store Properties Path");
    actualExportToGafferResultCacheHandler.setTimeToLive(10L);
    actualExportToGafferResultCacheHandler.setVisibility("Visibility");
    Class<GafferResultCacheExporter> actualExporterClass = actualExportToGafferResultCacheHandler.getExporterClass();
    String actualGraphId = actualExportToGafferResultCacheHandler.getGraphId();
    String actualStorePropertiesPath = actualExportToGafferResultCacheHandler.getStorePropertiesPath();
    Long actualTimeToLive = actualExportToGafferResultCacheHandler.getTimeToLive();

    // Assert that nothing has changed
    assertEquals("42", actualGraphId);
    assertEquals("Cache Store Properties Path", actualStorePropertiesPath);
    assertEquals("Visibility", actualExportToGafferResultCacheHandler.getVisibility());
    assertEquals(10L, actualTimeToLive.longValue());
    Class<GafferResultCacheExporter> expectedExporterClass = GafferResultCacheExporter.class;
    assertEquals(expectedExporterClass, actualExporterClass);
  }
}
