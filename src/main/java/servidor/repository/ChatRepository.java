package servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import servidor.domain.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long>{
    
}
