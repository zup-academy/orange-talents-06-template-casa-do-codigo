package com.projeto.casadocodigo.api.response.author;

public class AuthorResponse {

        private String name;
        private String descricao;

        public AuthorResponse(String name, String descricao) {
            this.name = name;
            this.descricao = descricao;
        }

        public String getName() {
            return name;
        }

        public String getDescricao() {
            return descricao;
        }


}
