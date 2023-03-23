package com.common.constant;

import org.apache.http.HttpHost;

import java.util.List;

import static java.util.List.*;

public class Constants {
    public static final String SEPARATOR = ",";
    public static final String SEMI_COLON = ";";
    public static final String SLASH = "/";
    public static final String COLON = ":";
    public static final String SHARP = "#";
    public static final String CROSS = "|";
    public static final String SPLIT_CROSS = "\\|";
    public static final String SPACE = " ";
    public static final String IMPORT_POLICY_START_VERSION = "1";
    public static final String TRUE = "true";
    public static final String REQUEST_ATTACH_VOFFICE_TYPE = "PRE_VIEW_VOFFICE";

    public static final String ID_SEPARATE_DASH = "-";
    public static final String DEFAULT_VALUE_MAP_SELECT_ALL = "-1";
    public static final String TIME_NEW_ROMAN = "Times New Roman";

    public static final String PDF_COMPONENT_PROPERTY_BLOCK_HEADER = "THÔNG TIN YÊU CẦU";
    public static final String PDF_PROPERTY_VALUE_BLOCK_HEADER = "THÔNG TIN KINH DOANH MÔ TẢ";
    public static final String PDF_PROPERTY_CURRENT_VALUE = "THÔNG TIN HIỆN TẠI";
    public static final String PDF_PROPERTY_NEW_VALUE = "THÔNG TIN MỚI";

    public static final String VOFFICE_DEPARTMENT = "VOFFICE_DEPARTMENT";
    public static final class MODULE_DISPLAY_TYPE {

        public static final String NORMAL = "1";
        public static final String MESSAGE = "2";
    };

    public static final class PO_MAP_REQUEST_FILE_STATUS {
        public static final String FAIL = "0";
        public static final String WAITING = "1";
        public static final String SUCCESS = "3";
        public static final class STATUS_DETAIL {
            public static final String EMPTY_ERROR_FAIL = "EMPTY_ERROR_FAIL";
            public static final String WAITING = "WAITING";
            public static final String SUCCESS = "SUCCESS";
            public static final String STATUS_DETAIL = "STATUS_DETAIL";
        }
    };

    public static final class FILTER_WS_TYPE {
        public static final Integer WS_SYNC = 1;
        public static final Integer WS_DEPLOY = 2;
    };

    public static final class REQUEST_HEADER {
        private REQUEST_HEADER() {

        }
        public static final String USER_NAME = "USER-NAME";
        public static final String LANGUAGE = "LANGUAGE";
        public static final String AUTHORIZATION = "Authorization";
        public static final String ACCEPT_LANGUAGE = "Accept-Language";
        public static final String USER_INFOR = "userInfo";
        public static final String LANG_VI = "vi-VN";
        public static final String LANG_EN = "en-US";

    }

    public static final Long POLICY_VERSION_ZERO = 0L;

    public static final class ERROR_CODE {
        public static final String SUCCESS = "0";
        public static final String INVALID = "1";
        public static final String UNAUTHORIZED = "2";
        public static final String SYSTEM_ERROR = "99";

    }

    public static final class CLASS_TEMPLATE {
        public static final String IMPORT_POLICY = "templates/policy_import_template.xlsx";
        public static final String IMPORT_POLICY_RESULT = "templates/po_policy_import_test_result.xlsx";
        public static final String FAKE_VOFFICE_FILE = "jasper/PHULUCTRINHKY.pdf";


        public static final String VOF2_GET_MAIL_VOFFICE_XML = "templates/getListVof2UserByMail.xml";
        public static final String VOF2_GET_MAIL_VOFFICE_RESPONSE_XML = "templates/getListVof2UserByMailResponse.xml";
        public static final String VOF2_REG_DIGITAL_DOC_XML = "templates/Vo2RegDigitalDocByEmail.xml";
        public static final String VOF2_REG_DIGITAL_DOC_RESPONSE_XML = "templates/Vo2RegDigitalDocByEmailResponse.xml";
        public static final String QLTT_TEST_XML = "templates/qltt.xml";
    }

