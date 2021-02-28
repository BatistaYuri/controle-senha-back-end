# Gerenciador de senhas

Sistema de controle de senhas para atendimento bancário. O sistema será utilizado por dois perfis de usuários: GERENTE e CLIENTE. O Gerente será responsável pela administração do sistema, chamando novas senhas e reiniciando a contagem de senhas quando for necessário. Ao cliente caberá apenas a retirada e acompanhamento das senhas.

# Configurações
Este projeto foi desenvolvido em Java 8 com framework Spring boot para utilizar arquitetuira REST;
Servidor roda em Tomcat;
Banco de dados PostgreSQL 13.

### Clonar projeto do GitHub
git clone https://github.com/BatistaYuri/controle-senha-back-end.git

## Configuração do ambiente
Optei por utilizar Spring Tools 4 para Eclipse (https://spring.io/tools), ao incializar um novo projeto é configurado automaticamente o Maven e o Tomcat.

Na IDE importe o projeto como projeto maven.

No arquivo src\main\resources\application.properties está configurado o banco de dados no servidor da [Amazon AWS](https://aws.amazon.com/pt/), caso deseje utilizar 
o banco de dados local troque as configurações.

Excecute o arquivo src\main\java\com\paripassu\senhas\SenhasApplication.java como "Java Application" para rodar a aplicação.

### Documentação da API
Local :http://localhost:8080/swagger-ui.html
Servidor Amazon AWS: http://gerenciadordesenhas2-env.eba-2iebjrez.sa-east-1.elasticbeanstalk.com/swagger-ui.html
