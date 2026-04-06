# 📊Controle-de-Relatorios


## 🚧 Status do Projeto

Em desenvolvimento

---

## 🛠️ Tecnologias Utilizadas

* Java (JDK)
* Java Swing (Interface gráfica)
* MySQL (Banco de dados)
* NetBeans IDE

---

## 👨‍💻 Time de Desenvolvedores

* Luis Fernando 

---

## 🎯 Objetivo do Software

Este sistema tem como objetivo auxiliar no controle e gerenciamento de relatórios de publicadores, permitindo o registro, acompanhamento e análise de atividades realizadas.

A aplicação busca facilitar a organização das informações, garantindo maior eficiência no controle de dados e geração de relatórios.

---

## ⚙️ Funcionalidades do Sistema

### 📌 Cadastro de Grupos

* Criar novos grupos
* Excluir grupos
* Exclusão em cascata de publicadores e relatórios vinculados

---

### 👤 Cadastro de Publicadores

* Adicionar publicadores a um grupo
* Listar publicadores cadastrados
* Armazenar informações como:
* Nome
* Modalidade
* Situação (ativo/inativo)
* Quantidade de estudos

---

### 📝 Registro de Relatórios

* Selecionar um publicador
* Informar:
* Participação (Sim/Não)
* Modalidade
* Horas (dependendo da modalidade)
* Estudos realizados
* Validação de campos obrigatórios
* Salvamento no banco de dados

---

### 📊 Resumo de Relatórios

* Exibição automática dos dados em tabela:
* Publicadores - Quantidade
* Publicadores - Relatando
* Publicadores - Estudos
* Pioneiro Auxiliar - Quantidade
* Pioneiro Auxiliar - Estudos
* Pioneiro Regular - Quantidade
* Pioneiro Regular - Estudos
* Total de Estudos

---

### 🔄 Atualização em Tempo Real

* Atualização automática da tabela de relatórios ao salvar dados

---

## 💡 Regras de Negócio

* Um publicador pertence a apenas um grupo
* Cada publicador possui apenas um relatório
* Exclusão de grupo remove automaticamente seus publicadores e relatórios (ON DELETE CASCADE)
* Campo de horas só é habilitado para modalidades específicas

---

## 📌 Observações

Este projeto foi desenvolvido com fins educacionais, com foco no aprendizado.

