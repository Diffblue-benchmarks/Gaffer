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

package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.library.FileGraphLibrary;
import uk.gov.gchq.gaffer.store.library.HashMapGraphLibrary;
import uk.gov.gchq.gaffer.store.operation.add.AddSchemaToLibrary;

class AddSchemaToLibraryHandlerDiffblueTest {
  /**
   * Test {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)} with {@code AddSchemaToLibrary}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddSchemaToLibrary, Context, Store) with 'AddSchemaToLibrary', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void AddSchemaToLibraryHandler.doOperation(AddSchemaToLibrary, Context, Store)"})
  void testDoOperationWithAddSchemaToLibraryContextStore() throws OperationException {
    // Arrange
    AddSchemaToLibraryHandler addSchemaToLibraryHandler = new AddSchemaToLibraryHandler();

    AddSchemaToLibrary operation = new AddSchemaToLibrary();
    operation.setParentSchemaIds(null);
    operation.setId(null);
    Context context = new Context();

    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act and Assert
    assertThrows(OperationException.class, () -> addSchemaToLibraryHandler.doOperation(operation, context, store));
  }

  /**
   * Test {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)} with {@code AddSchemaToLibrary}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddSchemaToLibrary, Context, Store) with 'AddSchemaToLibrary', 'Context', 'Store'; given ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void AddSchemaToLibraryHandler.doOperation(AddSchemaToLibrary, Context, Store)"})
  void testDoOperationWithAddSchemaToLibraryContextStore_givenArrayList() throws OperationException {
    // Arrange
    AddSchemaToLibraryHandler addSchemaToLibraryHandler = new AddSchemaToLibraryHandler();

    AddSchemaToLibrary operation = new AddSchemaToLibrary();
    operation.setParentSchemaIds(new ArrayList<>());
    operation.setId(null);
    Context context = new Context();

    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act and Assert
    assertThrows(OperationException.class, () -> addSchemaToLibraryHandler.doOperation(operation, context, store));
  }

  /**
   * Test {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)} with {@code AddSchemaToLibrary}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddSchemaToLibrary, Context, Store) with 'AddSchemaToLibrary', 'Context', 'Store'; given ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void AddSchemaToLibraryHandler.doOperation(AddSchemaToLibrary, Context, Store)"})
  void testDoOperationWithAddSchemaToLibraryContextStore_givenArrayListAddNull() throws OperationException {
    // Arrange
    AddSchemaToLibraryHandler addSchemaToLibraryHandler = new AddSchemaToLibraryHandler();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add(null);

    AddSchemaToLibrary operation = new AddSchemaToLibrary();
    operation.setParentSchemaIds(parentSchemaIds);
    operation.setId(null);
    Context context = new Context();

    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act and Assert
    assertThrows(OperationException.class, () -> addSchemaToLibraryHandler.doOperation(operation, context, store));
  }

  /**
   * Test {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)} with {@code AddSchemaToLibrary}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Operation}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddSchemaToLibrary, Context, Store) with 'AddSchemaToLibrary', 'Context', 'Store'; given ArrayList() add 'Operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void AddSchemaToLibraryHandler.doOperation(AddSchemaToLibrary, Context, Store)"})
  void testDoOperationWithAddSchemaToLibraryContextStore_givenArrayListAddOperation() throws OperationException {
    // Arrange
    AddSchemaToLibraryHandler addSchemaToLibraryHandler = new AddSchemaToLibraryHandler();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("Operation");

    AddSchemaToLibrary operation = new AddSchemaToLibrary();
    operation.setParentSchemaIds(parentSchemaIds);
    operation.setId(null);
    Context context = new Context();

    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act and Assert
    assertThrows(OperationException.class, () -> addSchemaToLibraryHandler.doOperation(operation, context, store));
  }

  /**
   * Test {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)} with {@code AddSchemaToLibrary}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Operation}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddSchemaToLibrary, Context, Store) with 'AddSchemaToLibrary', 'Context', 'Store'; given ArrayList() add 'Operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void AddSchemaToLibraryHandler.doOperation(AddSchemaToLibrary, Context, Store)"})
  void testDoOperationWithAddSchemaToLibraryContextStore_givenArrayListAddOperation2() throws OperationException {
    // Arrange
    AddSchemaToLibraryHandler addSchemaToLibraryHandler = new AddSchemaToLibraryHandler();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("Operation");

    AddSchemaToLibrary operation = new AddSchemaToLibrary();
    operation.setParentSchemaIds(parentSchemaIds);
    operation.setId(null);
    Context context = new Context();

    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    store.setGraphLibrary(new HashMapGraphLibrary());

    // Act and Assert
    assertThrows(OperationException.class, () -> addSchemaToLibraryHandler.doOperation(operation, context, store));
  }

  /**
   * Test {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)} with {@code AddSchemaToLibrary}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@code Id is invalid:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddSchemaToLibrary, Context, Store) with 'AddSchemaToLibrary', 'Context', 'Store'; given 'Id is invalid:'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void AddSchemaToLibraryHandler.doOperation(AddSchemaToLibrary, Context, Store)"})
  void testDoOperationWithAddSchemaToLibraryContextStore_givenIdIsInvalid() throws OperationException {
    // Arrange
    AddSchemaToLibraryHandler addSchemaToLibraryHandler = new AddSchemaToLibraryHandler();

    AddSchemaToLibrary operation = new AddSchemaToLibrary();
    operation.setParentSchemaIds(null);
    operation.setId("Id is invalid: ");
    Context context = new Context();

    TestAddToGraphLibraryImpl store = new TestAddToGraphLibraryImpl();
    store.setGraphLibrary(new FileGraphLibrary());

    // Act and Assert
    assertThrows(OperationException.class, () -> addSchemaToLibraryHandler.doOperation(operation, context, store));
  }

  /**
   * Test {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)} with {@code AddSchemaToLibrary}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link TestAddToGraphLibraryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AddSchemaToLibraryHandler#doOperation(AddSchemaToLibrary, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(AddSchemaToLibrary, Context, Store) with 'AddSchemaToLibrary', 'Context', 'Store'; when TestAddToGraphLibraryImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void AddSchemaToLibraryHandler.doOperation(AddSchemaToLibrary, Context, Store)"})
  void testDoOperationWithAddSchemaToLibraryContextStore_whenTestAddToGraphLibraryImpl() throws OperationException {
    // Arrange
    AddSchemaToLibraryHandler addSchemaToLibraryHandler = new AddSchemaToLibraryHandler();
    AddSchemaToLibrary operation = new AddSchemaToLibrary();
    Context context = new Context();

    // Act and Assert
    assertThrows(OperationException.class,
        () -> addSchemaToLibraryHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
