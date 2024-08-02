package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class WifiResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public WifiParsedResult parse(Result result) {
        String rawText;
        String ssid;
        String rawText2 = getMassagedText(result);
        if (!rawText2.startsWith("WIFI:") || (ssid = matchSinglePrefixedField("S:", (rawText = rawText2.substring(5)), ';', false)) == null || ssid.isEmpty()) {
            return null;
        }
        String pass = matchSinglePrefixedField("P:", rawText, ';', false);
        String matchSinglePrefixedField = matchSinglePrefixedField("T:", rawText, ';', false);
        String type = matchSinglePrefixedField;
        if (matchSinglePrefixedField == null) {
            type = "nopass";
        }
        return new WifiParsedResult(type, ssid, pass, Boolean.parseBoolean(matchSinglePrefixedField("H:", rawText, ';', false)), matchSinglePrefixedField("I:", rawText, ';', false), matchSinglePrefixedField("A:", rawText, ';', false), matchSinglePrefixedField("E:", rawText, ';', false), matchSinglePrefixedField("H:", rawText, ';', false));
    }
}
