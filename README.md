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

## :white_check_mark: Instituicao

### Inserir `POST` | `/Instituicao`

Enviar: 
```json
{
  "cnpj":"34303323000176",
  "razaoSocial":"Elfos S/A",
  "horarioAbertura":"08:00",
  "horarioFechamento":"18:00",
  "coordenada":{
    "latitude":"0",
    "longitude":"0"
  },
  "endereco":{
    "logradouro":"Av. Anaquin Scaiuauquer",
    "numero":"302",
    "bairro":"Maranguape",
    "cidade":"Fromhell",
    "estado":"PE",
    "cep":"88.170-009"
  }
}
```
Observação: Para casos de Instituicao sem coordenadas, a Latitude e a Longitude devem apresentar o valor 0.

### Ler `GET` | `/Instituicao/{cnpj}`

Retorno: 
```json
{
  "cnpj":"34303323000176",
  "razaoSocial":"Magos e bruxas S/A",
  "horarioAbertura":"18:00",
  "horarioFechamento":"06:00",
  "coordenada":{
    "id":20,
    "longitude":"58.47853",
    "latitude":"98.75841"
  },
  "endereco":{
    "id":19,
    "logradouro":"Av. Imbiribeira",
    "numero":"22",
    "bairro":"Afogados",
    "cidade":"Calypso",
    "estado":"PE",
    "cep":"88.170-009"
  },
  "comentarios":[
    {
      "id":1,
      "texto":"Instituicao teste 3",
      "cnpjInstituicao":"34303323000176"
    },
    {
      "id":2,
      "texto":"Instituicao teste 8",
      "cnpjInstituicao":"34303323000176"
    },
    {
      "id":4,
      "texto":"Instituicao teste 58",
      "cnpjInstituicao":"34303323000176"
    }
  ],
  "descricoes":[
    {
      "id":1,
      "descricao":"Descrição com qualquer texto aqui!!",
      "instituicao":null,
      "servico":null
    },
    {
      "id":2,
      "descricao":"SERVICO DE APOIO",
      "instituicao":null,
      "servico":null
    },
    {
      "id":4,
      "descricao":"Descrição com qualquer texto aqui!!",
      "instituicao":null,
      "servico":null
    },
    {
      "id":5,
      "descricao":"Descrição com qualquer texto aqui!!",
      "instituicao":null,
      "servico":null
    }
  ]
}
```

### Atualizar `PUT` | `/Instituicao`

Enviar: 
```json
{
  "cnpj":"34303323000176",
  "razaoSocial":"Magos e bruxas S/A",
  "horarioAbertura":"18:00",
  "horarioFechamento":"06:00",
  "coordenada":{
    "id":20,
    "longitude":"58.47853",
    "latitude":"98.75841"
  },
  "endereco":{
    "id":19,
    "logradouro":"Av. Imbiribeira",
    "numero":"22",
    "bairro":"Afogados",
    "cidade":"Calypso",
    "estado":"PE",
    "cep":"88.170-009"
  }
}
```

### Ler Todos `GET` | `/Instituicoes`

Retorno:
```json
[
  {
    "cnpj":"34303323000176",
    "razaoSocial":"Elfos S/A",
    "horarioAbertura":"08:00",
    "horarioFechamento":"18:00",
    "coordenada":{
      "id":20,
      "longitude":"0",
      "latitude":"0"
    },
    "endereco":{
      "id":19,
      "logradouro":"Av. Anaquin Scaiuauquer",
      "numero":"302",
      "bairro":"Maranguape",
      "cidade":"Fromhell",
      "estado":"PE",
      "cep":"88.170-009"
    },
    "comentarios":[
      
    ],
    "descricoes":[
      
    ]
  },
  {
    "cnpj":"34303323000178",
    "razaoSocial":"Elfos S/A",
    "horarioAbertura":"08:00",
    "horarioFechamento":"18:00",
    "coordenada":{
      "id":23,
      "longitude":"0",
      "latitude":"0"
    },
    "endereco":{
      "id":22,
      "logradouro":"Av. Anaquin Scaiuauquer",
      "numero":"302",
      "bairro":"Maranguape",
      "cidade":"Fromhell",
      "estado":"PE",
      "cep":"88.170-009"
    },
    "comentarios":[
      
    ],
    "descricoes":[
      
    ]
  },
  {
    "cnpj":"57303323000176",
    "razaoSocial":"Elfos S/A",
    "horarioAbertura":"08:00",
    "horarioFechamento":"18:00",
    "coordenada":{
      "id":21,
      "longitude":"0",
      "latitude":"0"
    },
    "endereco":{
      "id":20,
      "logradouro":"Av. Anaquin Scaiuauquer",
      "numero":"302",
      "bairro":"Maranguape",
      "cidade":"Fromhell",
      "estado":"PE",
      "cep":"88.170-009"
    },
    "comentarios":[
      
    ],
    "descricoes":[
      
    ]
  }
]
```

