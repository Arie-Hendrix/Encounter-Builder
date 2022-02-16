package com.encounter.encounterbuilder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import com.encounter.encounterbuilder.entity.Encounter;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/remove")
@OpenAPIDefinition(info = @Info(title = "Encounter Builder"), 
servers = {@Server(url = "http://localhost:8080", description = "Local Server")})
public interface EncounterDeleteController {
  @Operation(
      summary = "Deletes the encounter",
      description = "Deletes the specified encounter",
      responses = {
          @ApiResponse(responseCode = "202", 
              description = "The encounter was successfully deleted", 
              content = @Content(mediaType = "application/json", schema = @Schema(implementation = Encounter.class))),
          @ApiResponse(responseCode = "400", 
              description = "The request parameters are invalid", 
               content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404",
              description = "No encounters found with input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
              description = "An unexpected error has occurred",
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "name", allowEmptyValue = true,
              required = false, description = "Name of the encounter")
      })

  @DeleteMapping("/{name}")
  @ResponseStatus(code = HttpStatus.ACCEPTED)
  void removeEncounter(@PathVariable String name);
}
