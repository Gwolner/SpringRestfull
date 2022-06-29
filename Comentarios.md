# :white_check_mark: Comentario - Local

### Inserir `POST` | `/Local/Comentar`

Enviar: 
```json
{
  "avaliacao":"67",
  "texto":"Inserir teste premium",
  "idLocal":"12"
}
```

### Ler 

Ocorre ao ler um Local

### Atualizar `PUT` | `/Local/Comentar`

Enviar: 
```json
{
  "id":"8",
  "avaliacao":"66",
  "texto":"Teste premium novamente"
}
```

### Ler Todos 

Ocorre ao consultar todos os Locais

### Deletar `DELETE` | `/Local/Comentar/{id}`


# :white_check_mark: Comentario - Instituicao

### Inserir `POST` | `/Instituicao/Comentar`

Enviar: 
```json
{
  "texto":"teste AA de comentario",
  "cnpjInstituicao":"34303323000176"
}
```

### Ler 

Ocorre ao ler uma Instituicao

### Atualizar `PUT` | `/Instituicao/Comentar`

Enviar: 
```json
{
  "id":"5",
  "texto":"Teste premium"
}
```

### Ler Todos 

Ocorre ao consultar todas as Instituicoes

### Deletar `DELETE` | `/Instituicao/Comentar/{id}`




