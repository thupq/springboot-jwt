package com.util;

import com.common.constant.Constants;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataUtils {
    private static final Logger log = LoggerFactory.getLogger(DataUtils.class);

    private DataUtils() {
    }

    public static final String REGEX_NUMBER = "\\d+";
    public static final Integer ACCOUNT_TAIL = 1;
    public static final Integer VT_ACC_LOG_TAIL = 1;

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean notNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean nullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean nullOrEmpty(Collection objects) {
        return objects == null || objects.isEmpty();
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().equals("");
    }

    public static boolean isNullOrEmpty(final Object obj) {
        return obj == null || obj.toString().isEmpty();
    }

    public static boolean notNullOrEmpty(Collection<?> collection) {
        return !isNullOrEmpty(collection);
    }

    public static Integer parseToInt(String value) {
        return parseToInt(value, null);
    }

    public static Integer parseToInt(Object value) {
        String tmp = parseToString(value);
        if (isNull(tmp)) {
            return null;
        }
        return Integer.valueOf(tmp);
    }

    public static String escapeQueryChars(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '\\' || c == '+' || c == '-' || c == '!' || c == '(' || c == ')' || c == ':' || c == '^' || c == '[' || c == ']' || c == '"' || c == '{' || c == '}' || c == '~' || c == '*' || c == '?' || c == '|' || c == '&' || c == ';' || c == '/' || Character.isWhitespace(c)) {
                sb.append('\\');
            }

            sb.append(c);
        }

        return sb.toString();
    }

    public static String convertCamelToSnake(String camelCase) {
        // Regular Expression
        String regex = "([a-z])([A-Z]+)";

        // Replacement string
        String replacement = "$1_$2";

        // Replace the given regex
        // with replacement string
        // and convert it to lower case.
        String snakeCase = camelCase
                .replaceAll(
                        regex, replacement)
                .toLowerCase();

        // return string
        return snakeCase;
    }

    public static Integer parseToInt(Object value, Integer defaultValue) {
        String tmp = parseToString(value);
        if (isNull(tmp)) {
            return defaultValue;
        }
        return Integer.valueOf(tmp);
    }

    public static String replaceString(Object obj) {
        if (DataUtils.isNullOrEmpty(obj)) {
            return "";
        }
        return obj.toString().replaceAll("!", "!!")
                .replaceAll("%", "!%").replaceAll("_", "!_");
    }

    public static boolean notNullOrEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static String parseToString(Object value, String defaultVal) {
        return value != null ? String.valueOf(value) : defaultVal;
    }

    public static boolean nullOrZero(Long value) {
        return (value == null || value.equals(0L));
    }

    public static Character parseToCharacter(Object obj) {
        return (Character) obj;
    }

    public static String parseToString(Object obj) {
        if (isNull(obj)) {
            return null;
        }
        return String.valueOf(obj);
    }

    public static Double parseToDouble(Object obj) {
        if (isNull(obj)) {
            return null;
        }
        return Double.parseDouble(parseToString(obj));
    }

    public static BigInteger parseToBigInteger(Object obj) {
        if (isNull(obj)) {
            return null;
        }
        return new BigInteger(parseToString(obj));
    }

    public static Long parseToLong(Object obj) {
        if (isNull(obj)) {
            return null;
        }
        return Long.parseLong(parseToString(obj));
    }

    public static Float parseToFloat(Object obj) {
        if (isNull(obj)) {
            return null;
        }
        return Float.parseFloat(parseToString(obj));
    }

    public static Short parseToShort(Object obj) {
        if (isNull(obj)) {
            return null;
        }
        return Short.parseShort(parseToString(obj));
    }

    public static Integer parseToInteger(Object obj) {
        if (isNull(obj)) {
            return null;
        }
        return Integer.parseInt(parseToString(obj));
    }

    public static LocalDate parseToLocalDate(Object obj) {
        if (isNull(obj)) {
            return null;
        }
        return LocalDate.parse(parseToString(obj));
    }


    public static LocalDate longToLocalDate(Long input) {
        if (isNull(input) || input <= 0L) {
            return null;
        }
        LocalDateTime date =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(input), ZoneId.systemDefault());
        return date.toLocalDate();
    }

    public static LocalDateTime parseToLocalDatetime(Object value) {
        if (value == null)
            return null;
        String tmp = parseToString(value, null);
        if (tmp == null)
            return null;

        try {
            LocalDateTime rtn = convertStringToLocalDateTime(tmp, "yyyy-MM-dd HH:mm:ss");
            return rtn;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return null;
    }

    public static LocalDateTime longToLocalDateTime(Long input) {
        if (isNull(input) || input <= 0L) {
            return null;
        }
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(input), ZoneId.systemDefault());
    }

    public static Long localDateToLong(LocalDate input) {
        return input.toEpochDay();
    }

    public static Long localDateTimeToLong(LocalDateTime input) {
        ZonedDateTime zdt = input.atZone(ZoneId.systemDefault());
        return zdt.toInstant().toEpochMilli();
    }

    public static String objectToJson(Object data, String defaultValue) {
        if (isNull(data)) {
            return defaultValue;
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            return mapper.writeValueAsString(data);
        } catch (Exception ex) {
            log.warn(ex.getMessage(), ex);
            return "";
        }
    }

    public static String objectToJson(Object data) {
        return objectToJson(data, "");
    }

    private static <T> T jsonToObjectFronGson(String jsonData, Class<T> classOutput) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(jsonData, classOutput);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return null;
    }

    public static <T> T fromJson(String jsonData, Type classOutput) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(jsonData, classOutput);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return null;
    }

    public static <T> T jsonToObject(String jsonData, Class<T> classOutput) {
        try {
            if (DataUtils.isNullOrEmpty(jsonData))
                return null;
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(jsonData, classOutput);
        } catch (Exception ex) {
            log.warn(ex.getMessage(), ex);
            return jsonToObjectFronGson(jsonData, classOutput);
        }
    }

    public static LocalDateTime convertStringToLocalDateTime(String value, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        if (value == null) {
            return null;
        } else if (value.contains(".")) {
            value = value.substring(0, value.indexOf('.'));
        }
        return LocalDateTime.parse(value, formatter);
    }

    public static String localDateToString(LocalDate value, String format) {
        if (!notNull(value)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return value.format(formatter); // "1986-04-08 12:30"
    }

    public static String localDateTimeToString(LocalDateTime value, String format) {
        if (!notNull(value)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return value.format(formatter); // "1986-04-08 12:30"
    }


    public static String formatIsdn(String msisdn) {
        if (msisdn.startsWith("0")) {
            return msisdn.substring(1);
        } else if (msisdn.startsWith("84") && msisdn.length() == 11) {
            return msisdn.substring(2);
        } else if (msisdn.startsWith("+84")) {
            return msisdn.substring(3);
        }
        return msisdn;
    }

    public static String formatMsisdn(String isdn) {
        if (isdn.startsWith("84") && isdn.length() >= 11) {
            return isdn;
        } else if (isdn.startsWith("+84")) {
            return isdn.substring(1);
        } else if (isdn.startsWith("0")) {
            isdn = isdn.substring(1);
        }
        return String.format("84%s", isdn);
    }

    public static boolean isInteger(Object obj) {
        return obj == parseToInteger(obj);
    }

    public static String randomNumberByDate() {
        String randomNumber = String.valueOf(System.nanoTime());
        if (randomNumber.startsWith("0")) {
            randomNumber = randomNumber.replaceFirst("0", "9");
        }
        return randomNumber;
    }

    @SuppressWarnings("java:S1612")
    public static <T> List<List<T>> nPartition(List<T> objs, final int N) {
        return new ArrayList<>(IntStream.range(0, objs.size()).boxed().collect(
                Collectors.groupingBy(e -> e % N, Collectors.mapping(e -> objs.get(e), Collectors.toList())
                )).values());
    }

    public static <T> List<List<T>> distribute(List<T> elements, int nrOfGroups) {
        if (CollectionUtils.isEmpty(elements)) {
            return new ArrayList<>(0);
        }
        int size = elements.size();
        if (nrOfGroups >= size) {
            List<List<T>> groups = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                groups.add(Arrays.asList(elements.get(i)));
            }
            return groups;
        }

        int elementsPerGroup = size / nrOfGroups;
        int leftoverElements = size % nrOfGroups;

        List<List<T>> groups = new ArrayList<>();
        for (int i = 0; i < nrOfGroups; i++) {
            groups.add(elements.subList(i * elementsPerGroup + Math.min(i, leftoverElements),
                    (i + 1) * elementsPerGroup + Math.min(i + 1, leftoverElements)));
        }
        return groups;
    }

    public static Integer incrRetry(Integer retry) {
        if (isNull(retry)) {
            return 1;
        }
        return retry + 1;
    }

    public static String checkNullInput(Object object) {
        if (object == null) {
            return "";
        }
        return object.toString();
    }

    public static Long convertToLong(Object object) {
        if (object == null) {
            return 0L;
        }
        return parseToLong(object);
    }

    public static void trimValue(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.getType().getName().equals(String.class.getName())) {
                    field.setAccessible(true);
                    String value = String.valueOf(FieldUtils.readDeclaredField(object, field.getName(), true));
                    if (value != null && !value.equals("null")) {
                        field.set(object, value.trim());
                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    public static Integer formatPartitionByTail(String msisdn, Integer tail) {
        if (msisdn == null) {
            return 0;
        }
        tail = (tail == null) ? 1 : tail;
        msisdn = msisdn.trim();

        if (!msisdn.matches(REGEX_NUMBER)) {
            return 0;
        }

        int length = msisdn.length();
        if (length < tail) {
            return 0;
        }

        return Integer.parseInt(msisdn.substring(length - tail));

    }

    public static boolean safeEqual(Object obj1, Object obj2) {
        return ((obj1 != null) && (obj2 != null) && obj2.toString().equals(obj1.toString()));
    }

    public static boolean safeEqualIgnoreCase(Object obj1, Object obj2) {
        return ((obj1 != null) && (obj2 != null) && obj2.toString().equalsIgnoreCase(obj1.toString()));
    }

    public static String htmlUnescape(String data) {
        if (data == null) {
            return null;
        }
        return HtmlUtils.htmlUnescape(data);
    }

    public static String formatCurrency(BigInteger number) {
        Locale loc = new Locale("vi", "VN");
        NumberFormat nf = NumberFormat.getCurrencyInstance(loc);
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);
        return nf.format(number).trim();
    }

    public static <T> List<T> jsonToList(String json, Class<T> classOutput) throws IOException {
        if (isNull(json)) {
            return Collections.emptyList();
        }
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        return objectMapper
                .readValue(json, typeFactory.constructCollectionType(List.class, classOutput));
    }

    public static LocalDate convertStringToLocalDate(String value, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        if (value == null || value.trim().isEmpty()) {
            return null;
        } else if (value.contains(".")) {
            value = value.substring(0, value.indexOf('.'));
        }
        return LocalDate.parse(value, formatter);
    }

    public static String localDateTimeToString(LocalDateTime value) {
        if (!notNull(value)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return value.format(formatter); // "1986-04-08 12:30"
    }

    public static void throwIf(boolean test, String message) throws Exception {
        if (test) throw new Exception(message);
    }

    public static void throwBusIf(boolean test, String message) throws Exception {
        if (test) throw new Exception(message);
    }

    public static void throwInputIf(boolean test, String message) throws Exception {
        if (test) throw new Exception(message);
    }

    public static boolean matchByPattern(String value, String regex) {
        if (nullOrEmpty(regex) || nullOrEmpty(value)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static String subString(String input, int lengh) {
        if (input == null) {
            return null;
        }
        if (lengh <= 0) {
            return input;
        }

        int strlengh = input.length();
        if (strlengh > lengh) {
            return input.substring(0, lengh);
        }
        return input;
    }

    public static String camelToSnake(String str) {
        // Regular Expression
        String regex = "([a-z])([A-Z]+)";

        // Replacement string
        String replacement = "$1_$2";

        // Replace the given regex
        // with replacement string
        // and convert it to lower case.
        str = str
                .replaceAll(
                        regex, replacement)
                .toLowerCase();

        // return string
        return str;
    }

    public static String convertDateToString(Date date, String format) {
        SimpleDateFormat sdf = null;
        try {
            sdf = new SimpleDateFormat(format);
            return date == null ? "" : sdf.format(date);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return null;
        }
    }

    public static boolean checkSqlOnlySelect(String sql) {
        sql = sql.toUpperCase();
        return sql.contains("INSERT") || sql.contains("UPDATE")
                || sql.contains("DELETE") || sql.contains("DROP")
                || sql.contains("CREATE TABLE") || sql.contains("ALTER TABLE");
    }

    public static String replaceAll(String input, String find, String replace) {
        if (DataUtils.notNull(input)) {
            return input.replaceAll(find, replace);
        }
        return null;
    }

    //template\import\File_mau_import_template.xlsx
    public static InputStream readInputStreamResource(String path) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(path);
        return classPathResource.getInputStream();
    }

    public static <T> T base64ToObject(String encodedString, Class<T> classOutput)
            throws IOException {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8.name());

        return jsonToObject(decodedString, classOutput);
    }

    public static <T> T byteToObject(byte[] input, Class<T> classOutput) {
        String jsonData = new String(input, StandardCharsets.UTF_8);
        try {
            return DataUtils.jsonToObject(jsonData, classOutput);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return null;
    }

    public static short safeToShort(Object obj1, Short defaultValue) {
        short result = defaultValue;
        if (obj1 != null) {
            try {
                result = Short.parseShort(obj1.toString());
            } catch (Exception ignored) {
            }
        }

        return result;
    }

    /**
     * @param obj1
     * @param defaultValue
     * @return
     * @author phuvk
     */
    public static int safeToInt(Object obj1, int defaultValue) {
        int result = defaultValue;
        if (obj1 != null) {
            try {
                result = Integer.parseInt(obj1.toString());
            } catch (Exception ignored) {
            }
        }

        return result;
    }

    /**
     * @param obj1 Object
     * @return int
     */
    public static int safeToInt(Object obj1) {
        return safeToInt(obj1, 0);
    }

    /**
     * @param obj1 Object
     * @return String
     */
    public static String safeToString(Object obj1, String defaultValue) {
        if (obj1 == null || safeEqual(obj1.toString(), "null")) {
            return defaultValue;
        }
        return obj1.toString();
    }

    /**
     * @param obj1 Object
     * @return String
     */
    public static String safeToString(Object obj1) {
        return safeToString(obj1, "");
    }

    /**
     * safe equal
     *
     * @param obj1 Long
     * @param obj2 Long
     * @return boolean
     */
    public static boolean safeEqual(Long obj1, Long obj2) {
        if (obj1 == obj2) return true;
        return ((obj1 != null) && (obj2 != null) && (obj1.compareTo(obj2) == 0));
    }

    /**
     * safe equal
     *
     * @param obj1 Long
     * @param obj2 Long
     * @return boolean
     */
    public static boolean safeEqual(BigInteger obj1, BigInteger obj2) {
        if (obj1 == obj2) return true;
        return (obj1 != null) && (obj2 != null) && obj1.equals(obj2);
    }

    /**
     * @param obj1
     * @param obj2
     * @return
     * @date 09-12-2015 17:43:20
     * @author TuyenLT18
     * @description
     */
    public static boolean safeEqual(Short obj1, Short obj2) {
        if (obj1 == obj2) return true;
        return ((obj1 != null) && (obj2 != null) && (obj1.compareTo(obj2) == 0));
    }

    /**
     * safe equal
     *
     * @param obj1 String
     * @param obj2 String
     * @return boolean
     */
    public static boolean safeEqual(String obj1, String obj2) {
        if (obj1 == null && obj2 == null) return true;
        else if (obj1 == obj2) return true;
        return ((obj1 != null) && (obj2 != null) && obj1.equals(obj2));
    }


    public static boolean isNullOrEmptyObj(Object obj) {
        if (obj == null)
            return true;
        CharSequence cs = ((String) obj);
        return isNullOrEmpty(cs);
    }

    /**
     * check null or empty
     * Su dung ma nguon cua thu vien StringUtils trong apache common lang
     *
     * @param cs String
     * @return boolean
     */
    public static boolean isNullOrEmpty(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNullOrEmpty(final Object[] collection) {
        return collection == null || collection.length == 0;
    }

    public static boolean isNullOrEmpty(final Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNullObject(Object obj1) {
        if (obj1 == null) {
            return true;
        }
        if (obj1 instanceof String) {
            return isNullOrEmpty(obj1.toString());
        }
        return false;
    }

    public static Long safeToLong(Object obj1, Long defaultValue) {
        Long result = defaultValue;
        if (obj1 != null) {
            if (obj1 instanceof BigDecimal) {
                return ((BigDecimal) obj1).longValue();
            }
            if (obj1 instanceof BigInteger) {
                return ((BigInteger) obj1).longValue();
            }
            try {
                result = Long.parseLong(obj1.toString());
            } catch (Exception ignored) {
            }
        }

        return result;
    }

    /**
     * @param obj1 Object
     * @return Long
     */
    public static Long safeToLong(Object obj1) {
        return safeToLong(obj1, 0L);
    }

    public static Double safeToDouble(Object obj1, Double defaultValue) {
        Double result = defaultValue;
        if (obj1 != null) {
            try {
                result = Double.parseDouble(obj1.toString());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }

        return result;
    }

    public static Double safeToDouble(Object obj1) {
        return safeToDouble(obj1, 0d);
    }

    public static boolean isNullOrZero(Long value) {
        return (value == null || value.equals(0L));
    }

    public static boolean isNullOrZero(Double value) {
        return (value == null || value.longValue() == 0L);
    }

    public static String getKeyParam(String key, Object... params) {
        String result = key;
        if (!isNullOrEmpty(params)) {
            for (int i = 0; i < params.length; i++) {
                result += "_" + String.valueOf(params[i]);
            }
        }
        return result;
    }

    public static boolean compareList(List<String> source, List<String> dest, int type) {
        switch (type) {
            /* EQUAL */
            case 0:
                if (source.size() == dest.size()) {
                    for (String s : source) {
                        if (!dest.contains(s)) {
                            return false;
                        }
                    }

                    for (String d : dest) {
                        if (!source.contains(d)) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }

                break;
            /* IN */
            case 1:
                if (source.size() <= dest.size()) {
                    for (String s : source) {
                        if (!dest.contains(s)) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }

                break;
            /* CONTAIN */
            case 2:
                if (source.size() >= dest.size()) {
                    for (String d : dest) {
                        if (!source.contains(d)) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }

                break;
        }

        return true;
    }

    /*public static UserInfoDTO getUserInfo() {
        return UserInfoDTO.builder()
                .userName(Optional.of(ThreadContext.get(Constants.ACTION_USER)).orElse(Constants.USER_DEFAULT))
                .build();
    }*/


    public static String getHeaderRequest(String header) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
        String headerValue = request.getHeader(header);
        return headerValue;
    }

    public static String getLanguage() {
        Locale locale = LocaleContextHolder.getLocale();
        if (null != locale) {
            return locale.getLanguage();
        } else {
            return Constants.REQUEST_HEADER.LANG_VI;
        }
    }

    /*public static HttpHeaders getHeader() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add(Constants.REQUEST_HEADER.USER_INFOR, request.getHeader(Constants.REQUEST_HEADER.USER_INFOR));
        httpHeaders.add(Constants.REQUEST_HEADER.ACCEPT_LANGUAGE, request.getHeader(Constants.REQUEST_HEADER.ACCEPT_LANGUAGE));
        httpHeaders.add(Constants.REQUEST_HEADER.X_FORWARDED_FOR, request.getHeader(Constants.REQUEST_HEADER.X_FORWARDED_FOR));
        httpHeaders.add(Constants.REQUEST_HEADER.X_FORWARDED_HOST, request.getHeader(Constants.REQUEST_HEADER.X_FORWARDED_HOST));
        return httpHeaders;
    }*/

   /* public static Map<String, Object> getHeaderMap() {
        Map<String, Object> headerMap = new HashMap<>();
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        headerMap.put(Constants.REQUEST_HEADER.USER_INFOR, request.getHeader(Constants.REQUEST_HEADER.USER_INFOR));
        headerMap.put(Constants.REQUEST_HEADER.ACCEPT_LANGUAGE, request.getHeader(Constants.REQUEST_HEADER.ACCEPT_LANGUAGE));
        headerMap.put(Constants.REQUEST_HEADER.X_FORWARDED_FOR, request.getHeader(Constants.REQUEST_HEADER.X_FORWARDED_FOR));
        headerMap.put(Constants.REQUEST_HEADER.X_FORWARDED_HOST, request.getHeader(Constants.REQUEST_HEADER.X_FORWARDED_HOST));

        return headerMap;
    }*/

    public static boolean isJSONValid(String test) {
        try {
            if (isNullOrEmpty(test)) {
                return false;
            }
            new JSONObject(test);
        } catch (JSONException ex) {
            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

    /*public static MapDifference<String, Object> jsonDifference(String leftJson, String rightJson) {
        if (isNullOrEmpty(leftJson) || isNullOrEmpty(rightJson)) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();

        Map<String, Object> leftMap = gson.fromJson(leftJson, type);
        Map<String, Object> rightMap = gson.fromJson(rightJson, type);

        Map<String, Object> leftFlatMap = FlatMapUtil.flatten(leftMap);
        Map<String, Object> rightFlatMap = FlatMapUtil.flatten(rightMap);

        MapDifference<String, Object> difference = Maps.difference(leftFlatMap, rightFlatMap);

        System.out.println("Entries only on the left\n--------------------------");
        difference.entriesOnlyOnLeft()
                .forEach((key, value) -> System.out.println(key.substring(1) + ": " + value));

        System.out.println("\n\nEntries only on the right\n--------------------------");
        difference.entriesOnlyOnRight()
                .forEach((key, value) -> System.out.println(key.substring(1) + ": " + value));

        System.out.println("\n\nEntries differing\n--------------------------");
        difference.entriesDiffering()
                .forEach((key, value) -> System.out.println(key + ": " + value));
        return difference;
    }*/

    public static final LocalDateTime atBeginOfDay(LocalDateTime localDateTime) {
        if (isNull(localDateTime)) {
            return localDateTime;
        }
        return localDateTime.toLocalDate().atTime(LocalTime.MIDNIGHT);
    }

    public static final LocalDateTime atEndOfDay(LocalDateTime localDateTime) {
        if (isNull(localDateTime)) {
            return localDateTime;
        }
        return localDateTime.toLocalDate().atTime(LocalTime.MAX);
    }

    /**
     * Tra ve doi tuong default neu object la null, neu khong thi tra object
     *
     * @param object
     * @param defaultValue
     * @param <T>
     * @return
     */
    public static <T> T defaultIfNull(final T object, final T defaultValue) {
        return object != null ? object : defaultValue;
    }

    /**
     * Copy du lieu tu bean sang bean moi
     * Luu y chi copy duoc cac doi tuong o ngoai cung, list se duoc copy theo tham chieu
     * <p>
     * Chi dung duoc cho cac bean java, khong dung duoc voi cac doi tuong dang nhu String, Integer, Long...
     *
     * @param source
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T cloneBean(T source) {
        try {
            if (source == null) {
                return null;
            }
            T dto = (T) source.getClass().getConstructor().newInstance();
            BeanUtils.copyProperties(source, dto);
            return dto;
        } catch (Exception e) {
            return null;
        }
    }

    public static String toUpper(String input) {
        if (isNullOrEmpty(input)) {
            return input;
        }
        return input.toUpperCase();
    }

    public static String trim(Object obj) {
        if (isNull(obj)) {
            return null;
        }
        if (obj instanceof String) {
            return ((String) obj).trim();
        }
        return parseToString(obj);
    }

    public static boolean isAnyNull(Object... obj) {
        for (Object o : obj) {
            if (o instanceof String) {
                if (isNullOrEmpty(o)) {
                    return true;
                }
            } else {
                if (o == null) {
                    return true;
                }
            }

        }
        return false;
    }

}
