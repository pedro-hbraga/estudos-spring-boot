# estudos-spring-boot
Estudos sobre Java e Spring Boot.

Estudo realizado com instrução da formação da Alura de Java e Spring Boot.

Objetivo: Desenvolver uma API REST  // Obs: Sem utilização de Front, totalmente focado em Back

Tema: Clínica Médica

Ferramentas:
Spring Boot 3
Java
Lombok
MySQL
JPA/ Hibernate
Maven  -> Gerenciamento de dependências 
Insomnia
Migration

Utilizei também o Spring Initializr para gerar as dependências do projeto.

Utilizo o padrão DTO - Data Transfer Object, ou seja, representar os dados, recebidos e enviados, em OBJETOS

RECORDS: DadosCadastroMedico, DadosEndereco

Controllers:
ControllerMedico
POST
Realiza a Insercao na base vollmed_api, table medicos