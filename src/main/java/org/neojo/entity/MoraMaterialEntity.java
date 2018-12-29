package org.neojo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "moraMaterial", schema = "ntask", catalog = "")
public class MoraMaterialEntity {
    private int materialNo;
    private Integer subMaterialNo;
    private String arranger;
    private String arrangerKana;
    private String artistName;
    private String artistNameKana;
    private Integer artistNameNo;
    private Integer artistNo;
    private String bannerimage0;
    private String bannerimage1;
    private String bannerimage2;
    private String bannerimage3;
    private String bannerLinkUrl0;
    private String bannerLinkUrl1;
    private String bannerLinkUrl2;
    private String bannerLinkUrl3;
    private String bannerTargetBlank0;
    private String bannerTargetBlank1;
    private String bannerTargetBlank2;
    private String bannerTargetBlank3;
    private String bitPerSample;
    private String callCoupon;
    private String catchcopy;
    private String cdPartNo;
    private String channelConf;
    private String comingSoon;
    private String composer;
    private String composerKana;
    private String containCoupon;
    private String couponProduct;
    private String dispFlg;
    private String displayLabelname;
    private String dispStartDate;
    private String dispStartDateStr;
    private String distFlg;
    private String distPartNo;
    private Integer duration;
    private String durationStr;
    private String endDate;
    private String fullsizeimage;
    private String labelCode;
    private String labelcompanyname;
    private String labelId;
    private String labelname;
    private Integer listenDuration;
    private String listenFlg;
    private String listimage;
    private String lyrics;
    private String lyricsKana;
    private String master;
    private String mediaFlg;
    private Integer mediaFormatNo;
    private Integer mediaType;
    private String metaDescription;
    private String msin;
    private String musicComment;
    private String musicId;
    private String musicType;
    private String packageComment;
    private String packageId;
    private String packageimage;
    private String packageUrl;
    private String prFlg;
    private Integer price;
    private Integer priceWithoutTax;
    private String producer;
    private String producerKana;
    private Integer productTypeNo;
    private Integer samplingFreq;
    private String special;
    private String specialPageUrl;
    private String startDate;
    private String tid;
    private String tie;
    private String tieType;
    private String title;
    private String titleKana;
    private Integer trackNo;
    private String weblistsizeimage;
    private Integer relatedmaterialNo;

    @Id
    @Column(name = "materialNo")
    public int getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(int materialNo) {
        this.materialNo = materialNo;
    }

    @Basic
    @Column(name = "subMaterialNo")
    public Integer getSubMaterialNo() {
        return subMaterialNo;
    }

    public void setSubMaterialNo(Integer subMaterialNo) {
        this.subMaterialNo = subMaterialNo;
    }

    @Basic
    @Column(name = "arranger")
    public String getArranger() {
        return arranger;
    }

    public void setArranger(String arranger) {
        this.arranger = arranger;
    }

    @Basic
    @Column(name = "arrangerKana")
    public String getArrangerKana() {
        return arrangerKana;
    }

    public void setArrangerKana(String arrangerKana) {
        this.arrangerKana = arrangerKana;
    }

    @Basic
    @Column(name = "artistName")
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Basic
    @Column(name = "artistNameKana")
    public String getArtistNameKana() {
        return artistNameKana;
    }

    public void setArtistNameKana(String artistNameKana) {
        this.artistNameKana = artistNameKana;
    }

    @Basic
    @Column(name = "artistNameNo")
    public Integer getArtistNameNo() {
        return artistNameNo;
    }

    public void setArtistNameNo(Integer artistNameNo) {
        this.artistNameNo = artistNameNo;
    }

    @Basic
    @Column(name = "artistNo")
    public Integer getArtistNo() {
        return artistNo;
    }

    public void setArtistNo(Integer artistNo) {
        this.artistNo = artistNo;
    }

    @Basic
    @Column(name = "bannerimage0")
    public String getBannerimage0() {
        return bannerimage0;
    }

    public void setBannerimage0(String bannerimage0) {
        this.bannerimage0 = bannerimage0;
    }

    @Basic
    @Column(name = "bannerimage1")
    public String getBannerimage1() {
        return bannerimage1;
    }

    public void setBannerimage1(String bannerimage1) {
        this.bannerimage1 = bannerimage1;
    }

    @Basic
    @Column(name = "bannerimage2")
    public String getBannerimage2() {
        return bannerimage2;
    }

    public void setBannerimage2(String bannerimage2) {
        this.bannerimage2 = bannerimage2;
    }

    @Basic
    @Column(name = "bannerimage3")
    public String getBannerimage3() {
        return bannerimage3;
    }

