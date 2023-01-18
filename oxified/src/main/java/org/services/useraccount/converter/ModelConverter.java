package main.java.org.services.useraccount.converter;

import main.java.org.services.useraccount.dynamodb.model.Address;
import main.java.org.services.useraccount.dynamodb.model.UserAccount;
import main.java.org.services.useraccount.model.AddressModel;
import main.java.org.services.useraccount.model.UserAccountModel;

public class ModelConverter {
    public AddressModel toAddressModel(Address address) {
        return AddressModel.builder()
                .withAddressId(address.getAddressId())
                .withhouseNumber(address.getHouseNumber())
                .withBaranggay(address.getBaranggay())
                .withCity(address.getCity())
                .withBlockNumber(address.getBlockNumber())
                .withLotNumber(address.getLotNumber())
                .withProvince(address.getProvince())
                .withStreet(address.getStreet())
                .withZipcode(address.getZipCode())
                .build();
    }

    public UserAccountModel toUserAccountModel(UserAccount userAccount) {

        return UserAccountModel.builder()
                .withUaId(userAccount.getUaId())
                .withUserType(userAccount.getUserType())
                .withAccountStatus(userAccount.getAccountStatus())
                .withAddressId(userAccount.getAddressId())
                .withBirthDate(userAccount.getBirthdate())
                .withEmail(userAccount.getEmail())
                .withPassword(userAccount.getPassword())
                .withStatus(userAccount.getStatus())
                .withLastName(userAccount.getLastName())
                .withFirstName(userAccount.getFirstName())
                .withContactNumber(userAccount.getContactNumber())
                .withAvailability(userAccount.getAvailability())
                .withBackgroundChecked(userAccount.getBackgroundChecked())
                .withExperience(userAccount.getExperience())
                .withBookingId(userAccount.getBookingId())
                .withGender(userAccount.getGender())
                .withInbox(userAccount.getInbox())
                .withBusinessHours(userAccount.getBusinessHours())
                .build();
    }
}
