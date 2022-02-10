package com.encounter.encounterbuilder.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.Character;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/characters")
public interface CharacterGetController {
  @Operation(
      summary = "Returns the characters",
      description = "Returns the list of player characters available",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "The character list was returned sucessfully", 
              content = @Content(mediaType = "application/json", schema = @Schema(implementation = Encounter.class))),
          @ApiResponse(responseCode = "400", 
              description = "The request parameters are invalid", 
               content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", 
              description = "No characters found with input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
              description = "An unexpected error has occurred",
              content = @Content(mediaType = "application/json"))
      }
//      ,
//      parameters = {
//          @Parameter(name = "id", allowEmptyValue = true,
//              required = false, description = "Number of the character"),
//          @Parameter(name = "name", allowEmptyValue = true,
//              required = false, description = "Name of the character")
//      }
      )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Character> fetchAllPlayerCharacters();
}
