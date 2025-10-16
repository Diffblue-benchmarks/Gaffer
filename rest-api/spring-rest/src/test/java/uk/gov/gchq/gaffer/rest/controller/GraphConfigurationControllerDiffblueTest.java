package uk.gov.gchq.gaffer.rest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.rest.factory.GraphFactory;
import uk.gov.gchq.gaffer.rest.mapper.GafferExceptionMapper;

@ContextConfiguration(classes = {GraphConfigurationController.class, GafferExceptionMapper.class})
@ExtendWith(SpringExtension.class)
class GraphConfigurationControllerDiffblueTest {
  @Autowired private GafferExceptionMapper gafferExceptionMapper;

  @Autowired private GraphConfigurationController graphConfigurationController;

  @MockBean private GraphFactory graphFactory;

  /**
   * Test {@link GraphConfigurationController#getSchema()}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.schema.Schema GraphConfigurationController.getSchema()"
  })
  void testGetSchema() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/schema");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":null,\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getSchema()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.schema.Schema GraphConfigurationController.getSchema()"
  })
  void testGetSchema_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/schema");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"An error occurred\",\"detailMessage"
                        + "\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getDescription()}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getDescription()"})
  void testGetDescription() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/description");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":null,\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getDescription()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getDescription()"})
  void testGetDescription_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/description");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"An error occurred\",\"detailMessage"
                        + "\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getGraphId()}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getGraphId()"})
  void testGetGraphId() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/graphId");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":null,\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getGraphId()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getGraphId()}
   */
  @Test
  @DisplayName("Test getGraphId(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getGraphId()"})
  void testGetGraphId_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/graphId");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"An error occurred\",\"detailMessage"
                        + "\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getGraphCreatedTime()}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getGraphCreatedTime()}
   */
  @Test
  @DisplayName("Test getGraphCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getGraphCreatedTime()"})
  void testGetGraphCreatedTime() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/graphCreatedTime");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":null,\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getGraphCreatedTime()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getGraphCreatedTime()}
   */
  @Test
  @DisplayName("Test getGraphCreatedTime(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getGraphCreatedTime()"})
  void testGetGraphCreatedTime_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/graphCreatedTime");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"An error occurred\",\"detailMessage"
                        + "\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getFilterFunctions(String)} with {@code String}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set GraphConfigurationController.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/rest/graph/config/filterFunctions/{inputClass}", "Input Class");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"Could not find input class: Input"
                        + " Class\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getFilterFunctions(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'; given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set GraphConfigurationController.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_givenTrue() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/rest/graph/config/filterFunctions/{inputClass}", "Input Class");
    requestBuilder.secure(true);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"Could not find input class: Input"
                        + " Class\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFields(String)}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set GraphConfigurationController.getSerialisedFields(String)"})
  void testGetSerialisedFields() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/serialisedFields/{className}", "Class Name");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"Class name was not recognised:"
                        + " Class Name\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFieldClasses(String)}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map GraphConfigurationController.getSerialisedFieldClasses(String)"
  })
  void testGetSerialisedFieldClasses() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/rest/graph/config/serialisedFields/{className}/classes", "Class Name");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"Class name was not recognised:"
                        + " Class Name\",\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getStoreType()}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getStoreType()}
   */
  @Test
  @DisplayName("Test getStoreType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getStoreType()"})
  void testGetStoreType() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/storeType");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":null,\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getStoreType()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getStoreType()}
   */
  @Test
  @DisplayName("Test getStoreType(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationController.getStoreType()"})
  void testGetStoreType_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/storeType");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"An error occurred\",\"detailMessage"
                        + "\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getStoreTraits()}.
   *
   * <p>Method under test: {@link GraphConfigurationController#getStoreTraits()}
   */
  @Test
  @DisplayName("Test getStoreTraits()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set GraphConfigurationController.getStoreTraits()"})
  void testGetStoreTraits() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/storeTraits");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":null,\"detailMessage\":null}"));
  }

  /**
   * Test {@link GraphConfigurationController#getStoreTraits()}.
   *
   * <ul>
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationController#getStoreTraits()}
   */
  @Test
  @DisplayName("Test getStoreTraits(); then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set GraphConfigurationController.getStoreTraits()"})
  void testGetStoreTraits_thenContentStringAString() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/config/storeTraits");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(graphConfigurationController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"An error occurred\",\"detailMessage"
                        + "\":null}"));
  }
}
