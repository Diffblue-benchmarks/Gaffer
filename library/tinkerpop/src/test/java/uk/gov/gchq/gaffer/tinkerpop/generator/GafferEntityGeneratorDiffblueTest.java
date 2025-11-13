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

package uk.gov.gchq.gaffer.tinkerpop.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopVertex;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

public class GafferEntityGeneratorDiffblueTest {
  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return Vertex size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  public void test_applyWithGafferPopVertex_given42_thenReturnVertexSizeIsOne() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    // Act and Assert
    Object vertex = gafferEntityGenerator._apply(new GafferPopVertex("Label", objectList, null)).getVertex();
    assertTrue(vertex instanceof List);
    assertEquals(1, ((List<String>) vertex).size());
    assertEquals("42", ((List<String>) vertex).get(0));
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return Vertex size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  public void test_applyWithGafferPopVertex_given42_thenReturnVertexSizeIsTwo() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");

    // Act and Assert
    Object vertex = gafferEntityGenerator._apply(new GafferPopVertex("Label", objectList, null)).getVertex();
    assertTrue(vertex instanceof List);
    assertEquals(2, ((List<String>) vertex).size());
    assertEquals("42", ((List<String>) vertex).get(0));
    assertEquals("42", ((List<String>) vertex).get(1));
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   * <ul>
   *   <li>Then return Group is {@code Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  public void test_applyWithGafferPopVertex_thenReturnGroupIsLabel() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();

    // Act
    Entity actual_applyResult = gafferEntityGenerator._apply(new GafferPopVertex("Label", new ArrayList<>(), null));

    // Assert
    Object vertex = actual_applyResult.getVertex();
    assertTrue(vertex instanceof List);
    assertEquals("Label", actual_applyResult.getGroup());
    assertTrue(((List<Object>) vertex).isEmpty());
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   * <ul>
   *   <li>Then return Group is {@code xx[type=xx, subType=xx, value=xx]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  public void test_applyWithGafferPopVertex_thenReturnGroupIsXxTypeXxSubTypeXxValueXx() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();

    // Act
    Entity actual_applyResult = gafferEntityGenerator
        ._apply(new GafferPopVertex("xx[type=xx,  subType=xx,  value=xx]", "Id", null));

    // Assert
    assertEquals("Id", actual_applyResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertEquals("xx[type=xx,  subType=xx,  value=xx]", actual_applyResult.getGroup());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   * <ul>
   *   <li>Then return Vertex intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  public void test_applyWithGafferPopVertex_thenReturnVertexIntValueIsOne() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();

    // Act
    Entity actual_applyResult = gafferEntityGenerator._apply(new GafferPopVertex("Label", 1, null));

    // Assert
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertEquals(1, ((Integer) actual_applyResult.getVertex()).intValue());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   * <ul>
   *   <li>Then Vertex return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  public void test_applyWithGafferPopVertex_thenVertexReturnSet() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();

    // Act
    Entity actual_applyResult = gafferEntityGenerator._apply(new GafferPopVertex("Label", new HashSet<>(), null));

    // Assert
    Object vertex = actual_applyResult.getVertex();
    assertTrue(vertex instanceof Set);
    assertEquals("Label", actual_applyResult.getGroup());
    assertTrue(((Set<Object>) vertex).isEmpty());
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   * <ul>
   *   <li>Then Vertex return {@link TypeSubTypeValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  public void test_applyWithGafferPopVertex_thenVertexReturnTypeSubTypeValue() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();

    // Act and Assert
    Object vertex = gafferEntityGenerator
        ._apply(new GafferPopVertex("Label", "xx[type=xx,  subType=xx,  value=xx]", null))
        .getVertex();
    assertTrue(vertex instanceof TypeSubTypeValue);
    assertEquals("xx", ((TypeSubTypeValue) vertex).getSubType());
    assertEquals("xx", ((TypeSubTypeValue) vertex).getType());
    assertEquals("xx", ((TypeSubTypeValue) vertex).getValue());
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   * <ul>
   *   <li>When {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code Label} and {@code Id} and graph is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  public void test_applyWithGafferPopVertex_whenGafferPopVertexWithLabelAndIdAndGraphIsNull() {
    // Arrange
    GafferEntityGenerator gafferEntityGenerator = new GafferEntityGenerator();

    // Act
    Entity actual_applyResult = gafferEntityGenerator._apply(new GafferPopVertex("Label", "Id", null));

    // Assert
    assertEquals("Id", actual_applyResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actual_applyResult.getClassName());
    assertTrue(actual_applyResult.getProperties().isEmpty());
  }

  /**
   * Test {@link GafferEntityGenerator#_apply(GafferPopVertex)} with {@code GafferPopVertex}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferEntityGenerator#_apply(GafferPopVertex)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity GafferEntityGenerator._apply(GafferPopVertex)"})
  public void test_applyWithGafferPopVertex_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new GafferEntityGenerator())._apply(null));
  }
}
