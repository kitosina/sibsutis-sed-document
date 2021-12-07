package sibsutis.sed.sedsibsutisdocument.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import sibsutis.sed.sedsibsutisdocument.model.dto.IncomingDocumentEncrypt;
import sibsutis.sed.sedsibsutisdocument.model.dto.SendDocumentEncrypt;
import sibsutis.sed.sedsibsutisdocument.model.dto.SignDocumentEncrypt;
import sibsutis.sed.sedsibsutisdocument.model.entity.SendDocumentEntity;
import sibsutis.sed.sedsibsutisdocument.model.entity.SignInfoDocumentEntity;
import sibsutis.sed.sedsibsutisdocument.repository.DocumentRepository;
import sibsutis.sed.sedsibsutisdocument.repository.SignInfoDocumentRepository;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private SignInfoDocumentRepository signInfoDocumentRepository;

    @Transactional(rollbackFor = Exception.class)
    public void saveSandDocumentEncrypt(SendDocumentEncrypt sendDocument) {
        SendDocumentEntity sendDocumentEntity = convertSendDocumentEncryptToSendDocumentEntity(sendDocument);
        documentRepository.save(sendDocumentEntity);
    }

    public IncomingDocumentEncrypt getIncomingDocument(String documentName, String emailReceiver) {
        SendDocumentEntity sendDocumentEntity =
                documentRepository.findByDocumentNameAndEmailReceiver(documentName, emailReceiver);
        return convertSendDocumentEntityToIncomingDocumentEncrypt(sendDocumentEntity);
    }

    public SignDocumentEncrypt getSignDocument(String documentName, String emailReceiver, boolean signFlag) {
        SignInfoDocumentEntity signInfoDocumentEntity =
                signInfoDocumentRepository.findByDocumentNameAndEmailReceiverAndSignFlag(documentName, emailReceiver, signFlag);
        return convertSendDocumentEntityToSignDocumentEncrypt(signInfoDocumentEntity);
    }

    private SendDocumentEntity convertSendDocumentEncryptToSendDocumentEntity(SendDocumentEncrypt sendDocumentEncrypt) {
        SendDocumentEntity sendDocument = new SendDocumentEntity();
        sendDocument.setEncryptDocument(sendDocumentEncrypt.getEncryptDocumentInfo().getEncryptDocument());
        sendDocument.setEncryptSecretKey(sendDocumentEncrypt.getEncryptDocumentInfo().getEncryptSecretKey());
        sendDocument.setDocumentName(sendDocumentEncrypt.getDocumentName());
        sendDocument.setEmailSender(sendDocumentEncrypt.getEmailSender());
        sendDocument.setEmailReceiver(sendDocumentEncrypt.getEmailReceiver());
        return sendDocument;
    }

    private IncomingDocumentEncrypt convertSendDocumentEntityToIncomingDocumentEncrypt(SendDocumentEntity sendDocument) {
        return IncomingDocumentEncrypt.builder()
                .encryptDocument(sendDocument.getEncryptDocument())
                .encryptSecretKey(sendDocument.getEncryptSecretKey())
                .build();
    }

    private SignDocumentEncrypt convertSendDocumentEntityToSignDocumentEncrypt(SignInfoDocumentEntity signInfoDocumentEntity) {
        return SignDocumentEncrypt.builder()
                .encryptDocument(signInfoDocumentEntity.getEncryptDocument())
                .encryptSecretKey(signInfoDocumentEntity.getEncryptSecretKey())
                .build();
    }
}