    public static final class JASPER_TEMPLATE {
        public static final String VOFFICE_REQUEST_CATALOG = "jasper/REQUEST_CATALOG.jrxml";
    }

    public static final class ActionCode {
        private ActionCode() {}

        public static final String ACTION_AUDIT_ADD = "ADD";
        public static final String ACTION_AUDIT_UPDATE = "UPDATE";
        public static final String ACTION_AUDIT_DELETE = "DELETE";
        public static final String ACTION_DELETE_LOGIC = "DELETE_LOGIC";
        public static final String CC_TEST = "CC_TEST";
        public static final String POLICY_COMPLETE = "POLICY_COMPLETE";
    }

    public static final class RequestStatus {
        public static final String LOI_TRINH_KY = "-1";
        public static final String TU_CHOI_DUYET_KICH_BAN = "-2";
        public static final String DA_GUI_KIEM_DUYET = "-3";
        public static final String HET_HIEU_LUC = "0";
        public static final String THEM_MOI = "1";
        public static final String DONG = "10";
        public static final String DA_DUYET_KICH_BAN_TUONG_TAC = "2";
        public static final String DA_TAO_YEU_CAU_TRINH_KY = "3";
        public static final String CHO_XAY_DUNG_MOP = "35";
        public static final String HOAN_THANH_MOP = "36";
        public static final String DA_CAP_CHO_FO = "37";
        public static final String CHO_FO_TAC_DONG = "38";
        public static final String DANG_CHO_KY = "4";
        public static final String CHO_NGHIEM_THU = "40";
        public static final String TU_CHOI_KY_DUYET = "5";
        public static final String DA_KY_DUYET = "6";
        public static final String TU_CHOI_TIEP_NHAN = "7";
        public static final String KY_THUAT_DANG_THUC_HIEN = "8";
        public static final String TRIEN_KHAI = "9";
        public static final String TU_CHOI_MOP = "98";

        public static final String[] statusValid = {
          LOI_TRINH_KY, TU_CHOI_DUYET_KICH_BAN, DA_GUI_KIEM_DUYET, HET_HIEU_LUC, THEM_MOI, DONG, DA_DUYET_KICH_BAN_TUONG_TAC, DA_TAO_YEU_CAU_TRINH_KY, CHO_XAY_DUNG_MOP,
          HOAN_THANH_MOP, DA_CAP_CHO_FO, CHO_FO_TAC_DONG, DANG_CHO_KY, CHO_NGHIEM_THU, TU_CHOI_KY_DUYET, DA_KY_DUYET, TU_CHOI_TIEP_NHAN, KY_THUAT_DANG_THUC_HIEN, TRIEN_KHAI
        };
    }

    public static final class POLICY_TIMELINE {
        public static final String CHANGE_STATUS = "CHANGE_STATUS";
    }

    public static final class REQUEST_TIMELINE {
        public static final String ASSIGN = "ASSIGN";
        public static final String CHANGE_STATUS = "CHANGE_STATUS";
    }


    public static final class REGEX {
        public static final String REQUEST_CODE = "^[A-Z0-9_]+$";

        public static final String REGEX_STRING_50 = "^[a-zA-Z0-9_.]{1,50}$";
        public static final String REGEX_ALL_20 = "^.{1,20}$";
        public static final String REGEX_ALL_50 = "^.{1,50}$";
        public static final String REGEX_ALL_100 = "^.{1,100}$";
        public static final String REGEX_ALL_2000 = "^.{1,2000}$";
        public static final String REGEX_ALL_200 = "^.{0,200}$";
        public static final String REGEX_INT = "^([0-9]|[1-9][0-9])$";
    }

    public static final class STATUS {
        public static final String ACTIVE = "1";
        public static final String INACTIVE = "0";
    }

    public static final class PO_REQUEST_ASSIGN {
        public static final String ACTIVE = "1";
        public static final String INACTIVE = "0";
    }

