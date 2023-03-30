package by.academy.pharmacy.entity;

/**
 * constants storage.
 */
public final class Constant {
    /**
     * name of persistence unit, depending on profile.
     */
    public static final String PERSISTENCE_UNIT_NAME = "persistenceUnitName";
    /**
     * properties, containing name of persistence unit.
     */
    public static final String PERSISTENCE_UNIT_PROPERTIES
            = "persistenceUnit.properties";
    /**
     * name of mysql driver.
     */
    public static final String COM_MYSQL_CJ_JDBC_DRIVER
            = "com.mysql.cj.jdbc.Driver";
    /**
     * gets all objects of concrete hibernate entity.
     */
    public static final String FROM_HIBERNATE_CLASS = "FROM %s";
    /**
     * SuppressWarnings type.
     */
    public static final String UNCHECKED = "unchecked";
    /**
     * web application encoding.
     */
    public static final String ENCODING = "encoding";
    /**
     * http request parameter title.
     */
    public static final String COMMAND = "command";
    /**
     * path to default web page.
     */
    public static final String INDEX_JSP = "/index.jsp";
    /**
     * path to web page, containing collection of all producers.
     */
    public static final String JSP_PHARMACIST_PRODUCERS_INDEX_JSP
            = "/jsp/pharmacist/producers/index.jsp";
    /**
     * path to jsp, which updates entities.
     */
    public static final String JSP_PHARMACIST_PRODUCERS_EDIT_JSP
            = "/jsp/pharmacist/producers/edit.jsp";
    /**
     * path to jsp, which creates new entities.
     */
    public static final String JSP_PHARMACIST_PRODUCERS_NEW_JSP
            = "/jsp/pharmacist/producers/new.jsp";
    public static final String JSP_PHARMACIST_MEDICINES_NEW_JSP
            = "/jsp/pharmacist/medicines/new.jsp";
    public static final String JSP_PHARMACIST_MEDICINES_EDIT_JSP
            = "/jsp/pharmacist/medicines/edit.jsp";
    public static final String JSP_PHARMACIST_MEDICINES_INDEX_JSP
            = "/jsp/pharmacist/medicines/index.jsp";
    public static final String JSP_PHARMACIST_MEDICINE_PRODUCTS_NEW_JSP
            = "/jsp/pharmacist/medicineProducts/new.jsp";
    public static final String JSP_PHARMACIST_MEDICINE_PRODUCTS_EDIT_JSP
            = "/jsp/pharmacist/medicineProducts/edit.jsp";
    public static final String JSP_PHARMACIST_MEDICINE_PRODUCTS_INDEX_JSP
            = "/jsp/pharmacist/medicineProducts/index.jsp";
    public static final String JSP_ADMINISTRATOR_USERS_NEW_JSP
            = "/jsp/administrator/users/new.jsp";
    public static final String JSP_ADMINISTRATOR_USERS_EDIT_JSP
            = "/jsp/administrator/users/edit.jsp";
    public static final String JSP_ADMINISTRATOR_USERS_INDEX_JSP
            = "/jsp/administrator/users/index.jsp";
    public static final String JSP_ADMINISTRATOR_ORDERS_INDEX_JSP
            = "/jsp/administrator/orders/index.jsp";
    public static final String JSP_ADMINISTRATOR_PRESCRIPTION_REQUESTS_INDEX_JSP
            = "/jsp/administrator/prescriptionRequests/index.jsp";
    public static final String JSP_PHARMACIST_PRESCRIPTION_REQUESTS_INDEX_JSP
            = "/jsp/pharmacist/prescriptionRequests/index.jsp";
    public static final String JSP_PHARMACIST_PRESCRIPTIONS_NEW_JSP
            = "/jsp/pharmacist/prescriptions/new.jsp";
    public static final String JSP_CLIENT_PRESCRIPTIONS_INDEX_JSP
            = "/jsp/client/prescriptions/index.jsp";
    public static final String JSP_CLIENT_PRESCRIPTION_REQUESTS_INDEX_JSP
            = "/jsp/client/prescriptionRequests/index.jsp";
    public static final String JSP_CLIENT_PRESCRIPTION_REQUESTS_NEW_JSP
            = "/jsp/client/prescriptionRequests/new.jsp";
    public static final String JSP_CLIENT_ORDERS_INDEX_JSP
            = "/jsp/client/orders/index.jsp";
    public static final String JSP_CLIENT_MEDICINES_INDEX_JSP
            = "/jsp/client/medicines/index.jsp";
    public static final String JSP_CLIENT_MEDICINE_PRODUCTS_INDEX_JSP
            = "/jsp/client/medicineProducts/index.jsp";
    public static final String JSP_CLIENT_ORDERS_CART_JSP
            = "/jsp/client/orders/cart.jsp";

