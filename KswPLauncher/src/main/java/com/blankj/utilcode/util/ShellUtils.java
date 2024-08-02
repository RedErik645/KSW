package com.blankj.utilcode.util;

import com.blankj.utilcode.util.Utils;
import java.util.List;

public final class ShellUtils {
    private static final String LINE_SEP = System.getProperty("line.separator");

    private ShellUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Utils.Task<CommandResult> execCmdAsync(String command, boolean isRooted, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(new String[]{command}, isRooted, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(List<String> commands, boolean isRooted, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(commands == null ? null : (String[]) commands.toArray(new String[0]), isRooted, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(String[] commands, boolean isRooted, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(commands, isRooted, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(String command, boolean isRooted, boolean isNeedResultMsg, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(new String[]{command}, isRooted, isNeedResultMsg, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(List<String> commands, boolean isRooted, boolean isNeedResultMsg, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(commands == null ? null : (String[]) commands.toArray(new String[0]), isRooted, isNeedResultMsg, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(final String[] commands, final boolean isRooted, final boolean isNeedResultMsg, Utils.Consumer<CommandResult> consumer) {
        if (consumer != null) {
            return UtilsBridge.doAsync(new Utils.Task<CommandResult>(consumer) {
                /* class com.blankj.utilcode.util.ShellUtils.AnonymousClass1 */

                @Override // com.blankj.utilcode.util.ThreadUtils.Task
                public CommandResult doInBackground() {
                    return ShellUtils.execCmd(commands, isRooted, isNeedResultMsg);
                }
            });
        }
        throw new NullPointerException("Argument 'consumer' of type Utils.Consumer<CommandResult> (#3 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static CommandResult execCmd(String command, boolean isRooted) {
        return execCmd(new String[]{command}, isRooted, true);
    }

    public static CommandResult execCmd(List<String> commands, boolean isRooted) {
        return execCmd(commands == null ? null : (String[]) commands.toArray(new String[0]), isRooted, true);
    }

    public static CommandResult execCmd(String[] commands, boolean isRooted) {
        return execCmd(commands, isRooted, true);
    }

    public static CommandResult execCmd(String command, boolean isRooted, boolean isNeedResultMsg) {
        return execCmd(new String[]{command}, isRooted, isNeedResultMsg);
    }

    public static CommandResult execCmd(List<String> commands, boolean isRooted, boolean isNeedResultMsg) {
        return execCmd(commands == null ? null : (String[]) commands.toArray(new String[0]), isRooted, isNeedResultMsg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ec, code lost:
        if (r3 != null) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ee, code lost:
        r3.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x011c, code lost:
        if (0 == 0) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0121, code lost:
        if (r6 != null) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0123, code lost:
        r9 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0125, code lost:
        r9 = r6.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0129, code lost:
        if (r7 != null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x012c, code lost:
        r2 = r7.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0133, code lost:
        return new com.blankj.utilcode.util.ShellUtils.CommandResult(r1, r9, r2);
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d6 A[SYNTHETIC, Splitter:B:36:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e2 A[SYNTHETIC, Splitter:B:41:0x00e2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blankj.utilcode.util.ShellUtils.CommandResult execCmd(java.lang.String[] r13, boolean r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 356
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ShellUtils.execCmd(java.lang.String[], boolean, boolean):com.blankj.utilcode.util.ShellUtils$CommandResult");
    }

    public static class CommandResult {
        public String errorMsg;
        public int result;
        public String successMsg;

        public CommandResult(int result2, String successMsg2, String errorMsg2) {
            this.result = result2;
            this.successMsg = successMsg2;
            this.errorMsg = errorMsg2;
        }

        public String toString() {
            return "result: " + this.result + "\nsuccessMsg: " + this.successMsg + "\nerrorMsg: " + this.errorMsg;
        }
    }
}
