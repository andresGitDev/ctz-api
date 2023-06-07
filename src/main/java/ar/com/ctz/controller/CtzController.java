package ar.com.ctz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ctz.entity.Dollar;
import ar.com.ctz.service.CtzService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CtzController {
	
	@Autowired
	private final CtzService ctzService;
	
	@GetMapping(value = "/ctzDollarPrices")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns a list with the information of the quote types that can be consulted")
	public ResponseEntity<List<Dollar>> ctzGetDollarPrices() {
		return ResponseEntity.ok(ctzService.getDollarPrices());
	}

}
