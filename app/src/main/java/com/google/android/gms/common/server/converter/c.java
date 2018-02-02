package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class c implements Creator<StringToIntConverter$Entry> {
    static void a(StringToIntConverter$Entry stringToIntConverter$Entry, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, stringToIntConverter$Entry.versionCode);
        b.a(parcel, 2, stringToIntConverter$Entry.aOU);
        b.c(parcel, 3, stringToIntConverter$Entry.aOV);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = a.b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel, readInt);
                    break;
                case 2:
                    str = a.k(parcel, readInt);
                    break;
                case 3:
                    i = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StringToIntConverter$Entry(i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new StringToIntConverter$Entry[i];
    }
}
