# Consumo da API Spring Restful

## :white_check_mark: Servico

### Inserir `POST` | `/Servico`

Enviar: 
```json
{
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

### Atualizar `PUT` | `/Servico`

Enviar: 
```json
{
 "id":"1",
 "designacao":"Abrigo"
}
```

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

### Deletar `DELETE` | `/Servico/{id}`

## :white_check_mark: Acolhido

### Inserir `POST` | `/Acolhido`

Enviar: 
```json
{
  "cpf":"111.111.111-11",
  "rg":"8.147.598",
  "nome":"Bruce Wayne",
  "tipoContato":"Telegram",
  "contato":"(81)945875236",
  "dataNascimento":"12/05/1996",
  "coordenada":{
    "latitude":"66.40338",
    "longitude":"22.17403"
  }
}
```
**Observação:** Para casos de Acolhido sem coordenadas, a Latitude e a Longitude devem apresentar o valor 0.

### Ler `GET` | `Acolhido/{cpf}`

Retorno:
```json
{
  "cpf":"111.111.111-11",
  "rg":"8.147.598",
  "nome":"Bruce Wayne",
  "tipoContato":"Telegram",
  "contato":"(81)945875236",
  "dataNascimento":"12/05/1996",
  "coordenada":{
    "id":11,
    "longitude":"22.17403",
    "latitude":"66.40338"
  }
}
```

### Atualizar `PUT` | `/Acolhido`

Enviar: 
```json
{
  "cpf":"111.111.111-11",
  "rg":"8.147.595",
  "nome":"Bruce Wayne",
  "tipoContato":"Telegram",
  "contato":"(81)945875236",
  "dataNascimento":"12/05/1996",
  "coordenada":{
    "id":11,
    "longitude":"11.17403",
    "latitude":"66.40338"
  }
}
```
**Observação 1:** O CPF é enviado por ser uma PK. Não é permitido a alteração do CPF no banco de dados. <br/>
**Observação 2:** Para casos de Acolhido sem coordenadas, a Latitude e a Longitude devem apresentar o valor 0.

### Ler Todos `GET` | `/Acolhidos`

Retorno:
```json
[
  {
    "cpf":"111.111.111-11",
    "rg":"8.147.595",
    "nome":"Bruce Wayne",
    "tipoContato":"Telegram",
    "contato":"(87)945875236",
    "dataNascimento":"12/05/1996",
    "coordenada":{
      "id":11,
      "longitude":"53.1262",
      "latitude":"17.1256"
    }
  },
  {
    "cpf":"333.111.111-11",
    "rg":"8.147.598",
    "nome":"Bruce Wayne",
    "tipoContato":"Telegram",
    "contato":"(81)945875236",
    "dataNascimento":"12/05/1996",
    "coordenada":{
      "id":12,
      "longitude":"22.17403",
      "latitude":"66.40338"
    }
  },
  {
    "cpf":"555.111.111-11",
    "rg":"8.147.598",
    "nome":"Uélintoum Nunes",
    "tipoContato":"Telegram",
    "contato":"(81)945875236",
    "dataNascimento":"12/05/1996",
    "coordenada":{
      "id":13,
      "longitude":"0",
      "latitude":"0"
    }
  }
]
```

### Deletar `DELETE` | `Acolhido/{cpf}`

## :white_check_mark: Local

### Inserir `POST` | `/Local`

Enviar: 
```json
{
  "nome":"La cachepa",
  "link":"www.algumacoisa.com",
  "descricao":"Lugar feliz",
  "coordenada":{
    "latitude":"0",
    "longitude":"0"
  },
  "endereco":{
    "logradouro":"Rua Wonder Woman",
    "numero":"34",
    "bairro":"Suape",
    "cidade":"Temícera",
    "estado":"PE",
    "cep":"88.170-009"
  }
}
```
**Observação:** Para casos de Local sem coordenadas, a Latitude e a Longitude devem apresentar o valor 0.

### Ler `GET` | `Local/{id}`

Retorno:
```json
{
  "id":12,
  "nome":"Bar do Dengo",
  "link":"www.bardodengo.com",
  "descricao":"Lugar alegre",
  "coordenada":{
    "id":15,
    "longitude":"82.59403",
    "latitude":"41.15371"
  },
  "endereco":{
    "id":11,
    "logradouro":"Rua Wonder Woman",
    "numero":"34",
    "bairro":"Suape",
    "cidade":"Temícera",
    "estado":"PE",
    "cep":"88.170-009"
  },
  "comentarios":[
    
  ]
}
```

### Atualizar `PUT` | `/Local`

Enviar: 
```json
{
  "id":13,
  "nome":"Monopoly do amor",
  "link":"www.monopolydoamor.com.br",
  "descricao":"Lugar animado",
  "coordenada":{
    "id":16,
    "longitude":"011",
    "latitude":"032"
  },
  "endereco":{
    "id":12,
    "logradouro":"Rua Megalco Oliveira",
    "numero":"444",
    "bairro":"Suape",
    "cidade":"Temícera",
    "estado":"PE",
    "cep":"88.170-009"
  }
}
```

### Ler Todos `GET` | `/Locais`

Retorno:
```json
[
  {
    "id":12,
    "nome":"Bar do Dengo",
    "link":"www.bardodengo.com",
    "descricao":"Lugar alegre",
    "coordenada":{
      "id":15,
      "longitude":"82.59403",
      "latitude":"41.15371"
    },
    "endereco":{
      "id":11,
      "logradouro":"Rua Wonder Woman",
      "numero":"34",
      "bairro":"Suape",
      "cidade":"Temícera",
      "estado":"PE",
      "cep":"88.170-009"
    },
    "comentarios":[
      
    ]
  },
  {
    "id":13,
    "nome":"Monopoly do amor",
    "link":"www.monopoly.com",
    "descricao":"Lugar animado",
    "coordenada":{
      "id":16,
      "longitude":"0",
      "latitude":"0"
    },
    "endereco":{
      "id":12,
      "logradouro":"Rua Wonder Woman",
      "numero":"34",
      "bairro":"Suape",
      "cidade":"Temícera",
      "estado":"PE",
      "cep":"88.170-009"
    },
    "comentarios":[
      
    ]
  }
]
```

### Deletar `DELETE` | `Locais/{id}`
