package br.unicamp.ft.a213281_j199617.conoli.recyclerView;

public class Imovel {

    private String usuario_dono, administracao, tipo_imovel, tipo_vaga, tipo_quarto, preco;
    private Boolean geladeira, maquina_de_lavar, fogao, microondas, televisao, wifi, garagem, mobilia,
    utensilio, interfone, ar_condicionado, varanda;

    public Imovel(String usuario_dono, String administracao, String tipo_imovel,
                  String tipo_vaga, String tipo_quarto, String preco, Boolean geladeira,
                  Boolean maquina_de_lavar, Boolean fogao, Boolean microondas, Boolean televisao,
                  Boolean wifi, Boolean garagem, Boolean mobilia, Boolean utensilio,
                  Boolean interfone, Boolean ar_condicionado, Boolean varanda) {

        this.usuario_dono = usuario_dono;
        this.administracao = administracao;
        this.tipo_imovel = tipo_imovel;
        this.tipo_vaga = tipo_vaga;
        this.tipo_quarto = tipo_quarto;
        this.preco = preco;
        this.geladeira = geladeira;
        this.maquina_de_lavar = maquina_de_lavar;
        this.fogao = fogao;
        this.microondas = microondas;
        this.televisao = televisao;
        this.wifi = wifi;
        this.garagem = garagem;
        this.mobilia = mobilia;
        this.utensilio = utensilio;
        this.interfone = interfone;
        this.ar_condicionado = ar_condicionado;
        this.varanda = varanda;
    }

    //métodos usuario
    public String getUsuario_dono() {
        return usuario_dono;
    }
    public void setUsuario_dono(String usuario_dono) {
        this.usuario_dono = usuario_dono;
    }

    //métodos adm
    public String getAdministracao() {
        return administracao;
    }
    public void setAdministracao(String administracao) {
        this.administracao = administracao;
    }

    //métodos tipoImovel
    public String getTipo_imovel() {
        return tipo_imovel;
    }
    public void setTipo_imovel(String tipo_imovel) {
        this.tipo_imovel = tipo_imovel;
    }

    //métodos tipoVaga
    public String getTipo_vaga() {
        return tipo_vaga;
    }
    public void setTipo_vaga(String tipo_vaga) {
        this.tipo_vaga = tipo_vaga;
    }

    //métodos tipoQuarto
    public String getTipo_quarto() {
        return tipo_quarto;
    }
    public void setTipo_quarto(String tipo_quarto) {
        this.tipo_quarto = tipo_quarto;
    }

    //métodos preco
    public String getPreco() {
        return preco;
    }
    public void setPreco(String preco) {
        this.preco = preco;
    }

    //métodos geladeira
    public Boolean getGeladeira() {
        return geladeira;
    }
    public void setGeladeira(Boolean geladeira) {
        this.geladeira = geladeira;
    }

    //métodos maquina_de_lavar
    public Boolean getMaquina_de_lavar() {
        return maquina_de_lavar;
    }
    public void setMaquina_de_lavar(Boolean maquina_de_lavar) {
        this.maquina_de_lavar = maquina_de_lavar;
    }

    //métodos fogao
    public Boolean getFogao() {
        return fogao;
    }
    public void setFogao(Boolean fogao) {
        this.fogao = fogao;
    }

    //métodos microondas
    public Boolean getMicroondas() {
        return microondas;
    }
    public void setMicroondas(Boolean microondas) {
        this.microondas = microondas;
    }

    //métodos televisao
    public Boolean getTelevisao() {
        return televisao;
    }
    public void setTelevisao(Boolean televisao) {
        this.televisao = televisao;
    }

    //métodos wifi
    public Boolean getWifi() {
        return wifi;
    }
    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    //métodos garagem
    public Boolean getGaragem() {
        return garagem;
    }
    public void setGaragem(Boolean garagem) {
        this.garagem = garagem;
    }

    //métodos mobilia
    public Boolean getMobilia() {
        return mobilia;
    }
    public void setMobilia(Boolean mobilia) {
        this.mobilia = mobilia;
    }

    //métodos utensilio
    public Boolean getUtensilio() {
        return utensilio;
    }
    public void setUtensilio(Boolean utensilio) {
        this.utensilio = utensilio;
    }

    //métodos interfone
    public Boolean getInterfone() {
        return interfone;
    }
    public void setInterfone(Boolean interfone) {
        this.interfone = interfone;
    }

    //métodos ar_condicionado
    public Boolean getAr_condicionado() {
        return ar_condicionado;
    }
    public void setAr_condicionado(Boolean ar_condicionado) {
        this.ar_condicionado = ar_condicionado;
    }

    //métodos varanda
    public Boolean getVaranda() {
        return varanda;
    }
    public void setVaranda(Boolean varanda) {
        this.varanda = varanda;
    }


}
