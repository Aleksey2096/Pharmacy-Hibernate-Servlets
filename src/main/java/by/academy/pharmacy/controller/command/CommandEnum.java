package by.academy.pharmacy.controller.command;

import by.academy.pharmacy.controller.command.impl.ChangeLanguageCommand;
import by.academy.pharmacy.controller.command.impl.GetLoginFormCommand;
import by.academy.pharmacy.controller.command.impl.LoginCommand;
import by.academy.pharmacy.controller.command.impl.LogoutCommand;
import by.academy.pharmacy.controller.command.impl.medicine.DeleteMedicineCommand;
import by.academy.pharmacy.controller.command.impl.medicine.GetMedicineCreateFormCommand;
import by.academy.pharmacy.controller.command.impl.medicine.GetMedicineEditFormCommand;
import by.academy.pharmacy.controller.command.impl.medicine.ReadPaginatedClientMedicinesCommand;
import by.academy.pharmacy.controller.command.impl.medicine.ReadPaginatedMedicinesCommand;
import by.academy.pharmacy.controller.command.impl.medicine.SaveNewMedicineCommand;
import by.academy.pharmacy.controller.command.impl.medicine.SaveUpdatedMedicineCommand;
import by.academy.pharmacy.controller.command.impl.medicineProduct.DeleteMedicineProductCommand;
import by.academy.pharmacy.controller.command.impl.medicineProduct.GetMedicineProductCreateFormCommand;
import by.academy.pharmacy.controller.command.impl.medicineProduct.GetMedicineProductEditFormCommand;
import by.academy.pharmacy.controller.command.impl.medicineProduct.ReadPaginatedConcreteMedicineProductsCommand;
import by.academy.pharmacy.controller.command.impl.medicineProduct.ReadPaginatedMedicineProductsCommand;
import by.academy.pharmacy.controller.command.impl.medicineProduct.SaveNewMedicineProductCommand;
import by.academy.pharmacy.controller.command.impl.medicineProduct.SaveUpdatedMedicineProductCommand;
import by.academy.pharmacy.controller.command.impl.order.ReadPaginatedOrdersCommand;
import by.academy.pharmacy.controller.command.impl.order.ReadPaginatedUserOrdersCommand;
import by.academy.pharmacy.controller.command.impl.prescription.GetPrescriptionCreateFormCommand;
import by.academy.pharmacy.controller.command.impl.prescription.ReadPaginatedUserPrescriptionsCommand;
import by.academy.pharmacy.controller.command.impl.prescriptionRequest.ApprovePrescriptionRequestCommand;
import by.academy.pharmacy.controller.command.impl.prescriptionRequest.DismissPrescriptionRequestCommand;
import by.academy.pharmacy.controller.command.impl.prescriptionRequest.GetPrescriptionRequestCreateFormCommand;
import by.academy.pharmacy.controller.command.impl.prescriptionRequest.ProcessPaginatedPrescriptionRequestsCommand;
import by.academy.pharmacy.controller.command.impl.prescriptionRequest.ReadPaginatedPrescriptionRequestsCommand;
import by.academy.pharmacy.controller.command.impl.prescriptionRequest.ReadPaginatedUserPrescriptionRequestsCommand;
import by.academy.pharmacy.controller.command.impl.prescriptionRequest.SaveNewPrescriptionRequestCommand;
import by.academy.pharmacy.controller.command.impl.producer.DeleteProducerCommand;
import by.academy.pharmacy.controller.command.impl.producer.GetProducerCreateFormCommand;
import by.academy.pharmacy.controller.command.impl.producer.GetProducerEditFormCommand;
import by.academy.pharmacy.controller.command.impl.producer.ReadPaginatedProducersCommand;
import by.academy.pharmacy.controller.command.impl.producer.SaveNewProducerCommand;
import by.academy.pharmacy.controller.command.impl.producer.SaveUpdatedProducerCommand;
import by.academy.pharmacy.controller.command.impl.user.AddToCartCommand;
import by.academy.pharmacy.controller.command.impl.user.DeleteFromCartCommand;
import by.academy.pharmacy.controller.command.impl.user.DeleteUserCommand;
import by.academy.pharmacy.controller.command.impl.user.GetUserCreateFormCommand;
import by.academy.pharmacy.controller.command.impl.user.GetUserEditFormCommand;
import by.academy.pharmacy.controller.command.impl.user.MakeOrderCommand;
import by.academy.pharmacy.controller.command.impl.user.ReadCartCommand;
import by.academy.pharmacy.controller.command.impl.user.ReadPaginatedUsersCommand;
import by.academy.pharmacy.controller.command.impl.user.SaveNewUserCommand;
import by.academy.pharmacy.controller.command.impl.user.SaveUpdatedUserCommand;