    /**
     * path to jsp, which logs in system.
     */
    public static final String JSP_COMMON_LOGIN_JSP = "/jsp/common/login.jsp";
    /**
     * table title.
     */
    public static final String PRODUCER = "producer";
    /**
     * Holds pattern for Date object value.
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * session UserDTO attribute title.
     */
    public static final String USER = "user";
    /**
     * session attribute or request parameter holding link to previous request.
     */
    public static final String PREVIOUS_REQUEST_LINK = "previousRequestLink";
    public static final String PREVIOUS_REQUEST_LINK_APPROVED
            = "previousRequestLinkApproved";

    /**
     * sql special symbol.
     */
    public static final String PERCENTAGE_SYMBOL = "%";
    /**
     * request parameter title.
     */
    public static final String CURRENT_PAGE = "currentPage";
    /**
     * request parameter title.
     */
    public static final String RECORDS_PER_PAGE = "recordsPerPage";
    /**
     * initial number of page.
     */
    public static final Integer DEFAULT_PAGE_NUMBER = 1;
    /**
     * initial number of records displayed on single page.
     */
    public static final Integer DEFAULT_RECORDS_PER_PAGE = 5;
    /**
     * request parameter title.
     */
    public static final String ORDER_TYPE = "orderType";
    /**
     * request parameter title.
     */
    public static final String ORDER_FIELD = "orderField";
    /**
     * request parameter title.
     */
    public static final String SEARCH_VALUE = "searchValue";
    /**
     * request parameter title.
     */
    public static final String ORDER_OBJECT = "orderObject";
    /**
     * name of html input with type="file".
     */
    public static final String IMAGE = "image";
    public static final String PRODUCT = "product";
    public static final String ROLES = "roles";
    public static final String COUNTRIES = "countries";
    public static final String MEDICINE = "medicine";
    public static final String MEDICINE_PRODUCT = "medicineProduct";
    public static final String MEDICINE_PRODUCTS = "medicineProducts";

    // Fields and database properties

    public static final String POSTCODE = "postcode";
    public static final String CITY = "city";
    public static final String STREET = "street";
    public static final String HOUSE = "house";
    public static final String APARTMENT = "apartment";
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DOSAGE = "dosage";
    public static final String FORM = "form";
    public static final String PRICE = "price";
    public static final String AMOUNT = "amount";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    public static final String POSITION = "position";
    public static final String DATE = "date";
    public static final String ROLE = "role";
    public static final String HEALTH_CARE_CARD_NUMBER = "healthCareCardNumber";
    public static final String DATE_JOINED = "joinedDate";
    public static final String UPLOAD_DATE_TIME = "uploadDateTime";
    public static final String PRESCRIPTION_REQUEST_STATUS
            = "prescriptionRequestStatus";
    public static final String PRESCRIPTION_REQUESTS = "prescriptionRequests";

    /**
     * table column.
     */
    public static final String NAME = "name";
    /**
     * table column.
     */
    public static final String SURNAME = "surname";
    /**
     * table column.
     */
    public static final String LOGIN = "login";
    /**
     * table column.
     */
    public static final String PASSWORD = "password";
    public static final String COMPANY_NAME = "companyName";
    public static final String COUNTRY = "country";
    public static final String CREATION_DATE = "creationDate";

    // database properties

    public static final String HEALTH_CARE_CARD_NUMBER_DB
            = "health_care_card_number";
    public static final String PRODUCER_ID_DB = "producer_id";
    public static final String MEDICINE_ID_DB = "medicine_id";
    public static final String MEDICINE_PRODUCT_ID_DB = "medicine_product_id";
    public static final String PRESCRIPTION_ID_DB = "prescription_id";
    public static final String PRESCRIPTION_REQUEST_ID_DB
            = "prescription_request_id";

