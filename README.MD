![logo](src/main/resources/asset/img/logoLiteralura.webp)

# Challenge Literalura

Literalura es una aplicación de consola desarrollada en Java que permite consultar información sobre libros y autores utilizando una API externa. Además, almacena los datos en una base de datos PostgreSQL para su posterior consulta y análisis.

### Desafío de Especialización de Java en Backend Developer

Este proyecto forma parte del desafío de especialización en Java Backend Developer, diseñado para fortalecer habilidades en el desarrollo de aplicaciones backend, consumo de APIs externas y uso de bases de datos relacionales.

## Descripción

La aplicación proporciona un menú interactivo para:

- Consultar libros mediante una API externa.
- Almacenar y gestionar los libros consultados.
- Consultar autores, libros almacenados, autores vivos y libros por idioma.

### Funcionalidades Principales:

- Búsqueda de libros y autores mediante una API externa.
- Almacenamiento de libros y autores en una base de datos PostgreSQL.
- Listado de libros almacenados.
- Listado de autores almacenados.
- Filtrado de autores vivos.
- Consulta de libros almacenados por idioma.

### Requisitos

- Java 17 o superior.
- PostgreSQL instalado y configurado.
- Conexión a internet para consumir la API externa.
- Configuración de una variable de entorno `API_KEY` para acceder a la API de libros.

## Instalación

1. Clona este repositorio a tu máquina local:

```bash
git clone https://github.com/CasseliLayza/Challenge_Literalura.git
```

2. Configura la base de datos PostgreSQL:

- Crea una base de datos para la aplicación:
  ```sql
  CREATE DATABASE literalura;
  ```
- Configura las credenciales de conexión en el archivo `application.properties`.

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}
```

## Uso

Ejecuta la aplicación desde tu IDE o línea de comandos:

```bash
javac main/java/com/backend/literalura/application/LiteraluraApplication.java
java main.java.com.backend.literalura.application.LiteraluraApplication
```

### Menú de opciones:

```css
*****************************************************
Sea bienbenido/a a Literalura =]

1) Buscar libro por titulo
2) listar libros registrados
3) Listar autores registrados
4) listar autores vivos en un determinado año
5) listar libros por idioma

0) salir
=>> Elija una opcion valida

*****************************************************
```

## Contribuir

1. Haz un fork del repositorio.
2. Crea una rama para tu característica (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva característica'`).
4. Haz push a tu rama (`git push origin feature/nueva-caracteristica`).
5. Abre un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

## Créditos

- Desarrollado como parte del desafío de especialización **Java Backend Developer**.
- 📧 **Correo:** [Casseli Layza](casseli.layzal@dominio.com).

_**¡Gracias por revisar este proyecto!... Powered by Literalura 🌟📚🚀...!!**_

## Derechos Reservados

```markdown
© 2025 Tu Nombre. Todos los derechos reservados.
```