    public void setBannerimage3(String bannerimage3) {
        this.bannerimage3 = bannerimage3;
    }

    @Basic
    @Column(name = "bannerLinkUrl0")
    public String getBannerLinkUrl0() {
        return bannerLinkUrl0;
    }

    public void setBannerLinkUrl0(String bannerLinkUrl0) {
        this.bannerLinkUrl0 = bannerLinkUrl0;
    }

    @Basic
    @Column(name = "bannerLinkUrl1")
    public String getBannerLinkUrl1() {
        return bannerLinkUrl1;
    }

    public void setBannerLinkUrl1(String bannerLinkUrl1) {
        this.bannerLinkUrl1 = bannerLinkUrl1;
    }

    @Basic
    @Column(name = "bannerLinkUrl2")
    public String getBannerLinkUrl2() {
        return bannerLinkUrl2;
    }

    public void setBannerLinkUrl2(String bannerLinkUrl2) {
        this.bannerLinkUrl2 = bannerLinkUrl2;
    }

    @Basic
    @Column(name = "bannerLinkUrl3")
    public String getBannerLinkUrl3() {
        return bannerLinkUrl3;
    }

    public void setBannerLinkUrl3(String bannerLinkUrl3) {
        this.bannerLinkUrl3 = bannerLinkUrl3;
    }

    @Basic
    @Column(name = "bannerTargetBlank0")
    public String getBannerTargetBlank0() {
        return bannerTargetBlank0;
    }

    public void setBannerTargetBlank0(String bannerTargetBlank0) {
        this.bannerTargetBlank0 = bannerTargetBlank0;
    }

    @Basic
    @Column(name = "bannerTargetBlank1")
    public String getBannerTargetBlank1() {
        return bannerTargetBlank1;
    }

    public void setBannerTargetBlank1(String bannerTargetBlank1) {
        this.bannerTargetBlank1 = bannerTargetBlank1;
    }

    @Basic
    @Column(name = "bannerTargetBlank2")
    public String getBannerTargetBlank2() {
        return bannerTargetBlank2;
    }

    public void setBannerTargetBlank2(String bannerTargetBlank2) {
        this.bannerTargetBlank2 = bannerTargetBlank2;
    }

    @Basic
    @Column(name = "bannerTargetBlank3")
    public String getBannerTargetBlank3() {
        return bannerTargetBlank3;
    }

    public void setBannerTargetBlank3(String bannerTargetBlank3) {
        this.bannerTargetBlank3 = bannerTargetBlank3;
    }

    @Basic
    @Column(name = "bitPerSample")
    public String getBitPerSample() {
        return bitPerSample;
    }

    public void setBitPerSample(String bitPerSample) {
        this.bitPerSample = bitPerSample;
    }

    @Basic
    @Column(name = "callCoupon")
    public String getCallCoupon() {
        return callCoupon;
    }

    public void setCallCoupon(String callCoupon) {
        this.callCoupon = callCoupon;
    }

    @Basic
    @Column(name = "catchcopy")
    public String getCatchcopy() {
        return catchcopy;
    }

    public void setCatchcopy(String catchcopy) {
        this.catchcopy = catchcopy;
    }

    @Basic
    @Column(name = "cdPartNo")
    public String getCdPartNo() {
        return cdPartNo;
    }

    public void setCdPartNo(String cdPartNo) {
        this.cdPartNo = cdPartNo;
    }

    @Basic
    @Column(name = "channelConf")
    public String getChannelConf() {
        return channelConf;
    }

    public void setChannelConf(String channelConf) {
        this.channelConf = channelConf;
    }

    @Basic
    @Column(name = "comingSoon")
    public String getComingSoon() {
        return comingSoon;
    }

    public void setComingSoon(String comingSoon) {
        this.comingSoon = comingSoon;
    }

    @Basic
    @Column(name = "composer")
    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    @Basic
    @Column(name = "composerKana")
    public String getComposerKana() {
        return composerKana;
    }

    public void setComposerKana(String composerKana) {
        this.composerKana = composerKana;
    }

    @Basic
    @Column(name = "containCoupon")
    public String getContainCoupon() {
        return containCoupon;
    }

    public void setContainCoupon(String containCoupon) {
        this.containCoupon = containCoupon;
    }

    @Basic
    @Column(name = "couponProduct")
    public String getCouponProduct() {
        return couponProduct;
    }

    public void setCouponProduct(String couponProduct) {
        this.couponProduct = couponProduct;
    }

    @Basic
    @Column(name = "dispFlg")
    public String getDispFlg() {
        return dispFlg;
    }

