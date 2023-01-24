package main.java.org.service.spservice.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.org.service.spservice.dynamodb.models.Service;

import javax.inject.Inject;

public class ServiceDao {
    private DynamoDBMapper dynamoDBMapper;
    @Inject
    public ServiceDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Service getService(String serviceId, String uaId) {
        return dynamoDBMapper.load(Service.class, serviceId, uaId);
    }

    public Service saveService(Service service) {
        dynamoDBMapper.save(service);
        return service;
    }
}
