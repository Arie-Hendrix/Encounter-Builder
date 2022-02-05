package com.encounter.encounterbuilder.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.service.EncounterGetService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/encounters")
@Slf4j
public class DefaultEncounterGetController implements EncounterGetController {
  
  @Autowired
  private EncounterGetService encounterService;

  @Override
  public List<Encounter> fetchEncounters() {
    
    return encounterService.fetchEncounters();
  }
}
