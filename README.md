# Product CRUD API

A layered Java 17 application built with Spring Boot, Maven, Spring Data JPA, MySQL, and Thymeleaf. It provides a browser-based product manager and a JSON REST API.

## Architecture

```text
src/main/java/com/example/crud/
  controller/  HTTP endpoints
  dto/         Request validation
  model/       JPA entity
  repository/  Database access
  service/     Business logic
  resources/templates/  Thymeleaf pages
  resources/static/     CSS assets
```

## Run locally

Prerequisites: JDK 17+, Maven, and Docker with Compose.

Start MySQL:

```powershell
docker compose up -d
```

Start the API:

```powershell
mvn spring-boot:run
```

Run tests with `mvn test`. The web interface is at `http://localhost:8080/products`; the JSON API is at `http://localhost:8080/api/products`.

The default database settings match `docker-compose.yml`. Override them with `DB_HOST`, `DB_PORT`, `DB_NAME`, `DB_USERNAME`, and `DB_PASSWORD` environment variables. Hibernate creates or updates the `products` table on startup.

## Endpoints

| Method | Path | Description |
| --- | --- | --- |
| `POST` | `/api/products` | Create a product |
| `GET` | `/api/products` | List products |
| `GET` | `/api/products/{id}` | Get a product |
| `PUT` | `/api/products/{id}` | Replace a product's fields |
| `DELETE` | `/api/products/{id}` | Delete a product |

Create/update request body:

```json
{
  "name": "Keyboard",
  "description": "Mechanical keyboard",
  "price": 79.99
}
```