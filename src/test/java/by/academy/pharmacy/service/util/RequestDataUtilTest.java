package by.academy.pharmacy.service.util;

import by.academy.pharmacy.entity.OrderType;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import static by.academy.pharmacy.entity.Constant.CURRENT_PAGE;
import static by.academy.pharmacy.entity.Constant.DATE_FORMAT;
import static by.academy.pharmacy.entity.Constant.DEFAULT_PAGE_NUMBER;
import static by.academy.pharmacy.entity.Constant.DEFAULT_RECORDS_PER_PAGE;
import static by.academy.pharmacy.entity.Constant.ORDER_FIELD;
import static by.academy.pharmacy.entity.Constant.ORDER_TYPE;
import static by.academy.pharmacy.entity.Constant.RECORDS_PER_PAGE;
import static by.academy.pharmacy.service.MockUtil.getMockRequest;
import static by.academy.pharmacy.service.TestConstant.FIRST_INDEX;
import static by.academy.pharmacy.service.TestConstant.SECOND_INDEX;
import static by.academy.pharmacy.service.TestConstant.TEST_COUNTRY1;
import static by.academy.pharmacy.service.TestConstant.TEST_FORM1;
import static by.academy.pharmacy.service.TestConstant.TEST_ROLE1;
import static by.academy.pharmacy.service.TestConstant.TEST_STRING_DATE2;
import static by.academy.pharmacy.service.TestConstant.USERNAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RequestDataUtilTest {
    private static final Map<String, String[]> PARAMS_MAP = new HashMap<>();

    @Test
    public void testGetStringPositive() {
        PARAMS_MAP.put(USERNAME, new String[]{USERNAME});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getString(USERNAME, request), USERNAME);
    }

    @Test
    public void testGetStringNegative() {
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertNull(RequestDataUtil.getString(USERNAME, request));
    }

    @Test
    public void testGetShortPositive() {
        PARAMS_MAP.put(USERNAME, new String[]{String.valueOf(FIRST_INDEX)});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getShort(USERNAME, request), (short) FIRST_INDEX);
    }

    @Test
    public void testGetShortNegative() {
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertNull(RequestDataUtil.getShort(USERNAME, request));
    }

    @Test
    public void testGetIntegerPositive() {
        PARAMS_MAP.put(USERNAME, new String[]{String.valueOf(FIRST_INDEX)});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getInteger(USERNAME, request), FIRST_INDEX);
    }

    @Test
    public void testGetIntegerNegative() {
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertNull(RequestDataUtil.getInteger(USERNAME, request));
    }

    @Test
    public void testGetLongPositive() {
        PARAMS_MAP.put(USERNAME, new String[]{String.valueOf(FIRST_INDEX)});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getLong(USERNAME, request), FIRST_INDEX);
    }

    @Test
    public void testGetLongNegative() {
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertNull(RequestDataUtil.getLong(USERNAME, request));
    }

    @Test
    public void testGetBigDecimalPositive() {
        PARAMS_MAP.put(USERNAME, new String[]{String.valueOf(FIRST_INDEX)});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getBigDecimal(USERNAME, request), new BigDecimal(FIRST_INDEX));
    }

    @Test
    public void testGetBigDecimalNegative() {
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertNull(RequestDataUtil.getBigDecimal(USERNAME, request));
    }

    @Test
    public void testGetCountryPositive() {
        PARAMS_MAP.put(USERNAME, new String[]{String.valueOf(TEST_COUNTRY1)});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getCountry(USERNAME, request), TEST_COUNTRY1);
    }

    @Test
    public void testGetCountryNegative() {
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertNull(RequestDataUtil.getCountry(USERNAME, request));
    }

    @Test
    public void testGetFormPositive() {
        PARAMS_MAP.put(USERNAME, new String[]{String.valueOf(TEST_FORM1)});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getForm(USERNAME, request), TEST_FORM1);
    }

    @Test
    public void testGetFormNegative() {
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertNull(RequestDataUtil.getForm(USERNAME, request));
    }

    @Test
    public void testGetRolePositive() {
        PARAMS_MAP.put(USERNAME, new String[]{String.valueOf(TEST_ROLE1)});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getRole(USERNAME, request), TEST_ROLE1);
    }

    @Test
    public void testGetRoleNegative() {
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertNull(RequestDataUtil.getRole(USERNAME, request));
    }

    @Test
    public void testGetDatePositive() throws ParseException {
        PARAMS_MAP.put(USERNAME, new String[]{TEST_STRING_DATE2});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getDate(USERNAME, request),
                new SimpleDateFormat(DATE_FORMAT).parse(TEST_STRING_DATE2));
    }

    @Test
    public void testGetDateNegative() {
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertNull(RequestDataUtil.getDate(USERNAME, request));
    }

    @Test
    public void testGetBooleanNegative() {
        PARAMS_MAP.put(USERNAME, new String[]{String.valueOf(SECOND_INDEX)});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertFalse(RequestDataUtil.getBoolean(USERNAME, request));
    }

    @Test
    public void testGetCurrentPagePositive() {
        PARAMS_MAP.put(CURRENT_PAGE, new String[]{String.valueOf(SECOND_INDEX)});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getCurrentPage(request), SECOND_INDEX);
    }

    @Test
    public void testGetCurrentPageNegative() {
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getCurrentPage(request), DEFAULT_PAGE_NUMBER);
    }

    @Test
    public void testGetRecordsPerPagePositive() {
        PARAMS_MAP.put(RECORDS_PER_PAGE, new String[]{String.valueOf(FIRST_INDEX)});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getRecordsPerPage(request), FIRST_INDEX);
    }

    @Test
    public void testGetRecordsPerPageNegative() {
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getRecordsPerPage(request), DEFAULT_RECORDS_PER_PAGE);
    }

    @Test
    public void testGetOrderTypePositive() {
        PARAMS_MAP.put(ORDER_TYPE, new String[]{String.valueOf(OrderType.DESC)});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getOrderType(request), OrderType.DESC);
    }

    @Test
    public void testGetOrderTypeNegative() {
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getOrderType(request), OrderType.ASC);
    }

    @Test
    public void testGetOrderFieldPositive() {
        PARAMS_MAP.put(ORDER_FIELD, new String[]{USERNAME});
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertEquals(RequestDataUtil.getOrderField(request), USERNAME);
    }

    @Test
    public void testGetOrderFieldNegative() {
        HttpServletRequest request = getMockRequest(PARAMS_MAP);
        assertNull(RequestDataUtil.getOrderField(request));
    }

    @AfterEach
    public void clearParamsMap() {
        PARAMS_MAP.clear();
    }
}
