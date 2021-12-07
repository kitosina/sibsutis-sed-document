package sibsutis.sed.sedsibsutisdocument.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sibsutis.sed.sedsibsutisdocument.model.dto.SendDocumentEncrypt;
import sibsutis.sed.sedsibsutisdocument.model.entity.SignInfoDocumentEntity;
import sibsutis.sed.sedsibsutisdocument.repository.SignInfoDocumentRepository;

@Service
public class SignService {

    @Autowired
    private SignInfoDocumentRepository signInfoDocumentRepository;

    @Transactional(rollbackFor = Exception.class)
    public void signDocument(SendDocumentEncrypt sendDocumentEncrypt) {
        SignInfoDocumentEntity signInfoDocumentEntity =
                covertSendDocumentEncryptToSignInfoDocumentEntity(sendDocumentEncrypt);
        signInfoDocumentEntity.setSignFlag(true);
        signInfoDocumentRepository.save(signInfoDocumentEntity);
    }

    public void noSignDocument(SendDocumentEncrypt sendDocumentEncrypt) {
        SignInfoDocumentEntity signInfoDocumentEntity =
                covertSendDocumentEncryptToSignInfoDocumentEntity(sendDocumentEncrypt);
        signInfoDocumentEntity.setSignFlag(false);
        signInfoDocumentRepository.save(signInfoDocumentEntity);
    }

    private SignInfoDocumentEntity covertSendDocumentEncryptToSignInfoDocumentEntity(
            SendDocumentEncrypt sendDocumentEncrypt) {
        SignInfoDocumentEntity signInfoDocumentEntity = new SignInfoDocumentEntity();
        signInfoDocumentEntity.setEncryptDocument(sendDocumentEncrypt.getEncryptDocumentInfo().getEncryptDocument());
        signInfoDocumentEntity.setEncryptSecretKey(sendDocumentEncrypt.getEncryptDocumentInfo().getEncryptSecretKey());
        signInfoDocumentEntity.setDocumentName(sendDocumentEncrypt.getDocumentName());
        signInfoDocumentEntity.setEmailSender(sendDocumentEncrypt.getEmailSender());
        signInfoDocumentEntity.setEmailReceiver(sendDocumentEncrypt.getEmailReceiver());
        return signInfoDocumentEntity;
    }

}
