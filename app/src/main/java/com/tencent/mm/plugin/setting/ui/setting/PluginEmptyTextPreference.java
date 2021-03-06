package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginEmptyTextPreference extends Preference {
    private Context context;
    private TextView lbS;
    private String text;

    public PluginEmptyTextPreference(Context context, int i) {
        this(context, null, 0);
        this.text = context.getString(i);
    }

    public PluginEmptyTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lbS = null;
        this.context = context;
        setLayoutResource(R.i.dpj);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        View.inflate(this.context, R.i.dpj, null);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.lbS = (TextView) view.findViewById(R.h.cet);
        this.lbS.setText(this.text);
    }
}