    public static final String IS_NONPRESCRIPTION_DB = "is_nonprescription";
    public static final String APPROVAL_DATE_DB = "approval_date";
    public static final String MEDICINE_IMAGE_PATH_DB = "medicine_image_path";
    public static final String DATE_TIME_DB = "date_time";
    public static final String PAYMENT_CARD_NUMBER_DB = "payment_card_number";
    public static final String CONTACT_PHONE_DB = "contact_phone";
    public static final String DELIVERY_ADDRESS_DB = "delivery_address";
    public static final String DATE_OF_BIRTH_DB = "date_of_birth";
    public static final String PERSONAL_ACCOUNT_DB = "personal_account";
    public static final String COMPANY_NAME_DB = "company_name";
    public static final String COUNTRY_CODE_DB = "country_code";
    public static final String CREATION_DATE_DB = "creation_date";
    public static final String DATE_JOINED_DB = "date_joined";
    public static final String AVATAR_IMAGE_PATH_DB = "avatar_image_path";
    public static final String PRESCRIPTION_SCAN_PATH_DB
            = "prescription_scan_path";
    public static final String UPLOAD_DATE_TIME_DB = "upload_date_time";
    public static final String PRESCRIPTION_REQUEST_STATUS_DB
            = "prescription_request_status";

    // database table titles

    public static final String ADDRESSES = "addresses";
    public static final String MEDICINES = "medicines";
    public static final String MEDICINE_PRODUCTS_DB = "medicine_products";
    public static final String ORDERS = "orders";
    public static final String PERSONAL_INFO = "personal_info";
    public static final String PRESCRIPTIONS = "prescriptions";
    public static final String USERS = "users";
    public static final String PRODUCERS = "producers";
    public static final String PRESCRIPTION_REQUESTS_DB
            = "prescription_requests";

    // hibernate variable properties

    public static final String ADDRESS_ENTITY = "addressEntity";
    public static final String MEDICINE_ENTITY = "medicineEntity";
    public static final String CART = "cart";
    public static final String MEDICINE_PRODUCT_ENTITY
            = "medicineProductEntity";
    public static final String PERSONAL_INFO_ENTITY = "personalInfoEntity";
    public static final String PRODUCER_ENTITY = "producerEntity";
    public static final String CARTS = "carts";
    public static final String USER_ENTITY = "userEntity";
    public static final String LOCAL_DATE_TIME = "localDateTime";
    public static final String PAYMENT_CARD_NUMBER = "paymentCardNumber";
    public static final String CONTACT_PHONE = "contactPhone";
    public static final String DELIVERY_ADDRESS = "deliveryAddress";
    public static final String IS_NONPRESCRIPTION = "isNonprescription";
    public static final String APPROVAL_DATE = "approvalDate";
    public static final String FORMS = "forms";

    // URL properties

    public static final String DISPATCHER_READ_PAGINATED_CLIENT_MEDICINES_URL
            = "/dispatcher?command=read_paginated_client_medicines";
    public static final String LOGIN_MESSAGE = "loginMessage";
    public static final String TOTAL_PRICE = "totalPrice";
    public static final String TEXT_SUCCESSFUL_SIGNUP = "text.successfulSignup";
    public static final String LOCALE = "locale";
    public static final String ERROR_LOGIN_PASS_MESSAGE_KEY
            = "errorLoginPassMessageKey";
    public static final String TEXT_LOGIN_ERROR = "text.loginError";
    public static final String IMG_MEDICINE = "/img/medicine/";
    public static final String JPG = ".jpg";
    public static final String EMPTY_PATH = "";
    public static final String SPACE = " ";
    public static final String IMG_PRESCRIPTION_SCAN = "/img/prescriptionScan/";
    public static final String IMG_USER = "/img/user/";
    public static final String DEFAULT_LOCALE = "defaultLocale";
    public static final String LANGUAGES_TEXT = "languages.text";
    public static final String DE = "de";
    public static final String DE1 = "DE";
    public static final String EN = "en";
    public static final String US = "US";
    public static final String ES = "es";
    public static final String ES1 = "ES";
    public static final String RU = "ru";
    public static final String RU1 = "RU";

    /**
     * default constructor.
     */
    private Constant() {
    }
}
