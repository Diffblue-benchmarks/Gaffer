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

package uk.gov.gchq.gaffer.operation.impl.export;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.export.GetExport;
import uk.gov.gchq.gaffer.operation.impl.export.localfile.ImportFromLocalFile;

class GetExportsDiffblueTest {
  /**
   * Method under test: {@link GetExports.Builder#exports(List)}
   */
  @Test
  void testBuilderExports() {
    // Arrange
    GetExports.Builder builder = new GetExports.Builder();

    // Act and Assert
    assertSame(builder, builder.exports(new ArrayList<>()));
  }

  /**
   * Method under test: {@link GetExports.Builder#exports(List)}
   */
  @Test
  void testBuilderExports2() {
    // Arrange
    GetExports.Builder builder = new GetExports.Builder();

    ArrayList<GetExport> resultExports = new ArrayList<>();
    resultExports.add(new ImportFromLocalFile());

    // Act and Assert
    assertSame(builder, builder.exports(resultExports));
  }

  /**
   * Method under test: {@link GetExports.Builder#exports(List)}
   */
  @Test
  void testBuilderExports3() {
    // Arrange
    GetExports.Builder builder = new GetExports.Builder();

    ArrayList<GetExport> resultExports = new ArrayList<>();
    resultExports.add(new ImportFromLocalFile());
    resultExports.add(new ImportFromLocalFile());

    // Act and Assert
    assertSame(builder, builder.exports(resultExports));
  }

  /**
   * Method under test: {@link GetExports.Builder#exports(List)}
   */
  @Test
  void testBuilderExports4() {
    // Arrange
    GetExports.Builder builder = new GetExports.Builder();

    ArrayList<GetExport> resultExports = new ArrayList<>();
    resultExports.add(mock(GetExport.class));

    // Act and Assert
    assertSame(builder, builder.exports(resultExports));
  }

  /**
   * Method under test: {@link GetExports.Builder#exports(GetExport[])}
   */
  @Test
  void testBuilderExports5() {
    // Arrange
    GetExports.Builder builder = new GetExports.Builder();

    // Act and Assert
    assertSame(builder, builder.exports(new ImportFromLocalFile()));
  }

  /**
   * Method under test: {@link GetExports.Builder#exports(GetExport[])}
   */
  @Test
  void testBuilderExports6() {
    // Arrange
    GetExports.Builder builder = new GetExports.Builder();

    // Act and Assert
    assertSame(builder, builder.exports(mock(GetExport.class)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetExports}
   *   <li>{@link GetExports#setOptions(Map)}
   *   <li>{@link GetExports#getGetExports()}
   *   <li>{@link GetExports#getOptions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GetExports actualGetExports = new GetExports();
    HashMap<String, String> options = new HashMap<>();
    actualGetExports.setOptions(options);
    List<GetExport> actualGetExports2 = actualGetExports.getGetExports();
    Map<String, String> actualOptions = actualGetExports.getOptions();

    // Assert that nothing has changed
    assertTrue(actualGetExports2.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }

  /**
   * Method under test: {@link GetExports#setGetExports(List)}
   */
  @Test
  void testSetGetExports() {
    // Arrange
    GetExports getExports = new GetExports();
    ArrayList<GetExport> getExports2 = new ArrayList<>();

    // Act
    getExports.setGetExports(getExports2);

    // Assert
    assertSame(getExports2, getExports.getGetExports());
  }

  /**
   * Method under test: {@link GetExports#setGetExports(List)}
   */
  @Test
  void testSetGetExports2() {
    // Arrange
    GetExports getExports = new GetExports();

    ArrayList<GetExport> getExports2 = new ArrayList<>();
    getExports2.add(new ImportFromLocalFile());

    // Act
    getExports.setGetExports(getExports2);

    // Assert
    assertSame(getExports2, getExports.getGetExports());
  }

  /**
   * Method under test: {@link GetExports#setGetExports(List)}
   */
  @Test
  void testSetGetExports3() {
    // Arrange
    GetExports getExports = new GetExports();

    ArrayList<GetExport> getExports2 = new ArrayList<>();
    getExports2.add(new ImportFromLocalFile());
    getExports2.add(new ImportFromLocalFile());

    // Act
    getExports.setGetExports(getExports2);

    // Assert
    assertSame(getExports2, getExports.getGetExports());
  }

  /**
   * Method under test: {@link GetExports#setGetExports(List)}
   */
  @Test
  void testSetGetExports4() {
    // Arrange
    GetExports getExports = new GetExports();

    ArrayList<GetExport> getExports2 = new ArrayList<>();
    getExports2.add(mock(GetExport.class));

    // Act
    getExports.setGetExports(getExports2);

    // Assert
    assertSame(getExports2, getExports.getGetExports());
  }
}
