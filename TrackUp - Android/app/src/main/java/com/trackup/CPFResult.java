package com.trackup;

import java.util.List;

/**
 * Created by felipersn on 07/05/17.
 */

public class CPFResult {

    /**
     * cabecalho : {"entrada":"22430907836","produto":"LOCALIZE","consulta":"PESSOA_FISICA","protocoloTransacao":"9927d0c1-e3b2-4d43-88d9-21da1c52581b","dataHora":"07/05/2017 01:31:05"}
     * cadastro : {"cpf":"22430907836","nome":"HEDERSON VICTOR ALBERTINI","sexo":"M","dataNascimento":"22/12/1983","idade":"33","faixaIdade":"30 a 34 anos","signo":"Sagitário","rg":"032664133","ufRg":"SP","status":null,"statusData":null,"maeNome":"MARIA JOSE VICTOR DE CARVALHO","maeCpf":"03479036813","obitoProvavel":"NÃO","tituloEleitoral":null,"grauInstrucao":null,"dependentes":null,"estadoCivil":null,"tags":null}
     * participacoesEmpresas : [{"posicao":"1","documento":"15724796000100","nome":"ASSERTIVA SOLUCOES EM MARKETING E CREDITO LTDA - EPP","participacao":"50.00","qualificacaoSocio":"SOCIO-ADMINISTRADOR","dataEntrada":"01/06/2012","dataSaida":null,"valorParticipacao":null,"tags":null}]
     * rendaEmpregador : [{"posicao":"1","empregador":"ASSOCIACAO COMERCIAL DE SAO PAULO","documentoEmpregador":"60524550000131","setorEmpregador":"ATIVIDADES DE ORGANIZAÇÕES ASSOCIATIVAS","cboCodigo":"252105","cboDescricao":"Administrador","cboSetor":null,"cboSinonimos":null,"rendaEstimada":null,"faixaRenda":"De 1 a 2 Salários Mínimos","rendaDataRef":"2013-07-14","tags":null},{"posicao":"2","empregador":"SOPREZZ - SERVICOS DE ENTREGA LTDA - ME","documentoEmpregador":"07471168000124","setorEmpregador":"CORREIO E OUTRAS ATIVIDADES DE ENTREGA","cboCodigo":"391115","cboDescricao":"Controlador de entrada e saída","cboSetor":null,"cboSinonimos":null,"rendaEstimada":null,"faixaRenda":"De 1 a 2 Salários Mínimos","rendaDataRef":"2013-07-14","tags":null},{"posicao":"3","empregador":"BOA VISTA SERVICOS S.A.","documentoEmpregador":"11725176000127","setorEmpregador":"ATIVIDADES DE SEDES DE EMPRESAS E DE CONSULTORIA EM GESTÃO EMPRESARIAL","cboCodigo":"252105","cboDescricao":"Administrador","cboSetor":null,"cboSinonimos":null,"rendaEstimada":null,"faixaRenda":"De 1 a 2 Salários Mínimos","rendaDataRef":"2013-07-14","tags":null},{"posicao":"4","empregador":"BOA VISTA SERVICOS S.A.","documentoEmpregador":"11725176000127","setorEmpregador":"ATIVIDADES DE SEDES DE EMPRESAS E DE CONSULTORIA EM GESTÃO EMPRESARIAL","cboCodigo":"142305","cboDescricao":"Gerente comercial","cboSetor":null,"cboSinonimos":null,"rendaEstimada":null,"faixaRenda":"De 3 a 5 Salários Mínimos","rendaDataRef":"2014-10-03","tags":null}]
     * rendaBeneficioAssistencial : null
     * telefones : {"fixos":[{"posicao":"0","telefone":"1932037034","operadora":"Embratel  - Fixo","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null},{"posicao":"1","telefone":"1932410546","operadora":"Vivo - Fixo","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null},{"posicao":"2","telefone":"1933056871","operadora":"Embratel  - Fixo","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null},{"posicao":"3","telefone":"1921218462","operadora":"Embratel  - Fixo","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null}],"moveis":[{"posicao":"0","telefone":"11954117424","operadora":"OI - Celular","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null},{"posicao":"1","telefone":"11954117426","operadora":"OI - Celular","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null},{"posicao":"2","telefone":"19988931253","operadora":"OI - Celular","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null},{"posicao":"3","telefone":"11961149050","operadora":"OI - Celular","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null}]}
     * enderecos : [{"posicao":"0","tipoLogradouro":"R","logradouro":"ALBATROZ","numero":"65","complemento":"AP 22 B 2 F","bairro":"VL PE MANOEL DE NOBREGA","cidade":"CAMPINAS","uf":"SP","cep":"13061371","latitude":"-22.9115463","longitude":"-47.1190353","pontuacao":null,"grupo":null,"tags":null},{"posicao":"1","tipoLogradouro":"R","logradouro":"ALBATROZ","numero":"65","complemento":"BL C AP 22","bairro":"VL PE MANOEL DE NOBREGA","cidade":"CAMPINAS","uf":"SP","cep":"13061371","latitude":"-22.9115463","longitude":"-47.1190353","pontuacao":null,"grupo":null,"tags":null}]
     * emails : [{"posicao":"0","email":"hederson.albertini@gmail.com","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null},{"posicao":"1","email":"uniontransportes@ibest.com.br","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null}]
     */

