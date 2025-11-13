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

package uk.gov.gchq.gaffer.sketches.serialisation.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SketchesJsonModulesDiffblueTest {
  /**
   * Test {@link SketchesJsonModules#getModules()}.
   * <p>
   * Method under test: {@link SketchesJsonModules#getModules()}
   */
  @Test
  @DisplayName("Test getModules()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SketchesJsonModules.getModules()"})
  void testGetModules() {
    // Arrange and Act
    List<Module> actualModules = (new SketchesJsonModules()).getModules();

    // Assert
    assertEquals(2, actualModules.size());
    Module getResult = actualModules.get(0);
    assertTrue(getResult instanceof SimpleModule);
    Module getResult2 = actualModules.get(1);
    assertTrue(getResult2 instanceof SimpleModule);
    Iterable<? extends Module> dependencies = getResult.getDependencies();
    assertTrue(dependencies instanceof List);
    assertEquals("HllSketchJsonSerialiser", getResult2.getModuleName());
    assertEquals("HllSketchJsonSerialiser", getResult2.getTypeId());
    assertEquals("HyperLogLogPlusJsonSerialiser", getResult.getModuleName());
    assertEquals("HyperLogLogPlusJsonSerialiser", getResult.getTypeId());
    assertTrue(((List<? extends Module>) dependencies).isEmpty());
    assertSame(dependencies, getResult2.getDependencies());
  }

  /**
   * Test new {@link SketchesJsonModules} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link SketchesJsonModules}
   */
  @Test
  @DisplayName("Test new SketchesJsonModules (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SketchesJsonModules.<init>()"})
  void testNewSketchesJsonModules() {
    // Arrange, Act and Assert
    List<Module> modules = (new SketchesJsonModules()).getModules();
    assertEquals(2, modules.size());
    Module getResult = modules.get(0);
    assertTrue(getResult instanceof SimpleModule);
    Module getResult2 = modules.get(1);
    assertTrue(getResult2 instanceof SimpleModule);
    Iterable<? extends Module> dependencies = getResult.getDependencies();
    assertTrue(dependencies instanceof List);
    Version versionResult = getResult.version();
    assertEquals("", versionResult.getArtifactId());
    assertEquals("", versionResult.getGroupId());
    assertEquals("//1.0.0", versionResult.toFullString());
    assertEquals("HllSketchJsonSerialiser", getResult2.getModuleName());
    assertEquals("HllSketchJsonSerialiser", getResult2.getTypeId());
    assertEquals("HyperLogLogPlusJsonSerialiser", getResult.getModuleName());
    assertEquals("HyperLogLogPlusJsonSerialiser", getResult.getTypeId());
    assertEquals(0, versionResult.getMinorVersion());
    assertEquals(0, versionResult.getPatchLevel());
    assertEquals(1, versionResult.getMajorVersion());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertTrue(((List<? extends Module>) dependencies).isEmpty());
    assertEquals(versionResult, getResult2.version());
    assertSame(dependencies, getResult2.getDependencies());
  }
}
