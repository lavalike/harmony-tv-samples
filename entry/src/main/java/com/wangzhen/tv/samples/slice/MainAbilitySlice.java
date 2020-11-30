package com.wangzhen.tv.samples.slice;

import com.wangzhen.tv.samples.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;

public class MainAbilitySlice extends AbilitySlice implements Component.ClickedListener {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        findComponentById(ResourceTable.Id_btn_stack_layout).setClickedListener(this);
        findComponentById(ResourceTable.Id_btn_dependent_layout).setClickedListener(this);
        findComponentById(ResourceTable.Id_btn_network).setClickedListener(this);
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
        Intent intent = null;
        switch (component.getId()) {
            case ResourceTable.Id_btn_stack_layout:
                intent = new Intent();
                intent.setOperation(new Intent.OperationBuilder()
                        .withBundleName("com.wangzhen.tv.samples")
                        .withAbilityName("com.wangzhen.tv.samples.StackAbility")
                        .build());
                break;
            case ResourceTable.Id_btn_dependent_layout:
                intent = new Intent();
                intent.setOperation(new Intent.OperationBuilder()
                        .withBundleName("com.wangzhen.tv.samples")
                        .withAbilityName("com.wangzhen.tv.samples.DependentAbility")
                        .build());
                break;
            case ResourceTable.Id_btn_network:
                intent = new Intent();
                intent.setOperation(new Intent.OperationBuilder()
                        .withBundleName("com.wangzhen.tv.samples")
                        .withAbilityName("com.wangzhen.tv.samples.NetworkAbility")
                        .build());
                break;
        }
        if (intent != null) {
            intent.setParam("data", "from main");
            startAbility(intent);
        }
    }
}
