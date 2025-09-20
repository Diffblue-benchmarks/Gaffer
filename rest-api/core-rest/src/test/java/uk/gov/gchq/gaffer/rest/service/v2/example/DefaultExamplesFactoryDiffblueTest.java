package uk.gov.gchq.gaffer.rest.service.v2.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.impl.get.GetAllElements;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;

class DefaultExamplesFactoryDiffblueTest {
  /**
   * Test new {@link DefaultExamplesFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DefaultExamplesFactory}
   */
  @Test
  @DisplayName("Test new DefaultExamplesFactory (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewDefaultExamplesFactory() {
    // Arrange, Act and Assert
    GetAllElements allElements = new DefaultExamplesFactory().getAllElements();
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        allElements.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = allElements.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(allElements.getOptions());
    assertNull(allElements.getDirectedType());
    assertNull(allElements.getView());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, allElements.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }
}
