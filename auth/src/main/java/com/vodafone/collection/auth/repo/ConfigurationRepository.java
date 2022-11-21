package com.vodafone.collection.auth.repo;

import com.vodafone.collection.auth.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;




public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {

	Configuration getByKey(String key);

}
