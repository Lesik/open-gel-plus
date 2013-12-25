package com.lesikapk.opengelplus.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.NumberPicker;

public class NumberPickerPreference extends DialogPreference {
        
    private static final String androidns = "http://schemas.android.com/apk/res/com.lesikapk.opengelplus.settings";
    private int customMinValue = 0;
    private int customMaxValue = 0;
    private int Minute = 0;
    private NumberPicker np = null;

    public static int getMinute(String time) {
        String[] pieces = time.split(":");

        return (Integer.parseInt(pieces[1]));
    }

    public NumberPickerPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        int resId = attrs.getAttributeIntValue(androidns, "dialogMessage", 0);
        if (resId != 0){
            customMinValue = getContext().getResources().getInteger(resId);
            customMaxValue = getContext().getResources().getInteger(resId);
        }
        else {
                customMinValue = attrs.getAttributeIntValue(androidns, "dialogMessage", 0);
                customMaxValue = attrs.getAttributeIntValue(androidns, "dialogMessage", 10);
        }
        setPositiveButtonText("Set");
        setNegativeButtonText("Cancel");
    }

    @Override
    protected View onCreateDialogView() {
        np = new NumberPicker(getContext());

        return (np);
    }

    @Override
    protected void onBindDialogView(View v) {
        super.onBindDialogView(v);

        np.setMinValue(customMinValue);
        np.setMaxValue(customMaxValue);
        np.setValue(Minute);
        np.setWrapSelectorWheel(false);
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);

        if (positiveResult) {

            Minute = np.getValue();

            String time = 0 + ":" + String.valueOf(Minute);

            if (callChangeListener(time)) {
                persistString(time);
            }
        }
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return (a.getString(index));
    }

    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        String time = null;

        if (restoreValue) {
            if (defaultValue == null) {
                time = getPersistedString("08:00");
            } else {
                time = getPersistedString(defaultValue.toString());
            }
        } else {
            time = defaultValue.toString();
        }

        Minute = getMinute(time);
    }

}