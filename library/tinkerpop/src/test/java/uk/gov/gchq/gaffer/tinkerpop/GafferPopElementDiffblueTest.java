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

package uk.gov.gchq.gaffer.tinkerpop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GafferPopElementDiffblueTest {
  /**
   * Test {@link GafferPopElement#id()}.
   * <ul>
   *   <li>Given {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code Label} and {@code Id} and graph is {@code null}.</li>
   *   <li>Then return {@code Id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopElement#id()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object GafferPopElement.id()"})
  public void testId_givenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnId() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    // Act
    Object actualIdResult = gafferPopVertex.id();

    // Assert
    assertEquals("Id", actualIdResult);
    assertSame(gafferPopVertex.id, actualIdResult);
  }

  /**
   * Test {@link GafferPopElement#label()}.
   * <ul>
   *   <li>Given {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code Label} and {@code Id} and graph is {@code null}.</li>
   *   <li>Then return {@code Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopElement#label()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String GafferPopElement.label()"})
  public void testLabel_givenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnLabel() {
    // Arrange, Act and Assert
    assertEquals("Label", (new GafferPopVertex("Label", "Id", null)).label());
  }

  /**
   * Test {@link GafferPopElement#setReadOnly()}.
   * <ul>
   *   <li>Then {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code Label} and {@code Id} and graph is {@code null} ReadOnly.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopElement#setReadOnly()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GafferPopElement.setReadOnly()"})
  public void testSetReadOnly_thenGafferPopVertexWithLabelAndIdAndGraphIsNullReadOnly() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    // Act
    gafferPopVertex.setReadOnly();

    // Assert
    assertTrue(gafferPopVertex.isReadOnly());
  }

  /**
   * Test {@link GafferPopElement#isReadOnly()}.
   * <ul>
   *   <li>Given {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code Label} and {@code Id} and graph is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopElement#isReadOnly()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GafferPopElement.isReadOnly()"})
  public void testIsReadOnly_givenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new GafferPopVertex("Label", "Id", null)).isReadOnly());
  }

  /**
   * Test {@link GafferPopElement#graph()}.
   * <ul>
   *   <li>Given {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code Label} and {@code Id} and graph is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopElement#graph()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"uk.gov.gchq.gaffer.tinkerpop.GafferPopGraph GafferPopElement.graph()"})
  public void testGraph_givenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new GafferPopVertex("Label", "Id", null)).graph());
  }
}