    public void setDispFlg(String dispFlg) {
        this.dispFlg = dispFlg;
    }

    @Basic
    @Column(name = "displayLabelname")
    public String getDisplayLabelname() {
        return displayLabelname;
    }

    public void setDisplayLabelname(String displayLabelname) {
        this.displayLabelname = displayLabelname;
    }

    @Basic
    @Column(name = "dispStartDate")
    public String getDispStartDate() {
        return dispStartDate;
    }

    public void setDispStartDate(String dispStartDate) {
        this.dispStartDate = dispStartDate;
    }

    @Basic
    @Column(name = "dispStartDateStr")
    public String getDispStartDateStr() {
        return dispStartDateStr;
    }

    public void setDispStartDateStr(String dispStartDateStr) {
        this.dispStartDateStr = dispStartDateStr;
    }

    @Basic
    @Column(name = "distFlg")
    public String getDistFlg() {
        return distFlg;
    }

    public void setDistFlg(String distFlg) {
        this.distFlg = distFlg;
    }

    @Basic
    @Column(name = "distPartNo")
    public String getDistPartNo() {
        return distPartNo;
    }

    public void setDistPartNo(String distPartNo) {
        this.distPartNo = distPartNo;
    }

    @Basic
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "durationStr")
    public String getDurationStr() {
        return durationStr;
    }

    public void setDurationStr(String durationStr) {
        this.durationStr = durationStr;
    }

    @Basic
    @Column(name = "endDate")
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "fullsizeimage")
    public String getFullsizeimage() {
        return fullsizeimage;
    }

    public void setFullsizeimage(String fullsizeimage) {
        this.fullsizeimage = fullsizeimage;
    }

    @Basic
    @Column(name = "labelCode")
    public String getLabelCode() {
        return labelCode;
    }

    public void setLabelCode(String labelCode) {
        this.labelCode = labelCode;
    }

    @Basic
    @Column(name = "labelcompanyname")
    public String getLabelcompanyname() {
        return labelcompanyname;
    }

    public void setLabelcompanyname(String labelcompanyname) {
        this.labelcompanyname = labelcompanyname;
    }

    @Basic
    @Column(name = "labelId")
    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    @Basic
    @Column(name = "labelname")
    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    @Basic
    @Column(name = "listenDuration")
    public Integer getListenDuration() {
        return listenDuration;
    }

    public void setListenDuration(Integer listenDuration) {
        this.listenDuration = listenDuration;
    }

    @Basic
    @Column(name = "listenFlg")
    public String getListenFlg() {
        return listenFlg;
    }

    public void setListenFlg(String listenFlg) {
        this.listenFlg = listenFlg;
    }

    @Basic
    @Column(name = "listimage")
    public String getListimage() {
        return listimage;
    }

    public void setListimage(String listimage) {
        this.listimage = listimage;
    }

    @Basic
    @Column(name = "lyrics")
    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    @Basic
    @Column(name = "lyricsKana")
    public String getLyricsKana() {
        return lyricsKana;
    }

    public void setLyricsKana(String lyricsKana) {
        this.lyricsKana = lyricsKana;
    }

    @Basic
    @Column(name = "master")
    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Basic
    @Column(name = "mediaFlg")
    public String getMediaFlg() {
        return mediaFlg;
    }

    public void setMediaFlg(String mediaFlg) {
        this.mediaFlg = mediaFlg;
    }

    @Basic
    @Column(name = "mediaFormatNo")
    public Integer getMediaFormatNo() {
        return mediaFormatNo;
    }

    public void setMediaFormatNo(Integer mediaFormatNo) {
        this.mediaFormatNo = mediaFormatNo;
    }

    @Basic
    @Column(name = "mediaType")
    public Integer getMediaType() {
        return mediaType;
    }

    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
    }

    @Basic
    @Column(name = "metaDescription")
    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    @Basic
    @Column(name = "msin")
    public String getMsin() {
        return msin;
    }

    public void setMsin(String msin) {
        this.msin = msin;
    }

    @Basic
    @Column(name = "musicComment")
    public String getMusicComment() {
        return musicComment;
    }

    public void setMusicComment(String musicComment) {
        this.musicComment = musicComment;
    }

    @Basic
    @Column(name = "musicId")
    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    @Basic
    @Column(name = "musicType")
    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    @Basic
    @Column(name = "packageComment")
    public String getPackageComment() {
        return packageComment;
    }

    public void setPackageComment(String packageComment) {
        this.packageComment = packageComment;
    }

    @Basic
    @Column(name = "packageId")
    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @Basic
    @Column(name = "packageimage")
    public String getPackageimage() {
        return packageimage;
    }

    public void setPackageimage(String packageimage) {
        this.packageimage = packageimage;
    }

    @Basic
    @Column(name = "packageUrl")
    public String getPackageUrl() {
        return packageUrl;
    }

    public void setPackageUrl(String packageUrl) {
        this.packageUrl = packageUrl;
    }

    @Basic
    @Column(name = "prFlg")
    public String getPrFlg() {
        return prFlg;
    }

    public void setPrFlg(String prFlg) {
        this.prFlg = prFlg;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "priceWithoutTax")
    public Integer getPriceWithoutTax() {
        return priceWithoutTax;
    }

    public void setPriceWithoutTax(Integer priceWithoutTax) {
        this.priceWithoutTax = priceWithoutTax;
    }

    @Basic
    @Column(name = "producer")
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Basic
    @Column(name = "producerKana")
    public String getProducerKana() {
        return producerKana;
    }

    public void setProducerKana(String producerKana) {
        this.producerKana = producerKana;
    }

    @Basic
    @Column(name = "productTypeNo")
    public Integer getProductTypeNo() {
        return productTypeNo;
    }

    public void setProductTypeNo(Integer productTypeNo) {
        this.productTypeNo = productTypeNo;
    }

    @Basic
    @Column(name = "samplingFreq")
    public Integer getSamplingFreq() {
        return samplingFreq;
    }

    public void setSamplingFreq(Integer samplingFreq) {
        this.samplingFreq = samplingFreq;
    }

    @Basic
    @Column(name = "special")
    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    @Basic
    @Column(name = "specialPageUrl")
    public String getSpecialPageUrl() {
        return specialPageUrl;
    }

    public void setSpecialPageUrl(String specialPageUrl) {
        this.specialPageUrl = specialPageUrl;
    }

    @Basic
    @Column(name = "startDate")
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "tid")
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "tie")
    public String getTie() {
        return tie;
    }

    public void setTie(String tie) {
        this.tie = tie;
    }

    @Basic
    @Column(name = "tieType")
    public String getTieType() {
        return tieType;
    }

    public void setTieType(String tieType) {
        this.tieType = tieType;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "titleKana")
    public String getTitleKana() {
        return titleKana;
    }

    public void setTitleKana(String titleKana) {
        this.titleKana = titleKana;
    }

    @Basic
    @Column(name = "trackNo")
    public Integer getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(Integer trackNo) {
        this.trackNo = trackNo;
    }

    @Basic
    @Column(name = "weblistsizeimage")
    public String getWeblistsizeimage() {
        return weblistsizeimage;
    }

    public void setWeblistsizeimage(String weblistsizeimage) {
        this.weblistsizeimage = weblistsizeimage;
    }

    @Basic
    @Column(name = "relatedmaterialNo")
    public Integer getRelatedmaterialNo() {
        return relatedmaterialNo;
    }

    public void setRelatedmaterialNo(Integer relatedmaterialNo) {
        this.relatedmaterialNo = relatedmaterialNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoraMaterialEntity that = (MoraMaterialEntity) o;
        return materialNo == that.materialNo &&
                Objects.equals(subMaterialNo, that.subMaterialNo) &&
                Objects.equals(arranger, that.arranger) &&
                Objects.equals(arrangerKana, that.arrangerKana) &&
                Objects.equals(artistName, that.artistName) &&
                Objects.equals(artistNameKana, that.artistNameKana) &&
                Objects.equals(artistNameNo, that.artistNameNo) &&
                Objects.equals(artistNo, that.artistNo) &&
                Objects.equals(bannerimage0, that.bannerimage0) &&
                Objects.equals(bannerimage1, that.bannerimage1) &&
                Objects.equals(bannerimage2, that.bannerimage2) &&
                Objects.equals(bannerimage3, that.bannerimage3) &&
                Objects.equals(bannerLinkUrl0, that.bannerLinkUrl0) &&
                Objects.equals(bannerLinkUrl1, that.bannerLinkUrl1) &&
                Objects.equals(bannerLinkUrl2, that.bannerLinkUrl2) &&
                Objects.equals(bannerLinkUrl3, that.bannerLinkUrl3) &&
                Objects.equals(bannerTargetBlank0, that.bannerTargetBlank0) &&
                Objects.equals(bannerTargetBlank1, that.bannerTargetBlank1) &&
                Objects.equals(bannerTargetBlank2, that.bannerTargetBlank2) &&
                Objects.equals(bannerTargetBlank3, that.bannerTargetBlank3) &&
                Objects.equals(bitPerSample, that.bitPerSample) &&
                Objects.equals(callCoupon, that.callCoupon) &&
                Objects.equals(catchcopy, that.catchcopy) &&
                Objects.equals(cdPartNo, that.cdPartNo) &&
                Objects.equals(channelConf, that.channelConf) &&
                Objects.equals(comingSoon, that.comingSoon) &&
                Objects.equals(composer, that.composer) &&
                Objects.equals(composerKana, that.composerKana) &&
                Objects.equals(containCoupon, that.containCoupon) &&
                Objects.equals(couponProduct, that.couponProduct) &&
                Objects.equals(dispFlg, that.dispFlg) &&
                Objects.equals(displayLabelname, that.displayLabelname) &&
                Objects.equals(dispStartDate, that.dispStartDate) &&
                Objects.equals(dispStartDateStr, that.dispStartDateStr) &&
                Objects.equals(distFlg, that.distFlg) &&
                Objects.equals(distPartNo, that.distPartNo) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(durationStr, that.durationStr) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(fullsizeimage, that.fullsizeimage) &&
                Objects.equals(labelCode, that.labelCode) &&
                Objects.equals(labelcompanyname, that.labelcompanyname) &&
                Objects.equals(labelId, that.labelId) &&
                Objects.equals(labelname, that.labelname) &&
                Objects.equals(listenDuration, that.listenDuration) &&
                Objects.equals(listenFlg, that.listenFlg) &&
                Objects.equals(listimage, that.listimage) &&
                Objects.equals(lyrics, that.lyrics) &&
                Objects.equals(lyricsKana, that.lyricsKana) &&
                Objects.equals(master, that.master) &&
                Objects.equals(mediaFlg, that.mediaFlg) &&
                Objects.equals(mediaFormatNo, that.mediaFormatNo) &&
                Objects.equals(mediaType, that.mediaType) &&
                Objects.equals(metaDescription, that.metaDescription) &&
                Objects.equals(msin, that.msin) &&
                Objects.equals(musicComment, that.musicComment) &&
                Objects.equals(musicId, that.musicId) &&
                Objects.equals(musicType, that.musicType) &&
                Objects.equals(packageComment, that.packageComment) &&
                Objects.equals(packageId, that.packageId) &&
                Objects.equals(packageimage, that.packageimage) &&
                Objects.equals(packageUrl, that.packageUrl) &&
                Objects.equals(prFlg, that.prFlg) &&
                Objects.equals(price, that.price) &&
                Objects.equals(priceWithoutTax, that.priceWithoutTax) &&
                Objects.equals(producer, that.producer) &&
                Objects.equals(producerKana, that.producerKana) &&
                Objects.equals(productTypeNo, that.productTypeNo) &&
                Objects.equals(samplingFreq, that.samplingFreq) &&
                Objects.equals(special, that.special) &&
                Objects.equals(specialPageUrl, that.specialPageUrl) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(tid, that.tid) &&
                Objects.equals(tie, that.tie) &&
                Objects.equals(tieType, that.tieType) &&
                Objects.equals(title, that.title) &&
                Objects.equals(titleKana, that.titleKana) &&
                Objects.equals(trackNo, that.trackNo) &&
                Objects.equals(weblistsizeimage, that.weblistsizeimage) &&
                Objects.equals(relatedmaterialNo, that.relatedmaterialNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialNo, subMaterialNo, arranger, arrangerKana, artistName, artistNameKana, artistNameNo, artistNo, bannerimage0, bannerimage1, bannerimage2, bannerimage3, bannerLinkUrl0, bannerLinkUrl1, bannerLinkUrl2, bannerLinkUrl3, bannerTargetBlank0, bannerTargetBlank1, bannerTargetBlank2, bannerTargetBlank3, bitPerSample, callCoupon, catchcopy, cdPartNo, channelConf, comingSoon, composer, composerKana, containCoupon, couponProduct, dispFlg, displayLabelname, dispStartDate, dispStartDateStr, distFlg, distPartNo, duration, durationStr, endDate, fullsizeimage, labelCode, labelcompanyname, labelId, labelname, listenDuration, listenFlg, listimage, lyrics, lyricsKana, master, mediaFlg, mediaFormatNo, mediaType, metaDescription, msin, musicComment, musicId, musicType, packageComment, packageId, packageimage, packageUrl, prFlg, price, priceWithoutTax, producer, producerKana, productTypeNo, samplingFreq, special, specialPageUrl, startDate, tid, tie, tieType, title, titleKana, trackNo, weblistsizeimage, relatedmaterialNo);
    }

    @Override
    public String toString() {
        return "[" + this.artistName + " - " + this.title + "] : " + this.startDate;
    }
}
