package org.ormi.priv.tfa.orderflow.api.gateway.productregistry.adapter.inbound.http.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class ProductRegistryCommandResourceTest {

    @Nested
    class RegisterProduct {

        @Test
        void shouldRedirectWhenRegisteringValidProduct() {
            String validProductJson = "{ \"id\": \"123\", \"name\": \"Product Name\", \"description\": \"Product Description\" }";

            given()
                .contentType("application/json")
                .body(validProductJson)
                .when()
                .post("/api/product/registry/registerProduct")
                .then()
                .statusCode(302)
                .header("Location", is("/api/product/registry/events/PR"));
        }

        @Test
        void shouldReturnBadRequestWhenRegisteringInvalidProduct() {
            String invalidProductJson = "{ \"id\": \"123\", \"name\": \"\" }"; // Missing description

            given()
                .contentType("application/json")
                .body(invalidProductJson)
                .when()
                .post("/api/product/registry/registerProduct")
                .then()
                .statusCode(400);
        }

        @Test
        void shouldReturnBadRequestWhenRegisteringNullProduct() {
            given()
                .contentType("application/json")
                .body("{}") // Empty JSON body
                .when()
                .post("/api/product/registry/registerProduct")
                .then()
                .statusCode(400);
        }
    }

    @Nested
    class UpdateProduct {
        
        @Test
        void it_should_redirect_when_updatingValidProduct() {
            // Given
            String validProductJson = "{ \"id\": \"123\", \"name\": \"Product Name\", \"description\": \"Product Description\" }";
            
            // When & Then
            given()
                .contentType("application/json")
                .body(validProductJson)
                .when()
                .post("/api/product/registry/updateProduct")
                .then()
                .statusCode(302)
                .header("Location", equalTo("PR Event Stream"));
        }

        @Test
        void it_should_returnBadRequest_when_updatingInvalidProduct() {
            // Given
            String invalidProductJson = "{ \"id\": \"123\", \"name\": \"\", \"description\": \"\" }"; // Invalid product with missing fields
            
            // When & Then
            given()
                .contentType("application/json")
                .body(invalidProductJson)
                .when()
                .post("/api/product/registry/updateProduct")
                .then()
                .statusCode(400);
        }

        @Test
        void it_should_returnBadRequest_when_updatingNullProduct() {
            // When & Then
            given()
                .contentType("application/json")
                .body("")
                .when()
                .post("/api/product/registry/updateProduct")
                .then()
                .statusCode(400);
        }
    }

    @Nested
    class RemoveProduct {

        @Test
        void it_should_redirect_when_deletingValidProduct() {
            // Given
            String validProductJson = "{ \"id\": \"123\", \"name\": \"Product Name\", \"description\": \"Product Description\" }";
            
            // When & Then
            given()
                .contentType("application/json")
                .body(validProductJson)
                .when()
                .post("/api/product/registry/deleteProduct")
                .then()
                .statusCode(302)
                .header("Location", equalTo("PR Event Stream"));
        }

        @Test
        void it_should_returnBadRequest_when_deletingInvalidProduct() {
            // Given
            String invalidProductJson = "{ \"id\": \"123\", \"name\": \"\", \"description\": \"\" }"; // Invalid product with missing fields
            
            // When & Then
            given()
                .contentType("application/json")
                .body(invalidProductJson)
                .when()
                .post("/api/product/registry/deleteProduct")
                .then()
                .statusCode(400);
        }

        @Test
        void it_should_returnBadRequest_when_deletingNullProduct() {
            // When & Then
            given()
                .contentType("application/json")
                .body("")
                .when()
                .post("/api/product/registry/deleteProduct")
                .then()
                .statusCode(400);
        }
    }
}