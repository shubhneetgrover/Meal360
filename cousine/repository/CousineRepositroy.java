package com.meal360.web.cousine.repository;

import com.meal360.web.cousine.model.CousineModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CousineRepositroy extends MongoRepository<CousineModel,String> {
}