    private CabecalhoBean cabecalho;
    private CadastroBean cadastro;
    private Object rendaBeneficioAssistencial;
    private TelefonesBean telefones;
    private List<ParticipacoesEmpresasBean> participacoesEmpresas;
    private List<RendaEmpregadorBean> rendaEmpregador;
    private List<EnderecosBean> enderecos;
    private List<EmailsBean> emails;

    public CabecalhoBean getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(CabecalhoBean cabecalho) {
        this.cabecalho = cabecalho;
    }

    public CadastroBean getCadastro() {
        return cadastro;
    }

    public void setCadastro(CadastroBean cadastro) {
        this.cadastro = cadastro;
    }

    public Object getRendaBeneficioAssistencial() {
        return rendaBeneficioAssistencial;
    }

    public void setRendaBeneficioAssistencial(Object rendaBeneficioAssistencial) {
        this.rendaBeneficioAssistencial = rendaBeneficioAssistencial;
    }

    public TelefonesBean getTelefones() {
        return telefones;
    }

    public void setTelefones(TelefonesBean telefones) {
        this.telefones = telefones;
    }

    public List<ParticipacoesEmpresasBean> getParticipacoesEmpresas() {
        return participacoesEmpresas;
    }

    public void setParticipacoesEmpresas(List<ParticipacoesEmpresasBean> participacoesEmpresas) {
        this.participacoesEmpresas = participacoesEmpresas;
    }

    public List<RendaEmpregadorBean> getRendaEmpregador() {
        return rendaEmpregador;
    }

    public void setRendaEmpregador(List<RendaEmpregadorBean> rendaEmpregador) {
        this.rendaEmpregador = rendaEmpregador;
    }