### Deletar `DELETE` | `/Instituicao/{cnpj}`

## :white_check_mark: Alerta

### Inserir `POST` | `/Alerta/{cpf}/{cnpj}`

Enviar: 
```json
{
  "cnpj":"34303323000176",
  "razaoSocial":"Magos e bruxas S/A",
  "horarioAbertura":"18:00",
  "horarioFechamento":"06:00",
  "coordenada":{
    "id":20,
    "longitude":"58.47853",
    "latitude":"98.75841"
  },
  "endereco":{
    "id":19,
    "logradouro":"Av. Imbiribeira",
    "numero":"22",
    "bairro":"Afogados",
    "cidade":"Calypso",
    "estado":"PE",
    "cep":"88.170-009"
  },
  "comentarios":[
    {
      "id":1,
      "texto":"Instituicao teste 3",
      "cnpjInstituicao":"34303323000176"
    },
    {
      "id":2,
      "texto":"Instituicao teste 8",
      "cnpjInstituicao":"34303323000176"
    },
    {
      "id":4,
      "texto":"Instituicao teste 58",
      "cnpjInstituicao":"34303323000176"
    }
  ],
  "descricoes":[
    {
      "id":1,
      "descricao":"Descrição com qualquer texto aqui!!",
      "instituicao":null,
      "servico":null
    },
    {
      "id":2,
      "descricao":"SERVICO DE APOIO",
      "instituicao":null,
      "servico":null
    },
    {
      "id":4,
      "descricao":"Descrição com qualquer texto aqui!!",
      "instituicao":null,
      "servico":null
    },
    {
      "id":5,
      "descricao":"Descrição com qualquer texto aqui!!",
      "instituicao":null,
      "servico":null
    }
  ]
}
```

### Ler `GET` | `/Alerta/{id}`

Retorno:
```json
{
  "id":1,
  "status":"Novela",
  "acolhido":{
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
  "instituicao":{
    "cnpj":"34303323000178",
    "razaoSocial":"Elfos S/A",
    "horarioAbertura":"08:00",
    "horarioFechamento":"18:00",
    "coordenada":null,
    "endereco":{
      "id":22,
      "logradouro":"Av. Anaquin Scaiuauquer",
      "numero":"302",
      "bairro":"Maranguape",
      "cidade":"Fromhell",
      "estado":"PE",
      "cep":"88.170-009"
    },
    "comentarios":null,
    "descricoes":null
  }
}
```

### Atualizar `PUT` | `/Alerta`

Enviar: 
```json
{
  "id":"1",
  "status":"Novela"
}
```

### Ler Todos `GET` | `/Alertas`
Retorno:
```json
[
  {
    "id":1,
    "status":"Novela",
    "acolhido":{
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
    "instituicao":{
      "cnpj":"34303323000178",
      "razaoSocial":"Elfos S/A",
      "horarioAbertura":"08:00",
      "horarioFechamento":"18:00",
      "coordenada":null,
      "endereco":{
        "id":22,
        "logradouro":"Av. Anaquin Scaiuauquer",
        "numero":"302",
        "bairro":"Maranguape",
        "cidade":"Fromhell",
        "estado":"PE",
        "cep":"88.170-009"
      },
      "comentarios":null,
      "descricoes":null
    }
  },
  {
    "id":2,
    "status":"Tapera",
    "acolhido":{
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
    "instituicao":{
      "cnpj":"34303323000178",
      "razaoSocial":"Elfos S/A",
      "horarioAbertura":"08:00",
      "horarioFechamento":"18:00",
      "coordenada":null,
      "endereco":{
        "id":22,
        "logradouro":"Av. Anaquin Scaiuauquer",
        "numero":"302",
        "bairro":"Maranguape",
        "cidade":"Fromhell",
        "estado":"PE",
        "cep":"88.170-009"
      },
      "comentarios":null,
      "descricoes":null
    }
  }
]
```

### Deletar `DELETE` | `/Alerta/{id}`

## :white_check_mark: Comentarios e Descricao 

Para maiores detalhes, acesse os links abaixos:

[Comentarios](https://github.com/Gwolner/spring-restfull/blob/versao_2.0_Autenticacao_sistema/Comentarios.md). <br>
[Descricao](https://github.com/Gwolner/spring-restfull/blob/versao_2.0_Autenticacao_sistema/Descricao.md).

## :white_check_mark: MR do Banco 

Em verde, as entidades mais fortes do projeto.

[Modelo Relacional](https://github.com/Gwolner/spring-restfull/blob/versao_2.0_Autenticacao_sistema/bd/mr_tcc_controller.png).

## :white_check_mark: Autenticação de usuários 

Autenticação usada para Acolhido e Instituicao.

[Acolhido](https://github.com/Gwolner/spring-restfull/blob/versao_2.0_Autenticacao_sistema/Comentarios.md). <br>
[Instituicao](https://github.com/Gwolner/spring-restfull/blob/versao_2.0_Autenticacao_sistema/Descricao.md).
