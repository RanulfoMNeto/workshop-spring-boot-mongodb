# Workshop Spring Boot MongoDB

Repositório da API Workshop Spring Boot MongoDB, uma aplicação que gerencia posts e usuários.

A API possui endpoints para buscar, criar, atualizar e excluir posts, assim como para listar todos os usuários e seus respectivos posts. Além disso, é possível fazer buscas por texto no título, corpo e comentários dos posts e filtrar por intervalos de datas. O projeto é desenvolvido em Java utilizando o framework Spring e MongoDB como banco de dados.

## User

`GET /users`

Retorna a lista de todos os usuários cadastrados.

`GET /users/{id}`

Retorna um usuário específico pelo seu ID.

`POST /users`

Cria um novo usuário.

`DELETE /users/{id}`

Remove um usuário específico pelo seu ID.

`PUT /users/{id}`

Atualiza as informações de um usuário específico pelo seu ID.

`GET /users/{id}/posts`

Retorna a lista de posts de um usuário específico pelo seu ID.

## Post

`GET /posts/{id}`

Retorna um post específico pelo seu ID.

`GET /posts/search?search={text}`

Busca posts que contenham um determinado texto no título.

`GET /posts/fullsearch?search={text}&minDate={minDate}&maxDate={maxDate}`

Busca posts que contenham um determinado texto no título, corpo e comentários e foram criados em um intervalo de datas específico.
