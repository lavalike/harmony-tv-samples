package com.wangzhen.tv.samples;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.window.dialog.ToastDialog;

/**
 * StackAbility
 * Created by wangzhen on 11/28/20.
 */
public class StackAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_stack);
        String data = intent.getStringParam("data");
        new ToastDialog(this).setText(data).setDuration(2000).show();
    }

}
