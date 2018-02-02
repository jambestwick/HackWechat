package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.g;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vg;
import java.util.LinkedList;

public final class q extends a {
    final int mxU;

    public q(h hVar) {
        super(hVar);
        this.mxU = a.aa(hVar.context, R.f.buZ);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.i.dhB, null), aVar, fVar);
            aVar.mxV = (ImageView) view.findViewById(R.h.cgP);
            aVar.myC = (TextView) view.findViewById(R.h.chs);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.myC.setVisibility(0);
        LinkedList linkedList = fVar.field_favProto.weU;
        if (linkedList.size() > 0) {
            aVar.myC.setText(g.v(context, ((uq) linkedList.getFirst()).duration));
        } else {
            aVar.myC.setText("");
        }
        a(aVar, fVar);
        this.mpb.a(aVar.mxV, j.p(fVar), fVar, R.k.dvA, this.mxU, this.mxU);
        return view;
    }

    public final void a(View view, vg vgVar) {
        e.a(view.getContext(), ((a) view.getTag()).mqC, vgVar);
    }
}
