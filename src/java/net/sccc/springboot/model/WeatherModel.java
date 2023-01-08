package net.sccc.springboot.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"datetime",
"tempmax",
"tempmin",
"temp",
"feelslike",
"humidity",
"precip",
"preciptype"
})
@jakarta.annotation.Generated("jsonschema2pojo")
public class WeatherModel {

@JsonProperty("datetime")
private String datetime;
@JsonProperty("tempmax")
private Double tempmax;
@JsonProperty("tempmin")
private Integer tempmin;
@JsonProperty("temp")
private Double temp;
@JsonProperty("feelslike")
private Double feelslike;
@JsonProperty("humidity")
private Double humidity;
@JsonProperty("precip")
private Double precip;
@JsonProperty("preciptype")
private List<String> preciptype = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public WeatherModel() {
}

public WeatherModel(String datetime, Double tempmax, Integer tempmin, Double temp, Double feelslike, Double humidity, Double precip, List<String> preciptype) {
super();
this.datetime = datetime;
this.tempmax = tempmax;
this.tempmin = tempmin;
this.temp = temp;
this.feelslike = feelslike;
this.humidity = humidity;
this.precip = precip;
this.preciptype = preciptype;
}

@JsonProperty("datetime")
public String getDatetime() {
return datetime;
}

@JsonProperty("datetime")
public void setDatetime(String datetime) {
this.datetime = datetime;
}

@JsonProperty("tempmax")
public Double getTempmax() {
return tempmax;
}

@JsonProperty("tempmax")
public void setTempmax(Double tempmax) {
this.tempmax = tempmax;
}

@JsonProperty("tempmin")
public Integer getTempmin() {
return tempmin;
}

@JsonProperty("tempmin")
public void setTempmin(Integer tempmin) {
this.tempmin = tempmin;
}

@JsonProperty("temp")
public Double getTemp() {
return temp;
}

@JsonProperty("temp")
public void setTemp(Double temp) {
this.temp = temp;
}

@JsonProperty("feelslike")
public Double getFeelslike() {
return feelslike;
}

@JsonProperty("feelslike")
public void setFeelslike(Double feelslike) {
this.feelslike = feelslike;
}

@JsonProperty("humidity")
public Double getHumidity() {
return humidity;
}

@JsonProperty("humidity")
public void setHumidity(Double humidity) {
this.humidity = humidity;
}

@JsonProperty("precip")
public Double getPrecip() {
return precip;
}

@JsonProperty("precip")
public void setPrecip(Double precip) {
this.precip = precip;
}

@JsonProperty("preciptype")
public List<String> getPreciptype() {
return preciptype;
}

@JsonProperty("preciptype")
public void setPreciptype(List<String> preciptype) {
this.preciptype = preciptype;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
