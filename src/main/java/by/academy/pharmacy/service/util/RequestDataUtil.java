package by.academy.pharmacy.service.util;

import by.academy.pharmacy.entity.Country;
import by.academy.pharmacy.entity.Form;
import by.academy.pharmacy.entity.OrderType;
import by.academy.pharmacy.entity.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static by.academy.pharmacy.entity.Constant.CURRENT_PAGE;
import static by.academy.pharmacy.entity.Constant.DATE_FORMAT;
import static by.academy.pharmacy.entity.Constant.DEFAULT_PAGE_NUMBER;
import static by.academy.pharmacy.entity.Constant.DEFAULT_RECORDS_PER_PAGE;
import static by.academy.pharmacy.entity.Constant.ORDER_FIELD;
import static by.academy.pharmacy.entity.Constant.ORDER_TYPE;
import static by.academy.pharmacy.entity.Constant.RECORDS_PER_PAGE;

public final class RequestDataUtil {
	private RequestDataUtil() {
	}

	public static String getString(final String name,
								   final HttpServletRequest request) {
		String value = request.getParameter(name);
		if (value == null || value.isBlank()) {
			return null;
		}
		return value;
	}

	public static Short getShort(final String name,
								 final HttpServletRequest request) {
		try {
			return Short.parseShort(request.getParameter(name));
		} catch (NullPointerException | NumberFormatException e) {
			return null;
		}
	}

	public static Integer getInteger(final String name,
									 final HttpServletRequest request) {
		try {
			return Integer.parseInt(request.getParameter(name));
		} catch (NullPointerException | NumberFormatException e) {
			return null;
		}
	}

	public static Long getLong(final String name,
							   final HttpServletRequest request) {
		try {
			return Long.parseLong(request.getParameter(name));
		} catch (NullPointerException | NumberFormatException e) {
			return null;
		}
	}

	public static BigDecimal getBigDecimal(final String name,
										   final HttpServletRequest request) {
		try {
			return new BigDecimal(request.getParameter(name));
		} catch (NullPointerException | NumberFormatException e) {
			return null;
		}
	}

	public static Country getCountry(final String name,
									 final HttpServletRequest request) {
		try {
			return Country.valueOf(request.getParameter(name).toUpperCase());
		} catch (IllegalArgumentException | NullPointerException e) {
			return null;
		}
	}

	public static Form getForm(final String name,
							   final HttpServletRequest request) {
		try {
			return Form.valueOf(request.getParameter(name).toUpperCase());
		} catch (IllegalArgumentException | NullPointerException e) {
			return null;
		}
	}

	public static Role getRole(final String name,
							   final HttpServletRequest request) {
		try {
			return Role.valueOf(request.getParameter(name).toUpperCase());
		} catch (IllegalArgumentException | NullPointerException e) {
			return null;
		}
	}

	public static Date getDate(final String name,
							   final HttpServletRequest request) {
		try {
			return new SimpleDateFormat(DATE_FORMAT).parse(
					request.getParameter(name));
		} catch (NullPointerException | ParseException e) {
			return null;
		}
	}

	public static Boolean getDBoolean(final String name,
									  final HttpServletRequest request) {
		return request.getParameter(name) != null;
	}

	public static void saveFile(final String path,
								final HttpServletRequest request,
								final String partName) {
		try {
			Part imagePart = request.getPart(partName);
			if (imagePart != null && imagePart.getSize() > 0) {
				imagePart.write(path);
			}
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param request HttpServletRequest.
	 * @return current page parameter from request.
	 */
	public static Integer getCurrentPage(final HttpServletRequest request) {
		return Optional.ofNullable(request.getParameter(CURRENT_PAGE))
				.map(Integer::parseInt)
				.orElse(DEFAULT_PAGE_NUMBER);
	}

	/**
	 * @param request HttpServletRequest.
	 * @return records per page parameter from request.
	 */
	public static Integer getRecordsPerPage(final HttpServletRequest request) {
		return Optional.ofNullable(request.getParameter(RECORDS_PER_PAGE))
				.map(Integer::parseInt)
				.orElse(DEFAULT_RECORDS_PER_PAGE);
	}

	/**
	 * @param request HttpServletRequest.
	 * @return descending or ascending type of ordering.
	 */
	public static OrderType getOrderType(final HttpServletRequest request) {
		return Optional.ofNullable(request.getParameter(ORDER_TYPE))
				.map(x -> OrderType.valueOf(x.toUpperCase()))
				.orElse(OrderType.ASC);
	}

	/**
	 * @param request HttpServletRequest.
	 * @return field which needs to sort records.
	 */
	public static String getOrderField(final HttpServletRequest request) {
		return request.getParameter(ORDER_FIELD);
	}
}
