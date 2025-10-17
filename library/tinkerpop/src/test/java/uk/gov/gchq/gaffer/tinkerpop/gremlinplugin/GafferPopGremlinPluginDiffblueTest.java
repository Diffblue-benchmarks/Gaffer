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

package uk.gov.gchq.gaffer.tinkerpop.gremlinplugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.apache.tinkerpop.gremlin.jsr223.Customizer;
import org.apache.tinkerpop.gremlin.jsr223.DefaultImportCustomizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GafferPopGremlinPluginDiffblueTest {
  /**
   * Test new {@link GafferPopGremlinPlugin} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link GafferPopGremlinPlugin}
   */
  @Test
  @DisplayName("Test new GafferPopGremlinPlugin (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferPopGremlinPlugin.<init>()"})
  void testNewGafferPopGremlinPlugin() {
    // Arrange and Act
    GafferPopGremlinPlugin actualGafferPopGremlinPlugin = new GafferPopGremlinPlugin();

    // Assert
    Optional<Customizer[]> customizers = actualGafferPopGremlinPlugin.getCustomizers();
    Customizer[] getResult = customizers.get();
    Customizer customizer = getResult[0];
    assertTrue(customizer instanceof DefaultImportCustomizer);
    assertEquals("gafferpop", actualGafferPopGremlinPlugin.getName());
    assertEquals(1, getResult.length);
    assertEquals(6, ((DefaultImportCustomizer) customizer).getClassPackages().size());
    assertEquals(8, ((DefaultImportCustomizer) customizer).getClassImports().size());
    assertTrue(customizers.isPresent());
    assertTrue(((DefaultImportCustomizer) customizer).getEnumImports().isEmpty());
    assertTrue(((DefaultImportCustomizer) customizer).getFieldImports().isEmpty());
    assertTrue(((DefaultImportCustomizer) customizer).getMethodImports().isEmpty());
    assertTrue(((DefaultImportCustomizer) customizer).getEnumClasses().isEmpty());
    assertTrue(((DefaultImportCustomizer) customizer).getFieldClasses().isEmpty());
    assertTrue(((DefaultImportCustomizer) customizer).getMethodClasses().isEmpty());
  }

  /**
   * Test {@link GafferPopGremlinPlugin#instance()}.
   *
   * <p>Method under test: {@link GafferPopGremlinPlugin#instance()}
   */
  @Test
  @DisplayName("Test instance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopGremlinPlugin GafferPopGremlinPlugin.instance()"})
  void testInstance() {
    // Arrange and Act
    GafferPopGremlinPlugin actualInstanceResult = GafferPopGremlinPlugin.instance();

    // Assert
    Optional<Customizer[]> customizers = actualInstanceResult.getCustomizers();
    Customizer[] getResult = customizers.get();
    Customizer customizer = getResult[0];
    assertTrue(customizer instanceof DefaultImportCustomizer);
    assertEquals("gafferpop", actualInstanceResult.getName());
    assertEquals(1, getResult.length);
    assertEquals(6, ((DefaultImportCustomizer) customizer).getClassPackages().size());
    assertEquals(8, ((DefaultImportCustomizer) customizer).getClassImports().size());
    assertTrue(customizers.isPresent());
    assertTrue(((DefaultImportCustomizer) customizer).getEnumImports().isEmpty());
    assertTrue(((DefaultImportCustomizer) customizer).getFieldImports().isEmpty());
    assertTrue(((DefaultImportCustomizer) customizer).getMethodImports().isEmpty());
    assertTrue(((DefaultImportCustomizer) customizer).getEnumClasses().isEmpty());
    assertTrue(((DefaultImportCustomizer) customizer).getFieldClasses().isEmpty());
    assertTrue(((DefaultImportCustomizer) customizer).getMethodClasses().isEmpty());
  }

  /**
   * Test {@link GafferPopGremlinPlugin#requireRestart()}.
   *
   * <p>Method under test: {@link GafferPopGremlinPlugin#requireRestart()}
   */
  @Test
  @DisplayName("Test requireRestart()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GafferPopGremlinPlugin.requireRestart()"})
  void testRequireRestart() {
    // Arrange, Act and Assert
    assertTrue(GafferPopGremlinPlugin.instance().requireRestart());
  }
}
