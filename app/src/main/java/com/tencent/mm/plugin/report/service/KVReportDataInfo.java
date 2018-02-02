package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class KVReportDataInfo implements Parcelable {
    public static final Creator<KVReportDataInfo> CREATOR = new Creator<KVReportDataInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new KVReportDataInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new KVReportDataInfo[i];
        }
    };
    public boolean pQA;
    public boolean pQh;
    public long pQz;
    public String value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeLong(this.pQz);
        parcel.writeString(this.value);
        if (this.pQA) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.pQh) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }

    protected KVReportDataInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.pQz = parcel.readLong();
        this.value = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.pQA = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.pQh = z2;
    }
}
