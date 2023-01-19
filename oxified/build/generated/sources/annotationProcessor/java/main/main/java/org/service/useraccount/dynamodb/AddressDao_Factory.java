package main.java.org.service.useraccount.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AddressDao_Factory implements Factory<AddressDao> {
  private final Provider<DynamoDBMapper> dynamoDBMapperProvider;

  public AddressDao_Factory(Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    this.dynamoDBMapperProvider = dynamoDBMapperProvider;
  }

  @Override
  public AddressDao get() {
    return newInstance(dynamoDBMapperProvider.get());
  }

  public static AddressDao_Factory create(Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    return new AddressDao_Factory(dynamoDBMapperProvider);
  }

  public static AddressDao newInstance(DynamoDBMapper dynamoDBMapper) {
    return new AddressDao(dynamoDBMapper);
  }
}
