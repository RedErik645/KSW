package com.blankj.utilcode.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class NetworkUtils {

    public enum NetworkType {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_5G,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    public interface OnNetworkStatusChangedListener {
        void onConnected(NetworkType networkType);

        void onDisconnected();
    }

    private NetworkUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void openWirelessSettings() {
        Utils.getApp().startActivity(new Intent("android.settings.WIRELESS_SETTINGS").setFlags(268435456));
    }

    public static boolean isConnected() {
        NetworkInfo info = getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    public static Utils.Task<Boolean> isAvailableAsync(Utils.Consumer<Boolean> consumer) {
        if (consumer != null) {
            return UtilsBridge.doAsync(new Utils.Task<Boolean>(consumer) {
                /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass1 */

                @Override // com.blankj.utilcode.util.ThreadUtils.Task
                public Boolean doInBackground() {
                    return Boolean.valueOf(NetworkUtils.isAvailable());
                }
            });
        }
        throw new NullPointerException("Argument 'consumer' of type Utils.Consumer<Boolean> (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean isAvailable() {
        return isAvailableByDns() || isAvailableByPing(null);
    }

    public static void isAvailableByPingAsync(Utils.Consumer<Boolean> consumer) {
        isAvailableByPingAsync("", consumer);
    }

    public static Utils.Task<Boolean> isAvailableByPingAsync(final String ip, Utils.Consumer<Boolean> consumer) {
        if (consumer != null) {
            return UtilsBridge.doAsync(new Utils.Task<Boolean>(consumer) {
                /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass2 */

                @Override // com.blankj.utilcode.util.ThreadUtils.Task
                public Boolean doInBackground() {
                    return Boolean.valueOf(NetworkUtils.isAvailableByPing(ip));
                }
            });
        }
        throw new NullPointerException("Argument 'consumer' of type Utils.Consumer<Boolean> (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean isAvailableByPing() {
        return isAvailableByPing("");
    }

    public static boolean isAvailableByPing(String ip) {
        return ShellUtils.execCmd(String.format("ping -c 1 %s", new Object[]{TextUtils.isEmpty(ip) ? "223.5.5.5" : ip}), false).result == 0;
    }

    public static void isAvailableByDnsAsync(Utils.Consumer<Boolean> consumer) {
        isAvailableByDnsAsync("", consumer);
    }

    public static Utils.Task isAvailableByDnsAsync(final String domain, Utils.Consumer<Boolean> consumer) {
        if (consumer != null) {
            return UtilsBridge.doAsync(new Utils.Task<Boolean>(consumer) {
                /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass3 */

                @Override // com.blankj.utilcode.util.ThreadUtils.Task
                public Boolean doInBackground() {
                    return Boolean.valueOf(NetworkUtils.isAvailableByDns(domain));
                }
            });
        }
        throw new NullPointerException("Argument 'consumer' of type Utils.Consumer<Boolean> (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean isAvailableByDns() {
        return isAvailableByDns("");
    }

    public static boolean isAvailableByDns(String domain) {
        try {
            if (InetAddress.getByName(TextUtils.isEmpty(domain) ? "www.baidu.com" : domain) != null) {
                return true;
            }
            return false;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean getMobileDataEnabled() {
        try {
            TelephonyManager tm = (TelephonyManager) Utils.getApp().getSystemService("phone");
            if (tm == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return tm.isDataEnabled();
            }
            Method getMobileDataEnabledMethod = tm.getClass().getDeclaredMethod("getDataEnabled", new Class[0]);
            if (getMobileDataEnabledMethod != null) {
                return ((Boolean) getMobileDataEnabledMethod.invoke(tm, new Object[0])).booleanValue();
            }
            return false;
        } catch (Exception e) {
            Log.e("NetworkUtils", "getMobileDataEnabled: ", e);
        }
    }

    public static boolean isMobileData() {
        NetworkInfo info = getActiveNetworkInfo();
        return info != null && info.isAvailable() && info.getType() == 0;
    }

    public static boolean is4G() {
        NetworkInfo info = getActiveNetworkInfo();
        return info != null && info.isAvailable() && info.getSubtype() == 13;
    }

    public static boolean is5G() {
        NetworkInfo info = getActiveNetworkInfo();
        return info != null && info.isAvailable() && info.getSubtype() == 20;
    }

    public static boolean getWifiEnabled() {
        WifiManager manager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (manager == null) {
            return false;
        }
        return manager.isWifiEnabled();
    }

    public static void setWifiEnabled(boolean enabled) {
        WifiManager manager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (manager != null && enabled != manager.isWifiEnabled()) {
            manager.setWifiEnabled(enabled);
        }
    }

    public static boolean isWifiConnected() {
        NetworkInfo ni;
        ConnectivityManager cm = (ConnectivityManager) Utils.getApp().getSystemService("connectivity");
        if (cm == null || (ni = cm.getActiveNetworkInfo()) == null || ni.getType() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isWifiAvailable() {
        return getWifiEnabled() && isAvailable();
    }

    public static Utils.Task<Boolean> isWifiAvailableAsync(Utils.Consumer<Boolean> consumer) {
        if (consumer != null) {
            return UtilsBridge.doAsync(new Utils.Task<Boolean>(consumer) {
                /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass4 */

                @Override // com.blankj.utilcode.util.ThreadUtils.Task
                public Boolean doInBackground() {
                    return Boolean.valueOf(NetworkUtils.isWifiAvailable());
                }
            });
        }
        throw new NullPointerException("Argument 'consumer' of type Utils.Consumer<Boolean> (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static String getNetworkOperatorName() {
        TelephonyManager tm = (TelephonyManager) Utils.getApp().getSystemService("phone");
        if (tm == null) {
            return "";
        }
        return tm.getNetworkOperatorName();
    }

    public static NetworkType getNetworkType() {
        if (isEthernet()) {
            return NetworkType.NETWORK_ETHERNET;
        }
        NetworkInfo info = getActiveNetworkInfo();
        if (info == null || !info.isAvailable()) {
            return NetworkType.NETWORK_NO;
        }
        if (info.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (info.getType() != 0) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        switch (info.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkType.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkType.NETWORK_3G;
            case 13:
            case 18:
                return NetworkType.NETWORK_4G;
            case 19:
            default:
                String subtypeName = info.getSubtypeName();
                if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                    return NetworkType.NETWORK_3G;
                }
                return NetworkType.NETWORK_UNKNOWN;
            case 20:
                return NetworkType.NETWORK_5G;
        }
    }

    private static boolean isEthernet() {
        NetworkInfo info;
        NetworkInfo.State state;
        ConnectivityManager cm = (ConnectivityManager) Utils.getApp().getSystemService("connectivity");
        if (cm == null || (info = cm.getNetworkInfo(9)) == null || (state = info.getState()) == null) {
            return false;
        }
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return true;
        }
        return false;
    }

    private static NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager cm = (ConnectivityManager) Utils.getApp().getSystemService("connectivity");
        if (cm == null) {
            return null;
        }
        return cm.getActiveNetworkInfo();
    }

    public static Utils.Task<String> getIPAddressAsync(final boolean useIPv4, Utils.Consumer<String> consumer) {
        if (consumer != null) {
            return UtilsBridge.doAsync(new Utils.Task<String>(consumer) {
                /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass5 */

                @Override // com.blankj.utilcode.util.ThreadUtils.Task
                public String doInBackground() {
                    return NetworkUtils.getIPAddress(useIPv4);
                }
            });
        }
        throw new NullPointerException("Argument 'consumer' of type Utils.Consumer<String> (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static String getIPAddress(boolean useIPv4) {
        try {
            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
            LinkedList<InetAddress> adds = new LinkedList<>();
            while (nis.hasMoreElements()) {
                NetworkInterface ni = nis.nextElement();
                if (ni.isUp()) {
                    if (!ni.isLoopback()) {
                        Enumeration<InetAddress> addresses = ni.getInetAddresses();
                        while (addresses.hasMoreElements()) {
                            adds.addFirst(addresses.nextElement());
                        }
                    }
                }
            }
            Iterator<InetAddress> it = adds.iterator();
            while (it.hasNext()) {
                InetAddress add = it.next();
                if (!add.isLoopbackAddress()) {
                    String hostAddress = add.getHostAddress();
                    boolean isIPv4 = hostAddress.indexOf(58) < 0;
                    if (useIPv4) {
                        if (isIPv4) {
                            return hostAddress;
                        }
                    } else if (!isIPv4) {
                        int index = hostAddress.indexOf(37);
                        if (index < 0) {
                            return hostAddress.toUpperCase();
                        }
                        return hostAddress.substring(0, index).toUpperCase();
                    }
                }
            }
            return "";
        } catch (SocketException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getBroadcastIpAddress() {
        try {
            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
            new LinkedList();
            while (nis.hasMoreElements()) {
                NetworkInterface ni = nis.nextElement();
                if (ni.isUp()) {
                    if (!ni.isLoopback()) {
                        List<InterfaceAddress> ias = ni.getInterfaceAddresses();
                        int size = ias.size();
                        for (int i = 0; i < size; i++) {
                            InetAddress broadcast = ias.get(i).getBroadcast();
                            if (broadcast != null) {
                                return broadcast.getHostAddress();
                            }
                        }
                        continue;
                    }
                }
            }
            return "";
        } catch (SocketException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Utils.Task<String> getDomainAddressAsync(final String domain, Utils.Consumer<String> consumer) {
        if (consumer != null) {
            return UtilsBridge.doAsync(new Utils.Task<String>(consumer) {
                /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass6 */

                @Override // com.blankj.utilcode.util.ThreadUtils.Task
                public String doInBackground() {
                    return NetworkUtils.getDomainAddress(domain);
                }
            });
        }
        throw new NullPointerException("Argument 'consumer' of type Utils.Consumer<String> (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static String getDomainAddress(String domain) {
        try {
            return InetAddress.getByName(domain).getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getIpAddressByWifi() {
        WifiManager wm = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wm == null) {
            return "";
        }
        return Formatter.formatIpAddress(wm.getDhcpInfo().ipAddress);
    }

    public static String getGatewayByWifi() {
        WifiManager wm = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wm == null) {
            return "";
        }
        return Formatter.formatIpAddress(wm.getDhcpInfo().gateway);
    }

    public static String getNetMaskByWifi() {
        WifiManager wm = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wm == null) {
            return "";
        }
        return Formatter.formatIpAddress(wm.getDhcpInfo().netmask);
    }

    public static String getServerAddressByWifi() {
        WifiManager wm = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wm == null) {
            return "";
        }
        return Formatter.formatIpAddress(wm.getDhcpInfo().serverAddress);
    }

    public static String getSSID() {
        WifiInfo wi;
        WifiManager wm = (WifiManager) Utils.getApp().getApplicationContext().getSystemService("wifi");
        if (wm == null || (wi = wm.getConnectionInfo()) == null) {
            return "";
        }
        String ssid = wi.getSSID();
        if (TextUtils.isEmpty(ssid)) {
            return "";
        }
        if (ssid.length() > 2 && ssid.charAt(0) == '\"' && ssid.charAt(ssid.length() - 1) == '\"') {
            return ssid.substring(1, ssid.length() - 1);
        }
        return ssid;
    }

    public static void registerNetworkStatusChangedListener(OnNetworkStatusChangedListener listener) {
        NetworkChangedReceiver.getInstance().registerListener(listener);
    }

    public static boolean isRegisteredNetworkStatusChangedListener(OnNetworkStatusChangedListener listener) {
        return NetworkChangedReceiver.getInstance().isRegistered(listener);
    }

    public static void unregisterNetworkStatusChangedListener(OnNetworkStatusChangedListener listener) {
        NetworkChangedReceiver.getInstance().unregisterListener(listener);
    }

    public static final class NetworkChangedReceiver extends BroadcastReceiver {
        private Set<OnNetworkStatusChangedListener> mListeners = new HashSet();
        private NetworkType mType;

        /* access modifiers changed from: private */
        public static NetworkChangedReceiver getInstance() {
            return LazyHolder.INSTANCE;
        }

        /* access modifiers changed from: package-private */
        public void registerListener(final OnNetworkStatusChangedListener listener) {
            if (listener != null) {
                UtilsBridge.runOnUiThread(new Runnable() {
                    /* class com.blankj.utilcode.util.NetworkUtils.NetworkChangedReceiver.AnonymousClass1 */

                    public void run() {
                        int preSize = NetworkChangedReceiver.this.mListeners.size();
                        NetworkChangedReceiver.this.mListeners.add(listener);
                        if (preSize == 0 && NetworkChangedReceiver.this.mListeners.size() == 1) {
                            NetworkChangedReceiver.this.mType = NetworkUtils.getNetworkType();
                            Utils.getApp().registerReceiver(NetworkChangedReceiver.getInstance(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        }
                    }
                });
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isRegistered(OnNetworkStatusChangedListener listener) {
            if (listener == null) {
                return false;
            }
            return this.mListeners.contains(listener);
        }

        /* access modifiers changed from: package-private */
        public void unregisterListener(final OnNetworkStatusChangedListener listener) {
            if (listener != null) {
                UtilsBridge.runOnUiThread(new Runnable() {
                    /* class com.blankj.utilcode.util.NetworkUtils.NetworkChangedReceiver.AnonymousClass2 */

                    public void run() {
                        int preSize = NetworkChangedReceiver.this.mListeners.size();
                        NetworkChangedReceiver.this.mListeners.remove(listener);
                        if (preSize == 1 && NetworkChangedReceiver.this.mListeners.size() == 0) {
                            Utils.getApp().unregisterReceiver(NetworkChangedReceiver.getInstance());
                        }
                    }
                });
            }
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                UtilsBridge.runOnUiThreadDelayed(new Runnable() {
                    /* class com.blankj.utilcode.util.NetworkUtils.NetworkChangedReceiver.AnonymousClass3 */

                    public void run() {
                        NetworkType networkType = NetworkUtils.getNetworkType();
                        if (NetworkChangedReceiver.this.mType != networkType) {
                            NetworkChangedReceiver.this.mType = networkType;
                            if (networkType == NetworkType.NETWORK_NO) {
                                for (OnNetworkStatusChangedListener listener : NetworkChangedReceiver.this.mListeners) {
                                    listener.onDisconnected();
                                }
                                return;
                            }
                            for (OnNetworkStatusChangedListener listener2 : NetworkChangedReceiver.this.mListeners) {
                                listener2.onConnected(networkType);
                            }
                        }
                    }
                }, 1000);
            }
        }

        /* access modifiers changed from: private */
        public static class LazyHolder {
            private static final NetworkChangedReceiver INSTANCE = new NetworkChangedReceiver();

            private LazyHolder() {
            }
        }
    }
}
