package sibsutis.sed.sedsibsutisdocument.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sibsutis.sed.sedsibsutisdocument.model.dto.SendDocumentEncrypt;
import sibsutis.sed.sedsibsutisdocument.model.entity.SendDocumentEntity;

@Repository
public interface DocumentRepository extends JpaRepository<SendDocumentEntity, Long> {
    SendDocumentEntity findByDocumentNameAndEmailReceiver(String documentName, String emailReceiver);
}