    public static final class LOG_ACTION_TYPE {
        public static final String VIEW = "VIEW";
        public static final String INSERT = "INSERT";
        public static final String EDIT = "EDIT";
        public static final String DELETE = "DELETE";
        public static final String SAVE = "SAVE";
    }

    public static final class LOG_TRANSACTION_TYPE {
        public static final String SINGLE = "01";
        public static final String PARENT = "10";
        public static final String CHILD = "100";
    }

    public static final class LOG_VSA {
        public static final String OPTION_SET = "OPTION_SET";
        public static final String PRODUCT_TEMPLATE = "PRODUCT_TEMPLATE";
        public static final String API_MGMT = "API_MGMT";
        public static final String IMPACT_MGMT = "IMPACT_MGMT";
        public static final String WS_DEFINE = "WS_DEFINE";
        public static final String MAPPING_WS = "IMPACT_MGMT";
        public static final String PRODUCT_SEARCH = "PRODUCT_SEARCH";
        public static final String PRODUCT_UNLOCK = "PRODUCT_UNLOCK";
        public static final String REQUEST_MANAGER = "REQUEST_MANAGER";
    }

    public static final class LOG_SERVICE_CODE {
        public static final String POLICY_SERVICE = "CATALOG_POLICY_SERVICE";
        public static final String TEMPLATE_SERVICE = "CATALOG_TEMPLATE_SERVICE";
        public static final String CONFIG_SERVICE = "CATALOG_TEMPLATE_SERVICE";
        public static final String SYNC_SERVICE = "CATALOG_SYNC_SERVICE";
        public static final String LOG_SERVICE = "CATALOG_LOG_SERVICE";
        public static final String NOTIFICATION_SERVICE = "CATALOG_NOTIFICATION_SERVICE";
        public static final String SERVICE_CATALOG = "SERVICE_CATALOG";
    }

    public static final class NOTIFICATION_TYPE {
        public static final long SMS = 0;
        public static final long EMAIL = 1;
    }

    public static final class NOTIFICATION{
        public static final String REQUEST_POLICY_REJECT_SUBJECT = "REJECT_POLICY";
        public static final String REQUEST_COMMENT_ADD_SUBJECT ="REQUEST";
        public static final String REQUEST_ASSIGN_ADD_SUBJECT="REQUEST_ASSIGN";
    }

    public static final class POLICY_STATUS {
        public static final String POLICY_STATUS_LABEL = "POLICY_STATUS";
        public static final String TU_CHOI = "-1";
        public static final String HET_HIEU_LUC = "0";
        public static final String DANG_KHAI_BAO = "7";
        public static final String HOAN_THANH_KHAI_BAO = "12";
        public static final String DONG_BO_TEST_LAB = "13";
        public static final String SYNC_TEST_LAB_SUCCESS = "15";
        public static final String SYNC_TEST_LAB = "13";
        public static final String SYNC_SUCCESS = "21";
        public static final String SYNC_REAL = "19";
        public static final String TEST_TEST_LAB_THANH_CONG = "18";
        public static final String DONG_BO_HE_THONG_THAT = "19";
        public static final String HOAN_THIEN_SP = "36";


        public static final String[] statusValid = {
                HET_HIEU_LUC, DANG_KHAI_BAO, HOAN_THANH_KHAI_BAO,DONG_BO_TEST_LAB,
                SYNC_TEST_LAB_SUCCESS, SYNC_TEST_LAB, SYNC_SUCCESS, SYNC_REAL
        };
    }

    public static final class POLICY_TYPE {
        public static final String KHAI_BAO_MOI = "0";
        public static final String SUA_DOI = "1";

        public static final String[] typeValid = {
            KHAI_BAO_MOI, SUA_DOI
        };
    }

    public static final class MODULE_TYPE {
        public static final String BUSSINESS = "0";
        public static final String TECHNICAL = "1";
        public static final String ALL = "2";
    }

