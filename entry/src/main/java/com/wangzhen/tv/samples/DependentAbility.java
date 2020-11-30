package com.wangzhen.tv.samples;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class DependentAbility extends Ability implements Component.ClickedListener {
    private Text tvCount;
    private int count;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_dependent);

        tvCount = (Text) findComponentById(ResourceTable.Id_tv_count);
        findComponentById(ResourceTable.Id_btn_add_count).setClickedListener(this);
    }

    @Override
    public void onClick(Component component) {
        tvCount.setText("click:" + ++count);
    }
}
