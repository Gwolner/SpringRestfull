# Consumo da API Spring Restful

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

### Ler Todos `GET` | `/Servicos`

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

## :white_check_mark: Acolhido

### Inserir `POST` | `/Acolhido`

Enviar: 
```json
{
  "cpf": "096.147.852-45",
  "rg": "8.147.598",
  "nome": "Bruce Wayne",
  "tipoContato": "Telegram",
  "contato": "(81)945875236",
  "dataNascimento": "12/05/1996",
  "coordenada": {
    "id": "4",
    "latitude": "66.40338",
    "longitude": "22.17403"
  }
}
```
**Observação:** Para casos de Acolhido sem coordenadas, a Latitude e a Longitude devem apresentar o valor 0.

### Atualizar `PUT` | `/Acolhido`

Enviar: 
```json
{
  "cpf": "111.111.111-11",
  "rg": "8.147.598",
  "nome": "Bruce Wayne",
  "tipoContato": "Whatssap",
  "contato": "(81)945875236",
  "dataNascimento": "12/05/1996",
  "coordenada": {
    "id": 13,
    "longitude": "5",
    "latitude": "5"
  }
}
```

Ou enviar: 
```json
{
  "cpf": "111.111.111-11",
  "rg": "8.147.598",
  "nome": "Bruce Wayne",
  "tipoContato": "Whatssap",
  "contato": "(81)945875236",
  "dataNascimento": "12/05/1996",
  "coordenada": null
}
```

### Ler `GET` | `Acolhido/{cpf}`

Retorno:
```json
{
  "cpf": "026.147.452-45",
  "rg": "8.147.598",
  "nome": "Bruce Wayne",
  "tipoContato": "Telegram",
  "contato": "(81)945875236",
  "dataNascimento": "12/05/1996",
  "coordenada": {
    "id": 7,
    "longitude": "22.17403",
    "latitude": "66.40338"
  }
}
```

ou retorno: 
```json
{
  "cpf": "111.111.111-11",
  "rg": "8.147.598",
  "nome": "Bruce Wayne",
  "tipoContato": "Telegram",
  "contato": "(81)945875236",
  "dataNascimento": "12/05/1996",
  "coordenada": null
}
```
### Deletar `DELETE` | `Acolhido/{cpf}`

### Ler Todos `GET` | `/Acolhidos`

Retorno:
```json
[
  {
    "cpf": "026.147.452-45",
    "rg": "8.147.598",
    "nome": "Bruce Wayne",
    "tipoContato": "Telegram",
    "contato": "(81)945875236",
    "dataNascimento": "12/05/1996",
    "coordenada": {
      "id": 7,
      "longitude": "22.17403",
      "latitude": "66.40338"
    }
  },
  {
    "cpf": "026.147.472-11",
    "rg": "8.147.598",
    "nome": "Bruce Wayne",
    "tipoContato": "Telegram",
    "contato": "(81)945875236",
    "dataNascimento": "12/05/1996",
    "coordenada": null
  },
  {
    "cpf": "026.147.472-45",
    "rg": "8.147.598",
    "nome": "Bruce Wayne",
    "tipoContato": "Telegram",
    "contato": "(81)945875236",
    "dataNascimento": "12/05/1996",
    "coordenada": {
      "id": 8,
      "longitude": "22.17403",
      "latitude": "66.40338"
    }
  }
]
```
