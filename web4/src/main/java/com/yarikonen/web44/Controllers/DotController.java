package com.yarikonen.web44.Controllers;


import com.yarikonen.web44.Annotations.LogEntryExit;
import com.yarikonen.web44.Data.Dot;
import com.yarikonen.web44.Services.DotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@RestController
public class DotController {
    DotService dotService;
    @Autowired
    DotController(DotService dotService){
        this.dotService = dotService;

    }
    @LogEntryExit(showResult = true)
    @GetMapping("/dots")
    public List<Dot> getDots(){
        return List.of(new Dot(1L,1,1,1, LocalTime.now(),true,1));
    }
    @LogEntryExit(showArgs = true)
    @PostMapping("/dots/newDot")
    public ResponseEntity<String> addDot(@RequestBody Dot dot){
        dotService.addDot(dot);
        return ResponseEntity.ok("Dot is valid");
    }
}
