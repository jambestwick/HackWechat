package com.tencent.mm.ui.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class Snack implements Parcelable {
    public static final Creator<Snack> CREATOR = new Creator<Snack>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Snack(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Snack[i];
        }
    };
    final String mMessage;
    final int zfA;
    final Parcelable zfB;
    final short zfC;
    final int zfD;
    final String zfz;

    Snack(String str, String str2, int i, Parcelable parcelable, short s, int i2) {
        this.mMessage = str;
        this.zfz = str2;
        this.zfA = i;
        this.zfB = parcelable;
        this.zfC = s;
        this.zfD = i2;
    }

    Snack(Parcel parcel) {
        this.mMessage = parcel.readString();
        this.zfz = parcel.readString();
        this.zfA = parcel.readInt();
        this.zfB = parcel.readParcelable(parcel.getClass().getClassLoader());
        this.zfC = (short) parcel.readInt();
        this.zfD = ((Integer) parcel.readParcelable(parcel.getClass().getClassLoader())).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mMessage);
        parcel.writeString(this.zfz);
        parcel.writeInt(this.zfA);
        parcel.writeParcelable(this.zfB, 0);
        parcel.writeInt(this.zfC);
        parcel.writeInt(this.zfD);
    }

    public int describeContents() {
        return 0;
    }
}
