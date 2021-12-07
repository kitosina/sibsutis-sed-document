package sibsutis.sed.sedsibsutisdocument.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sibsutis.sed.sedsibsutisdocument.model.dto.SendDocumentEncrypt;
import sibsutis.sed.sedsibsutisdocument.service.SignService;

@RequestMapping("/sign")
@RestController
public class SignController {

    @Autowired
    private SignService signService;

    @PostMapping("/document")
    public ResponseEntity signDocument(@RequestBody SendDocumentEncrypt sendDocumentEncrypt) {
        signService.signDocument(sendDocumentEncrypt);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/document/no")
    public ResponseEntity noSignDocument(@RequestBody SendDocumentEncrypt sendDocumentEncrypt) {
        signService.noSignDocument(sendDocumentEncrypt);
        return ResponseEntity.ok().build();
    }

}
