package com.example.controllercondocumentazione;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class NameController {
    @GetMapping("/yourName")
    @Operation(description = "stampa il nome immesso come parametro", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses ({
            @ApiResponse(responseCode = "200", description = "parametro correttamente inserito"),
            @ApiResponse(responseCode = "500", description = "nessun nome inserito")
    })
    public String returnName (@RequestParam String name) {
        return name;
    }
    @PostMapping("yourName")
    @Operation(description = "stampa il parametro al contrario")
    @ApiResponses ({
            @ApiResponse(responseCode = "200", description = "inversione effetuata con successo"),
            @ApiResponse(responseCode = "500", description = "parametro mancante")
    })
    public String returnReverseName (@RequestParam String name) {
        StringBuilder buildName = new StringBuilder(name);
        String reverseName = buildName.reverse().toString();
        return reverseName;
    }
}