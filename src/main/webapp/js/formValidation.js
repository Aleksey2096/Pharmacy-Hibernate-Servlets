/**
 * Regexp expression to check login validity.
 * Login requirements:
 * 1) Username consists of alphanumeric characters (a-zA-Z0-9), lowercase, or uppercase.
 * 2) Username allowed of the dot (.), underscore (_), and hyphen (-).
 * 3) The dot (.), underscore (_), or hyphen (-) must not be the first or last character.
 * 4) The dot (.), underscore (_), or hyphen (-) does not appear consecutively, e.g.
 * 5) The number of characters must be between 5 and 20.
 * ^[a-zA-Z0-9] # start with an alphanumeric character ( # start of (group 1)
 * [._-](?![._-]) # follow by a dot, hyphen, or underscore, negative # lookahead
 * to ensures dot, hyphen, and underscore # does not appear consecutively | # or
 * [a-zA-Z0-9] # an alphanumeric character ) # end of (group 1) {3,18} # ensures
 * the length of (group 1) between 3 and 18 [a-zA-Z0-9]$ # end with an alphanumeric character
 * # {3,18} plus the first and last alphanumeric # characters, total length became {5,20}
 */
const LOGIN_REGEX = /^[a-zA-Z\d]([._-](?![._-])|[a-zA-Z\d]){3,18}[a-zA-Z\d]$/;
/**
 * Regexp expression to check password validity.
 * Password requirements:
 * 1) Password must contain at least one digit [0-9].
 * 2) Password must contain at least one lowercase Latin character [a-z].
 * 3) Password must contain at least one uppercase Latin character [A-Z].
 * 4) Password must contain at least one special character like ! @ # & ( ).
 * 5) Password must contain a length of at least 8 characters and a maximum of 20 characters.
 * ^ # start of line (?=.*[0-9]) # positive lookahead, digit [0-9] (?=.*[a-z]) #
 * positive lookahead, one lowercase character [a-z] (?=.*[A-Z]) # positive
 * lookahead, one uppercase character [A-Z] (?=.*[!@#&()–[{}]:;',?/*~$^+=<>]) #
 * positive lookahead, one of the special character in this [.] . # matches
 * anything {8,20} # length at least 8 characters and maximum of 20 characters $
 * # end of line
 */
const PASSWORD_REGEX = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}:;',?/*~$^+=<>]).{8,20}$/;
const IMAGE_REGEX = /[\/.](gif|jpg|jpeg|tiff|png)$/i;
const EMAIL_REGEX = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}])|(([a-zA-Z\-\d]+\.)+[a-zA-Z]{2,}))$/;
const LETTERS_REGEX = /^[A-Za-z]+$/;
const POSITIVE_INTEGER_REGEX = /^[1-9]\d{0,8}$/;
const POSITIVE_SHORT_REGEX = /^[1-9]\d{0,3}$/;
const SIXTEEN_DIGITS_REGEX = /^(\d{16})$/
const PRICE_REGEX = /^\d+(\.\d{1,2})?$/;
const PHONE_REGEX = /^\+(\d{11})$/;


let form = document.getElementById("mainForm");

let valueRequired = form.elements["valueRequired"].value.trim();
let valueInvalid = form.elements["valueInvalid"].value.trim();

function validateAdministratorUserForm() {
    let healthCareCardNumberValid = validateRegexp(form.elements["health_care_card_number"], valueRequired, valueInvalid, SIXTEEN_DIGITS_REGEX);
    let dateJoinedValid;
    if (form.elements["date_joined"] === undefined) {
        dateJoinedValid = true;
    } else {
        dateJoinedValid = hasValue(form.elements["date_joined"], valueRequired);
    }
    let loginValid = validateRegexp(form.elements["login"], valueRequired, valueInvalid, LOGIN_REGEX);
    let passwordValid = validateRegexp(form.elements["password"], valueRequired, valueInvalid, PASSWORD_REGEX);
    let imageValid = validateRegexp(form.elements["image"], valueRequired, valueInvalid, IMAGE_REGEX);
    let nameValid = validateRegexp(form.elements["name"], valueRequired, valueInvalid, LETTERS_REGEX);
    let surnameValid = validateRegexp(form.elements["surname"], valueRequired, valueInvalid, LETTERS_REGEX);
    let dateOfBirthValid = hasValue(form.elements["date_of_birth"], valueRequired);
    let phoneValid = validateRegexp(form.elements["phone"], valueRequired, valueInvalid, PHONE_REGEX);
    let emailValid = validateRegexp(form.elements["email"], valueRequired, valueInvalid, EMAIL_REGEX);
    let positionValid = hasValue(form.elements["position"], valueRequired);
    let personalAccountValid = validateRegexp(form.elements["personal_account"], valueRequired, valueInvalid, PRICE_REGEX);
    let paymentCardNumberValid = validateRegexp(form.elements["payment_card_number"], valueRequired, valueInvalid, SIXTEEN_DIGITS_REGEX);
    let postcodeValid = validateRegexp(form.elements["postcode"], valueRequired, valueInvalid, POSITIVE_INTEGER_REGEX);
    let cityValid = validateRegexp(form.elements["city"], valueRequired, valueInvalid, LETTERS_REGEX);
    let streetValid = hasValue(form.elements["street"], valueRequired);
    let houseValid = validateRegexp(form.elements["house"], valueRequired, valueInvalid, POSITIVE_SHORT_REGEX);
    let apartmentValid = validateRegexp(form.elements["apartment"], valueRequired, valueInvalid, POSITIVE_SHORT_REGEX);

    if (healthCareCardNumberValid && dateJoinedValid && loginValid && passwordValid && imageValid
        && nameValid && surnameValid && dateOfBirthValid && phoneValid && emailValid && positionValid
        && personalAccountValid && paymentCardNumberValid && postcodeValid && cityValid && streetValid
        && houseValid && apartmentValid) {
        form.submit();
    }
}

