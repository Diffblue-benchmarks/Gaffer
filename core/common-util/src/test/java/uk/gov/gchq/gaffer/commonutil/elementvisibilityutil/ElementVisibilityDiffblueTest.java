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

package uk.gov.gchq.gaffer.commonutil.elementvisibilityutil;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.jupiter.api.Test;

class ElementVisibilityDiffblueTest {
  /**
   * Method under test: {@link ElementVisibility.Node#getTerm(byte[])}
   */
  @Test
  void testNodeGetTerm() throws UnsupportedEncodingException {
    // Arrange
    ElementVisibility.Node node = new ElementVisibility.Node(1, 3);
    byte[] expression = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ArrayByteSequence actualTerm = node.getTerm(expression);

    // Assert
    assertEquals(1, actualTerm.offset());
    assertEquals(1, actualTerm.offset);
    assertEquals(2, actualTerm.length());
    assertEquals(2, actualTerm.length);
    assertTrue(actualTerm.isBackedByArray());
    assertSame(expression, actualTerm.getBackingArray());
    assertArrayEquals(new byte[]{'X', 'A'}, actualTerm.toArray());
  }

  /**
   * Method under test: {@link ElementVisibility.Node#getTerm(byte[])}
   */
  @Test
  void testNodeGetTerm2() throws UnsupportedEncodingException {
    // Arrange
    ElementVisibility.Node node = new ElementVisibility.Node(ElementVisibility.NodeType.EMPTY, 1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> node.getTerm("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ElementVisibility.Node#getTerm(byte[])}
   */
  @Test
  void testNodeGetTerm3() throws UnsupportedEncodingException {
    // Arrange
    ElementVisibility.Node node = new ElementVisibility.Node(1, 3);
    byte[] expression = "A\"AXAXAX".getBytes("UTF-8");

    // Act
    ArrayByteSequence actualTerm = node.getTerm(expression);

    // Assert
    assertEquals(0, actualTerm.length());
    assertEquals(0, actualTerm.toArray().length);
    assertEquals(0, actualTerm.length);
    assertEquals(2, actualTerm.offset());
    assertEquals(2, actualTerm.offset);
    assertTrue(actualTerm.isBackedByArray());
    assertSame(expression, actualTerm.getBackingArray());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementVisibility.Node#getChildren()}
   *   <li>{@link ElementVisibility.Node#getTermEnd()}
   *   <li>{@link ElementVisibility.Node#getTermStart()}
   *   <li>{@link ElementVisibility.Node#getType()}
   * </ul>
   */
  @Test
  void testNodeGettersAndSetters() {
    // Arrange
    ElementVisibility.Node node = new ElementVisibility.Node(1, 3);

    // Act
    List<ElementVisibility.Node> actualChildren = node.getChildren();
    int actualTermEnd = node.getTermEnd();
    int actualTermStart = node.getTermStart();

    // Assert
    assertEquals(1, actualTermStart);
    assertEquals(3, actualTermEnd);
    assertEquals(ElementVisibility.NodeType.TERM, node.getType());
    assertTrue(actualChildren.isEmpty());
  }

  /**
   * Method under test: {@link ElementVisibility.Node#Node(int, int)}
   */
  @Test
  void testNodeNewNode() {
    // Arrange and Act
    ElementVisibility.Node actualNode = new ElementVisibility.Node(1, 3);

    // Assert
    assertEquals(1, actualNode.getTermStart());
    assertEquals(3, actualNode.getTermEnd());
    assertEquals(ElementVisibility.NodeType.TERM, actualNode.getType());
    List<ElementVisibility.Node> children = actualNode.getChildren();
    assertTrue(children.isEmpty());
    assertSame(actualNode.EMPTY, children);
  }

  /**
   * Method under test:
   * {@link ElementVisibility.Node#Node(ElementVisibility.NodeType, int)}
   */
  @Test
  void testNodeNewNode2() {
    // Arrange and Act
    ElementVisibility.Node actualNode = new ElementVisibility.Node(ElementVisibility.NodeType.EMPTY, 1);

    // Assert
    assertEquals(1, actualNode.getTermStart());
    assertEquals(2, actualNode.getTermEnd());
    assertEquals(ElementVisibility.NodeType.EMPTY, actualNode.getType());
    List<ElementVisibility.Node> children = actualNode.getChildren();
    assertTrue(children.isEmpty());
    assertSame(actualNode.EMPTY, children);
  }

  /**
   * Method under test: {@link ElementVisibility#quote(String)}
   */
  @Test
  void testQuote() {
    // Arrange, Act and Assert
    assertEquals("Term", ElementVisibility.quote("Term"));
    assertEquals("\"[\"", ElementVisibility.quote("["));
  }

  /**
   * Method under test: {@link ElementVisibility#quote(byte[])}
   */
  @Test
  void testQuote2() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualQuoteResult = ElementVisibility.quote("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualQuoteResult);
  }

  /**
   * Method under test: {@link ElementVisibility#quote(byte[])}
   */
  @Test
  void testQuote3() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualQuoteResult = ElementVisibility.quote("\bXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("\"\bXAXAXAX\"".getBytes("UTF-8"), actualQuoteResult);
  }

  /**
   * Method under test: {@link ElementVisibility#quote(byte[])}
   */
  @Test
  void testQuote4() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualQuoteResult = ElementVisibility.quote("\b\"AXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("\"\b\\\"AXAXAX\"".getBytes("UTF-8"), actualQuoteResult);
  }

  /**
   * Method under test: {@link ElementVisibility#quote(byte[])}
   */
  @Test
  void testQuote5() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualQuoteResult = ElementVisibility.quote("\b\\AXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("\"\b\\\\AXAXAX\"".getBytes("UTF-8"), actualQuoteResult);
  }

  /**
   * Method under test: {@link ElementVisibility#equals(ElementVisibility)}
   */
  @Test
  void testEquals() {
    // Arrange
    ElementVisibility elementVisibility = new ElementVisibility("Expression");

    // Act and Assert
    assertTrue(elementVisibility.equals(new ElementVisibility("Expression")));
  }

  /**
   * Method under test: {@link ElementVisibility#equals(ElementVisibility)}
   */
  @Test
  void testEquals2() {
    // Arrange
    ElementVisibility elementVisibility = new ElementVisibility("42");

    // Act and Assert
    assertFalse(elementVisibility.equals(new ElementVisibility("Expression")));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementVisibility#equals(Object)}
   *   <li>{@link ElementVisibility#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementVisibility elementVisibility = new ElementVisibility("Expression");
    ElementVisibility elementVisibility2 = new ElementVisibility("Expression");

    // Act and Assert
    assertEquals(elementVisibility, elementVisibility2);
    int expectedHashCodeResult = elementVisibility.hashCode();
    assertEquals(expectedHashCodeResult, elementVisibility2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementVisibility#equals(Object)}
   *   <li>{@link ElementVisibility#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementVisibility elementVisibility = new ElementVisibility("Expression");

    // Act and Assert
    assertEquals(elementVisibility, elementVisibility);
    int expectedHashCodeResult = elementVisibility.hashCode();
    assertEquals(expectedHashCodeResult, elementVisibility.hashCode());
  }

  /**
   * Method under test: {@link ElementVisibility#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ElementVisibility elementVisibility = new ElementVisibility("42");

    // Act and Assert
    assertNotEquals(elementVisibility, new ElementVisibility("Expression"));
  }

  /**
   * Method under test: {@link ElementVisibility#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementVisibility("Expression"), null);
  }

  /**
   * Method under test: {@link ElementVisibility#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementVisibility("Expression"), "Different type to ElementVisibility");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementVisibility#toString()}
   *   <li>{@link ElementVisibility#getExpression()}
   *   <li>{@link ElementVisibility#getParseTree()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ElementVisibility elementVisibility = new ElementVisibility("Expression");

    // Act
    String actualToStringResult = elementVisibility.toString();
    byte[] actualExpression = elementVisibility.getExpression();
    ElementVisibility.Node actualParseTree = elementVisibility.getParseTree();

    // Assert
    assertEquals("[Expression]", actualToStringResult);
    assertEquals(0, actualParseTree.getTermStart());
    assertEquals(10, actualParseTree.getTermEnd());
    assertEquals(ElementVisibility.NodeType.TERM, actualParseTree.getType());
    assertTrue(actualParseTree.getChildren().isEmpty());
    assertArrayEquals("Expression".getBytes("UTF-8"), actualExpression);
  }

  /**
   * Method under test: {@link ElementVisibility#ElementVisibility(Object)}
   */
  @Test
  void testNewElementVisibility() throws UnsupportedEncodingException {
    // Arrange and Act
    ElementVisibility actualElementVisibility = new ElementVisibility((Object) "Expression");

    // Assert
    ElementVisibility.Node parseTree = actualElementVisibility.getParseTree();
    assertEquals(0, parseTree.getTermStart());
    assertEquals(10, parseTree.getTermEnd());
    assertEquals(ElementVisibility.NodeType.TERM, parseTree.getType());
    assertTrue(parseTree.getChildren().isEmpty());
    byte[] expectedExpression = "Expression".getBytes("UTF-8");
    assertArrayEquals(expectedExpression, actualElementVisibility.getExpression());
  }

  /**
   * Method under test: {@link ElementVisibility#ElementVisibility(Object)}
   */
  @Test
  void testNewElementVisibility2() {
    // Arrange and Act
    ElementVisibility actualElementVisibility = new ElementVisibility((Object) "");

    // Assert
    ElementVisibility.Node parseTree = actualElementVisibility.getParseTree();
    assertEquals(0, parseTree.getTermStart());
    assertEquals(0, actualElementVisibility.getExpression().length);
    assertEquals(1, parseTree.getTermEnd());
    assertEquals(ElementVisibility.NodeType.EMPTY, parseTree.getType());
    assertTrue(parseTree.getChildren().isEmpty());
  }

  /**
   * Method under test: {@link ElementVisibility#ElementVisibility(String)}
   */
  @Test
  void testNewElementVisibility3() throws UnsupportedEncodingException {
    // Arrange and Act
    ElementVisibility actualElementVisibility = new ElementVisibility("Expression");

    // Assert
    ElementVisibility.Node parseTree = actualElementVisibility.getParseTree();
    assertEquals(0, parseTree.getTermStart());
    assertEquals(10, parseTree.getTermEnd());
    assertEquals(ElementVisibility.NodeType.TERM, parseTree.getType());
    assertTrue(parseTree.getChildren().isEmpty());
    byte[] expectedExpression = "Expression".getBytes("UTF-8");
    assertArrayEquals(expectedExpression, actualElementVisibility.getExpression());
  }

  /**
   * Method under test: {@link ElementVisibility#ElementVisibility(String)}
   */
  @Test
  void testNewElementVisibility4() {
    // Arrange and Act
    ElementVisibility actualElementVisibility = new ElementVisibility("");

    // Assert
    ElementVisibility.Node parseTree = actualElementVisibility.getParseTree();
    assertEquals(0, parseTree.getTermStart());
    assertEquals(0, actualElementVisibility.getExpression().length);
    assertEquals(1, parseTree.getTermEnd());
    assertEquals(ElementVisibility.NodeType.EMPTY, parseTree.getType());
    assertTrue(parseTree.getChildren().isEmpty());
  }

  /**
   * Method under test: {@link ElementVisibility#ElementVisibility(byte[])}
   */
  @Test
  void testNewElementVisibility5() throws UnsupportedEncodingException {
    // Arrange
    byte[] expression = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ElementVisibility actualElementVisibility = new ElementVisibility(expression);

    // Assert
    ElementVisibility.Node parseTree = actualElementVisibility.getParseTree();
    assertEquals(0, parseTree.getTermStart());
    assertEquals(8, parseTree.getTermEnd());
    assertEquals(ElementVisibility.NodeType.TERM, parseTree.getType());
    assertTrue(parseTree.getChildren().isEmpty());
    assertSame(expression, actualElementVisibility.getExpression());
  }

  /**
   * Method under test: {@link ElementVisibility#ElementVisibility(byte[])}
   */
  @Test
  void testNewElementVisibility6() throws UnsupportedEncodingException {
    // Arrange
    byte[] expression = "A&AXAXAX".getBytes("UTF-8");

    // Act
    ElementVisibility actualElementVisibility = new ElementVisibility(expression);

    // Assert
    ElementVisibility.Node parseTree = actualElementVisibility.getParseTree();
    List<ElementVisibility.Node> children = parseTree.getChildren();
    assertEquals(2, children.size());
    ElementVisibility.Node getResult = children.get(0);
    assertEquals(0, getResult.getTermStart());
    assertEquals(0, parseTree.getTermStart());
    assertEquals(1, getResult.getTermEnd());
    ElementVisibility.Node getResult2 = children.get(1);
    assertEquals(2, getResult2.getTermStart());
    assertEquals(8, getResult2.getTermEnd());
    assertEquals(8, parseTree.getTermEnd());
    assertEquals(ElementVisibility.NodeType.AND, parseTree.getType());
    assertEquals(ElementVisibility.NodeType.TERM, getResult.getType());
    assertEquals(ElementVisibility.NodeType.TERM, getResult2.getType());
    assertTrue(getResult.getChildren().isEmpty());
    assertSame(expression, actualElementVisibility.getExpression());
  }

  /**
   * Method under test: {@link ElementVisibility#ElementVisibility(byte[])}
   */
  @Test
  void testNewElementVisibility7() throws UnsupportedEncodingException {
    // Arrange
    byte[] expression = "A|AXAXAX".getBytes("UTF-8");

    // Act
    ElementVisibility actualElementVisibility = new ElementVisibility(expression);

    // Assert
    ElementVisibility.Node parseTree = actualElementVisibility.getParseTree();
    List<ElementVisibility.Node> children = parseTree.getChildren();
    assertEquals(2, children.size());
    ElementVisibility.Node getResult = children.get(0);
    assertEquals(0, getResult.getTermStart());
    assertEquals(0, parseTree.getTermStart());
    assertEquals(1, getResult.getTermEnd());
    ElementVisibility.Node getResult2 = children.get(1);
    assertEquals(2, getResult2.getTermStart());
    assertEquals(8, getResult2.getTermEnd());
    assertEquals(8, parseTree.getTermEnd());
    assertEquals(ElementVisibility.NodeType.OR, parseTree.getType());
    assertEquals(ElementVisibility.NodeType.TERM, getResult.getType());
    assertEquals(ElementVisibility.NodeType.TERM, getResult2.getType());
    assertTrue(getResult.getChildren().isEmpty());
    assertSame(expression, actualElementVisibility.getExpression());
  }

  /**
   * Method under test: {@link ElementVisibility#ElementVisibility(byte[])}
   */
  @Test
  void testNewElementVisibility8() {
    // Arrange and Act
    ElementVisibility actualElementVisibility = new ElementVisibility((byte[]) null);

    // Assert
    assertNull(actualElementVisibility.getExpression());
    ElementVisibility.Node parseTree = actualElementVisibility.getParseTree();
    assertEquals(0, parseTree.getTermStart());
    assertEquals(1, parseTree.getTermEnd());
    assertEquals(ElementVisibility.NodeType.EMPTY, parseTree.getType());
    assertTrue(parseTree.getChildren().isEmpty());
  }

  /**
   * Method under test: {@link ElementVisibility#ElementVisibility(byte[])}
   */
  @Test
  void testNewElementVisibility9() {
    // Arrange
    byte[] expression = new byte[]{};

    // Act
    ElementVisibility actualElementVisibility = new ElementVisibility(expression);

    // Assert
    ElementVisibility.Node parseTree = actualElementVisibility.getParseTree();
    assertEquals(0, parseTree.getTermStart());
    byte[] expression2 = actualElementVisibility.getExpression();
    assertEquals(0, expression2.length);
    assertEquals(1, parseTree.getTermEnd());
    assertEquals(ElementVisibility.NodeType.EMPTY, parseTree.getType());
    assertTrue(parseTree.getChildren().isEmpty());
    assertSame(expression, expression2);
  }

  /**
   * Method under test: {@link ElementVisibility#ElementVisibility(byte[])}
   */
  @Test
  void testNewElementVisibility10() throws UnsupportedEncodingException {
    // Arrange
    byte[] expression = "A&A&AXAX".getBytes("UTF-8");

    // Act
    ElementVisibility actualElementVisibility = new ElementVisibility(expression);

    // Assert
    ElementVisibility.Node parseTree = actualElementVisibility.getParseTree();
    List<ElementVisibility.Node> children = parseTree.getChildren();
    assertEquals(3, children.size());
    ElementVisibility.Node getResult = children.get(0);
    assertEquals(0, getResult.getTermStart());
    assertEquals(0, parseTree.getTermStart());
    assertEquals(1, getResult.getTermEnd());
    ElementVisibility.Node getResult2 = children.get(1);
    assertEquals(2, getResult2.getTermStart());
    assertEquals(3, getResult2.getTermEnd());
    ElementVisibility.Node getResult3 = children.get(2);
    assertEquals(4, getResult3.getTermStart());
    assertEquals(8, getResult3.getTermEnd());
    assertEquals(8, parseTree.getTermEnd());
    assertEquals(ElementVisibility.NodeType.AND, parseTree.getType());
    assertEquals(ElementVisibility.NodeType.TERM, getResult.getType());
    assertEquals(ElementVisibility.NodeType.TERM, getResult2.getType());
    assertEquals(ElementVisibility.NodeType.TERM, getResult3.getType());
    assertTrue(getResult.getChildren().isEmpty());
    assertSame(expression, actualElementVisibility.getExpression());
  }
}
