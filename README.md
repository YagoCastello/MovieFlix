# MovieFlix

# 🎬 MovieFlixNeo

API REST desenvolvida em **Spring Boot** para gerenciamento de um catálogo de filmes, construída como projeto de estudo e portfólio para vagas de desenvolvedor Java Júnior.

## 📌 Sobre o projeto

O MovieFlixNeo é uma aplicação backend que expõe endpoints para cadastro, consulta, atualização e remoção de filmes (CRUD), utilizando uma arquitetura em camadas (Controller → Service → Repository) e persistência com PostgreSQL versionada via Flyway.

## 🚀 Tecnologias utilizadas

- **Java**
- **Spring Boot**
- **Spring Data JPA** (Hibernate)
- **Flyway** — versionamento e migração de schema do banco de dados
- **PostgreSQL** — banco de dados relacional
- **Maven** — gerenciamento de dependências
- **Docker** — containerização do banco de dados (opcional)

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```
src
└── main
    ├── java
    │   └── com.seuusuario.movieflixneo
    │       ├── controller     # Endpoints REST
    │       ├── service        # Regras de negócio
    │       ├── repository     # Acesso a dados (Spring Data JPA)
    │       ├── model          # Entidades JPA
    │       └── dto            # Objetos de transferência de dados
    └── resources
        ├── db.migration       # Scripts de versionamento (Flyway)
        └── application.yml    # Configurações da aplicação
```

## ⚙️ Pré-requisitos

- Java 17+
- Maven 3.8+
- PostgreSQL (ou Docker para subir via container)

## 🔧 Como executar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/YagoCastello/movieflixneo.git
   cd movieflixneo
   ```

2. Configure o banco de dados no arquivo `application.yml` (ou `application.properties`):
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/movieflixneo
       username: seu_usuario
       password: sua_senha
   ```

3. (Opcional) Suba o banco via Docker:
   ```bash
   docker run --name movieflixneo-db -e POSTGRES_DB=movieflixneo \
     -e POSTGRES_USER=seu_usuario -e POSTGRES_PASSWORD=sua_senha \
     -p 5432:5432 -d postgres
   ```

4. Execute as migrações e suba a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

5. A API estará disponível em:
   ```
   http://localhost:8080
   ```

## 📚 Endpoints principais

| Método | Endpoint          | Descrição                        |
|--------|-------------------|-----------------------------------|
| GET    | `/movies`         | Lista todos os filmes             |
| GET    | `/movies/{id}`    | Busca um filme por ID             |
| POST   | `/movies`         | Cadastra um novo filme            |
| PUT    | `/movies/{id}`    | Atualiza um filme existente       |
| DELETE | `/movies/{id}`    | Remove um filme                   |

> Ajuste esta tabela conforme os endpoints reais implementados no seu controller.

## 🗄️ Banco de dados

O schema é versionado com **Flyway**, com scripts localizados em `src/main/resources/db/migration`. As entidades JPA são mapeadas para refletir exatamente as colunas e relacionamentos definidos nessas migrations, evitando divergências entre o modelo Java e o schema do banco.

## 🧪 Testes

```bash
./mvnw test
```

## 📈 Roadmap / próximos passos

- [ ] Implementar autenticação e autorização com Spring Security + JWT
- [ ] Adicionar paginação e filtros nas consultas
- [ ] Documentar a API com Swagger/OpenAPI
- [ ] Cobertura de testes unitários e de integração

## 👤 Autor

**Yago Castello**
- GitHub: [github.com/YagoCastello](https://github.com/YagoCastello)
- LinkedIn: [linkedin.com/in/yagosaloman](https://linkedin.com/in/yagosaloman)

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
