package com.encounter.encounterbuilder.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.encounter.encounterbuilder.entity.Encounter;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/update")
@OpenAPIDefinition(info = @Info(title = "Encounter Builder"), 
servers = {@Server(url = "http://localhost:8080", description = "Local Server")})
public interface EncounterUpdateController {

  // @formatter:off
  @Operation(
      summary = "Updates the encounter",
      description = "Updates the name of the encounter",
      responses = {
          @ApiResponse(responseCode = "201", 
              description = "The encounter was updated sucessfully", 
              content = @Content(mediaType = "application/json", schema = @Schema(implementation = Encounter.class))),
          @ApiResponse(responseCode = "400", 
              description = "The request parameters are invalid", 
               content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
              description = "No encounter found with input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
              description = "An unexpected error has occurred",
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "name", allowEmptyValue = false,
              required = true, description = "Name of the encounter to update"),
          @Parameter(name = "newName", allowEmptyValue = false,
              required = false, description = "New name for the encounter")
      }
     )
  
  @PatchMapping("/{name}")
  @ResponseStatus(code = HttpStatus.CREATED)
  Encounter updateEncounter(@Valid @RequestBody String newName, @PathVariable String name);
}
