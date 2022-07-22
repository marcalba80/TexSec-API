package servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import servidor.domain.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long>{
    @Query(
        "SELECT CASE WHEN(COUNT(*) > 0) THEN TRUE ELSE FALSE END " +
        "FROM Chat c " +
        "WHERE c.user1.username IN (:user1, :user2) " +
        "AND c.user2.username IN (:user1, :user2)"
    )
    public boolean chatExists(@Param("user1") String user1, @Param("user2") String user2);
}
