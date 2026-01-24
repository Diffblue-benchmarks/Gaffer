/*
 * Copyright 2026 Crown Copyright
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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.elementvisibilityutil.ElementVisibility.Node;
import uk.gov.gchq.gaffer.commonutil.elementvisibilityutil.ElementVisibility.NodeType;

class ElementVisibilityDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementVisibility#ElementVisibility(byte[])}
   *   <li>{@link ElementVisibility#toString()}
   *   <li>{@link ElementVisibility#getExpression()}
   *   <li>{@link ElementVisibility#getParseTree()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ElementVisibility.<init>(byte[])",
    "byte[] ElementVisibility.getExpression()",
    "Node ElementVisibility.getParseTree()",
    "String ElementVisibility.toString()"
  })
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] expression = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ElementVisibility actualElementVisibility = new ElementVisibility(expression);
    String actualToStringResult = actualElementVisibility.toString();
    byte[] actualExpression = actualElementVisibility.getExpression();
    Node actualParseTree = actualElementVisibility.getParseTree();

    // Assert
    assertEquals("[AXAXAXAX]", actualToStringResult);
    assertEquals(0, actualParseTree.getTermStart());
    assertEquals(8, actualParseTree.getTermEnd());
    assertEquals(NodeType.TERM, actualParseTree.getType());
    List<Node> children = actualParseTree.getChildren();
    assertTrue(children.isEmpty());
    assertSame(expression, actualExpression);
    assertSame(Node.EMPTY, children);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualExpression);
  }

  /**
   * Test {@link ElementVisibility#ElementVisibility(Object)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return ParseTree TermEnd is one.
   * </ul>
   *
   * <p>Method under test: {@link ElementVisibility#ElementVisibility(Object)}
   */
  @Test
  @DisplayName(
      "Test new ElementVisibility(Object); when empty string; then return ParseTree TermEnd is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementVisibility.<init>(Object)"})
  void testNewElementVisibility_whenEmptyString_thenReturnParseTreeTermEndIsOne() {
    // Arrange and Act
    ElementVisibility actualElementVisibility = new ElementVisibility((Object) "");

    // Assert
    Node parseTree = actualElementVisibility.getParseTree();
    assertEquals(0, parseTree.getTermStart());
    assertEquals(1, parseTree.getTermEnd());
    assertEquals(NodeType.EMPTY, parseTree.getType());
    assertTrue(parseTree.getChildren().isEmpty());
    assertArrayEquals(new byte[] {}, actualElementVisibility.getExpression());
  }

  /**
   * Test {@link ElementVisibility#ElementVisibility(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return ParseTree TermEnd is one.
   * </ul>
   *
   * <p>Method under test: {@link ElementVisibility#ElementVisibility(String)}
   */
  @Test
  @DisplayName(
      "Test new ElementVisibility(String); when empty string; then return ParseTree TermEnd is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementVisibility.<init>(String)"})
  void testNewElementVisibility_whenEmptyString_thenReturnParseTreeTermEndIsOne2() {
    // Arrange and Act
    ElementVisibility actualElementVisibility = new ElementVisibility("");

    // Assert
    Node parseTree = actualElementVisibility.getParseTree();
    assertEquals(0, parseTree.getTermStart());
    assertEquals(1, parseTree.getTermEnd());
    assertEquals(NodeType.EMPTY, parseTree.getType());
    assertTrue(parseTree.getChildren().isEmpty());
    assertArrayEquals(new byte[] {}, actualElementVisibility.getExpression());
  }

  /**
   * Test {@link ElementVisibility#ElementVisibility(Object)}.
   *
   * <ul>
   *   <li>When {@code Expression}.
   *   <li>Then return ParseTree TermEnd is ten.
   * </ul>
   *
   * <p>Method under test: {@link ElementVisibility#ElementVisibility(Object)}
   */
  @Test
  @DisplayName(
      "Test new ElementVisibility(Object); when 'Expression'; then return ParseTree TermEnd is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementVisibility.<init>(Object)"})
  void testNewElementVisibility_whenExpression_thenReturnParseTreeTermEndIsTen()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ElementVisibility actualElementVisibility = new ElementVisibility((Object) "Expression");

    // Assert
    Node parseTree = actualElementVisibility.getParseTree();
    assertEquals(0, parseTree.getTermStart());
    assertEquals(10, parseTree.getTermEnd());
    assertEquals(NodeType.TERM, parseTree.getType());
    assertTrue(parseTree.getChildren().isEmpty());
    assertArrayEquals("Expression".getBytes("UTF-8"), actualElementVisibility.getExpression());
  }

  /**
   * Test {@link ElementVisibility#ElementVisibility(String)}.
   *
   * <ul>
   *   <li>When {@code Expression}.
   *   <li>Then return ParseTree TermEnd is ten.
   * </ul>
   *
   * <p>Method under test: {@link ElementVisibility#ElementVisibility(String)}
   */
  @Test
  @DisplayName(
      "Test new ElementVisibility(String); when 'Expression'; then return ParseTree TermEnd is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementVisibility.<init>(String)"})
  void testNewElementVisibility_whenExpression_thenReturnParseTreeTermEndIsTen2()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ElementVisibility actualElementVisibility = new ElementVisibility("Expression");

    // Assert
    Node parseTree = actualElementVisibility.getParseTree();
    assertEquals(0, parseTree.getTermStart());
    assertEquals(10, parseTree.getTermEnd());
    assertEquals(NodeType.TERM, parseTree.getType());
    assertTrue(parseTree.getChildren().isEmpty());
    assertArrayEquals("Expression".getBytes("UTF-8"), actualElementVisibility.getExpression());
  }

  /**
   * Test Node {@link Node#getTerm(byte[])}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(int, int)} with start is one and end is three.
   *   <li>Then return length is zero.
   * </ul>
   *
   * <p>Method under test: {@link Node#getTerm(byte[])}
   */
  @Test
  @DisplayName(
      "Test Node getTerm(byte[]); given Node(int, int) with start is one and end is three; then return length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayByteSequence Node.getTerm(byte[])"})
  void testNodeGetTerm_givenNodeWithStartIsOneAndEndIsThree_thenReturnLengthIsZero()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ArrayByteSequence actualTerm =
        new Node(1, 3).getTerm("A\"A\"A\"A\"A\"A\"A\"A\"".getBytes("UTF-8"));

    // Assert
    assertEquals(0, actualTerm.length());
    assertEquals(0, actualTerm.length);
    assertEquals(2, actualTerm.offset());
    assertEquals(2, actualTerm.offset);
    assertArrayEquals("A\"A\"A\"A\"A\"A\"A\"A\"".getBytes("UTF-8"), actualTerm.getBackingArray());
    assertArrayEquals(new byte[] {}, actualTerm.toArray());
  }

  /**
   * Test Node {@link Node#getTerm(byte[])}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(int, int)} with start is one and end is three.
   *   <li>Then return offset is one.
   * </ul>
   *
   * <p>Method under test: {@link Node#getTerm(byte[])}
   */
  @Test
  @DisplayName(
      "Test Node getTerm(byte[]); given Node(int, int) with start is one and end is three; then return offset is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayByteSequence Node.getTerm(byte[])"})
  void testNodeGetTerm_givenNodeWithStartIsOneAndEndIsThree_thenReturnOffsetIsOne()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ArrayByteSequence actualTerm = new Node(1, 3).getTerm("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, actualTerm.offset());
    assertEquals(1, actualTerm.offset);
    assertEquals(2, actualTerm.length());
    assertEquals(2, actualTerm.length);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualTerm.getBackingArray());
    assertArrayEquals(new byte[] {'X', 'A'}, actualTerm.toArray());
  }

  /**
   * Test Node {@link Node#getTerm(byte[])}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(NodeType, int)} with type is {@code EMPTY} and start is one.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link Node#getTerm(byte[])}
   */
  @Test
  @DisplayName(
      "Test Node getTerm(byte[]); given Node(NodeType, int) with type is 'EMPTY' and start is one; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayByteSequence Node.getTerm(byte[])"})
  void testNodeGetTerm_givenNodeWithTypeIsEmptyAndStartIsOne_thenThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new Node(NodeType.EMPTY, 1).getTerm("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Node getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Node#getChildren()}
   *   <li>{@link Node#getTermEnd()}
   *   <li>{@link Node#getTermStart()}
   *   <li>{@link Node#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test Node getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List Node.getChildren()",
    "int Node.getTermEnd()",
    "int Node.getTermStart()",
    "NodeType Node.getType()"
  })
  void testNodeGettersAndSetters() {
    // Arrange
    Node node = new Node(1, 3);

    // Act
    List<Node> actualChildren = node.getChildren();
    int actualTermEnd = node.getTermEnd();
    int actualTermStart = node.getTermStart();

    // Assert
    assertEquals(1, actualTermStart);
    assertEquals(3, actualTermEnd);
    assertEquals(NodeType.TERM, node.getType());
    assertTrue(actualChildren.isEmpty());
  }

  /**
   * Test Node {@link Node#Node(int, int)}.
   *
   * <p>Method under test: {@link Node#Node(int, int)}
   */
  @Test
  @DisplayName("Test Node new Node(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Node.<init>(int, int)"})
  void testNodeNewNode() {
    // Arrange and Act
    Node actualNode = new Node(1, 3);

    // Assert
    assertEquals(1, actualNode.getTermStart());
    assertEquals(3, actualNode.getTermEnd());
    assertEquals(NodeType.TERM, actualNode.getType());
    assertTrue(actualNode.getChildren().isEmpty());
  }

  /**
   * Test Node {@link Node#Node(NodeType, int)}.
   *
   * <p>Method under test: {@link Node#Node(NodeType, int)}
   */
  @Test
  @DisplayName("Test Node new Node(NodeType, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Node.<init>(NodeType, int)"})
  void testNodeNewNode2() {
    // Arrange and Act
    Node actualNode = new Node(NodeType.EMPTY, 1);

    // Assert
    assertEquals(1, actualNode.getTermStart());
    assertEquals(2, actualNode.getTermEnd());
    assertEquals(NodeType.EMPTY, actualNode.getType());
    assertTrue(actualNode.getChildren().isEmpty());
  }

  /**
   * Test {@link ElementVisibility#quote(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link ElementVisibility#quote(byte[])}
   */
  @Test
  @DisplayName("Test quote(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ElementVisibility.quote(byte[])"})
  void testQuoteWithByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "\"A\bA\bA\bA\bA\bA\bA\bA\b\"".getBytes("UTF-8"),
        ElementVisibility.quote("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link ElementVisibility#quote(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link ElementVisibility#quote(byte[])}
   */
  @Test
  @DisplayName("Test quote(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ElementVisibility.quote(byte[])"})
  void testQuoteWithByte2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "\"\\\"\bA\bA\bA\bA\bA\bA\bA\b\"".getBytes("UTF-8"),
        ElementVisibility.quote("\"\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link ElementVisibility#quote(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link ElementVisibility#quote(byte[])}
   */
  @Test
  @DisplayName("Test quote(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ElementVisibility.quote(byte[])"})
  void testQuoteWithByte3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "\"\\\\\bA\bA\bA\bA\bA\bA\bA\b\"".getBytes("UTF-8"),
        ElementVisibility.quote("\\\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")));
  }

  /**
   * Test {@link ElementVisibility#quote(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ElementVisibility#quote(byte[])}
   */
  @Test
  @DisplayName(
      "Test quote(byte[]) with 'byte[]'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ElementVisibility.quote(byte[])"})
  void testQuoteWithByte_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), ElementVisibility.quote("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ElementVisibility#quote(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return {@code "["}.
   * </ul>
   *
   * <p>Method under test: {@link ElementVisibility#quote(String)}
   */
  @Test
  @DisplayName("Test quote(String) with 'String'; then return '\"[\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ElementVisibility.quote(String)"})
  void testQuoteWithString_thenReturnQuotationMarkLeftSquareBracketQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\"[\"", ElementVisibility.quote("["));
  }

  /**
   * Test {@link ElementVisibility#quote(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Term}.
   *   <li>Then return {@code Term}.
   * </ul>
   *
   * <p>Method under test: {@link ElementVisibility#quote(String)}
   */
  @Test
  @DisplayName("Test quote(String) with 'String'; when 'Term'; then return 'Term'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ElementVisibility.quote(String)"})
  void testQuoteWithString_whenTerm_thenReturnTerm() {
    // Arrange, Act and Assert
    assertEquals("Term", ElementVisibility.quote("Term"));
  }

  /**
   * Test {@link ElementVisibility#equals(Object)}, and {@link ElementVisibility#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementVisibility#equals(Object)}
   *   <li>{@link ElementVisibility#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementVisibility.equals(Object)",
    "int ElementVisibility.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementVisibility elementVisibility = new ElementVisibility("Expression");
    ElementVisibility elementVisibility2 = new ElementVisibility("Expression");

    // Act and Assert
    assertEquals(elementVisibility, elementVisibility2);
    assertEquals(elementVisibility.hashCode(), elementVisibility2.hashCode());
  }

  /**
   * Test {@link ElementVisibility#equals(Object)}, and {@link ElementVisibility#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementVisibility#equals(Object)}
   *   <li>{@link ElementVisibility#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementVisibility.equals(Object)",
    "int ElementVisibility.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementVisibility elementVisibility = new ElementVisibility("Expression");

    // Act and Assert
    assertEquals(elementVisibility, elementVisibility);
    int expectedHashCodeResult = elementVisibility.hashCode();
    assertEquals(expectedHashCodeResult, elementVisibility.hashCode());
  }

  /**
   * Test {@link ElementVisibility#equals(ElementVisibility)} with {@code otherLe}.
   *
   * <ul>
   *   <li>Given {@link ElementVisibility#ElementVisibility(String)} with expression is {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementVisibility#equals(ElementVisibility)}
   */
  @Test
  @DisplayName(
      "Test equals(ElementVisibility) with 'otherLe'; given ElementVisibility(String) with expression is '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementVisibility.equals(ElementVisibility)"})
  void testEqualsWithOtherLe_givenElementVisibilityWithExpressionIs42_thenReturnFalse() {
    // Arrange
    ElementVisibility elementVisibility = new ElementVisibility("42");

    // Act
    boolean actualEqualsResult = elementVisibility.equals(new ElementVisibility("Expression"));

    // Assert
    assertFalse(actualEqualsResult);
  }

  /**
   * Test {@link ElementVisibility#equals(ElementVisibility)} with {@code otherLe}.
   *
   * <ul>
   *   <li>Given {@link ElementVisibility#ElementVisibility(String)} with {@code Expression}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementVisibility#equals(ElementVisibility)}
   */
  @Test
  @DisplayName(
      "Test equals(ElementVisibility) with 'otherLe'; given ElementVisibility(String) with 'Expression'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementVisibility.equals(ElementVisibility)"})
  void testEqualsWithOtherLe_givenElementVisibilityWithExpression_thenReturnTrue() {
    // Arrange
    ElementVisibility elementVisibility = new ElementVisibility("Expression");

    // Act
    boolean actualEqualsResult = elementVisibility.equals(new ElementVisibility("Expression"));

    // Assert
    assertTrue(actualEqualsResult);
  }

  /**
   * Test {@link ElementVisibility#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementVisibility#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementVisibility.equals(Object)",
    "int ElementVisibility.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementVisibility("Expression"), 1);
  }

  /**
   * Test {@link ElementVisibility#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementVisibility#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementVisibility.equals(Object)",
    "int ElementVisibility.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ElementVisibility elementVisibility = new ElementVisibility("42");

    // Act and Assert
    assertNotEquals(elementVisibility, new ElementVisibility("Expression"));
  }

  /**
   * Test {@link ElementVisibility#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementVisibility#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementVisibility.equals(Object)",
    "int ElementVisibility.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementVisibility("Expression"), null);
  }

  /**
   * Test {@link ElementVisibility#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementVisibility#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementVisibility.equals(Object)",
    "int ElementVisibility.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementVisibility("Expression"), "Different type to ElementVisibility");
  }
}
