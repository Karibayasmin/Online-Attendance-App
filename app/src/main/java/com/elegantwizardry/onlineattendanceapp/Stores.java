package com.elegantwizardry.onlineattendanceapp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Stores implements Serializable {

    @SerializedName("data")
    private List<Data> dataList;
    @SerializedName("links")
    private Links links;
    @SerializedName("meta")
    private Meta meta;

    public Stores(List<Data> dataList, Links links, Meta meta) {
        this.dataList = dataList;
        this.links = links;
        this.meta = meta;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public Links getLinks() {
        return links;
    }

    public Meta getMeta() {
        return meta;
    }

    public class Data implements Serializable {

        @SerializedName("id")
        private Integer id;
        @SerializedName("name")
        private String name;
        @SerializedName("address")
        private String address;

        public Data(Integer id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }
    }

    public class Links implements Serializable{

        @SerializedName("first")
        private String first;
        @SerializedName("last")
        private String last;
        @SerializedName("prev")
        private String prev;
        @SerializedName("next")
        private String next;

        public Links(String first, String last, String prev, String next) {
            this.first = first;
            this.last = last;
            this.prev = prev;
            this.next = next;
        }

        public String getFirst() {
            return first;
        }

        public String getLast() {
            return last;
        }

        public String getPrev() {
            return prev;
        }

        public String getNext() {
            return next;
        }
    }

    public class Meta implements Serializable{

        @SerializedName("current_page")
        private Integer current_page;
        @SerializedName("from")
        private Integer from;
        @SerializedName("last_page")
        private Integer last_page;
        @SerializedName("path")
        private String path;
        @SerializedName("per_page")
        private Integer per_page;
        @SerializedName("to")
        private Integer to;
        @SerializedName("total")
        private Integer total;

        public Meta(Integer current_page, Integer from, Integer last_page, String path, Integer per_page, Integer to, Integer total) {
            this.current_page = current_page;
            this.from = from;
            this.last_page = last_page;
            this.path = path;
            this.per_page = per_page;
            this.to = to;
            this.total = total;
        }

        public Integer getCurrent_page() {
            return current_page;
        }

        public Integer getFrom() {
            return from;
        }

        public Integer getLast_page() {
            return last_page;
        }

        public String getPath() {
            return path;
        }

        public Integer getPer_page() {
            return per_page;
        }

        public Integer getTo() {
            return to;
        }

        public Integer getTotal() {
            return total;
        }
    }
}
