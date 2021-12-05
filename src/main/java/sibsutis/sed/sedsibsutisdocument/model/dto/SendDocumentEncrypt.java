package sibsutis.sed.sedsibsutisdocument.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
public class SendDocumentEncrypt {

    @JsonProperty("document_name")
    private String documentName;

    @JsonProperty("email_sender")
    private String emailSender;

    @JsonProperty("email_receiver")
    private String emailReceiver;

    @JsonProperty("encrypt_document_info")
    private EncryptDocumentInfo encryptDocumentInfo;

    @Data
    @NoArgsConstructor
    public static class EncryptDocumentInfo {

        private byte[] encryptDocument;

        private byte[] encryptSecretKey;

    }

}