    public static final class USE_ACTION_TYPE {
        public static final String ADD = "ADD";
        public static final String UPDATE = "UPDATE";
        public static final String DELETE = "DELETE";
        public static final String REMOVE = "REMOVE";
    }

    public static final class KEY_REDIS {
        public static final long LOCK_TIME = 180l;
        public static final long EXPIRE_TIME_DATA = 36000l;

        public static final String LOCK_POLICY = "LOCK_POLICY";

        public static final String CATALOG_POLICY_TYPE ="CATALOG_POLICY_TYPE";

        public static final String CATALOG_POLICY_TYPE_EXPORT_EXCEL ="CATALOG_POLICY_TYPE_EXPORT_EXCEL";

        public static final String CATALOG_POLICY_TYPE_PROPERTY_LIST="CATALOG_POLICY_TYPE_PROPERTY_LIST";
    }

    public static final class LOCK_POLICY {
        public static final Long LOCK = 1L;
        public static final Long UN_LOCK = 0L;

        public static final String LOCK_S = "1";
        public static final String UN_LOCK_S = "0";

        public static final String[] lockValid = {
                LOCK_S, UN_LOCK_S
        };
    }

    public static final class RENDER {
        public static final Long SHOW = 1L;
        public static final Long HIDE = 0L;

        public static final String SHOW_S = "1";
        public static final String HIDE_S = "0";

        public static final String[] isRenderValid = {
                SHOW_S, HIDE_S
        };
    }

    public static final class HIDE {
        public static final Long SHOW = 0L;
        public static final Long HIDE_VALUE = 1L;

        public static final String SHOW_S = "0";
        public static final String HIDE_S = "1";

        public static final String[] isRenderValid = {
                SHOW_S, HIDE_S
        };
    }

    public static final class CONFIG {
        public static final String DEFAULT_TIME_ZONE = "Asia/Ho_Chi_Minh";
    }

    public final static class OPTION_SET {
        public final static String SYNC_POLICY_ELASTIC_POLICY_TYPE_ID_QUERY_1 = "SYNC_POLICY_ELASTIC_POLICY_TYPE_ID_QUERY_1";
        public final static String SYNC_POLICY_ELASTIC_POLICY_TYPE_ID_QUERY_2_V1 = "SYNC_POLICY_ELASTIC_POLICY_TYPE_ID_QUERY_2_V1";
        public final static String SYNC_POLICY_ELASTIC_PROPERTY_ID = "SYNC_POLICY_ELASTIC_PROPERTY_ID";
        public final static String CHANNEL_WS = "CHANNEL_WS";
        public final static String LOCK_SYNC_WS = "LOCK_SYNC_WS";
        public final static String SYNC_N_DATE_BEFORE_TO_ELASTIC = "SYNC_N_DATE_BEFORE_TO_ELASTIC";
        public final static String PO_PROPERTY_SYNC_098 = "PO_PROPERTY_SYNC_098";
        public final static String SYNC_098_MULTIPLE_REQUEST = "SYNC_098_MULTIPLE_REQUEST";
        public final static String IGNORE_WS = "IGNORE_WS";
        public static final String SYNC_PROPERTY_ADDON_098 = "SYNC_PROPERTY_ADDON_098";
        public static final String SYNC_PROPERTY_VALUE_ADDON_098 = "SYNC_PROPERTY_VALUE_ADDON_098";

        public static final String SYNC_PROPERTY_PREFIX_222 = "SYNC_PROPERTY_PREFIX_222";
        public static final String SYNC_PROPERTY_VALUE_PREFIX_222 = "SYNC_PROPERTY_VALUE_PREFIX_222";


        public static class NOTIFICATION_POLICY_SYNC_TYPE {
            public static final String TEST_LAB = "SEND_OUTSIDE_APP_NOTIFICATION_TESTLAB";
            public static final String REAL = "SEND_OUTSIDE_APP_NOTIFICATION_REAL";
            public static final String SUBJECT = "SEND_OUTSIDE_APP_NOTIFICATION_SUBJECT";
        }
        public static class PRODUCT_WS_SYNC{
            public static final String WS_PRODUCT_FILTER = "WS_PRODUCT_FILTER";
            public static final String SEQUENCE_PRODUCT_TABLE = "SEQUENCE_PRODUCT_TABLE";
            public static final String ID_PROPERTY_CODE =  "TABLE_PRODUCT_SEQ";
        }

