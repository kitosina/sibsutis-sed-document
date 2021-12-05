package sibsutis.sed.sedsibsutisdocument.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sibsutis.sed.sedsibsutisdocument.model.dto.SendDocumentEncrypt;
import sibsutis.sed.sedsibsutisdocument.service.DocumentService;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/send")
    public ResponseEntity sendDocument(@RequestBody SendDocumentEncrypt sendDocumentEncrypt) {
        documentService.saveSandDocumentEncrypt(sendDocumentEncrypt);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/incoming")
    public ResponseEntity incomingDocument(@RequestParam("document_name") String documentName,
                                           @RequestParam("email_receiver") String emailReceiver) {
        return ResponseEntity.ok(documentService.getIncomingDocument(documentName, emailReceiver));
    }
}
