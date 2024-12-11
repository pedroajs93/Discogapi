package com.pedroajs.mysongapi.application.dto;

import java.util.List;

public class DiscogsArtistReleasesResponse {

    private Pagination pagination;
    private List<DiscogsReleaseDTO> releases;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<DiscogsReleaseDTO> getReleases() {
        return releases;
    }

    public void setReleases(List<DiscogsReleaseDTO> releases) {
        this.releases = releases;
    }

    public static class Pagination {
        private int per_page;
        private int items;
        private int page;
        private int pages;
        private Object urls;

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getItems() {
            return items;
        }

        public void setItems(int items) {
            this.items = items;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public Object getUrls() {
            return urls;
        }

        public void setUrls(Object urls) {
            this.urls = urls;
        }
    }
}
