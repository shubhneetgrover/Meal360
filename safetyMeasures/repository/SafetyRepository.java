package com.meal360.web.safetyMeasures.repository;

import com.meal360.web.safetyMeasures.model.SafetyMeasures;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SafetyRepository extends MongoRepository<SafetyMeasures, String> {
}
