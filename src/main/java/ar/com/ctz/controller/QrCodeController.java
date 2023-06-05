package ar.com.ctz.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

import ar.com.ctz.dto.QrCodeGenerationRequestDto;
import ar.com.ctz.service.QrCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class QrCodeController {

	private final QrCodeService qrCodeService;

	@PostMapping(value = "/generateData")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns a .png QR code with provided information decoded inside")
	public void qrCodeGenerationHandler(
			@Valid @RequestBody(required = true) final QrCodeGenerationRequestDto qrCodeGenerationRequestDto,
			final HttpServletResponse httpServletResponse) throws IOException, WriterException {
		qrCodeService.generateData(qrCodeGenerationRequestDto, httpServletResponse);
	}

	@GetMapping(value = "/qrCode")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns a .png QR code with provided information decoded inside")
	public void qrCodeGeneration(final HttpServletResponse httpServletResponse, String data)
			throws IOException, WriterException {
		qrCodeService.qrCode(data, httpServletResponse);
	}

	@GetMapping(value = "/dataMatrix")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns a .png QR code with provided information decoded inside")
	public void dataMatrixGeneration(final HttpServletResponse httpServletResponse, String data)
			throws IOException, WriterException {
		qrCodeService.dataMatrix(data, httpServletResponse);
	}

	@GetMapping(value = "/pdf417")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns a .png QR code with provided information decoded inside")
	public void pdf417(final HttpServletResponse httpServletResponse, String data) throws IOException, WriterException {
		qrCodeService.pdf417(data, httpServletResponse);
	}

	@PutMapping(value = "/read", consumes = "multipart/form-data")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "returns decoded information inside provided QR code")
	public ResponseEntity<?> read(
			@Parameter(description = ".png image of QR code generated through this portal") @RequestParam(value = "file", required = true) MultipartFile file)
			throws IOException, NotFoundException {
		return qrCodeService.read(file);
	}

}
