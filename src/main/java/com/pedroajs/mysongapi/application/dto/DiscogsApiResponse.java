package com.pedroajs.mysongapi.application.dto;


import java.util.List;

public class DiscogsApiResponse {

    private Pagination pagination;
    private List<DiscogsArtistDTO> results;

    // Getters e Setters

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<DiscogsArtistDTO> getResults() {
        return results;
    }

    public void setResults(List<DiscogsArtistDTO> results) {
        this.results = results;
    }

    // Classe interna para paginação
    public static class Pagination {
        private int page;
        private int pages;
        private int per_page;
        private int items;

        // Getters e Setters
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
    }
}
