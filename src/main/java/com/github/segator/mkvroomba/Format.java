
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
    "filename",
    "nb_streams",
    "nb_programs",
    "format_name",
    "format_long_name",
    "start_time",
    "duration",
    "size",
    "bit_rate",
    "probe_score",
    "tags"
})
public class Format implements Serializable
{

    @JsonProperty("filename")
    private String filename;
    @JsonProperty("nb_streams")
    private Integer nbStreams;
    @JsonProperty("nb_programs")
    private Integer nbPrograms;
    @JsonProperty("format_name")
    private String formatName;
    @JsonProperty("format_long_name")
    private String formatLongName;
    @JsonProperty("start_time")
    private String startTime;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("size")
    private String size;
    @JsonProperty("bit_rate")
    private String bitRate;
    @JsonProperty("probe_score")
    private Integer probeScore;
    @JsonProperty("tags")
    private Tags_ tags;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6603041841084861073L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Format() {
    }

    /**
     * 
     * @param duration
     * @param filename
     * @param nbPrograms
     * @param size
     * @param bitRate
     * @param nbStreams
     * @param formatName
     * @param startTime
     * @param probeScore
     * @param formatLongName
     * @param tags
     */
    public Format(String filename, Integer nbStreams, Integer nbPrograms, String formatName, String formatLongName, String startTime, String duration, String size, String bitRate, Integer probeScore, Tags_ tags) {
        super();
        this.filename = filename;
        this.nbStreams = nbStreams;
        this.nbPrograms = nbPrograms;
        this.formatName = formatName;
        this.formatLongName = formatLongName;
        this.startTime = startTime;
        this.duration = duration;
        this.size = size;
        this.bitRate = bitRate;
        this.probeScore = probeScore;
        this.tags = tags;
    }

    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    @JsonProperty("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @JsonProperty("nb_streams")
    public Integer getNbStreams() {
        return nbStreams;
    }

    @JsonProperty("nb_streams")
    public void setNbStreams(Integer nbStreams) {
        this.nbStreams = nbStreams;
    }

    @JsonProperty("nb_programs")
    public Integer getNbPrograms() {
        return nbPrograms;
    }

    @JsonProperty("nb_programs")
    public void setNbPrograms(Integer nbPrograms) {
        this.nbPrograms = nbPrograms;
    }

    @JsonProperty("format_name")
    public String getFormatName() {
        return formatName;
    }

    @JsonProperty("format_name")
    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    @JsonProperty("format_long_name")
    public String getFormatLongName() {
        return formatLongName;
    }

    @JsonProperty("format_long_name")
    public void setFormatLongName(String formatLongName) {
        this.formatLongName = formatLongName;
    }

    @JsonProperty("start_time")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("start_time")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("size")
    public String getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("bit_rate")
    public String getBitRate() {
        return bitRate;
    }

    @JsonProperty("bit_rate")
    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }

    @JsonProperty("probe_score")
    public Integer getProbeScore() {
        return probeScore;
    }

    @JsonProperty("probe_score")
    public void setProbeScore(Integer probeScore) {
        this.probeScore = probeScore;
    }

    @JsonProperty("tags")
    public Tags_ getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Tags_ tags) {
        this.tags = tags;
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
        return new ToStringBuilder(this).append("filename", filename).append("nbStreams", nbStreams).append("nbPrograms", nbPrograms).append("formatName", formatName).append("formatLongName", formatLongName).append("startTime", startTime).append("duration", duration).append("size", size).append("bitRate", bitRate).append("probeScore", probeScore).append("tags", tags).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(formatName).append(formatLongName).append(tags).append(duration).append(filename).append(nbPrograms).append(size).append(bitRate).append(nbStreams).append(startTime).append(probeScore).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Format) == false) {
            return false;
        }
        Format rhs = ((Format) other);
        return new EqualsBuilder().append(formatName, rhs.formatName).append(formatLongName, rhs.formatLongName).append(tags, rhs.tags).append(duration, rhs.duration).append(filename, rhs.filename).append(nbPrograms, rhs.nbPrograms).append(size, rhs.size).append(bitRate, rhs.bitRate).append(nbStreams, rhs.nbStreams).append(startTime, rhs.startTime).append(probeScore, rhs.probeScore).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
