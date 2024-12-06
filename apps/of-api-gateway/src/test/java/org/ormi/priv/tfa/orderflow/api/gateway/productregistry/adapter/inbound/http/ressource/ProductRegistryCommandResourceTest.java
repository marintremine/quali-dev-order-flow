package org.ormi.priv.tfa.orderflow.api.gateway.productregistry.adapter.inbound.http.ressource;

import org.junit.jupiter.api.Test;
import org.ormi.priv.tfa.orderflow.api.gateway.productregistry.adapter.inbound.http.dto.RegisterProductCommandDto;
import org.ormi.priv.tfa.orderflow.api.gateway.productregistry.adapter.inbound.http.dto.UpdateProductCommandDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ProductRegistryCommandResourceTest {
  
  
  @Test
  public void testRegisterProduct_ValidProduct() {
      RegisterProductCommandDto dto = new RegisterProductCommandDto("product1", "product description");
      
      given()
          .contentType(MediaType.APPLICATION_JSON)
          .body(dto)
      .when()
          .post("/api/product/registry/registerProduct")
      .then()
          .statusCode(302);
  }

  @Test
  public void testRegisterProduct_InvalidProduct() {
      RegisterProductCommandDto invalidDto = new RegisterProductCommandDto("", "");
      
      given()
          .contentType(MediaType.APPLICATION_JSON)
          .body(invalidDto)
      .when()
          .post("/api/product/registry/registerProduct")
      .then()
          .statusCode(400);
  }

  @Test
  public void testRegisterProduct_NullBody() {
      given()
          .contentType(MediaType.APPLICATION_JSON)
      .when()
          .post("/api/product/registry/registerProduct")
      .then()
          .statusCode(400);
  }

  @Test
  public void testUpdateProduct_ValidProduct() {
      UpdateProductCommandDto dto = new UpdateProductCommandDto("product-id", "updated product", "updated description");
      
      given()
          .contentType(MediaType.APPLICATION_JSON)
          .body(dto)
      .when()
          .post("/api/product/registry/updateProduct")
      .then()
          .statusCode(302);
  }

  @Test
  public void testUpdateProduct_InvalidProduct() {
      UpdateProductCommandDto invalidDto = new UpdateProductCommandDto("", "", "");
      
      given()
          .contentType(MediaType.APPLICATION_JSON)
          .body(invalidDto)
      .when()
          .post("/api/product/registry/updateProduct")
      .then()
          .statusCode(400);
  }

  @Test
  public void testUpdateProduct_NullBody() {
      given()
          .contentType(MediaType.APPLICATION_JSON)
      .when()
          .post("/api/product/registry/updateProduct")
      .then()
          .statusCode(400);
  }
}