function validateCart() {
    let paymentCardNumberValid = validateRegexp(form.elements["payment_card_number"], valueRequired, valueInvalid, SIXTEEN_DIGITS_REGEX);
    let contactPhoneValid = validateRegexp(form.elements["contact_phone"], valueRequired, valueInvalid, PHONE_REGEX);
    let deliveryAddressValid = hasValue(form.elements["delivery_address"], valueRequired);

    if (paymentCardNumberValid && contactPhoneValid && deliveryAddressValid) {
        checkout();
    }
}

function validatePrescriptionRequest() {
    let imageValid = validateRegexp(form.elements["image"], valueRequired, valueInvalid, IMAGE_REGEX);

    if (imageValid) {
        form.submit();
    }
}

function validateMedicineProduct() {
    let dosageValid = validateRegexp(form.elements["dosage"], valueRequired, valueInvalid, POSITIVE_SHORT_REGEX);
    let priceValid = validateRegexp(form.elements["price"], valueRequired, valueInvalid, PRICE_REGEX);
    let amountValid = validateRegexp(form.elements["amount"], valueRequired, valueInvalid, POSITIVE_INTEGER_REGEX);

    if (dosageValid && priceValid && amountValid) {
        form.submit();
    }
}

function validateMedicine() {
    let titleValid = hasValue(form.elements["title"], valueRequired);
    let approvalDateValid = hasValue(form.elements["approval_date"], valueRequired);
    let imageValid = validateRegexp(form.elements["image"], valueRequired, valueInvalid, IMAGE_REGEX);

    if (titleValid && approvalDateValid && imageValid) {
        form.submit();
    }
}

function validatePrescription() {
    let healthCareCardNumberValid = validateRegexp(form.elements["health_care_card_number"], valueRequired, valueInvalid, SIXTEEN_DIGITS_REGEX);
    let medicineProductIdValid = validateRegexp(form.elements["medicine_product_id"], valueRequired, valueInvalid, POSITIVE_INTEGER_REGEX);
    let amountValid = validateRegexp(form.elements["amount"], valueRequired, valueInvalid, POSITIVE_INTEGER_REGEX);
    let dateValid = hasValue(form.elements["date"], valueRequired);

    if (healthCareCardNumberValid && medicineProductIdValid && amountValid && dateValid) {
        form.submit();
    }
}

function validateProducer() {
    let companyNameValid = hasValue(form.elements["companyName"], valueRequired);
    let creationDateValid = hasValue(form.elements["creationDate"], valueRequired);

    if (companyNameValid && creationDateValid) {
        form.submit();
    }
}


// show a message with a type of the input
function showMessage(input, message, type) {
    // get the small element and set the message
    const msg = input.parentNode.querySelector("span");
    msg.innerText = message;
    // update the class for the input
    input.classList.add(type ? "success" : "error");
    input.classList.remove(type ? "error" : "success");
    return type;
}

function showError(input, message) {
    return showMessage(input, message, false);
}

function showSuccess(input) {
    return showMessage(input, "", true);
}

function hasValue(input, message) {
    if (input.value.trim() === "") {
        return showError(input, message);
    }
    return showSuccess(input);
}

function validateRegexp(input, requiredMsg, invalidMsg, regexp) {
    // check if the value is not empty
    if (!hasValue(input, requiredMsg)) {
        return false;
    }

    const value = input.value.trim();
    if (!regexp.test(value)) {
        return showError(input, invalidMsg);
    }
    return true;
}

