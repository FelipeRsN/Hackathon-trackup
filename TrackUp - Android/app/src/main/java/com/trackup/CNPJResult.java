package com.trackup;

import java.util.List;

/**
 * Created by felipersn on 07/05/17.
 */

public class CNPJResult {
    /**
     * cabecalho : {"entrada":"15724796000100","produto":"LOCALIZE","consulta":"PESSOA_JURIDICA","protocoloTransacao":"ee27e6f6-2b5b-4d2d-8e52-7fabc70db177","dataHora":"06/05/2017 20:19:44"}
     * cadastro : {"cnpj":"15724796000100","razaoSocial":"ASSERTIVA SOLUCOES EM MARKETING E CREDITO LTDA - EPP","nomeFantasia":"ASSERTIVA SOLUCOES EM MARKETING E CREDITO","dataAbertura":"01/06/2012","idadeEmpresa":"4","faixaIdade":"0 a 4 anos","quantidadeFuncionarios":null,"faixaFuncionarios":"Número de Funcionários não Fornecido","porteEmpresa":null,"receitaStatus":null,"dataReceitaStatus":null,"cnae":"6209100","cnaeDescricao":"Suporte técnico, manutenção e outros serviços em tecnologia da informação","cnaeGrupo":"ATIVIDADES DOS SERVIÇOS DE TECNOLOGIA DA INFORMAÇÃO","cnaeSubgrupo":null,"tipoEmpresa":"MATRIZ","naturezaJuridica":null,"nire":null,"site":null,"regimeTributario":null,"tags":null}
     * cadastroCnpjCnaesSecundarias : [{"posicao":"0","cnae":"1822999","descricao":"Serviços de acabamentos gráficos, exceto encadernação e plastificação","grupo":"IMPRESSÃO E REPRODUÇÃO DE GRAVAÇÕES","subgrupo":null},{"posicao":"1","cnae":"6202300","descricao":"Desenvolvimento e licenciamento de programas de computador customizáveis","grupo":"ATIVIDADES DOS SERVIÇOS DE TECNOLOGIA DA INFORMAÇÃO","subgrupo":null},{"posicao":"2","cnae":"6311900","descricao":"Tratamento de dados, provedores de serviços de aplicação e serviços de hospedagem na internet","grupo":"ATIVIDADES DE PRESTAÇÃO DE SERVIÇOS DE INFORMAÇÃO","subgrupo":null}]
     * quadroSocietario : [{"posicao":"0","documento":"22430907836","nome":"HEDERSON VICTOR ALBERTINI","participacao":"50.00","qualificacaoSocio":"SOCIO-ADMINISTRADOR","dataEntrada":"01/06/2012","dataSaida":null,"valorParticipacao":null,"tags":null},{"posicao":"1","documento":"06621990812","nome":"DOMINGO MARTIN JUNIOR","participacao":"50.00","qualificacaoSocio":"SOCIO-ADMINISTRADOR","dataEntrada":"05/06/2013","dataSaida":null,"valorParticipacao":null,"tags":null}]
     * participacoesEmpresas : null
     * telefones : {"fixos":[{"posicao":"0","telefone":"1932081277","operadora":"Vivo - Fixo","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null},{"posicao":"1","telefone":"1933420545","operadora":"America NET - Fixo","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null},{"posicao":"2","telefone":"1933420544","operadora":"America NET - Fixo","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null},{"posicao":"3","telefone":"1935003450","operadora":"America NET - Fixo","pontuacao":null,"grupo":null,"relacao":"Direto","tags":null}],"moveis":[]}
     * enderecos : [{"posicao":"0","tipoLogradouro":"AV","logradouro":"JOSE ROCHA BOMFIM","numero":"214","complemento":"BL S SL 214","bairro":"LOT CENTER SANTA GENEBRA","cidade":"CAMPINAS","uf":"SP","cep":"13080650","latitude":"-22.8465333","longitude":"-47.0846438","pontuacao":null,"grupo":null,"tags":null},{"posicao":"1","tipoLogradouro":"R","logradouro":"LUIS GAMA","numero":"1117","complemento":null,"bairro":"BONFIM","cidade":"CAMPINAS","uf":"SP","cep":"13070717","latitude":"-22.8977522","longitude":"-47.0772862","pontuacao":null,"grupo":null,"tags":null}]
     * emails : null
     */

    private CabecalhoBean cabecalho;
    private CadastroBean cadastro;
    private Object participacoesEmpresas;
    private TelefonesBean telefones;
    private Object emails;
    private List<CadastroCnpjCnaesSecundariasBean> cadastroCnpjCnaesSecundarias;
    private List<QuadroSocietarioBean> quadroSocietario;
    private List<EnderecosBean> enderecos;

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

