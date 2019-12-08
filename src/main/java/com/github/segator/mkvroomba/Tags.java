
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
    "BPS-eng",
    "DURATION-eng",
    "NUMBER_OF_FRAMES-eng",
    "NUMBER_OF_BYTES-eng",
    "_STATISTICS_WRITING_APP-eng",
    "_STATISTICS_WRITING_DATE_UTC-eng",
    "_STATISTICS_TAGS-eng",
    "language",
    "title"
})
public class Tags implements Serializable
{

    @JsonProperty("BPS-eng")
    private String bPSEng;
    @JsonProperty("DURATION-eng")
    private String dURATIONEng;
    @JsonProperty("NUMBER_OF_FRAMES-eng")
    private String nUMBEROFFRAMESEng;
    @JsonProperty("NUMBER_OF_BYTES-eng")
    private String nUMBEROFBYTESEng;
    @JsonProperty("_STATISTICS_WRITING_APP-eng")
    private String sTATISTICSWRITINGAPPEng;
    @JsonProperty("_STATISTICS_WRITING_DATE_UTC-eng")
    private String sTATISTICSWRITINGDATEUTCEng;
    @JsonProperty("_STATISTICS_TAGS-eng")
    private String sTATISTICSTAGSEng;
    @JsonProperty("language")
    private String language;
    @JsonProperty("title")
    private String title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 1421320390545278548L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tags() {
    }

    /**
     * 
     * @param bPSEng
     * @param sTATISTICSWRITINGAPPEng
     * @param dURATIONEng
     * @param nUMBEROFFRAMESEng
     * @param nUMBEROFBYTESEng
     * @param language
     * @param sTATISTICSTAGSEng
     * @param title
     * @param sTATISTICSWRITINGDATEUTCEng
     */
    public Tags(String bPSEng, String dURATIONEng, String nUMBEROFFRAMESEng, String nUMBEROFBYTESEng, String sTATISTICSWRITINGAPPEng, String sTATISTICSWRITINGDATEUTCEng, String sTATISTICSTAGSEng, String language, String title) {
        super();
        this.bPSEng = bPSEng;
        this.dURATIONEng = dURATIONEng;
        this.nUMBEROFFRAMESEng = nUMBEROFFRAMESEng;
        this.nUMBEROFBYTESEng = nUMBEROFBYTESEng;
        this.sTATISTICSWRITINGAPPEng = sTATISTICSWRITINGAPPEng;
        this.sTATISTICSWRITINGDATEUTCEng = sTATISTICSWRITINGDATEUTCEng;
        this.sTATISTICSTAGSEng = sTATISTICSTAGSEng;
        this.language = language;
        this.title = title;
    }

    @JsonProperty("BPS-eng")
    public String getBPSEng() {
        return bPSEng;
    }

    @JsonProperty("BPS-eng")
    public void setBPSEng(String bPSEng) {
        this.bPSEng = bPSEng;
    }

    @JsonProperty("DURATION-eng")
    public String getDURATIONEng() {
        return dURATIONEng;
    }

    @JsonProperty("DURATION-eng")
    public void setDURATIONEng(String dURATIONEng) {
        this.dURATIONEng = dURATIONEng;
    }

    @JsonProperty("NUMBER_OF_FRAMES-eng")
    public String getNUMBEROFFRAMESEng() {
        return nUMBEROFFRAMESEng;
    }

    @JsonProperty("NUMBER_OF_FRAMES-eng")
    public void setNUMBEROFFRAMESEng(String nUMBEROFFRAMESEng) {
        this.nUMBEROFFRAMESEng = nUMBEROFFRAMESEng;
    }

    @JsonProperty("NUMBER_OF_BYTES-eng")
    public String getNUMBEROFBYTESEng() {
        return nUMBEROFBYTESEng;
    }

    @JsonProperty("NUMBER_OF_BYTES-eng")
    public void setNUMBEROFBYTESEng(String nUMBEROFBYTESEng) {
        this.nUMBEROFBYTESEng = nUMBEROFBYTESEng;
    }

    @JsonProperty("_STATISTICS_WRITING_APP-eng")
    public String getSTATISTICSWRITINGAPPEng() {
        return sTATISTICSWRITINGAPPEng;
    }

    @JsonProperty("_STATISTICS_WRITING_APP-eng")
    public void setSTATISTICSWRITINGAPPEng(String sTATISTICSWRITINGAPPEng) {
        this.sTATISTICSWRITINGAPPEng = sTATISTICSWRITINGAPPEng;
    }

    @JsonProperty("_STATISTICS_WRITING_DATE_UTC-eng")
    public String getSTATISTICSWRITINGDATEUTCEng() {
        return sTATISTICSWRITINGDATEUTCEng;
    }

    @JsonProperty("_STATISTICS_WRITING_DATE_UTC-eng")
    public void setSTATISTICSWRITINGDATEUTCEng(String sTATISTICSWRITINGDATEUTCEng) {
        this.sTATISTICSWRITINGDATEUTCEng = sTATISTICSWRITINGDATEUTCEng;
    }

    @JsonProperty("_STATISTICS_TAGS-eng")
    public String getSTATISTICSTAGSEng() {
        return sTATISTICSTAGSEng;
    }

    @JsonProperty("_STATISTICS_TAGS-eng")
    public void setSTATISTICSTAGSEng(String sTATISTICSTAGSEng) {
        this.sTATISTICSTAGSEng = sTATISTICSTAGSEng;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
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
        return new ToStringBuilder(this).append("bPSEng", bPSEng).append("dURATIONEng", dURATIONEng).append("nUMBEROFFRAMESEng", nUMBEROFFRAMESEng).append("nUMBEROFBYTESEng", nUMBEROFBYTESEng).append("sTATISTICSWRITINGAPPEng", sTATISTICSWRITINGAPPEng).append("sTATISTICSWRITINGDATEUTCEng", sTATISTICSWRITINGDATEUTCEng).append("sTATISTICSTAGSEng", sTATISTICSTAGSEng).append("language", language).append("title", title).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bPSEng).append(sTATISTICSWRITINGAPPEng).append(dURATIONEng).append(nUMBEROFFRAMESEng).append(nUMBEROFBYTESEng).append(language).append(sTATISTICSTAGSEng).append(additionalProperties).append(title).append(sTATISTICSWRITINGDATEUTCEng).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tags) == false) {
            return false;
        }
        Tags rhs = ((Tags) other);
        return new EqualsBuilder().append(bPSEng, rhs.bPSEng).append(sTATISTICSWRITINGAPPEng, rhs.sTATISTICSWRITINGAPPEng).append(dURATIONEng, rhs.dURATIONEng).append(nUMBEROFFRAMESEng, rhs.nUMBEROFFRAMESEng).append(nUMBEROFBYTESEng, rhs.nUMBEROFBYTESEng).append(language, rhs.language).append(sTATISTICSTAGSEng, rhs.sTATISTICSTAGSEng).append(additionalProperties, rhs.additionalProperties).append(title, rhs.title).append(sTATISTICSWRITINGDATEUTCEng, rhs.sTATISTICSWRITINGDATEUTCEng).isEquals();
    }

}
