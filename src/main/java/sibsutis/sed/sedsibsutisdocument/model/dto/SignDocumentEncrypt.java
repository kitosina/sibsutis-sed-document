package sibsutis.sed.sedsibsutisdocument.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignDocumentEncrypt {

    @JsonProperty("encrypt_document")
    private byte[] encryptDocument;

    @JsonProperty("encrypt_secret_key")
    private byte[] encryptSecretKey;

}