        public static class PRODUCT_VAS {
            public static final String CODE = "PRODUCT_VAS";
            public static final String PROPERTY_X = "PROPERTY_X";
        }

        private OPTION_SET() {
        }

        public static class SYNC_ENVIRONMENT {
            public static final String TEST_LAB = "1";
            public  static final String REAL = "2";
        }
    }

    public static final class PO_POLICY_SYNC {
        public final static Long SUCCESS = 1L;
        public final static Long FAILED = 2L;
        public final static Long ROLLBACK_SUCCESS = 3L;
        public final static Long ROLLBACK_FAIL = 4L;
        public final static Long PROCESSING = 0L;
        public final static Long TYPE_SOAP = 1L;
        public final static Long TYPE_REST_POST = 2L;
        public final static Long TYPE_REST_PUT = 3L;
        public final static Long TYPE_REST_GET = 4L;
        public final static String ERROR_CODE_SUCCESS = "0";
        public final static String ERROR_CODE_DEFAULT = "errorCode";
        public final static String ERROR_DESC_DEFAULT = "errorDescription";
        public final static String MESSAGE_KEY = "message";
        public final static Long TYPE_TEST_LAB = 1l;
        public final static Long TYPE_REAL_SYSTEM = 2l;
        public final static Integer HOUR_DISTANCE = 24;
        public final static String SPEC_CHAR = "##";
        public final static String POLICY_CODE = "POLICY_CODE";
        public final static String POLICY_NAME = "POLICY_NAME";
        public final static String POLICY_DESC = "POLICY_DESC";
        public final static String POLICY_TYPE = "POLICY_TYPE";
        public final static String POLICY_TYPE_NAME = "POLICY_TYPE_NAME";
        public final static String POLICY_TYPE_ID= "POLICY_TYPE_ID";
        public final static String POLICY_STATUS = "POLICY_STATUS";
        public static final String POLICY_ID = "POLICY_ID";



        public final static String POLICY_VERSION = "POLICY_VERSION";
        public final static String POLICY_CURRENT_ID = "POLICY_CURRENT_ID";
        public final static String SPEC_CHAR_LIST_1 = ", ";
        public final static String SPEC_CHAR_LIST_2 = "|";

        public static class SYNC_TYPE {
            public static final Long SYNC = 1l;
            public static final Long ROLLBACK = 2l;
            public static final Long SCHEDULE = 3l;
            public static final Long DEPLOY = 4l;
        }

        public static class SYNC_STATUS{
            public static final String WAIT_SYNC = "0";
            public static final String SYNC_SUCCESS = "1";
            public static final String SYNC_FAIL = "2";
        }
    }
    public static final class ELASTIC_INDEX {
        public static final String INDEX_PRODUCT = "product_1";
        public static final String TYPE_DATA = "data_1";
        public static final String TYPE_DATA_HISTORY = "data_his";


        public static final int TYPE_MUST = 1;
        public static final int TYPE_OR = 2;

        //Allowing formats for date type
       /* public static final List<String> DATE_VALUE_TYPE_FORMAT = List.of("dd/MM/yyyy HH:mm:ss", "dd/MM/yyyy");
        public static final String PROPERTY_FORMAT_DELIM = "||";
        public static final int ONE_REQUEST_MAX_FIELD_SIZE = 900;
        public static final List<Integer> TEXT_OPERATORS = List.of(OPERATOR.EQUAL, OPERATOR.CONTAIN, OPERATOR.NOT_EQUAL
                , OPERATOR.IS_EMPTY, OPERATOR.IS_NOT_EMPTY);

        public static final List<Integer> DATE_LONG_OPERATORS = List.of(OPERATOR.EQUAL, OPERATOR.GT, OPERATOR.GTE, OPERATOR.LT, OPERATOR.LTE, OPERATOR.NOT_EQUAL
                , OPERATOR.IS_NOT_EMPTY);*/

