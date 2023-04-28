package by.academy.pharmacy.service;

import by.academy.pharmacy.entity.Country;
import by.academy.pharmacy.entity.ProducerEntity;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConnection;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpUpgradeHandler;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import static by.academy.pharmacy.service.TestConstant.CLEAR_PRODUCERS_TABLE_SQL;
import static by.academy.pharmacy.service.TestConstant.COMPANY_NAME_COLUMN_TITLE;
import static by.academy.pharmacy.service.TestConstant.COUNTRY_CODE_COLUMN_TITLE;
import static by.academy.pharmacy.service.TestConstant.CREATION_DATE_COLUMN_TITLE;
import static by.academy.pharmacy.service.TestConstant.FIRST_INDEX;
import static by.academy.pharmacy.service.TestConstant.ID_COLUMN_TITLE;
import static by.academy.pharmacy.service.TestConstant.INSERT_PRODUCER_SQL;
import static by.academy.pharmacy.service.TestConstant.PASSWORD;
import static by.academy.pharmacy.service.TestConstant.SECOND_INDEX;
import static by.academy.pharmacy.service.TestConstant.SELECT_PRODUCER_BY_ID_SQL;
import static by.academy.pharmacy.service.TestConstant.TEST_COMPANY_NAME1;
import static by.academy.pharmacy.service.TestConstant.TEST_COUNTRY1;
import static by.academy.pharmacy.service.TestConstant.TEST_CREATION_DATE1;
import static by.academy.pharmacy.service.TestConstant.TEST_PROPERTIES_URL;
import static by.academy.pharmacy.service.TestConstant.THIRD_INDEX;
import static by.academy.pharmacy.service.TestConstant.URL;
import static by.academy.pharmacy.service.TestConstant.USERNAME;

public final class MockUtil {
    private static final ResourceBundle PROPERTIES = ResourceBundle.getBundle(TEST_PROPERTIES_URL);
    public static final String URL_STRING = PROPERTIES.getString(URL);
    public static final String USER = PROPERTIES.getString(USERNAME);
    public static final String PASS = PROPERTIES.getString(PASSWORD);

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL_STRING, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ProducerEntity createTestProducer() {
        ProducerEntity producer = new ProducerEntity();
        producer.setCompanyName(TEST_COMPANY_NAME1);
        producer.setCountry(TEST_COUNTRY1);
        producer.setCreationDate(TEST_CREATION_DATE1);
        return producer;
    }

