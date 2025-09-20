package uk.gov.gchq.gaffer.store.operation.handler.named;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.view.AddNamedView;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedViewCache;

class AddNamedViewHandlerDiffblueTest {
  /**
   * Test {@link AddNamedViewHandler#AddNamedViewHandler(NamedViewCache)}.
   *
   * <p>Method under test: {@link AddNamedViewHandler#AddNamedViewHandler(NamedViewCache)}
   */
  @Test
  @DisplayName("Test new AddNamedViewHandler(NamedViewCache)")
  @Tag("MaintainedByDiffblue")
  void testNewAddNamedViewHandler() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new AddNamedViewHandler(new NamedViewCache("Suffix Named View Cache Name"))
            .getSuffixCacheName());
  }

  /**
   * Test {@link AddNamedViewHandler#AddNamedViewHandler(String)}.
   *
   * <p>Method under test: {@link AddNamedViewHandler#AddNamedViewHandler(String)}
   */
  @Test
  @DisplayName("Test new AddNamedViewHandler(String)")
  @Tag("MaintainedByDiffblue")
  void testNewAddNamedViewHandler2() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new AddNamedViewHandler("Suffix Named View Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link AddNamedViewHandler#getSuffixCacheName()}.
   *
   * <ul>
   *   <li>Then return {@code suffix named view cache name}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedViewHandler#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName(); then return 'suffix named view cache name'")
  @Tag("MaintainedByDiffblue")
  void testGetSuffixCacheName_thenReturnSuffixNamedViewCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new AddNamedViewHandler("Suffix Named View Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link AddNamedViewHandler#doOperation(AddNamedView, Context, Store)} with {@code
   * AddNamedView}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedViewHandler#doOperation(AddNamedView, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddNamedView, Context, Store) with 'AddNamedView', 'Context', 'Store'; given empty string")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithAddNamedViewContextStore_givenEmptyString() throws OperationException {
    // Arrange
    AddNamedViewHandler addNamedViewHandler =
        new AddNamedViewHandler("Suffix Named View Cache Name");

    AddNamedView operation = new AddNamedView();
    operation.setName("");
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> addNamedViewHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link AddNamedViewHandler#doOperation(AddNamedView, Context, Store)} with {@code
   * AddNamedView}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link AddNamedView} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AddNamedViewHandler#doOperation(AddNamedView, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddNamedView, Context, Store) with 'AddNamedView', 'Context', 'Store'; when AddNamedView (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithAddNamedViewContextStore_whenAddNamedView() throws OperationException {
    // Arrange
    AddNamedViewHandler addNamedViewHandler =
        new AddNamedViewHandler("Suffix Named View Cache Name");
    AddNamedView operation = new AddNamedView();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> addNamedViewHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
