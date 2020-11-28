package com.wangzhen.tv.samples.slice;

import com.wangzhen.tv.samples.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.window.dialog.ToastDialog;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.net.NetManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class NetworkAbilitySlice extends AbilitySlice implements Component.ClickedListener {
    private static final String URL = "http://192.168.10.100:8080/wangzhen/plugin/plugin.json";

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_network);

        findComponentById(ResourceTable.Id_btn_request).setClickedListener(this);
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    @Override
    public void onClick(Component component) {
        request();
    }

    private void request() {
        NetManager manager = NetManager.getInstance(this);
        if (!manager.hasDefaultNet() || manager.getDefaultNet() == null) {
            showToast("网络不可用");
            return;
        }
        HttpURLConnection connection = null;
        try {
            URL url = new URL(URL);
            URLConnection urlConnection = manager.getDefaultNet().openConnection(url, Proxy.NO_PROXY);
            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
                connection.setRequestMethod("GET");
                connection.connect();

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String data;
                    while ((data = reader.readLine()) != null) {
                        sb.append(data);
                    }
                    HiLog.error(new HiLogLabel(HiLog.LOG_APP, 0, "->"), sb.toString());
                    reader.close();
                }
            }
        } catch (Exception e) {
            showToast("网络错误");
            HiLog.error(new HiLogLabel(HiLog.LOG_APP, 0, "->"), e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private void showToast(String message) {
        ToastDialog toastDialog = new ToastDialog(this);
        toastDialog.setText(message).setDuration(2000).show();
    }
}