public enum CommandEnum {
    MAKE_ORDER(new MakeOrderCommand()), ADD_TO_CART(new AddToCartCommand()),
    GET_MEDICINE_EDIT_FORM(new GetMedicineEditFormCommand()),
    READ_CART(new ReadCartCommand()),
    GET_MEDICINE_CREATE_FORM(new GetMedicineCreateFormCommand()),
    DELETE_FROM_CART(new DeleteFromCartCommand()),
    SAVE_NEW_MEDICINE(new SaveNewMedicineCommand()),
    READ_PAGINATED_MEDICINES(new ReadPaginatedMedicinesCommand()),
    READ_PAGINATED_CLIENT_MEDICINES(new ReadPaginatedClientMedicinesCommand()),
    SAVE_UPDATED_MEDICINE(new SaveUpdatedMedicineCommand()),
    DELETE_MEDICINE(new DeleteMedicineCommand()),
    GET_MEDICINE_PRODUCT_EDIT_FORM(new GetMedicineProductEditFormCommand()),
    GET_MEDICINE_PRODUCT_CREATE_FORM(new GetMedicineProductCreateFormCommand()),
    SAVE_NEW_MEDICINE_PRODUCT(new SaveNewMedicineProductCommand()),
    READ_PAGINATED_MEDICINE_PRODUCTS(
            new ReadPaginatedMedicineProductsCommand()),
    READ_PAGINATED_CONCRETE_MEDICINE_PRODUCTS(
            new ReadPaginatedConcreteMedicineProductsCommand()),
    SAVE_UPDATED_MEDICINE_PRODUCT(new SaveUpdatedMedicineProductCommand()),
    DELETE_MEDICINE_PRODUCT(new DeleteMedicineProductCommand()),
    SAVE_NEW_PRESCRIPTION_REQUEST(new SaveNewPrescriptionRequestCommand()),
    /**
     * command for receiving producer edit form.
     */
    GET_PRODUCER_EDIT_FORM(new GetProducerEditFormCommand()),
    /**
     * command for receiving producer new form.
     */
    GET_PRODUCER_CREATE_FORM(new GetProducerCreateFormCommand()),
    /**
     * command for creating new entities in database.
     */
    SAVE_NEW_PRODUCER(new SaveNewProducerCommand()),
    /**
     * command for reading entities from database.
     */
    READ_PAGINATED_PRODUCERS(new ReadPaginatedProducersCommand()),
    /**
     * command for updating entities in database.
     */
    SAVE_UPDATED_PRODUCER(new SaveUpdatedProducerCommand()),
    /**
     * command for deleting entities in database.
     */
    DELETE_PRODUCER(new DeleteProducerCommand()),
    CHANGE_LANGUAGE(new ChangeLanguageCommand()),
    GET_LOGIN_FORM(new GetLoginFormCommand()),
    LOGIN(new LoginCommand()), LOGOUT(new LogoutCommand()),
    DELETE_USER(new DeleteUserCommand()),
    GET_USER_CREATE_FORM(new GetUserCreateFormCommand()),
    GET_USER_EDIT_FORM(new GetUserEditFormCommand()),
    READ_PAGINATED_USERS(new ReadPaginatedUsersCommand()),
    READ_PAGINATED_ORDERS(new ReadPaginatedOrdersCommand()),
    READ_PAGINATED_PRESCRIPTION_REQUESTS(
            new ReadPaginatedPrescriptionRequestsCommand()),
    PROCESS_PAGINATED_PRESCRIPTION_REQUESTS(
            new ProcessPaginatedPrescriptionRequestsCommand()),
    DISMISS_PRESCRIPTION_REQUEST(new DismissPrescriptionRequestCommand()),
    APPROVE_PRESCRIPTION_REQUEST(new ApprovePrescriptionRequestCommand()),
    GET_PRESCRIPTION_CREATE_FORM(new GetPrescriptionCreateFormCommand()),
    READ_PAGINATED_USER_PRESCRIPTIONS(
            new ReadPaginatedUserPrescriptionsCommand()),
    READ_PAGINATED_USER_PRESCRIPTION_REQUESTS(
            new ReadPaginatedUserPrescriptionRequestsCommand()),
    READ_PAGINATED_USER_ORDERS(new ReadPaginatedUserOrdersCommand()),
    GET_PRESCRIPTION_REQUEST_CREATE_FORM(
            new GetPrescriptionRequestCreateFormCommand()),
    SAVE_NEW_USER(new SaveNewUserCommand()),
    SAVE_UPDATED_USER(new SaveUpdatedUserCommand());

    /**
     * Command implementation.
     */
    private final Command command;

    /**
     * CommandEnum initialization.
     *
     * @param newCommand command
     */
    CommandEnum(final Command newCommand) {
        command = newCommand;
    }

    /**
     * @return command implementation from enum.
     */
    public Command getCommand() {
        return command;
    }
}
