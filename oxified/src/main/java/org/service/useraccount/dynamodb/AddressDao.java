package main.java.org.service.useraccount.dynamodb;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.org.service.useraccount.dynamodb.model.Address;

import javax.inject.Inject;

public class AddressDao {
    private final DynamoDBMapper dynamoDBMapper;
    @Inject
    public AddressDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Address getAddress(String addressId) {
        return dynamoDBMapper.load(Address.class, addressId);
    }
}
