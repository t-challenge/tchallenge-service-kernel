package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.time.Instant;
import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.tsystems.tchallenge.service.kernel.generic.repository.OrdinalEntityRepository;

public interface TaskRepository extends OrdinalEntityRepository<Task> {

    // TODO: add method for task selection

    @Query("SELECT DISTINCT t FROM Task AS t " +
            "JOIN t.categories AS cat " +
//            "JOIN t.tags AS tag " +
            "JOIN t.authors AS auth " +
            "WHERE t.question LIKE :text " +
//            "AND tag.id IN :tags " +
            "AND cat.id IN :categories " +
            "AND t.difficulty.id IN :difficulties " +
            "AND auth.account.login IN :authors " +
            "AND t.status.id NOT IN ('DELETED')")
    Page<Task> findPage(@Param("text") String text,
                        //@Param("tags") Collection<String> tags,
                        @Param("categories") Collection<String> categories,
                        @Param("difficulties") Collection<String> difficulties,
                        @Param("authors") Collection<String> authors,
                        Pageable pageable);

    @Override
    @Query("SELECT t FROM Task AS t " +
            "WHERE t.id = :id " +
            "AND t.status.id NOT IN ('DELETED')")
    Task findById(@Param("id") Long id);

    @Query("SELECT DISTINCT t FROM Task AS t " +
            "JOIN t.categories AS cat " +
            "WHERE cat.id IN :categories " +
            "AND t.difficulty.id IN :difficulties " +
            "AND t.status.id NOT IN ('DELETED')")
    Collection<Task> findSelection(@Param("categories") Collection<String> categories,
                                   @Param("difficulties") Collection<String> difficulties);

    // TODO: remove this method
    Collection<Task> findAll();
}
