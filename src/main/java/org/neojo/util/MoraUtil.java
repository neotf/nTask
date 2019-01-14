package org.neojo.util;

import org.neojo.entity.MoraMaterialEntity;

public class MoraUtil {
    private static String BASE_URL = "http://cf.mora.jp/contents/package/%04d/%08d/%04d/%03d/%03d/packageMeta.json";

    public static String getPackageUrl(int mountPoint, int labelId, int materialNo) {
        return String.format(BASE_URL, mountPoint, labelId, materialNo / 1000000, materialNo % 1000000 / 1000, materialNo % 1000);
    }

    public static String getPackageUrl(int labelId, int materialNo) {
        return getPackageUrl(0, labelId, materialNo);
    }


    public static String getMediaFormat(MoraMaterialEntity mme) {
        Integer mediaFlg = mme.getMediaFlg();
        Integer mediaFormatNo = mme.getMediaFormatNo();
        Integer mediaType = mme.getMediaType();
        Integer samplingFreq = mme.getSamplingFreq();
        String bitPerSample = mme.getBitPerSample();
        double khz = samplingFreq==null?0:Double.valueOf(samplingFreq) / 1000;
        double mhz = samplingFreq==null?0:Double.valueOf(samplingFreq) / 1000000;

        if (mediaFormatNo == null) {
            return mediaFlg == 1 ? "[AAC]" : mediaFlg == 2 ? "[AVC]" : "[AAC/AVC]";
        } else {
            if (mediaFlg == 3 && mediaFormatNo == 10) {
                return "[AAC / AVC]";
            } else if (mediaFlg == 3 && mediaFormatNo == 12) {
                return String.format("[%.1fkHz/%sbit][FLAC / AVC]", khz, bitPerSample);
            } else if (mediaFlg == 3 && mediaFormatNo == 13) {
                if (mediaType == 9 || mediaType == 10) {
                    return String.format("[%.1fMHz/%sbit][DSD / AVC]", mhz, bitPerSample);
                }
            } else if (mediaFlg == 3) {
                return "AAC";
            } else if (mediaFlg == 4 && mediaFormatNo == 12) {
                return String.format("[%.1fkHz/%sbit][FLAC / AAC]", khz, bitPerSample);
            } else if (mediaFlg == 4 && mediaFormatNo == 13) {
                if (mediaType == 9 || mediaType == 10) {
                    return String.format("[%.1fMHz/%sbit][DSD / AAC]", mhz, bitPerSample);
                }
            } else if (mediaFormatNo == 10) {
                return "[AAC]";
            } else if (mediaFormatNo == 11) {
                return "[AVC]";
            } else if (mediaFormatNo == 12) {
                return String.format("[%.1fkHz/%sbit][FLAC]", khz, bitPerSample);
            } else if (mediaFormatNo == 13) {
                if (mediaType == 9 || mediaType == 10) {
                    return String.format("[%.1fMHz/%sbit][DSD]", mhz, bitPerSample);
                }
            }
        }
        return null;
    }
}
