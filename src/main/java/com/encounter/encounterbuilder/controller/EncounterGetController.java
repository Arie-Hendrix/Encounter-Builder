package com.encounter.encounterbuilder.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.encounter.encounterbuilder.entity.CreatureType;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.Monster;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/encounters")
public interface EncounterGetController {
  @Operation(
      summary = "Returns the encounter",
      description = "Returns the specified encounter number/name",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "The encounter list was returned sucessfully", 
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
          //@Parameter(name = "id", allowEmptyValue = true,
          //    required = false, description = "Number of the encounter"),
          @Parameter(name = "name", allowEmptyValue = true,
              required = false, description = "Name of the encounter")
      })
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  Encounter fetchEncounters(String name);
  List<Monster> fetchMonstersOfType(CreatureType type);
}