    public static void clearProducersTable(final Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(CLEAR_PRODUCERS_TABLE_SQL)) {
            statement.executeUpdate();
        }
    }

    public static ProducerEntity selectProducerById(final long id, final Connection connection)
            throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCER_BY_ID_SQL)) {
            statement.setLong(FIRST_INDEX, id);
            ResultSet resultset = statement.executeQuery();
            ProducerEntity producer = null;
            while (resultset.next()) {
                producer = createProducer(resultset);
            }
            return producer;
        }
    }

    public static void insertProducer(final ProducerEntity producer, final Connection connection)
            throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCER_SQL,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(FIRST_INDEX, producer.getCompanyName());
            statement.setString(SECOND_INDEX, producer.getCountry().getCode());
            statement.setDate(THIRD_INDEX, new java.sql.Date(producer.getCreationDate().getTime()));
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                producer.setId(statement.getGeneratedKeys().getLong(FIRST_INDEX));
            }
        }
    }

    private static ProducerEntity createProducer(final ResultSet resultset) throws SQLException {
        ProducerEntity producer = new ProducerEntity();
        producer.setId(resultset.getLong(ID_COLUMN_TITLE));
        producer.setCompanyName(resultset.getString(COMPANY_NAME_COLUMN_TITLE));
        producer.setCountry(Country.valueOfCode(resultset.getString(COUNTRY_CODE_COLUMN_TITLE)));
        producer.setCreationDate(resultset.getDate(CREATION_DATE_COLUMN_TITLE));
        return producer;
    }

    public static void main(final String[] args) {
        Map<String, String[]> testMap = new HashMap<>();
        testMap.put("name", new String[]{"testName"});
        HttpServletRequest request = getMockRequest(testMap);
        System.out.println(request.getParameter("name"));
    }

    public static HttpServletRequest getMockRequest(final Map<String, String[]> params) {
        return new HttpServletRequest() {

            @Override
            public Map<String, String[]> getParameterMap() {
                return params;
            }

            @Override
            public String getParameter(final String name) {
                String[] values = params.get(name);
                if (values == null || values.length == 0) {
                    return null;
                }
                return values[0];
            }

            @Override
            public String getAuthType() {
                return null;
            }

            @Override
            public Cookie[] getCookies() {
                return new Cookie[0];
            }

            @Override
            public long getDateHeader(final String newS) {
                return 0;
            }

            @Override
            public String getHeader(final String newS) {
                return null;
            }

            @Override
            public Enumeration<String> getHeaders(final String newS) {
                return null;
            }

            @Override
            public Enumeration<String> getHeaderNames() {
                return null;
            }

            @Override
            public int getIntHeader(final String newS) {
                return 0;
            }

            @Override
            public String getMethod() {
                return null;
            }

            @Override
            public String getPathInfo() {
                return null;
            }

            @Override
            public String getPathTranslated() {
                return null;
            }

            @Override
            public String getContextPath() {
                return null;
            }

            @Override
            public String getQueryString() {
                return null;
            }

            @Override
            public String getRemoteUser() {
                return null;
            }

            @Override
            public boolean isUserInRole(final String newS) {
                return false;
            }

            @Override
            public Principal getUserPrincipal() {
                return null;
            }

            @Override
            public String getRequestedSessionId() {
                return null;
            }

            @Override
            public String getRequestURI() {
                return null;
            }

            @Override
            public StringBuffer getRequestURL() {
                return null;
            }

            @Override
            public String getServletPath() {
                return null;
            }

            @Override
            public HttpSession getSession(final boolean newB) {
                return null;
            }

            @Override
            public HttpSession getSession() {
                return null;
            }

            @Override
            public String changeSessionId() {
                return null;
            }

            @Override
            public boolean isRequestedSessionIdValid() {
                return false;
            }

            @Override
            public boolean isRequestedSessionIdFromCookie() {
                return false;
            }

            @Override
            public boolean isRequestedSessionIdFromURL() {
                return false;
            }

            @Override
            public boolean authenticate(final HttpServletResponse newHttpServletResponse) {
                return false;
            }

            @Override
            public void login(final String newS, final String newS1) {

            }

            @Override
            public void logout() {

            }

            @Override
            public Collection<Part> getParts() {
                return null;
            }

            @Override
            public Part getPart(final String newS) {
                return null;
            }

            @Override
            public <T extends HttpUpgradeHandler> T upgrade(final Class<T> newClass) {
                return null;
            }

            @Override
            public Object getAttribute(final String newS) {
                return null;
            }

            @Override
            public Enumeration<String> getAttributeNames() {
                return null;
            }

            @Override
            public String getCharacterEncoding() {
                return null;
            }

            @Override
            public void setCharacterEncoding(final String newS) {

            }

            @Override
            public int getContentLength() {
                return 0;
            }

            @Override
            public long getContentLengthLong() {
                return 0;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public ServletInputStream getInputStream() {
                return null;
            }

            @Override
            public Enumeration<String> getParameterNames() {
                return null;
            }

            @Override
            public String[] getParameterValues(final String newS) {
                return new String[0];
            }

            @Override
            public String getProtocol() {
                return null;
            }

            @Override
            public String getScheme() {
                return null;
            }

            @Override
            public String getServerName() {
                return null;
            }

            @Override
            public int getServerPort() {
                return 0;
            }

            @Override
            public BufferedReader getReader() {
                return null;
            }

            @Override
            public String getRemoteAddr() {
                return null;
            }

            @Override
            public String getRemoteHost() {
                return null;
            }

            @Override
            public void setAttribute(final String newS, final Object newO) {

            }

            @Override
            public void removeAttribute(final String newS) {

            }

            @Override
            public Locale getLocale() {
                return null;
            }

            @Override
            public Enumeration<Locale> getLocales() {
                return null;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public RequestDispatcher getRequestDispatcher(final String newS) {
                return null;
            }

            @Override
            public int getRemotePort() {
                return 0;
            }

            @Override
            public String getLocalName() {
                return null;
            }

            @Override
            public String getLocalAddr() {
                return null;
            }

            @Override
            public int getLocalPort() {
                return 0;
            }

            @Override
            public ServletContext getServletContext() {
                return null;
            }

            @Override
            public AsyncContext startAsync() throws IllegalStateException {
                return null;
            }

            @Override
            public AsyncContext startAsync(final ServletRequest newServletRequest,
                                           final ServletResponse newServletResponse)
                    throws IllegalStateException {
                return null;
            }

            @Override
            public boolean isAsyncStarted() {
                return false;
            }

            @Override
            public boolean isAsyncSupported() {
                return false;
            }

            @Override
            public AsyncContext getAsyncContext() {
                return null;
            }

            @Override
            public DispatcherType getDispatcherType() {
                return null;
            }

            @Override
            public String getRequestId() {
                return null;
            }

            @Override
            public String getProtocolRequestId() {
                return null;
            }

            @Override
            public ServletConnection getServletConnection() {
                return null;
            }
        };
    }
}
