package com.ismail.athanapp.model;

import com.google.gson.annotations.SerializedName;

public class Timing {
    @SerializedName("Fajr")
    private String fajrTiming;

    @SerializedName("Sunrise")
    private String sunriseTiming;

    @SerializedName("Dhuhr")
    private String dhuhrTiming;

    @SerializedName("Asr")
    private String asrTiming;

    @SerializedName("Sunset")
    private String sunsetTiming;

    @SerializedName("Maghrib")
    private String maghribTiming;

    @SerializedName("Isha")
    private String ishaTiming;

    @SerializedName("Imsak")
    private String imsakTiming;

    @SerializedName("Midnight")
    private String midNightTiming;

    public String getFajrTiming() {
        return fajrTiming;
    }

    public void setFajrTiming(String fajrTiming) {
        this.fajrTiming = fajrTiming;
    }

    public String getSunriseTiming() {
        return sunriseTiming;
    }

    public void setSunriseTiming(String sunriseTiming) {
        this.sunriseTiming = sunriseTiming;
    }

    public String getDhuhrTiming() {
        return dhuhrTiming;
    }

    public void setDhuhrTiming(String dhuhrTiming) {
        this.dhuhrTiming = dhuhrTiming;
    }

    public String getAsrTiming() {
        return asrTiming;
    }

    public void setAsrTiming(String asrTiming) {
        this.asrTiming = asrTiming;
    }

    public String getSunsetTiming() {
        return sunsetTiming;
    }

    public void setSunsetTiming(String sunsetTiming) {
        this.sunsetTiming = sunsetTiming;
    }

    public String getMaghribTiming() {
        return maghribTiming;
    }

    public void setMaghribTiming(String maghribTiming) {
        this.maghribTiming = maghribTiming;
    }

    public String getIshaTiming() {
        return ishaTiming;
    }

    public void setIshaTiming(String ishaTiming) {
        this.ishaTiming = ishaTiming;
    }

    public String getImsakTiming() {
        return imsakTiming;
    }

    public void setImsakTiming(String imsakTiming) {
        this.imsakTiming = imsakTiming;
    }

    public String getMidNightTiming() {
        return midNightTiming;
    }

    public void setMidNightTiming(String midNightTiming) {
        this.midNightTiming = midNightTiming;
    }
}
