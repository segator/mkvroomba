
package com.github.segator.mkvroomba;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "default",
    "dub",
    "original",
    "comment",
    "lyrics",
    "karaoke",
    "forced",
    "hearing_impaired",
    "visual_impaired",
    "clean_effects",
    "attached_pic",
    "timed_thumbnails"
})
public class Disposition implements Serializable
{

    @JsonProperty("default")
    private Integer _default;
    @JsonProperty("dub")
    private Integer dub;
    @JsonProperty("original")
    private Integer original;
    @JsonProperty("comment")
    private Integer comment;
    @JsonProperty("lyrics")
    private Integer lyrics;
    @JsonProperty("karaoke")
    private Integer karaoke;
    @JsonProperty("forced")
    private Integer forced;
    @JsonProperty("hearing_impaired")
    private Integer hearingImpaired;
    @JsonProperty("visual_impaired")
    private Integer visualImpaired;
    @JsonProperty("clean_effects")
    private Integer cleanEffects;
    @JsonProperty("attached_pic")
    private Integer attachedPic;
    @JsonProperty("timed_thumbnails")
    private Integer timedThumbnails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 34042810733755418L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Disposition() {
    }

    /**
     * 
     * @param dub
     * @param _default
     * @param karaoke
     * @param original
     * @param attachedPic
     * @param forced
     * @param cleanEffects
     * @param timedThumbnails
     * @param comment
     * @param hearingImpaired
     * @param lyrics
     * @param visualImpaired
     */
    public Disposition(Integer _default, Integer dub, Integer original, Integer comment, Integer lyrics, Integer karaoke, Integer forced, Integer hearingImpaired, Integer visualImpaired, Integer cleanEffects, Integer attachedPic, Integer timedThumbnails) {
        super();
        this._default = _default;
        this.dub = dub;
        this.original = original;
        this.comment = comment;
        this.lyrics = lyrics;
        this.karaoke = karaoke;
        this.forced = forced;
        this.hearingImpaired = hearingImpaired;
        this.visualImpaired = visualImpaired;
        this.cleanEffects = cleanEffects;
        this.attachedPic = attachedPic;
        this.timedThumbnails = timedThumbnails;
    }

    @JsonProperty("default")
    public Integer getDefault() {
        return _default;
    }

    @JsonProperty("default")
    public void setDefault(Integer _default) {
        this._default = _default;
    }

    @JsonProperty("dub")
    public Integer getDub() {
        return dub;
    }

    @JsonProperty("dub")
    public void setDub(Integer dub) {
        this.dub = dub;
    }

    @JsonProperty("original")
    public Integer getOriginal() {
        return original;
    }

    @JsonProperty("original")
    public void setOriginal(Integer original) {
        this.original = original;
    }

    @JsonProperty("comment")
    public Integer getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(Integer comment) {
        this.comment = comment;
    }

    @JsonProperty("lyrics")
    public Integer getLyrics() {
        return lyrics;
    }

    @JsonProperty("lyrics")
    public void setLyrics(Integer lyrics) {
        this.lyrics = lyrics;
    }

    @JsonProperty("karaoke")
    public Integer getKaraoke() {
        return karaoke;
    }

    @JsonProperty("karaoke")
    public void setKaraoke(Integer karaoke) {
        this.karaoke = karaoke;
    }

    @JsonProperty("forced")
    public Integer getForced() {
        return forced;
    }

    @JsonProperty("forced")
    public void setForced(Integer forced) {
        this.forced = forced;
    }

    @JsonProperty("hearing_impaired")
    public Integer getHearingImpaired() {
        return hearingImpaired;
    }

    @JsonProperty("hearing_impaired")
    public void setHearingImpaired(Integer hearingImpaired) {
        this.hearingImpaired = hearingImpaired;
    }

    @JsonProperty("visual_impaired")
    public Integer getVisualImpaired() {
        return visualImpaired;
    }

    @JsonProperty("visual_impaired")
    public void setVisualImpaired(Integer visualImpaired) {
        this.visualImpaired = visualImpaired;
    }

    @JsonProperty("clean_effects")
    public Integer getCleanEffects() {
        return cleanEffects;
    }

    @JsonProperty("clean_effects")
    public void setCleanEffects(Integer cleanEffects) {
        this.cleanEffects = cleanEffects;
    }

    @JsonProperty("attached_pic")
    public Integer getAttachedPic() {
        return attachedPic;
    }

    @JsonProperty("attached_pic")
    public void setAttachedPic(Integer attachedPic) {
        this.attachedPic = attachedPic;
    }

    @JsonProperty("timed_thumbnails")
    public Integer getTimedThumbnails() {
        return timedThumbnails;
    }

    @JsonProperty("timed_thumbnails")
    public void setTimedThumbnails(Integer timedThumbnails) {
        this.timedThumbnails = timedThumbnails;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("_default", _default).append("dub", dub).append("original", original).append("comment", comment).append("lyrics", lyrics).append("karaoke", karaoke).append("forced", forced).append("hearingImpaired", hearingImpaired).append("visualImpaired", visualImpaired).append("cleanEffects", cleanEffects).append("attachedPic", attachedPic).append("timedThumbnails", timedThumbnails).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(_default).append(original).append(attachedPic).append(forced).append(dub).append(karaoke).append(cleanEffects).append(timedThumbnails).append(comment).append(additionalProperties).append(hearingImpaired).append(lyrics).append(visualImpaired).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Disposition) == false) {
            return false;
        }
        Disposition rhs = ((Disposition) other);
        return new EqualsBuilder().append(_default, rhs._default).append(original, rhs.original).append(attachedPic, rhs.attachedPic).append(forced, rhs.forced).append(dub, rhs.dub).append(karaoke, rhs.karaoke).append(cleanEffects, rhs.cleanEffects).append(timedThumbnails, rhs.timedThumbnails).append(comment, rhs.comment).append(additionalProperties, rhs.additionalProperties).append(hearingImpaired, rhs.hearingImpaired).append(lyrics, rhs.lyrics).append(visualImpaired, rhs.visualImpaired).isEquals();
    }

}