        public static final String DEFAULT_USER = "elastic";
        public static final String DEFAULT_PASS = "elastic";
        public static final String DEFAULT_TOKENIZER = "TAS_analyzer";
        public static final HttpHost DEFAULT_HOST = new HttpHost("10.58.71.159", 9200);


        public static final class VALUE_TYPE {

            public static final Integer DATE = 3;
            public static final Integer LONG = 2;
            public static final Integer TEXT = 1;
        } ;


        public static class OPERATOR {
            public static final Integer EQUAL = 0;
            public static final Integer GT = 1;
            public static final Integer GTE = 2;
            public static final Integer LT = 3;
            public static final Integer LTE = 4;
            public static final Integer CONTAIN = 6;

            public static final Integer NOT_EQUAL = 11;

            public static final Integer IS_EMPTY = 12;

            public static final Integer IS_NOT_EMPTY = 13;
        }


        public static final String MAPPING_TYPE = "MAPPING_TYPE";

    }

    public enum VALUE_TYPE {
        STRING("1"), DIGIT("2"), TIME("3"),
        BOOLEAN("4"), SELECT_ONE("5"), SELECT_MANY("6"),
        TEXT_AREA("7"), EDITOR("8"), COMBOBOX_OR_TEXT("9"),
        IMAGE("10"), TREE("11"), DATETIME("12"),
        RELATION("13"), TEXT_AREA_DEFAULT("14"),
        TABLE("15"), RULE_TABLE("16"), TEMPLATE_TABLE("17"), BUTTON("18"),
        VAS_NOT_SUPPORT("19"), SQL("20"), TABLE_CLOB("21"), TABLE_PRODUCT("22"), ID("23"), SELECT_MANY_CLOB("24")
        , TABLE_098("25") ;
        private String type;

