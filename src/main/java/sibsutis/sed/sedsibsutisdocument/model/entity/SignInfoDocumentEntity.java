package sibsutis.sed.sedsibsutisdocument.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "sign_info_document_encrypt", schema = "document_encrypt")
public class SignInfoDocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "email_sender")
    private String emailSender;

    @Column(name = "email_receiver")
    private String emailReceiver;

    @Column(name = "encrypt_document")
    private byte[] encryptDocument;

    @Column(name = "encrypt_secret_key")
    private byte[] encryptSecretKey;

    @Column(name = "sign_flag")
    private boolean signFlag;

}
