/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.web.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author jolube
 */
public class ClientIpAddress {
    // CHECKSTYLE:OFF
    // http://stackoverflow.com/a/11327345/131929
    private static Pattern PRIVATE_ADDRESS_PATTERN = Pattern.compile(
            "(^127\\.)|(^192\\.168\\.)|(^10\\.)|(^172\\.1[6-9]\\.)|(^172\\.2[0-9]\\.)|(^172\\.3[0-1]\\.)|(^::1$)|(^[fF][cCdD])",
            Pattern.CANON_EQ);
    // CHECKSTYLE:ON

    private ClientIpAddress() {
    }

    /**
     * Extracts the "real" client IP address from the request. It analyzes
     * request headers {@code REMOTE_ADDR}, {@code X-Forwarded-For} as well as
     * {@code Client-IP}. Optionally private/local addresses can be filtered in
     * which case an empty string is returned.
     *
     * @param request HTTP request
     * @param filterPrivateAddresses true if private/local addresses (see
     * https://en.wikipedia.org/wiki/Private_network#Private_IPv4_address_spaces
     * and https://en.wikipedia.org/wiki/Unique_local_address) should be
     * filtered i.e. omitted
     * @return IP address or empty string
     */
    public static String getFrom(HttpServletRequest request, boolean filterPrivateAddresses) {
        String ip = request.getRemoteAddr();

        String headerClientIp = request.getHeader("Client-IP");
        String headerXForwardedFor = request.getHeader("X-Forwarded-For");
        if (StringUtils.isEmpty(ip) && StringUtils.isNotEmpty(headerClientIp)) {
            ip = headerClientIp;
        } else if (StringUtils.isNotEmpty(headerXForwardedFor)) {
            ip = headerXForwardedFor;
        }
        if (filterPrivateAddresses && isPrivateOrLocalAddress(ip)) {
            return StringUtils.EMPTY;
        } else {
            return ip;
        }
    }

    private static boolean isPrivateOrLocalAddress(String address) {
        Matcher regexMatcher = PRIVATE_ADDRESS_PATTERN.matcher(address);
        return regexMatcher.matches();
    }
}