        VALUE_TYPE(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static final class PO_COMPONENT_TYPE {
        //MinhNH
        public enum VALUE_TYPE {
            STRING("1"), DIGIT("2"), TIME("3"),
            BOOLEAN("4"), SELECT_ONE("5"), SELECT_MANY("6"),
            TEXT_AREA("7"), EDITOR("8"), COMBOBOX_OR_TEXT("9"),
            IMAGE("10"), TREE("11"), DATETIME("12"),
            RELATION("13"), TEXT_AREA_DEFAULT("14"),
            TABLE("15"), RULE_TABLE("16"), TEMPLATE_TABLE("17"), BUTTON("18"),
            VAS_NOT_SUPPORT("19"), SQL("20"), TABLE_CLOB("21"), TABLE_PRODUCT("22"), ID("23"), SELECT_MANY_CLOB("24");

            private String type;

            VALUE_TYPE(String type) {
                this.type = type;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

    }

    public static final class OPERATOR {
        public static final String EQUAL = "0";
        public static final String GT = "1";
        public static final String GTE = "2";
        public static final String LT = "3";
        public static final String LTE = "4";
        public static final String IN = "5";
        public static final String CONTAIN = "6";
        public static final String NOTNULL = "7";
        public static final String NULL = "8";
        public static final String NE = "9";
        public static final String NOTIN = "10";
        public static final String NOTCONTAIN = "11";
        public static final String IS_EMPTY = "12";
        public static final String IS_NOT_EMPTY = "13";

        public static final String OPERATOR = "OPERATOR";
    }

    public static final class PO_POLICY_STATUS {
        public final static String POLICY_STATUS = "POLICY_STATUS";
        public final static String HET_HIEU_LUC = "0";
        public final static String DE_XUAT = "1";
        public final static String DANG_TRINH_KY = "2";
        public final static String DA_KY_DUYET = "3";
        public final static String TU_CHOI_KY = "4";
        public final static String DA_TIEP_NHAN = "5";
        public final static String TU_CHOI_TIEP_NHAN = "6";
        public final static String DANG_KHAI_BAO = "7";
        public final static String CHO_NANG_CAP_PM = "8";
        public final static String CHO_KHAI_BAO_TEMPLATE = "9";
        public final static String HOAN_THANH_KHAI_BAO_TEMPLATE = "10";
        public final static String HOAN_THANH_NANG_CAP_PM = "11";
        public final static String HOAN_THANH_KHAI_BAO = "12";
        public final static String DONG_BO_TEST_LAP = "13";
        public final static String DONG_BO_TEST_LAP_FAIL = "14";
        public final static String DONG_BO_TEST_LAP_SUCCESS = "15";
        public final static String CC_TEST_TEST_LAP = "16";
        public final static String CC_TEST_TEST_LAP_FAIL = "17";
        public final static String CC_TEST_TEST_LAP_SUCCESS = "18";
        public final static String DONG_BO_HE_THONG_THAT = "19";
        public final static String DONG_BO_FAIL = "20";
        public final static String DONG_BO_SUCCESS = "21";
        public final static String CC_TEST = "22";
        public final static String CC_TEST_FAIL = "23";
        public final static String CC_TEST_SUCCESS = "24";
        public final static String ROLLBACK_DL = "25";
        public final static String TRIEN_KHAI = "26";
        public final static String DANG_TRIEN_KHAI = "29";
        public final static String TRIEN_KHAI_THAT_BAI = "30";
        public final static String SAVING_VERSION = "27";
        public final static String SAVING_VERSION_FAIL = "28";
        public final static String ROLLBACK_SUCCESS = "32"; //rollback thanh cong
        public final static String ROLLBACK_INPROGRESS = "31"; //dang tien hanh rollback
        public final static String ROLLBACK_FAIL = "33"; //Rollback that bai, Huy bo rollback
        public final static String DANG_CHO_TRIEN_KHAI = "44"; //Rollback that bai, Huy bo rollback
        public final static String TU_CHOI = "-1"; //Rollback that bai, Huy bo rollback
        public final static String HOAN_THIEN_SANPHAM = "36"; //Rollback that bai, Huy bo rollback

    }

    public final static class KEY_REDIS_CACHE {
        public final static String CACHE_RENDER_RELA = "CACHE_RENDER_RELA";
        public final static String CACHE_GET_FULL_INFO_POLICY_TYPE = "CACHE_GET_FULL_INFO_POLICY_TYPE";
        public final static String CACHE_GET_FULL_INFO_PROPERTY = "CACHE_GET_FULL_INFO_PROPERTY";
        public final static String CACHE_PROPERTY_VALUE_TYPE_BY_TEMPLATE_ID_AND_PROPERTY_ID = "CACHE_PROPERTY_VALUE_TYPE_BY_TEMPLATE_ID_AND_PROPERTY_ID";
        public final static String CACHE_POLICY_USE_LIST_BY_CODE = "CACHE_POLICY_USE_LIST_BY_CODE";
        public final static String CACHE_COMPONENT_TYPE_ID_AND_PROPERTY_ID = "CACHE_COMPONENT_TYPE_ID_AND_PROPERTY_ID";
        public final static String CACHE_LIST_MAP_COMPONENT_TYPE_PROPERTY_HIS = "CACHE_LIST_MAP_COMPONENT_TYPE_PROPERTY_HIS";
        public final static String CACHE_LIST_MAP_COMPONENT_TYPE_PROPERTY = "CACHE_LIST_MAP_COMPONENT_TYPE_PROPERTY";
        public final static String CACHE_RELATION = "CACHE_RELATION";
        public final static String CACHE_REQUEST_POLICY = "CACHE_REQUEST_POLICY";
        public final static String CACHE_POLICY_CONTROLLER_FULL = "CACHE_POLICY_CONTROLLER_FULL";
        public final static String CACHE_POLICY_CONTROLLER_LOCK = "CACHE_POLICY_CONTROLLER_LOCK";
        public final static String CACHE_POLICY_RULE = "CACHE_POLICY_RULE";
        public final static String CACHE_LIST_TREE = "CACHE_LIST_TREE";
        public final static String CACHE_OUT_SIDE_MAPPING_BY_FUNCTION_NAME = "CACHE_OUT_SIDE_MAPPING_BY_FUNCTION_NAME";
        public final static String CACHE_FULL_INFO_MAP_POLICY_MODULE_TYPE = "CACHE_FULL_INFO_MAP_POLICY_MODULE_TYPE";
        public final static String CACHE_FIND_BY_POLICY_ID_AND_PROPERTY_ID = "CACHE_FIND_BY_POLICY_ID_AND_PROPERTY_ID";
        public final static String CACHE_FIND_BY_POLICY_ID_AND_PROPERTY_ID_AND_REL_POLICY_TYPE_ID = "CACHE_FIND_BY_POLICY_ID_AND_PROPERTY_ID_AND_REL_POLICY_TYPE_ID";
        public final static String CACHE_FIND_BY_COMPONENT_TYPE_ID_AND_PROPERTY_ID = "CACHE_FIND_BY_COMPONENT_TYPE_ID_AND_PROPERTY_ID";
        public final static String CACHE_FIND_LIST_POLICY_USE_WITH_REQUIRED = "CACHE_FIND_LIST_POLICY_USE_WITH_REQUIRED";
        public final static String CACHE_MAP_POLICY_TYPE = "CACHE_MAP_POLICY_TYPE";
        public final static String CACHE_MAP_UPDATE_POLICY_CONFIG = "CACHE_MAP_UPDATE_POLICY_CONFIG";
        public final static String CACHE_MAP_POLICY_TYPE_HIS = "CACHE_MAP_POLICY_TYPE_HIS";
        public final static String CACHE_LIST_PROPERTY_APP = "CACHE_LIST_PROPERTY_APP";
        public final static String CACHE_LIST_PROPERTY_COMMENT = "CACHE_LIST_PROPERTY_COMMENT";
        public final static String CACHE_GET_POLICY_USE_LIST_BY_ALL_TYPE = "CACHE_GET_POLICY_USE_LIST_BY_ALL_TYPE";
        public final static String CACHE_GET_POLICY_USE_LIST_BY_ALL_TYPE_2 = "CACHE_GET_POLICY_USE_LIST_BY_ALL_TYPE_2";
        public final static String CACHE_GET_POLICY_USE_LIST_BY_ALL_TYPE_3 = "CACHE_GET_POLICY_USE_LIST_BY_ALL_TYPE_3";
        public final static String WS_PRODUCT_CATALOG = "WS_PRODUCT_CATALOG___";

    }

    public static final class FILE_ATTACH_TYPE {
        public final static String CC_TEST_BY_NO_v2 = "CC_TEST_BY_NO_V2";

        public final static String CC_TEST_BY_NO = "CC_TEST_BY_NO";
        public final static String COMPLETE_BY_NO = "COMPLETE_BY_NO_V2";
        public static final String ATTACH_VOFFICE = "PRE_VIEW_VOFFICE";
    }
    public static final class RECEIVER_TYPE {
        public final static int UPDATE_MOP = 0;
        public final static int REJECT_MOP = 1;
        public final static int ACCEPT_MOP = 2;
        public final static int ACCEPT_FO = 3;
    }
    public static final class FILE_TYPE {
        public final static String MOP = "MOP";
        public final static String REJECT_MOP = "REJECT_MOP";
        public final static String APPROVE_MOP = "APPROVE_MOP";
    }
    public static final class RECEIVE_CAP_STATUS {
        public static final String APPROVE = "1";
        public static final String REJECT = "0";
    }

    public class IMPORT_POLICY {
        public static final String PROPERTY_VALUE_SHEET_NAME = "Giá trị thuộc tính import";
    }
}
