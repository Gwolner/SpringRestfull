# Consumo da API Spring Restful

## :white_check_mark: Endereco

### Inserir `POST` | `/Endereco`

Enviar: 
```json
{
  "logradouro": "Rua Universo da Loucura",
  "numero": "616",
  "bairro": "Sanctum",
  "cidade": "Nova Iorque",
  "estado": "PE",
  "cep": "54.210-081"
}
```

### Atualizar `PUT` | `/Endereco` 

Enviar: 
```json
{
  "id": "4",
  "logradouro": "Rua Temilson Xavier",
  "numero": "87",
  "bairro": "Coque",
  "cidade": "Recife",
  "estado": "PE",
  "cep": "54.270-081"
}
```

### Ler `GET` | `/Endereco/{id}`

Retorno:
```json
{
  "id": 4,
  "logradouro": "Rua Temilson Xavier",
  "numero": "87",
  "bairro": "Coque",
  "cidade": "Pina",
  "estado": "PE",
  "cep": "54.270-081"
}
```

### Deletar `DELETE` | `/Endereco /{id}`

### Ler Todos `GET` | `/Endereco `

Retorno:
```json
[
  {
    "id": 1,
    "logradouro": "Rua Universo da Loucura",
    "numero": "616",
    "bairro": "Sanctum",
    "cidade": "Nova Iorque",
    "estado": "PE",
    "cep": "54.210-081"
  },
  {
    "id": 2,
    "logradouro": "Rua De volta ao lar",
    "numero": "888",
    "bairro": "Miranha",
    "cidade": "Nova Iorque",
    "estado": "PE",
    "cep": "54.270-081"
  },
  {
    "id": 4,
    "logradouro": "Rua Temilson Xavier",
    "numero": "87",
    "bairro": "Coque",
    "cidade": "Pina",
    "estado": "PE",
    "cep": "54.270-081"
  }
]
```

## :white_check_mark: Servico

### Inserir `POST` | `/Servico`

Enviar: 
```json
{
 "designacao":"Abrigo"
}
```

### Atualizar `PUT` | `/Servico`

Enviar: 
```json
{
 "id":"1",
 "designacao":"Abrigo"
}
```

### Ler `GET` | `/Servico/{id}`

Retorno: 
```json
{
  "id": 1,
  "designacao": "Abrigo"
}
```

### Deletar `DELETE` | `/Servico/{id}`

### Ler Todos `GET` | `/Servico`

Retorno:
```json
[
 {
  "id": 1,
  "designacao": "Abrigo"
 },
 {
  "id": 3,
  "designacao": "Abrigo"
 }
]
```
