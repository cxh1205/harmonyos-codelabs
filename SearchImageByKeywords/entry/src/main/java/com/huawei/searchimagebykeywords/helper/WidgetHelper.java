/*
 * Copyright (c) 2021 Huawei Device Co., Ltd.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huawei.searchimagebykeywords.helper;

import ohos.agp.colors.RgbColor;
import ohos.agp.components.Component;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.Text;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.utils.TextAlignment;
import ohos.agp.window.dialog.ToastDialog;
import ohos.app.AbilityContext;

import static ohos.agp.components.ComponentContainer.LayoutConfig.MATCH_CONTENT;
import static ohos.agp.components.ComponentContainer.LayoutConfig.MATCH_PARENT;

/**
 * 小组件帮助类
 *
 * @since 2021-02-04
 */
public final class WidgetHelper {
    private static final int TOAST_SHOW_TIME_MS = 1000;

    private static final int CORNER_RADIUS = 15;

    private static final int TEXT_SIZE_48 = 48;

    private static final int TEXT_PADDING_30 = 30;

    private static final int TEXT_PADDING_20 = 20;

    private static final int RGB_COLOR = 0x666666FF;

    private WidgetHelper() { }

    /**
     * 展示弹出框
     *
     * @param context 页面对象
     * @param msg 要展示的消息
     */
    public static void showTips(AbilityContext context, String msg) {
        showTips(context, msg, TOAST_SHOW_TIME_MS);
    }

    /**
     * 展示弹出框
     *
     * @param context 页面
     * @param msg 要展示的消息
     * @param durationTime 弹框持续时间
     */
    public static void showTips(AbilityContext context, String msg, int durationTime) {
        Text text = new Text(context);
        text.setWidth(MATCH_CONTENT);
        text.setHeight(MATCH_CONTENT);
        text.setTextSize(TEXT_SIZE_48);
        text.setText(msg);
        text.setPadding(TEXT_PADDING_30, TEXT_PADDING_20, TEXT_PADDING_30, TEXT_PADDING_20);
        text.setMultipleLine(true);
        text.setTextColor(Color.WHITE);
        text.setTextAlignment(TextAlignment.CENTER);

        ShapeElement style = new ShapeElement();
        style.setShape(ShapeElement.RECTANGLE);
        style.setRgbColor(new RgbColor(RGB_COLOR));
        style.setCornerRadius(CORNER_RADIUS);
        text.setBackground(style);
        DirectionalLayout mainLayout = new DirectionalLayout(context);
        mainLayout.setWidth(MATCH_PARENT);

        mainLayout.setHeight(MATCH_CONTENT);
        mainLayout.setAlignment(LayoutAlignment.CENTER);
        mainLayout.addComponent(text);

        ToastDialog toastDialog = new ToastDialog(context);
        toastDialog.setSize(MATCH_PARENT, MATCH_CONTENT);
        toastDialog.setDuration(durationTime);
        toastDialog.setAutoClosable(true);
        toastDialog.setTransparent(true);

        toastDialog.setAlignment(LayoutAlignment.CENTER);
        Component cc = mainLayout;
        toastDialog.setComponent(cc);
        toastDialog.show();
    }
}
