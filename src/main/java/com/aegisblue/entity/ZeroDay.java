package com.aegisblue.entity;

public class ZeroDay {

    @JsonProperty("zdiCanId")
    private int vulnerabilityId;

    @JsonProperty("vendor")
    private String vendor;

    @JsonProperty("cvss")
    private int cvssScore;

    @JsonProperty("reportedDate")
    private String reportedDate;

    @JsonProperty("publishDate")
    private String publishDate;

    @JsonProperty("description")
    private String description;


    public int getVulnerabilityId(){
        return vulnerabilityId;
    }

    public void setVulnerabilityId(int vulnerabilityId){
        this.vulnerabilityId = vulnerabilityId;
    }

    public String getVendor(){
        return vendor;
    }

    public void setVendor(String vendor){
        this.vendor = vendor;
    }

    public int getCvssScore(){
        return cvssScore;
    }

    public void setCvssScore(int cvssScore){
        this.cvssScore = cvssScore;
    }

    public String getReportedDate(){
        return reportedDate;
    }

    public void setReportedDate(String reportedDate){
        this.reportedDate = reportedDate;
    }

    public String getPublishDate(){
        return publishDate;
    }

    public void setPublishDate(String publishDate){
        this.publishDate = publishDate;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

        @Override
        public String toString(){
            return
                    "ZeroDay{" +
                            "zdiCanId = '" + vulnerabilityId + '\'' +
                            ",vendor = '" + vendor + '\'' +
                            ",cvss = '" + cvssScore + '\'' +
                            ",reportedDate = '" + reportedDate + '\'' +
                            ",publishDate = '" + publishDate + '\'' +
                            ",description = '" + description + '\'' +
                            "}";
        }
}