    public List<EnderecosBean> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecosBean> enderecos) {
        this.enderecos = enderecos;
    }

    public List<EmailsBean> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailsBean> emails) {
        this.emails = emails;
    }

    public static class CabecalhoBean {
        /**
         * entrada : 22430907836
         * produto : LOCALIZE
         * consulta : PESSOA_FISICA
         * protocoloTransacao : 9927d0c1-e3b2-4d43-88d9-21da1c52581b
         * dataHora : 07/05/2017 01:31:05
         */

        private String entrada;
        private String produto;
        private String consulta;
        private String protocoloTransacao;
        private String dataHora;

        public String getEntrada() {
            return entrada;
        }

        public void setEntrada(String entrada) {
            this.entrada = entrada;
        }

        public String getProduto() {
            return produto;
        }

        public void setProduto(String produto) {
            this.produto = produto;
        }

        public String getConsulta() {
            return consulta;
        }

        public void setConsulta(String consulta) {
            this.consulta = consulta;
        }

        public String getProtocoloTransacao() {
            return protocoloTransacao;
        }

        public void setProtocoloTransacao(String protocoloTransacao) {
            this.protocoloTransacao = protocoloTransacao;
        }

        public String getDataHora() {
            return dataHora;
        }

        public void setDataHora(String dataHora) {
            this.dataHora = dataHora;
        }
    }

    public static class CadastroBean {
        /**
         * cpf : 22430907836
         * nome : HEDERSON VICTOR ALBERTINI
         * sexo : M
         * dataNascimento : 22/12/1983
         * idade : 33
         * faixaIdade : 30 a 34 anos
         * signo : Sagitário
         * rg : 032664133
         * ufRg : SP
         * status : null
         * statusData : null
         * maeNome : MARIA JOSE VICTOR DE CARVALHO
         * maeCpf : 03479036813
         * obitoProvavel : NÃO
         * tituloEleitoral : null
         * grauInstrucao : null
         * dependentes : null
         * estadoCivil : null
         * tags : null
         */

        private String cpf;
        private String nome;
        private String sexo;
        private String dataNascimento;
        private String idade;
        private String faixaIdade;
        private String signo;
        private String rg;
        private String ufRg;
        private Object status;
        private Object statusData;
        private String maeNome;
        private String maeCpf;
        private String obitoProvavel;
        private Object tituloEleitoral;
        private Object grauInstrucao;
        private Object dependentes;
        private Object estadoCivil;
        private Object tags;

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

        public String getIdade() {
            return idade;
        }

        public void setIdade(String idade) {
            this.idade = idade;
        }

        public String getFaixaIdade() {
            return faixaIdade;
        }

        public void setFaixaIdade(String faixaIdade) {
            this.faixaIdade = faixaIdade;
        }

        public String getSigno() {
            return signo;
        }

        public void setSigno(String signo) {
            this.signo = signo;
        }

        public String getRg() {
            return rg;
        }

        public void setRg(String rg) {
            this.rg = rg;
        }

        public String getUfRg() {
            return ufRg;
        }

        public void setUfRg(String ufRg) {
            this.ufRg = ufRg;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public Object getStatusData() {
            return statusData;
        }

        public void setStatusData(Object statusData) {
            this.statusData = statusData;
        }

        public String getMaeNome() {
            return maeNome;
        }

        public void setMaeNome(String maeNome) {
            this.maeNome = maeNome;
        }

        public String getMaeCpf() {
            return maeCpf;
        }

        public void setMaeCpf(String maeCpf) {
            this.maeCpf = maeCpf;
        }

        public String getObitoProvavel() {
            return obitoProvavel;
        }

        public void setObitoProvavel(String obitoProvavel) {
            this.obitoProvavel = obitoProvavel;
        }

        public Object getTituloEleitoral() {
            return tituloEleitoral;
        }

        public void setTituloEleitoral(Object tituloEleitoral) {
            this.tituloEleitoral = tituloEleitoral;
        }

        public Object getGrauInstrucao() {
            return grauInstrucao;
        }

        public void setGrauInstrucao(Object grauInstrucao) {
            this.grauInstrucao = grauInstrucao;
        }

        public Object getDependentes() {
            return dependentes;
        }

        public void setDependentes(Object dependentes) {
            this.dependentes = dependentes;
        }

        public Object getEstadoCivil() {
            return estadoCivil;
        }

        public void setEstadoCivil(Object estadoCivil) {
            this.estadoCivil = estadoCivil;
        }

        public Object getTags() {
            return tags;
        }

        public void setTags(Object tags) {
            this.tags = tags;
        }
    }

    public static class TelefonesBean {
        private List<FixosBean> fixos;
        private List<MoveisBean> moveis;

        public List<FixosBean> getFixos() {
            return fixos;
        }

        public void setFixos(List<FixosBean> fixos) {
            this.fixos = fixos;
        }

        public List<MoveisBean> getMoveis() {
            return moveis;
        }

        public void setMoveis(List<MoveisBean> moveis) {
            this.moveis = moveis;
        }

        public static class FixosBean {
            /**
             * posicao : 0
             * telefone : 1932037034
             * operadora : Embratel  - Fixo
             * pontuacao : null
             * grupo : null
             * relacao : Direto
             * tags : null
             */

            private String posicao;
            private String telefone;
            private String operadora;
            private Object pontuacao;
            private Object grupo;
            private String relacao;
            private Object tags;

            public String getPosicao() {
                return posicao;
            }

            public void setPosicao(String posicao) {
                this.posicao = posicao;
            }

            public String getTelefone() {
                return telefone;
            }

            public void setTelefone(String telefone) {
                this.telefone = telefone;
            }

            public String getOperadora() {
                return operadora;
            }

            public void setOperadora(String operadora) {
                this.operadora = operadora;
            }

            public Object getPontuacao() {
                return pontuacao;
            }

            public void setPontuacao(Object pontuacao) {
                this.pontuacao = pontuacao;
            }

            public Object getGrupo() {
                return grupo;
            }

            public void setGrupo(Object grupo) {
                this.grupo = grupo;
            }

            public String getRelacao() {
                return relacao;
            }

            public void setRelacao(String relacao) {
                this.relacao = relacao;
            }

            public Object getTags() {
                return tags;
            }

            public void setTags(Object tags) {
                this.tags = tags;
            }
        }

        public static class MoveisBean {
            /**
             * posicao : 0
             * telefone : 11954117424
             * operadora : OI - Celular
             * pontuacao : null
             * grupo : null
             * relacao : Direto
             * tags : null
             */

            private String posicao;
            private String telefone;
            private String operadora;
            private Object pontuacao;
            private Object grupo;
            private String relacao;
            private Object tags;

            public String getPosicao() {
                return posicao;
            }

            public void setPosicao(String posicao) {
                this.posicao = posicao;
            }

            public String getTelefone() {
                return telefone;
            }

            public void setTelefone(String telefone) {
                this.telefone = telefone;
            }

            public String getOperadora() {
                return operadora;
            }

            public void setOperadora(String operadora) {
                this.operadora = operadora;
            }

            public Object getPontuacao() {
                return pontuacao;
            }

            public void setPontuacao(Object pontuacao) {
                this.pontuacao = pontuacao;
            }

            public Object getGrupo() {
                return grupo;
            }

            public void setGrupo(Object grupo) {
                this.grupo = grupo;
            }

            public String getRelacao() {
                return relacao;
            }

            public void setRelacao(String relacao) {
                this.relacao = relacao;
            }

            public Object getTags() {
                return tags;
            }

            public void setTags(Object tags) {
                this.tags = tags;
            }
        }
    }

    public static class ParticipacoesEmpresasBean {
        /**
         * posicao : 1
         * documento : 15724796000100
         * nome : ASSERTIVA SOLUCOES EM MARKETING E CREDITO LTDA - EPP
         * participacao : 50.00
         * qualificacaoSocio : SOCIO-ADMINISTRADOR
         * dataEntrada : 01/06/2012
         * dataSaida : null
         * valorParticipacao : null
         * tags : null
         */

        private String posicao;
        private String documento;
        private String nome;
        private String participacao;
        private String qualificacaoSocio;
        private String dataEntrada;
        private Object dataSaida;
        private Object valorParticipacao;
        private Object tags;

        public String getPosicao() {
            return posicao;
        }

        public void setPosicao(String posicao) {
            this.posicao = posicao;
        }

        public String getDocumento() {
            return documento;
        }

        public void setDocumento(String documento) {
            this.documento = documento;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getParticipacao() {
            return participacao;
        }

        public void setParticipacao(String participacao) {
            this.participacao = participacao;
        }

        public String getQualificacaoSocio() {
            return qualificacaoSocio;
        }

        public void setQualificacaoSocio(String qualificacaoSocio) {
            this.qualificacaoSocio = qualificacaoSocio;
        }

        public String getDataEntrada() {
            return dataEntrada;
        }

        public void setDataEntrada(String dataEntrada) {
            this.dataEntrada = dataEntrada;
        }

        public Object getDataSaida() {
            return dataSaida;
        }

        public void setDataSaida(Object dataSaida) {
            this.dataSaida = dataSaida;
        }

        public Object getValorParticipacao() {
            return valorParticipacao;
        }

        public void setValorParticipacao(Object valorParticipacao) {
            this.valorParticipacao = valorParticipacao;
        }

        public Object getTags() {
            return tags;
        }

        public void setTags(Object tags) {
            this.tags = tags;
        }
    }

    public static class RendaEmpregadorBean {
        /**
         * posicao : 1
         * empregador : ASSOCIACAO COMERCIAL DE SAO PAULO
         * documentoEmpregador : 60524550000131
         * setorEmpregador : ATIVIDADES DE ORGANIZAÇÕES ASSOCIATIVAS
         * cboCodigo : 252105
         * cboDescricao : Administrador
         * cboSetor : null
         * cboSinonimos : null
         * rendaEstimada : null
         * faixaRenda : De 1 a 2 Salários Mínimos
         * rendaDataRef : 2013-07-14
         * tags : null
         */

        private String posicao;
        private String empregador;
        private String documentoEmpregador;
        private String setorEmpregador;
        private String cboCodigo;
        private String cboDescricao;
        private Object cboSetor;
        private Object cboSinonimos;
        private Object rendaEstimada;
        private String faixaRenda;
        private String rendaDataRef;
        private Object tags;

        public String getPosicao() {
            return posicao;
        }

        public void setPosicao(String posicao) {
            this.posicao = posicao;
        }

        public String getEmpregador() {
            return empregador;
        }

        public void setEmpregador(String empregador) {
            this.empregador = empregador;
        }

        public String getDocumentoEmpregador() {
            return documentoEmpregador;
        }

        public void setDocumentoEmpregador(String documentoEmpregador) {
            this.documentoEmpregador = documentoEmpregador;
        }

        public String getSetorEmpregador() {
            return setorEmpregador;
        }

        public void setSetorEmpregador(String setorEmpregador) {
            this.setorEmpregador = setorEmpregador;
        }

        public String getCboCodigo() {
            return cboCodigo;
        }

        public void setCboCodigo(String cboCodigo) {
            this.cboCodigo = cboCodigo;
        }

        public String getCboDescricao() {
            return cboDescricao;
        }

        public void setCboDescricao(String cboDescricao) {
            this.cboDescricao = cboDescricao;
        }

        public Object getCboSetor() {
            return cboSetor;
        }

        public void setCboSetor(Object cboSetor) {
            this.cboSetor = cboSetor;
        }

        public Object getCboSinonimos() {
            return cboSinonimos;
        }

        public void setCboSinonimos(Object cboSinonimos) {
            this.cboSinonimos = cboSinonimos;
        }

        public Object getRendaEstimada() {
            return rendaEstimada;
        }

        public void setRendaEstimada(Object rendaEstimada) {
            this.rendaEstimada = rendaEstimada;
        }

        public String getFaixaRenda() {
            return faixaRenda;
        }

        public void setFaixaRenda(String faixaRenda) {
            this.faixaRenda = faixaRenda;
        }

        public String getRendaDataRef() {
            return rendaDataRef;
        }

        public void setRendaDataRef(String rendaDataRef) {
            this.rendaDataRef = rendaDataRef;
        }

        public Object getTags() {
            return tags;
        }

        public void setTags(Object tags) {
            this.tags = tags;
        }
    }

    public static class EnderecosBean {
        /**
         * posicao : 0
         * tipoLogradouro : R
         * logradouro : ALBATROZ
         * numero : 65
         * complemento : AP 22 B 2 F
         * bairro : VL PE MANOEL DE NOBREGA
         * cidade : CAMPINAS
         * uf : SP
         * cep : 13061371
         * latitude : -22.9115463
         * longitude : -47.1190353
         * pontuacao : null
         * grupo : null
         * tags : null
         */

        private String posicao;
        private String tipoLogradouro;
        private String logradouro;
        private String numero;
        private String complemento;
        private String bairro;
        private String cidade;
        private String uf;
        private String cep;
        private String latitude;
        private String longitude;
        private Object pontuacao;
        private Object grupo;
        private Object tags;

        public String getPosicao() {
            return posicao;
        }

        public void setPosicao(String posicao) {
            this.posicao = posicao;
        }

        public String getTipoLogradouro() {
            return tipoLogradouro;
        }

        public void setTipoLogradouro(String tipoLogradouro) {
            this.tipoLogradouro = tipoLogradouro;
        }

        public String getLogradouro() {
            return logradouro;
        }

        public void setLogradouro(String logradouro) {
            this.logradouro = logradouro;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public String getComplemento() {
            return complemento;
        }

        public void setComplemento(String complemento) {
            this.complemento = complemento;
        }

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getUf() {
            return uf;
        }

        public void setUf(String uf) {
            this.uf = uf;
        }

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public Object getPontuacao() {
            return pontuacao;
        }

        public void setPontuacao(Object pontuacao) {
            this.pontuacao = pontuacao;
        }

        public Object getGrupo() {
            return grupo;
        }

        public void setGrupo(Object grupo) {
            this.grupo = grupo;
        }

        public Object getTags() {
            return tags;
        }

        public void setTags(Object tags) {
            this.tags = tags;
        }
    }

    public static class EmailsBean {
        /**
         * posicao : 0
         * email : hederson.albertini@gmail.com
         * pontuacao : null
         * grupo : null
         * relacao : Direto
         * tags : null
         */

        private String posicao;
        private String email;
        private Object pontuacao;
        private Object grupo;
        private String relacao;
        private Object tags;

        public String getPosicao() {
            return posicao;
        }

        public void setPosicao(String posicao) {
            this.posicao = posicao;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getPontuacao() {
            return pontuacao;
        }

        public void setPontuacao(Object pontuacao) {
            this.pontuacao = pontuacao;
        }

        public Object getGrupo() {
            return grupo;
        }

        public void setGrupo(Object grupo) {
            this.grupo = grupo;
        }

        public String getRelacao() {
            return relacao;
        }

        public void setRelacao(String relacao) {
            this.relacao = relacao;
        }

        public Object getTags() {
            return tags;
        }

        public void setTags(Object tags) {
            this.tags = tags;
        }
    }
}