    public Object getParticipacoesEmpresas() {
        return participacoesEmpresas;
    }

    public void setParticipacoesEmpresas(Object participacoesEmpresas) {
        this.participacoesEmpresas = participacoesEmpresas;
    }

    public TelefonesBean getTelefones() {
        return telefones;
    }

    public void setTelefones(TelefonesBean telefones) {
        this.telefones = telefones;
    }

    public Object getEmails() {
        return emails;
    }

    public void setEmails(Object emails) {
        this.emails = emails;
    }

    public List<CadastroCnpjCnaesSecundariasBean> getCadastroCnpjCnaesSecundarias() {
        return cadastroCnpjCnaesSecundarias;
    }

    public void setCadastroCnpjCnaesSecundarias(List<CadastroCnpjCnaesSecundariasBean> cadastroCnpjCnaesSecundarias) {
        this.cadastroCnpjCnaesSecundarias = cadastroCnpjCnaesSecundarias;
    }

    public List<QuadroSocietarioBean> getQuadroSocietario() {
        return quadroSocietario;
    }

    public void setQuadroSocietario(List<QuadroSocietarioBean> quadroSocietario) {
        this.quadroSocietario = quadroSocietario;
    }

    public List<EnderecosBean> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecosBean> enderecos) {
        this.enderecos = enderecos;
    }

    public static class CabecalhoBean {
        /**
         * entrada : 15724796000100
         * produto : LOCALIZE
         * consulta : PESSOA_JURIDICA
         * protocoloTransacao : ee27e6f6-2b5b-4d2d-8e52-7fabc70db177
         * dataHora : 06/05/2017 20:19:44
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
         * cnpj : 15724796000100
         * razaoSocial : ASSERTIVA SOLUCOES EM MARKETING E CREDITO LTDA - EPP
         * nomeFantasia : ASSERTIVA SOLUCOES EM MARKETING E CREDITO
         * dataAbertura : 01/06/2012
         * idadeEmpresa : 4
         * faixaIdade : 0 a 4 anos
         * quantidadeFuncionarios : null
         * faixaFuncionarios : Número de Funcionários não Fornecido
         * porteEmpresa : null
         * receitaStatus : null
         * dataReceitaStatus : null
         * cnae : 6209100
         * cnaeDescricao : Suporte técnico, manutenção e outros serviços em tecnologia da informação
         * cnaeGrupo : ATIVIDADES DOS SERVIÇOS DE TECNOLOGIA DA INFORMAÇÃO
         * cnaeSubgrupo : null
         * tipoEmpresa : MATRIZ
         * naturezaJuridica : null
         * nire : null
         * site : null
         * regimeTributario : null
         * tags : null
         */

        private String cnpj;
        private String razaoSocial;
        private String nomeFantasia;
        private String dataAbertura;
        private String idadeEmpresa;
        private String faixaIdade;
        private Object quantidadeFuncionarios;
        private String faixaFuncionarios;
        private Object porteEmpresa;
        private Object receitaStatus;
        private Object dataReceitaStatus;
        private String cnae;
        private String cnaeDescricao;
        private String cnaeGrupo;
        private Object cnaeSubgrupo;
        private String tipoEmpresa;
        private Object naturezaJuridica;
        private Object nire;
        private Object site;
        private Object regimeTributario;
        private Object tags;

        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }

        public String getRazaoSocial() {
            return razaoSocial;
        }

        public void setRazaoSocial(String razaoSocial) {
            this.razaoSocial = razaoSocial;
        }

        public String getNomeFantasia() {
            return nomeFantasia;
        }

        public void setNomeFantasia(String nomeFantasia) {
            this.nomeFantasia = nomeFantasia;
        }

        public String getDataAbertura() {
            return dataAbertura;
        }

        public void setDataAbertura(String dataAbertura) {
            this.dataAbertura = dataAbertura;
        }

        public String getIdadeEmpresa() {
            return idadeEmpresa;
        }

        public void setIdadeEmpresa(String idadeEmpresa) {
            this.idadeEmpresa = idadeEmpresa;
        }

        public String getFaixaIdade() {
            return faixaIdade;
        }

        public void setFaixaIdade(String faixaIdade) {
            this.faixaIdade = faixaIdade;
        }

        public Object getQuantidadeFuncionarios() {
            return quantidadeFuncionarios;
        }

        public void setQuantidadeFuncionarios(Object quantidadeFuncionarios) {
            this.quantidadeFuncionarios = quantidadeFuncionarios;
        }

        public String getFaixaFuncionarios() {
            return faixaFuncionarios;
        }

        public void setFaixaFuncionarios(String faixaFuncionarios) {
            this.faixaFuncionarios = faixaFuncionarios;
        }

        public Object getPorteEmpresa() {
            return porteEmpresa;
        }

        public void setPorteEmpresa(Object porteEmpresa) {
            this.porteEmpresa = porteEmpresa;
        }

        public Object getReceitaStatus() {
            return receitaStatus;
        }

        public void setReceitaStatus(Object receitaStatus) {
            this.receitaStatus = receitaStatus;
        }

        public Object getDataReceitaStatus() {
            return dataReceitaStatus;
        }

        public void setDataReceitaStatus(Object dataReceitaStatus) {
            this.dataReceitaStatus = dataReceitaStatus;
        }

        public String getCnae() {
            return cnae;
        }

        public void setCnae(String cnae) {
            this.cnae = cnae;
        }

        public String getCnaeDescricao() {
            return cnaeDescricao;
        }

        public void setCnaeDescricao(String cnaeDescricao) {
            this.cnaeDescricao = cnaeDescricao;
        }

        public String getCnaeGrupo() {
            return cnaeGrupo;
        }

        public void setCnaeGrupo(String cnaeGrupo) {
            this.cnaeGrupo = cnaeGrupo;
        }

        public Object getCnaeSubgrupo() {
            return cnaeSubgrupo;
        }

        public void setCnaeSubgrupo(Object cnaeSubgrupo) {
            this.cnaeSubgrupo = cnaeSubgrupo;
        }

        public String getTipoEmpresa() {
            return tipoEmpresa;
        }

        public void setTipoEmpresa(String tipoEmpresa) {
            this.tipoEmpresa = tipoEmpresa;
        }

        public Object getNaturezaJuridica() {
            return naturezaJuridica;
        }

        public void setNaturezaJuridica(Object naturezaJuridica) {
            this.naturezaJuridica = naturezaJuridica;
        }

        public Object getNire() {
            return nire;
        }

        public void setNire(Object nire) {
            this.nire = nire;
        }

        public Object getSite() {
            return site;
        }

        public void setSite(Object site) {
            this.site = site;
        }

        public Object getRegimeTributario() {
            return regimeTributario;
        }

        public void setRegimeTributario(Object regimeTributario) {
            this.regimeTributario = regimeTributario;
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
        private List<?> moveis;

        public List<FixosBean> getFixos() {
            return fixos;
        }

        public void setFixos(List<FixosBean> fixos) {
            this.fixos = fixos;
        }

        public List<?> getMoveis() {
            return moveis;
        }

        public void setMoveis(List<?> moveis) {
            this.moveis = moveis;
        }

        public static class FixosBean {
            /**
             * posicao : 0
             * telefone : 1932081277
             * operadora : Vivo - Fixo
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

    public static class CadastroCnpjCnaesSecundariasBean {
        /**
         * posicao : 0
         * cnae : 1822999
         * descricao : Serviços de acabamentos gráficos, exceto encadernação e plastificação
         * grupo : IMPRESSÃO E REPRODUÇÃO DE GRAVAÇÕES
         * subgrupo : null
         */

        private String posicao;
        private String cnae;
        private String descricao;
        private String grupo;
        private Object subgrupo;

        public String getPosicao() {
            return posicao;
        }

        public void setPosicao(String posicao) {
            this.posicao = posicao;
        }

        public String getCnae() {
            return cnae;
        }

        public void setCnae(String cnae) {
            this.cnae = cnae;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getGrupo() {
            return grupo;
        }

        public void setGrupo(String grupo) {
            this.grupo = grupo;
        }

        public Object getSubgrupo() {
            return subgrupo;
        }

        public void setSubgrupo(Object subgrupo) {
            this.subgrupo = subgrupo;
        }
    }

    public static class QuadroSocietarioBean {
        /**
         * posicao : 0
         * documento : 22430907836
         * nome : HEDERSON VICTOR ALBERTINI
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

    public static class EnderecosBean {
        /**
         * posicao : 0
         * tipoLogradouro : AV
         * logradouro : JOSE ROCHA BOMFIM
         * numero : 214
         * complemento : BL S SL 214
         * bairro : LOT CENTER SANTA GENEBRA
         * cidade : CAMPINAS
         * uf : SP
         * cep : 13080650
         * latitude : -22.8465333
         * longitude : -47.0846438
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
}
