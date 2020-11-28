package com.wangzhen.tv.samples;

import com.wangzhen.tv.samples.slice.DependentAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class DependentAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(DependentAbilitySlice.class.getName());
    }
}
