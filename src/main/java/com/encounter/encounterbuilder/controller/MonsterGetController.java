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
@RequestMapping("/monsters")
public interface MonsterGetController {
  @Operation(
      summary = "Returns the monsters of a type",
      description = "Returns the specified type of monster",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "The monster list was returned sucessfully", 
              content = @Content(mediaType = "application/json", schema = @Schema(implementation = Encounter.class))),
          @ApiResponse(responseCode = "400", 
              description = "The request parameters are invalid", 
               content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
              description = "No monsters found with input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
              description = "An unexpected error has occurred",
              content = @Content(mediaType = "application/json"))
      }
      //,
//      parameters = {
//          @Parameter(name = "id", allowEmptyValue = true,
//              required = false, description = "Number of the monster"),
//          @Parameter(name = "name", allowEmptyValue = true,
//              required = false, description = "Name of the monster")
//      }
      )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Monster> fetchMonstersOfType(CreatureType type);
}
