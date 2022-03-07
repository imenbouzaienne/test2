package com.sip.ams.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sip.ams.entities.Provider;
import com.sip.ams.entities.Article;
import java.util.*;
@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {
	@Query("FROM Article a WHERE a.provider.id = ?1")
	List<Article> findArticlesByProvider(long id);

}
