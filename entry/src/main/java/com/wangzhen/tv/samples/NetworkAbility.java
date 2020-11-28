package com.wangzhen.tv.samples;

import com.wangzhen.tv.samples.slice.NetworkAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

/**
 * NetworkAbility
 * Created by wangzhen on 11/28/20.
 */
public class NetworkAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(NetworkAbilitySlice.class.getName());
    }
}
