package de.afp.java_backend.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.afp.java_backend.model.SubHelper;
import de.afp.java_backend.model.Subforum;
import de.afp.java_backend.model.ThreadModel;

@Repository
public interface SubforumRepo extends JpaRepository<Subforum, Long>{
    @Query(value = "Select thread_model.* FROM thread_model " + 
    "INNER JOIN subforum ON thread_model.sub_forum_id = subforum.sub_forum_id " + 
    //"WHERE sub_name = \"News\"", nativeQuery = true)
    "WHERE sub_name = ?1", nativeQuery = true)
    List<?> getAllThreadsBySubname(String subName); 
}
