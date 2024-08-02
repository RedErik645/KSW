package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Map;
import java.util.regex.Pattern;

public final class EmailAddressResultParser extends ResultParser {
    private static final Pattern COMMA = Pattern.compile(",");

    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String rawText = getMassagedText(result);
        if (rawText.startsWith("mailto:") || rawText.startsWith("MAILTO:")) {
            String substring = rawText.substring(7);
            String hostEmail = substring;
            int queryStart = substring.indexOf(63);
            if (queryStart >= 0) {
                hostEmail = hostEmail.substring(0, queryStart);
            }
            try {
                String hostEmail2 = urlDecode(hostEmail);
                String[] tos = null;
                if (!hostEmail2.isEmpty()) {
                    tos = COMMA.split(hostEmail2);
                }
                Map<String, String> nameValues = parseNameValuePairs(rawText);
                String[] ccs = null;
                String[] bccs = null;
                String subject = null;
                String body = null;
                if (nameValues != null) {
                    if (tos == null) {
                        String tosString = nameValues.get("to");
                        if (tosString != null) {
                            tos = COMMA.split(tosString);
                        }
                    }
                    String ccString = nameValues.get("cc");
                    if (ccString != null) {
                        ccs = COMMA.split(ccString);
                    }
                    String bccString = nameValues.get("bcc");
                    if (bccString != null) {
                        bccs = COMMA.split(bccString);
                    }
                    subject = nameValues.get("subject");
                    body = nameValues.get("body");
                }
                return new EmailAddressParsedResult(tos, ccs, bccs, subject, body);
            } catch (IllegalArgumentException e) {
                return null;
            }
        } else if (!EmailDoCoMoResultParser.isBasicallyValidEmailAddress(rawText)) {
            return null;
        } else {
            return new EmailAddressParsedResult(rawText);
        }
    }
}