package net.sccc.springboot.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"queryCost",
"resolvedAddress",
"address",
"timezone",
"description",
"days"
})
@jakarta.annotation.Generated("jsonschema2pojo")
public class WeatherLayout {

@JsonProperty("queryCost")
private Integer queryCost;
@JsonProperty("resolvedAddress")
private String resolvedAddress;
@JsonProperty("address")
private String address;
@JsonProperty("timezone")
private String timezone;
@JsonProperty("description")
private String description;
@JsonProperty("days")
private WeatherModel days = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public WeatherLayout() {
}

/**
* 
* @param queryCost
* @param address
* @param timezone
* @param description
* @param days
* @param resolvedAddress
*/
public WeatherLayout(Integer queryCost, String resolvedAddress, String address, String timezone, String description, WeatherModel days) {
super();
this.queryCost = queryCost;
this.resolvedAddress = resolvedAddress;
this.address = address;
this.timezone = timezone;
this.description = description;
this.days = days;
}

@JsonProperty("queryCost")
public Integer getQueryCost() {
return queryCost;
}

@JsonProperty("queryCost")
public void setQueryCost(Integer queryCost) {
this.queryCost = queryCost;
}

@JsonProperty("resolvedAddress")
public String getResolvedAddress() {
return resolvedAddress;
}

@JsonProperty("resolvedAddress")
public void setResolvedAddress(String resolvedAddress) {
this.resolvedAddress = resolvedAddress;
}

@JsonProperty("address")
public String getAddress() {
return address;
}

@JsonProperty("address")
public void setAddress(String address) {
this.address = address;
}

@JsonProperty("timezone")
public String getTimezone() {
return timezone;
}

@JsonProperty("timezone")
public void setTimezone(String timezone) {
this.timezone = timezone;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("days")
public WeatherModel getDays() {
return days;
}

@JsonProperty("days")
public void setDays(WeatherModel wm) {
this.days = wm;
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
