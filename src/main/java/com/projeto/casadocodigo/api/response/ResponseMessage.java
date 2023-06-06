package com.projeto.casadocodigo.api.response;

public class ResponseMessage {
    private int codigo;
    private String status;
    private String mensagem;

    public ResponseMessage(int codigo, String status, String mensagem) {
        this.codigo = codigo;
        this.status = status;
        this.mensagem = mensagem;
    }


    public int getCodigo() {
        return codigo;
    }

    public String getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }
}
