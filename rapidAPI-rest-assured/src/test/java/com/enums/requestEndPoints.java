package com.enums;

public enum requestEndPoints {

    REPORT_COUNTRY_NAME {
        public String toString() {
            return "/report/country/name";
        }},
    REPORT_COUNTRY {
        public String toString() {
            return "/report/country/all";
        }},
    REPORT_COUNTRY_CODE {
        public String toString() {
            return "/report/country/code";
        }},
    COUNTRY_CODE {
        public String toString() {
            return "/country/code";
        }},
    COUNTRY_NAME {
        public String toString() {
            return "/country";
        }},
}



