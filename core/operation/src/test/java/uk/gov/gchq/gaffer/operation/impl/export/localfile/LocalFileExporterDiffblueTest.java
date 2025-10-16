package uk.gov.gchq.gaffer.operation.impl.export.localfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;

class LocalFileExporterDiffblueTest {
  /**
   * Test {@link LocalFileExporter#get(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link LocalFileExporter#get(String)}
   */
  @Test
  @DisplayName("Test get(String); when '/'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable LocalFileExporter.get(String)"})
  void testGet_whenSlash_thenReturnList() throws OperationException {
    // Arrange and Act
    Iterable<String> actualGetResult = new LocalFileExporter().get("/");
    Iterator<String> actualIteratorResult = actualGetResult.iterator();

    // Assert
    assertTrue(actualGetResult instanceof List);
    assertEquals("aws", actualIteratorResult.next());
    assertEquals(23, ((List<String>) actualGetResult).size());
    assertEquals("aws", ((List<String>) actualGetResult).get(0));
    assertEquals("bin", actualIteratorResult.next());
    assertEquals("bin", ((List<String>) actualGetResult).get(1));
    assertEquals("boot", actualIteratorResult.next());
    assertEquals("boot", ((List<String>) actualGetResult).get(2));
    assertEquals("dev", actualIteratorResult.next());
    assertEquals("dev", ((List<String>) actualGetResult).get(3));
    assertEquals("etc", actualIteratorResult.next());
    assertEquals("etc", ((List<String>) actualGetResult).get(4));
    assertEquals("home", actualIteratorResult.next());
    assertEquals("home", ((List<String>) actualGetResult).get(5));
    assertEquals("lib", actualIteratorResult.next());
    assertEquals("lib32", actualIteratorResult.next());
    assertEquals("lib64", actualIteratorResult.next());
    assertEquals("libx32", actualIteratorResult.next());
    assertEquals("sbin", ((List<String>) actualGetResult).get(17));
    assertEquals("srv", ((List<String>) actualGetResult).get(18));
    assertEquals("sys", ((List<String>) actualGetResult).get(19));
    assertEquals("tmp", ((List<String>) actualGetResult).get(20));
    assertEquals("usr", ((List<String>) actualGetResult).get(21));
    assertEquals("var", ((List<String>) actualGetResult).get(22));
    assertTrue(actualIteratorResult.hasNext());
  }
}
