package sibsutis.sed.sedsibsutisdocument.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sibsutis.sed.sedsibsutisdocument.model.entity.SendDocumentEntity;
import sibsutis.sed.sedsibsutisdocument.model.entity.SignInfoDocumentEntity;

@Repository
public interface SignInfoDocumentRepository extends JpaRepository<SignInfoDocumentEntity, Long> {
    SignInfoDocumentEntity findByDocumentNameAndEmailReceiverAndSignFlag(String documentName,
                                                                         String emailReceiver,
                                                                         boolean signFlag);
}
