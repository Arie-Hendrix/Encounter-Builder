package com.encounter.encounterbuilder.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.EncounterRequest;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/builder")
@OpenAPIDefinition(info = @Info(title = "Encounter Builder"), 
servers = {@Server(url = "http://localhost:8080", description = "Local Server")})
public interface EncounterPostController {
  
//@formatter:off
 @Operation(
     summary = "Creates a new encounter",
     description = "Creates a new encounter with the options supplied",
     responses = {
         @ApiResponse(responseCode = "201", 
             description = "The created encounter was returned", 
             content = @Content(mediaType = "application/json", schema = @Schema(implementation = Encounter.class))),
         @ApiResponse(responseCode = "400", 
             description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
         @ApiResponse(responseCode = "404", 
             description = "An encounter component was not found with input criteria", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(responseCode = "500", 
             description = "An unexpected error has occurred",
             content = @Content(mediaType = "application/json"))
     },
     parameters = {
         @Parameter(name = "name", allowEmptyValue = false, required = true, 
             description = "Enter a name for the new encounter")
     }
    )

 @PostMapping("/{name}")
 @ResponseStatus(code = HttpStatus.CREATED)
 Encounter createEncounter(@Valid @RequestBody EncounterRequest request,@RequestParam String name);

 // @formatter:on

}
