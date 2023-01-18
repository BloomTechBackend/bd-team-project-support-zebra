package main.java.org.service.useraccount.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.oxified.useraccount.service.dynamodb.model.Address;

public class AddressDao {
    private final DynamoDBMapper dynamoDBMapper;

    public AddressDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Address getAddress(String addressId) {
        return dynamoDBMapper.load(Address.class, addressId);
    }
}
